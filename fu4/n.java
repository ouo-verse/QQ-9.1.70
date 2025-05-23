package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public v f400791a;

    /* renamed from: b, reason: collision with root package name */
    public j f400792b;

    public n() {
        a();
    }

    public n a() {
        this.f400791a = null;
        this.f400792b = null;
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
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        if (this.f400792b == null) {
                            this.f400792b = new j();
                        }
                        codedInputByteBufferNano.readMessage(this.f400792b);
                    }
                } else {
                    if (this.f400791a == null) {
                        this.f400791a = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f400791a);
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
        v vVar = this.f400791a;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vVar);
        }
        j jVar = this.f400792b;
        if (jVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, jVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v vVar = this.f400791a;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(1, vVar);
        }
        j jVar = this.f400792b;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(2, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
