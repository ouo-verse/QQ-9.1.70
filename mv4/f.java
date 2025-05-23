package mv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import dv4.r;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public dv4.j f417677a;

    /* renamed from: b, reason: collision with root package name */
    public r f417678b;

    public f() {
        a();
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
                if (this.f417677a == null) {
                    this.f417677a = new dv4.j();
                }
                codedInputByteBufferNano.readMessage(this.f417677a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f417678b == null) {
                    this.f417678b = new r();
                }
                codedInputByteBufferNano.readMessage(this.f417678b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        dv4.j jVar = this.f417677a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        r rVar = this.f417678b;
        return rVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, rVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        dv4.j jVar = this.f417677a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        r rVar = this.f417678b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f417677a = null;
        this.f417678b = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
