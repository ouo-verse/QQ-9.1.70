package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public String f400529a;

    /* renamed from: b, reason: collision with root package name */
    public String f400530b;

    public j() {
        a();
    }

    public j a() {
        this.f400529a = "";
        this.f400530b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400529a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400530b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400529a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400529a);
        }
        return !this.f400530b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f400530b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400529a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400529a);
        }
        if (!this.f400530b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400530b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
