package mv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public int f417669a;

    /* renamed from: b, reason: collision with root package name */
    public String f417670b;

    /* renamed from: c, reason: collision with root package name */
    public cv4.a f417671c;

    public a() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f417669a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f417670b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f417671c == null) {
                    this.f417671c = new cv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f417671c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f417669a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f417670b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417670b);
        }
        cv4.a aVar = this.f417671c;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417669a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f417670b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417670b);
        }
        cv4.a aVar = this.f417671c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f417669a = 0;
        this.f417670b = "";
        this.f417671c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
