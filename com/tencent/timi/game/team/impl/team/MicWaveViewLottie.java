package com.tencent.timi.game.team.impl.team;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.airbnb.lottie.RenderMode;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qq.effect.engine.QEffectType;
import com.tencent.timi.game.ui.SafeLottieAnimationView;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.l;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MicWaveViewLottie extends FrameLayout implements co4.b {

    /* renamed from: d, reason: collision with root package name */
    co4.d f379683d;

    /* renamed from: e, reason: collision with root package name */
    SafeLottieAnimationView f379684e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f379685f;

    /* renamed from: h, reason: collision with root package name */
    private CommonOuterClass$QQUserId f379686h;

    /* renamed from: i, reason: collision with root package name */
    private String f379687i;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f379688m;

    public MicWaveViewLottie(Context context) {
        super(context);
        this.f379685f = false;
        this.f379687i = "lottie/tg_voice_anim_male.json";
        this.f379688m = new Runnable() { // from class: com.tencent.timi.game.team.impl.team.MicWaveViewLottie.1
            @Override // java.lang.Runnable
            public void run() {
                MicWaveViewLottie.this.f379685f = false;
            }
        };
        i();
    }

    private void i() {
        this.f379683d = ((bo4.d) mm4.b.b(bo4.d.class)).n2(this);
        this.f379684e = new SafeLottieAnimationView(getContext());
        if (ah.o0()) {
            this.f379684e.setRenderMode(RenderMode.SOFTWARE);
        }
        addView(this.f379684e, new FrameLayout.LayoutParams(-1, -1));
        this.f379684e.setImageAssetsFolder(QEffectType.LOTTIE_TAG);
        this.f379684e.setRepeatCount(0);
        this.f379684e.addAnimatorListener(new a());
        this.f379684e.setAnimation(this.f379687i);
    }

    private void k(boolean z16) {
        String str;
        if (z16) {
            str = "lottie/tg_voice_anim_female.json";
        } else {
            str = "lottie/tg_voice_anim_male.json";
        }
        if (!str.equals(this.f379687i)) {
            this.f379687i = str;
            this.f379684e.setAnimation(str);
        }
    }

    @Override // co4.b
    public void a() {
        k(false);
    }

    @Override // co4.b
    public void b() {
        k(false);
    }

    @Override // co4.b
    public boolean c() {
        return false;
    }

    @Override // co4.b
    public void d() {
        k(false);
    }

    @Override // co4.b
    public void e(IUserInfo iUserInfo) {
        boolean z16;
        if (iUserInfo != null && TextUtils.equals(iUserInfo.m(this.f379686h), "\u5973")) {
            z16 = true;
        } else {
            z16 = false;
        }
        k(z16);
    }

    public void j() {
        l.b("MicWaveViewLottie", "playWaveAnimation  mIsPlayingMicAnim=" + this.f379685f);
        if (this.f379685f) {
            return;
        }
        this.f379684e.setVisibility(0);
        this.f379685f = true;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f379688m);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.f379688m, 2500L);
        this.f379684e.playAnimation();
    }

    public void setUserId(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        this.f379686h = commonOuterClass$QQUserId;
        this.f379683d.g(commonOuterClass$QQUserId);
    }

    public MicWaveViewLottie(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f379685f = false;
        this.f379687i = "lottie/tg_voice_anim_male.json";
        this.f379688m = new Runnable() { // from class: com.tencent.timi.game.team.impl.team.MicWaveViewLottie.1
            @Override // java.lang.Runnable
            public void run() {
                MicWaveViewLottie.this.f379685f = false;
            }
        };
        i();
    }

    public MicWaveViewLottie(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f379685f = false;
        this.f379687i = "lottie/tg_voice_anim_male.json";
        this.f379688m = new Runnable() { // from class: com.tencent.timi.game.team.impl.team.MicWaveViewLottie.1
            @Override // java.lang.Runnable
            public void run() {
                MicWaveViewLottie.this.f379685f = false;
            }
        };
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            MicWaveViewLottie.this.f379688m.run();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            MicWaveViewLottie.this.f379688m.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
