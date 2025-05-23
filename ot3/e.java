package ot3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f424029a;

    /* renamed from: b, reason: collision with root package name */
    public String f424030b;

    /* renamed from: c, reason: collision with root package name */
    public f[] f424031c;

    /* renamed from: d, reason: collision with root package name */
    public int f424032d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f424033e;

    /* renamed from: f, reason: collision with root package name */
    public int f424034f;

    /* renamed from: g, reason: collision with root package name */
    public int f424035g;

    /* renamed from: h, reason: collision with root package name */
    public c[] f424036h;

    /* renamed from: i, reason: collision with root package name */
    public int f424037i;

    /* renamed from: j, reason: collision with root package name */
    public int f424038j;

    /* renamed from: k, reason: collision with root package name */
    public int f424039k;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f424029a = 0;
        this.f424030b = "";
        this.f424031c = f.b();
        this.f424032d = 0;
        this.f424033e = WireFormatNano.EMPTY_INT_ARRAY;
        this.f424034f = 0;
        this.f424035g = 0;
        this.f424036h = c.b();
        this.f424037i = 0;
        this.f424038j = 0;
        this.f424039k = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        int length4;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f424029a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.f424030b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    f[] fVarArr = this.f424031c;
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
                    this.f424031c = fVarArr2;
                    break;
                case 32:
                    this.f424032d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                    int[] iArr = this.f424033e;
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
                    this.f424033e = iArr2;
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
                    int[] iArr3 = this.f424033e;
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
                    this.f424033e = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 56:
                    this.f424034f = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f424035g = codedInputByteBufferNano.readInt32();
                    break;
                case 74:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    c[] cVarArr = this.f424036h;
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
                    this.f424036h = cVarArr2;
                    break;
                case 80:
                    this.f424037i = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f424038j = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f424039k = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f424029a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f424030b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424030b);
        }
        f[] fVarArr = this.f424031c;
        int i16 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f424031c;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, fVar);
                }
                i17++;
            }
        }
        int i18 = this.f424032d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i18);
        }
        int[] iArr2 = this.f424033e;
        if (iArr2 != null && iArr2.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                iArr = this.f424033e;
                if (i19 >= iArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i19]);
                i19++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (iArr.length * 1);
        }
        int i27 = this.f424034f;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i27);
        }
        int i28 = this.f424035g;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i28);
        }
        c[] cVarArr = this.f424036h;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f424036h;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, cVar);
                }
                i16++;
            }
        }
        int i29 = this.f424037i;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i29);
        }
        int i36 = this.f424038j;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i36);
        }
        int i37 = this.f424039k;
        if (i37 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(12, i37);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424029a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f424030b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424030b);
        }
        f[] fVarArr = this.f424031c;
        int i16 = 0;
        if (fVarArr != null && fVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                f[] fVarArr2 = this.f424031c;
                if (i17 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i17];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, fVar);
                }
                i17++;
            }
        }
        int i18 = this.f424032d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i18);
        }
        int[] iArr = this.f424033e;
        if (iArr != null && iArr.length > 0) {
            int i19 = 0;
            while (true) {
                int[] iArr2 = this.f424033e;
                if (i19 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(5, iArr2[i19]);
                i19++;
            }
        }
        int i26 = this.f424034f;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        int i27 = this.f424035g;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i27);
        }
        c[] cVarArr = this.f424036h;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f424036h;
                if (i16 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i16];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(9, cVar);
                }
                i16++;
            }
        }
        int i28 = this.f424037i;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i28);
        }
        int i29 = this.f424038j;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i29);
        }
        int i36 = this.f424039k;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i36);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
