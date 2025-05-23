package com.tencent.mobileqq.zplan.minihome.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/data/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "id", "J", "a", "()J", "subState", "I", "b", "()I", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.minihome.data.a, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class DecorateIdentifies {

    @SerializedName("id")
    private final long id;

    @SerializedName("subState")
    private final int subState;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getSubState() {
        return this.subState;
    }

    public int hashCode() {
        return (com.tencent.mobileqq.vas.banner.c.a(this.id) * 31) + this.subState;
    }

    public String toString() {
        return "DecorateIdentifies(id=" + this.id + ", subState=" + this.subState + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecorateIdentifies)) {
            return false;
        }
        DecorateIdentifies decorateIdentifies = (DecorateIdentifies) other;
        return this.id == decorateIdentifies.id && this.subState == decorateIdentifies.subState;
    }
}
