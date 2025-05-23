package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class p extends ExtendableMessageNano<p> {

    /* renamed from: a, reason: collision with root package name */
    public j f395047a;

    /* renamed from: b, reason: collision with root package name */
    public String f395048b;

    public p() {
        a();
    }

    public static p c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (p) MessageNano.mergeFrom(new p(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f395047a == null) {
                    this.f395047a = new j();
                }
                codedInputByteBufferNano.readMessage(this.f395047a);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395048b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        j jVar = this.f395047a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        return !this.f395048b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f395048b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f395047a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        if (!this.f395048b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f395048b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public p a() {
        this.f395047a = null;
        this.f395048b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
