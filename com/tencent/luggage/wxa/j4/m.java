package com.tencent.luggage.wxa.j4;

import android.content.Context;
import com.tencent.luggage.wxa.cp.l;
import com.tencent.luggage.wxa.tn.z;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FilenameUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f130854b;

    /* renamed from: a, reason: collision with root package name */
    public static final m f130853a = new m();

    /* renamed from: c, reason: collision with root package name */
    public static String f130855c = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements l.d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f130856a = new a();

        @Override // com.tencent.luggage.wxa.cp.l.d
        public final void a(l.c e16) {
            e16.a("assets", com.tencent.luggage.wxa.cp.c.a());
            e16.a("content", com.tencent.luggage.wxa.cp.e.a());
            m mVar = m.f130853a;
            Intrinsics.checkNotNullExpressionValue(e16, "e");
            mVar.a(e16);
        }
    }

    public static /* synthetic */ void a(m mVar, boolean z16, String str, Context context, l.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = z.m();
        }
        if ((i3 & 2) != 0) {
            str = z.i();
            Intrinsics.checkNotNullExpressionValue(str, "getProcessName()");
        }
        if ((i3 & 4) != 0) {
            context = z.c();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        }
        if ((i3 & 8) != 0) {
            eVar = null;
        }
        mVar.a(z16, str, context, eVar);
    }

    public final void a(boolean z16, String processName, Context context, l.e eVar) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        Intrinsics.checkNotNullParameter(context, "context");
        f130854b = z16;
        f130855c = processName;
        com.tencent.luggage.wxa.cp.l.c(context);
        com.tencent.luggage.wxa.cp.l.c(!z16);
        if (eVar != null) {
            com.tencent.luggage.wxa.cp.l.a(eVar);
        }
        com.tencent.luggage.wxa.cp.l.a(a.f130856a);
    }

    public final void a(l.c cVar) {
        String concat = FilenameUtils.concat(com.tencent.luggage.wxa.db.a.e(), "networkfiles");
        cVar.a("networkfiles", new com.tencent.luggage.wxa.cp.h(new com.tencent.luggage.wxa.cp.m(concat), TimeUnit.DAYS.toMillis(3L)));
        cVar.a(concat, "networkfiles");
        String concat2 = FilenameUtils.concat(com.tencent.luggage.wxa.db.a.a(), "skyline_cache");
        cVar.a("WxaSkylineCache", new com.tencent.luggage.wxa.cp.m(concat2));
        cVar.a(concat2, "WxaSkylineCache");
        String concat3 = FilenameUtils.concat(com.tencent.luggage.wxa.db.a.a(), "chromium_cronet_cache");
        cVar.a("WxaChromiumCronetCache", new com.tencent.luggage.wxa.cp.m(concat3));
        cVar.a(concat3, "WxaChromiumCronetCache");
        String concat4 = FilenameUtils.concat(com.tencent.luggage.wxa.db.a.a(), "cronet_request_cache");
        cVar.a("WxaCronetRequestCache", new com.tencent.luggage.wxa.cp.m(concat4));
        cVar.a(concat4, "WxaCronetRequestCache");
    }
}
