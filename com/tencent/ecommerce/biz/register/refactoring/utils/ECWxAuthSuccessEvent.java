package com.tencent.ecommerce.biz.register.refactoring.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isSuccessWxAuth", "b", "Ljava/lang/String;", "nickName", "<init>", "(ZLjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.biz.register.refactoring.utils.e, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECWxAuthSuccessEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean isSuccessWxAuth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String nickName;

    public ECWxAuthSuccessEvent(boolean z16, String str) {
        this.isSuccessWxAuth = z16;
        this.nickName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isSuccessWxAuth;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        String str = this.nickName;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECWxAuthSuccessEvent(isSuccessWxAuth=" + this.isSuccessWxAuth + ", nickName=" + this.nickName + ")";
    }

    public /* synthetic */ ECWxAuthSuccessEvent(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECWxAuthSuccessEvent)) {
            return false;
        }
        ECWxAuthSuccessEvent eCWxAuthSuccessEvent = (ECWxAuthSuccessEvent) other;
        return this.isSuccessWxAuth == eCWxAuthSuccessEvent.isSuccessWxAuth && Intrinsics.areEqual(this.nickName, eCWxAuthSuccessEvent.nickName);
    }
}
