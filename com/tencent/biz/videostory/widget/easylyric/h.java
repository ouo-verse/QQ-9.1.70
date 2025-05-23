package com.tencent.biz.videostory.widget.easylyric;

import com.tencent.oskplayer.util.Singleton;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private static final a f97219c = new a();

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<f> f97220a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f97221b = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class a extends Singleton<h> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.oskplayer.util.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createInstance() {
            return new h();
        }
    }

    h() {
    }

    public static h b() {
        return f97219c.getInstance();
    }

    public void a(f fVar) {
        this.f97220a.add(fVar);
    }

    public void c() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f97220a;
        if (copyOnWriteArrayList != null) {
            Iterator<f> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onPlay();
            }
        }
    }

    public void d() {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f97220a;
        if (copyOnWriteArrayList != null) {
            Iterator<f> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onStop();
            }
        }
    }

    public void e(long j3) {
        CopyOnWriteArrayList<f> copyOnWriteArrayList = this.f97220a;
        if (copyOnWriteArrayList != null && !this.f97221b) {
            Iterator<f> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().a(j3);
            }
        }
    }

    public void f(f fVar) {
        this.f97220a.remove(fVar);
    }
}
