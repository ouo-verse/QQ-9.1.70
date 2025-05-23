package com.qzone.proxy.feedcomponent.util;

import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import java.io.File;
import java.lang.ref.WeakReference;
import s8.k;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneZipCacheHelper {

    /* renamed from: a, reason: collision with root package name */
    public static int f50871a = 1;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(boolean z16, boolean z17);
    }

    public static boolean a(final String str, final String str2, String str3, final int i3, int i16, a aVar) {
        File[] listFiles;
        try {
            final String d16 = d(str2, str3, i16);
            File file = new File(d16);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && ((i3 == -1 || listFiles.length == i3) && listFiles.length > 0)) {
                return true;
            }
            final WeakReference weakReference = new WeakReference(aVar);
            FeedGlobalEnv.g().getBackgroundHandler().post(new Runnable() { // from class: com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles2;
                    int i17;
                    com.qzone.proxy.feedcomponent.b.e("QzoneZipCacheHelper", String.format("delay 10s,url:%s,path:%s", str2, d16));
                    File file2 = new File(d16);
                    boolean z16 = file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles()) != null && ((i17 = i3) == -1 || listFiles2.length == i17) && listFiles2.length > 0;
                    String str4 = d16 + ".zip";
                    File file3 = new File(str4);
                    if (!z16) {
                        DownloaderFactory.getInstance(FeedGlobalEnv.getContext()).getCommonDownloader().download(str, str4, new a(file3));
                    }
                    WeakReference weakReference2 = weakReference;
                    if (weakReference2 != null) {
                        a aVar2 = (a) weakReference2.get();
                        if (aVar2 != null) {
                            aVar2.a(z16, false);
                        } else {
                            com.qzone.proxy.feedcomponent.b.e("QzoneZipCacheHelper", "callback is null");
                        }
                    }
                    try {
                        if (file3.exists()) {
                            s8.k.b().a(file3);
                        }
                    } catch (Throwable unused) {
                    }
                }

                /* compiled from: P */
                /* renamed from: com.qzone.proxy.feedcomponent.util.QzoneZipCacheHelper$1$a */
                /* loaded from: classes39.dex */
                class a implements Downloader.DownloadListener {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ File f50877a;

                    a(File file) {
                        this.f50877a = file;
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadCanceled(String str) {
                        com.qzone.proxy.feedcomponent.b.c("QzoneZipCacheHelper", "zip Download Canceled, zip url = " + str);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QzoneZipCacheHelper.g(str, false, d16, this.f50877a, weakReference);
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadFailed(String str, DownloadResult downloadResult) {
                        com.qzone.proxy.feedcomponent.b.c("QzoneZipCacheHelper", "zip Download Failed, zip url = " + str);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QzoneZipCacheHelper.g(str, false, d16, this.f50877a, weakReference);
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QzoneZipCacheHelper.g(str, true, d16, this.f50877a, weakReference);
                    }

                    @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                    public void onDownloadProgress(String str, long j3, float f16) {
                    }
                }
            });
            return false;
        } catch (Throwable th5) {
            com.qzone.proxy.feedcomponent.b.c("QzoneZipCacheHelper", th5.toString());
            return false;
        }
    }

    static void c(File file) {
        if (!file.exists()) {
            file.mkdir();
        } else {
            if (file.isDirectory()) {
                return;
            }
            file.mkdir();
        }
    }

    public static String d(String str, String str2, int i3) {
        if (i3 == f50871a) {
            return FeedGlobalEnv.g().getCacheDir(str) + "/" + str2;
        }
        return e().b(f(str, str2));
    }

    static k.a e() {
        return s8.k.b().c();
    }

    private static String f(String str, String str2) {
        return str + "_" + str2;
    }

    public static void h(String str, String str2) {
        c(new File(str2));
        s8.k.b().e(new File(str), new File(str2));
    }

    static void g(String str, boolean z16, String str2, File file, WeakReference<a> weakReference) {
        if (z16) {
            h(file.getAbsolutePath(), str2);
            e().a(str2, true);
            com.qzone.proxy.feedcomponent.b.e("QzoneZipCacheHelper", String.format("download succ,path:%s", str2));
        } else {
            com.qzone.proxy.feedcomponent.b.e("QzoneZipCacheHelper", String.format("download fail,url:%s,path:%s", str, str2));
        }
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                aVar.a(z16, true);
            } else {
                com.qzone.proxy.feedcomponent.b.e("QzoneZipCacheHelper", "callback is null");
            }
        }
        try {
            if (file.exists()) {
                s8.k.b().a(file);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean b(String str, String str2, String str3, int i3, a aVar) {
        return a(str, str2, str3, i3, 0, aVar);
    }
}
