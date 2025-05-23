package m52;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.c;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import l52.b;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements com.tencent.mobileqq.kandian.base.msf.a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f416183f = new a();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f416184d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f416185e = new ConcurrentHashMap();

    a() {
    }

    public static a a() {
        return f416183f;
    }

    private b b(String str) {
        Object remove = this.f416185e.remove(str);
        if (remove instanceof WeakReference) {
            remove = ((WeakReference) remove).get();
        }
        if (remove instanceof b) {
            return (b) remove;
        }
        QLog.i("RIJSSOHelper", 1, "#getObserver: not find observer, obj=" + remove);
        return null;
    }

    public void e(String str, byte[] bArr, Map<Object, Object> map, b bVar) {
        String str2;
        Object obj;
        QLog.i("RIJSSOHelper", 1, "#sendRequest: cmd=" + str);
        if (!AppNetConnInfo.isNetSupport()) {
            QLog.i("RIJSSOHelper", 1, "#sendRequest: without network!! return null");
            if (bVar != null) {
                bVar.a(false, 0, new JSONObject(), null);
                return;
            }
            return;
        }
        String str3 = str + util.base64_pad_url + this.f416184d.getAndIncrement();
        QLog.i("RIJSSOHelper", 1, "#sendRequest: key=" + str3);
        this.f416185e.put(str3, bVar);
        if (map != null && (obj = map.get(MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO)) != null) {
            str2 = obj.toString();
        } else {
            str2 = "";
        }
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(this.f416184d.get());
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(bArr));
        ToServiceMsg d16 = c.d(str, stQWebReq.toByteArray());
        d16.setTraceInfo(str2);
        d16.getAttributes().put("trpcSeq", str3);
        d16.getAttributes().put("trpcSeqNum", this.f416184d);
        ReadInJoyMSFService.f().j(d16, this);
    }

    private static PROTOCAL.StQWebRsp d(boolean z16, FromServiceMsg fromServiceMsg, Object obj) {
        int trpcRspFuncRetCode;
        if (!z16) {
            StringBuilder sb5 = new StringBuilder("#parseResponse: isSuccess=false");
            if (fromServiceMsg != null) {
                int businessFailCode = fromServiceMsg.getBusinessFailCode();
                sb5.append(", businessFailCode=");
                sb5.append(businessFailCode);
                f("sso error:" + businessFailCode);
            }
            QLog.e("RIJSSOHelper", 1, sb5);
            return null;
        }
        if (fromServiceMsg != null && (trpcRspFuncRetCode = fromServiceMsg.getTrpcRspFuncRetCode()) != 0) {
            byte[] trpcRspErrorMsg = fromServiceMsg.getTrpcRspErrorMsg();
            String str = (trpcRspErrorMsg == null || trpcRspErrorMsg.length <= 0) ? null : new String(trpcRspErrorMsg);
            QLog.e("RIJSSOHelper", 1, "#parseResponse: trpcErrCode=" + trpcRspFuncRetCode + ", trpcErrMsg=" + str);
            f("trpc error:" + trpcRspFuncRetCode + "," + str);
            return null;
        }
        if (!(obj instanceof byte[])) {
            QLog.e("RIJSSOHelper", 1, "#parseResponse: data=" + obj);
            f("data is null");
            return null;
        }
        try {
            PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
            stQWebRsp.mergeFrom((byte[]) obj);
            return stQWebRsp;
        } catch (IOException e16) {
            QLog.e("RIJSSOHelper", 1, e16, new Object[0]);
            return null;
        }
    }

    private JSONObject c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return new JSONObject();
        }
        try {
            int businessFailCode = fromServiceMsg.getBusinessFailCode();
            JSONObject jSONObject = new JSONObject();
            if (businessFailCode == 1000) {
                businessFailCode = 0;
            }
            jSONObject.put("channel_code", businessFailCode);
            jSONObject.put("channel_msg", fromServiceMsg.getBusinessFailMsg());
            return jSONObject;
        } catch (Throwable unused) {
            QLog.e("RIJSSOHelper", 1, "getSSOResult fail");
            return new JSONObject();
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.msf.a
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = fromServiceMsg != null && fromServiceMsg.isSuccess();
        QLog.i("RIJSSOHelper", 1, "#onReceive: isSuccess=" + z16);
        if (toServiceMsg != null) {
            String str = (String) toServiceMsg.getAttributes().get("trpcSeq");
            QLog.i("RIJSSOHelper", 1, "#onReceive: key=" + str);
            AtomicInteger atomicInteger = (AtomicInteger) toServiceMsg.getAttributes().get("trpcSeqNum");
            b b16 = b(str);
            if (b16 != null) {
                PROTOCAL.StQWebRsp d16 = d(z16, fromServiceMsg, obj);
                if (d16 == null) {
                    z16 = false;
                }
                b16.a(z16, atomicInteger != null ? atomicInteger.get() : 0, c(toServiceMsg, fromServiceMsg), d16);
            }
        }
    }

    private static void f(String str) {
    }
}
