package com.tencent.ams.fusion.widget.apng.decode;

import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
class FDATChunk extends Chunk {
    static IPatchRedirector $redirector_;
    static final int ID;
    int sequence_number;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52186);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ID = Chunk.fourCCToInt("fdAT");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FDATChunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) throws IOException {
        this.sequence_number = aPNGReader.readInt();
    }
}
