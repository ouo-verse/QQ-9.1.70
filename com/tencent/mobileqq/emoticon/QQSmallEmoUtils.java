package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSmallEmoUtils {
    static IPatchRedirector $redirector_;

    public QQSmallEmoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int computeIntFromBytes(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 << 8) | (bArr[i17] & 255);
        }
        return i16;
    }

    public static int[] getEmoDescripFromChars(char[] cArr) {
        return new int[]{computeIntFromBytes(new byte[]{(byte) cArr[0], (byte) cArr[1]}, 2), cArr[2]};
    }
}
