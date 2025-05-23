package bs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile i[] f29071c;

    /* renamed from: a, reason: collision with root package name */
    public String f29072a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29073b;

    public i() {
        a();
    }

    public static i[] b() {
        if (f29071c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f29071c == null) {
                    f29071c = new i[0];
                }
            }
        }
        return f29071c;
    }

    public i a() {
        this.f29072a = "";
        this.f29073b = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f29072a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29073b = codedInputByteBufferNano.readBytes();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f29072a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f29072a);
        }
        return !Arrays.equals(this.f29073b, WireFormatNano.EMPTY_BYTES) ? computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.f29073b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f29072a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f29072a);
        }
        if (!Arrays.equals(this.f29073b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f29073b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
