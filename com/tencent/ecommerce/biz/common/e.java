package com.tencent.ecommerce.biz.common;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\nJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\nR\"\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/common/e;", "", "", "busId", "a", "sellId", "d", "key", "value", "b", "", "extMap", "c", "f", "", "Ljava/util/Map;", "paramsMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<Object, Object> paramsMap;

    public e() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.paramsMap = linkedHashMap;
        linkedHashMap.put("uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
    }

    public final e a(String busId) {
        this.paramsMap.put("bus_id", busId);
        return this;
    }

    public final e b(String key, String value) {
        this.paramsMap.put(key, value);
        return this;
    }

    public final e c(Map<String, String> extMap) {
        this.paramsMap.putAll(extMap);
        return this;
    }

    public final e d(String sellId) {
        this.paramsMap.put("seller_id", sellId);
        return this;
    }

    public final Map<Object, Object> f() {
        return this.paramsMap;
    }

    public static /* synthetic */ e e(e eVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = com.tencent.ecommerce.biz.register.b.f103963a.a();
        }
        return eVar.d(str);
    }
}
