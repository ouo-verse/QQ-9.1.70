package com.tencent.mobileqq.fts.v1.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MsgExts implements Serializable, Cloneable {
    static IPatchRedirector $redirector_;

    public MsgExts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static long bytesToLong(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr);
        allocate.flip();
        return allocate.getLong();
    }

    public static byte[] copyOfRange(byte[] bArr, int i3, int i16) {
        if (i3 <= i16) {
            int length = bArr.length;
            if (i3 >= 0 && i3 <= length) {
                int i17 = i16 - i3;
                int min = Math.min(i17, length - i3);
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, i3, bArr2, 0, min);
                return bArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    public static byte[] longToBytes(long j3) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(j3);
        return allocate.array();
    }

    public static byte[] serialize(Object obj, int i3) {
        if (obj == null || i3 != 1) {
            return null;
        }
        try {
            if (!(obj instanceof TextMsgExts)) {
                return null;
            }
            byte[] bArr = new byte[16];
            TextMsgExts textMsgExts = (TextMsgExts) obj;
            System.arraycopy(longToBytes(textMsgExts.time), 0, bArr, 0, 8);
            System.arraycopy(longToBytes(textMsgExts.shmsgseq), 0, bArr, 8, 8);
            return bArr;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.MsgExts", 2, "unserialize: failure", e16);
            }
            return null;
        }
    }

    public static Object unserialize(byte[] bArr, int i3) {
        if (bArr == null || bArr.length == 0 || i3 != 1) {
            return null;
        }
        try {
            if (bArr.length != 16) {
                return null;
            }
            return new TextMsgExts(bytesToLong(copyOfRange(bArr, 0, 8)), bytesToLong(copyOfRange(bArr, 8, 16)));
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.fts.MsgExts", 2, "unserialize: failure", e16);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return super.clone();
    }
}
