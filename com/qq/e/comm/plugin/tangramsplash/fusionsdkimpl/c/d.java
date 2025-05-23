package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.c;

import android.util.Pair;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.ar;
import com.qq.e.comm.plugin.k.as;
import com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.SplashEventHandlerCenter;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.a.f;
import java.util.ArrayList;
import java.util.List;
import nt.h;
import ot.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f40084a;

    /* renamed from: b, reason: collision with root package name */
    private List<Pair<Class<? extends com.tencent.ams.fusion.service.a>, com.tencent.ams.fusion.service.a>> f40085b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private c f40086c;

    /* renamed from: d, reason: collision with root package name */
    private a f40087d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f40088e;

    d() {
        boolean z16 = false;
        if (GDTADManager.getInstance() != null && GDTADManager.getInstance().getSM() != null && GDTADManager.getInstance().getSM().getInteger(GDTLogger.KEY_ENABLE_CONSOLE_LOG, 0) == 1) {
            z16 = true;
        }
        GDTLogger.i("SplashServiceManger logEnable:" + z16);
        f.e(z16);
        this.f40085b.add(new Pair<>(jt.a.class, new as()));
        this.f40085b.add(new Pair<>(lt.a.class, new ar()));
        this.f40085b.add(new Pair<>(com.tencent.ams.fusion.service.a.a.class, new com.qq.e.comm.plugin.j.d()));
        this.f40085b.add(new Pair<>(com.tencent.ams.fusion.service.resdownload.c.class, new com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a.b()));
        com.tencent.ams.fusion.service.b.b().k().a(new SplashEventHandlerCenter());
        this.f40086c = new c();
        this.f40085b.add(new Pair<>(com.tencent.ams.fusion.service.splash.data.f.class, this.f40086c));
        this.f40085b.add(new Pair<>(qt.c.class, new b()));
        this.f40085b.add(new Pair<>(e.class, new com.tencent.ams.fusion.service.splash.c.a.a.b()));
        this.f40085b.add(new Pair<>(h.class, new com.tencent.ams.fusion.service.splash.b.b.a.b()));
        this.f40087d = new a();
        this.f40085b.add(new Pair<>(com.tencent.ams.fusion.service.splash.data.b.class, this.f40087d));
    }

    public static d a() {
        if (f40084a == null) {
            synchronized (d.class) {
                if (f40084a == null) {
                    f40084a = new d();
                }
            }
        }
        return f40084a;
    }

    public void b() {
        if (this.f40088e) {
            return;
        }
        synchronized (d.class) {
            if (this.f40088e) {
                return;
            }
            this.f40088e = true;
            com.tencent.ams.fusion.service.b.b().e(this.f40085b);
        }
    }

    public c c() {
        return this.f40086c;
    }

    public a d() {
        return this.f40087d;
    }
}
