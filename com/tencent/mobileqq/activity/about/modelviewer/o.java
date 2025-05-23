package com.tencent.mobileqq.activity.about.modelviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.filament.utils.Manipulator;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.activity.about.modelviewer.o;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 |2\u00020\u0001:\u0002}~B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0013\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0017R\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00109\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b8\u00105R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020:8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b>\u0010<R&\u0010C\u001a\u0012\u0012\u0004\u0012\u00020:0@j\b\u0012\u0004\u0012\u00020:`A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010ER$\u0010M\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001aR\u0018\u0010W\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010VR\"\u0010\\\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010O\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R*\u0010b\u001a\u00020]2\u0006\u0010^\u001a\u00020]8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u000f\u001a\u0004\b_\u0010`\"\u0004\bN\u0010aR*\u0010c\u001a\u00020]2\u0006\u0010^\u001a\u00020]8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0014\u0010`\"\u0004\b<\u0010aR\u0017\u0010i\u001a\u00020d8\u0006\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u0017\u0010n\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010kR\"\u0010w\u001a\u00020p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010y\u001a\u00020p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010r\u001a\u0004\b;\u0010t\"\u0004\bx\u0010v\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/o;", "Landroid/view/View$OnTouchListener;", "", "T", "O", BdhLogUtil.LogTag.Tag_Req, "W", "E", "t", "N", "", "time", "G", "Ljava/lang/Runnable;", "runnable", UserInfo.SEX_FEMALE, "r", "V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "d", "Landroid/view/View;", "view", "Lcom/google/android/filament/utils/Manipulator;", "e", "Lcom/google/android/filament/utils/Manipulator;", "manipulator", "Landroid/view/GestureDetector;", "f", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "setGestureDetector", "(Landroid/view/GestureDetector;)V", "gestureDetector", "Landroid/animation/ValueAnimator;", tl.h.F, "Landroid/animation/ValueAnimator;", HippyTKDListViewAdapter.X, "()Landroid/animation/ValueAnimator;", "K", "(Landroid/animation/ValueAnimator;)V", "backAnimation", "Landroid/animation/AnimatorSet;", "i", "Landroid/animation/AnimatorSet;", "w", "()Landroid/animation/AnimatorSet;", "J", "(Landroid/animation/AnimatorSet;)V", "animatorSet", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "idleDelay", "", BdhLogUtil.LogTag.Tag_Conn, "I", "animationPointer", "D", "animationsCount", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "animationIndexes", "Landroid/view/VelocityTracker;", "Landroid/view/VelocityTracker;", "velocityTracker", "Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "y", "()Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "L", "(Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;)V", "callback", "H", "Z", "firstEnter", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUIHandler", "springAnimationView", "Landroidx/dynamicanimation/animation/SpringAnimation;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "reboundAnimation", "getTouched", "()Z", "M", "(Z)V", "touched", "", "value", "u", "()F", "(F)V", "angleX", "angleY", "Ljava/security/SecureRandom;", "P", "Ljava/security/SecureRandom;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/security/SecureRandom;", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/Runnable;", "idleAnimation", "firstEnterAnimation", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", ExifInterface.LATITUDE_SOUTH, "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "B", "()Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "setXUpdater", "(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V", "xUpdater", "setYUpdater", "yUpdater", "<init>", "(Landroid/view/View;Lcom/google/android/filament/utils/Manipulator;)V", "U", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class o implements View.OnTouchListener {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int animationPointer;

    /* renamed from: D, reason: from kotlin metadata */
    private final int animationsCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Integer> animationIndexes;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private VelocityTracker velocityTracker;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private b callback;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean firstEnter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Handler mUIHandler;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View springAnimationView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private SpringAnimation reboundAnimation;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean touched;

    /* renamed from: M, reason: from kotlin metadata */
    private float angleX;

    /* renamed from: N, reason: from kotlin metadata */
    private float angleY;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final SecureRandom random;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Runnable idleAnimation;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Runnable firstEnterAnimation;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private ValueAnimator.AnimatorUpdateListener xUpdater;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private ValueAnimator.AnimatorUpdateListener yUpdater;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Manipulator manipulator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetector gestureDetector;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator backAnimation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimatorSet animatorSet;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long idleDelay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$a", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/MotionEvent;", "motionEvent", "", "onDown", "", "onShowPress", "onSingleTapUp", "motionEvent1", "", "v", "v1", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "onFling", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class a implements GestureDetector.OnGestureListener {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$a$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.activity.about.modelviewer.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C7119a extends AnimatorListenerAdapter {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ o f177768d;

            C7119a(o oVar) {
                this.f177768d = oVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                this.f177768d.H(0.0f);
                this.f177768d.J(null);
                b y16 = this.f177768d.y();
                if (y16 != null) {
                    y16.a();
                }
                o oVar = this.f177768d;
                oVar.G(oVar.idleDelay);
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(o this$0, float f16, float f17) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.x() != null) {
                ValueAnimator x16 = this$0.x();
                Intrinsics.checkNotNull(x16);
                x16.removeAllListeners();
                ValueAnimator x17 = this$0.x();
                Intrinsics.checkNotNull(x17);
                x17.cancel();
                this$0.K(null);
            }
            if (this$0.w() != null) {
                AnimatorSet w3 = this$0.w();
                if (w3 != null) {
                    w3.removeAllListeners();
                }
                AnimatorSet w16 = this$0.w();
                if (w16 != null) {
                    w16.cancel();
                }
                this$0.J(null);
            }
            if (Math.abs(this$0.u()) > 10.0f) {
                this$0.R();
                return;
            }
            this$0.r(this$0.z());
            this$0.J(new AnimatorSet());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this$0.u(), f16);
            ofFloat.addUpdateListener(this$0.B());
            long j3 = 220;
            ofFloat.setDuration(j3);
            com.tencent.mobileqq.activity.about.modelviewer.a aVar = com.tencent.mobileqq.activity.about.modelviewer.a.f177712h;
            ofFloat.setInterpolator(aVar);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f16, 0.0f);
            ofFloat2.addUpdateListener(this$0.B());
            ofFloat2.setStartDelay(j3);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new OvershootInterpolator());
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(this$0.v(), f17);
            ofFloat3.addUpdateListener(this$0.C());
            ofFloat3.setDuration(j3);
            ofFloat3.setInterpolator(aVar);
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(f17, 0.0f);
            ofFloat4.addUpdateListener(this$0.C());
            ofFloat4.setStartDelay(j3);
            ofFloat4.setDuration(600L);
            ofFloat4.setInterpolator(new OvershootInterpolator());
            AnimatorSet w17 = this$0.w();
            if (w17 != null) {
                w17.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
            }
            b y16 = this$0.y();
            if (y16 != null) {
                y16.c();
            }
            AnimatorSet w18 = this$0.w();
            if (w18 != null) {
                w18.addListener(new C7119a(this$0));
            }
            AnimatorSet w19 = this$0.w();
            if (w19 != null) {
                w19.start();
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            VelocityTracker velocityTracker = o.this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
            o.this.q();
            o.this.M(true);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent1, float v3, float v16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, this, motionEvent, motionEvent1, Float.valueOf(v3), Float.valueOf(v16))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            Intrinsics.checkNotNullParameter(motionEvent1, "motionEvent1");
            Log.d("TelegramGesture", "onFling");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            } else {
                Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent1, float v3, float v16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, this, motionEvent, motionEvent1, Float.valueOf(v3), Float.valueOf(v16))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            Intrinsics.checkNotNullParameter(motionEvent1, "motionEvent1");
            o oVar = o.this;
            oVar.H(oVar.u() + (v3 * 0.5f));
            o oVar2 = o.this;
            oVar2.I(oVar2.v() + (v16 * 0.1f));
            if (o.this.velocityTracker == null) {
                o.this.velocityTracker = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker = o.this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent1);
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@NotNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent);
            } else {
                Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NotNull MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ReportController.y((QQAppInterface) peekAppRuntime, "0X800C5B7");
            float measuredWidth = o.this.view.getMeasuredWidth() / 2.0f;
            final float nextInt = ((o.this.A().nextInt(30) + 40) * (measuredWidth - motionEvent.getX())) / measuredWidth;
            final float nextInt2 = ((o.this.A().nextInt(30) + 40) * (measuredWidth - motionEvent.getY())) / measuredWidth;
            final o oVar = o.this;
            oVar.F(new Runnable() { // from class: com.tencent.mobileqq.activity.about.modelviewer.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.a.b(o.this, nextInt, nextInt2);
                }
            }, 16L);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/o$b;", "", "", "c", "a", "Lcom/tencent/mobileqq/activity/about/modelviewer/Direction;", "direction", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public interface b {
        void a();

        void b(@NotNull Direction direction);

        void c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/about/modelviewer/o$c;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.about.modelviewer.o$c, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            o.this.H(0.0f);
            o.this.J(null);
            o oVar = o.this;
            oVar.G(oVar.idleDelay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            o.this.H(0.0f);
            o.this.J(null);
            o oVar = o.this;
            oVar.G(oVar.idleDelay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class f extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            o.this.H(0.0f);
            o.this.J(null);
            o oVar = o.this;
            oVar.G(oVar.idleDelay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class g extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            o.this.H(0.0f);
            o.this.J(null);
            b y16 = o.this.y();
            if (y16 != null) {
                y16.a();
            }
            o oVar = o.this;
            oVar.G(oVar.idleDelay);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/about/modelviewer/o$h", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class h extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            o.this.H(0.0f);
            o.this.J(null);
            o oVar = o.this;
            oVar.G(oVar.idleDelay);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26650);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(@NotNull View view, @NotNull Manipulator manipulator) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(manipulator, "manipulator");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view, (Object) manipulator);
            return;
        }
        this.view = view;
        this.manipulator = manipulator;
        this.idleDelay = 2000L;
        this.animationsCount = 3;
        this.animationIndexes = new ArrayList<>();
        this.firstEnter = true;
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.random = new SecureRandom();
        this.idleAnimation = new Runnable() { // from class: com.tencent.mobileqq.activity.about.modelviewer.h
            @Override // java.lang.Runnable
            public final void run() {
                o.D(o.this);
            }
        };
        this.firstEnterAnimation = new Runnable() { // from class: com.tencent.mobileqq.activity.about.modelviewer.i
            @Override // java.lang.Runnable
            public final void run() {
                o.s(o.this);
            }
        };
        manipulator.h(0, 0, false);
        view.setOnTouchListener(this);
        GestureDetector gestureDetector = new GestureDetector(view.getContext(), new a());
        this.gestureDetector = gestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.setIsLongpressEnabled(true);
        for (int i3 = 0; i3 < 3; i3++) {
            this.animationIndexes.add(Integer.valueOf(i3));
        }
        Collections.shuffle(this.animationIndexes);
        this.xUpdater = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.X(o.this, valueAnimator);
            }
        };
        this.yUpdater = new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.Y(o.this, valueAnimator);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r0.isRunning() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0.isRunning() == false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
    
        r2.G(r2.idleDelay);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void D(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimatorSet animatorSet = this$0.animatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
        }
        ValueAnimator valueAnimator = this$0.backAnimation;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
        }
        this$0.W();
    }

    private final void E() {
        int i3;
        int abs = Math.abs(this.random.nextInt() % 3);
        this.animatorSet = new AnimatorSet();
        if (abs == 2) {
            i3 = -485;
        } else {
            i3 = 485;
        }
        float f16 = i3;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.angleY, f16);
        ofFloat.addUpdateListener(this.xUpdater);
        ofFloat.setDuration(3000L);
        ofFloat.setInterpolator(com.tencent.mobileqq.activity.about.modelviewer.a.f177712h);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f16, 0.0f);
        ofFloat2.addUpdateListener(this.xUpdater);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(3000L);
        ofFloat2.setInterpolator(new OvershootInterpolator());
        AnimatorSet animatorSet = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.playTogether(ofFloat, ofFloat2);
        AnimatorSet animatorSet2 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.addListener(new e());
        AnimatorSet animatorSet3 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(Runnable runnable, long time) {
        if (time == 0) {
            this.mUIHandler.post(runnable);
        } else {
            this.mUIHandler.postDelayed(runnable, time);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(long time) {
        r(this.idleAnimation);
        F(this.idleAnimation, time);
    }

    private final void N() {
        this.animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.angleX, 360.0f);
        ofFloat.addUpdateListener(this.xUpdater);
        ofFloat.setDuration(8000L);
        ofFloat.setInterpolator(com.tencent.mobileqq.activity.about.modelviewer.a.f177710f);
        AnimatorSet animatorSet = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.playTogether(ofFloat);
        AnimatorSet animatorSet2 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.addListener(new f());
        AnimatorSet animatorSet3 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.start();
    }

    private final void O() {
        boolean z16;
        float f16;
        b bVar;
        float f17;
        q();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        float f18 = this.angleX;
        floatRef.element = f18;
        final float f19 = this.angleY;
        Direction direction = Direction.Left;
        if (Math.abs(f18) > 30.0f) {
            float f26 = floatRef.element;
            if (f26 > 360.0f) {
                floatRef.element = f26 - 360;
            } else if (f26 < -360.0f) {
                floatRef.element = f26 + 360;
            }
            float f27 = this.angleX;
            if (f27 > 0.0f) {
                f17 = f27 - 360.0f;
            } else {
                f17 = 360.0f + f27;
            }
            floatRef.element = f17;
            if (f27 <= 0.0f) {
                direction = Direction.Right;
            }
            z16 = true;
        } else {
            z16 = false;
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            f16 = velocityTracker2.getXVelocity();
        } else {
            f16 = 0.0f;
        }
        if (this.springAnimationView == null) {
            this.springAnimationView = new View(this.view.getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            View view = this.springAnimationView;
            Intrinsics.checkNotNull(view);
            view.setLayoutParams(layoutParams);
            ViewParent parent = this.view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).addView(this.springAnimationView);
        }
        if (this.reboundAnimation == null) {
            this.reboundAnimation = new SpringAnimation(this.springAnimationView, DynamicAnimation.TRANSLATION_X, 0.0f);
        }
        SpringAnimation springAnimation = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation);
        springAnimation.getSpring().setDampingRatio(0.65f);
        SpringAnimation springAnimation2 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation2);
        springAnimation2.getSpring().setStiffness(20.0f);
        SpringAnimation springAnimation3 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation3);
        springAnimation3.setStartValue(200.0f);
        SpringAnimation springAnimation4 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation4);
        springAnimation4.setStartVelocity(-Math.abs(f16 / 3));
        SpringAnimation springAnimation5 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation5);
        springAnimation5.addUpdateListener(new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.f
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f28, float f29) {
                o.P(o.this, floatRef, f19, dynamicAnimation, f28, f29);
            }
        });
        SpringAnimation springAnimation6 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation6);
        springAnimation6.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.g
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z17, float f28, float f29) {
                o.Q(o.this, dynamicAnimation, z17, f28, f29);
            }
        });
        SpringAnimation springAnimation7 = this.reboundAnimation;
        Intrinsics.checkNotNull(springAnimation7);
        springAnimation7.start();
        if (z16 && (bVar = this.callback) != null) {
            bVar.b(direction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(o this$0, Ref.FloatRef fromX, float f16, DynamicAnimation dynamicAnimation, float f17, float f18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromX, "$fromX");
        Log.d("TestAnimation", "update data: " + f17);
        float f19 = f17 / 200.0f;
        this$0.H(fromX.element * f19);
        this$0.I(f19 * f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(o this$0, DynamicAnimation dynamicAnimation, boolean z16, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.animatorSet = null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ReportController.y((QQAppInterface) peekAppRuntime, "0X800C5B8");
        if (!z16) {
            this$0.G(this$0.idleDelay);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        q();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.angleX;
        final float f16 = this.angleY;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.backAnimation = ofFloat;
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.S(o.this, floatRef, f16, valueAnimator);
            }
        });
        ValueAnimator valueAnimator = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.setDuration(1000L);
        ValueAnimator valueAnimator2 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.setInterpolator(new OvershootInterpolator());
        ValueAnimator valueAnimator3 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.start();
        ValueAnimator valueAnimator4 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.addListener(new g());
        b bVar = this.callback;
        if (bVar != null) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(o this$0, Ref.FloatRef fromX, float f16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromX, "$fromX");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.H(fromX.element * floatValue);
        this$0.I(floatValue * f16);
    }

    private final void T() {
        q();
        H(-340.0f);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.angleX;
        final float f16 = this.angleY;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.backAnimation = ofFloat;
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.activity.about.modelviewer.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                o.U(o.this, floatRef, f16, valueAnimator);
            }
        });
        ValueAnimator valueAnimator = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.setDuration(1000L);
        ValueAnimator valueAnimator2 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.setInterpolator(new OvershootInterpolator());
        ValueAnimator valueAnimator3 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.start();
        ValueAnimator valueAnimator4 = this.backAnimation;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.addListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(o this$0, Ref.FloatRef fromX, float f16, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fromX, "$fromX");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.H(fromX.element * floatValue);
        this$0.I(floatValue * f16);
    }

    private final void W() {
        Integer num = this.animationIndexes.get(this.animationPointer);
        Intrinsics.checkNotNullExpressionValue(num, "animationIndexes[animationPointer]");
        int intValue = num.intValue();
        int i3 = this.animationPointer + 1;
        this.animationPointer = i3;
        if (i3 >= this.animationIndexes.size()) {
            Collections.shuffle(this.animationIndexes);
            this.animationPointer = 0;
        }
        if (intValue != 0) {
            if (intValue != 1) {
                t();
                return;
            } else {
                N();
                return;
            }
        }
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(o this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.H(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(o this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.I(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Runnable runnable) {
        this.mUIHandler.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T();
    }

    private final void t() {
        this.animatorSet = new AnimatorSet();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.angleX, 180.0f);
        ofFloat.addUpdateListener(this.xUpdater);
        ofFloat.setDuration(600L);
        com.tencent.mobileqq.activity.about.modelviewer.a aVar = com.tencent.mobileqq.activity.about.modelviewer.a.f177710f;
        ofFloat.setInterpolator(aVar);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(180.0f, 360.0f);
        ofFloat2.addUpdateListener(this.xUpdater);
        ofFloat2.setDuration(600L);
        ofFloat2.setStartDelay(2000L);
        ofFloat2.setInterpolator(aVar);
        AnimatorSet animatorSet = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.playTogether(ofFloat, ofFloat2);
        AnimatorSet animatorSet2 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.addListener(new d());
        AnimatorSet animatorSet3 = this.animatorSet;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.start();
    }

    @NotNull
    public final SecureRandom A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (SecureRandom) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.random;
    }

    @NotNull
    public final ValueAnimator.AnimatorUpdateListener B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ValueAnimator.AnimatorUpdateListener) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.xUpdater;
    }

    @NotNull
    public final ValueAnimator.AnimatorUpdateListener C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ValueAnimator.AnimatorUpdateListener) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.yUpdater;
    }

    public final void H(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            return;
        }
        this.angleX = f16;
        double d16 = 200;
        this.manipulator.j((int) (((-f16) / 360.0f) * 3.141592653589793d * d16), (int) ((this.angleY / 360.0f) * 3.141592653589793d * d16));
    }

    public final void I(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            return;
        }
        this.angleY = f16;
        double d16 = 200;
        this.manipulator.j((int) (((-this.angleX) / 360.0f) * 3.141592653589793d * d16), (int) ((f16 / 360.0f) * 3.141592653589793d * d16));
    }

    public final void J(@Nullable AnimatorSet animatorSet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) animatorSet);
        } else {
            this.animatorSet = animatorSet;
        }
    }

    public final void K(@Nullable ValueAnimator valueAnimator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) valueAnimator);
        } else {
            this.backAnimation = valueAnimator;
        }
    }

    public final void L(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
        } else {
            this.callback = bVar;
        }
    }

    public final void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.touched = z16;
        }
    }

    public final void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else if (this.firstEnter) {
            F(this.firstEnterAnimation, 1000L);
            this.firstEnter = false;
        } else {
            H(0.0f);
            G(this.idleDelay);
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) v3, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 0) {
            this.view.getParent().requestDisallowInterceptTouchEvent(true);
        } else if (event.getAction() == 3 || event.getAction() == 1) {
            this.touched = false;
            O();
            this.view.getParent().requestDisallowInterceptTouchEvent(false);
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.velocityTracker = null;
        }
        GestureDetector gestureDetector = this.gestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.onTouchEvent(event);
        return true;
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.mUIHandler.removeCallbacksAndMessages(null);
        SpringAnimation springAnimation = this.reboundAnimation;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = this.reboundAnimation;
        if (springAnimation2 != null) {
            springAnimation2.removeEndListener(null);
        }
        SpringAnimation springAnimation3 = this.reboundAnimation;
        if (springAnimation3 != null) {
            springAnimation3.removeUpdateListener(null);
        }
        this.reboundAnimation = null;
        View view = this.springAnimationView;
        if (view != null) {
            ViewParent parent = view.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(view);
        }
        this.springAnimationView = null;
        ValueAnimator valueAnimator = this.backAnimation;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            valueAnimator.removeAllListeners();
            ValueAnimator valueAnimator2 = this.backAnimation;
            Intrinsics.checkNotNull(valueAnimator2);
            valueAnimator2.cancel();
            this.backAnimation = null;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.removeAllListeners();
            AnimatorSet animatorSet2 = this.animatorSet;
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.cancel();
            this.animatorSet = null;
        }
    }

    public final float u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
        }
        return this.angleX;
    }

    public final float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
        }
        return this.angleY;
    }

    @Nullable
    public final AnimatorSet w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AnimatorSet) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.animatorSet;
    }

    @Nullable
    public final ValueAnimator x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ValueAnimator) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.backAnimation;
    }

    @Nullable
    public final b y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.callback;
    }

    @NotNull
    public final Runnable z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Runnable) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.idleAnimation;
    }
}
