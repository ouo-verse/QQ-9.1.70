package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gf;
import com.xiaomi.push.gp;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hz;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class z {

    /* renamed from: b, reason: collision with root package name */
    private static volatile z f388120b;

    /* renamed from: a, reason: collision with root package name */
    private final Context f388121a;

    z(Context context) {
        this.f388121a = context.getApplicationContext();
    }

    private static z a(Context context) {
        if (f388120b == null) {
            synchronized (z.class) {
                if (f388120b == null) {
                    f388120b = new z(context);
                }
            }
        }
        return f388120b;
    }

    public static void b(Context context, hb hbVar) {
        a(context).d(hbVar, 0, true);
    }

    public static void c(Context context, hb hbVar, boolean z16) {
        a(context).d(hbVar, 1, z16);
    }

    private void d(hb hbVar, int i3, boolean z16) {
        if (!hz.j(this.f388121a) && hz.i() && hbVar != null && hbVar.f389249a == gf.SendMessage && hbVar.m375a() != null && z16) {
            jz4.c.m("click to start activity result:" + String.valueOf(i3));
            he heVar = new he(hbVar.m375a().m341a(), false);
            heVar.c(gp.SDK_START_ACTIVITY.f24750a);
            heVar.b(hbVar.m376a());
            heVar.d(hbVar.f389250b);
            HashMap hashMap = new HashMap();
            heVar.f24813a = hashMap;
            hashMap.put("result", String.valueOf(i3));
            ag.h(this.f388121a).D(heVar, gf.Notification, false, false, null, true, hbVar.f389250b, hbVar.f24804a, true, false);
        }
    }

    public static void e(Context context, hb hbVar, boolean z16) {
        a(context).d(hbVar, 2, z16);
    }

    public static void f(Context context, hb hbVar, boolean z16) {
        a(context).d(hbVar, 3, z16);
    }

    public static void g(Context context, hb hbVar, boolean z16) {
        a(context).d(hbVar, 4, z16);
    }

    public static void h(Context context, hb hbVar, boolean z16) {
        s c16 = s.c(context);
        if (!TextUtils.isEmpty(c16.q()) && !TextUtils.isEmpty(c16.t())) {
            if (c16.x()) {
                a(context).d(hbVar, 7, z16);
                return;
            } else {
                a(context).d(hbVar, 5, z16);
                return;
            }
        }
        a(context).d(hbVar, 6, z16);
    }
}
