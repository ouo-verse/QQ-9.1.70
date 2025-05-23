package com.tencent.mobileqq.aio.animation.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.animation.AIOAnimationContainer;
import com.tencent.mobileqq.aio.animation.animator.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.util.AnimateUtils;
import com.tencent.util.QQViewCompatUtil;
import com.tencent.util.VersionUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002./B\u001f\u0012\u0006\u0010&\u001a\u00020\n\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0016J'\u0010\u0016\u001a\u00020\u00042\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u0013\"\u0004\u0018\u00010\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016R*\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010$\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/a;", "Lcom/tencent/mobileqq/aio/animation/f;", "", "msgId", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "view", "", "v", "", EventListener.KEY_DELTA, "i", "changed", "left", "top", "right", "bottom", "f", "", "", "args", DomainData.DOMAIN_NAME, "([Ljava/lang/Object;)Z", "o", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "t", "()[Landroid/graphics/drawable/Drawable;", "u", "([Landroid/graphics/drawable/Drawable;)V", "drawables", "g", "J", "targetId", tl.h.F, "Landroid/view/View;", "view1", "type", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/aio/animation/data/a;", "listview", "<init>", "(ILcom/tencent/mobileqq/aio/animation/AIOAnimationContainer;Lcom/tencent/mobileqq/aio/animation/data/a;)V", "j", "a", "b", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a extends com.tencent.mobileqq.aio.animation.f {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: k, reason: collision with root package name */
    private static final int f187818k;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Drawable[] drawables;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long targetId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View view;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View view1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/a$a;", "Landroid/view/View;", "", "changed", "", "left", "top", "right", "bottom", "", "onLayout", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/aio/animation/animator/a;Landroid/content/Context;)V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private final class C7233a extends View {
        static IPatchRedirector $redirector_;

        public C7233a(@Nullable Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) context);
            }
        }

        @Override // android.view.View
        public void draw(@NotNull Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            super.draw(canvas);
            for (Drawable drawable : a.this.t()) {
                Intrinsics.checkNotNull(drawable);
                drawable.draw(canvas);
            }
        }

        @Override // android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom));
                return;
            }
            int i3 = bottom - top;
            int i16 = 0;
            for (Drawable drawable : a.this.t()) {
                Intrinsics.checkNotNull(drawable);
                drawable.setBounds(i16, i3 - drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth() + i16, i3);
                i16 += drawable.getIntrinsicWidth();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/animator/a$b;", "", "", "KEYFRAME_DURATION", UserInfo.SEX_FEMALE, "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.animator.a$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/a$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                a.this.h();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
                a.this.h();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/a$d", "Lcom/tencent/util/AnimateUtils$AnimationAdapter;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationEnd", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(a this_run) {
            Intrinsics.checkNotNullParameter(this_run, "$this_run");
            this_run.h();
            this_run.b().invalidate();
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (a.this.view != null) {
                View view = a.this.view;
                Intrinsics.checkNotNull(view);
                if (view.isShown()) {
                    AIOAnimationContainer b16 = a.this.b();
                    final a aVar = a.this;
                    b16.post(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.animator.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.d.b(a.this);
                        }
                    });
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/a$e", "Landroid/view/animation/Animation;", "", "width", "height", "parentWidth", "parentHeight", "", "initialize", "", "interpolatedTime", "Landroid/view/animation/Transformation;", "t", "applyTransformation", "d", UserInfo.SEX_FEMALE, "mPivotX", "e", "mPivotY", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends Animation {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float mPivotX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float mPivotY;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, @NotNull Transformation t16) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(interpolatedTime), t16);
                return;
            }
            Intrinsics.checkNotNullParameter(t16, "t");
            float f17 = 1.0f;
            if (interpolatedTime < 0.45833334f) {
                f16 = interpolatedTime / 0.45833334f;
            } else if (interpolatedTime < 0.8333334f) {
                f16 = 1.0f;
            } else {
                f16 = 1 - ((interpolatedTime - 0.8333334f) / 0.16666667f);
            }
            if (interpolatedTime < 0.25f) {
                f17 = 1 + ((interpolatedTime / 0.25f) * 0.5f);
            } else if (interpolatedTime < 0.45833334f) {
                f17 = 1.5f - (((interpolatedTime - 0.25f) * 0.5f) / 0.20833334f);
            }
            t16.setAlpha(f16);
            t16.getMatrix().setScale(f17, f17, this.mPivotX, this.mPivotY);
        }

        @Override // android.view.animation.Animation
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(parentWidth), Integer.valueOf(parentHeight));
                return;
            }
            super.initialize(width, height, parentWidth, parentHeight);
            this.mPivotX = width * 0.5f;
            this.mPivotY = height * 0.5f;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0014R\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/aio/animation/animator/a$f", "Landroid/view/animation/Animation;", "", "width", "height", "parentWidth", "parentHeight", "", "initialize", "", "interpolatedTime", "Landroid/view/animation/Transformation;", "t", "applyTransformation", "d", UserInfo.SEX_FEMALE, "mPivotX", "e", "mPivotY", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class f extends Animation {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float mPivotX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float mPivotY;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float interpolatedTime, @NotNull Transformation t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(interpolatedTime), t16);
                return;
            }
            Intrinsics.checkNotNullParameter(t16, "t");
            float f16 = 1.5f;
            float f17 = 0.0f;
            if (interpolatedTime >= 0.20833334f) {
                if (interpolatedTime < 0.5416667f) {
                    float f18 = ((interpolatedTime - 0.20833334f) / 0.33333334f) * 0.5f;
                    f17 = 0.5f - f18;
                    f16 = 1.5f + f18;
                } else {
                    f16 = 2.0f;
                }
            }
            t16.setAlpha(f17);
            t16.getMatrix().setScale(f16, f16, this.mPivotX, this.mPivotY);
        }

        @Override // android.view.animation.Animation
        public void initialize(int width, int height, int parentWidth, int parentHeight) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(parentWidth), Integer.valueOf(parentHeight));
                return;
            }
            super.initialize(width, height, parentWidth, parentHeight);
            this.mPivotX = width * 0.5f;
            this.mPivotY = height * 0.5f;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29198);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            f187818k = l.b(60);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(int i3, @NotNull AIOAnimationContainer container, @NotNull com.tencent.mobileqq.aio.animation.data.a listview) {
        super(i3, container, listview);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listview, "listview");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), container, listview);
        }
    }

    private final boolean s(long msgId) {
        View view = this.view;
        Intrinsics.checkNotNull(view);
        int left = view.getLeft();
        View view2 = this.view;
        Intrinsics.checkNotNull(view2);
        int width = left + (view2.getWidth() / 2);
        View view3 = this.view;
        Intrinsics.checkNotNull(view3);
        int top = view3.getTop();
        View view4 = this.view;
        Intrinsics.checkNotNull(view4);
        int height = top + (view4.getHeight() / 2);
        int width2 = (b().getWidth() / 2) - width;
        int height2 = (b().getHeight() / 2) - height;
        if (width2 != 0 || height2 != 0) {
            View view5 = this.view;
            Intrinsics.checkNotNull(view5);
            view5.offsetLeftAndRight(width2);
            View view6 = this.view;
            Intrinsics.checkNotNull(view6);
            view6.offsetTopAndBottom(height2);
            View view7 = this.view1;
            Intrinsics.checkNotNull(view7);
            view7.offsetLeftAndRight(width2);
            View view8 = this.view1;
            Intrinsics.checkNotNull(view8);
            view8.offsetTopAndBottom(height2);
            b().invalidate();
            return true;
        }
        return true;
    }

    private final void v(View view) {
        Animator animator;
        if (view != null) {
            b().removeViewInLayout(view);
            Object tag = view.getTag();
            if (tag instanceof Animator) {
                animator = (Animator) tag;
            } else {
                animator = null;
            }
            if (animator != null) {
                animator.cancel();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean f(boolean changed, int left, int top, int right, int bottom) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(changed), Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom))).booleanValue();
        }
        return s(this.targetId);
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void i(int delta) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, delta);
        } else {
            QQViewCompatUtil.refelctViewGroupOffsetChildrenTopAndBottom(b(), -delta);
        }
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public boolean n(@NotNull Object... args) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Object obj2 = args[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
        this.targetId = ((Long) obj2).longValue();
        if (intValue > 0) {
            int length = Integer.toString(intValue).length();
            if (intValue > 99) {
                u(new Drawable[4]);
                t()[3] = ContextCompat.getDrawable(c().getContext(), R.drawable.c09);
                Drawable drawable = t()[3];
                Intrinsics.checkNotNull(drawable);
                int intrinsicWidth = drawable.getIntrinsicWidth() + 0;
                t()[2] = ContextCompat.getDrawable(c().getContext(), R.drawable.c07);
                Drawable drawable2 = t()[2];
                Intrinsics.checkNotNull(drawable2);
                int intrinsicWidth2 = intrinsicWidth + drawable2.getIntrinsicWidth();
                t()[1] = ContextCompat.getDrawable(c().getContext(), R.drawable.c07);
                Drawable drawable3 = t()[1];
                Intrinsics.checkNotNull(drawable3);
                i3 = intrinsicWidth2 + drawable3.getIntrinsicWidth();
            } else {
                u(new Drawable[length + 1]);
                int i16 = 0;
                int i17 = 0;
                do {
                    int i18 = length - i16;
                    t()[i18] = ContextCompat.getDrawable(c().getContext(), (intValue % 10) + R.drawable.bzy);
                    Drawable drawable4 = t()[i18];
                    Intrinsics.checkNotNull(drawable4);
                    i17 += drawable4.getIntrinsicWidth();
                    i16++;
                    intValue /= 10;
                } while (intValue > 0);
                i3 = i17;
            }
            t()[0] = ContextCompat.getDrawable(c().getContext(), R.drawable.c0_);
            Drawable drawable5 = t()[0];
            Intrinsics.checkNotNull(drawable5);
            int intrinsicWidth3 = i3 + drawable5.getIntrinsicWidth();
            this.view = new C7233a(c().getContext());
            this.view1 = new C7233a(c().getContext());
            AIOAnimationContainer b16 = b();
            View view = this.view;
            Intrinsics.checkNotNull(view);
            AIOAnimationContainer.Companion companion = AIOAnimationContainer.INSTANCE;
            b16.addViewInLayout(view, -1, companion.a(), false);
            AIOAnimationContainer b17 = b();
            View view2 = this.view1;
            Intrinsics.checkNotNull(view2);
            b17.addViewInLayout(view2, -1, companion.a(), false);
            View view3 = this.view;
            Intrinsics.checkNotNull(view3);
            int i19 = f187818k;
            view3.layout(0, 0, intrinsicWidth3, i19);
            View view4 = this.view1;
            Intrinsics.checkNotNull(view4);
            view4.layout(0, 0, intrinsicWidth3, i19);
            if (s(this.targetId)) {
                if (VersionUtils.isHoneycomb()) {
                    View view5 = this.view;
                    if (view5 != null) {
                        view5.setLayerType(2, null);
                        view5.setPivotX(intrinsicWidth3 / 2);
                        view5.setPivotY(i19 / 2);
                        Keyframe[] keyframeArr = {Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.45833334f, 1.0f), Keyframe.ofFloat(0.8333334f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f)};
                        Keyframe[] keyframeArr2 = {Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.25f, 1.5f), Keyframe.ofFloat(0.45833334f, 1.0f), Keyframe.ofFloat(1.0f, 1.0f)};
                        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(com.tencent.luggage.wxa.c8.c.f123400v, (Keyframe[]) Arrays.copyOf(keyframeArr, 4));
                        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_X, (Keyframe[]) Arrays.copyOf(keyframeArr2, 4));
                        PropertyValuesHolder ofKeyframe3 = PropertyValuesHolder.ofKeyframe(BasicAnimation.KeyPath.SCALE_Y, (Keyframe[]) Arrays.copyOf(keyframeArr2, 4));
                        ObjectAnimator duration = ObjectAnimator.ofPropertyValuesHolder(view5, ofKeyframe).setDuration(1000L);
                        Intrinsics.checkNotNullExpressionValue(duration, "ofPropertyValuesHolder(i\u2026holder).setDuration(1000)");
                        ObjectAnimator duration2 = ObjectAnimator.ofPropertyValuesHolder(view5, ofKeyframe2).setDuration(1000L);
                        Intrinsics.checkNotNullExpressionValue(duration2, "ofPropertyValuesHolder(i\u2026older1).setDuration(1000)");
                        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(view5, ofKeyframe3).setDuration(1000L);
                        Intrinsics.checkNotNullExpressionValue(duration3, "ofPropertyValuesHolder(i\u2026older2).setDuration(1000)");
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.addListener(new c());
                        animatorSet.play(duration).with(duration2).with(duration3);
                        animatorSet.start();
                        view5.setTag(animatorSet);
                    }
                    View view6 = this.view1;
                    if (view6 != null) {
                        view6.setLayerType(2, null);
                        view6.setPivotX(intrinsicWidth3 / 2);
                        view6.setPivotY(i19 / 2);
                        view6.setAlpha(0.0f);
                        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view6, com.tencent.luggage.wxa.c8.c.f123400v, 0.5f, 0.0f).setDuration(333L);
                        Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(it, \"alpha\", 0.5f, 0f).setDuration(333)");
                        ObjectAnimator duration5 = ObjectAnimator.ofFloat(view6, BasicAnimation.KeyPath.SCALE_X, 1.5f, 2.0f).setDuration(333L);
                        Intrinsics.checkNotNullExpressionValue(duration5, "ofFloat(it, \"scaleX\", 1.5f, 2f).setDuration(333)");
                        ObjectAnimator duration6 = ObjectAnimator.ofFloat(view6, BasicAnimation.KeyPath.SCALE_Y, 1.5f, 2.0f).setDuration(333L);
                        Intrinsics.checkNotNullExpressionValue(duration6, "ofFloat(it, \"scaleY\", 1.5f, 2f).setDuration(333)");
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.play(duration4).with(duration5).with(duration6);
                        animatorSet2.setStartDelay(208L);
                        animatorSet2.start();
                        view6.setTag(animatorSet2);
                    }
                } else {
                    e eVar = new e();
                    eVar.setDuration(1000L);
                    eVar.setFillAfter(true);
                    View view7 = this.view;
                    Intrinsics.checkNotNull(view7);
                    view7.setAnimation(eVar);
                    eVar.setAnimationListener(new d());
                    f fVar = new f();
                    fVar.setDuration(1000L);
                    fVar.setFillAfter(true);
                    View view8 = this.view1;
                    Intrinsics.checkNotNull(view8);
                    view8.setAnimation(fVar);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.animation.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        v(this.view);
        v(this.view1);
        this.view = null;
        this.view1 = null;
    }

    @NotNull
    public final Drawable[] t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Drawable[] drawableArr = this.drawables;
        if (drawableArr != null) {
            return drawableArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("drawables");
        return null;
    }

    public final void u(@NotNull Drawable[] drawableArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawableArr);
        } else {
            Intrinsics.checkNotNullParameter(drawableArr, "<set-?>");
            this.drawables = drawableArr;
        }
    }
}
