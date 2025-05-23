package com.tencent.ecommerce.biz.orders.buyerorders.submit.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/k;", "", "", "type", "", "platformName", "id", "a", "toString", "hashCode", "other", "", "equals", "I", "b", "Ljava/lang/String;", "c", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.model.k, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class VirtualProductAccount {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String platformName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    public VirtualProductAccount(int i3, String str, String str2) {
        this.type = i3;
        this.platformName = str;
        this.id = str2;
    }

    public final VirtualProductAccount a(int type, String platformName, String id5) {
        return new VirtualProductAccount(type, platformName, id5);
    }

    public int hashCode() {
        int i3 = this.type * 31;
        String str = this.platformName;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.id;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VirtualProductAccount(type=" + this.type + ", platformName=" + this.platformName + ", id=" + this.id + ")";
    }

    public /* synthetic */ VirtualProductAccount(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : str2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VirtualProductAccount)) {
            return false;
        }
        VirtualProductAccount virtualProductAccount = (VirtualProductAccount) other;
        return this.type == virtualProductAccount.type && Intrinsics.areEqual(this.platformName, virtualProductAccount.platformName) && Intrinsics.areEqual(this.id, virtualProductAccount.id);
    }

    public static /* synthetic */ VirtualProductAccount b(VirtualProductAccount virtualProductAccount, int i3, String str, String str2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = virtualProductAccount.type;
        }
        if ((i16 & 2) != 0) {
            str = virtualProductAccount.platformName;
        }
        if ((i16 & 4) != 0) {
            str2 = virtualProductAccount.id;
        }
        return virtualProductAccount.a(i3, str, str2);
    }
}
