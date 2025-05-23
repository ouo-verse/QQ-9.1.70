package ks4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f412954a;

    /* renamed from: b, reason: collision with root package name */
    public String f412955b;

    /* renamed from: c, reason: collision with root package name */
    public String f412956c;

    /* renamed from: d, reason: collision with root package name */
    public String f412957d;

    /* renamed from: e, reason: collision with root package name */
    public String f412958e;

    /* renamed from: f, reason: collision with root package name */
    public String f412959f;

    /* renamed from: g, reason: collision with root package name */
    public int f412960g;

    public c() {
        a();
    }

    public c a() {
        this.f412954a = "";
        this.f412955b = "";
        this.f412956c = "";
        this.f412957d = "";
        this.f412958e = "";
        this.f412959f = "";
        this.f412960g = 0;
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
                this.f412954a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f412955b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f412956c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f412957d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f412958e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f412959f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f412960g = readInt32;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f412954a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f412954a);
        }
        if (!this.f412955b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f412955b);
        }
        if (!this.f412956c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f412956c);
        }
        if (!this.f412957d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f412957d);
        }
        if (!this.f412958e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f412958e);
        }
        if (!this.f412959f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f412959f);
        }
        int i3 = this.f412960g;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f412954a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f412954a);
        }
        if (!this.f412955b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f412955b);
        }
        if (!this.f412956c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f412956c);
        }
        if (!this.f412957d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f412957d);
        }
        if (!this.f412958e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f412958e);
        }
        if (!this.f412959f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f412959f);
        }
        int i3 = this.f412960g;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
