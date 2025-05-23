package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f413107a;

    /* renamed from: b, reason: collision with root package name */
    public String f413108b;

    /* renamed from: c, reason: collision with root package name */
    public int f413109c;

    public h() {
        a();
    }

    public h a() {
        this.f413107a = "";
        this.f413108b = "";
        this.f413109c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f413107a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f413108b = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f413109c = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.f413107a) + CodedOutputByteBufferNano.computeStringSize(2, this.f413108b) + CodedOutputByteBufferNano.computeUInt32Size(3, this.f413109c);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f413107a);
        codedOutputByteBufferNano.writeString(2, this.f413108b);
        codedOutputByteBufferNano.writeUInt32(3, this.f413109c);
        super.writeTo(codedOutputByteBufferNano);
    }
}
