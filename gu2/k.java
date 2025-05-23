package gu2;

import com.squareup.wire.Message;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.tvideo.net.base.TVideoPbBaseRequest;
import com.tencent.mobileqq.tvideo.net.request.TVideoDynamicAdGetRequest;
import com.tencent.mobileqq.tvideo.net.request.TVideoRewardAdGetRequest;
import com.tencent.mobileqq.tvideo.net.request.TVideoRewardAdUnlockRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tvideo.protocol.pb.DynamicAdProxyRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewPlayRequest;
import com.tencent.tvideo.protocol.pb.RewardAdNewUpdateRequest;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class k extends hv2.i {
    private <R extends Message> TVideoPbBaseRequest c(R r16) {
        if (r16 instanceof RewardAdNewUpdateRequest) {
            return new TVideoRewardAdGetRequest((RewardAdNewUpdateRequest) r16);
        }
        if (r16 instanceof RewardAdNewPlayRequest) {
            return new TVideoRewardAdUnlockRequest((RewardAdNewPlayRequest) r16);
        }
        if (r16 instanceof DynamicAdProxyRequest) {
            return new TVideoDynamicAdGetRequest((DynamicAdProxyRequest) r16);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(pv2.a aVar, Message message, BaseRequest baseRequest, boolean z16, long j3, String str, Message message2) {
        n.e("QAdRequestService", "isSuccess = " + z16 + ", retCode = " + j3);
        if (z16 && j3 == 0) {
            aVar.a(message, message2);
        } else {
            aVar.b(message, message2, (int) j3);
        }
    }

    @Override // hv2.i
    public <R extends Message, T extends Message> int a(final R r16, final pv2.a<R, T> aVar) {
        if (aVar == null) {
            return -1;
        }
        TVideoPbBaseRequest c16 = c(r16);
        if (c16 == null) {
            QLog.e("QAdRequestService", 1, "cmdRequest type is error");
            aVar.b(null, null, -1);
            return -1;
        }
        return VSNetworkHelper.getInstance().sendRequest(c16, new VSDispatchObserver.OnVSRspCallBack() { // from class: gu2.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                k.d(pv2.a.this, r16, baseRequest, z16, j3, str, (Message) obj);
            }
        });
    }
}
