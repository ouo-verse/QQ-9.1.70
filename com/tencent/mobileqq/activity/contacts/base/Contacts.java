package com.tencent.mobileqq.activity.contacts.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.newfriendentry.CTNewFriendEntryController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.contact.api.IContactExpandBannerApi;
import com.tencent.mobileqq.main.api.IMainUIHelperApi;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.IQCircleContactExpandBannerApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.CommonLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qui.quiblurview.f;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.theme.TextHook;
import com.tencent.util.QUITokenResUtil;
import com.tencent.util.TokenResUtils;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* compiled from: P */
@ArgusTag(testConfigKey = "argus_contact", testTags = {"AUTO_PRELOAD"})
@Page(business = Business.Contact, type = PageHierarchy.MainPage)
/* loaded from: classes10.dex */
public class Contacts extends Frame implements View.OnClickListener, Handler.Callback, CommonLoadingView.a, nb2.a {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_COMPUTE_CONTENT_RECT = 9529;
    private static final int MSG_INIT = 9528;
    private static final int MSG_REFRESH_LOAD = 9527;
    public static final String RELATION_TAB_SHOWTIME = "relation_tab_showtime";
    public static final int RESULT_ORDER_CONVERSATION = 4;
    public static final int RESULT_ORDER_DISCUSSION = 2;
    public static final int RESULT_ORDER_FORWARD_DISCUSSION = 7;
    public static final int RESULT_ORDER_FORWARD_FRIEND = 8;
    public static final int RESULT_ORDER_FORWARD_PHONEBOOK = 9;
    public static final int RESULT_ORDER_FORWARD_RENCENTUSER = 10;
    public static final int RESULT_ORDER_FORWARD_TROOP = 6;
    public static final int RESULT_ORDER_FRIEND = 0;
    public static final int RESULT_ORDER_PHONECONTACT = 5;
    public static final int RESULT_ORDER_PUBLIC_ACCOUNT = 3;
    public static final int RESULT_ORDER_TROOP = 1;
    private static final String TAG = "Tab.Contacts";
    public static long mStartRelationTabShowTime;
    private ViewGroup commonRefreshLayout;
    private final d dirtyStateProvider;
    private com.tencent.mobileqq.observer.a mAddContactTxRedObserver;
    private RedTouch mAddContactTxRedTouch;
    private ImageView mBgImageView;
    private FrameLayout mExpandBannerView;
    MqqHandler mHandler;
    private boolean mHasInited;
    private ImageView mIvBtnRight;
    private LinearLayout mLlRoot;
    private CommonLoadingView mLoadingView;
    private RelativeLayout mNewFriendEntryView;
    private com.tencent.mobileqq.newfriend.observer.d mNewFriendVeriObserver;
    private RelativeLayout mRlTitleBar;
    private boolean mScrollToDevice;
    private j mSearchBarAsis;
    private boolean mShowPYMKCard;
    private TextView mTitle;
    private int mToastOffset;
    private com.tencent.mobileqq.activity.contacts.troopnotificationentry.b mTroopNotificationEntryController;
    private ContactsViewController mViewController;
    private CTNewFriendEntryController newFriendEntryController;
    private final MainResourceConfig resConfig;
    private RelativeLayout stausTitle;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Contacts.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.a, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else if (((Frame) Contacts.this).isResume) {
                Contacts.this.updateAddContactRedTouch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b extends com.tencent.mobileqq.newfriend.observer.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Contacts.this);
            }
        }

        @Override // com.tencent.mobileqq.newfriend.observer.d
        public void c(boolean z16, boolean z17, boolean z18, String str, boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, Boolean.valueOf(z19));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(Contacts.TAG, 2, "ui.onGetAddFriendBlockedRedPoint, success=" + z16 + ",blockedUin=" + str);
            }
            ((INewFriendService) Contacts.this.app.getRuntimeService(INewFriendService.class, "")).refreshContactUnreadCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Contacts.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (QLog.isColorLevel()) {
                QLog.d(Contacts.TAG, 2, "tabRoot click");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private class d implements f.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private int f181458a;

        /* renamed from: b, reason: collision with root package name */
        private int f181459b;

        /* renamed from: c, reason: collision with root package name */
        private int f181460c;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f181461d;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Contacts.this);
                return;
            }
            this.f181458a = -1;
            this.f181459b = -1;
            this.f181460c = -1;
            this.f181461d = new int[2];
        }

        @Override // com.tencent.qui.quiblurview.f.b
        public boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (!Contacts.this.commonRefreshLayout.isDirty()) {
                return false;
            }
            int childCount = Contacts.this.commonRefreshLayout.getChildCount();
            if (this.f181458a != childCount) {
                this.f181458a = childCount;
                return true;
            }
            int scrollY = Contacts.this.commonRefreshLayout.getScrollY();
            if (this.f181459b != scrollY) {
                this.f181459b = scrollY;
                return true;
            }
            int i3 = this.f181461d[1];
            Contacts.this.commonRefreshLayout.getLocationInWindow(this.f181461d);
            if (this.f181460c == i3) {
                return false;
            }
            this.f181460c = i3;
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68012);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            mStartRelationTabShowTime = 0L;
        }
    }

    public Contacts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHasInited = false;
        this.mScrollToDevice = false;
        this.mSearchBarAsis = null;
        this.resConfig = MainResourceConfig.f();
        this.mShowPYMKCard = false;
        this.mAddContactTxRedObserver = new a();
        this.mNewFriendVeriObserver = new b();
        this.mHandler = new MqqHandler(Looper.getMainLooper(), this);
        this.dirtyStateProvider = new d();
    }

    private void addObservers() {
        this.app.registObserver(this.mAddContactTxRedObserver);
        ((QQAppInterface) this.app).addObserver(this.mNewFriendVeriObserver);
        ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).addListener(this);
    }

    private void handleSuperThemeBg() {
        ViewGroup viewGroup = (ViewGroup) this.mLlRoot.findViewById(R.id.j8z);
        this.commonRefreshLayout = viewGroup;
        com.tencent.mobileqq.qui.b.f276860a.a(viewGroup, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            this.mBgImageView.setImageDrawable(null);
            ViewGroup viewGroup2 = this.commonRefreshLayout;
            if (viewGroup2 != null) {
                viewGroup2.setBackground(null);
                return;
            }
            return;
        }
        this.mBgImageView.setImageDrawable(null);
        if (!QQTheme.isVasTheme() && MainResourceConfig.r()) {
            this.commonRefreshLayout.setBackground(this.resConfig.l(getActivity()));
        } else {
            this.commonRefreshLayout.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.qui_common_bg_primary_bg));
        }
    }

    private void initExpandBanner() {
        View findViewById = this.mLlRoot.findViewById(R.id.b7z);
        if (findViewById == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "initExpandBanner return, headView = null");
            }
        } else {
            if (this.mExpandBannerView == null) {
                this.mExpandBannerView = (FrameLayout) findViewById.findViewById(R.id.uy7);
            }
            initImageViewBanner();
            initFriendUpdateList();
        }
    }

    private void initFriendUpdateList() {
        ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).initView(this.mExpandBannerView, !this.mShowPYMKCard);
    }

    private void initHeaderBar() {
        View findViewById = this.mLlRoot.findViewById(R.id.b7z);
        j jVar = new j((BaseActivity) getActivity(), 2, findViewById);
        this.mSearchBarAsis = jVar;
        jVar.f(this.stausTitle);
        this.mSearchBarAsis.e(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contacts.base.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Contacts.this.lambda$initHeaderBar$0(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(R.id.f7j);
        this.mNewFriendEntryView = relativeLayout;
        this.newFriendEntryController = new CTNewFriendEntryController(relativeLayout, (QQAppInterface) this.app);
        this.mNewFriendEntryView.setOnClickListener(this);
        this.mTroopNotificationEntryController = new com.tencent.mobileqq.activity.contacts.troopnotificationentry.b(findViewById, (QQAppInterface) this.app, getActivity());
        setThemeDivider();
    }

    private void initImageViewBanner() {
        ((IContactExpandBannerApi) QRoute.api(IContactExpandBannerApi.class)).initView(this.mExpandBannerView);
    }

    private void initTitleBar() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.b8b);
        this.mLlRoot = linearLayout;
        this.mRlTitleBar = (RelativeLayout) linearLayout.findViewById(R.id.idz);
        ImageView imageView = (ImageView) this.mLlRoot.findViewById(R.id.ivTitleBtnRightImage);
        this.mIvBtnRight = imageView;
        imageView.setVisibility(0);
        this.mIvBtnRight.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
        this.mIvBtnRight.setImageResource(TokenResUtils.getTokenRes(R.drawable.tab_contacts_icon, R.drawable.qui_add_friend_icon_navigation_01_selector));
        this.mIvBtnRight.setOnClickListener(this);
        this.mAddContactTxRedTouch = new RedTouch(getActivity(), this.mIvBtnRight).setGravity(21).setButtomMargin(10).applyTo();
        TextView textView = (TextView) this.mLlRoot.findViewById(R.id.ivTitleName);
        this.mTitle = textView;
        textView.setVisibility(0);
        this.stausTitle = (RelativeLayout) this.mLlRoot.findViewById(R.id.j2c);
        IphoneTitleBarActivity.setLayerType(this.mRlTitleBar);
        IphoneTitleBarActivity.setLayerType(this.mIvBtnRight);
        updateTitleBar();
        reportRightIconDTEvent();
    }

    private void initUI() {
        if (this.mToastOffset > 0) {
            return;
        }
        this.mToastOffset = getActivity().getTitleBarHeight() - ((int) al.a(getActivity(), 5.0f));
        this.mViewController.i();
        this.mViewController.r0(this.mToastOffset);
        initTitleBar();
        CommonLoadingView commonLoadingView = (CommonLoadingView) this.mLlRoot.findViewById(R.id.b5t);
        this.mLoadingView = commonLoadingView;
        commonLoadingView.setOnFirstDrawListener(this);
        this.mBgImageView = (ImageView) this.mLlRoot.findViewById(R.id.b8c);
        setThemeDiyBgContacts(-1);
        handleSuperThemeBg();
        initHeaderBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void intiFriendCallback() {
        addObservers();
        this.mViewController.e((QQAppInterface) this.app);
        setThemeDiyBgContacts(-1);
        this.newFriendEntryController.g((QQAppInterface) this.app);
        ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
        j jVar = this.mSearchBarAsis;
        if (jVar != null) {
            jVar.a((QQAppInterface) this.app);
        }
        com.tencent.mobileqq.activity.contacts.troopnotificationentry.b bVar = this.mTroopNotificationEntryController;
        if (bVar != null) {
            bVar.f((QQAppInterface) this.app, getActivity());
        }
        initExpandBanner();
        ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initHeaderBar$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ContactsViewController contactsViewController = this.mViewController;
        if (contactsViewController != null) {
            contactsViewController.q0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void onClickTitleRightButton() {
        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPage(getActivity(), 1, 3, LaunchMode.standard, new Bundle());
        ReportController.o(this.app, "CliOper", "", "", "Contacts_shortcut", "Contacts_scut", 0, 0, "", "", "", "");
        try {
            ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick(String.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_CONTACT_EXPERT));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    private void removeObservers() {
        this.app.unRegistObserver(this.mAddContactTxRedObserver);
        ((QQAppInterface) this.app).removeObserver(this.mNewFriendVeriObserver);
        ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).removeListener(this);
    }

    private void reportRightIconDTEvent() {
        VideoReport.setElementId(this.mIvBtnRight, "em_kl_add_qq_friends");
        VideoReport.setElementExposePolicy(this.mIvBtnRight, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.mIvBtnRight, ClickPolicy.REPORT_ALL);
    }

    private void setThemeDivider() {
        int i3;
        boolean z16;
        int i16;
        int i17;
        int i18 = 0;
        boolean isNowThemeIsSimple = ThemeUtil.isNowThemeIsSimple(this.app, false, null);
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        View findViewById = this.mLlRoot.findViewById(R.id.b7z);
        if (findViewById != null) {
            int f16 = BaseAIOUtils.f(12.0f, getResources());
            View findViewById2 = findViewById.findViewById(R.id.ixi);
            SimpleModeHelper.l(this.mLlRoot, isNowThemeIsSimple, f16);
            if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
                i3 = R.drawable.eot;
            } else {
                i3 = R.drawable.eos;
            }
            View findViewById3 = findViewById.findViewById(R.id.bmu);
            if (findViewById2 != null && findViewById2.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            findViewById3.setBackgroundResource(QUITokenResUtil.getResId(i3, R.drawable.qui_common_border_standard_bg));
            int i19 = 8;
            if (!isNowThemeIsSimple && !studyModeSwitch) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            findViewById3.setVisibility(i16);
            if (z16) {
                i17 = findViewById3.getVisibility();
            } else {
                i17 = 8;
            }
            findViewById3.setVisibility(i17);
            View findViewById4 = findViewById.findViewById(R.id.bmv);
            findViewById4.setBackgroundResource(QUITokenResUtil.getResId(i3, R.drawable.qui_common_border_standard_bg));
            if (isNowThemeIsSimple || studyModeSwitch) {
                i18 = 8;
            }
            findViewById4.setVisibility(i18);
            if (z16) {
                i19 = findViewById4.getVisibility();
            }
            findViewById4.setVisibility(i19);
            SimpleModeHelper.j(isNowThemeIsSimple, findViewById, i3);
            SimpleModeHelper.k(isNowThemeIsSimple, findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAddContactRedTouch() {
        if (this.mAddContactTxRedTouch != null) {
            this.mAddContactTxRedTouch.parseRedTouch(((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("101200"));
        }
    }

    private void updateTitleBar() {
        MainResourceConfig.s(this.mTitle);
        ((IMainUIHelperApi) QRoute.api(IMainUIHelperApi.class)).updateTitleBar(this, this.mRlTitleBar, this.resConfig, true);
        this.mTitle.setTextColor(getResources().getColor(R.color.qui_common_text_nav_primary));
    }

    private void updateUnreadCount(int i3, boolean z16) {
        ContactsViewController contactsViewController;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateUnreadCount|count = " + i3 + ", fromResume = " + z16);
        }
        if (this.newFriendEntryController != null) {
            List<Object> allUnreadMsg = ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).getAllUnreadMsg();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateUnreadCount|count = " + i3 + ", realcount = " + allUnreadMsg.size() + ", fromResume = " + z16);
            }
            this.newFriendEntryController.l(allUnreadMsg, !z16, z16);
        }
        if (i3 > 0 && (contactsViewController = this.mViewController) != null) {
            contactsViewController.c0();
        }
        com.tencent.mobileqq.activity.contacts.troopnotificationentry.b bVar = this.mTroopNotificationEntryController;
        if (bVar != null) {
            bVar.k();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame
    public void fillData(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        AppRuntime appRuntime = this.app;
        if (appRuntime == null || "0".equals(((QQAppInterface) appRuntime).getCurrentAccountUin())) {
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101957", false);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "initFriendDataSwitch = " + isSwitchOn);
        }
        if (isSwitchOn) {
            IFriendDataService iFriendDataService = (IFriendDataService) this.app.getRuntimeService(IFriendDataService.class, "");
            if (iFriendDataService != null) {
                iFriendDataService.initFriendCache();
                iFriendDataService.initFriendCache(new uc1.c() { // from class: com.tencent.mobileqq.activity.contacts.base.Contacts.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Contacts.this);
                        }
                    }

                    @Override // uc1.c
                    public void a() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.base.Contacts.3.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        Contacts.this.intiFriendCallback();
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            return;
        }
        intiFriendCallback();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public f.b getBlurDirtyState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (f.b) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.dirtyStateProvider;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public String getLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return getActivity().getString(R.string.c75);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ContactsViewController contactsViewController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 9528) {
            if (i3 == MSG_COMPUTE_CONTENT_RECT && (contactsViewController = this.mViewController) != null) {
                contactsViewController.S();
            }
        } else {
            this.mLoadingView.setVisibility(8);
            if (!this.mHasInited) {
                notifyResume(true);
            }
            this.mHasInited = true;
            this.mHandler.sendEmptyMessageDelayed(MSG_COMPUTE_CONTENT_RECT, 300L);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public boolean hasInited() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.mHasInited;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.notifyActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onActivityResult");
        }
        if (i3 == 1000) {
            if (i16 == 0) {
                finish();
                ((QQAppInterface) this.app).exit(false);
                return;
            }
            return;
        }
        if (i3 == 1000000) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "bind phone suc requestCode: " + i3 + ", src: 12");
                return;
            }
            return;
        }
        if (i3 == 9999) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
            }
            if (!com.tencent.mobileqq.phonecontact.util.e.a()) {
                ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.activity.contacts.report.d.n("ITEM_CLICK");
        super.notifyCreate();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCreate");
        }
        mStartRelationTabShowTime = System.currentTimeMillis();
        initUI();
        addObservers();
        ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).getUnreadMessageCountAsync();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public View notifyCreateView(LayoutInflater layoutInflater) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this, (Object) layoutInflater);
        }
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.e3x, (ViewGroup) null);
        ContactsViewController contactsViewController = new ContactsViewController(getActivity());
        this.mViewController = contactsViewController;
        contactsViewController.g(inflate);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onCreateView");
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.notifyDestroy();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        j jVar = this.mSearchBarAsis;
        if (jVar != null) {
            jVar.b();
        }
        this.mViewController.j();
        this.mHandler.removeCallbacksAndMessages(null);
        com.tencent.mobileqq.activity.contacts.troopnotificationentry.b bVar = this.mTroopNotificationEntryController;
        if (bVar != null) {
            bVar.g();
        }
        removeObservers();
        ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).onDestroy();
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        ApngImage.pauseByTag(3);
        super.notifyPause(z16);
        this.mViewController.k(z16);
        com.tencent.mobileqq.activity.contacts.report.d.f181714a.l(this.app);
        j jVar = this.mSearchBarAsis;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.ba
    public void notifyResume(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.notifyResume(z16);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onResume");
        }
        this.mViewController.l(z16);
        updateUnreadCount(((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).getAllUnreadMessageCount(), true);
        if (AppSetting.f99565y) {
            this.mTitle.setFocusable(true);
            this.mTitle.setContentDescription(getString(R.string.c75));
            getActivity().setTitle(getString(R.string.c75));
        }
        j jVar = this.mSearchBarAsis;
        if (jVar != null) {
            jVar.d();
        }
        updateAddContactRedTouch();
        ((IRedTouchManager) this.app.getRuntimeService(IRedTouchManager.class, "")).residenceReport(System.currentTimeMillis());
        ApngImage.playByTag(3);
        if (this.mScrollToDevice) {
            this.mScrollToDevice = false;
            this.mViewController.p0();
        }
        com.tencent.mobileqq.activity.contacts.troopnotificationentry.b bVar = this.mTroopNotificationEntryController;
        if (bVar != null) {
            bVar.h();
        }
        initExpandBanner();
        if (z16) {
            ((IQCircleContactExpandBannerApi) QRoute.api(IQCircleContactExpandBannerApi.class)).onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.Frame
    public void onBeforeAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        removeObservers();
        ContactsViewController contactsViewController = this.mViewController;
        if (contactsViewController != null) {
            contactsViewController.h();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) view);
        } else if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightImage) {
                onClickTitleRightButton();
            } else if (id5 == R.id.f7j) {
                this.newFriendEntryController.h();
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(getActivity(), null, 2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // nb2.a
    public void onContactCountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.widget.CommonLoadingView.a
    public void onFirstDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onFirstDraw");
        }
        this.mHandler.sendEmptyMessage(9528);
    }

    @Override // com.tencent.mobileqq.app.Frame, com.tencent.mobileqq.app.be
    public void onFrameTabClick() {
        ContactsViewController contactsViewController;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onFrameTabClick();
        if (this.mHasInited && (contactsViewController = this.mViewController) != null) {
            contactsViewController.e0();
        }
    }

    @Override // nb2.a
    public void onMayKnowStatesChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public void onPostThemeChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        setThemeDiyBgContacts(i3);
        handleSuperThemeBg();
        updateTitleBar();
        setThemeDivider();
        com.tencent.mobileqq.activity.contacts.base.c.f181500j.clear();
        j jVar = this.mSearchBarAsis;
        if (jVar != null) {
            jVar.onPostThemeChanged();
        }
        if (getContentView() != null) {
            TextHook.updateFont(getContentView());
        }
    }

    @Override // nb2.a
    public void onUnreadChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            updateUnreadCount(i3, false);
        }
    }

    public void scrollToDevice(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.mScrollToDevice = z16;
        }
    }

    void setThemeDiyBgContacts(int i3) {
        ContactsViewController contactsViewController = this.mViewController;
        if (contactsViewController != null) {
            contactsViewController.g0(i3);
        }
        RelativeLayout relativeLayout = this.mNewFriendEntryView;
        if (relativeLayout != null) {
            relativeLayout.setBackground(getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg_selector));
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.f103145zt);
        Resources resources = getResources();
        if (relativeLayout2 != null && resources != null) {
            relativeLayout2.setBackground(resources.getDrawable(R.drawable.qui_common_fill_light_primary_bg_selector));
        }
        View findViewById = findViewById(R.id.f221102u);
        if (findViewById != null) {
            findViewById.setBackground(getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg_selector));
            findViewById.setOnClickListener(new c());
        }
        ImageView imageView = this.mBgImageView;
        if (imageView == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setThemeDiyBgContacts mBgImageView == null");
                return;
            }
            return;
        }
        ThemeBackground.applyThemeBg(this.app, imageView, 3, QUITokenResUtil.getResId(R.drawable.bg_texture_theme_version2, R.drawable.qui_common_bg_primary_bg), "-contacts-");
    }
}
