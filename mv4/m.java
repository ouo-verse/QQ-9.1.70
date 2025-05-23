package mv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public cv4.f f417697a;

    /* renamed from: b, reason: collision with root package name */
    public cv4.a f417698b;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f417697a == null) {
                    this.f417697a = new cv4.f();
                }
                codedInputByteBufferNano.readMessage(this.f417697a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f417698b == null) {
                    this.f417698b = new cv4.a();
                }
                codedInputByteBufferNano.readMessage(this.f417698b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        cv4.f fVar = this.f417697a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        cv4.a aVar = this.f417698b;
        return aVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, aVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        cv4.f fVar = this.f417697a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        cv4.a aVar = this.f417698b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f417697a = null;
        this.f417698b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
