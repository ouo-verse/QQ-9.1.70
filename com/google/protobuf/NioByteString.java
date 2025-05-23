package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NioByteString(ByteBuffer byteBuffer) {
        ad.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer i(int i3, int i16) {
        if (i3 >= this.buffer.position() && i16 <= this.buffer.limit() && i3 <= i16) {
            ByteBuffer slice = this.buffer.slice();
            slice.position(i3 - this.buffer.position());
            slice.limit(i16 - this.buffer.position());
            return slice;
        }
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i16)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i3) {
        try {
            return this.buffer.get(i3);
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw e16;
        } catch (IndexOutOfBoundsException e17) {
            throw new ArrayIndexOutOfBoundsException(e17.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i3, int i16, int i17) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i3);
        slice.get(bArr, i16, i17);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString byteString, int i3, int i16) {
        return substring(0, i16).equals(byteString.substring(i3, i16 + i3));
    }

    @Override // com.google.protobuf.ByteString
    public byte internalByteAt(int i3) {
        return byteAt(i3);
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.r(this.buffer);
    }

    @Override // com.google.protobuf.ByteString
    public k newCodedInput() {
        return k.j(this.buffer, true);
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int partialHash(int i3, int i16, int i17) {
        for (int i18 = i16; i18 < i16 + i17; i18++) {
            i3 = (i3 * 31) + this.buffer.get(i18);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i3, int i16, int i17) {
        return Utf8.u(i3, this.buffer, i16, i17 + i16);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i3, int i16) {
        try {
            return new NioByteString(i(i3, i16));
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw e16;
        } catch (IndexOutOfBoundsException e17) {
            throw new ArrayIndexOutOfBoundsException(e17.getMessage());
        }
    }

    @Override // com.google.protobuf.ByteString
    protected String toStringInternal(Charset charset) {
        byte[] byteArray;
        int length;
        int i3;
        if (this.buffer.hasArray()) {
            byteArray = this.buffer.array();
            i3 = this.buffer.arrayOffset() + this.buffer.position();
            length = this.buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            i3 = 0;
        }
        return new String(byteArray, i3, length, charset);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i3, int i16) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i3, i16);
        } else {
            i.g(i(i3, i16 + i3), outputStream);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends InputStream {

        /* renamed from: d, reason: collision with root package name */
        private final ByteBuffer f35592d;

        a() {
            this.f35592d = NioByteString.this.buffer.slice();
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f35592d.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.f35592d.mark();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f35592d.hasRemaining()) {
                return this.f35592d.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            try {
                this.f35592d.reset();
            } catch (InvalidMarkException e16) {
                throw new IOException(e16);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            if (!this.f35592d.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i16, this.f35592d.remaining());
            this.f35592d.get(bArr, i3, min);
            return min;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void writeTo(j jVar) throws IOException {
        jVar.a(this.buffer.slice());
    }
}
