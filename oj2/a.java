package oj2;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* compiled from: P */
    /* renamed from: oj2.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC10920a {
        void a(@Nullable NetResp netResp);

        void onProgressUpdate(@IntRange(from = 0, to = 100) int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        private String f423021d;

        /* renamed from: e, reason: collision with root package name */
        private String f423022e;

        /* renamed from: f, reason: collision with root package name */
        private InterfaceC10920a f423023f;

        b(String str, String str2, InterfaceC10920a interfaceC10920a) {
            this.f423021d = str;
            this.f423022e = str2;
            this.f423023f = interfaceC10920a;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            mj2.a.d("AEDownloader", "onResp url: " + this.f423021d + " resultcode: " + netResp.mResult);
            InterfaceC10920a interfaceC10920a = this.f423023f;
            if (interfaceC10920a != null) {
                interfaceC10920a.a(netResp);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            InterfaceC10920a interfaceC10920a = this.f423023f;
            if (interfaceC10920a != null) {
                interfaceC10920a.onProgressUpdate((int) ((((float) j3) / ((float) j16)) * 100.0f));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static a f423024a = new a();
    }

    public static a b() {
        return c.f423024a;
    }

    @WorkerThread
    private static void c(String str, String str2, InterfaceC10920a interfaceC10920a) {
        mj2.a.d("AEDownloader", "realDownload---url=" + str + ", saveName=" + str2);
        if (com.tencent.mobileqq.qqvideoedit.a.b() == null) {
            if (interfaceC10920a != null) {
                interfaceC10920a.a(null);
            }
            mj2.a.b("AEDownloader", "realDownload---FAIL appInterface is null");
            return;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = new b(str, str2, interfaceC10920a);
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = new File(str2).getPath();
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 60000L;
        try {
            ((IHttpEngineService) com.tencent.mobileqq.qqvideoedit.a.b().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            e16.printStackTrace();
            mj2.a.c("AEDownloader", "realDownload---exception: ", e16);
            if (interfaceC10920a != null) {
                interfaceC10920a.a(null);
            }
        }
    }

    public void a(String str, String str2, InterfaceC10920a interfaceC10920a) {
        c(str, str2, interfaceC10920a);
    }
}
