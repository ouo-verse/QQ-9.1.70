package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
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
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ThumbHttpDownloader implements IHttpCommunicatorListener {
    protected static final String C = lc1.b.a().getDefaultThumbPath();

    /* renamed from: m, reason: collision with root package name */
    private static long f207600m;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f207601d;

    /* renamed from: e, reason: collision with root package name */
    private final int f207602e = 3;

    /* renamed from: f, reason: collision with root package name */
    private LinkedHashMap<Long, a> f207603f = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private List<a> f207604h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private List<String> f207605i = new ArrayList();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader$2, reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f207607d;
        final /* synthetic */ ThumbHttpDownloader this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.k(this.f207607d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        String f207609b;

        /* renamed from: c, reason: collision with root package name */
        String f207610c;

        /* renamed from: d, reason: collision with root package name */
        String f207611d;

        /* renamed from: e, reason: collision with root package name */
        String f207612e;

        /* renamed from: f, reason: collision with root package name */
        HttpMsg f207613f;

        /* renamed from: q, reason: collision with root package name */
        h f207624q;

        /* renamed from: r, reason: collision with root package name */
        b f207625r;

        /* renamed from: s, reason: collision with root package name */
        public HttpMsg f207626s;

        /* renamed from: v, reason: collision with root package name */
        String f207629v;

        /* renamed from: a, reason: collision with root package name */
        long f207608a = -1;

        /* renamed from: g, reason: collision with root package name */
        FileOutputStream f207614g = null;

        /* renamed from: h, reason: collision with root package name */
        int[] f207615h = new int[0];

        /* renamed from: i, reason: collision with root package name */
        long f207616i = 0;

        /* renamed from: j, reason: collision with root package name */
        long f207617j = 0;

        /* renamed from: k, reason: collision with root package name */
        int f207618k = -1;

        /* renamed from: l, reason: collision with root package name */
        int f207619l = 0;

        /* renamed from: m, reason: collision with root package name */
        boolean f207620m = true;

        /* renamed from: n, reason: collision with root package name */
        int f207621n = 0;

        /* renamed from: o, reason: collision with root package name */
        int f207622o = 0;

        /* renamed from: p, reason: collision with root package name */
        long f207623p = 0;

        /* renamed from: t, reason: collision with root package name */
        long f207627t = 0;

        /* renamed from: u, reason: collision with root package name */
        boolean f207628u = false;

        /* renamed from: w, reason: collision with root package name */
        short f207630w = 0;

        public String toString() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a(long j3, a aVar);

        boolean b(long j3, a aVar);

        void c(long j3, boolean z16, int i3, String str, a aVar);

        void d(long j3, a aVar);

        void e(long j3, HttpMsg httpMsg);

        void f(long j3, int i3, a aVar);

        List<String> g(long j3, String str, int i3, boolean z16, List<String> list);
    }

    public ThumbHttpDownloader(QQAppInterface qQAppInterface) {
        this.f207601d = qQAppInterface;
    }

    private void b(a aVar) {
        if (aVar == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  addDowloadingTask task = null");
            return;
        }
        synchronized (this.f207603f) {
            this.f207603f.put(Long.valueOf(aVar.f207608a), aVar);
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + aVar.f207608a + "] addDowloadingTask,size:" + this.f207603f.size());
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals("-441") && !str.equals("-443") && !str.equals("-447") && !str.equals("-29224") && !str.equals("-31717")) {
            return false;
        }
        return true;
    }

    private void d() {
        QLog.i("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,mWaitDowloadTask.size(" + String.valueOf(this.f207604h.size()) + ")");
        synchronized (this.f207603f) {
            int size = this.f207603f.size();
            if (size >= 8) {
                QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,but is have" + size + " task downloading, waiting....");
                return;
            }
            synchronized (this.f207604h) {
                if (this.f207604h.size() == 0) {
                    QLog.w("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,no waiting task.");
                    return;
                }
                boolean z16 = false;
                a aVar = this.f207604h.get(0);
                if (aVar == null) {
                    QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  mWaitDowloadTask ,task of 0 location is null. downloadNext");
                    this.f207604h.remove(0);
                    d();
                    return;
                }
                this.f207604h.remove(aVar);
                b(aVar);
                QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + aVar.f207608a + "] downloadNext send cs get url. thumb task,");
                aVar.f207623p = System.currentTimeMillis();
                b bVar = aVar.f207625r;
                if (bVar != null) {
                    z16 = bVar.b(aVar.f207608a, aVar);
                }
                if (!z16) {
                    QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  downloadNext ,geturl failed");
                    j(aVar.f207608a);
                    i(aVar.f207612e);
                    d();
                }
            }
        }
    }

    private a e(long j3) {
        a aVar;
        synchronized (this.f207603f) {
            aVar = this.f207603f.get(Long.valueOf(j3));
        }
        return aVar;
    }

    private void i(String str) {
        synchronized (this.f207605i) {
            this.f207605i.remove(str);
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + f207600m + "], Name[" + str + "] removeDowloadingList,size:" + this.f207603f.size());
        }
    }

    private void j(long j3) {
        synchronized (this.f207603f) {
            this.f207603f.remove(Long.valueOf(j3));
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] removeDowloadingTask,size:" + this.f207603f.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(a aVar) {
        String str;
        String str2;
        if (aVar.f207614g == null) {
            try {
                QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + aVar.f207608a + "] runDownload...tmpname[" + String.valueOf(aVar.f207612e) + "]");
                aVar.f207614g = new FileOutputStream(aVar.f207612e, true);
            } catch (FileNotFoundException unused) {
                m(aVar, true);
                b bVar = aVar.f207625r;
                if (bVar != null) {
                    bVar.c(aVar.f207608a, false, -2, null, aVar);
                }
                j(aVar.f207608a);
                i(aVar.f207612e);
                d();
                return;
            }
        }
        HttpMsg httpMsg = new HttpMsg(aVar.f207609b, null, this, true);
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
        httpMsg.msgId = String.valueOf(aVar.f207608a);
        QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + aVar.f207608a + "] start runDownload... , url[" + aVar.f207609b + "] data RANGE[bytes=0-], peerType[" + String.valueOf(httpMsg.busiType) + "]");
        httpMsg.setRequestProperty("Accept-Encoding", "identity");
        b bVar2 = aVar.f207625r;
        if (bVar2 != null) {
            bVar2.e(aVar.f207608a, httpMsg);
        }
        if (!TextUtils.isEmpty(aVar.f207610c)) {
            httpMsg.setRequestProperty("Cookie", aVar.f207610c);
        }
        String str3 = aVar.f207609b;
        if (str3 != null) {
            str2 = str3.toLowerCase();
        } else {
            str2 = "";
        }
        if (aVar.f207628u && str2.startsWith("https")) {
            httpMsg.mIsHttps = true;
            httpMsg.mIsHostIP = h.c(aVar.f207609b);
            httpMsg.mReqHost = aVar.f207629v;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "cookie:" + aVar.f207610c);
        }
        try {
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendMsg(httpMsg);
            aVar.f207613f = httpMsg;
        } catch (Exception unused2) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "HttpCommunicator send exception fail");
            m(aVar, true);
            b bVar3 = aVar.f207625r;
            if (bVar3 != null) {
                bVar3.c(aVar.f207608a, false, -1, null, aVar);
            }
            j(aVar.f207608a);
            i(aVar.f207612e);
            d();
        }
    }

    private void m(a aVar, boolean z16) {
        if (aVar == null) {
            return;
        }
        aVar.f207617j = 0L;
        try {
            FileOutputStream fileOutputStream = aVar.f207614g;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                aVar.f207614g = null;
                QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + f207600m + "]. closeFileStream:");
            } else {
                QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + f207600m + "]. closeFileStream.had closed: stream = null:");
            }
        } catch (IOException e16) {
            aVar.f207614g = null;
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb][" + f207600m + "]. closeFileStream: exception");
            e16.printStackTrace();
        }
        if (aVar.f207613f != null) {
            try {
                ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(aVar.f207613f);
            } catch (Exception unused) {
                QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "HttpCommunicator cancel send exception");
            }
        }
        if (z16) {
            q.d(aVar.f207612e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        int i3;
        boolean z16;
        long parseLong = Long.parseLong(httpMsg.msgId);
        a e16 = e(parseLong);
        boolean z17 = true;
        if (e16 == null) {
            QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + parseLong + "] decode no this task ");
            return;
        }
        if (httpMsg != e16.f207613f) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + parseLong + "] decode req not match");
            return;
        }
        e16.f207626s = httpMsg2;
        if (httpMsg2 == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + parseLong + "] decode resp = null ");
            m(e16, true);
            b bVar = e16.f207625r;
            if (bVar != null) {
                bVar.c(e16.f207608a, false, -7, null, e16);
            }
            j(e16.f207608a);
            i(e16.f207612e);
            d();
            return;
        }
        synchronized (e16.f207615h) {
            if (httpMsg2.getResponseCode() == 206 || httpMsg2.getResponseCode() == 200) {
                FileOutputStream fileOutputStream = e16.f207614g;
                if (fileOutputStream == null) {
                    m(e16, true);
                    b bVar2 = e16.f207625r;
                    if (bVar2 != null) {
                        bVar2.c(e16.f207608a, false, -8, null, e16);
                    }
                    j(e16.f207608a);
                    i(e16.f207612e);
                    d();
                    return;
                }
                try {
                    fileOutputStream.write(httpMsg2.getRecvData());
                    if (e16.f207616i == 0) {
                        long totalLen = httpMsg2.getTotalLen();
                        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + parseLong + "]  thumb Size[" + String.valueOf(totalLen) + "]");
                        e16.f207616i = totalLen;
                    }
                    long length = httpMsg2.getRecvData().length;
                    e16.f207627t = length;
                    e16.f207617j += length;
                    QLog.d("ThumbHttpDownloader<FileAssistant>", 4, "recv packeg[" + e16.f207627t + "],total[" + String.valueOf(e16.f207617j) + "] thumb Size[" + String.valueOf(e16.f207616i) + "]");
                    long j3 = e16.f207617j;
                    long j16 = e16.f207616i;
                    if (j3 >= j16) {
                        e16.f207613f = null;
                        try {
                            e16.f207614g.flush();
                            e16.f207614g.getFD().sync();
                            m(e16, false);
                            if (!FileUtils.renameFile(new File(e16.f207612e), new File(e16.f207611d))) {
                                QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + parseLong + "] renameFile failed");
                                i3 = -9;
                                z16 = false;
                            } else {
                                i3 = 0;
                                z16 = true;
                            }
                            b bVar3 = e16.f207625r;
                            if (bVar3 != null) {
                                bVar3.c(e16.f207608a, z16, i3, e16.f207611d, e16);
                            }
                            j(e16.f207608a);
                            i(e16.f207612e);
                            if (!z17) {
                                d();
                                return;
                            }
                            return;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            m(e16, true);
                            b bVar4 = e16.f207625r;
                            if (bVar4 != null) {
                                bVar4.c(e16.f207608a, false, -8, null, e16);
                            }
                            j(e16.f207608a);
                            i(e16.f207612e);
                            d();
                            return;
                        }
                    }
                    int i16 = (int) ((((float) j3) / ((float) j16)) * 10000.0f);
                    b bVar5 = e16.f207625r;
                    if (bVar5 != null) {
                        bVar5.f(e16.f207608a, i16, e16);
                    }
                } catch (Exception e18) {
                    e18.printStackTrace();
                    m(e16, true);
                    b bVar6 = e16.f207625r;
                    if (bVar6 != null) {
                        bVar6.c(e16.f207608a, false, -8, null, e16);
                    }
                    j(e16.f207608a);
                    i(e16.f207612e);
                    d();
                    return;
                }
            }
            z17 = false;
            if (!z17) {
            }
        }
    }

    public int f(int i3) {
        if (i3 == 404) {
            QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + f207600m + "] had not found error 404, over....");
            return -11;
        }
        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + f207600m + "] had not nextUrl, over....");
        return -5;
    }

    public void g(long j3, boolean z16, String str, int i3, String str2, String str3, String str4, boolean z17, String str5, short s16, String str6, Bundle bundle) {
        int i16;
        String str7;
        boolean z18;
        ArrayList<String> arrayList;
        boolean z19;
        final a e16 = e(j3);
        if (e16 == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] OnGetThumbInfo no this task");
            d();
            return;
        }
        if (!z16) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + j3 + "] onGetDownloadUrlCome failed");
            j(e16.f207608a);
            i(e16.f207612e);
            d();
            return;
        }
        if (z17) {
            str7 = str4;
            i16 = s16;
        } else {
            i16 = i3;
            str7 = str4;
        }
        e16.f207610c = str7;
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(str + ":" + i16);
        if (bundle != null) {
            boolean z26 = bundle.getBoolean("usemediaplatform", false);
            arrayList = bundle.getStringArrayList("ipv6list");
            z18 = z26;
        } else {
            z18 = false;
            arrayList = null;
        }
        b bVar = e16.f207625r;
        if (bVar != null) {
            List<String> g16 = bVar.g(j3, str6, i16, z18, arrayList);
            if (g16 != null && g16.size() > 0) {
                if (d.b()) {
                    QLog.d("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] debugIsDisableIPv4OnDoubleStack");
                    arrayList2.clear();
                }
                for (int size = g16.size() - 1; size >= 0; size--) {
                    arrayList2.add(0, g16.get(size));
                }
                z19 = false;
                QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] runDownload use IPv6");
            } else {
                z19 = false;
            }
        } else {
            z19 = false;
        }
        QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] runDownload use IPList:" + arrayList2.toString());
        h hVar = new h(this.f207601d, arrayList2, str2);
        e16.f207624q = hVar;
        if (z17) {
            hVar.f(true);
        }
        e16.f207609b = e16.f207624q.a();
        e16.f207628u = z17;
        e16.f207629v = str5;
        e16.f207630w = s16;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.ThumbHttpDownloader.1
            @Override // java.lang.Runnable
            public void run() {
                ThumbHttpDownloader.this.k(e16);
            }
        }, 8, null, z19);
    }

    public long h(String str, b bVar, boolean z16) {
        long j3;
        synchronized (this.f207605i) {
            if (this.f207605i.contains(str)) {
                return -1L;
            }
            this.f207605i.add(str);
            synchronized (this.f207604h) {
                a aVar = new a();
                aVar.f207611d = str;
                aVar.f207612e = str + ".tmp";
                aVar.f207625r = bVar;
                long j16 = f207600m;
                f207600m = 1 + j16;
                aVar.f207608a = j16;
                aVar.f207620m = z16;
                this.f207604h.add(aVar);
                QLog.i("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + aVar.f207608a + "] add WaitDowloadTask waiting...");
                j3 = aVar.f207608a;
            }
            return j3;
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public final void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        long j3;
        String str;
        int f16;
        if (httpMsg != null) {
            j3 = Long.parseLong(httpMsg.msgId);
        } else {
            j3 = -1;
        }
        a e16 = e(j3);
        if (e16 == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "]get mMapDowloadingTask task fail, may be is success taskid[" + String.valueOf(j3) + "]");
            d();
            return;
        }
        if (httpMsg2 == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] response is null");
            m(e16, true);
            b bVar = e16.f207625r;
            if (bVar != null) {
                bVar.c(e16.f207608a, false, -1, null, e16);
            }
            j(e16.f207608a);
            i(e16.f207612e);
            d();
            return;
        }
        String errorString = httpMsg2.getErrorString();
        if (errorString == null) {
            errorString = "null";
        }
        e16.f207626s = httpMsg2;
        int i3 = httpMsg2.errCode;
        QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + j3 + "] handleError retCode[" + i3 + "], retMsg[" + errorString + "]");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] net is broken");
            m(e16, true);
            b bVar2 = e16.f207625r;
            if (bVar2 != null) {
                bVar2.c(e16.f207608a, false, -3, null, e16);
            }
            j(e16.f207608a);
            i(e16.f207612e);
            d();
            return;
        }
        if (httpMsg == null) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] request = null. over");
            f16 = -6;
        } else if (!httpMsg2.permitRetry()) {
            QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] response.permitRetry = false. over");
            f16 = -4;
        } else {
            HttpURLConnection httpURLConnection = httpMsg2.mConn;
            if (httpURLConnection != null && c(httpURLConnection.getHeaderField(HttpMsg.USERRETURNCODE))) {
                QLog.e("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] file over size and server can not create thumb. over");
                f16 = -10;
            } else {
                if (e16.f207619l < 3 && e16.f207620m) {
                    QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] try it. retryTimes:" + e16.f207619l + " eofRetry:" + e16.f207622o);
                    e16.f207619l = e16.f207619l + 1;
                    if (i3 == 9056 && e16.f207622o < 3) {
                        QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] .Error_Exp_Eof retryTimes:" + e16.f207619l + " eofRetry:" + e16.f207622o);
                        e16.f207619l = e16.f207619l - 1;
                        e16.f207622o = e16.f207622o + 1;
                    } else {
                        e16.f207622o = 0;
                    }
                    m(e16, true);
                    b bVar3 = e16.f207625r;
                    if (bVar3 != null) {
                        bVar3.d(e16.f207608a, e16);
                    }
                    e16.f207621n++;
                    k(e16);
                    return;
                }
                QLog.w("ThumbHttpDownloader<FileAssistant>", 1, "[downloadThumb] ID[" + j3 + "] try it. retryTimes > 3 getNextUrl....");
                h hVar = e16.f207624q;
                if (hVar != null) {
                    str = hVar.a();
                } else {
                    str = null;
                }
                if (str != null) {
                    e16.f207619l = 0;
                    e16.f207622o = 0;
                    e16.f207609b = str;
                    m(e16, true);
                    ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).cancelMsg(e16.f207613f);
                    b bVar4 = e16.f207625r;
                    if (bVar4 != null) {
                        bVar4.a(e16.f207608a, e16);
                    }
                    e16.f207621n++;
                    k(e16);
                    return;
                }
                f16 = f(httpMsg.getResponseCode());
            }
        }
        int i16 = f16;
        m(e16, true);
        b bVar5 = e16.f207625r;
        if (bVar5 != null) {
            bVar5.c(e16.f207608a, false, i16, null, e16);
        }
        j(e16.f207608a);
        i(e16.f207612e);
        d();
    }

    public void l() {
        d();
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public final boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        return true;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
    }
}
