package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class m extends ExtendableMessageNano<m> {

    /* renamed from: a, reason: collision with root package name */
    public int f424176a;

    /* renamed from: b, reason: collision with root package name */
    public String f424177b;

    /* renamed from: c, reason: collision with root package name */
    public String f424178c;

    /* renamed from: d, reason: collision with root package name */
    public String f424179d;

    /* renamed from: e, reason: collision with root package name */
    public String f424180e;

    /* renamed from: f, reason: collision with root package name */
    public String f424181f;

    public m() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public m mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f424176a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f424177b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f424178c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f424179d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f424180e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424181f = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f424176a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f424177b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424177b);
        }
        if (!this.f424178c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424178c);
        }
        if (!this.f424179d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f424179d);
        }
        if (!this.f424180e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f424180e);
        }
        return !this.f424181f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f424181f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424176a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f424177b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424177b);
        }
        if (!this.f424178c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424178c);
        }
        if (!this.f424179d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f424179d);
        }
        if (!this.f424180e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424180e);
        }
        if (!this.f424181f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f424181f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public m a() {
        this.f424176a = 0;
        this.f424177b = "";
        this.f424178c = "";
        this.f424179d = "";
        this.f424180e = "";
        this.f424181f = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
