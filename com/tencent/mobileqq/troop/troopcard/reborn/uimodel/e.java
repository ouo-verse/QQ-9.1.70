package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/d;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/c;", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    @NotNull
    public static final c a(@NotNull d dVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        if (dVar.d().b()) {
            if (dVar.d().a().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new c.a(dVar.d().a());
            }
        }
        if (dVar.g() && !dVar.c()) {
            if (dVar.h()) {
                return c.b.f299749a;
            }
            return c.d.f299751a;
        }
        if (dVar.e() != null) {
            return new c.C8796c(dVar.e());
        }
        return c.d.f299751a;
    }
}
