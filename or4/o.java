package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public String f423526a;

    /* renamed from: b, reason: collision with root package name */
    public e f423527b;

    public o() {
        a();
    }

    public o a() {
        this.f423526a = "";
        this.f423527b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f423527b == null) {
                            this.f423527b = new e();
                        }
                        codedInputByteBufferNano.readMessage(this.f423527b);
                    }
                } else {
                    this.f423526a = codedInputByteBufferNano.readString();
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
        if (!this.f423526a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423526a);
        }
        e eVar = this.f423527b;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423526a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423526a);
        }
        e eVar = this.f423527b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
