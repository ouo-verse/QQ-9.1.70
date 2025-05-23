package cp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: n, reason: collision with root package name */
    private static volatile i[] f391597n;

    /* renamed from: a, reason: collision with root package name */
    public long f391598a;

    /* renamed from: b, reason: collision with root package name */
    public long f391599b;

    /* renamed from: c, reason: collision with root package name */
    public String f391600c;

    /* renamed from: d, reason: collision with root package name */
    public long f391601d;

    /* renamed from: e, reason: collision with root package name */
    public g f391602e;

    /* renamed from: f, reason: collision with root package name */
    public String f391603f;

    /* renamed from: g, reason: collision with root package name */
    public long f391604g;

    /* renamed from: h, reason: collision with root package name */
    public j f391605h;

    /* renamed from: i, reason: collision with root package name */
    public long[] f391606i;

    /* renamed from: j, reason: collision with root package name */
    public a[] f391607j;

    /* renamed from: k, reason: collision with root package name */
    public int f391608k;

    /* renamed from: l, reason: collision with root package name */
    public long f391609l;

    /* renamed from: m, reason: collision with root package name */
    public h f391610m;

    public i() {
        a();
    }

    public static i[] b() {
        if (f391597n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391597n == null) {
                    f391597n = new i[0];
                }
            }
        }
        return f391597n;
    }

    public i a() {
        this.f391598a = 0L;
        this.f391599b = 0L;
        this.f391600c = "";
        this.f391601d = 0L;
        this.f391602e = null;
        this.f391603f = "";
        this.f391604g = 0L;
        this.f391605h = null;
        this.f391606i = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f391607j = a.b();
        this.f391608k = 0;
        this.f391609l = 0L;
        this.f391610m = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f391598a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f391599b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f391600c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f391601d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    if (this.f391602e == null) {
                        this.f391602e = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f391602e);
                    break;
                case 50:
                    this.f391603f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f391604g = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    if (this.f391605h == null) {
                        this.f391605h = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.f391605h);
                    break;
                case 80:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                    long[] jArr = this.f391606i;
                    if (jArr == null) {
                        length = 0;
                    } else {
                        length = jArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    long[] jArr2 = new long[i3];
                    if (length != 0) {
                        System.arraycopy(jArr, 0, jArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.f391606i = jArr2;
                    break;
                case 82:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.f391606i;
                    if (jArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = jArr3.length;
                    }
                    int i17 = i16 + length2;
                    long[] jArr4 = new long[i17];
                    if (length2 != 0) {
                        System.arraycopy(jArr3, 0, jArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.f391606i = jArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    a[] aVarArr = this.f391607j;
                    if (aVarArr == null) {
                        length3 = 0;
                    } else {
                        length3 = aVarArr.length;
                    }
                    int i18 = repeatedFieldArrayLength2 + length3;
                    a[] aVarArr2 = new a[i18];
                    if (length3 != 0) {
                        System.arraycopy(aVarArr, 0, aVarArr2, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        a aVar = new a();
                        aVarArr2[length3] = aVar;
                        codedInputByteBufferNano.readMessage(aVar);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    a aVar2 = new a();
                    aVarArr2[length3] = aVar2;
                    codedInputByteBufferNano.readMessage(aVar2);
                    this.f391607j = aVarArr2;
                    break;
                case 96:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f391608k = readInt32;
                        break;
                    }
                case 104:
                    this.f391609l = codedInputByteBufferNano.readInt64();
                    break;
                case 114:
                    if (this.f391610m == null) {
                        this.f391610m = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f391610m);
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
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f391598a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f391599b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f391600c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391600c);
        }
        long j17 = this.f391601d;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        g gVar = this.f391602e;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gVar);
        }
        if (!this.f391603f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f391603f);
        }
        long j18 = this.f391604g;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j18);
        }
        j jVar = this.f391605h;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, jVar);
        }
        long[] jArr2 = this.f391606i;
        int i3 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr = this.f391606i;
                if (i16 >= jArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr.length * 1);
        }
        a[] aVarArr = this.f391607j;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f391607j;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, aVar);
                }
                i3++;
            }
        }
        int i18 = this.f391608k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i18);
        }
        long j19 = this.f391609l;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(13, j19);
        }
        h hVar = this.f391610m;
        if (hVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(14, hVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f391598a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f391599b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f391600c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391600c);
        }
        long j17 = this.f391601d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        g gVar = this.f391602e;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(5, gVar);
        }
        if (!this.f391603f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f391603f);
        }
        long j18 = this.f391604g;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j18);
        }
        j jVar = this.f391605h;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(8, jVar);
        }
        long[] jArr = this.f391606i;
        int i3 = 0;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.f391606i;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(10, jArr2[i16]);
                i16++;
            }
        }
        a[] aVarArr = this.f391607j;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f391607j;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, aVar);
                }
                i3++;
            }
        }
        int i17 = this.f391608k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i17);
        }
        long j19 = this.f391609l;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeInt64(13, j19);
        }
        h hVar = this.f391610m;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(14, hVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
