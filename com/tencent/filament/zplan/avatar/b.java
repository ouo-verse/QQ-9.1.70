package com.tencent.filament.zplan.avatar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\t\fB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R&\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/avatar/b;", "T", "", "", "avatarString", "c", "(Ljava/lang/String;)Ljava/lang/Object;", "data", "", "a", "(Ljava/lang/String;Ljava/lang/Object;)V", "d", "b", "toString", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/filament/zplan/avatar/b$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "avatarInfoToResourceMap", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, CachePair<T>> avatarInfoToResourceMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/filament/zplan/avatar/b$a;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "c", "(I)V", "useCount", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "<init>", "(ILjava/lang/Object;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.avatar.b$a, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class CachePair<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int useCount;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final T data;

        public CachePair(int i3, T t16) {
            this.useCount = i3;
            this.data = t16;
        }

        public final T a() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getUseCount() {
            return this.useCount;
        }

        public final void c(int i3) {
            this.useCount = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof CachePair) {
                    CachePair cachePair = (CachePair) other;
                    if (this.useCount != cachePair.useCount || !Intrinsics.areEqual(this.data, cachePair.data)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16 = this.useCount * 31;
            T t16 = this.data;
            if (t16 != null) {
                i3 = t16.hashCode();
            } else {
                i3 = 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "CachePair(useCount=" + this.useCount + ", data=" + this.data + ")";
        }
    }

    public final void a(@NotNull String avatarString, T data) {
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        this.avatarInfoToResourceMap.put(avatarString, new CachePair<>(1, data));
    }

    public final void b() {
        this.avatarInfoToResourceMap.clear();
    }

    @Nullable
    public final T c(@NotNull String avatarString) {
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        CachePair<T> cachePair = this.avatarInfoToResourceMap.get(avatarString);
        if (cachePair != null) {
            cachePair.c(cachePair.getUseCount() + 1);
            return cachePair.a();
        }
        return null;
    }

    public final void d() {
        if (this.avatarInfoToResourceMap.size() < 5) {
            return;
        }
        int i3 = Integer.MAX_VALUE;
        String str = null;
        for (Map.Entry<String, CachePair<T>> entry : this.avatarInfoToResourceMap.entrySet()) {
            if (entry.getValue().getUseCount() < i3) {
                i3 = entry.getValue().getUseCount();
                str = entry.getKey();
            }
        }
        if (str != null) {
            this.avatarInfoToResourceMap.remove(str);
        }
    }

    @NotNull
    public String toString() {
        return "size:" + this.avatarInfoToResourceMap.size();
    }
}
