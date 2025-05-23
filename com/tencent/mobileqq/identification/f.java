package com.tencent.mobileqq.identification;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, ArrayList<b>> f237946a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f237947b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f237948c;

    /* renamed from: d, reason: collision with root package name */
    private IHttpEngineService f237949d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements INetEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f237950d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f237951e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f237952f;

        a(String str, String str2, String str3) {
            this.f237950d = str;
            this.f237951e = str2;
            this.f237952f = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, f.this, str, str2, str3);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            QLog.i("HuiYanResDownloader", 1, "download resp, result=" + netResp.mResult + ", errCode=" + netResp.mErrCode + ", httpCode=" + netResp.mHttpCode + ", errDesc=" + netResp.mErrDesc);
            if (netResp.mResult != 0) {
                f.this.d(this.f237950d, false, null);
                return;
            }
            if (f.b(this.f237951e, this.f237952f)) {
                f.this.d(this.f237950d, true, this.f237951e);
                return;
            }
            QLog.w("HuiYanResDownloader", 1, "check md5 fail url=" + this.f237950d + ", md5=" + this.f237952f);
            f.this.d(this.f237950d, false, null);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
        void a();

        void onDownloadSuccess(String str);
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f237946a = new HashMap();
        this.f237947b = new HashMap();
        this.f237948c = new Object();
        this.f237949d = null;
    }

    public static boolean b(String str, String str2) {
        String str3 = null;
        try {
            byte[] fileMd5 = MD5.getFileMd5(str);
            if (fileMd5 != null) {
                str3 = HexUtil.bytes2HexStr(fileMd5);
            }
        } catch (Throwable th5) {
            QLog.e("HuiYanResDownloader", 1, "MD5.getFileMd5 exception ", th5);
            try {
                str3 = com.tencent.qqprotect.singleupdate.a.d(new File(str));
            } catch (Exception e16) {
                QLog.e("HuiYanResDownloader", 1, "MD5FileUtil.getFileMD5String exception ", e16);
            }
        }
        if (str3 != null && str3.equalsIgnoreCase(str2)) {
            return true;
        }
        return false;
    }

    public static String c() {
        File file = new File(j.l(), "download_" + System.currentTimeMillis() + "_" + new Random().nextInt(10));
        if (file.exists()) {
            file.delete();
        }
        return file.getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, boolean z16, String str2) {
        ArrayList arrayList;
        synchronized (this.f237948c) {
            this.f237947b.remove(str);
            ArrayList<b> arrayList2 = this.f237946a.get(str);
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = null;
            }
            this.f237946a.remove(str);
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (z16) {
                bVar.onDownloadSuccess(str2);
            } else {
                bVar.a();
            }
        }
    }

    private boolean e(NetReq netReq) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("HuiYanResDownloader", 1, "sendReq fail, appRuntime is null");
            return false;
        }
        if (peekAppRuntime.isLogin() && !TextUtils.isEmpty(peekAppRuntime.getCurrentAccountUin())) {
            try {
                ((IHttpEngineService) peekAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(netReq);
                return true;
            } catch (Exception e16) {
                QLog.e("HuiYanResDownloader", 1, "sendReq fail ", e16);
            }
        }
        ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(netReq);
        QLog.i("HuiYanResDownloader", 1, "sendReq by HttpEngineServiceImpl, is not login now");
        return true;
    }

    public void f(String str, String str2, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, bVar);
            return;
        }
        QLog.i("HuiYanResDownloader", 1, "start download url=" + str + ", md5=" + str2);
        synchronized (this.f237948c) {
            ArrayList<b> arrayList = this.f237946a.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f237946a.put(str, arrayList);
            }
            if (bVar != null) {
                arrayList.add(bVar);
            }
            Boolean bool = this.f237947b.get(str);
            if (bool != null && bool.booleanValue()) {
                QLog.i("HuiYanResDownloader", 1, "is downloading now");
                return;
            }
            this.f237947b.put(str, Boolean.TRUE);
            String c16 = c();
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mReqUrl = str;
            httpNetReq.mOutPath = c16;
            httpNetReq.mCallback = new a(str, c16, str2);
            if (!e(httpNetReq)) {
                d(str, false, null);
            }
        }
    }
}
