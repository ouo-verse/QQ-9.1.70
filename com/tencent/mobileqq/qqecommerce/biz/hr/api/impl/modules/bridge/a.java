package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.bridge;

import android.support.v4.util.ArrayMap;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\r\u001a\u00020\u0004H&J,\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\u000f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00020\u000eJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0014\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R6\u0010\u001c\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00020\u000e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/bridge/a;", "", "", "g", "", "method", "Lorg/json/JSONObject;", "param", "callback", "", "d", "ns", "e", "f", "Lkotlin/Function2;", "func", h.F, "data", "b", HippyQQHttpModule.HTPP_ERROR_TEXT, "c", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "a", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "()Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;", "bridgeModule", "Landroid/support/v4/util/ArrayMap;", "Landroid/support/v4/util/ArrayMap;", "funcMap", "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/modules/a;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a bridgeModule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayMap<String, Function2<JSONObject, String, Unit>> funcMap;

    public a(com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a bridgeModule) {
        Intrinsics.checkNotNullParameter(bridgeModule, "bridgeModule");
        this.bridgeModule = bridgeModule;
        this.funcMap = new ArrayMap<>();
        g();
    }

    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.modules.a getBridgeModule() {
        return this.bridgeModule;
    }

    public final void b(String callback, Object data) {
        this.bridgeModule.T(callback, data);
    }

    public final void c(String callback, String errorText) {
        Intrinsics.checkNotNullParameter(errorText, "errorText");
        this.bridgeModule.U(callback, errorText);
    }

    public final boolean d(String method, JSONObject param, String callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        Function2<JSONObject, String, Unit> function2 = this.funcMap.get(method);
        if (function2 == null) {
            return false;
        }
        function2.invoke(param, callback);
        return true;
    }

    public final boolean e(String ns5) {
        Intrinsics.checkNotNullParameter(ns5, "ns");
        return f().equals(ns5);
    }

    public abstract String f();

    public abstract void g();

    public final void h(String method, Function2<? super JSONObject, ? super String, Unit> func) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(func, "func");
        this.funcMap.put(method, func);
    }
}
