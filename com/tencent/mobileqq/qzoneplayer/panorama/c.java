package com.tencent.mobileqq.qzoneplayer.panorama;

import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f279398c;

    /* renamed from: a, reason: collision with root package name */
    private int f279399a = 3;

    /* renamed from: b, reason: collision with root package name */
    private Set<WeakReference<b>> f279400b = new CopyOnWriteArraySet();

    c() {
    }

    public static c b() {
        if (f279398c == null) {
            synchronized (c.class) {
                f279398c = new c();
            }
        }
        return f279398c;
    }

    public synchronized b a() {
        b bVar;
        long currentTimeMillis = System.currentTimeMillis();
        loop0: while (true) {
            bVar = null;
            for (WeakReference<b> weakReference : this.f279400b) {
                b bVar2 = weakReference.get();
                if (bVar2 != null) {
                    if (!bVar2.e() && currentTimeMillis - weakReference.get().c() >= 3) {
                    }
                } else {
                    this.f279400b.remove(weakReference);
                }
                bVar = bVar2;
            }
            break loop0;
        }
        if (bVar == null && this.f279400b.size() < this.f279399a) {
            b bVar3 = new b();
            if (!bVar3.d()) {
                PlayerUtils.log(6, "RenderThreadHandlerMgr", "gl thread looper is null!!!!");
            } else {
                bVar3 = new b();
            }
            bVar = bVar3;
            this.f279400b.add(new WeakReference<>(bVar));
        }
        if (bVar != null) {
            bVar.j(true);
        } else {
            PlayerUtils.log(6, "RenderThreadHandlerMgr", "gl thread handler reach max");
        }
        return bVar;
    }
}
