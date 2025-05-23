package com.tencent.mobileqq.flock.ktx;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Ly45/f;", "Lb55/g;", "b", "a", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {
    @NotNull
    public static final y45.f a(@NotNull b55.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        y45.f fVar = new y45.f();
        fVar.f449391a = gVar.f27973a;
        fVar.f449392b = gVar.f27974b;
        return fVar;
    }

    @NotNull
    public static final b55.g b(@NotNull y45.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        b55.g gVar = new b55.g();
        gVar.f27973a = fVar.f449391a;
        gVar.f27974b = fVar.f449392b;
        return gVar;
    }
}
