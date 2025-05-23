package com.tencent.mobileqq.msf.core.net.utils;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.g;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f249475a = "ByteMessageCodec";

    /* renamed from: b, reason: collision with root package name */
    public static final String f249476b = "send_mode";

    /* renamed from: c, reason: collision with root package name */
    public static final int f249477c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static final int f249478d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static final int f249479e = 591;

    /* renamed from: f, reason: collision with root package name */
    public static final int f249480f = 595;

    /* renamed from: g, reason: collision with root package name */
    public static final int f249481g = 600;

    /* renamed from: h, reason: collision with root package name */
    protected static final char[] f249482h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18457);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f249482h = "0123456789ABCDEF".toCharArray();
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] a(ToServiceMsg toServiceMsg, MsfCore msfCore) {
        return b(toServiceMsg, msfCore);
    }

    private static byte[] b(ToServiceMsg toServiceMsg, MsfCore msfCore) {
        byte[] bArr;
        byte[] bArr2;
        if (toServiceMsg == null) {
            QLog.e(f249475a, 1, "[messageToByte] error: msg is null.");
            return null;
        }
        try {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (toServiceMsg.getWupBuffer() != null) {
                byte d16 = k.d();
                byte activeNetIpFamily = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
                if (toServiceMsg.getAttributes().containsKey("send_mode")) {
                    ((Integer) toServiceMsg.getAttributes().get("send_mode")).intValue();
                }
                try {
                    bArr2 = t.a(toServiceMsg, serviceCmd, activeNetIpFamily, d16);
                } catch (Exception e16) {
                    QLog.d(f249475a, 1, "", e16);
                    bArr2 = null;
                }
                if (591 == CodecWarpper.getSharedObjectVersion()) {
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, toServiceMsg.getWupBuffer(), true);
                } else {
                    if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                        bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, activeNetIpFamily, bArr2, null, toServiceMsg.getWupBuffer(), true);
                    }
                    bArr = CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", serviceCmd, null, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, bArr2, null, toServiceMsg.getWupBuffer(), true);
                }
            } else {
                bArr = new byte[0];
            }
            return bArr;
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d(f249475a, 1, "[messageToByte] get packet fail ssoSeq: " + toServiceMsg.getRequestSsoSeq(), th5);
            return null;
        }
    }

    public static FromServiceMsg a(byte[] bArr, MsfCore msfCore) {
        return b(bArr, msfCore);
    }

    private static FromServiceMsg a(FromServiceMsg fromServiceMsg) {
        if ((fromServiceMsg.getFlag() & 1) != 0) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            if (wupBuffer.length > 4) {
                try {
                    int i3 = ((wupBuffer[0] & 255) << 24) | 0 | ((wupBuffer[1] & 255) << 16) | ((wupBuffer[2] & 255) << 8) | (wupBuffer[3] & 255);
                    byte[] bArr = new byte[i3];
                    System.arraycopy(wupBuffer, 4, bArr, 0, i3 - 4);
                    byte[] b16 = g.b(bArr);
                    byte[] bArr2 = new byte[b16.length + 4];
                    bArr2[0] = (byte) (((b16.length + 4) >> 24) & 255);
                    bArr2[1] = (byte) (((b16.length + 4) >> 16) & 255);
                    bArr2[2] = (byte) (((b16.length + 4) >> 8) & 255);
                    bArr2[3] = (byte) ((b16.length + 4) & 255);
                    System.arraycopy(b16, 0, bArr2, 4, b16.length);
                    fromServiceMsg.putWupBuffer(bArr2);
                } catch (Throwable th5) {
                    QLog.d(f249475a, 1, "LightSender uncompress data failed", th5);
                }
            }
            return null;
        }
        return fromServiceMsg;
    }

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int i16 = bArr[i3] & 255;
            int i17 = i3 * 2;
            char[] cArr2 = f249482h;
            cArr[i17] = cArr2[i16 >>> 4];
            cArr[i17 + 1] = cArr2[i16 & 15];
        }
        return new String(cArr);
    }

    private static FromServiceMsg b(byte[] bArr, MsfCore msfCore) {
        if (bArr != null && bArr.length > 0) {
            FromServiceMsg nativeParseData = CodecWarpper.nativeParseData(bArr);
            if (nativeParseData == null) {
                QLog.e(f249475a, 1, "[byteToMessage] msg is null.");
                return null;
            }
            return a(nativeParseData);
        }
        QLog.e(f249475a, 1, "[byteToMessage] error: data is null.");
        return null;
    }
}
