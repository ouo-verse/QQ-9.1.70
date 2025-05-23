package com.tencent.luggage.wxa.ff;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f126112b;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f126111a = com.tencent.luggage.wxa.tn.e.f141568j;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static List<Runnable> f126113c = null;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends V2TXLivePremier.V2TXLivePremierObserver {

        /* renamed from: a, reason: collision with root package name */
        private static final String f126114a = "MicroMsg.AppBrand.Live";

        public void a(int i3, String str) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    w.a(f126114a, str);
                                    return;
                                } else {
                                    w.c(f126114a, str);
                                    return;
                                }
                            }
                            w.b(f126114a, str);
                            return;
                        }
                        w.f(f126114a, str);
                        return;
                    }
                    w.d(f126114a, str);
                    return;
                }
                w.a(f126114a, str);
                return;
            }
            w.e(f126114a, str);
        }
    }

    public static void a(@NonNull Runnable runnable) {
        if (f126112b) {
            return;
        }
        if (f126113c == null) {
            f126113c = new ArrayList();
        }
        f126113c.add(runnable);
    }

    public static void b() {
        if (f126112b) {
            return;
        }
        c();
        a();
        f126112b = true;
    }

    private static void c() {
        V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig = new V2TXLiveDef.V2TXLiveLogConfig();
        v2TXLiveLogConfig.enableObserver = true;
        v2TXLiveLogConfig.logLevel = 1;
        v2TXLiveLogConfig.enableConsole = false;
        v2TXLiveLogConfig.enableLogFile = false;
        V2TXLivePremier.setLogConfig(v2TXLiveLogConfig);
        V2TXLivePremier.setObserver(new a());
    }

    private static void a() {
        List<Runnable> list = f126113c;
        if (list != null && !list.isEmpty()) {
            Iterator<Runnable> it = f126113c.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            f126113c.clear();
            f126113c = null;
            return;
        }
        f126113c = null;
    }
}
