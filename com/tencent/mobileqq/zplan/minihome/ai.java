package com.tencent.mobileqq.zplan.minihome;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lq55/d;", "Lcom/tencent/mobileqq/zplan/minihome/ag;", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ai {
    public static final MiniHomeInfo a(q55.d dVar) {
        String str;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(dVar, "<this>");
        r55.a aVar = dVar.f428438b;
        if (aVar == null || (bArr = aVar.f430776d) == null) {
            str = "";
        } else {
            str = new String(bArr, Charsets.UTF_8);
        }
        boolean z16 = dVar.f428437a;
        boolean z17 = dVar.f428439c;
        r55.a aVar2 = dVar.f428438b;
        String str2 = aVar2 != null ? aVar2.f430773a : null;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = aVar2 != null ? aVar2.f430774b : null;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = aVar2 != null ? aVar2.f430775c : null;
        if (str4 == null) {
            str4 = "";
        }
        ao aoVar = new ao(str2, str3, str4, str);
        boolean z18 = dVar.f428440d;
        q55.e eVar = dVar.f428441e;
        String str5 = eVar != null ? eVar.f428442a : null;
        if (str5 == null) {
            str5 = "";
        }
        String str6 = eVar != null ? eVar.f428443b : null;
        return new MiniHomeInfo(z16, z17, aoVar, z18, new GiftDesc(str5, str6 != null ? str6 : ""));
    }
}
