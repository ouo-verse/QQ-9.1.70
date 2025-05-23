package com.tencent.sqshow.zootopia.avatar.loading.recorder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/e;", "", "", "type", "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/BaseLoadingAvatarRecorder;", "a", "b", "", "c", "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/d;", "l", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mRecorderPool", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f370046a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, BaseLoadingAvatarRecorder> mRecorderPool;

    static {
        e eVar = new e();
        f370046a = eVar;
        mRecorderPool = new HashMap<>();
        eVar.b(2);
        eVar.b(1);
    }

    e() {
    }

    public final BaseLoadingAvatarRecorder b(@AvatarRecordType int type) {
        HashMap<Integer, BaseLoadingAvatarRecorder> hashMap = mRecorderPool;
        BaseLoadingAvatarRecorder baseLoadingAvatarRecorder = hashMap.get(Integer.valueOf(type));
        if (baseLoadingAvatarRecorder != null) {
            return baseLoadingAvatarRecorder;
        }
        BaseLoadingAvatarRecorder a16 = a(type);
        hashMap.put(Integer.valueOf(type), a16);
        return a16;
    }

    public final void c() {
        Collection<BaseLoadingAvatarRecorder> values = mRecorderPool.values();
        Intrinsics.checkNotNullExpressionValue(values, "mRecorderPool.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((BaseLoadingAvatarRecorder) it.next()).l();
        }
    }

    public final void d(d l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        Collection<BaseLoadingAvatarRecorder> values = mRecorderPool.values();
        Intrinsics.checkNotNullExpressionValue(values, "mRecorderPool.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((BaseLoadingAvatarRecorder) it.next()).o(l3);
        }
    }

    private final BaseLoadingAvatarRecorder a(int type) {
        if (type == 1) {
            return new c();
        }
        return new b();
    }
}
