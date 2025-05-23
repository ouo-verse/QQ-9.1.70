package com.tencent.mobileqq.qwallet.pet.filament;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J(\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/c;", "", "", "petType", "actionType", "controllerId", "", "c", "", "progress", "d", "g", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface c {
    void c(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId);

    void d(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId, float progress);

    void g(@NotNull String petType, @NotNull String actionType, @NotNull String controllerId);
}
