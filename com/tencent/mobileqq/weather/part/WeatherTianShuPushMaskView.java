package com.tencent.mobileqq.weather.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AdTimeCounter;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001B\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0002OPB+\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0007J\b\u0010\u0014\u001a\u00020\u0003H\u0007J\b\u0010\u0015\u001a\u00020\u0003H\u0007R\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010&R\u0016\u00103\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010=R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "", "o", tl.h.F, "u", DomainData.DOMAIN_NAME, "r", ReportConstant.COSTREPORT_PREFIX, "t", "", "p", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "onLifecycleResume", "onLifecyclePause", "onLifecycleDestroy", "d", "Landroid/content/Context;", "mContext", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mRootView", "Lcom/tencent/mobileqq/weather/data/o;", "f", "Lcom/tencent/mobileqq/weather/data/o;", "tianShuData", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "mImgDrawable", "Landroid/view/View;", "i", "Landroid/view/View;", "mDialogRootView", "Landroid/widget/FrameLayout;", "mDialogContentView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mDialogImage", "D", "mCloseIcon", "E", "mCloseRippleTop", UserInfo.SEX_FEMALE, "mCloseRippleBottom", "", "G", "Ljava/lang/String;", "mImageUrl", "H", "Z", "mIsShown", "I", "mIsCloseClicked", "J", "mIsPause", "", "K", "mCurrentCloseTime", "com/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$c", "L", "Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$c;", "mCloseTimerCallback", "Lcom/tencent/mobileqq/util/AdTimeCounter;", "M", "Lcom/tencent/mobileqq/util/AdTimeCounter;", "mCloseTimeCounter", "Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$b;", "onCloseListener", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/weather/data/o;Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$b;)V", "N", "a", "b", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherTianShuPushMaskView extends FrameLayout implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mDialogImage;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView mCloseIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private View mCloseRippleTop;

    /* renamed from: F, reason: from kotlin metadata */
    private View mCloseRippleBottom;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String mImageUrl;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsShown;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsCloseClicked;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsPause;

    /* renamed from: K, reason: from kotlin metadata */
    private long mCurrentCloseTime;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final c mCloseTimerCallback;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final AdTimeCounter mCloseTimeCounter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.weather.data.o tianShuData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private APNGDrawable mImgDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View mDialogRootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mDialogContentView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$a;", "", "", "AUTO_CLOSE_TIME", "J", "CLICK_RIPPLE_ANIM_DURATION", "CLOSE_ICON_DISAPPEAR_ANIM_DURATION", "DIALOG_DISAPPEAR_ALPHA_ANIM_DURATION", "DIALOG_DISAPPEAR_TRANS_ANIM_DURATION", "", "TAG", "Ljava/lang/String;", "TIME_COUNTER_FREQ", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.WeatherTianShuPushMaskView$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$b;", "", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface b {
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$c", "Lcom/tencent/mobileqq/util/d;", "", "currentTimeMs", "", "a", "leftTimeMs", "b", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.util.d {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherTianShuPushMaskView.this);
            }
        }

        @Override // com.tencent.mobileqq.util.d
        public void a(long currentTimeMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                WeatherTianShuPushMaskView.this.mCurrentCloseTime = currentTimeMs;
                QLog.d("WeatherTianShuPushMaskView", 1, "onCurrentTime:", Long.valueOf(currentTimeMs));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, currentTimeMs);
            }
        }

        @Override // com.tencent.mobileqq.util.d
        public void b(long leftTimeMs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, leftTimeMs);
            } else if (leftTimeMs == 0) {
                WeatherTianShuPushMaskView.this.u();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherTianShuPushMaskView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                View view = WeatherTianShuPushMaskView.this.mCloseRippleTop;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleTop");
                    view = null;
                }
                view.setVisibility(8);
                WeatherTianShuPushMaskView.this.u();
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherTianShuPushMaskView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                View view = WeatherTianShuPushMaskView.this.mCloseRippleBottom;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleBottom");
                    view = null;
                }
                view.setVisibility(8);
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/weather/part/WeatherTianShuPushMaskView$f", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class f implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WeatherTianShuPushMaskView.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                WeatherTianShuPushMaskView.this.l();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43506);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ WeatherTianShuPushMaskView(Context context, ViewGroup viewGroup, com.tencent.mobileqq.weather.data.o oVar, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, oVar, (i3 & 8) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, viewGroup, oVar, bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    private final void h() {
        String n3 = this.tianShuData.n();
        this.mImageUrl = n3;
        if (TextUtils.isEmpty(n3)) {
            return;
        }
        ImageView imageView = this.mDialogImage;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            imageView = null;
        }
        imageView.setImageDrawable(GdtUIUtils.getUrlDrawable(this.tianShuData.n()));
        this.mImgDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngDrawable("WeatherTianShuPushMaskView", this.tianShuData.n(), new ApngOptions());
        ImageView imageView3 = this.mDialogImage;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            imageView3 = null;
        }
        imageView3.setImageDrawable(this.mImgDrawable);
        FrameLayout frameLayout = this.mDialogContentView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentView");
            frameLayout = null;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeatherTianShuPushMaskView.i(WeatherTianShuPushMaskView.this, view);
            }
        });
        View view = this.mDialogRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogRootView");
            view = null;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.weather.part.af
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean j3;
                j3 = WeatherTianShuPushMaskView.j(view2, motionEvent);
                return j3;
            }
        });
        ImageView imageView4 = this.mCloseIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIcon");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WeatherTianShuPushMaskView.k(WeatherTianShuPushMaskView.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(WeatherTianShuPushMaskView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        ImageView imageView = this$0.mDialogImage;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogImage");
            imageView = null;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mDialogImage.context");
        gVar.O(context, this$0.tianShuData.h());
        com.tencent.mobileqq.weather.mvvm.h.f313416a.f(this$0.tianShuData, "tianshu push dialog click");
        com.tencent.mobileqq.weather.util.report.m.f313688a.b();
        this$0.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WeatherTianShuPushMaskView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LifecycleOwner m(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    private final void n() {
        if (this.mIsCloseClicked) {
            return;
        }
        com.tencent.mobileqq.weather.util.report.m.f313688a.c();
        this.mIsCloseClicked = true;
        r();
    }

    private final void o() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.h7i, (ViewGroup) this, true);
        if (inflate == null) {
            return;
        }
        View findViewById = inflate.findViewById(R.id.f121697by);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_tianshu_dialog_rootview)");
        this.mDialogRootView = findViewById;
        View findViewById2 = inflate.findViewById(R.id.f121677bw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026r_tianshu_dialog_content)");
        this.mDialogContentView = (FrameLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f121687bx);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026ather_tianshu_dialog_img)");
        this.mDialogImage = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f121637bs);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ianshu_dialog_close_icon)");
        this.mCloseIcon = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f121657bu);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_dialog_close_ripple_top)");
        this.mCloseRippleTop = findViewById5;
        View findViewById6 = inflate.findViewById(R.id.f121647bt);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026alog_close_ripple_bottom)");
        this.mCloseRippleBottom = findViewById6;
        View view = this.mCloseRippleTop;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleTop");
            view = null;
        }
        com.tencent.mobileqq.weather.util.b.j(view, 29.0f);
        View view3 = this.mCloseRippleBottom;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleBottom");
        } else {
            view2 = view3;
        }
        com.tencent.mobileqq.weather.util.b.j(view2, 29.0f);
    }

    private final boolean p() {
        com.tencent.mobileqq.weather.data.f fVar = com.tencent.mobileqq.weather.data.f.f313296a;
        if (fVar.f() != 0 && TextUtils.equals(this.tianShuData.e(), String.valueOf(fVar.f()))) {
            return true;
        }
        return false;
    }

    private final void r() {
        View view = this.mCloseRippleTop;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleTop");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this.mCloseRippleBottom;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleBottom");
            view3 = null;
        }
        view3.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new d());
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(300L);
        alphaAnimation2.setFillAfter(true);
        alphaAnimation2.setAnimationListener(new e());
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation2);
        animationSet.addAnimation(scaleAnimation);
        View view4 = this.mCloseRippleTop;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleTop");
            view4 = null;
        }
        view4.startAnimation(alphaAnimation);
        View view5 = this.mCloseRippleBottom;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleBottom");
        } else {
            view2 = view5;
        }
        view2.startAnimation(animationSet);
    }

    private final void s() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        alphaAnimation.setFillAfter(true);
        ImageView imageView = this.mCloseIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIcon");
            imageView = null;
        }
        imageView.startAnimation(alphaAnimation);
    }

    private final void t() {
        boolean p16 = p();
        QLog.d("WeatherTianShuPushMaskView", 1, "startDialogCloseAnim is connect:", Boolean.valueOf(p16));
        ad adVar = new ad();
        long j3 = 700;
        adVar.setDuration(700L);
        adVar.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        if (!p16) {
            j3 = 200;
        }
        alphaAnimation.setDuration(j3);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new f());
        AnimationSet animationSet = new AnimationSet(true);
        if (p16) {
            animationSet.addAnimation(adVar);
        }
        animationSet.addAnimation(alphaAnimation);
        FrameLayout frameLayout = this.mDialogContentView;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentView");
            frameLayout = null;
        }
        frameLayout.startAnimation(animationSet);
        View view2 = this.mDialogRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogRootView");
        } else {
            view = view2;
        }
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        this.mIsCloseClicked = true;
        this.mCloseTimeCounter.i();
        s();
        t();
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mRootView.removeView(this);
        View view = this.mDialogRootView;
        FrameLayout frameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogRootView");
            view = null;
        }
        view.setVisibility(8);
        ImageView imageView = this.mCloseIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIcon");
            imageView = null;
        }
        Animation animation = imageView.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        View view2 = this.mCloseRippleTop;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleTop");
            view2 = null;
        }
        Animation animation2 = view2.getAnimation();
        if (animation2 != null) {
            animation2.cancel();
        }
        View view3 = this.mCloseRippleBottom;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseRippleBottom");
            view3 = null;
        }
        Animation animation3 = view3.getAnimation();
        if (animation3 != null) {
            animation3.cancel();
        }
        FrameLayout frameLayout2 = this.mDialogContentView;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogContentView");
        } else {
            frameLayout = frameLayout2;
        }
        Animation animation4 = frameLayout.getAnimation();
        if (animation4 != null) {
            animation4.cancel();
        }
        APNGDrawable aPNGDrawable = this.mImgDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.stop();
        }
        this.mCurrentCloseTime = 5000L;
        this.mCloseTimeCounter.i();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d("WeatherTianShuPushMaskView", 2, "onLifecycleDestroy");
        l();
        LifecycleOwner m3 = m(this.mContext);
        if (m3 != null && (lifecycle = m3.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onLifecyclePause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        QLog.d("WeatherTianShuPushMaskView", 2, "onLifecyclePause");
        this.mIsPause = true;
        this.mCloseTimeCounter.i();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onLifecycleResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!this.mIsCloseClicked && this.mIsPause && this.mIsShown) {
            QLog.d("WeatherTianShuPushMaskView", 2, "onLifecycleResume");
            this.mCloseTimeCounter.h(this.mCurrentCloseTime);
        }
        this.mIsPause = false;
    }

    public final void q() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mRootView.addView(this);
        View view = this.mDialogRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDialogRootView");
            view = null;
        }
        view.setVisibility(0);
        this.mIsShown = true;
        com.tencent.mobileqq.weather.mvvm.h.f313416a.g(this.tianShuData, "tianshu push dialog expo");
        com.tencent.mobileqq.weather.util.report.m.f313688a.d();
        APNGDrawable aPNGDrawable = this.mImgDrawable;
        if (aPNGDrawable != null) {
            aPNGDrawable.start();
        }
        this.mCloseTimeCounter.g();
        QLog.d("WeatherTianShuPushMaskView", 1, "show, start count");
        LifecycleOwner m3 = m(this.mContext);
        if (m3 != null && (lifecycle = m3.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherTianShuPushMaskView(@NotNull Context mContext, @NotNull ViewGroup mRootView, @NotNull com.tencent.mobileqq.weather.data.o tianShuData, @Nullable b bVar) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(tianShuData, "tianShuData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, mContext, mRootView, tianShuData, bVar);
            return;
        }
        this.mContext = mContext;
        this.mRootView = mRootView;
        this.tianShuData = tianShuData;
        this.mImageUrl = "";
        c cVar = new c();
        this.mCloseTimerCallback = cVar;
        this.mCloseTimeCounter = new AdTimeCounter(5000L, new WeakReference(cVar), 500L);
        o();
        h();
    }
}
