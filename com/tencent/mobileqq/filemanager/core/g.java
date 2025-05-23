package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static List<k> f207650a;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements SDKInitListener {
        a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (!z16) {
                QLog.e("FileVideoDownloadManager<FileAssistant>XOXO", 1, "initSDKAsync failed!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void b(String str, String str2);

        void e();

        void onError(int i3, String str);
    }

    static {
        QQVideoPlaySDKManager.initQQImp();
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getApplication(), new a());
        }
        f207650a = new ArrayList();
    }

    public static void a(String str) {
        f(str);
        j(str);
    }

    public static k b(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        String a16 = bVar.a();
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "try create downloader:" + a16);
        k e16 = e(a16);
        if (e16 != null) {
            i(bVar);
            synchronized (f207650a) {
                f207650a.add(0, e16);
            }
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("find downloader %s and set to head", a16));
            return e16;
        }
        FileVideoDownloaderImpl fileVideoDownloaderImpl = new FileVideoDownloaderImpl(bVar);
        synchronized (f207650a) {
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "new downloader:" + a16);
            f207650a.add(0, fileVideoDownloaderImpl);
        }
        return fileVideoDownloaderImpl;
    }

    public static void c(String str) {
        k e16 = e(str);
        if (e16 == null) {
            QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", str));
            return;
        }
        synchronized (f207650a) {
            for (k kVar : f207650a) {
                if (kVar != e16) {
                    kVar.stop();
                }
            }
            f207650a.remove(e16);
            f207650a.add(0, e16);
        }
        QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("downloa %s set to head and stop other succ!", str));
        e16.startDownload();
    }

    public static void d() {
        k kVar;
        if (f207650a.size() == 0) {
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "download queue is empty");
            return;
        }
        for (k kVar2 : f207650a) {
            if (kVar2.isDownloading()) {
                QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s downloading", kVar2.a()));
                return;
            }
        }
        synchronized (f207650a) {
            kVar = f207650a.get(0);
        }
        if (kVar == null) {
            QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, "next queue has elment, why get head is null?");
        } else {
            kVar.startDownload();
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("start %s to download", kVar.a()));
        }
    }

    private static k e(String str) {
        k kVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (f207650a) {
            Iterator<k> it = f207650a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k next = it.next();
                if (str.equalsIgnoreCase(next.a())) {
                    kVar = next;
                    break;
                }
            }
        }
        return kVar;
    }

    private static void f(String str) {
        k e16 = e(str);
        if (e16 != null) {
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause!", str));
            e16.stop();
        } else {
            QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####   %s pause failed, not find!", str));
        }
        j(str);
    }

    public static void g(String str) {
        k e16 = e(str);
        if (e16 == null) {
            QLog.w("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("%s not in downloadList", str));
        } else {
            e16.c();
        }
    }

    public static void h() {
        Iterator<k> it = f207650a.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        synchronized (f207650a) {
            f207650a.clear();
        }
    }

    public static void i(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        j(bVar.a());
    }

    public static void j(String str) {
        k e16 = e(str);
        if (e16 == null) {
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, "cann't find downloader with:" + str);
            return;
        }
        e16.stop();
        synchronized (f207650a) {
            f207650a.remove(e16);
            QLog.i("FileVideoDownloadManager<FileAssistant>XOXO", 1, String.format("####  remove downloader:%s, mapsize:%d", str, Integer.valueOf(f207650a.size())));
        }
    }

    public static void k(String str, boolean z16) {
        k e16 = e(str);
        if (e16 == null) {
            return;
        }
        e16.d(!z16);
    }
}
