package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class r extends ExtendableMessageNano<r> {

    /* renamed from: a, reason: collision with root package name */
    public ab f400799a;

    /* renamed from: b, reason: collision with root package name */
    public aw f400800b;

    /* renamed from: c, reason: collision with root package name */
    public af f400801c;

    /* renamed from: d, reason: collision with root package name */
    public int f400802d;

    public r() {
        a();
    }

    public r a() {
        this.f400799a = null;
        this.f400800b = null;
        this.f400801c = null;
        this.f400802d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public r mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 80) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                                    this.f400802d = readInt32;
                                }
                            }
                        } else {
                            if (this.f400801c == null) {
                                this.f400801c = new af();
                            }
                            codedInputByteBufferNano.readMessage(this.f400801c);
                        }
                    } else {
                        if (this.f400800b == null) {
                            this.f400800b = new aw();
                        }
                        codedInputByteBufferNano.readMessage(this.f400800b);
                    }
                } else {
                    if (this.f400799a == null) {
                        this.f400799a = new ab();
                    }
                    codedInputByteBufferNano.readMessage(this.f400799a);
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
        ab abVar = this.f400799a;
        if (abVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, abVar);
        }
        aw awVar = this.f400800b;
        if (awVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, awVar);
        }
        af afVar = this.f400801c;
        if (afVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, afVar);
        }
        int i3 = this.f400802d;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ab abVar = this.f400799a;
        if (abVar != null) {
            codedOutputByteBufferNano.writeMessage(1, abVar);
        }
        aw awVar = this.f400800b;
        if (awVar != null) {
            codedOutputByteBufferNano.writeMessage(2, awVar);
        }
        af afVar = this.f400801c;
        if (afVar != null) {
            codedOutputByteBufferNano.writeMessage(3, afVar);
        }
        int i3 = this.f400802d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
