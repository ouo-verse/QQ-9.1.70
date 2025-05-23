package common.config.service;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {
    public static <T extends JceStruct> T a(Class<T> cls, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                newInstance.readFrom(new JceInputStream(bArr));
                return newInstance;
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return null;
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] b(JceStruct jceStruct) {
        if (jceStruct == null) {
            return null;
        }
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf-8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }
}
