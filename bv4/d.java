package bv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f29271a;

    /* renamed from: b, reason: collision with root package name */
    public String f29272b;

    /* renamed from: c, reason: collision with root package name */
    public String f29273c;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f29271a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f29272b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f29273c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f29271a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f29272b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f29272b);
        }
        return !this.f29273c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f29273c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f29271a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f29272b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f29272b);
        }
        if (!this.f29273c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f29273c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f29271a = 0L;
        this.f29272b = "";
        this.f29273c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
