package com.tencent.kuikly.core.manager;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H\u0000\u00a2\u0006\u0004\b\t\u0010\b\"\u0011\u0010\r\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/manager/b;", "", "methodId", "", "", "args", "", "c", "(Lcom/tencent/kuikly/core/manager/b;I[Ljava/lang/Object;)V", "b", "", "a", "()Z", "ktIsInComposeThread", "core_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public static final boolean a() {
        return BridgeManager.f117344a.z();
    }

    public static final void b(b bVar, int i3, Object... args) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            bVar.onCallKotlin(i3, Arrays.copyOf(args, args.length));
        } catch (Throwable unused) {
        }
    }

    public static final void c(b bVar, int i3, Object... args) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            bVar.onCallNative(i3, Arrays.copyOf(args, args.length));
        } catch (Throwable unused) {
        }
    }
}
