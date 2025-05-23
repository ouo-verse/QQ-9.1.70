package com.tencent.mobileqq.qqecommerce.base.msf;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECSendPackageCallback;
import com.tencent.ecommerce.base.network.api.IECSender;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c implements IECSender {
    private ECRemoteResponse c(int i3, JSONObject jSONObject, PROTOCAL.StQWebRsp stQWebRsp) {
        int optInt = jSONObject.optInt("channel_code", -1);
        String optString = jSONObject.optString("channel_msg", "");
        if (stQWebRsp == null) {
            QLog.e("ECNetworkManager", 1, "[combineRemoteResponse] response is null, seq= " + i3);
            return new ECRemoteResponse(i3, optInt == 0 ? -1 : optInt, "ForwardRsp is null", null, optInt, optString, "");
        }
        QLog.i("ECNetworkManager", 1, "[combineRemoteResponse] requestSeq = " + i3 + ", retcode = " + optInt + ", msg = " + optString + ", ssoResult = " + jSONObject);
        return new ECRemoteResponse(i3, (int) stQWebRsp.retCode.get(), stQWebRsp.errMsg.get().toString(), stQWebRsp.busiBuff.get().toByteArray(), optInt, optString, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(IECSendPackageCallback iECSendPackageCallback, boolean z16, int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
        ECRemoteResponse d16 = d(i3, jSONObject, bVar);
        if (iECSendPackageCallback == null) {
            QLog.e("ECNetworkManager", 1, "[sendPackage] iecSendPackageCallback is null");
        } else if (z16 && d16.getCode() == 0) {
            iECSendPackageCallback.onSuccess(d16);
        } else {
            iECSendPackageCallback.onError(d16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(IECSendPackageCallback iECSendPackageCallback, boolean z16, int i3, JSONObject jSONObject, PROTOCAL.StQWebRsp stQWebRsp) {
        ECRemoteResponse c16 = c(i3, jSONObject, stQWebRsp);
        if (iECSendPackageCallback == null) {
            QLog.e("ECNetworkManager", 1, "[sendPackage] iecSendPackageCallback is null");
        } else if (z16 && c16.getCode() == 0) {
            iECSendPackageCallback.onSuccess(c16);
        } else {
            iECSendPackageCallback.onError(c16);
        }
    }

    @Override // com.tencent.ecommerce.base.network.api.IECSender
    public int sendPackage(String str, String str2, byte[] bArr, int i3, Map<Object, ?> map, final IECSendPackageCallback iECSendPackageCallback) {
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).ssoForward(str, str2, bArr, i3, (Map<Object, ? extends Object>) map, new l52.a() { // from class: com.tencent.mobileqq.qqecommerce.base.msf.b
            @Override // l52.a
            public final void a(boolean z16, int i16, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
                c.this.e(iECSendPackageCallback, z16, i16, jSONObject, bVar);
            }
        });
        return 0;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECSender
    public int sendQQPackage(String str, byte[] bArr, Map<Object, ?> map, final IECSendPackageCallback iECSendPackageCallback) {
        ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).sendSsoCmdRequest(str, bArr, map, new l52.b() { // from class: com.tencent.mobileqq.qqecommerce.base.msf.a
            @Override // l52.b
            public final void a(boolean z16, int i3, JSONObject jSONObject, PROTOCAL.StQWebRsp stQWebRsp) {
                c.this.f(iECSendPackageCallback, z16, i3, jSONObject, stQWebRsp);
            }
        });
        return 0;
    }

    private ECRemoteResponse d(int i3, JSONObject jSONObject, tencent.trpcprotocol.b bVar) {
        int i16;
        String str;
        int optInt = jSONObject.optInt("channel_code", -1);
        String optString = jSONObject.optString("channel_msg", "");
        if (bVar == null) {
            QLog.e("ECNetworkManager", 1, "[combineRemoteResponse] response is null, seq= " + i3);
            return new ECRemoteResponse(i3, optInt == 0 ? -1 : optInt, "ForwardRsp is null", null, optInt, optString, "");
        }
        QLog.i("ECNetworkManager", 1, "[combineRemoteResponse] requestSeq = " + i3 + ", retcode = " + bVar.f436077a + ", msg = " + bVar.f436078b + ", ssoResult = " + jSONObject);
        int i17 = bVar.f436077a;
        String str2 = bVar.f436078b;
        int optInt2 = jSONObject.optInt("unCompressSucceed", 0);
        String optString2 = jSONObject.optString("unCompressMessage", "ForwardRsp unCompressBody failed");
        if (i17 != 0 || optInt2 == 0) {
            i16 = i17;
            str = str2;
        } else {
            i16 = -2;
            str = optString2;
        }
        ECRemoteResponse eCRemoteResponse = new ECRemoteResponse(i3, i16, str, bVar.f436079c, optInt, optString, "");
        eCRemoteResponse.o(optInt2);
        eCRemoteResponse.m(jSONObject.optInt("compressType", 0));
        eCRemoteResponse.l(jSONObject.optString("compressRatio", "0.0000"));
        eCRemoteResponse.p(jSONObject.optLong("unCompressTimeCost", 0L));
        return eCRemoteResponse;
    }
}
