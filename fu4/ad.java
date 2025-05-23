package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ad extends ExtendableMessageNano<ad> {

    /* renamed from: a, reason: collision with root package name */
    public String f400660a;

    /* renamed from: b, reason: collision with root package name */
    public ac f400661b;

    /* renamed from: c, reason: collision with root package name */
    public String f400662c;

    public ad() {
        a();
    }

    public ad a() {
        this.f400660a = "";
        this.f400661b = null;
        this.f400662c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ad mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f400662c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        if (this.f400661b == null) {
                            this.f400661b = new ac();
                        }
                        codedInputByteBufferNano.readMessage(this.f400661b);
                    }
                } else {
                    this.f400660a = codedInputByteBufferNano.readString();
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
        if (!this.f400660a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400660a);
        }
        ac acVar = this.f400661b;
        if (acVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, acVar);
        }
        if (!this.f400662c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400662c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400660a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400660a);
        }
        ac acVar = this.f400661b;
        if (acVar != null) {
            codedOutputByteBufferNano.writeMessage(2, acVar);
        }
        if (!this.f400662c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400662c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
