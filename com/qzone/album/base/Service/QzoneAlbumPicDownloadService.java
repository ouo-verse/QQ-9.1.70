package com.qzone.album.base.Service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.album.util.j;
import com.qzone.homepage.ui.Facade.f;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.FileUtils;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes39.dex */
public class QzoneAlbumPicDownloadService extends f {

    /* renamed from: f, reason: collision with root package name */
    private static QzoneAlbumPicDownloadService f41945f;

    /* renamed from: c, reason: collision with root package name */
    private c f41946c = null;

    /* renamed from: d, reason: collision with root package name */
    private c f41947d = null;

    /* renamed from: e, reason: collision with root package name */
    ImageLoader.Options f41948e;

    /* loaded from: classes39.dex */
    public interface c {
        void a(String str, ArrayList<String> arrayList);

        void onDownloadFailed(String str);
    }

    QzoneAlbumPicDownloadService() {
        this.f41948e = new ImageLoader.Options();
        ImageLoader.Options options = new ImageLoader.Options();
        this.f41948e = options;
        options.useMainThread = false;
        options.imageConfig = Bitmap.Config.RGB_565;
        options.fileRootPath = g4.d.f401216a;
    }

    public static synchronized QzoneAlbumPicDownloadService o() {
        QzoneAlbumPicDownloadService qzoneAlbumPicDownloadService;
        synchronized (QzoneAlbumPicDownloadService.class) {
            if (f41945f == null) {
                f41945f = new QzoneAlbumPicDownloadService();
            }
            qzoneAlbumPicDownloadService = f41945f;
        }
        return qzoneAlbumPicDownloadService;
    }

    public static String p(String str) {
        boolean z16;
        String str2;
        ImageLoader imageLoader = ImageLoader.getInstance(BaseApplication.getContext());
        ImageLoader.Options options = new ImageLoader.Options();
        String str3 = g4.d.f401216a;
        options.fileRootPath = str3;
        File imageFile = imageLoader.getImageFile(str, options);
        String str4 = null;
        if (imageFile == null) {
            return null;
        }
        String absolutePath = imageFile.getAbsolutePath();
        String P = u4.a.z().P(absolutePath);
        String fileName = FileManagerUtil.getFileName(absolutePath);
        if ("webp".equals(P)) {
            str2 = MimeHelper.IMAGE_SUBTYPE_JPEG;
            z16 = true;
        } else {
            z16 = false;
            str2 = P;
        }
        if (z16) {
            try {
                File file = new File(str3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str5 = str3 + (fileName + "." + str2);
                if (new File(str5).exists()) {
                    return str5;
                }
                Bitmap n3 = com.qzone.util.image.c.n(imageFile.getAbsolutePath(), null);
                if (n3 != null) {
                    if (com.qzone.util.image.c.V(n3, str5, Bitmap.CompressFormat.JPEG, 90, true)) {
                        return str5;
                    }
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        if (P.equals("sharpp")) {
            try {
                return u4.a.z().m(new File(absolutePath), true);
            } catch (OutOfMemoryError e16) {
                QZLog.w("QzoneAlbumPicDownloadService", "Out of Memory ", e16);
            }
        }
        if (!z16) {
            str4 = g4.d.f401216a + (fileName + "." + str2);
            if (!new File(str4).exists()) {
                FileUtils.copyFile(new File(imageFile.getAbsolutePath()), new File(str4));
            }
        }
        return str4;
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void b(String str, int i3, int i16, String str2) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneAlbumPicDownloadService", 2, "onDownloadFailed");
        }
        c cVar = this.f41947d;
        if (cVar != null) {
            cVar.onDownloadFailed(null);
            this.f41947d = null;
        }
        c cVar2 = this.f41946c;
        if (cVar2 != null) {
            cVar2.onDownloadFailed(null);
            this.f41946c = null;
        }
        j(str);
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void d(String str, int i3, int i16, String str2) {
        if (this.f41947d != null) {
            this.f41947d = null;
        }
        if (this.f41946c != null) {
            this.f41946c = null;
        }
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void e(String str, int i3, int i16, String str2) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneAlbumPicDownloadService", 2, "onDownloadSucceed");
        }
        if (this.f41947d != null) {
            this.f41947d = null;
        }
        if (this.f41946c != null) {
            this.f41946c = null;
        }
        j(str);
    }

    public void k(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                this.f47585a.cancel(next, null, this.f41948e);
            }
        }
    }

    public void l(String str, List<String> list, c cVar) {
        if (g(str) != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneAlbumPicDownloadService", 2, "status != null taskId:" + str);
            }
            QZLog.d("QzoneAlbumPicDownloadService", 2, "status != null taskId:", str);
            return;
        }
        if (list != null) {
            this.f41946c = cVar;
            AlbumBatchImageDownloadStatus albumBatchImageDownloadStatus = new AlbumBatchImageDownloadStatus(str, list.size(), this, cVar);
            f(str, albumBatchImageDownloadStatus);
            for (String str2 : list) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneAlbumPicDownloadService", 2, "url:" + str2);
                }
                if (this.f47585a.downloadImageOnly(str2, albumBatchImageDownloadStatus, this.f41948e) != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneAlbumPicDownloadService", 2, "f.exists()");
                    }
                    albumBatchImageDownloadStatus.onDownloadSucceed(str2);
                }
            }
        }
    }

    public void m(Context context, String str, List<String> list, c cVar) {
        if (g(str) != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneAlbumPicDownloadService", 2, "status != null taskId:" + str);
            }
            QZLog.d("QzoneAlbumPicDownloadService", 2, "status != null taskId:", str);
            return;
        }
        if (list != null) {
            this.f41947d = cVar;
            AlbumBatchImageDownloadStatus albumBatchImageDownloadStatus = new AlbumBatchImageDownloadStatus(str, list.size(), this, cVar, 2);
            f(str, albumBatchImageDownloadStatus);
            for (String str2 : list) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneAlbumPicDownloadService", 2, "url:" + str2);
                }
                ImageLoader.Options options = new ImageLoader.Options();
                options.useMainThread = false;
                options.imageConfig = Bitmap.Config.RGB_565;
                options.fileRootPath = g4.d.f401216a;
                if (this.f47585a.loadImage(str2, new a(albumBatchImageDownloadStatus, str2), options) != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneAlbumPicDownloadService", 2, "f.exists()");
                    }
                    albumBatchImageDownloadStatus.onDownloadSucceed(str2);
                }
            }
        }
    }

    public void n(Context context, String str, List<String> list, c cVar) {
        if (g(str) == null && list != null) {
            AlbumBatchImageDownloadStatus albumBatchImageDownloadStatus = new AlbumBatchImageDownloadStatus(str, list.size(), this, cVar, 3);
            f(str, albumBatchImageDownloadStatus);
            for (String str2 : list) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneAlbumPicDownloadService", 2, "url:" + str2);
                }
                ImageLoader.Options options = new ImageLoader.Options();
                options.useMainThread = false;
                options.imageConfig = Bitmap.Config.RGB_565;
                options.fileRootPath = g4.d.f401216a;
                if (this.f47585a.loadImage(str2, new b(albumBatchImageDownloadStatus, str2), options) != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.d("QzoneAlbumPicDownloadService", 2, "f.exists()");
                    }
                    albumBatchImageDownloadStatus.onDownloadSucceed(str2);
                }
            }
        }
    }

    /* loaded from: classes39.dex */
    public static class AlbumBatchImageDownloadStatus extends f.a {

        /* renamed from: f, reason: collision with root package name */
        public c f41949f;

        /* renamed from: g, reason: collision with root package name */
        ArrayList<String> f41950g;

        /* renamed from: h, reason: collision with root package name */
        private int f41951h;

        public AlbumBatchImageDownloadStatus(String str, int i3, com.qzone.homepage.ui.Facade.a aVar, c cVar) {
            super(str, i3, aVar);
            this.f41950g = new ArrayList<>();
            this.f41951h = 1;
            this.f41949f = cVar;
        }

        @Override // com.qzone.homepage.ui.Facade.f.a, com.tencent.component.media.image.ImageLoader.ImageDownloadListener
        public synchronized void onDownloadSucceed(final String str) {
            String str2 = null;
            if (this.f47588b == 1) {
                int i3 = this.f41951h;
                if (i3 == 2) {
                    str2 = QzoneAlbumPicDownloadService.p(str);
                } else if (i3 != 3) {
                    str2 = j.b(str);
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneAlbumPicDownloadService", 2, "AlbumBatchImageDownloadStatus onDownloadSucceed path:" + str2);
                }
                if (str2 == null && this.f41951h != 3) {
                    QZLog.w("QzoneAlbumPicDownloadService", "AlbumBatchImageDownloadStatus onDownloadFailed");
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.base.Service.QzoneAlbumPicDownloadService.AlbumBatchImageDownloadStatus.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c cVar = AlbumBatchImageDownloadStatus.this.f41949f;
                            if (cVar != null) {
                                cVar.onDownloadFailed(str);
                            }
                        }
                    });
                } else {
                    this.f41950g.add(str2);
                    this.f47591e.e(this.f47587a, 1, 1, str);
                    com.qzone.util.image.c.N(BaseApplication.getContext(), str2);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.base.Service.QzoneAlbumPicDownloadService.AlbumBatchImageDownloadStatus.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumBatchImageDownloadStatus albumBatchImageDownloadStatus = AlbumBatchImageDownloadStatus.this;
                            c cVar = albumBatchImageDownloadStatus.f41949f;
                            if (cVar != null) {
                                cVar.a(str, albumBatchImageDownloadStatus.f41950g);
                            }
                        }
                    });
                }
            } else {
                this.f47589c++;
                int i16 = this.f41951h;
                if (i16 == 2) {
                    str2 = QzoneAlbumPicDownloadService.p(str);
                } else if (i16 != 3) {
                    str2 = j.b(str);
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("QzoneAlbumPicDownloadService", 2, "AlbumBatchImageDownloadStatus onDownloadSucceed url:" + str + " path:" + str2 + " downloadedCount:" + this.f47589c);
                }
                if (str2 == null && this.f41951h != 3) {
                    QZLog.w("QzoneAlbumPicDownloadService", "AlbumBatchImageDownloadStatus onDownloadFailed downloadedCount:" + (this.f47589c - 1));
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.base.Service.QzoneAlbumPicDownloadService.AlbumBatchImageDownloadStatus.3
                        @Override // java.lang.Runnable
                        public void run() {
                            c cVar = AlbumBatchImageDownloadStatus.this.f41949f;
                            if (cVar != null) {
                                cVar.onDownloadFailed(str);
                            }
                        }
                    });
                    return;
                }
                this.f41950g.add(str2);
                com.qzone.util.image.c.N(BaseApplication.getContext(), str2);
                int i17 = this.f47589c;
                int i18 = this.f47588b;
                if (i17 == i18) {
                    this.f47591e.e(this.f47587a, i18, i17, str);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qzone.album.base.Service.QzoneAlbumPicDownloadService.AlbumBatchImageDownloadStatus.4
                        @Override // java.lang.Runnable
                        public void run() {
                            AlbumBatchImageDownloadStatus albumBatchImageDownloadStatus = AlbumBatchImageDownloadStatus.this;
                            c cVar = albumBatchImageDownloadStatus.f41949f;
                            if (cVar != null) {
                                cVar.a(str, albumBatchImageDownloadStatus.f41950g);
                            }
                        }
                    });
                }
            }
        }

        public AlbumBatchImageDownloadStatus(String str, int i3, com.qzone.homepage.ui.Facade.a aVar, c cVar, int i16) {
            super(str, i3, aVar);
            this.f41950g = new ArrayList<>();
            this.f41949f = cVar;
            this.f41951h = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f.a f41956d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f41957e;

        a(f.a aVar, String str) {
            this.f41956d = aVar;
            this.f41957e = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            this.f41956d.onDownloadFailed(this.f41957e);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f41956d.onDownloadSucceed(this.f41957e);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* loaded from: classes39.dex */
    class b implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f.a f41959d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f41960e;

        b(f.a aVar, String str) {
            this.f41959d = aVar;
            this.f41960e = str;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            this.f41959d.onDownloadFailed(this.f41960e);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f41959d.onDownloadSucceed(this.f41960e);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    @Override // com.qzone.homepage.ui.Facade.a
    public void a(String str, int i3) {
    }

    @Override // com.qzone.homepage.ui.Facade.f, com.qzone.homepage.ui.Facade.a
    public void c(String str, int i3, int i16) {
    }
}
