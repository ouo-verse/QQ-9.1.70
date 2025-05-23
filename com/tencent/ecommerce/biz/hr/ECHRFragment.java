package com.tencent.ecommerce.biz.hr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.ktx.ECSchemeExtUserDataMap;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.hr.IECHippyRenderView;
import com.tencent.ecommerce.biz.hr.apk.HRAarManager;
import com.tencent.ecommerce.biz.hr.module.ECHRShare;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.context.h;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.a;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.Constants;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001kB\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u0018\u001a\u00020\nJ\u0012\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\"\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001cJ+\u0010%\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n0 H\u0014J\"\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\u001c\u0010.\u001a\u00020\n2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0,H\u0002J\u001c\u0010/\u001a\u00020\n2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0,H\u0002J?\u00102\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n0 2\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u0012H\u0002J+\u00103\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\n0 H\u0002J\u0010\u00106\u001a\u00020\n2\u0006\u00105\u001a\u000204H\u0002J\u001c\u00107\u001a\u00020\u00052\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u00108\u001a\u00020\nH\u0002J\u0016\u0010;\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\n09H\u0002J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0,H\u0002J\u0010\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020\nH\u0002J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020\nH\u0002J\u0018\u0010D\u001a\u00020\n2\u0006\u0010C\u001a\u00020>2\u0006\u00105\u001a\u000204H\u0002R(\u0010K\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010E8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010C\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Y\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010WR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u0004\u0018\u00010b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010h\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010g\u00a8\u0006l"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/kuikly/core/render/android/expand/a;", "", "getContentLayoutId", "", "getBusinessDescription", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "", "Eh", "Ah", "onBackPressed", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "C2", "ti", "params", "gi", AdMetricTag.EVENT_NAME, "", "", "data", "vi", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "contextCode", "result", "ki", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "ci", "si", "", "param", WidgetCacheLunarData.YI, WidgetCacheLunarData.JI, "retryCount", "needMatchVersion", "hi", "li", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "ri", "pi", "di", "Lkotlin/Function0;", "task", SensorJsPlugin.SENSOR_INTERVAL_UI, "fi", "pageName", "Lcom/tencent/ecommerce/biz/hr/ExecuteContextMode;", "ni", "xi", "zi", "wi", "executeContextMode", "ei", "Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "<set-?>", "P", "Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "oi", "()Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "ecHippyRenderView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "pagerName", BdhLogUtil.LogTag.Tag_Req, "Ljava/util/Map;", ExifInterface.LATITUDE_SOUTH, "Z", "modalMode", "T", "supportCustomBackPressed", "U", "Lcom/tencent/ecommerce/biz/hr/ExecuteContextMode;", "V", "configExecuteContextMode", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "W", "Lcom/tencent/ecommerce/base/offline/api/IECOfflineManager$a;", "aarOfflineStrongCallback", "Lcom/tencent/ecommerce/biz/hr/CenterViewState;", "X", "Lcom/tencent/ecommerce/biz/hr/CenterViewState;", "centerViewState", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "mi", "()Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "centerStateView", "qi", "()Ljava/lang/String;", "tracePageName", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECHRFragment extends ECBaseFragment implements com.tencent.kuikly.core.render.android.expand.a {
    private static int Y;

    /* renamed from: Z, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private ECHippyRenderView ecHippyRenderView;

    /* renamed from: Q, reason: from kotlin metadata */
    private String pagerName = "";

    /* renamed from: R, reason: from kotlin metadata */
    private final Map<String, Object> params = new LinkedHashMap();

    /* renamed from: S, reason: from kotlin metadata */
    private boolean modalMode;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean supportCustomBackPressed;

    /* renamed from: U, reason: from kotlin metadata */
    private ExecuteContextMode executeContextMode;

    /* renamed from: V, reason: from kotlin metadata */
    private ExecuteContextMode configExecuteContextMode;

    /* renamed from: W, reason: from kotlin metadata */
    private IECOfflineManager.OfflineStrongCallback aarOfflineStrongCallback;

    /* renamed from: X, reason: from kotlin metadata */
    private volatile CenterViewState centerViewState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/ECHRFragment$a;", "", "", "openCount", "I", "a", "()I", "setOpenCount", "(I)V", "HR_DYNAMIC_CONFIG_ID", "", "KEY_HR_BACKGROUND_IMAGE_BASE64", "Ljava/lang/String;", "OPEN_PAGE_COUNT", "PAGE_STATE_DOWNLOADING_AAR_FILE", "PAGE_STATE_DOWNLOAD_AAR_FILE_ERROR", "PAGE_STATE_LOADING_AAR_FILE", "PAGE_STATE_LOAD_AAR_ERROR", "PAGE_STATE_LOAD_AAR_SUCCESS", "SHARE_REQUEST_CODE", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.hr.ECHRFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ECHRFragment.Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECHRFragment() {
        ExecuteContextMode executeContextMode = ExecuteContextMode.JVM;
        this.executeContextMode = executeContextMode;
        this.configExecuteContextMode = executeContextMode;
        this.centerViewState = CenterViewState.UNKNOWN;
    }

    private final void ci() {
        if (si()) {
            View yh5 = yh();
            while (true) {
                View view = null;
                if (yh5 == null) {
                    break;
                }
                if (yh5.getId() == R.id.nx_) {
                    yh5.setBackgroundColor(0);
                }
                ViewParent parent = yh5.getParent();
                if (parent instanceof View) {
                    view = parent;
                }
                yh5 = view;
            }
            IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
            if (resourceApi != null) {
                resourceApi.fetchDrawable(yh().getContext(), "qui_image://common_bg_bottom_standard_bg", (IECImageLoader.ImageLoaderOption) null, new Function3<Drawable, Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$adaptSearchPage$$inlined$apply$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable, Integer num, String str) {
                        invoke(drawable, num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Drawable drawable, int i3, String str) {
                        LinearLayout yh6;
                        if (drawable != null) {
                            yh6 = ECHRFragment.this.yh();
                            yh6.setBackground(drawable);
                        }
                    }
                });
            }
        }
    }

    private final void di() {
        String str;
        if (Intrinsics.areEqual("qsearch_detail", this.pagerName)) {
            Map<String, Object> map = this.params;
            IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
            if (qqApi == null || (str = qqApi.getLbsInfo()) == null) {
                str = "";
            }
            map.put("lbs", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(ExecuteContextMode executeContextMode, ViewGroup container) {
        TextView textView = new TextView(requireContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(150, 50);
        layoutParams.topMargin = 300;
        textView.setLayoutParams(layoutParams);
        textView.setText(executeContextMode.name());
        textView.setTextColor(-1);
        textView.setTextSize(2, 13.0f);
        textView.setTextAlignment(4);
        textView.setBackgroundColor(-16711936);
        textView.setAlpha(0.3f);
        container.addView(textView);
    }

    private final Map<String, Object> fi() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Set<String> keySet = arguments.keySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : keySet) {
                Object obj = arguments.get(str);
                if (obj instanceof ECSchemeExtUserDataMap) {
                    linkedHashMap.put(str, ((ECSchemeExtUserDataMap) obj).getExtUserDataMap());
                } else {
                    Intrinsics.checkNotNull(obj);
                    linkedHashMap.put(str, obj);
                }
            }
            return linkedHashMap;
        }
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(final Function1<? super String, Unit> result, final int retryCount, final boolean needMatchVersion) {
        HRAarManager hRAarManager = HRAarManager.f102531b;
        String j3 = hRAarManager.j(this.pagerName, needMatchVersion);
        if (j3.length() > 0) {
            ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
            if (eCHippyRenderView != null) {
                eCHippyRenderView.setPageProgressStatus(110);
            }
            hRAarManager.i(j3, this.pagerName, new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$fetchApkContextCode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    if (str.length() > 0) {
                        ECHippyRenderView ecHippyRenderView = ECHRFragment.this.getEcHippyRenderView();
                        if (ecHippyRenderView != null) {
                            ecHippyRenderView.setPageProgressStatus(111);
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("run in dynamic aar mode: ");
                        str5 = ECHRFragment.this.pagerName;
                        sb5.append(str5);
                        cg0.a.b("ECHRFragment", sb5.toString());
                        ECHRFragment.this.executeContextMode = ExecuteContextMode.DEX;
                        result.invoke(str);
                        return;
                    }
                    h.Companion companion = h.INSTANCE;
                    str2 = ECHRFragment.this.pagerName;
                    if (companion.a(str2)) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("aar env ready, but back to jvm mode: ");
                        str4 = ECHRFragment.this.pagerName;
                        sb6.append(str4);
                        cg0.a.b("ECHRFragment", sb6.toString());
                        ECHRFragment.this.li(result);
                        return;
                    }
                    ECHippyRenderView ecHippyRenderView2 = ECHRFragment.this.getEcHippyRenderView();
                    if (ecHippyRenderView2 != null) {
                        ecHippyRenderView2.setPageProgressStatus(112);
                    }
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("aar env ready, but page aar path not exist: ");
                    str3 = ECHRFragment.this.pagerName;
                    sb7.append(str3);
                    cg0.a.b("ECHRFragment", sb7.toString());
                    ECHRFragment.this.wi();
                }
            });
            return;
        }
        if (h.INSTANCE.a(this.pagerName)) {
            cg0.a.b("ECHRFragment", "aar env not ready, but back to jvm mode: " + this.pagerName);
            li(result);
            return;
        }
        this.aarOfflineStrongCallback = new IECOfflineManager.OfflineStrongCallback(null, new Function1<IECOfflineManager.OfflineDownloadState, Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$fetchApkContextCode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
                invoke2(offlineDownloadState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
                cg0.a.b("ECHRFragment", "aar not exist download result: " + offlineDownloadState + ", retryCount: " + retryCount);
                ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$fetchApkContextCode$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ECHRFragment$fetchApkContextCode$2 eCHRFragment$fetchApkContextCode$2 = ECHRFragment$fetchApkContextCode$2.this;
                        ECHRFragment.this.hi(result, retryCount + 1, needMatchVersion);
                    }
                });
            }
        });
        if (retryCount <= 3) {
            ECHippyRenderView eCHippyRenderView2 = this.ecHippyRenderView;
            if (eCHippyRenderView2 != null) {
                eCHippyRenderView2.setPageProgressStatus(108);
            }
            cg0.a.b("ECHRFragment", "aar env not ready, download offline: " + this.pagerName);
            xi();
            hRAarManager.f(this.aarOfflineStrongCallback);
            return;
        }
        ECHippyRenderView eCHippyRenderView3 = this.ecHippyRenderView;
        if (eCHippyRenderView3 != null) {
            eCHippyRenderView3.setPageProgressStatus(109);
        }
        cg0.a.b("ECHRFragment", "download aar offline fail: " + this.pagerName);
        wi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(final Map<String, Object> param) {
        ki(new Function1<String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$fetchContextCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final String str) {
                ECHRFragment.this.ui(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$fetchContextCode$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ExecuteContextMode executeContextMode;
                        LinearLayout yh5;
                        String qi5;
                        String str2;
                        ECHRFragment.this.zi();
                        ECHippyRenderView ecHippyRenderView = ECHRFragment.this.getEcHippyRenderView();
                        if (ecHippyRenderView != null) {
                            String str3 = str;
                            str2 = ECHRFragment.this.pagerName;
                            IECHippyRenderView.a.a(ecHippyRenderView, str3, str2, param, null, 8, null);
                        }
                        executeContextMode = ECHRFragment.this.configExecuteContextMode;
                        if (executeContextMode != ExecuteContextMode.JVM) {
                            ECRMonitorManager eCRMonitorManager = ECRMonitorManager.f100953c;
                            qi5 = ECHRFragment.this.qi();
                            eCRMonitorManager.c(qi5);
                        }
                        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isPublicVersion()) {
                            return;
                        }
                        ECHRFragment eCHRFragment = ECHRFragment.this;
                        ExecuteContextMode a16 = ExecuteContextMode.INSTANCE.a(eCHRFragment.C2().getMode());
                        yh5 = ECHRFragment.this.yh();
                        eCHRFragment.ei(a16, (ViewGroup) yh5.findViewById(R.id.f163023nw3));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(Function1<? super String, Unit> result) {
        cg0.a.b("ECHRFragment", "run in jvm mode: " + this.pagerName);
        this.executeContextMode = ExecuteContextMode.JVM;
        result.invoke("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECStateCenterView mi() {
        return (ECStateCenterView) yh().findViewById(R.id.f163024nw4);
    }

    private final ExecuteContextMode ni(String pageName) {
        return ExecuteContextMode.INSTANCE.a(((Number) com.tencent.ecommerce.base.config.service.b.f100655b.b(100168, pageName, 0)).intValue());
    }

    private final String pi(Map<String, ? extends Object> param) {
        Object obj = param.get("page_name");
        if (obj == null) {
            obj = param.get("target");
        }
        if (obj == null) {
            obj = "";
        }
        return (String) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String qi() {
        if (a.f102514a[this.executeContextMode.ordinal()] != 1) {
            return this.pagerName + util.base64_pad_url + this.executeContextMode.name();
        }
        return this.pagerName;
    }

    private final void ri(ViewGroup container) {
        ECHippyRenderView eCHippyRenderView = new ECHippyRenderView(requireContext(), this, new Function0<Map<Object, ? extends Object>>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$initECHippyRenderView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Object, ? extends Object> invoke() {
                ExecuteContextMode executeContextMode;
                ExecuteContextMode executeContextMode2;
                ExecuteContextMode executeContextMode3;
                ExecuteContextMode executeContextMode4;
                Map<Object, ? extends Object> mutableMapOf;
                Map<Object, ? extends Object> mutableMapOf2;
                executeContextMode = ECHRFragment.this.executeContextMode;
                if (executeContextMode == ExecuteContextMode.JVM) {
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("open_page_count", Integer.valueOf(ECHRFragment.INSTANCE.a())));
                    return mutableMapOf2;
                }
                Pair[] pairArr = new Pair[4];
                executeContextMode2 = ECHRFragment.this.configExecuteContextMode;
                pairArr[0] = TuplesKt.to("config_mode", Integer.valueOf(executeContextMode2.value));
                executeContextMode3 = ECHRFragment.this.executeContextMode;
                pairArr[1] = TuplesKt.to("execute_mode", Integer.valueOf(executeContextMode3.value));
                executeContextMode4 = ECHRFragment.this.executeContextMode;
                pairArr[2] = TuplesKt.to(ReportDataBuilder.KEY_BUNDLE_ID, a.f102518e[executeContextMode4.ordinal()] != 1 ? "-1" : HRAarManager.f102531b.h());
                pairArr[3] = TuplesKt.to("open_page_count", Integer.valueOf(ECHRFragment.INSTANCE.a()));
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
                return mutableMapOf;
            }
        });
        eCHippyRenderView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        container.addView(eCHippyRenderView);
        Unit unit = Unit.INSTANCE;
        this.ecHippyRenderView = eCHippyRenderView;
    }

    private final boolean si() {
        return Intrinsics.areEqual("qsearch_detail", this.pagerName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.tencent.ecommerce.biz.hr.ECHRFragment$sam$java_lang_Runnable$0] */
    public final void ui(final Function0<Unit> task) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            task.invoke();
            return;
        }
        LinearLayout yh5 = yh();
        if (task != null) {
            task = new Runnable() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Function0.this.invoke();
                }
            };
        }
        yh5.post((Runnable) task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wi() {
        if (this.centerViewState == CenterViewState.FAIL) {
            return;
        }
        ui(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$setFailState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECStateCenterView mi5;
                ECHRFragment.this.centerViewState = CenterViewState.FAIL;
                mi5 = ECHRFragment.this.mi();
                if (mi5 != null) {
                    IStateCenterView.a.b(mi5, null, 1, null);
                }
            }
        });
    }

    private final void xi() {
        if (this.centerViewState == CenterViewState.LOADING) {
            return;
        }
        ui(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$setLoadingState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECStateCenterView mi5;
                ECHRFragment.this.centerViewState = CenterViewState.LOADING;
                mi5 = ECHRFragment.this.mi();
                if (mi5 != null) {
                    IStateCenterView.a.c(mi5, null, 1, null);
                }
            }
        });
    }

    private final void yi(Map<String, Object> param) {
        if (this.modalMode) {
            yh().setBackgroundColor(0);
            return;
        }
        if (param.containsKey("hr_background_image_base64")) {
            Object obj = param.get("hr_background_image_base64");
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null) {
                if (str.length() > 0) {
                    LinearLayout yh5 = yh();
                    f01.b bVar = new f01.b();
                    bVar.c(new String(Base64.decode(str, 0), Charsets.UTF_8));
                    Unit unit = Unit.INSTANCE;
                    yh5.setBackground(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zi() {
        ECStateCenterView mi5 = mi();
        if ((mi5 == null || mi5.getVisibility() != 8) && this.centerViewState != CenterViewState.SUCCESS) {
            ui(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$setSuccessState$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ECStateCenterView mi6;
                    ECHRFragment.this.centerViewState = CenterViewState.SUCCESS;
                    mi6 = ECHRFragment.this.mi();
                    if (mi6 != null) {
                        mi6.setSucceededState();
                    }
                }
            });
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Ah() {
        return !this.params.containsKey("disable_change_system_bar");
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public KuiklyRenderCoreExecuteMode C2() {
        int i3 = a.f102516c[this.executeContextMode.ordinal()];
        if (i3 == 1) {
            return KuiklyRenderCoreExecuteMode.JS;
        }
        if (i3 == 2) {
            return KuiklyRenderCoreExecuteMode.SO;
        }
        if (i3 != 3) {
            return KuiklyRenderCoreExecuteMode.JVM;
        }
        return KuiklyRenderCoreExecuteMode.DEX;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean Cc() {
        return a.C5872a.b(this);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ff(com.tencent.kuikly.core.render.android.b bVar) {
        a.C5872a.q(this, bVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ia(Throwable th5, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        a.C5872a.m(this, th5, errorReason, kuiklyRenderCoreExecuteMode);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: K0 */
    public Long getEmbedSceneSyncTimeout() {
        return a.C5872a.t(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: M0 */
    public boolean getUseHostDisplayMetrics() {
        return a.C5872a.w(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Map<String, Object> O1() {
        return a.C5872a.d(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Integer Re() {
        return a.C5872a.s(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Sa() {
        a.C5872a.i(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public String V0() {
        return a.C5872a.v(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean c1() {
        return a.C5872a.f(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public List<KRMonitorType> ec() {
        return a.C5872a.n(this);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECHRFragment" + this.pagerName;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crn;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean h4() {
        return a.C5872a.u(this);
    }

    protected void ki(Function1<? super String, Unit> result) {
        this.configExecuteContextMode = ni(this.pagerName);
        cg0.a.b("ECHRFragment", "execute config: " + this.configExecuteContextMode + ", pageName: " + this.pagerName);
        if (a.f102517d[this.configExecuteContextMode.ordinal()] != 1) {
            if (h.INSTANCE.a(this.pagerName)) {
                li(result);
                return;
            }
            cg0.a.b("ECHRFragment", "trigger dynamic load page, pageName: " + this.pagerName);
            ii(this, result, 0, false, 2, null);
            return;
        }
        ii(this, result, 0, true, 2, null);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void le(com.tencent.kuikly.core.render.android.performace.c cVar) {
        a.C5872a.h(this, cVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean ng() {
        return a.C5872a.c(this);
    }

    /* renamed from: oi, reason: from getter */
    public final ECHippyRenderView getEcHippyRenderView() {
        return this.ecHippyRenderView;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        Map<String, ? extends Object> emptyMap;
        if (!this.supportCustomBackPressed && (!this.modalMode || this.ecHippyRenderView == null)) {
            return super.onBackPressed();
        }
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        Intrinsics.checkNotNull(eCHippyRenderView);
        emptyMap = MapsKt__MapsKt.emptyMap();
        eCHippyRenderView.sentEvent("onModalModeBackPressed", emptyMap);
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        this.params.clear();
        this.params.putAll(fi());
        this.pagerName = pi(this.params);
        di();
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (a.f102515b[this.configExecuteContextMode.ordinal()] == 1) {
            HRAarManager.f102531b.k();
        }
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onDetach();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void onPageLoadComplete(boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        a.C5872a.k(this, z16, errorReason, kuiklyRenderCoreExecuteMode);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b(qi());
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onPause();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onResume();
        }
        ECRMonitorManager.f100953c.c(qi());
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewGroup viewGroup = (ViewGroup) yh().findViewById(R.id.f163023nw3);
        if (viewGroup != null) {
            if (this.params.containsKey(KuiklyLaunchParams.PARAM_MODAL_MODE)) {
                this.modalMode = true;
            }
            if (this.params.containsKey("hr_support_custom_back_pressed")) {
                this.supportCustomBackPressed = true;
            }
            ri(viewGroup);
            Y++;
            ECStateCenterView mi5 = mi();
            if (mi5 != null) {
                mi5.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHRFragment$onViewCreated$$inlined$also$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Map map;
                        ECHRFragment eCHRFragment = ECHRFragment.this;
                        map = eCHRFragment.params;
                        eCHRFragment.ji(map);
                    }
                });
            }
            ji(this.params);
            yi(this.params);
        }
        ci();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void p9() {
        a.C5872a.j(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void pg(j01.a aVar) {
        a.C5872a.g(this, aVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b bVar) {
        a.C5872a.o(this, bVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalRenderView(com.tencent.kuikly.core.render.android.b bVar) {
        a.C5872a.p(this, bVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerViewExternalPropHandler(com.tencent.kuikly.core.render.android.b bVar) {
        a.C5872a.r(this, bVar);
    }

    public final void ti() {
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.onPause();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean u0() {
        return a.C5872a.e(this);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        if (si()) {
            return 1;
        }
        return super.uh();
    }

    public final void vi(String eventName, Map<String, ? extends Object> data) {
        cg0.a.b("ECHRFragment", "sendEvent eventName: " + eventName + " data:" + data);
        ECHippyRenderView eCHippyRenderView = this.ecHippyRenderView;
        if (eCHippyRenderView != null) {
            eCHippyRenderView.sentEvent(eventName, data);
        }
    }

    public final void gi(String params) {
        String str;
        if (params != null) {
            Bundle arguments = getArguments();
            if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
                str = "";
            }
            IECSchemeCallback b16 = ug0.a.b(str);
            if (b16 != null) {
                b16.onCallbackFinished(new JSONObject(params));
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10000) {
            ECHRShare.f102572h.j(resultCode, data);
        }
    }

    static /* synthetic */ void ii(ECHRFragment eCHRFragment, Function1 function1, int i3, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            if ((i16 & 4) != 0) {
                z16 = false;
            }
            eCHRFragment.hi(function1, i3, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchApkContextCode");
    }
}
