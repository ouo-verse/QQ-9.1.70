package cv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f391920a;

    /* renamed from: b, reason: collision with root package name */
    public String f391921b;

    /* renamed from: c, reason: collision with root package name */
    public String f391922c;

    /* renamed from: d, reason: collision with root package name */
    public String f391923d;

    /* renamed from: e, reason: collision with root package name */
    public int f391924e;

    public c() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f391920a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f391921b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f391922c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f391923d = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f391924e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f391920a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f391921b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391921b);
        }
        if (!this.f391922c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391922c);
        }
        if (!this.f391923d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391923d);
        }
        int i16 = this.f391924e;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f391920a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f391921b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391921b);
        }
        if (!this.f391922c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391922c);
        }
        if (!this.f391923d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391923d);
        }
        int i16 = this.f391924e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public c a() {
        this.f391920a = 0;
        this.f391921b = "";
        this.f391922c = "";
        this.f391923d = "";
        this.f391924e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
