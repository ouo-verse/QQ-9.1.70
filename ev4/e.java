package ev4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: n, reason: collision with root package name */
    private static volatile e[] f397218n;

    /* renamed from: a, reason: collision with root package name */
    public int f397219a;

    /* renamed from: b, reason: collision with root package name */
    public int f397220b;

    /* renamed from: c, reason: collision with root package name */
    public String f397221c;

    /* renamed from: d, reason: collision with root package name */
    public String f397222d;

    /* renamed from: e, reason: collision with root package name */
    public String f397223e;

    /* renamed from: f, reason: collision with root package name */
    public String f397224f;

    /* renamed from: g, reason: collision with root package name */
    public int f397225g;

    /* renamed from: h, reason: collision with root package name */
    public String f397226h;

    /* renamed from: i, reason: collision with root package name */
    public String f397227i;

    /* renamed from: j, reason: collision with root package name */
    public String f397228j;

    /* renamed from: k, reason: collision with root package name */
    public int f397229k;

    /* renamed from: l, reason: collision with root package name */
    public String f397230l;

    /* renamed from: m, reason: collision with root package name */
    public f[] f397231m;

    public e() {
        a();
    }

    public static e[] b() {
        if (f397218n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397218n == null) {
                    f397218n = new e[0];
                }
            }
        }
        return f397218n;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f397219a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f397220b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f397221c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f397222d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f397223e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f397224f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f397225g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f397226h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f397227i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f397228j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f397229k = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.f397230l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    f[] fVarArr = this.f397231m;
                    int length = fVarArr == null ? 0 : fVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    f[] fVarArr2 = new f[i3];
                    if (length != 0) {
                        System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        f fVar = new f();
                        fVarArr2[length] = fVar;
                        codedInputByteBufferNano.readMessage(fVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    f fVar2 = new f();
                    fVarArr2[length] = fVar2;
                    codedInputByteBufferNano.readMessage(fVar2);
                    this.f397231m = fVarArr2;
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
        int i3 = this.f397219a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f397220b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f397221c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f397221c);
        }
        if (!this.f397222d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f397222d);
        }
        if (!this.f397223e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f397223e);
        }
        if (!this.f397224f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f397224f);
        }
        int i17 = this.f397225g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        if (!this.f397226h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f397226h);
        }
        if (!this.f397227i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f397227i);
        }
        if (!this.f397228j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f397228j);
        }
        int i18 = this.f397229k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        if (!this.f397230l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f397230l);
        }
        f[] fVarArr = this.f397231m;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f397231m;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, fVar);
                }
                i19++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f397219a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f397220b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f397221c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f397221c);
        }
        if (!this.f397222d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f397222d);
        }
        if (!this.f397223e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f397223e);
        }
        if (!this.f397224f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f397224f);
        }
        int i17 = this.f397225g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        if (!this.f397226h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f397226h);
        }
        if (!this.f397227i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f397227i);
        }
        if (!this.f397228j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f397228j);
        }
        int i18 = this.f397229k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        if (!this.f397230l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f397230l);
        }
        f[] fVarArr = this.f397231m;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f397231m;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(13, fVar);
                }
                i19++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f397219a = 0;
        this.f397220b = 0;
        this.f397221c = "";
        this.f397222d = "";
        this.f397223e = "";
        this.f397224f = "";
        this.f397225g = 0;
        this.f397226h = "";
        this.f397227i = "";
        this.f397228j = "";
        this.f397229k = 0;
        this.f397230l = "";
        this.f397231m = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
