package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: t, reason: collision with root package name */
    private static volatile i[] f423350t;

    /* renamed from: a, reason: collision with root package name */
    public String f423351a;

    /* renamed from: b, reason: collision with root package name */
    public sp4.c f423352b;

    /* renamed from: c, reason: collision with root package name */
    public rp4.g f423353c;

    /* renamed from: d, reason: collision with root package name */
    public rp4.f f423354d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f423355e;

    /* renamed from: f, reason: collision with root package name */
    public g[] f423356f;

    /* renamed from: g, reason: collision with root package name */
    public h f423357g;

    /* renamed from: h, reason: collision with root package name */
    public long f423358h;

    /* renamed from: i, reason: collision with root package name */
    public d f423359i;

    /* renamed from: j, reason: collision with root package name */
    public g f423360j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f423361k;

    /* renamed from: l, reason: collision with root package name */
    public int f423362l;

    /* renamed from: m, reason: collision with root package name */
    public int f423363m;

    /* renamed from: n, reason: collision with root package name */
    public j[] f423364n;

    /* renamed from: o, reason: collision with root package name */
    public int f423365o;

    /* renamed from: p, reason: collision with root package name */
    public int f423366p;

    /* renamed from: q, reason: collision with root package name */
    public b f423367q;

    /* renamed from: r, reason: collision with root package name */
    public int f423368r;

    /* renamed from: s, reason: collision with root package name */
    public String[] f423369s;

    public i() {
        a();
    }

    public static i[] b() {
        if (f423350t == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423350t == null) {
                    f423350t = new i[0];
                }
            }
        }
        return f423350t;
    }

    public static i d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (i) MessageNano.mergeFrom(new i(), bArr);
    }

    public i a() {
        this.f423351a = "";
        this.f423352b = null;
        this.f423353c = null;
        this.f423354d = null;
        this.f423355e = WireFormatNano.EMPTY_BYTES;
        this.f423356f = g.b();
        this.f423357g = null;
        this.f423358h = 0L;
        this.f423359i = null;
        this.f423360j = null;
        this.f423361k = false;
        this.f423362l = 0;
        this.f423363m = 0;
        this.f423364n = j.b();
        this.f423365o = 0;
        this.f423366p = 0;
        this.f423367q = null;
        this.f423368r = 0;
        this.f423369s = WireFormatNano.EMPTY_STRING_ARRAY;
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
                case 10:
                    this.f423351a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    if (this.f423352b == null) {
                        this.f423352b = new sp4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f423352b);
                    break;
                case 26:
                    if (this.f423353c == null) {
                        this.f423353c = new rp4.g();
                    }
                    codedInputByteBufferNano.readMessage(this.f423353c);
                    break;
                case 34:
                    if (this.f423354d == null) {
                        this.f423354d = new rp4.f();
                    }
                    codedInputByteBufferNano.readMessage(this.f423354d);
                    break;
                case 42:
                    this.f423355e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    g[] gVarArr = this.f423356f;
                    if (gVarArr == null) {
                        length = 0;
                    } else {
                        length = gVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    g[] gVarArr2 = new g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        g gVar = new g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f423356f = gVarArr2;
                    break;
                case 58:
                    if (this.f423357g == null) {
                        this.f423357g = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f423357g);
                    break;
                case 64:
                    this.f423358h = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    if (this.f423359i == null) {
                        this.f423359i = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f423359i);
                    break;
                case 82:
                    if (this.f423360j == null) {
                        this.f423360j = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f423360j);
                    break;
                case 88:
                    this.f423361k = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.f423362l = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.f423363m = codedInputByteBufferNano.readUInt32();
                    break;
                case 114:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    j[] jVarArr = this.f423364n;
                    if (jVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = jVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    j[] jVarArr2 = new j[i16];
                    if (length2 != 0) {
                        System.arraycopy(jVarArr, 0, jVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        j jVar = new j();
                        jVarArr2[length2] = jVar;
                        codedInputByteBufferNano.readMessage(jVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    j jVar2 = new j();
                    jVarArr2[length2] = jVar2;
                    codedInputByteBufferNano.readMessage(jVar2);
                    this.f423364n = jVarArr2;
                    break;
                case 120:
                    this.f423365o = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.f423366p = codedInputByteBufferNano.readUInt32();
                    break;
                case 138:
                    if (this.f423367q == null) {
                        this.f423367q = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f423367q);
                    break;
                case 144:
                    this.f423368r = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    String[] strArr = this.f423369s;
                    if (strArr == null) {
                        length3 = 0;
                    } else {
                        length3 = strArr.length;
                    }
                    int i17 = repeatedFieldArrayLength3 + length3;
                    String[] strArr2 = new String[i17];
                    if (length3 != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    this.f423369s = strArr2;
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
        if (!this.f423351a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423351a);
        }
        sp4.c cVar = this.f423352b;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
        }
        rp4.g gVar = this.f423353c;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
        }
        rp4.f fVar = this.f423354d;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, fVar);
        }
        if (!Arrays.equals(this.f423355e, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.f423355e);
        }
        g[] gVarArr = this.f423356f;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f423356f;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar2 = gVarArr2[i16];
                if (gVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, gVar2);
                }
                i16++;
            }
        }
        h hVar = this.f423357g;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, hVar);
        }
        long j3 = this.f423358h;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j3);
        }
        d dVar = this.f423359i;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, dVar);
        }
        g gVar3 = this.f423360j;
        if (gVar3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, gVar3);
        }
        boolean z16 = this.f423361k;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z16);
        }
        int i17 = this.f423362l;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i17);
        }
        int i18 = this.f423363m;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i18);
        }
        j[] jVarArr = this.f423364n;
        if (jVarArr != null && jVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                j[] jVarArr2 = this.f423364n;
                if (i19 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i19];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, jVar);
                }
                i19++;
            }
        }
        int i26 = this.f423365o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i26);
        }
        int i27 = this.f423366p;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i27);
        }
        b bVar = this.f423367q;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, bVar);
        }
        int i28 = this.f423368r;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i28);
        }
        String[] strArr = this.f423369s;
        if (strArr != null && strArr.length > 0) {
            int i29 = 0;
            int i36 = 0;
            while (true) {
                String[] strArr2 = this.f423369s;
                if (i3 < strArr2.length) {
                    String str = strArr2[i3];
                    if (str != null) {
                        i36++;
                        i29 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                } else {
                    return computeSerializedSize + i29 + (i36 * 2);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423351a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423351a);
        }
        sp4.c cVar = this.f423352b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar);
        }
        rp4.g gVar = this.f423353c;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(3, gVar);
        }
        rp4.f fVar = this.f423354d;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(4, fVar);
        }
        if (!Arrays.equals(this.f423355e, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.f423355e);
        }
        g[] gVarArr = this.f423356f;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f423356f;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar2 = gVarArr2[i16];
                if (gVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(6, gVar2);
                }
                i16++;
            }
        }
        h hVar = this.f423357g;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(7, hVar);
        }
        long j3 = this.f423358h;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j3);
        }
        d dVar = this.f423359i;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(9, dVar);
        }
        g gVar3 = this.f423360j;
        if (gVar3 != null) {
            codedOutputByteBufferNano.writeMessage(10, gVar3);
        }
        boolean z16 = this.f423361k;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        int i17 = this.f423362l;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i17);
        }
        int i18 = this.f423363m;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i18);
        }
        j[] jVarArr = this.f423364n;
        if (jVarArr != null && jVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                j[] jVarArr2 = this.f423364n;
                if (i19 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i19];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(14, jVar);
                }
                i19++;
            }
        }
        int i26 = this.f423365o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i26);
        }
        int i27 = this.f423366p;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i27);
        }
        b bVar = this.f423367q;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(17, bVar);
        }
        int i28 = this.f423368r;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i28);
        }
        String[] strArr = this.f423369s;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f423369s;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(19, str);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
