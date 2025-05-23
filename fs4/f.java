package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f400517a;

    /* renamed from: b, reason: collision with root package name */
    public hs4.b f400518b;

    public f() {
        a();
    }

    public f a() {
        this.f400517a = "";
        this.f400518b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f400517a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f400518b == null) {
                    this.f400518b = new hs4.b();
                }
                codedInputByteBufferNano.readMessage(this.f400518b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400517a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400517a);
        }
        hs4.b bVar = this.f400518b;
        return bVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, bVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400517a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400517a);
        }
        hs4.b bVar = this.f400518b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
