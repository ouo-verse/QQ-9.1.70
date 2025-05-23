package jp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public long f410795a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f410796b;

    /* renamed from: c, reason: collision with root package name */
    public a f410797c;

    /* renamed from: d, reason: collision with root package name */
    public long f410798d;

    /* renamed from: e, reason: collision with root package name */
    public String f410799e;

    public b() {
        a();
    }

    public b a() {
        this.f410795a = 0L;
        this.f410796b = WireFormatNano.EMPTY_BYTES;
        this.f410797c = null;
        this.f410798d = 0L;
        this.f410799e = "";
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
                                    this.f410799e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f410798d = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            if (this.f410797c == null) {
                                this.f410797c = new a();
                            }
                            codedInputByteBufferNano.readMessage(this.f410797c);
                        }
                    } else {
                        this.f410796b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    this.f410795a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f410795a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!Arrays.equals(this.f410796b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f410796b);
        }
        a aVar = this.f410797c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        long j16 = this.f410798d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.f410799e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f410799e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f410795a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!Arrays.equals(this.f410796b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f410796b);
        }
        a aVar = this.f410797c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        long j16 = this.f410798d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.f410799e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f410799e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
