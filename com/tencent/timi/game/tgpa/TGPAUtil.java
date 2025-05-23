package com.tencent.timi.game.tgpa;

import android.content.Context;
import com.tencent.timi.game.tgpa.service.TgpaInterProcessService;
import com.tencent.timi.game.utils.w;

/* loaded from: classes26.dex */
public class TGPAUtil {

    /* loaded from: classes26.dex */
    public interface a {
        void a(int i3, float f16);

        void b(String str);

        void c(int i3);

        void d(String str);

        void e(boolean z16);

        void f(String str, Object obj);
    }

    public static void a() {
        jn4.a.c().b();
    }

    public static String b() {
        return "";
    }

    public static void c(final Context context) {
        w.c(new Runnable() { // from class: com.tencent.timi.game.tgpa.TGPAUtil.1
            @Override // java.lang.Runnable
            public void run() {
                b.a().b(context);
            }
        });
    }

    public static void d(a aVar) {
        jn4.a.c().h(aVar);
    }

    public static void e(Context context, boolean z16) {
        TgpaInterProcessService.b(context, z16);
    }

    public static void f(Context context) {
        TgpaInterProcessService.c(context);
    }

    public static void g(a aVar) {
        jn4.a.c().k(aVar);
    }
}
