package cooperation.qzone.util;

import PUSH_COMM_STRUCT.BinaryPushInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes28.dex */
public class JceUtils {
    public static <T extends JceStruct> T decodeWup(Class<T> cls, byte[] bArr) {
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

    public static byte[] encodeWup(JceStruct jceStruct) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf8");
        jceStruct.writeTo(jceOutputStream);
        return jceOutputStream.toByteArray();
    }

    public static byte[] inflateByte(byte[] bArr) {
        if (bArr != null) {
            BinaryPushInfo binaryPushInfo = (BinaryPushInfo) decodeWup(BinaryPushInfo.class, bArr);
            long j3 = binaryPushInfo.compressType;
            if (j3 == 0) {
                return binaryPushInfo.pushBuffer;
            }
            if (j3 == 2) {
                try {
                    Inflater inflater = new Inflater();
                    byte[] bArr2 = binaryPushInfo.pushBuffer;
                    inflater.setInput(bArr2, 0, bArr2.length);
                    byte[] bArr3 = new byte[4096];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr3, 0, inflater.inflate(bArr3));
                    }
                    inflater.end();
                    return byteArrayOutputStream.toByteArray();
                } catch (Exception e16) {
                    QZLog.e("JceUtils.inflateByte", "Push Buf decompresse error!", e16);
                    return bArr;
                }
            }
            return bArr;
        }
        return bArr;
    }

    public static byte[] encodeWup(ArrayList arrayList) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.setServerEncoding("utf8");
        jceOutputStream.write((Collection) arrayList, 0);
        return jceOutputStream.toByteArray();
    }

    public static <T extends JceStruct> T decodeWup(T t16, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("utf8");
                t16.readFrom(jceInputStream);
                return t16;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return null;
    }
}
