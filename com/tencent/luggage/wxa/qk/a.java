package com.tencent.luggage.wxa.qk;

import android.content.res.Configuration;
import com.tencent.luggage.wxa.c5.e;
import com.tencent.luggage.wxa.h6.q;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C6650a f138929a = new C6650a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qk.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6650a {
        public C6650a() {
        }

        public /* synthetic */ C6650a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(e eVar, Configuration oldConfig, Configuration newConfig) {
            com.tencent.luggage.wxa.fd.b bVar;
            boolean z16;
            boolean z17;
            String str;
            Intrinsics.checkNotNullParameter(oldConfig, "oldConfig");
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            if (eVar != null) {
                bVar = eVar.E();
            } else {
                bVar = null;
            }
            if (bVar != null) {
                z16 = eVar.E().k();
            } else {
                z16 = true;
            }
            if ((newConfig.uiMode & 48) != (oldConfig.uiMode & 48)) {
                z17 = true;
            } else {
                z17 = false;
            }
            boolean a16 = q.a();
            w.d("MicroMsg.AppBandDarkModeHelper", "darkModeThemeChanged  isDarkModeSupportForCurrentWxa=%b  isNightModeEnabled=%b nightModeChanged=%b", Boolean.valueOf(z16), Boolean.valueOf(a16), Boolean.valueOf(z17));
            if (!z16 || !a16 || !z17) {
                return false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Theme change into ");
            if (32 == (newConfig.uiMode & 48)) {
                str = "NIGHT";
            } else {
                str = "DAY";
            }
            sb5.append(str);
            sb5.append(" mode");
            w.d("MicroMsg.AppBandDarkModeHelper", sb5.toString());
            return true;
        }
    }

    public static final boolean a(e eVar, Configuration configuration, Configuration configuration2) {
        return f138929a.a(eVar, configuration, configuration2);
    }
}
