package com.tencent.tedger.outapi.beans;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class SampleInfoDB implements Serializable {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 1;
    public String ID;
    public boolean hasUsed;
    public byte[] sample;
    public long timeStamp;

    public SampleInfoDB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static SampleInfoDB ByteToObject(byte[] bArr) {
        SampleInfoDB sampleInfoDB = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            SampleInfoDB sampleInfoDB2 = (SampleInfoDB) objectInputStream.readObject();
            try {
                byteArrayInputStream.close();
                objectInputStream.close();
                return sampleInfoDB2;
            } catch (Exception e16) {
                e = e16;
                sampleInfoDB = sampleInfoDB2;
                e.printStackTrace();
                return sampleInfoDB;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static byte[] toByteArray(SampleInfoDB sampleInfoDB) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(sampleInfoDB);
            objectOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e16) {
            e16.printStackTrace();
            return bArr;
        }
    }
}
