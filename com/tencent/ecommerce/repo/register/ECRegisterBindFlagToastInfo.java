package com.tencent.ecommerce.repo.register;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/repo/register/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "state", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.register.d, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class ECRegisterBindFlagToastInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    public ECRegisterBindFlagToastInfo() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int i3 = this.state * 31;
        String str = this.msg;
        return i3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ECRegisterBindFlagToastInfo(state=" + this.state + ", msg=" + this.msg + ")";
    }

    public ECRegisterBindFlagToastInfo(int i3, String str) {
        this.state = i3;
        this.msg = str;
    }

    public /* synthetic */ ECRegisterBindFlagToastInfo(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? "" : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ECRegisterBindFlagToastInfo)) {
            return false;
        }
        ECRegisterBindFlagToastInfo eCRegisterBindFlagToastInfo = (ECRegisterBindFlagToastInfo) other;
        return this.state == eCRegisterBindFlagToastInfo.state && Intrinsics.areEqual(this.msg, eCRegisterBindFlagToastInfo.msg);
    }
}
