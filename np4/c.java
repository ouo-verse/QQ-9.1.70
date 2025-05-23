package np4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public b f420673a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f420674b;

    /* renamed from: c, reason: collision with root package name */
    public d f420675c;

    /* renamed from: d, reason: collision with root package name */
    public a f420676d;

    public c() {
        a();
    }

    public c a() {
        this.f420673a = null;
        this.f420674b = WireFormatNano.EMPTY_BYTES;
        this.f420675c = null;
        this.f420676d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f420676d == null) {
                                    this.f420676d = new a();
                                }
                                codedInputByteBufferNano.readMessage(this.f420676d);
                            }
                        } else {
                            if (this.f420675c == null) {
                                this.f420675c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f420675c);
                        }
                    } else {
                        this.f420674b = codedInputByteBufferNano.readBytes();
                    }
                } else {
                    if (this.f420673a == null) {
                        this.f420673a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f420673a);
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
        b bVar = this.f420673a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        if (!Arrays.equals(this.f420674b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f420674b);
        }
        d dVar = this.f420675c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        a aVar = this.f420676d;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f420673a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        if (!Arrays.equals(this.f420674b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f420674b);
        }
        d dVar = this.f420675c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        a aVar = this.f420676d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
