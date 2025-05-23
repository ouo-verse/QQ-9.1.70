package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public hs4.r f400525a;

    /* renamed from: b, reason: collision with root package name */
    public u f400526b;

    /* renamed from: c, reason: collision with root package name */
    public long f400527c;

    /* renamed from: d, reason: collision with root package name */
    public hs4.s f400528d;

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
                if (this.f400525a == null) {
                    this.f400525a = new hs4.r();
                }
                codedInputByteBufferNano.readMessage(this.f400525a);
            } else if (readTag == 18) {
                if (this.f400526b == null) {
                    this.f400526b = new u();
                }
                codedInputByteBufferNano.readMessage(this.f400526b);
            } else if (readTag == 24) {
                this.f400527c = codedInputByteBufferNano.readInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f400528d == null) {
                    this.f400528d = new hs4.s();
                }
                codedInputByteBufferNano.readMessage(this.f400528d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        hs4.r rVar = this.f400525a;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rVar);
        }
        u uVar = this.f400526b;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar);
        }
        long j3 = this.f400527c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        hs4.s sVar = this.f400528d;
        return sVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, sVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        hs4.r rVar = this.f400525a;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(1, rVar);
        }
        u uVar = this.f400526b;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar);
        }
        long j3 = this.f400527c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        hs4.s sVar = this.f400528d;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(4, sVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public i a() {
        this.f400525a = null;
        this.f400526b = null;
        this.f400527c = 0L;
        this.f400528d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
