package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f391780a;

    /* renamed from: b, reason: collision with root package name */
    public String f391781b;

    /* renamed from: c, reason: collision with root package name */
    public String f391782c;

    /* renamed from: d, reason: collision with root package name */
    public String f391783d;

    /* renamed from: e, reason: collision with root package name */
    public String f391784e;

    /* renamed from: f, reason: collision with root package name */
    public String f391785f;

    /* renamed from: g, reason: collision with root package name */
    public String f391786g;

    /* renamed from: h, reason: collision with root package name */
    public String f391787h;

    /* renamed from: i, reason: collision with root package name */
    public String f391788i;

    public k() {
        a();
    }

    public k a() {
        this.f391780a = false;
        this.f391781b = "";
        this.f391782c = "";
        this.f391783d = "";
        this.f391784e = "";
        this.f391785f = "";
        this.f391786g = "";
        this.f391787h = "";
        this.f391788i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (readTag != 66) {
                                                if (readTag != 74) {
                                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                        return this;
                                                    }
                                                } else {
                                                    this.f391788i = codedInputByteBufferNano.readString();
                                                }
                                            } else {
                                                this.f391787h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            this.f391786g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f391785f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f391784e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f391783d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f391782c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f391781b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f391780a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f391780a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f391781b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391781b);
        }
        if (!this.f391782c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391782c);
        }
        if (!this.f391783d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391783d);
        }
        if (!this.f391784e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f391784e);
        }
        if (!this.f391785f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f391785f);
        }
        if (!this.f391786g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f391786g);
        }
        if (!this.f391787h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f391787h);
        }
        if (!this.f391788i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f391788i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f391780a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f391781b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391781b);
        }
        if (!this.f391782c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391782c);
        }
        if (!this.f391783d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391783d);
        }
        if (!this.f391784e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391784e);
        }
        if (!this.f391785f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f391785f);
        }
        if (!this.f391786g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f391786g);
        }
        if (!this.f391787h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f391787h);
        }
        if (!this.f391788i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f391788i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
