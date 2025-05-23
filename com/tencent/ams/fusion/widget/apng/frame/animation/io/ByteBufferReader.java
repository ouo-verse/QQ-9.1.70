package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ByteBufferReader implements Reader {
    static IPatchRedirector $redirector_;
    private final ByteBuffer byteBuffer;

    public ByteBufferReader(ByteBuffer byteBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) byteBuffer);
        } else {
            this.byteBuffer = byteBuffer;
            byteBuffer.position(0);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public int available() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.byteBuffer.limit() - this.byteBuffer.position();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public byte peek() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Byte) iPatchRedirector.redirect((short) 3, (Object) this)).byteValue();
        }
        return this.byteBuffer.get();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public int position() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.byteBuffer.position();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        this.byteBuffer.get(bArr, i3, i16);
        return i16;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public void reset() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.byteBuffer.position(0);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public long skip(long j3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, j3)).longValue();
        }
        this.byteBuffer.position((int) (r0.position() + j3));
        return j3;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public InputStream toInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (InputStream) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new ByteArrayInputStream(this.byteBuffer.array());
    }
}
