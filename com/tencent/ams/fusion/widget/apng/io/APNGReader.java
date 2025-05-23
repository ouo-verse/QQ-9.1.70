package com.tencent.ams.fusion.widget.apng.io;

import android.text.TextUtils;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.FilterReader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;

/* loaded from: classes3.dex */
public class APNGReader extends FilterReader {
    static IPatchRedirector $redirector_;
    private static ThreadLocal<byte[]> __intBytes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51947);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            __intBytes = new ThreadLocal<>();
        }
    }

    public APNGReader(Reader reader) {
        super(reader);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) reader);
        }
    }

    protected static byte[] ensureBytes() {
        byte[] bArr = __intBytes.get();
        if (bArr == null) {
            byte[] bArr2 = new byte[4];
            __intBytes.set(bArr2);
            return bArr2;
        }
        return bArr;
    }

    public boolean matchFourCC(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return false;
        }
        int readFourCC = readFourCC();
        for (int i3 = 0; i3 < 4; i3++) {
            if (((readFourCC >> (i3 * 8)) & 255) != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public int readFourCC() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        byte[] ensureBytes = ensureBytes();
        if (read(ensureBytes, 0, 4) == -1) {
            return 0;
        }
        return ((ensureBytes[3] & 255) << 24) | (ensureBytes[0] & 255) | ((ensureBytes[1] & 255) << 8) | ((ensureBytes[2] & 255) << 16);
    }

    public int readInt() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        byte[] ensureBytes = ensureBytes();
        if (read(ensureBytes, 0, 4) == -1) {
            return 0;
        }
        return ((ensureBytes[0] & 255) << 24) | ((ensureBytes[2] & 255) << 8) | (ensureBytes[3] & 255) | ((ensureBytes[1] & 255) << 16);
    }

    public short readShort() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Short) iPatchRedirector.redirect((short) 3, (Object) this)).shortValue();
        }
        byte[] ensureBytes = ensureBytes();
        if (read(ensureBytes, 0, 2) == -1) {
            return (short) 0;
        }
        return (short) (((ensureBytes[0] & 255) << 8) | (ensureBytes[1] & 255));
    }
}
