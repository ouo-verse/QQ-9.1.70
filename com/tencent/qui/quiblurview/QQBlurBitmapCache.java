package com.tencent.qui.quiblurview;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
class QQBlurBitmapCache {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final PutOrderCache<String, Bitmap> f363583a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class PutOrderCache<K, V> extends LinkedHashMap<K, V> {
        static IPatchRedirector $redirector_;
        private int capacity;
        private Map.Entry<K, V> removed;

        PutOrderCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.capacity = Integer.MAX_VALUE;
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public V put(K k3, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (V) iPatchRedirector.redirect((short) 2, (Object) this, (Object) k3, (Object) v3);
            }
            remove(k3);
            return (V) super.put(k3, v3);
        }

        @Nullable
        public V putAndGetRemoved(K k3, V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
            }
            this.removed = null;
            V v16 = get(k3);
            put(k3, v3);
            Map.Entry<K, V> entry = this.removed;
            if (entry == null) {
                if (v16 == v3) {
                    return null;
                }
                return v16;
            }
            return entry.getValue();
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) entry)).booleanValue();
            }
            if (size() > this.capacity) {
                this.removed = entry;
                return true;
            }
            this.removed = null;
            return false;
        }

        public void setCapacity(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.capacity = i3;
            }
        }
    }

    public QQBlurBitmapCache(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        PutOrderCache<String, Bitmap> putOrderCache = new PutOrderCache<>();
        this.f363583a = putOrderCache;
        putOrderCache.setCapacity(i3);
    }

    public Bitmap a(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        for (Bitmap bitmap : this.f363583a.values()) {
            if (bitmap != null && i3 == bitmap.getWidth() && i16 == bitmap.getHeight()) {
                Bitmap putAndGetRemoved = this.f363583a.putAndGetRemoved(i3 + "_" + i16, bitmap);
                if (putAndGetRemoved != null) {
                    putAndGetRemoved.recycle();
                }
                return bitmap;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.f363583a.putAndGetRemoved(i3 + "_" + i16, createBitmap);
        return createBitmap;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f363583a.clear();
        }
    }
}
