package com.tencent.av.core;

import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.pb.CodedInputStreamMicro;
import com.tencent.mobileqq.pb.WireFormatMicro;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static byte a(byte[] bArr) {
        if (bArr != null && bArr.length >= 3) {
            return bArr[2];
        }
        return (byte) -1;
    }

    public static boolean b(byte[] bArr) {
        CodedInputStreamMicro newInstance = CodedInputStreamMicro.newInstance(bArr);
        while (true) {
            try {
                int readTag = newInstance.readTag();
                if (readTag != 0) {
                    if (WireFormatMicro.getTagFieldNumber(readTag) == 2) {
                        return true;
                    }
                    newInstance.skipField(readTag);
                } else {
                    return false;
                }
            } catch (IOException e16) {
                if (AVCoreLog.isColorLevel()) {
                    AVCoreLog.e("AbstractNetChannel", "", e16);
                    return false;
                }
                return false;
            }
        }
    }
}
