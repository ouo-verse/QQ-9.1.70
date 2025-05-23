package com.tencent.adelie.av.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.cache.api.Business;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAvatarHelper {

    /* renamed from: g, reason: collision with root package name */
    private static AdelieAvatarHelper f61485g;

    /* renamed from: d, reason: collision with root package name */
    private ew.b f61489d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f61490e = false;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<ImageView> f61491f = null;

    /* renamed from: a, reason: collision with root package name */
    private final Object f61486a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f61487b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.cache.api.collection.a<String, Drawable> f61488c = new com.tencent.cache.api.collection.a<>(Business.Default, "QavAvatarHelper", 10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.adelie.av.ui.AdelieAvatarHelper$1, reason: invalid class name */
    /* loaded from: classes37.dex */
    public class AnonymousClass1 implements ew.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ew.b f61492d;

        /* compiled from: P */
        /* renamed from: com.tencent.adelie.av.ui.AdelieAvatarHelper$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes37.dex */
        class RunnableC05221 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Drawable f61494d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ew.a f61495e;

            RunnableC05221(Drawable drawable, ew.a aVar) {
                this.f61494d = drawable;
                this.f61495e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = this.f61494d;
                if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                    return;
                }
                ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).handleBitmapToGaussianBg(BaseApplicationImpl.getApplication().getRuntime().getApplication(), this.f61495e, ((BitmapDrawable) this.f61494d).getBitmap(), new ew.b() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.1.1.1
                    @Override // ew.b
                    public void D1(final ew.a aVar, final Drawable drawable2) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.1.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ew.b bVar = AnonymousClass1.this.f61492d;
                                if (bVar != null) {
                                    bVar.D1(aVar, drawable2);
                                }
                            }
                        });
                    }
                });
            }
        }

        AnonymousClass1(ew.b bVar) {
            this.f61492d = bVar;
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            ThreadManagerV2.excute(new RunnableC05221(drawable, aVar), 16, null, false);
        }
    }

    AdelieAvatarHelper() {
    }

    private void e(Drawable drawable, String str) {
        synchronized (this.f61487b) {
            this.f61487b.add(str);
        }
        synchronized (this.f61488c) {
            this.f61488c.f(str, drawable);
        }
    }

    private void f(String str) {
        ArrayList arrayList;
        synchronized (this.f61487b) {
            Iterator<String> it = this.f61487b.iterator();
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
                synchronized (this.f61488c) {
                    this.f61488c.g(str2);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 2, "clearCache, uin = " + str + ", list = " + arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(AppRuntime appRuntime, ew.a aVar, int i3, String str, WeakReference<ew.b> weakReference) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String fHDAvatarPath = FaceUtil.getFHDAvatarPath(aVar.f397248b);
        File file = new File(fHDAvatarPath);
        File file2 = new File(file.getPath() + System.currentTimeMillis());
        boolean z17 = HttpDownloadUtil.downloadData(appRuntime, new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", str), file2, 0), (HttpDownloadUtil.b) null) == 0;
        if (z17) {
            synchronized (this.f61486a) {
                if (file2.exists()) {
                    z17 = file2.renameTo(file);
                }
                z16 = z17;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "downloadHDAvatar suc bRet = " + z16 + ", path = " + fHDAvatarPath + ", downloadURL = " + str);
            }
            if (z16) {
                h(appRuntime.getApp().getResources(), aVar, i3, fHDAvatarPath, weakReference);
            }
            z17 = z16;
        } else {
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "downloadHDAvatar fail bRet = " + z17 + ", path = " + fHDAvatarPath + ", downloadURL = " + str);
            }
            if (file2.exists()) {
                file2.delete();
            }
        }
        if (z17) {
            return;
        }
        ew.b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.D1(aVar, null);
        }
    }

    private void j(final AppRuntime appRuntime, final ew.a aVar, final WeakReference<ew.b> weakReference, final int i3) {
        try {
            r(appRuntime, aVar, weakReference, i3);
        } catch (NullPointerException unused) {
            ew.b bVar = weakReference == null ? null : weakReference.get();
            if (bVar != null) {
                bVar.D1(aVar, null);
            }
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdelieAvatarHelper.this.r(appRuntime, aVar, weakReference, i3);
                    } catch (Throwable th5) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("AdelieAvatarHelper", 2, "downloadHDAvatar, retry fail", th5);
                        }
                    }
                }
            }, 16, null, true, 5000L);
        }
    }

    private static String k(ew.a aVar, int i3) {
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

    private String l(int i3, String str, String str2, int i16) {
        Setting qQHeadSettingFromDB;
        if (QLog.isColorLevel()) {
            QLog.d("AdelieAvatarHelper", 2, "getAvatarDownloadUrl uinType = " + i3 + ", uin = " + str + ", extraUin = " + str2);
        }
        String str3 = null;
        if (ew.c.d(i3) && (qQHeadSettingFromDB = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getQQHeadSettingFromDB(str)) != null && !TextUtils.isEmpty(qQHeadSettingFromDB.uin) && !TextUtils.isEmpty(qQHeadSettingFromDB.url)) {
            str3 = ew.c.a(qQHeadSettingFromDB.url, i16, qQHeadSettingFromDB.bFaceFlags);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "getAvatarDownloadUrl, uin[" + str + "], path[" + str3 + "]");
        }
        return str3;
    }

    private Drawable m(String str) {
        Drawable e16;
        synchronized (this.f61488c) {
            e16 = this.f61488c.e(str);
        }
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView o() {
        WeakReference<ImageView> weakReference = this.f61491f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static AdelieAvatarHelper p() {
        if (f61485g == null) {
            synchronized (AdelieAvatarHelper.class) {
                if (f61485g == null) {
                    f61485g = new AdelieAvatarHelper();
                }
            }
        }
        return f61485g;
    }

    private void q(ImageView imageView) {
        this.f61491f = new WeakReference<>(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final AppRuntime appRuntime, final ew.a aVar, final WeakReference<ew.b> weakReference, int i3) {
        final String l3 = l(aVar.f397247a, aVar.f397248b, aVar.f397249c, i3);
        final int b16 = ew.c.b(l3);
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "tryDownloadHDAvatar, param = " + aVar + ", avatarSize = " + b16 + ", downloadUrl = " + l3);
        }
        if (!TextUtils.isEmpty(l3) && (b16 > 140 || b16 == 0)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.6
                @Override // java.lang.Runnable
                public void run() {
                    AdelieAvatarHelper.this.i(appRuntime, aVar, b16, l3, weakReference);
                }
            }, 128, null, false);
            return;
        }
        ew.b bVar = weakReference == null ? null : weakReference.get();
        if (bVar != null) {
            bVar.D1(aVar, null);
        }
    }

    private void t(final ew.a aVar) {
        if (o() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "updateAvatar, param = " + aVar);
            }
            if (this.f61489d == null) {
                this.f61489d = new ew.b() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.3
                    @Override // ew.b
                    public void D1(ew.a aVar2, final Drawable drawable) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("AdelieAvatarHelper", 4, "updateAvatar, param = " + aVar2 + ", drawable = " + drawable);
                        }
                        final ImageView o16 = AdelieAvatarHelper.this.o();
                        if (o16 == null) {
                            QLog.e("AdelieAvatarHelper", 1, "onGetFaceDrawable error for illegal UI.");
                        } else if (drawable == null) {
                            final Bitmap faceBitmap = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getFaceBitmap(aVar2.f397248b, aVar2.f397250d ? (byte) 4 : (byte) 5, true);
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView = o16;
                                    if (imageView != null) {
                                        imageView.setImageBitmap(faceBitmap);
                                    }
                                }
                            });
                        } else {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.3.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView = o16;
                                    if (imageView != null) {
                                        imageView.setImageDrawable(drawable);
                                    }
                                }
                            });
                        }
                    }
                };
            }
            if (!this.f61490e) {
                this.f61489d.D1(aVar, null);
            }
            this.f61490e = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.4
                @Override // java.lang.Runnable
                public void run() {
                    AdelieAvatarHelper.this.n(aVar, new WeakReference<>(AdelieAvatarHelper.this.f61489d));
                }
            }, 16, null, false);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "updateAvatar, fail view is null. param = " + aVar);
        }
    }

    private void v(final ew.a aVar, final ew.b bVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "GaussianBg updateAvatar, param = " + aVar);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.ui.AdelieAvatarHelper.2
            @Override // java.lang.Runnable
            public void run() {
                AdelieAvatarHelper.this.n(aVar, new WeakReference<>(bVar));
            }
        }, 16, null, false);
    }

    public void s(ImageView imageView, ew.a aVar, Bitmap bitmap) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "updateAvatar, param = " + aVar + ", bitmap = " + bitmap + ", headView = " + imageView);
        }
        if (bitmap != null) {
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        } else if (imageView != null) {
            if (o() != imageView) {
                q(imageView);
                this.f61490e = false;
            }
            t(aVar);
        }
    }

    public void u(ew.a aVar, Bitmap bitmap, ew.b bVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "updateAvatar, param = " + aVar + ", bitmap = " + bitmap);
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(bVar);
        if (bitmap != null) {
            anonymousClass1.D1(aVar, new BitmapDrawable(bitmap));
        } else {
            v(aVar, anonymousClass1);
        }
    }

    public void g(String str) {
        this.f61489d = null;
        ImageView o16 = o();
        if (o16 != null) {
            o16.setImageDrawable(null);
        }
        this.f61491f = null;
        if (!TextUtils.isEmpty(str)) {
            f(str);
        }
        f61485g = null;
    }

    private void h(Resources resources, ew.a aVar, int i3, String str, WeakReference<ew.b> weakReference) {
        BitmapDrawable bitmapDrawable = null;
        ew.b bVar = weakReference != null ? weakReference.get() : null;
        if (!q.p(str)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "decodeAvatar fail, param = " + aVar);
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
                    QLog.i("AdelieAvatarHelper", 2, "decodeAvatar, getCircleFaceBitmap fail, param = " + aVar);
                }
            }
            if (decodeFile != null) {
                bitmapDrawable = new BitmapDrawable(resources, decodeFile);
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("AdelieAvatarHelper", 2, "decodeAvatar " + th5.toString());
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("AdelieAvatarHelper", 4, "decodeAvatar param = " + aVar + ", drawable = " + bitmapDrawable);
        }
        if (bVar != null) {
            bVar.D1(aVar, bitmapDrawable);
        }
        if (bitmapDrawable != null) {
            e(bitmapDrawable, k(aVar, i3));
        }
    }

    public void n(ew.a aVar, WeakReference<ew.b> weakReference) {
        ew.b bVar = weakReference != null ? weakReference.get() : null;
        if (!ew.c.d(aVar.f397247a)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "getHDAvatarDrawable, not support, param = " + aVar);
            }
            if (bVar != null) {
                bVar.D1(aVar, null);
                return;
            }
            return;
        }
        Drawable m3 = m(k(aVar, 640));
        if (m3 != null) {
            if (bVar != null) {
                bVar.D1(aVar, m3);
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("AdelieAvatarHelper", 4, "getHDAvatarDrawable, from cache, param = " + aVar);
                return;
            }
            return;
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String fHDAvatarPath = FaceUtil.getFHDAvatarPath(aVar.f397248b);
        if (q.p(fHDAvatarPath)) {
            h(runtime.getApp().getResources(), aVar, 640, fHDAvatarPath, weakReference);
        } else {
            j(runtime, aVar, weakReference, 640);
        }
    }
}
