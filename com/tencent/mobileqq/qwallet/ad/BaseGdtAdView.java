package com.tencent.mobileqq.qwallet.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 w2\u00020\u00012\u00020\u0002:\u0002xyB1\b\u0007\u0012\u0006\u0010p\u001a\u00020o\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q\u0012\b\b\u0002\u0010s\u001a\u00020\u0016\u0012\b\b\u0002\u0010t\u001a\u00020\u0016\u00a2\u0006\u0004\bu\u0010vJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0014J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u000bH\u0014J#\u0010\u001f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010#\u001a\u00020\u0005J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0007J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0007J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0007J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0007J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0007J\b\u0010+\u001a\u00020\u0016H%J\b\u0010,\u001a\u00020\u0016H%J\b\u0010-\u001a\u00020\u0016H%J\b\u0010.\u001a\u00020\u0016H%J\b\u0010/\u001a\u00020\u0016H%J\b\u00100\u001a\u00020\u0016H%J\b\u00101\u001a\u00020\u0016H%R\"\u00109\u001a\u0002028\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010I\u001a\u00020B8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010KR\u0016\u0010N\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010DR\"\u0010R\u001a\u00020B8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bO\u0010D\u001a\u0004\bP\u0010F\"\u0004\bQ\u0010HR$\u0010Z\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010b\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010j\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010m\u00a8\u0006z"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "clickParams", "", "Y0", "", "picUrl", "", "h1", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "i1", "G0", "Z0", "", "L0", "onFinishInflate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "d1", "", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Lcom/tencent/mobileqq/qwallet/ad/MediaType;", "T0", "lastExposureTime", "H0", "(Lcom/tencent/gdtad/aditem/GdtAd;Ljava/lang/Long;)V", "k1", "l1", "c1", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Q0", "S0", "X0", "N0", "U0", "V0", "P0", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "R0", "()Landroid/widget/RelativeLayout;", "p1", "(Landroid/widget/RelativeLayout;)V", "mediaContainer", "Landroid/view/View;", "e", "Landroid/view/View;", "W0", "()Landroid/view/View;", ICustomDataEditor.STRING_PARAM_1, "(Landroid/view/View;)V", "negativeFeedback", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "M0", "()Landroid/widget/TextView;", "m1", "(Landroid/widget/TextView;)V", "description", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "merchantLogo", "i", "merchantName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O0", "o1", "jumpBtn", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "getAdEventCallback", "()Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "setAdEventCallback", "(Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;)V", "adEventCallback", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "D", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "negativeFeedbackListener", "Lcom/tencent/mobileqq/qwallet/ad/p;", "E", "Lcom/tencent/mobileqq/qwallet/ad/p;", "gdtVideoWrapper", "Lcom/tencent/mobileqq/qwallet/ad/QWalletAdExposureChecker;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qwallet/ad/QWalletAdExposureChecker;", "customExposureChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "G", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "exposureCheckerCallback", "Lcom/tencent/mobileqq/qwallet/ad/QWalletAdExposureChecker$b;", "H", "Lcom/tencent/mobileqq/qwallet/ad/QWalletAdExposureChecker$b;", "checkerTimerTickCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "I", "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class BaseGdtAdView extends ConstraintLayout implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a adEventCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener negativeFeedbackListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private p gdtVideoWrapper;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QWalletAdExposureChecker customExposureChecker;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback exposureCheckerCallback;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QWalletAdExposureChecker.b checkerTimerTickCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected RelativeLayout mediaContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View negativeFeedback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected TextView description;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView merchantLogo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView merchantName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected TextView jumpBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "", "Lcom/tencent/mobileqq/qwallet/ad/AdEvent;", "event", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull AdEvent event);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f277020a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.UNSUPPORTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f277020a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void G0() {
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.x();
        }
        R0().removeAllViews();
    }

    public static /* synthetic */ void I0(BaseGdtAdView baseGdtAdView, GdtAd gdtAd, Long l3, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                l3 = 0L;
            }
            baseGdtAdView.H0(gdtAd, l3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doExposureReport");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(BaseGdtAdView this$0, GdtAd gdtAd, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l1(gdtAd);
        a aVar = this$0.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.STRICT_EXPOSURE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(BaseGdtAdView this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.adEventCallback;
        if (aVar != null) {
            AdEvent adEvent = AdEvent.EXPOSURE_TIMER_TICK;
            adEvent.setParam(Long.valueOf(j3));
            aVar.a(adEvent);
        }
    }

    private final long L0(GdtAd gdtAd) {
        p pVar;
        Long u16;
        if (gdtAd == null || T0(gdtAd) != MediaType.VIDEO || (pVar = this.gdtVideoWrapper) == null || (u16 = pVar.u()) == null) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return u16.longValue();
    }

    private final void Y0(GdtHandler.Params clickParams) {
        QWalletAdExposureChecker.G(getContext(), clickParams.f108486ad, new mqq.util.WeakReference(this.exposureCheckerCallback));
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.w();
        }
        clickParams.videoCeilingSupportedIfNotInstalled = true;
        clickParams.videoStartPositionMillis = L0(clickParams.f108486ad);
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(clickParams);
        a aVar = this.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.TO_LANDING_PAGE);
        }
    }

    private final boolean Z0() {
        return ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_AD_CONTENT_DISABLE_CLICK, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(BaseGdtAdView this$0, AdFeedbackDialogFragment.Result result) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (result != null && result.action == 3) {
            z16 = true;
        }
        if (z16) {
            p pVar = this$0.gdtVideoWrapper;
            if (pVar != null) {
                pVar.x();
            }
            a aVar = this$0.adEventCallback;
            if (aVar != null) {
                aVar.a(AdEvent.DISMISS);
            }
        }
        if (result != null) {
            num = Integer.valueOf(result.action);
        } else {
            num = null;
        }
        QLog.d("BaseGdtAdView", 1, "negative button open result: " + num + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(BaseGdtAdView this$0) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this$0);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(BaseGdtAdView this$0, GdtHandler.Params clickParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickParams, "$clickParams");
        a aVar = this$0.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.CLICK);
        }
        this$0.Y0(clickParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(BaseGdtAdView this$0, GdtHandler.Params clickParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickParams, "$clickParams");
        a aVar = this$0.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.CLICK);
        }
        if (!this$0.Z0()) {
            this$0.Y0(clickParams);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(Activity activity, BaseGdtAdView this$0, GdtAd gdtAd, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new mqq.util.WeakReference(activity);
        adFeedbackParams.listener = new mqq.util.WeakReference(this$0.negativeFeedbackListener);
        adFeedbackParams.f61346ad = gdtAd;
        adFeedbackParams.styleId = 0;
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("BaseGdtAdView", 1, "renderAdInfo", th5);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h1(String picUrl) {
        boolean z16;
        boolean isBlank;
        if (picUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(picUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                G0();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                R0().addView(imageView);
                ColorDrawable colorDrawable = new ColorDrawable(0);
                imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(picUrl, colorDrawable, colorDrawable));
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean i1(GdtAd gdtAd) {
        boolean z16;
        boolean isBlank;
        String videoUrl = gdtAd.getVideoUrl();
        if (videoUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(videoUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                G0();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.gdtVideoWrapper = new p(context, R0(), gdtAd);
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void H0(@Nullable final GdtAd gdtAd, @Nullable Long lastExposureTime) {
        long j3;
        if (gdtAd == null) {
            return;
        }
        k1(gdtAd);
        a aVar = this.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.ORIGINAL_EXPOSURE);
        }
        this.exposureCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.qwallet.ad.f
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                BaseGdtAdView.J0(BaseGdtAdView.this, gdtAd, weakReference);
            }
        };
        this.checkerTimerTickCallback = new QWalletAdExposureChecker.b() { // from class: com.tencent.mobileqq.qwallet.ad.g
            @Override // com.tencent.mobileqq.qwallet.ad.QWalletAdExposureChecker.b
            public final void a(long j16) {
                BaseGdtAdView.K0(BaseGdtAdView.this, j16);
            }
        };
        if (lastExposureTime != null) {
            j3 = lastExposureTime.longValue();
        } else {
            j3 = 0;
        }
        QWalletAdExposureChecker qWalletAdExposureChecker = new QWalletAdExposureChecker(gdtAd, j3, new mqq.util.WeakReference(this));
        qWalletAdExposureChecker.I(new mqq.util.WeakReference(this.exposureCheckerCallback));
        qWalletAdExposureChecker.J(new mqq.util.WeakReference(this.checkerTimerTickCallback));
        qWalletAdExposureChecker.N();
        this.customExposureChecker = qWalletAdExposureChecker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView M0() {
        TextView textView = this.description;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("description");
        return null;
    }

    @IdRes
    protected abstract int N0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextView O0() {
        TextView textView = this.jumpBtn;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jumpBtn");
        return null;
    }

    @IdRes
    protected abstract int P0();

    @LayoutRes
    protected abstract int Q0();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RelativeLayout R0() {
        RelativeLayout relativeLayout = this.mediaContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaContainer");
        return null;
    }

    @IdRes
    protected abstract int S0();

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r4 != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected MediaType T0(@NotNull GdtAd gdtAd) {
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        String videoUrl = gdtAd.getVideoUrl();
        boolean z17 = false;
        if (videoUrl != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(videoUrl);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    return MediaType.VIDEO;
                }
                String basic_img = gdtAd.getBasic_img();
                if (basic_img != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(basic_img);
                }
                z17 = true;
                if (!z17) {
                    return MediaType.IMAGE;
                }
                return MediaType.UNSUPPORTED;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @IdRes
    protected abstract int U0();

    @IdRes
    protected abstract int V0();

    @NotNull
    protected final View W0() {
        View view = this.negativeFeedback;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("negativeFeedback");
        return null;
    }

    @IdRes
    protected abstract int X0();

    public final void c1() {
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.A();
        }
    }

    public final boolean d1(@Nullable final GdtAd gdtAd, @Nullable final Activity activity) {
        boolean h16;
        if (activity == null || gdtAd == null) {
            return false;
        }
        int i3 = c.f277020a[T0(gdtAd).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    h16 = false;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                h16 = i1(gdtAd);
            }
        } else {
            h16 = h1(gdtAd.getBasic_img());
        }
        if (!h16) {
            return false;
        }
        a aVar = this.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.RENDERED);
        }
        M0().setText(gdtAd.getText());
        TextView textView = this.merchantName;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("merchantName");
            textView = null;
        }
        textView.setText(gdtAd.getAdvertiser_corporate_image_name());
        final GdtHandler.Params params = new GdtHandler.Params();
        params.processId = MobileQQ.sProcessId;
        params.f108486ad = gdtAd;
        params.activity = new mqq.util.WeakReference(activity);
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_zf_qianbao");
        params.extra = bundle;
        O0().setText(gdtAd.getButtonText(GdtHandler.canLaunchApp(params)));
        O0().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.ad.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGdtAdView.e1(BaseGdtAdView.this, params, view);
            }
        });
        ColorDrawable colorDrawable = new ColorDrawable(0);
        ImageView imageView2 = this.merchantLogo;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("merchantLogo");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(gdtAd.getAdvertiser_corporate_logo(), colorDrawable, colorDrawable));
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.ad.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGdtAdView.f1(BaseGdtAdView.this, params, view);
            }
        });
        W0().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.ad.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseGdtAdView.g1(activity, this, gdtAd, view);
            }
        });
        return true;
    }

    public void k1(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        QLog.i("BaseGdtAdView", 1, "reportOriginalExposure traceId=" + gdtAd.getTraceId());
        GdtOriginalExposureReporter.reportOriginalExposure(gdtAd, getContext());
    }

    public void l1(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        QLog.i("BaseGdtAdView", 1, "reportStrictExposure traceId=" + gdtAd.getTraceId());
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).doCgiReport(gdtAd.getUrlForImpression());
    }

    protected final void m1(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.description = textView;
    }

    protected final void o1(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.jumpBtn = textView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onDestroy: ");
        QWalletAdExposureChecker qWalletAdExposureChecker = this.customExposureChecker;
        if (qWalletAdExposureChecker != null) {
            qWalletAdExposureChecker.D();
        }
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), Q0(), this);
        View findViewById = findViewById(S0());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(getMediaContainerId())");
        p1((RelativeLayout) findViewById);
        View findViewById2 = findViewById(X0());
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(getNegativeFeedbackId())");
        s1(findViewById2);
        View findViewById3 = findViewById(N0());
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(getDescriptionId())");
        m1((TextView) findViewById3);
        View findViewById4 = findViewById(U0());
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(getMerchantLogoId())");
        this.merchantLogo = (ImageView) findViewById4;
        View findViewById5 = findViewById(V0());
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(getMerchantNameId())");
        this.merchantName = (TextView) findViewById5;
        View findViewById6 = findViewById(P0());
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(getJumpBtnId())");
        o1((TextView) findViewById6);
        post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.ad.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseGdtAdView.b1(BaseGdtAdView.this);
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onPause: ");
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.y();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onResume: ");
        p pVar = this.gdtVideoWrapper;
        if (pVar != null) {
            pVar.z();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        a aVar;
        super.onSizeChanged(w3, h16, oldw, oldh);
        if (w3 != 0 && h16 != 0 && (aVar = this.adEventCallback) != null) {
            aVar.a(AdEvent.VIEW_LAYOUT);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QWalletAdExposureChecker qWalletAdExposureChecker = this.customExposureChecker;
        if (qWalletAdExposureChecker != null) {
            qWalletAdExposureChecker.F();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        QWalletAdExposureChecker qWalletAdExposureChecker = this.customExposureChecker;
        if (qWalletAdExposureChecker != null) {
            qWalletAdExposureChecker.E();
        }
    }

    protected final void p1(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.mediaContainer = relativeLayout;
    }

    protected final void s1(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.negativeFeedback = view;
    }

    public final void setAdEventCallback(@Nullable a aVar) {
        this.adEventCallback = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BaseGdtAdView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.negativeFeedbackListener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.qwallet.ad.a
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                BaseGdtAdView.a1(BaseGdtAdView.this, result);
            }
        };
    }
}
