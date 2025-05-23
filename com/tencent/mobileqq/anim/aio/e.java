package com.tencent.mobileqq.anim.aio;

import android.os.SystemClock;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b*\u0001)\b\u0000\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0001\fB)\b\u0002\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00100\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b1\u00102B=\b\u0016\u0012\b\u00103\u001a\u0004\u0018\u00010!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u00104\u001a\u00020\u000b\u0012\u0006\u00105\u001a\u00020\u000b\u00a2\u0006\u0004\b1\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/e;", "Landroid/view/animation/AnimationSet;", "Lcom/tencent/mobileqq/anim/aio/b;", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "l", "k", "i", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "a", "Landroid/view/animation/Animation$AnimationListener;", "listener", "setAnimationListener", "Landroid/view/animation/Transformation;", "outTransformation", "getTransformation", "reset", "", "d", "I", "frameCount", "e", "delayTime", "J", "lastFrameTime", tl.h.F, "animationStartTime", "Z", "readyToStart", "isAnimationStart", "Lcom/tencent/mobileqq/anim/aio/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/anim/aio/a;", "animationController", "D", "Landroid/view/animation/Animation$AnimationListener;", "E", "didLogAnimationEnd", "com/tencent/mobileqq/anim/aio/e$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/anim/aio/e$b;", "animationListener", "", "fromX", "toX", "alphaAnimation", "<init>", "(FFZI)V", "controller", "useAlphaAnimation", "delayStartAnimation", "(Lcom/tencent/mobileqq/anim/aio/a;Landroid/view/animation/Animation$AnimationListener;FFZZ)V", "G", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e extends AnimationSet implements com.tencent.mobileqq.anim.aio.b {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Nullable
    private static volatile WeakReference<com.tencent.mobileqq.anim.aio.b> H;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a animationController;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Animation.AnimationListener listener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean didLogAnimationEnd;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b animationListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int frameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int delayTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastFrameTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long animationStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean readyToStart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimationStart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/anim/aio/e$a;", "", "Lcom/tencent/mobileqq/anim/aio/b;", "a", "", "DEFAULT_DELAY_START_TIME", "I", "", "LOG_FRAME_TIME", "Z", "", "TAG", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "animationState", "Lmqq/util/WeakReference;", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.anim.aio.e$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @Nullable
        public final com.tencent.mobileqq.anim.aio.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.anim.aio.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            if (e.H != null) {
                WeakReference weakReference = e.H;
                Intrinsics.checkNotNull(weakReference);
                return (com.tencent.mobileqq.anim.aio.b) weakReference.get();
            }
            return null;
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/anim/aio/e$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animation.AnimationListener animationListener = e.this.listener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animation.AnimationListener animationListener = e.this.listener;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    e(float f16, float f17, boolean z16, int i3) {
        super(false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        b bVar = new b();
        this.animationListener = bVar;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, f16, 1, f17, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(getDuration());
        translateAnimation.setInterpolator(getInterpolator());
        addAnimation(translateAnimation);
        if (z16) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(getDuration());
            addAnimation(alphaAnimation);
        }
        reset();
        this.delayTime = i3;
        super.setAnimationListener(bVar);
        if (QLog.isColorLevel()) {
            QLog.i("AIOEnterAnimation", 2, "[init] delay=" + i3);
        }
    }

    private final void f(long currentTime) {
        boolean z16;
        if (this.isAnimationStart) {
            return;
        }
        if (this.frameCount == 1) {
            this.animationStartTime = SystemClock.uptimeMillis() + this.delayTime;
            m(currentTime);
            return;
        }
        boolean z17 = false;
        if (SystemClock.uptimeMillis() >= this.animationStartTime) {
            z16 = true;
        } else {
            z16 = false;
        }
        a aVar = this.animationController;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.a()) {
                z17 = true;
            }
        }
        if (!z16 && !z17) {
            m(currentTime);
            return;
        }
        if (!this.readyToStart) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOEnterAnimation", 1, "ready to start, timeOffset=" + (SystemClock.uptimeMillis() - this.animationStartTime) + " timeUp=" + z16 + " listHasShown=" + z17);
            }
            m(currentTime);
            this.readyToStart = true;
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.anim.aio.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.h(e.this);
                }
            });
            return;
        }
        m(currentTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIOEnterAnimation", 1, "animation start, timeOffset=" + (SystemClock.uptimeMillis() - this$0.animationStartTime));
        this$0.isAnimationStart = true;
    }

    private final void i(long currentTime) {
        if (this.isAnimationStart) {
            return;
        }
        if (!this.readyToStart) {
            m(currentTime);
            this.readyToStart = true;
            this.animationStartTime = SystemClock.uptimeMillis();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.anim.aio.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.j(e.this);
                }
            });
            return;
        }
        m(currentTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIOEnterAnimation", 1, "animation start, timeOffset=" + (SystemClock.uptimeMillis() - this$0.animationStartTime));
        this$0.isAnimationStart = true;
    }

    private final void l(long currentTime) {
        if (QLog.isColorLevel() && !this.didLogAnimationEnd) {
            this.didLogAnimationEnd = true;
            QLog.i("AIOEnterAnimation", 2, "[onAnimationEnd] currentTime=" + currentTime);
        }
        H = null;
    }

    private final void m(long currentTime) {
        setStartTime(currentTime + 1);
    }

    @Override // com.tencent.mobileqq.anim.aio.b
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isAnimationStart;
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long currentTime, @NotNull Transformation outTransformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Long.valueOf(currentTime), outTransformation)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(outTransformation, "outTransformation");
        int i3 = this.frameCount + 1;
        this.frameCount = i3;
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOEnterAnimation", 2, "animation starts currentTime=" + currentTime);
            }
            Animation.AnimationListener animationListener = this.listener;
            if (animationListener != null) {
                animationListener.onAnimationStart(this);
            }
        }
        if (this.delayTime == 0) {
            i(currentTime);
        } else {
            f(currentTime);
        }
        k(currentTime);
        boolean transformation = super.getTransformation(currentTime, outTransformation);
        if (!transformation) {
            l(currentTime);
        }
        return transformation;
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.frameCount = 0;
        this.readyToStart = false;
        this.isAnimationStart = false;
        this.lastFrameTime = 0L;
        this.animationStartTime = 0L;
        H = new WeakReference<>(this);
        this.didLogAnimationEnd = false;
        super.reset();
    }

    @Override // android.view.animation.Animation
    public void setAnimationListener(@Nullable Animation.AnimationListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }

    public e(@Nullable a aVar, @Nullable Animation.AnimationListener animationListener, float f16, float f17, boolean z16, boolean z17) {
        this(f16, f17, z16, z17 ? 100 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, aVar, animationListener, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.animationController = aVar;
            this.listener = animationListener;
        }
    }

    private final void k(long currentTime) {
    }
}
