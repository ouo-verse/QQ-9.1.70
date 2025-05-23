package com.tencent.luggage.wxa.f7;

import com.tencent.mobileqq.vas.perception.api.IVipPerceptionKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends com.tencent.luggage.wxa.r6.a {

    /* renamed from: b, reason: collision with root package name */
    public String f125448b;

    /* renamed from: c, reason: collision with root package name */
    public String f125449c;

    /* renamed from: d, reason: collision with root package name */
    public String f125450d;

    /* renamed from: e, reason: collision with root package name */
    public String f125451e;

    /* renamed from: f, reason: collision with root package name */
    public String f125452f;

    /* renamed from: g, reason: collision with root package name */
    public int f125453g;

    /* renamed from: h, reason: collision with root package name */
    public int f125454h;

    public /* synthetic */ e(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) == 0 ? str5 : "", (i17 & 32) != 0 ? 0 : i3, (i17 & 64) != 0 ? 0 : i16);
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public int a() {
        return IVipPerceptionKt.VIP_PERCEPTION_OBTAIN_EXPERIENCE_ERR_CODE_REPEAT;
    }

    @Override // com.tencent.luggage.wxa.r6.a
    public String d() {
        String join = StringUtils.join(new String[]{this.f125448b, this.f125449c, this.f125450d, this.f125451e, this.f125452f, String.valueOf(this.f125453g), String.valueOf(this.f125454h)}, ",");
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u2026oString()\n        ), \",\")");
        return join;
    }

    public e(String str, String str2, String str3, String str4, String str5, int i3, int i16) {
        this.f125448b = str;
        this.f125449c = str2;
        this.f125450d = str3;
        this.f125451e = str4;
        this.f125452f = str5;
        this.f125453g = i3;
        this.f125454h = i16;
    }

    public final void a(int i3) {
        this.f125454h = i3;
    }
}
