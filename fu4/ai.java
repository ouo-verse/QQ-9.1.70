package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ai extends ExtendableMessageNano<ai> {

    /* renamed from: a, reason: collision with root package name */
    public f f400688a;

    /* renamed from: b, reason: collision with root package name */
    public am f400689b;

    /* renamed from: c, reason: collision with root package name */
    public d f400690c;

    public ai() {
        a();
    }

    public ai a() {
        this.f400688a = null;
        this.f400689b = null;
        this.f400690c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ai mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            if (this.f400690c == null) {
                                this.f400690c = new d();
                            }
                            codedInputByteBufferNano.readMessage(this.f400690c);
                        }
                    } else {
                        if (this.f400689b == null) {
                            this.f400689b = new am();
                        }
                        codedInputByteBufferNano.readMessage(this.f400689b);
                    }
                } else {
                    if (this.f400688a == null) {
                        this.f400688a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f400688a);
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
        f fVar = this.f400688a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        am amVar = this.f400689b;
        if (amVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, amVar);
        }
        d dVar = this.f400690c;
        if (dVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f400688a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        am amVar = this.f400689b;
        if (amVar != null) {
            codedOutputByteBufferNano.writeMessage(2, amVar);
        }
        d dVar = this.f400690c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
