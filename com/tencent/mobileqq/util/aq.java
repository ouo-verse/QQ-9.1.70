package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class aq {

    /* renamed from: a, reason: collision with root package name */
    private CustomLruCache<String, Drawable> f306586a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, WeakReference<Drawable>> f306587b = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends CustomLruCache<String, Drawable> {
        a(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.util.CustomLruCache, android.support.v4.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, Drawable drawable) {
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                if (bitmap2 == null) {
                    return 0;
                }
                return bitmap2.getRowBytes() * bitmap2.getHeight();
            }
            if (!(drawable instanceof AnimationDrawable)) {
                return 0;
            }
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i3 = 0;
            for (int i16 = 0; i16 < numberOfFrames; i16++) {
                Drawable frame = animationDrawable.getFrame(i16);
                if ((frame instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) frame).getBitmap()) != null) {
                    i3 += bitmap.getRowBytes() * bitmap.getHeight();
                }
            }
            return i3;
        }
    }

    public aq(int i3) {
        int max = Math.max(i3, 5);
        if (QLog.isColorLevel()) {
            QLog.d(QZLog.IMAGE_CACHE_TAG, 2, "Memory cache size = " + max + "MB");
        }
        this.f306586a = new a(max * 1024 * 1024);
    }
}
