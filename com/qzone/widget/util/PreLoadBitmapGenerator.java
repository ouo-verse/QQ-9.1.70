package com.qzone.widget.util;

import android.graphics.Bitmap;
import com.qzone.widget.util.c;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes37.dex */
public abstract class PreLoadBitmapGenerator implements c.b {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, Bitmap> f61091a = new LinkedHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private int f61092b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final Object f61093c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str, Bitmap bitmap) {
        this.f61091a.put(str, bitmap);
        if (this.f61091a.size() > 2) {
            Map.Entry<String, Bitmap> next = this.f61091a.entrySet().iterator().next();
            next.getValue().recycle();
            this.f61091a.remove(next.getKey());
        }
    }

    private void g(final String str) {
        final long nanoTime = System.nanoTime();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).post(new Runnable() { // from class: com.qzone.widget.util.PreLoadBitmapGenerator.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap i3 = PreLoadBitmapGenerator.this.i(str);
                QZLog.i("PreLoadBitmapGenerator", "asyncPreLoad: " + (System.nanoTime() - nanoTime));
                synchronized (PreLoadBitmapGenerator.this.f61093c) {
                    if (!PreLoadBitmapGenerator.this.f61091a.containsKey(str)) {
                        PreLoadBitmapGenerator.this.f(str, i3);
                        PreLoadBitmapGenerator.this.f61092b = 0;
                    } else {
                        PreLoadBitmapGenerator.this.f61092b++;
                        QZLog.i("PreLoadBitmapGenerator", "asyncPreLoad: invalid");
                    }
                }
            }
        });
    }

    @Override // com.qzone.widget.util.c.b
    public Bitmap generateBitmap(String str, String str2) {
        Bitmap bitmap;
        boolean z16;
        synchronized (this.f61093c) {
            bitmap = this.f61091a.get(str);
            if (bitmap == null) {
                bitmap = i(str);
                f(str, bitmap);
            }
            z16 = this.f61092b < 2;
        }
        if (str2 != null) {
            if (z16) {
                g(str2);
            } else {
                QZLog.i("PreLoadBitmapGenerator", "generateBitmap: invalid pre load");
            }
        }
        return bitmap;
    }

    protected abstract Bitmap i(String str);

    public void j() {
        synchronized (this.f61093c) {
            Iterator<Map.Entry<String, Bitmap>> it = this.f61091a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().recycle();
            }
            this.f61091a.clear();
        }
    }

    public Bitmap h(String str, String str2, boolean z16) {
        if (z16) {
            return generateBitmap(str, str2);
        }
        return i(str);
    }
}
