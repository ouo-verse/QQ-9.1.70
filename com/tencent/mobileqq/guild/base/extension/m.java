package com.tencent.mobileqq.guild.base.extension;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"", "", "b", "a", "(Ljava/lang/Object;)Ljava/lang/String;", "identityString", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class m {
    @NotNull
    public static final String a(@NotNull Object obj) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        int identityHashCode = System.identityHashCode(obj);
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(identityHashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return simpleName + "@" + num;
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        int checkRadix;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String simpleName = obj.getClass().getSimpleName();
        int identityHashCode = System.identityHashCode(obj);
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(identityHashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return simpleName + "@" + num + ":" + SystemClock.uptimeMillis();
    }
}
