package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes12.dex */
public class HttpThumbDownloader implements IHttpCommunicatorListener {
    private String C;
    private HttpMsg D;
    private a L;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f207427e;

    /* renamed from: h, reason: collision with root package name */
    private String f207429h;

    /* renamed from: i, reason: collision with root package name */
    private String f207430i;

    /* renamed from: m, reason: collision with root package name */
    private String f207431m;

    /* renamed from: d, reason: collision with root package name */
    private final int f207426d = 3;

    /* renamed from: f, reason: collision with root package name */
    private long f207428f = -1;
    private long E = 0;
    private long F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private long J = 0;
    private FileOutputStream K = null;
    private long M = 0;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(String str, int i3);

        void b(String str);

        void c(String str, boolean z16, int i3, String str2, long j3);
    }

    public HttpThumbDownloader(QQAppInterface qQAppInterface) {
        this.f207427e = qQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        if (this.K == null) {
            try {
                this.K = new FileOutputStream(this.C, true);
            } catch (FileNotFoundException e16) {
                QLog.d("ZipThumbDownloader", 1, e16, "runDownload FileNotFoundException");
                d(true);
                a aVar = this.L;
                if (aVar != null) {
                    aVar.c(this.f207429h, false, -2, null, this.f207428f);
                    return;
                }
                return;
            }
        }
        HttpMsg httpMsg = new HttpMsg(this.f207429h, null, this, true);
        if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
            str = "wifi";
        } else {
            str = "gprs";
        }
        httpMsg.setRequestProperty("Net-type", str);
        httpMsg.setRequestProperty("Range", "bytes=0-");
        httpMsg.setPriority(5);
        httpMsg.setDataSlice(true);
        httpMsg.fileType = 0;
        httpMsg.busiType = 0;
        httpMsg.msgId = String.valueOf(this.f207428f);
        httpMsg.setRequestProperty("Accept-Encoding", "identity");
        if (!TextUtils.isEmpty(this.f207430i)) {
            httpMsg.setRequestProperty("Cookie", this.f207430i);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ZipThumbDownloader", 1, "cookie:" + this.f207430i);
        }
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
        this.D = httpMsg;
    }

    private void d(boolean z16) {
        this.F = 0L;
        try {
            FileOutputStream fileOutputStream = this.K;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.K = null;
            }
        } catch (IOException e16) {
            this.K = null;
            QLog.e("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.f207428f + " closeFileStream");
            e16.printStackTrace();
        }
        if (this.D != null) {
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(this.D);
        }
        if (z16) {
            q.d(this.C);
        }
    }

    public void b(long j3, String str, String str2, a aVar) {
        this.f207428f = j3;
        this.f207429h = str2;
        this.f207431m = str;
        this.C = str + ".tmp";
        this.L = aVar;
        QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.f207428f + "] add WaitDowloadTask waiting...");
        this.J = System.currentTimeMillis();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.HttpThumbDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                HttpThumbDownloader.this.c();
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        long j3;
        boolean z16;
        int i3;
        if (httpMsg2 != null) {
            j3 = Long.parseLong(httpMsg2.msgId);
        } else {
            j3 = -1;
        }
        if (j3 != this.f207428f) {
            QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + j3 + " but [currentTaskId] = " + this.f207428f);
            return;
        }
        if (httpMsg2 == null) {
            QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + j3 + "] decode resp = null ");
            d(true);
            a aVar = this.L;
            if (aVar != null) {
                aVar.c(this.f207429h, false, -7, null, this.f207428f);
                return;
            }
            return;
        }
        if (httpMsg2.getResponseCode() == 206 || httpMsg2.getResponseCode() == 200) {
            FileOutputStream fileOutputStream = this.K;
            if (fileOutputStream == null) {
                d(true);
                a aVar2 = this.L;
                if (aVar2 != null) {
                    aVar2.c(this.f207429h, false, -8, null, this.f207428f);
                    return;
                }
                return;
            }
            try {
                fileOutputStream.write(httpMsg2.getRecvData());
                if (0 == this.E) {
                    long totalLen = httpMsg2.getTotalLen();
                    QLog.i("ZipThumbDownloader", 1, "decode : [thumbId] = " + j3 + "]  [thumb Size] = " + String.valueOf(totalLen));
                    this.E = totalLen;
                }
                long length = httpMsg2.getRecvData().length;
                this.M = length;
                this.F += length;
                QLog.d("ZipThumbDownloader", 4, "decode : recv packeg[" + this.M + "],total[" + String.valueOf(this.F) + "] thumb Size[" + String.valueOf(this.E) + "]");
                long j16 = this.F;
                long j17 = this.E;
                if (j16 >= j17) {
                    this.D = null;
                    try {
                        this.K.flush();
                        this.K.getFD().sync();
                        d(false);
                        if (!FileUtils.renameFile(new File(this.C), new File(this.f207431m))) {
                            QLog.e("ZipThumbDownloader", 1, "decode : [downloadThumb] = " + this.f207428f + " renameFile failed");
                            i3 = -9;
                            z16 = false;
                        } else {
                            z16 = true;
                            i3 = 0;
                        }
                        a aVar3 = this.L;
                        if (aVar3 != null) {
                            aVar3.c(this.f207429h, z16, i3, this.f207431m, this.f207428f);
                            return;
                        }
                        return;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        d(true);
                        a aVar4 = this.L;
                        if (aVar4 != null) {
                            aVar4.c(this.f207429h, false, -8, null, this.f207428f);
                            return;
                        }
                        return;
                    }
                }
                int i16 = (int) ((((float) j16) / ((float) j17)) * 10000.0f);
                a aVar5 = this.L;
                if (aVar5 != null) {
                    aVar5.a(this.f207429h, i16);
                }
            } catch (Exception e17) {
                QLog.e("ZipThumbDownloader", 1, e17, "mRevStream.write exception");
                d(true);
                a aVar6 = this.L;
                if (aVar6 != null) {
                    aVar6.c(this.f207429h, false, -8, null, this.f207428f);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        long j3;
        int i3;
        if (httpMsg != null) {
            j3 = Long.parseLong(httpMsg.msgId);
        } else {
            j3 = -1;
        }
        if (j3 != this.f207428f) {
            QLog.e("ZipThumbDownloader", 1, "handleError : [thumbId] = " + j3 + " but [currentTaskId] = " + this.f207428f);
            return;
        }
        if (httpMsg2 == null) {
            QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " response is null");
            d(true);
            a aVar = this.L;
            if (aVar != null) {
                aVar.c(this.f207429h, false, -1, null, this.f207428f);
                return;
            }
            return;
        }
        String errorString = httpMsg2.getErrorString();
        if (errorString == null) {
            errorString = "null";
        }
        int i16 = httpMsg2.errCode;
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " handleError retCode [errCode] = " + i16 + ", [retMsg] = " + errorString);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " net is broken");
            d(true);
            a aVar2 = this.L;
            if (aVar2 != null) {
                aVar2.c(this.f207429h, false, -3, null, this.f207428f);
                return;
            }
            return;
        }
        if (httpMsg == null) {
            QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " request = null. over");
            i3 = -6;
        } else if (!httpMsg2.permitRetry()) {
            QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " response.permitRetry = false. over");
            i3 = -4;
        } else {
            if (this.G < 3) {
                QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " try it. [retryTimes] = " + this.G + " [eofRetry] = " + this.I);
                this.G = this.G + 1;
                if (i16 == 9056 && this.I < 3) {
                    QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " [Error_Exp_Eof retryTimes] = " + this.G + " [eofRetry] = " + this.I);
                    this.G = this.G - 1;
                    this.I = this.I + 1;
                } else {
                    this.I = 0;
                }
                d(true);
                a aVar3 = this.L;
                if (aVar3 != null) {
                    aVar3.b(this.f207429h);
                }
                this.H++;
                c();
                return;
            }
            QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.f207428f + " try it. retryTimes > 3 download over....");
            i3 = -1;
        }
        int i17 = i3;
        d(true);
        a aVar4 = this.L;
        if (aVar4 != null) {
            aVar4.c(this.f207429h, false, i17, null, this.f207428f);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        return true;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
    }
}
