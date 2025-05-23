package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f406129a;

    /* renamed from: b, reason: collision with root package name */
    public u f406130b;

    /* renamed from: c, reason: collision with root package name */
    public String f406131c;

    public c() {
        a();
    }

    public c a() {
        this.f406129a = "";
        this.f406130b = null;
        this.f406131c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f406129a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f406130b == null) {
                    this.f406130b = new u();
                }
                codedInputByteBufferNano.readMessage(this.f406130b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406131c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f406129a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f406129a);
        }
        u uVar = this.f406130b;
        if (uVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, uVar);
        }
        return !this.f406131c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f406131c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f406129a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f406129a);
        }
        u uVar = this.f406130b;
        if (uVar != null) {
            codedOutputByteBufferNano.writeMessage(2, uVar);
        }
        if (!this.f406131c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406131c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
