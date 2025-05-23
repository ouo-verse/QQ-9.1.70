package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Long, a> f68698a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f68699a;

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f68700b;

        /* renamed from: c, reason: collision with root package name */
        private String f68701c;

        /* renamed from: d, reason: collision with root package name */
        private String f68702d;

        /* renamed from: e, reason: collision with root package name */
        private int f68703e = 2;

        /* renamed from: f, reason: collision with root package name */
        private int f68704f = 1;

        public a(long j3, Bitmap bitmap, String str) {
            this.f68699a = j3;
            this.f68700b = bitmap;
            this.f68702d = str;
            this.f68701c = str + "/" + j3 + ".jpg";
        }

        public synchronized void e() {
            this.f68703e++;
        }

        public Bitmap f() {
            return this.f68700b;
        }

        public synchronized boolean g() {
            ms.a.c("PhotoTakenPerformance", "enter bitmap recycle");
            int i3 = this.f68703e - 1;
            this.f68703e = i3;
            if (i3 > 0) {
                return false;
            }
            com.tencent.mobileqq.wink.utils.f.n(this.f68700b);
            ms.a.c("PhotoTakenPerformance", "bitmap recycle");
            return true;
        }

        public boolean h() {
            Bitmap bitmap;
            return (TextUtils.isEmpty(this.f68701c) || (bitmap = this.f68700b) == null || bitmap.isRecycled()) ? false : true;
        }
    }

    public static synchronized long a(long j3, Bitmap bitmap, String str) {
        synchronized (g.class) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    f68698a.put(Long.valueOf(j3), new a(j3, bitmap, str));
                    return j3;
                }
            }
            ms.a.c("EditPhotosStorage", "addPhoto error");
            return -1L;
        }
    }

    public static synchronized void b(long j3) {
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            if (aVar != null) {
                aVar.e();
            }
        }
    }

    private static synchronized void c(long j3, a aVar) {
        synchronized (g.class) {
            if (aVar.h()) {
                b(j3);
                FileUtils.createFileIfNotExits(aVar.f68701c);
                File file = new File(aVar.f68701c);
                try {
                    BaseImageUtil.saveBitmapFileAsJPEG(aVar.f68700b, file);
                    BaseImageUtil.savePhotoToSysAlbum(BaseApplication.getContext(), file.getAbsolutePath());
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
                g(j3);
            }
        }
    }

    public static synchronized Bitmap d(long j3) {
        Bitmap f16;
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            f16 = aVar != null ? aVar.f() : null;
        }
        return f16;
    }

    public static synchronized String e(long j3) {
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            if (aVar == null) {
                return null;
            }
            int i3 = aVar.f68704f;
            if (i3 == 1 || i3 == 2) {
                c(j3, aVar);
            }
            return aVar.f68701c;
        }
    }

    public static synchronized boolean f(long j3) {
        boolean z16;
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            if (aVar != null && aVar.f68700b != null) {
                z16 = aVar.f68700b.isRecycled() ? false : true;
            }
        }
        return z16;
    }

    public static synchronized void g(long j3) {
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            if (aVar != null) {
                if (aVar.g()) {
                    f68698a.remove(aVar);
                } else {
                    f68698a.put(Long.valueOf(j3), aVar);
                }
            }
        }
    }

    public static synchronized void h(long j3, boolean z16) {
        synchronized (g.class) {
            a aVar = f68698a.get(Long.valueOf(j3));
            if (aVar == null) {
                return;
            }
            if (z16) {
                aVar.f68704f = 3;
            } else {
                aVar.f68704f = 2;
            }
            f68698a.put(Long.valueOf(j3), aVar);
        }
    }
}
