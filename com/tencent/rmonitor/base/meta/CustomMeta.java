package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rmonitor/base/meta/CustomMeta;", "", "firstCustomField", "", "secondCustomField", "(Ljava/lang/String;Ljava/lang/String;)V", "getFirstCustomField", "()Ljava/lang/String;", "getSecondCustomField", "rmonitor-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes25.dex */
public final class CustomMeta {

    @NotNull
    private final String firstCustomField;

    @NotNull
    private final String secondCustomField;

    public CustomMeta(@NotNull String firstCustomField, @NotNull String secondCustomField) {
        Intrinsics.checkParameterIsNotNull(firstCustomField, "firstCustomField");
        Intrinsics.checkParameterIsNotNull(secondCustomField, "secondCustomField");
        this.firstCustomField = firstCustomField;
        this.secondCustomField = secondCustomField;
    }

    @NotNull
    public final String getFirstCustomField() {
        return this.firstCustomField;
    }

    @NotNull
    public final String getSecondCustomField() {
        return this.secondCustomField;
    }
}
