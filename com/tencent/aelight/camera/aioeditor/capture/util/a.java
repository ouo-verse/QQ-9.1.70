package com.tencent.aelight.camera.aioeditor.capture.util;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(String str);
    }

    public c a(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str4 = "";
            if (!jSONObject.has("pendantMD5")) {
                str2 = "";
            } else {
                str2 = jSONObject.getString("pendantMD5");
            }
            if (!jSONObject.has("pendantUrl")) {
                str3 = "";
            } else {
                str3 = jSONObject.getString("pendantUrl");
            }
            if (jSONObject.has("pendantName")) {
                str4 = jSONObject.getString("pendantName");
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return new c(str4, str3, str2);
            }
            if (QLog.isColorLevel()) {
                QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public c b(String str, String str2, String str3, b bVar) {
        c a16 = a(str);
        if (a16 == null) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + a16.f67186c + " url=" + a16.f67185b + " name=" + a16.f67184a);
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            String str4 = File.separator;
            sb5.append(str4);
            String sb6 = sb5.toString();
            String str5 = str2 + str4 + a16.f67184a;
            File file = new File(str2, str3);
            if (file.exists()) {
                file.delete();
                if (QLog.isColorLevel()) {
                    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
                }
            }
            File file2 = new File(str5);
            if (file2.exists()) {
                file2.delete();
                if (QLog.isColorLevel()) {
                    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
                }
            }
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new C0581a(str2, str3, a16, sb6, str5, bVar);
            httpNetReq.mReqUrl = a16.f67185b;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = file.getPath();
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            try {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (QQAppInterface.class.isInstance(runtime)) {
                    ((IHttpEngineService) ((QQAppInterface) runtime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    if (QLog.isColorLevel()) {
                        QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + a16.f67185b);
                    }
                } else if (fr.b.a() != null) {
                    ((IHttpEngineService) fr.b.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                }
            } catch (Exception unused) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
        }
        return a16;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        String f67184a;

        /* renamed from: b, reason: collision with root package name */
        String f67185b;

        /* renamed from: c, reason: collision with root package name */
        String f67186c;

        public c() {
            this.f67184a = "";
            this.f67185b = "";
            this.f67186c = "";
        }

        public c(String str, String str2, String str3) {
            this.f67184a = str;
            this.f67185b = str2;
            this.f67186c = str3;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class C0581a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f67178d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f67179e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f67180f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f67181h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f67182i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ b f67183m;

        C0581a(String str, String str2, c cVar, String str3, String str4, b bVar) {
            this.f67178d = str;
            this.f67179e = str2;
            this.f67180f = cVar;
            this.f67181h = str3;
            this.f67182i = str4;
            this.f67183m = bVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            String str;
            if (QLog.isColorLevel()) {
                QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + netResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
            }
            File file = new File(this.f67178d, this.f67179e);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
                    return;
                }
                return;
            }
            try {
                str = FileUtils.calcMd5(file.getPath());
            } catch (UnsatisfiedLinkError e16) {
                QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", e16);
                str = "";
            }
            if (!TextUtils.isEmpty(this.f67180f.f67186c) && this.f67180f.f67186c.equalsIgnoreCase(str)) {
                try {
                    ZipUtils.unZipFile(file, this.f67181h);
                } catch (IOException e17) {
                    QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", e17);
                }
            } else if (QLog.isColorLevel()) {
                QLog.e("ConfigSimplifier_PTV", 2, "parseFilterConfigZip error, md5:", this.f67180f.f67186c, " ", str);
            }
            File file2 = new File(this.f67182i);
            if (file2.exists()) {
                String z16 = QIMPtvTemplateManager.z(file2);
                b bVar = this.f67183m;
                if (bVar == null || z16 == null) {
                    return;
                }
                bVar.a(z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
