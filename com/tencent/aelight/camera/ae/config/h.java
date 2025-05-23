package com.tencent.aelight.camera.ae.config;

import com.qq.jce.wup.ObjectCreateException;
import com.qq.jce.wup.UniPacket;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends UniPacket {

    /* renamed from: a, reason: collision with root package name */
    private final String f63490a;

    public h(boolean z16) {
        super(z16);
        this.f63490a = "compressed";
    }

    @Override // com.qq.jce.wup.UniAttribute
    public <T> T getByClass(String str, T t16) throws ObjectCreateException {
        HashMap<String, HashMap<String, byte[]>> hashMap = this._data;
        boolean z16 = false;
        if (hashMap != null && hashMap.containsKey("compressed") && this._data.get("compressed") != null) {
            byte[] bArr = this._data.get("compressed").get(HippyControllerProps.STRING);
            if ("true".equalsIgnoreCase(new String(bArr))) {
                HashMap<String, byte[]> hashMap2 = this._data.get(str);
                if (hashMap2 != null) {
                    Iterator<Map.Entry<String, byte[]>> it = hashMap2.entrySet().iterator();
                    if (it.hasNext()) {
                        Map.Entry<String, byte[]> next = it.next();
                        next.setValue(a(next.getValue()));
                    }
                }
                z16 = true;
            } else {
                QLog.e("CompressUniPacket", 1, "not compressed " + new String(bArr));
            }
        }
        b(z16);
        return (T) super.getByClass(str, t16);
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
                } catch (Error e16) {
                    e16.printStackTrace();
                } catch (DataFormatException e17) {
                    e17.printStackTrace();
                }
            } finally {
                inflater.end();
            }
        }
        bArr = byteArrayOutputStream.toByteArray();
        return bArr;
    }

    private void b(boolean z16) {
    }
}
