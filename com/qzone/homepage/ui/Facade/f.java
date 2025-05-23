package com.qzone.homepage.ui.Facade;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class f implements com.qzone.homepage.ui.Facade.a {

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, a> f47586b = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    protected ImageLoader f47585a = ImageLoader.getInstance(BaseApplication.getContext());

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements ImageLoader.ImageDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        public String f47587a;

        /* renamed from: b, reason: collision with root package name */
        public int f47588b;

        /* renamed from: c, reason: collision with root package name */
        public int f47589c;

        /* renamed from: d, reason: collision with root package name */
        public int f47590d;

        /* renamed from: e, reason: collision with root package name */
        public com.qzone.homepage.ui.Facade.a f47591e;

        public a(String str, int i3, com.qzone.homepage.ui.Facade.a aVar) {
            this.f47587a = str;
            this.f47588b = i3;
            this.f47591e = aVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
        public void onDownloadCanceled(String str) {
            this.f47591e.d(this.f47587a, this.f47588b, this.f47589c, str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
        public synchronized void onDownloadFailed(String str) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "onDownloadFailed:", str);
            this.f47591e.b(this.f47587a, this.f47588b, this.f47589c, str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            if (this.f47588b == 1) {
                int i3 = (int) (f16 * 100.0f);
                this.f47590d = i3;
                this.f47591e.a(this.f47587a, i3);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageDownloadListener
        public synchronized void onDownloadSucceed(String str) {
            QZLog.d("[PhotoAlbum]downloadPhotoAndVideo", 2, "onDownloadSucceed:", str);
            int i3 = this.f47588b;
            if (i3 == 1) {
                this.f47591e.e(this.f47587a, 1, 1, str);
            } else {
                int i16 = this.f47589c + 1;
                this.f47589c = i16;
                if (i16 == i3) {
                    this.f47591e.e(this.f47587a, i3, i16, str);
                } else {
                    int i17 = (int) ((i16 / i3) * 100.0f);
                    this.f47590d = i17;
                    this.f47591e.a(this.f47587a, i17);
                }
            }
        }
    }

    public static boolean i(String str, String str2) {
        File imageFile;
        ImageLoader imageLoader = ImageLoader.getInstance(BaseApplication.getContext());
        if (!TextUtils.isEmpty(str2)) {
            ImageLoader.Options options = new ImageLoader.Options();
            options.fileRootPath = ImageManager.getCachePath(BaseApplication.getContext(), str2);
            imageFile = imageLoader.getImageFile(str, options);
        } else {
            imageFile = imageLoader.getImageFile(str);
        }
        return imageFile != null && imageFile.exists();
    }

    public static boolean h(List<String> list, String str) {
        if (list == null) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!i(it.next(), str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(String str, a aVar) {
        if (str == null) {
            return false;
        }
        synchronized (this.f47586b) {
            this.f47586b.put(str, aVar);
        }
        return true;
    }

    public a g(String str) {
        a aVar;
        if (str == null) {
            return null;
        }
        synchronized (this.f47586b) {
            aVar = this.f47586b.get(str);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j(String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f47586b) {
            this.f47586b.remove(str);
        }
        return true;
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void c(String str, int i3, int i16) {
    }
}
