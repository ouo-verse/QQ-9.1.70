package com.qzone.publish.business.publishqueue.intimate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/qzone/publish/business/publishqueue/intimate/d;", "", "", "uid", "Lcom/qzone/publish/business/publishqueue/intimate/c;", "a", "", "b", "Ljava/util/Map;", "batchUtilMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f51164a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, c> batchUtilMap = new LinkedHashMap();

    d() {
    }

    public final c a(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Map<String, c> map = batchUtilMap;
        c cVar = map.get(uid);
        if (cVar == null) {
            cVar = new c();
            map.put(uid, cVar);
        }
        return cVar;
    }
}
