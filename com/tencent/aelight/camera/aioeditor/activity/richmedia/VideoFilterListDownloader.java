package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetFailedListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes32.dex */
public class VideoFilterListDownloader implements NetFailedListener {

    /* renamed from: h, reason: collision with root package name */
    private static VideoFilterListDownloader f66376h;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, a> f66377d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private Lock f66378e = new ReentrantLock();

    /* renamed from: f, reason: collision with root package name */
    b f66379f = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public FilterDesc f66381a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<WeakReference<c>> f66382b = new ArrayList<>();

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface c {
        void a(boolean z16);
    }

    private boolean d(FilterDesc filterDesc, c cVar) {
        boolean z16;
        this.f66378e.lock();
        try {
            a aVar = this.f66377d.get(filterDesc.name);
            if (aVar == null) {
                a aVar2 = new a();
                aVar2.f66381a = filterDesc;
                aVar2.f66382b.add(new WeakReference<>(cVar));
                this.f66377d.put(filterDesc.name, aVar2);
                z16 = false;
            } else {
                aVar.f66382b.add(new WeakReference<>(cVar));
                z16 = true;
            }
            return z16;
        } finally {
            this.f66378e.unlock();
        }
    }

    public static boolean e(FilterDesc filterDesc) {
        String resFold = filterDesc.getResFold(com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j);
        String str = filterDesc.respicname;
        if (str != null && !str.equals("")) {
            if (!new File(resFold + filterDesc.respicname).exists()) {
                QLog.i("VideoFilterListDownloader", 2, "check false respicname file not exists :" + filterDesc.name);
                return true;
            }
        }
        return false;
    }

    public static VideoFilterListDownloader f() {
        if (f66376h == null) {
            f66376h = new VideoFilterListDownloader();
        }
        return f66376h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(FilterDesc filterDesc, boolean z16) {
        ArrayList arrayList = new ArrayList();
        this.f66378e.lock();
        try {
            a aVar = this.f66377d.get(filterDesc.name);
            if (aVar != null && aVar.f66382b != null) {
                for (int i3 = 0; i3 < aVar.f66382b.size(); i3++) {
                    c cVar = aVar.f66382b.get(i3).get();
                    if (cVar != null) {
                        arrayList.add(cVar);
                    }
                }
                aVar.f66382b.clear();
                this.f66377d.remove(filterDesc.name);
            }
            this.f66378e.unlock();
            if (arrayList.size() > 0) {
                for (int i16 = 0; i16 < arrayList.size(); i16++) {
                    c cVar2 = (c) arrayList.get(i16);
                    if (cVar2 != null) {
                        cVar2.a(z16);
                    }
                }
            }
        } catch (Throwable th5) {
            this.f66378e.unlock();
            throw th5;
        }
    }

    private void i(final FilterDesc filterDesc) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = VideoFilterListDownloader.this.f66379f;
                httpNetReq.mReqUrl = filterDesc.resurl;
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j + filterDesc.name + ".zip";
                httpNetReq.setUserData(filterDesc);
                httpNetReq.mFailedListener = VideoFilterListDownloader.this;
                FilterDesc filterDesc2 = filterDesc;
                if (filterDesc2.bundle == null) {
                    filterDesc2.bundle = new Bundle();
                }
                filterDesc.bundle.putLong("requestStartTime", System.currentTimeMillis());
                ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
            }
        });
    }

    public void c(FilterDesc filterDesc, c cVar) {
        if (d(filterDesc, cVar)) {
            return;
        }
        i(filterDesc);
    }

    @Override // com.tencent.mobileqq.transfile.NetFailedListener
    public void onFailed(NetResp netResp) {
        FilterDesc filterDesc = (FilterDesc) netResp.mReq.getUserData();
        if (filterDesc != null) {
            QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener onFailed file: " + filterDesc.resurl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(FilterDesc filterDesc, long j3, int i3) {
        if (filterDesc != null) {
            try {
                m.a aVar = ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).I;
                ArrayList<QIMFilterCategoryItem> arrayList = new ArrayList<>();
                if (aVar != null) {
                    arrayList = aVar.c(0).f66517c;
                }
                for (QIMFilterCategoryItem qIMFilterCategoryItem : arrayList) {
                    if (qIMFilterCategoryItem.f66701i == 103) {
                        Iterator<String> it = qIMFilterCategoryItem.F.iterator();
                        while (it.hasNext()) {
                            if (it.next().equals(filterDesc.name)) {
                                VSReporter.q("record_filter_download", VSReporter.d(i3, System.currentTimeMillis() - filterDesc.bundle.getLong("requestStartTime", System.currentTimeMillis()), filterDesc.resurl, j3, filterDesc.name));
                                QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener report.");
                                return;
                            }
                        }
                    }
                }
            } catch (Exception unused) {
                QLog.i("VideoFilterListDownloader", 2, "Report exception.");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements INetEngineListener {
        b() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            FilterDesc filterDesc = (FilterDesc) netResp.mReq.getUserData();
            if (filterDesc != null) {
                boolean z16 = false;
                if (netResp.mResult != 0) {
                    QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + netResp.mErrCode + ", errorMsg: " + netResp.mErrDesc + ", file: " + filterDesc.resurl);
                    VideoFilterListDownloader.this.h(filterDesc, 0L, 5);
                } else if (!filterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(netResp.mReq.mOutPath))) {
                    QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
                    FileUtils.deleteFile(netResp.mReq.mOutPath);
                } else {
                    QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + filterDesc.name + filterDesc.resurl);
                    try {
                        FileUtils.uncompressZip(netResp.mReq.mOutPath, com.tencent.aelight.camera.aioeditor.richmedia.capture.data.a.f67459j, false);
                        if (filterDesc.bundle == null) {
                            filterDesc.bundle = new Bundle();
                        }
                        VideoFilterListDownloader.this.h(filterDesc, FileUtils.getFileSizes(netResp.mReq.mOutPath), 0);
                        FileUtils.deleteFile(netResp.mReq.mOutPath);
                        z16 = true;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
                        VideoFilterListDownloader.this.h(filterDesc, 0L, 4);
                    }
                }
                VideoFilterListDownloader.this.g(filterDesc, z16);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
