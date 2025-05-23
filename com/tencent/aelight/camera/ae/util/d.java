package com.tencent.aelight.camera.ae.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(NetResp netResp);

        void onProgressUpdate(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private String f65758d;

        /* renamed from: e, reason: collision with root package name */
        private String f65759e;

        /* renamed from: f, reason: collision with root package name */
        private a f65760f;

        b(String str, String str2, a aVar) {
            this.f65758d = str;
            this.f65759e = str2;
            this.f65760f = aVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            ms.a.f("AEDownloader", "onResp url: " + this.f65758d + " resultcode: " + netResp.mResult);
            a aVar = this.f65760f;
            if (aVar != null) {
                aVar.a(netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            a aVar = this.f65760f;
            if (aVar != null) {
                aVar.onProgressUpdate((int) ((((float) j3) / ((float) j16)) * 100.0f));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static d f65761a = new d();
    }

    public static d b() {
        return c.f65761a;
    }

    private static void c(String str, String str2, a aVar) {
        ms.a.f("AEDownloader", "realDownload---url=" + str + ", saveName=" + str2);
        AppInterface a16 = com.tencent.aelight.camera.aebase.a.a();
        if (a16 == null) {
            if (aVar != null) {
                aVar.a(null);
            }
            ms.a.c("AEDownloader", "realDownload---FAIL appInterface is null");
            return;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new b(str, str2, aVar);
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = new File(str2).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) a16.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            ms.a.d("AEDownloader", "realDownload---exception: ", e16);
            if (aVar != null) {
                aVar.a(null);
            }
        }
    }

    public void a(String str, String str2, a aVar) {
        c(str, str2, aVar);
    }
}
