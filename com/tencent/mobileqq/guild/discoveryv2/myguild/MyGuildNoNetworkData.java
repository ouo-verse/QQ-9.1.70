package com.tencent.mobileqq.guild.discoveryv2.myguild;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/w;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "refreshBlock", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.w, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class MyGuildNoNetworkData extends h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Function0<Unit> refreshBlock;

    public MyGuildNoNetworkData(@NotNull Function0<Unit> refreshBlock) {
        Intrinsics.checkNotNullParameter(refreshBlock, "refreshBlock");
        this.refreshBlock = refreshBlock;
    }

    @NotNull
    public final Function0<Unit> a() {
        return this.refreshBlock;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof MyGuildNoNetworkData) && Intrinsics.areEqual(this.refreshBlock, ((MyGuildNoNetworkData) other).refreshBlock)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.h
    public int hashCode() {
        return this.refreshBlock.hashCode();
    }

    @NotNull
    public String toString() {
        return "MyGuildNoNetworkData(refreshBlock=" + this.refreshBlock + ")";
    }
}
