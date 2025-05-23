package com.tencent.mobileqq.login.relogin.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.login.relogin.anim.LoginAnimSurfaceView;
import com.tencent.mobileqq.login.relogin.fragment.SplashLoginSuccessAnimator;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.ax;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u0000 #2\u00020\u0001:\u0003$%\u0018B\u0007\u00a2\u0006\u0004\b!\u0010\"J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J,\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator;", "Lcom/tencent/mobileqq/login/relogin/fragment/a;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "maskColorResId", "", "p", "Le72/b;", "callback", "", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "captureViewList", "l", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "", "fadeInDuration", "d", "b", "I", "Landroid/content/res/ColorStateList;", "Landroid/content/res/ColorStateList;", "bgColorStateList", "", "Ljava/util/List;", "e", "avatarMoveTarget", "<init>", "()V", "f", "AnimatorItem", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class SplashLoginSuccessAnimator extends com.tencent.mobileqq.login.relogin.fragment.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f242471g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f242472h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Lazy<Long> f242473i;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @ColorRes
    private int maskColorResId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorStateList bgColorStateList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> captureViewList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int avatarMoveTarget;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u0019\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "b", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "c", "()Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "captureView", "", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "", "Z", "getNeedDraw$qqlogin_impl_release", "()Z", "f", "(Z)V", "needDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "e", "()Landroid/graphics/Paint;", "paint", "Landroid/graphics/Matrix;", "Landroid/graphics/Matrix;", "()Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "scaleBitmap", "<init>", "(Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;Ljava/lang/String;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static class AnimatorItem {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a captureView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String tag;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean needDraw;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paint paint;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Matrix matrix;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap scaleBitmap;

        public AnimatorItem(@NotNull a captureView, @Nullable String str) {
            Intrinsics.checkNotNullParameter(captureView, "captureView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) captureView, (Object) str);
                return;
            }
            this.captureView = captureView;
            this.tag = str;
            this.needDraw = true;
            this.paint = new Paint();
            Matrix matrix = new Matrix();
            this.matrix = matrix;
            matrix.setTranslate(captureView.e(), captureView.g());
            float a16 = captureView.a();
            if ((0.0f <= a16 && a16 <= 1.0f) && captureView.c() != null) {
                captureView.c().setAlpha((int) (255 * captureView.a()));
            }
        }

        private final void a() {
            if (this.scaleBitmap == null && this.captureView.f() == ImageView.ScaleType.FIT_XY && this.captureView.b() != null) {
                if (this.captureView.h() != this.captureView.b().getWidth() || this.captureView.d() != this.captureView.b().getHeight()) {
                    this.scaleBitmap = Bitmap.createScaledBitmap(this.captureView.b(), this.captureView.h(), this.captureView.d(), true);
                }
            }
        }

        public void b(@NotNull Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (!this.needDraw) {
                return;
            }
            final long nanoTime = System.nanoTime();
            a();
            Bitmap bitmap = this.scaleBitmap;
            if (bitmap != null) {
                Intrinsics.checkNotNull(bitmap);
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.paint);
            } else if (this.captureView.b() != null) {
                canvas.drawBitmap(this.captureView.b(), this.matrix, this.paint);
            } else if (this.captureView.c() != null) {
                this.captureView.c().draw(canvas);
            }
            SplashLoginSuccessAnimator.INSTANCE.a("SplashLoginSuccessAnimator." + this.tag, new Function0<String>(nanoTime) { // from class: com.tencent.mobileqq.login.relogin.fragment.SplashLoginSuccessAnimator$AnimatorItem$draw$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $start;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$start = nanoTime;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, nanoTime);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    long nanoTime2 = System.nanoTime() - this.$start;
                    long j3 = 1000;
                    return "draw cost: " + nanoTime2 + ", " + ((nanoTime2 / j3) / j3);
                }
            });
        }

        @NotNull
        public final a c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.captureView;
        }

        @NotNull
        public final Matrix d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Matrix) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.matrix;
        }

        @NotNull
        public final Paint e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Paint) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.paint;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.needDraw = z16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u001e\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\fR\u001b\u0010\u0017\u001a\u00020\u00138FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$b;", "", "", "tag", "Lkotlin/Function0;", "msg", "", "a", "", "DEBUG", "Z", "b", "()Z", "setDEBUG", "(Z)V", "removeViewAnrFixSwitch$delegate", "Lkotlin/Lazy;", "d", "removeViewAnrFixSwitch", "", "delayRemoveView$delegate", "c", "()J", "delayRemoveView", "DURATION_AVATAR_BREATHE", "J", "DURATION_FADE_IN", "DURATION_SPLASH", "FRAME_DURATION", "TAG", "Ljava/lang/String;", "", "VIEW_INDEX_AVATAR", "I", "VIEW_INDEX_BOTTOM", "VIEW_INDEX_LOGO", "VIEW_INDEX_MASK", "VIEW_INDEX_POLAR", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.relogin.fragment.SplashLoginSuccessAnimator$b, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@NotNull String tag, @NotNull Function0<String> msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) tag, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (b()) {
                QLog.d(tag, 2, msg2.invoke());
            }
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SplashLoginSuccessAnimator.f242471g;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return ((Number) SplashLoginSuccessAnimator.f242473i.getValue()).longValue();
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return ((Boolean) SplashLoginSuccessAnimator.f242472h.getValue()).booleanValue();
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationStart", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e72.b f242492d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FrameLayout f242493e;

        c(e72.b bVar, FrameLayout frameLayout) {
            this.f242492d = bVar;
            this.f242493e = frameLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) frameLayout);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e72.b bVar, FrameLayout frameLayout) {
            Intrinsics.checkNotNullParameter(frameLayout, "$frameLayout");
            if (bVar != null) {
                bVar.a();
            }
            frameLayout.setBackground(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation, boolean isReverse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animation, Boolean.valueOf(isReverse));
                return;
            }
            QLog.i("SplashLoginSuccessAnimator", 1, "begin onAnimationStart");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Intrinsics.checkNotNullExpressionValue(uIHandlerV2, "getUIHandlerV2()");
            final e72.b bVar = this.f242492d;
            final FrameLayout frameLayout = this.f242493e;
            ax.h(uIHandlerV2, new Runnable() { // from class: com.tencent.mobileqq.login.relogin.fragment.f
                @Override // java.lang.Runnable
                public final void run() {
                    SplashLoginSuccessAnimator.c.b(e72.b.this, frameLayout);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationEnd", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e72.b f242494d;

        d(e72.b bVar) {
            this.f242494d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(e72.b bVar) {
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animation, Boolean.valueOf(isReverse));
                return;
            }
            QLog.i("SplashLoginSuccessAnimator", 1, "avatar breath onAnimationEnd");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Intrinsics.checkNotNullExpressionValue(uIHandlerV2, "getUIHandlerV2()");
            final e72.b bVar = this.f242494d;
            ax.h(uIHandlerV2, new Runnable() { // from class: com.tencent.mobileqq.login.relogin.fragment.g
                @Override // java.lang.Runnable
                public final void run() {
                    SplashLoginSuccessAnimator.d.b(e72.b.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationEnd", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f242495d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e72.b f242496e;

        e(FrameLayout frameLayout, e72.b bVar) {
            this.f242495d = frameLayout;
            this.f242496e = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) frameLayout, (Object) bVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final FrameLayout frameLayout, e72.b bVar) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(frameLayout, "$frameLayout");
            Companion companion = SplashLoginSuccessAnimator.INSTANCE;
            if (companion.d()) {
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.login.relogin.fragment.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashLoginSuccessAnimator.e.d(frameLayout);
                    }
                }, companion.c());
            } else {
                ViewParent parent = frameLayout.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(frameLayout);
                }
            }
            if (bVar != null) {
                bVar.onAnimEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(FrameLayout frameLayout) {
            ViewGroup viewGroup;
            Intrinsics.checkNotNullParameter(frameLayout, "$frameLayout");
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(frameLayout);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation, boolean isReverse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, animation, Boolean.valueOf(isReverse));
                return;
            }
            QLog.i("SplashLoginSuccessAnimator", 1, "fade in onAnimationEnd");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Intrinsics.checkNotNullExpressionValue(uIHandlerV2, "getUIHandlerV2()");
            final FrameLayout frameLayout = this.f242495d;
            final e72.b bVar = this.f242496e;
            ax.h(uIHandlerV2, new Runnable() { // from class: com.tencent.mobileqq.login.relogin.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    SplashLoginSuccessAnimator.e.c(frameLayout, bVar);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$f", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class f extends AnimatorItem {
        static IPatchRedirector $redirector_;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f242497g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f242498h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f242499i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f242500j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ float f242501k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ float f242502l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int[] f242503m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ SplashLoginSuccessAnimator f242504n;

        /* renamed from: o, reason: collision with root package name */
        final /* synthetic */ float f242505o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ float f242506p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(a aVar, float f16, float f17, float f18, float f19, float f26, float f27, int[] iArr, SplashLoginSuccessAnimator splashLoginSuccessAnimator, float f28, float f29) {
            super(aVar, "avatar");
            this.f242497g = f16;
            this.f242498h = f17;
            this.f242499i = f18;
            this.f242500j = f19;
            this.f242501k = f26;
            this.f242502l = f27;
            this.f242503m = iArr;
            this.f242504n = splashLoginSuccessAnimator;
            this.f242505o = f28;
            this.f242506p = f29;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27), iArr, splashLoginSuccessAnimator, Float.valueOf(f28), Float.valueOf(f29));
            }
        }

        public void g(float animatedValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
                return;
            }
            if (animatedValue <= 1.0f) {
                float f16 = 1;
                float f17 = ((this.f242497g - f16) * animatedValue) + f16;
                float f18 = f16 + ((this.f242498h - f16) * animatedValue);
                d().setTranslate(c().e() + (this.f242499i * animatedValue), c().g() + (this.f242500j * animatedValue));
                d().preScale(f17, f18);
                return;
            }
            if (animatedValue <= 2.0f) {
                float f19 = animatedValue - 1.0f;
                float f26 = 1;
                float f27 = this.f242497g * (((this.f242501k - f26) * f19) + f26);
                float f28 = this.f242498h * (f26 + ((this.f242502l - f26) * f19));
                d().setTranslate((this.f242503m[0] - (this.f242504n.avatarMoveTarget * 0.15f)) + (this.f242505o * f19), (this.f242503m[1] - (this.f242504n.avatarMoveTarget * 0.15f)) + (this.f242506p * f19));
                d().preScale(f27, f28);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$g", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class g extends AnimatorItem {
        static IPatchRedirector $redirector_;

        g(a aVar) {
            super(aVar, VasProfileTemplatePreloadHelper.BACKGROUND);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public void g(float animatedValue) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
                return;
            }
            f(true);
            if (1.0f <= animatedValue && animatedValue <= 2.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                float f16 = 1;
                float f17 = f16 - ((animatedValue - f16) * 0.3f);
                Drawable c16 = c().c();
                if (c16 != null) {
                    c16.setAlpha((int) (255 * f17));
                    return;
                }
                return;
            }
            if (2.0f <= animatedValue && animatedValue <= 3.0f) {
                z17 = true;
            }
            if (z17) {
                float f18 = (3 - animatedValue) * 0.7f;
                Drawable c17 = c().c();
                if (c17 != null) {
                    c17.setAlpha((int) (255 * f18));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$h", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class h extends AnimatorItem {
        static IPatchRedirector $redirector_;

        h(a aVar) {
            super(aVar, "bottomView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public void g(float animatedValue) {
            float coerceAtLeast;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
            } else if (animatedValue < 1.0f) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(animatedValue - 0.4f, 0.0f);
                d().setTranslate(c().e(), c().g() + (c().d() * ((coerceAtLeast * 10) / 6)));
            } else {
                f(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$i", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class i extends AnimatorItem {
        static IPatchRedirector $redirector_;

        i(a aVar) {
            super(aVar, "logoView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public void g(float animatedValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
                return;
            }
            if (animatedValue <= 0.4f) {
                d().setTranslate(c().e(), c().g() - ((c().g() + c().d()) * (animatedValue * 2.5f)));
            } else {
                z16 = false;
            }
            f(z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$j", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class j extends AnimatorItem {
        static IPatchRedirector $redirector_;

        j(a aVar) {
            super(aVar, "mask");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public void g(float animatedValue) {
            float coerceAtMost;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
                return;
            }
            if (animatedValue < 1.0f) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(animatedValue, 1.0f);
                int i3 = (int) (255 * coerceAtMost);
                Drawable c16 = c().c();
                if (c16 != null) {
                    c16.setAlpha(i3);
                }
                e().setAlpha(i3);
                return;
            }
            f(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$k", "Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$AnimatorItem;", "", "animatedValue", "", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class k extends AnimatorItem {
        static IPatchRedirector $redirector_;

        k(a aVar) {
            super(aVar, "polar");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public void g(float animatedValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Float.valueOf(animatedValue));
                return;
            }
            if (animatedValue != 1.0f) {
                z16 = false;
            }
            if (z16) {
                f(false);
            }
        }
    }

    static {
        Lazy<Boolean> lazy;
        Lazy<Long> lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(SplashLoginSuccessAnimator$Companion$removeViewAnrFixSwitch$2.INSTANCE);
        f242472h = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SplashLoginSuccessAnimator$Companion$delayRemoveView$2.INSTANCE);
        f242473i = lazy2;
    }

    public SplashLoginSuccessAnimator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maskColorResId = -1;
        this.captureViewList = new ArrayList();
        this.avatarMoveTarget = ViewUtils.dpToPx(28.0f);
    }

    private final View l(Activity activity, e72.b callback, List<? extends a> captureViewList) {
        List list;
        List listOf;
        if (captureViewList.size() < 5) {
            if (callback != null) {
                callback.b();
                return null;
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.bgColorStateList);
        Unit unit = Unit.INSTANCE;
        final g gVar = new g(new a(null, 0, 0, 0, 0, 0.0f, gradientDrawable, null, 160, null));
        arrayList.add(gVar);
        final k kVar = new k(captureViewList.get(0));
        final i iVar = new i(captureViewList.get(1));
        arrayList.add(iVar);
        final h hVar = new h(captureViewList.get(2));
        arrayList.add(hVar);
        final j jVar = new j(captureViewList.get(3));
        arrayList.add(jVar);
        int i3 = this.avatarMoveTarget;
        int[] q16 = q(activity);
        float e16 = (q16[0] - (this.avatarMoveTarget * 0.15f)) - r1.e();
        float g16 = (q16[1] - (this.avatarMoveTarget * 0.15f)) - r1.g();
        float b16 = b() / this.avatarMoveTarget;
        float b17 = b() / this.avatarMoveTarget;
        int[] a16 = a(activity);
        final f fVar = new f(captureViewList.get(4), i3 / ((float) (r1.h() / 1.3d)), i3 / ((float) (r1.d() / 1.3d)), e16, g16, b16, b17, q16, this, (a16[0] - (b() * 0.15f)) - (q16[0] - (this.avatarMoveTarget * 0.15f)), (a16[1] - (b() * 0.15f)) - (q16[1] - (this.avatarMoveTarget * 0.15f)));
        arrayList.add(fVar);
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        ValueAnimator beginAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        ValueAnimator middleAnimator = ValueAnimator.ofFloat(1.0f, 2.0f);
        ValueAnimator endAnimator = ValueAnimator.ofFloat(2.0f, 3.0f);
        Intrinsics.checkNotNullExpressionValue(beginAnimator, "beginAnimator");
        Intrinsics.checkNotNullExpressionValue(middleAnimator, "middleAnimator");
        Intrinsics.checkNotNullExpressionValue(endAnimator, "endAnimator");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ValueAnimator[]{beginAnimator, middleAnimator, endAnimator});
        beginAnimator.setDuration(432L);
        beginAnimator.setInterpolator(new FastOutSlowInInterpolator());
        middleAnimator.setDuration(192L);
        middleAnimator.setInterpolator(new LinearInterpolator());
        endAnimator.setDuration(192L);
        endAnimator.setInterpolator(new LinearInterpolator());
        beginAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.login.relogin.fragment.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashLoginSuccessAnimator.o(SplashLoginSuccessAnimator.k.this, iVar, hVar, jVar, fVar, valueAnimator);
            }
        });
        middleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.login.relogin.fragment.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashLoginSuccessAnimator.m(SplashLoginSuccessAnimator.f.this, gVar, valueAnimator);
            }
        });
        endAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.login.relogin.fragment.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashLoginSuccessAnimator.n(SplashLoginSuccessAnimator.g.this, valueAnimator);
            }
        });
        LoginAnimSurfaceView loginAnimSurfaceView = new LoginAnimSurfaceView(activity, list, listOf);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(this.bgColorStateList);
        frameLayout.setBackground(gradientDrawable2);
        frameLayout.addView(loginAnimSurfaceView);
        beginAnimator.addListener(new c(callback, frameLayout));
        middleAnimator.addListener(new d(callback));
        endAnimator.addListener(new e(frameLayout, callback));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(f avatarAnimatorItem, g bgAnimatorItem, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(avatarAnimatorItem, "$avatarAnimatorItem");
        Intrinsics.checkNotNullParameter(bgAnimatorItem, "$bgAnimatorItem");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        avatarAnimatorItem.g(((Float) animatedValue).floatValue());
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        bgAnimatorItem.g(((Float) animatedValue2).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(g bgAnimatorItem, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(bgAnimatorItem, "$bgAnimatorItem");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        bgAnimatorItem.g(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(k polarAnimatorItem, i logoAnimatorItem, h bottomViewAnimatorItem, j maskAnimatorItem, f avatarAnimatorItem, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(polarAnimatorItem, "$polarAnimatorItem");
        Intrinsics.checkNotNullParameter(logoAnimatorItem, "$logoAnimatorItem");
        Intrinsics.checkNotNullParameter(bottomViewAnimatorItem, "$bottomViewAnimatorItem");
        Intrinsics.checkNotNullParameter(maskAnimatorItem, "$maskAnimatorItem");
        Intrinsics.checkNotNullParameter(avatarAnimatorItem, "$avatarAnimatorItem");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        polarAnimatorItem.g(((Float) animatedValue).floatValue());
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        logoAnimatorItem.g(((Float) animatedValue2).floatValue());
        Object animatedValue3 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        bottomViewAnimatorItem.g(((Float) animatedValue3).floatValue());
        Object animatedValue4 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue4, "null cannot be cast to non-null type kotlin.Float");
        maskAnimatorItem.g(((Float) animatedValue4).floatValue());
        Object animatedValue5 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue5, "null cannot be cast to non-null type kotlin.Float");
        avatarAnimatorItem.g(((Float) animatedValue5).floatValue());
    }

    private final void p(Activity activity, View rootView, @ColorRes int maskColorResId) {
        if (!(rootView instanceof ViewGroup)) {
            return;
        }
        QUIPolarLightView qUIPolarLightView = (QUIPolarLightView) rootView.findViewById(R.id.f26270d3);
        if (qUIPolarLightView != null) {
            qUIPolarLightView.stopAnimation();
        }
        this.maskColorResId = maskColorResId;
        this.bgColorStateList = activity.getColorStateList(maskColorResId);
        long currentTimeMillis = System.currentTimeMillis();
        this.captureViewList.clear();
        try {
            ArrayList arrayList = new ArrayList();
            View polarLight = rootView.findViewById(R.id.f26270d3);
            com.tencent.mobileqq.login.relogin.anim.a aVar = com.tencent.mobileqq.login.relogin.anim.a.f242420a;
            Intrinsics.checkNotNullExpressionValue(polarLight, "polarLight");
            a b16 = com.tencent.mobileqq.login.relogin.anim.a.b(aVar, polarLight, 0, 0, false, 14, null);
            if (b16 != null) {
                arrayList.add(b16);
            }
            View findViewById = rootView.findViewById(R.id.f61782z2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qq_logo)");
            a b17 = com.tencent.mobileqq.login.relogin.anim.a.b(aVar, (ImageView) findViewById, 0, 0, false, 14, null);
            if (b17 != null) {
                arrayList.add(b17);
            }
            a d16 = com.tencent.mobileqq.login.relogin.anim.a.d(aVar, rootView, Arrays.copyOf(new int[]{R.id.k9t, R.id.f1057566v, R.id.ai7, R.id.yug, R.id.zea}, 5), false, 4, null);
            if (d16 != null) {
                arrayList.add(d16);
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(this.bgColorStateList);
            gradientDrawable.setAlpha(0);
            arrayList.add(new a(null, 0, 0, ((ViewGroup) rootView).getWidth(), ((ViewGroup) rootView).getHeight(), 0.0f, gradientDrawable, null, 128, null));
            View findViewById2 = rootView.findViewById(R.id.f165909du3);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.iv_avatar)");
            a b18 = com.tencent.mobileqq.login.relogin.anim.a.b(aVar, (QQProAvatarView) findViewById2, 0, 0, false, 14, null);
            if (b18 != null) {
                arrayList.add(b18);
            }
            if (arrayList.size() == 5) {
                this.captureViewList.addAll(arrayList);
            } else {
                QLog.i("SplashLoginSuccessAnimator", 1, "captureReLoginView error size: " + arrayList.size());
            }
        } catch (Exception e16) {
            QLog.e("SplashLoginSuccessAnimator", 1, "captureReLoginView ", e16);
        }
        QLog.i("SplashLoginSuccessAnimator", 1, "captureReLoginView cost " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private final int[] q(Context context) {
        return new int[]{ViewUtils.dpToPx(16.0f) + ((b() - this.avatarMoveTarget) / 2), ImmersiveUtils.getStatusBarHeight(context) + ((context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - this.avatarMoveTarget) / 2)};
    }

    @Override // com.tencent.mobileqq.login.relogin.fragment.a
    public void c(@NotNull Activity activity, @NotNull View rootView, @ColorRes int maskColorResId, @Nullable e72.b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, rootView, Integer.valueOf(maskColorResId), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.i("SplashLoginSuccessAnimator", 2, "startLoginAnim ");
        if (callback != null) {
            callback.a();
        }
        p(activity, rootView, maskColorResId);
        if (callback != null) {
            callback.onAnimEnd();
        }
        boolean isDevelopLevel = QLog.isDevelopLevel();
        f242471g = isDevelopLevel;
        QLog.i("SplashLoginSuccessAnimator", 1, "isDEBUG? " + isDevelopLevel);
    }

    @Override // com.tencent.mobileqq.login.relogin.fragment.a
    public void d(@NotNull Activity activity, long fadeInDuration, @Nullable e72.b callback) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, Long.valueOf(fadeInDuration), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i("SplashLoginSuccessAnimator", 2, "startSplashAnim captureViewList size: " + this.captureViewList.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null || str.length() == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.w("SplashLoginSuccessAnimator", 1, "startSplashAnim disable, uin is null");
            if (callback != null) {
                callback.b();
                return;
            }
            return;
        }
        if (this.captureViewList.size() < 5) {
            QLog.i("SplashLoginSuccessAnimator", 1, "startSplashAnim disable childView error. size: " + this.captureViewList.size());
            if (callback != null) {
                callback.b();
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        View l3 = l(activity, callback, this.captureViewList);
        QLog.i("SplashLoginSuccessAnimator", 2, "buildAnim cost: " + (System.currentTimeMillis() - currentTimeMillis));
        if (l3 != null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            if (viewGroup != null) {
                viewGroup.addView(l3, -1, -1);
            }
        } else if (callback != null) {
            callback.b();
        }
        this.captureViewList.clear();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001BQ\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\r\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u0015\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/login/relogin/fragment/SplashLoginSuccessAnimator$a;", "", "Landroid/graphics/Bitmap;", "a", "Landroid/graphics/Bitmap;", "b", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "I", "e", "()I", "left", "c", "g", "top", "d", tl.h.F, "width", "height", "", "f", UserInfo.SEX_FEMALE, "()F", com.tencent.luggage.wxa.c8.c.f123400v, "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/widget/ImageView$ScaleType;", "Landroid/widget/ImageView$ScaleType;", "()Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(Landroid/graphics/Bitmap;IIIIFLandroid/graphics/drawable/Drawable;Landroid/widget/ImageView$ScaleType;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int left;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int top;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int width;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int height;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final float alpha;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Drawable drawable;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ImageView.ScaleType scaleType;

        public a(@Nullable Bitmap bitmap, int i3, int i16, int i17, int i18, float f16, @Nullable Drawable drawable, @NotNull ImageView.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), drawable, scaleType);
                return;
            }
            this.bitmap = bitmap;
            this.left = i3;
            this.top = i16;
            this.width = i17;
            this.height = i18;
            this.alpha = f16;
            this.drawable = drawable;
            this.scaleType = scaleType;
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.alpha;
        }

        @Nullable
        public final Bitmap b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.bitmap;
        }

        @Nullable
        public final Drawable c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.drawable;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.height;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.left;
        }

        @NotNull
        public final ImageView.ScaleType f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ImageView.ScaleType) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.scaleType;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.top;
        }

        public final int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.width;
        }

        public /* synthetic */ a(Bitmap bitmap, int i3, int i16, int i17, int i18, float f16, Drawable drawable, ImageView.ScaleType scaleType, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap, i3, i16, i17, i18, (i19 & 32) != 0 ? 1.0f : f16, (i19 & 64) != 0 ? null : drawable, (i19 & 128) != 0 ? ImageView.ScaleType.FIT_CENTER : scaleType);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Float.valueOf(f16), drawable, scaleType, Integer.valueOf(i19), defaultConstructorMarker);
        }
    }
}
