package com.qzone.business.gift.business.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.qzone.util.al;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGiftDownloadService {

    /* renamed from: e, reason: collision with root package name */
    private static final al<QzoneGiftDownloadService, Void> f44511e = new a();

    /* renamed from: a, reason: collision with root package name */
    private Downloader f44512a;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f44514c;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, c> f44513b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    Downloader.DownloadListener f44515d = new b();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QzoneGiftDownloadService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneGiftDownloadService a(Void r16) {
            return new QzoneGiftDownloadService();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Downloader.DownloadListener {
        b() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QzoneGiftDownloadService.this.h(str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QzoneGiftDownloadService.this.h(str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            Message obtainMessage;
            c cVar = (c) QzoneGiftDownloadService.this.f44513b.get(str);
            if (cVar != null) {
                float f17 = f16 * 100.0f;
                if (f17 - cVar.f44526e < 10.0f) {
                    return;
                }
                int i3 = cVar.f44524c;
                Handler handler = cVar.f44525d;
                if (TextUtils.isEmpty(cVar.f44522a) || handler == null || (obtainMessage = handler.obtainMessage(i3)) == null) {
                    return;
                }
                int i16 = (((int) f17) / 10) * 10;
                cVar.f44526e = i16;
                if (i16 < 100) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS, cVar.f44526e);
                    obtainMessage.obj = bundle;
                    handler.sendMessage(obtainMessage);
                }
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            File file;
            int i3;
            Handler handler;
            c cVar = (c) QzoneGiftDownloadService.this.f44513b.get(str);
            if (cVar == null || TextUtils.isEmpty(cVar.f44522a) || TextUtils.isEmpty(cVar.f44523b) || cVar.f44525d == null) {
                return;
            }
            String gifFullScreenDir = CacheManager.getGifFullScreenDir();
            String str2 = gifFullScreenDir + File.separator + cVar.f44522a + ".zip";
            try {
                if (!cVar.f44523b.equalsIgnoreCase(PluginStatic.encodeFile(str2))) {
                    QzoneGiftDownloadService.this.h(str);
                    return;
                }
            } catch (Exception e16) {
                QZLog.w(e16);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(gifFullScreenDir);
            String str3 = File.separator;
            sb5.append(str3);
            sb5.append(cVar.f44522a);
            sb5.append(str3);
            String sb6 = sb5.toString();
            File file2 = new File(sb6);
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            try {
                try {
                    ZipUtils.unZipFolder(str2, sb6);
                    i3 = cVar.f44524c;
                    handler = cVar.f44525d;
                } catch (Exception e17) {
                    QLog.w("QzoneGiftDownloadService", 1, "unzipTofolder" + e17);
                    file = new File(str2);
                }
                if (handler == null) {
                    return;
                }
                Message obtainMessage = handler.obtainMessage(i3);
                if (obtainMessage != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS, 100);
                    obtainMessage.obj = bundle;
                    handler.sendMessage(obtainMessage);
                }
                QzoneGiftDownloadService.this.f44514c.remove(str);
                QzoneGiftDownloadService.this.f44513b.remove(str);
                file = new File(str2);
                file.delete();
            } finally {
                new File(str2).delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f44522a;

        /* renamed from: b, reason: collision with root package name */
        public String f44523b;

        /* renamed from: c, reason: collision with root package name */
        public int f44524c;

        /* renamed from: d, reason: collision with root package name */
        public Handler f44525d;

        /* renamed from: e, reason: collision with root package name */
        public int f44526e;

        public c() {
        }

        public c(QzoneGiftDownloadService qzoneGiftDownloadService, String str, String str2, int i3, Handler handler, int i16) {
            this();
            this.f44522a = str;
            this.f44523b = str2;
            this.f44524c = i3;
            this.f44525d = handler;
            this.f44526e = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        c cVar = this.f44513b.get(str);
        if (cVar == null) {
            return;
        }
        int i3 = cVar.f44524c;
        Handler handler = cVar.f44525d;
        if (TextUtils.isEmpty(cVar.f44522a) || handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(i3);
        if (obtainMessage != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS, -1);
            obtainMessage.obj = bundle;
            handler.sendMessage(obtainMessage);
        }
        this.f44514c.remove(str);
        this.f44513b.remove(str);
    }

    public static QzoneGiftDownloadService i() {
        return f44511e.get(null);
    }

    public void g(final String str, final String str2, final String str3, final int i3, final Handler handler) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || handler == null) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.business.gift.business.service.QzoneGiftDownloadService.2
            @Override // java.lang.Runnable
            public void run() {
                if (QzoneGiftDownloadService.this.f44512a == null) {
                    QzoneGiftDownloadService.this.f44512a = FileDownloaderManager.g().getDownloader();
                }
                String gifFullScreenDir = CacheManager.getGifFullScreenDir();
                File file = new File(gifFullScreenDir);
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
                QzoneGiftDownloadService.this.f44512a.download(str2, gifFullScreenDir + File.separator + str + ".zip", QzoneGiftDownloadService.this.f44515d);
                if (QzoneGiftDownloadService.this.f44514c == null) {
                    QzoneGiftDownloadService.this.f44514c = Collections.synchronizedSet(new HashSet());
                }
                QzoneGiftDownloadService.this.f44514c.add(str2);
                QzoneGiftDownloadService.this.f44513b.put(str2, new c(QzoneGiftDownloadService.this, str, str3, i3, handler, 0));
            }
        });
    }
}
