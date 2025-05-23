package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.g;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileVideoDownloaderImpl implements k, ISPlayerDownloader.Listener, g.b {

    /* renamed from: a, reason: collision with root package name */
    private ISPlayerDownloader f207415a;

    /* renamed from: d, reason: collision with root package name */
    private String f207418d;

    /* renamed from: e, reason: collision with root package name */
    private j f207419e;

    /* renamed from: f, reason: collision with root package name */
    private i f207420f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileviewer.data.b f207421g;

    /* renamed from: b, reason: collision with root package name */
    private int f207416b = -1;

    /* renamed from: c, reason: collision with root package name */
    private SuperPlayerVideoInfo f207417c = null;

    /* renamed from: h, reason: collision with root package name */
    private String f207422h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f207423i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f207424j = false;

    public FileVideoDownloaderImpl(com.tencent.mobileqq.filemanager.fileviewer.data.b bVar) {
        this.f207421g = null;
        this.f207418d = bVar.a();
        this.f207421g = bVar;
    }

    private void i(String str, String str2) {
        String md5 = Md5Utils.getMD5(this.f207418d);
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "----build Videoinfo---- fileid:" + md5);
        String c16 = this.f207421g.c();
        this.f207422h = c16;
        this.f207417c = SuperPlayerFactory.createVideoInfoForUrl(str, 104, md5, c16);
        if (str2 != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str2);
            this.f207417c.setCookies(arrayList);
        }
        this.f207417c.setFormat(104);
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public String a() {
        return this.f207421g.a();
    }

    @Override // com.tencent.mobileqq.filemanager.core.g.b
    public void b(String str, String str2) {
        if (this.f207415a != null && this.f207416b > 0) {
            QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "downloader exsited:" + this.f207416b);
            return;
        }
        i(str, str2);
        ISPlayerDownloader createDownloader = SuperPlayerFactory.createDownloader(BaseApplication.getContext(), 109);
        this.f207415a = createDownloader;
        this.f207416b = createDownloader.startOfflineDownload(this.f207417c, this);
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "start download task:" + this.f207416b);
        i iVar = this.f207420f;
        if (iVar != null) {
            iVar.m(this.f207417c);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public void c() {
        stop();
        onDownloadFinish(0);
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public void d(boolean z16) {
        this.f207423i = z16;
        if (!z16) {
            j();
            this.f207420f = null;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.g.b
    public void e() {
        j();
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public void f(j jVar) {
        this.f207419e = jVar;
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public void g(i iVar) {
        this.f207420f = iVar;
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public boolean isDownloading() {
        if (this.f207416b != -1) {
            return true;
        }
        return false;
    }

    public String j() {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "isPlaying[" + this.f207423i + "], downloadSucc[" + this.f207424j + "]");
        if (this.f207423i || !this.f207424j) {
            return null;
        }
        String recreateFilePath = FileManagerUtil.recreateFilePath(lc1.b.a().getDefaultRecvPath() + this.f207421g.getFileName());
        if (!q.f(this.f207422h)) {
            QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "[" + this.f207421g.a() + "],File rename faild mybe renamed");
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.f207421g.a() + "],File download over rename[" + recreateFilePath + "],src[" + this.f207422h + "]");
        }
        if (!FileUtils.renameFile(new File(this.f207422h), new File(recreateFilePath))) {
            this.f207421g.d(false);
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.f207421g.a() + "],File download over. rename success!");
        }
        this.f207421g.f(recreateFilePath);
        g.j(this.f207421g.a());
        g.d();
        return recreateFilePath;
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadError(int i3, int i16, int i17, String str) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadError(" + i16 + "," + i17 + "," + str + ")");
        this.f207421g.d(false);
        j jVar = this.f207419e;
        if (jVar == null) {
            return;
        }
        jVar.onDownloadError(i16, i17, str);
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadFinish(int i3) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "---------->   onDownloadFinish:" + this.f207418d);
        this.f207424j = true;
        final String j3 = j();
        if (this.f207419e == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                j jVar = FileVideoDownloaderImpl.this.f207419e;
                if (jVar != null) {
                    jVar.r(j3);
                }
            }
        });
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        if (this.f207424j) {
            if (QLog.isColorLevel()) {
                QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", this.f207421g.a()));
                return;
            }
            return;
        }
        this.f207421g.e(j3);
        if (this.f207419e == null) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProgressUpdate(playableDurationMS:" + i16 + ", downloadSpeedKBs:" + i17 + ", currentDownloadSizeByte: " + j3 + ", totalFileSizeByte: " + j16 + ",)");
        }
        this.f207419e.d(i16, i17, j3, j16);
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadProtocolUpdate(int i3, String str, String str2) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProtocolUpdate(" + str + "," + str2 + ",)");
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadStatusUpdate(int i3, int i16) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadStatusUpdate(" + i16 + ",)");
    }

    @Override // com.tencent.mobileqq.filemanager.core.g.b
    public void onError(int i3, String str) {
        i iVar = this.f207420f;
        if (iVar != null) {
            iVar.p(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public boolean startDownload() {
        SuperPlayerVideoInfo superPlayerVideoInfo = this.f207417c;
        if (superPlayerVideoInfo != null) {
            i iVar = this.f207420f;
            if (iVar != null) {
                iVar.m(superPlayerVideoInfo);
            }
            if (this.f207416b > 0) {
                return true;
            }
        }
        this.f207416b = 0;
        long fileSize = this.f207421g.getFileSize();
        String c16 = this.f207421g.c();
        if (fileSize != FileManagerUtil.getFileSizes(c16)) {
            FileUtils.deleteFile(c16);
        }
        this.f207421g.g(this);
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.core.k
    public void stop() {
        if (this.f207416b > 0) {
            QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "stop download:" + this.f207416b);
            this.f207415a.stopOfflineDownload(this.f207416b);
            this.f207421g.b();
        }
        this.f207417c = null;
        this.f207416b = -1;
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadCdnUrlExpired(int i3, Map<String, String> map) {
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadCdnUrlUpdate(int i3, String str) {
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
    }

    @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
    public void onDownloadCdnUrlInfoUpdate(int i3, String str, String str2, String str3, String str4) {
    }
}
