package com.tencent.kuikly.core.kmp;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\u0006J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u000e\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0013j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/kuikly/core/kmp/b;", "T", "", "", "key", "b", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "", "e", "(Ljava/lang/String;Ljava/lang/Object;)V", "d", "", "a", "c", "Ljava/lang/String;", "globalKey", "Z", "isThreadSafetyMode", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "keyValueMap", "Ljava/lang/Object;", "globalValue", "Lcom/tencent/kuikly/core/kmp/c;", "Lcom/tencent/kuikly/core/kmp/c;", "rwLock", "<init>", "(Ljava/lang/String;Z)V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String globalKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isThreadSafetyMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, T> keyValueMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private T globalValue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private c rwLock;

    public b(String globalKey, boolean z16) {
        Intrinsics.checkNotNullParameter(globalKey, "globalKey");
        this.globalKey = globalKey;
        this.isThreadSafetyMode = z16;
        this.keyValueMap = new HashMap<>();
        if (z16) {
            this.rwLock = new c();
        }
    }

    public final boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, this.globalKey)) {
            return this.globalValue != null;
        }
        c cVar = this.rwLock;
        if (cVar != null) {
            cVar.a();
        }
        boolean containsKey = this.keyValueMap.containsKey(key);
        c cVar2 = this.rwLock;
        if (cVar2 != null) {
            cVar2.b();
        }
        return containsKey;
    }

    public final T b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, this.globalKey)) {
            return this.globalValue;
        }
        c cVar = this.rwLock;
        if (cVar != null) {
            cVar.a();
        }
        T t16 = this.keyValueMap.get(key);
        c cVar2 = this.rwLock;
        if (cVar2 == null) {
            return t16;
        }
        cVar2.b();
        return t16;
    }

    public final boolean c() {
        c cVar = this.rwLock;
        if (cVar != null) {
            cVar.a();
        }
        boolean isEmpty = this.keyValueMap.isEmpty();
        c cVar2 = this.rwLock;
        if (cVar2 != null) {
            cVar2.b();
        }
        return isEmpty;
    }

    public final T d(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, this.globalKey)) {
            T t16 = this.globalValue;
            this.globalValue = null;
            return t16;
        }
        c cVar = this.rwLock;
        if (cVar != null) {
            cVar.c();
        }
        T remove = this.keyValueMap.remove(key);
        c cVar2 = this.rwLock;
        if (cVar2 != null) {
            cVar2.d();
        }
        return remove;
    }

    public final void e(String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (Intrinsics.areEqual(key, this.globalKey)) {
            this.globalValue = value;
            return;
        }
        c cVar = this.rwLock;
        if (cVar != null) {
            cVar.c();
        }
        this.keyValueMap.put(key, value);
        c cVar2 = this.rwLock;
        if (cVar2 != null) {
            cVar2.d();
        }
    }

    public /* synthetic */ b(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? false : z16);
    }
}
