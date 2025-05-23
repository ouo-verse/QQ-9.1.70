package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class al extends ExtendableMessageNano<al> {

    /* renamed from: a, reason: collision with root package name */
    public f f400705a;

    /* renamed from: b, reason: collision with root package name */
    public int f400706b;

    /* renamed from: c, reason: collision with root package name */
    public String f400707c;

    public al() {
        a();
    }

    public al a() {
        this.f400705a = null;
        this.f400706b = 0;
        this.f400707c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public al mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f400707c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f400706b = codedInputByteBufferNano.readInt32();
                    }
                } else {
                    if (this.f400705a == null) {
                        this.f400705a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f400705a);
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
        f fVar = this.f400705a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        int i3 = this.f400706b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f400707c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400707c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f400705a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        int i3 = this.f400706b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f400707c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400707c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
