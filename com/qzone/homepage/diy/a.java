package com.qzone.homepage.diy;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import cooperation.qzone.util.QZLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends LottieLoader {

    /* renamed from: d, reason: collision with root package name */
    private MQLruCache<String, Object> f47527d;

    public a(Context context) {
        super(context);
    }

    public void e() {
        MQLruCache<String, Object> mQLruCache = this.f47527d;
        if (mQLruCache != null) {
            Iterator<String> it = mQLruCache.getLargeCache().iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object obj = this.f47527d.get(next);
                if (obj != null && (obj instanceof Bitmap)) {
                    ((Bitmap) obj).recycle();
                    QZLog.i("QZoneLottieLoader", 4, "recycle bitmap key = " + next);
                }
            }
            this.f47527d.releaseLargeCache();
        }
    }

    public void setMemoryCacheSize(int i3) {
        C0390a c0390a = new C0390a(i3);
        this.f47527d = c0390a;
        c0390a.setLargeSize(1);
    }

    /* compiled from: P */
    /* renamed from: com.qzone.homepage.diy.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0390a extends MQLruCache<String, Object> {
        C0390a(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.MQLruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOfObj(String str, Object obj) {
            if (obj != null && (obj instanceof Bitmap)) {
                Bitmap bitmap = (Bitmap) obj;
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
            return super.sizeOfObj(str, obj);
        }
    }
}
