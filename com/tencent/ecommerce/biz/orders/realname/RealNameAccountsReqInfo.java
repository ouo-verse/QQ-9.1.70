package com.tencent.ecommerce.biz.orders.realname;

import com.tencent.ecommerce.base.list.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/realname/b;", "Lcom/tencent/ecommerce/base/list/f;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "cookie", "<init>", "(Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.orders.realname.b, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class RealNameAccountsReqInfo extends f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String cookie;

    public RealNameAccountsReqInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public int hashCode() {
        String str = this.cookie;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "RealNameAccountsReqInfo(cookie=" + this.cookie + ")";
    }

    public RealNameAccountsReqInfo(String str) {
        this.cookie = str;
    }

    public /* synthetic */ RealNameAccountsReqInfo(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RealNameAccountsReqInfo) && Intrinsics.areEqual(this.cookie, ((RealNameAccountsReqInfo) other).cookie);
        }
        return true;
    }
}
