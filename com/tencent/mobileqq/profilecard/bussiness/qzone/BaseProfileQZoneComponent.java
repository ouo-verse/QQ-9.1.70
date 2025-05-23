package com.tencent.mobileqq.profilecard.bussiness.qzone;

import SummaryCard.PhotoInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hitrate.b;
import com.tencent.mobileqq.hitrate.d;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneJumpPageApi;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Marker;

/* loaded from: classes16.dex */
public abstract class BaseProfileQZoneComponent extends AbsQQProfileContentComponent implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    static int ACTION_TYPE = 0;
    public static final int BASE_BIG_PIC_NUMBER = 3;
    public static final int BASE_BIG_TEXT_NUMBER = 4;
    public static final int BASE_SMALL_PIC_NUMBER = 4;
    public static final int BASE_SMALL_TEXT_NUMBER = 3;
    public static final String KEY_IMAGE_URL = "imageUrl";
    public static final String KEY_IS_VIDEO = "isVideo";
    public static final int MAX_URL_IMAGE_SIZE = 3;
    public static final int SUBTHREAD_MSG_PERSIST_CARD = 6;
    public static final int SUBTHREAD_MSG_UPDATE_CARD = 5;
    static int SUB_ACTION_TYPE_3 = 0;
    static int SUB_ACTION_TYPE_8 = 0;
    private static final String TAG = "BaseProfileQZoneComponent";
    public static IQZoneApiProxy mQZoneApiProxy;
    protected boolean isBlacklist;
    private boolean isInitDtReport;
    public WeakReferenceHandler mAsyncThreadHandler;
    public boolean mIsFromArkBabyQ;
    protected PhotoInfo mLastPhotoInfo;
    protected int mLastPhotoListSize;
    public final b mPreloadHitSession;
    public ColorDrawable mQzoneDefaultPic;
    public float mScreenWidth;
    public WeakReferenceHandler mUiHandler;
    private View photoView;
    protected int photoVisibilityState;
    public int qzonePicNums;
    private View tipsView;
    protected int tipsVisibilityState;

    /* loaded from: classes16.dex */
    public static class WebProcessStartedListener implements u {
        static IPatchRedirector $redirector_;
        private WeakReference<d> mPreloadHitSessionRef;

        WebProcessStartedListener(d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
            } else {
                this.mPreloadHitSessionRef = new WeakReference<>(dVar);
            }
        }

        @Override // com.tencent.mobileqq.webview.util.u
        public void onResult(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (z16) {
                d dVar = this.mPreloadHitSessionRef.get();
                if (dVar != null) {
                    dVar.a();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(BaseProfileQZoneComponent.TAG, 2, "check friend's profile and preload web-process!");
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74140);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        mQZoneApiProxy = null;
        ACTION_TYPE = 699;
        SUB_ACTION_TYPE_3 = 3;
        SUB_ACTION_TYPE_8 = 8;
    }

    public BaseProfileQZoneComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iComponentCenter, (Object) profileCardInfo);
            return;
        }
        this.qzonePicNums = 0;
        this.mPreloadHitSession = new b("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.getQZonePluginName());
        this.isInitDtReport = false;
        this.photoVisibilityState = 0;
        this.tipsVisibilityState = 0;
        this.isBlacklist = false;
    }

    public static String getKeyForMd5(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!NetworkUtils.isNetworkUrl(str)) {
            return str;
        }
        int indexOf = str.indexOf("//");
        if (indexOf != -1) {
            str2 = str.substring(indexOf + 2);
        }
        int indexOf2 = str2.indexOf("/");
        if (indexOf2 != -1) {
            str2 = str2.substring(indexOf2 + 1);
        }
        if (str.indexOf(ContainerUtils.FIELD_DELIMITER) == -1) {
            return str2;
        }
        return str2.substring(0, str2.indexOf(ContainerUtils.FIELD_DELIMITER));
    }

    private static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void qzGoQzoneUserHomeActivity(int i3) {
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        if (isInterceptQZoneSkip(i3)) {
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null) {
                qBaseActivity.finish();
                return;
            }
            return;
        }
        String currentNickname = qQAppInterface.getCurrentNickname();
        if (TextUtils.isEmpty(currentNickname)) {
            currentNickname = qQAppInterface.getCurrentNickname();
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = qQAppInterface.getCurrentAccountUin();
        userInfo.nickname = currentNickname;
        byte[] bArr = profileCardInfo.card.vQzoneCoverInfo;
        Object[] objArr = new Object[2];
        int i16 = 0;
        objArr[0] = bArr;
        if (bArr != null) {
            i16 = bArr.length;
        }
        objArr[1] = Integer.valueOf(i16);
        log(String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", objArr));
        QBaseActivity qBaseActivity2 = this.mActivity;
        AllInOne allInOne = profileCardInfo.allInOne;
        QZoneHelper.forwardToUserHome(qBaseActivity2, userInfo, allInOne.uin, allInOne.lastActivity, -1, 5, this.mPreloadHitSession, bArr, false);
        QZoneClickReport.ReportInfo reportInfo = new QZoneClickReport.ReportInfo();
        reportInfo.actionType = "1";
        reportInfo.subactionType = "0";
        reportInfo.tabletype = 4;
        reportInfo.sourceType = "3";
        reportInfo.sourceFrom = QZoneClickReport.ClickReportConfig.SOURCE_FROM_USERPROFILE;
        reportInfo.sourceTo = QZoneClickReport.ClickReportConfig.SOURCE_TO_USERHOME;
        QZoneClickReport.startReportImediately(qQAppInterface.getAccount(), reportInfo);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE, "3");
        hashMap.put("source_from", QZoneClickReport.ClickReportConfig.SOURCE_FROM_USERPROFILE);
        hashMap.put("source_to", QZoneClickReport.ClickReportConfig.SOURCE_TO_USERHOME);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getAccount(), StatisticCollector.QZONE_SOURCE_DATA_REPORT, true, 0L, 0L, hashMap, null);
    }

    public static void setVisible(View view, boolean z16) {
        int i3;
        if (view != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkBlackListForbid(View view, View view2) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, (Object) view2);
            return;
        }
        this.photoView = view;
        this.tipsView = view2;
        int i16 = 8;
        if (view != null) {
            if (this.isBlacklist) {
                i3 = 8;
            } else {
                i3 = this.photoVisibilityState;
            }
            view.setVisibility(i3);
        }
        if (view2 != null) {
            if (!this.isBlacklist) {
                i16 = this.tipsVisibilityState;
            }
            view2.setVisibility(i16);
        }
    }

    public void forwardToWriteMood() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        Intent intent = this.mActivity.getIntent();
        intent.putExtra(QZoneJsConstants.WRITE_MOOD_FROM_PROFILE_CARD, true);
        intent.putExtra(QZoneJsConstants.KEY_NEW_CARD_IS_NEED_SHOW, true);
        QZoneHelper.forwardToWriteMood(this.mActivity, this.mApp.getCurrentAccountUin(), 1037);
        LpReportInfo_pf00064.allReport(ACTION_TYPE, SUB_ACTION_TYPE_8);
        LpReportInfo_pf00064.allReport(586, 1, 6);
    }

    public int getColumnCount(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) card)).intValue();
        }
        if (card != null && card.enlargeQzonePic == 1) {
            return 3;
        }
        return 4;
    }

    public int getTextCount(Card card) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) card)).intValue();
        }
        if (card != null && card.enlargeQzonePic == 1) {
            return 4;
        }
        return 3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        int i3 = message.what;
        if (i3 != 5) {
            if (i3 == 6) {
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
                createEntityManager.persist((Card) message.obj);
                createEntityManager.close();
                return false;
            }
            return false;
        }
        EntityManager createEntityManager2 = qQAppInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager2.update((Card) message.obj);
        createEntityManager2.close();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean isDIYTemplateProfile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ProfileCardInfo profileCardInfo = (ProfileCardInfo) this.mData;
        if (profileCardInfo != null) {
            return ProfileTemplateApi.isDiyTemplateStyleID(profileCardInfo.curUseStyleId);
        }
        return false;
    }

    public boolean isInterceptQZoneSkip(int i3) {
        Context applicationContext;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, i3)).booleanValue();
        }
        if (AppSetting.t(BaseApplication.getContext())) {
            return false;
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (qBaseActivity == null) {
            applicationContext = null;
        } else {
            applicationContext = qBaseActivity.getApplicationContext();
        }
        if (i3 == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean isCallToProfileCard = ((IQZoneJumpPageApi) QRoute.api(IQZoneJumpPageApi.class)).isCallToProfileCard(applicationContext);
        QZLog.d(TAG, 1, "[isInterceptQZoneSkip] entry type: " + i3 + " | isProfileEntryQZone: " + z16 + " | isNewSimpleSkipExp: " + isCallToProfileCard);
        if (!z16 || isCallToProfileCard) {
            return false;
        }
        return true;
    }

    public boolean isSamePhotoInfo(PhotoInfo photoInfo, PhotoInfo photoInfo2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) photoInfo, (Object) photoInfo2)).booleanValue();
        }
        if (photoInfo == null || photoInfo2 == null) {
            return false;
        }
        if (photoInfo == photoInfo2) {
            return true;
        }
        if (photoInfo.uPhotoTimestamp != photoInfo2.uPhotoTimestamp || !TextUtils.equals(getKeyForMd5(photoInfo.strPicUrl), getKeyForMd5(photoInfo2.strPicUrl))) {
            return false;
        }
        return true;
    }

    public abstract boolean makeOrRefreshQZone(Card card);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        DATA data;
        ArrayList<String> stringArrayListExtra;
        Card r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1037 && i16 == -1 && intent != null && (data = this.mData) != 0 && ((ProfileCardInfo) data).allInOne != null && ((ProfileCardInfo) data).allInOne.f260789pa == 0 && (stringArrayListExtra = intent.getStringArrayListExtra("imageUrl")) != null && stringArrayListExtra.size() > 0) {
            FriendsManager friendsManager = (FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager == null) {
                r16 = null;
            } else {
                r16 = friendsManager.r(((ProfileCardInfo) this.mData).allInOne.uin);
            }
            if (r16 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < stringArrayListExtra.size() && i17 < 3; i17++) {
                    arrayList.add(Boolean.valueOf(intent.getBooleanExtra(KEY_IS_VIDEO + i17, false)));
                }
                r16.addQZonePhotoList(stringArrayListExtra, arrayList);
                r16.hasFakeData = true;
                DATA data2 = this.mData;
                ((ProfileCardInfo) data2).card = r16;
                makeOrRefreshQZone(((ProfileCardInfo) data2).card);
            }
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent
    public void onBlacklistConfigureChange(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            if (this.isBlacklist == z17) {
                return;
            }
            this.isBlacklist = z17;
            checkBlackListForbid(this.photoView, this.tipsView);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qBaseActivity, (Object) bundle);
            return;
        }
        Intent intent = qBaseActivity.getIntent();
        if (intent != null) {
            this.mIsFromArkBabyQ = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_ARK_BABYQ, false);
        }
        super.onCreate(qBaseActivity, bundle);
        DisplayMetrics displayMetrics = qBaseActivity.getResources().getDisplayMetrics();
        this.mScreenWidth = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mAsyncThreadHandler = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.mUiHandler = new WeakReferenceHandler(Looper.getMainLooper(), null);
        ThreadManagerV2.post(new Runnable((ProfileCardInfo) this.mData) { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ProfileCardInfo val$cardInfo;

            {
                this.val$cardInfo = r5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfileQZoneComponent.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(this.val$cardInfo.allInOne.uin)) {
                        String str = this.val$cardInfo.allInOne.uin;
                        if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                            str = this.val$cardInfo.allInOne.uin.substring(1);
                        }
                        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(BaseProfileQZoneComponent.ACTION_TYPE, 1, Long.valueOf(str).longValue()), false, false);
                    }
                } catch (Exception e16) {
                    QZLog.e("QzoneReport", "LpReportInfoProfile", e16);
                }
            }
        }, 8, null, true);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        WeakReferenceHandler weakReferenceHandler = this.mAsyncThreadHandler;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.mAsyncThreadHandler.removeMessages(0);
            this.mAsyncThreadHandler = null;
        }
        this.mPreloadHitSession.b();
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onResume();
        QQAppInterface qQAppInterface = this.mQQAppInterface;
        if (qQAppInterface != null) {
            IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) qQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
            if (iWebProcessManagerService != null) {
                iWebProcessManagerService.startWebProcess(17, new WebProcessStartedListener(this.mPreloadHitSession));
            }
            QZoneHelper.preloadInFriendProfileCard(qQAppInterface, this.mPreloadHitSession);
        }
    }

    public void startQzoneShowFeed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseProfileQZoneComponent.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    Card r16;
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    ProfileCardInfo profileCardInfo = (ProfileCardInfo) ((AbsComponent) BaseProfileQZoneComponent.this).mData;
                    FriendsManager friendsManager = (FriendsManager) ((AbsQQProfileContentComponent) BaseProfileQZoneComponent.this).mQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                    if (friendsManager == null) {
                        r16 = null;
                    } else {
                        r16 = friendsManager.r(profileCardInfo.allInOne.uin);
                    }
                    int i3 = 0;
                    if (r16 == null) {
                        r16 = new Card();
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    r16.feedPreviewTime = System.currentTimeMillis();
                    r16.strQzoneFeedsDesc = "";
                    Message obtain = Message.obtain();
                    obtain.obj = r16;
                    if (z16) {
                        obtain.what = 6;
                    } else {
                        obtain.what = 5;
                    }
                    WeakReferenceHandler weakReferenceHandler = BaseProfileQZoneComponent.this.mAsyncThreadHandler;
                    if (weakReferenceHandler != null) {
                        weakReferenceHandler.sendMessage(obtain);
                    }
                    AllInOne allInOne = profileCardInfo.allInOne;
                    if (allInOne != null) {
                        i3 = allInOne.profileEntryType;
                    }
                    BaseProfileQZoneComponent.this.qzGoQzoneUserHomeActivity(i3);
                }
            }, 8, null, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    /* renamed from: onDataUpdate, reason: merged with bridge method [inline-methods] */
    public boolean lambda$checkValidComponent$3(ProfileCardInfo profileCardInfo) {
        VIEW view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) profileCardInfo)).booleanValue();
        }
        boolean lambda$checkValidComponent$3 = super.lambda$checkValidComponent$3((BaseProfileQZoneComponent) profileCardInfo) | makeOrRefreshQZone(((ProfileCardInfo) this.mData).card);
        if (lambda$checkValidComponent$3 && !this.isInitDtReport && (view = this.mViewContainer) != 0) {
            this.isInitDtReport = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) view, ProfileCardDtReportUtil.DT_REPORT_QZONE);
        }
        return lambda$checkValidComponent$3;
    }
}
