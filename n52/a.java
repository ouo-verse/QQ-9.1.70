package n52;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.c;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;
import tencent.trpcprotocol.b;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a implements com.tencent.mobileqq.kandian.base.msf.a {

    /* renamed from: f, reason: collision with root package name */
    private static final a f418384f = new a();

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f418385d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, Object> f418386e = new ConcurrentHashMap();

    a() {
    }

    public static a a() {
        return f418384f;
    }

    private l52.a b(String str) {
        Object remove = this.f418386e.remove(str);
        if (remove instanceof WeakReference) {
            remove = ((WeakReference) remove).get();
        }
        if (remove instanceof l52.a) {
            return (l52.a) remove;
        }
        QLog.i("RIJTrpcHelper", 1, "#getObserver: not find observer, obj=" + remove);
        return null;
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
            if (toServiceMsg != null) {
                jSONObject.put("compressType", toServiceMsg.getAttributes().get("compressType"));
                jSONObject.put("compressRatio", toServiceMsg.getAttributes().get("compressRatio"));
                jSONObject.put("unCompressSucceed", toServiceMsg.getAttributes().get("unCompressSucceed"));
                jSONObject.put("unCompressTimeCost", toServiceMsg.getAttributes().get("unCompressTimeCost"));
            }
            return jSONObject;
        } catch (Throwable unused) {
            QLog.e("RIJTrpcHelper", 1, "getSSOResult fail");
            return new JSONObject();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a0, code lost:
    
        if (r12 != null) goto L31;
     */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00f6: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:45:0x00fb, block:B:43:0x00f6 */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] h(byte[] bArr, ToServiceMsg toServiceMsg) throws IOException {
        GZIPInputStream gZIPInputStream;
        Throwable th5;
        IOException e16;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2;
        byte[] bArr3;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr4 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr4);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr4, 0, read);
                    }
                    bArr3 = byteArrayOutputStream.toByteArray();
                    if (toServiceMsg != null) {
                        toServiceMsg.getAttributes().put("unCompressSucceed", 0);
                    }
                    QLog.d("RIJTrpcHelper", 1, "unCompressBody succeed, data report succeed.");
                    gZIPInputStream.close();
                } catch (IOException e17) {
                    e16 = e17;
                    bArr2 = new byte[0];
                    QLog.d("RIJTrpcHelper", 1, "unCompressBody IOException failed: ", e16.toString(), ", data report failed.");
                    e16.printStackTrace();
                    if (toServiceMsg != null) {
                        toServiceMsg.getAttributes().put("unCompressSucceed", 1);
                    }
                } catch (Throwable th6) {
                    th5 = th6;
                    bArr2 = new byte[0];
                    QLog.d("RIJTrpcHelper", 1, "unCompressBody finally failed: ", th5.toString(), ", data report failed.");
                    th5.printStackTrace();
                    if (toServiceMsg != null) {
                        toServiceMsg.getAttributes().put("unCompressSucceed", 2);
                    }
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    bArr3 = bArr2;
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    if (toServiceMsg != null) {
                    }
                    if (bArr3.length > 0) {
                    }
                    QLog.d("RIJTrpcHelper", 1, "unCompressBody cost = ", Long.valueOf(currentTimeMillis2));
                    return bArr3;
                }
            } catch (IOException e18) {
                gZIPInputStream = null;
                e16 = e18;
            } catch (Throwable th7) {
                gZIPInputStream = null;
                th5 = th7;
            }
            long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
            if (toServiceMsg != null) {
                toServiceMsg.getAttributes().put("unCompressTimeCost", Long.valueOf(currentTimeMillis22));
            }
            if (bArr3.length > 0) {
                float length = (((bArr.length * 10000) / bArr3.length) * 1.0f) / 10000.0f;
                DecimalFormat decimalFormat = new DecimalFormat("0.0000");
                if (toServiceMsg != null) {
                    toServiceMsg.getAttributes().put("compressRatio", decimalFormat.format(length));
                }
            }
            QLog.d("RIJTrpcHelper", 1, "unCompressBody cost = ", Long.valueOf(currentTimeMillis22));
            return bArr3;
        } catch (Throwable th8) {
            if (gZIPInputStream2 != null) {
                gZIPInputStream2.close();
            }
            throw th8;
        }
    }

    public void e(String str, String str2, byte[] bArr, int i3, Map<Object, Object> map, String str3, l52.a aVar, boolean z16) {
        int i16 = 0;
        if (!AppNetConnInfo.isNetSupport()) {
            QLog.i("RIJTrpcHelper", 1, "#sendRequest: without network!! return null");
            if (aVar != null) {
                aVar.a(false, 0, new JSONObject(), null);
                return;
            }
            return;
        }
        String str4 = str + util.base64_pad_url + str2 + util.base64_pad_url + this.f418385d.getAndIncrement();
        if (z16) {
            this.f418386e.put(str4, new WeakReference(aVar));
        } else {
            this.f418386e.put(str4, aVar);
        }
        tencent.trpcprotocol.a aVar2 = new tencent.trpcprotocol.a();
        aVar2.f436071a = str;
        aVar2.f436072b = str2;
        aVar2.f436073c = bArr;
        aVar2.f436074d = i3;
        if (!TextUtils.isEmpty(str3)) {
            aVar2.f436075e = str3;
        }
        String str5 = "";
        if (map != null) {
            r45.a[] aVarArr = new r45.a[map.size()];
            for (Object obj : map.keySet()) {
                if (MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO.equals(obj)) {
                    str5 = map.get(obj).toString();
                } else {
                    r45.a aVar3 = new r45.a();
                    aVar3.f430739a = obj.toString();
                    aVar3.f430740b = map.get(obj).toString();
                    aVarArr[i16] = aVar3;
                    i16++;
                }
            }
            aVar2.f436076f = aVarArr;
        }
        ToServiceMsg d16 = c.d("trpc.ecom.api_gateway.ApiGateway.SsoForward", MessageNano.toByteArray(aVar2));
        d16.setTraceInfo(str5);
        d16.getAttributes().put("trpcSeq", str4);
        d16.getAttributes().put("trpcSeqNum", this.f418385d);
        ReadInJoyMSFService.f().j(d16, this);
    }

    private static b d(boolean z16, FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg, Object obj) {
        int trpcRspFuncRetCode;
        if (!z16) {
            StringBuilder sb5 = new StringBuilder("#parseResponse: isSuccess=false");
            if (fromServiceMsg != null) {
                int businessFailCode = fromServiceMsg.getBusinessFailCode();
                sb5.append(", businessFailCode=");
                sb5.append(businessFailCode);
                g("sso error:" + businessFailCode);
            }
            QLog.e("RIJTrpcHelper", 1, sb5);
            return null;
        }
        if (fromServiceMsg != null && (trpcRspFuncRetCode = fromServiceMsg.getTrpcRspFuncRetCode()) != 0) {
            byte[] trpcRspErrorMsg = fromServiceMsg.getTrpcRspErrorMsg();
            String str = (trpcRspErrorMsg == null || trpcRspErrorMsg.length <= 0) ? null : new String(trpcRspErrorMsg);
            QLog.e("RIJTrpcHelper", 1, "#parseResponse: trpcErrCode=" + trpcRspFuncRetCode + ", trpcErrMsg=" + str);
            g("trpc error:" + trpcRspFuncRetCode + "," + str);
            return null;
        }
        if (!(obj instanceof byte[])) {
            QLog.e("RIJTrpcHelper", 1, "#parseResponse: data=" + obj);
            g("data is null");
            return null;
        }
        try {
            b c16 = b.c((byte[]) obj);
            QLog.i("RIJTrpcHelper", 1, "#parseResponse: code=" + c16.f436077a + ", msg=" + c16.f436078b + ", compressType=" + c16.f436080d);
            if (c16.f436080d == 1) {
                c16.f436079c = h(c16.f436079c, toServiceMsg);
            }
            if (toServiceMsg != null) {
                toServiceMsg.getAttributes().put("compressType", Integer.valueOf(c16.f436080d));
            }
            return c16;
        } catch (IOException e16) {
            QLog.e("RIJTrpcHelper", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.msf.a
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = fromServiceMsg != null && fromServiceMsg.isSuccess();
        if (toServiceMsg != null) {
            String str = (String) toServiceMsg.getAttributes().get("trpcSeq");
            if (QLog.isColorLevel()) {
                QLog.i("RIJTrpcHelper", 2, "#onReceive: isSuccess=" + z16 + ", key=" + str);
            }
            AtomicInteger atomicInteger = (AtomicInteger) toServiceMsg.getAttributes().get("trpcSeqNum");
            l52.a b16 = b(str);
            if (b16 != null) {
                b d16 = d(z16, fromServiceMsg, toServiceMsg, obj);
                if (d16 == null) {
                    z16 = false;
                }
                b16.a(z16, atomicInteger != null ? atomicInteger.get() : 0, c(toServiceMsg, fromServiceMsg), d16);
            }
        }
    }

    public void f(String str, String str2, byte[] bArr, Map<Object, Object> map, String str3, l52.a aVar) {
        e(str, str2, bArr, 0, map, str3, aVar, false);
    }

    private static void g(String str) {
    }
}
