package com.tencent.mobileqq.matchfriend.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendRequest;
import com.tencent.mobileqq.matchfriend.reborn.content.main.matching.QQStrangerMatchVoiceDismissLoadingEvent;
import com.tencent.mobileqq.matchfriend.report.api.IMatchFriendJubaoApi;
import com.tencent.mobileqq.matchfriend.voicechat.RoomInfo;
import com.tencent.mobileqq.matchfriend.voicechat.VoiceChatController;
import com.tencent.mobileqq.matchfriend.widget.MatchFriendLoopScrollView;
import com.tencent.mobileqq.matchfriend.widget.VoiceChatAvatarView;
import com.tencent.mobileqq.matchfriend.widget.background.MatchFriendBackgroundView;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.app.QQStrangerAppInterface;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.relation.common.api.IRelationFloatWindowAnim;
import com.tencent.relation.common.handler.RelationFloatWindowPermissionHandler;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.widget.AlphaClickableImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import mqq.app.Constants;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendVoiceMatchFragment extends QPublicBaseFragment implements View.OnClickListener {
    private QQStrangerAppInterface C;
    private View D;
    private AlphaClickableImageView E;
    private AlphaClickableImageView F;
    private LinearLayout G;
    private MatchFriendBackgroundView H;
    private VoiceChatAvatarView I;
    private VoiceChatAvatarView J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private TextView N;
    private TextView P;
    private LinearLayout Q;
    private ImageView R;
    private TextView S;
    private TextView T;
    private Timer U;
    private ConstraintLayout V;
    private ImageView W;
    private ImageView X;
    private LottieDrawable Y;
    private AlphaClickableImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private AlphaClickableImageView f244087a0;

    /* renamed from: b0, reason: collision with root package name */
    private QQBlurView f244088b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f244089c0;

    /* renamed from: d0, reason: collision with root package name */
    private MatchFriendLoopScrollView f244090d0;

    /* renamed from: f0, reason: collision with root package name */
    private ValueAnimator f244092f0;

    /* renamed from: g0, reason: collision with root package name */
    private VoiceAnimController f244093g0;

    /* renamed from: h0, reason: collision with root package name */
    private VoiceAnimController f244094h0;

    /* renamed from: i0, reason: collision with root package name */
    private RoomInfo f244095i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f244096j0;

    /* renamed from: p0, reason: collision with root package name */
    private String f244102p0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f244104r0;

    /* renamed from: s0, reason: collision with root package name */
    private RelationFloatWindowPermissionHandler f244105s0;

    /* renamed from: t0, reason: collision with root package name */
    private com.tencent.relation.common.window.a f244106t0;

    /* renamed from: e0, reason: collision with root package name */
    private int f244091e0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f244097k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f244098l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f244099m0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private long f244100n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f244101o0 = false;

    /* renamed from: q0, reason: collision with root package name */
    private int f244103q0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    private final com.tencent.mobileqq.matchfriend.voicechat.api.a f244107u0 = new com.tencent.mobileqq.matchfriend.voicechat.api.a() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.1
        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void a(final int i3, final int i16) {
            super.a(i3, i16);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.1.3
                @Override // java.lang.Runnable
                public void run() {
                    int i17 = i3;
                    int i18 = 0;
                    if (i17 != 0) {
                        if (i17 == 1) {
                            MatchFriendVoiceMatchFragment.this.Ai(true);
                            i18 = R.drawable.g07;
                        } else if (i17 == 2) {
                            MatchFriendVoiceMatchFragment.this.Ai(false);
                            i18 = R.drawable.fzz;
                        }
                    } else if (i16 == 3) {
                        MatchFriendVoiceMatchFragment.this.Ai(false);
                        i18 = R.drawable.f159743g02;
                    } else {
                        MatchFriendVoiceMatchFragment.this.Ai(true);
                        i18 = R.drawable.g06;
                    }
                    if (MatchFriendVoiceMatchFragment.this.isAdded()) {
                        MatchFriendVoiceMatchFragment.this.f244087a0.setImageDrawable(MatchFriendVoiceMatchFragment.this.getResources().getDrawable(i18));
                    }
                }
            });
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void b() {
            super.b();
            MatchFriendVoiceMatchFragment.this.Fi(R.string.x1g, 1);
            MatchFriendVoiceMatchFragment.this.startTimer();
            MatchFriendVoiceMatchFragment.this.Ei();
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.1.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MatchFriendVoiceMatchFragment.this.f244098l0) {
                        return;
                    }
                    MatchFriendVoiceMatchFragment.this.Di(R.string.x1u, 3);
                }
            }, 16, null, true, 15000L);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void c() {
            super.c();
            MatchFriendVoiceMatchFragment.this.Fi(R.string.x1t, 2);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void d(int i3) {
            super.d(i3);
            if (i3 == 1 || i3 == 2) {
                MatchFriendVoiceMatchFragment.this.Fi(R.string.x1h, 1);
                MatchFriendVoiceMatchFragment.this.ii(2000L);
            } else {
                if (i3 != 3) {
                    return;
                }
                MatchFriendVoiceMatchFragment.this.Fi(R.string.x1l, 1);
                MatchFriendVoiceMatchFragment.this.ii(2000L);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void e(boolean z16) {
            super.e(z16);
            if (z16) {
                MatchFriendVoiceMatchFragment.this.ni();
            } else {
                MatchFriendVoiceMatchFragment.this.Di(R.string.x1v, 2);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void f(int i3) {
            super.f(i3);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void g(boolean z16) {
            super.g(z16);
            if (z16) {
                MatchFriendVoiceMatchFragment.this.Di(R.string.x1m, 2);
            } else {
                MatchFriendVoiceMatchFragment.this.Di(R.string.x1p, 1);
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void h(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            super.h(qavDef$MultiUserInfo, z16);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void j(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            super.j(qavDef$MultiUserInfo);
            if (qavDef$MultiUserInfo == null) {
                return;
            }
            if (MatchFriendVoiceMatchFragment.this.f244095i0 == null || qavDef$MultiUserInfo.mUin != MatchFriendVoiceMatchFragment.this.f244095i0.f245598e) {
                MatchFriendVoiceMatchFragment.this.Di(R.string.x1n, 1);
                MatchFriendVoiceMatchFragment.this.ii(3000L);
            } else if (MatchFriendVoiceMatchFragment.this.getQBaseActivity() != null) {
                MatchFriendVoiceMatchFragment.this.getQBaseActivity().finish();
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void k() {
            super.k();
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void l(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, final int i3) {
            String str;
            super.l(qavDef$MultiUserInfo, z16, i3);
            if (QLog.isColorLevel() && MatchFriendVoiceMatchFragment.this.f244095i0 != null && qavDef$MultiUserInfo != null) {
                if (MatchFriendVoiceMatchFragment.this.f244095i0.f245598e == qavDef$MultiUserInfo.mUin) {
                    str = "self";
                } else if (MatchFriendVoiceMatchFragment.this.f244095i0.f245599f == qavDef$MultiUserInfo.mUin) {
                    str = GuildMsgItem.NICK_FRIEND;
                } else {
                    str = "other";
                }
                QLog.d("MatchFriendVoiceMatchFragment", 2, "onUserSpeaking" + str + " audioEnergy:" + i3);
            }
            if (i3 > 5 && MatchFriendVoiceMatchFragment.this.f244095i0 != null && qavDef$MultiUserInfo != null) {
                if (MatchFriendVoiceMatchFragment.this.f244095i0.f245598e != qavDef$MultiUserInfo.mUin || MatchFriendVoiceMatchFragment.this.f244093g0 == null) {
                    if (MatchFriendVoiceMatchFragment.this.f244095i0.f245599f == qavDef$MultiUserInfo.mUin && MatchFriendVoiceMatchFragment.this.f244094h0 != null) {
                        MatchFriendVoiceMatchFragment.this.f244094h0.l();
                    }
                } else {
                    MatchFriendVoiceMatchFragment.this.f244093g0.l();
                }
            }
            if (VoiceChatController.I().M()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MatchFriendVoiceMatchFragment.this.di(i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void m(List<QavDef$MultiUserInfo> list) {
            super.m(list);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void n(boolean z16) {
            super.n(z16);
        }

        @Override // com.tencent.mobileqq.matchfriend.voicechat.api.a
        public void o() {
            super.o();
            MatchFriendVoiceMatchFragment.this.Fi(R.string.x1o, 1);
            MatchFriendVoiceMatchFragment.this.ii(2000L);
        }
    };

    /* renamed from: v0, reason: collision with root package name */
    private final com.tencent.relation.common.servlet.b f244108v0 = new e();

    /* renamed from: w0, reason: collision with root package name */
    private final Runnable f244109w0 = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.11
        @Override // java.lang.Runnable
        public void run() {
            MatchFriendVoiceMatchFragment.this.Q.setVisibility(8);
        }
    };

    /* renamed from: x0, reason: collision with root package name */
    private final Runnable f244110x0 = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.13
        @Override // java.lang.Runnable
        public void run() {
            MatchFriendVoiceMatchFragment.this.P.setVisibility(8);
        }
    };

    /* renamed from: y0, reason: collision with root package name */
    private final Runnable f244111y0 = new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.14
        @Override // java.lang.Runnable
        public void run() {
            MatchFriendVoiceMatchFragment.this.pi();
        }
    };

    /* renamed from: z0, reason: collision with root package name */
    IRelationFloatWindowAnim.a f244112z0 = new a();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements IRelationFloatWindowAnim.a {
        a() {
        }

        @Override // com.tencent.relation.common.api.IRelationFloatWindowAnim.a
        public void onAnimationEnd() {
            MatchFriendVoiceMatchFragment.this.D.setVisibility(8);
            VoiceChatController.I().S(MatchFriendVoiceMatchFragment.this.f244107u0);
            if (MatchFriendVoiceMatchFragment.this.getQBaseActivity() != null) {
                MatchFriendVoiceMatchFragment.this.f244097k0 = true;
                MatchFriendVoiceMatchFragment.this.getQBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (VoiceChatController.I().M()) {
                MatchFriendVoiceMatchFragment matchFriendVoiceMatchFragment = MatchFriendVoiceMatchFragment.this;
                matchFriendVoiceMatchFragment.bi(matchFriendVoiceMatchFragment.X, intValue);
                if (MatchFriendVoiceMatchFragment.this.Y == null) {
                    MatchFriendVoiceMatchFragment.this.wi();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class f implements View.OnLayoutChangeListener {
        f() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            view.removeOnLayoutChangeListener(this);
            ((IRelationFloatWindowAnim) QRoute.api(IRelationFloatWindowAnim.class)).doCircleEnterAnimation(MatchFriendVoiceMatchFragment.this.D, MatchFriendVoiceMatchFragment.this.f244106t0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ai(boolean z16) {
        this.f244087a0.setClickable(z16);
        this.f244087a0.setEnabled(z16);
    }

    private void Ci() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.getWindow() == null || ImmersiveUtils.isSupporImmersive() != 1) {
            return;
        }
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Di(final int i3, final int i16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.12
            @Override // java.lang.Runnable
            public void run() {
                if (MatchFriendVoiceMatchFragment.this.isAdded()) {
                    String string = MatchFriendVoiceMatchFragment.this.getResources().getString(i3);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    if (!MatchFriendVoiceMatchFragment.this.f244098l0 || MatchFriendVoiceMatchFragment.this.f244104r0) {
                        MatchFriendVoiceMatchFragment.this.zi(string, i16);
                        return;
                    }
                    MatchFriendVoiceMatchFragment.this.f244101o0 = true;
                    MatchFriendVoiceMatchFragment.this.f244102p0 = string;
                    MatchFriendVoiceMatchFragment.this.f244103q0 = i16;
                    QLog.i("MatchFriendVoiceMatchFragment", 1, "showAlert on pause, pending.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ei() {
        ThreadManager.getUIHandler().postDelayed(this.f244111y0, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi(final int i3, final int i16) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (MatchFriendVoiceMatchFragment.this.isAdded()) {
                    String string = MatchFriendVoiceMatchFragment.this.getResources().getString(i3);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    MatchFriendVoiceMatchFragment.this.P.setText(string);
                    MatchFriendVoiceMatchFragment.this.P.setVisibility(0);
                    ThreadManager.getUIHandler().removeCallbacks(MatchFriendVoiceMatchFragment.this.f244110x0);
                    if (i16 == 1) {
                        ThreadManager.getUIHandler().postDelayed(MatchFriendVoiceMatchFragment.this.f244110x0, 3000L);
                    }
                }
            }
        });
    }

    private void Hi() {
        Timer timer = this.U;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void Ii() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101704", false);
        if (QLog.isColorLevel()) {
            QLog.i("MatchFriendVoiceMatchFragment", 1, "voiceChatSwitch :" + isSwitchOn);
        }
        if (!isSwitchOn || this.f244107u0 == null) {
            return;
        }
        VoiceChatController.I().S(this.f244107u0);
    }

    private void Ji() {
        VoiceChatAvatarView voiceChatAvatarView;
        RoomInfo roomInfo = this.f244095i0;
        if (roomInfo == null || (voiceChatAvatarView = this.I) == null) {
            return;
        }
        voiceChatAvatarView.setAvatarUrl(roomInfo.f245602m);
        QIPCClientHelper.getInstance().getClient().callServer("MatchFriendVoiceChatIpcServer", "voiceChatGetSelfProfile", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.18
            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
                Bundle bundle;
                if (eIPCResult == null || !eIPCResult.isSuccess() || (bundle = eIPCResult.data) == null) {
                    return;
                }
                final String string = bundle.getString("key_avatar");
                final String string2 = eIPCResult.data.getString("key_nickname");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MatchFriendVoiceMatchFragment.this.J.setAvatarUrl(string);
                        MatchFriendVoiceMatchFragment.this.M.setText(string2);
                    }
                });
            }
        });
    }

    private void ci() {
        RoomInfo E;
        AlphaClickableImageView alphaClickableImageView = this.F;
        if (alphaClickableImageView != null) {
            alphaClickableImageView.setClickable(false);
        }
        if (VoiceChatController.I().L() && (E = VoiceChatController.I().E()) != null) {
            ((IMatchFriendJubaoApi) QRoute.api(IMatchFriendJubaoApi.class)).jumpMatchFriendJuBao(this.C, getQBaseActivity(), "10134", String.valueOf(E.f245599f), this.N.getText().toString());
            y82.a.b().d(this.F, "em_kl_new_report_btn");
        }
    }

    private void gi() {
        if (this.f244095i0 == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.8
            @Override // java.lang.Runnable
            public void run() {
                VoiceChatController.I().J(MatchFriendVoiceMatchFragment.this.f244095i0.f245598e);
                if (VoiceChatController.I().B(MatchFriendVoiceMatchFragment.this.f244095i0) != 0) {
                    MatchFriendVoiceMatchFragment.this.Fi(R.string.x1h, 1);
                    MatchFriendVoiceMatchFragment.this.ii(2000L);
                } else {
                    VoiceChatController.I().A(MatchFriendVoiceMatchFragment.this.f244107u0);
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii(long j3) {
        if (this.f244098l0 && !this.f244104r0) {
            this.f244100n0 = j3;
            this.f244099m0 = true;
            QLog.i("MatchFriendVoiceMatchFragment", 1, "handleHangUp on pause, pending.");
        } else {
            Hi();
            VoiceChatController.I().C(j3);
        }
    }

    private void initData() {
        RoomInfo E;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null) {
            return;
        }
        Intent intent = qBaseActivity.getIntent();
        int intExtra = intent.getIntExtra("key_room_id", 0);
        this.f244096j0 = intent.getBooleanExtra("key_is_restore", false);
        if (intent.getBooleanExtra("key_is_from_notification", false)) {
            com.tencent.mobileqq.matchfriend.utils.a.b();
            this.f244096j0 = true;
        } else if (this.f244096j0) {
            this.f244106t0 = com.tencent.mobileqq.matchfriend.utils.a.a(true);
        }
        if (this.f244096j0 && ((E = VoiceChatController.I().E()) == null || E.f245597d != intExtra)) {
            this.f244096j0 = false;
            QLog.e("MatchFriendVoiceMatchFragment", 1, "restore room error. roomId not the same as before.");
        }
        if (this.f244096j0) {
            li();
            return;
        }
        RoomInfo roomInfo = (RoomInfo) intent.getParcelableExtra("key_room_info");
        this.f244095i0 = roomInfo;
        if (roomInfo == null) {
            QQToast.makeText(qBaseActivity, 1, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 1).show();
            qBaseActivity.finish();
        } else {
            gi();
        }
    }

    private void initUI() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewParent parent = activity.findViewById(android.R.id.title).getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).setVisibility(8);
        }
        this.E = (AlphaClickableImageView) this.D.findViewById(R.id.oss);
        this.F = (AlphaClickableImageView) this.D.findViewById(R.id.osq);
        this.G = (LinearLayout) this.D.findViewById(R.id.f163156om0);
        this.H = (MatchFriendBackgroundView) this.D.findViewById(R.id.osl);
        this.I = (VoiceChatAvatarView) this.G.findViewById(R.id.omx);
        this.J = (VoiceChatAvatarView) this.G.findViewById(R.id.oqy);
        this.L = (ImageView) this.G.findViewById(R.id.f163180or0);
        this.K = (ImageView) this.G.findViewById(R.id.omz);
        this.M = (TextView) this.G.findViewById(R.id.f163181or1);
        this.N = (TextView) this.G.findViewById(R.id.osi);
        this.P = (TextView) this.G.findViewById(R.id.osk);
        LinearLayout linearLayout = (LinearLayout) this.D.findViewById(R.id.osh);
        this.Q = linearLayout;
        this.R = (ImageView) linearLayout.findViewById(R.id.okz);
        this.S = (TextView) this.Q.findViewById(R.id.osb);
        this.T = (TextView) this.D.findViewById(R.id.osj);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.D.findViewById(R.id.oso);
        this.V = constraintLayout;
        this.W = (ImageView) constraintLayout.findViewById(R.id.f163151ol0);
        this.X = (ImageView) this.V.findViewById(R.id.omn);
        this.Z = (AlphaClickableImageView) this.V.findViewById(R.id.osp);
        this.f244087a0 = (AlphaClickableImageView) this.V.findViewById(R.id.ost);
        this.f244088b0 = (QQBlurView) this.D.findViewById(R.id.osn);
        this.f244089c0 = (TextView) this.D.findViewById(R.id.ok6);
        this.f244090d0 = (MatchFriendLoopScrollView) this.D.findViewById(R.id.ok5);
        this.W.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f244087a0.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.I.setOnClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f10361v) + ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = dimensionPixelSize;
            this.E.setLayoutParams(marginLayoutParams);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
        if (marginLayoutParams2 != null) {
            marginLayoutParams2.topMargin = dimensionPixelSize;
            this.F.setLayoutParams(marginLayoutParams2);
        }
        ti();
        if (this.f244096j0) {
            Bi(VoiceChatController.I().M());
            VoiceChatController.I().V();
            pi();
            si();
        } else {
            VoiceChatController.I().X(true);
        }
        RoomInfo roomInfo = this.f244095i0;
        if (roomInfo != null) {
            if (!TextUtils.isEmpty(roomInfo.f245602m)) {
                Ji();
            }
            this.N.setText(this.f244095i0.f245601i);
        }
        if (this.f244096j0) {
            this.D.addOnLayoutChangeListener(new f());
        }
    }

    private void ji() {
        final boolean z16 = !VoiceChatController.I().M();
        Bi(z16);
        if (z16) {
            Di(R.string.x1k, 1);
        } else {
            Gi();
            Di(R.string.x1j, 1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_switch_status", Integer.valueOf(z16 ? 1 : 0));
        y82.a.b().e(this.W, "em_kl_new_voice_match_call_microphpone_btn", hashMap);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.17
            @Override // java.lang.Runnable
            public void run() {
                VoiceChatController.I().W(z16);
            }
        }, 16, null, true);
    }

    private void ki() {
        if (this.f244104r0) {
            return;
        }
        if (this.f244101o0) {
            QLog.i("MatchFriendVoiceMatchFragment", 1, "[handlePendingTask] showAlert, mPendingAlertText=" + this.f244102p0 + ", mPendingAlertType" + this.f244103q0);
            zi(this.f244102p0, this.f244103q0);
            this.f244101o0 = false;
        }
        if (this.f244099m0) {
            QLog.i("MatchFriendVoiceMatchFragment", 1, "[handlePendingTask] hangup, mPendingHangUpDelay=" + this.f244100n0);
            ii(this.f244100n0);
            this.f244099m0 = false;
        }
    }

    private void li() {
        RoomInfo E = VoiceChatController.I().E();
        this.f244095i0 = E;
        if (E == null) {
            return;
        }
        VoiceChatController.I().A(this.f244107u0);
        startTimer();
    }

    private void mi() {
        int i3;
        final int i16 = !VoiceChatController.I().O() ? 1 : 0;
        if (i16 != 0) {
            Di(R.string.x1s, 1);
            i3 = R.drawable.g07;
        } else {
            Di(R.string.x1r, 1);
            i3 = R.drawable.g06;
        }
        this.f244087a0.setImageDrawable(getResources().getDrawable(i3));
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_switch_status", Integer.valueOf(i16));
        y82.a.b().e(this.W, "em_kl_new_voice_match_call_speaker_btn", hashMap);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.16
            @Override // java.lang.Runnable
            public void run() {
                VoiceChatController.I().c0(i16, 0);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni() {
        ThreadManager.getUIHandler().post(this.f244109w0);
    }

    private void oi(View view) {
        HashMap hashMap = new HashMap();
        if (this.f244095i0 != null) {
            hashMap.put("kl_new_from_openid", com.tencent.mobileqq.matchfriend.utils.b.d().j());
            hashMap.put("kl_new_to_openid", this.f244095i0.f245600h);
        }
        y82.a.b().c(getQBaseActivity(), view, "pg_kl_new_voice_match_call", new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        List<com.tencent.mobileqq.matchfriend.bean.a> H = VoiceChatController.I().H();
        if (H != null && H.size() != 0) {
            qi(H);
        } else {
            QLog.d("MatchFriendVoiceMatchFragment", 1, "initIceBreakTopic dataList is null");
        }
    }

    private void qi(List<com.tencent.mobileqq.matchfriend.bean.a> list) {
        MatchFriendLoopScrollView matchFriendLoopScrollView = this.f244090d0;
        if (matchFriendLoopScrollView != null) {
            matchFriendLoopScrollView.g(list);
            this.f244090d0.setVisibility(0);
        }
        TextView textView = this.f244089c0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    private void ri() {
        if (this.f244096j0 || this.f244095i0 == null) {
            return;
        }
        IMatchFriendRequest iMatchFriendRequest = (IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class);
        QQStrangerAppInterface qQStrangerAppInterface = this.C;
        RoomInfo roomInfo = this.f244095i0;
        iMatchFriendRequest.getVoiceLinkIceBreakTopic(qQStrangerAppInterface, roomInfo.f245599f, roomInfo.f245598e);
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(this.f244095i0.f245598e));
        arrayList.add(String.valueOf(this.f244095i0.f245599f));
        ((IMatchFriendRequest) QRoute.api(IMatchFriendRequest.class)).batchGetUserGender(this.C, arrayList);
        Bundle bundle = new Bundle();
        bundle.putLong("friend_tiny_id", this.f244095i0.f245599f);
        QIPCClientHelper.getInstance().getClient().callServer("MatchFriendVoiceChatIpcServer", "enterVoiceChat", bundle, null);
    }

    private void si() {
        List<Pair<Long, Integer>> G = VoiceChatController.I().G();
        if (G != null && G.size() != 0) {
            ui(G);
        } else {
            QLog.d("MatchFriendVoiceMatchFragment", 1, "initVoiceAnim dataList is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        if (VoiceChatController.I().L()) {
            TimerTask timerTask = new TimerTask() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.9
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RoomInfo E = VoiceChatController.I().E();
                            MatchFriendVoiceMatchFragment.this.T.setText(com.tencent.mobileqq.matchfriend.voicechat.b.a(E == null ? 0L : System.currentTimeMillis() - E.E));
                        }
                    });
                }
            };
            Timer timer = this.U;
            if (timer != null) {
                timer.cancel();
                this.U.purge();
            }
            BaseTimer baseTimer = new BaseTimer();
            this.U = baseTimer;
            baseTimer.schedule(timerTask, 0L, 1000L);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    MatchFriendVoiceMatchFragment.this.T.setVisibility(0);
                }
            });
        }
    }

    private void ti() {
        this.f244093g0 = new VoiceAnimController(this.L);
        this.f244094h0 = new VoiceAnimController(this.K);
    }

    private void ui(List<Pair<Long, Integer>> list) {
        int i3 = 0;
        int i16 = 0;
        for (Pair<Long, Integer> pair : list) {
            if (this.f244095i0.f245598e == ((Long) pair.first).longValue()) {
                i3 = ((Integer) pair.second).intValue();
            } else if (this.f244095i0.f245599f == ((Long) pair.first).longValue()) {
                i16 = ((Integer) pair.second).intValue();
            }
        }
        if (i3 == 0) {
            i3 = 1;
        }
        if (i16 == 0) {
            i16 = 1;
        }
        String ei5 = ei(i3, 1);
        String ei6 = ei(i16, i3 == i16 ? 2 : 1);
        VoiceAnimController voiceAnimController = this.f244093g0;
        if (voiceAnimController != null) {
            voiceAnimController.p(ei5);
        }
        VoiceAnimController voiceAnimController2 = this.f244094h0;
        if (voiceAnimController2 != null) {
            voiceAnimController2.p(ei6);
        }
    }

    private void vi() {
        Bundle bundle = new Bundle();
        bundle.putLong("friend_tiny_id", this.f244095i0.f245599f);
        bundle.putString("key_nickname", this.f244095i0.f245601i);
        bundle.putInt("key_first_relation_origin", 2);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MatchFriendIpcServer", "jumpMatchFriendAIO", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        if (getQBaseActivity() == null) {
            return;
        }
        LottieHelper.b(getQBaseActivity(), "qav_mic_voice_lottie/data.json", "qav_mic_voice_lottie/images/", getResources().getDimensionPixelSize(R.dimen.f10351u), getResources().getDimensionPixelSize(R.dimen.f10331s), -1, new d());
    }

    private void xi() {
        this.f244105s0 = new RelationFloatWindowPermissionHandler();
        this.f244106t0 = com.tencent.mobileqq.matchfriend.utils.a.a(false);
        if (this.f244105s0.c()) {
            com.tencent.mobileqq.matchfriend.utils.a.c(true);
            ((IRelationFloatWindowAnim) QRoute.api(IRelationFloatWindowAnim.class)).doCircleOuterAnimation(this.D, this.f244106t0, this.f244112z0);
        } else {
            this.f244105s0.f(new b());
            this.f244105s0.e(R.string.wzn, R.string.wzl, R.string.wzk, R.string.wzm, null);
            y82.a.b().f(this.f244088b0, "em_kl_new_voice_match_call_minimize_authorize");
        }
        y82.a.b().d(this.E, "em_kl_new_voice_match_call_minimize_btn");
    }

    private void yi(boolean z16) {
        if (this.f244095i0 == null) {
            QLog.e("MatchFriendVoiceMatchFragment", 1, "openProfileCard mRoomInfo is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_self", z16);
        if (z16) {
            bundle.putLong("key_self_tiny_id", this.f244095i0.f245598e);
        } else {
            bundle.putString("key_open_id", this.f244095i0.f245600h);
        }
        bundle.putInt("key_first_relation_origin", 2);
        bundle.putInt("key_from_source", 6);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "MatchFriendVoiceChatIpcServer", "openProfile", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(String str, int i3) {
        this.S.setText(str);
        this.R.setVisibility(i3 == 3 ? 0 : 8);
        this.Q.setVisibility(0);
        ThreadManager.getUIHandler().removeCallbacks(this.f244109w0);
        if (i3 == 1 || i3 == 3) {
            ThreadManager.getUIHandler().postDelayed(this.f244109w0, 3000L);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        xi();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u.a().b()) {
            return;
        }
        switch (view.getId()) {
            case R.id.f163151ol0 /* 1829044336 */:
                ji();
                return;
            case R.id.omx /* 1829044407 */:
                yi(false);
                return;
            case R.id.oqy /* 1829044555 */:
                yi(true);
                return;
            case R.id.osp /* 1829044620 */:
                ii(0L);
                y82.a.b().d(this.Z, "em_kl_new_voice_match_call_hung_up_btn");
                return;
            case R.id.osq /* 1829044621 */:
                ci();
                return;
            case R.id.oss /* 1829044623 */:
                xi();
                return;
            case R.id.ost /* 1829044624 */:
                mi();
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Hi();
        Ii();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        QLog.i("MatchFriendVoiceMatchFragment", 1, "onFinish, mIsOpenFloatWindow" + this.f244097k0);
        QQStrangerAppInterface qQStrangerAppInterface = this.C;
        if (qQStrangerAppInterface != null) {
            qQStrangerAppInterface.removeObserver(this.f244108v0);
        } else {
            QLog.e("MatchFriendVoiceMatchFragment", 1, "onFinish: app.removeObserver is error! app is null!");
        }
        if (!this.f244097k0) {
            VoiceChatController.I().Y(null);
            VoiceChatController.I().Z(null);
        }
        boolean F = VoiceChatController.I().F();
        if (!this.f244097k0 || F) {
            VoiceChatController.I().X(false);
            RoomInfo roomInfo = this.f244095i0;
            if (roomInfo != null && roomInfo.f245599f != 0) {
                vi();
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.6
                    @Override // java.lang.Runnable
                    public void run() {
                        MatchFriendVoiceMatchFragment.super.onFinish();
                    }
                }, 4000L);
                return;
            }
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f244098l0 = true;
        MatchFriendBackgroundView matchFriendBackgroundView = this.H;
        if (matchFriendBackgroundView != null) {
            matchFriendBackgroundView.a();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f244098l0 = false;
        AlphaClickableImageView alphaClickableImageView = this.F;
        if (alphaClickableImageView != null) {
            alphaClickableImageView.setClickable(true);
        }
        Ci();
        MatchFriendBackgroundView matchFriendBackgroundView = this.H;
        if (matchFriendBackgroundView != null) {
            matchFriendBackgroundView.b();
        }
        ki();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("MatchFriendVoiceMatchFragment", 1, "dispatchEvent MatchVoiceDismissLoadingEvent.");
                SimpleEventBus.getInstance().dispatchEvent(new QQStrangerMatchVoiceDismissLoadingEvent(), true);
            }
        }, 16, null, true, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements RelationFloatWindowPermissionHandler.a {
        b() {
        }

        @Override // com.tencent.relation.common.handler.RelationFloatWindowPermissionHandler.a
        public void a(boolean z16) {
            if (z16) {
                QLog.d("MatchFriendVoiceMatchFragment", 1, "initFloatWindowPermissionHandler: grant window permission.");
                com.tencent.mobileqq.matchfriend.utils.a.c(true);
                ((IRelationFloatWindowAnim) QRoute.api(IRelationFloatWindowAnim.class)).doCircleOuterAnimation(MatchFriendVoiceMatchFragment.this.D, MatchFriendVoiceMatchFragment.this.f244106t0, MatchFriendVoiceMatchFragment.this.f244112z0);
                y82.a.b().d(MatchFriendVoiceMatchFragment.this.f244088b0, "em_kl_new_voice_match_call_minimize_authorize");
            }
        }
    }

    private void Gi() {
        this.f244091e0 = 0;
        ValueAnimator valueAnimator = this.f244092f0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f244092f0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements LottieHelper.d {
        d() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            if (lottieDrawable == null) {
                return;
            }
            if (MatchFriendVoiceMatchFragment.this.Y != null && MatchFriendVoiceMatchFragment.this.Y.isRunning()) {
                MatchFriendVoiceMatchFragment.this.Y.stop();
                MatchFriendVoiceMatchFragment.this.Y.removeAllAnimatorListeners();
            }
            MatchFriendVoiceMatchFragment.this.Y = lottieDrawable;
            if (MatchFriendVoiceMatchFragment.this.X != null) {
                MatchFriendVoiceMatchFragment.this.X.setBackground(MatchFriendVoiceMatchFragment.this.Y);
            }
            MatchFriendVoiceMatchFragment.this.Y.start();
            QLog.i("MatchFriendVoiceMatchFragment", 1, "loadSpeakingLottie success.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(List<Pair<Long, Integer>> list) {
        if (list != null && list.size() != 0) {
            VoiceChatController.I().Y(list);
            ui(list);
        } else {
            QLog.e("MatchFriendVoiceMatchFragment", 1, "handleBatchGetUserGender dataList is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hi(List<com.tencent.mobileqq.matchfriend.bean.a> list) {
        if (list != null && list.size() != 0) {
            VoiceChatController.I().Z(list);
        } else {
            QLog.e("MatchFriendVoiceMatchFragment", 1, "handleGetVoiceLinkIceBreakTopic dataList is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(View view, int i3) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.height = (int) (((i3 * 1.0d) / 10000.0d) * BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f10331s));
        marginLayoutParams.topMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f10341t) - marginLayoutParams.height;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.D = layoutInflater.inflate(R.layout.cwg, viewGroup, false);
        QQStrangerAppInterface qQStrangerAppInterface = (QQStrangerAppInterface) getQBaseActivity().getAppRuntime();
        this.C = qQStrangerAppInterface;
        qQStrangerAppInterface.addObserver(this.f244108v0);
        this.f244104r0 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqstranger_disable_pause_pending_task", false);
        QLog.i("MatchFriendVoiceMatchFragment", 1, "disablePendingTask=" + this.f244104r0);
        initData();
        initUI();
        ri();
        oi(this.D);
        return this.D;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class e implements com.tencent.relation.common.servlet.b {
        e() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 == 19) {
                if (z16) {
                    MatchFriendVoiceMatchFragment.this.hi((List) obj);
                    return;
                }
                return;
            }
            if (i3 == 20 && z16) {
                MatchFriendVoiceMatchFragment.this.fi((List) obj);
            }
        }
    }

    private String ei(int i3, int i16) {
        if (i16 == 1) {
            if (i3 == 2) {
                return "https://downv6.qq.com/extendfriend/anim_female_output.png";
            }
            return "https://downv6.qq.com/extendfriend/anim_gender_output.png";
        }
        if (i3 == 2) {
            return "https://downv6.qq.com/extendfriend/anim_female_output_copy.png";
        }
        return "https://downv6.qq.com/extendfriend/anim_gender_output_copy.png";
    }

    private void Bi(boolean z16) {
        this.W.setImageDrawable(getResources().getDrawable(z16 ? R.drawable.f159745g04 : R.drawable.f159744g03));
        this.X.setVisibility(z16 ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(int i3) {
        int i16;
        int i17 = i3 > 100 ? 10000 : i3 > 0 ? ((int) (((i3 * 1.0d) / 100.0d) * 7500.0d)) + 2500 : 0;
        int i18 = this.f244091e0;
        this.f244091e0 = i17;
        if (i17 != i18) {
            ValueAnimator valueAnimator = this.f244092f0;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                i16 = -1;
            } else {
                i18 = ((Integer) this.f244092f0.getAnimatedValue()).intValue();
                this.f244092f0.cancel();
                i16 = i18;
            }
            if (this.f244092f0 == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.f244092f0 = valueAnimator2;
                valueAnimator2.addUpdateListener(new c());
            }
            this.f244092f0.setDuration(this.f244091e0 > i18 ? 100L : 200L);
            ValueAnimator valueAnimator3 = this.f244092f0;
            int[] iArr = new int[2];
            if (i16 != -1) {
                i18 = i16;
            }
            iArr[0] = i18;
            iArr[1] = this.f244091e0;
            valueAnimator3.setIntValues(iArr);
            this.f244092f0.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class VoiceAnimController {

        /* renamed from: a, reason: collision with root package name */
        private final ImageView f244131a;

        /* renamed from: b, reason: collision with root package name */
        private ApngDrawable f244132b;

        /* renamed from: c, reason: collision with root package name */
        private ValueAnimator f244133c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f244134d = false;

        /* renamed from: e, reason: collision with root package name */
        private int f244135e = 0;

        /* renamed from: f, reason: collision with root package name */
        private boolean f244136f = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f16;
                float f17;
                float f18;
                VoiceAnimController.this.f244135e = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (VoiceAnimController.this.f244136f) {
                    if (VoiceAnimController.this.f244135e < 500 || VoiceAnimController.this.f244135e >= 1000) {
                        return;
                    } else {
                        VoiceAnimController.this.f244136f = false;
                    }
                }
                if (VoiceAnimController.this.f244135e < 0 || VoiceAnimController.this.f244135e >= 500) {
                    if (500 > VoiceAnimController.this.f244135e || VoiceAnimController.this.f244135e >= 2000) {
                        if (2000 > VoiceAnimController.this.f244135e || VoiceAnimController.this.f244135e >= 2200) {
                            return;
                        }
                        f16 = Constants.Action.ACTION_APP_GUARD - VoiceAnimController.this.f244135e;
                        f17 = 200.0f;
                    } else {
                        f18 = 1.0f;
                        VoiceAnimController.this.f244131a.setAlpha(f18);
                    }
                } else {
                    f16 = VoiceAnimController.this.f244135e;
                    f17 = 500.0f;
                }
                f18 = f16 / f17;
                VoiceAnimController.this.f244131a.setAlpha(f18);
            }
        }

        public VoiceAnimController(ImageView imageView) {
            this.f244131a = imageView;
            imageView.setAlpha(0.0f);
            o();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public URLDrawable m(String str) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int dimensionPixelSize = BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.f10371w);
            obtain.mRequestWidth = dimensionPixelSize;
            obtain.mRequestHeight = dimensionPixelSize;
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mUseApngImage = true;
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 1);
            obtain.mExtraInfo = bundle;
            obtain.mPlayGifImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.setURLDrawableListener(new a());
            return drawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(URLDrawable uRLDrawable) {
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                QLog.d("MatchFriendVoiceMatchFragment", 1, "initApngDrawable success");
                ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
                apngDrawable.getImage().setSupportGlobalPasued(false);
                this.f244132b = apngDrawable;
            }
        }

        private void o() {
            if (this.f244133c == null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(Constants.Action.ACTION_APP_GUARD);
                this.f244133c = ofInt;
                ofInt.setDuration(2200L);
                this.f244133c.setInterpolator(new LinearInterpolator());
                this.f244133c.addUpdateListener(new b());
                this.f244133c.addListener(new c());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(final String str) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.VoiceAnimController.1
                @Override // java.lang.Runnable
                public void run() {
                    URLDrawable m3 = VoiceAnimController.this.m(str);
                    VoiceAnimController.this.f244131a.setImageDrawable(m3);
                    if (m3.getCurrDrawable() instanceof ApngDrawable) {
                        VoiceAnimController.this.n(m3);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q() {
            this.f244132b.repaly();
            this.f244133c.start();
        }

        public void l() {
            int i3;
            if (this.f244132b == null) {
                QLog.e("MatchFriendVoiceMatchFragment", 1, "checkShowVoiceAnim apngDrawable is null");
                return;
            }
            if (!this.f244134d) {
                this.f244134d = true;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.fragment.MatchFriendVoiceMatchFragment.VoiceAnimController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        VoiceAnimController.this.q();
                    }
                });
            } else if (!this.f244136f && (i3 = this.f244135e) >= 1000 && i3 < 2000) {
                this.f244136f = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public class a implements URLDrawable.URLDrawableListener {
            a() {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable) {
                VoiceAnimController.this.n(uRLDrawable);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes33.dex */
        public class c implements Animator.AnimatorListener {
            c() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                VoiceAnimController.this.f244134d = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!VoiceAnimController.this.f244136f || VoiceAnimController.this.f244132b == null) {
                    VoiceAnimController.this.f244134d = false;
                } else {
                    VoiceAnimController.this.q();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }
    }
}
