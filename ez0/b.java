package ez0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f397451a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f397452b;

    /* renamed from: c, reason: collision with root package name */
    public a f397453c;

    /* renamed from: d, reason: collision with root package name */
    public long f397454d;

    /* renamed from: e, reason: collision with root package name */
    public String f397455e;

    public b() {
        a();
    }

    public b a() {
        this.f397451a = 0L;
        this.f397452b = WireFormatNano.EMPTY_BYTES;
        this.f397453c = null;
        this.f397454d = 0L;
        this.f397455e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f397455e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f397454d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            if (this.f397453c == null) {
                                this.f397453c = new a();
                            }
                            codedInputByteBufferNano.readMessage(this.f397453c);
                        }
                    } else {
                        this.f397452b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f397451a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f397451a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f397452b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f397452b);
        }
        a aVar = this.f397453c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        long j16 = this.f397454d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.f397455e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f397455e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f397451a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f397452b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f397452b);
        }
        a aVar = this.f397453c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        long j16 = this.f397454d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.f397455e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f397455e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
