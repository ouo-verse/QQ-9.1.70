package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ag {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<c> f198114a;

    /* renamed from: b, reason: collision with root package name */
    private Object f198115b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public AppInterface f198116c;

    /* renamed from: d, reason: collision with root package name */
    private IHttpEngineService f198117d;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f198118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f198119e;

        a(c cVar, b bVar) {
            this.f198118d = cVar;
            this.f198119e = bVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16 = true;
            if (netResp.mResult != 3) {
                synchronized (ag.this.f198115b) {
                    if (ag.this.f198114a != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ag.this.f198114a.size()) {
                                break;
                            }
                            if (((c) ag.this.f198114a.get(i3)).f198122b.equals(this.f198118d.f198122b)) {
                                ag.this.f198114a.remove(i3);
                                break;
                            }
                            i3++;
                        }
                    }
                }
                if (netResp.mResult == 0) {
                    File file = new File(((HttpNetReq) netResp.mReq).mOutPath);
                    String e16 = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                    if ((TextUtils.isEmpty(e16) || !e16.equalsIgnoreCase(this.f198118d.f198123c)) && this.f198118d.f198121a != 1) {
                        QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq) netResp.mReq).mReqUrl + ", fileName = " + file.getAbsolutePath() + ", fileMD5 = " + e16);
                        this.f198119e.b(false, this.f198118d);
                        return;
                    }
                } else {
                    z16 = false;
                }
                this.f198119e.b(z16, this.f198118d);
                return;
            }
            QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((HttpNetReq) netResp.mReq).mReqUrl);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq) netReq).mReqUrl + ", total size = " + j16 + ", cur downloaded size = " + j3);
            }
            this.f198119e.a(j3, j16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(long j3, long j16);

        void b(boolean z16, c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f198121a;

        /* renamed from: b, reason: collision with root package name */
        public String f198122b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f198123c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f198124d = "";

        /* renamed from: e, reason: collision with root package name */
        public boolean f198125e = false;

        /* renamed from: f, reason: collision with root package name */
        public HttpNetReq f198126f = null;

        /* renamed from: g, reason: collision with root package name */
        public long f198127g;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("DownloadInfo{");
            stringBuffer.append("type=");
            stringBuffer.append(this.f198121a);
            stringBuffer.append(", url='");
            stringBuffer.append(this.f198122b);
            stringBuffer.append('\'');
            stringBuffer.append(", md5='");
            stringBuffer.append(this.f198123c);
            stringBuffer.append('\'');
            stringBuffer.append(", fileName='");
            stringBuffer.append(this.f198124d);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public ag(AppInterface appInterface) {
        this.f198114a = null;
        this.f198117d = null;
        this.f198116c = appInterface;
        this.f198117d = (IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all");
        this.f198114a = new ArrayList<>();
    }

    public void c() {
        synchronized (this.f198115b) {
            for (int i3 = 0; i3 < this.f198114a.size(); i3++) {
                QLog.i("AREngine_ARResourceDownload", 1, "cancelDownloadTask. url = " + this.f198114a.get(i3).f198122b);
                this.f198117d.cancelReq(this.f198114a.get(i3).f198126f);
            }
            this.f198114a.clear();
        }
    }

    public boolean d(c cVar, b bVar) {
        if (cVar == null || bVar == null) {
            return false;
        }
        a aVar = new a(cVar, bVar);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = aVar;
        httpNetReq.mReqUrl = cVar.f198122b;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = cVar.f198124d;
        httpNetReq.mPrioty = 1;
        httpNetReq.mSupportBreakResume = true;
        this.f198117d.sendReq(httpNetReq);
        cVar.f198126f = httpNetReq;
        synchronized (this.f198115b) {
            this.f198114a.add(cVar);
        }
        QLog.i("AREngine_ARResourceDownload", 1, "submitDownloadTask. url = " + cVar.f198122b);
        return true;
    }

    public void e() {
        c();
    }
}
