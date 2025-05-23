package com.tencent.common.danmaku.tool;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<b> f99773a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList<b> f99774b;

    /* renamed from: c, reason: collision with root package name */
    private final int f99775c;

    /* renamed from: d, reason: collision with root package name */
    private int f99776d;

    /* renamed from: e, reason: collision with root package name */
    private int f99777e;

    /* renamed from: f, reason: collision with root package name */
    private int f99778f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f99779a;

        /* renamed from: b, reason: collision with root package name */
        private int f99780b;

        /* renamed from: c, reason: collision with root package name */
        private int f99781c;

        /* renamed from: d, reason: collision with root package name */
        private int f99782d;

        /* renamed from: e, reason: collision with root package name */
        private int f99783e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            Bitmap bitmap = this.f99779a;
            if (bitmap != null && !bitmap.isRecycled() && !com.tencent.common.danmaku.a.b().a().d()) {
                this.f99779a.recycle();
            }
            k();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Bitmap i() {
            Bitmap bitmap = this.f99779a;
            k();
            return bitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Bitmap bitmap) {
            this.f99779a = bitmap;
            this.f99780b = bitmap.getWidth();
            this.f99781c = bitmap.getHeight();
            this.f99782d = bitmap.getHeight() * bitmap.getWidth();
            this.f99783e = bitmap.getRowBytes() * bitmap.getHeight();
        }

        private void k() {
            this.f99779a = null;
            this.f99780b = 0;
            this.f99781c = 0;
            this.f99782d = 0;
            this.f99783e = 0;
        }

        /* synthetic */ b(C1015a c1015a) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c1015a);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f99773a = new LinkedList<>();
        this.f99774b = new LinkedList<>();
        DisplayMetrics displayMetrics = com.tencent.common.danmaku.a.b().a().e().getDisplayMetrics();
        this.f99775c = displayMetrics.widthPixels * displayMetrics.heightPixels * 6;
    }

    private void a() {
        while (this.f99776d > this.f99775c) {
            Iterator<b> it = this.f99773a.iterator();
            b bVar = null;
            while (it.hasNext()) {
                b next = it.next();
                if (bVar == null || bVar.f99782d > next.f99782d) {
                    bVar = next;
                }
            }
            if (bVar != null) {
                this.f99773a.remove(bVar);
                this.f99776d -= bVar.f99783e;
                bVar.h();
                this.f99774b.addLast(bVar);
            }
        }
    }

    private b d() {
        b poll = this.f99774b.poll();
        if (poll == null) {
            return new b(null);
        }
        return poll;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Iterator<b> it = this.f99773a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next != null) {
                next.h();
            }
        }
        this.f99773a.clear();
        this.f99776d = 0;
        this.f99777e = 0;
        this.f99778f = 0;
    }

    public Bitmap c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        this.f99777e++;
        Iterator<b> it = this.f99773a.iterator();
        b bVar = null;
        while (it.hasNext()) {
            b next = it.next();
            if (next.f99780b >= i3 && next.f99781c >= i16 && (bVar == null || bVar.f99782d >= next.f99782d)) {
                bVar = next;
            }
        }
        if (bVar != null) {
            this.f99773a.remove(bVar);
            this.f99776d -= bVar.f99783e;
            Bitmap i17 = bVar.i();
            this.f99774b.addLast(bVar);
            return i17;
        }
        try {
            this.f99778f++;
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e16) {
            com.tencent.common.danmaku.util.e.c("BitmapCacheManager", "create bitmap out of memory", e16);
            return null;
        }
    }

    public void e(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bitmap);
            return;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f99776d += bitmap.getRowBytes() * bitmap.getHeight();
            b d16 = d();
            d16.j(bitmap);
            this.f99773a.addLast(d16);
            a();
        }
    }
}
