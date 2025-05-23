package com.tencent.av.avatar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.cache.api.Business;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import ew.b;
import ew.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavAvatarHelper {

    /* renamed from: d, reason: collision with root package name */
    private static QavAvatarHelper f73220d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f73221a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f73222b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.cache.api.collection.a<String, Drawable> f73223c = new com.tencent.cache.api.collection.a<>(Business.Default, "QavAvatarHelper", 10);

    QavAvatarHelper() {
    }

    private void c(Drawable drawable, String str) {
        synchronized (this.f73222b) {
            this.f73222b.add(str);
        }
        synchronized (this.f73223c) {
            this.f73223c.f(str, drawable);
        }
    }

    private void e(Resources resources, ew.a aVar, int i3, String str, WeakReference<b> weakReference) {
        b bVar;
        BitmapDrawable bitmapDrawable = null;
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (!q.p(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "decodeAvatar fail, param = " + aVar);
            }
            if (bVar != null) {
                bVar.D1(aVar, null);
                return;
            }
            return;
        }
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            if (aVar.f397250d && decodeFile != null) {
                float f16 = resources.getDisplayMetrics().density;
                if (f16 < 0.001f) {
                    f16 = 2.0f;
                }
                decodeFile = BaseImageUtil.getCircleFaceBitmap(decodeFile, (int) (decodeFile.getWidth() / f16), (int) (decodeFile.getHeight() / f16));
                if (decodeFile == null && QLog.isColorLevel()) {
                    QLog.i("QavAvatarHelper", 2, "decodeAvatar, getCircleFaceBitmap fail, param = " + aVar);
                }
            }
            if (decodeFile != null) {
                bitmapDrawable = new BitmapDrawable(resources, decodeFile);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("QavAvatarHelper", 2, "decodeAvatar " + th5.toString());
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "decodeAvatar param = " + aVar + ", drawable = " + bitmapDrawable);
        }
        if (bVar != null) {
            bVar.D1(aVar, bitmapDrawable);
        }
        if (bitmapDrawable != null) {
            c(bitmapDrawable, h(aVar, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VideoAppInterface videoAppInterface, ew.a aVar, int i3, String str, WeakReference<b> weakReference) {
        b bVar;
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String fHDAvatarPath = FaceUtil.getFHDAvatarPath(aVar.f397248b);
        File file = new File(fHDAvatarPath);
        File file2 = new File(file.getPath() + System.currentTimeMillis());
        boolean z17 = false;
        if (HttpDownloadUtil.downloadData(videoAppInterface, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", str), file2, 0), (HttpDownloadUtil.b) null) == 0) {
            z17 = true;
        }
        if (z17) {
            synchronized (this.f73221a) {
                if (file2.exists()) {
                    z17 = file2.renameTo(file);
                }
                z16 = z17;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "downloadHDAvatar suc bRet = " + z16 + ", path = " + fHDAvatarPath + ", downloadURL = " + str);
            }
            if (z16) {
                e(videoAppInterface.getApp().getResources(), aVar, i3, fHDAvatarPath, weakReference);
            }
            z17 = z16;
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "downloadHDAvatar fail bRet = " + z17 + ", path = " + fHDAvatarPath + ", downloadURL = " + str);
            }
            if (file2.exists()) {
                file2.delete();
            }
        }
        if (!z17) {
            if (weakReference != null) {
                bVar = weakReference.get();
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.D1(aVar, null);
            }
        }
    }

    private void g(final VideoAppInterface videoAppInterface, final ew.a aVar, final WeakReference<b> weakReference, final int i3) {
        b bVar;
        try {
            l(videoAppInterface, aVar, weakReference, i3);
        } catch (NullPointerException unused) {
            if (weakReference == null) {
                bVar = null;
            } else {
                bVar = weakReference.get();
            }
            if (bVar != null) {
                bVar.D1(aVar, null);
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.avatar.QavAvatarHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        QavAvatarHelper.this.l(videoAppInterface, aVar, weakReference, i3);
                    } catch (Throwable th5) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("QavAvatarHelper", 2, "downloadHDAvatar, retry fail", th5);
                        }
                    }
                }
            }, 16, null, true, 5000L);
        }
    }

    public static String h(ew.a aVar, int i3) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        sb5.append(aVar.f397247a);
        sb5.append("_");
        sb5.append(aVar.f397248b);
        sb5.append("_");
        sb5.append(aVar.f397249c);
        sb5.append("_");
        if (aVar.f397250d) {
            str = "0";
        } else {
            str = "1";
        }
        sb5.append(str);
        sb5.append("_");
        sb5.append(i3);
        return sb5.toString();
    }

    private Drawable i(String str) {
        Drawable e16;
        synchronized (this.f73223c) {
            e16 = this.f73223c.e(str);
        }
        return e16;
    }

    public static QavAvatarHelper k() {
        if (f73220d == null) {
            synchronized (QavAvatarHelper.class) {
                if (f73220d == null) {
                    f73220d = new QavAvatarHelper();
                }
            }
        }
        return f73220d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(final VideoAppInterface videoAppInterface, final ew.a aVar, final WeakReference<b> weakReference, int i3) {
        b bVar;
        final String x16 = videoAppInterface.x(aVar, i3);
        final int b16 = c.b(x16);
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "tryDownloadHDAvatar, param = " + aVar + ", avatarSize = " + b16 + ", downloadUrl = " + x16);
        }
        if (!TextUtils.isEmpty(x16) && (b16 > 140 || b16 == 0)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.avatar.QavAvatarHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    QavAvatarHelper.this.f(videoAppInterface, aVar, b16, x16, weakReference);
                }
            }, 128, null, false);
            return;
        }
        if (weakReference == null) {
            bVar = null;
        } else {
            bVar = weakReference.get();
        }
        if (bVar != null) {
            bVar.D1(aVar, null);
        }
    }

    public void d(String str) {
        ArrayList arrayList;
        synchronized (this.f73222b) {
            Iterator<String> it = this.f73222b.iterator();
            arrayList = null;
            while (it.hasNext()) {
                String next = it.next();
                if (next.contains(str)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(2);
                    }
                    arrayList.add(next);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                String str2 = (String) it5.next();
                synchronized (this.f73223c) {
                    this.f73223c.g(str2);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 2, "clearCache, uin = " + str + ", list = " + arrayList);
        }
    }

    public void j(VideoAppInterface videoAppInterface, ew.a aVar, WeakReference<b> weakReference) {
        b bVar;
        if (videoAppInterface == null) {
            return;
        }
        if (weakReference != null) {
            bVar = weakReference.get();
        } else {
            bVar = null;
        }
        if (!c.d(aVar.f397247a)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "getHDAvatarDrawable, not support, param = " + aVar);
            }
            if (bVar != null) {
                bVar.D1(aVar, null);
                return;
            }
            return;
        }
        Drawable i3 = i(h(aVar, 640));
        if (i3 != null) {
            if (bVar != null) {
                bVar.D1(aVar, i3);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "getHDAvatarDrawable, from cache, param = " + aVar);
                return;
            }
            return;
        }
        String fHDAvatarPath = FaceUtil.getFHDAvatarPath(aVar.f397248b);
        if (q.p(fHDAvatarPath)) {
            e(videoAppInterface.getApp().getResources(), aVar, 640, fHDAvatarPath, weakReference);
        } else {
            g(videoAppInterface, aVar, weakReference, 640);
        }
    }
}
