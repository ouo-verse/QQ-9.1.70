package m55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f416287a;

    /* renamed from: b, reason: collision with root package name */
    public String f416288b;

    /* renamed from: c, reason: collision with root package name */
    public String f416289c;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f416287a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f416288b = codedInputByteBufferNano.readString();
            } else if (readTag != 82) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f416289c = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f416287a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f416288b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f416288b);
        }
        return !this.f416289c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f416289c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f416287a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f416288b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f416288b);
        }
        if (!this.f416289c.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f416289c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f416287a = 0;
        this.f416288b = "";
        this.f416289c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
