package com.tencent.ntcompose.lifecycle.viewmodel;

import com.tencent.ntcompose.lifecycle.viewmodel.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0001\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0086\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/f;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "T", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b$b;", "key", "t", "", "b", "(Lcom/tencent/ntcompose/lifecycle/viewmodel/b$b;Ljava/lang/Object;)V", "initialExtras", "<init>", "(Lcom/tencent/ntcompose/lifecycle/viewmodel/b;)V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f extends b {
    public f(b initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        a().putAll(initialExtras.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void b(b.InterfaceC9259b<T> key, T t16) {
        Intrinsics.checkNotNullParameter(key, "key");
        a().put(key, t16);
    }
}
