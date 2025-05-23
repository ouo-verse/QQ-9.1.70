package com.tencent.luggage.wxa.f7;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f125445b;

    /* renamed from: c, reason: collision with root package name */
    public String f125446c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f125447d;

    public /* synthetic */ d(String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? false : z16);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return 10099;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new Object[]{this.f125445b, this.f125446c, Boolean.valueOf(this.f125447d)}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026owWording\n        ), \",\")");
        return join;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (Intrinsics.areEqual(this.f125445b, dVar.f125445b) && Intrinsics.areEqual(this.f125446c, dVar.f125446c) && this.f125447d == dVar.f125447d) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f125445b.hashCode() * 31) + this.f125446c.hashCode()) * 31;
        boolean z16 = this.f125447d;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "KVReport_UserCloseWeAppWhenLoading(instanceId=" + this.f125445b + ", wxaAppId=" + this.f125446c + ", hasShowWording=" + this.f125447d + ')';
    }

    public d(String instanceId, String wxaAppId, boolean z16) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(wxaAppId, "wxaAppId");
        this.f125445b = instanceId;
        this.f125446c = wxaAppId;
        this.f125447d = z16;
    }
}
