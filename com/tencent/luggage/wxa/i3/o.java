package com.tencent.luggage.wxa.i3;

import android.app.Activity;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hn.d6;
import com.tencent.luggage.wxa.hn.eh;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class o extends Error implements Parcelable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f129343b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f129344a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final o a(String str, d6 d6Var, eh ehVar) {
            boolean z16;
            int i3;
            int i16;
            o oVar = null;
            if (d6Var == null) {
                return null;
            }
            boolean z17 = true;
            int i17 = 0;
            if (ehVar != null && 1 == ehVar.f127578d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && 3 == com.tencent.luggage.wxa.p3.g.a()) {
                if (str != null && str.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    oVar = new r(str);
                    if (oVar != null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("createErrorAction not, block_reason:");
                        if (ehVar != null) {
                            i17 = ehVar.f127578d;
                        }
                        sb5.append(i17);
                        sb5.append(", ActionCode:");
                        sb5.append(d6Var.f127477d);
                        sb5.append(", error:");
                        sb5.append(oVar.getClass().getName());
                        com.tencent.luggage.wxa.tn.w.b("WxaLaunchErrorAction", sb5.toString());
                    }
                    return oVar;
                }
            }
            int i18 = d6Var.f127477d;
            if (i18 != 2) {
                if (i18 == 3) {
                    com.tencent.luggage.wxa.tn.w.b("WxaLaunchErrorAction", "createErrorAction " + d6Var.f127480g + TokenParser.SP + d6Var.f127481h);
                    String str2 = d6Var.f127480g;
                    String str3 = d6Var.f127481h;
                    if (ehVar != null) {
                        i16 = ehVar.f127578d;
                    } else {
                        i16 = 0;
                    }
                    oVar = new p(str2, str3, i16);
                }
            } else {
                com.tencent.luggage.wxa.tn.w.b("WxaLaunchErrorAction", "createErrorAction " + d6Var.f127478e);
                if (d6Var.f127478e != null) {
                    String str4 = d6Var.f127478e;
                    Intrinsics.checkNotNullExpressionValue(str4, "pb.OpenUrl");
                    if (ehVar != null) {
                        i3 = ehVar.f127578d;
                    } else {
                        i3 = 0;
                    }
                    oVar = new q(str4, i3);
                }
            }
            if (oVar != null) {
            }
            return oVar;
        }
    }

    public o(int i3) {
        this.f129344a = i3;
    }

    public static final o a(String str, d6 d6Var, eh ehVar) {
        return f129343b.a(str, d6Var, ehVar);
    }

    public abstract void a(Activity activity, com.tencent.luggage.wxa.wj.c cVar);

    public int a() {
        return this.f129344a;
    }

    public final void a(com.tencent.luggage.wxa.p5.f rt5) {
        Intrinsics.checkNotNullParameter(rt5, "rt");
        com.tencent.luggage.wxa.wj.c n06 = rt5.n0();
        WindowAndroidActivityImpl windowAndroidActivityImpl = n06 instanceof WindowAndroidActivityImpl ? (WindowAndroidActivityImpl) n06 : null;
        Activity j3 = windowAndroidActivityImpl != null ? windowAndroidActivityImpl.j() : null;
        com.tencent.luggage.wxa.wj.c n07 = rt5.n0();
        Intrinsics.checkNotNullExpressionValue(n07, "rt.windowAndroid");
        rt5.D();
        if (j3 != null && !j3.isFinishing() && !j3.isDestroyed()) {
            a(j3, n07);
        } else {
            a(null, n07);
        }
    }
}
