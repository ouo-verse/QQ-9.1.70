package com.tencent.ams.fusion.widget.apng.frame.animation.io;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ByteBufferWriter implements Writer {
    static IPatchRedirector $redirector_;
    protected ByteBuffer byteBuffer;

    public ByteBufferWriter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            reset(10240);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public int position() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.byteBuffer.position();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void putByte(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Byte.valueOf(b16));
        } else {
            this.byteBuffer.put(b16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void putBytes(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            this.byteBuffer.put(bArr);
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void reset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer == null || i3 > byteBuffer.capacity()) {
            ByteBuffer allocate = ByteBuffer.allocate(i3);
            this.byteBuffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.byteBuffer.clear();
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public void skip(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.byteBuffer.position(i3 + position());
        }
    }

    @Override // com.tencent.ams.fusion.widget.apng.frame.animation.io.Writer
    public byte[] toByteArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.byteBuffer.array();
    }
}
