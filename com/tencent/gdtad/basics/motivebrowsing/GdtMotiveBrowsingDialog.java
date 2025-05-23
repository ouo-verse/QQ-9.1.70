package com.tencent.gdtad.basics.motivebrowsing;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.GdtWebViewProxy;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u007fB\u0011\b\u0016\u0012\u0006\u0010|\u001a\u00020{\u00a2\u0006\u0004\b}\u0010~J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!J\b\u0010$\u001a\u00020\u0004H\u0016J\u0006\u0010%\u001a\u00020\u0004J\b\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0004H\u0014J\b\u0010+\u001a\u00020\u0004H\u0014J\u000e\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,J\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202R\u0016\u00107\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010KR\u0018\u0010a\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0018\u0010f\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010LR\u0016\u0010j\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010LR\u0016\u0010l\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010LR\u0016\u0010n\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010LR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0014\u0010z\u001a\u00020w8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bx\u0010y\u00a8\u0006\u0080\u0001"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "", "initView", "m0", "r0", "n0", "Lcom/tencent/gdtad/basics/motivebrowsing/v;", "browsingData", "k0", "D0", "w0", "u0", "A0", "Landroidx/lifecycle/Lifecycle$Event;", "event", "g0", "s0", "", "actionType", "", TianShuMMKVConstant.UserActionKey.ACTION_TIME, "z0", "y0", "clickButton", "x0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "titlePart", "j0", "onBackPressed", "i0", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "onStart", DKHippyEvent.EVENT_STOP, "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mode", "B0", "Landroid/content/Intent;", "intent", "setIntent", "Landroid/os/ResultReceiver;", "resultReceiver", "C0", BdhLogUtil.LogTag.Tag_Conn, "Landroid/app/Activity;", "mActivity", "D", "Landroid/view/View;", "mRootView", "Lcom/tencent/biz/ui/TouchWebView;", "E", "Lcom/tencent/biz/ui/TouchWebView;", "mWebView", "Lcom/tencent/gdtad/inject/IGdtWebView;", UserInfo.SEX_FEMALE, "Lcom/tencent/gdtad/inject/IGdtWebView;", "mWebViewBuilder", "Landroidx/lifecycle/LifecycleRegistry;", "G", "Landroidx/lifecycle/LifecycleRegistry;", "mLifecycleRegistry", "H", "Landroidx/lifecycle/ViewModelStore;", "mViewModelStore", "", "I", "Z", "hasCountDownComplete", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "J", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "viewModel", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "K", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mQQCustomDialog", "L", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mModel", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "M", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "titleContainer", "N", "countDownTime", "P", "Landroid/content/Intent;", "mIntent", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mSavedActivityIntent", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/ResultReceiver;", "mResultReceiver", ExifInterface.LATITUDE_SOUTH, "isSuccess", "T", "isError", "U", "isReportAchieveReward", "V", "mIsReportLoadingFinishEvent", "Lcom/tencent/gdtad/inject/GdtWebViewProxy;", "W", "Lcom/tencent/gdtad/inject/GdtWebViewProxy;", "mGdtWebViewProxy", "Lcom/tencent/gdtad/basics/motivevideo/report/d;", "X", "Lcom/tencent/gdtad/basics/motivevideo/report/d;", "mMiniAppReportHelper", "Lcom/tencent/gdtad/basics/motivevideo/report/c;", "Y", "Lcom/tencent/gdtad/basics/motivevideo/report/c;", "mInnerClickReportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtMotiveBrowsingDialog extends ReportDialog implements LifecycleOwner, ViewModelStoreOwner {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Activity mActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TouchWebView mWebView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IGdtWebView mWebViewBuilder;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private LifecycleRegistry mLifecycleRegistry;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ViewModelStore mViewModelStore;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hasCountDownComplete;

    /* renamed from: J, reason: from kotlin metadata */
    private GdtMotiveBrowsingViewModel viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private QQCustomDialog mQQCustomDialog;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private GdtMotiveVideoModel mModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private GdtMotiveBrowsingTitle titleContainer;

    /* renamed from: N, reason: from kotlin metadata */
    private int countDownTime;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Intent mIntent;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Intent mSavedActivityIntent;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ResultReceiver mResultReceiver;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isSuccess;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isError;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isReportAchieveReward;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mIsReportLoadingFinishEvent;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private GdtWebViewProxy mGdtWebViewProxy;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private com.tencent.gdtad.basics.motivevideo.report.d mMiniAppReportHelper;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.gdtad.basics.motivevideo.report.c mInnerClickReportHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;", "data", "Landroid/content/Intent;", "intent", "Landroid/os/ResultReceiver;", "resultReceiver", "", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Activity activity, GdtMotiveVideoPageData data, Intent intent, ResultReceiver resultReceiver) {
            String[] strArr;
            String str;
            String str2;
            Long l3;
            List<String> appMarketPackageName;
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(intent, "$intent");
            try {
                GdtMotiveBrowsingDialog gdtMotiveBrowsingDialog = new GdtMotiveBrowsingDialog(activity);
                gdtMotiveBrowsingDialog.B0(new GdtMotiveVideoModel(data));
                GdtMotiveVideoModel gdtMotiveVideoModel = new GdtMotiveVideoModel(data);
                GdtAd gdtAd = gdtMotiveVideoModel.getGdtAd();
                String str3 = null;
                if (gdtAd != null && (appMarketPackageName = gdtAd.getAppMarketPackageName()) != null) {
                    Object[] array = appMarketPackageName.toArray(new String[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    strArr = (String[]) array;
                } else {
                    strArr = null;
                }
                intent.putExtra("app_market_package_name", strArr);
                GdtAd gdtAd2 = gdtMotiveVideoModel.getGdtAd();
                if (gdtAd2 != null) {
                    str = gdtAd2.getAppMarketDeeplink();
                } else {
                    str = null;
                }
                intent.putExtra("app_market_deeplink", str);
                GdtAd gdtAd3 = gdtMotiveVideoModel.getGdtAd();
                if (gdtAd3 != null) {
                    str2 = gdtAd3.getTraceId();
                } else {
                    str2 = null;
                }
                intent.putExtra("WebReport_TRACE_ID", str2);
                GdtAd gdtAd4 = gdtMotiveVideoModel.getGdtAd();
                if (gdtAd4 != null) {
                    l3 = Long.valueOf(gdtAd4.getAId());
                } else {
                    l3 = null;
                }
                intent.putExtra("WebReport_AD_ID", String.valueOf(l3));
                GdtAd gdtAd5 = gdtMotiveVideoModel.getGdtAd();
                if (gdtAd5 != null) {
                    str3 = gdtAd5.getPosId();
                }
                intent.putExtra("WebReport_POS_ID", str3);
                intent.putExtra("gdtMotiveBrowsing", true);
                gdtMotiveBrowsingDialog.setIntent(intent);
                if (resultReceiver != null) {
                    gdtMotiveBrowsingDialog.C0(resultReceiver);
                }
                gdtMotiveBrowsingDialog.show();
            } catch (Exception e16) {
                QLog.i("GdtMotiveBrowsingDialog", 1, "dialog.show()", e16);
            }
        }

        public final void b(@NotNull final Activity activity, @NotNull final GdtMotiveVideoPageData data, @NotNull final Intent intent, @Nullable final ResultReceiver resultReceiver) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(intent, "intent");
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivebrowsing.j
                @Override // java.lang.Runnable
                public final void run() {
                    GdtMotiveBrowsingDialog.Companion.c(activity, data, intent, resultReceiver);
                }
            });
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f108798d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GdtMotiveBrowsingDialog f108799e;

        b(ViewGroup viewGroup, GdtMotiveBrowsingDialog gdtMotiveBrowsingDialog) {
            this.f108798d = viewGroup;
            this.f108799e = gdtMotiveBrowsingDialog;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f108798d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            QLog.i("GdtMotiveBrowsingDialog", 1, "onGlobalLayout:" + this.f108799e.mRootView + " l=" + this.f108798d.getLeft() + ",t=" + this.f108798d.getTop() + ",r=" + this.f108798d.getRight() + ",b=" + this.f108798d.getBottom());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog$c", "Lcom/tencent/gdtad/inject/IGdtWebViewListener;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "errorCode", "", "description", "failingUrl", "", "onReceivedError", "webview", "url", "", "shouldOverrideUrlLoading", "newProgress", "onProgressChanged", "onPageFinished", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends IGdtWebViewListener {
        c() {
        }

        @Override // com.tencent.gdtad.inject.IGdtWebViewListener
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            if (!GdtMotiveBrowsingDialog.this.isError) {
                GdtMotiveBrowsingDialog.this.isSuccess = true;
                if (!GdtMotiveBrowsingDialog.this.mIsReportLoadingFinishEvent) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020036);
                    GdtMotiveBrowsingDialog.this.mIsReportLoadingFinishEvent = true;
                }
            }
            GdtMotiveBrowsingDialog.this.isError = false;
        }

        @Override // com.tencent.gdtad.inject.IGdtWebViewListener
        public void onProgressChanged(@Nullable WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress >= 50) {
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = GdtMotiveBrowsingDialog.this.viewModel;
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel2 = null;
                if (gdtMotiveBrowsingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    gdtMotiveBrowsingViewModel = null;
                }
                l mGdtMotiveBrowsingExperimentReportHelper = gdtMotiveBrowsingViewModel.getMGdtMotiveBrowsingExperimentReportHelper();
                TouchWebView touchWebView = GdtMotiveBrowsingDialog.this.mWebView;
                GdtMotiveVideoModel gdtMotiveVideoModel = GdtMotiveBrowsingDialog.this.mModel;
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel3 = GdtMotiveBrowsingDialog.this.viewModel;
                if (gdtMotiveBrowsingViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    gdtMotiveBrowsingViewModel2 = gdtMotiveBrowsingViewModel3;
                }
                mGdtMotiveBrowsingExperimentReportHelper.e(touchWebView, gdtMotiveVideoModel, gdtMotiveBrowsingViewModel2);
            }
        }

        @Override // com.tencent.gdtad.inject.IGdtWebViewListener
        public void onReceivedError(@NotNull WebView view, int errorCode, @NotNull String description, @NotNull String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
            QLog.i("GdtMotiveBrowsingDialog", 1, "onReceivedError url = " + errorCode + ",description = " + description + ",failingUrl = " + failingUrl);
            GdtMotiveBrowsingDialog.this.isError = true;
            GdtMotiveBrowsingDialog.this.isSuccess = false;
            if (!GdtMotiveBrowsingDialog.this.mIsReportLoadingFinishEvent) {
                GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020037);
                GdtMotiveBrowsingDialog.this.mIsReportLoadingFinishEvent = true;
            }
        }

        @Override // com.tencent.gdtad.inject.IGdtWebViewListener
        public boolean shouldOverrideUrlLoading(@NotNull WebView webview, @Nullable String url) {
            Intrinsics.checkNotNullParameter(webview, "webview");
            QLog.i("GdtMotiveBrowsingDialog", 1, "shouldOverrideUrlLoading " + url);
            if (url != null) {
                GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = GdtMotiveBrowsingDialog.this.viewModel;
                if (gdtMotiveBrowsingViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    gdtMotiveBrowsingViewModel = null;
                }
                if (gdtMotiveBrowsingViewModel.c2(url, GdtMotiveBrowsingDialog.this.mModel)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GdtMotiveBrowsingDialog(@NotNull Context context) {
        super(context, R.style.Theme.Black.NoTitleBar.Fullscreen);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mViewModelStore = new ViewModelStore();
        this.mGdtWebViewProxy = new GdtWebViewProxy();
        this.mMiniAppReportHelper = new com.tencent.gdtad.basics.motivevideo.report.d();
        this.mInnerClickReportHelper = new com.tencent.gdtad.basics.motivevideo.report.c();
        this.mActivity = (Activity) context;
    }

    private final void A0() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        String str;
        List split$default;
        String str2;
        GdtMotiveVideoPageData gdtMotiveVideoPageData2;
        QLog.i("GdtMotiveBrowsingDialog", 1, "sendRewardedCallback");
        GdtMotiveVideoModel gdtMotiveVideoModel = this.mModel;
        if (gdtMotiveVideoModel != null && (gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData()) != null && (str = gdtMotiveVideoPageData.motiveBrowsingKey) != null) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null);
            if (true ^ split$default.isEmpty()) {
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
                this.mActivity.sendBroadcast(intent);
                ResultReceiver resultReceiver = this.mResultReceiver;
                if (resultReceiver != null) {
                    resultReceiver.send(-1, intent.getExtras());
                }
            }
        }
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020025);
    }

    private final void D0() {
        GdtAd gdtAd;
        View view;
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        com.tencent.gdtad.basics.motivevideo.b bVar = com.tencent.gdtad.basics.motivevideo.b.f108898a;
        GdtMotiveVideoModel gdtMotiveVideoModel = this.mModel;
        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = null;
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        String b16 = bVar.b(gdtAd, this.countDownTime);
        if (TextUtils.isEmpty(b16)) {
            b16 = this.mActivity.getString(com.tencent.mobileqq.R.string.f1378207w, Integer.valueOf(this.countDownTime));
        }
        Activity activity = this.mActivity;
        q O = q.O(activity, activity.getRequestedOrientation(), b16, this.mActivity.getString(com.tencent.mobileqq.R.string.f1377907t), this.mActivity.getString(com.tencent.mobileqq.R.string.f1378007u), new DialogInterface.OnClickListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GdtMotiveBrowsingDialog.E0(GdtMotiveBrowsingDialog.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GdtMotiveBrowsingDialog.F0(GdtMotiveBrowsingDialog.this, dialogInterface, i3);
            }
        });
        this.mQQCustomDialog = O;
        if (O != null) {
            O.show();
            Window window = O.getWindow();
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
            x0(9);
        }
        QQCustomDialog qQCustomDialog2 = this.mQQCustomDialog;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.e
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    GdtMotiveBrowsingDialog.H0(GdtMotiveBrowsingDialog.this, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(GdtMotiveBrowsingDialog this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(GdtMotiveBrowsingDialog this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(GdtMotiveBrowsingDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = this$0.viewModel;
        if (gdtMotiveBrowsingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            gdtMotiveBrowsingViewModel = null;
        }
        gdtMotiveBrowsingViewModel.h2();
    }

    private final void g0(Lifecycle.Event event) {
        try {
            this.mLifecycleRegistry.handleLifecycleEvent(event);
        } catch (Throwable th5) {
            QLog.i("GdtMotiveBrowsingDialog", 1, "handleLifecycleEvent fail : event -> " + event, th5);
        }
    }

    private final void initView() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 28) {
            Intrinsics.checkNotNull(window);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        Intrinsics.checkNotNull(window);
        window.setFlags(1024, 1024);
        window.setVolumeControlStream(3);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) decorView;
        viewGroup.setSystemUiVisibility(7942);
        viewGroup.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.g
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i3) {
                GdtMotiveBrowsingDialog.o0(viewGroup, i3);
            }
        });
        View inflate = LayoutInflater.from(this.mActivity).inflate(com.tencent.mobileqq.R.layout.ect, viewGroup, false);
        this.mRootView = inflate;
        if (inflate == null) {
            QLog.i("GdtMotiveBrowsingDialog", 1, "mRootView == null");
            return;
        }
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.h
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                GdtMotiveBrowsingDialog.p0(GdtMotiveBrowsingDialog.this, dialogInterface);
            }
        });
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.gdtad.basics.motivebrowsing.i
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                GdtMotiveBrowsingDialog.q0(GdtMotiveBrowsingDialog.this, dialogInterface);
            }
        });
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new b(viewGroup, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(MotiveBrowsingData browsingData) {
        boolean z16;
        QLog.i("GdtMotiveBrowsingDialog", 1, "handleMotiveBrowsingData browsingData: " + browsingData);
        int event = browsingData.getEvent();
        String script = browsingData.getScript();
        int leftSecond = browsingData.getLeftSecond();
        if (event != 0) {
            if (event == 1) {
                if (leftSecond <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.hasCountDownComplete = z16;
                GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle = this.titleContainer;
                if (gdtMotiveBrowsingTitle != null) {
                    gdtMotiveBrowsingTitle.f(leftSecond);
                }
                if (!this.isReportAchieveReward && leftSecond <= 0) {
                    z0(2, NetConnInfoCenter.getServerTime());
                    this.isReportAchieveReward = true;
                    this.mInnerClickReportHelper.d();
                    this.mInnerClickReportHelper.c();
                    return;
                }
                return;
            }
            return;
        }
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            touchWebView.evaluateJavascript(script, new ValueCallback() { // from class: com.tencent.gdtad.basics.motivebrowsing.f
                @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    GdtMotiveBrowsingDialog.l0((String) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(String str) {
        QLog.i("GdtMotiveBrowsingDialog", 1, "handleMotiveBrowsingData EVENT_CALL_BACK_JS callback " + str);
    }

    private final void m0() {
        if (this.mModel == null) {
            QLog.i("GdtMotiveBrowsingDialog", 1, "mModel == null");
            return;
        }
        ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(this).get(GdtMotiveBrowsingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(this\u2026ingViewModel::class.java)");
        this.viewModel = (GdtMotiveBrowsingViewModel) viewModel;
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
        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel3 = this.viewModel;
        if (gdtMotiveBrowsingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            gdtMotiveBrowsingViewModel2 = gdtMotiveBrowsingViewModel3;
        }
        com.tencent.gdtad.basics.motivebrowsing.b.b(this, gdtMotiveBrowsingViewModel2.a2(), new GdtMotiveBrowsingDialog$initData$1(this));
        this.mSavedActivityIntent = this.mActivity.getIntent();
        this.mActivity.setIntent(this.mIntent);
        GdtADFlyingStreamingReportHelper.getInstance().init(this.mModel);
    }

    private final void n0() {
        FrameLayout frameLayout;
        GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle(this.mActivity);
        this.titleContainer = gdtMotiveBrowsingTitle;
        gdtMotiveBrowsingTitle.setOnCloseClickListener(new GdtMotiveBrowsingDialog$initTitle$1(this));
        int dpToPx = ViewUtils.dpToPx(15.0f);
        GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle2 = this.titleContainer;
        if (gdtMotiveBrowsingTitle2 != null) {
            gdtMotiveBrowsingTitle2.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        GdtMotiveBrowsingTitle gdtMotiveBrowsingTitle3 = this.titleContainer;
        if (gdtMotiveBrowsingTitle3 != null) {
            gdtMotiveBrowsingTitle3.setLayoutParams(layoutParams);
        }
        View view = this.mRootView;
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(com.tencent.mobileqq.R.id.title_container);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            frameLayout.addView(this.titleContainer);
        }
        ImmersiveUtils.clearCoverForStatus(this.mActivity.getWindow(), true);
        ImmersiveUtils.setStatusTextColor(true, this.mActivity.getWindow());
        j0(this.mActivity, frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ViewGroup decorView, int i3) {
        Intrinsics.checkNotNullParameter(decorView, "$decorView");
        if ((i3 & 4) == 0) {
            decorView.setSystemUiVisibility(7942);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(GdtMotiveBrowsingDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(GdtMotiveBrowsingDialog this$0, DialogInterface dialogInterface) {
        boolean z16;
        Integer num;
        Integer num2;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator translationY;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.mActivity;
        if (activity != null && activity.getRequestedOrientation() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            View view = this$0.mRootView;
            ViewPropertyAnimator viewPropertyAnimator = null;
            if (view != null) {
                num = Integer.valueOf(view.getMeasuredHeight());
            } else {
                num = null;
            }
            View view2 = this$0.mRootView;
            if (view2 != null) {
                num2 = Integer.valueOf(view2.getMeasuredWidth());
            } else {
                num2 = null;
            }
            if (num != null && num.intValue() != 0 && num2 != null && num2.intValue() != 0) {
                View view3 = this$0.mRootView;
                if (view3 != null) {
                    view3.setPivotX(0.0f);
                }
                View view4 = this$0.mRootView;
                if (view4 != null) {
                    view4.setPivotY(0.0f);
                }
                View view5 = this$0.mRootView;
                if (view5 != null && (animate = view5.animate()) != null && (translationY = animate.translationY(num.intValue() * 1.0f)) != null) {
                    viewPropertyAnimator = translationY.rotation(-90.0f);
                }
                if (viewPropertyAnimator != null) {
                    viewPropertyAnimator.setDuration(0L);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(num.intValue(), num2.intValue());
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                View view6 = this$0.mRootView;
                if (view6 != null) {
                    view6.setLayoutParams(layoutParams);
                }
                View view7 = this$0.mRootView;
                if (view7 != null) {
                    view7.requestLayout();
                }
            }
        }
    }

    private final void r0() {
        FrameLayout frameLayout;
        TouchWebView touchWebView;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DestInfo destInfo;
        PBStringField pBStringField;
        String str = null;
        AppRuntime appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) appRuntime;
        this.mWebView = new TouchWebView(this.mActivity);
        IGdtWebView createGdtWebView = this.mGdtWebViewProxy.createGdtWebView();
        this.mWebViewBuilder = createGdtWebView;
        if (createGdtWebView != null) {
            Activity activity = this.mActivity;
            createGdtWebView.init(activity, activity, null, appInterface, new c());
        }
        IGdtWebView iGdtWebView = this.mWebViewBuilder;
        if (iGdtWebView != null) {
            iGdtWebView.setWebView(this.mWebView);
        }
        IGdtWebView iGdtWebView2 = this.mWebViewBuilder;
        if (iGdtWebView2 != null) {
            iGdtWebView2.onCreate(null);
        }
        IGdtWebView iGdtWebView3 = this.mWebViewBuilder;
        if (iGdtWebView3 != null) {
            iGdtWebView3.onConstruct(null, appInterface, null);
        }
        View view = this.mRootView;
        if (view != null) {
            frameLayout = (FrameLayout) view.findViewById(com.tencent.mobileqq.R.id.l1y);
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            frameLayout.addView(this.mWebView);
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.mModel;
        if (gdtMotiveVideoModel != null && (adInfo = gdtMotiveVideoModel.getAdInfo()) != null && (destInfo = adInfo.dest_info) != null && (pBStringField = destInfo.landing_page) != null) {
            str = pBStringField.get();
        }
        if (!TextUtils.isEmpty(str) && (touchWebView = this.mWebView) != null) {
            touchWebView.loadUrl(str);
        }
        QLog.i("GdtMotiveBrowsingDialog", 1, "initWebView url = " + str);
    }

    private final void s0() {
        boolean z16;
        ViewParent viewParent;
        QLog.i("GdtMotiveBrowsingDialog", 1, "onDestory");
        this.mActivity.setIntent(this.mSavedActivityIntent);
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mQQCustomDialog = null;
        IGdtWebView iGdtWebView = this.mWebViewBuilder;
        if (iGdtWebView != null) {
            if (iGdtWebView != null) {
                iGdtWebView.onDestroy();
            }
            this.mWebViewBuilder = null;
        }
        TouchWebView touchWebView = this.mWebView;
        if (touchWebView != null) {
            if (touchWebView != null) {
                viewParent = touchWebView.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null && (viewParent instanceof ViewGroup)) {
                ((ViewGroup) viewParent).removeAllViewsInLayout();
            }
            this.mWebView = null;
        }
        g0(Lifecycle.Event.ON_DESTROY);
        Activity activity = this.mActivity;
        if (activity != null && activity.isChangingConfigurations()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            QLog.i("GdtMotiveBrowsingDialog", 1, "mViewModelStore.clear()");
            this.mViewModelStore.clear();
        }
        GdtADFlyingStreamingReportHelper.getInstance().onDestroy();
    }

    private final void u0() {
        QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick onCancel");
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mQQCustomDialog = null;
        x0(1);
        A0();
        super.onBackPressed();
    }

    private final void w0() {
        QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick confirm");
        QQCustomDialog qQCustomDialog = this.mQQCustomDialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.mQQCustomDialog = null;
        x0(2);
    }

    private final void x0(int clickButton) {
        int i3 = this.countDownTime;
        GdtMotiveBrowsingViewModel gdtMotiveBrowsingViewModel = this.viewModel;
        if (gdtMotiveBrowsingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            gdtMotiveBrowsingViewModel = null;
        }
        this.mInnerClickReportHelper.b(clickButton, (i3 - gdtMotiveBrowsingViewModel.getLeftSecond()) * 1000);
    }

    private final void y0() {
        this.mInnerClickReportHelper.f(this.countDownTime * 1000);
        this.mInnerClickReportHelper.e(this.countDownTime);
        x0(11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 == null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z0(int actionType, long actionTime) {
        String str;
        GdtAd gdtAd;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        String str2 = "";
        if (this.mMiniAppReportHelper == null) {
            return;
        }
        try {
            GdtMotiveVideoModel gdtMotiveVideoModel = this.mModel;
            String str3 = null;
            if (gdtMotiveVideoModel != null) {
                gdtAd = gdtMotiveVideoModel.getGdtAd();
            } else {
                gdtAd = null;
            }
            GdtMotiveVideoModel gdtMotiveVideoModel2 = this.mModel;
            if (gdtMotiveVideoModel2 != null) {
                gdtMotiveVideoPageData = gdtMotiveVideoModel2.getGdtMotiveVideoPageData();
            } else {
                gdtMotiveVideoPageData = null;
            }
            if (gdtAd != null) {
                str = Long.valueOf(gdtAd.getAId()).toString();
            }
            str = "";
            if (gdtMotiveVideoPageData != null) {
                try {
                    str3 = gdtMotiveVideoPageData.appId;
                } catch (Exception unused) {
                    QLog.e("GdtMotiveBrowsingDialog", 1, "get adInfo aId and appId fail");
                    this.mMiniAppReportHelper.a(actionType, actionTime, str, str2);
                }
            }
            if (str3 != null) {
                str2 = str3;
            }
        } catch (Exception unused2) {
            str = "";
        }
        this.mMiniAppReportHelper.a(actionType, actionTime, str, str2);
    }

    public final void B0(@NotNull GdtMotiveVideoModel mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mModel = mode;
    }

    public final void C0(@NotNull ResultReceiver resultReceiver) {
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.mResultReceiver = resultReceiver;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore, reason: from getter */
    public ViewModelStore getMViewModelStore() {
        return this.mViewModelStore;
    }

    public final void i0() {
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020026);
        QLog.i("GdtMotiveBrowsingDialog", 1, "doOnBackEvent");
        if (!this.hasCountDownComplete) {
            D0();
            return;
        }
        A0();
        super.onBackPressed();
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020043);
        x0(4);
    }

    public final void j0(@NotNull Activity activity, @Nullable View titlePart) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (titlePart != null) {
            LiuHaiUtils.initLiuHaiProperty(activity);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                ViewGroup.LayoutParams layoutParams = titlePart.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = LiuHaiUtils.getNotchInScreenHeight(activity);
                titlePart.setLayoutParams(layoutParams2);
                QLog.i("GdtMotiveBrowsingDialog", 1, "fitSpecialScreen addHeight = " + layoutParams2.topMargin);
            }
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        QLog.i("GdtMotiveBrowsingDialog", 1, "onBackPressed");
        i0();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("GdtMotiveBrowsingDialog", 1, "onCreate");
        g0(Lifecycle.Event.ON_CREATE);
        initView();
        n0();
        r0();
        m0();
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020033);
        GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020006);
        z0(0, NetConnInfoCenter.getServerTime());
        y0();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        QLog.i("GdtMotiveBrowsingDialog", 1, "onStart");
        super.onStart();
        IGdtWebView iGdtWebView = this.mWebViewBuilder;
        if (iGdtWebView != null) {
            iGdtWebView.onResume();
        }
        g0(Lifecycle.Event.ON_START);
        g0(Lifecycle.Event.ON_RESUME);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog
    protected void onStop() {
        QLog.i("GdtMotiveBrowsingDialog", 1, DKHippyEvent.EVENT_STOP);
        super.onStop();
        IGdtWebView iGdtWebView = this.mWebViewBuilder;
        if (iGdtWebView != null) {
            iGdtWebView.onPause();
        }
        g0(Lifecycle.Event.ON_PAUSE);
        g0(Lifecycle.Event.ON_STOP);
    }

    public final void setIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mIntent = intent;
    }
}
