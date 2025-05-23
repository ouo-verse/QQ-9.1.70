package com.tencent.ams.fusion.widget.apng.decode;

import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
class FCTLChunk extends Chunk {
    static IPatchRedirector $redirector_ = null;
    static final int APNG_BLEND_OP_OVER = 1;
    static final int APNG_BLEND_OP_SOURCE = 0;
    static final int APNG_DISPOSE_OP_BACKGROUND = 1;
    static final int APNG_DISPOSE_OP_NON = 0;
    static final int APNG_DISPOSE_OP_PREVIOUS = 2;
    static final int ID;
    byte blendOp;
    short delayDen;
    short delayNum;
    byte disposeOp;
    int height;
    int sequenceNumber;
    int width;
    int xOffset;
    int yOffset;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52183);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            ID = Chunk.fourCCToInt("fcTL");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FCTLChunk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.decode.Chunk
    void innerParse(APNGReader aPNGReader) throws IOException {
        this.sequenceNumber = aPNGReader.readInt();
        this.width = aPNGReader.readInt();
        this.height = aPNGReader.readInt();
        this.xOffset = aPNGReader.readInt();
        this.yOffset = aPNGReader.readInt();
        this.delayNum = aPNGReader.readShort();
        this.delayDen = aPNGReader.readShort();
        this.disposeOp = aPNGReader.peek();
        this.blendOp = aPNGReader.peek();
    }
}
