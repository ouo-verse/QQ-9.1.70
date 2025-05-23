package com.tencent.upload.utils;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JceEncoder {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "JceEncoder";

    public JceEncoder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static <T extends JceStruct> T decode(Class<T> cls, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                return (T) decode(cls.newInstance(), bArr);
            } catch (Exception e16) {
                UploadLog.e(TAG, "decode(Class<T> clazz, byte[] datas)  e = " + e16);
            }
        }
        return null;
    }

    public static byte[] encode(JceStruct jceStruct) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public static <T extends JceStruct> T decode(T t16, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf8");
                t16.readFrom(jceInputStream);
                return t16;
            } catch (Exception e16) {
                UploadLog.e(TAG, "decode(T t, byte[] datas)  e = " + e16);
            }
        }
        return null;
    }
}
