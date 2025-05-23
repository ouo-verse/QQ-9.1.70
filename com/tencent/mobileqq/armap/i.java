package com.tencent.mobileqq.armap;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i implements Manager, INetEngineListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<b> f199747d;

    /* renamed from: e, reason: collision with root package name */
    Set<String> f199748e;

    /* renamed from: f, reason: collision with root package name */
    private IHttpEngineService f199749f;

    /* renamed from: h, reason: collision with root package name */
    AppInterface f199750h;

    /* renamed from: i, reason: collision with root package name */
    h f199751i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f199752a;

        /* renamed from: b, reason: collision with root package name */
        public String f199753b;

        /* renamed from: c, reason: collision with root package name */
        public String f199754c;

        /* renamed from: d, reason: collision with root package name */
        public String f199755d;

        /* renamed from: e, reason: collision with root package name */
        public int f199756e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f199757f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f199758g;

        /* renamed from: h, reason: collision with root package name */
        public Object f199759h;

        /* renamed from: i, reason: collision with root package name */
        public b f199760i;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f199752a = 0;
            this.f199756e = 0;
            this.f199757f = false;
            this.f199758g = true;
            this.f199760i = null;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("|_DownloadParam_start");
            sb5.append("|");
            sb5.append(" type:");
            sb5.append(this.f199752a);
            sb5.append("|");
            sb5.append(" md5:");
            sb5.append(this.f199754c);
            sb5.append("|");
            sb5.append(" endFix:");
            sb5.append(this.f199755d);
            sb5.append("|");
            sb5.append(" retryCount:");
            sb5.append(this.f199756e);
            sb5.append("|");
            sb5.append(" needUnzip:");
            sb5.append(this.f199757f);
            sb5.append("|");
            sb5.append(" needVerify:");
            sb5.append(this.f199758g);
            sb5.append("|");
            sb5.append(" url:");
            sb5.append(this.f199753b);
            if (this.f199759h != null) {
                sb5.append("|");
                sb5.append(" userData:");
                sb5.append(this.f199759h);
            }
            sb5.append("|end");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface b {
        void a(String str, String str2, int i3);

        void b(String str, String str2, int i3, String str3, Object obj);

        void onDownloadStart();
    }

    public i(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f199747d = new Vector();
        this.f199748e = Collections.synchronizedSet(new HashSet());
        this.f199750h = appInterface;
        this.f199749f = (IHttpEngineService) appInterface.getRuntimeService(IHttpEngineService.class, "all");
        this.f199751i = new h();
    }

    private boolean f(a aVar) {
        return this.f199751i.a(this.f199750h, aVar.f199752a).d(aVar);
    }

    private void g(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "retry|" + aVar);
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = aVar.f199753b;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = this.f199751i.a(this.f199750h, aVar.f199752a).e(aVar);
        httpNetReq.mPrioty = 1;
        httpNetReq.setUserData(aVar);
        httpNetReq.mSupportBreakResume = true;
        this.f199749f.sendReq(httpNetReq);
    }

    private String h(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + aVar);
        }
        String b16 = this.f199751i.a(this.f199750h, aVar.f199752a).b(aVar);
        if (!FileUtils.fileExists(b16)) {
            try {
                FileUtils.uncompressZip(this.f199751i.a(this.f199750h, aVar.f199752a).e(aVar), b16, false);
                if (QLog.isColorLevel()) {
                    QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + b16);
                }
            } catch (Exception e16) {
                FileUtils.deleteDirectory(b16);
                QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + aVar + " , " + e16.getMessage(), e16);
            }
        }
        return b16;
    }

    public void a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            if (bVar == null) {
                return;
            }
            synchronized (this.f199747d) {
                if (!this.f199747d.contains(bVar)) {
                    this.f199747d.add(bVar);
                }
            }
        }
    }

    public boolean b(a aVar) {
        String e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar)).booleanValue();
        }
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "download|" + aVar);
        }
        h.b a16 = this.f199751i.a(this.f199750h, aVar.f199752a);
        int i16 = 0;
        if (!TextUtils.isEmpty(aVar.f199754c) && this.f199748e.contains(aVar.f199754c)) {
            if (QLog.isColorLevel()) {
                QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + aVar);
            }
            return false;
        }
        if (!f(aVar)) {
            if (QLog.isColorLevel()) {
                QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + aVar);
            }
            if (aVar.f199757f) {
                String b16 = a16.b(aVar);
                if (FileUtils.fileExists(b16) && !a16.c(aVar, true)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + aVar);
                    }
                    FileUtils.deleteDirectory(b16);
                }
                e16 = h(aVar);
            } else {
                e16 = a16.e(aVar);
            }
            if (new File(e16).exists()) {
                i3 = 0;
            }
            synchronized (this.f199747d) {
                while (i16 < this.f199747d.size()) {
                    b bVar = this.f199747d.get(i16);
                    if (bVar != null) {
                        bVar.b(aVar.f199753b, aVar.f199754c, i3, e16, aVar.f199759h);
                    }
                    i16++;
                }
            }
            b bVar2 = aVar.f199760i;
            if (bVar2 != null) {
                bVar2.b(aVar.f199753b, aVar.f199754c, i3, e16, aVar.f199759h);
            }
            return true;
        }
        this.f199748e.add(aVar.f199754c);
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "download send request ,url = " + aVar.f199753b);
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = this;
        httpNetReq.mReqUrl = aVar.f199753b;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = a16.e(aVar);
        httpNetReq.mPrioty = 1;
        httpNetReq.setUserData(aVar);
        httpNetReq.mSupportBreakResume = true;
        this.f199749f.sendReq(httpNetReq);
        synchronized (this.f199747d) {
            while (i16 < this.f199747d.size()) {
                b bVar3 = this.f199747d.get(i16);
                if (bVar3 != null) {
                    bVar3.onDownloadStart();
                }
                i16++;
            }
        }
        return true;
    }

    public boolean c(String str, String str2, String str3, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3))).booleanValue();
        }
        return d(str, str2, str3, z16, i3, null);
    }

    public boolean d(String str, String str2, String str3, boolean z16, int i3, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), obj)).booleanValue();
        }
        return e(str, str2, str3, z16, i3, obj, null);
    }

    public boolean e(String str, String str2, String str3, boolean z16, int i3, Object obj, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), obj, bVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "download|" + str + "|" + str2);
        }
        a aVar = new a();
        aVar.f199752a = i3;
        aVar.f199753b = str;
        aVar.f199756e = 2;
        if (str3 == null) {
            str3 = "";
        }
        aVar.f199755d = str3;
        aVar.f199757f = z16;
        aVar.f199759h = obj;
        aVar.f199760i = bVar;
        if (TextUtils.isEmpty(str2)) {
            aVar.f199754c = Utils.Crc64String(str);
            aVar.f199758g = false;
        } else {
            aVar.f199754c = str2;
            aVar.f199758g = true;
        }
        return b(aVar);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        a aVar;
        boolean z17;
        boolean z18;
        String str;
        String str2;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
            return;
        }
        if (netResp.mResult == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
        File file = new File(httpNetReq.mOutPath);
        Object userData = httpNetReq.getUserData();
        int i3 = netResp.mErrCode;
        String str3 = netResp.mErrDesc;
        if (str3 == null) {
            str3 = "0";
        }
        if (userData != null && (userData instanceof a)) {
            aVar = (a) userData;
            h.b a16 = this.f199751i.a(this.f199750h, aVar.f199752a);
            str = aVar.f199754c;
            if (z16) {
                if (aVar.f199758g) {
                    if (!a16.a(aVar)) {
                        file.delete();
                        i3 = AppConstants.RichMediaErrorCode.ERR_MD5_NOT_SAME_1;
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + z16 + "|" + aVar);
                    }
                }
                String b16 = a16.b(aVar);
                if (z16 && aVar.f199757f) {
                    FileUtils.deleteDirectory(b16);
                    h(aVar);
                    file = new File(b16);
                    z16 = file.exists();
                    if (!z16) {
                        i3 = 2;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + z16 + "|" + aVar);
                    }
                }
                if (this.f199748e.contains(str)) {
                    this.f199748e.remove(str);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("ResDownloadManager", 2, "onResp result|" + netResp.mResult + "|errCode:3|errDesc:" + str3 + "|params:" + aVar);
                }
                if (file.exists()) {
                    file.delete();
                }
                int i16 = aVar.f199756e;
                if (i16 > 0) {
                    aVar.f199756e = i16 - 1;
                    g(aVar);
                    i3 = 3;
                    z18 = true;
                    z17 = z16;
                } else {
                    if (this.f199748e.contains(str)) {
                        this.f199748e.remove(str);
                    }
                    i3 = 3;
                }
            }
            z18 = false;
            z17 = z16;
        } else {
            file.delete();
            if (QLog.isColorLevel()) {
                QLog.i("ResDownloadManager", 2, "onResp userdata|" + userData);
            }
            aVar = null;
            z17 = z16;
            z18 = false;
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "onResp url:" + httpNetReq.mReqUrl + " result:" + netResp.mResult + " errCode:" + i3 + " md5:" + str);
        }
        if (z18) {
            return;
        }
        synchronized (this.f199747d) {
            for (int i17 = 0; i17 < this.f199747d.size(); i17++) {
                b bVar2 = this.f199747d.get(i17);
                if (bVar2 != null && aVar != null) {
                    bVar2.b(httpNetReq.mReqUrl, str, i3, file.getAbsolutePath(), aVar.f199759h);
                }
            }
        }
        if (aVar != null && (bVar = aVar.f199760i) != null) {
            bVar.b(httpNetReq.mReqUrl, str, i3, file.getAbsolutePath(), aVar.f199759h);
        }
        if (!z17 && aVar != null) {
            QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + aVar + ", errCode=" + i3 + ", errDesc=" + str3 + ", httpCode=" + netResp.mHttpCode);
            HashMap<String, String> hashMap = netResp.mRespProperties;
            if (hashMap != null && hashMap.containsKey(NetResp.KEY_REASON)) {
                str2 = netResp.mRespProperties.get(NetResp.KEY_REASON);
            } else {
                str2 = "0";
            }
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("param_FailCode", String.valueOf(i3));
            hashMap2.put("url", com.tencent.mobileqq.precover.a.b(aVar.f199753b));
            hashMap2.put("md5", aVar.f199754c);
            hashMap2.put("err_desc", str3);
            hashMap2.put("type", aVar.f199752a + "");
            hashMap2.put("endFix", aVar.f199755d);
            hashMap2.put("retryCount", aVar.f199756e + "");
            hashMap2.put("needUnzip", aVar.f199757f + "");
            hashMap2.put("needVerify", aVar.f199758g + "");
            hashMap2.put("httpCode", netResp.mHttpCode + "");
            hashMap2.put(NetResp.KEY_REASON, str2);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f199750h.getCurrentAccountUin(), "armap_download_result", z17, 0L, 0L, hashMap2, "", false);
        }
    }

    @Override // com.tencent.mobileqq.transfile.INetEngineListener
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (netReq != null && (netReq instanceof HttpNetReq)) {
            String str = ((HttpNetReq) netReq).mReqUrl;
            Object userData = netReq.getUserData();
            if (userData != null && (userData instanceof a)) {
                a aVar = (a) userData;
                String str2 = aVar.f199754c;
                if (QLog.isColorLevel()) {
                    QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + j3 + "|totalLen=" + j16 + "|" + aVar);
                }
                if (aVar.f199757f) {
                    i3 = 90;
                } else {
                    i3 = 100;
                }
                if (j16 > 0) {
                    i16 = (int) ((j3 * i3) / j16);
                } else {
                    i16 = 0;
                }
                synchronized (this.f199747d) {
                    for (int i17 = 0; i17 < this.f199747d.size(); i17++) {
                        b bVar = this.f199747d.get(i17);
                        if (bVar != null) {
                            bVar.a(str, str2, i16);
                        }
                    }
                }
                b bVar2 = aVar.f199760i;
                if (bVar2 != null) {
                    bVar2.a(str, str2, i16);
                }
            }
        }
    }
}
