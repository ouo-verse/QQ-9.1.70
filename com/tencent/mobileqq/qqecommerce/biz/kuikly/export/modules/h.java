package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\fH\u0002J?\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\fH\u0002J?\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\fH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\u0004\u0018\u0001`\fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/h;", "Li01/e;", "", "jsonParams", "c", "bundleName", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "params", "d", "g", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "a", "method", "call", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends i01.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016JT\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/h$b", "Lcom/tencent/hippy/qq/api/IUpdateListener;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "", "bundleName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "updateJSCosts", "", "onUpdateSuccess", "retCode", "errMsg", "onUpdateFailed", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262998a;

        b(Function1<Object, Unit> function1) {
            this.f262998a = function1;
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int requestId, int retCode, String errMsg, String bundleName, HashMap<String, String> updateJSCosts) {
            Map mapOf;
            Map mapOf2;
            Map mapOf3;
            if (retCode == 1) {
                Function1<Object, Unit> function1 = this.f262998a;
                if (function1 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("retCode", 0), TuplesKt.to("errMsg", "no new version"));
                    function1.invoke(mapOf);
                    return;
                }
                return;
            }
            if (retCode != 101) {
                Function1<Object, Unit> function12 = this.f262998a;
                if (function12 != null) {
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = TuplesKt.to("retCode", -1);
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    pairArr[1] = TuplesKt.to("errMsg", errMsg);
                    mapOf3 = MapsKt__MapsKt.mapOf(pairArr);
                    function12.invoke(mapOf3);
                    return;
                }
                return;
            }
            Function1<Object, Unit> function13 = this.f262998a;
            if (function13 != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", 1));
                function13.invoke(mapOf2);
            }
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int requestId, String bundleName, HashMap<String, String> updateJSCosts) {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f262998a;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", 1));
                function1.invoke(mapOf);
            }
        }
    }

    private final String c(String jsonParams) {
        try {
            Activity activity = getActivity();
            if (activity == null) {
                activity = Foreground.getTopActivity();
            }
            if (activity != null) {
                if (new OpenHippyInfo(new JSONObject(jsonParams)).openHippy(activity)) {
                    return "1";
                }
                return "0";
            }
            return "-1";
        } catch (Exception e16) {
            QLog.e("QQKuiklyHippyModule", 1, "openHippyPage e:", e16);
            return "-1";
        }
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        OpenHippyInfo a16 = a(params);
        if (a16 == null) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("retCode", -1), TuplesKt.to("errMsg", "error params"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadHippyPage(a16);
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", 0));
            callback.invoke(mapOf);
        }
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        OpenHippyInfo a16 = a(params);
        if (a16 == null) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("retCode", -1), TuplesKt.to("errMsg", "error params"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(a16);
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", 0));
            callback.invoke(mapOf);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1215065763:
                if (method.equals("openHippyPage")) {
                    return c(params);
                }
                return Unit.INSTANCE;
            case 877015269:
                if (method.equals("removePreload")) {
                    g(params, callback);
                }
                return Unit.INSTANCE;
            case 1578367311:
                if (method.equals("preloadHippy")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1682217690:
                if (method.equals("updateHippyJsBundle")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }

    private final OpenHippyInfo a(String params) {
        if (params == null || params.length() == 0) {
            return null;
        }
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(new JSONObject(params));
        if (openHippyInfo.preloadType == TabPreloadItem.PreloadType.NO_PRELOAD || !openHippyInfo.checkData()) {
            return null;
        }
        return openHippyInfo;
    }

    private final void i(String bundleName, Function1<Object, Unit> callback) {
        Map mapOf;
        if (!(bundleName == null || bundleName.length() == 0)) {
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).commonUpdateJsBundle(bundleName, "kuikly", new b(callback));
        } else if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("retCode", -1));
            callback.invoke(mapOf);
        }
    }
}
