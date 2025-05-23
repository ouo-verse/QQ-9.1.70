package com.tencent.mobileqq.intervideo.now.dynamic.channelImpl;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.service.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqinterface.CommonCallback;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MainService;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NowChannerHandlerV2 extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private Map<Integer, CommonCallback> f238378d;

    /* renamed from: e, reason: collision with root package name */
    private AtomicInteger f238379e;

    public NowChannerHandlerV2(AppInterface appInterface) {
        super(appInterface);
        this.f238378d = new HashMap();
        this.f238379e = new AtomicInteger(0);
    }

    public void E2(String str, String str2, byte[] bArr, CommonCallback<Bundle> commonCallback) {
        if (QLog.isColorLevel()) {
            QLog.w("NowChannerHandler", 2, "send serviceName = " + str + " to SSO Service");
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(MainService.SERVICE_CMD, str2);
        a.g(str2, new String[]{BusinessHandlerFactory.NOW_CHANNEL_HANDLER_V2});
        ToServiceMsg toServiceMsg = new ToServiceMsg(str, getCurrentAccountUin(), str2);
        toServiceMsg.putWupBuffer(bArr);
        toServiceMsg.setAttributes(hashMap);
        toServiceMsg.setTimeout(15000L);
        sendPbReq(toServiceMsg);
        int incrementAndGet = this.f238379e.incrementAndGet();
        toServiceMsg.setRequestSsoSeq(incrementAndGet);
        this.f238378d.put(Integer.valueOf(incrementAndGet), commonCallback);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return g52.a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.e("NowChannerHandler", 2, "onReceive-----serviceName = " + toServiceMsg.getServiceName() + ", serviceCmd = " + toServiceMsg.getServiceCmd());
        }
        D2(toServiceMsg, fromServiceMsg, obj);
    }

    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            CommonCallback commonCallback = this.f238378d.get(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            Bundle bundle = new Bundle();
            bundle.putByteArray("BUFFER", (byte[]) obj);
            bundle.putInt("BIZCODE", 0);
            bundle.putString("ERRMSG", fromServiceMsg.getBusinessFailMsg());
            bundle.putInt("CHANNELCODE", fromServiceMsg.getResultCode() != 1000 ? -1 : 0);
            bundle.putString(MainService.SERVICE_CMD, (String) toServiceMsg.getAttribute(MainService.SERVICE_CMD));
            if (commonCallback != null) {
                commonCallback.onResult(bundle);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NowChannerHandler", 2, "handleLiveFeedNearbyAnchor req == null || res == null");
        }
    }
}
