package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tj\u0004\u0018\u0001`\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/b;", "Li01/e;", "", "params", "a", "", "c", "d", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends i01.e {
    private final String a(String params) {
        if (params == null) {
            return "";
        }
        return ECLocalConfig.f100650f.getString(params, "", Boolean.FALSE);
    }

    private final void d(String params) {
        if (params == null) {
            params = "{}";
        }
        JSONObject jSONObject = new JSONObject(params);
        ECLocalConfig.f100650f.setString(jSONObject.optString("key"), jSONObject.optString("value"), Boolean.FALSE);
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        int hashCode = method.hashCode();
        if (hashCode != -75439223) {
            if (hashCode != 1098253751) {
                if (hashCode == 1984670357 && method.equals("setItem")) {
                    d(params);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("removeItem")) {
                c(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("getItem")) {
            return a(params);
        }
        return super.call(method, params, callback);
    }

    private final void c(String params) {
        if (params != null) {
            ECLocalConfig.f100650f.remove(params, Boolean.FALSE);
        }
    }
}
