package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.weiyun.channel.HttpChannel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.uploader.UploadRequest;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f315305a;

        /* renamed from: b, reason: collision with root package name */
        public String f315306b;

        /* renamed from: c, reason: collision with root package name */
        public String f315307c;

        /* renamed from: d, reason: collision with root package name */
        public String f315308d;

        /* renamed from: e, reason: collision with root package name */
        public int f315309e;

        /* renamed from: f, reason: collision with root package name */
        public String f315310f;

        /* renamed from: g, reason: collision with root package name */
        public String f315311g;

        /* renamed from: h, reason: collision with root package name */
        public String f315312h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f315313i;

        /* renamed from: j, reason: collision with root package name */
        public long f315314j;

        /* renamed from: k, reason: collision with root package name */
        public String f315315k;

        /* renamed from: l, reason: collision with root package name */
        public String f315316l;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    private static void a(String str, String str2, a aVar, boolean z16, boolean z17) {
        String str3;
        long j3;
        int i3;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", String.valueOf(aVar.f315305a));
        hashMap.put("serverip", aVar.f315307c);
        hashMap.put("param_errMsg", aVar.f315306b);
        hashMap.put(ReportConstant.KEY_ERR_DESC, String.valueOf(aVar.f315306b));
        hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, aVar.f315307c);
        hashMap.put("param_ftnIP", aVar.f315307c);
        hashMap.put("param_innerServerIp", aVar.f315308d);
        hashMap.put("param_serverPort", String.valueOf(aVar.f315309e));
        hashMap.put("param_url", aVar.f315310f);
        hashMap.put("param_MD5", aVar.f315311g);
        if (aVar.f315313i) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        hashMap.put("param_isDowngrade", str3);
        hashMap.put("param_fsizeo", String.valueOf(aVar.f315314j));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, z16, 0L, 0L, hashMap, null);
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("t_server_ip", aVar.f315307c);
            jSONObject.put("t_server_port", aVar.f315309e);
            jSONObject.put("t_url", aVar.f315310f);
            jSONObject.put("t_file_name", aVar.f315312h);
            jSONObject.put("t_file_id", aVar.f315315k);
            jSONObject.put("t_file_path", aVar.f315316l);
            jSONObject.put("t_file_size", aVar.f315314j);
            jSONObject.put("t_file_sha", aVar.f315311g);
            jSONObject.put("t_err_code", aVar.f315305a);
            if (str != null) {
                if (str.startsWith("weiyun_")) {
                    j3 = Long.parseLong(str.substring(7));
                } else {
                    j3 = Long.parseLong(str);
                }
            } else {
                j3 = 0;
            }
            jSONObject.put("t_uin", j3);
            jSONObject.put("t_terminal", "Android_mobileQQ");
            if (z17) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            jSONObject.put("t_action", i3);
            jSONObject.put("t_app_ver", com.tencent.mobileqq.cooperation.a.c(BaseApplication.getContext()));
            if (!z16) {
                jSONObject.put("t_err_msg", aVar.f315306b);
            }
            jSONArray.mo162put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", 1);
            jSONObject2.put("data", jSONArray);
            HttpChannel.f("https://user.weiyun.com/ftn_report/weiyun?op=all", jSONObject2);
        } catch (Exception unused) {
        }
    }

    public static void b(String str, String str2, com.tencent.mobileqq.weiyun.model.c cVar, boolean z16, long j3) {
        try {
            a aVar = new a();
            aVar.f315305a = cVar.f315183e;
            aVar.f315306b = cVar.f315184f;
            com.tencent.mobileqq.weiyun.model.b bVar = cVar.E;
            if (bVar == null) {
                bVar = com.tencent.mobileqq.weiyun.sdk.download.c.u().v(j3);
            }
            if (bVar != null) {
                aVar.f315312h = bVar.g().f315159f;
                aVar.f315314j = bVar.g().f315161i;
                aVar.f315315k = bVar.g().f315158e;
                aVar.f315311g = bVar.g().f315160h;
                aVar.f315316l = cVar.f315187m;
                HttpNetReq j16 = bVar.j();
                if (j16 != null) {
                    aVar.f315310f = j16.mReqUrl;
                }
            }
            a(str, str2, aVar, z16, true);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WyReportUtils", 2, "report download exception =" + e16.getMessage(), e16);
            }
        }
    }

    public static void c(String str, String str2, UploadJobContext.StatusInfo statusInfo, boolean z16, long j3) {
        boolean z17;
        try {
            a aVar = new a();
            aVar.f315305a = statusInfo.errorCode;
            aVar.f315306b = statusInfo.errorMsg;
            UploadJobContext uploadJobContext = statusInfo.jobContext;
            if (uploadJobContext == null) {
                uploadJobContext = UploadManager.getInstance().getJobContext(j3);
            }
            if (uploadJobContext != null) {
                aVar.f315312h = uploadJobContext.file().fileName;
                aVar.f315314j = uploadJobContext.file().fileSize;
                aVar.f315315k = statusInfo.fileId;
                aVar.f315311g = uploadJobContext.file().sha;
                UploadRequest uploadRequest = uploadJobContext.uploadRequest();
                if (uploadRequest != null) {
                    aVar.f315307c = uploadRequest.serverIp();
                    aVar.f315309e = uploadRequest.serverPort();
                    aVar.f315310f = uploadRequest.serverName();
                }
            }
            if (!WeiyunTransmissionGlobal.getInstance().isNativeUpload()) {
                z17 = true;
            } else {
                z17 = false;
            }
            aVar.f315313i = z17;
            a(str, str2, aVar, z16, false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WyReportUtils", 2, "report upload exception =" + e16.getMessage(), e16);
            }
        }
    }
}
