package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f394991a;

    /* renamed from: b, reason: collision with root package name */
    public String f394992b;

    /* renamed from: c, reason: collision with root package name */
    public String f394993c;

    public j() {
        a();
    }

    public j a() {
        this.f394991a = 0;
        this.f394992b = "";
        this.f394993c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f394993c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f394992b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f394991a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f394991a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f394992b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394992b);
        }
        if (!this.f394993c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f394993c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f394991a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f394992b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394992b);
        }
        if (!this.f394993c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f394993c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
