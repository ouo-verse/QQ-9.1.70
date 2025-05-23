package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public String f394956a;

    /* renamed from: b, reason: collision with root package name */
    public String f394957b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f394958c;

    /* renamed from: d, reason: collision with root package name */
    public int f394959d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f394960e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f394961f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f394962g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f394963h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f394964i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f394965j;

    /* renamed from: k, reason: collision with root package name */
    public c[] f394966k;

    /* renamed from: l, reason: collision with root package name */
    public String f394967l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f394968m;

    public d() {
        a();
    }

    public d a() {
        this.f394956a = "";
        this.f394957b = "";
        this.f394958c = f.b();
        this.f394959d = 0;
        this.f394960e = WireFormatNano.EMPTY_INT_ARRAY;
        this.f394961f = false;
        this.f394962g = false;
        this.f394963h = false;
        this.f394964i = false;
        this.f394965j = false;
        this.f394966k = c.b();
        this.f394967l = "";
        this.f394968m = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f394956a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f394957b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    f[] fVarArr = this.f394958c;
                    if (fVarArr == null) {
                        length = 0;
                    } else {
                        length = fVarArr.length;
                    }
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
                    this.f394958c = fVarArr2;
                    break;
                case 32:
                    this.f394959d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                    int[] iArr = this.f394960e;
                    if (iArr == null) {
                        length2 = 0;
                    } else {
                        length2 = iArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    int[] iArr2 = new int[i16];
                    if (length2 != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readInt32();
                    this.f394960e = iArr2;
                    break;
                case 42:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i17 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readInt32();
                        i17++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f394960e;
                    if (iArr3 == null) {
                        length3 = 0;
                    } else {
                        length3 = iArr3.length;
                    }
                    int i18 = i17 + length3;
                    int[] iArr4 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length3);
                    }
                    while (length3 < i18) {
                        iArr4[length3] = codedInputByteBufferNano.readInt32();
                        length3++;
                    }
                    this.f394960e = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 48:
                    this.f394961f = codedInputByteBufferNano.readBool();
                    break;
                case 56:
                    this.f394962g = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    this.f394963h = codedInputByteBufferNano.readBool();
                    break;
                case 72:
                    this.f394964i = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.f394965j = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    c[] cVarArr = this.f394966k;
                    if (cVarArr == null) {
                        length4 = 0;
                    } else {
                        length4 = cVarArr.length;
                    }
                    int i19 = repeatedFieldArrayLength3 + length4;
                    c[] cVarArr2 = new c[i19];
                    if (length4 != 0) {
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length4);
                    }
                    while (length4 < i19 - 1) {
                        c cVar = new c();
                        cVarArr2[length4] = cVar;
                        codedInputByteBufferNano.readMessage(cVar);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    c cVar2 = new c();
                    cVarArr2[length4] = cVar2;
                    codedInputByteBufferNano.readMessage(cVar2);
                    this.f394966k = cVarArr2;
                    break;
                case 98:
                    this.f394967l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.f394968m = codedInputByteBufferNano.readBool();
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
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f394956a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394956a);
        }
        if (!this.f394957b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f394957b);
        }
        f[] fVarArr = this.f394958c;
        int i3 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                f[] fVarArr2 = this.f394958c;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i16++;
            }
        }
        int i17 = this.f394959d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        int[] iArr2 = this.f394960e;
        if (iArr2 != null && iArr2.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.f394960e;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        boolean z16 = this.f394961f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        boolean z17 = this.f394962g;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z17);
        }
        boolean z18 = this.f394963h;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z18);
        }
        boolean z19 = this.f394964i;
        if (z19) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z19);
        }
        boolean z26 = this.f394965j;
        if (z26) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z26);
        }
        c[] cVarArr = this.f394966k;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f394966k;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, cVar);
                }
                i3++;
            }
        }
        if (!this.f394967l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f394967l);
        }
        boolean z27 = this.f394968m;
        if (z27) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, z27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394956a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394956a);
        }
        if (!this.f394957b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f394957b);
        }
        f[] fVarArr = this.f394958c;
        int i3 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                f[] fVarArr2 = this.f394958c;
                if (i16 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i16];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i16++;
            }
        }
        int i17 = this.f394959d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        int[] iArr = this.f394960e;
        if (iArr != null && iArr.length > 0) {
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.f394960e;
                if (i18 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(5, iArr2[i18]);
                i18++;
            }
        }
        boolean z16 = this.f394961f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        boolean z17 = this.f394962g;
        if (z17) {
            codedOutputByteBufferNano.writeBool(7, z17);
        }
        boolean z18 = this.f394963h;
        if (z18) {
            codedOutputByteBufferNano.writeBool(8, z18);
        }
        boolean z19 = this.f394964i;
        if (z19) {
            codedOutputByteBufferNano.writeBool(9, z19);
        }
        boolean z26 = this.f394965j;
        if (z26) {
            codedOutputByteBufferNano.writeBool(10, z26);
        }
        c[] cVarArr = this.f394966k;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f394966k;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, cVar);
                }
                i3++;
            }
        }
        if (!this.f394967l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f394967l);
        }
        boolean z27 = this.f394968m;
        if (z27) {
            codedOutputByteBufferNano.writeBool(13, z27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
