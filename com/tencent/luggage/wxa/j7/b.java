package com.tencent.luggage.wxa.j7;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.luggage.wxa.tn.b1;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b implements com.tencent.luggage.wxa.j7.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f130885b = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String appId, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            String format = String.format("<sysmsg type=\"AppBrandForceKill\"><AppBrandForceKill>\n\t<AppId>%s</AppId>\n\t<VersionType>%d</VersionType>\n</AppBrandForceKill></sysmsg>", Arrays.copyOf(new Object[]{appId, Integer.valueOf(i3)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            Context c16 = z.c();
            Intent intent = new Intent();
            byte[] bytes = format.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            intent.putExtra("kContent", Base64.encode(bytes, 0));
            intent.putExtra("kAction", "ForceKillAppNotify");
            intent.setAction("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION");
            c16.sendBroadcast(intent);
        }
    }

    public static final void b(String str, int i3) {
        f130885b.a(str, i3);
    }

    @Override // com.tencent.luggage.wxa.j7.a
    public void a(Intent intent, String xml) {
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(xml, "xml");
        boolean z17 = true;
        if (xml.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Map a16 = b1.a(xml, "sysmsg", null);
        String str = (String) a16.get(".sysmsg.AppBrandForceKill.AppId");
        int a17 = w0.a((String) a16.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
        if (str != null && str.length() != 0) {
            z17 = false;
        }
        if (z17) {
            return;
        }
        a(str, a17);
    }

    public abstract void a(String str, int i3);

    @Override // com.tencent.luggage.wxa.j7.a
    public String name() {
        return "ForceKillAppNotify";
    }
}
