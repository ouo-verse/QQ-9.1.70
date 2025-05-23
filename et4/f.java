package et4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f397124a;

    /* renamed from: b, reason: collision with root package name */
    public String f397125b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f397126c;

    /* renamed from: d, reason: collision with root package name */
    public int f397127d;

    public f() {
        a();
    }

    public f a() {
        this.f397124a = "";
        this.f397125b = "";
        this.f397126c = false;
        this.f397127d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f397124a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f397125b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f397126c = codedInputByteBufferNano.readBool();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397127d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f397124a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f397124a);
        }
        if (!this.f397125b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f397125b);
        }
        boolean z16 = this.f397126c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i3 = this.f397127d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f397124a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f397124a);
        }
        if (!this.f397125b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f397125b);
        }
        boolean z16 = this.f397126c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i3 = this.f397127d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
