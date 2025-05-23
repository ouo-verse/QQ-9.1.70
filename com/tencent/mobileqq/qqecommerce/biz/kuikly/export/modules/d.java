package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.events.QFSGrowthCenterTaskOperationEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import cooperation.qzone.QUA;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J5\u0010\n\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J5\u0010\u000b\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J?\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J?\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J?\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J?\u0010\u0013\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002J5\u0010\u0014\u001a\u00020\u00072+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0002JI\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2+\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\bH\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/d;", "Li01/e;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "l", "", "params", "c", "o", "key", "g", "j", "p", "d", "method", "call", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends i01.e {
    private final void d(Function1<Object, Unit> callback) {
        Map mapOf;
        String qua3 = QUA.getQUA3();
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("qua", qua3));
            callback.invoke(mapOf);
        }
    }

    private final void i(Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Context context = getContext();
        if (context == null) {
            QLog.e("QQCirKuiklyAPIModule", 1, "hasContactPermission: context is null");
            if (callback != null) {
                mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", "context is null"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        boolean z16 = ContextCompat.checkSelfPermission(context, QQPermissionConstants.Permission.READ_CONTACTS) == 0;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("hasPermission", Boolean.valueOf(z16)));
            callback.invoke(mapOf);
        }
    }

    private final void j(String params, Function1<Object, Unit> callback) {
        yb0.g.f449962a.p(getActivity(), params, callback);
    }

    private final void l(final Function1<Object, Unit> callback) {
        Map mapOf;
        Context context = getContext();
        Activity i3 = context != null ? KRCSSViewExtensionKt.i(context) : null;
        if (i3 == null) {
            QLog.e("QQCirKuiklyAPIModule", 1, "requestContactPermission: context is null");
            if (callback != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", "context is null"));
                callback.invoke(mapOf);
                return;
            }
            return;
        }
        com.tencent.biz.qqcircle.helpers.k.f84627a.j(i3, true, new Consumer() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.c
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                d.m(Function1.this, (Boolean) obj);
            }
        });
    }

    private final void o() {
        Context context = getContext();
        if (context == null) {
            QLog.e("QQCirKuiklyAPIModule", 1, "showQRCode: context is null");
        } else {
            com.tencent.biz.qqcircle.launcher.c.s0(context, null);
        }
    }

    private final void p(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        SimpleEventBus.getInstance().dispatchEvent(new QFSGrowthCenterTaskOperationEvent(true));
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("success", "1"));
            callback.invoke(mapOf);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2112029888:
                if (method.equals("requestContactPermission")) {
                    l(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -2000781590:
                if (method.equals("getNativeExperiment")) {
                    c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1327478934:
                if (method.equals("openQVideoMultiSharePanel")) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1017850768:
                if (method.equals("getNativeQua")) {
                    d(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 693050603:
                if (method.equals("showQRCode")) {
                    o();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1074755184:
                if (method.equals("updateCreatorCenterRedDot")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1564676757:
                if (method.equals("hasContactPermission")) {
                    i(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1593045179:
                if (method.equals("getUnitedConfig")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 function1, Boolean bool) {
        Map mapOf;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("success", bool));
            function1.invoke(mapOf);
        }
    }

    private final void g(String key, Function1<Object, Unit> callback) {
        Map mapOf;
        if (!(key == null || key.length() == 0) && callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(TPReportParams.JSON_KEY_VAL, ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(key, "")));
            callback.invoke(mapOf);
        } else {
            QLog.e("QQCirKuiklyAPIModule", 1, "getUnitedConfig: key is null or empty or callback is null");
        }
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Map mapOf3;
        if (params == null || params.length() == 0) {
            if (callback != null) {
                mapOf3 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", "params is null or empty"));
                callback.invoke(mapOf3);
                return;
            }
            return;
        }
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String expName = k06.optString("exp_name");
        String appId = k06.optString("app_id");
        if (!(expName == null || expName.length() == 0)) {
            if (!(appId == null || appId.length() == 0)) {
                com.tencent.biz.qqcircle.utils.m mVar = com.tencent.biz.qqcircle.utils.m.f92779a;
                Intrinsics.checkNotNullExpressionValue(expName, "expName");
                Intrinsics.checkNotNullExpressionValue(appId, "appId");
                String c16 = com.tencent.biz.qqcircle.utils.m.c(mVar, expName, appId, false, 4, null);
                if (callback != null) {
                    mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(SsoReporter.TAB_EXPERIMENT_KEY, c16));
                    callback.invoke(mapOf2);
                    return;
                }
                return;
            }
        }
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", "expName(" + expName + " or appId(" + appId + " is null or empty"));
            callback.invoke(mapOf);
        }
    }
}
