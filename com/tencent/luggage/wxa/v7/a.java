package com.tencent.luggage.wxa.v7;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.ilink.BuildConfig;
import com.tencent.luggage.wxa.q7.f0;
import com.tencent.luggage.wxa.q7.h0;
import com.tencent.luggage.wxa.q7.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.x3.a;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final C6835a f143290a = new C6835a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.v7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6835a {
        public C6835a() {
        }

        public /* synthetic */ C6835a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x01ad, code lost:
    
        if (com.tencent.luggage.wxa.q7.r.f138048a.b() == false) goto L29;
     */
    @Override // com.tencent.luggage.wxa.v7.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context) {
        Application application;
        String str;
        String str2;
        String str3;
        String replace$default;
        Application application2;
        long j3;
        String str4;
        String str5;
        boolean contains$default;
        String str6;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Application) {
            application = (Application) context;
        } else {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            application = (Application) applicationContext;
        }
        com.tencent.luggage.wxa.e5.g gVar = com.tencent.luggage.wxa.e5.g.f124544a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        f0.h();
        Unit unit = Unit.INSTANCE;
        String obj = unit.toString();
        if (obj == null) {
            obj = "";
        }
        boolean a16 = l0.a();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (elapsedRealtime2 <= 32 || !a16) {
            str = "";
            str2 = "block main thread and skip ";
            StringBuilder sb5 = new StringBuilder();
            str3 = "runProfiled:log:";
            sb5.append(str3);
            sb5.append("WxaSensitiveApiInvokeHolder");
            sb5.append(" cost ");
            sb5.append(elapsedRealtime2);
            sb5.append(" ms result:");
            sb5.append(obj);
            sb5.append(" isMainThread: ");
            sb5.append(a16);
            sb5.append(TokenParser.SP);
            w.d("Luggage.Utils.Profile", sb5.toString());
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("block main thread and skip ");
            str = "";
            str2 = "block main thread and skip ";
            sb6.append((int) (elapsedRealtime2 / 16));
            sb6.append(" frames! runProfiled:log:");
            sb6.append("WxaSensitiveApiInvokeHolder");
            sb6.append(" cost ");
            sb6.append(elapsedRealtime2);
            sb6.append(" ms result:");
            sb6.append(obj);
            sb6.append(" isMainThread: ");
            sb6.append(a16);
            sb6.append(TokenParser.SP);
            w.f("Luggage.Utils.Profile", sb6.toString());
            str3 = "runProfiled:log:";
        }
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        com.tencent.luggage.wxa.db.a.a("wxa");
        long elapsedRealtime4 = SystemClock.elapsedRealtime();
        String i3 = z.i();
        Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
        replace$default = StringsKt__StringsJVMKt.replace$default(i3, ":", "_", false, 4, (Object) null);
        h0.a(replace$default);
        String obj2 = unit.toString();
        if (obj2 == null) {
            obj2 = str;
        }
        boolean a17 = l0.a();
        long elapsedRealtime5 = SystemClock.elapsedRealtime() - elapsedRealtime4;
        if (elapsedRealtime5 > 32 && a17) {
            StringBuilder sb7 = new StringBuilder();
            application2 = application;
            str5 = str2;
            sb7.append(str5);
            j3 = elapsedRealtime3;
            str4 = str3;
            sb7.append((int) (elapsedRealtime5 / 16));
            sb7.append(" frames! runProfiled:log:");
            sb7.append("XLogSetup-LogImp");
            sb7.append(" cost ");
            sb7.append(elapsedRealtime5);
            sb7.append(" ms result:");
            sb7.append(obj2);
            sb7.append(" isMainThread: ");
            sb7.append(a17);
            sb7.append(TokenParser.SP);
            w.f("Luggage.Utils.Profile", sb7.toString());
        } else {
            application2 = application;
            j3 = elapsedRealtime3;
            str4 = str3;
            str5 = str2;
            w.d("Luggage.Utils.Profile", str4 + "XLogSetup-LogImp cost " + elapsedRealtime5 + " ms result:" + obj2 + " isMainThread: " + a17 + TokenParser.SP);
        }
        long elapsedRealtime6 = SystemClock.elapsedRealtime();
        String processName = z.i();
        Intrinsics.checkNotNullExpressionValue(processName, "processName");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) ":wxa_container", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) processName, (CharSequence) BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, (Object) null);
            if (!contains$default2) {
            }
        }
        com.tencent.luggage.wxa.s7.b.f140101a.a();
        String obj3 = unit.toString();
        if (obj3 == null) {
            obj3 = str;
        }
        boolean a18 = l0.a();
        long elapsedRealtime7 = SystemClock.elapsedRealtime() - elapsedRealtime6;
        if (elapsedRealtime7 > 32 && a18) {
            w.f("Luggage.Utils.Profile", str5 + ((int) (elapsedRealtime7 / 16)) + " frames! runProfiled:log:XLogSetup-Crash cost " + elapsedRealtime7 + " ms result:" + obj3 + " isMainThread: " + a18 + TokenParser.SP);
        } else {
            w.d("Luggage.Utils.Profile", str4 + "XLogSetup-Crash cost " + elapsedRealtime7 + " ms result:" + obj3 + " isMainThread: " + a18 + TokenParser.SP);
        }
        b(context);
        String obj4 = unit.toString();
        if (obj4 == null) {
            obj4 = str;
        }
        boolean a19 = l0.a();
        long elapsedRealtime8 = SystemClock.elapsedRealtime() - j3;
        if (elapsedRealtime8 <= 32 || !a19) {
            str6 = "Luggage.Utils.Profile";
            w.d(str6, str4 + "XLogSetup-ALL cost " + elapsedRealtime8 + " ms result:" + obj4 + " isMainThread: " + a19 + TokenParser.SP);
        } else {
            str6 = "Luggage.Utils.Profile";
            w.f(str6, str5 + ((int) (elapsedRealtime8 / 16)) + " frames! runProfiled:log:XLogSetup-ALL cost " + elapsedRealtime8 + " ms result:" + obj4 + " isMainThread: " + a19 + TokenParser.SP);
        }
        Application application3 = application2;
        com.tencent.luggage.wxa.w7.b.a(com.tencent.luggage.wxa.w7.b.f144108a, application3, null, 2, null);
        long elapsedRealtime9 = SystemClock.elapsedRealtime();
        y.f138216a.a(application3);
        String obj5 = unit.toString();
        if (obj5 == null) {
            obj5 = str;
        }
        boolean a26 = l0.a();
        long elapsedRealtime10 = SystemClock.elapsedRealtime() - elapsedRealtime9;
        if (elapsedRealtime10 > 32 && a26) {
            w.f(str6, str5 + ((int) (elapsedRealtime10 / 16)) + " frames! runProfiled:log:WxaDynamicPkgMgr.initLoadLibrary cost " + elapsedRealtime10 + " ms result:" + obj5 + " isMainThread: " + a26 + TokenParser.SP);
        } else {
            w.d(str6, str4 + "WxaDynamicPkgMgr.initLoadLibrary cost " + elapsedRealtime10 + " ms result:" + obj5 + " isMainThread: " + a26 + TokenParser.SP);
        }
        a.C6898a.f144554a.a(com.tencent.luggage.wxa.f7.f.f125455a.a());
        com.tencent.luggage.wxa.gi.c.a("WeAppLaunch", com.tencent.luggage.wxa.q6.a.f137864a);
    }

    public final void b(Context context) {
        w.d("Luggage.WXA.CommonProcessStartup", "*************************************************************************");
        w.d("Luggage.WXA.CommonProcessStartup", "* LuggageOpenSDK REV.%s start up", "ff21ec7a35922aa90e584b2bb63d1a39c25df3b8");
        w.d("Luggage.WXA.CommonProcessStartup", "* Package: %s", context.getPackageName());
        w.d("Luggage.WXA.CommonProcessStartup", "* Is support game: %b", Boolean.TRUE);
        w.d("Luggage.WXA.CommonProcessStartup", "* Build pipeline: %d", 143);
        w.d("Luggage.WXA.CommonProcessStartup", "* Build time: %s", "2025-04-27 19:07:38");
        w.d("Luggage.WXA.CommonProcessStartup", "*************************************************************************");
    }
}
