package nt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f421270a;

    /* renamed from: b, reason: collision with root package name */
    public long f421271b;

    /* renamed from: c, reason: collision with root package name */
    public a f421272c;

    /* renamed from: d, reason: collision with root package name */
    public b f421273d;

    public c() {
        a();
    }

    public c a() {
        this.f421270a = "";
        this.f421271b = 0L;
        this.f421272c = null;
        this.f421273d = null;
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
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f421273d == null) {
                                    this.f421273d = new b();
                                }
                                codedInputByteBufferNano.readMessage(this.f421273d);
                            }
                        } else {
                            if (this.f421272c == null) {
                                this.f421272c = new a();
                            }
                            codedInputByteBufferNano.readMessage(this.f421272c);
                        }
                    } else {
                        this.f421271b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f421270a = codedInputByteBufferNano.readString();
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
        if (!this.f421270a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f421270a);
        }
        long j3 = this.f421271b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        a aVar = this.f421272c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        b bVar = this.f421273d;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f421270a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f421270a);
        }
        long j3 = this.f421271b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        a aVar = this.f421272c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        b bVar = this.f421273d;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
