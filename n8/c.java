package n8;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedList<Bitmap> f419481a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    private final int f419482b;

    /* renamed from: c, reason: collision with root package name */
    private int f419483c;

    /* renamed from: d, reason: collision with root package name */
    private int f419484d;

    /* renamed from: e, reason: collision with root package name */
    private int f419485e;

    public c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f419482b = displayMetrics.widthPixels * displayMetrics.heightPixels * 8;
    }

    private void d(Bitmap bitmap) {
        this.f419481a.remove(bitmap);
        if (bitmap != null) {
            this.f419483c -= bitmap.getRowBytes() * bitmap.getHeight();
            if (bitmap.isRecycled()) {
                return;
            }
            bitmap.recycle();
        }
    }

    public void a() {
        Iterator<Bitmap> it = this.f419481a.iterator();
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next != null && !next.isRecycled()) {
                next.recycle();
            }
        }
        this.f419481a.clear();
        this.f419483c = 0;
        this.f419484d = 0;
        this.f419485e = 0;
    }

    public Bitmap b(int i3, int i16) {
        this.f419484d++;
        Iterator<Bitmap> it = this.f419481a.iterator();
        Bitmap bitmap = null;
        while (it.hasNext()) {
            Bitmap next = it.next();
            if (next.getWidth() >= i3 && next.getHeight() >= i16 && (bitmap == null || bitmap.getHeight() * bitmap.getWidth() >= next.getHeight() * next.getWidth())) {
                bitmap = next;
            }
        }
        if (bitmap != null) {
            this.f419481a.remove(bitmap);
            this.f419483c -= bitmap.getRowBytes() * bitmap.getHeight();
            return bitmap;
        }
        try {
            this.f419485e++;
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public void c(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f419483c += bitmap.getRowBytes() * bitmap.getHeight();
        this.f419481a.addLast(bitmap);
        while (this.f419483c > this.f419482b) {
            Iterator<Bitmap> it = this.f419481a.iterator();
            Bitmap bitmap2 = null;
            while (it.hasNext()) {
                Bitmap next = it.next();
                if (bitmap2 == null || bitmap2.getHeight() * bitmap2.getWidth() >= next.getHeight() * next.getWidth()) {
                    bitmap2 = next;
                }
            }
            if (bitmap2 != null) {
                d(bitmap2);
            }
        }
    }
}
