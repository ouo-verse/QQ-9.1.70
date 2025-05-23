package com.tencent.mobileqq.shortvideo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class u extends ShortVideoPreDownloader {
    ISPlayerDownloader L;
    ISPlayerPreDownloader M;
    private ArrayList<c> N;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements SDKInitListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ v f288216d;

        a(v vVar) {
            this.f288216d = vVar;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            u.this.z(this.f288216d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements com.tencent.mobileqq.activity.aio.r {

        /* renamed from: d, reason: collision with root package name */
        private v f288220d;

        /* renamed from: e, reason: collision with root package name */
        public View f288221e = new View(BaseApplicationImpl.getApplication());

        /* renamed from: f, reason: collision with root package name */
        private String[] f288222f;

        /* renamed from: h, reason: collision with root package name */
        private String f288223h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class a implements SDKInitListener {
            a() {
            }

            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public void onSDKInited(boolean z16) {
                c.this.d();
                c cVar = c.this;
                BaseSVReceiveOperator.v(u.this.f287671d, cVar.f288220d);
            }
        }

        public c(v vVar) {
            this.f288220d = vVar;
        }

        private void c() {
            if (!QQVideoPlaySDKManager.isSDKReady()) {
                QQVideoPlaySDKManager.initSDKAsync(u.this.f287671d.getApplication(), new a());
            }
            d();
            BaseSVReceiveOperator.v(u.this.f287671d, this.f288220d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            u uVar = u.this;
            if (uVar.M == null) {
                uVar.M = SuperPlayerFactory.createPreDownloader(BaseApplication.getContext(), 101);
            }
            String j3 = j.j(this.f288220d.F, "mp4");
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(this.f288222f, 101, this.f288220d.F.getMd5() + this.f288220d.F.uniseq, j3);
            MessageForShortVideo messageForShortVideo = this.f288220d.F;
            long j16 = ((long) messageForShortVideo.videoFileTime) * 1000;
            int i3 = messageForShortVideo.videoFileSize;
            u.this.M.startPreDownload(createVideoInfoForUrl, j16, ShortVideoUtils.getPreDownloadTime() * 1000);
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + j3);
            }
            this.f288220d.F.setBitValue(0, (byte) 1);
            this.f288220d.F.serial();
            QQMessageFacade messageFacade = u.this.f287671d.getMessageFacade();
            MessageForShortVideo messageForShortVideo2 = this.f288220d.F;
            messageFacade.Y0(messageForShortVideo2.frienduin, messageForShortVideo2.istroop, messageForShortVideo2.uniseq, messageForShortVideo2.msgData);
        }

        @Override // com.tencent.mobileqq.activity.aio.r
        public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
            if (fileMsg.uniseq != this.f288220d.F.uniseq) {
                return;
            }
            int i17 = fileMsg.fileType;
            if (i17 == 6 || i17 == 17 || i17 == 9 || i17 == 20) {
                int i18 = fileMsg.status;
                if (i18 != 2002) {
                    if (i18 == 2004 || i18 == 2005 || i18 == 5001 || i18 == 5002) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
                        }
                        ad adVar = this.f288220d.K;
                        if (adVar != null) {
                            adVar.onComplete(fileMsg.status);
                        }
                        u.this.N.remove(this);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
                }
                String[] strArr = fileMsg.urls;
                if (strArr != null) {
                    this.f288222f = strArr;
                    String str = fileMsg.domain;
                    this.f288223h = str;
                    if (!StringUtil.isEmpty(str)) {
                        StringBuilder sb5 = new StringBuilder();
                        String[] strArr2 = this.f288222f;
                        sb5.append(strArr2[0]);
                        sb5.append("&txhost=");
                        sb5.append(this.f288223h);
                        strArr2[0] = sb5.toString();
                    }
                    v vVar = this.f288220d;
                    vVar.M = this.f288222f;
                    if (vVar.J) {
                        u.this.w(vVar);
                    } else {
                        c();
                    }
                }
                u.this.N.remove(this);
            }
        }
    }

    public u(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.N = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(v vVar) {
        if (vVar != null && vVar.F != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + vVar.F.uniseq);
            }
            if (!QQVideoPlaySDKManager.isSDKReady()) {
                QQVideoPlaySDKManager.initSDKAsync(this.f287671d.getApplication(), new a(vVar));
            }
            z(vVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(v vVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + vVar.F.uniseq);
        }
        this.L = SuperPlayerFactory.createDownloader(BaseApplication.getContext(), 101);
        String j3 = j.j(vVar.F, "mp4");
        String[] strArr = vVar.M;
        if (strArr != null && strArr.length > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (String str : vVar.M) {
                sb5.append(str);
                sb5.append(";");
            }
            int startOfflineDownload = this.L.startOfflineDownload(SuperPlayerFactory.createVideoInfoForUrl(sb5.toString(), 101, vVar.F.getMd5() + vVar.F.uniseq, j3), new b(vVar));
            if (startOfflineDownload > 0) {
                vVar.L = startOfflineDownload;
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.e("ShortVideoPreDownloader", 2, " downFullVideo error preLoadId = " + startOfflineDownload);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
    v j() {
        synchronized (this.f287673f) {
            v y16 = y(this.f287673f);
            if (y16 != null) {
                ShortVideoPreDownloader.o("getShortVideoRequest", "get a short video request from AIORequests");
                return y16;
            }
            synchronized (this.f287674h) {
                v y17 = y(this.f287674h);
                if (y17 != null) {
                    ShortVideoPreDownloader.o("getShortVideoRequest", "get a short video request from C2CRequests");
                    return y17;
                }
                synchronized (this.f287675i) {
                    v y18 = y(this.f287675i);
                    if (y18 != null) {
                        ShortVideoPreDownloader.o("getShortVideoRequest", "get a short video request from DiscussionRequests");
                        return y18;
                    }
                    synchronized (this.f287676m) {
                        v y19 = y(this.f287676m);
                        if (y19 != null) {
                            ShortVideoPreDownloader.o("getShortVideoRequest", "get a short video request from GroupRequests");
                            return y19;
                        }
                        ShortVideoPreDownloader.o("getShortVideoRequest", "cannot get any request");
                        return null;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
    public void n(v vVar) {
        com.tencent.mobileqq.activity.aio.y d16;
        super.n(vVar);
        if (vVar.f288268i.f288040c == 0 && (d16 = com.tencent.mobileqq.activity.aio.y.d(this.f287671d)) != null) {
            c cVar = new c(vVar);
            this.N.add(cVar);
            d16.a(cVar.f288221e, cVar);
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader, mqq.manager.Manager
    public void onDestroy() {
        super.onDestroy();
        ISPlayerPreDownloader iSPlayerPreDownloader = this.M;
        if (iSPlayerPreDownloader != null) {
            iSPlayerPreDownloader.stopAllPreDownload();
            this.M.destory();
            this.M = null;
        }
    }

    public void v(com.tencent.mobileqq.multimsg.save.c cVar) {
        v vVar;
        int i3;
        if (cVar != null && (vVar = cVar.f251676c) != null) {
            r(vVar.F);
            ITransFileController iTransFileController = (ITransFileController) this.f287671d.getRuntimeService(ITransFileController.class);
            n nVar = cVar.f251676c.f288268i;
            IHttpCommunicatorListener findProcessor = iTransFileController.findProcessor(nVar.f288043f, nVar.f288045h);
            if (findProcessor instanceof BaseDownloadProcessor) {
                ((BaseDownloadProcessor) findProcessor).cancel();
            }
            ISPlayerDownloader iSPlayerDownloader = this.L;
            if (iSPlayerDownloader != null && (i3 = cVar.f251676c.L) > 0) {
                iSPlayerDownloader.stopOfflineDownload(i3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
        }
    }

    public void x(com.tencent.mobileqq.multimsg.save.c cVar) {
        v vVar;
        if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
        }
        if (cVar != null && (vVar = cVar.f251676c) != null) {
            r(vVar.F);
            n nVar = cVar.f251676c.f288268i;
            IHttpCommunicatorListener findProcessor = ((ITransFileController) this.f287671d.getRuntimeService(ITransFileController.class)).findProcessor(nVar.f288043f, nVar.f288045h);
            if (findProcessor != null && (findProcessor instanceof BaseDownloadProcessor)) {
                ((BaseDownloadProcessor) findProcessor).cancel();
            }
            n(cVar.f251676c);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
        }
    }

    v y(List<v> list) {
        int size = list.size();
        v vVar = null;
        if (size <= 0) {
            return null;
        }
        if (QQVideoPlaySDKManager.isSDKReady()) {
            int i3 = size - 1;
            v vVar2 = list.get(i3);
            list.remove(i3);
            ShortVideoPreDownloader.o("getRequestBySDKStatus", "sdk installed");
            return vVar2;
        }
        Iterator<v> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            v next = it.next();
            if (next.f288268i.f288040c != 0) {
                list.remove(next);
                vVar = next;
                break;
            }
        }
        ShortVideoPreDownloader.o("getRequestBySDKStatus", "get a short video request");
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements ISPlayerDownloader.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f288218a;

        b(v vVar) {
            this.f288218a = vVar;
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadError(int i3, int i16, int i17, String str) {
            ad adVar;
            if (QLog.isColorLevel() && this.f288218a != null) {
                QLog.d("ShortVideoPreDownloader", 2, "onDownloadError, preLoadId = " + this.f288218a.L + " , uniseq = " + this.f288218a.F.uniseq + ", moduleID = " + i16 + ", errorCode = " + i17 + ", extInfo = " + str);
            }
            v vVar = this.f288218a;
            if (vVar != null && (adVar = vVar.K) != null) {
                adVar.onComplete(i17);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadFinish(int i3) {
            ad adVar;
            if (QLog.isColorLevel() && this.f288218a != null) {
                QLog.d("ShortVideoPreDownloader", 2, "onDownloadFinish, preLoadId = " + this.f288218a.L + " , uniseq = " + this.f288218a.F.uniseq);
            }
            v vVar = this.f288218a;
            if (vVar != null && (adVar = vVar.K) != null) {
                adVar.onComplete(0);
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
            MessageForShortVideo messageForShortVideo;
            if (QLog.isColorLevel()) {
                QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.f288218a.L + " , uniseq = " + this.f288218a.F.uniseq + "currentDownloadSizeByte = " + j3 + ", totalFileSizeByte = " + j16);
            }
            v vVar = this.f288218a;
            if (vVar.K != null && (messageForShortVideo = vVar.F) != null) {
                long j17 = vVar.N;
                if (j3 > j17) {
                    vVar.N = j3;
                } else {
                    j3 = j17;
                }
                long j18 = messageForShortVideo.videoFileSize;
                if (j18 > 0 && j3 <= j18) {
                    int i18 = (int) (((j3 * 1.0d) / j18) * 100.0d);
                    if (QLog.isColorLevel()) {
                        QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.f288218a.L + ", pogress = " + i18 + " , uniseq = " + this.f288218a.F.uniseq);
                    }
                    this.f288218a.K.onProgress(i18);
                }
            }
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlExpired(int i3, Map<String, String> map) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlUpdate(int i3, String str) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadStatusUpdate(int i3, int i16) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onCommonMessageCallback(int i3, int i16, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadProtocolUpdate(int i3, String str, String str2) {
        }

        @Override // com.tencent.superplayer.api.ISPlayerDownloader.Listener
        public void onDownloadCdnUrlInfoUpdate(int i3, String str, String str2, String str3, String str4) {
        }
    }
}
