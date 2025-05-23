package nj2;

import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends UniPacket {
    public a(boolean z16) {
        super(z16);
    }

    private byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (!inflater.finished()) {
            try {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } catch (DataFormatException e16) {
                    e16.printStackTrace();
                }
            } finally {
                inflater.end();
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        return bArr;
    }

    @Override // com.qq.jce.wup.UniAttribute
    public <T> T getByClass(String str, T t16) throws ObjectCreateException {
        boolean z16 = false;
        if (this._data.containsKey("compressed") && this._data.get("compressed") != null) {
            byte[] bArr = this._data.get("compressed").get(HippyControllerProps.STRING);
            if ("true".equalsIgnoreCase(new String(bArr))) {
                HashMap<String, byte[]> hashMap = this._data.get(str);
                if (hashMap != null) {
                    Iterator<Map.Entry<String, byte[]>> it = hashMap.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry<String, byte[]> next = it.next();
                        next.setValue(a(next.getValue()));
                    }
                }
                z16 = true;
            } else {
                ms.a.c("CompressUniPacket", "not compressed " + new String(bArr));
            }
        }
        b(z16);
        return (T) super.getByClass(str, t16);
    }

    private void b(boolean z16) {
    }
}
