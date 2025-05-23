package com.tencent.ntcompose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\bR+\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ntcompose/material/p;", "", "", "<set-?>", "a", "Landroidx/compose/runtime/MutableState;", "()Z", "b", "(Z)V", "isRefreshing", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final MutableState isRefreshing;

    public p(boolean z16) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z16), null, 2, null);
        this.isRefreshing = mutableStateOf$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        return ((Boolean) this.isRefreshing.getValue()).booleanValue();
    }

    public final void b(boolean z16) {
        this.isRefreshing.setValue(Boolean.valueOf(z16));
    }
}
