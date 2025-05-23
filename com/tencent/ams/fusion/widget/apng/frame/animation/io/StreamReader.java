package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StreamReader extends FilterInputStream implements Reader {
    static IPatchRedirector $redirector_;
    private int position;

    public StreamReader(InputStream inputStream) {
        super(inputStream);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream);
        } else {
            try {
                inputStream.reset();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public byte peek() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Byte) iPatchRedirector.redirect((short) 2, (Object) this)).byteValue();
        }
        byte read = (byte) read();
        this.position++;
        return read;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public int position() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.position;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int read = super.read(bArr, i3, i16);
        this.position += Math.max(0, read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public synchronized void reset() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.reset();
            this.position = 0;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public long skip(long j3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, j3)).longValue();
        }
        long skip = super.skip(j3);
        this.position = (int) (this.position + skip);
        return skip;
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader
    public InputStream toInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InputStream) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this;
    }
}
