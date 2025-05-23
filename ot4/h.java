package ot4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f424057a;

    /* renamed from: b, reason: collision with root package name */
    public String f424058b;

    /* renamed from: c, reason: collision with root package name */
    public String f424059c;

    public h() {
        a();
    }

    public h a() {
        this.f424057a = "";
        this.f424058b = "";
        this.f424059c = "";
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
                this.f424057a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f424058b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424059c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424057a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424057a);
        }
        if (!this.f424058b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424058b);
        }
        return !this.f424059c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f424059c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424057a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424057a);
        }
        if (!this.f424058b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424058b);
        }
        if (!this.f424059c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424059c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
