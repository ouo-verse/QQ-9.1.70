package cooperation.vip;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static <T extends JceStruct> T a(Class<T> cls, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf8");
            newInstance.readFrom(jceInputStream);
            return newInstance;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
