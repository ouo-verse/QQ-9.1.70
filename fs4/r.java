package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile r[] f400569c;

    /* renamed from: a, reason: collision with root package name */
    public String f400570a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f400571b;

    public r() {
        a();
    }

    public static r[] b() {
        if (f400569c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400569c == null) {
                    f400569c = new r[0];
                }
            }
        }
        return f400569c;
    }

    public r a() {
        this.f400570a = "";
        this.f400571b = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400570a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400571b = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400570a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400570a);
        }
        return !Arrays.equals(this.f400571b, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.f400571b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400570a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400570a);
        }
        if (!Arrays.equals(this.f400571b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f400571b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
