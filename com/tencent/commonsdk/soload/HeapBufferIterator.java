package com.tencent.commonsdk.soload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class HeapBufferIterator extends BufferIterator {
    static IPatchRedirector $redirector_;
    private final byte[] buffer;
    private final int byteCount;
    private final int offset;
    private final ByteOrder order;
    private int position;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public final class SizeOf {
        static IPatchRedirector $redirector_ = null;
        public static final int CHAR = 2;
        public static final int DOUBLE = 8;
        public static final int FLOAT = 4;
        public static final int INT = 4;
        public static final int LONG = 8;
        public static final int SHORT = 2;

        SizeOf() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HeapBufferIterator.this);
            }
        }
    }

    HeapBufferIterator(byte[] bArr, int i3, int i16, ByteOrder byteOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, Integer.valueOf(i3), Integer.valueOf(i16), byteOrder);
            return;
        }
        this.buffer = bArr;
        this.offset = i3;
        this.byteCount = i16;
        this.order = byteOrder;
    }

    public static HeapBufferIterator iterator(byte[] bArr, int i3, int i16, ByteOrder byteOrder) {
        return new HeapBufferIterator(bArr, i3, i16, byteOrder);
    }

    @Override // com.tencent.commonsdk.soload.BufferIterator
    public int readInt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        int peekInt = Memory.peekInt(this.buffer, this.offset + this.position, this.order);
        this.position += 4;
        return peekInt;
    }

    @Override // com.tencent.commonsdk.soload.BufferIterator
    public short readShort() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Short) iPatchRedirector.redirect((short) 5, (Object) this)).shortValue();
        }
        short peekShort = Memory.peekShort(this.buffer, this.offset + this.position, this.order);
        this.position += 2;
        return peekShort;
    }

    @Override // com.tencent.commonsdk.soload.BufferIterator
    public void seek(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.position = i3;
        }
    }

    @Override // com.tencent.commonsdk.soload.BufferIterator
    public void skip(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.position += i3;
        }
    }
}
