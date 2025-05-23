package com.tencent.luggage.wxa.f7;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.luggage.wxa.i3.n;
import com.tencent.luggage.wxa.j4.k;
import com.tencent.luggage.wxa.j4.l;
import com.tencent.luggage.wxa.n3.e0;
import com.tencent.luggage.wxa.q7.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements l, k {

    /* renamed from: c, reason: collision with root package name */
    public static final g f125459c = new g();

    @Override // com.tencent.luggage.wxa.j4.l
    public /* synthetic */ String a() {
        return w21.c.a(this);
    }

    @Override // com.tencent.luggage.wxa.j4.k
    public /* synthetic */ String b() {
        return w21.b.a(this);
    }

    public final void c() {
        l.b.f130852a = this;
        k.b.f130850a = this;
    }

    @Override // com.tencent.luggage.wxa.j4.l
    public String a(com.tencent.luggage.wxa.j4.d dVar) {
        String str;
        String id5 = b();
        if (dVar != null && (str = dVar.f130793e0) != null) {
            if (str.length() > 0) {
                id5 = id5 + "&host_scene=" + new n(str, false, 2, (DefaultConstructorMarker) null).a();
            }
        }
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        return id5;
    }

    @Override // com.tencent.luggage.wxa.j4.l
    public String a(com.tencent.luggage.wxa.ki.a aVar) {
        String str;
        String id5 = b();
        if (aVar != null && (str = aVar.F) != null) {
            if (str.length() > 0) {
                id5 = id5 + "&host_scene=" + new n(str, false, 2, (DefaultConstructorMarker) null).a();
            }
        }
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        return id5;
    }

    @Override // com.tencent.luggage.wxa.j4.k
    public String a(long j3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("hash=");
        e0.a aVar = e0.f135163b;
        s.d dVar = s.d.f138074a;
        sb5.append(aVar.b(dVar.c()));
        String join = StringUtils.join(new String[]{sb5.toString(), "ts=" + j3, "host=" + dVar.b(), "version=603979777", "device=2"}, ContainerUtils.FIELD_DELIMITER);
        Intrinsics.checkNotNullExpressionValue(join, "join(arrayOf(\n          \u20262-android\n        ), \"&\")");
        return join;
    }
}
