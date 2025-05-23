package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0016\u0010\u0018\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010.R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0017R\u0016\u00103\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0017R\u0016\u00105\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0017R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "", "initViewModel", "initData", "Gh", "Lcom/tencent/gdtad/basics/motivebrowsing/v;", "browsingData", "Eh", "Kh", "Ih", "Hh", "Jh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "onResume", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "doOnBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "Z", "hasCountDownComplete", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "D", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "viewModel", "Lcom/tencent/mobileqq/mvvm/d;", "E", "Lcom/tencent/mobileqq/mvvm/d;", "lifeCycleFragment", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mQQCustomDialog", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "G", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mModel", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "H", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "titleContainer", "", "I", "countDownTime", "J", "isSuccess", "K", "isError", "L", "mIsReportLoadingFinishEvent", "Landroid/os/ResultReceiver;", "M", "Landroid/os/ResultReceiver;", "mResultReceiver", "<init>", "()V", "N", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtMotiveBrowsingFragment extends WebViewFragment {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasCountDownComplete;

    /* renamed from: D, reason: from kotlin metadata */
    private GdtMotiveBrowsingViewModel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.mvvm.d lifeCycleFragment;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mQQCustomDialog;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GdtMotiveVideoModel mModel;

    /* renamed from: H, reason: from kotlin metadata */
    private GdtMotiveBrowsingTitle titleContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private int countDownTime;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isSuccess;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isError;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsReportLoadingFinishEvent;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ResultReceiver mResultReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;", "data", "Landroid/content/Intent;", "intent", "Landroid/os/ResultReceiver;", "resultReceiver", "", "a", "", "COUNT_DOWN_TOTAL_SECOND", "I", "", "KEY_MOTIVE_BROWSING", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity activity, @NotNull GdtMotiveVideoPageData data, @NotNull Intent intent, @Nullable ResultReceiver resultReceiver) {
            String str;
            String str2;
            String str3;
            Long l3;
            String str4;
            String str5;
            List<String> appMarketPackageName;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(intent, "intent");
            GdtMotiveVideoModel gdtMotiveVideoModel = new GdtMotiveVideoModel(data);
            intent.putExtra("fragment_class", GdtMotiveBrowsingFragment.class.getCanonicalName());
            GdtAd gdtAd = gdtMotiveVideoModel.getGdtAd();
            String[] strArr = null;
            if (gdtAd != null) {
                str = gdtAd.getUrlForLandingPage();
            } else {
                str = null;
            }
            intent.putExtra("url", str);
            intent.putExtra("isTransparentTitle", true);
            GdtAd gdtAd2 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd2 != null) {
                str2 = gdtAd2.getTraceId();
            } else {
                str2 = null;
            }
            intent.putExtra("WebReport_TRACE_ID", str2);
            GdtAd gdtAd3 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd3 != null) {
                str3 = gdtAd3.getUrlForAction();
            } else {
                str3 = null;
            }
            intent.putExtra("WebReport_ACTION_URL", str3);
            GdtAd gdtAd4 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd4 != null) {
                l3 = Long.valueOf(gdtAd4.getAId());
            } else {
                l3 = null;
            }
            intent.putExtra("WebReport_AD_ID", l3);
            GdtAd gdtAd5 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd5 != null) {
                str4 = gdtAd5.getPosId();
            } else {
                str4 = null;
            }
            intent.putExtra("WebReport_POS_ID", str4);
            intent.putExtra("WebReport_IS_H5", true);
            intent.putExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
            GdtAd gdtAd6 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd6 != null) {
                str5 = gdtAd6.getAppMarketDeeplink();
            } else {
                str5 = null;
            }
            intent.putExtra("app_market_deeplink", str5);
            GdtAd gdtAd7 = gdtMotiveVideoModel.getGdtAd();
            if (gdtAd7 != null && (appMarketPackageName = gdtAd7.getAppMarketPackageName()) != null) {
                Object[] array = appMarketPackageName.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                strArr = (String[]) array;
            }
            intent.putExtra("app_market_package_name", strArr);
            intent.putExtra("result_receiver", resultReceiver);
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\bH\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "onPageFinished", "", "errorCode", "description", "failingUrl", "onReceivedError", "", "shouldOverrideUrlLoading", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "onFinalState", "newProgress", "onProgressChanged", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            super.onFinalState(extraData);
            GdtMotiveBrowsingFragment.this.Gh();
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            super.onPageFinished(view, url);
            if (!GdtMotiveBrowsingFragment.this.isError) {
                GdtMotiveBrowsingFragment.this.isSuccess = true;
                if (!GdtMotiveBrowsingFragment.this.mIsReportLoadingFinishEvent) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020036);
                    GdtMotiveBrowsingFragment.this.mIsReportLoadingFinishEvent = true;
                }
            }
            GdtMotiveBrowsingFragment.this.isError = false;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onProgressChanged(@Nullable WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress >= 50) {
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = GdtMotiveBrowsingFragment.this.viewModel;
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel2 = null;
                if (gdtMotiveBrowsingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    gdtMotiveBrowsingViewModel = null;
                }
                l mGdtMotiveBrowsingExperimentReportHelper = gdtMotiveBrowsingViewModel.getMGdtMotiveBrowsingExperimentReportHelper();
                TouchWebView touchWebView = ((WebViewFragment) GdtMotiveBrowsingFragment.this).webView;
                GdtMotiveVideoModel gdtMotiveVideoModel = GdtMotiveBrowsingFragment.this.mModel;
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel3 = GdtMotiveBrowsingFragment.this.viewModel;
                if (gdtMotiveBrowsingViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    gdtMotiveBrowsingViewModel2 = gdtMotiveBrowsingViewModel3;
                }
                mGdtMotiveBrowsingExperimentReportHelper.e(touchWebView, gdtMotiveVideoModel, gdtMotiveBrowsingViewModel2);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedError(@Nullable WebView view, int errorCode, @Nullable String description, @Nullable String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            GdtMotiveBrowsingFragment.this.isError = true;
            GdtMotiveBrowsingFragment.this.isSuccess = false;
            if (!GdtMotiveBrowsingFragment.this.mIsReportLoadingFinishEvent) {
                GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020037);
                GdtMotiveBrowsingFragment.this.mIsReportLoadingFinishEvent = true;
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public boolean shouldOverrideUrlLoading(@Nullable WebView view, @Nullable String url) {
            if (QLog.isColorLevel()) {
                QLog.d("GdtMotiveBrowsingFragment", 2, "shouldOverrideUrlLoading " + url);
            }
            if (!((WebViewFragment) GdtMotiveBrowsingFragment.this).isDestroyed && ((WebViewFragment) GdtMotiveBrowsingFragment.this).webView != null && url != null) {
                GdtMotiveBrowsingFragment gdtMotiveBrowsingFragment = GdtMotiveBrowsingFragment.this;
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = gdtMotiveBrowsingFragment.viewModel;
                if (gdtMotiveBrowsingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    gdtMotiveBrowsingViewModel = null;
                }
                if (!gdtMotiveBrowsingViewModel.c2(url, gdtMotiveBrowsingFragment.mModel)) {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(MotiveBrowsingData browsingData) {
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData browsingData: " + browsingData);
        }
        int event = browsingData.getEvent();
        String script = browsingData.getScript();
        int leftSecond = browsingData.getLeftSecond();
        if (event != 0) {
            boolean z16 = true;
            if (event == 1) {
                if (leftSecond > 0) {
                    z16 = false;
                }
                this.hasCountDownComplete = z16;
                if (this.titleContainer == null) {
                    Gh();
                }
                GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle = this.titleContainer;
                if (gdtMotiveBrowsingTitle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                    gdtMotiveBrowsingTitle = null;
                }
                gdtMotiveBrowsingTitle.f(leftSecond);
                return;
            }
            return;
        }
        this.webView.evaluateJavascript(script, new ValueCallback() { // from class: com.tencent.gdtad.basics.motivebrowsing.m
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                GdtMotiveBrowsingFragment.Fh((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData EVENT_CALL_BACK_JS callback " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        ViewGroup viewGroup;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle(qBaseActivity);
        this.titleContainer = gdtMotiveBrowsingTitle;
        gdtMotiveBrowsingTitle.setOnCloseClickListener(new GdtMotiveBrowsingFragment$initTitle$1(this));
        ViewGroup viewGroup2 = getUIStyleHandler().V;
        ViewGroup viewGroup3 = null;
        if (viewGroup2 != null && (viewGroup = (ViewGroup) viewGroup2.findViewById(R.id.l2a)) != null) {
            GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle2 = this.titleContainer;
            if (gdtMotiveBrowsingTitle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
                gdtMotiveBrowsingTitle2 = null;
            }
            viewGroup.addView(gdtMotiveBrowsingTitle2);
        }
        int dip2px = ViewUtils.dip2px(63.0f);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            dip2px += ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setPadding(0, dip2px, 0, 0);
        }
        SwiftIphoneTitleBarUI swiftTitleUI = getSwiftTitleUI();
        if (swiftTitleUI != null) {
            viewGroup3 = swiftTitleUI.M;
        }
        if (viewGroup3 != null) {
            viewGroup3.setVisibility(8);
        }
        ImmersiveUtils.clearCoverForStatus(getQBaseActivity().getWindow(), true);
        ImmersiveUtils.setStatusTextColor(true, getQBaseActivity().getWindow());
    }

    private final void Hh() {
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick onCancel");
        }
        Jh();
        super.doOnBackEvent();
    }

    private final void Ih() {
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick confirm");
        }
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mQQCustomDialog = null;
    }

    private final void Jh() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        String str;
        List split$default;
        String str2;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        if (QLog.isColorLevel()) {
            QLog.d("GdtMotiveBrowsingFragment", 2, "sendRewardedCallback");
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.mModel;
        if (gdtMotiveVideoModel != null && (gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData()) != null && (str = gdtMotiveVideoPageData.motiveBrowsingKey) != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty()) {
                Intent intent = new Intent((String) split$default.get(0));
                intent.putExtra(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, this.countDownTime * 1000);
                intent.putExtra("elapsed_time", this.countDownTime * 1000);
                intent.putExtra("profitable_flag", this.hasCountDownComplete);
                GdtMotiveVideoModel gdtMotiveVideoModel2 = this.mModel;
                if (gdtMotiveVideoModel2 != null && (gdtMotiveVideoPageData2 = gdtMotiveVideoModel2.getGdtMotiveVideoPageData()) != null) {
                    str2 = gdtMotiveVideoPageData2.getAsyncCallbackId();
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "mModel?.gdtMotiveVideoPa\u2026ta?.asyncCallbackId ?: \"\"");
                }
                intent.putExtra("arg_callback", str2);
                intent.putExtra("KEY_MOTIVE_BROWSING", str);
                getQBaseActivity().sendBroadcast(intent);
                ResultReceiver resultReceiver = this.mResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(-1, intent.getExtras());
                }
            }
        }
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020025);
    }

    private final void Kh() {
        View view;
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getQBaseActivity(), 0, (String) null, getResources().getString(R.string.f1378207w, Integer.valueOf(this.countDownTime)), getResources().getString(R.string.f1377907t), getResources().getString(R.string.f1378007u), new DialogInterface.OnClickListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GdtMotiveBrowsingFragment.Lh(GdtMotiveBrowsingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GdtMotiveBrowsingFragment.Mh(GdtMotiveBrowsingFragment.this, dialogInterface, i3);
            }
        });
        this.mQQCustomDialog = createCustomDialog;
        if (createCustomDialog != null) {
            createCustomDialog.show();
            Window window = createCustomDialog.getWindow();
            GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = null;
            if (window != null) {
                view = window.getDecorView();
            } else {
                view = null;
            }
            if (view != null) {
                view.setSystemUiVisibility(7942);
            }
            GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel2 = this.viewModel;
            if (gdtMotiveBrowsingViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                gdtMotiveBrowsingViewModel = gdtMotiveBrowsingViewModel2;
            }
            gdtMotiveBrowsingViewModel.d2();
        }
        QQCustomDialog qQCustomDialog2 = this.mQQCustomDialog;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.p
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GdtMotiveBrowsingFragment.Nh(GdtMotiveBrowsingFragment.this, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(GdtMotiveBrowsingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(GdtMotiveBrowsingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(GdtMotiveBrowsingFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = this$0.viewModel;
        if (gdtMotiveBrowsingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            gdtMotiveBrowsingViewModel = null;
        }
        gdtMotiveBrowsingViewModel.h2();
    }

    private final void initData() {
        Serializable serializableExtra = this.intent.getSerializableExtra("data");
        if (!(serializableExtra instanceof GdtMotiveVideoPageData)) {
            getQBaseActivity().finish();
            return;
        }
        try {
            this.mModel = new GdtMotiveVideoModel((GdtMotiveVideoPageData) GdtMotiveVideoPageData.class.cast(serializableExtra));
            GdtADFlyingStreamingReportHelper.getInstance().init(this.mModel);
            int rewardTime = GdtUtil.getRewardTime(this.mModel);
            if (rewardTime <= 0) {
                rewardTime = 15;
            }
            this.countDownTime = rewardTime;
            GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = this.viewModel;
            GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel2 = null;
            if (gdtMotiveBrowsingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                gdtMotiveBrowsingViewModel = null;
            }
            gdtMotiveBrowsingViewModel.U1(this.countDownTime);
            com.tencent.mobileqq.mvvm.d dVar = this.lifeCycleFragment;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
                dVar = null;
            }
            GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel3 = this.viewModel;
            if (gdtMotiveBrowsingViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                gdtMotiveBrowsingViewModel2 = gdtMotiveBrowsingViewModel3;
            }
            com.tencent.gdtad.basics.motivebrowsing.b.b(dVar, gdtMotiveBrowsingViewModel2.a2(), new GdtMotiveBrowsingFragment$initData$1(this));
        } catch (Throwable th5) {
            QLog.d("GdtMotiveBrowsingFragment", 1, th5, new Object[0]);
        }
        ResultReceiver resultReceiver = (ResultReceiver) this.intent.getParcelableExtra("result_receiver");
        if (resultReceiver != null) {
            this.mResultReceiver = resultReceiver;
        }
    }

    private final void initViewModel() {
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(getActivity());
        Intrinsics.checkNotNullExpressionValue(checkAndAddLifeCycleFragment, "api(ILifeCycleFragmentIn\u2026feCycleFragment(activity)");
        this.lifeCycleFragment = checkAndAddLifeCycleFragment;
        if (checkAndAddLifeCycleFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
            checkAndAddLifeCycleFragment = null;
        }
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(checkAndAddLifeCycleFragment).get(GdtMotiveBrowsingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(life\u2026ingViewModel::class.java)");
        this.viewModel = (GdtMotiveBrowsingViewModel) viewModel;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020026);
        if (!this.hasCountDownComplete) {
            Kh();
            return;
        }
        Jh();
        super.doOnBackEvent();
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020043);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        initViewModel();
        initData();
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020033);
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020006);
        return doOnCreate;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public com.tencent.mobileqq.webview.swift.utils.t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mQQCustomDialog = null;
        GdtADFlyingStreamingReportHelper.getInstance().onDestroy();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.setRequestedOrientation(1);
        }
    }
}
