package com.qzone.reborn.feedpro.utils;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J1\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ9\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\f\u0010\rR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/b;", "", "T", "", "key", "pageId", "data", "", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Class;", "clazz", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "", "Ljava/util/Map;", "dataMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f54315a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Object> dataMap = new LinkedHashMap();

    b() {
    }

    public final <T> T a(String key, String pageId, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        T t16 = (T) dataMap.remove(pageId + "_" + key);
        QLog.d("QzoneBigDataTransferManager", 1, "getAndRemoveData key:" + pageId + "_" + key + " data:" + t16);
        if (!clazz.isInstance(t16)) {
            return null;
        }
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.qzone.reborn.feedpro.utils.QzoneBigDataTransferManager.getAndRemoveData");
        return t16;
    }

    public final <T> void b(String key, String pageId, T data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        dataMap.put(pageId + "_" + key, data);
        QLog.d("QzoneBigDataTransferManager", 1, "putData key:" + pageId + "_" + key + " data:" + data);
    }
}
