package com.tencent.ams.fusion.widget.apng.decode;

import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
class IHDRChunk extends Chunk {
    static IPatchRedirector $redirector_;
    static final int ID;
    byte[] data;
    int height;
    int width;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ID = Chunk.fourCCToInt("IHDR");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IHDRChunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.data = new byte[5];
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) throws IOException {
        this.width = aPNGReader.readInt();
        this.height = aPNGReader.readInt();
        byte[] bArr = this.data;
        aPNGReader.read(bArr, 0, bArr.length);
    }
}
