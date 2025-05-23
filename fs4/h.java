package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public i f400522a;

    /* renamed from: b, reason: collision with root package name */
    public g f400523b;

    /* renamed from: c, reason: collision with root package name */
    public String f400524c;

    public h() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f400522a == null) {
                    this.f400522a = new i();
                }
                codedInputByteBufferNano.readMessage(this.f400522a);
            } else if (readTag == 18) {
                if (this.f400523b == null) {
                    this.f400523b = new g();
                }
                codedInputByteBufferNano.readMessage(this.f400523b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f400524c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        i iVar = this.f400522a;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, iVar);
        }
        g gVar = this.f400523b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        return !this.f400524c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400524c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        i iVar = this.f400522a;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(1, iVar);
        }
        g gVar = this.f400523b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        if (!this.f400524c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400524c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f400522a = null;
        this.f400523b = null;
        this.f400524c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
