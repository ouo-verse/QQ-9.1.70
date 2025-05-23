package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.kp;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qe {
    private static void a(final Context context, final String str, final Callback<Boolean> callback) {
        kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.qe.2
            private Boolean a() throws Exception {
                qe.a(context, str);
                return Boolean.TRUE;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                qe.a(context, str);
                return Boolean.TRUE;
            }
        }).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) (callback != null ? new kp.a<Boolean>() { // from class: com.tencent.mapsdk.internal.qe.1
            private void a(Boolean bool) {
                Callback.this.callback(bool);
            }

            @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
            public final /* bridge */ /* synthetic */ void callback(Object obj) {
                Callback.this.callback((Boolean) obj);
            }
        } : null));
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        String a16 = mz.a(context, (TencentMapOptions) null).a(str);
        my a17 = my.a(context);
        a(a17);
        int b16 = ho.b(ho.n(), a17.a("sdkVersion"));
        mv a18 = mx.a(context, str);
        mw.b(a18, a16);
        mw.a(context, a18, a16, er.f148272a);
        if (b16 > 0) {
            a17.a("sdkVersion", ho.n());
        }
    }

    private static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        String a16 = mz.a(context, (TencentMapOptions) null).a(str);
        mv a17 = mx.a(context, str);
        mw.c(a17, a16);
        mw.d(a17, a16);
        mw.a(context, a17, a16, er.f148275d);
        mw.a(context, a17, a16, er.f148273b);
        mw.a(context, a17, a16, er.f148274c);
        mw.a(context, a17, a16, er.f148276e);
        mw.a(context, a17, a16, er.f148277f);
        mw.a(context, a17, a16, er.f148278g);
        mw.a(context, a17, a16, er.f148279h);
    }

    public static void a(mv mvVar) {
        if (ho.b(mvVar.a("sdkVersion"), "4.0.9.1") < 0) {
            mvVar.a(new String[]{et.f148314q, et.f148316s});
        }
    }

    public static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        String a16 = mz.a(context, (TencentMapOptions) null).a(str);
        my a17 = my.a(context);
        a(a17);
        int b16 = ho.b(ho.n(), a17.a("sdkVersion"));
        mv a18 = mx.a(context, str);
        mw.a(a18, a16);
        mw.a(context, a18, a16, er.f148272a);
        mw.a(context, a18, a16, er.f148275d);
        mw.a(context, a18, a16, er.f148273b);
        mw.a(context, a18, a16, er.f148274c);
        mw.a(context, a18, a16, er.f148276e);
        mw.a(context, a18, a16, er.f148277f);
        mw.a(context, a18, a16, er.f148278g);
        mw.a(context, a18, a16, er.f148279h);
        if (b16 > 0) {
            a17.a("sdkVersion", ho.n());
        }
    }
}
