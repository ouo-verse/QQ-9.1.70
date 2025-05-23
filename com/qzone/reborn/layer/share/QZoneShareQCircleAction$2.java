package com.qzone.reborn.layer.share;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.wink.listener.INetEngineListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes37.dex */
class QZoneShareQCircleAction$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f58143d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f58144e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ INetEngineListener f58145f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f58146h;
    final /* synthetic */ s this$0;

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f58143d);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = this.f58143d + this.f58144e;
        if (!new File(str).exists()) {
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new a();
            httpNetReq.mReqUrl = this.f58146h;
            QLog.d("QZoneShareQCircleAction", 1, "req.mReqUrl = " + httpNetReq.mReqUrl);
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = str;
            QLog.d("QZoneShareQCircleAction", 1, "req.mOutPath = " + httpNetReq.mOutPath);
            httpNetReq.mContinuErrorLimit = 2;
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
            return;
        }
        this.f58145f.getFilePath(str);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements com.tencent.mobileqq.transfile.INetEngineListener {
        a() {
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            NetReq netReq;
            QLog.d("QZoneShareQCircleAction", 1, "netResp.mResult isSuccess = " + (netResp != null && netResp.mResult == 0));
            if (netResp != null && netResp.mResult == 0 && (netReq = netResp.mReq) != null && !TextUtils.isEmpty(netReq.mOutPath)) {
                QZoneShareQCircleAction$2.this.f58145f.getFilePath(netResp.mReq.mOutPath);
            } else {
                QZoneShareQCircleAction$2.this.f58145f.getFilePath("");
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
