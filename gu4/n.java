package gu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public String f403405a;

    /* renamed from: b, reason: collision with root package name */
    public String f403406b;

    /* renamed from: c, reason: collision with root package name */
    public String f403407c;

    public n() {
        a();
    }

    public n a() {
        this.f403405a = "";
        this.f403406b = "";
        this.f403407c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f403407c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f403406b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403405a = codedInputByteBufferNano.readString();
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
        if (!this.f403405a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403405a);
        }
        if (!this.f403406b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403406b);
        }
        if (!this.f403407c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f403407c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403405a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403405a);
        }
        if (!this.f403406b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403406b);
        }
        if (!this.f403407c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403407c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
