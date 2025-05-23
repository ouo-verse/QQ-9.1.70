package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String f424145a;

    /* renamed from: b, reason: collision with root package name */
    public String f424146b;

    /* renamed from: c, reason: collision with root package name */
    public String f424147c;

    /* renamed from: d, reason: collision with root package name */
    public n[] f424148d;

    /* renamed from: e, reason: collision with root package name */
    public String f424149e;

    /* renamed from: f, reason: collision with root package name */
    public int f424150f;

    /* renamed from: g, reason: collision with root package name */
    public int f424151g;

    /* renamed from: h, reason: collision with root package name */
    public String f424152h;

    /* renamed from: i, reason: collision with root package name */
    public int f424153i;

    /* renamed from: j, reason: collision with root package name */
    public String f424154j;

    /* renamed from: k, reason: collision with root package name */
    public String f424155k;

    public e() {
        a();
    }

    public e a() {
        this.f424145a = "";
        this.f424146b = "";
        this.f424147c = "";
        this.f424148d = n.b();
        this.f424149e = "";
        this.f424150f = 0;
        this.f424151g = 0;
        this.f424152h = "";
        this.f424153i = 0;
        this.f424154j = "";
        this.f424155k = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f424145a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f424146b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f424147c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    n[] nVarArr = this.f424148d;
                    int length = nVarArr == null ? 0 : nVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    n[] nVarArr2 = new n[i3];
                    if (length != 0) {
                        System.arraycopy(nVarArr, 0, nVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        n nVar = new n();
                        nVarArr2[length] = nVar;
                        codedInputByteBufferNano.readMessage(nVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    n nVar2 = new n();
                    nVarArr2[length] = nVar2;
                    codedInputByteBufferNano.readMessage(nVar2);
                    this.f424148d = nVarArr2;
                    break;
                case 42:
                    this.f424149e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f424150f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.f424151g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f424152h = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f424153i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f424154j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f424155k = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424145a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424145a);
        }
        if (!this.f424146b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424146b);
        }
        if (!this.f424147c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424147c);
        }
        n[] nVarArr = this.f424148d;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f424148d;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, nVar);
                }
                i3++;
            }
        }
        if (!this.f424149e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f424149e);
        }
        int i16 = this.f424150f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f424151g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        if (!this.f424152h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f424152h);
        }
        int i18 = this.f424153i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        if (!this.f424154j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f424154j);
        }
        return !this.f424155k.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f424155k) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424145a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424145a);
        }
        if (!this.f424146b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424146b);
        }
        if (!this.f424147c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424147c);
        }
        n[] nVarArr = this.f424148d;
        if (nVarArr != null && nVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n[] nVarArr2 = this.f424148d;
                if (i3 >= nVarArr2.length) {
                    break;
                }
                n nVar = nVarArr2[i3];
                if (nVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, nVar);
                }
                i3++;
            }
        }
        if (!this.f424149e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424149e);
        }
        int i16 = this.f424150f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f424151g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        if (!this.f424152h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f424152h);
        }
        int i18 = this.f424153i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        if (!this.f424154j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f424154j);
        }
        if (!this.f424155k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f424155k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
