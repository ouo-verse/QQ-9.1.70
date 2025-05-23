package com.tencent.mobileqq.qqecommerce.base.somanager;

import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\bR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/somanager/c;", "", "", "isHost", "a", "", QzoneIPCModule.RESULT_CODE, "b", "", "c", "", "Ljava/util/Map;", "paramsMap", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Map<Object, Object> paramsMap = new LinkedHashMap();

    public final c a(boolean isHost) {
        this.paramsMap.put("is_host", Integer.valueOf(isHost ? 1 : 0));
        return this;
    }

    public final c b(int resultCode) {
        this.paramsMap.put("result_code", Integer.valueOf(resultCode));
        return this;
    }

    public final Map<Object, Object> c() {
        return this.paramsMap;
    }
}
