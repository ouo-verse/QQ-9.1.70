package com.qzone.proxy.feedcomponent.util;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.tencent.component.media.utils.LruCache;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes39.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f50909a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static LruCache<Integer, Bitmap> f50910b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends LruCache<Integer, Bitmap> {
        a(int i3) {
            super(i3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.component.media.utils.LruCache
        public int sizeOf(Integer num, Bitmap bitmap) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final l f50912a = new l();
    }

    l() {
    }

    public static l a() {
        return b.f50912a;
    }

    public LruCache<Integer, Bitmap> b() {
        if (f50910b == null) {
            synchronized (f50909a) {
                if (f50910b == null) {
                    int memoryClass = ((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass() * 131072;
                    if (memoryClass > 52428800) {
                        memoryClass = 52428800;
                    }
                    f50910b = new a(memoryClass);
                }
            }
        }
        return f50910b;
    }
}
