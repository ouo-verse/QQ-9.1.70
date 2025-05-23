package com.tencent.mobileqq.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.cf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;
import com.tencent.mobileqq.profilecard.vas.VasProfileCardHeaderUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.mask.VasMaskUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.pendant.drawable.AvatarPendantFileUtil;
import com.tencent.mobileqq.vas.pendant.drawable.PendantConstant;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.RoundedImageView;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class FriendProfileImageActivity extends BaseActivity implements View.OnClickListener, Runnable, cf.a, Handler.Callback {
    static IPatchRedirector $redirector_;
    private int A0;
    private com.tencent.mobileqq.utils.ad B0;
    private boolean C0;
    private QUIButton D0;
    AllInOne E0;
    private com.tencent.mobileqq.hitrate.d F0;
    QQProgressDialog G0;
    AlphaAnimation H0;
    AlphaAnimation I0;
    Runnable J0;
    private long K0;
    private long L0;
    private Rect M0;
    private boolean N0;
    boolean O0;
    private View.OnClickListener P0;
    private QQToastNotifier Q0;

    /* renamed from: a0, reason: collision with root package name */
    Gallery f175898a0;

    /* renamed from: b0, reason: collision with root package name */
    com.tencent.mobileqq.adapter.q f175899b0;

    /* renamed from: c0, reason: collision with root package name */
    cf f175900c0;

    /* renamed from: d0, reason: collision with root package name */
    View f175901d0;

    /* renamed from: e0, reason: collision with root package name */
    TextView f175902e0;

    /* renamed from: f0, reason: collision with root package name */
    ImageButton f175903f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f175904g0;

    /* renamed from: h0, reason: collision with root package name */
    RelativeLayout f175905h0;

    /* renamed from: i0, reason: collision with root package name */
    View f175906i0;

    /* renamed from: j0, reason: collision with root package name */
    int f175907j0;

    /* renamed from: k0, reason: collision with root package name */
    AsyncTask<Void, Void, Void> f175908k0;

    /* renamed from: l0, reason: collision with root package name */
    int f175909l0;

    /* renamed from: m0, reason: collision with root package name */
    boolean f175910m0;

    /* renamed from: n0, reason: collision with root package name */
    boolean f175911n0;

    /* renamed from: o0, reason: collision with root package name */
    FrameLayout f175912o0;

    /* renamed from: p0, reason: collision with root package name */
    RelativeLayout f175913p0;

    /* renamed from: q0, reason: collision with root package name */
    RelativeLayout f175914q0;

    /* renamed from: r0, reason: collision with root package name */
    ImageView f175915r0;

    /* renamed from: s0, reason: collision with root package name */
    ImageView f175916s0;

    /* renamed from: t0, reason: collision with root package name */
    long f175917t0;

    /* renamed from: u0, reason: collision with root package name */
    int f175918u0;

    /* renamed from: v0, reason: collision with root package name */
    ImageView f175919v0;

    /* renamed from: w0, reason: collision with root package name */
    private TextView f175920w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f175921x0;

    /* renamed from: y0, reason: collision with root package name */
    boolean f175922y0;

    /* renamed from: z0, reason: collision with root package name */
    boolean f175923z0;

    /* renamed from: com.tencent.mobileqq.activity.FriendProfileImageActivity$2, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        AnonymousClass2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(FriendProfileImageActivity.this.f175900c0.f180634d), "qqBaseActivity", new hx3.b<kx3.a>(FriendProfileImageActivity.this.f175900c0.f180634d) { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.2.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f175924a;

                {
                    this.f175924a = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<kx3.a> eVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                        return;
                    }
                    if (eVar != null && eVar.a() == 0 && eVar.b() != null && !eVar.b().isEmpty()) {
                        ThreadManager.getUIHandler().post(new Runnable(eVar.b().get(0)) { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.2.1.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ kx3.a f175926d;

                            {
                                this.f175926d = r5;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) r5);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                ImageView imageView = FriendProfileImageActivity.this.f175916s0;
                                if (imageView == null) {
                                    return;
                                }
                                imageView.setVisibility(0);
                                IPendantInfo pendantInfo = ((com.tencent.mobileqq.vas.b) FriendProfileImageActivity.this.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).getPendantInfo(FriendProfileImageActivity.this.f175917t0);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                pendantInfo.setDrawable(FriendProfileImageActivity.this.f175916s0, 1, PendantConstant.PENDANT_TARGET_ID_PROFILE_PREVIEW, anonymousClass1.f175924a, this.f175926d.getPendantDiyId());
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f175931d;

        a(TextView textView) {
            this.f175931d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this, (Object) textView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f175931d.clearAnimation();
                this.f175931d.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            FriendProfileImageActivity.this.f175908k0.execute(new Void[0]);
            FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
            friendProfileImageActivity.O0 = false;
            if (friendProfileImageActivity.f175922y0) {
                friendProfileImageActivity.f175919v0.setVisibility(8);
            } else if (!friendProfileImageActivity.f175921x0) {
                friendProfileImageActivity.f175919v0.setVisibility(0);
            }
            QUIImmersiveHelper.u(FriendProfileImageActivity.this.getWindow(), true, true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
            friendProfileImageActivity.O0 = false;
            friendProfileImageActivity.f175905h0.setVisibility(8);
            FriendProfileImageActivity.this.finish();
            FriendProfileImageActivity.this.overridePendingTransition(0, 0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* loaded from: classes9.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* loaded from: classes9.dex */
        class a implements ActionSheet.OnButtonClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ cf.b f175936d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ActionSheet f175937e;

            a(cf.b bVar, ActionSheet actionSheet) {
                this.f175936d = bVar;
                this.f175937e = actionSheet;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, d.this, bVar, actionSheet);
                }
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                    return;
                }
                if (i3 == 0) {
                    FriendProfileImageActivity.this.L2(this.f175936d);
                }
                this.f175937e.dismiss();
            }
        }

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (view.getId() == R.id.bf5) {
                cf.b f16 = FriendProfileImageActivity.this.f175900c0.f();
                FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                if (!friendProfileImageActivity.f175911n0 && friendProfileImageActivity.f175910m0 && f16 != null) {
                    ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(friendProfileImageActivity, null);
                    actionSheet.addButton(R.string.bsg, 3);
                    actionSheet.addCancelButton(R.string.cancel);
                    actionSheet.setOnButtonClickListener(new a(f16, actionSheet));
                    actionSheet.show();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes9.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendProfileImageActivity.this.showActionSheet();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes9.dex */
    class f implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                FriendProfileImageActivity.this.back();
            }
        }
    }

    /* loaded from: classes9.dex */
    class g implements AdapterView.OnItemSelectedListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else {
                if (view == null) {
                    return;
                }
                FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                friendProfileImageActivity.f175901d0 = view;
                friendProfileImageActivity.f175900c0.m(i3);
                FriendProfileImageActivity.this.e3(adapterView, i3);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) adapterView);
            }
        }
    }

    /* loaded from: classes9.dex */
    class h implements AdapterView.OnItemLongClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FriendProfileImageActivity.this.showActionSheet();
                return true;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class i implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cf.b f175943d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f175944e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f175945f;

        i(cf.b bVar, boolean z16, ActionSheet actionSheet) {
            this.f175943d = bVar;
            this.f175944e = z16;
            this.f175945f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FriendProfileImageActivity.this, bVar, Boolean.valueOf(z16), actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            String str;
            String str2;
            String str3;
            String str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        FriendProfileImageActivity.this.c3(this.f175943d.f180641c);
                        QQAppInterface qQAppInterface = FriendProfileImageActivity.this.app;
                        if (this.f175944e) {
                            str3 = "1";
                        } else {
                            str3 = "2";
                        }
                        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, str3, "", "", "");
                    } else if (i3 != 3) {
                        if (i3 == 4) {
                            FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                            if (!friendProfileImageActivity.f175911n0 && friendProfileImageActivity.f175910m0) {
                                friendProfileImageActivity.L2(this.f175943d);
                            }
                        }
                    } else {
                        String str5 = this.f175943d.f180641c;
                        FriendProfileImageActivity friendProfileImageActivity2 = FriendProfileImageActivity.this;
                        ProfileCardUtil.l(str5, friendProfileImageActivity2.app, friendProfileImageActivity2);
                        QQAppInterface qQAppInterface2 = FriendProfileImageActivity.this.app;
                        if (this.f175944e) {
                            str4 = "1";
                        } else {
                            str4 = "2";
                        }
                        ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, str4, "", "", "");
                    }
                } else {
                    String str6 = this.f175943d.f180641c;
                    FriendProfileImageActivity friendProfileImageActivity3 = FriendProfileImageActivity.this;
                    ProfileCardUtil.m(str6, friendProfileImageActivity3.app, friendProfileImageActivity3);
                    QQAppInterface qQAppInterface3 = FriendProfileImageActivity.this.app;
                    if (this.f175944e) {
                        str2 = "1";
                    } else {
                        str2 = "2";
                    }
                    ReportController.o(qQAppInterface3, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, str2, "", "", "");
                }
            } else {
                ProfileCardUtil.k(this.f175943d.f180641c, FriendProfileImageActivity.this);
                QQAppInterface qQAppInterface4 = FriendProfileImageActivity.this.app;
                if (this.f175944e) {
                    str = "1";
                } else {
                    str = "2";
                }
                ReportController.o(qQAppInterface4, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, str, "", "", "");
            }
            this.f175945f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class j extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f175947a;

        j(String str) {
            this.f175947a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onAllGranted();
                FriendProfileImageActivity.this.b3(this.f175947a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class k implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f175949d;

        k(TextView textView) {
            this.f175949d = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this, (Object) textView);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f175949d.clearAnimation();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else if (!FriendProfileImageActivity.this.O0) {
                this.f175949d.setVisibility(0);
            }
        }
    }

    public FriendProfileImageActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.A0 = 0;
        this.B0 = null;
        this.C0 = true;
        this.F0 = new com.tencent.mobileqq.hitrate.d("profile_image", "com.tencent.mobileqq:tool");
        this.H0 = new AlphaAnimation(0.0f, 1.0f);
        this.I0 = new AlphaAnimation(1.0f, 0.0f);
        this.J0 = new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                    friendProfileImageActivity.f175902e0.startAnimation(friendProfileImageActivity.I0);
                }
            }
        };
        this.K0 = 350L;
        this.L0 = 250L;
        this.N0 = false;
        this.O0 = false;
        this.P0 = new d();
    }

    private void J2(Rect rect, Rect rect2) {
        float f16;
        this.O0 = true;
        View findViewById = getActivity().findViewById(android.R.id.content);
        this.f175912o0.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setDuration(this.K0);
        alphaAnimation.setFillAfter(true);
        if (rect2 != null && rect != null) {
            this.M0 = rect;
            int width = rect.width();
            int height = rect.height();
            int width2 = rect2.width();
            int height2 = rect2.height();
            int width3 = findViewById.getWidth();
            int height3 = findViewById.getHeight();
            if (width2 > width3 || height2 > height3) {
                float f17 = width2;
                float f18 = width3 / f17;
                float f19 = height2;
                float f26 = height3 / f19;
                if (f18 < f26) {
                    height2 = Math.round(f18 * f19);
                    width2 = width3;
                } else {
                    width2 = Math.round(f26 * f17);
                    height2 = height3;
                }
            }
            float c16 = com.tencent.common.galleryactivity.j.c(width2, height2, width3, height3);
            if (width2 == 0) {
                width2 = 1;
            }
            if (height2 == 0) {
                height2 = 1;
            }
            if (width2 != width || height != height2) {
                float f27 = (width / width2) / c16;
                float f28 = (height / height2) / c16;
                if (f27 > f28) {
                    f16 = f28;
                } else {
                    f16 = f27;
                }
                ScaleAnimation scaleAnimation = new ScaleAnimation(f16, 1.0f, f16, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(this.K0);
                scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f175898a0.startAnimation(scaleAnimation);
                if (Math.abs(width2 - width3) < 10.0f) {
                    U2();
                }
            }
            Rect rect3 = new Rect(this.f175905h0.getPaddingLeft(), this.f175905h0.getPaddingTop(), this.f175905h0.getWidth() - this.f175905h0.getPaddingRight(), this.f175905h0.getHeight() - this.f175905h0.getPaddingBottom());
            com.tencent.common.galleryactivity.j.e(this.f175905h0, rect3);
            int centerX = rect3.centerX();
            int centerY = rect3.centerY();
            TranslateAnimation translateAnimation = new TranslateAnimation(-(centerX - this.M0.centerX()), 0.0f, -(centerY - this.M0.centerY()), 0.0f);
            translateAnimation.setDuration(this.K0);
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            translateAnimation.setAnimationListener(new b());
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(translateAnimation);
            this.f175905h0.startAnimation(animationSet);
            if (!this.f175923z0) {
                this.f175912o0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.13
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                        friendProfileImageActivity.O0 = false;
                        if (!friendProfileImageActivity.f175921x0) {
                            friendProfileImageActivity.f175913p0.setVisibility(0);
                        }
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, FriendProfileImageActivity.this.getResources().getDimension(R.dimen.a0i), 0.0f);
                        translateAnimation2.setDuration(300L);
                        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
                        FriendProfileImageActivity.this.f175914q0.startAnimation(translateAnimation2);
                    }
                }, this.K0);
            }
            this.f175906i0.startAnimation(alphaAnimation);
        }
    }

    private void K2() {
        Rect rect = (Rect) getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
        cf.b f16 = this.f175900c0.f();
        this.N0 = true;
        Rect M2 = M2(f16);
        this.O0 = true;
        View findViewById = getActivity().findViewById(android.R.id.content);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(this.L0);
        alphaAnimation.setFillAfter(true);
        if (M2 != null && rect != null) {
            this.M0 = rect;
            W2(rect, M2, findViewById);
            T2();
        }
        this.f175903f0.setVisibility(4);
        this.f175902e0.setVisibility(4);
        if (this.f175913p0.getVisibility() == 0) {
            this.f175913p0.setVisibility(8);
        }
        this.f175906i0.startAnimation(alphaAnimation);
    }

    @NonNull
    private Rect M2(cf.b bVar) {
        int i3;
        int i16 = getResources().getDisplayMetrics().densityDpi;
        if (bVar != null) {
            if (bVar.f180642d == 6) {
                i3 = BaseImageUtil.scaleFromDensity(640, 160, i16);
            } else {
                i3 = BaseImageUtil.scaleFromDensity(100, 160, i16);
            }
        } else {
            i3 = 0;
        }
        Rect rect = new Rect(0, 0, i3, i3);
        Rect calculateBigImageBounds = BaseImageUtil.calculateBigImageBounds(rect, (int) getResources().getDimension(R.dimen.f159270z3), getResources().getDisplayMetrics().density);
        if (calculateBigImageBounds != null) {
            return calculateBigImageBounds;
        }
        return rect;
    }

    private CharSequence N2() {
        String specialShapeBtnText = VasMaskUtils.INSTANCE.getSpecialShapeBtnText();
        if (TextUtils.isEmpty(specialShapeBtnText)) {
            return getText(R.string.f21746613);
        }
        return specialShapeBtnText;
    }

    private void P2(Intent intent) {
        String string = intent.getExtras().getString("guild_id");
        String string2 = intent.getExtras().getString("uin");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            if (((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getGuildInfo(string) == null) {
                QLog.e("qqBaseActivity", 1, "handlerStartGuildChartAndSendMsg guildInfo is null, id:" + string);
                return;
            }
            if (!((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome() && ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatPie(this, new LaunchGuildChatPieParam().l(string).b(string2).k(intent.getExtras()).r(false).a());
                return;
            }
            com.tencent.mobileqq.guild.api.i a16 = new com.tencent.mobileqq.guild.api.i().f(string).b(string2).d(com.tencent.guild.aio.factory.a.class.getName()).a();
            if (AppSetting.t(QBaseActivity.sTopActivity)) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(QBaseActivity.sTopActivity, a16);
            } else {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(QBaseActivity.sTopActivity, a16);
            }
        }
    }

    private void Q2(TextView textView) {
        textView.setVisibility(4);
        this.H0.setDuration(300L);
        this.I0.setDuration(300L);
        this.H0.setAnimationListener(new k(textView));
        this.I0.setAnimationListener(new a(textView));
    }

    private void R2(View view, View view2) {
        cf cfVar;
        boolean z16 = true;
        if (!this.f175910m0 && (cfVar = this.f175900c0) != null && cfVar.f180634d != null && view != null) {
            if (view2 == null) {
                QLog.e("qqBaseActivity", 1, "[initZPlanAvatarEntrance] stubPendantLayout == null");
                return;
            }
            Card r16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f175900c0.f180634d);
            if (r16 == null) {
                QLog.e("qqBaseActivity", 1, "[initZPlanAvatarEntrance] stubPendantLayout == null");
                return;
            }
            if (!((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).enableGuestZplanAvatarEntrance()) {
                QLog.i("qqBaseActivity", 1, "[initZPlanAvatarEntrance] toggle not enable");
                return;
            }
            int i3 = 8;
            view.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.u7p);
            linearLayout.setVisibility(0);
            QUIButton qUIButton = (QUIButton) linearLayout.findViewById(R.id.f126907q1);
            this.D0 = (QUIButton) linearLayout.findViewById(R.id.f126917q2);
            if (!this.C0) {
                qUIButton.setText("\u8bd5\u8bd5\u5934\u50cf\u6302\u4ef6");
            }
            if (((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.f175900c0.f180634d).isMoonAvatar(VasProfileCardHeaderUtil.getFaceId(this.app, this.f175900c0.f180634d))) {
                qUIButton.setText(R.string.f2172560i);
            }
            if (((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.f175900c0.f180634d)) {
                qUIButton.setText(N2());
            }
            qUIButton.setThemeId(1001);
            this.D0.setThemeId(1001);
            qUIButton.setOnClickListener(this);
            this.D0.setOnClickListener(this);
            boolean z17 = r16.isZPlanAvatar;
            QLog.i("qqBaseActivity", 1, "[initZPlanAvatarEntrance] isZPlanAvatar:" + z17);
            boolean isZPlanAvatarSettingEnable = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isZPlanAvatarSettingEnable();
            QLog.i("qqBaseActivity", 1, "[initZPlanAvatarEntrance] isZplanAvatarSettingEnable:" + isZPlanAvatarSettingEnable);
            if (!z17 || !isZPlanAvatarSettingEnable) {
                z16 = false;
            }
            QUIButton qUIButton2 = this.D0;
            if (z16) {
                i3 = 0;
            }
            qUIButton2.setVisibility(i3);
            return;
        }
        QLog.e("qqBaseActivity", 1, "[initZPlanAvatarEntrance] only show in guest mode");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void S2(URLImageView uRLImageView, RoundedImageView roundedImageView, ViewGroup viewGroup, ValueAnimator valueAnimator) {
        if (((Float) valueAnimator.getAnimatedValue()).floatValue() < 0.05f) {
            uRLImageView.setVisibility(0);
            roundedImageView.setVisibility(8);
            viewGroup.removeView(roundedImageView);
        }
    }

    private void T2() {
        Rect rect = new Rect(this.f175905h0.getPaddingLeft(), this.f175905h0.getPaddingTop(), this.f175905h0.getWidth() - this.f175905h0.getPaddingRight(), this.f175905h0.getHeight() - this.f175905h0.getPaddingBottom());
        com.tencent.common.galleryactivity.j.e(this.f175905h0, rect);
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -(centerX - this.M0.centerX()), 0.0f, -(centerY - this.M0.centerY()));
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new c());
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(this.L0);
        this.f175905h0.startAnimation(animationSet);
    }

    private void U2() {
        final URLImageView uRLImageView = (URLImageView) this.f175898a0.findViewById(R.id.image);
        if (uRLImageView == null) {
            return;
        }
        int measuredWidth = uRLImageView.getMeasuredWidth() / 2;
        Drawable drawable = uRLImageView.getDrawable();
        final RoundedImageView roundedImageView = new RoundedImageView(uRLImageView.getContext());
        roundedImageView.setImageDrawable(drawable);
        roundedImageView.setLayoutParams((RelativeLayout.LayoutParams) uRLImageView.getLayoutParams());
        final ViewGroup viewGroup = (ViewGroup) uRLImageView.getParent();
        uRLImageView.setVisibility(4);
        viewGroup.addView(roundedImageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(roundedImageView, "cornerRadius", measuredWidth, 0.0f);
        ofFloat.setDuration(this.K0);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.ce
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FriendProfileImageActivity.S2(URLImageView.this, roundedImageView, viewGroup, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private void V2() {
        URLImageView uRLImageView = (URLImageView) this.f175898a0.findViewById(R.id.image);
        if (uRLImageView == null) {
            return;
        }
        int measuredWidth = uRLImageView.getMeasuredWidth() / 2;
        Drawable drawable = uRLImageView.getDrawable();
        RoundedImageView roundedImageView = new RoundedImageView(uRLImageView.getContext());
        roundedImageView.setImageDrawable(drawable);
        roundedImageView.setLayoutParams((RelativeLayout.LayoutParams) uRLImageView.getLayoutParams());
        ViewGroup viewGroup = (ViewGroup) uRLImageView.getParent();
        viewGroup.removeView(uRLImageView);
        viewGroup.addView(roundedImageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(roundedImageView, "cornerRadius", 0.0f, measuredWidth);
        ofFloat.setDuration(this.L0);
        ofFloat.start();
    }

    private void W2(Rect rect, Rect rect2, View view) {
        float f16;
        int width = rect.width();
        int height = rect.height();
        int width2 = rect2.width();
        int height2 = rect2.height();
        int width3 = view.getWidth();
        int height3 = view.getHeight();
        if (width2 > width3 || height2 > height3) {
            float f17 = width2;
            float f18 = width3 / f17;
            float f19 = height2;
            float f26 = height3 / f19;
            if (f18 < f26) {
                height2 = Math.round(f18 * f19);
                width2 = width3;
            } else {
                width2 = Math.round(f26 * f17);
                height2 = height3;
            }
        }
        float c16 = com.tencent.common.galleryactivity.j.c(width2, height2, width3, height3);
        if (width2 == 0) {
            width2 = 1;
        }
        if (height2 == 0) {
            height2 = 1;
        }
        if (width2 != width || height != height2) {
            float f27 = (width / width2) / c16;
            float f28 = (height / height2) / c16;
            if (f27 > f28) {
                f16 = f28;
            } else {
                f16 = f27;
            }
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f16, 1.0f, f16, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(this.L0);
            this.f175898a0.startAnimation(scaleAnimation);
            V2();
        }
    }

    private void Y2() {
        boolean z16;
        String str;
        if (this.f175900c0 == null) {
            return;
        }
        if (!Utils.B()) {
            QQToast.makeText(super.getApplicationContext(), getString(R.string.h9v), 0).show();
            return;
        }
        String str2 = this.f175900c0.f180634d;
        if (str2 != null && !str2.equals(this.app.getCurrentAccountUin())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && ((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.f175900c0.f180634d)) {
            String specialShapeBtnJumUrl = VasMaskUtils.INSTANCE.getSpecialShapeBtnJumUrl();
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.setFlags(268435456);
            VasWebviewUtil.openQQBrowserActivity(this, specialShapeBtnJumUrl, -1L, intent, false, -1);
            return;
        }
        String faceId = VasProfileCardHeaderUtil.getFaceId(this.app, this.f175900c0.f180634d);
        if (!z16 && ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.f175900c0.f180634d).isMoonAvatar(faceId)) {
            VasProfileCardHeaderUtil.goSplendidDetailsPage(this.app, this, this.f175900c0.f180634d);
            return;
        }
        this.F0.d();
        if (AvatarPendantFileUtil.isDiyPendant(this.f175917t0)) {
            str = IndividuationUrlHelper.UrlId.FRIEND_TO_DIY_PENDANT_HOME;
        } else {
            str = IndividuationUrlHelper.UrlId.FRIEND_TO_PENDANT_HOME;
        }
        String url = IndividuationUrlHelper.getUrl(str);
        if (!TextUtils.isEmpty(url)) {
            String addEntryParamToUrl = VasWebviewUtil.addEntryParamToUrl(url.replace("[sharefri]", this.f175900c0.f180634d), 44);
            if (VasNormalToggle.VAS_BUG_112408032.isEnable(true)) {
                ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(this, addEntryParamToUrl);
            } else {
                Intent intent2 = new Intent(this, (Class<?>) QQBrowserActivity.class);
                intent2.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, false);
                intent2.putExtra("show_right_close_button", false);
                intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent2.putExtra("url", addEntryParamToUrl);
                intent2.putExtra("business", 512L);
                VasWebviewUtil.insertVasWbPluginToIntent(512L, intent2);
                intent2.putExtra("isShowAd", false);
                startActivity(intent2);
            }
            ReportController.o(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
        } else {
            QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
        }
        String str3 = this.f175900c0.f180634d;
        if (str3 != null) {
            if (str3.equals(this.app.getCurrentAccountUin())) {
                ReportController.o(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
            } else {
                ReportController.o(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.f175918u0, 0, "", "", "", "");
            }
        }
        AvatarPendantUtil.j(this, PendantConstant.SP_KEY_ENTRANCE_CARD_FACE_PREVIEW, this.app.getCurrentAccountUin(), System.currentTimeMillis());
        finish();
    }

    private void Z2(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "6");
        hashMap.put("zplan_action_type", str2);
        VideoReport.reportEvent(str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b3(String str) {
        com.tencent.mobileqq.activity.aio.photo.c.n(this, new File(str), com.tencent.image.Utils.Crc64String(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(String str) {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_FRIEND_PROFILE_IMAGE, QQPermissionConstants.Business.SCENE.FRIEND_FPROFILE_IMAGE));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            b3(str);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new j(str));
        }
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setPageParams(this, new PageParams(hashMap));
        VideoReport.setPageId(this, "pg_zplan_friend_avatar_detail");
        QUIButton qUIButton = this.D0;
        if (qUIButton != null) {
            VideoReport.setElementId(qUIButton, "em_zplan_edit_sqqshow_avatar");
            VideoReport.setElementExposePolicy(this.D0, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.D0, ClickPolicy.REPORT_NONE);
            if (this.D0.getVisibility() == 0) {
                Z2("ev_zplan_avatar_edit_entrance", "imp");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showActionSheet() {
        cf.b f16;
        String str;
        if (!isFinishing() && (f16 = this.f175900c0.f()) != null && f16.f180642d == 6) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            boolean z16 = true;
            actionSheet.addButton(R.string.bsj, 1);
            actionSheet.addButton(R.string.bg5, 1);
            actionSheet.addButton(R.string.bst, 1);
            actionSheet.addButton(R.string.f170982bg2, 1);
            if (!this.f175911n0 && this.f175910m0) {
                actionSheet.addButton(R.string.bsg, 3);
            }
            actionSheet.addCancelButton(R.string.cancel);
            if (TextUtils.isEmpty(this.f175900c0.f180634d) || !TextUtils.equals(this.f175900c0.f180634d, this.app.getCurrentAccountUin())) {
                z16 = false;
            }
            actionSheet.setOnButtonClickListener(new i(f16, z16, actionSheet));
            actionSheet.show();
            QQAppInterface qQAppInterface = this.app;
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, str, "", "", "");
        }
    }

    private void startChatAndSendMsg(Bundle bundle) {
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this), null);
        Bundle bundle2 = new Bundle(bundle);
        m3.putExtras(bundle2);
        if (bundle2.getInt("uintype", 0) == 10014) {
            P2(m3);
        } else {
            startActivity(m3);
        }
        finish();
    }

    @Override // com.tencent.mobileqq.activity.cf.a
    public void G0(cf.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bVar);
        } else {
            f3(bVar);
        }
    }

    void L2(cf.b bVar) {
        if (!NetworkUtil.isNetSupport(this)) {
            QQToast.makeText(this, getString(R.string.ak6), 0).show();
            return;
        }
        if (((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(this.f175900c0.f180634d) != null) {
            ((CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).N2(this.f175900c0.f180634d, r0.uFaceTimeStamp, HexUtil.hexStr2Bytes(bVar.f180639a));
            d3();
        }
    }

    void back() {
        if (!this.O0 && !this.f175898a0.resetScale(false)) {
            K2();
            View view = this.f175901d0;
            if (view != null) {
                this.f175899b0.e(view);
            }
        }
    }

    void d3() {
        if (this.G0 == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.G0 = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.akr);
        }
        this.G0.show();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i16 == -1 && i3 == 21 && intent != null && intent.getExtras() != null && !intent.getExtras().isEmpty() && intent.getExtras().getInt("uintype", 0) != 10027) {
            startChatAndSendMsg(intent.getExtras());
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            back();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.ajr);
        super.setContentView(R.layout.f168205pe);
        this.B0 = new com.tencent.mobileqq.utils.ad(getMainLooper(), this);
        Bundle extras = getIntent().getExtras();
        this.f175921x0 = extras.getBoolean("is_from_face2face_add_friend", false);
        this.f175922y0 = extras.getBoolean("is_hide_actionsheet", false);
        this.f175923z0 = extras.getBoolean("is_hide_footbar", false);
        this.A0 = extras.getInt("curType", 0);
        this.E0 = (AllInOne) getIntent().getParcelableExtra(IProfileCardConst.KEY_ALL_IN_ONE);
        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        this.f175898a0 = gallery;
        gallery.setVisibility(0);
        this.f175902e0 = (TextView) findViewById(R.id.jfb);
        this.f175905h0 = (RelativeLayout) findViewById(R.id.root);
        View findViewById = findViewById(R.id.a4f);
        this.f175906i0 = findViewById;
        findViewById.setBackgroundColor(-16777216);
        this.f175912o0 = (FrameLayout) findViewById(R.id.ier);
        View inflate = ((ViewStub) findViewById(R.id.j5d)).inflate();
        this.f175913p0 = (RelativeLayout) inflate.findViewById(R.id.b9b);
        this.f175914q0 = (RelativeLayout) inflate.findViewById(R.id.b9c);
        this.f175903f0 = (ImageButton) findViewById(R.id.bf5);
        ImageView imageView = (ImageView) findViewById(R.id.f164122k9);
        this.f175919v0 = imageView;
        imageView.setVisibility(4);
        this.f175920w0 = (TextView) inflate.findViewById(R.id.ji8);
        this.f175903f0.setVisibility(4);
        this.f175903f0.setOnClickListener(this.P0);
        this.f175919v0.setOnClickListener(new e());
        this.f175899b0 = new com.tencent.mobileqq.adapter.q(this);
        AllInOne allInOne = this.E0;
        if (allInOne != null) {
            i3 = allInOne.f260789pa;
        } else {
            i3 = -1;
        }
        this.f175900c0 = new FriendProfileImageAvatar(this.app, ProfilePAUtils.isFromGuild(i3));
        this.f175911n0 = true;
        if (this.A0 == 1) {
            this.f175899b0.g(true);
        }
        this.f175900c0.f180634d = extras.getString("friendUin");
        long j3 = extras.getLong("extra_pendant_id", 0L);
        this.f175917t0 = j3;
        if (j3 == 0) {
            this.f175920w0.setText(R.string.g7e);
            this.f175917t0 = 5L;
            this.C0 = false;
        }
        this.f175918u0 = extras.getInt("extra_action_source", 0);
        if (this.f175900c0.f180634d != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f175905h0.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.dimen.a0i);
            this.f175905h0.setLayoutParams(layoutParams);
            this.f175914q0.setOnClickListener(this);
            this.f175915r0 = (ImageView) inflate.findViewById(R.id.dgi);
            ThreadManager.getSubThreadHandler().post(this);
            this.f175916s0 = (ImageView) inflate.findViewById(R.id.dfv);
            if (((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.f175900c0.f180634d).isMoonAvatar(VasProfileCardHeaderUtil.getFaceId(this.app, this.f175900c0.f180634d))) {
                this.f175916s0.setVisibility(8);
                this.f175920w0.setText(R.string.f2172560i);
            } else {
                ThreadManagerV2.post(new AnonymousClass2(), 8, null, true);
            }
        }
        if (((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(this.f175900c0.f180634d)) {
            this.f175920w0.setText(N2());
        }
        if (this.app.getCurrentAccountUin().equals(this.f175900c0.f180634d)) {
            this.f175910m0 = true;
        } else {
            this.f175910m0 = false;
        }
        this.f175909l0 = extras.getInt("index", -1);
        cf.b bVar = new cf.b();
        bVar.f180645g = this.f175900c0.f180634d;
        bVar.f180639a = extras.getString("filekey");
        this.f175900c0.k(this, bVar);
        this.f175907j0 = this.f175900c0.g();
        this.f175900c0.n(this);
        this.f175900c0.l(this);
        this.f175899b0.f(this.f175900c0);
        this.f175898a0.setAdapter((SpinnerAdapter) this.f175899b0);
        this.f175898a0.setSelection(this.f175900c0.g());
        this.f175898a0.setSpacing(getResources().getDimensionPixelSize(R.dimen.f158920sg));
        this.f175898a0.setOnItemClickListener(new f());
        this.f175898a0.setOnItemSelectedListener(new g());
        Q2(this.f175902e0);
        this.f175898a0.setOnItemLongClickListener(new h());
        this.f175908k0 = new AsyncTask<Void, Void, Void>(bVar) { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.6
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cf.b f175928a;

            {
                this.f175928a = bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendProfileImageActivity.this, (Object) bVar);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) voidArr);
                }
                FriendProfileImageActivity.this.f175900c0.j(this.f175928a);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Void r46) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) r46);
                    return;
                }
                FriendProfileImageActivity friendProfileImageActivity = FriendProfileImageActivity.this;
                friendProfileImageActivity.f175900c0.m(friendProfileImageActivity.f175909l0);
                FriendProfileImageActivity friendProfileImageActivity2 = FriendProfileImageActivity.this;
                friendProfileImageActivity2.f175898a0.setSelection(friendProfileImageActivity2.f175900c0.g());
                FriendProfileImageActivity.this.f175899b0.notifyDataSetChanged();
                FriendProfileImageActivity friendProfileImageActivity3 = FriendProfileImageActivity.this;
                if (!friendProfileImageActivity3.f175911n0 && friendProfileImageActivity3.f175910m0) {
                    friendProfileImageActivity3.f175903f0.setVisibility(0);
                }
                FriendProfileImageActivity.this.f175905h0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        FriendProfileImageActivity friendProfileImageActivity4 = FriendProfileImageActivity.this;
                        if (friendProfileImageActivity4.f175907j0 != friendProfileImageActivity4.f175900c0.g()) {
                            FriendProfileImageActivity friendProfileImageActivity5 = FriendProfileImageActivity.this;
                            friendProfileImageActivity5.f175907j0 = friendProfileImageActivity5.f175900c0.g();
                            return;
                        }
                        View selectedView = FriendProfileImageActivity.this.f175898a0.getSelectedView();
                        if (selectedView == null) {
                            return;
                        }
                        FriendProfileImageActivity friendProfileImageActivity6 = FriendProfileImageActivity.this;
                        friendProfileImageActivity6.f175901d0 = selectedView;
                        cf cfVar = friendProfileImageActivity6.f175900c0;
                        cfVar.m(cfVar.g());
                        FriendProfileImageActivity friendProfileImageActivity7 = FriendProfileImageActivity.this;
                        friendProfileImageActivity7.e3(friendProfileImageActivity7.f175898a0, friendProfileImageActivity7.f175900c0.g());
                    }
                });
            }
        };
        R2(this.f175914q0, inflate);
        initDtReport();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this);
        this.B0.removeCallbacksAndMessages(null);
        this.f175900c0.n(null);
        this.f175900c0.d(this);
        this.f175899b0.a();
        super.doOnDestroy();
        this.f175908k0.cancel(true);
        this.f175901d0 = null;
        AlphaAnimation alphaAnimation = this.H0;
        if (alphaAnimation != null) {
            alphaAnimation.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.I0;
        if (alphaAnimation2 != null) {
            alphaAnimation2.setAnimationListener(null);
        }
        Gallery gallery = this.f175898a0;
        if (gallery != null) {
            try {
                int childCount = gallery.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = this.f175898a0.getChildAt(i3);
                    if (childAt != null) {
                        View findViewById = childAt.findViewById(R.id.image);
                        if (findViewById instanceof URLImageView) {
                            ((URLImageView) findViewById).setImageDrawable(null);
                            ((URLImageView) findViewById).setBackgroundDrawable(null);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (82 == keyEvent.getKeyCode()) {
            showActionSheet();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnPause();
        AbstractVideoImage.pauseAll();
        SmallScreenUtils.A(BaseApplication.getContext(), false);
        this.F0.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnResume();
        AbstractVideoImage.resumeAll();
        SmallScreenUtils.A(BaseApplication.getContext(), true);
        QQAppInterface qQAppInterface = this.app;
        AvatarPendantUtil.i(qQAppInterface, this, PendantConstant.SP_KEY_ENTRANCE_CARD_FACE_PREVIEW, qQAppInterface.getCurrentAccountUin(), this.F0);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnWindowFocusChanged(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        super.doOnWindowFocusChanged(z16);
        if (z16 && !this.N0) {
            float f16 = getResources().getDisplayMetrics().density;
            int i16 = getResources().getDisplayMetrics().densityDpi;
            cf.b f17 = this.f175900c0.f();
            this.N0 = true;
            Rect rect = (Rect) getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
            if (f17 != null) {
                if (f17.f180642d == 6) {
                    i3 = BaseImageUtil.scaleFromDensity(640, 160, i16);
                } else {
                    i3 = BaseImageUtil.scaleFromDensity(100, 160, i16);
                }
            } else {
                i3 = 0;
            }
            Rect rect2 = new Rect(0, 0, i3, i3);
            Rect calculateBigImageBounds = BaseImageUtil.calculateBigImageBounds(rect2, (int) getResources().getDimension(R.dimen.f159270z3), f16);
            if (calculateBigImageBounds != null) {
                rect2 = calculateBigImageBounds;
            }
            J2(rect, rect2);
        }
    }

    void e3(AdapterView adapterView, int i3) {
        if (!this.O0) {
            if (adapterView.getCount() > 1) {
                this.f175902e0.setText((i3 + 1) + "/" + adapterView.getCount());
                if (this.f175902e0.getVisibility() == 4) {
                    this.f175902e0.setVisibility(0);
                    this.f175902e0.startAnimation(this.H0);
                    if (this.f175904g0) {
                        this.f175902e0.postDelayed(this.J0, 3000L);
                        this.f175904g0 = false;
                        return;
                    } else {
                        this.f175902e0.postDelayed(this.J0, 2000L);
                        return;
                    }
                }
                this.f175902e0.removeCallbacks(this.J0);
                this.f175902e0.clearAnimation();
                this.f175902e0.postDelayed(this.J0, 2000L);
                return;
            }
            this.f175902e0.setVisibility(4);
        }
    }

    public void f3(cf.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bVar);
            return;
        }
        if (this.A0 != 1 && this.f175901d0 != null && bVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + bVar.f180645g + ", state=" + bVar.f180642d);
            }
            String str = (String) this.f175901d0.getTag();
            int i3 = bVar.f180642d;
            if (i3 == 6) {
                if (str == null || !str.equals(bVar.f180641c)) {
                    this.f175899b0.b(bVar, this.f175901d0);
                    return;
                }
                return;
            }
            if (i3 != 3 && i3 != 4) {
                if (i3 == 5 || i3 == 2) {
                    this.f175899b0.c(bVar, this.f175901d0);
                    return;
                }
                return;
            }
            if (str == null || !str.equals(bVar.f180640b)) {
                this.f175899b0.d(bVar, this.f175901d0);
            }
            if (bVar.f180644f && bVar.f180642d == 4) {
                ImageProgressCircle imageProgressCircle = (ImageProgressCircle) this.f175901d0.findViewById(R.id.dea);
                if (imageProgressCircle != null) {
                    imageProgressCircle.setProgress(bVar.f180643e);
                    if (imageProgressCircle.getVisibility() != 0) {
                        this.f175899b0.h(imageProgressCircle);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + bVar.f180643e);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 == 1 && !isFinishing()) {
                notifyUser(R.string.ak6, 1);
            }
        } else {
            this.f175915r0.setImageDrawable((Drawable) message.obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    public void notifyUser(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.Q0 == null) {
            this.Q0 = new QQToastNotifier(this);
        }
        this.Q0.notifyUser(i3, getTitleBarHeight(), 0, i16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.b9c) {
                Y2();
            } else if (id5 == R.id.f126907q1) {
                Y2();
            } else if (id5 == R.id.f126917q2) {
                VideoReport.reportEvent("clck", this.D0, null);
                Z2("ev_zplan_avatar_edit_entrance", "click");
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).openZPlanAvatarPicEditPage(this, "6", null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        Drawable faceDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        cf cfVar = this.f175900c0;
        if (cfVar != null && cfVar.f180634d != null) {
            AllInOne allInOne = this.E0;
            if (allInOne != null) {
                i3 = allInOne.f260789pa;
            } else {
                i3 = -1;
            }
            if (ProfilePAUtils.isFromGuild(i3)) {
                faceDrawable = ((IQQGuildAvatarApi) this.app.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarDrawable(this.app, "0", this.f175900c0.f180634d);
            } else {
                faceDrawable = FaceDrawable.getFaceDrawable(this.app, 1, this.f175900c0.f180634d);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = faceDrawable;
            this.B0.sendMessage(obtain);
        }
    }
}
