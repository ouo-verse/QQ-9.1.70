package com.tencent.upload.utils;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes27.dex */
public class ProtocolUtil {
    static IPatchRedirector $redirector_;

    public ProtocolUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final int[] fromProtocolSequence(String str) {
        int[] iArr = {0, 0};
        if (str != null && str.length() != 0) {
            try {
                String[] split = str.split("\\|");
                if (split != null && split.length == 2) {
                    try {
                        iArr[0] = Integer.parseInt(split[0]);
                        iArr[1] = Integer.parseInt(split[1]);
                    } catch (NumberFormatException e16) {
                        UploadLog.w(ProtocolUtil.class.getSimpleName(), "toProtocolSequence " + e16);
                    }
                } else {
                    UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence:" + str + " results == null || results.length != 2" + str);
                }
            } catch (PatternSyntaxException e17) {
                UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence:" + str + " " + e17);
            }
        } else {
            UploadLog.w(ProtocolUtil.class.getSimpleName(), "fromProtocolSequence protocolSequence == null || len == 0");
        }
        return iArr;
    }

    public static final byte[] pack(String str, Object obj) throws Exception {
        if (str != null && obj != null) {
            UniPacket uniPacket = new UniPacket();
            uniPacket.setEncodeName("UTF-8");
            uniPacket.setRequestId(0);
            uniPacket.setFuncName("FuncName");
            uniPacket.setServantName("ServantName");
            uniPacket.put(str, obj);
            byte[] encode = uniPacket.encode();
            uniPacket.clearCacheData();
            return encode;
        }
        return null;
    }

    public static final String toProtocolSequence(int i3, int i16) {
        return i3 + "|" + i16;
    }

    public static final Object unpack(String str, byte[] bArr) throws Exception {
        if (bArr == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket();
        uniPacket.setEncodeName("UTF-8");
        uniPacket.decode(bArr);
        Object obj = uniPacket.get(str);
        uniPacket.clearCacheData();
        return obj;
    }
}
