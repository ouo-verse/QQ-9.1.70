package mv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import dv4.r;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public r f417679a;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f417679a == null) {
                    this.f417679a = new r();
                }
                codedInputByteBufferNano.readMessage(this.f417679a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        r rVar = this.f417679a;
        return rVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, rVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        r rVar = this.f417679a;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(1, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f417679a = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
