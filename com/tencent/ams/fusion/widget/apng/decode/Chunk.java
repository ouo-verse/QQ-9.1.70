package com.tencent.ams.fusion.widget.apng.decode;

import android.text.TextUtils;
import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
class Chunk {
    static IPatchRedirector $redirector_;
    int crc;
    int fourcc;
    int length;
    int offset;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Chunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int fourCCToInt(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            return ((str.charAt(3) & '\u00ff') << 24) | (str.charAt(0) & '\u00ff') | ((str.charAt(1) & '\u00ff') << 8) | ((str.charAt(2) & '\u00ff') << 16);
        }
        return -1159790593;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void parse(APNGReader aPNGReader) throws IOException {
        int available = aPNGReader.available();
        innerParse(aPNGReader);
        int available2 = available - aPNGReader.available();
        int i3 = this.length;
        if (available2 <= i3) {
            if (available2 < i3) {
                aPNGReader.skip(i3 - available2);
                return;
            }
            return;
        }
        throw new IOException("Out of chunk area");
    }

    void innerParse(APNGReader aPNGReader) throws IOException {
    }
}
