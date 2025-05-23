package com.tencent.mobileqq.anim.aio;

import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n*\u0001\u001f\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001,B7\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010(\u001a\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/g;", "Landroid/view/animation/AnimationSet;", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "c", "", "reason", "b", "Landroid/view/animation/Animation$AnimationListener;", "listener", "setAnimationListener", "Landroid/view/animation/Transformation;", "outTransformation", "", "getTransformation", "reset", "", "d", "I", "frameCount", "e", "Z", QZoneJsConstants.ACTION_START_ANIMATION, "f", "J", "startAnimationTime", tl.h.F, "startAnimationTimeout", "i", "Landroid/view/animation/Animation$AnimationListener;", "com/tencent/mobileqq/anim/aio/g$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/anim/aio/g$b;", "animationListener", "", "fromX", "toX", "useAlphaAnimation", "eventListener", "timeout", "<init>", "(FFZLandroid/view/animation/Animation$AnimationListener;I)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends AnimationSet {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean startAnimation;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long startAnimationTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long startAnimationTimeout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animation.AnimationListener listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b animationListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/g$a;", "", "", "START_ANIMATION_TIMEOUT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.anim.aio.g$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/anim/aio/g$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                Animation.AnimationListener animationListener = g.this.listener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                Animation.AnimationListener animationListener = g.this.listener;
                if (animationListener != null) {
                    animationListener.onAnimationRepeat(animation);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ g(float f16, float f17, boolean z16, Animation.AnimationListener animationListener, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(f16, f17, z16, (i16 & 8) != 0 ? null : animationListener, (i16 & 16) != 0 ? 200 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), animationListener, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final void b(long currentTime, String reason) {
        if (!this.startAnimation) {
            if (QLog.isColorLevel()) {
                QLog.i("MainExitAnimation", 2, "[setAnimationStart] reason=" + reason + ", currentTime=" + currentTime);
            }
            this.startAnimation = true;
            setStartTime(currentTime);
        }
    }

    private final void c(long currentTime) {
        if (this.startAnimation) {
            return;
        }
        if (this.startAnimationTime > 0 && SystemClock.uptimeMillis() > this.startAnimationTime) {
            QLog.i("MainExitAnimation", 1, "[updateAnimationState] time limit reached, start animation");
            b(currentTime, "timeout");
            return;
        }
        com.tencent.mobileqq.anim.aio.b a16 = e.INSTANCE.a();
        if (a16 != null && !a16.a()) {
            setStartTime(currentTime);
            return;
        }
        b(currentTime, "enter animation started, state=" + a16);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long currentTime, @NotNull Transformation outTransformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Long.valueOf(currentTime), outTransformation)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(outTransformation, "outTransformation");
        int i3 = this.frameCount + 1;
        this.frameCount = i3;
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("MainExitAnimation", 1, "animation starts, currentTime=" + currentTime);
            }
            Animation.AnimationListener animationListener = this.listener;
            if (animationListener != null) {
                animationListener.onAnimationStart(this);
            }
            long j3 = 0;
            if (this.startAnimationTimeout != 0) {
                j3 = this.startAnimationTimeout + SystemClock.uptimeMillis();
            }
            this.startAnimationTime = j3;
        }
        c(currentTime);
        return super.getTransformation(currentTime, outTransformation);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.reset();
        this.frameCount = 0;
        this.startAnimation = false;
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(@Nullable Animation.AnimationListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }

    @JvmOverloads
    public g(float f16, float f17, boolean z16, @Nullable Animation.AnimationListener animationListener, int i3) {
        super(false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), animationListener, Integer.valueOf(i3));
            return;
        }
        b bVar = new b();
        this.animationListener = bVar;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f16, 1, f17, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(getDuration());
        translateAnimation.setInterpolator(getInterpolator());
        addAnimation(translateAnimation);
        if (z16) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(getDuration());
            addAnimation(alphaAnimation);
        }
        reset();
        this.listener = animationListener;
        this.startAnimationTimeout = i3;
        super.setAnimationListener(bVar);
        if (QLog.isColorLevel()) {
            QLog.i("MainExitAnimation", 2, "[init] timeout=" + i3);
        }
    }
}
