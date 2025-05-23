package com.tencent.mobileqq.wink.editor.util;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/d;", "", "", "b", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f322631a = new d();

    d() {
    }

    @NotNull
    public final String a() {
        boolean z16;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z17 = true;
            if (stackTrace != null) {
                if (stackTrace.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = false;
                }
            }
            if (z17) {
                return "";
            }
            StringBuilder sb5 = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb5.append(stackTraceElement.toString());
                sb5.append("\n");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "{\n            val stackT\u2026lder.toString()\n        }");
            return sb6;
        } catch (Throwable unused) {
            return "";
        }
    }

    public final boolean b() {
        List mutableListOf;
        boolean equals;
        String model = DeviceInfoMonitor.getModel();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("noh-an00", "noh-an01", "noh-al00", "noh-al10", "noh-nx9", "nop-an00", "oce-an10", "oce-an50");
        List list = mutableListOf;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            equals = StringsKt__StringsJVMKt.equals((String) it.next(), model, true);
            if (equals) {
                return true;
            }
        }
        return false;
    }
}
