package com.tencent.qqnt.qwallet.aio.pay;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\nj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/h;", "", "", "billNo", "", "c", "Lkotlin/Function0;", "listener", "a", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "billNoToListener", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f361811a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Function0<Unit>> billNoToListener = new HashMap<>();

    h() {
    }

    public final void a(@NotNull String billNo, @NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Intrinsics.checkNotNullParameter(listener, "listener");
        billNoToListener.put(billNo, listener);
    }

    public final void b(@NotNull String billNo) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        billNoToListener.remove(billNo);
    }

    public final void c(@NotNull String billNo) {
        Intrinsics.checkNotNullParameter(billNo, "billNo");
        Function0<Unit> function0 = billNoToListener.get(billNo);
        if (function0 != null) {
            function0.invoke();
        }
    }
}
