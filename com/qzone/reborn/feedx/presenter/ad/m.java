package com.qzone.reborn.feedx.presenter.ad;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.canvasui.widget.shake.GdtShakeLeftLayoutForQzone;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.shakead.ShakeCaiDanAdManager;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.mobileqq.vip.diy.common.DIYLottieLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0002\u0081\u0001B\b\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\u0012\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\b\u0010&\u001a\u00020\u0002H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\b\u0010)\u001a\u00020(H\u0014J\b\u0010*\u001a\u00020\u0013H\u0014J\b\u0010+\u001a\u00020\u000bH\u0014J\u0012\u0010.\u001a\u00020\u00022\b\u0010-\u001a\u0004\u0018\u00010,H\u0014J\u0010\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0014J\u0012\u00102\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u00103\u001a\u00020\u0002H\u0016J\b\u00104\u001a\u00020\u0002H\u0016J\b\u00105\u001a\u00020\u0002H\u0016J\b\u00106\u001a\u00020\u0002H\u0016J\u0006\u00107\u001a\u00020\u0002J\b\u00108\u001a\u00020\u0002H\u0016R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010K\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010;R\u0018\u0010M\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010>R\u0018\u0010O\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010BR\u0018\u0010Q\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010FR\u0018\u0010T\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0016\u0010Y\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010HR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\u0007R\u0018\u0010c\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010l\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0018\u0010n\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010pR\u0014\u0010t\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010sR$\u0010{\u001a\u0004\u0018\u00010u8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u0018\u0010~\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010}\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/m;", "Lvg/a;", "", "e0", "g0", "f0", "w0", "Z", "B0", "y0", "z0", "", "animate", "d0", "Lcom/tencent/mobileqq/vip/diy/common/DIYLottieLoader;", "X", "Lcf/b;", "event", "c0", "", "currentDuration", "m0", "l0", "b0", "state", "s0", "n0", "o0", "x0", "A0", "u0", "v0", "a0", "t0", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "Y", "C0", "k0", "j0", "", "k", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "c", "onPaused", "r0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mAdvShakeMaskLayout", "G", "Lcom/airbnb/lottie/LottieAnimationView;", "mAdvShakeMaskImageView", "Lcom/tencent/mobileqq/vas/widget/lottie/LottieLoader;", "H", "Lcom/tencent/mobileqq/vas/widget/lottie/LottieLoader;", "mAdvShakeMaskLottieLoader", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mAdvShakeMaskContentTitle", "J", "mAdvShakeMaskContent", "K", "mAdvShakeGuideLayout", "L", "mAdvShakeGuideImageView", "M", "mAdvShakeGuideLottieLoader", "N", "mAdvShakeGuideContent", "P", "Ljava/lang/String;", "mShakeLottieUrl", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mShakeStartTime", BdhLogUtil.LogTag.Tag_Req, "mShakeScrollTime", "Landroid/widget/RelativeLayout;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/RelativeLayout;", "mAdShakeRightGuideLayout", "T", "mIsShakeRightStyle", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "mAdShakeRightGuideLight", "Landroid/view/animation/Animation;", "V", "Landroid/view/animation/Animation;", "mAdShakeRightGuideLightAnimation", "Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;", "W", "Lcom/qzone/canvasui/widget/shake/GdtShakeLeftLayoutForQzone;", "mShakeLeftGuideLayout", "mIsShakeLeftStyle", "Landroid/view/View;", "mCurrentShakeLayout", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "mShakeSensor", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeWithValueListener;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeWithValueListener;", "mShakeListener", "Landroid/os/Handler;", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "mAd", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends vg.a {

    /* renamed from: e0, reason: collision with root package name */
    private static final HashMap<String, Boolean> f55484e0 = new HashMap<>();

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mAdvShakeMaskLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private LottieAnimationView mAdvShakeMaskImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private LottieLoader mAdvShakeMaskLottieLoader;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mAdvShakeMaskContentTitle;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mAdvShakeMaskContent;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout mAdvShakeGuideLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private LottieAnimationView mAdvShakeGuideImageView;

    /* renamed from: M, reason: from kotlin metadata */
    private LottieLoader mAdvShakeGuideLottieLoader;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mAdvShakeGuideContent;

    /* renamed from: P, reason: from kotlin metadata */
    private String mShakeLottieUrl;

    /* renamed from: Q, reason: from kotlin metadata */
    private long mShakeStartTime;

    /* renamed from: R, reason: from kotlin metadata */
    private long mShakeScrollTime;

    /* renamed from: S, reason: from kotlin metadata */
    private RelativeLayout mAdShakeRightGuideLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mIsShakeRightStyle;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView mAdShakeRightGuideLight;

    /* renamed from: V, reason: from kotlin metadata */
    private Animation mAdShakeRightGuideLightAnimation;

    /* renamed from: W, reason: from kotlin metadata */
    private GdtShakeLeftLayoutForQzone mShakeLeftGuideLayout;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean mIsShakeLeftStyle;

    /* renamed from: Y, reason: from kotlin metadata */
    private View mCurrentShakeLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    private GdtShakeSensor mShakeSensor;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final GdtShakeSensor.OnShakeWithValueListener mShakeListener = new GdtShakeSensor.OnShakeWithValueListener() { // from class: com.qzone.reborn.feedx.presenter.ad.j
        @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeWithValueListener
        public final void onShakeComplete(float f16, float f17, float f18, float f19) {
            m.p0(m.this, f16, f17, f18, f19);
        }
    };

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private Handler mHandler = new c(Looper.getMainLooper());

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GdtAd mAd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/m$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            LinearLayout linearLayout = m.this.mAdvShakeMaskLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(4);
            }
            if (m.this.mIsShakeRightStyle || ih.j.j(((vg.a) m.this).f441565h, m.this.mShakeStartTime)) {
                return;
            }
            View view = m.this.mCurrentShakeLayout;
            if (view != null && view.getVisibility() == 0) {
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250L);
            View view2 = m.this.mCurrentShakeLayout;
            if (view2 != null) {
                view2.startAnimation(alphaAnimation);
            }
            View view3 = m.this.mCurrentShakeLayout;
            if (view3 == null) {
                return;
            }
            view3.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/m$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            if (i3 == 1) {
                m.this.d0(true);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                m.this.w0();
                return;
            }
            if (m.this.mAd != null) {
                GdtAd gdtAd = m.this.mAd;
                if (ih.j.i(gdtAd != null ? gdtAd.getTraceId() : null)) {
                    QLog.d("QZoneAdFeedShakeCaiDanPresenter", 1, "feed is marked as shielded ");
                    m.this.u0();
                    return;
                }
            }
            LinearLayout linearLayout = m.this.mAdvShakeMaskLayout;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                return;
            }
            m.this.t0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/m$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ImageView imageView = m.this.mAdShakeRightGuideLight;
            if (imageView != null) {
                imageView.startAnimation(m.this.mAdShakeRightGuideLightAnimation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/m$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            m.this.Z();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    private final void A0() {
        View view;
        if (ih.j.l(this.f441565h)) {
            GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
            if (gdtShakeSensor != null) {
                gdtShakeSensor.unregister(BaseApplication.getContext());
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(2);
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.removeMessages(3);
            }
            View view2 = this.mCurrentShakeLayout;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            LinearLayout linearLayout = this.mAdvShakeMaskLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (this.mIsShakeRightStyle && (view = this.mCurrentShakeLayout) != null) {
                view.clearAnimation();
            }
            LottieAnimationView lottieAnimationView = this.mAdvShakeGuideImageView;
            LottieDrawable lottieDrawable = (LottieDrawable) (lottieAnimationView != null ? lottieAnimationView.getDrawable() : null);
            if (lottieDrawable != null) {
                lottieDrawable.stop();
            }
            LottieAnimationView lottieAnimationView2 = this.mAdvShakeMaskImageView;
            LottieDrawable lottieDrawable2 = (LottieDrawable) (lottieAnimationView2 != null ? lottieAnimationView2.getDrawable() : null);
            if (lottieDrawable2 != null) {
                lottieDrawable2.stop();
            }
        }
    }

    private final void B0() {
        if (this.mAdvShakeMaskLottieLoader == null) {
            this.mAdvShakeMaskLottieLoader = X();
        }
        if (this.mAdvShakeGuideLottieLoader == null) {
            this.mAdvShakeGuideLottieLoader = X();
        }
        try {
            JSONObject jSONObject = new JSONObject(ih.j.b(this.f441565h));
            TextView textView = this.mAdvShakeMaskContentTitle;
            if (textView != null) {
                textView.setText(jSONObject.optString("title"));
            }
            TextView textView2 = this.mAdvShakeMaskContent;
            if (textView2 != null) {
                textView2.setText(jSONObject.optString("description"));
            }
            this.mShakeLottieUrl = jSONObject.optString("shake_lottie_animation");
            y0();
            ShakeCaiDanAdManager.c().h(jSONObject.optString("transition_animation_url"));
            if (this.mShakeSensor == null) {
                this.mShakeSensor = new GdtShakeSensor();
            }
            GdtShakeSensor.Params c16 = ih.j.c(this.f441565h);
            GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
            if (gdtShakeSensor != null) {
                gdtShakeSensor.setShakeFactor(c16);
            }
            GdtShakeSensor gdtShakeSensor2 = this.mShakeSensor;
            if (gdtShakeSensor2 != null) {
                gdtShakeSensor2.setShakeWithValueListener(new WeakReference<>(this.mShakeListener));
            }
            x0();
        } catch (Exception e16) {
            QLog.e("QZoneAdFeedShakeCaiDanPresenter", 1, "parse json error " + e16);
        }
    }

    private final void C0() {
        this.mShakeStartTime = System.currentTimeMillis();
        if (this.mShakeScrollTime != 0) {
            return;
        }
        this.mShakeScrollTime = System.currentTimeMillis();
    }

    private final DIYLottieLoader X() {
        DIYLottieLoader dIYLottieLoader = new DIYLottieLoader(this.f441562d.getContext());
        dIYLottieLoader.setMemoryCacheSize((int) (sy3.b.a() / 2));
        return dIYLottieLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z() {
        View view;
        if (!this.mIsShakeRightStyle && (view = this.mCurrentShakeLayout) != null) {
            view.setVisibility(4);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(250L);
        LinearLayout linearLayout = this.mAdvShakeMaskLayout;
        if (linearLayout != null) {
            linearLayout.startAnimation(alphaAnimation);
        }
        LinearLayout linearLayout2 = this.mAdvShakeMaskLayout;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        Message message = new Message();
        message.what = 1;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessageDelayed(message, a0());
        }
    }

    private final int a0() {
        if (ih.j.o(this.f441565h)) {
            return ih.j.d(this.f441565h);
        }
        return ih.j.n(this.f441565h) ? 2000 : -1;
    }

    private final boolean b0() {
        String str;
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null || (str = gdtAd.getTraceId()) == null) {
            str = "";
        }
        if (this.mAd != null && !TextUtils.isEmpty(str)) {
            HashMap<String, Boolean> hashMap = f55484e0;
            if (hashMap.containsKey(str)) {
                return Intrinsics.areEqual(hashMap.get(str), Boolean.TRUE);
            }
        }
        return false;
    }

    private final void c0(cf.b event) {
        int r16 = QZoneAdFeedUtils.f55717a.r(event.f30766b, "event_key_qzone_ad_feed_video_current_duration");
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            Intrinsics.checkNotNull(gdtAd);
            if (ih.j.i(gdtAd.getTraceId()) || ih.j.j(this.f441565h, this.mShakeStartTime)) {
                LinearLayout linearLayout = this.mAdvShakeMaskLayout;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(8);
                return;
            }
        }
        if (m0(r16)) {
            s0(true);
            w0();
        }
        if (l0(r16)) {
            s0(false);
        }
    }

    private final void e0() {
        if (this.mAdvShakeGuideLayout == null) {
            ViewStub viewStub = (ViewStub) this.f441562d.findViewById(R.id.n1d);
            this.mAdvShakeGuideLayout = (LinearLayout) (viewStub != null ? viewStub.inflate() : null);
        }
        LinearLayout linearLayout = this.mAdvShakeGuideLayout;
        Intrinsics.checkNotNull(linearLayout);
        View findViewById = linearLayout.findViewById(R.id.n1f);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById;
        this.mAdvShakeGuideImageView = lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        LottieAnimationView lottieAnimationView2 = this.mAdvShakeGuideImageView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView3 = this.mAdvShakeGuideImageView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setRepeatMode(1);
        }
        LinearLayout linearLayout2 = this.mAdvShakeGuideLayout;
        Intrinsics.checkNotNull(linearLayout2);
        View findViewById2 = linearLayout2.findViewById(R.id.n1e);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById2;
        this.mAdvShakeGuideContent = textView;
        if (textView == null) {
            return;
        }
        textView.setText("\u6447\u52a8\u624b\u673a");
    }

    private final void f0() {
        if (this.mAdvShakeMaskLayout == null) {
            ViewStub viewStub = (ViewStub) this.f441562d.findViewById(R.id.n1i);
            this.mAdvShakeMaskLayout = (LinearLayout) (viewStub != null ? viewStub.inflate() : null);
        }
        LinearLayout linearLayout = this.mAdvShakeMaskLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        LinearLayout linearLayout2 = this.mAdvShakeMaskLayout;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) (linearLayout2 != null ? linearLayout2.findViewById(R.id.n1j) : null);
        this.mAdvShakeMaskImageView = lottieAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView2 = this.mAdvShakeMaskImageView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setRepeatMode(1);
        }
        LottieAnimationView lottieAnimationView3 = this.mAdvShakeMaskImageView;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        LinearLayout linearLayout3 = this.mAdvShakeMaskLayout;
        this.mAdvShakeMaskContentTitle = (TextView) (linearLayout3 != null ? linearLayout3.findViewById(R.id.n1h) : null);
        LinearLayout linearLayout4 = this.mAdvShakeMaskLayout;
        this.mAdvShakeMaskContent = (TextView) (linearLayout4 != null ? linearLayout4.findViewById(R.id.n1g) : null);
    }

    private final void g0() {
        ViewStub viewStub = (ViewStub) this.f441563e.findViewById(R.id.nmn);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mAdShakeRightGuideLayout = (RelativeLayout) this.f441563e.findViewById(R.id.f162785mm3);
        this.mAdShakeRightGuideLight = (ImageView) this.f441563e.findViewById(R.id.mm6);
        RelativeLayout relativeLayout = this.mAdShakeRightGuideLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.presenter.ad.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.i0(m.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity mActivity = this$0.C;
            Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
            BusinessFeedData mFeedData = this$0.f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
            qZoneAdFeedUtils.H(mActivity, view, mFeedData, FeedElement.RECOMM_ACTION_LEFT_TEXT, 8, this$0.f441567m, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j0() {
        RelativeLayout relativeLayout = this.mAdShakeRightGuideLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone = this.mShakeLeftGuideLayout;
        if (gdtShakeLeftLayoutForQzone != null) {
            gdtShakeLeftLayoutForQzone.setVisibility(8);
        }
        LinearLayout linearLayout = this.mAdvShakeGuideLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    private final void k0() {
        GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone = (GdtShakeLeftLayoutForQzone) this.f441562d.findViewById(R.id.myi);
        this.mShakeLeftGuideLayout = gdtShakeLeftLayoutForQzone;
        if (gdtShakeLeftLayoutForQzone != null) {
            gdtShakeLeftLayoutForQzone.addGuideText("\u6447\u52a8\u624b\u673a");
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) gdtShakeLeftLayoutForQzone.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).height = AreaConst.dp25;
                int i3 = AreaConst.dp12;
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i3;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
                gdtShakeLeftLayoutForQzone.init(ih.j.c(this.f441565h));
                gdtShakeLeftLayoutForQzone.setLayoutParams(layoutParams);
            }
        }
    }

    private final boolean l0(int currentDuration) {
        return ih.j.o(this.f441565h) && currentDuration < ih.j.e(this.f441565h) && b0();
    }

    private final boolean m0(int currentDuration) {
        int e16 = ih.j.e(this.f441565h);
        return ih.j.o(this.f441565h) && e16 >= 0 && currentDuration >= e16 && !b0();
    }

    private final boolean n0() {
        BusinessFeedData businessFeedData;
        return this.C != null && (businessFeedData = this.f441565h) != null && ih.j.l(businessFeedData) && this.C.hasWindowFocus() && QZoneAdFeedUtils.f55717a.K(this.f441565h, this.f441563e, this.C) && o0();
    }

    private final boolean o0() {
        LinearLayout linearLayout = this.mAdvShakeMaskLayout;
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            return true;
        }
        View view = this.mCurrentShakeLayout;
        if (view != null && view.getVisibility() == 0) {
            return QZoneAdFeedUtils.f55717a.N(this.mCurrentShakeLayout, this.C, 100);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0(false);
        ShakeCaiDanAdManager.c().e(true);
        ShakeCaiDanAdManager c16 = ShakeCaiDanAdManager.c();
        View view = this$0.f441563e;
        Activity activity = this$0.C;
        c16.d(view, activity, activity, this$0.f441565h, this$0.f441567m);
    }

    private final void s0(boolean state) {
        String str;
        GdtAd gdtAd = this.mAd;
        if (gdtAd == null || (str = gdtAd.getTraceId()) == null) {
            str = "";
        }
        if (this.mAd == null || TextUtils.isEmpty(str)) {
            return;
        }
        f55484e0.put(str, Boolean.valueOf(state));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        GdtShakeLeftLayoutForQzone gdtShakeLeftLayoutForQzone;
        if (this.mIsShakeRightStyle) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.2f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
            this.mAdShakeRightGuideLightAnimation = translateAnimation;
            translateAnimation.setDuration(1000L);
            Animation animation = this.mAdShakeRightGuideLightAnimation;
            if (animation != null) {
                animation.setRepeatMode(-1);
            }
            ImageView imageView = this.mAdShakeRightGuideLight;
            if (imageView != null) {
                imageView.startAnimation(this.mAdShakeRightGuideLightAnimation);
            }
            Animation animation2 = this.mAdShakeRightGuideLightAnimation;
            if (animation2 != null) {
                animation2.setAnimationListener(new d());
            }
        }
        View view = this.mCurrentShakeLayout;
        if (view != null) {
            view.setVisibility(0);
        }
        if (!this.mIsShakeLeftStyle || (gdtShakeLeftLayoutForQzone = this.mShakeLeftGuideLayout) == null) {
            return;
        }
        gdtShakeLeftLayoutForQzone.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        if (this.mAd == null) {
            return;
        }
        LinearLayout linearLayout = this.mAdvShakeMaskLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.mCurrentShakeLayout;
        if (view != null) {
            view.setVisibility(8);
        }
        GdtAd gdtAd = this.mAd;
        ih.j.q(gdtAd != null ? gdtAd.getTraceId() : null);
        A0();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private final void v0() {
        GdtAd gdtAd = this.mAd;
        if (gdtAd != null) {
            if (ih.j.i(gdtAd != null ? gdtAd.getTraceId() : null)) {
                return;
            }
        }
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.register(BaseApplication.getContext());
        }
        long f16 = ih.j.f();
        Message message = new Message();
        message.what = 2;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendMessageDelayed(message, f16);
        }
        int e16 = ih.j.e(this.f441565h);
        if (!ih.j.n(this.f441565h) || e16 < 0) {
            return;
        }
        Message message2 = new Message();
        message2.what = 3;
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.sendMessageDelayed(message2, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0() {
        z0();
        if (this.mIsShakeRightStyle) {
            Z();
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(250L);
        View view = this.mCurrentShakeLayout;
        if (view != null) {
            view.startAnimation(alphaAnimation);
        }
        alphaAnimation.setAnimationListener(new e());
    }

    private final void x0() {
        if (QZoneAdFeedUtils.f55717a.U() && ih.j.l(this.f441565h)) {
            v0();
            LottieAnimationView lottieAnimationView = this.mAdvShakeGuideImageView;
            LottieDrawable lottieDrawable = (LottieDrawable) (lottieAnimationView != null ? lottieAnimationView.getDrawable() : null);
            if (lottieDrawable != null) {
                lottieDrawable.start();
            }
            LottieAnimationView lottieAnimationView2 = this.mAdvShakeMaskImageView;
            LottieDrawable lottieDrawable2 = (LottieDrawable) (lottieAnimationView2 != null ? lottieAnimationView2.getDrawable() : null);
            if (lottieDrawable2 != null) {
                lottieDrawable2.start();
            }
        }
    }

    private final void y0() {
        LottieAnimationView lottieAnimationView;
        LottieLoader lottieLoader;
        if (TextUtils.isEmpty(this.mShakeLottieUrl) || (lottieAnimationView = this.mAdvShakeGuideImageView) == null || (lottieLoader = this.mAdvShakeGuideLottieLoader) == null) {
            return;
        }
        String str = this.mShakeLottieUrl;
        lottieLoader.fromNetworkWithCacheBitmap(lottieAnimationView, str, LottieLoader.makeApolloZipPath(str + "guide"), true);
    }

    private final void z0() {
        LottieAnimationView lottieAnimationView;
        LottieLoader lottieLoader;
        if (TextUtils.isEmpty(this.mShakeLottieUrl) || (lottieAnimationView = this.mAdvShakeMaskImageView) == null || (lottieLoader = this.mAdvShakeMaskLottieLoader) == null) {
            return;
        }
        String str = this.mShakeLottieUrl;
        lottieLoader.fromNetworkWithCacheBitmap(lottieAnimationView, str, LottieLoader.makeApolloZipPath(str + "shaker"), true);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Object obj;
        String str;
        View view;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && this.f441562d != null) {
            if (!ih.j.l(businessFeedData)) {
                this.f441562d.setVisibility(8);
                return;
            }
            this.f441562d.setVisibility(0);
            String aid = QZoneAdFeedDataExtKt.getAid(this.f441565h);
            String traceId = QZoneAdFeedDataExtKt.getTraceId(this.f441565h);
            GdtAd gdtAd = this.mAd;
            if (gdtAd != null) {
                obj = Long.valueOf(gdtAd.getAId());
            } else {
                obj = "-2147483648";
            }
            GdtAd gdtAd2 = this.mAd;
            if (gdtAd2 == null || (str = gdtAd2.getTraceId()) == null) {
                str = "";
            }
            QLog.i("QZoneAdFeedShakeCaiDanPresenter", 2, "[onBindData]  aid:" + aid + " traceId:" + traceId + " oldAid:" + obj + " oldTraceId:" + str);
            if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
                QLog.e("QZoneAdFeedShakeCaiDanPresenter", 2, "[onBindData] ignore, is the same ad");
                return;
            }
            this.mIsShakeLeftStyle = Intrinsics.areEqual(QZoneAdFeedDataExtKt.shakeAdNewStyle(this.f441565h), "bottom_left");
            this.mIsShakeRightStyle = ih.j.m(this.f441565h);
            j0();
            if (this.mIsShakeRightStyle) {
                view = this.mAdShakeRightGuideLayout;
            } else if (this.mIsShakeLeftStyle) {
                view = this.mShakeLeftGuideLayout;
            } else {
                view = this.mAdvShakeGuideLayout;
            }
            this.mCurrentShakeLayout = view;
            this.mAd = GdtFeedUtilForQZone.E(this.f441565h);
            B0();
            return;
        }
        QLog.e("QZoneAdFeedShakeCaiDanPresenter", 1, "[onBindData] error, containerView is null");
    }

    @Override // vg.a
    public void B() {
        A0();
    }

    @Override // vg.a, vg.c
    public void c() {
        x0();
        C0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedShakeCaiDanPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        A0();
        this.mShakeSensor = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Y(this.mAdvShakeGuideImageView);
        Y(this.mAdvShakeMaskImageView);
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        if (ih.j.l(this.f441565h)) {
            ShakeCaiDanAdManager.c().g();
        }
        A0();
    }

    public final void r0() {
        this.mShakeScrollTime = System.currentTimeMillis();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nn5;
    }

    @Override // vg.a
    public void t(cf.b event) {
        super.t(event);
        if (event != null && QZoneAdFeedUtils.f55717a.I(event.f30766b, "event_key_qzone_ad_feed_video_current_duration")) {
            c0(event);
        }
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public void z() {
        x0();
        C0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(final m this$0, float f16, float f17, float f18, float f19) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ih.j.j(this$0.f441565h, this$0.mShakeStartTime)) {
            GdtAd gdtAd = this$0.mAd;
            if (gdtAd != null) {
                Intrinsics.checkNotNull(gdtAd);
                str = gdtAd.getTraceId();
            } else {
                str = "";
            }
            QLog.d("QZoneAdFeedShakeCaiDanPresenter", 1, "user shake in limit time, shield shake\uff0ctraceid \uff1a" + str);
            this$0.u0();
            return;
        }
        if (QZoneAdFeedUtils.f55717a.f(this$0.f441565h, this$0.f441563e, this$0.C, System.currentTimeMillis() - this$0.mShakeScrollTime)) {
            QLog.d("QZoneAdFeedShakeCaiDanPresenter", 1, "intercept tab, shield shake");
            GdtShakeSensor gdtShakeSensor = this$0.mShakeSensor;
            if (gdtShakeSensor != null) {
                gdtShakeSensor.reset();
                return;
            }
            return;
        }
        if (this$0.n0()) {
            ih.j.p(f16, f17, f18, f19, System.currentTimeMillis() - this$0.mShakeStartTime);
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.ad.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.q0(m.this);
                }
            });
        } else {
            GdtShakeSensor gdtShakeSensor2 = this$0.mShakeSensor;
            if (gdtShakeSensor2 != null) {
                gdtShakeSensor2.reset();
            }
        }
    }

    private final void Y(LottieAnimationView view) {
        LottieDrawable lottieDrawable = (LottieDrawable) (view != null ? view.getDrawable() : null);
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
        if (lottieDrawable != null) {
            lottieDrawable.removeAllUpdateListeners();
        }
        if (lottieDrawable != null) {
            lottieDrawable.clearComposition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(boolean animate) {
        boolean z16 = false;
        if (animate) {
            LinearLayout linearLayout = this.mAdvShakeMaskLayout;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(250L);
                LinearLayout linearLayout2 = this.mAdvShakeMaskLayout;
                if (linearLayout2 != null) {
                    linearLayout2.startAnimation(alphaAnimation);
                }
                alphaAnimation.setAnimationListener(new b());
            }
        } else {
            if (!this.mIsShakeRightStyle) {
                View view = this.mCurrentShakeLayout;
                if (view != null) {
                    view.clearAnimation();
                }
                View view2 = this.mCurrentShakeLayout;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
            LinearLayout linearLayout3 = this.mAdvShakeMaskLayout;
            if (linearLayout3 != null) {
                linearLayout3.clearAnimation();
            }
            LinearLayout linearLayout4 = this.mAdvShakeMaskLayout;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(4);
            }
        }
        y0();
    }

    @Override // vg.a
    protected void C(View containerView) {
        if (containerView == null) {
            QLog.e("QZoneAdFeedShakeCaiDanPresenter", 1, "[onInitView] error, containerView is null");
            return;
        }
        f0();
        e0();
        g0();
        k0();
    }
}
