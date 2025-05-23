package com.tencent.mobileqq.friends.intimate;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.i;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f211777d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f211778e;

    /* renamed from: f, reason: collision with root package name */
    private IPreDownloadController f211779f;

    /* renamed from: h, reason: collision with root package name */
    private String f211780h;

    /* renamed from: i, reason: collision with root package name */
    private String f211781i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements INetEngineListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements HttpEngineTask.IHttpEngineTask {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask
        public void onPreDownloadStart(HttpEngineTask httpEngineTask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) httpEngineTask);
            } else if (QLog.isColorLevel()) {
                QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", httpEngineTask.httpReq.mReqUrl));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) netResp);
                return;
            }
            String str = ((HttpNetReq) netResp.mReq).mReqUrl;
            if (QLog.isColorLevel()) {
                QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", str, Integer.valueOf(netResp.mResult)));
            }
            int i3 = netResp.mResult;
            if (i3 != 0) {
                if (i3 == 1 && c.this.f211779f != null) {
                    c.this.f211779f.preDownloadSuccess(str, -1L);
                    return;
                }
                return;
            }
            if (c.this.f211779f != null) {
                c.this.f211779f.preDownloadSuccess(str, netResp.mTotalFileLen);
            }
            HttpNetReq httpNetReq = (HttpNetReq) netResp.mReq;
            c cVar = c.this;
            if (cVar.i(httpNetReq.mOutPath, cVar.f211781i)) {
                File file = new File(c.o());
                if (!file.exists()) {
                    file.mkdirs();
                }
                boolean u16 = c.this.u(httpNetReq.mOutPath, c.o());
                boolean s16 = c.this.s();
                if (QLog.isColorLevel()) {
                    QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", Boolean.valueOf(u16), Boolean.valueOf(s16)));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
            }
            c.this.k(httpNetReq.mOutPath);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            } else if (QLog.isColorLevel()) {
                QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", ((HttpNetReq) netReq).mReqUrl, Long.valueOf(j16), Long.valueOf(j3)));
            }
        }
    }

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f211777d = qQAppInterface;
            this.f211778e = qQAppInterface.getEntityManagerFactory().createEntityManager();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(String str, String str2) {
        if (!new File(str).exists()) {
            return false;
        }
        String e16 = o.e(str);
        if (str2 == null || !str2.equalsIgnoreCase(e16)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static String n() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir != null) {
            String str = filesDir.getAbsolutePath() + "/pddata/prd/intimate_res";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
                return str;
            }
            return str;
        }
        return null;
    }

    public static String o() {
        return String.format("%s/res", n());
    }

    private String p(String str) {
        return String.format("%s/%s.zip", n(), str);
    }

    public static boolean q(String[] strArr) {
        for (String str : strArr) {
            if (!new File(str).exists()) {
                QLog.e("IntimateInfoManager", 1, String.format("isFilesExist check fail. filePath=%s", str));
                return false;
            }
        }
        return true;
    }

    private boolean r() {
        if (!TextUtils.isEmpty(this.f211781i)) {
            return i(p(this.f211781i), this.f211781i);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        if (TextUtils.isEmpty(this.f211781i)) {
            return false;
        }
        String o16 = o();
        if (!q(new String[]{o16 + "/boy_add", o16 + "/boy_reduce", o16 + "/couple_add", o16 + "/couple_reduce", o16 + "/girl_add", o16 + "/girl_reduce", o16 + "/bestfriend_add", o16 + "/bestfriend_reduce"})) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(String str, String str2) {
        try {
            i.i(str, str2);
            return true;
        } catch (Exception e16) {
            QLog.e("IntimateInfoManager", 1, "unzipResource fail.", e16);
            return false;
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.f211779f != null && !TextUtils.isEmpty(this.f211780h)) {
            this.f211779f.cancelPreDownload(this.f211780h);
        }
    }

    public void h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IntimateInfoManager", 2, String.format("checkAndDownloadIntimateResources url=%s md5=%s", str, str2));
        }
        this.f211780h = str;
        this.f211781i = str2;
        if (!j()) {
            l();
        }
    }

    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        boolean r16 = r();
        boolean s16 = s();
        if (QLog.isColorLevel()) {
            QLog.d("IntimateInfoManager", 2, String.format("checkResourceReady download=%s unzipped=%s", Boolean.valueOf(r16), Boolean.valueOf(s16)));
        }
        if (r16 && s16) {
            return true;
        }
        return false;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (!TextUtils.isEmpty(this.f211780h) && !TextUtils.isEmpty(this.f211781i)) {
            if (this.f211779f == null) {
                this.f211779f = (IPreDownloadController) this.f211777d.getRuntimeService(IPreDownloadController.class);
            }
            String p16 = p(this.f211781i);
            if (!i(p16, this.f211781i)) {
                k(p16);
                if (this.f211779f != null) {
                    HttpNetReq httpNetReq = new HttpNetReq();
                    httpNetReq.mCallback = new a();
                    httpNetReq.mReqUrl = this.f211780h;
                    httpNetReq.mHttpMethod = 0;
                    httpNetReq.mOutPath = p16;
                    httpNetReq.mPrioty = 0;
                    httpNetReq.mSupportBreakResume = true;
                    this.f211779f.requestPreDownload(10089, PreDownloadConstants.DEPARTMENT_PRD, this.f211781i, 0, this.f211780h, p16, 2, 0, false, new HttpEngineTask(this.f211777d, this.f211781i, new b(), httpNetReq));
                    return;
                }
                return;
            }
            if (!s()) {
                boolean u16 = u(p16, o());
                boolean s16 = s();
                if (QLog.isColorLevel()) {
                    QLog.d("IntimateInfoManager", 2, String.format("downloadResource unzip result=%s unzipped=%s", Boolean.valueOf(u16), Boolean.valueOf(s16)));
                    return;
                }
                return;
            }
            return;
        }
        QLog.e("IntimateInfoManager", 1, "downloadResource invalid parameters.");
    }

    public IntimateInfo m(String str) {
        EntityManager entityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IntimateInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || (entityManager = this.f211778e) == null || !entityManager.isOpen()) {
            return null;
        }
        return (IntimateInfo) DBMethodProxy.find(this.f211778e, (Class<? extends Entity>) IntimateInfo.class, str);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "IntimateInfoManager onDestroy");
        }
        this.f211778e.close();
        g();
    }

    public void t(String str) {
        EntityManager entityManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str) && (entityManager = this.f211778e) != null && entityManager.isOpen()) {
            IntimateInfo intimateInfo = (IntimateInfo) DBMethodProxy.find(this.f211778e, (Class<? extends Entity>) IntimateInfo.class, str);
            if (intimateInfo != null) {
                this.f211778e.remove(intimateInfo);
            }
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "removeIntimateInfo: " + intimateInfo);
            }
        }
    }

    public void v(IntimateInfo intimateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intimateInfo);
            return;
        }
        if (intimateInfo == null) {
            return;
        }
        EntityManager entityManager = this.f211778e;
        if (entityManager != null && entityManager.isOpen()) {
            this.f211778e.update(intimateInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", intimateInfo.friendUin));
        }
    }

    public void w(String str, IntimateInfo intimateInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) intimateInfo);
            return;
        }
        if (!TextUtils.isEmpty(str) && intimateInfo != null) {
            EntityManager entityManager = this.f211778e;
            if (entityManager != null && entityManager.isOpen()) {
                this.f211778e.persistOrReplace(intimateInfo);
            }
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, String.format("updateIntimateInfo, uin: %s", str));
            }
        }
    }
}
