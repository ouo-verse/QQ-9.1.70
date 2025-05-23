package com.tencent.mobileqq.nearbypro.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lsp4/c;", "", "a", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull sp4.c cVar) {
        String str;
        sp4.a aVar;
        sp4.b bVar;
        boolean z16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        sp4.a[] dresses = cVar.f434142c;
        Intrinsics.checkNotNullExpressionValue(dresses, "dresses");
        int length = dresses.length;
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 < length) {
                aVar = dresses[i3];
                if (aVar.f434131a == 1001) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            } else {
                aVar = null;
                break;
            }
        }
        if (aVar != null && (bVar = aVar.f434133c) != null) {
            str = bVar.f434137d;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
