package com.tencent.mobileqq.phonecontact.api.impl;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.StaleDataException;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchGetContactServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.persistence.transaction.FindTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.api.impl.b;
import com.tencent.mobileqq.phonecontact.data.ContactBinded;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.data.LastLoginPhoneInfo;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.phonecontact.data.PhoneNumInfo;
import com.tencent.mobileqq.phonecontact.handler.ContactBindHandler;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.remote.ServiceConst;
import friendlist.GetOnlineInfoResp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class PhoneContactServiceImpl implements IPhoneContactService {
    static IPatchRedirector $redirector_ = null;
    private static final int CMD_PHONE_UNITY_BANNER_CONFIG = 34;
    private static final boolean DEBUG_DETAIL_LOG = true;
    private static final boolean DEBUG_UPDATE_LAST_LOGIN = false;
    private static final String DEVICE_INFO_BUSIID = "73f9b3";
    private static final String FRD_HAS_BIND_PHONE_COUNT_TAG = "frd_has_bind_phone_count_";
    private static final String FRD_HAS_BIND_PHONE_SOME_TAG = "frd_has_bind_phone_some_";
    private static final String KEY_ALL_ENTRANCE_NUM = "all_entrance_num";
    private static final String KEY_BIND_STYLE = "key_bind_style";
    private static final String KEY_BIND_WORDING = "key_bind_wording";
    private static final String KEY_BLOCK_MSG = "key_block_msg";
    private static final String KEY_CONFIG_VERSION = "key_config_version";
    public static final String KEY_CONTACTS_SWITCHES = "key_contacts_switches";
    private static final String KEY_LAST_REQ_LOGIN_TIME = "key_req_last_login_time";
    private static final String KEY_LAST_UNBIND_MOBILE_TIME = "last_unbind_mobile_time";
    private static final String KEY_LOGIN_INFO_TIME_STAMP = "key_login_info_timestamp";
    private static final String KEY_REQUEST_LOGIN_INTERVAL = "key_req_login_interval";
    private static final long MIN_GAP_AFTER_LAST_UNBIND_MOBILE = 3600000;
    private static final long MIN_POPUP_MATCH_INTERVAL_FOR_SWITCHPHONE = 86400000;
    private static final long MIN_RETRY_INTERVAL = 120000;
    private static final String[] PHONES_PROJECTION;
    public static int RESULT_FAIL = 0;
    public static int RESULT_OK = 0;
    public static final String SP_NEW_FRIEND = "sp_new_friend";
    private static final String TAG = "IMCore.PhoneContact.PhoneContactServiceImpl";
    private static final String USER_SETTING_FLAG = "user_setting_flag_";
    public static int sAllEntranceNum;
    private static volatile long sQueryContactListInterval;
    private static volatile long sQueryContactListIntervalLogin;
    private String UNIQUE_NO;
    private AppInterface app;
    public volatile List<PhoneContact> bindAllFriendList;
    private volatile List<PhoneContact> bindNonFriendList;
    public com.tencent.mobileqq.phonecontact.data.a contactBindedDataCache;
    private ConcurrentHashMap<String, PhoneContact> contactCache;
    private ConcurrentHashMap<String, PhoneContact> contactCacheByCodeNumber;
    private ConcurrentHashMap<String, PhoneContact> contactCacheByUin;
    boolean contactChanged;
    private volatile long contactListQueryTimeStamp;
    private com.tencent.mobileqq.phonecontact.observer.b contactOb;
    private m contactObserver;
    private volatile boolean destroyed;

    /* renamed from: em, reason: collision with root package name */
    private EntityManager f258386em;
    private boolean isAppBlocking;
    private volatile boolean isCacheInited;
    private volatile boolean isLastLoginRequesting;
    private boolean isPhoneSwitched;
    private volatile boolean isQueryingContact;
    private volatile boolean isUpdatingContact;
    private volatile long lastUpdateFailTimeStamp;
    private volatile long lastUploadFailTimeStamp;
    private Runnable mClearRecommendBadgeTask;
    private ContactBindHandler mContactBindHandler;
    private com.tencent.mobileqq.phonecontact.observer.a mContactBindObserver2;
    private ContactBinded mContactBinded;
    private ArrayList<ContactMatch> mContactMatch;
    private volatile int mCurrentBindState;
    private JSONObject mDataForNewGuide;
    private int mFrdHasBindPhoneTotalCount;
    private boolean mFromNotBind;
    private com.tencent.mobileqq.phonecontact.processor.a mInjectProcessor;
    private volatile boolean mIsFirstQueryBindState;
    private boolean mIsUploadForNewGuide;
    private volatile Set<String> mLastLoginSet;
    private long mLastUnbindMobileTime;
    private List<PhoneContact> mListForContactListView;
    private List<PhoneContact> mListForPhoneSelector;
    private List<PhoneContact> mListForSelector;
    private LinkedList<od2.a> mListenerList;
    private l mLoadContactFriendTask;
    private ArrayList<PhoneContactAdd> mPhoneContactAddList;
    private Random mRandom;
    private final Object mRecommendLock;
    private List<String> mSomeFrdHasBindPhone;
    private int mStarRecommendCount;
    public long mUIBits;
    public volatile int mUploadPackages;
    private UploadProgressGenerator mUploadProgressGenerator;
    private volatile long mUserSettingFlag;
    private ConcurrentHashMap<String, PhoneContact> md52PhoneContact;
    public boolean needUploadResultTip;
    private List<PhoneContact> orderedBindList;
    private List<PhoneContact> orderedNobindList;
    private ConcurrentHashMap<String, String> phoneNumToUinMap;
    private SharedPreferences pref;
    List<PhoneContact> recommendMobiles;
    private List<NotBindContactFriendInfo> respBindFriendListNotBind;
    private List<MobileContactsFriendInfo> respBindFriendList_V2;
    private List<NotBindContactNotFriendInfo> respBindStrangerListNotBind;
    private List<MobileContactsNotFriendInfo> respBindStrangerList_V2;
    private byte[] sessionId;
    private ConcurrentHashMap<String, PhoneContact> tmpContactCache;
    private ConcurrentHashMap<String, String> uinToPhoneNumMap;

    /* renamed from: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        AnonymousClass2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        void a() {
            boolean z16;
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            int selfBindState = PhoneContactServiceImpl.this.getSelfBindState();
            boolean poppedForThisVersionNotBind = PhoneContactServiceImpl.this.poppedForThisVersionNotBind();
            long j3 = PhoneContactServiceImpl.this.pref.getLong(AppConstants.Preferences.LAST_POPUP_MATCH_TIME_FOR_SWITCHPHONE, 0L);
            if (PhoneContactServiceImpl.this.isPhoneSwitched && System.currentTimeMillis() - j3 > 86400000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "onFirstRespQueryNotBindState bindState = " + selfBindState + ", needToJumpBind = " + poppedForThisVersionNotBind + ", phoneSwitchBefit = " + z16 + j3);
            }
            if ((poppedForThisVersionNotBind || z16) && PhoneContactServiceImpl.this.mInjectProcessor.g(false)) {
                PhoneContactServiceImpl.this.queryShowBindPhonePage(true);
            }
        }

        void b() {
            boolean z16;
            if (com.tencent.mobileqq.phonecontact.constant.b.f258441a) {
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                QLog.e(PhoneContactServiceImpl.TAG, 1, "onFirstRespQueryState app is null");
                return;
            }
            int selfBindState = PhoneContactServiceImpl.this.getSelfBindState();
            boolean poppedForThisVersion = PhoneContactServiceImpl.this.poppedForThisVersion();
            long j3 = PhoneContactServiceImpl.this.pref.getLong(AppConstants.Preferences.LAST_POPUP_MATCH_TIME_FOR_SWITCHPHONE, 0L);
            if (PhoneContactServiceImpl.this.isPhoneSwitched && System.currentTimeMillis() - j3 > 86400000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "bindState = " + selfBindState + ", isFristRun = " + poppedForThisVersion + ", attempPop = " + z16 + j3);
            }
            if ((poppedForThisVersion || z16) && PhoneContactServiceImpl.this.mInjectProcessor.g(true)) {
                PhoneContactServiceImpl.this.queryShowBindPhonePage(false);
            }
        }

        void c() {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.2.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        com.tencent.mobileqq.phonecontact.nt.b.f258483a.g(AppConstants.Preferences.CONTACT_LAST_QUERY_TIME, PhoneContactServiceImpl.this.contactListQueryTimeStamp);
                        if (QLog.isColorLevel()) {
                            QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("save last query time: %s", Long.valueOf(PhoneContactServiceImpl.this.contactListQueryTimeStamp)));
                        }
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }, 16, null, false);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.phonecontact.observer.b
        public void onCancelBind(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, z16);
                return;
            }
            if (!PhoneContactServiceImpl.this.destroyed && z16) {
                PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 11L);
                PhoneContactServiceImpl.this.mCurrentBindState = 1;
                PhoneContactServiceImpl.this.notifyBindStateChanged();
                PhoneContactServiceImpl.this.mInjectProcessor.c();
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onHideContact(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, z16);
            } else if (!PhoneContactServiceImpl.this.destroyed && z16) {
                PhoneContactServiceImpl.this.notifyContactChanged(2);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryBindState(boolean z16, boolean z17, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (z16 && z17) {
                PhoneContactServiceImpl.this.mInjectProcessor.h();
            }
            PhoneContactServiceImpl.this.isQueryingContact = false;
            PhoneContactServiceImpl.this.contactListQueryTimeStamp = System.currentTimeMillis();
            QLog.d(PhoneContactServiceImpl.TAG, 1, String.format("onQueryBindState [%s, %s, %s, %s, %s]", Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(PhoneContactServiceImpl.this.mIsFirstQueryBindState), Long.valueOf(j3), Integer.valueOf(PhoneContactServiceImpl.this.getSelfBindState())));
            PhoneContactServiceImpl.this.showToast(6, z16);
            if ((j3 == 14 || j3 == 17 || j3 == 13) && com.tencent.mobileqq.phonecontact.util.e.a()) {
                z16 = false;
            }
            if (z16) {
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                phoneContactServiceImpl.checkUpdateLocalContact(phoneContactServiceImpl.mIsFirstQueryBindState, 1);
                if (PhoneContactServiceImpl.this.mIsFirstQueryBindState) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (!PhoneContactServiceImpl.this.destroyed) {
                                PhoneContactServiceImpl.this.mIsFirstQueryBindState = false;
                                if (PhoneContactServiceImpl.this.getSelfBindState() <= 5) {
                                    try {
                                        AnonymousClass2.this.a();
                                        return;
                                    } catch (Exception e16) {
                                        QLog.e(PhoneContactServiceImpl.TAG, 1, "onFirstRespQueryNotBindState fail!", e16);
                                        return;
                                    }
                                }
                                try {
                                    AnonymousClass2.this.b();
                                } catch (Exception e17) {
                                    QLog.e(PhoneContactServiceImpl.TAG, 1, "onFirstRespQueryState fail!", e17);
                                }
                            }
                        }
                    }, 16, null, false);
                }
            }
            c();
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryContactList(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "onQueryContactList, isSuc = " + z16 + ", updateFlag = " + i3);
            }
            if (z16) {
                PhoneContactServiceImpl.this.notifyContactChanged(i3);
            }
            PhoneContactServiceImpl.this.checkUpdateLastLoginList();
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onQueryLastLoginInfo(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, z16);
            } else if (!PhoneContactServiceImpl.this.destroyed) {
                PhoneContactServiceImpl.this.isLastLoginRequesting = false;
                if (z16) {
                    PhoneContactServiceImpl.this.notifyContactChanged(2);
                }
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUpdateContact(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "onUpdateContact, isSuc = " + z16 + ", reason = " + i3);
            }
            PhoneContactServiceImpl.this.isUpdatingContact = false;
            if (z16) {
                PhoneContactServiceImpl.this.notifyContactChanged(1);
                PhoneContactServiceImpl.this.saveContactListTimeStamp(0L, 0L);
            } else {
                if (i3 == 2 || i3 == 3) {
                    PhoneContactServiceImpl.this.contactChanged = true;
                }
                PhoneContactServiceImpl.this.lastUpdateFailTimeStamp = System.currentTimeMillis();
            }
            PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 9L);
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUpdateContactNotBind(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "onUpdateContactNotBind, isSuc = " + z16 + ", reason = " + i3);
            }
            PhoneContactServiceImpl.this.isUpdatingContact = false;
            if (z16) {
                PhoneContactServiceImpl.this.notifyContactChanged(1);
                PhoneContactServiceImpl.this.saveContactListTimeStampNotBind(0L);
            } else {
                PhoneContactServiceImpl.this.lastUpdateFailTimeStamp = System.currentTimeMillis();
                if (i3 != 2 && i3 != 3) {
                    if (i3 == 5 || i3 == 4) {
                        if (PhoneContactServiceImpl.this.mCurrentBindState != 8) {
                            PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 8L);
                            return;
                        }
                        return;
                    }
                } else {
                    PhoneContactServiceImpl.this.contactChanged = true;
                }
            }
            PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 8L);
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUploadContact(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 4;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "onUploadContact, isSuc = " + z16 + ", reason = " + i3 + ", currentState=" + PhoneContactServiceImpl.this.mCurrentBindState);
            }
            if (PhoneContactServiceImpl.this.mIsUploadForNewGuide) {
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                if (z16) {
                    i16 = 3;
                }
                phoneContactServiceImpl.saveUploadDataForNewGuide(i16, phoneContactServiceImpl.contactCache.size(), 100, 100);
            }
            if (PhoneContactServiceImpl.this.mUploadProgressGenerator != null) {
                PhoneContactServiceImpl.this.mUploadProgressGenerator.cancel();
                PhoneContactServiceImpl.this.mUploadProgressGenerator = null;
            }
            if (z16) {
                PhoneContactServiceImpl.this.mCurrentBindState = 9;
                PhoneContactServiceImpl.this.saveContactListTimeStamp(0L, 0L);
                PhoneContactServiceImpl.this.notifyContactChanged(15);
            } else {
                PhoneContactServiceImpl.this.lastUploadFailTimeStamp = System.currentTimeMillis();
                if (i3 == 2) {
                    PhoneContactServiceImpl.this.mCurrentBindState = 7;
                } else if (i3 == 3) {
                    PhoneContactServiceImpl.this.mCurrentBindState = 9;
                    PhoneContactServiceImpl.this.contactChanged = true;
                } else if (i3 == 1) {
                    PhoneContactServiceImpl.this.mCurrentBindState = 1;
                    PhoneContactServiceImpl.this.lastUploadFailTimeStamp = 0L;
                }
            }
            PhoneContactServiceImpl.this.notifyBindStateChanged();
            PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 7L);
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUploadContactNotBind(boolean z16, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            QLog.d(PhoneContactServiceImpl.TAG, 1, "onUploadContactNotBind, isSuc = " + z16 + ", reason = " + i3 + ", currentState=" + PhoneContactServiceImpl.this.mCurrentBindState);
            if (PhoneContactServiceImpl.this.mUploadProgressGenerator != null) {
                PhoneContactServiceImpl.this.mUploadProgressGenerator.cancel();
                PhoneContactServiceImpl.this.mUploadProgressGenerator = null;
            }
            if (PhoneContactServiceImpl.this.mIsUploadForNewGuide) {
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                if (z16) {
                    i16 = 3;
                } else {
                    i16 = 4;
                }
                phoneContactServiceImpl.saveUploadDataForNewGuide(i16, phoneContactServiceImpl.contactCache.size(), 100, 100);
            }
            if (z16) {
                PhoneContactServiceImpl.this.mCurrentBindState = 2;
                PhoneContactServiceImpl.this.saveContactListTimeStamp(0L, 0L);
                PhoneContactServiceImpl.this.notifyContactChanged(15);
            } else {
                PhoneContactServiceImpl.this.lastUploadFailTimeStamp = System.currentTimeMillis();
                if (i3 == 2 || i3 == 3) {
                    PhoneContactServiceImpl.this.mCurrentBindState = 0;
                    PhoneContactServiceImpl.this.contactChanged = true;
                } else {
                    if (i3 == 5) {
                        PhoneContactServiceImpl.this.mCurrentBindState = 1;
                        PhoneContactServiceImpl.this.lastUploadFailTimeStamp = 0L;
                        PhoneContactServiceImpl.this.notifyBindStateChanged();
                        PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 6L);
                        return;
                    }
                    if (i3 == 4) {
                        PhoneContactServiceImpl.this.mCurrentBindState = 9;
                        PhoneContactServiceImpl phoneContactServiceImpl2 = PhoneContactServiceImpl.this;
                        phoneContactServiceImpl2.contactChanged = true;
                        phoneContactServiceImpl2.notifyBindStateChanged();
                        PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 6L);
                        return;
                    }
                    PhoneContactServiceImpl.this.mCurrentBindState = 0;
                    PhoneContactServiceImpl.this.notifyBindStateChanged();
                    PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 6L);
                    return;
                }
            }
            PhoneContactServiceImpl.this.notifyBindStateChanged();
            PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 6L);
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onUploadProgressUpdated(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (PhoneContactServiceImpl.this.destroyed) {
                return;
            }
            if (PhoneContactServiceImpl.this.mUploadProgressGenerator == null) {
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                phoneContactServiceImpl.mUploadProgressGenerator = new UploadProgressGenerator(phoneContactServiceImpl, null);
            }
            PhoneContactServiceImpl.this.mUploadProgressGenerator.a(i3, i16);
            if (PhoneContactServiceImpl.this.mIsUploadForNewGuide) {
                PhoneContactServiceImpl phoneContactServiceImpl2 = PhoneContactServiceImpl.this;
                phoneContactServiceImpl2.saveUploadDataForNewGuide(2, phoneContactServiceImpl2.contactCache.size(), i3, i16);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onVerifyBindSms(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            } else if (!PhoneContactServiceImpl.this.destroyed && z16 && i3 == 0) {
                PhoneContactServiceImpl.this.checkUpdateBindStateAndList(true, true, 10L);
            }
        }
    }

    /* loaded from: classes16.dex */
    class a implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            return phoneContact.contactID - phoneContact2.contactID;
        }
    }

    /* loaded from: classes16.dex */
    class b implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            String str = phoneContact.pinyinFirst;
            String str2 = phoneContact2.pinyinFirst;
            if (str.endsWith("#")) {
                str = "Za";
            }
            if (str2.endsWith("#")) {
                str2 = "Za";
            }
            int compareTo = str.compareTo(str2);
            if (compareTo == 0) {
                return phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
            }
            return compareTo;
        }
    }

    /* loaded from: classes16.dex */
    class c implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f258411a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f258412b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean[] f258413c;

        c(String[] strArr, String str, boolean[] zArr) {
            this.f258411a = strArr;
            this.f258412b = str;
            this.f258413c = zArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneContactServiceImpl.this, strArr, str, zArr);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            while (cursor.moveToNext()) {
                int columnIndex = cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA1);
                if (columnIndex >= 0) {
                    String a16 = com.tencent.mobileqq.phonecontact.util.d.a(cursor.getString(columnIndex));
                    this.f258411a[0] = com.tencent.mobileqq.phonecontact.util.d.a(this.f258412b);
                    if (!TextUtils.equals(a16, this.f258411a[0])) {
                        if (TextUtils.equals("+86" + a16, this.f258411a[0])) {
                        }
                    }
                    this.f258413c[0] = true;
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class d implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            String str = phoneContact.pinyinFirst;
            String str2 = phoneContact2.pinyinFirst;
            if (str.endsWith("#")) {
                str = "Za";
            }
            if (str2.endsWith("#")) {
                str2 = "Za";
            }
            int compareTo = str.compareTo(str2);
            if (compareTo == 0) {
                compareTo = phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
            }
            if (compareTo == 0) {
                return phoneContact.contactID - phoneContact2.contactID;
            }
            return compareTo;
        }
    }

    /* loaded from: classes16.dex */
    class e implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            String str = phoneContact.pinyinFirst;
            String str2 = phoneContact2.pinyinFirst;
            if (str.endsWith("#")) {
                str = "Za";
            }
            if (str2.endsWith("#")) {
                str2 = "Za";
            }
            int compareTo = str.compareTo(str2);
            if (compareTo == 0) {
                compareTo = phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
            }
            if (compareTo == 0) {
                return phoneContact.contactID - phoneContact2.contactID;
            }
            return compareTo;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class f implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            return phoneContact.contactID - phoneContact2.contactID;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class g implements Comparator<PhoneContact> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
            boolean z16;
            boolean z17;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
            }
            String str = phoneContact.pinyinFirst;
            String str2 = phoneContact2.pinyinFirst;
            if (str.endsWith("#")) {
                str = "Za";
            }
            if (str2.endsWith("#")) {
                str2 = "Za";
            }
            int compareTo = str.compareTo(str2);
            if (compareTo == 0) {
                boolean z18 = !TextUtils.isEmpty(phoneContact.uin);
                if (z18 && !phoneContact.uin.equals("0")) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z19 = !TextUtils.isEmpty(phoneContact2.uin);
                if (z19 && !phoneContact2.uin.equals("0")) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z16) {
                    i3 = 0;
                } else if (z18) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                if (z17) {
                    i16 = 0;
                } else if (z19) {
                    i16 = 1;
                }
                compareTo = i3 - i16;
            }
            if (compareTo == 0) {
                return phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
            }
            return compareTo;
        }
    }

    /* loaded from: classes16.dex */
    class h extends com.tencent.mobileqq.phonecontact.observer.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.a
        protected void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("onQueryShowBindPhonePage result=%s", Boolean.valueOf(z16)));
            }
            if (z16) {
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                PhoneContactServiceImpl.this.setShowBindPhonePageResult(phoneContactServiceImpl.showBindPhonePage(phoneContactServiceImpl.mFromNotBind));
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.a
        protected void c(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("onSetShowBindPhonePageResult result=%s", Boolean.valueOf(z16)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class i implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f258420a;

        i(ArrayList arrayList) {
            this.f258420a = arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this, (Object) arrayList);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        @SuppressLint({"Range"})
        public void a(Cursor cursor) throws StaleDataException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            if (cursor != null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    int count = cursor.getCount();
                    this.f258420a.ensureCapacity(count);
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(count);
                    ArrayList arrayList = new ArrayList();
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        String a16 = com.tencent.mobileqq.phonecontact.util.d.a(cursor.getString(cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA1)));
                        String string = cursor.getString(cursor.getColumnIndex("display_name"));
                        if (TextUtils.isEmpty(string)) {
                            string = a16;
                        }
                        int i3 = cursor.getInt(cursor.getColumnIndex("contact_id"));
                        int i16 = cursor.getInt(cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA2));
                        String string2 = cursor.getString(cursor.getColumnIndex("data3"));
                        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(string)) {
                            PhoneContact phoneContact = new PhoneContact();
                            phoneContact.mobileNo = a16;
                            phoneContact.name = string;
                            phoneContact.contactID = i3;
                            phoneContact.type = i16;
                            phoneContact.label = string2;
                            phoneContact.lastScanTime = currentTimeMillis;
                            phoneContact.pinyinAll = ChnToSpell.d(string, 1);
                            String d16 = ChnToSpell.d(string, 2);
                            phoneContact.pinyinInitial = d16;
                            phoneContact.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(d16);
                            phoneContact.md5 = com.tencent.mobileqq.phonecontact.util.d.b(string, a16);
                            concurrentHashMap.put(a16, phoneContact);
                            PhoneContactServiceImpl.this.md52PhoneContact.put(phoneContact.md5, phoneContact);
                            arrayList.add(new PersistOrReplaceTransaction(phoneContact));
                        }
                        cursor.moveToNext();
                    }
                    PhoneContactServiceImpl.this.f258386em.doMultiDBOperateByTransaction(arrayList);
                    PhoneContactServiceImpl.this.afterLoadLocalContact(concurrentHashMap);
                    for (PhoneContact phoneContact2 : PhoneContactServiceImpl.this.contactCache.values()) {
                        this.f258420a.add(new AddressBookItem(phoneContact2.mobileNo, phoneContact2.name));
                    }
                } catch (StaleDataException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PhoneContactServiceImpl.TAG, 2, "", e16);
                    }
                    throw e16;
                }
            }
        }
    }

    /* loaded from: classes16.dex */
    class j implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f258422a;

        j(Map map) {
            this.f258422a = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this, (Object) map);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            String str;
            String str2;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int count = cursor.getCount();
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "load contacts from system db, size=" + count);
            }
            try {
                cursor.moveToFirst();
                while (true) {
                    int i16 = 0;
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    int columnIndex = cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA1);
                    int columnIndex2 = cursor.getColumnIndex("display_name");
                    int columnIndex3 = cursor.getColumnIndex("contact_id");
                    int columnIndex4 = cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA2);
                    int columnIndex5 = cursor.getColumnIndex("data3");
                    String str3 = "";
                    if (columnIndex < 0) {
                        str = "";
                    } else {
                        str = cursor.getString(columnIndex);
                    }
                    String a16 = com.tencent.mobileqq.phonecontact.util.d.a(str);
                    if (columnIndex2 < 0) {
                        str2 = "";
                    } else {
                        str2 = cursor.getString(columnIndex2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = a16;
                    }
                    if (columnIndex3 >= 0) {
                        i3 = cursor.getInt(columnIndex3);
                    } else {
                        i3 = 0;
                    }
                    if (columnIndex4 >= 0) {
                        i16 = cursor.getInt(columnIndex4);
                    }
                    if (columnIndex5 >= 0) {
                        str3 = cursor.getString(columnIndex5);
                    }
                    if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(str2)) {
                        PhoneContact phoneContact = new PhoneContact();
                        phoneContact.mobileNo = a16;
                        phoneContact.name = str2;
                        phoneContact.contactID = i3;
                        phoneContact.type = i16;
                        phoneContact.label = str3;
                        phoneContact.lastScanTime = currentTimeMillis;
                        phoneContact.pinyinAll = ChnToSpell.d(str2, 1);
                        String d16 = ChnToSpell.d(str2, 2);
                        phoneContact.pinyinInitial = d16;
                        phoneContact.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(d16);
                        phoneContact.md5 = com.tencent.mobileqq.phonecontact.util.d.b(str2, a16);
                        this.f258422a.put(a16, phoneContact);
                    }
                    cursor.moveToNext();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(PhoneContactServiceImpl.TAG, 2, "load phone contact from system db cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (StaleDataException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(PhoneContactServiceImpl.TAG, 2, "cursor query exception=", e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class k implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f258424a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f258425b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f258426c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ HashMap f258427d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f258428e;

        k(long j3, ArrayList arrayList, ArrayList arrayList2, HashMap hashMap, ArrayList arrayList3) {
            this.f258424a = j3;
            this.f258425b = arrayList;
            this.f258426c = arrayList2;
            this.f258427d = hashMap;
            this.f258428e = arrayList3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PhoneContactServiceImpl.this, Long.valueOf(j3), arrayList, arrayList2, hashMap, arrayList3);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.api.impl.b.a
        public void a(Cursor cursor) throws StaleDataException {
            String str;
            String str2;
            int i3;
            int i16;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cursor);
                return;
            }
            try {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    int columnIndex = cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA1);
                    int columnIndex2 = cursor.getColumnIndex("display_name");
                    int columnIndex3 = cursor.getColumnIndex("contact_id");
                    int columnIndex4 = cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA2);
                    int columnIndex5 = cursor.getColumnIndex("data3");
                    if (columnIndex < 0) {
                        str = "";
                    } else {
                        str = cursor.getString(columnIndex);
                    }
                    String a16 = com.tencent.mobileqq.phonecontact.util.d.a(str);
                    if (columnIndex2 < 0) {
                        str2 = "";
                    } else {
                        str2 = cursor.getString(columnIndex2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = a16;
                    }
                    if (columnIndex3 >= 0) {
                        i3 = cursor.getInt(columnIndex3);
                    } else {
                        i3 = 0;
                    }
                    if (columnIndex4 >= 0) {
                        i16 = cursor.getInt(columnIndex4);
                    } else {
                        i16 = 0;
                    }
                    if (columnIndex5 < 0) {
                        str3 = "";
                    } else {
                        str3 = cursor.getString(columnIndex5);
                    }
                    if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(str2)) {
                        PhoneContact phoneContact = (PhoneContact) PhoneContactServiceImpl.this.contactCache.get(a16);
                        if (phoneContact == null) {
                            PhoneContact phoneContact2 = new PhoneContact();
                            phoneContact2.mobileNo = a16;
                            phoneContact2.name = str2;
                            phoneContact2.contactID = i3;
                            phoneContact2.type = i16;
                            phoneContact2.label = str3;
                            phoneContact2.lastScanTime = this.f258424a;
                            phoneContact2.pinyinAll = ChnToSpell.d(str2, 1);
                            String d16 = ChnToSpell.d(str2, 2);
                            phoneContact2.pinyinInitial = d16;
                            phoneContact2.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(d16);
                            PhoneContactServiceImpl.this.contactCache.put(a16, phoneContact2);
                            phoneContact2.md5 = com.tencent.mobileqq.phonecontact.util.d.b(str2, a16);
                            PhoneContactServiceImpl.this.md52PhoneContact.put(phoneContact2.md5, phoneContact2);
                            this.f258425b.add(phoneContact2);
                            this.f258426c.add(new AddressBookItem(a16, str2));
                        } else {
                            phoneContact.contactID = i3;
                            phoneContact.lastScanTime = this.f258424a;
                            if (TextUtils.isEmpty(phoneContact.md5)) {
                                phoneContact.md5 = com.tencent.mobileqq.phonecontact.util.d.b(phoneContact.name, a16);
                                PhoneContactServiceImpl.this.md52PhoneContact.put(phoneContact.md5, phoneContact);
                            }
                            if (phoneContact.isUploaded) {
                                if (!str2.equals(phoneContact.name)) {
                                    this.f258427d.put(a16, str2);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("rename, [old:%s, new:%s, phone:%s]", com.tencent.util.k.d(phoneContact.name), com.tencent.util.k.d(str2), com.tencent.util.k.d(a16)));
                                    }
                                } else {
                                    if (QLog.isColorLevel() && this.f258427d.containsKey(a16)) {
                                        QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("remove from rename, [name:%s, phone:%s]", com.tencent.util.k.d(str2), com.tencent.util.k.d(a16)));
                                    }
                                    this.f258427d.remove(a16);
                                }
                            } else {
                                this.f258426c.add(new AddressBookItem(a16, str2));
                                this.f258425b.add(phoneContact);
                            }
                        }
                    }
                    cursor.moveToNext();
                }
                for (String str4 : this.f258427d.keySet()) {
                    PhoneContact phoneContact3 = (PhoneContact) PhoneContactServiceImpl.this.contactCache.get(str4);
                    if (phoneContact3 != null) {
                        String str5 = (String) this.f258427d.get(str4);
                        this.f258428e.add(new AddressBookItem(str4, phoneContact3.name));
                        this.f258426c.add(new AddressBookItem(str4, str5));
                        phoneContact3.name = str5;
                        phoneContact3.pinyinAll = ChnToSpell.d(str5, 1);
                        String d17 = ChnToSpell.d(str5, 2);
                        phoneContact3.pinyinInitial = d17;
                        phoneContact3.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(d17);
                        PhoneContactServiceImpl.this.md52PhoneContact.remove(phoneContact3.md5, phoneContact3);
                        phoneContact3.md5 = com.tencent.mobileqq.phonecontact.util.d.b(str5, str4);
                        PhoneContactServiceImpl.this.md52PhoneContact.put(phoneContact3.md5, phoneContact3);
                        this.f258425b.add(phoneContact3);
                    }
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = PhoneContactServiceImpl.this.contactCache.entrySet().iterator();
                while (it.hasNext()) {
                    PhoneContact phoneContact4 = (PhoneContact) ((Map.Entry) it.next()).getValue();
                    if (phoneContact4.lastScanTime != this.f258424a) {
                        if (!TextUtils.isEmpty(phoneContact4.unifiedCode)) {
                            PhoneContactServiceImpl.this.contactCacheByCodeNumber.remove(phoneContact4.unifiedCode);
                        }
                        it.remove();
                        arrayList.add(new RemoveTransaction(phoneContact4));
                        this.f258428e.add(new AddressBookItem(phoneContact4.mobileNo, phoneContact4.name));
                    }
                }
                PhoneContactServiceImpl.this.f258386em.doMultiDBOperateByTransaction(arrayList);
            } catch (StaleDataException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(PhoneContactServiceImpl.TAG, 2, "", e16);
                }
                throw e16;
            }
        }
    }

    /* loaded from: classes16.dex */
    private class l extends AsyncTask<RespondQueryQQBindingStat, Void, List<PhoneContact>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private List<String> f258430a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public class a implements Comparator<PhoneContact> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
                }
                return phoneContact.contactID - phoneContact2.contactID;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes16.dex */
        public class b implements Comparator<PhoneContact> {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l.this);
                }
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(PhoneContact phoneContact, PhoneContact phoneContact2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContact, (Object) phoneContact2)).intValue();
                }
                int i3 = phoneContact.sortWeight - phoneContact2.sortWeight;
                if (i3 == 0) {
                    String str = phoneContact.pinyinFirst;
                    String str2 = phoneContact2.pinyinFirst;
                    if (str.endsWith("#")) {
                        str = "Za";
                    }
                    if (str2.endsWith("#")) {
                        str2 = "Za";
                    }
                    int compareTo = str.compareTo(str2);
                    if (compareTo == 0) {
                        return phoneContact.pinyinAll.compareTo(phoneContact2.pinyinAll);
                    }
                    return compareTo;
                }
                return i3;
            }
        }

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<PhoneContact> doInBackground(RespondQueryQQBindingStat... respondQueryQQBindingStatArr) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) respondQueryQQBindingStatArr);
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactFriendTask", 2, "doInBackground");
            }
            RespondQueryQQBindingStat respondQueryQQBindingStat = respondQueryQQBindingStatArr[0];
            ArrayList<PhoneContact> arrayList = new ArrayList();
            arrayList.addAll(PhoneContactServiceImpl.this.contactCache.values());
            PhoneContactServiceImpl.this.safeSort(arrayList, new a());
            ArrayList arrayList2 = new ArrayList();
            IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) PhoneContactServiceImpl.this.app.getRuntimeService(IAddFriendServiceApi.class, "");
            if (arrayList.size() > 0) {
                String str = respondQueryQQBindingStat.mobileNo;
                for (PhoneContact phoneContact : arrayList) {
                    if (isCancelled()) {
                        break;
                    }
                    if (str == null || !str.endsWith(phoneContact.mobileNo.trim())) {
                        PhoneContact phoneContact2 = (PhoneContact) phoneContact.clone();
                        if (!TextUtils.isEmpty(phoneContact2.uin)) {
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact2.uin);
                            if (phoneContact2.uin.equals("0")) {
                                friendsSimpleInfoWithUid = null;
                            } else {
                                friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "IMCore.PhoneContact.ContactFriendTask");
                            }
                            if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, "IMCore.PhoneContact.ContactFriendTask")) {
                                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                                aVar.d(uidFromUin);
                                phoneContact2.nickName = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                                phoneContact2.remark = friendsSimpleInfoWithUid.r();
                                phoneContact2.sortWeight = 262144;
                            } else {
                                phoneContact2.uin = "0";
                                if (iAddFriendServiceApi.hasSendAddFriendReq(phoneContact2.nationCode + phoneContact2.mobileCode)) {
                                    phoneContact2.sortWeight = 131072;
                                    phoneContact2.hasSendAddReq = true;
                                } else {
                                    List<String> list = this.f258430a;
                                    if (list != null && list.contains(phoneContact2.mobileNo)) {
                                        phoneContact2.sortWeight = this.f258430a.indexOf(phoneContact2.mobileNo);
                                    } else {
                                        phoneContact2.sortWeight = 65536;
                                    }
                                }
                            }
                            arrayList2.add(phoneContact2);
                        }
                    }
                }
                PhoneContactServiceImpl.this.safeSort(arrayList2, new b());
            }
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<PhoneContact> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            } else if (!isCancelled()) {
                PhoneContactServiceImpl.this.notifyContactFriendListLoaded(list);
            }
        }

        public void c(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else {
                this.f258430a = list;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.PhoneContact.ContactFriendTask", 2, "on cancelled");
            }
            PhoneContactServiceImpl.this.mLoadContactFriendTask = null;
        }

        /* synthetic */ l(PhoneContactServiceImpl phoneContactServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) phoneContactServiceImpl, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class m extends ContentObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<PhoneContactServiceImpl> f258434a;

        public m(Handler handler) {
            super(handler);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
            }
        }

        public void a(PhoneContactServiceImpl phoneContactServiceImpl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) phoneContactServiceImpl);
                return;
            }
            WeakReference<PhoneContactServiceImpl> weakReference = this.f258434a;
            if (weakReference != null) {
                weakReference.clear();
            }
            if (phoneContactServiceImpl != null) {
                this.f258434a = new WeakReference<>(phoneContactServiceImpl);
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            PhoneContactServiceImpl phoneContactServiceImpl;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.d(PhoneContactServiceImpl.TAG, 1, "Contact onChange selfChange:" + z16);
            WeakReference<PhoneContactServiceImpl> weakReference = this.f258434a;
            if (weakReference == null) {
                phoneContactServiceImpl = null;
            } else {
                phoneContactServiceImpl = weakReference.get();
            }
            if (phoneContactServiceImpl != null) {
                phoneContactServiceImpl.contactChanged = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24659);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 116)) {
            redirector.redirect((short) 116);
            return;
        }
        sQueryContactListInterval = 120000L;
        sQueryContactListIntervalLogin = 86400000L;
        PHONES_PROJECTION = new String[]{StepCounterConstants.BEACON_PARAM_KEY_DATA1, "display_name", "contact_id", StepCounterConstants.BEACON_PARAM_KEY_DATA2, "data3"};
        sAllEntranceNum = 20;
        RESULT_OK = 0;
        RESULT_FAIL = 2;
    }

    public PhoneContactServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUserSettingFlag = 0L;
        this.mIsFirstQueryBindState = true;
        this.isQueryingContact = false;
        this.contactListQueryTimeStamp = 0L;
        this.lastUploadFailTimeStamp = 0L;
        this.isUpdatingContact = false;
        this.lastUpdateFailTimeStamp = 0L;
        this.mCurrentBindState = -1;
        this.phoneNumToUinMap = new ConcurrentHashMap<>();
        this.uinToPhoneNumMap = new ConcurrentHashMap<>();
        this.isPhoneSwitched = false;
        this.mRecommendLock = new Object();
        this.mUploadPackages = 0;
        this.destroyed = false;
        this.mFrdHasBindPhoneTotalCount = -1;
        this.mSomeFrdHasBindPhone = null;
        this.mStarRecommendCount = 0;
        this.mRandom = null;
        this.mLastUnbindMobileTime = 0L;
        this.needUploadResultTip = false;
        this.contactOb = new AnonymousClass2();
        this.isAppBlocking = false;
        this.mLastLoginSet = new HashSet();
        this.isLastLoginRequesting = false;
        this.contactChanged = false;
        this.contactCache = new ConcurrentHashMap<>();
        this.contactCacheByCodeNumber = new ConcurrentHashMap<>();
        this.contactCacheByUin = new ConcurrentHashMap<>();
        this.md52PhoneContact = new ConcurrentHashMap<>();
        this.tmpContactCache = null;
        this.orderedBindList = null;
        this.orderedNobindList = null;
        this.bindNonFriendList = null;
        this.bindAllFriendList = null;
        this.contactBindedDataCache = null;
        this.mClearRecommendBadgeTask = new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (PhoneContact phoneContact : PhoneContactServiceImpl.this.contactCache.values()) {
                    if (phoneContact.isNewRecommend) {
                        phoneContact.isNewRecommend = false;
                        arrayList.add(new UpdateTransaction(phoneContact));
                    }
                }
                PhoneContactServiceImpl.this.f258386em.doMultiDBOperateByTransaction(arrayList);
                ContactBinded contactBinded = PhoneContactServiceImpl.this.mContactBinded;
                if (contactBinded != null) {
                    contactBinded.isReaded = true;
                }
                PhoneContactServiceImpl.this.pushRecommendUnreadCount(false);
            }
        };
        this.mListenerList = new LinkedList<>();
        this.mUploadProgressGenerator = null;
        this.recommendMobiles = new ArrayList();
        this.mListForSelector = null;
        this.mListForPhoneSelector = null;
        this.mListForContactListView = null;
        this.mIsUploadForNewGuide = false;
        this.mContactBindObserver2 = new h();
    }

    private void addContactsToLastLoginList(List<String> list) {
        try {
            HashSet hashSet = new HashSet(this.mLastLoginSet.size() + list.size());
            hashSet.addAll(this.mLastLoginSet);
            hashSet.addAll(list);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addContactsToLastLogin, mLastLoginSet.size=" + this.mLastLoginSet.size() + ", tempSet.size=" + hashSet.size());
            }
            this.mLastLoginSet = hashSet;
            saveLastLoginListToDb(this.mLastLoginSet);
        } catch (OutOfMemoryError e16) {
            QLog.e("PhoneContactManagerImp", 1, "addContactsToLastLoginList oom", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterLoadLocalContact(ConcurrentHashMap<String, PhoneContact> concurrentHashMap) {
        QLog.i(TAG, 1, "tempContact  = " + concurrentHashMap.entrySet() + " contactCache = " + this.contactCache.entrySet());
        for (Map.Entry<String, PhoneContact> entry : this.contactCache.entrySet()) {
            PhoneContact value = entry.getValue();
            PhoneContact phoneContact = concurrentHashMap.get(entry.getKey());
            if (phoneContact != null && value != null) {
                phoneContact.uin = value.uin;
                phoneContact.nationCode = value.nationCode;
                phoneContact.mobileCode = value.mobileCode;
                phoneContact.bindingDate = value.bindingDate;
                phoneContact.nickName = value.nickName;
                phoneContact.isUploaded = value.isUploaded;
                phoneContact.originBinder = value.originBinder;
                phoneContact.ability = value.ability;
            }
        }
        ConcurrentHashMap<String, PhoneContact> concurrentHashMap2 = this.contactCache;
        this.contactCache = concurrentHashMap;
        concurrentHashMap2.clear();
    }

    private void afterSaveContactFromServer(boolean z16) {
        ConcurrentHashMap<String, PhoneContact> concurrentHashMap = this.tmpContactCache;
        if (concurrentHashMap != null) {
            if (!concurrentHashMap.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (PhoneContact phoneContact : this.tmpContactCache.values()) {
                    resetContact(phoneContact, z16);
                    arrayList.add(new UpdateTransaction(phoneContact));
                }
                this.f258386em.doMultiDBOperateByTransaction(arrayList);
                this.tmpContactCache.clear();
            }
            this.tmpContactCache = null;
        }
    }

    private void beforeSaveContactFromServer(boolean z16) {
        if (z16) {
            this.contactCacheByUin.clear();
            this.contactCacheByCodeNumber.clear();
        }
        if (this.tmpContactCache == null) {
            this.tmpContactCache = new ConcurrentHashMap<>();
        }
        this.tmpContactCache.putAll(this.contactCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean checkUpdateBindStateAndList(boolean z16, boolean z17, long j3) {
        int i3;
        AppInterface appInterface = this.app;
        if (!this.destroyed && appInterface != null) {
            this.mInjectProcessor.i(true);
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append("checkUpdateBindStateAndList, from: ");
            sb5.append(j3);
            sb5.append(", isQueryingContact: ");
            sb5.append(this.isQueryingContact);
            sb5.append(", isUpdatingContact: ");
            sb5.append(this.isUpdatingContact);
            sb5.append(", mCurrentBindState: ");
            sb5.append(this.mCurrentBindState);
            sb5.append(", beForce: ");
            sb5.append(z16);
            sb5.append(", isQueryAll: ");
            sb5.append(z17);
            sb5.append(", lastQueryTime: ");
            sb5.append(this.contactListQueryTimeStamp / 1000);
            sb5.append(", currentTime: ");
            sb5.append(currentTimeMillis / 1000);
            sb5.append(", bindState: ");
            sb5.append(getSelfBindState());
            QLog.d(TAG, 1, sb5.toString());
            if (!this.isQueryingContact && this.mCurrentBindState != 8 && !this.isUpdatingContact && this.mCurrentBindState != 4) {
                long abs = Math.abs(currentTimeMillis - this.contactListQueryTimeStamp);
                if ((j3 != 2 && j3 != 23) || (abs >= sQueryContactListIntervalLogin && ContactSyncLimitManager.d().h())) {
                    if (!z16 && abs < sQueryContactListInterval) {
                        QLog.i(TAG, 1, String.format("checkUpdateBindStateAndList return. [interval:%s, limit:%s]", Long.valueOf(abs), Long.valueOf(sQueryContactListInterval)));
                        return false;
                    }
                    this.isQueryingContact = true;
                    this.respBindFriendList_V2 = null;
                    this.respBindStrangerList_V2 = null;
                    NewIntent newIntent = new NewIntent(appInterface.getApplication(), ContactBindServlet.class);
                    newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 30);
                    newIntent.putExtra("next_flag", 0L);
                    long j16 = this.pref.getLong("queryContactTimeStamp", 0L);
                    long j17 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
                    int bindStateForServer = getBindStateForServer();
                    newIntent.putExtra("time_stamp", j16);
                    newIntent.putExtra("richinfo_time_stamp", j17);
                    newIntent.putExtra(ServiceConst.PARA_SESSION_ID, new byte[0]);
                    newIntent.putExtra("unique_phone_no", getUNIQUE_NO());
                    if (z17) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    newIntent.putExtra("force_query_list", i3);
                    newIntent.putExtra("param_query_from", j3);
                    newIntent.putExtra("param_bind_state", bindStateForServer);
                    appInterface.startServlet(newIntent);
                    QLog.d(TAG, 1, String.format("real doQueryContactList. [force, queryAll, from, interval] = [%b, %b, %d, %d]", Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Long.valueOf(abs)));
                    return true;
                }
                QLog.i(TAG, 1, String.format("checkUpdateBindStateAndList return. foreground=%b [interval:%s, limit:%s]", Boolean.valueOf(ContactSyncLimitManager.d().h()), Long.valueOf(abs), Long.valueOf(sQueryContactListIntervalLogin)));
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdateLastLoginList() {
        if (this.destroyed) {
            return;
        }
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (PhoneContactServiceImpl.this.destroyed) {
                    return;
                }
                long j3 = PhoneContactServiceImpl.this.pref.getLong(PhoneContactServiceImpl.KEY_LAST_REQ_LOGIN_TIME, 0L);
                long j16 = PhoneContactServiceImpl.this.pref.getLong(PhoneContactServiceImpl.KEY_REQUEST_LOGIN_INTERVAL, 86400000L);
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder(100);
                    sb5.append("checkLastLogin, lastReqTime = ");
                    sb5.append(j3);
                    sb5.append(", current = ");
                    sb5.append(System.currentTimeMillis());
                    sb5.append(", interval = ");
                    sb5.append(j16);
                    sb5.append(", isRequesting = ");
                    sb5.append(PhoneContactServiceImpl.this.isLastLoginRequesting);
                    QLog.d(PhoneContactServiceImpl.TAG, 2, sb5.toString());
                }
                if (!PhoneContactServiceImpl.this.isLastLoginRequesting && PhoneContactServiceImpl.this.isBindContactOk() && Math.abs(System.currentTimeMillis() - j3) >= j16) {
                    PhoneContactServiceImpl.this.isLastLoginRequesting = true;
                    NewIntent newIntent = new NewIntent(PhoneContactServiceImpl.this.app.getApplication(), ContactBindServlet.class);
                    newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 32);
                    long j17 = PhoneContactServiceImpl.this.pref.getLong(PhoneContactServiceImpl.KEY_LOGIN_INFO_TIME_STAMP, 0L);
                    newIntent.putExtra("next_flag", 0);
                    newIntent.putExtra("time_stamp", j17);
                    newIntent.putExtra("unique_phone_no", PhoneContactServiceImpl.this.getUNIQUE_NO());
                    PhoneContactServiceImpl.this.app.startServlet(newIntent);
                }
            }
        });
    }

    private boolean dealCheckUpdateLocalContact(boolean z16) {
        Object valueOf;
        boolean updatePhoneContactNotBind;
        boolean checkUpdateBindStateAndList;
        int selfBindState = getSelfBindState();
        RespondQueryQQBindingStat selfBindInfo = getSelfBindInfo();
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.contactChanged);
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = Integer.valueOf(selfBindState);
        if (selfBindInfo == null) {
            valueOf = "bind info is null";
        } else {
            valueOf = Boolean.valueOf(selfBindInfo.noBindUploadContacts);
        }
        objArr[3] = valueOf;
        QLog.d(TAG, 1, String.format("pre dealCheckUpdateLocalContact() | contactChanged: %s, beFirstQuery: %s, bindState: %s, bindInfo: %s", objArr));
        if (selfBindState != 8 && isAutoUploadContacts()) {
            checkUpdateBindStateAndList = uploadPhoneContact();
        } else {
            if (isBindContactOk()) {
                if (!z16 && !this.contactChanged) {
                    return false;
                }
                updatePhoneContactNotBind = updatePhoneContact();
            } else if (selfBindState != 4 && isAutoUploadContactsNotBind()) {
                checkUpdateBindStateAndList = uploadPhoneContactNotBind();
            } else if (selfBindState == 1) {
                if (!z16 || selfBindInfo == null || !selfBindInfo.noBindUploadContacts) {
                    return false;
                }
                checkUpdateBindStateAndList = checkUpdateBindStateAndList(true, true, 15L);
            } else {
                if (selfBindState != 2) {
                    return false;
                }
                if (!z16 && !this.contactChanged) {
                    return false;
                }
                updatePhoneContactNotBind = updatePhoneContactNotBind();
            }
            return false | updatePhoneContactNotBind;
        }
        return false | checkUpdateBindStateAndList;
    }

    private void deleteLocalData() {
        if (this.destroyed) {
            return;
        }
        QLog.d(TAG, 1, "deleteLocalData");
        this.isCacheInited = false;
        saveContactListTimeStamp(0L, 0L);
        this.contactCache.clear();
        this.contactCacheByUin.clear();
        this.contactCacheByCodeNumber.clear();
        this.md52PhoneContact.clear();
        notifyContactChanged(1);
        pushRecommendUnreadCount(false);
        synchronized (this.mRecommendLock) {
            ArrayList<ContactMatch> arrayList = this.mContactMatch;
            if (arrayList != null) {
                arrayList.clear();
                this.mContactMatch = null;
            }
            this.mContactBinded = null;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new DeleteTransaction(new PhoneContact().getTableName(), null, null));
        arrayList2.add(new DeleteTransaction(new ContactMatch().getTableName(), null, null));
        arrayList2.add(new DeleteTransaction(new ContactBinded().getTableName(), null, null));
        this.f258386em.doMultiDBOperateByTransaction(arrayList2);
    }

    private boolean doUpdateContact(String str, ArrayList<AddressBookItem> arrayList, ArrayList<AddressBookItem> arrayList2, ArrayList<PhoneContact> arrayList3, boolean z16) {
        int i3;
        int size;
        int size2;
        int size3;
        if (str != null && (arrayList != null || arrayList2 != null)) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(z16);
                if (arrayList == null) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                objArr[1] = Integer.valueOf(size);
                if (arrayList2 == null) {
                    size2 = 0;
                } else {
                    size2 = arrayList2.size();
                }
                objArr[2] = Integer.valueOf(size2);
                if (arrayList3 == null) {
                    size3 = 0;
                } else {
                    size3 = arrayList3.size();
                }
                objArr[3] = Integer.valueOf(size3);
                QLog.d(TAG, 2, String.format("doUpdateContact bind:%s, add:%s, del:%s, rename:%s", objArr));
            }
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            if (z16) {
                i3 = 15;
            } else {
                i3 = 38;
            }
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, i3);
            newIntent.putExtra("unique_phone_no", str);
            newIntent.putExtra("add_contact_list", arrayList);
            newIntent.putExtra("del_contact_list", arrayList2);
            newIntent.putExtra("rename_contact_list", arrayList3);
            newIntent.putExtra("next_flag", 0L);
            newIntent.putExtra("upload_package_no", 0);
            newIntent.putExtra(ServiceConst.PARA_SESSION_ID, new byte[0]);
            newIntent.putExtra("is_resend", false);
            this.app.startServlet(newIntent);
            return true;
        }
        this.isUpdatingContact = false;
        return false;
    }

    public static PhoneContactServiceImpl getService(AppInterface appInterface) {
        return (PhoneContactServiceImpl) appInterface.getRuntimeService(IPhoneContactService.class, "");
    }

    private String getUniqueString() {
        String str;
        if (!TextUtils.isEmpty("")) {
            str = "";
        } else {
            try {
                str = DeviceInfoMonitor.getString(BaseApplication.getContext().getContentResolver(), SharedPreferencedUtil.SP_KEY_ANDROID_ID);
            } catch (Exception unused) {
                str = "";
            }
            QLog.i(TAG, 1, String.format("fallback androidId:%s", str));
            if (TextUtils.isEmpty(str)) {
                str = new Random().nextLong() + "";
            }
        }
        return "|" + str;
    }

    private List<PhoneContact> initBindAllFriendList() {
        ArrayList arrayList = new ArrayList(this.contactCache.size());
        for (PhoneContact phoneContact : this.contactCache.values()) {
            if (!TextUtils.isEmpty(phoneContact.uin)) {
                arrayList.add(phoneContact);
            }
        }
        return arrayList;
    }

    private List<PhoneContact> initBindNonfriendList() {
        ArrayList arrayList = new ArrayList(this.contactCache.size());
        for (PhoneContact phoneContact : this.contactCache.values()) {
            if ("0".equals(phoneContact.uin)) {
                arrayList.add(phoneContact);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initBindNonfriendList| [ " + arrayList.size() + "/" + this.contactCache.size() + "]");
        }
        return arrayList;
    }

    private void initLastLoginList() {
        List<? extends Entity> list;
        if (this.destroyed) {
            return;
        }
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            list = createEntityManager.query(LastLoginPhoneInfo.class);
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>(0);
        }
        HashSet hashSet = new HashSet(list.size());
        Iterator<? extends Entity> it = list.iterator();
        while (it.hasNext()) {
            LastLoginPhoneInfo lastLoginPhoneInfo = (LastLoginPhoneInfo) it.next();
            if (!TextUtils.isEmpty(lastLoginPhoneInfo.unifiedCode)) {
                hashSet.add(lastLoginPhoneInfo.unifiedCode);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initLastLoginList, load for db,size=" + list.size() + ", tempSet.size=" + hashSet.size());
        }
        this.mLastLoginSet = hashSet;
    }

    private void initQueryInterval() {
        try {
            com.tencent.mobileqq.phonecontact.nt.b bVar = com.tencent.mobileqq.phonecontact.nt.b.f258483a;
            sQueryContactListInterval = bVar.b(AppConstants.Preferences.CONTACT_QUERY_MIN_INTERVAL, sQueryContactListInterval);
            sQueryContactListIntervalLogin = bVar.b(AppConstants.Preferences.CONTACT_QUERY_MIN_INTERVAL_FOR_LOGIN, sQueryContactListIntervalLogin);
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, th5.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("initQueryInterval  [limit:%s limitLogin:%s]", Long.valueOf(sQueryContactListInterval), Long.valueOf(sQueryContactListIntervalLogin)));
        }
    }

    private String initUniqueString() {
        String string = this.pref.getString(AppConstants.Preferences.CONTACT_BIND_INFO_UNIQUE, "");
        if (!TextUtils.isEmpty(string) && !string.equals("null|null")) {
            return string;
        }
        String uniqueString = getUniqueString();
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString(AppConstants.Preferences.CONTACT_BIND_INFO_UNIQUE, uniqueString);
        edit.commit();
        return uniqueString;
    }

    private ArrayList<AddressBookItem> loadContactFromPhoneToDB() {
        preLoadLocalContact();
        QLog.d(TAG, 1, "- - - read system contacts - - - [loadContactFromPhoneToDB()]");
        b.C8219b c8219b = new b.C8219b(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        ArrayList<AddressBookItem> arrayList = new ArrayList<>();
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, c8219b, new i(arrayList), true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "loadContactFromPhoneToDB save contact finish with: " + arrayList.size());
        }
        this.isCacheInited = true;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBindStateChanged() {
        if (this.destroyed) {
            return;
        }
        this.app.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PhoneContactServiceImpl.this.mListenerList) {
                        try {
                            Iterator it = PhoneContactServiceImpl.this.mListenerList.iterator();
                            while (it.hasNext()) {
                                ((od2.a) it.next()).Ug(PhoneContactServiceImpl.this.mCurrentBindState);
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContactFriendListLoaded(List<PhoneContact> list) {
        this.mInjectProcessor.a(list);
    }

    private void notifyRecommendCountChanged(boolean z16, List<PhoneContact> list) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "notifyRecommendCountChanged|beAdded = " + z16 + "|list.size = " + list.size());
        }
        if (this.destroyed) {
            return;
        }
        this.app.runOnUiThread(new Runnable(z16, list.size()) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.14
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f258389d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f258390e;

            {
                this.f258389d = z16;
                this.f258390e = r7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PhoneContactServiceImpl.this, Boolean.valueOf(z16), Integer.valueOf(r7));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PhoneContactServiceImpl.this.mListenerList) {
                        Iterator it = PhoneContactServiceImpl.this.mListenerList.iterator();
                        while (it.hasNext()) {
                            ((od2.a) it.next()).e7(this.f258389d, this.f258390e);
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private void notifyUISwitchChanged(long j3) {
        this.app.runOnUiThread(new Runnable(j3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.15
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f258391d;

            {
                this.f258391d = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, PhoneContactServiceImpl.this, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PhoneContactServiceImpl.this.mListenerList) {
                        Iterator it = PhoneContactServiceImpl.this.mListenerList.iterator();
                        while (it.hasNext()) {
                            ((od2.a) it.next()).B7(this.f258391d);
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgressChanged(int i3) {
        if (this.destroyed) {
            return;
        }
        this.app.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.13
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f258388d;

            {
                this.f258388d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PhoneContactServiceImpl.this.mListenerList) {
                        Iterator it = PhoneContactServiceImpl.this.mListenerList.iterator();
                        while (it.hasNext()) {
                            ((od2.a) it.next()).T2(this.f258388d);
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    private void onNewRecommendContact(boolean z16, List<PhoneContact> list) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onNewRecommendContact|listSize = ", Integer.valueOf(list.size()));
        }
        synchronized (this.mRecommendLock) {
            ArrayList arrayList = new ArrayList();
            if (list.size() > 0) {
                if (this.mContactBinded != null && list.size() <= sAllEntranceNum) {
                    if (this.mContactMatch == null) {
                        this.mContactMatch = new ArrayList<>(list.size());
                    }
                    for (PhoneContact phoneContact : list) {
                        Iterator<ContactMatch> it = this.mContactMatch.iterator();
                        while (it.hasNext()) {
                            ContactMatch next = it.next();
                            if (next.mobileNo.equals(phoneContact.mobileNo)) {
                                it.remove();
                                arrayList.add(new RemoveTransaction(next));
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "onNewRecommendContact remove uin=", next.mobileNo);
                                }
                            }
                        }
                        ContactMatch contactMatch = new ContactMatch();
                        contactMatch.mobileNo = phoneContact.mobileNo;
                        contactMatch.unifiedCode = phoneContact.unifiedCode;
                        contactMatch.name = phoneContact.name;
                        contactMatch.timestamp = com.tencent.mobileqq.service.message.e.K0();
                        contactMatch.age = (short) phoneContact.age;
                        contactMatch.gender = (short) phoneContact.sex;
                        contactMatch.commonFriend = phoneContact.samFriend;
                        this.mContactMatch.add(contactMatch);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "onNewRecommendContact new uin=", contactMatch.mobileNo);
                        }
                        arrayList.addAll(updateEntity(contactMatch));
                    }
                } else {
                    if (this.mContactBinded == null) {
                        this.mContactBinded = new ContactBinded();
                    }
                    this.mContactBinded.timestamp = com.tencent.mobileqq.service.message.e.K0();
                    this.mContactBinded.isReaded = false;
                }
                arrayList.addAll(updateEntity(this.mContactBinded));
            }
            if (z16) {
                if (this.mContactBinded == null) {
                    ContactBinded contactBinded = new ContactBinded();
                    this.mContactBinded = contactBinded;
                    contactBinded.isReaded = list.isEmpty();
                    arrayList.addAll(updateEntity(this.mContactBinded));
                }
            } else {
                this.mContactBinded = null;
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean poppedForThisVersion() {
        boolean z16 = !AppSetting.f99551k.equals(this.pref.getString(AppConstants.Preferences.PHONE_VERSION_RUN_POPPED, ""));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isPhoneContactFirstRun result = " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean poppedForThisVersionNotBind() {
        boolean z16 = !AppSetting.f99551k.equals(this.pref.getString(AppConstants.Preferences.PHONE_VERSION_RUN_POPPED_NOTBIND, ""));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "poppedForThisVersionNotBind result = " + z16);
        }
        return z16;
    }

    private void preLoadLocalContact() {
        QLog.d(TAG, 1, "preLoadLocalContact");
        saveContactListTimeStamp(0L, 0L);
        this.isCacheInited = false;
        this.contactCache.clear();
        this.contactCacheByUin.clear();
        this.contactCacheByCodeNumber.clear();
        this.md52PhoneContact.clear();
        try {
            AppInterface appInterface = this.app;
            if (appInterface != null) {
                appInterface.getWritableDatabase().delete(new PhoneContact().getTableName(), null, null);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushRecommendUnreadCount(boolean z16) {
        List<PhoneContact> recommendUnreadList = getRecommendUnreadList();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pushRecommendUnreadCount: beAdded = " + z16 + ", unreadCount = " + recommendUnreadList.size());
        }
        notifyRecommendCountChanged(z16, recommendUnreadList);
        com.tencent.mobileqq.phonecontact.processor.a aVar = this.mInjectProcessor;
        if (aVar == null) {
            QLog.e(TAG, 2, "pushRecommendUnreadCount is error! mInjectProcessor is null!");
        } else {
            aVar.refreshAppBadge();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryShowBindPhonePage(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("queryShowBindPhonePage fromNotBind=%s", Boolean.valueOf(z16)));
        }
        try {
            this.mFromNotBind = z16;
            if (this.mContactBindHandler == null) {
                this.mContactBindHandler = (ContactBindHandler) this.app.getBusinessHandler(ContactBindHandler.class.getName());
            }
            ReportController.o(this.app, "dc00898", "", "", "0X80095EE", "0X80095EE", 0, 0, "", "", "", "");
            this.mContactBindHandler.G2(this.app.getCurrentUin());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "queryShowBindPhonePage fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registContentObserver() {
        try {
            m mVar = new m(new Handler(this.app.getApp().getMainLooper()));
            this.contactObserver = mVar;
            mVar.a(this);
            this.app.getApp().getContentResolver().registerContentObserver(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, true, this.contactObserver);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, th5.getMessage(), th5);
            }
        }
    }

    private void removeIllegalRecommend() {
        String str;
        synchronized (this.mRecommendLock) {
            if (this.mCurrentBindState >= 9 && getBannerState() == 1) {
                if (this.mContactBinded != null) {
                    this.mContactBinded = null;
                }
                ArrayList<ContactMatch> arrayList = this.mContactMatch;
                if (arrayList != null && arrayList.size() > 0) {
                    this.mContactMatch.clear();
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new DeleteTransaction(new ContactMatch().getTableName(), null, null));
                arrayList2.add(new DeleteTransaction(new ContactBinded().getTableName(), null, null));
                this.f258386em.doMultiDBOperateByTransaction(arrayList2);
                QLog.d(TAG, 1, "removeIllegalRecommend with BannerShow");
            } else if (this.mContactMatch != null) {
                ArrayList arrayList3 = new ArrayList();
                Iterator<ContactMatch> it = this.mContactMatch.iterator();
                while (it.hasNext()) {
                    ContactMatch next = it.next();
                    PhoneContact queryPhoneContactByMobile = queryPhoneContactByMobile(next.mobileNo);
                    if (queryPhoneContactByMobile == null || (((str = queryPhoneContactByMobile.uin) != null && !str.equals("0")) || this.mContactMatch.size() >= sAllEntranceNum)) {
                        it.remove();
                        arrayList3.add(new RemoveTransaction(next));
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "removeIllegalRecommend remove ContactMatch = ", next.mobileNo);
                        }
                    }
                }
                this.f258386em.doMultiDBOperateByTransaction(arrayList3);
                if (QLog.isColorLevel()) {
                    Iterator<ContactMatch> it5 = this.mContactMatch.iterator();
                    while (it5.hasNext()) {
                        QLog.d(TAG, 2, "removeIllegalRecommend|mobileNo : " + it5.next().mobileNo + "|size : " + this.mContactMatch.size());
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "removeIllegalRecommend mContactMatchsize = " + this.mContactMatch.size());
                }
            }
        }
    }

    private void resetContact(PhoneContact phoneContact, boolean z16) {
        if (!TextUtils.isEmpty(phoneContact.uin)) {
            if (z16) {
                phoneContact.bindingDate = 0L;
                phoneContact.isRecommend = 0;
                phoneContact.uin = "";
                phoneContact.originBinder = 0L;
                phoneContact.ability = 0;
                return;
            }
            if (phoneContact.uin.equals("0")) {
                phoneContact.netTypeIconId = 0;
                phoneContact.detalStatusFlag = QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA;
                phoneContact.iTermType = 0;
                phoneContact.strTermDesc = "";
                phoneContact.eNetworkType = 0;
                phoneContact.abilityBits = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void safeSort(List<T> list, Comparator<? super T> comparator) {
        try {
            Collections.sort(list, comparator);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "safeSort exception: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveContactListTimeStamp(long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("saveContactListTimeStamp, [%s,%s]", Long.valueOf(j3), Long.valueOf(j16)));
        }
        this.pref.edit().putLong("queryContactTimeStamp", j3).putLong("queryRichInfoTimeStamp", j16).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveContactListTimeStampNotBind(long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveContactListTimeStampNotBind" + j3);
        }
        SharedPreferences sharedPreferences = this.pref;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("queryContactTimeStamp", j3).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveUploadDataForNewGuide(int i3, int i16, int i17, int i18) {
        try {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, String.format("saveUploadDataForNewGuide [%s, %s, %s, %s]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
            }
            if (this.mDataForNewGuide == null) {
                this.mDataForNewGuide = new JSONObject();
            }
            this.mDataForNewGuide.put("state", i3);
            if (i16 > 0) {
                this.mDataForNewGuide.put("total", i16);
            }
            this.mDataForNewGuide.put("curPer", i17);
            this.mDataForNewGuide.put("expPer", i18);
            this.mInjectProcessor.j(this.app.getAccount(), this.mDataForNewGuide);
            if (i3 == 3 || i3 == 4) {
                this.mIsUploadForNewGuide = false;
                this.mDataForNewGuide = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setShowBindPhonePageResult(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("setShowBindPhonePageResult success=%s", Boolean.valueOf(z16)));
        }
        try {
            if (this.mContactBindHandler == null) {
                this.mContactBindHandler = (ContactBindHandler) this.app.getBusinessHandler(ContactBindHandler.class.getName());
            }
            this.mContactBindHandler.J2(this.app.getCurrentUin(), z16);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "setShowBindPhonePageResult fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showBindPhonePage(boolean z16) {
        if (!this.app.isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("showBindPhonePage isLogin return false", new Object[0]));
            }
            return false;
        }
        boolean poppedForThisVersion = poppedForThisVersion();
        boolean poppedForThisVersionNotBind = poppedForThisVersionNotBind();
        long abs = Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLastUnbindMobileTime);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "showBindPhonePage| isFirstRun: " + poppedForThisVersion + ", needToJumpBind: " + poppedForThisVersionNotBind + ", unbindGap: " + abs);
        }
        return this.mInjectProcessor.f(z16, poppedForThisVersion, poppedForThisVersionNotBind, getSelfBindState(), getSelfBindInfo(), isAutoUploadContacts(), abs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(int i3, boolean z16) {
        String string;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("showToast [%s, %s, %s, %s]", Boolean.valueOf(this.needUploadResultTip), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(this.mCurrentBindState)));
        }
        if (this.needUploadResultTip) {
            this.needUploadResultTip = false;
            if (this.mCurrentBindState != 1) {
                if (z16) {
                    string = BaseApplication.getContext().getString(R.string.f198064lp);
                } else {
                    string = BaseApplication.getContext().getString(R.string.f198054lo);
                }
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    showToast(z16, string);
                } else {
                    this.app.runOnUiThread(new Runnable(z16, string) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f258398d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f258399e;

                        {
                            this.f258398d = z16;
                            this.f258399e = string;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, PhoneContactServiceImpl.this, Boolean.valueOf(z16), string);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                PhoneContactServiceImpl.this.showToast(this.f258398d, this.f258399e);
                            } else {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void syncBindState(RespondQueryQQBindingStat respondQueryQQBindingStat) {
        int i3 = this.mCurrentBindState;
        int selfBindState = getSelfBindState(respondQueryQQBindingStat);
        if (selfBindState != 1) {
            if (selfBindState != 2 && selfBindState != 3) {
                if (selfBindState != 5) {
                    if (selfBindState != 6) {
                        if (selfBindState != 7) {
                            if (selfBindState == 9) {
                                this.mCurrentBindState = selfBindState;
                            }
                        } else if (this.mCurrentBindState != 8) {
                            if (this.mCurrentBindState != selfBindState) {
                                deleteLocalData();
                            }
                            this.mCurrentBindState = selfBindState;
                        } else if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "cur state is uploading");
                        }
                    } else {
                        if (respondQueryQQBindingStat.lastUsedFlag == 3) {
                            deleteLocalData();
                        }
                        this.mCurrentBindState = selfBindState;
                    }
                }
            } else {
                this.mCurrentBindState = selfBindState;
            }
            if (this.mCurrentBindState == 0) {
                this.mCurrentBindState = selfBindState;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "syncBindState newState = " + selfBindState + " lastState=" + i3 + " curState=" + this.mCurrentBindState);
            }
            if (i3 == this.mCurrentBindState) {
                notifyBindStateChanged();
                return;
            }
            return;
        }
        if (this.mCurrentBindState != selfBindState) {
            deleteLocalData();
            this.pref.edit().putBoolean(AppConstants.Preferences.KEY_SHOW_CONTACT_BANNER, true).commit();
        }
        if (selfBindState != 1 || this.mCurrentBindState != 4) {
            this.mCurrentBindState = selfBindState;
        }
        if (this.mCurrentBindState == 0) {
        }
        if (QLog.isColorLevel()) {
        }
        if (i3 == this.mCurrentBindState) {
        }
    }

    private ArrayList<PhoneContact> updateLocalContact(ArrayList<AddressBookItem> arrayList, ArrayList<AddressBookItem> arrayList2) {
        HashMap hashMap = new HashMap();
        ArrayList<PhoneContact> arrayList3 = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "- - - read system contacts - - - [updateLocalContact()]");
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null), new k(currentTimeMillis, arrayList3, arrayList, hashMap, arrayList2), false);
        this.contactChanged = false;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateLocalContact [add:%s, del:%s, rename:%s, cost:%s]", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        return arrayList3;
    }

    private synchronized boolean updatePhoneContact() {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("updatePhoneContact, isUpdating = ");
            sb5.append(this.isUpdatingContact);
            sb5.append(", isQuerying = ");
            sb5.append(this.isQueryingContact);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (!this.isUpdatingContact && !this.isQueryingContact) {
            if (System.currentTimeMillis() - this.lastUpdateFailTimeStamp < 120000) {
                return false;
            }
            ArrayList<AddressBookItem> arrayList = new ArrayList<>();
            ArrayList<AddressBookItem> arrayList2 = new ArrayList<>();
            QLog.d(TAG, 1, "do-updatePhoneContact()");
            if (ContactSyncLimitManager.d().h()) {
                ArrayList<PhoneContact> updateLocalContact = updateLocalContact(arrayList, arrayList2);
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    this.isUpdatingContact = doUpdateContact(getUNIQUE_NO(), arrayList, arrayList2, updateLocalContact, true);
                    notifyContactChanged(1);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private synchronized boolean updatePhoneContactNotBind() {
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("updatePhoneContactNotBind, isUpdating = ");
            sb5.append(this.isUpdatingContact);
            sb5.append(", isQuerying = ");
            sb5.append(this.isQueryingContact);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (!this.isUpdatingContact && !this.isQueryingContact) {
            if (System.currentTimeMillis() - this.lastUpdateFailTimeStamp < 120000) {
                return false;
            }
            QLog.d(TAG, 1, "do-updatePhoneContactNotBind()");
            ArrayList<AddressBookItem> arrayList = new ArrayList<>();
            ArrayList<AddressBookItem> arrayList2 = new ArrayList<>();
            ArrayList<PhoneContact> updateLocalContact = updateLocalContact(arrayList, arrayList2);
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                return false;
            }
            this.isUpdatingContact = doUpdateContact(getUNIQUE_NO(), arrayList, arrayList2, updateLocalContact, false);
            notifyContactChanged(1);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void OnDisableMobileBindSuc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "OnDisableMobileBindSuc");
        }
        this.mCurrentBindState = 7;
        checkUpdateBindStateAndList(true, true, 22L);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean addContactAndUpload(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addContactAndUpload " + str + ", " + str2);
        }
        ContentResolver contentResolver = this.app.getApp().getContentResolver();
        try {
            ContentValues contentValues = new ContentValues();
            long parseId = ContentUris.parseId(contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues));
            if (parseId <= 0) {
                return false;
            }
            contentValues.clear();
            contentValues.put("raw_contact_id", Long.valueOf(parseId));
            contentValues.put("mimetype", "vnd.android.cursor.item/name");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI, contentValues);
            contentValues.clear();
            contentValues.put("raw_contact_id", Long.valueOf(parseId));
            contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA1, str2);
            contentValues.put(StepCounterConstants.BEACON_PARAM_KEY_DATA2, (Integer) 2);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI, contentValues);
            checkUpdateLocalContact(false, 1);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void addFriendSuccessNotify(String str, String str2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) str, (Object) str2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        PhoneContact phoneContact = this.contactCache.get(str);
        if (phoneContact != null) {
            phoneContact.uin = str2;
            arrayList.add(new UpdateTransaction(phoneContact));
            if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
                this.contactCacheByUin.put(phoneContact.uin, phoneContact);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        this.f258386em.doMultiDBOperateByTransaction(arrayList);
        if (z16) {
            notifyContactChanged(1);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void addListener(od2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.mListenerList) {
            if (!this.mListenerList.contains(aVar)) {
                this.mListenerList.add(aVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void addUinByPhoneNum(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) str, (Object) str2);
            return;
        }
        String str3 = this.phoneNumToUinMap.get(str);
        if (str3 == null || !str3.equals(str2)) {
            this.phoneNumToUinMap.put(str, str2);
            this.uinToPhoneNumMap.put(str2, str);
            EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
            PhoneNumInfo phoneNumInfo = new PhoneNumInfo();
            phoneNumInfo.phoneNum = str;
            phoneNumInfo.uin = str2;
            if (createEntityManager != null) {
                createEntityManager.persistOrReplace(phoneNumInfo);
                createEntityManager.close();
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public com.tencent.mobileqq.phonecontact.data.a asyncInitContactBindedData(List<PhoneContact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (com.tencent.mobileqq.phonecontact.data.a) iPatchRedirector.redirect((short) 34, (Object) this, (Object) list);
        }
        ThreadManager.getSubThreadHandler().post(new Runnable(list) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.10
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f258387d;

            {
                this.f258387d = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this, (Object) list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                List list2 = this.f258387d;
                if (list2 != null && !list2.isEmpty()) {
                    PhoneContactServiceImpl.this.contactBindedDataCache = com.tencent.mobileqq.phonecontact.util.a.a(this.f258387d, null, true);
                } else {
                    PhoneContactServiceImpl.this.contactBindedDataCache = null;
                }
            }
        });
        return this.contactBindedDataCache;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void changeHidenStatus(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "changeHidenStatus: mobile = " + str + ";hide=" + z16);
        }
        PhoneContact queryContactByCodeNumber = queryContactByCodeNumber(str);
        if (queryContactByCodeNumber != null && queryContactByCodeNumber.isHiden != z16) {
            queryContactByCodeNumber.isHiden = z16;
            this.f258386em.update(queryContactByCodeNumber);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkAndUploadContact(boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return ((Boolean) iPatchRedirector.redirect((short) 105, (Object) this, z16)).booleanValue();
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            z17 = true;
        } else {
            z17 = false;
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        long abs = Math.abs(K0 - this.mUserSettingFlag);
        if (abs < 3600) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18 && (z16 || ContactSyncLimitManager.d().h())) {
            boolean g16 = PermissionChecker.h().g();
            if (!z17) {
                g16 = PermissionChecker.h().f();
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "checkAndUploadContact,  has: " + g16 + ",  state: " + getSelfBindState());
            }
            if (g16) {
                if (z17) {
                    ThreadManagerV2.excute(new Runnable(z16) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.24
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ boolean f258397d;

                        {
                            this.f258397d = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, PhoneContactServiceImpl.this, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z27;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (PermissionChecker.h().f()) {
                                PhoneContactServiceImpl.this.uploadOrUpdateContact();
                                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                                if (this.f258397d) {
                                    z27 = true;
                                } else {
                                    z27 = phoneContactServiceImpl.needUploadResultTip;
                                }
                                phoneContactServiceImpl.needUploadResultTip = z27;
                            }
                        }
                    }, 16, null, false);
                } else {
                    uploadOrUpdateContact();
                    if (z16) {
                        z26 = true;
                    } else {
                        z26 = this.needUploadResultTip;
                    }
                    this.needUploadResultTip = z26;
                }
                z19 = true;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, String.format("checkAndUploadContact [%s, %s, %s, %s]", Long.valueOf(abs), Long.valueOf(K0), Long.valueOf(this.mUserSettingFlag), Boolean.valueOf(z19)));
                }
                if (z18 || z19) {
                    markOrClearUserSettingFlag(false);
                }
                return z19;
            }
        }
        z19 = false;
        if (QLog.isColorLevel()) {
        }
        if (z18) {
        }
        markOrClearUserSettingFlag(false);
        return z19;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public synchronized void checkUpdateBindStateAndListIgnoreBindState(boolean z16, boolean z17, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
        } else {
            if (this.destroyed) {
                return;
            }
            ThreadManagerV2.excute(new Runnable(z16, z17, i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ boolean f258400d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ boolean f258401e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f258402f;

                {
                    this.f258400d = z16;
                    this.f258401e = z17;
                    this.f258402f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PhoneContactServiceImpl.this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(PhoneContactServiceImpl.TAG, 2, String.format("checkUpdateBindStateAndListIgnoreBindState [forced:%s, isQueryAll:%s, from:%s]", Boolean.valueOf(this.f258400d), Boolean.valueOf(this.f258401e), Integer.valueOf(this.f258402f)));
                    }
                    PhoneContactServiceImpl.this.checkUpdateBindStateAndList(this.f258400d, this.f258401e, this.f258402f);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void checkUpdateLocalContact(boolean z16, int i3) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (this.destroyed) {
            return;
        }
        if ((i3 == 2 || i3 == 23) && !ContactSyncLimitManager.d().h()) {
            QLog.d(TAG, 1, String.format("checkUpdateLocalContact() return. beFirstQuery=%b queryFrom=%d runningForeground=%b", Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(ContactSyncLimitManager.d().h())));
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            boolean dealCheckUpdateLocalContact = dealCheckUpdateLocalContact(z16);
            QLog.i(TAG, 1, String.format("post dealCheckUpdateLocalContact() [beFirstQuery, queryFrom, deal]=[%b, %d, %b]", Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(dealCheckUpdateLocalContact)));
            if (!dealCheckUpdateLocalContact) {
                if (i3 == 2 || i3 == 23) {
                    checkUpdateBindStateAndList(false, true, i3);
                    return;
                }
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable(z16, i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.19
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f258392d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f258393e;

            {
                this.f258392d = z16;
                this.f258393e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, PhoneContactServiceImpl.this, Boolean.valueOf(z16), Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PhoneContactServiceImpl.this.checkUpdateLocalContact(this.f258392d, this.f258393e);
                }
            }
        }, 32, null, true);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void clearRecommendBadge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            ThreadManagerV2.executeOnNetWorkThread(this.mClearRecommendBadgeTask);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void deleteContactMatch(ContactMatch contactMatch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) contactMatch);
            return;
        }
        synchronized (this.mRecommendLock) {
            ArrayList<ContactMatch> arrayList = this.mContactMatch;
            if (arrayList != null) {
                arrayList.remove(contactMatch);
                this.f258386em.remove(contactMatch);
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void deletePhoneContactAddInfo(PhoneContactAdd phoneContactAdd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) phoneContactAdd);
            return;
        }
        synchronized (this.mRecommendLock) {
            ArrayList<PhoneContactAdd> arrayList = this.mPhoneContactAddList;
            if (arrayList != null) {
                arrayList.remove(phoneContactAdd);
                this.f258386em.remove(phoneContactAdd);
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void disableMobileMatch(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) str2);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 33);
        newIntent.putExtra("country_code", str);
        newIntent.putExtra("phone_number", str2);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean existContact(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Boolean) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "existContact " + str + ", " + str2);
        }
        boolean[] zArr = {false};
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, new b.C8219b(ContactsContract.Data.CONTENT_URI, new String[]{"raw_contact_id", "_id", "mimetype", StepCounterConstants.BEACON_PARAM_KEY_DATA1}, "mimetype='vnd.android.cursor.item/name' AND data1='" + str + "' AND " + StepCounterConstants.BEACON_PARAM_KEY_DATA2 + "='2'", null, null), new c(new String[]{str2}, str2, zArr), true);
        return zArr[0];
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void fillToMaxCountIfNeeded(ArrayList<PhoneContact> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) arrayList, i3);
            return;
        }
        for (PhoneContact phoneContact : this.contactCache.values()) {
            if (i3 != 0) {
                if (!TextUtils.isEmpty(phoneContact.uin) && !arrayList.contains(phoneContact)) {
                    i3--;
                    arrayList.add(phoneContact);
                }
            } else {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public ArrayList<PhoneContact> generateRandomList() {
        ArrayList<PhoneContact> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (ArrayList) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> bindNonfriendList = getBindNonfriendList(null);
        if (bindNonfriendList != null && !bindNonfriendList.isEmpty()) {
            IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) this.app.getRuntimeService(IAddFriendServiceApi.class, "");
            ArrayList<PhoneContact> arrayList2 = new ArrayList<>();
            for (PhoneContact phoneContact : bindNonfriendList) {
                if (phoneContact != null && phoneContact.samFriend > 0 && !iAddFriendServiceApi.hasSendAddFriendReq(phoneContact.unifiedCode, true)) {
                    arrayList2.add(phoneContact);
                }
            }
            if (arrayList2.size() < this.mStarRecommendCount) {
                arrayList = arrayList2;
            } else {
                arrayList = new ArrayList<>(this.mStarRecommendCount);
                for (int i3 = 0; i3 < this.mStarRecommendCount; i3++) {
                    arrayList.add(arrayList2.remove(this.mRandom.nextInt(arrayList2.size())));
                }
            }
            try {
                safeSort(arrayList, new com.tencent.mobileqq.phonecontact.util.c(new int[]{3, 4}, this.mLastLoginSet, this.app));
            } catch (IllegalArgumentException e16) {
                QLog.e(TAG, 1, "" + e16, e16);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("generateRandomList,[%s, %s, %s]", Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList2.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            }
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("generateRandomList,[%s, %s]", 0, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
        return new ArrayList<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getBannerState() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Integer) iPatchRedirector.redirect((short) 56, (Object) this)).intValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (QLog.isColorLevel()) {
            stringBuffer.append("getBannerState bind state = ");
            stringBuffer.append(getSelfBindState());
        }
        if (getSelfBindState() == 9) {
            if (QLog.isColorLevel()) {
                stringBuffer.append(" isCacheInited=");
                stringBuffer.append(this.isCacheInited);
            }
            if (this.isCacheInited) {
                if (this.contactCache.size() == 0) {
                    i3 = 1;
                }
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                stringBuffer.append(" ret=");
                stringBuffer.append(i3);
                QLog.d(TAG, 2, stringBuffer.toString());
            }
            return i3;
        }
        i3 = 2;
        if (QLog.isColorLevel()) {
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getBindAllFriendList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (List) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        List<PhoneContact> list = this.bindAllFriendList;
        if (list == null || list.isEmpty()) {
            list = initBindAllFriendList();
        }
        ArrayList arrayList = new ArrayList(list);
        try {
            safeSort(arrayList, new com.tencent.mobileqq.phonecontact.util.c(new int[]{6, 5, 1, 4}, this.mLastLoginSet, this.app));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getBindAllFriendList", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBindAllFriendList size = " + arrayList.size());
        }
        this.bindAllFriendList = arrayList;
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getBindHideNoneFriendList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, (Object) this, z16);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> list = this.bindNonFriendList;
        if (list == null) {
            list = initBindNonfriendList();
        }
        ArrayList arrayList = new ArrayList();
        for (PhoneContact phoneContact : list) {
            if (phoneContact.isHiden) {
                arrayList.add(phoneContact);
            }
        }
        if (z16) {
            safeSort(arrayList, new com.tencent.mobileqq.phonecontact.util.c(new int[]{1, 4}, null, null));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBindHideNoneFriendList cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", size = " + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getBindNonfriendList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) ? getBindNonfriendList(new int[]{1, 2, 4}) : (List) iPatchRedirector.redirect((short) 32, (Object) this);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<Object> getBindNonfriendListInObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) ? getBindNonfriendListInObject(new int[]{1, 2, 4}) : (List) iPatchRedirector.redirect((short) 33, (Object) this);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int getBindStateForServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Integer) iPatchRedirector.redirect((short) 62, (Object) this)).intValue();
        }
        if (getSelfBindState() <= 5) {
            return 2;
        }
        return 1;
    }

    public String getBindWording() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.pref.getString(KEY_BIND_WORDING, null);
    }

    public String getBlockMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pref.getString(KEY_BLOCK_MSG, null);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public com.tencent.mobileqq.phonecontact.data.a getContactBoundDataCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return (com.tencent.mobileqq.phonecontact.data.a) iPatchRedirector.redirect((short) 109, (Object) this);
        }
        return this.contactBindedDataCache;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getContactList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (List) iPatchRedirector.redirect((short) 53, (Object) this);
        }
        if (this.isCacheInited) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.addAll(this.contactCache.values());
                return arrayList;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16.toString());
                }
                return this.f258386em.query(PhoneContact.class);
            }
        }
        return this.f258386em.query(PhoneContact.class);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getContactListForContactListView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            return (List) iPatchRedirector.redirect((short) 87, (Object) this, z16);
        }
        if (this.mListForContactListView == null) {
            this.mListForContactListView = getContactListForContactListView(this.contactCache, z16);
        }
        return this.mListForContactListView;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<List<PhoneContact>> getContactListForDisplay() {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (List) iPatchRedirector.redirect((short) 54, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.destroyed) {
            return new ArrayList(0);
        }
        if (this.orderedBindList == null) {
            ArrayList<PhoneContact> arrayList = new ArrayList();
            arrayList.addAll(this.contactCache.values());
            safeSort(arrayList, new a());
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (arrayList.size() > 0) {
                if (getSelfBindInfo() == null) {
                    return null;
                }
                String str = getSelfBindInfo().mobileNo;
                PhoneContact phoneContact = null;
                for (PhoneContact phoneContact2 : arrayList) {
                    if (str == null || !str.endsWith(phoneContact2.mobileNo.trim())) {
                        PhoneContact phoneContact3 = (PhoneContact) phoneContact2.clone();
                        if (TextUtils.isEmpty(phoneContact3.uin)) {
                            if (phoneContact != null) {
                                if (phoneContact3.contactID == phoneContact.contactID) {
                                    phoneContact.mobileNo += "|" + phoneContact3.mobileNo;
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "getContactListForDisplay: conbine contact contact name is:" + phoneContact.name + "uin is :" + phoneContact.uin + "number is:" + phoneContact.mobileNo);
                                    }
                                } else {
                                    arrayList3.add(phoneContact);
                                }
                            }
                            phoneContact = phoneContact3;
                        } else {
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact3.uin);
                            if (phoneContact3.uin.equals("0")) {
                                friendsSimpleInfoWithUid = null;
                            } else {
                                friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
                            }
                            if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.f() >= 0) {
                                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                                aVar.d(uidFromUin);
                                phoneContact3.nickName = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                                phoneContact3.remark = friendsSimpleInfoWithUid.r();
                            } else {
                                phoneContact3.uin = "0";
                            }
                            arrayList2.add(phoneContact3);
                        }
                    }
                }
                if (phoneContact != null) {
                    arrayList3.add(phoneContact);
                }
                b bVar = new b();
                safeSort(arrayList2, bVar);
                safeSort(arrayList3, bVar);
            }
            this.orderedBindList = arrayList2;
            this.orderedNobindList = arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        removeDuplicate(this.orderedBindList);
        removeDuplicate(this.orderedNobindList);
        arrayList4.add(this.orderedBindList);
        arrayList4.add(this.orderedNobindList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sort contact cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return arrayList4;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getContactListForPhoneSelector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            return (List) iPatchRedirector.redirect((short) 86, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> list = this.mListForPhoneSelector;
        if (list == null || list.size() <= 0) {
            ArrayList<PhoneContact> arrayList = new ArrayList();
            for (PhoneContact phoneContact : this.contactCache.values()) {
                if (TextUtils.isEmpty(phoneContact.uin)) {
                    arrayList.add(phoneContact);
                } else if (!phoneContact.uin.equals("0")) {
                    if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact.uin), TAG) != null) {
                        arrayList.add(phoneContact);
                    }
                }
            }
            if (arrayList.size() > 0) {
                if (getSelfBindInfo() == null) {
                    return null;
                }
                arrayList.remove(queryPhoneContactByMobile(getSelfBindInfo().mobileNo));
                for (PhoneContact phoneContact2 : arrayList) {
                    if (phoneContact2.pinyinFirst == null) {
                        phoneContact2.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(phoneContact2.pinyinInitial);
                    }
                }
                safeSort(arrayList, new e());
            }
            this.mListForPhoneSelector = arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getContactListForPhoneSelector sort contact cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.mListForPhoneSelector;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getContactListForSelector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            return (List) iPatchRedirector.redirect((short) 85, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> list = this.mListForSelector;
        if (list == null || list.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.contactCache.values());
            if (arrayList.size() > 0) {
                if (getSelfBindInfo() == null) {
                    return null;
                }
                arrayList.remove(queryPhoneContactByMobile(getSelfBindInfo().mobileNo));
                safeSort(arrayList, new d());
            }
            this.mListForSelector = arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getContactListForSelector sort contact cost time: " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.mListForSelector;
    }

    public int getDetailedBindState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Integer) iPatchRedirector.redirect((short) 67, (Object) this)).intValue();
        }
        return this.mCurrentBindState;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public Object[] getFriendHasBindPhone() {
        String join;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return (Object[]) iPatchRedirector.redirect((short) 99, (Object) this);
        }
        if (this.mFrdHasBindPhoneTotalCount < 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
            if (defaultSharedPreferences != null) {
                String account = this.app.getAccount();
                this.mFrdHasBindPhoneTotalCount = defaultSharedPreferences.getInt(FRD_HAS_BIND_PHONE_COUNT_TAG + account, 0);
                String string = defaultSharedPreferences.getString(FRD_HAS_BIND_PHONE_SOME_TAG + account, "");
                if (string.length() > 0) {
                    String[] split = string.split("\\|");
                    if (split.length > 0) {
                        ArrayList arrayList = new ArrayList(split.length);
                        this.mSomeFrdHasBindPhone = arrayList;
                        Collections.addAll(arrayList, split);
                    }
                }
            } else {
                this.mFrdHasBindPhoneTotalCount = 0;
                this.mSomeFrdHasBindPhone = null;
            }
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.mFrdHasBindPhoneTotalCount);
            List<String> list = this.mSomeFrdHasBindPhone;
            if (list == null) {
                join = "null";
            } else {
                join = TextUtils.join(",", list);
            }
            objArr[1] = join;
            QLog.i(TAG, 2, String.format("getFriendHasBindPhone [%s, %s]", objArr));
        }
        return new Object[]{Integer.valueOf(this.mFrdHasBindPhoneTotalCount), this.mSomeFrdHasBindPhone};
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public long getLastLoginType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).longValue();
        }
        if (this.mLastLoginSet.contains(str)) {
            return 1L;
        }
        return 10L;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public ArrayList<PhoneContactAdd> getPhoneContactAddList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (ArrayList) iPatchRedirector.redirect((short) 48, (Object) this);
        }
        return this.mPhoneContactAddList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public PhoneContact getPhoneContactByMD5(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return (PhoneContact) iPatchRedirector.redirect((short) 107, (Object) this, (Object) str);
        }
        return this.md52PhoneContact.get(str);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public String getPhoneNumByUin(String str) {
        EntityManager createEntityManager;
        PhoneNumInfo phoneNumInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            return (String) iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
        }
        if (str != null && str.length() != 0) {
            String str2 = this.uinToPhoneNumMap.get(str);
            if (str2 != null) {
                return str2;
            }
            AppInterface appInterface = this.app;
            if (appInterface == null) {
                createEntityManager = null;
            } else {
                createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            }
            if (createEntityManager != null && (phoneNumInfo = (PhoneNumInfo) DBMethodProxy.find(createEntityManager, PhoneNumInfo.class, "uin=?", new String[]{str})) != null) {
                return phoneNumInfo.phoneNum;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public ArrayList<Entity> getRecommendContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (ArrayList) iPatchRedirector.redirect((short) 45, (Object) this);
        }
        ArrayList<Entity> arrayList = new ArrayList<>();
        synchronized (this.mRecommendLock) {
            ContactBinded contactBinded = this.mContactBinded;
            if (contactBinded != null) {
                arrayList.add(contactBinded);
            }
            ArrayList<ContactMatch> arrayList2 = this.mContactMatch;
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.addAll(this.mContactMatch);
                if (QLog.isColorLevel()) {
                    Iterator<ContactMatch> it = this.mContactMatch.iterator();
                    while (it.hasNext()) {
                        QLog.d(TAG, 2, "getRecommendContact|mobileNo : " + it.next().mobileNo + "|size : " + this.mContactMatch.size());
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int getRecommendUnreadCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        return getRecommendUnreadList().size();
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getRecommendUnreadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (List) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        List<PhoneContact> list = this.bindNonFriendList;
        if (list == null) {
            list = initBindNonfriendList();
        }
        ArrayList arrayList = new ArrayList();
        for (PhoneContact phoneContact : list) {
            if (phoneContact.isNewRecommend) {
                arrayList.add(phoneContact);
            }
        }
        this.bindNonFriendList = list;
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public RespondQueryQQBindingStat getSelfBindInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            return (RespondQueryQQBindingStat) iPatchRedirector.redirect((short) 69, (Object) this);
        }
        if (this.destroyed) {
            return null;
        }
        RespondQueryQQBindingStat respondQueryQQBindingStat = new RespondQueryQQBindingStat();
        SharedPreferences c16 = com.tencent.mobileqq.phonecontact.nt.b.f258483a.c(ServiceConst.PARA_SESSION_ID);
        if (c16 == null) {
            return null;
        }
        respondQueryQQBindingStat.nationCode = c16.getString(AppConstants.Preferences.CONTACT_BIND_INFO_NATION, null);
        respondQueryQQBindingStat.mobileNo = c16.getString(AppConstants.Preferences.CONTACT_BIND_INFO_MOBILE, "");
        respondQueryQQBindingStat.MobileUniqueNo = c16.getString(AppConstants.Preferences.CONTACT_BIND_INFO_IMEI, "");
        respondQueryQQBindingStat.isRecommend = c16.getLong(AppConstants.Preferences.CONTACT_BIND_INFO_RECOMMEND, 0L);
        respondQueryQQBindingStat.originBinder = c16.getLong(AppConstants.Preferences.CONTACT_BIND_INFO_ORIGIN, 0L);
        respondQueryQQBindingStat.bindingTime = c16.getLong(AppConstants.Preferences.CONTACT_BIND_INFO_TIME, 0L);
        respondQueryQQBindingStat.lastUsedFlag = c16.getLong(AppConstants.Preferences.CONTACT_BIND_INFO_FLAG, 0L);
        respondQueryQQBindingStat.type = c16.getInt(AppConstants.Preferences.CONTACT_BIND_TYPE, 0);
        respondQueryQQBindingStat.isStopFindMatch = c16.getBoolean(AppConstants.Preferences.CONTACT_BIND_IS_STOP_FIND_MATCH, false);
        respondQueryQQBindingStat.noBindUploadContacts = c16.getBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_UPLOAD, false);
        respondQueryQQBindingStat.noBindUploadContactsLocal = c16.getBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_UPLOAD_LOCAL, false);
        respondQueryQQBindingStat.continueUploadNotbind = c16.getBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_CONTINUE_UPLOAD, false);
        respondQueryQQBindingStat.isPhoneSwitched = c16.getBoolean(AppConstants.Preferences.CONTACT_BIND_IS_PHONE_SWITCHED, false);
        return respondQueryQQBindingStat;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int getSelfBindState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Integer) iPatchRedirector.redirect((short) 66, (Object) this)).intValue();
        }
        switch (this.mCurrentBindState) {
            case -1:
                this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
                return getSelfBindState();
            case 0:
            default:
                return 0;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return this.mCurrentBindState;
            case 8:
                return 8;
            case 9:
                return 9;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public long getUIBits() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return ((Long) iPatchRedirector.redirect((short) 112, (Object) this)).longValue();
        }
        return this.mUIBits;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public String getUNIQUE_NO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.UNIQUE_NO == null) {
            synchronized (TAG) {
                if (this.UNIQUE_NO == null) {
                    this.UNIQUE_NO = initUniqueString();
                }
            }
        }
        return this.UNIQUE_NO;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public String getUinByPhoneNum(String str) {
        EntityManager createEntityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return (String) iPatchRedirector.redirect((short) 77, (Object) this, (Object) str);
        }
        if (this.destroyed || str == null) {
            return null;
        }
        if (!this.phoneNumToUinMap.containsKey(str)) {
            AppInterface appInterface = this.app;
            if (appInterface == null) {
                createEntityManager = null;
            } else {
                createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            }
            if (createEntityManager == null) {
                return null;
            }
            PhoneNumInfo phoneNumInfo = (PhoneNumInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PhoneNumInfo.class, str);
            if (phoneNumInfo != null) {
                this.phoneNumToUinMap.put(str, phoneNumInfo.uin);
                this.uinToPhoneNumMap.put(phoneNumInfo.uin, str);
            }
            createEntityManager.close();
        }
        return this.phoneNumToUinMap.get(str);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int getUploadPackages() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return ((Integer) iPatchRedirector.redirect((short) 111, (Object) this)).intValue();
        }
        return this.mUploadPackages;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int getsAllEntranceConfigVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Integer) iPatchRedirector.redirect((short) 94, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.phonecontact.nt.b.f258483a.e(KEY_CONFIG_VERSION, 0);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void hideContact(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hideContact mobile=" + str + "; hide=" + z16);
        }
        PhoneContact queryContactByCodeNumber = queryContactByCodeNumber(str);
        if (queryContactByCodeNumber != null) {
            AddressBookItem addressBookItem = new AddressBookItem(queryContactByCodeNumber.mobileNo, queryContactByCodeNumber.name);
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 34);
            newIntent.putExtra("param_hiden_mobile", addressBookItem);
            newIntent.putExtra("param_hiden_flag", z16);
            newIntent.putExtra("unique_phone_no", str);
            this.app.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void initContactCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!this.isCacheInited) {
            this.contactCache.clear();
            this.contactCacheByUin.clear();
            this.contactCacheByCodeNumber.clear();
            this.md52PhoneContact.clear();
            List<? extends Entity> query = this.f258386em.query(PhoneContact.class);
            if (query != null) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    PhoneContact phoneContact = (PhoneContact) it.next();
                    phoneContact.pinyinFirst = com.tencent.mobileqq.phonecontact.util.d.c(phoneContact.pinyinInitial);
                    this.contactCache.put(phoneContact.mobileNo, phoneContact);
                    if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
                        this.contactCacheByUin.put(phoneContact.uin, phoneContact);
                    }
                    if (!TextUtils.isEmpty(phoneContact.unifiedCode)) {
                        this.contactCacheByCodeNumber.put(phoneContact.unifiedCode, phoneContact);
                    }
                    if (!TextUtils.isEmpty(phoneContact.md5)) {
                        this.md52PhoneContact.put(phoneContact.md5, phoneContact);
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "No contacts.");
            }
            synchronized (this.mRecommendLock) {
                this.mContactMatch = (ArrayList) this.f258386em.query(ContactMatch.class, false, null, null, null, null, null, null);
                this.mPhoneContactAddList = (ArrayList) this.f258386em.query(PhoneContactAdd.class, false, null, null, null, null, null, null);
            }
            sAllEntranceNum = com.tencent.mobileqq.phonecontact.nt.b.f258483a.e(KEY_ALL_ENTRANCE_NUM, 20);
            initLastLoginList();
            this.isCacheInited = true;
            notifyContactChanged(1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("initContactCache [%s]", Integer.valueOf(sAllEntranceNum)));
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean isAutoUploadContacts() {
        RespondQueryQQBindingStat selfBindInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            return ((Boolean) iPatchRedirector.redirect((short) 81, (Object) this)).booleanValue();
        }
        if (this.mCurrentBindState == 8) {
            return true;
        }
        if (this.mCurrentBindState == 6) {
            if (getSelfBindInfo() != null && getSelfBindInfo().lastUsedFlag == 2) {
                return true;
            }
            return false;
        }
        if (this.mCurrentBindState == 7 && (selfBindInfo = getSelfBindInfo()) != null) {
            return !selfBindInfo.isStopFindMatch;
        }
        return false;
    }

    public boolean isAutoUploadContactsNotBind() {
        RespondQueryQQBindingStat selfBindInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            return ((Boolean) iPatchRedirector.redirect((short) 80, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (this.mCurrentBindState == 4) {
            selfBindInfo = null;
        } else {
            selfBindInfo = getSelfBindInfo();
            if (this.mCurrentBindState != 3 ? selfBindInfo == null || !selfBindInfo.continueUploadNotbind : selfBindInfo == null || getSelfBindInfo().lastUsedFlag != 2) {
                z16 = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isAutoUploadContactsNotBind| result: " + z16 + ", selfBindInfo: " + selfBindInfo + ", bindState: " + this.mCurrentBindState);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean isBindContactOk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return ((Boolean) iPatchRedirector.redirect((short) 79, (Object) this)).booleanValue();
        }
        int selfBindState = getSelfBindState();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isBindContactOk = " + selfBindState);
        }
        if (selfBindState >= 9) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean isBindNoneFriendListEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.bindNonFriendList == null) {
            this.bindNonFriendList = initBindNonfriendList();
        }
        if (this.bindNonFriendList != null && !this.bindNonFriendList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean isBindedIgnoreUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Boolean) iPatchRedirector.redirect((short) 90, (Object) this)).booleanValue();
        }
        if (getSelfBindState() > 5) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean isDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            return ((Boolean) iPatchRedirector.redirect((short) 84, (Object) this)).booleanValue();
        }
        return this.destroyed;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int loadContactFriendList(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this, (Object) list)).intValue();
        }
        RespondQueryQQBindingStat selfBindInfo = getSelfBindInfo();
        if (selfBindInfo == null) {
            return RESULT_FAIL;
        }
        l lVar = this.mLoadContactFriendTask;
        if (lVar != null) {
            lVar.cancel(true);
        }
        l lVar2 = new l(this, null);
        this.mLoadContactFriendTask = lVar2;
        lVar2.c(list);
        this.mLoadContactFriendTask.execute(selfBindInfo);
        return RESULT_OK;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public Map<String, PhoneContact> loadContactFromPhoneWithoutCaches() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Map) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        b.C8219b c8219b = new b.C8219b(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONES_PROJECTION, null, null, null);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        com.tencent.mobileqq.phonecontact.api.impl.b.a(this.app, c8219b, new j(concurrentHashMap), true);
        return concurrentHashMap;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void makePhoneContactAddInfo(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "makePhoneContactAddInfo|unifiedCode : " + str + "|friendSetting : " + i3 + "|remark : " + str2);
        }
        if (i3 != 1 && i3 != 4) {
            return;
        }
        synchronized (this.mRecommendLock) {
            try {
                ArrayList arrayList = new ArrayList();
                ArrayList<PhoneContactAdd> arrayList2 = this.mPhoneContactAddList;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    Iterator<PhoneContactAdd> it = this.mPhoneContactAddList.iterator();
                    while (it.hasNext()) {
                        PhoneContactAdd next = it.next();
                        if (next.unifiedCode.equals(str)) {
                            next.timestamp = com.tencent.mobileqq.service.message.e.K0();
                            arrayList.addAll(updateEntity(next));
                            break;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                    PhoneContactAdd phoneContactAdd = new PhoneContactAdd();
                    phoneContactAdd.name = str2;
                    phoneContactAdd.unifiedCode = str;
                    phoneContactAdd.timestamp = com.tencent.mobileqq.service.message.e.K0();
                    if (i3 == 1) {
                        phoneContactAdd.remindInfo = BaseApplication.getContext().getResources().getString(R.string.csg);
                    } else if (i3 == 4) {
                        phoneContactAdd.remindInfo = this.app.getApp().getApplicationContext().getResources().getString(R.string.csh);
                    }
                    if (this.mPhoneContactAddList == null) {
                        this.mPhoneContactAddList = new ArrayList<>();
                    }
                    this.mPhoneContactAddList.add(phoneContactAdd);
                    arrayList.addAll(updateEntity(phoneContactAdd));
                }
                ArrayList<ContactMatch> arrayList3 = this.mContactMatch;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    Iterator<ContactMatch> it5 = this.mContactMatch.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        ContactMatch next2 = it5.next();
                        if (next2.unifiedCode.equals(str)) {
                            it5.remove();
                            arrayList.add(new RemoveTransaction(next2));
                            break;
                        }
                    }
                }
                this.f258386em.doMultiDBOperateByTransaction(arrayList);
            } catch (Resources.NotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "makePhoneContactAddInfo", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void markAndUploadForNewGuide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this);
            return;
        }
        int selfBindState = getSelfBindState();
        if (selfBindState > 5) {
            if (selfBindState == 9) {
                this.mIsUploadForNewGuide = false;
                if (!this.isCacheInited) {
                    initContactCache();
                }
                saveUploadDataForNewGuide(3, this.contactCache.size(), 100, 100);
            } else {
                this.mIsUploadForNewGuide = true;
                uploadPhoneContact();
            }
        } else if (selfBindState == 2) {
            this.mIsUploadForNewGuide = false;
            if (!this.isCacheInited) {
                initContactCache();
            }
            saveUploadDataForNewGuide(3, this.contactCache.size(), 100, 100);
        } else {
            this.mIsUploadForNewGuide = true;
            uploadPhoneContactNotBind();
        }
        QLog.i("BindMsgConstant", 1, String.format("markAndUploadForNewGuide [%s, %s]", Integer.valueOf(selfBindState), Boolean.valueOf(this.mIsUploadForNewGuide)));
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void markOrClearUserSettingFlag(boolean z16) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this, z16);
            return;
        }
        if (z16) {
            j3 = com.tencent.mobileqq.service.message.e.K0();
        } else {
            j3 = 0;
        }
        this.mUserSettingFlag = j3;
        com.tencent.mobileqq.phonecontact.nt.b.f258483a.f(USER_SETTING_FLAG + this.app.getAccount(), this.mUserSettingFlag);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("markOrClearUserSettingFlag [%s]", Long.valueOf(this.mUserSettingFlag)));
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void markRecommendReaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
            return;
        }
        synchronized (this.mRecommendLock) {
            try {
                ContactBinded contactBinded = this.mContactBinded;
                if (contactBinded != null) {
                    contactBinded.isReaded = true;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList<ContactMatch> arrayList2 = this.mContactMatch;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<ContactMatch> it = this.mContactMatch.iterator();
                    while (it.hasNext()) {
                        ContactMatch next = it.next();
                        next.isReaded = true;
                        arrayList.addAll(updateEntity(next));
                    }
                }
                this.f258386em.doMultiDBOperateByTransaction(arrayList);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "markAllDataReaded", e16);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public synchronized void markUploadedContact(List<AddressBookItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) list);
            return;
        }
        if (this.destroyed) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<AddressBookItem> it = list.iterator();
            while (it.hasNext()) {
                PhoneContact phoneContact = this.contactCache.get(it.next().mobileNo);
                if (phoneContact != null) {
                    phoneContact.isUploaded = true;
                    arrayList.add(new UpdateTransaction(phoneContact));
                }
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList);
            this.mUploadPackages++;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public synchronized void markUploadedContactNotBind(List<AddressBookItem> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) list);
            return;
        }
        if (this.destroyed) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<AddressBookItem> it = list.iterator();
            while (it.hasNext()) {
                PhoneContact phoneContact = this.contactCache.get(it.next().mobileNo);
                if (phoneContact != null) {
                    phoneContact.isUploaded = true;
                    arrayList.add(new UpdateTransaction(phoneContact));
                }
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList);
            this.mUploadPackages++;
        }
    }

    public void multiMakePhoneContactAddInfo(ArrayList<PhoneContact> arrayList, ArrayList<AddBatchPhoneFriendResult> arrayList2, int i3) {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, arrayList, arrayList2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("multiMakePhoneContactAddInfo|sourceId : ");
            sb5.append(i3);
            if (arrayList == null) {
                str = "|phoneList is null";
            } else {
                str = "|phoneList.size : " + arrayList.size();
            }
            sb5.append(str);
            if (arrayList2 == null) {
                str2 = "|addlist is null";
            } else {
                str2 = "|addlist.size : " + arrayList2.size();
            }
            sb5.append(str2);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (arrayList != null && !arrayList.isEmpty() && arrayList2 != null && !arrayList2.isEmpty()) {
            if (i3 != 3078 && i3 != 3079) {
                return;
            }
            synchronized (this.mRecommendLock) {
                try {
                    ArrayList<PhoneContactAdd> arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    if (this.mPhoneContactAddList == null) {
                        this.mPhoneContactAddList = new ArrayList<>(arrayList3.size());
                    }
                    Iterator<AddBatchPhoneFriendResult> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        AddBatchPhoneFriendResult next = it.next();
                        if (next.sendResult == 0) {
                            Iterator<PhoneContactAdd> it5 = this.mPhoneContactAddList.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    PhoneContactAdd next2 = it5.next();
                                    if (next2.unifiedCode.equals(next.mobile)) {
                                        next2.timestamp = com.tencent.mobileqq.service.message.e.K0();
                                        arrayList4.addAll(updateEntity(next2));
                                        z16 = false;
                                        break;
                                    }
                                } else {
                                    z16 = true;
                                    break;
                                }
                            }
                            if (z16) {
                                PhoneContactAdd phoneContactAdd = new PhoneContactAdd();
                                phoneContactAdd.unifiedCode = next.mobile;
                                phoneContactAdd.timestamp = com.tencent.mobileqq.service.message.e.K0();
                                phoneContactAdd.remindInfo = this.app.getApp().getApplicationContext().getResources().getString(R.string.csg);
                                arrayList3.add(phoneContactAdd);
                            }
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        for (PhoneContactAdd phoneContactAdd2 : arrayList3) {
                            Iterator<PhoneContact> it6 = arrayList.iterator();
                            while (it6.hasNext()) {
                                PhoneContact next3 = it6.next();
                                if (next3.unifiedCode.equals(phoneContactAdd2.unifiedCode)) {
                                    String str3 = next3.name;
                                    if (str3 == null) {
                                        str3 = next3.nickName;
                                    }
                                    phoneContactAdd2.name = str3;
                                    arrayList4.addAll(updateEntity(phoneContactAdd2));
                                }
                            }
                        }
                        this.mPhoneContactAddList.addAll(arrayList3);
                        ArrayList<ContactMatch> arrayList5 = this.mContactMatch;
                        if (arrayList5 != null && !arrayList5.isEmpty()) {
                            Iterator<ContactMatch> it7 = this.mContactMatch.iterator();
                            while (it7.hasNext()) {
                                ContactMatch next4 = it7.next();
                                Iterator it8 = arrayList3.iterator();
                                while (true) {
                                    if (!it8.hasNext()) {
                                        break;
                                    }
                                    if (next4.unifiedCode.equals(((PhoneContactAdd) it8.next()).unifiedCode)) {
                                        it7.remove();
                                        arrayList4.add(new RemoveTransaction(next4));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    this.f258386em.doMultiDBOperateByTransaction(arrayList4);
                } catch (Resources.NotFoundException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "multiMakePhoneContactAddInfo", e16);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean needShowToastWhenUpload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return ((Boolean) iPatchRedirector.redirect((short) 115, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean needUploadContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            return ((Boolean) iPatchRedirector.redirect((short) 102, (Object) this)).booleanValue();
        }
        int selfBindState = getSelfBindState();
        boolean z16 = true;
        if (selfBindState != 6 && selfBindState != 7 && selfBindState != 5 && selfBindState != 1 && selfBindState != 3) {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "needUploadContact [" + selfBindState + ", " + z16 + "]");
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void notifyContactChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            notifyContactChanged(1);
        } else {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void onAppRunBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            ContactSyncLimitManager.d().l(false);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void onAppRunForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        ContactSyncLimitManager.d().l(true);
        if (!com.tencent.mobileqq.phonecontact.util.e.a()) {
            checkUpdateLocalContact(false, 23);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        AppInterface appInterface = (AppInterface) appRuntime;
        this.app = appInterface;
        this.mInjectProcessor = com.tencent.mobileqq.phonecontact.processor.b.a(appInterface);
        com.tencent.mobileqq.phonecontact.nt.b bVar = com.tencent.mobileqq.phonecontact.nt.b.f258483a;
        SharedPreferences c16 = bVar.c(ServiceConst.PARA_SESSION_ID);
        this.pref = c16;
        if (c16 != null) {
            this.sessionId = c16.getString(ServiceConst.PARA_SESSION_ID, "").getBytes();
        }
        this.contactListQueryTimeStamp = bVar.d(AppConstants.Preferences.CONTACT_LAST_QUERY_TIME, 0L);
        this.mLastUnbindMobileTime = bVar.d(KEY_LAST_UNBIND_MOBILE_TIME, 0L);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("init [%s, %s]", Long.valueOf(this.contactListQueryTimeStamp), Long.valueOf(this.mLastUnbindMobileTime)));
        }
        initQueryInterval();
        this.mUserSettingFlag = bVar.b(USER_SETTING_FLAG + this.app.getAccount(), 0L);
        this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
        this.f258386em = this.app.getEntityManagerFactory().createEntityManager();
        this.app.registObserver(this.contactOb);
        this.app.addObserver(this.mContactBindObserver2);
        this.mRandom = new Random(SystemClock.elapsedRealtime());
        DisplayMetrics displayMetrics = this.app.getApplication().getResources().getDisplayMetrics();
        if (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) >= 1080) {
            i3 = 5;
        } else {
            i3 = 4;
        }
        this.mStarRecommendCount = i3;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                phoneContactServiceImpl.UNIQUE_NO = phoneContactServiceImpl.getUNIQUE_NO();
                PhoneContactServiceImpl.this.registContentObserver();
                PhoneContactServiceImpl phoneContactServiceImpl2 = PhoneContactServiceImpl.this;
                phoneContactServiceImpl2.mUIBits = phoneContactServiceImpl2.pref.getLong(PhoneContactServiceImpl.KEY_CONTACTS_SWITCHES, 0L);
                if (PhoneContactServiceImpl.this.app != null) {
                    ContactSyncServiceImpl.getService(PhoneContactServiceImpl.this.app);
                }
                PermissionChecker.h().f();
            }
        }, 16, null, false);
        ContactSyncLimitManager.d().f(this.app);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
            return;
        }
        this.destroyed = true;
        this.orderedNobindList = null;
        this.orderedBindList = null;
        this.mListForSelector = null;
        this.mListForContactListView = null;
        this.app.unRegistObserver(this.contactOb);
        this.app.removeObserver(this.mContactBindObserver2);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        unRegistContentObservers();
        this.mCurrentBindState = -1;
        this.isCacheInited = false;
        PermissionChecker.h().i();
        com.tencent.mobileqq.phonecontact.processor.a aVar = this.mInjectProcessor;
        if (aVar != null) {
            aVar.onDestroy();
            this.mInjectProcessor = null;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void onFriendListChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            checkUpdateBindStateAndListIgnoreBindState(true, true, 14);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void onGetFriendsHasBindPhone(int i3, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, i3, (Object) list);
            return;
        }
        this.mFrdHasBindPhoneTotalCount = i3;
        this.mSomeFrdHasBindPhone = list;
        StringBuilder sb5 = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                if (str != null) {
                    if (sb5.length() > 0) {
                        sb5.append("|");
                    }
                    sb5.append(str);
                }
            }
        }
        String account = this.app.getAccount();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.edit().putInt(FRD_HAS_BIND_PHONE_COUNT_TAG + account, this.mFrdHasBindPhoneTotalCount).putString(FRD_HAS_BIND_PHONE_SOME_TAG + account, sb5.toString()).apply();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("onGetFriendsHasBindPhone [%s, %s]", Integer.valueOf(this.mFrdHasBindPhoneTotalCount), sb5.toString()));
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public PhoneContact queryContactByCodeNumber(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            return (PhoneContact) iPatchRedirector.redirect((short) 73, (Object) this, (Object) str);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "queryContactByCodeNumber codeNumber is null");
            }
            return null;
        }
        if (this.isCacheInited) {
            return this.contactCacheByCodeNumber.get(str);
        }
        EntityManager entityManager = this.f258386em;
        if (entityManager == null) {
            return null;
        }
        return (PhoneContact) DBMethodProxy.find(entityManager, PhoneContact.class, "mobileCode=?", new String[]{str});
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public PhoneContact queryPhoneContactByMobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            return (PhoneContact) iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        }
        if (this.isCacheInited) {
            return this.contactCache.get(str);
        }
        if (this.f258386em != null) {
            return (PhoneContact) this.f258386em.doFindOperateByTransaction(new FindTransaction((Class<? extends Entity>) PhoneContact.class, str));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public PhoneContact queryPhoneContactByUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return (PhoneContact) iPatchRedirector.redirect((short) 71, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            return this.contactCacheByUin.get(str);
        }
        return null;
    }

    public void removeDuplicate(List<PhoneContact> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (PhoneContact phoneContact : list) {
                String str = phoneContact.mobileCode;
                if (!TextUtils.isEmpty(phoneContact.uin)) {
                    arrayList.add(str);
                } else {
                    ArrayList arrayList2 = (ArrayList) hashMap.get(str);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(str, arrayList2);
                    }
                    arrayList2.add(phoneContact);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get((String) it.next());
                if (arrayList3 != null) {
                    Iterator it5 = arrayList3.iterator();
                    while (it5.hasNext()) {
                        list.remove((PhoneContact) it5.next());
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void removeListener(od2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) aVar);
            return;
        }
        synchronized (this.mListenerList) {
            this.mListenerList.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void saveBindConfig(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveBindConfig style:" + i3 + " wording:" + str + " blockMsg:" + str2);
        }
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putInt(KEY_BIND_STYLE, i3);
        edit.putString(KEY_BIND_WORDING, str);
        edit.putString(KEY_BLOCK_MSG, str2);
        edit.commit();
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean saveBindInfo(RespondQueryQQBindingStat respondQueryQQBindingStat, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            return ((Boolean) iPatchRedirector.redirect((short) 68, (Object) this, (Object) respondQueryQQBindingStat, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (this.destroyed) {
            return false;
        }
        if (this.mCurrentBindState == -1) {
            this.mCurrentBindState = getSelfBindState(getSelfBindInfo());
        }
        if (this.mCurrentBindState != getSelfBindState(respondQueryQQBindingStat)) {
            z16 = true;
        }
        if (respondQueryQQBindingStat == null) {
            respondQueryQQBindingStat = new RespondQueryQQBindingStat();
        }
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString(AppConstants.Preferences.CONTACT_BIND_INFO_MOBILE, respondQueryQQBindingStat.mobileNo);
        edit.putString(AppConstants.Preferences.CONTACT_BIND_INFO_NATION, respondQueryQQBindingStat.nationCode);
        edit.putString(AppConstants.Preferences.CONTACT_BIND_INFO_IMEI, respondQueryQQBindingStat.MobileUniqueNo);
        edit.putLong(AppConstants.Preferences.CONTACT_BIND_INFO_RECOMMEND, respondQueryQQBindingStat.isRecommend);
        edit.putLong(AppConstants.Preferences.CONTACT_BIND_INFO_ORIGIN, respondQueryQQBindingStat.originBinder);
        edit.putLong(AppConstants.Preferences.CONTACT_BIND_INFO_TIME, respondQueryQQBindingStat.bindingTime);
        edit.putLong(AppConstants.Preferences.CONTACT_BIND_INFO_FLAG, respondQueryQQBindingStat.lastUsedFlag);
        edit.putInt(AppConstants.Preferences.CONTACT_BIND_TYPE, respondQueryQQBindingStat.type);
        edit.putBoolean(AppConstants.Preferences.CONTACT_BIND_IS_STOP_FIND_MATCH, respondQueryQQBindingStat.isStopFindMatch);
        edit.putBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_UPLOAD, respondQueryQQBindingStat.noBindUploadContacts);
        edit.putBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_UPLOAD_LOCAL, respondQueryQQBindingStat.noBindUploadContactsLocal);
        edit.putBoolean(AppConstants.Preferences.CONTACT_BIND_IS_PHONE_SWITCHED, respondQueryQQBindingStat.isPhoneSwitched);
        this.isPhoneSwitched = respondQueryQQBindingStat.isPhoneSwitched;
        edit.commit();
        syncBindState(respondQueryQQBindingStat);
        return z16;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int saveContactFromServer(boolean z16, int i3, long j3, boolean z17, long j16, long j17, List<MobileContactsFriendInfo> list, List<MobileContactsNotFriendInfo> list2) {
        boolean z18;
        boolean z19;
        boolean z26;
        int i16;
        boolean z27;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z28 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Integer) iPatchRedirector.redirect((short) 61, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z17), Long.valueOf(j16), Long.valueOf(j17), list, list2)).intValue();
        }
        if (this.destroyed) {
            return 0;
        }
        QLog.isColorLevel();
        List<MobileContactsFriendInfo> list3 = this.respBindFriendList_V2;
        if (list3 == null) {
            this.respBindFriendList_V2 = list;
        } else {
            list3.addAll(list);
        }
        List<MobileContactsNotFriendInfo> list4 = this.respBindStrangerList_V2;
        if (list4 == null) {
            this.respBindStrangerList_V2 = list2;
        } else {
            list4.addAll(list2);
        }
        if (j3 != 4294967295L && !z16) {
            return 0;
        }
        this.pref.getLong("queryContactTimeStamp", 0L);
        this.pref.getLong("queryRichInfoTimeStamp", 0L);
        if (QLog.isColorLevel()) {
            List<MobileContactsFriendInfo> list5 = this.respBindFriendList_V2;
            if (list5 != null) {
                list5.size();
            }
            List<MobileContactsNotFriendInfo> list6 = this.respBindStrangerList_V2;
            if (list6 != null) {
                list6.size();
            }
        }
        if (!this.isCacheInited) {
            initContactCache();
        }
        if ((i3 == 0 && z16) || !z16) {
            beforeSaveContactFromServer(z17);
        }
        List<MobileContactsFriendInfo> list7 = this.respBindFriendList_V2;
        if (list7 != null && list7.size() > 0) {
            IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) this.app.getRuntimeService(IAddFriendServiceApi.class, "");
            ArrayList arrayList = new ArrayList();
            z19 = false;
            for (MobileContactsFriendInfo mobileContactsFriendInfo : this.respBindFriendList_V2) {
                PhoneContact phoneContact = this.md52PhoneContact.get(mobileContactsFriendInfo.contactsInfoEncrypt.toUpperCase());
                if (phoneContact != null) {
                    resetContact(phoneContact, z17);
                    phoneContact.uin = mobileContactsFriendInfo.QQ;
                    phoneContact.bindingDate = mobileContactsFriendInfo.bindingDate;
                    phoneContact.isUploaded = true;
                    phoneContact.originBinder = mobileContactsFriendInfo.originBinder;
                    phoneContact.ability = mobileContactsFriendInfo.accountAbi;
                    String a16 = PhoneContactUtils.a(mobileContactsFriendInfo.MobileNoMask, phoneContact.mobileNo);
                    phoneContact.unifiedCode = a16;
                    phoneContact.mobileCode = a16;
                    phoneContact.nationCode = "";
                    if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact.uin), TAG);
                        if (friendsSimpleInfoWithUid != null) {
                            phoneContact.nickName = friendsSimpleInfoWithUid.p();
                        }
                        this.contactCacheByUin.put(phoneContact.uin, phoneContact);
                        z27 = false;
                        iAddFriendServiceApi.setAddFriendReqStatus(phoneContact.unifiedCode, false);
                    } else {
                        z27 = false;
                    }
                    if (!TextUtils.isEmpty(phoneContact.unifiedCode)) {
                        this.contactCacheByCodeNumber.put(phoneContact.unifiedCode, phoneContact);
                    }
                    this.tmpContactCache.remove(phoneContact.mobileNo);
                    arrayList.add(new UpdateTransaction(phoneContact));
                    z19 = true;
                } else {
                    z27 = z28;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "bind friend not found, " + mobileContactsFriendInfo.contactsInfoEncrypt);
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("MobileContactsFriendInfo;");
                    if (phoneContact == null) {
                        str = "null";
                    } else {
                        str = phoneContact.unifiedCode;
                    }
                    sb5.append(str);
                    QLog.d(TAG, 2, sb5.toString());
                }
                z28 = z27;
            }
            z18 = z28;
            this.f258386em.doMultiDBOperateByTransaction(arrayList);
        } else {
            z18 = false;
            z19 = false;
        }
        List<MobileContactsNotFriendInfo> list8 = this.respBindStrangerList_V2;
        if (list8 != null && list8.size() > 0) {
            ArrayList arrayList2 = new ArrayList(this.respBindStrangerList_V2.size());
            ArrayList arrayList3 = new ArrayList();
            z26 = z18;
            for (MobileContactsNotFriendInfo mobileContactsNotFriendInfo : this.respBindStrangerList_V2) {
                PhoneContact phoneContact2 = this.md52PhoneContact.get(mobileContactsNotFriendInfo.contactsInfoEncrypt.toUpperCase());
                if (phoneContact2 != null) {
                    resetContact(phoneContact2, z17);
                    if (z17) {
                        phoneContact2.uin = "0";
                        phoneContact2.bindingDate = mobileContactsNotFriendInfo.bindingDate;
                        phoneContact2.nickName = mobileContactsNotFriendInfo.nickname;
                        phoneContact2.isUploaded = true;
                        phoneContact2.originBinder = mobileContactsNotFriendInfo.originBinder;
                        phoneContact2.ability = mobileContactsNotFriendInfo.accountAbi;
                        String a17 = PhoneContactUtils.a(mobileContactsNotFriendInfo.MobileNoMask, phoneContact2.mobileNo);
                        phoneContact2.unifiedCode = a17;
                        phoneContact2.mobileCode = a17;
                        phoneContact2.nationCode = "";
                        phoneContact2.age = mobileContactsNotFriendInfo.age;
                        phoneContact2.sex = mobileContactsNotFriendInfo.sex;
                        phoneContact2.samFriend = mobileContactsNotFriendInfo.sameFriend;
                        if (mobileContactsNotFriendInfo.isNew) {
                            phoneContact2.isNewRecommend = true;
                            this.recommendMobiles.add(phoneContact2);
                            z26 = true;
                        }
                    }
                    if (mobileContactsNotFriendInfo.isUpdateSign) {
                        phoneContact2.setRichBuffer(mobileContactsNotFriendInfo.personalSign, mobileContactsNotFriendInfo.richTime);
                    }
                    if (phoneContact2.detalStatusFlag != 20) {
                        arrayList2.add(phoneContact2.unifiedCode);
                    }
                    phoneContact2.netTypeIconId = mobileContactsNotFriendInfo.conType;
                    phoneContact2.detalStatusFlag = mobileContactsNotFriendInfo.detalStatusFlag;
                    phoneContact2.iTermType = mobileContactsNotFriendInfo.iTermType;
                    phoneContact2.strTermDesc = mobileContactsNotFriendInfo.strTermDesc;
                    phoneContact2.eNetworkType = mobileContactsNotFriendInfo.eNetworkType;
                    phoneContact2.abilityBits = mobileContactsNotFriendInfo.uAbiFlag;
                    if (!TextUtils.isEmpty(phoneContact2.unifiedCode)) {
                        this.contactCacheByCodeNumber.put(phoneContact2.unifiedCode, phoneContact2);
                    }
                    phoneContact2.isHiden = mobileContactsNotFriendInfo.isHide;
                    this.tmpContactCache.remove(phoneContact2.mobileNo);
                    arrayList3.add(new UpdateTransaction(phoneContact2));
                    z19 = true;
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "bind nofriend not found, " + mobileContactsNotFriendInfo.contactsInfoEncrypt);
                }
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList3);
            addContactsToLastLoginList(arrayList2);
        } else {
            z26 = z18;
        }
        this.bindNonFriendList = null;
        this.bindAllFriendList = null;
        this.respBindFriendList_V2 = null;
        this.respBindStrangerList_V2 = null;
        if (z17) {
            i16 = 7;
        } else {
            i16 = 6;
        }
        if (z26) {
            i16 |= 8;
        }
        if (j3 == 4294967295L) {
            afterSaveContactFromServer(z17);
            onNewRecommendContact(z19, this.recommendMobiles);
            this.recommendMobiles.clear();
            removeIllegalRecommend();
            saveContactListTimeStamp(j16, j17);
        }
        pushRecommendUnreadCount(z26);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveContactFromServer_v2 leave");
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public int saveContactFromServerNotBind(boolean z16, int i3, long j3, long j16, ArrayList<NotBindContactFriendInfo> arrayList, ArrayList<NotBindContactNotFriendInfo> arrayList2) {
        boolean z17;
        boolean z18;
        int i16;
        boolean z19;
        String obj;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z26 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return ((Integer) iPatchRedirector.redirect((short) 96, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), arrayList, arrayList2)).intValue();
        }
        if (this.destroyed) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(80);
            sb5.append("saveContactFromServerNotBind, isSegmented = ");
            sb5.append(z16);
            sb5.append(", packageNo = ");
            sb5.append(i3);
            sb5.append(", nextFlag = ");
            sb5.append(j3);
            QLog.d(TAG, 2, sb5.toString());
        }
        List<NotBindContactFriendInfo> list = this.respBindFriendListNotBind;
        if (list == null) {
            this.respBindFriendListNotBind = arrayList;
        } else {
            list.addAll(arrayList);
        }
        List<NotBindContactNotFriendInfo> list2 = this.respBindStrangerListNotBind;
        if (list2 == null) {
            this.respBindStrangerListNotBind = arrayList2;
        } else {
            list2.addAll(arrayList2);
        }
        if (j3 != 4294967295L && !z16) {
            return 0;
        }
        long j17 = this.pref.getLong("queryContactTimeStamp", 0L);
        long j18 = this.pref.getLong("queryRichInfoTimeStamp", 0L);
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder(200);
            sb6.append("saveContactFromServer, localTimeStamp:");
            sb6.append(j17);
            sb6.append(", ");
            sb6.append(j18);
            sb6.append(", remoteTimeStamp: ");
            sb6.append(j16);
            sb6.append(", friendCount:");
            List<NotBindContactFriendInfo> list3 = this.respBindFriendListNotBind;
            int i18 = -1;
            if (list3 != null) {
                i17 = list3.size();
            } else {
                i17 = -1;
            }
            sb6.append(i17);
            sb6.append(", strangerCount:");
            List<NotBindContactNotFriendInfo> list4 = this.respBindStrangerListNotBind;
            if (list4 != null) {
                i18 = list4.size();
            }
            sb6.append(i18);
            QLog.d(TAG, 2, sb6.toString());
        }
        if (!this.isCacheInited) {
            initContactCache();
        }
        if ((i3 == 0 && z16) || !z16) {
            beforeSaveContactFromServer(true);
        }
        List<NotBindContactFriendInfo> list5 = this.respBindFriendListNotBind;
        if (list5 != null && list5.size() > 0) {
            IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) this.app.getRuntimeService(IAddFriendServiceApi.class, "");
            ArrayList arrayList3 = new ArrayList();
            z17 = false;
            for (NotBindContactFriendInfo notBindContactFriendInfo : this.respBindFriendListNotBind) {
                PhoneContact phoneContact = this.md52PhoneContact.get(notBindContactFriendInfo.contactsInfoEncrypt.toUpperCase());
                if (phoneContact != null) {
                    resetContact(phoneContact, z26);
                    phoneContact.uin = String.valueOf(notBindContactFriendInfo.bindUin);
                    phoneContact.isUploaded = true;
                    String a16 = PhoneContactUtils.a(notBindContactFriendInfo.MobileNoMask, phoneContact.mobileNo);
                    phoneContact.unifiedCode = a16;
                    phoneContact.mobileCode = a16;
                    phoneContact.nationCode = "";
                    if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact.uin), TAG);
                        if (friendsSimpleInfoWithUid != null) {
                            phoneContact.nickName = friendsSimpleInfoWithUid.p();
                        }
                        this.contactCacheByUin.put(phoneContact.uin, phoneContact);
                        iAddFriendServiceApi.setAddFriendReqStatus(phoneContact.unifiedCode, false);
                    }
                    if (!TextUtils.isEmpty(phoneContact.unifiedCode)) {
                        this.contactCacheByCodeNumber.put(phoneContact.unifiedCode, phoneContact);
                    }
                    this.tmpContactCache.remove(phoneContact.mobileNo);
                    arrayList3.add(new UpdateTransaction(phoneContact));
                    z17 = true;
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "bind friend not found, " + notBindContactFriendInfo.contactsInfoEncrypt);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("MobileContactsFriendInfo;");
                    if (phoneContact == null) {
                        obj = "null";
                    } else {
                        obj = phoneContact.toString();
                    }
                    sb7.append(obj);
                    QLog.d(TAG, 2, sb7.toString());
                }
                z26 = true;
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList3);
        } else {
            z17 = false;
        }
        List<NotBindContactNotFriendInfo> list6 = this.respBindStrangerListNotBind;
        if (list6 != null && list6.size() > 0) {
            ArrayList arrayList4 = new ArrayList(this.respBindStrangerListNotBind.size());
            ArrayList arrayList5 = new ArrayList();
            z18 = false;
            for (NotBindContactNotFriendInfo notBindContactNotFriendInfo : this.respBindStrangerListNotBind) {
                PhoneContact phoneContact2 = this.md52PhoneContact.get(notBindContactNotFriendInfo.contactsInfoEncrypt.toUpperCase());
                if (phoneContact2 != null) {
                    resetContact(phoneContact2, true);
                    phoneContact2.uin = "0";
                    phoneContact2.nickName = notBindContactNotFriendInfo.nickname;
                    phoneContact2.isUploaded = true;
                    String a17 = PhoneContactUtils.a(notBindContactNotFriendInfo.MobileNoMask, phoneContact2.mobileNo);
                    phoneContact2.unifiedCode = a17;
                    phoneContact2.mobileCode = a17;
                    phoneContact2.nationCode = "";
                    phoneContact2.age = notBindContactNotFriendInfo.age;
                    phoneContact2.sex = notBindContactNotFriendInfo.sex;
                    phoneContact2.samFriend = notBindContactNotFriendInfo.sameFriend;
                    if (notBindContactNotFriendInfo.isNew) {
                        phoneContact2.isNewRecommend = true;
                        this.recommendMobiles.add(phoneContact2);
                        z19 = true;
                    } else {
                        z19 = z18;
                    }
                    if (phoneContact2.detalStatusFlag != 20) {
                        arrayList4.add(phoneContact2.unifiedCode);
                    }
                    phoneContact2.abilityBits = notBindContactNotFriendInfo.uAbiFlag;
                    if (!TextUtils.isEmpty(phoneContact2.unifiedCode)) {
                        this.contactCacheByCodeNumber.put(phoneContact2.unifiedCode, phoneContact2);
                    }
                    this.tmpContactCache.remove(phoneContact2.mobileNo);
                    arrayList5.add(new UpdateTransaction(phoneContact2));
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "MobileContactsNotFriendInfo; mobile=" + phoneContact2.unifiedCode + " hide=" + phoneContact2.isHiden);
                    }
                    z18 = z19;
                    z17 = true;
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "bind nofriend not found, " + notBindContactNotFriendInfo.contactsInfoEncrypt);
                }
            }
            this.f258386em.doMultiDBOperateByTransaction(arrayList5);
            addContactsToLastLoginList(arrayList4);
        } else {
            z18 = false;
        }
        this.bindNonFriendList = null;
        this.bindAllFriendList = null;
        this.respBindFriendListNotBind = null;
        this.respBindStrangerListNotBind = null;
        if (z18) {
            i16 = 15;
        } else {
            i16 = 7;
        }
        if (j3 == 4294967295L) {
            afterSaveContactFromServer(true);
            onNewRecommendContact(z17, this.recommendMobiles);
            this.recommendMobiles.clear();
            removeIllegalRecommend();
            saveContactListTimeStampNotBind(j16);
        }
        pushRecommendUnreadCount(z18);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveContactFromServerNotBind leave");
        }
        return i16;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void saveLastLoginList(List<String> list, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveLastLoginList, size = " + list.size() + ", stamp " + j3 + ", interval = " + j16);
        }
        this.pref.edit().putLong(KEY_LAST_REQ_LOGIN_TIME, System.currentTimeMillis()).putLong(KEY_LOGIN_INFO_TIME_STAMP, j3).putLong(KEY_REQUEST_LOGIN_INTERVAL, Math.max(43200000L, j16 * 1000)).commit();
        HashSet hashSet = new HashSet(list.size());
        for (String str : list) {
            PhoneContact phoneContact = this.md52PhoneContact.get(str.toUpperCase());
            if (phoneContact != null) {
                hashSet.add(phoneContact.unifiedCode);
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "saveLastLoginList, wtf pc null " + str.toUpperCase());
            }
        }
        this.mLastLoginSet = hashSet;
        saveLastLoginListToDb(this.mLastLoginSet);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "saveLastLoginInfo: tempSet.size=" + hashSet.size());
        }
    }

    public void saveLastLoginListToDb(Set<String> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) set);
            return;
        }
        if (this.destroyed) {
            return;
        }
        QLog.i(TAG, 1, "saveLastLoginListToDb list=" + set);
        EntityManager createEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        if (createEntityManager == null) {
            QLog.e(TAG, 1, "saveLastLoginListToDb em is null");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DeleteTransaction("LastLoginPhoneInfo", null, null));
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    LastLoginPhoneInfo lastLoginPhoneInfo = new LastLoginPhoneInfo();
                    lastLoginPhoneInfo.unifiedCode = str;
                    arrayList.add(new PersistOrReplaceTransaction(lastLoginPhoneInfo));
                }
            }
            createEntityManager.doMultiDBOperateByTransaction(arrayList);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "saveLastLoginListToDb Exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void saveQueryInterval(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (j3 == sQueryContactListInterval && j16 == sQueryContactListIntervalLogin) {
            return;
        }
        try {
            sQueryContactListInterval = Math.max(1800000L, j3);
            sQueryContactListIntervalLogin = Math.max(86400000L, j16);
            com.tencent.mobileqq.phonecontact.nt.b bVar = com.tencent.mobileqq.phonecontact.nt.b.f258483a;
            bVar.f(AppConstants.Preferences.CONTACT_QUERY_MIN_INTERVAL, sQueryContactListInterval);
            bVar.f(AppConstants.Preferences.CONTACT_QUERY_MIN_INTERVAL_FOR_LOGIN, sQueryContactListIntervalLogin);
        } catch (Throwable th5) {
            th5.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, th5.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("saveQueryInterval  [limit:%s, limitLogin:%s]", Long.valueOf(sQueryContactListInterval), Long.valueOf(sQueryContactListIntervalLogin)));
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void saveUIBits(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, j3);
            return;
        }
        if (this.mUIBits != j3) {
            this.mUIBits = j3;
            SharedPreferences sharedPreferences = this.pref;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putLong(KEY_CONTACTS_SWITCHES, j3);
                notifyUISwitchChanged(j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendBindMobile(String str, String str2, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 35);
        newIntent.putExtra("country_code", str);
        newIntent.putExtra("phone_number", str2);
        newIntent.putExtra("cmd_param_bind_type", i3);
        newIntent.putExtra("cmd_param_is_from_uni", z16);
        newIntent.putExtra("cmd_param_is_from_change_bind", z17);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendBindMobileEncrypt(String str, byte[] bArr, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str != null && bArr != null) {
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 35);
            newIntent.putExtra("country_code", str);
            newIntent.putExtra("cmd_param_is_encrypt", true);
            newIntent.putExtra("cmd_param_encrypt_mobile", bArr);
            newIntent.putExtra("cmd_param_bind_type", i3);
            newIntent.putExtra("cmd_param_is_from_uni", z16);
            newIntent.putExtra("cmd_param_is_from_change_bind", z17);
            this.app.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendRebindMobile(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 19);
        newIntent.putExtra("country_code", str);
        newIntent.putExtra("phone_number", str2);
        newIntent.putExtra("cmd_param_bind_type", 0);
        this.app.startServlet(newIntent);
        sendRebindMobile(str, str2, 0, false, false);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendRebindMobileEncrypt(String str, byte[] bArr, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, bArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str != null && bArr != null) {
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 19);
            newIntent.putExtra("country_code", str);
            newIntent.putExtra("cmd_param_is_encrypt", true);
            newIntent.putExtra("cmd_param_encrypt_mobile", bArr);
            newIntent.putExtra("cmd_param_bind_type", i3);
            newIntent.putExtra("cmd_param_is_from_uni", z16);
            newIntent.putExtra("cmd_param_is_from_change_bind", z17);
            this.app.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendVerifySmsCode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            sendVerifySmsCode(str, 0, false, false);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void setContactBoundDataCache(com.tencent.mobileqq.phonecontact.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, (Object) aVar);
        } else {
            this.contactBindedDataCache = aVar;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void setNeedUploadResultTip(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this, z16);
        } else {
            this.needUploadResultTip = z16;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void setOpeningShareFlag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, z16);
        } else {
            com.tencent.mobileqq.phonecontact.constant.b.f258441a = false;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void setUploadToastSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this, z16);
        } else {
            QMMKV.fromV2(BaseApplication.context, "common_mmkv_configurations").putBoolean("phone_contact_upload_toast", z16);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean shouldBlockMessageTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isAppBlocking;
    }

    void unRegistContentObservers() {
        if (this.contactObserver != null) {
            try {
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, th5.getMessage(), th5);
                }
            }
            if (this.destroyed) {
                return;
            }
            this.app.getApp().getContentResolver().unregisterContentObserver(this.contactObserver);
            this.contactObserver.a(null);
            this.contactObserver = null;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void unbindMobile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        RespondQueryQQBindingStat selfBindInfo = getSelfBindInfo();
        if (selfBindInfo == null || selfBindInfo.nationCode == null || selfBindInfo.mobileNo == null) {
            return;
        }
        unbindMobile(false, false);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void unbindMobileEncrypt(byte[] bArr, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, bArr, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        RespondQueryQQBindingStat selfBindInfo = getSelfBindInfo();
        if (selfBindInfo != null && selfBindInfo.nationCode != null && selfBindInfo.mobileNo != null) {
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            this.mLastUnbindMobileTime = serverTimeMillis;
            com.tencent.mobileqq.phonecontact.nt.b.f258483a.g(KEY_LAST_UNBIND_MOBILE_TIME, serverTimeMillis);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("unbindMobileEncrypt [%s]", Long.valueOf(this.mLastUnbindMobileTime)));
            }
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 20);
            newIntent.putExtra("country_code", selfBindInfo.nationCode);
            newIntent.putExtra("cmd_param_is_encrypt", true);
            newIntent.putExtra("cmd_param_encrypt_mobile", bArr);
            newIntent.putExtra("cmd_param_is_from_uni", z16);
            newIntent.putExtra("cmd_param_is_from_change_bind", z17);
            this.app.startServlet(newIntent);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void updateAllEntranceConfig(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, i3, (Object) str);
            return;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                int optInt = new JSONObject(str).optInt(KEY_ALL_ENTRANCE_NUM);
                if (optInt > 0) {
                    sAllEntranceNum = optInt;
                }
                com.tencent.mobileqq.phonecontact.nt.b bVar = com.tencent.mobileqq.phonecontact.nt.b.f258483a;
                bVar.h(KEY_ALL_ENTRANCE_NUM, sAllEntranceNum);
                bVar.h(KEY_CONFIG_VERSION, i3);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "updateConfigs error " + e16.getMessage());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateAllEntranceConfig|allEntranceNum = " + sAllEntranceNum);
        }
    }

    protected List<BaseTransaction> updateEntity(Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (List) iPatchRedirector.redirect((short) 93, (Object) this, (Object) entity);
        }
        ArrayList arrayList = new ArrayList();
        if (this.f258386em.isOpen()) {
            if (entity.getStatus() == 1000) {
                arrayList.add(new PersistOrReplaceTransaction(entity));
            } else if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                arrayList.add(new UpdateTransaction(entity));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateEntity em closed e=" + entity.getTableName());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void updateOnlineStatus(String str, GetOnlineInfoResp getOnlineInfoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) str, (Object) getOnlineInfoResp);
            return;
        }
        PhoneContact queryContactByCodeNumber = queryContactByCodeNumber(str);
        if (queryContactByCodeNumber != null) {
            queryContactByCodeNumber.detalStatusFlag = (byte) getOnlineInfoResp.dwStatus;
            long j3 = getOnlineInfoResp.iTermType;
            queryContactByCodeNumber.iTermType = (int) j3;
            int i3 = getOnlineInfoResp.eNetworkType;
            queryContactByCodeNumber.eNetworkType = i3;
            int i16 = getOnlineInfoResp.eIconType;
            queryContactByCodeNumber.netTypeIconId = i16;
            queryContactByCodeNumber.strTermDesc = getOnlineInfoResp.strTermDesc;
            queryContactByCodeNumber.abilityBits = getOnlineInfoResp.uAbiFlag;
            if ((j3 == 67586 || j3 == 66566 || j3 == 72194 || j3 == 65804 || j3 == 72706) && i3 != 1) {
                queryContactByCodeNumber.netTypeIconIdIphoneOrWphoneNoWifi = i16;
            }
            notifyContactChanged(2);
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void updateRenameList(ArrayList<PhoneContact> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateRenameList");
        }
        if (arrayList != null && arrayList.size() != 0) {
            try {
                ArrayList arrayList2 = new ArrayList();
                Iterator<PhoneContact> it = arrayList.iterator();
                while (it.hasNext()) {
                    PhoneContact next = it.next();
                    if (next.getStatus() == 1000) {
                        arrayList2.add(new PersistTransaction(next));
                    } else {
                        arrayList2.add(new UpdateTransaction(next));
                    }
                }
                this.f258386em.doMultiDBOperateByTransaction(arrayList2);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16.getMessage());
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void updateSessionId(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) bArr);
        } else {
            this.sessionId = bArr;
            this.pref.edit().putString(ServiceConst.PARA_SESSION_ID, new String(bArr)).commit();
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void uploadOrUpdateContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this);
            return;
        }
        int selfBindState = getSelfBindState();
        QLog.i(TAG, 1, "uploadOrUpdateContact() state: " + selfBindState);
        if (selfBindState > 5) {
            if (selfBindState == 9) {
                updatePhoneContact();
                return;
            } else {
                uploadPhoneContact();
                return;
            }
        }
        if (selfBindState == 2) {
            updatePhoneContactNotBind();
        } else {
            uploadPhoneContactNotBind();
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public synchronized boolean uploadPhoneContact() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("uploadPhoneContact, isUploading = ");
            if (this.mCurrentBindState == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append(", isQueryingContact = ");
            sb5.append(this.isQueryingContact);
            sb5.append(", lastFailPeriode = ");
            sb5.append((System.currentTimeMillis() - this.lastUploadFailTimeStamp) / 1000);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (this.mCurrentBindState != 8 && !this.isQueryingContact && getUNIQUE_NO() != null) {
            if (System.currentTimeMillis() - this.lastUploadFailTimeStamp < 120000) {
                return false;
            }
            QLog.d(TAG, 1, "do-uploadPhoneContact()");
            if (this.mCurrentBindState == 2 || this.mCurrentBindState == 3 || this.mCurrentBindState == 4) {
                deleteLocalData();
            }
            this.mCurrentBindState = 8;
            notifyBindStateChanged();
            if (this.mUploadProgressGenerator == null) {
                UploadProgressGenerator uploadProgressGenerator = new UploadProgressGenerator(this, null);
                this.mUploadProgressGenerator = uploadProgressGenerator;
                uploadProgressGenerator.e();
            }
            ArrayList<AddressBookItem> loadContactFromPhoneToDB = loadContactFromPhoneToDB();
            if (loadContactFromPhoneToDB == null) {
                loadContactFromPhoneToDB = new ArrayList<>(0);
            }
            if (this.mIsUploadForNewGuide) {
                saveUploadDataForNewGuide(1, loadContactFromPhoneToDB.size(), 0, 0);
            }
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 31);
            newIntent.putExtra("unique_phone_no", getUNIQUE_NO());
            newIntent.putExtra("next_flag", 0L);
            newIntent.putExtra("upload_package_no", 0);
            newIntent.putExtra(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST, loadContactFromPhoneToDB);
            newIntent.putExtra(ServiceConst.PARA_SESSION_ID, new byte[0]);
            newIntent.putExtra("is_resend", false);
            this.app.startServlet(newIntent);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public synchronized boolean uploadPhoneContactNotBind() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            return ((Boolean) iPatchRedirector.redirect((short) 98, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("uploadPhoneContactNotBind, isUploading = ");
            sb5.append(this.mCurrentBindState);
            sb5.append("isQueryingContact = ");
            sb5.append(this.isQueryingContact);
            sb5.append(", lastFailPeriode = ");
            sb5.append((System.currentTimeMillis() - this.lastUploadFailTimeStamp) / 1000);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (this.mCurrentBindState != 4 && !this.isQueryingContact && getUNIQUE_NO() != null) {
            if (System.currentTimeMillis() - this.lastUploadFailTimeStamp < 120000) {
                return false;
            }
            QLog.d(TAG, 1, "do-uploadPhoneContactNotBind()");
            this.pref.edit().putBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_CONTINUE_UPLOAD, false).commit();
            this.mCurrentBindState = 4;
            notifyBindStateChanged();
            if (this.mUploadProgressGenerator == null) {
                UploadProgressGenerator uploadProgressGenerator = new UploadProgressGenerator(this, null);
                this.mUploadProgressGenerator = uploadProgressGenerator;
                uploadProgressGenerator.e();
            }
            ArrayList<AddressBookItem> loadContactFromPhoneToDB = loadContactFromPhoneToDB();
            if (loadContactFromPhoneToDB == null) {
                loadContactFromPhoneToDB = new ArrayList<>(0);
            }
            if (this.mIsUploadForNewGuide) {
                saveUploadDataForNewGuide(1, loadContactFromPhoneToDB.size(), 0, 0);
            }
            NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
            newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 37);
            newIntent.putExtra("unique_phone_no", getUNIQUE_NO());
            newIntent.putExtra("next_flag", 0L);
            newIntent.putExtra("upload_package_no", 0);
            newIntent.putExtra(MiniAppBatchGetContactServlet.KEY_CONTACT_LIST, loadContactFromPhoneToDB);
            newIntent.putExtra(ServiceConst.PARA_SESSION_ID, new byte[0]);
            newIntent.putExtra("is_resend", false);
            this.app.startServlet(newIntent);
            return true;
        }
        if (this.isQueryingContact) {
            this.pref.edit().putBoolean(AppConstants.Preferences.CONTACT_BIND_NOBIND_CONTINUE_UPLOAD, true).commit();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyContactChanged(int i3) {
        if (this.destroyed) {
            return;
        }
        if ((i3 & 1) != 0) {
            this.orderedNobindList = null;
            this.orderedBindList = null;
            this.mListForSelector = null;
            this.mListForContactListView = null;
            this.mInjectProcessor.b();
            this.mInjectProcessor.e();
        }
        this.bindNonFriendList = null;
        this.bindAllFriendList = null;
        this.app.runOnUiThread(new Runnable(i3) { // from class: com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f258403d;

            {
                this.f258403d = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this, i3);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    synchronized (PhoneContactServiceImpl.this.mListenerList) {
                        Iterator it = PhoneContactServiceImpl.this.mListenerList.iterator();
                        while (it.hasNext()) {
                            ((od2.a) it.next()).L1(this.f258403d);
                        }
                    }
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getBindNonfriendList(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (List) iPatchRedirector.redirect((short) 37, (Object) this, (Object) iArr);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> list = this.bindNonFriendList;
        if (list == null) {
            list = initBindNonfriendList();
        }
        ArrayList arrayList = new ArrayList(list);
        if (iArr != null && iArr.length > 0) {
            try {
                safeSort(arrayList, new com.tencent.mobileqq.phonecontact.util.c(iArr, this.mLastLoginSet, this.app));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getBindNonfriendList", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBindNonfriendList cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", size = " + arrayList.size());
        }
        this.bindNonFriendList = arrayList;
        return arrayList;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<Object> getBindNonfriendListInObject(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (List) iPatchRedirector.redirect((short) 38, (Object) this, (Object) iArr);
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<PhoneContact> list = this.bindNonFriendList;
        if (list == null) {
            list = initBindNonfriendList();
        }
        ArrayList arrayList = new ArrayList(list);
        if (iArr != null && iArr.length > 0) {
            try {
                safeSort(arrayList, new com.tencent.mobileqq.phonecontact.util.c(iArr, this.mLastLoginSet, this.app));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "getBindNonfriendList", e16);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBindNonfriendList cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", size = " + arrayList.size());
        }
        this.bindNonFriendList = arrayList;
        return new ArrayList(arrayList);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendVerifySmsCode(String str, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 16);
        newIntent.putExtra("verify_smscode", str);
        newIntent.putExtra(ServiceConst.PARA_SESSION_ID, this.sessionId);
        newIntent.putExtra("cmd_param_bind_type", i3);
        newIntent.putExtra("cmd_param_is_from_uni", z16);
        newIntent.putExtra("cmd_param_is_from_change_bind", z17);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public List<PhoneContact> getContactListForContactListView(Map<String, PhoneContact> map, boolean z16) {
        long j3;
        Iterator it;
        boolean z17;
        long j16;
        String str;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return (List) iPatchRedirector.redirect((short) 89, this, map, Boolean.valueOf(z16));
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            arrayList.addAll(map.values());
        }
        if (!z16) {
            safeSort(arrayList, new f());
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() > 0) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = null;
            if (getSelfBindInfo() == null) {
                return null;
            }
            String str2 = getSelfBindInfo().mobileNo;
            Iterator it5 = arrayList.iterator();
            PhoneContact phoneContact = null;
            while (it5.hasNext()) {
                PhoneContact phoneContact2 = (PhoneContact) it5.next();
                if (str2 == null || !str2.endsWith(phoneContact2.mobileNo.trim())) {
                    PhoneContact phoneContact3 = (PhoneContact) phoneContact2.clone();
                    if (phoneContact == null) {
                        if (!TextUtils.isEmpty(phoneContact3.uin)) {
                            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact3.uin);
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = phoneContact3.uin.equals("0") ? dVar : ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, TAG);
                            if (friendsSimpleInfoWithUid != null && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(uidFromUin, TAG)) {
                                com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
                                aVar.d(uidFromUin);
                                phoneContact3.nickName = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
                                phoneContact3.remark = friendsSimpleInfoWithUid.r();
                            } else {
                                phoneContact3.uin = "0";
                            }
                        }
                        it = it5;
                        z17 = z19;
                        j16 = currentTimeMillis;
                        str = str2;
                    } else if (!z16 && phoneContact3.contactID == phoneContact.contactID) {
                        String str3 = phoneContact.mobileNo + "|" + phoneContact3.mobileNo;
                        boolean isEmpty = TextUtils.isEmpty(phoneContact.uin) ^ z19;
                        if (!isEmpty || phoneContact.uin.equals("0")) {
                            it = it5;
                            z18 = false;
                        } else {
                            it = it5;
                            z18 = true;
                        }
                        z17 = true;
                        boolean z26 = !TextUtils.isEmpty(phoneContact3.uin);
                        str = str2;
                        boolean z27 = z26 && !phoneContact3.uin.equals("0");
                        j16 = currentTimeMillis;
                        String uidFromUin2 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact.uin);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid2 = !z27 ? null : ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin2, TAG);
                        boolean z28 = friendsSimpleInfoWithUid2 != null && friendsSimpleInfoWithUid2.f() >= 0;
                        if ((z18 ? (char) 0 : isEmpty ? (char) 1 : (char) 2) > (z28 ? (char) 0 : z26 ? (char) 1 : (char) 2)) {
                            if (z26) {
                                if (z28) {
                                    com.tencent.relation.common.bean.nameservice.a aVar2 = new com.tencent.relation.common.bean.nameservice.a();
                                    aVar2.d(uidFromUin2);
                                    phoneContact3.nickName = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar2);
                                    phoneContact3.remark = friendsSimpleInfoWithUid2.r();
                                } else {
                                    phoneContact3.uin = "0";
                                }
                            }
                            phoneContact = phoneContact3;
                        }
                        phoneContact.mobileNo = str3;
                        z19 = z17;
                        it5 = it;
                        str2 = str;
                        currentTimeMillis = j16;
                        dVar = null;
                    } else {
                        it = it5;
                        z17 = z19;
                        j16 = currentTimeMillis;
                        str = str2;
                        arrayList2.add(phoneContact);
                        if (!TextUtils.isEmpty(phoneContact3.uin)) {
                            String uidFromUin3 = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(phoneContact3.uin);
                            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid3 = phoneContact3.uin.equals("0") ? null : ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin3, TAG);
                            if (friendsSimpleInfoWithUid3 != null && friendsSimpleInfoWithUid3.f() >= 0) {
                                com.tencent.relation.common.bean.nameservice.a aVar3 = new com.tencent.relation.common.bean.nameservice.a();
                                aVar3.d(uidFromUin3);
                                phoneContact3.nickName = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar3);
                                phoneContact3.remark = friendsSimpleInfoWithUid3.r();
                            } else {
                                phoneContact3.uin = "0";
                            }
                        }
                    }
                    phoneContact = phoneContact3;
                    z19 = z17;
                    it5 = it;
                    str2 = str;
                    currentTimeMillis = j16;
                    dVar = null;
                }
            }
            j3 = currentTimeMillis;
            if (phoneContact != null) {
                arrayList2.add(phoneContact);
            }
            removeDuplicate(arrayList2);
            safeSort(arrayList2, new g());
        } else {
            j3 = currentTimeMillis;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getContactListForContactListView sort contact cost time: " + (System.currentTimeMillis() - j3));
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void unbindMobile(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        RespondQueryQQBindingStat selfBindInfo = getSelfBindInfo();
        if (selfBindInfo == null || selfBindInfo.nationCode == null || selfBindInfo.mobileNo == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        this.mLastUnbindMobileTime = serverTimeMillis;
        com.tencent.mobileqq.phonecontact.nt.b.f258483a.g(KEY_LAST_UNBIND_MOBILE_TIME, serverTimeMillis);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, String.format("unbindMobile [%s]", Long.valueOf(this.mLastUnbindMobileTime)));
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 20);
        newIntent.putExtra("country_code", selfBindInfo.nationCode);
        newIntent.putExtra("phone_number", selfBindInfo.mobileNo);
        newIntent.putExtra("cmd_param_is_from_uni", z16);
        newIntent.putExtra("cmd_param_is_from_change_bind", z17);
        this.app.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class UploadProgressGenerator implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f258404d;

        /* renamed from: e, reason: collision with root package name */
        volatile int f258405e;

        /* renamed from: f, reason: collision with root package name */
        volatile int f258406f;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f258407h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f258408i;

        UploadProgressGenerator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneContactServiceImpl.this);
                return;
            }
            this.f258404d = 0;
            this.f258405e = 0;
            this.f258406f = 5;
            this.f258408i = false;
        }

        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "set progress, actual = " + i3 + ", expected = " + i16);
            }
            this.f258408i = true;
            this.f258405e = i3;
            this.f258406f = i16;
            ThreadManager.getUIHandler().removeCallbacks(this);
            ThreadManager.getUIHandler().postDelayed(this, 20L);
        }

        public void cancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                this.f258407h = true;
                ThreadManager.getUIHandler().removeCallbacks(this);
            }
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.f258407h = false;
                ThreadManager.getUIHandler().postDelayed(this, 100L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(PhoneContactServiceImpl.TAG, 2, "run progress, isCanceled = " + this.f258407h + ", bindState = " + PhoneContactServiceImpl.this.mCurrentBindState);
            }
            if (!this.f258407h) {
                if ((PhoneContactServiceImpl.this.mCurrentBindState == 8 || PhoneContactServiceImpl.this.mCurrentBindState == 4) && this.f258404d + 1 < this.f258406f) {
                    PhoneContactServiceImpl phoneContactServiceImpl = PhoneContactServiceImpl.this;
                    int i3 = this.f258404d;
                    this.f258404d = i3 + 1;
                    phoneContactServiceImpl.notifyUploadProgressChanged(i3);
                    if (this.f258408i) {
                        PhoneContactServiceImpl.this.notifyContactChanged(7);
                        this.f258408i = false;
                    }
                    MqqHandler uIHandler = ThreadManager.getUIHandler();
                    if (this.f258404d < this.f258405e) {
                        j3 = 20;
                    } else {
                        j3 = 100;
                    }
                    uIHandler.postDelayed(this, j3);
                }
            }
        }

        /* synthetic */ UploadProgressGenerator(PhoneContactServiceImpl phoneContactServiceImpl, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) phoneContactServiceImpl, (Object) anonymousClass1);
        }
    }

    private int getSelfBindState(RespondQueryQQBindingStat respondQueryQQBindingStat) {
        if (respondQueryQQBindingStat == null) {
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("getSelfBindState [%s, %s]", getUNIQUE_NO(), respondQueryQQBindingStat));
        }
        if (TextUtils.isEmpty(respondQueryQQBindingStat.mobileNo)) {
            if (TextUtils.isEmpty(respondQueryQQBindingStat.MobileUniqueNo)) {
                return 1;
            }
            return getUNIQUE_NO().equalsIgnoreCase(respondQueryQQBindingStat.MobileUniqueNo) ? 2 : 3;
        }
        long j3 = respondQueryQQBindingStat.originBinder;
        if (j3 == 2 || j3 == 3) {
            return 5;
        }
        if (j3 != 1) {
            return 0;
        }
        if (respondQueryQQBindingStat.MobileUniqueNo.equals("init padding")) {
            respondQueryQQBindingStat.MobileUniqueNo = null;
        }
        if (TextUtils.isEmpty(respondQueryQQBindingStat.MobileUniqueNo) || respondQueryQQBindingStat.isStopFindMatch) {
            return 7;
        }
        return getUNIQUE_NO().equalsIgnoreCase(respondQueryQQBindingStat.MobileUniqueNo) ? 9 : 6;
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public boolean deletePhoneContactAddInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, (Object) this, (Object) str)).booleanValue();
        }
        synchronized (this.mRecommendLock) {
            ArrayList<PhoneContactAdd> arrayList = this.mPhoneContactAddList;
            if (arrayList == null) {
                return false;
            }
            Iterator<PhoneContactAdd> it = arrayList.iterator();
            while (it.hasNext()) {
                PhoneContactAdd next = it.next();
                if (next.unifiedCode.equals(str)) {
                    it.remove();
                    this.f258386em.remove(next);
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendRebindMobile(String str, String str2, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, str2, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (str == null || str2 == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), ContactBindServlet.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 19);
        newIntent.putExtra("country_code", str);
        newIntent.putExtra("phone_number", str2);
        newIntent.putExtra("cmd_param_bind_type", i3);
        newIntent.putExtra("cmd_param_is_from_uni", z16);
        newIntent.putExtra("cmd_param_is_from_change_bind", z17);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.phonecontact.api.IPhoneContactService
    public void sendBindMobile(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            sendBindMobile(str, str2, 0, false, false);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(boolean z16, String str) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, z16 ? 2 : 1, str, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }
}
