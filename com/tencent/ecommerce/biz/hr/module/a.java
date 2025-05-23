package com.tencent.ecommerce.biz.hr.module;

import android.content.Context;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/a;", "Li01/e;", "", "params", "", "a", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "d", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "ecGlobalShowWindowViewModel", "<init>", "()V", "e", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ECGlobalShowWindowViewModel ecGlobalShowWindowViewModel = new ECGlobalShowWindowViewModel();

    private final void a(String params) {
        if (params == null) {
            params = "{}";
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("productID");
        String optString2 = jSONObject.optString("saasType");
        String optString3 = jSONObject.optString("goodsType");
        Context context = getContext();
        if (context != null) {
            ECGlobalShowWindowViewModel.O1(this.ecGlobalShowWindowViewModel, context, optString2, optString, optString3, null, 16, null);
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        if (method.hashCode() == -2076481159 && method.equals("addProductToWindow")) {
            a(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
