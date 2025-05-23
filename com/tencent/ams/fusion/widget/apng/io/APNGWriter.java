package com.tencent.ams.fusion.widget.apng.io;

import com.tencent.ams.fusion.widget.apng.frame.animation.io.ByteBufferWriter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteOrder;

/* loaded from: classes3.dex */
public class APNGWriter extends ByteBufferWriter {
    static IPatchRedirector $redirector_;

    public APNGWriter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.ByteBufferWriter, com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void reset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            super.reset(i3);
            this.byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
    }

    public void writeFourCC(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        putByte((byte) (i3 & 255));
        putByte((byte) ((i3 >> 8) & 255));
        putByte((byte) ((i3 >> 16) & 255));
        putByte((byte) ((i3 >> 24) & 255));
    }

    public void writeInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        putByte((byte) ((i3 >> 24) & 255));
        putByte((byte) ((i3 >> 16) & 255));
        putByte((byte) ((i3 >> 8) & 255));
        putByte((byte) (i3 & 255));
    }
}
