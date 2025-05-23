package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.impl.PublicAccountBrowserImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.j;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.ap;
import com.tencent.mobileqq.activity.contacts.publicaccount.PublicAccountFragment;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.z;
import com.tencent.mobileqq.applets.NewPublicAccountServlet;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.e;
import com.tencent.mobileqq.utils.p;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigGroupInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$ConfigInfo;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes32.dex */
public class PublicAccountUtilImpl implements IPublicAccountUtil {
    public static final String AB_TEST_LOADTIME = "ab_test_loadtime_";
    public static final String AB_TEST_SHAREPRE = "ab_test_sharePre";
    public static final String AB_TEST_SWITCH = "ab_test_switch_";
    private static volatile int DELETE_OLDKANDIAN_FLAG = -1;
    private static final long FOLDER_MASK = 30720;
    private static Object LOCK = new Object();
    private static final int MASK_MSG_LIST = 3;
    private static final int MASK_PA_FOLDER = 2;
    private static String TAG_DELETE_OLDKANDIAN_FLAG = "tag_delete_oldkandian_flag";
    private static boolean isComeFromReadInjoy = false;
    public static long lastRequestLbsTime;
    public static MqqHandler publicAccountAIOuiHandler;
    private static WeakReference<Handler> qqLsHandler;

    /* loaded from: classes32.dex */
    class a implements ActionSheet.OnButtonClickListener {
        final /* synthetic */ ActionSheet C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f80289d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80290e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f80291f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f80292h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f80293i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Context f80294m;

        a(QQAppInterface qQAppInterface, String str, int i3, long j3, boolean z16, Context context, ActionSheet actionSheet) {
            this.f80289d = qQAppInterface;
            this.f80290e = str;
            this.f80291f = i3;
            this.f80292h = j3;
            this.f80293i = z16;
            this.f80294m = context;
            this.C = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            PAMessage b16;
            String str;
            if (i3 != 0) {
                if (i3 == 1 && this.f80290e.equals(AppConstants.PUBLIC_ACCOUNT_QQ_MAIL)) {
                    MessageRecord P = this.f80289d.getMessageFacade().P(this.f80290e, this.f80291f, this.f80292h);
                    if (P != null && (b16 = ap.b(P)) != null && (str = b16.items.get(0).url) != null) {
                        PublicAccountUtilImpl.removeMail(this.f80289d, this.f80294m, str);
                    }
                    this.f80289d.getMessageFacade().T1(this.f80290e, this.f80291f, this.f80292h);
                    if (this.f80293i) {
                        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.f80289d, this.f80290e, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_9", "aio_delete");
                    } else {
                        PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.f80289d, this.f80290e, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_8", "aio_delete");
                    }
                    this.f80289d.getMessageFacade().m0(this.f80290e, this.f80291f);
                }
            } else {
                this.f80289d.getMessageFacade().T1(this.f80290e, this.f80291f, this.f80292h);
                if (this.f80293i) {
                    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.f80289d, this.f80290e, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_9", "aio_delete");
                } else {
                    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.f80289d, this.f80290e, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_8", "aio_delete");
                }
                this.f80289d.getMessageFacade().m0(this.f80290e, this.f80291f);
            }
            this.C.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountObserver f80302d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80303e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f80304f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f80305h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ AppInterface f80306i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f80307m;

        c(IPublicAccountObserver iPublicAccountObserver, String str, boolean z16, Context context, AppInterface appInterface, int i3) {
            this.f80302d = iPublicAccountObserver;
            this.f80303e = str;
            this.f80304f = z16;
            this.f80305h = context;
            this.f80306i = appInterface;
            this.f80307m = i3;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountUtil.TAG, 2, "success:" + String.valueOf(z16));
            }
            if (!z16) {
                IPublicAccountObserver iPublicAccountObserver = this.f80302d;
                if (iPublicAccountObserver != null) {
                    iPublicAccountObserver.onUpdate(101, false, this.f80303e);
                }
                if (this.f80304f) {
                    PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d6b);
                    return;
                }
                return;
            }
            try {
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                        mobileqq_mp_followresponse.mergeFrom(byteArray);
                        int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                        if (QLog.isColorLevel()) {
                            QLog.d(IPublicAccountUtil.TAG, 2, "followUin, retCode=" + i16);
                        }
                        if (i16 == 0) {
                            IPublicAccountObserver iPublicAccountObserver2 = this.f80302d;
                            if (iPublicAccountObserver2 != null) {
                                iPublicAccountObserver2.onUpdate(101, true, this.f80303e);
                            }
                            PublicAccountUtilImpl.sendDetailInfoRequest(this.f80306i, this.f80305h, this.f80303e, this.f80307m);
                            return;
                        }
                        if (i16 == 58) {
                            IPublicAccountObserver iPublicAccountObserver3 = this.f80302d;
                            if (iPublicAccountObserver3 != null) {
                                iPublicAccountObserver3.onUpdate(101, false, this.f80303e);
                            }
                            if (this.f80304f) {
                                PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d69);
                                return;
                            }
                            return;
                        }
                        if (i16 == 65) {
                            IPublicAccountObserver iPublicAccountObserver4 = this.f80302d;
                            if (iPublicAccountObserver4 != null) {
                                iPublicAccountObserver4.onUpdate(101, false, this.f80303e);
                            }
                            if (this.f80304f) {
                                PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d5i);
                                return;
                            }
                            return;
                        }
                        IPublicAccountObserver iPublicAccountObserver5 = this.f80302d;
                        if (iPublicAccountObserver5 != null) {
                            iPublicAccountObserver5.onUpdate(101, false, this.f80303e);
                        }
                        if (this.f80304f) {
                            PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d6b);
                            return;
                        }
                        return;
                    }
                    IPublicAccountObserver iPublicAccountObserver6 = this.f80302d;
                    if (iPublicAccountObserver6 != null) {
                        iPublicAccountObserver6.onUpdate(101, false, this.f80303e);
                    }
                    if (this.f80304f) {
                        PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d6b);
                        return;
                    }
                    return;
                }
                IPublicAccountObserver iPublicAccountObserver7 = this.f80302d;
                if (iPublicAccountObserver7 != null) {
                    iPublicAccountObserver7.onUpdate(101, false, this.f80303e);
                }
                if (this.f80304f) {
                    PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d6b);
                }
            } catch (Exception unused) {
                IPublicAccountObserver iPublicAccountObserver8 = this.f80302d;
                if (iPublicAccountObserver8 != null) {
                    iPublicAccountObserver8.onUpdate(101, false, this.f80303e);
                }
                if (this.f80304f) {
                    PublicAccountUtilImpl.displayToast(this.f80305h, R.string.d6b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountObserver f80308d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80309e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f80310f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Context f80311h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f80312i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f80313m;

        d(IPublicAccountObserver iPublicAccountObserver, String str, boolean z16, Context context, Object obj, QQAppInterface qQAppInterface) {
            this.f80308d = iPublicAccountObserver;
            this.f80309e = str;
            this.f80310f = z16;
            this.f80311h = context;
            this.f80312i = obj;
            this.f80313m = qQAppInterface;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountUtil.TAG, 2, "success:" + String.valueOf(z16));
            }
            if (!z16) {
                IPublicAccountObserver iPublicAccountObserver = this.f80308d;
                if (iPublicAccountObserver != null) {
                    iPublicAccountObserver.onUpdate(102, false, this.f80309e);
                }
                if (this.f80310f) {
                    PublicAccountUtilImpl.displayToast(this.f80311h, R.string.d6b);
                    return;
                }
                return;
            }
            try {
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        mobileqq_mp$UnFollowResponse mobileqq_mp_unfollowresponse = new mobileqq_mp$UnFollowResponse();
                        mobileqq_mp_unfollowresponse.mergeFrom(byteArray);
                        if (mobileqq_mp_unfollowresponse.ret_info.get().ret_code.get() == 0) {
                            if (this.f80312i != null) {
                                PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) this.f80313m.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
                                if (publicAccountHandlerImpl != null) {
                                    publicAccountHandlerImpl.onFollowPublicAccount(this.f80312i);
                                }
                            } else {
                                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.f80313m.getRuntimeService(IPublicAccountDataManager.class, "all");
                                iPublicAccountDataManager.delPublicAccountInfo(this.f80309e);
                                iPublicAccountDataManager.delAccountDetailInfoCache(this.f80309e);
                                StructLongMessageDownloadProcessor.deleteTask(this.f80313m, this.f80309e);
                                this.f80313m.getMessageFacade().q(this.f80309e, 1008);
                                TroopBarAssistantManager.n().D(this.f80313m, (List) iPublicAccountDataManager.getPublicAccountEqqInfoList());
                            }
                            IPublicAccountObserver iPublicAccountObserver2 = this.f80308d;
                            if (iPublicAccountObserver2 != null) {
                                iPublicAccountObserver2.onUpdate(102, true, this.f80309e);
                                return;
                            }
                            return;
                        }
                        IPublicAccountObserver iPublicAccountObserver3 = this.f80308d;
                        if (iPublicAccountObserver3 != null) {
                            iPublicAccountObserver3.onUpdate(102, false, this.f80309e);
                        }
                        if (this.f80310f) {
                            PublicAccountUtilImpl.displayToast(this.f80311h, R.string.d6b);
                            return;
                        }
                        return;
                    }
                    IPublicAccountObserver iPublicAccountObserver4 = this.f80308d;
                    if (iPublicAccountObserver4 != null) {
                        iPublicAccountObserver4.onUpdate(102, false, this.f80309e);
                    }
                    if (this.f80310f) {
                        PublicAccountUtilImpl.displayToast(this.f80311h, R.string.d6b);
                        return;
                    }
                    return;
                }
                IPublicAccountObserver iPublicAccountObserver5 = this.f80308d;
                if (iPublicAccountObserver5 != null) {
                    iPublicAccountObserver5.onUpdate(102, false, this.f80309e);
                }
                if (this.f80310f) {
                    PublicAccountUtilImpl.displayToast(this.f80311h, R.string.d6b);
                }
            } catch (Exception unused) {
                IPublicAccountObserver iPublicAccountObserver6 = this.f80308d;
                if (iPublicAccountObserver6 != null) {
                    iPublicAccountObserver6.onUpdate(102, false, this.f80309e);
                }
                if (this.f80310f) {
                    PublicAccountUtilImpl.displayToast(this.f80311h, R.string.d6b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class g implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        private final IPublicAccountUtil.a<IPublicAccountDetail> f80326d;

        public g(IPublicAccountUtil.a<IPublicAccountDetail> aVar) {
            this.f80326d = aVar;
        }

        private void a(PublicAccountDetailImpl publicAccountDetailImpl) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            EntityManager createEntityManager = peekAppRuntime.getEntityManagerFactory(peekAppRuntime.getAccount()).createEntityManager();
            if (createEntityManager != null) {
                try {
                    createEntityManager.persistOrReplace(publicAccountDetailImpl);
                } catch (Exception e16) {
                    QLog.e(IPublicAccountUtil.TAG, 1, "saveDetailInfo persist failed!", e16);
                }
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager == null) {
                return;
            }
            iPublicAccountDataManager.saveAccountDetailInfoCache(publicAccountDetailImpl);
            PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(publicAccountDetailImpl.uin);
            if ((publicAccountInfo == null || TextUtils.isEmpty(publicAccountInfo.uid)) && publicAccountDetailImpl.followType == 1) {
                iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(publicAccountDetailImpl, 0L));
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            boolean z17;
            QLog.d(IPublicAccountUtil.TAG, 1, "GetPublicAccountDetailObserver onReceive success:" + z16);
            if (!z16 || bundle == null) {
                PublicAccountUtilImpl.invokeGetCallback(this.f80326d, false, null);
                return;
            }
            byte[] byteArray = bundle.getByteArray("data");
            int i16 = bundle.getInt("type", 0);
            if (byteArray == null) {
                QLog.e(IPublicAccountUtil.TAG, 1, "GetPublicAccountDetailObserver data is null");
                PublicAccountUtilImpl.invokeGetCallback(this.f80326d, false, null);
                return;
            }
            mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
            oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
            try {
                if (i16 == 0) {
                    mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                    z17 = true;
                } else {
                    z17 = PublicAccountUtilImpl.convert0xcf8ToMobileMP(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                }
            } catch (Exception e16) {
                QLog.e(IPublicAccountUtil.TAG, 1, "get detail info failed!", e16);
                z17 = false;
            }
            if (!z17) {
                QLog.e(IPublicAccountUtil.TAG, 1, "GetPublicAccountDetailObserver convert failed!");
                PublicAccountUtilImpl.invokeGetCallback(this.f80326d, false, null);
                return;
            }
            int i17 = (mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has()) ? mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() : -1;
            if (i17 == 0) {
                PublicAccountDetailImpl publicAccountDetailImpl = new PublicAccountDetailImpl();
                publicAccountDetailImpl.init(mobileqq_mp_getpublicaccountdetailinforesponse);
                a(publicAccountDetailImpl);
                PublicAccountUtilImpl.invokeGetCallback(this.f80326d, true, publicAccountDetailImpl);
                return;
            }
            QLog.e(IPublicAccountUtil.TAG, 1, "GetPublicAccountDetailObserver retCode: " + i17);
            PublicAccountUtilImpl.invokeGetCallback(this.f80326d, false, null);
        }
    }

    private static boolean WenHao(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        for (int i3 = 0; i3 < str2.length(); i3++) {
            if (str.charAt(i3) != str2.charAt(i3) && str2.charAt(i3) != '?') {
                return false;
            }
        }
        return true;
    }

    private static boolean XingHao(String str, String str2) {
        boolean z16;
        int length = str.length();
        int length2 = str2.length();
        int indexOf = str2.indexOf("*");
        if (indexOf == -1) {
            if (length != length2) {
                return false;
            }
            if (length == 0) {
                return true;
            }
            for (int i3 = 0; i3 < length2; i3++) {
                if (str.charAt(i3) != str2.charAt(i3)) {
                    return false;
                }
            }
            return true;
        }
        if (indexOf != 0) {
            for (int i16 = 0; i16 < indexOf; i16++) {
                if (str.charAt(i16) != str2.charAt(i16)) {
                    return false;
                }
            }
            return XingHao(str.substring(indexOf, length), str2.substring(indexOf, length2));
        }
        if (length2 == 1) {
            return true;
        }
        int i17 = 0;
        while (i17 < length) {
            int i18 = indexOf + 1;
            if (str.charAt(i17) == str2.charAt(i18) || str2.charAt(i18) == '*') {
                z16 = true;
                break;
            }
            i17++;
        }
        i17 = 0;
        z16 = false;
        if (!z16) {
            return false;
        }
        if (i17 == length) {
            return true;
        }
        return XingHao(str.substring(i17, length), str2.substring(indexOf + 1, length2));
    }

    public static String bytesToString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b16 : bArr) {
            stringBuffer.append((int) b16);
            stringBuffer.append(",");
        }
        return stringBuffer.toString();
    }

    private static boolean containLbsUin(AppInterface appInterface, String str) {
        UinPair uinPair = new UinPair(appInterface.getCurrentAccountUin(), str);
        PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) appInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        if (publicAccountHandlerImpl.lbsUinList == null) {
            EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
            publicAccountHandlerImpl.lbsUinList = createEntityManager.query(UinPair.class, false, "userUin=? ", new String[]{appInterface.getCurrentAccountUin()}, null, null, null, null);
            createEntityManager.close();
            if (publicAccountHandlerImpl.lbsUinList == null) {
                publicAccountHandlerImpl.lbsUinList = new ArrayList();
            }
        }
        return publicAccountHandlerImpl.lbsUinList.contains(uinPair);
    }

    public static boolean convert0xcf8ToMobileMP(byte[] bArr, oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse) {
        int i3;
        if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse == null) {
            return false;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
            if (mergeFrom.uint32_result.has()) {
                i3 = mergeFrom.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.i(IPublicAccountUtil.TAG, 2, "handle OidbSvc.0xcf8|OIDBSSOPke.result=" + i3);
                }
            } else {
                i3 = -1;
            }
            if (i3 != 0 || !mergeFrom.bytes_bodybuffer.has() || mergeFrom.bytes_bodybuffer.get() == null) {
                return false;
            }
            oidb_cmd0xcf8_getpublicaccountdetailinforesponse.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.has()) {
                mobileqq_mp$RetInfo mobileqq_mp_retinfo = new mobileqq_mp$RetInfo();
                mobileqq_mp_retinfo.ret_code.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get());
                mobileqq_mp_retinfo.err_info.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.ret_info.get().err_info.get());
                mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.set(mobileqq_mp_retinfo);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.seqno.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.seqno.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.uin.set((int) oidb_cmd0xcf8_getpublicaccountdetailinforesponse.luin.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.name.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.name.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.display_number.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.display_number.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.summary.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.summary.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_msg.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_recv_msg.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_recv_push.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_recv_push.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.certified_grade.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.certified_grade.get());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info.has()) {
                ArrayList arrayList = new ArrayList();
                for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo : oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info.get()) {
                    ArrayList arrayList2 = new ArrayList();
                    for (oidb_cmd0xcf8$ConfigInfo oidb_cmd0xcf8_configinfo : oidb_cmd0xcf8_configgroupinfo.config_info.get()) {
                        mobileqq_mp$ConfigInfo mobileqq_mp_configinfo = new mobileqq_mp$ConfigInfo();
                        mobileqq_mp_configinfo.type.set(oidb_cmd0xcf8_configinfo.type.get());
                        mobileqq_mp_configinfo.title.set(oidb_cmd0xcf8_configinfo.title.get());
                        mobileqq_mp_configinfo.content.set(oidb_cmd0xcf8_configinfo.content.get());
                        mobileqq_mp_configinfo.event_id.set(oidb_cmd0xcf8_configinfo.event_id.get());
                        mobileqq_mp_configinfo.url.set(oidb_cmd0xcf8_configinfo.url.get());
                        mobileqq_mp_configinfo.auth_type.set(oidb_cmd0xcf8_configinfo.auth_type.get());
                        mobileqq_mp_configinfo.state.set(oidb_cmd0xcf8_configinfo.state.get());
                        mobileqq_mp_configinfo.confirm_flag.set(oidb_cmd0xcf8_configinfo.confirm_flag.get());
                        mobileqq_mp_configinfo.confirm_tips.set(oidb_cmd0xcf8_configinfo.confirm_tips.get());
                        mobileqq_mp_configinfo.state_id.set(oidb_cmd0xcf8_configinfo.state_id.get());
                        arrayList2.add(mobileqq_mp_configinfo);
                    }
                    mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo = new mobileqq_mp$ConfigGroupInfo();
                    mobileqq_mp_configgroupinfo.config_info.set(arrayList2);
                    arrayList.add(mobileqq_mp_configgroupinfo);
                }
                mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info.set(arrayList);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.is_show_share_button.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_show_share_button.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_show_follow_button.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_show_follow_button.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.follow_type.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.follow_type.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.is_sync_lbs.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.is_sync_lbs.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.group_id.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.group_id.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.show_flag.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.show_flag.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_flag.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_flag.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.luin.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.luin.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.config_background_color.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_background_color.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.config_background_img.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_background_img.get());
            if (oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info_new.has()) {
                ArrayList arrayList3 = new ArrayList();
                for (oidb_cmd0xcf8$ConfigGroupInfo oidb_cmd0xcf8_configgroupinfo2 : oidb_cmd0xcf8_getpublicaccountdetailinforesponse.config_group_info_new.get()) {
                    ArrayList arrayList4 = new ArrayList();
                    for (oidb_cmd0xcf8$ConfigInfo oidb_cmd0xcf8_configinfo2 : oidb_cmd0xcf8_configgroupinfo2.config_info.get()) {
                        mobileqq_mp$ConfigInfo mobileqq_mp_configinfo2 = new mobileqq_mp$ConfigInfo();
                        mobileqq_mp_configinfo2.type.set(oidb_cmd0xcf8_configinfo2.type.get());
                        mobileqq_mp_configinfo2.title.set(oidb_cmd0xcf8_configinfo2.title.get());
                        mobileqq_mp_configinfo2.content.set(oidb_cmd0xcf8_configinfo2.content.get());
                        mobileqq_mp_configinfo2.event_id.set(oidb_cmd0xcf8_configinfo2.event_id.get());
                        mobileqq_mp_configinfo2.url.set(oidb_cmd0xcf8_configinfo2.url.get());
                        mobileqq_mp_configinfo2.auth_type.set(oidb_cmd0xcf8_configinfo2.auth_type.get());
                        mobileqq_mp_configinfo2.state.set(oidb_cmd0xcf8_configinfo2.state.get());
                        mobileqq_mp_configinfo2.confirm_flag.set(oidb_cmd0xcf8_configinfo2.confirm_flag.get());
                        mobileqq_mp_configinfo2.confirm_tips.set(oidb_cmd0xcf8_configinfo2.confirm_tips.get());
                        mobileqq_mp_configinfo2.state_id.set(oidb_cmd0xcf8_configinfo2.state_id.get());
                        arrayList4.add(mobileqq_mp_configinfo2);
                    }
                    mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo2 = new mobileqq_mp$ConfigGroupInfo();
                    mobileqq_mp_configgroupinfo2.config_info.set(arrayList4);
                    arrayList3.add(mobileqq_mp_configgroupinfo2);
                }
                mobileqq_mp_getpublicaccountdetailinforesponse.config_group_info_new.set(arrayList3);
            }
            mobileqq_mp_getpublicaccountdetailinforesponse.certified_description.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.certified_description.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.unified_account_descrpition.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.unified_account_descrpition.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_flag2.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_flag2.get());
            mobileqq_mp_getpublicaccountdetailinforesponse.account_uid.set(oidb_cmd0xcf8_getpublicaccountdetailinforesponse.account_uid.get());
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.w(IPublicAccountUtil.TAG, 4, e16.getMessage(), e16);
            return false;
        } catch (Exception e17) {
            QLog.w(IPublicAccountUtil.TAG, 4, e17.getMessage(), e17);
            return false;
        }
    }

    public static int getAccountTypeInner(int i3) {
        if (i3 >= 0) {
            if ((2097152 & i3) != 0) {
                return -2;
            }
            if ((67108864 & i3) != 0) {
                return -3;
            }
            if ((33554432 & i3) != 0) {
                return -4;
            }
            if ((8388608 & i3) != 0) {
                return -5;
            }
            if ((134217728 & i3) != 0) {
                return -6;
            }
            if ((i3 & Integer.MIN_VALUE) != 0) {
                return -9;
            }
            return -11;
        }
        return i3;
    }

    private static IPublicAccountConfigAttr.a getConfigInfo(PublicAccountDetailImpl publicAccountDetailImpl, int i3, int i16) {
        List<IPublicAccountConfigAttr> list = publicAccountDetailImpl.paConfigAttrs;
        if (list != null && !list.isEmpty()) {
            for (IPublicAccountConfigAttr iPublicAccountConfigAttr : publicAccountDetailImpl.paConfigAttrs) {
                if (iPublicAccountConfigAttr.getType() == i3) {
                    for (IPublicAccountConfigAttr.a aVar : iPublicAccountConfigAttr.getConfigs()) {
                        if (aVar.f79333e == i16) {
                            return aVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void gotoAIO(AppInterface appInterface, Context context, String str, int i3) {
        String str2;
        int i16;
        PublicAccountInfo publicAccountInfo;
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "gotoAIO app: " + appInterface + " | context: " + context + " | uin: " + str + " | accountFlag: " + i3);
        }
        if (appInterface == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null && (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) != null) {
            str2 = publicAccountInfo.name;
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        int accountType = getAccountType(appInterface, str, i3);
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        if (accountType == -7) {
            intent.putExtra("chat_subType", 1);
            i16 = 0;
        } else {
            i16 = 1008;
        }
        intent.putExtra("uin", str);
        intent.putExtra("uintype", i16);
        intent.putExtra("uinname", str2);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, context.getString(R.string.button_back));
        context.startActivity(intent);
    }

    public static boolean isInPublicAccountFolderStatic(long j3) {
        if (((int) ((j3 & FOLDER_MASK) >> 11)) != 3) {
            return true;
        }
        return false;
    }

    private static boolean isLike(String str, String str2) {
        if (str2.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) != -1) {
            return WenHao(str, str2);
        }
        if (str2.indexOf("*") != -1) {
            return XingHao(str, str2);
        }
        return false;
    }

    private static void openBmqqProfile(Intent intent, Context context, String str) {
        if (intent == null) {
            intent = new Intent(context, (Class<?>) QidianProfileCardActivity.class);
        } else {
            intent.setClassName(context, QidianProfileCardActivity.class.getName());
        }
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, new AllInOne(str, 104));
        intent.putExtra("uin", str);
        context.startActivity(intent);
    }

    private static void openBmqqProfileForResult(Intent intent, Activity activity, String str, int i3, int i16) {
        if (intent == null) {
            intent = new Intent(activity, (Class<?>) QidianProfileCardActivity.class);
        } else {
            intent.setClassName(activity, QidianProfileCardActivity.class.getName());
        }
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, new AllInOne(str, 104));
        intent.putExtra("uin", str);
        activity.startActivityForResult(intent, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeMail(final AppInterface appInterface, final Context context, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.1
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountUtilImpl.sendDelMailReq(AppInterface.this, context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportPublicAccountPushRedDotExposure(String str) {
        AppInterface appInterface = (AppInterface) ((IReadInJoyUtils) QRoute.api(IReadInJoyUtils.class)).getAppRuntime();
        if (appInterface == null) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        MessageRecord x16 = qQAppInterface.getMessageFacade().x1(str, 1008);
        if (x16 == null || x16.isread) {
            return;
        }
        String extInfoFromExtStr = x16.getExtInfoFromExtStr("has_report");
        if (TextUtils.isEmpty(extInfoFromExtStr) || !"1".equals(extInfoFromExtStr)) {
            x16.saveExtInfoToExtStr("has_report", "1");
            qQAppInterface.getMessageFacade().a1(x16.frienduin, 1008, x16.uniseq, AppConstants.Key.COLUMN_EXT_STR, x16.extStr);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009A7C", "0X8009A7C", 0, 0, str, "", "", "", false);
        }
    }

    private static void saveLbsUin(AppInterface appInterface, String str) {
        UinPair uinPair = new UinPair(appInterface.getCurrentAccountUin(), str);
        PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) appInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        if (publicAccountHandlerImpl.lbsUinList == null) {
            publicAccountHandlerImpl.lbsUinList = new ArrayList();
        }
        publicAccountHandlerImpl.lbsUinList.add(uinPair);
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.persist(uinPair);
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c4, code lost:
    
        if (r13.getInt("ret") == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void sendDelMailReq(AppInterface appInterface, final Context context, String str) {
        int indexOf;
        String str2;
        String str3;
        int indexOf2;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return;
        }
        boolean z16 = true;
        String[] split = str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER);
        boolean z17 = false;
        int i3 = 0;
        while (true) {
            str2 = "";
            if (i3 >= split.length) {
                str3 = "";
                break;
            } else {
                if (split[i3].startsWith("url=")) {
                    str3 = URLDecoder.decode(split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                    break;
                }
                i3++;
            }
        }
        if (TextUtils.isEmpty(str3) || (indexOf2 = str3.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return;
        }
        String[] split2 = str3.substring(indexOf2 + 1).split(ContainerUtils.FIELD_DELIMITER);
        appInterface.getCurrentAccountUin();
        int i16 = 0;
        while (true) {
            if (i16 >= split2.length) {
                break;
            }
            if (split2[i16].startsWith("mailid=")) {
                str2 = split2[i16].split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
                break;
            }
            i16++;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            HttpResponse httpResponse = HttpBaseUtil.l(String.format("https://w.mail.qq.com/cgi-bin/login?mailid=%1$s&target=mobileqqdel&fwd=mq&uin=%2$s&fun=from3g", str2, appInterface.getCurrentAccountUin()), "GET", new Bundle(), null).f340995a;
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                JSONObject jSONObject = new JSONObject(HttpBaseUtil.q(httpResponse));
                if (jSONObject.has("ret")) {
                }
            }
            z16 = false;
            z17 = z16;
        } catch (Exception unused) {
        }
        if (z17) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.2
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(context.getApplicationContext(), context.getResources().getString(R.string.d5e), 0).show();
            }
        });
    }

    public static byte[] stringToBytes(String str) {
        String[] split = str.split(",");
        ByteBuffer allocate = ByteBuffer.allocate(split.length);
        for (String str2 : split) {
            allocate.put((byte) Integer.parseInt(str2));
        }
        return allocate.array();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void cleanPublicAccountObserver() {
        synchronized (PublicAccountUtilImpl.class) {
            publicAccountAIOuiHandler = null;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public String constructAttributeL() {
        String cityCode = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adcode", cityCode);
            jSONObject.put("deviceCode", "");
            jSONObject.put("macAddress", "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        byte[] bytes = jSONObject.toString().getBytes();
        byte[] bArr = new byte[bytes.length];
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[i3] = (byte) (bytes[i3] ^ 182);
        }
        return PluginBaseInfoHelper.Base64Helper.encodeToString(bArr, 2);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void doVideoPlayRealtimeReport(final String str, final String str2, final int i3, final int i16) {
        if (QLog.isColorLevel()) {
            QLog.i(IPublicAccountUtil.TAG, 2, "doVideoPlayRealtimeReport aid=" + str + ", vid=" + str2 + ", rtype=" + i3 + ", rcode=" + i16);
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.15

            /* renamed from: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl$15$a */
            /* loaded from: classes32.dex */
            class a implements e.a {
                a() {
                }

                @Override // com.tencent.mobileqq.troop.utils.e.a
                public void rg(JSONObject jSONObject, int i3, Bundle bundle) {
                    if (jSONObject != null) {
                        if (QLog.isColorLevel()) {
                            QLog.w(IPublicAccountUtil.TAG, 2, "videoPlayRealtimeReport:return result :" + jSONObject);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w(IPublicAccountUtil.TAG, 2, "videoPlayRealtimeReport:return result null");
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        AppInterface appInterface = (runtime == null || !(runtime instanceof AppInterface)) ? null : (AppInterface) runtime;
                        if (appInterface == null) {
                            return;
                        }
                        String currentAccountUin = appInterface.getCurrentAccountUin();
                        if (TextUtils.isEmpty(currentAccountUin) || ((TicketManager) appInterface.getManager(2)) == null) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        String format = String.format(IPublicAccountUtil.VIDEO_REALTIME_REPORT_URL, str, str2, Integer.valueOf(i3), str);
                        bundle.putString("Cookie", "uin=" + currentAccountUin);
                        HashMap hashMap = new HashMap();
                        hashMap.put("BUNDLE", bundle);
                        hashMap.put("CONTEXT", BaseApplicationImpl.getApplication());
                        a aVar = new a();
                        if (i3 == 1) {
                            format = format + "&rcode=" + Integer.toString(i16);
                        }
                        String str3 = format;
                        if (QLog.isColorLevel()) {
                            QLog.i(IPublicAccountUtil.TAG, 2, "doVideoPlayRealtimeReport cgiUrl=" + str3);
                        }
                        new com.tencent.mobileqq.troop.utils.f(str3, "GET", aVar, 0, null).executeOnExecutor(ThreadManagerV2.getNetExcutor(), hashMap);
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(IPublicAccountUtil.TAG, 2, "videoPlayRealtimeReport:request Exception " + e16);
                    }
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.w(IPublicAccountUtil.TAG, 2, "videoPlayRealtimeReport:request OutOfMemoryError " + e17);
                    }
                }
            }
        }, 5, null, true);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void enterTimTeam(Context context, AppInterface appInterface) {
        boolean booleanValue = ((Boolean) p.b(context, appInterface.getCurrentAccountUin(), AppConstants.Preferences.CONFIG_TIM_TEAM_IS_WEB, Boolean.FALSE)).booleanValue();
        String str = (String) p.b(context, appInterface.getCurrentAccountUin(), AppConstants.Preferences.CONFIG_TIM_TEAM_URL, "https://m.q.qq.com/a/p/1109953074?s=pages%2Fnotification%2Findex%3FenterType%3DqqMiniHelper");
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        if (!booleanValue && iMiniAppService.isMiniAppUrl(str)) {
            iMiniAppService.startMiniApp(context, str, 1043, null);
        } else {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("hide_more_button", true);
            intent.putExtra("webStyle", "noBottomBar");
            context.startActivity(intent);
        }
        ((QQAppInterface) appInterface).getMessageFacade().R0(AppConstants.TIM_TEAM_UIN, 1008, true, true);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver) {
        followUin(appInterface, context, str, iPublicAccountObserver, true, 0);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public int getAccountType(int i3) {
        return getAccountTypeInner(i3);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public long getAccountType2(long j3) {
        if ((512 & j3) != 0) {
            return -8L;
        }
        if ((j3 & 1048576) != 0) {
            return -10L;
        }
        return -1L;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public String getNickName(AppRuntime appRuntime, String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        PublicAccountInfo publicAccountInfo;
        return (TextUtils.isEmpty(str) || (iPublicAccountDataManager = (IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all")) == null || (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) == null) ? str : publicAccountInfo.name;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public int getPubAccountRecentUserPosInMessageList() {
        return ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).getPubAccountRecentUserPosInMessageList();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void getPublicAccountDetail(String str, IPublicAccountUtil.a<IPublicAccountDetail> aVar) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "getPublicAccountDetail, puin : " + str);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(IPublicAccountUtil.TAG, 1, "getPublicAccountDetail failed! runtime is null");
            invokeGetCallback(aVar, false, null);
            return;
        }
        try {
            i3 = (int) Long.parseLong(str);
        } catch (Exception e16) {
            QLog.e(IPublicAccountUtil.TAG, 1, "parse uin failed: " + str, e16);
            i3 = 0;
        }
        if (i3 == 0) {
            invokeGetCallback(aVar, false, null);
            return;
        }
        NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ.getApplicationContext(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.uin.set(i3);
        newIntent.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        newIntent.setObserver(new g(aVar));
        QLog.d(IPublicAccountUtil.TAG, 1, "getPublicAccountDetail startServlet uin: " + str);
        peekAppRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public NewIntent getPublicAccountDetailRequest(final AppInterface appInterface, Context context, MqqHandler mqqHandler, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "getPublicAccountDetailRequest, puin : " + str);
        }
        synchronized (PublicAccountUtilImpl.class) {
            if (mqqHandler != null) {
                publicAccountAIOuiHandler = mqqHandler;
            }
        }
        NewIntent newIntent = new NewIntent(context, PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(str));
        } catch (Exception unused) {
        }
        newIntent.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.10
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, final boolean z16, final Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountUtil.TAG, 2, "success:" + String.valueOf(z16));
                }
                ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] byteArray;
                        int i16;
                        boolean convert0xcf8ToMobileMP;
                        boolean z17 = false;
                        if (z16) {
                            try {
                                byteArray = bundle.getByteArray("data");
                                i16 = bundle.getInt("type", 0);
                            } catch (Exception unused2) {
                            }
                            if (byteArray != null) {
                                mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                                oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
                                if (i16 == 0) {
                                    mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                                    convert0xcf8ToMobileMP = true;
                                } else {
                                    convert0xcf8ToMobileMP = PublicAccountUtilImpl.convert0xcf8ToMobileMP(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                                }
                                if (convert0xcf8ToMobileMP && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has() && mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() == 0) {
                                    PublicAccountDetailImpl publicAccountDetailImpl = new PublicAccountDetailImpl();
                                    publicAccountDetailImpl.init(mobileqq_mp_getpublicaccountdetailinforesponse);
                                    AppInterface appInterface2 = appInterface;
                                    EntityManager createEntityManager = appInterface2.getEntityManagerFactory(appInterface2.getAccount()).createEntityManager();
                                    if (createEntityManager != null) {
                                        createEntityManager.persistOrReplace(publicAccountDetailImpl);
                                        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
                                        if (iPublicAccountDataManager != null) {
                                            iPublicAccountDataManager.saveAccountDetailInfoCache(publicAccountDetailImpl);
                                            if (((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(publicAccountDetailImpl.uin)) == null && publicAccountDetailImpl.followType == 1) {
                                                iPublicAccountDataManager.savePublicAccountInfo(PublicAccountInfo.createPublicAccount(publicAccountDetailImpl, 0L));
                                            }
                                        }
                                        synchronized (PublicAccountUtilImpl.class) {
                                            MqqHandler mqqHandler2 = PublicAccountUtilImpl.publicAccountAIOuiHandler;
                                            if (mqqHandler2 != null) {
                                                mqqHandler2.sendEmptyMessage(36);
                                                z17 = true;
                                            } else {
                                                MqqHandler handler = appInterface.getHandler(Conversation.class);
                                                if (handler != null) {
                                                    handler.sendEmptyMessage(1014);
                                                }
                                            }
                                            if (PublicAccountUtilImpl.qqLsHandler != null && PublicAccountUtilImpl.qqLsHandler.get() != null && mobileqq_mp_getpublicaccountdetailinforesponse.uin.has()) {
                                                Message obtain = Message.obtain();
                                                obtain.obj = String.valueOf(mobileqq_mp_getpublicaccountdetailinforesponse.uin.get());
                                                obtain.what = 200;
                                                ((Handler) PublicAccountUtilImpl.qqLsHandler.get()).sendMessage(obtain);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (z17) {
                            return;
                        }
                        synchronized (PublicAccountUtilImpl.class) {
                            MqqHandler mqqHandler3 = PublicAccountUtilImpl.publicAccountAIOuiHandler;
                            if (mqqHandler3 != null) {
                                mqqHandler3.sendEmptyMessage(36);
                            }
                        }
                    }
                }, 10L);
            }
        });
        appInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "sendDetailInfoRequest exit");
        }
        return newIntent;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public String getSourceId(String str) {
        if ("2105640434".equals(str)) {
            return "biz_src_gzh_bodong";
        }
        if ("2747277822".equals(str)) {
            return "biz_src_gzh_games";
        }
        if ("2080578142".equals(str)) {
            return "biz_src_gwh";
        }
        if (IPublicAccountUtil.UIN_FOR_SHOP.equals(str)) {
            return "biz_src_gzh_qqgw";
        }
        if ("2993250418".equals(str)) {
            return "biz_src_gzh_qqmusic";
        }
        if ("2909288299".equals(str)) {
            return "biz_src_gzh_news";
        }
        if (IPublicAccountUtil.UIN_FOR_WALLET.equals(str)) {
            return "biz_src_gzh_qianbao";
        }
        if (IPublicAccountBrowser.PUB_COUPON_UIN.equals(str)) {
            return "biz_src_gzh_chwl";
        }
        if ("1816533856".equals(str)) {
            return "biz_src_gzh_qqzb";
        }
        if ("3288261892".equals(str)) {
            return "biz_src_gzh_ketang";
        }
        if ("3383393803".equals(str)) {
            return "biz_src_gzh_fudao";
        }
        if (IPublicAccountUtil.UIN_FOR_HEALTH.equals(str)) {
            return "biz_src_gzh_sport";
        }
        if ("2658655094".equals(str)) {
            return "biz_src_gzh_weather";
        }
        return "biz_src_gzh";
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public String getUid(AppRuntime appRuntime, String str) {
        PublicAccountInfo publicAccountInfo;
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null && (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str)) != null) {
            return publicAccountInfo.uid;
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void getUidAsync(final String str, final IPublicAccountUtil.a<String> aVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e(IPublicAccountUtil.TAG, 1, "getUidAsync failed! runtime is null");
            invokeGetCallback(aVar, false, "");
            return;
        }
        String uid = getUid(peekAppRuntime, str);
        if (!TextUtils.isEmpty(uid)) {
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(str)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(str, uid);
            }
            invokeGetCallback(aVar, true, uid);
        } else {
            QLog.d(IPublicAccountUtil.TAG, 1, "getUidAsync get local uid failed uin: " + str);
            getPublicAccountDetail(str, new IPublicAccountUtil.a() { // from class: com.tencent.biz.pubaccount.util.api.impl.a
                @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil.a
                public final void onResult(boolean z16, Object obj) {
                    PublicAccountUtilImpl.lambda$getUidAsync$0(IPublicAccountUtil.a.this, str, z16, (IPublicAccountDetail) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public int getUinType(AppInterface appInterface, String str) {
        PublicAccountInfo publicAccountInfo;
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        return (iPublicAccountDataManager == null || (publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str)) == null || publicAccountInfo.extendType != 2) ? 1008 : 1024;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public String getVersionInfo() {
        return AppSetting.f99551k + ",3," + AppSetting.f99542b;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void gotoProfile(Intent intent, AppInterface appInterface, Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "gotoProfile app: " + appInterface + " | context: " + context + " | uin: " + str + " | accountFlag: " + i3);
        }
        if (appInterface == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        int accountType = getAccountType(appInterface, str, i3);
        if (accountType == -2 || accountType == -3 || accountType == -4) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("source", 105);
            }
        } else if (accountType == -1 && intent == null) {
            intent = new Intent();
            intent.putExtra("source", 104);
        }
        Intent intent2 = intent;
        if (accountType == -7) {
            CrmUtils.n(context, intent2, str, false, -1, true, -1);
        } else if (accountType != -6) {
            openPublicAccountProfile(intent2, context, str);
        } else if (nx.a.b(context, str)) {
            openBmqqProfile(intent2, context, str);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void gotoProfileForResult(Intent intent, AppInterface appInterface, Activity activity, String str, int i3, int i16, int i17, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "gotoProfileForResult app: " + appInterface + " | activity: " + activity + " | uin: " + str + " | accountFlag: " + i3 + " | requestCode: " + i16 + " | source: " + i17);
        }
        if (appInterface == null || activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        int accountType = getAccountType(appInterface, str, i3);
        if (accountType == -7) {
            CrmUtils.n(activity, intent, str, false, 5, true, i16);
        } else if (accountType != -6) {
            openPublicAccountProfileForResult(intent, appInterface, activity, str, i16, i17, z16);
        } else if (nx.a.b(activity, str)) {
            openBmqqProfileForResult(intent, activity, str, i16, i17);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isComeFromReadInJoy() {
        return isComeFromReadInjoy;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isDeleteOldKandian(AppInterface appInterface) {
        boolean z16;
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("mobileQQ", 0);
        synchronized (LOCK) {
            if (DELETE_OLDKANDIAN_FLAG == -1) {
                DELETE_OLDKANDIAN_FLAG = sharedPreferences.getInt(TAG_DELETE_OLDKANDIAN_FLAG + appInterface.getCurrentAccountUin(), 0);
            }
            z16 = DELETE_OLDKANDIAN_FLAG != 0;
        }
        return z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isHitPublicAccountFolderExp() {
        return j.INSTANCE.g();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isInPublicAccountFolder(long j3) {
        return isInPublicAccountFolderStatic(j3);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isInterestAccount(AppInterface appInterface, String str) {
        return getAccountType(appInterface, str) == -2;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isInterestAccountOrUnSupportMsgType(AppInterface appInterface, String str, int i3) {
        if (i3 != -2000 && i3 != -1000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isKandianHost(String str) {
        return com.tencent.biz.pubaccount.util.a.a(str);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isKandianNeedAddSkinParamsUrl(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return false;
        }
        return "kandian.qq.com".equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host) || "act.kandian.qq.com".equalsIgnoreCase(host) || "node.kandian.qq.com".equalsIgnoreCase(host);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isKandianUrl(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        return isKandianHost(parse.getHost());
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isMediaAndOtherSubscript(AppInterface appInterface, String str) {
        int accountType = getAccountType(appInterface, str);
        return accountType == -3 || accountType == -4;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isMsgTabStoryNodeListVisible() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isOnFetchMsgStage(BaseQQAppInterface baseQQAppInterface) {
        Automator automator;
        if (!(baseQQAppInterface instanceof QQAppInterface) || (automator = ((QQAppInterface) baseQQAppInterface).mAutomator) == null) {
            return false;
        }
        return automator.isInRealActionLoginB();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isPublicAccountFolderSettingShow(long j3) {
        if (((j3 >> 20) & 1) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isPublicAccountUrl(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return false;
        }
        return PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isQWalletPubAccount(Object obj) {
        String str;
        if (!(obj instanceof SessionInfo) || (str = ((SessionInfo) obj).f179557e) == null) {
            return false;
        }
        return IPublicAccountUtil.UIN_FOR_WALLET.equals(str);
    }

    public boolean isSubscribeAccount(AppInterface appInterface, String str) {
        int accountType = getAccountType(appInterface, str);
        return accountType == -3 || accountType == -4 || accountType == -2;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isSubscript(int i3, long j3) {
        int accountType = getAccountType(i3);
        return accountType == -2 || accountType == -3 || accountType == -4 || getAccountType2(j3) == -8;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void modifyIntentForSpecificBrowserIfNeeded(Intent intent, String str) {
        modifyIntentForSpecificBrowserIfNeeded(null, intent, str);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void openPublicAccountCommonAIO(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            QLog.e(IPublicAccountUtil.TAG, 1, "openPublicAccountCommonAIO failed! uin is empty");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = getNickName(peekAppRuntime, str);
        } else {
            str2 = "";
        }
        getUidAsync(str, new h(context, str, str2));
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void openPublicAccountProfile(Intent intent, Context context, String str) {
        if (intent == null) {
            intent = new Intent(context, (Class<?>) PublicAccountDetailActivityImpl.class);
        } else {
            intent.setClassName(context, PublicAccountDetailActivityImpl.class.getName());
        }
        intent.putExtra("uin", str);
        intent.addFlags(67108864);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public IPublicAccountDetail queryAccountDetail(AppInterface appInterface, String str) {
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountDetailImpl.class, str);
        createEntityManager.close();
        return publicAccountDetailImpl;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void removeLbsUin(AppInterface appInterface, String str) {
        UinPair uinPair = new UinPair(appInterface.getCurrentAccountUin(), str);
        PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) appInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
        List<UinPair> list = publicAccountHandlerImpl.lbsUinList;
        if (list != null && list.contains(uinPair)) {
            publicAccountHandlerImpl.lbsUinList.remove(uinPair);
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.remove(uinPair);
        createEntityManager.close();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void reportForPublicAccountExposure(final String str) {
        if (QLog.isColorLevel() && AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str)) {
            QLog.i(IPublicAccountUtil.TAG, 2, "reportForPublicAccountExposure, uin=" + str);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.16
            @Override // java.lang.Runnable
            public void run() {
                if (AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN.equals(str) || AppConstants.Q_ECOMMERCE_MSG_PUBLIC_ACCOUNT_UIN.equals(str)) {
                    return;
                }
                PublicAccountUtilImpl.reportPublicAccountPushRedDotExposure(str);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void reportPAShareButtonEvent(final String str) {
        final Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return;
        }
        if (PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host)) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ReportController.o(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006A68", "0X8006A68", 0, 0, parse.getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID), str, "", "");
                    } catch (Exception unused) {
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void reportPAShareItemEvent(final int i3, final String str, final int i16) {
        final Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String host = parse.getHost();
        if (TextUtils.isEmpty(host)) {
            return;
        }
        if (PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host)) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String queryParameter = parse.getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                        int i17 = i16;
                        if (i17 == 0) {
                            i17 = 100;
                        }
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006DF8", "0X8006DF8", i3, 0, queryParameter, str, "" + i17, "", false);
                        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006DF8", "", queryParameter, str, "" + i17, "" + i3);
                    } catch (Exception unused) {
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void resetDeleteOldKandian() {
        synchronized (LOCK) {
            DELETE_OLDKANDIAN_FLAG = -1;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void sendDetailInfoRequest(AppInterface appInterface, Context context, String str) {
        sendDetailInfoRequest(appInterface, context, str, -1);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void sendReadConfirm(BaseQQAppInterface baseQQAppInterface, String str) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = str;
        sessionInfo.f179555d = 1008;
        if (baseQQAppInterface instanceof QQAppInterface) {
            ChatActivityFacade.Q0((QQAppInterface) baseQQAppInterface, sessionInfo);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void setComeFromReadInJoy(boolean z16) {
        isComeFromReadInjoy = z16;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public long setInPublicAccountFolder(long j3, boolean z16) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        return (j3 & (-30721)) | (i3 << 11);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void setLSAccountDetailRequestHandler(Handler handler) {
        synchronized (PublicAccountUtilImpl.class) {
            if (handler != null) {
                qqLsHandler = new WeakReference<>(handler);
            } else {
                qqLsHandler = null;
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean shouldPreloadWebProcess(String str) {
        return IPublicAccountUtil.UIN_FOR_SHOP.equals(str) || IPublicAccountUtil.UIN_FOR_HEALTH.equals(str) || IPublicAccountUtil.UIN_FOR_WALLET.equals(str);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean showPubAccUin(AppInterface appInterface) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void unfollowUin(AppInterface appInterface, Context context, String str, boolean z16, IPublicAccountObserver iPublicAccountObserver) {
        unfollowUin(appInterface, context, str, z16, iPublicAccountObserver, false);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void updateDeleteOldKandian(AppInterface appInterface, boolean z16) {
        boolean z17;
        RecentUser findRecentUser;
        SharedPreferences sharedPreferences = appInterface.getApplication().getSharedPreferences("mobileQQ", 0);
        synchronized (LOCK) {
            if (DELETE_OLDKANDIAN_FLAG == -1) {
                DELETE_OLDKANDIAN_FLAG = sharedPreferences.getInt(TAG_DELETE_OLDKANDIAN_FLAG + appInterface.getCurrentAccountUin(), 0);
            }
            int i3 = 1;
            z17 = DELETE_OLDKANDIAN_FLAG == 0;
            if (!z16) {
                i3 = 0;
            }
            DELETE_OLDKANDIAN_FLAG = i3;
            sharedPreferences.edit().putInt(TAG_DELETE_OLDKANDIAN_FLAG + appInterface.getCurrentAccountUin(), DELETE_OLDKANDIAN_FLAG).commit();
        }
        if (z17 && z16) {
            RecentUserProxy m3 = ((QQAppInterface) appInterface).getProxyManager().m();
            if (m3 != null && (findRecentUser = m3.findRecentUser(AppConstants.OLD_KANDIAN_UIN, 1008)) != null) {
                m3.delRecentUser(findRecentUser);
                MqqHandler handler = appInterface.getHandler(Conversation.class);
                if (handler != null) {
                    handler.sendEmptyMessage(1009);
                }
            }
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                iPublicAccountDataManager.delPublicAccountInfoCache(AppConstants.OLD_KANDIAN_UIN);
                MqqHandler handler2 = appInterface.getHandler(PublicAccountFragment.class);
                if (handler2 != null) {
                    handler2.sendEmptyMessage(0);
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(IPublicAccountUtil.TAG, 2, "updateDeleteOldKandian notDeleteState = " + z17 + ", isDelete = " + z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void updateRecentList(BaseQQAppInterface baseQQAppInterface) {
        MqqHandler handler = baseQQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void videoPlayRealtimeReport(String str, String str2, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i(IPublicAccountUtil.TAG, 2, "videoPlayRealtimeReport aid=" + str + ", vid=" + str2 + ", rtype=" + i3 + ", rcode=" + i16);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof AppInterface)) {
            doVideoPlayRealtimeReport(str, str2, i3, i16);
            return;
        }
        Intent intent = new Intent("readInJoy_video_play_real_time_report");
        intent.putExtra(IPublicAccountUtil.VIDEO_REALTIME_REPORT_AID, str);
        intent.putExtra(IPublicAccountUtil.VIDEO_REALTIME_REPORT_VID, str2);
        intent.putExtra(IPublicAccountUtil.VIDEO_REALTIME_REPORT_RTYPE, i3);
        intent.putExtra(IPublicAccountUtil.VIDEO_REALTIME_REPORT_RCODE, i16);
        BaseApplicationImpl.getApplication().sendBroadcast(intent);
    }

    /* loaded from: classes32.dex */
    private static class h implements IPublicAccountUtil.a<String> {

        /* renamed from: a, reason: collision with root package name */
        private final mqq.util.WeakReference<Context> f80327a;

        /* renamed from: b, reason: collision with root package name */
        private final String f80328b;

        /* renamed from: c, reason: collision with root package name */
        private final String f80329c;

        public h(Context context, String str, String str2) {
            this.f80327a = new mqq.util.WeakReference<>(context);
            this.f80328b = str;
            this.f80329c = str2;
        }

        @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onResult(boolean z16, String str) {
            String str2;
            if (z16 && !TextUtils.isEmpty(str)) {
                final Context context = this.f80327a.get();
                if (context == null) {
                    context = MobileQQ.sMobileQQ;
                }
                final Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
                intent.putExtra("uin", this.f80328b);
                intent.putExtra("uintype", 1008);
                intent.putExtra("key_peerId", str);
                intent.addFlags(268435456);
                String str3 = this.f80329c;
                if (TextUtils.isEmpty(str3) || str3.equals(this.f80328b)) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        str2 = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getNickName(peekAppRuntime, this.f80328b);
                    } else {
                        str2 = "";
                    }
                    if (!str2.isEmpty() && !str2.equals(str3)) {
                        str3 = str2;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra("uinname", str3);
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    context.startActivity(intent);
                    return;
                } else {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            context.startActivity(intent);
                        }
                    });
                    return;
                }
            }
            QLog.e(IPublicAccountUtil.TAG, 1, "OpenAIOGetUidCallback get uid failed!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void displayToast(Context context, int i3) {
        QQToast.makeText(context, i3, 0).show();
    }

    private boolean isMediaAndOtherSubscript(int i3) {
        int accountType = getAccountType(i3);
        return accountType == -3 || accountType == -4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendDetailInfoRequest(final AppInterface appInterface, final Context context, final String str, final int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "sendDetailInfoRequest");
        }
        NewIntent newIntent = new NewIntent(context, PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_DETAIL_INFO);
        mobileqq_mp$GetPublicAccountDetailInfoRequest mobileqq_mp_getpublicaccountdetailinforequest = new mobileqq_mp$GetPublicAccountDetailInfoRequest();
        mobileqq_mp_getpublicaccountdetailinforequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        mobileqq_mp_getpublicaccountdetailinforequest.seqno.set(0);
        mobileqq_mp_getpublicaccountdetailinforequest.version.set(1);
        try {
            mobileqq_mp_getpublicaccountdetailinforequest.uin.set((int) Long.parseLong(str));
        } catch (Exception unused) {
        }
        newIntent.putExtra("data", mobileqq_mp_getpublicaccountdetailinforequest.toByteArray());
        newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.9
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i16, boolean z16, Bundle bundle) {
                boolean convert0xcf8ToMobileMP;
                if (QLog.isColorLevel()) {
                    QLog.d(IPublicAccountUtil.TAG, 2, "success:" + String.valueOf(z16));
                }
                if (!z16) {
                    PublicAccountUtilImpl.displayToast(context, R.string.d6b);
                    return;
                }
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    int i17 = bundle.getInt("type", 0);
                    if (byteArray == null) {
                        PublicAccountUtilImpl.displayToast(context, R.string.d6b);
                        return;
                    }
                    final mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
                    oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse oidb_cmd0xcf8_getpublicaccountdetailinforesponse = new oidb_cmd0xcf8$GetPublicAccountDetailInfoResponse();
                    if (i17 == 0) {
                        mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(byteArray);
                        convert0xcf8ToMobileMP = true;
                    } else {
                        convert0xcf8ToMobileMP = PublicAccountUtilImpl.convert0xcf8ToMobileMP(byteArray, oidb_cmd0xcf8_getpublicaccountdetailinforesponse, mobileqq_mp_getpublicaccountdetailinforesponse);
                    }
                    if (!convert0xcf8ToMobileMP) {
                        PublicAccountUtilImpl.displayToast(context, R.string.d6b);
                    } else if (!mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.has() || !mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.has() || mobileqq_mp_getpublicaccountdetailinforesponse.ret_info.get().ret_code.get() != 0) {
                        PublicAccountUtilImpl.displayToast(context, R.string.d6b);
                    } else {
                        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PublicAccountHandlerImpl publicAccountHandlerImpl;
                                PublicAccountDetailImpl publicAccountDetailImpl = new PublicAccountDetailImpl();
                                publicAccountDetailImpl.init(mobileqq_mp_getpublicaccountdetailinforesponse);
                                AppInterface appInterface2 = appInterface;
                                EntityManager createEntityManager = appInterface2.getEntityManagerFactory(appInterface2.getAccount()).createEntityManager();
                                if (createEntityManager != null) {
                                    createEntityManager.persistOrReplace(publicAccountDetailImpl);
                                }
                                AppInterface appInterface3 = appInterface;
                                if ((appInterface3 instanceof AppInterface) && (publicAccountHandlerImpl = (PublicAccountHandlerImpl) appInterface3.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)) != null) {
                                    publicAccountHandlerImpl.onFollowPublicAccount(publicAccountDetailImpl);
                                }
                                AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                                if (i3 >= 0) {
                                    AppInterface appInterface4 = appInterface;
                                    if (!(appInterface4 instanceof AppInterface)) {
                                        AppRuntime peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
                                        appInterface4 = (peekAppRuntime == null || !(peekAppRuntime instanceof AppInterface)) ? null : (AppInterface) peekAppRuntime;
                                    }
                                    IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                                    AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                                    iPublicAccountReportUtils.reportFollowEvent(appInterface4, str, i3);
                                }
                            }
                        }, 10L);
                    }
                } catch (Exception unused2) {
                }
            }
        });
        appInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "sendDetailInfoRequest exit");
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void deletePubAccountMsg(AppInterface appInterface, Context context, String str, int i3, long j3, boolean z16) {
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        actionSheet.setMainTitle(context.getResources().getString(R.string.dq9));
        actionSheet.addButton(R.string.f170822ak3, 3);
        if (str.equals(AppConstants.PUBLIC_ACCOUNT_QQ_MAIL)) {
            actionSheet.addButton(R.string.d5d);
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new a(qQAppInterface, str, i3, j3, z16, context, actionSheet));
        actionSheet.show();
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16) {
        followUin(appInterface, context, str, iPublicAccountObserver, z16, 0);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public int getAccountType(AppInterface appInterface, String str) {
        IPublicAccountDataManager iPublicAccountDataManager;
        int i3 = -1;
        if (appInterface == null || TextUtils.isEmpty(str) || (iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) {
            return -1;
        }
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfo(str);
        if (publicAccountInfo != null) {
            if (publicAccountInfo.extendType != 2) {
                return getAccountType(publicAccountInfo.accountFlag);
            }
        } else {
            TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
            if (k3 != null && k3.associatePubAccount != 0) {
                i3 = -4;
            }
            z zVar = (z) appInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER);
            if (zVar == null || zVar.b(str) == null) {
                return i3;
            }
        }
        return -7;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void modifyIntentForSpecificBrowserIfNeeded(MessageRecord messageRecord, Intent intent, String str) {
        TroopInfo k3;
        int indexOf;
        if (messageRecord != null) {
            try {
                if (messageRecord.istroop == 1) {
                    intent.putExtra("groupUin", messageRecord.frienduin);
                    TroopManager troopManager = (TroopManager) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
                    if (troopManager != null && (k3 = troopManager.k(messageRecord.frienduin)) != null) {
                        intent.putExtra("isAdmin", k3.isOwnerOrAdmin());
                    }
                }
                if (messageRecord.istroop == 3000) {
                    intent.putExtra("dicussgroup_uin", messageRecord.frienduin);
                }
                intent.putExtra("friend_uin", messageRecord.frienduin);
                intent.putExtra("friendUin", messageRecord.senderuin);
                intent.putExtra("uinType", messageRecord.istroop);
                intent.putExtra(QQBrowserActivity.KEY_IS_SEND, messageRecord.isSend());
                intent.putExtra("fromAio", true);
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        ComponentName component = intent.getComponent();
        if (component == null || TextUtils.isEmpty(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) == -1) {
            return;
        }
        String[] split = str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER);
        for (int i3 = 0; i3 < split.length; i3++) {
            if (split[i3].startsWith("_webviewtype=")) {
                String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length != 2 || TextUtils.isEmpty(split2[1])) {
                    return;
                }
                try {
                    if (Integer.parseInt(split2[1]) != 1) {
                        return;
                    }
                    intent.setComponent(new ComponentName(component.getPackageName(), CouponActivity.class.getName()));
                    return;
                } catch (NumberFormatException unused) {
                    return;
                }
            }
            if (split[i3].startsWith("url=")) {
                String[] split3 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length != 2 || TextUtils.isEmpty(split3[1])) {
                    return;
                }
                modifyIntentForSpecificBrowserIfNeeded(intent, URLDecoder.decode(split3[1]));
                return;
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public JSONObject parseString2Json(String str) {
        try {
            return (JSONObject) new JSONTokener(str).nextValue();
        } catch (NullPointerException | JSONException | Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void unfollowUin(AppInterface appInterface, Context context, String str, boolean z16, IPublicAccountObserver iPublicAccountObserver, boolean z17) {
        Entity entity;
        z zVar;
        if (!(appInterface instanceof QQAppInterface) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        BaseApplication context2 = BaseApplication.getContext();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        PublicAccountDetailImpl publicAccountDetailImpl = null;
        r0 = null;
        Entity entity2 = null;
        if (iPublicAccountDataManager != null) {
            PublicAccountDetailImpl publicAccountDetailImpl2 = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(str);
            if (publicAccountDetailImpl2 == null && (zVar = (z) qQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)) != null) {
                entity2 = zVar.b(str);
            }
            entity = entity2;
            publicAccountDetailImpl = publicAccountDetailImpl2;
        } else {
            entity = null;
        }
        boolean z18 = z17 || publicAccountDetailImpl == null || getAccountType(publicAccountDetailImpl.accountFlag) != -4;
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "unFollowUin() uin: " + str + "  useNewProtocol: " + z18);
        }
        if (!z17 && publicAccountDetailImpl != null && getAccountType(publicAccountDetailImpl.accountFlag) == -4) {
            NewIntent newIntent = new NewIntent(qQAppInterface.getApp().getApplicationContext(), PublicAccountServletImpl.class);
            newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
            mobileqq_mp$UnFollowRequest mobileqq_mp_unfollowrequest = new mobileqq_mp$UnFollowRequest();
            try {
                mobileqq_mp_unfollowrequest.uin.set((int) Long.parseLong(str));
                BusinessObserver dVar = new d(iPublicAccountObserver, str, z16, context2, entity == null ? entity : publicAccountDetailImpl, qQAppInterface);
                newIntent.putExtra("data", mobileqq_mp_unfollowrequest.toByteArray());
                newIntent.setObserver(dVar);
                qQAppInterface.startServlet(newIntent);
                return;
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(IPublicAccountUtil.TAG, 2, "Unfollow Request got wrong uin:" + str);
                    return;
                }
                return;
            }
        }
        com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new e(entity == null ? entity : publicAccountDetailImpl, qQAppInterface, str, iPublicAccountObserver, z16, context2), qQAppInterface);
        cVar.e(qQAppInterface);
        qQAppInterface.removeObserver(cVar);
        qQAppInterface.addObserver(cVar);
        com.tencent.mobileqq.applets.e.c(qQAppInterface, false, str, 0);
    }

    private static MessageForStructing configureStructingMsgWithFields(MessageForStructing messageForStructing, String str, String str2, String str3, String str4) {
        if (messageForStructing == null || !messageForStructing.isread) {
            return null;
        }
        MessageForStructing messageForStructing2 = (MessageForStructing) q.d(messageForStructing.msgtype);
        messageForStructing2.copyStructingMsg(messageForStructing);
        messageForStructing2.issend = 1;
        messageForStructing2.isread = true;
        if (!TextUtils.isEmpty(str)) {
            messageForStructing2.structingMsg.mMsgBrief = str;
            messageForStructing2.doPrewrite();
        }
        if (!TextUtils.isEmpty(str2)) {
            messageForStructing2.structingMsg.mArticleIds = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            messageForStructing2.structingMsg.mOrangeWord = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            try {
                messageForStructing2.time = Long.parseLong(str4);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        messageForStructing2.extInt = 0;
        messageForStructing2.extLong = 0;
        return messageForStructing2;
    }

    private static String getNonNullObejct(Object obj) {
        if (obj == null) {
            return "";
        }
        return String.valueOf(obj);
    }

    private static int getSubscriptCount(AppInterface appInterface) {
        IPublicAccountDataManager iPublicAccountDataManager;
        int size = (appInterface == null || (iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) ? 0 : ((ArrayList) iPublicAccountDataManager.getPublicAccountScriptList()).size();
        if (QLog.isColorLevel()) {
            QLog.d(IPublicAccountUtil.TAG, 2, "getSubscriptCount count: " + size);
        }
        return size;
    }

    private static long macToLong(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 6) {
                return 0L;
            }
            int i3 = 40;
            long j3 = 0;
            for (String str2 : split) {
                long parseLong = Long.parseLong(str2, 16);
                if (i3 > 0) {
                    parseLong <<= i3;
                }
                j3 += parseLong;
                i3 -= 8;
            }
            return j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static MessageForStructing newStructingMsgWithFields(AppInterface appInterface, String str, String str2, String str3, String str4) {
        MessageForStructing messageForStructing = (MessageForStructing) q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        StructMsgForGeneralShare b16 = i.b();
        messageForStructing.structingMsg = b16;
        b16.mMsgServiceID = 142;
        messageForStructing.selfuin = appInterface.getCurrentUin();
        String str5 = AppConstants.NEW_KANDIAN_UIN;
        messageForStructing.frienduin = str5;
        messageForStructing.senderuin = str5;
        messageForStructing.istroop = 1008;
        messageForStructing.issend = 1;
        messageForStructing.isread = true;
        if (!TextUtils.isEmpty(str)) {
            messageForStructing.structingMsg.mMsgBrief = str;
            messageForStructing.doPrewrite();
        }
        if (!TextUtils.isEmpty(str2)) {
            messageForStructing.structingMsg.mArticleIds = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            messageForStructing.structingMsg.mOrangeWord = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            try {
                messageForStructing.time = Long.parseLong(str4);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        messageForStructing.extInt = 0;
        messageForStructing.extLong = 0;
        return messageForStructing;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16, int i3) {
        followUin(appInterface, context, str, iPublicAccountObserver, z16, i3, false);
    }

    public static IPublicAccountConfigAttr.a getMessageHistoryInfo(PublicAccountDetailImpl publicAccountDetailImpl) {
        IPublicAccountConfigAttr.a configInfo;
        IPublicAccountConfigAttr.a configInfo2 = getConfigInfo(publicAccountDetailImpl, 0, 9);
        return (configInfo2 == null && (configInfo = getConfigInfo(publicAccountDetailImpl, 0, 0)) != null && "\u5386\u53f2\u6d88\u606f".equals(configInfo.f79330b)) ? configInfo : configInfo2;
    }

    public static Integer getMessageSetting(PublicAccountDetailImpl publicAccountDetailImpl) {
        IPublicAccountConfigAttr.a configInfo = getConfigInfo(publicAccountDetailImpl, 0, 10);
        if (configInfo == null) {
            return null;
        }
        return Integer.valueOf(configInfo.f79334f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void invokeGetCallback(IPublicAccountUtil.a<T> aVar, boolean z16, T t16) {
        if (aVar == null) {
            return;
        }
        aVar.onResult(z16, t16);
    }

    public static String pickOutFreakingPhoneNumber(PublicAccountDetailImpl publicAccountDetailImpl) {
        IPublicAccountConfigAttr.a configInfo = getConfigInfo(publicAccountDetailImpl, 0, 8);
        if (configInfo == null) {
            return null;
        }
        return configInfo.f79342n;
    }

    public static void setMessageSetting(PublicAccountDetailImpl publicAccountDetailImpl, int i3) {
        IPublicAccountConfigAttr.a configInfo = getConfigInfo(publicAccountDetailImpl, 0, 10);
        if (configInfo == null) {
            return;
        }
        configInfo.f79334f = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
    
        if (getAccountType(r0.accountFlag) == (-4)) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b0  */
    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16, int i3, boolean z17) {
        boolean z18;
        if (appInterface == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        BaseApplication context2 = BaseApplication.getContext();
        if (!z17) {
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
            z18 = false;
            if (iPublicAccountDataManager == null || (r0 = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(str)) == null) {
            }
            if (QLog.isColorLevel()) {
                QLog.d(IPublicAccountUtil.TAG, 2, "followUin() uin: " + str + "  useNewProtocol: " + z18);
            }
            if (!z18) {
                com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new b(iPublicAccountObserver, str, appInterface, context2, i3, z16));
                PublicAccountIntent publicAccountIntent = new PublicAccountIntent(context2.getApplicationContext(), NewPublicAccountServlet.class);
                publicAccountIntent.b(cVar);
                publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_CMD", "newFollow");
                publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_UIN", str);
                publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", true);
                publicAccountIntent.putExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", i3);
                appInterface.startServlet(publicAccountIntent);
                return;
            }
            NewIntent newIntent = new NewIntent(context2.getApplicationContext(), PublicAccountServletImpl.class);
            newIntent.putExtra("cmd", "follow");
            mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
            mobileqq_mp_followrequest.ext.set("" + i3);
            try {
                mobileqq_mp_followrequest.uin.set((int) Long.parseLong(str));
                newIntent.setObserver(new c(iPublicAccountObserver, str, z16, context2, appInterface, i3));
                newIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
                appInterface.startServlet(newIntent);
                return;
            } catch (NumberFormatException unused) {
                if (QLog.isColorLevel()) {
                    QLog.w(IPublicAccountUtil.TAG, 2, "Follow Request got wrong uin:" + str);
                    return;
                }
                return;
            }
        }
        z18 = true;
        if (QLog.isColorLevel()) {
        }
        if (!z18) {
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean isFollowUin(AppInterface appInterface, String str) {
        if (appInterface == null || TextUtils.isEmpty(str)) {
            return false;
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory(appInterface.getAccount()).createEntityManager();
        if (((PublicAccountInfo) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountInfo.class, str)) != null) {
            createEntityManager.close();
            return true;
        }
        PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) PublicAccountDetailImpl.class, str);
        createEntityManager.close();
        try {
            mobileqq_mp$GetPublicAccountDetailInfoResponse mobileqq_mp_getpublicaccountdetailinforesponse = new mobileqq_mp$GetPublicAccountDetailInfoResponse();
            mobileqq_mp_getpublicaccountdetailinforesponse.mergeFrom(publicAccountDetailImpl.accountData);
            return mobileqq_mp_getpublicaccountdetailinforesponse.follow_type.get() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isShopOrServiceAccount(PublicAccountDetailImpl publicAccountDetailImpl) {
        if (publicAccountDetailImpl == null) {
            return false;
        }
        int accountTypeInner = getAccountTypeInner(publicAccountDetailImpl.accountFlag);
        return accountTypeInner == -5 || accountTypeInner == -11;
    }

    private static void openPublicAccountProfileForResult(Intent intent, AppInterface appInterface, Activity activity, String str, int i3, int i16, boolean z16) {
        Intent intent2;
        if (i16 == 1) {
            PublicAccountHandlerImpl.reportClickPublicAccountEventInner(appInterface, str, IPublicAccountHandler.MAIN_ACTION, "mp_msg_sys_2", "detail");
        }
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin(IPublicAccountUtil.TAG, Long.valueOf(str).longValue()) != null) {
            Intent intent3 = new Intent();
            intent3.putExtra("uin", str);
            intent3.putExtra("chatPage", true);
            ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(activity, intent3);
            return;
        }
        if (z16) {
            String str2 = u62.a.f438482k + PluginBaseInfoHelper.Base64Helper.encodeToString(str.getBytes(), 0);
            intent2 = new Intent(activity, (Class<?>) PublicAccountBrowserImpl.class);
            intent2.putExtra("url", str2);
        } else {
            if (intent == null) {
                intent = new Intent(activity, (Class<?>) PublicAccountDetailActivityImpl.class);
            } else {
                intent.setClassName(activity, PublicAccountDetailActivityImpl.class.getName());
            }
            intent.putExtra("uin", str);
            intent.putExtra("source", 5);
            intent.addFlags(67108864);
            intent2 = intent;
        }
        activity.startActivityForResult(intent2, i3);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public boolean articleReport(String str, final int i3, final String str2) {
        final Uri parse;
        if (i3 == 0 || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getHost()) || (!PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(parse.getHost()) && !PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(parse.getHost()))) {
            return false;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.11
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String queryParameter = parse.getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8006510", "0X8006510", 0, 0, queryParameter, i3 + "", str2, "", false);
                } catch (Exception unused) {
                }
            }
        }, 5, null, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getUidAsync$0(IPublicAccountUtil.a aVar, String str, boolean z16, IPublicAccountDetail iPublicAccountDetail) {
        if (z16 && iPublicAccountDetail != null) {
            String uid = iPublicAccountDetail.getUid();
            if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(str)) {
                ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(str, uid);
            }
            invokeGetCallback(aVar, true, uid);
            return;
        }
        invokeGetCallback(aVar, false, "");
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void onPublicAccountArkMsgClick(AppInterface appInterface, ChatMessage chatMessage) {
        String str;
        if (appInterface == null || chatMessage == null) {
            return;
        }
        JSONObject jSONObject = chatMessage.mExJsonObject;
        if (jSONObject != null) {
            str = jSONObject.optString(QQHealthReportApiImpl.REPORT_KEY_BYTES_OAC_MSG_EXTEND);
        } else {
            str = "";
        }
        PublicAccountEventReport.m((QQAppInterface) appInterface, chatMessage.senderuin, 0, 6, chatMessage.msgId, str);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public void reportPAShareItemEvent(final int i3, final String str, String str2, final String str3, final String str4) {
        final int i16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            i16 = !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : 0;
        } catch (NumberFormatException unused) {
            i16 = 0;
        }
        final Uri parse = Uri.parse(str);
        if (parse != null) {
            String host = parse.getHost();
            if (TextUtils.isEmpty(host)) {
                return;
            }
            if (PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE.equalsIgnoreCase(host) || PublicAccountDetailActivityImpl.DOMAIN_MP_POST.equalsIgnoreCase(host)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.14
                    @Override // java.lang.Runnable
                    public void run() {
                        String str5;
                        try {
                            String queryParameter = parse.getQueryParameter(AppConstants.Key.SHARE_REQ_ARTICLE_ID);
                            int i17 = i16;
                            if (i17 == 0) {
                                i17 = 100;
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                String str6 = "null";
                                if (TextUtils.isEmpty(str3)) {
                                    str5 = "null";
                                } else {
                                    str5 = str3;
                                }
                                jSONObject.put("rowkey", str5);
                                if (!TextUtils.isEmpty(str4)) {
                                    str6 = str4;
                                }
                                jSONObject.put("isfan", str6);
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", IPublicAccountHandler.MAIN_ACTION, "", "0X8007F1F", "0X8007F1F", i3, 0, queryParameter, str, "" + i17, jSONObject.toString(), false);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        } catch (Exception unused2) {
                        }
                    }
                }, 5, null, false);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    public int getAccountType(AppInterface appInterface, String str, int i3) {
        int accountType = getAccountType(appInterface, str);
        return accountType == -1 ? getAccountType(i3) : accountType;
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPublicAccountUtil
    @Deprecated
    public void followUin(AppInterface appInterface, Context context, String str, IPublicAccountObserver iPublicAccountObserver, int i3) {
        if (appInterface == null || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        f fVar = new f(iPublicAccountObserver, str, appInterface, context);
        QQAppInterface qQAppInterface = (QQAppInterface) appInterface;
        appInterface.addObserver(new com.tencent.mobileqq.applets.c(fVar, qQAppInterface));
        com.tencent.mobileqq.applets.e.c(qQAppInterface, true, str, 0);
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(appInterface, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPublicAccountObserver f80295a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f80296b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppInterface f80297c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f80298d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f80299e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f80300f;

        b(IPublicAccountObserver iPublicAccountObserver, String str, AppInterface appInterface, Context context, int i3, boolean z16) {
            this.f80295a = iPublicAccountObserver;
            this.f80296b = str;
            this.f80297c = appInterface;
            this.f80298d = context;
            this.f80299e = i3;
            this.f80300f = z16;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            IPublicAccountObserver iPublicAccountObserver = this.f80295a;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(101, false, this.f80296b);
            }
            if (this.f80300f) {
                PublicAccountUtilImpl.displayToast(this.f80298d, R.string.d6b);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            IPublicAccountObserver iPublicAccountObserver = this.f80295a;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(101, true, this.f80296b);
            }
            PublicAccountUtilImpl.sendDetailInfoRequest(this.f80297c, this.f80298d, this.f80296b, this.f80299e);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 4;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f80314a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f80315b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f80316c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IPublicAccountObserver f80317d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f80318e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f80319f;

        e(Object obj, QQAppInterface qQAppInterface, String str, IPublicAccountObserver iPublicAccountObserver, boolean z16, Context context) {
            this.f80314a = obj;
            this.f80315b = qQAppInterface;
            this.f80316c = str;
            this.f80317d = iPublicAccountObserver;
            this.f80318e = z16;
            this.f80319f = context;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            IPublicAccountObserver iPublicAccountObserver = this.f80317d;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(102, false, this.f80316c);
            }
            if (this.f80318e) {
                PublicAccountUtilImpl.displayToast(this.f80319f, R.string.d6b);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            if (this.f80314a != null) {
                PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) this.f80315b.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
                if (publicAccountHandlerImpl != null) {
                    publicAccountHandlerImpl.onFollowPublicAccount(this.f80314a);
                }
            } else {
                IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.f80315b.getRuntimeService(IPublicAccountDataManager.class, "all");
                iPublicAccountDataManager.delPublicAccountInfo(this.f80316c);
                iPublicAccountDataManager.delAccountDetailInfoCache(this.f80316c);
                StructLongMessageDownloadProcessor.deleteTask(this.f80315b, this.f80316c);
                this.f80315b.getMessageFacade().q(this.f80316c, 1008);
                TroopBarAssistantManager.n().D(this.f80315b, (List) iPublicAccountDataManager.getPublicAccountEqqInfoList());
            }
            IPublicAccountObserver iPublicAccountObserver = this.f80317d;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(102, true, this.f80316c);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 5;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }

    /* loaded from: classes32.dex */
    class f extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPublicAccountObserver f80321a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f80322b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AppInterface f80323c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f80324d;

        f(IPublicAccountObserver iPublicAccountObserver, String str, AppInterface appInterface, Context context) {
            this.f80321a = iPublicAccountObserver;
            this.f80322b = str;
            this.f80323c = appInterface;
            this.f80324d = context;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            IPublicAccountObserver iPublicAccountObserver = this.f80321a;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(101, false, this.f80322b);
            }
            PublicAccountUtilImpl.displayToast(this.f80324d, R.string.d6b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            IPublicAccountObserver iPublicAccountObserver = this.f80321a;
            if (iPublicAccountObserver != null) {
                iPublicAccountObserver.onUpdate(101, true, this.f80322b);
            }
            PublicAccountUtilImpl.this.sendDetailInfoRequest(this.f80323c, this.f80324d, this.f80322b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 4;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }
}
