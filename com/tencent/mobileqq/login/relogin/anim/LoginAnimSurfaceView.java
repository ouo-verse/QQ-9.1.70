package com.tencent.mobileqq.login.relogin.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.relogin.anim.b;
import com.tencent.mobileqq.login.relogin.fragment.SplashLoginSuccessAnimator;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0002;<B-\u0012\b\u00107\u001a\u0004\u0018\u000106\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e\u00a2\u0006\u0004\b8\u00109J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010'\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0018\u00010(R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "o", "", "curPlayTime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Landroid/animation/ValueAnimator;", "animator", "currentPlayTime", DomainData.DOMAIN_NAME, "r", "onDraw", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Landroid/view/SurfaceHolder;", "holder", "", "format", "width", "height", "surfaceChanged", "surfaceCreated", "surfaceDestroyed", "", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "d", "Ljava/util/List;", "mAnimatorItemList", "e", "animatorList", "f", "Landroid/view/SurfaceHolder;", "mSurfaceHolder", "Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView$DrawingThread;", h.F, "Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView$DrawingThread;", "mThread", "i", "Z", "isAnimFinish", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "totalAnimatorDuration", "Lcom/tencent/mobileqq/login/relogin/anim/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/login/relogin/anim/b;", "recorder", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;)V", "D", "b", "DrawingThread", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginAnimSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<Boolean> E;

    @NotNull
    private static final Lazy<Boolean> F;

    @NotNull
    private static final Lazy<Boolean> G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b recorder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SplashLoginSuccessAnimator.AnimatorItem> mAnimatorItemList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ValueAnimator> animatorList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SurfaceHolder mSurfaceHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private DrawingThread mThread;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isAnimFinish;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long totalAnimatorDuration;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView$DrawingThread;", "Ljava/lang/Thread;", "", "frameCost", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "startPlay", "r", TencentLocation.RUN_MODE, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "getKeepRunning", "()Z", "p", "(Z)V", "keepRunning", "D", "J", "E", "o", "()J", "setCurPlayTime", "(J)V", "curPlayTime", "<init>", "(Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class DrawingThread extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private boolean keepRunning;

        /* renamed from: D, reason: from kotlin metadata */
        private long startPlay;

        /* renamed from: E, reason: from kotlin metadata */
        private long curPlayTime;

        public DrawingThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoginAnimSurfaceView.this);
            } else {
                setName("LoginSuccessAnimDrawingThread");
            }
        }

        private final void q(final long frameCost) {
            boolean z16 = false;
            if (frameCost < 15000000) {
                long j3 = 16000000 - frameCost;
                long j16 = 1000;
                try {
                    final long j17 = (j3 / j16) / j16;
                    LockMethodProxy.sleep(j17);
                    Companion.c(LoginAnimSurfaceView.INSTANCE, false, new Function0<String>(j17) { // from class: com.tencent.mobileqq.login.relogin.anim.LoginAnimSurfaceView$DrawingThread$sleepToFrameTime$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ long $mills;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$mills = j17;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, j17);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                            }
                            return "sleepToFrameTime [" + this.$mills + "]";
                        }
                    }, 1, null);
                    return;
                } catch (Exception e16) {
                    QLog.e("LoginAnimSurfaceView", 1, "sleepToFrameTime exception ", e16);
                    return;
                }
            }
            Companion companion = LoginAnimSurfaceView.INSTANCE;
            if (frameCost > 16000000) {
                z16 = true;
            }
            companion.b(z16, new Function0<String>(frameCost) { // from class: com.tencent.mobileqq.login.relogin.anim.LoginAnimSurfaceView$DrawingThread$sleepToFrameTime$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $frameCost;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$frameCost = frameCost;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, frameCost);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "sleepToFrameTime lag: " + this.$frameCost;
                }
            });
        }

        public final long o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.curPlayTime;
        }

        public final void p(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.keepRunning = z16;
            }
        }

        public final void r(long startPlay) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, startPlay);
                return;
            }
            this.startPlay = startPlay;
            LoginAnimSurfaceView.this.isAnimFinish = false;
            this.keepRunning = true;
            start();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0110 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Canvas canvas;
            long j3;
            Canvas lockCanvas;
            Companion companion;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            LoginAnimSurfaceView.this.recorder.b();
            Process.setThreadPriority(-8);
            Looper.prepare();
            LoginAnimSurfaceView.this.r();
            Canvas canvas2 = null;
            b.a aVar = null;
            while (this.keepRunning) {
                b.a aVar2 = new b.a();
                b.a.c(aVar2, 0, 0L, 2, null);
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        lockCanvas = LoginAnimSurfaceView.this.mSurfaceHolder.lockHardwareCanvas();
                    } else {
                        lockCanvas = LoginAnimSurfaceView.this.mSurfaceHolder.lockCanvas();
                    }
                    canvas = lockCanvas;
                } catch (Exception e16) {
                    e = e16;
                    canvas = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    try {
                        companion = LoginAnimSurfaceView.INSTANCE;
                        Companion.e(companion, aVar2, 1, 0L, 2, null);
                        if (canvas != null) {
                            LoginAnimSurfaceView.this.o(canvas);
                            Companion.e(companion, aVar2, 2, 0L, 2, null);
                            long currentTimeMillis = System.currentTimeMillis() - this.startPlay;
                            this.curPlayTime = currentTimeMillis;
                            LoginAnimSurfaceView.this.q(currentTimeMillis);
                            Companion.e(companion, aVar2, 3, 0L, 2, null);
                            if (this.curPlayTime >= LoginAnimSurfaceView.this.totalAnimatorDuration) {
                                QLog.i("LoginAnimSurfaceView", 1, "animator play finish");
                                LoginAnimSurfaceView.this.isAnimFinish = true;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        QLog.e("LoginAnimSurfaceView", 1, "drawing thread exception ", e);
                        if (canvas != null) {
                            if (LoginAnimSurfaceView.INSTANCE.h()) {
                                try {
                                    LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas);
                                } catch (Exception e18) {
                                    e = e18;
                                    QLog.e("LoginAnimSurfaceView", 1, "unlockCanvasAndPost exception: ", e);
                                    LoginAnimSurfaceView.this.p();
                                    Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                                    if (aVar == null) {
                                    }
                                    if (j3 <= 0) {
                                    }
                                    Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 5, 0L, 2, null);
                                    b.a.c(aVar2, 6, 0L, 2, null);
                                    LoginAnimSurfaceView.this.recorder.a(aVar2);
                                    aVar = aVar2;
                                }
                                Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                            }
                            LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas);
                            Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                        }
                        if (aVar == null) {
                        }
                        if (j3 <= 0) {
                        }
                        Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 5, 0L, 2, null);
                        b.a.c(aVar2, 6, 0L, 2, null);
                        LoginAnimSurfaceView.this.recorder.a(aVar2);
                        aVar = aVar2;
                    }
                    if (canvas != null) {
                        if (companion.h()) {
                            try {
                                LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas);
                            } catch (Exception e19) {
                                e = e19;
                                QLog.e("LoginAnimSurfaceView", 1, "unlockCanvasAndPost exception: ", e);
                                LoginAnimSurfaceView.this.p();
                                Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                                if (aVar == null) {
                                }
                                if (j3 <= 0) {
                                }
                                Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 5, 0L, 2, null);
                                b.a.c(aVar2, 6, 0L, 2, null);
                                LoginAnimSurfaceView.this.recorder.a(aVar2);
                                aVar = aVar2;
                            }
                            Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                        }
                        LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas);
                        Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                    }
                    if (aVar == null) {
                        j3 = aVar.a();
                    } else {
                        j3 = 0;
                    }
                    if (j3 <= 0) {
                        q(System.nanoTime() - j3);
                    }
                    Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 5, 0L, 2, null);
                    b.a.c(aVar2, 6, 0L, 2, null);
                    LoginAnimSurfaceView.this.recorder.a(aVar2);
                    aVar = aVar2;
                } catch (Throwable th6) {
                    th = th6;
                    canvas2 = canvas;
                    if (canvas2 != null) {
                        if (LoginAnimSurfaceView.INSTANCE.h()) {
                            try {
                                LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas2);
                            } catch (Exception e26) {
                                QLog.e("LoginAnimSurfaceView", 1, "unlockCanvasAndPost exception: ", e26);
                                LoginAnimSurfaceView.this.p();
                            }
                        } else {
                            LoginAnimSurfaceView.this.mSurfaceHolder.unlockCanvasAndPost(canvas2);
                        }
                        Companion.e(LoginAnimSurfaceView.INSTANCE, aVar2, 4, 0L, 2, null);
                    }
                    throw th;
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationEnd", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f242418d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LoginAnimSurfaceView f242419e;

        a(int i3, LoginAnimSurfaceView loginAnimSurfaceView) {
            this.f242418d = i3;
            this.f242419e = loginAnimSurfaceView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) loginAnimSurfaceView);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            int lastIndex;
            int lastIndex2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animation, Boolean.valueOf(isReverse));
                return;
            }
            int i3 = this.f242418d;
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.f242419e.animatorList);
            if (i3 < lastIndex) {
                ((ValueAnimator) this.f242419e.animatorList.get(this.f242418d + 1)).start();
                return;
            }
            int i16 = this.f242418d;
            lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(this.f242419e.animatorList);
            if (i16 == lastIndex2) {
                DrawingThread drawingThread = this.f242419e.mThread;
                if (drawingThread != null) {
                    drawingThread.p(false);
                }
                String c16 = this.f242419e.recorder.c();
                if (!TextUtils.isEmpty(c16)) {
                    QLog.i("LoginAnimSurfaceView", 1, c16);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002R\u001b\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/login/relogin/anim/LoginAnimSurfaceView$b;", "", "", "isErrorLevel", "Lkotlin/Function0;", "", "msg", "", "b", "Lcom/tencent/mobileqq/login/relogin/anim/b$a;", "", "eventId", "", "nanoTime", "d", "onDestroyFixSwitch$delegate", "Lkotlin/Lazy;", "f", "()Z", "onDestroyFixSwitch", "surfaceUnlockExpFixSwitch$delegate", h.F, "surfaceUnlockExpFixSwitch", "removeViewAnrFixSwitch$delegate", "g", "removeViewAnrFixSwitch", "DEBUG", "Z", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.relogin.anim.LoginAnimSurfaceView$b, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        static /* synthetic */ void c(Companion companion, boolean z16, Function0 function0, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            companion.b(z16, function0);
        }

        static /* synthetic */ void e(Companion companion, b.a aVar, int i3, long j3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                j3 = System.nanoTime();
            }
            companion.d(aVar, i3, j3);
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return ((Boolean) LoginAnimSurfaceView.E.getValue()).booleanValue();
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return ((Boolean) LoginAnimSurfaceView.G.getValue()).booleanValue();
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return ((Boolean) LoginAnimSurfaceView.F.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(boolean isErrorLevel, Function0<String> msg2) {
        }

        private final void d(b.a aVar, int i3, long j3) {
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<Boolean> lazy2;
        Lazy<Boolean> lazy3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23124);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LoginAnimSurfaceView$Companion$onDestroyFixSwitch$2.INSTANCE);
        E = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LoginAnimSurfaceView$Companion$surfaceUnlockExpFixSwitch$2.INSTANCE);
        F = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(LoginAnimSurfaceView$Companion$removeViewAnrFixSwitch$2.INSTANCE);
        G = lazy3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoginAnimSurfaceView(@Nullable Context context, @NotNull List<? extends SplashLoginSuccessAnimator.AnimatorItem> mAnimatorItemList, @NotNull List<? extends ValueAnimator> animatorList) {
        super(context);
        Intrinsics.checkNotNullParameter(mAnimatorItemList, "mAnimatorItemList");
        Intrinsics.checkNotNullParameter(animatorList, "animatorList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, mAnimatorItemList, animatorList);
            return;
        }
        this.mAnimatorItemList = mAnimatorItemList;
        this.animatorList = animatorList;
        SurfaceHolder holder = getHolder();
        Intrinsics.checkNotNullExpressionValue(holder, "holder");
        this.mSurfaceHolder = holder;
        this.recorder = new b();
        holder.addCallback(this);
        setZOrderOnTop(true);
        holder.setFormat(-2);
        long j3 = 0;
        int i3 = 0;
        for (ValueAnimator valueAnimator : animatorList) {
            j3 += valueAnimator.getDuration();
            valueAnimator.addListener(new a(i3, this));
            i3++;
        }
        this.totalAnimatorDuration = j3;
    }

    private final void n(final ValueAnimator animator, final long currentPlayTime) {
        Companion.c(INSTANCE, false, new Function0<String>(currentPlayTime, animator) { // from class: com.tencent.mobileqq.login.relogin.anim.LoginAnimSurfaceView$animatorSetCurPlayTime$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ValueAnimator $animator;
            final /* synthetic */ long $currentPlayTime;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$currentPlayTime = currentPlayTime;
                this.$animator = animator;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Long.valueOf(currentPlayTime), animator);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "animatorSetCurPlayTime curPlayTime:" + this.$currentPlayTime + ", isRunning: " + this.$animator.isRunning() + ", duration: " + this.$animator.getDuration();
            }
        }, 1, null);
        if (animator.isRunning()) {
            if (animator.getCurrentPlayTime() >= animator.getDuration()) {
                if (animator.getCurrentPlayTime() == animator.getDuration()) {
                    animator.setCurrentPlayTime(animator.getDuration());
                }
                animator.end();
                return;
            }
            animator.setCurrentPlayTime(currentPlayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            Iterator<SplashLoginSuccessAnimator.AnimatorItem> it = this.mAnimatorItemList.iterator();
            while (it.hasNext()) {
                it.next().b(canvas);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (!this.isAnimFinish) {
            int i3 = 0;
            for (ValueAnimator valueAnimator : this.animatorList) {
                int i16 = i3 + 1;
                QLog.i("LoginAnimSurfaceView", 4, "surfaceDestroyed " + i3 + MsgSummary.STR_COLON + valueAnimator.isRunning() + " ");
                try {
                    if (valueAnimator.isRunning()) {
                        valueAnimator.end();
                    }
                } catch (Exception e16) {
                    QLog.e("LoginAnimSurfaceView", 1, "surfaceDestroyed animator end exception:", e16);
                }
                i3 = i16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(long curPlayTime) {
        long j3 = 0;
        for (ValueAnimator valueAnimator : this.animatorList) {
            n(valueAnimator, curPlayTime - j3);
            j3 += valueAnimator.getDuration();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.animatorList);
        ValueAnimator valueAnimator = (ValueAnimator) firstOrNull;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
        } else {
            o(canvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0 && action != 2) {
            return super.onTouchEvent(event);
        }
        if (this.isAnimFinish) {
            if (event.getAction() == 0) {
                QLog.e("LoginAnimSurfaceView", 1, "onTouchEvent isFinishAnim");
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.animatorList);
            ValueAnimator valueAnimator = (ValueAnimator) lastOrNull;
            if (valueAnimator != null) {
                valueAnimator.end();
            }
        }
        return true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NotNull SurfaceHolder holder, int format, int width, int height) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, holder, Integer.valueOf(format), Integer.valueOf(width), Integer.valueOf(height));
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("LoginAnimSurfaceView", 1, "surfaceChanged: " + width + ", " + height);
        Iterator<SplashLoginSuccessAnimator.AnimatorItem> it = this.mAnimatorItemList.iterator();
        while (it.hasNext()) {
            Drawable c16 = it.next().c().c();
            if (c16 != null) {
                c16.setBounds(0, 0, width, height);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: all -> 0x008c, TryCatch #1 {, blocks: (B:12:0x0020, B:14:0x0024, B:16:0x0037, B:19:0x003c, B:23:0x0049, B:25:0x004d, B:26:0x0053, B:28:0x0077, B:29:0x0081, B:31:0x0085, B:35:0x007d, B:36:0x0045), top: B:11:0x0020, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0085 A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #1 {, blocks: (B:12:0x0020, B:14:0x0024, B:16:0x0037, B:19:0x003c, B:23:0x0049, B:25:0x004d, B:26:0x0053, B:28:0x0077, B:29:0x0081, B:31:0x0085, B:35:0x007d, B:36:0x0045), top: B:11:0x0020, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007d A[Catch: all -> 0x008c, TryCatch #1 {, blocks: (B:12:0x0020, B:14:0x0024, B:16:0x0037, B:19:0x003c, B:23:0x0049, B:25:0x004d, B:26:0x0053, B:28:0x0077, B:29:0x0081, B:31:0x0085, B:35:0x007d, B:36:0x0045), top: B:11:0x0020, outer: #0 }] */
    @Override // android.view.SurfaceHolder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void surfaceCreated(@NotNull SurfaceHolder holder) {
        long j3;
        long currentTimeMillis;
        DrawingThread drawingThread;
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("LoginAnimSurfaceView", 1, "surfaceCreated");
        try {
            synchronized (this) {
                if (this.isAnimFinish) {
                    QLog.e("LoginAnimSurfaceView", 1, "surfaceCreated but isFinishAnim");
                    lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.animatorList);
                    ValueAnimator valueAnimator = (ValueAnimator) lastOrNull;
                    if (valueAnimator != null) {
                        valueAnimator.end();
                    }
                    return;
                }
                DrawingThread drawingThread2 = this.mThread;
                if (drawingThread2 != null) {
                    if (drawingThread2 != null) {
                        drawingThread2.p(false);
                    }
                    DrawingThread drawingThread3 = this.mThread;
                    if (drawingThread3 != null) {
                        j3 = drawingThread3.o();
                        this.mThread = new DrawingThread();
                        QLog.i("LoginAnimSurfaceView", 2, "surfaceCreated curPlayTime: " + j3);
                        if (j3 <= 0) {
                            currentTimeMillis = System.currentTimeMillis() - j3;
                        } else {
                            currentTimeMillis = System.currentTimeMillis();
                        }
                        drawingThread = this.mThread;
                        if (drawingThread != null) {
                            drawingThread.r(currentTimeMillis);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
                j3 = 0;
                this.mThread = new DrawingThread();
                QLog.i("LoginAnimSurfaceView", 2, "surfaceCreated curPlayTime: " + j3);
                if (j3 <= 0) {
                }
                drawingThread = this.mThread;
                if (drawingThread != null) {
                }
            }
        } catch (Exception e16) {
            QLog.e("LoginAnimSurfaceView", 1, "surfaceCreated catch exception ", e16);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NotNull SurfaceHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        QLog.i("LoginAnimSurfaceView", 1, "surfaceDestroyed isAnimFinish: " + this.isAnimFinish + " ");
        if (INSTANCE.g()) {
            try {
                holder.removeCallback(this);
            } catch (Exception e16) {
                QLog.e("LoginAnimSurfaceView", 1, "surfaceDestroyed ", e16);
            }
        }
        DrawingThread drawingThread = this.mThread;
        if (drawingThread != null) {
            drawingThread.p(false);
        }
        if (INSTANCE.f()) {
            p();
            return;
        }
        try {
            DrawingThread drawingThread2 = this.mThread;
            if (drawingThread2 != null) {
                drawingThread2.join();
            }
        } catch (InterruptedException e17) {
            QLog.e("LoginAnimSurfaceView", 1, "surfaceDestroyed catch exception ", e17);
        }
    }
}
