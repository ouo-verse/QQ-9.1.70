package com.tencent.ecommerce.base.report.service;

import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\nR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/m;", "", "", "isSelect", "b", "isHost", "a", "", QzoneIPCModule.RESULT_CODE, "c", "", "d", "", "Ljava/util/Map;", "paramsMap", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<Object, Object> paramsMap = new LinkedHashMap();

    public final m a(boolean isHost) {
        this.paramsMap.put("is_host", Integer.valueOf(isHost ? 1 : 0));
        return this;
    }

    public final m b(boolean isSelect) {
        this.paramsMap.put("is_select", Integer.valueOf(isSelect ? 1 : 0));
        return this;
    }

    public final m c(int resultCode) {
        this.paramsMap.put("result_code", Integer.valueOf(resultCode));
        return this;
    }

    public final Map<Object, Object> d() {
        return this.paramsMap;
    }
}
