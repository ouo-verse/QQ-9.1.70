package com.tencent.mobileqq.ark.util;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class h {
    static HttpNetReq a(String str, byte[] bArr, Map<String, String> map, String str2) {
        int i3;
        HttpNetReq httpNetReq = new HttpNetReq();
        if (bArr != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        httpNetReq.mHttpMethod = i3;
        httpNetReq.mReqUrl = str;
        if (str2 != null) {
            httpNetReq.mOutPath = str2;
        } else {
            httpNetReq.mOutStream = new ByteArrayOutputStream();
        }
        httpNetReq.mPrioty = 0;
        if (map != null) {
            httpNetReq.mReqProperties.putAll(map);
        }
        return httpNetReq;
    }

    public static void b(AppRuntime appRuntime, String str, Map<String, String> map, String str2, g91.a aVar) {
        f(appRuntime, str, null, map, str2, aVar);
    }

    public static void c(AppRuntime appRuntime, String str, Map<String, String> map, g91.a aVar) {
        f(appRuntime, str, null, map, null, aVar);
    }

    public static void d(AppRuntime appRuntime, String str, byte[] bArr, Map<String, String> map, g91.a aVar) {
        f(appRuntime, str, bArr, map, null, aVar);
    }

    static byte[] e(NetResp netResp, HttpNetReq httpNetReq) {
        byte[] bArr = null;
        if (netResp.mErrCode == 0) {
            OutputStream outputStream = httpNetReq.mOutStream;
            if (outputStream != null) {
                bArr = ((ByteArrayOutputStream) outputStream).toByteArray();
            } else {
                String str = httpNetReq.mOutPath;
                if (str != null) {
                    bArr = FileUtils.readFile(str);
                }
            }
            if (bArr == null) {
                QLog.i("ArkApp.NetUtil", 1, "read file fail, path is " + httpNetReq.mOutPath);
                netResp.mErrCode = 1;
            }
        }
        return bArr;
    }

    public static void f(AppRuntime appRuntime, String str, byte[] bArr, Map<String, String> map, String str2, g91.a aVar) {
        HttpNetReq a16 = a(str, bArr, map, str2);
        a16.mCallback = new a(aVar, a16);
        g(appRuntime, aVar, a16);
    }

    static void g(AppRuntime appRuntime, g91.a aVar, HttpNetReq httpNetReq) {
        try {
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            QLog.i("ArkApp.NetUtil", 1, "failed to get http engine service, " + e16);
            if (aVar != null) {
                aVar.a(1, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g91.a f199655d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HttpNetReq f199656e;

        a(g91.a aVar, HttpNetReq httpNetReq) {
            this.f199655d = aVar;
            this.f199656e = httpNetReq;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            this.f199655d.a(netResp.mErrCode, h.e(netResp, this.f199656e));
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
