package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public iv4.e f415652a;

    /* renamed from: b, reason: collision with root package name */
    public kv4.a f415653b;

    /* renamed from: c, reason: collision with root package name */
    public long f415654c;

    /* renamed from: d, reason: collision with root package name */
    public long f415655d;

    public i() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f415652a == null) {
                    this.f415652a = new iv4.e();
                }
                codedInputByteBufferNano.readMessage(this.f415652a);
            } else if (readTag == 18) {
                if (this.f415653b == null) {
                    this.f415653b = new kv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f415653b);
            } else if (readTag == 24) {
                this.f415654c = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415655d = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        iv4.e eVar = this.f415652a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        kv4.a aVar = this.f415653b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        long j3 = this.f415654c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j16 = this.f415655d;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        iv4.e eVar = this.f415652a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        kv4.a aVar = this.f415653b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        long j3 = this.f415654c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j16 = this.f415655d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f415652a = null;
        this.f415653b = null;
        this.f415654c = 0L;
        this.f415655d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
