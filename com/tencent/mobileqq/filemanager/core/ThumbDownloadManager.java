package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.core.HttpThumbDownloader;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ThumbDownloadManager {

    /* renamed from: b, reason: collision with root package name */
    private QQAppInterface f207587b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedHashMap<String, b> f207588c = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private List<b> f207589d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private List<String> f207590e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private HttpThumbDownloader.a f207591f = new a();

    /* renamed from: a, reason: collision with root package name */
    private Handler f207586a = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        String f207597a;

        /* renamed from: b, reason: collision with root package name */
        String f207598b;

        /* renamed from: c, reason: collision with root package name */
        long f207599c;
    }

    public ThumbDownloadManager(QQAppInterface qQAppInterface) {
        this.f207587b = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(b bVar) {
        if (bVar == null) {
            return;
        }
        this.f207588c.put(bVar.f207597a, bVar);
        if (QLog.isColorLevel()) {
            QLog.i("ThumbDownloadManager", 2, "addDownloadingTask : MapDowloadingTask currentSize[" + this.f207588c.size() + "]");
        }
    }

    private boolean l(String str, String str2) {
        if (this.f207590e.contains(str2) || q.f(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final String str) {
        this.f207586a.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                ThumbDownloadManager.this.r(str);
                ThumbDownloadManager.this.q(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f207586a.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (ThumbDownloadManager.this.f207588c.size() >= 8 || ThumbDownloadManager.this.f207589d.size() == 0) {
                    return;
                }
                b bVar = (b) ThumbDownloadManager.this.f207589d.get(0);
                if (bVar == null) {
                    ThumbDownloadManager.this.f207589d.remove(0);
                    ThumbDownloadManager.this.n();
                } else {
                    ThumbDownloadManager.this.f207589d.remove(bVar);
                    ThumbDownloadManager.this.k(bVar);
                    ThumbDownloadManager.this.s(bVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(long j3, String str, String str2) {
        String zipThumbUrlWithFileUrl = FileManagerUtil.getZipThumbUrlWithFileUrl(str2);
        if (!l(str, zipThumbUrlWithFileUrl)) {
            return false;
        }
        b bVar = new b();
        bVar.f207598b = str;
        bVar.f207597a = zipThumbUrlWithFileUrl;
        bVar.f207599c = j3;
        this.f207590e.add(zipThumbUrlWithFileUrl);
        this.f207589d.add(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        if (!this.f207590e.remove(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask remove task fail, thumbUrl[" + str + "]");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ThumbDownloadManager", 2, "removeDownloadingList : ListDownloadTask currentSize[" + this.f207590e.size() + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        this.f207588c.remove(str);
        if (QLog.isColorLevel()) {
            QLog.i("ThumbDownloadManager", 2, "removeDownloadingTask : MapDowloadingTask currentSize[" + this.f207588c.size() + "]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(b bVar) {
        if (bVar == null) {
            return;
        }
        new HttpThumbDownloader(this.f207587b).b(bVar.f207599c, bVar.f207598b, bVar.f207597a, this.f207591f);
    }

    public void p(final long j3, final String str, final String str2) {
        this.f207586a.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.ThumbDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (ThumbDownloadManager.this.o(j3, str, str2)) {
                    ThumbDownloadManager.this.n();
                }
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements HttpThumbDownloader.a {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.a
        public void c(String str, boolean z16, int i3, String str2, long j3) {
            ThumbDownloadManager.this.m(str);
            ThumbDownloadManager.this.f207587b.getFileManagerNotifyCenter().b(z16, 60, new Object[]{Long.valueOf(j3), Integer.valueOf(i3), str2, str});
            ThumbDownloadManager.this.n();
        }

        @Override // com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.a
        public void b(String str) {
        }

        @Override // com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.a
        public void a(String str, int i3) {
        }
    }
}
