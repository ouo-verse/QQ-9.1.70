package com.tencent.common.danmaku.tool;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private LruCache<String, T> f99788a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends LruCache<String, T> {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) t16)).intValue();
            }
            if (t16 != null) {
                int c16 = d.this.c(t16);
                if (c16 == 0) {
                    return d.this.d(t16);
                }
                return c16;
            }
            return 0;
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99788a = new a(((int) Runtime.getRuntime().maxMemory()) / 32);
        }
    }

    private static int b(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public int c(T t16) {
        if (t16 instanceof Bitmap) {
            return b((Bitmap) t16);
        }
        if (t16 instanceof BitmapDrawable) {
            return b(((BitmapDrawable) t16).getBitmap());
        }
        return 0;
    }

    protected int d(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16)).intValue();
        }
        return 0;
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            synchronized (this) {
                this.f99788a.trimToSize(i3);
            }
        }
    }
}
