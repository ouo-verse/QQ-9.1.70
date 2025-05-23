package com.tencent.mobileqq.qqexpand.profilecard;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.component.IProfileContentKey;
import com.tencent.mobileqq.profilecard.base.container.IProfileBottomContainer;
import com.tencent.mobileqq.profilecard.base.framework.IComponent;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes35.dex */
public class ProfileExtendFriendComponent extends AbsQQProfileContentComponent implements View.OnClickListener {
    private static final int N = Color.parseColor("#A6000000");
    private Dialog C;
    private Dialog D;
    private boolean E;
    private QQProgressDialog F;
    private ExpandObserver G;
    private String H;
    private boolean I;
    private PhotoWallObserver J;
    private final ExpandObserver K;
    private final Runnable L;
    private final Runnable M;

    /* renamed from: d, reason: collision with root package name */
    private Handler f264051d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f264052e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f264053f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f264054h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f264055i;

    /* renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f264056m;

    /* loaded from: classes35.dex */
    class a extends PhotoWallObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallObserver
        protected void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar, String str2) {
            ProfileExtendFriendComponent.this.K(1000L);
            QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetQZonePhotoWall isSuccess=%s", Boolean.valueOf(z16)));
        }
    }

    /* loaded from: classes35.dex */
    class b extends ExpandObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        protected void x(boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileExtendFriendComponent", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", Boolean.valueOf(z16), Integer.valueOf(i3)));
            }
            if (z16 && i3 == 2 && ((AbsProfileComponent) ProfileExtendFriendComponent.this).mDelegate != null) {
                ((AbsProfileComponent) ProfileExtendFriendComponent.this).mDelegate.requestUpdateCard();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Card f264059d;

        c(Card card) {
            this.f264059d = card;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(((AbsComponent) ProfileExtendFriendComponent.this).mApp.getCurrentAccountUin())) {
                Dialog b16 = q.b(((AbsComponent) ProfileExtendFriendComponent.this).mActivity);
                ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DB", ProfileExtendFriendComponent.this.f264053f ? 2 : 1, 0, "", "", "", "");
                if (((AbsComponent) ProfileExtendFriendComponent.this).mActivity == null || ((AbsComponent) ProfileExtendFriendComponent.this).mActivity.isFinishing()) {
                    return;
                }
                b16.show();
                return;
            }
            ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo(this.f264059d);
            Intent intent = new Intent();
            intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
            ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(((AbsComponent) ProfileExtendFriendComponent.this).mActivity, intent, 4097);
            ReportController.o(((AbsComponent) ProfileExtendFriendComponent.this).mApp, "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Card f264061d;

        d(Card card) {
            this.f264061d = card;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id5 = view.getId();
            if (id5 == R.id.ah8) {
                if (ProfileExtendFriendComponent.this.C != null && ProfileExtendFriendComponent.this.C.isShowing()) {
                    ProfileExtendFriendComponent.this.C.dismiss();
                }
                if (TextUtils.isEmpty(this.f264061d.declaration)) {
                    ReportController.o(((AbsComponent) ProfileExtendFriendComponent.this).mApp, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
                    return;
                } else {
                    ReportController.o(((AbsComponent) ProfileExtendFriendComponent.this).mApp, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (id5 == R.id.aip) {
                if (TextUtils.isEmpty(this.f264061d.declaration)) {
                    ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragment(((AbsComponent) ProfileExtendFriendComponent.this).mActivity, null);
                } else {
                    ((AbsComponent) ProfileExtendFriendComponent.this).mActivity.startActivityForResult(InterestSwitchEditActivity.V2(((AbsComponent) ProfileExtendFriendComponent.this).mActivity), 1022);
                }
                if (ProfileExtendFriendComponent.this.C != null && ProfileExtendFriendComponent.this.C.isShowing()) {
                    ProfileExtendFriendComponent.this.C.dismiss();
                }
                if (TextUtils.isEmpty(this.f264061d.declaration)) {
                    ReportController.o(((AbsComponent) ProfileExtendFriendComponent.this).mApp, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(((AbsComponent) ProfileExtendFriendComponent.this).mApp, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes35.dex */
    public class e extends ExpandObserver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
        public void d(boolean z16, Card card) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileExtendFriendComponent", 2, String.format("onGetExtendFriendInfo success=%s declaration=%s", Boolean.valueOf(z16), card != null ? card.declaration : null));
            }
            if (ProfileExtendFriendComponent.this.f264051d != null) {
                ProfileExtendFriendComponent.this.f264051d.removeCallbacks(ProfileExtendFriendComponent.this.L);
            }
            if (ProfileExtendFriendComponent.this.F != null) {
                ProfileExtendFriendComponent.this.F.dismiss();
                ProfileExtendFriendComponent.this.F = null;
            }
            if (ProfileExtendFriendComponent.this.E) {
                return;
            }
            ProfileExtendFriendComponent.this.E = true;
            ProfileExtendFriendComponent.this.addFriend();
        }
    }

    public ProfileExtendFriendComponent(IComponentCenter iComponentCenter, ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
        this.f264056m = new AtomicBoolean(false);
        this.I = false;
        this.J = new a();
        this.K = new b();
        this.L = new Runnable() { // from class: com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.3
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("ProfileExtendFriendComponent", 2, "");
                }
                if (ProfileExtendFriendComponent.this.E) {
                    return;
                }
                ProfileExtendFriendComponent.this.E = true;
                ProfileExtendFriendComponent.this.addFriend();
            }
        };
        this.M = new Runnable() { // from class: com.tencent.mobileqq.qqexpand.profilecard.ProfileExtendFriendComponent.4
            @Override // java.lang.Runnable
            public void run() {
                int top;
                if (((AbsComponent) ProfileExtendFriendComponent.this).mViewContainer == null || (top = ((View) ((AbsComponent) ProfileExtendFriendComponent.this).mViewContainer).getTop()) < 0 || ((AbsProfileComponent) ProfileExtendFriendComponent.this).mDelegate == null) {
                    return;
                }
                ((AbsProfileComponent) ProfileExtendFriendComponent.this).mDelegate.scrollToMoreInfoView(top);
            }
        };
    }

    private boolean D(Card card) {
        return false;
    }

    private boolean E() {
        if (QLog.isColorLevel()) {
            QLog.d("ProfileExtendFriendComponent", 2, String.format("checkUpdateExtendInfo mExtendRequested=%s", Boolean.valueOf(this.E)));
        }
        if (this.E || this.G != null) {
            return false;
        }
        e eVar = new e();
        this.G = eVar;
        this.mApp.addObserver(eVar);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mActivity);
        this.F = qQProgressDialog;
        qQProgressDialog.setBackAndSearchFilter(true);
        this.F.show();
        ((com.tencent.mobileqq.qqexpand.network.e) this.mApp.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).l1(this.mApp.getCurrentAccountUin(), false);
        Handler handler = this.f264051d;
        if (handler != null) {
            handler.postDelayed(this.L, 10000L);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G(Card card, ProfileContentTitleView profileContentTitleView) {
        boolean z16;
        ProfileCardExtendFriendView profileCardExtendFriendView;
        ProfileCardExtendFriendView profileCardExtendFriendView2;
        int i3;
        float[] fArr;
        ProfileCardTemplate profileCardTemplate;
        boolean isInNightMode = ThemeUtil.isInNightMode(this.mApp);
        boolean z17 = ((ProfileCardInfo) this.mData).currentTemplate != null;
        View contentView = profileContentTitleView.getContentView();
        boolean z18 = contentView != null && (!z17 ? contentView.getTag(R.id.p0v) == null : (profileCardTemplate = (ProfileCardTemplate) contentView.getTag(R.id.p0v)) != null && profileCardTemplate.equals(((ProfileCardInfo) this.mData).currentTemplate));
        if (contentView != null && Boolean.FALSE.equals(contentView.getTag(R.id.p0w)) && Boolean.valueOf(isInNightMode).equals(contentView.getTag(R.id.p0x)) && !z18) {
            profileCardExtendFriendView2 = (ProfileCardExtendFriendView) contentView;
        } else {
            profileContentTitleView.removeContentViews();
            profileContentTitleView.setFocusable(false);
            profileContentTitleView.setClickable(false);
            if (z17) {
                Object obj = ((ProfileCardInfo) this.mData).currentTemplate.templateAttr.get("commonItemContentColor");
                if (obj != null) {
                    if (obj instanceof ColorStateList) {
                        i3 = ((ColorStateList) obj).getDefaultColor();
                    } else if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.startsWith("#")) {
                            i3 = Color.parseColor(str);
                        }
                    }
                    fArr = new float[3];
                    Color.colorToHSV(i3, fArr);
                    if (fArr[2] > 0.5f) {
                        z16 = true;
                        if (!isInNightMode) {
                            profileCardExtendFriendView = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo) this.mData).currentTemplate, true);
                        } else if (z17) {
                            profileCardExtendFriendView = new ProfileCardExtendFriendView(this.mActivity, ((ProfileCardInfo) this.mData).currentTemplate, z16);
                        } else {
                            profileCardExtendFriendView = new ProfileCardExtendFriendView(this.mActivity);
                        }
                        profileCardExtendFriendView2 = profileCardExtendFriendView;
                        profileCardExtendFriendView2.x(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
                        profileCardExtendFriendView2.setFromExtendFriend(this.f264053f);
                        if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 96 || this.f264053f) {
                            profileCardExtendFriendView2.setFold(false);
                        }
                        profileCardExtendFriendView2.setClickable(true);
                        profileCardExtendFriendView2.setTag(R.id.p0w, Boolean.FALSE);
                        profileCardExtendFriendView2.setTag(R.id.p0x, Boolean.valueOf(isInNightMode));
                        profileCardExtendFriendView2.setTag(R.id.p0v, ((ProfileCardInfo) this.mData).currentTemplate);
                        profileContentTitleView.addContentView(profileCardExtendFriendView2);
                    }
                }
                i3 = 0;
                fArr = new float[3];
                Color.colorToHSV(i3, fArr);
                if (fArr[2] > 0.5f) {
                }
            }
            z16 = false;
            if (!isInNightMode) {
            }
            profileCardExtendFriendView2 = profileCardExtendFriendView;
            profileCardExtendFriendView2.x(ProfileTemplateApi.getTemplateUtils(this.mComponentCenter));
            profileCardExtendFriendView2.setFromExtendFriend(this.f264053f);
            if (((ProfileCardInfo) this.mData).allInOne.f260789pa != 96) {
            }
            profileCardExtendFriendView2.setFold(false);
            profileCardExtendFriendView2.setClickable(true);
            profileCardExtendFriendView2.setTag(R.id.p0w, Boolean.FALSE);
            profileCardExtendFriendView2.setTag(R.id.p0x, Boolean.valueOf(isInNightMode));
            profileCardExtendFriendView2.setTag(R.id.p0v, ((ProfileCardInfo) this.mData).currentTemplate);
            profileContentTitleView.addContentView(profileCardExtendFriendView2);
        }
        if (ProfileTemplateApi.getDiyMoreInfoManager(this.mComponentCenter).isDiy()) {
            profileCardExtendFriendView2.setDiyCard(true);
            profileCardExtendFriendView2.setProfileCardFavorShowView(profileContentTitleView);
        } else {
            profileCardExtendFriendView2.setDiyCard(false);
        }
        profileCardExtendFriendView2.setIsFromLimitChat(this.f264054h);
        profileCardExtendFriendView2.m(card, this.mQQAppInterface);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H() {
        if (TextUtils.equals(((ProfileCardInfo) this.mData).card.uin, this.mApp.getCurrentAccountUin())) {
            if (M()) {
                ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DB", this.f264053f ? 2 : 1, 0, "", "", "", "");
                return;
            }
            ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo(((ProfileCardInfo) this.mData).card);
            Intent intent = new Intent();
            intent.putExtra(IExpandFragmentRouter.KEY_EXTEND_FRIEND_INFO, extendFriendInfo);
            ((IExpandFragmentRouter) QRoute.api(IExpandFragmentRouter.class)).launchExpandEditFragmentForResult(this.mActivity, intent, 4097);
            return;
        }
        boolean C = ExpandChatUtil.C(this.mQQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d("ProfileExtendFriendComponent", 2, "handleExtendFriendTitleClick showEntry = " + C);
        }
        if (this.f264054h || !C) {
            return;
        }
        ((IExpandEntrance) QRoute.api(IExpandEntrance.class)).enterExpand(this.mActivity, this.mApp, 5);
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).reportEnterExpandClick("6");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView, VIEW] */
    private boolean J(Card card, boolean z16) {
        boolean z17;
        if (!D(card)) {
            if (this.mViewContainer == 0) {
                return false;
            }
            this.mViewContainer = null;
            return true;
        }
        if (this.mViewContainer == 0) {
            ?? profileContentTitleView = new ProfileContentTitleView(this.mActivity);
            profileContentTitleView.setTitle(this.mActivity.getString(R.string.x6p));
            if (this.f264054h) {
                profileContentTitleView.setArrowEnable(false);
            }
            this.mViewContainer = profileContentTitleView;
            z17 = true;
        } else {
            z17 = false;
        }
        ProfileContentTitleView profileContentTitleView2 = (ProfileContentTitleView) this.mViewContainer;
        boolean isInNightMode = ThemeUtil.isInNightMode(this.mApp);
        boolean z18 = ((ProfileCardInfo) this.mData).currentTemplate != null;
        if (TextUtils.equals(card.uin, this.mApp.getCurrentAccountUin())) {
            if (TextUtils.isEmpty(card.declaration)) {
                F(profileContentTitleView2, card, isInNightMode, z18);
            } else {
                G(card, profileContentTitleView2);
            }
        } else {
            G(card, profileContentTitleView2);
        }
        profileContentTitleView2.mTitleContainer.setTag(new com.tencent.mobileqq.profile.b(87, null));
        profileContentTitleView2.mTitleContainer.setOnClickListener(this);
        profileContentTitleView2.setArrowEnable(ExpandChatUtil.C(this.mApp));
        updateItemTheme(profileContentTitleView2, true);
        K(5000L);
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(long j3) {
        if (this.f264052e || (this.f264053f && !this.f264055i)) {
            if (this.f264051d == null) {
                QLog.w("ProfileExtendFriendComponent", 1, "mHandler is null, can not scroll");
            } else if (this.f264056m.compareAndSet(false, true)) {
                this.f264051d.postDelayed(this.M, j3);
            }
        }
    }

    private boolean M() {
        if (!((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(this.mApp.getCurrentAccountUin())) {
            return false;
        }
        if (this.D == null) {
            this.D = q.b(this.mActivity);
        }
        if (!this.D.isShowing() && !this.mActivity.isFinishing()) {
            this.D.show();
        }
        ReportController.o(this.mApp, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFriend() {
        IComponent component = getComponentCenter().getComponent(107);
        if (component instanceof IProfileBottomContainer) {
            ((IProfileBottomContainer) component).addFriend();
        }
    }

    public boolean I(ProfileCardInfo profileCardInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", String.valueOf(profileCardInfo.allInOne.subSourceId));
        hashMap.put("to_uid", profileCardInfo.allInOne.uin);
        hashMap.put(ServiceConst.PARA_SESSION_ID, LimitChatUtil.A(this.mApp.getCurrentAccountUin(), profileCardInfo.allInOne.uin));
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#add_friends_all", true, -1L, -1L, hashMap, true, true);
        if (!M()) {
            return L();
        }
        ReportController.o(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public String getComponentName() {
        return "ProfileExtendFriendComponent";
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.IComponent
    public int getComponentType() {
        return 1008;
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.component.AbsProfileContentComponent
    public String getProfileContentKey() {
        return IProfileContentKey.MAP_KEY_EXTEND_FRIEND;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 4097 && i16 == 8193) {
            this.f264053f = true;
            this.mActivity.setResult(8193);
            IProfileActivityDelegate iProfileActivityDelegate = this.mDelegate;
            if (iProfileActivityDelegate != null) {
                iProfileActivityDelegate.requestUpdateCard();
            }
            DATA data = this.mData;
            if (data != 0 && ((ProfileCardInfo) data).card != null) {
                str = ((ProfileCardInfo) data).allInOne.uin;
            } else {
                str = "";
            }
            ProfileCardDtReportUtil.reportCommonEvent(this.mApp, str, "ev_profile_completekuolie");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view.getTag() instanceof com.tencent.mobileqq.profile.b) && ((com.tencent.mobileqq.profile.b) view.getTag()).f260135a == 87) {
            H();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.base.component.AbsQQProfileContentComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(QBaseActivity qBaseActivity, Bundle bundle) {
        super.onCreate(qBaseActivity, bundle);
        Intent intent = this.mActivity.getIntent();
        if (intent != null) {
            this.f264053f = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS, false);
            this.f264054h = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_EXTENDS_FRIENDS_LIMIT_CHAT, false);
            this.f264055i = intent.getBooleanExtra(IProfileCardConst.KEY_FROM_LIMIT_CHAT_PLUS, false);
            this.f264052e = intent.getBooleanExtra("profile_scroll_to_extend_friend", false);
        }
        this.f264051d = new Handler(Looper.getMainLooper());
        this.mApp.addObserver(this.J);
        this.mApp.addObserver(this.K);
    }

    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        Handler handler = this.f264051d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f264051d = null;
        }
        this.mApp.removeObserver(this.J);
        this.mApp.removeObserver(this.K);
        ExpandObserver expandObserver = this.G;
        if (expandObserver != null) {
            this.mApp.removeObserver(expandObserver);
            this.G = null;
        }
        QQProgressDialog qQProgressDialog = this.F;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.F = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onPause() {
        super.onPause();
        VIEW view = this.mViewContainer;
        if (view == 0 || !(view instanceof ProfileContentTitleView)) {
            return;
        }
        View contentView = ((ProfileContentTitleView) view).getContentView();
        if (contentView instanceof ProfileCardExtendFriendView) {
            ((ProfileCardExtendFriendView) contentView).t();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F(ProfileContentTitleView profileContentTitleView, Card card, boolean z16, boolean z17) {
        View view;
        Object obj;
        View childAt = profileContentTitleView.getChildAt(0);
        if (childAt != null && Boolean.TRUE.equals(childAt.getTag(0)) && Boolean.valueOf(z16).equals(childAt.getTag(1)) && ((ProfileCardInfo) this.mData).currentTemplate.equals(childAt.getTag(2))) {
            return;
        }
        profileContentTitleView.removeContentViews();
        if (!z16 && !z17) {
            view = LayoutInflater.from(this.mActivity).inflate(R.layout.f167380d05, (ViewGroup) null);
            View findViewById = view.findViewById(R.id.p19);
            String e16 = com.tencent.mobileqq.qqexpand.utils.e.e("expand_summary_default_bg.png");
            if (com.tencent.mobileqq.filemanager.util.q.p(e16)) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(com.tencent.mobileqq.qqexpand.utils.e.a(e16, null));
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (this.mActivity.getResources().getDisplayMetrics().widthPixels / (r0.getWidth() / r0.getHeight()))));
                findViewById.setBackgroundDrawable(bitmapDrawable);
            }
        } else {
            View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.d06, (ViewGroup) null);
            inflate.setTag(R.id.p0w, Boolean.TRUE);
            inflate.setTag(R.id.p0x, Boolean.valueOf(z16));
            inflate.setTag(R.id.p0v, ((ProfileCardInfo) this.mData).currentTemplate);
            TextView textView = (TextView) inflate.findViewById(R.id.f163242p24);
            TextView textView2 = (TextView) inflate.findViewById(R.id.f163243p25);
            try {
                Drawable drawable = this.mActivity.getResources().getDrawable(R.drawable.f4u);
                if (z16) {
                    drawable.setColorFilter(N, PorterDuff.Mode.SRC_ATOP);
                }
                inflate.setBackgroundDrawable(drawable);
            } catch (OutOfMemoryError e17) {
                QLog.e("ProfileExtendFriendComponent", 1, e17, new Object[0]);
            }
            if (z17 && (obj = ((ProfileCardInfo) this.mData).currentTemplate.templateAttr.get("commonItemContentColor")) != null) {
                if (obj instanceof ColorStateList) {
                    ColorStateList colorStateList = (ColorStateList) obj;
                    textView.setTextColor(colorStateList);
                    textView2.setTextColor(colorStateList);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.startsWith("#")) {
                        textView.setTextColor(Color.parseColor(str));
                        textView2.setTextColor(Color.parseColor(str));
                    }
                }
            }
            view = inflate;
        }
        view.setClickable(true);
        view.findViewById(R.id.f163241p23).setOnClickListener(new c(card));
        profileContentTitleView.addContentView(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponent
    public boolean onDataUpdate(ProfileCardInfo profileCardInfo) {
        Card card;
        boolean onDataUpdate = super.onDataUpdate((ProfileExtendFriendComponent) profileCardInfo);
        DATA data = this.mData;
        boolean J = onDataUpdate | J(((ProfileCardInfo) data).card, ((ProfileCardInfo) data).isNetRet);
        if (J && !this.I) {
            this.I = true;
            ProfileCardDtReportUtil.initElementWithExposure((View) this.mViewContainer, ProfileCardDtReportUtil.DT_REPORT_EXTEND_FRIEND);
        }
        if (profileCardInfo != null && (card = profileCardInfo.card) != null) {
            this.H = card.uin;
        }
        return J;
    }

    private boolean L() {
        Card r16;
        boolean z16 = false;
        if (this.f264054h || (r16 = ((FriendsManager) this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.mApp.getCurrentUin())) == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileExtendFriendComponent", 2, String.format("showExtendFriendProfileGuide declaration=%s isShowCard=%s", r16.declaration, Boolean.valueOf(r16.isShowCard)));
        }
        if (TextUtils.isEmpty(r16.declaration) && E()) {
            return true;
        }
        if (TextUtils.isEmpty(r16.declaration) || !r16.isShowCard) {
            Dialog a16 = q.a(this.mActivity, TextUtils.isEmpty(r16.declaration) ? 1 : 2, new d(r16));
            this.C = a16;
            try {
                a16.show();
                z16 = true;
            } catch (Exception e16) {
                QLog.e("ProfileExtendFriendComponent", 1, "showExtendFriendProfileGuide fail.", e16);
            }
            if (TextUtils.isEmpty(r16.declaration)) {
                ReportController.o(this.mApp, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.mApp, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
            }
        }
        return z16;
    }
}
