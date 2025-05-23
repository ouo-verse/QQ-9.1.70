package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.Nullable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.f;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f179896a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a implements f {

        /* renamed from: d, reason: collision with root package name */
        private String f179897d;

        /* renamed from: e, reason: collision with root package name */
        private BitmapDrawable[] f179898e;

        /* renamed from: f, reason: collision with root package name */
        private int f179899f;

        /* renamed from: h, reason: collision with root package name */
        private int f179900h;

        public a(String str, BitmapDrawable[] bitmapDrawableArr, int i3) {
            this.f179897d = str;
            this.f179898e = bitmapDrawableArr;
            this.f179899f = i3;
            a();
        }

        private void a() {
            this.f179900h = 0;
            for (BitmapDrawable bitmapDrawable : this.f179898e) {
                if (bitmapDrawable != null && bitmapDrawable.getBitmap() != null) {
                    this.f179900h += bitmapDrawable.getBitmap().getByteCount();
                }
            }
        }

        public int b() {
            return this.f179899f;
        }

        public BitmapDrawable[] c() {
            return this.f179898e;
        }

        @Override // com.tencent.cache.api.f
        public int getByteSize() {
            return this.f179900h;
        }
    }

    @Nullable
    public static a a(String str) {
        return (a) ImageCacheHelper.f98636a.g("StickerBubbleGifCache_" + str);
    }

    public static void b() {
        f179896a++;
    }

    private static boolean c() {
        if (f179896a > 3) {
            return true;
        }
        return false;
    }

    public static void d(String str, BitmapDrawable[] bitmapDrawableArr, int i3) {
        if (c()) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerBubble_FrameCache", 2, "putFramesToCache: " + str + " / " + bitmapDrawableArr);
            }
            String str2 = "StickerBubbleGifCache_" + str;
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            if (imageCacheHelper.g(str2) == null) {
                imageCacheHelper.i(str2, new a(str, bitmapDrawableArr, i3), Business.AIO);
            }
        }
    }
}
