package com.tencent.luggage.wxa.zj;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.x3.a;
import com.tencent.mm.plugin.appbrand.profile.KVReportLogIdRemapping;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final f f146728a = new f();

    @Override // com.tencent.luggage.wxa.zj.d
    public void a(int i3, Object... vals) {
        Intrinsics.checkNotNullParameter(vals, "vals");
        String a16 = e.a(Arrays.copyOf(vals, vals.length));
        w.a("Luggage.KVReporter", "kvStat id:" + i3 + " value:" + a16);
        a(this, i3, a16, false, false, false, 28, null);
    }

    public final boolean b() {
        if (1 == com.tencent.luggage.wxa.p3.g.a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.zj.d
    public void a(int i3, String str) {
        w.a("Luggage.KVReporter", "kvStat id:" + i3 + " value:" + str);
        a(this, i3, str, false, false, false, 28, null);
    }

    @Override // com.tencent.luggage.wxa.zj.d
    public void a() {
        a.C6898a.f144554a.a().a();
    }

    public static /* synthetic */ void a(f fVar, int i3, String str, boolean z16, boolean z17, boolean z18, int i16, Object obj) {
        fVar.a(i3, str, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? false : z18);
    }

    public final void a(int i3, String str, boolean z16, boolean z17, boolean z18) {
        int a16 = z16 ? i3 : KVReportLogIdRemapping.f152267a.a(i3);
        if (a16 == 0) {
            w.f("Luggage.KVReporter", "doKvReport wx_log_id:" + i3 + " ignore undefined ilink_log_id");
            return;
        }
        int i16 = !b() ? 1 : 0;
        com.tencent.luggage.wxa.x3.a a17 = a.C6898a.f144554a.a();
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a17.writeKvData(a16, bytes, z17, 0, false, i16);
    }
}
