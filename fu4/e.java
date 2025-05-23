package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f400767a;

    /* renamed from: b, reason: collision with root package name */
    public String f400768b;

    /* renamed from: c, reason: collision with root package name */
    public String f400769c;

    public e() {
        a();
    }

    public e a() {
        this.f400767a = "";
        this.f400768b = "";
        this.f400769c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f400769c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f400768b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f400767a = codedInputByteBufferNano.readString();
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
        if (!this.f400767a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400767a);
        }
        if (!this.f400768b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400768b);
        }
        if (!this.f400769c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400769c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400767a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400767a);
        }
        if (!this.f400768b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400768b);
        }
        if (!this.f400769c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400769c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
