package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ac extends ExtendableMessageNano<ac> {

    /* renamed from: a, reason: collision with root package name */
    public String f400657a;

    /* renamed from: b, reason: collision with root package name */
    public String f400658b;

    /* renamed from: c, reason: collision with root package name */
    public String f400659c;

    public ac() {
        a();
    }

    public ac a() {
        this.f400657a = "";
        this.f400658b = "";
        this.f400659c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ac mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f400659c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f400658b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f400657a = codedInputByteBufferNano.readString();
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
        if (!this.f400657a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400657a);
        }
        if (!this.f400658b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400658b);
        }
        if (!this.f400659c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400659c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400657a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400657a);
        }
        if (!this.f400658b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400658b);
        }
        if (!this.f400659c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400659c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
