package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public String f406219a;

    /* renamed from: b, reason: collision with root package name */
    public String f406220b;

    public u() {
        a();
    }

    public u a() {
        this.f406219a = "";
        this.f406220b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406219a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406220b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406219a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406219a);
        }
        return !this.f406220b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f406220b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406219a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406219a);
        }
        if (!this.f406220b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406220b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
