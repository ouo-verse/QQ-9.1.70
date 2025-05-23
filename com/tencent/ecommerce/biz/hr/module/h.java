package com.tencent.ecommerce.biz.hr.module;

import android.graphics.Bitmap;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016JI\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/h;", "Li01/e;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "", "d", "Z", "needDestroyShareCallback", "<init>", "()V", "e", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class h extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needDestroyShareCallback;

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Map mapOf;
        com.tencent.kuikly.core.render.android.expand.module.j jVar;
        int hashCode = method.hashCode();
        if (hashCode != -925958806) {
            if (hashCode != -208290750) {
                if (hashCode == 705042617 && method.equals("saveViewImage")) {
                    if (params != null) {
                        int optInt = new JSONObject(params).optInt(HippyHeaderListViewController.VIEW_TAG);
                        Bitmap i3 = ECHRShare.f102572h.i(this, optInt, null);
                        if (i3 == null) {
                            return params;
                        }
                        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
                        if (aVar != null && (jVar = (com.tencent.kuikly.core.render.android.expand.module.j) aVar.a("KRMemoryCacheModule")) != null) {
                            jVar.l(String.valueOf(optInt), i3);
                        }
                        if (callback == null) {
                            return params;
                        }
                        JSONObject jSONObject = new JSONObject();
                        Unit unit = Unit.INSTANCE;
                        callback.invoke(jSONObject.toString());
                        return params;
                    }
                    return null;
                }
            } else if (method.equals("showSharePanel")) {
                ECHRShare.f102572h.y(getActivity(), params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("doShareAction")) {
            this.needDestroyShareCallback = true;
            ECHRShare.f102572h.h(get_kuiklyRenderContext(), this, params, callback);
            return Unit.INSTANCE;
        }
        if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", -1), TuplesKt.to("message", "\u65b9\u6cd5\u4e0d\u5b58\u5728"));
            return callback.invoke(mapOf);
        }
        return null;
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        if (this.needDestroyShareCallback) {
            ECHRShare.f102572h.o(null);
            this.needDestroyShareCallback = false;
        }
    }
}
