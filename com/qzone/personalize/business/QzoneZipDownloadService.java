package com.qzone.personalize.business;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.misc.network.downloader.FileDownloaderManager;
import com.qzone.util.al;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.magicface.model.f;
import com.tencent.open.base.MD5Utils;
import cooperation.qzone.LocalMultiProcConfig;
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
public class QzoneZipDownloadService {

    /* renamed from: e, reason: collision with root package name */
    private static final al<QzoneZipDownloadService, Void> f49155e = new a();

    /* renamed from: a, reason: collision with root package name */
    private Downloader f49156a;

    /* renamed from: c, reason: collision with root package name */
    private Set<String> f49158c;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, c> f49157b = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    Downloader.DownloadListener f49159d = new b();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QzoneZipDownloadService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneZipDownloadService a(Void r16) {
            return new QzoneZipDownloadService();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Downloader.DownloadListener {
        b() {
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            QzoneZipDownloadService.this.j(str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            QzoneZipDownloadService.this.j(str);
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            Message obtainMessage;
            c cVar = (c) QzoneZipDownloadService.this.f49157b.get(str);
            if (cVar != null) {
                float f17 = f16 * 100.0f;
                if (f17 - cVar.f49169c < 10.0f) {
                    return;
                }
                int i3 = cVar.f49167a;
                Handler handler = cVar.f49168b;
                if (handler == null || (obtainMessage = handler.obtainMessage(i3)) == null) {
                    return;
                }
                int i16 = (((int) f17) / 10) * 10;
                cVar.f49169c = i16;
                if (i16 < 100) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS, cVar.f49169c);
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
            try {
                c cVar = (c) QzoneZipDownloadService.this.f49157b.get(str);
                if (cVar != null) {
                    String str2 = cVar.f49170d;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    String str3 = File.separator;
                    sb5.append(str3);
                    sb5.append(MD5Utils.toMD5(str));
                    sb5.append(".zip");
                    String sb6 = sb5.toString();
                    String str4 = str2 + str3 + MD5Utils.toMD5(str) + str3;
                    File file2 = new File(str4);
                    if (!file2.exists() || !file2.isDirectory()) {
                        file2.mkdirs();
                    }
                    try {
                        ZipUtils.unZipFolder(sb6, str4);
                        i3 = cVar.f49167a;
                        handler = cVar.f49168b;
                        QzoneZipDownloadService.this.f49158c.remove(str);
                        QzoneZipDownloadService.this.f49157b.remove(str);
                    } catch (Exception unused) {
                        file = new File(sb6);
                    } catch (Throwable th5) {
                        new File(sb6).delete();
                        throw th5;
                    }
                    if (handler == null) {
                        new File(sb6).delete();
                        return;
                    }
                    Message obtainMessage = handler.obtainMessage(i3);
                    if (obtainMessage != null) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(RemoteHandleConst.PARAM_FULLSCREEN_GIFT_DOWNLOADPROGRESS, 100);
                        obtainMessage.obj = bundle;
                        handler.sendMessage(obtainMessage);
                    }
                    handler.sendMessage(handler.obtainMessage(0));
                    file = new File(sb6);
                    file.delete();
                }
            } catch (Exception e16) {
                QZLog.e("QzoneZipDownloadService", "download zip exception " + e16 + " URL " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public int f49167a;

        /* renamed from: b, reason: collision with root package name */
        public Handler f49168b;

        /* renamed from: c, reason: collision with root package name */
        public int f49169c;

        /* renamed from: d, reason: collision with root package name */
        public String f49170d;

        public c() {
        }

        public c(QzoneZipDownloadService qzoneZipDownloadService, int i3, Handler handler, int i16, String str) {
            this();
            this.f49167a = i3;
            this.f49168b = handler;
            this.f49169c = i16;
            this.f49170d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        c cVar = this.f49157b.get(str);
        if (cVar == null) {
            return;
        }
        int i3 = cVar.f49167a;
        Handler handler = cVar.f49168b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(i3);
            if (obtainMessage != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("process", -1);
                obtainMessage.obj = bundle;
                handler.sendMessage(obtainMessage);
            }
            this.f49158c.remove(str);
            this.f49157b.remove(str);
        }
    }

    public static QzoneZipDownloadService k() {
        return f49155e.get(null);
    }

    public void g(String str) {
        if (LocalMultiProcConfig.getBool(LocalMultiProcConfig.QZONE_PASSIVE_PRAISE_ENABLED, true)) {
            h(str, 0, null);
        }
    }

    public void h(final String str, final int i3, final Handler handler) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.personalize.business.QzoneZipDownloadService.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QzoneZipDownloadService.this.f49156a == null) {
                        QzoneZipDownloadService.this.f49156a = FileDownloaderManager.g().getDownloader();
                    }
                    String praiseDir = CacheManager.getPraiseDir();
                    File file = new File(praiseDir);
                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }
                    String replace = str.replace("sbig", f.d());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(praiseDir);
                    String str2 = File.separator;
                    sb5.append(str2);
                    sb5.append(MD5Utils.toMD5(replace));
                    sb5.append(str2);
                    File file2 = new File(sb5.toString());
                    if (file2.exists() && file2.isDirectory()) {
                        return;
                    }
                    QzoneZipDownloadService.this.f49156a.download(replace, praiseDir + str2 + MD5Utils.toMD5(replace) + ".zip", QzoneZipDownloadService.this.f49159d);
                    if (QzoneZipDownloadService.this.f49158c == null) {
                        QzoneZipDownloadService.this.f49158c = Collections.synchronizedSet(new HashSet());
                    }
                    QzoneZipDownloadService.this.f49158c.add(replace);
                    QzoneZipDownloadService.this.f49157b.put(replace, new c(QzoneZipDownloadService.this, i3, handler, 0, praiseDir));
                } catch (Exception e16) {
                    QZLog.e("QzoneZipDownloadService", "download zip exception " + e16 + " URL " + str);
                }
            }
        });
    }

    public void i(final String str, final String str2, final Handler handler) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.personalize.business.QzoneZipDownloadService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (QzoneZipDownloadService.this.f49156a == null) {
                        QzoneZipDownloadService.this.f49156a = FileDownloaderManager.g().getDownloader();
                    }
                    String str3 = str2;
                    File file = new File(str3);
                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }
                    String str4 = str;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str3);
                    String str5 = File.separator;
                    sb5.append(str5);
                    sb5.append(MD5Utils.toMD5(str4));
                    sb5.append(str5);
                    File file2 = new File(sb5.toString());
                    if (file2.exists() && file2.isDirectory()) {
                        handler.sendMessage(handler.obtainMessage(0));
                        return;
                    }
                    QzoneZipDownloadService.this.f49156a.download(str4, str3 + str5 + MD5Utils.toMD5(str4) + ".zip", QzoneZipDownloadService.this.f49159d);
                    if (QzoneZipDownloadService.this.f49158c == null) {
                        QzoneZipDownloadService.this.f49158c = Collections.synchronizedSet(new HashSet());
                    }
                    QzoneZipDownloadService.this.f49158c.add(str4);
                    QzoneZipDownloadService.this.f49157b.put(str4, new c(QzoneZipDownloadService.this, -1, handler, 0, str3));
                } catch (Exception e16) {
                    QZLog.e("QzoneZipDownloadService", "download zip exception " + e16 + " url " + str);
                }
            }
        });
    }
}
