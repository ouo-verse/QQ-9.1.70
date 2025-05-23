package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<e> f198094a;

    /* renamed from: c, reason: collision with root package name */
    public QQAppInterface f198096c;

    /* renamed from: d, reason: collision with root package name */
    private IHttpEngineService f198097d;

    /* renamed from: e, reason: collision with root package name */
    private IPreDownloadController f198098e;

    /* renamed from: b, reason: collision with root package name */
    private Object f198095b = new Object();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, d> f198099f = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements HttpEngineTask.IHttpEngineTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f198100d;

        a(e eVar) {
            this.f198100d = eVar;
        }

        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
        public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            d dVar;
            boolean z16 = true;
            if (netResp.mResult != 3) {
                synchronized (ae.this.f198095b) {
                    if (ae.this.f198094a != null) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= ae.this.f198094a.size()) {
                                break;
                            }
                            if (((e) ae.this.f198094a.get(i3)).f198107b.equals(this.f198100d.f198107b)) {
                                ae.this.f198094a.remove(i3);
                                break;
                            }
                            i3++;
                        }
                    }
                }
                synchronized (ae.this.f198099f) {
                    dVar = (d) ae.this.f198099f.get(this.f198100d.f198108c);
                }
                if (netResp.mResult == 0) {
                    if (ae.this.f198098e != null) {
                        IPreDownloadController iPreDownloadController = ae.this.f198098e;
                        e eVar = this.f198100d;
                        iPreDownloadController.preDownloadSuccess(eVar.f198107b, eVar.f198113h);
                    }
                    File file = new File(((HttpNetReq) netResp.mReq).mOutPath);
                    String e16 = com.tencent.mobileqq.portal.o.e(file.getAbsolutePath());
                    if ((TextUtils.isEmpty(e16) || !e16.equalsIgnoreCase(this.f198100d.f198108c)) && this.f198100d.f198106a != 1) {
                        QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((HttpNetReq) netResp.mReq).mReqUrl + ", fileName = " + file.getAbsolutePath() + ", fileMD5 = " + e16);
                        if (dVar != null) {
                            dVar.c(false, this.f198100d);
                            return;
                        }
                        return;
                    }
                } else {
                    if (ae.this.f198098e != null) {
                        ae.this.f198098e.preDownloadSuccess(this.f198100d.f198107b, -1L);
                    }
                    z16 = false;
                }
                if (dVar != null) {
                    dVar.c(z16, this.f198100d);
                    return;
                }
                return;
            }
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((HttpNetReq) netResp.mReq).mReqUrl);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            d dVar;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((HttpNetReq) netReq).mReqUrl + ", total size = " + j16 + ", cur downloaded size = " + j3);
            }
            synchronized (ae.this.f198099f) {
                dVar = (d) ae.this.f198099f.get(this.f198100d.f198108c);
            }
            if (dVar != null) {
                dVar.a(j3, j16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c extends HttpEngineTask {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f198103d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f198104e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(BaseQQAppInterface baseQQAppInterface, String str, HttpEngineTask.IHttpEngineTask iHttpEngineTask, HttpNetReq httpNetReq, e eVar, d dVar) {
            super(baseQQAppInterface, str, iHttpEngineTask, httpNetReq);
            this.f198103d = eVar;
            this.f198104e = dVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask, com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        public void realCancel() {
            d dVar;
            QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
            synchronized (ae.this.f198099f) {
                dVar = (d) ae.this.f198099f.get(this.f198103d.f198108c);
            }
            if (dVar != null) {
                dVar.d();
            }
            super.realCancel();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask, com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask
        public void realStart() {
            d dVar;
            QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
            synchronized (ae.this.f198099f) {
                dVar = (d) ae.this.f198099f.get(this.f198103d.f198108c);
            }
            if (dVar != null) {
                this.f198104e.b();
            }
            super.realStart();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface d {
        void a(long j3, long j16);

        void b();

        void c(boolean z16, @Nullable e eVar);

        void d();
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f198106a;

        /* renamed from: e, reason: collision with root package name */
        public String f198110e;

        /* renamed from: h, reason: collision with root package name */
        public long f198113h;

        /* renamed from: b, reason: collision with root package name */
        public String f198107b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f198108c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f198109d = "";

        /* renamed from: f, reason: collision with root package name */
        public boolean f198111f = false;

        /* renamed from: g, reason: collision with root package name */
        public HttpNetReq f198112g = null;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("DownloadInfo{");
            stringBuffer.append("type=");
            stringBuffer.append(this.f198106a);
            stringBuffer.append(", url='");
            stringBuffer.append(this.f198107b);
            stringBuffer.append('\'');
            stringBuffer.append(", md5='");
            stringBuffer.append(this.f198108c);
            stringBuffer.append('\'');
            stringBuffer.append(", fileName='");
            stringBuffer.append(this.f198109d);
            stringBuffer.append('\'');
            stringBuffer.append('}');
            return stringBuffer.toString();
        }
    }

    public ae(QQAppInterface qQAppInterface) {
        this.f198094a = null;
        this.f198097d = null;
        this.f198096c = qQAppInterface;
        this.f198097d = (IHttpEngineService) qQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
        this.f198094a = new ArrayList<>();
        this.f198098e = (IPreDownloadController) this.f198096c.getRuntimeService(IPreDownloadController.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r1 != 4) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(e eVar, d dVar) {
        int i3;
        if (eVar == null || dVar == null) {
            return false;
        }
        a aVar = new a(eVar);
        b bVar = new b();
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = bVar;
        httpNetReq.mReqUrl = eVar.f198107b;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = eVar.f198109d;
        httpNetReq.mPrioty = 1;
        httpNetReq.mSupportBreakResume = true;
        eVar.f198112g = httpNetReq;
        synchronized (this.f198095b) {
            this.f198094a.add(eVar);
        }
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork != 1) {
            int i16 = 2;
            if (systemNetwork != 2) {
                i16 = 3;
                if (systemNetwork != 3) {
                    i16 = 4;
                }
            }
            i3 = i16;
            this.f198098e.requestPreDownload(10065, PreDownloadConstants.DEPARTMENT_PRD, eVar.f198108c, 0, eVar.f198107b, httpNetReq.mOutPath, i3, 0, false, new c(this.f198096c, eVar.f198108c, aVar, httpNetReq, eVar, dVar));
            this.f198099f.put(eVar.f198108c, dVar);
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + eVar.f198107b);
            return true;
        }
        i3 = 1;
        this.f198098e.requestPreDownload(10065, PreDownloadConstants.DEPARTMENT_PRD, eVar.f198108c, 0, eVar.f198107b, httpNetReq.mOutPath, i3, 0, false, new c(this.f198096c, eVar.f198108c, aVar, httpNetReq, eVar, dVar));
        this.f198099f.put(eVar.f198108c, dVar);
        QLog.i("AREngine_ARPreSoResourceDownload", 1, "submitDownloadTask. url = " + eVar.f198107b);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class b implements INetEngineListener {
        b() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
