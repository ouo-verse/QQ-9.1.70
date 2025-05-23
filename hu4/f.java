package hu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {
    public int A;
    public int B;
    public int C;

    /* renamed from: a, reason: collision with root package name */
    public long f406350a;

    /* renamed from: b, reason: collision with root package name */
    public String f406351b;

    /* renamed from: c, reason: collision with root package name */
    public int f406352c;

    /* renamed from: d, reason: collision with root package name */
    public String f406353d;

    /* renamed from: e, reason: collision with root package name */
    public String f406354e;

    /* renamed from: f, reason: collision with root package name */
    public String f406355f;

    /* renamed from: g, reason: collision with root package name */
    public String f406356g;

    /* renamed from: h, reason: collision with root package name */
    public String f406357h;

    /* renamed from: i, reason: collision with root package name */
    public String f406358i;

    /* renamed from: j, reason: collision with root package name */
    public int f406359j;

    /* renamed from: k, reason: collision with root package name */
    public int f406360k;

    /* renamed from: l, reason: collision with root package name */
    public int f406361l;

    /* renamed from: m, reason: collision with root package name */
    public String f406362m;

    /* renamed from: n, reason: collision with root package name */
    public String f406363n;

    /* renamed from: o, reason: collision with root package name */
    public String f406364o;

    /* renamed from: p, reason: collision with root package name */
    public int f406365p;

    /* renamed from: q, reason: collision with root package name */
    public int f406366q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f406367r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f406368s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f406369t;

    /* renamed from: u, reason: collision with root package name */
    public h f406370u;

    /* renamed from: v, reason: collision with root package name */
    public i f406371v;

    /* renamed from: w, reason: collision with root package name */
    public int f406372w;

    /* renamed from: z, reason: collision with root package name */
    public e[] f406373z;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f406350a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f406351b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f406352c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f406353d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f406354e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f406355f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f406356g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f406357h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f406358i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f406359j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f406360k = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.f406361l = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    this.f406362m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f406363n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f406364o = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f406365p = codedInputByteBufferNano.readInt32();
                    break;
                case 136:
                    this.f406366q = codedInputByteBufferNano.readInt32();
                    break;
                case 144:
                    this.f406367r = codedInputByteBufferNano.readBool();
                    break;
                case 152:
                    this.f406368s = codedInputByteBufferNano.readBool();
                    break;
                case 160:
                    this.f406369t = codedInputByteBufferNano.readBool();
                    break;
                case 170:
                    if (this.f406370u == null) {
                        this.f406370u = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f406370u);
                    break;
                case 178:
                    if (this.f406371v == null) {
                        this.f406371v = new i();
                    }
                    codedInputByteBufferNano.readMessage(this.f406371v);
                    break;
                case 184:
                    this.f406372w = codedInputByteBufferNano.readInt32();
                    break;
                case 194:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 194);
                    e[] eVarArr = this.f406373z;
                    int length = eVarArr == null ? 0 : eVarArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    e[] eVarArr2 = new e[i3];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e eVar = new e();
                        eVarArr2[length] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f406373z = eVarArr2;
                    break;
                case 200:
                    this.A = codedInputByteBufferNano.readInt32();
                    break;
                case 208:
                    this.B = codedInputByteBufferNano.readUInt32();
                    break;
                case 216:
                    this.C = codedInputByteBufferNano.readInt32();
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
        long j3 = this.f406350a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f406351b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f406351b);
        }
        int i3 = this.f406352c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.f406353d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406353d);
        }
        if (!this.f406354e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406354e);
        }
        if (!this.f406355f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f406355f);
        }
        if (!this.f406356g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f406356g);
        }
        if (!this.f406357h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f406357h);
        }
        if (!this.f406358i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f406358i);
        }
        int i16 = this.f406359j;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        int i17 = this.f406360k;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i17);
        }
        int i18 = this.f406361l;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i18);
        }
        if (!this.f406362m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f406362m);
        }
        if (!this.f406363n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f406363n);
        }
        if (!this.f406364o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f406364o);
        }
        int i19 = this.f406365p;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i19);
        }
        int i26 = this.f406366q;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i26);
        }
        boolean z16 = this.f406367r;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(18, z16);
        }
        boolean z17 = this.f406368s;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, z17);
        }
        boolean z18 = this.f406369t;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z18);
        }
        h hVar = this.f406370u;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, hVar);
        }
        i iVar = this.f406371v;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, iVar);
        }
        int i27 = this.f406372w;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(23, i27);
        }
        e[] eVarArr = this.f406373z;
        if (eVarArr != null && eVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                e[] eVarArr2 = this.f406373z;
                if (i28 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i28];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, eVar);
                }
                i28++;
            }
        }
        int i29 = this.A;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(25, i29);
        }
        int i36 = this.B;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(26, i36);
        }
        int i37 = this.C;
        return i37 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(27, i37) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406350a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f406351b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f406351b);
        }
        int i3 = this.f406352c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.f406353d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406353d);
        }
        if (!this.f406354e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406354e);
        }
        if (!this.f406355f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f406355f);
        }
        if (!this.f406356g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f406356g);
        }
        if (!this.f406357h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f406357h);
        }
        if (!this.f406358i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f406358i);
        }
        int i16 = this.f406359j;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        int i17 = this.f406360k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i17);
        }
        int i18 = this.f406361l;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i18);
        }
        if (!this.f406362m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f406362m);
        }
        if (!this.f406363n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f406363n);
        }
        if (!this.f406364o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f406364o);
        }
        int i19 = this.f406365p;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i19);
        }
        int i26 = this.f406366q;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i26);
        }
        boolean z16 = this.f406367r;
        if (z16) {
            codedOutputByteBufferNano.writeBool(18, z16);
        }
        boolean z17 = this.f406368s;
        if (z17) {
            codedOutputByteBufferNano.writeBool(19, z17);
        }
        boolean z18 = this.f406369t;
        if (z18) {
            codedOutputByteBufferNano.writeBool(20, z18);
        }
        h hVar = this.f406370u;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(21, hVar);
        }
        i iVar = this.f406371v;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(22, iVar);
        }
        int i27 = this.f406372w;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(23, i27);
        }
        e[] eVarArr = this.f406373z;
        if (eVarArr != null && eVarArr.length > 0) {
            int i28 = 0;
            while (true) {
                e[] eVarArr2 = this.f406373z;
                if (i28 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i28];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(24, eVar);
                }
                i28++;
            }
        }
        int i29 = this.A;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(25, i29);
        }
        int i36 = this.B;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(26, i36);
        }
        int i37 = this.C;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeInt32(27, i37);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f406350a = 0L;
        this.f406351b = "";
        this.f406352c = 0;
        this.f406353d = "";
        this.f406354e = "";
        this.f406355f = "";
        this.f406356g = "";
        this.f406357h = "";
        this.f406358i = "";
        this.f406359j = 0;
        this.f406360k = 0;
        this.f406361l = 0;
        this.f406362m = "";
        this.f406363n = "";
        this.f406364o = "";
        this.f406365p = 0;
        this.f406366q = 0;
        this.f406367r = false;
        this.f406368s = false;
        this.f406369t = false;
        this.f406370u = null;
        this.f406371v = null;
        this.f406372w = 0;
        this.f406373z = e.b();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
