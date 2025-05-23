package com.tencent.ecommerce.biz.logistics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/logistics/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "code", "b", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.logistics.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECExpressCompany {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    public ECExpressCompany(String str, String str2) {
        this.code = str;
        this.name = str2;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ECExpressCompany(code=" + this.code + ", name=" + this.name + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECExpressCompany)) {
            return false;
        }
        ECExpressCompany eCExpressCompany = (ECExpressCompany) other;
        return Intrinsics.areEqual(this.code, eCExpressCompany.code) && Intrinsics.areEqual(this.name, eCExpressCompany.name);
    }
}
