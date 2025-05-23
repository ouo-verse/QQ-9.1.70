package com.tencent.mobileqq.guild.mainframe.manager;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMainFrameRedDragManager {

    /* renamed from: d, reason: collision with root package name */
    private static volatile GuildMainFrameRedDragManager f227471d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f227472a = false;

    /* renamed from: b, reason: collision with root package name */
    private long f227473b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Set<IQQGuildService.b> f227474c = new HashSet();

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, boolean z16) {
        QLog.d("Guild.MF.GuildMainFrameRedDragManager", 1, str + " endDrag isDragging=" + this.f227472a);
        if (!this.f227472a) {
            return;
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
        this.f227472a = false;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildMainFrameRedDragManager.this.k();
            }
        };
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 1000L);
        } else {
            runnable.run();
        }
    }

    public static GuildMainFrameRedDragManager i() {
        if (f227471d == null) {
            synchronized (GuildMainFrameRedDragManager.class) {
                if (f227471d == null) {
                    f227471d = new GuildMainFrameRedDragManager();
                }
            }
        }
        return f227471d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        QLog.i("Guild.MF.GuildMainFrameRedDragManager", 1, "endDragNow");
        Iterator it = new HashSet(this.f227474c).iterator();
        while (it.hasNext()) {
            ((IQQGuildService.b) it.next()).endDrag();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str) {
        if (this.f227472a) {
            QLog.w("Guild.MF.GuildMainFrameRedDragManager", 1, str + " already dragging");
            return;
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
        QLog.d("Guild.MF.GuildMainFrameRedDragManager", 1, str + " startDrag");
        this.f227472a = true;
        this.f227473b = System.currentTimeMillis();
        Iterator it = new HashSet(this.f227474c).iterator();
        while (it.hasNext()) {
            ((IQQGuildService.b) it.next()).startDrag();
        }
    }

    public void e(final IQQGuildService.b bVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f227474c.add(bVar);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager.1
                @Override // java.lang.Runnable
                public void run() {
                    GuildMainFrameRedDragManager.this.f227474c.add(bVar);
                }
            });
        }
    }

    public void f(String str) {
        g(str, true);
    }

    public void g(final String str, final boolean z16) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h(str, z16);
        } else {
            s.f("Guild.MF.GuildMainFrameRedDragManager", "endDrag error", new RuntimeException("endDrag"));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager.4
                @Override // java.lang.Runnable
                public void run() {
                    GuildMainFrameRedDragManager.this.h(str, z16);
                }
            });
        }
    }

    public boolean j() {
        return this.f227472a;
    }

    public void l(final IQQGuildService.b bVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f227474c.remove(bVar);
        } else {
            s.f("Guild.MF.GuildMainFrameRedDragManager", "removeRedDragListener error", new RuntimeException("addRedDragListener"));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildMainFrameRedDragManager.this.f227474c.remove(bVar);
                }
            });
        }
    }

    public void m(final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n(str);
        } else {
            s.f("Guild.MF.GuildMainFrameRedDragManager", "startDrag error", new RuntimeException("startDrag"));
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameRedDragManager.3
                @Override // java.lang.Runnable
                public void run() {
                    GuildMainFrameRedDragManager.this.n(str);
                }
            });
        }
    }
}
