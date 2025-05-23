package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f425408a;

    /* renamed from: b, reason: collision with root package name */
    public String f425409b;

    /* renamed from: c, reason: collision with root package name */
    public d f425410c;

    public j() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f425408a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f425409b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f425410c == null) {
                    this.f425410c = new d();
                }
                codedInputByteBufferNano.readMessage(this.f425410c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f425408a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f425409b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f425409b);
        }
        d dVar = this.f425410c;
        return dVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, dVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f425408a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f425409b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f425409b);
        }
        d dVar = this.f425410c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f425408a = 0;
        this.f425409b = "";
        this.f425410c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
