package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: a, reason: collision with root package name */
    public int f400550a;

    /* renamed from: b, reason: collision with root package name */
    public String f400551b;

    /* renamed from: c, reason: collision with root package name */
    public String f400552c;

    /* renamed from: d, reason: collision with root package name */
    public p f400553d;

    /* renamed from: e, reason: collision with root package name */
    public String f400554e;

    public o() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400550a = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                this.f400551b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f400552c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.f400553d == null) {
                    this.f400553d = new p();
                }
                codedInputByteBufferNano.readMessage(this.f400553d);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400554e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f400550a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f400551b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400551b);
        }
        if (!this.f400552c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400552c);
        }
        p pVar = this.f400553d;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, pVar);
        }
        return !this.f400554e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f400554e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400550a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f400551b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400551b);
        }
        if (!this.f400552c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400552c);
        }
        p pVar = this.f400553d;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(4, pVar);
        }
        if (!this.f400554e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400554e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f400550a = 0;
        this.f400551b = "";
        this.f400552c = "";
        this.f400553d = null;
        this.f400554e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
