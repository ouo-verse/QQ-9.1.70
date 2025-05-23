package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public aa f400778a;

    /* renamed from: b, reason: collision with root package name */
    public av f400779b;

    /* renamed from: c, reason: collision with root package name */
    public ae f400780c;

    public j() {
        a();
    }

    public j a() {
        this.f400778a = null;
        this.f400779b = null;
        this.f400780c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            if (this.f400780c == null) {
                                this.f400780c = new ae();
                            }
                            codedInputByteBufferNano.readMessage(this.f400780c);
                        }
                    } else {
                        if (this.f400779b == null) {
                            this.f400779b = new av();
                        }
                        codedInputByteBufferNano.readMessage(this.f400779b);
                    }
                } else {
                    if (this.f400778a == null) {
                        this.f400778a = new aa();
                    }
                    codedInputByteBufferNano.readMessage(this.f400778a);
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
        aa aaVar = this.f400778a;
        if (aaVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aaVar);
        }
        av avVar = this.f400779b;
        if (avVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, avVar);
        }
        ae aeVar = this.f400780c;
        if (aeVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, aeVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        aa aaVar = this.f400778a;
        if (aaVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aaVar);
        }
        av avVar = this.f400779b;
        if (avVar != null) {
            codedOutputByteBufferNano.writeMessage(2, avVar);
        }
        ae aeVar = this.f400780c;
        if (aeVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aeVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
