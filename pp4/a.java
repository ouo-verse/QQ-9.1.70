package pp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f426961a;

    /* renamed from: b, reason: collision with root package name */
    public String f426962b;

    /* renamed from: c, reason: collision with root package name */
    public String f426963c;

    public a() {
        a();
    }

    public a a() {
        this.f426961a = "";
        this.f426962b = "";
        this.f426963c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f426963c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f426962b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f426961a = codedInputByteBufferNano.readString();
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
        if (!this.f426961a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f426961a);
        }
        if (!this.f426962b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f426962b);
        }
        if (!this.f426963c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f426963c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f426961a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f426961a);
        }
        if (!this.f426962b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f426962b);
        }
        if (!this.f426963c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f426963c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
