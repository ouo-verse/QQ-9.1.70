package com.tencent.luggage.wxa.i5;

import com.tencent.luggage.wxa.hn.gi;
import com.tencent.luggage.wxa.hn.n9;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final gi f129489a;

    /* renamed from: b, reason: collision with root package name */
    public final gi f129490b;

    /* renamed from: c, reason: collision with root package name */
    public final n9 f129491c;

    public h(gi hostAppInfo, gi giVar, n9 usageInfo) {
        Intrinsics.checkNotNullParameter(hostAppInfo, "hostAppInfo");
        Intrinsics.checkNotNullParameter(usageInfo, "usageInfo");
        this.f129489a = hostAppInfo;
        this.f129490b = giVar;
        this.f129491c = usageInfo;
    }

    public final gi a() {
        return this.f129489a;
    }

    public final gi b() {
        return this.f129490b;
    }

    public final n9 c() {
        return this.f129491c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (Intrinsics.areEqual(this.f129489a, hVar.f129489a) && Intrinsics.areEqual(this.f129490b, hVar.f129490b) && Intrinsics.areEqual(this.f129491c, hVar.f129491c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.f129489a.hashCode() * 31;
        gi giVar = this.f129490b;
        if (giVar == null) {
            hashCode = 0;
        } else {
            hashCode = giVar.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.f129491c.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("UserInfoUsageInfoItem(hostAppInfo=");
        sb5.append(a(this.f129489a));
        sb5.append(", hostPluginInfo=");
        gi giVar = this.f129490b;
        if (giVar == null || (str = a(giVar)) == null) {
            str = "null";
        }
        sb5.append(str);
        sb5.append(", usageInfo=");
        sb5.append(this.f129491c.c());
        sb5.append(')');
        return sb5.toString();
    }

    public final String a(gi giVar) {
        return "WxaUseUserInfoItem(appid=" + giVar.f127725d + ", nick_name=" + giVar.f127726e + ", icon_url=" + giVar.f127727f + ')';
    }
}
