package com.tencent.rdelivery.reshub.util;

import com.tencent.mobileqq.app.MessageHandlerConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class b {
    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return b(inputStream, outputStream, MessageHandlerConstants.NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM);
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i3) throws IOException {
        byte[] bArr = new byte[i3];
        long j3 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                outputStream.write(bArr, 0, read);
                j3 += read;
            } else {
                return j3;
            }
        }
    }
}
