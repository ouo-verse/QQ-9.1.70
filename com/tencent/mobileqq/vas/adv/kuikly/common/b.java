package com.tencent.mobileqq.vas.adv.kuikly.common;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007\u00a2\u0006\u0004\b%\u0010&J?\u0010\r\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u000e\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u000f\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J=\u0010\u0012\u001a\u00020\n2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002JI\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR;\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/common/b;", "Li01/e;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$OnShakeListener;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "d", "g", "", "retCode", "a", "method", "call", "onShakeComplete", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor;", "mShakeSensor", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "e", "Lcom/tencent/gdtad/views/shake/GdtShakeSensor$Params;", "mShakeParams", "f", "Lkotlin/jvm/functions/Function1;", "mShakeCallback", "", h.F, "Z", "mIsRegistered", "<init>", "()V", "i", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends e implements GdtShakeSensor.OnShakeListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtShakeSensor mShakeSensor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GdtShakeSensor.Params mShakeParams = new GdtShakeSensor.Params();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> mShakeCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsRegistered;

    private final void a(Function1<Object, Unit> callback, int retCode) {
        QLog.d("QQKuiklyAdWieldSensorModule", 1, "callbackRetCode:", Integer.valueOf(retCode));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret_code", retCode);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(params)) {
            if (params != null) {
                jSONObject = new JSONObject(params).optJSONObject(QAdVrReport.ElementID.AD_INFO);
            } else {
                jSONObject = null;
            }
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = (qq_ad_get.QQAdGetRsp.AdInfo) GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), jSONObject);
            if (adInfo != null) {
                this.mShakeParams = new GdtShakeSensor.Params(adInfo);
            }
        }
        GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
        gdtShakeSensor.setShakeFactor(this.mShakeParams);
        gdtShakeSensor.setShakeListener(new WeakReference<>(this));
        this.mShakeSensor = gdtShakeSensor;
        a(callback, 1);
    }

    private final void d(String params, Function1<Object, Unit> callback) {
        if (this.mIsRegistered) {
            a(callback, 0);
            return;
        }
        QLog.d("QQKuiklyAdWieldSensorModule", 2, "registerShakeSensor");
        if (this.mShakeSensor == null) {
            GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
            gdtShakeSensor.setShakeFactor(this.mShakeParams);
            gdtShakeSensor.setShakeListener(new WeakReference<>(this));
            this.mShakeSensor = gdtShakeSensor;
        }
        GdtShakeSensor gdtShakeSensor2 = this.mShakeSensor;
        if (gdtShakeSensor2 != null) {
            gdtShakeSensor2.register(getContext());
        }
        this.mShakeCallback = callback;
        this.mIsRegistered = true;
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        if (!this.mIsRegistered) {
            a(callback, 0);
            return;
        }
        QLog.d("QQKuiklyAdWieldSensorModule", 1, "unregisterShakeSensor");
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.unregister(getContext());
        }
        this.mShakeCallback = null;
        this.mShakeSensor = null;
        this.mIsRegistered = false;
        a(callback, 1);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != -1816980235) {
            if (hashCode != -1264410238) {
                if (hashCode == -32181687 && method.equals("unregisterWieldSensor")) {
                    g(params, callback);
                }
            } else if (method.equals("registerWieldSensor")) {
                d(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("initWieldSensor")) {
            c(params, callback);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        g(null, null);
    }

    @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
    public void onShakeComplete() {
        GdtShakeSensor gdtShakeSensor = this.mShakeSensor;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.reset();
        }
        a(this.mShakeCallback, 1);
        g(null, null);
    }
}
