package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: s, reason: collision with root package name */
    private static volatile b[] f413069s;

    /* renamed from: a, reason: collision with root package name */
    public int f413070a;

    /* renamed from: b, reason: collision with root package name */
    public String f413071b;

    /* renamed from: c, reason: collision with root package name */
    public int f413072c;

    /* renamed from: d, reason: collision with root package name */
    public String f413073d;

    /* renamed from: e, reason: collision with root package name */
    public int f413074e;

    /* renamed from: f, reason: collision with root package name */
    public int f413075f;

    /* renamed from: g, reason: collision with root package name */
    public int f413076g;

    /* renamed from: h, reason: collision with root package name */
    public int f413077h;

    /* renamed from: i, reason: collision with root package name */
    public long f413078i;

    /* renamed from: j, reason: collision with root package name */
    public int f413079j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f413080k;

    /* renamed from: l, reason: collision with root package name */
    public int f413081l;

    /* renamed from: m, reason: collision with root package name */
    public float f413082m;

    /* renamed from: n, reason: collision with root package name */
    public String f413083n;

    /* renamed from: o, reason: collision with root package name */
    public String f413084o;

    /* renamed from: p, reason: collision with root package name */
    public m f413085p;

    /* renamed from: q, reason: collision with root package name */
    public h f413086q;

    /* renamed from: r, reason: collision with root package name */
    public String f413087r;

    public b() {
        a();
    }

    public static b[] b() {
        if (f413069s == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f413069s == null) {
                    f413069s = new b[0];
                }
            }
        }
        return f413069s;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f413070a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f413071b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 100) {
                        break;
                    } else {
                        this.f413072c = readInt32;
                        break;
                    }
                case 34:
                    this.f413073d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f413074e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f413075f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f413076g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f413077h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f413078i = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.f413079j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f413080k = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.f413081l = codedInputByteBufferNano.readUInt32();
                    break;
                case 109:
                    this.f413082m = codedInputByteBufferNano.readFloat();
                    break;
                case 114:
                    this.f413083n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f413084o = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    if (this.f413085p == null) {
                        this.f413085p = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f413085p);
                    break;
                case 138:
                    if (this.f413086q == null) {
                        this.f413086q = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f413086q);
                    break;
                case 146:
                    this.f413087r = codedInputByteBufferNano.readString();
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
        int i3 = this.f413070a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f413071b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f413071b);
        }
        int i16 = this.f413072c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        if (!this.f413073d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f413073d);
        }
        int i17 = this.f413074e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.f413075f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.f413076g;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.f413077h;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        long j3 = this.f413078i;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        int i27 = this.f413079j;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i27);
        }
        boolean z16 = this.f413080k;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z16);
        }
        int i28 = this.f413081l;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        if (Float.floatToIntBits(this.f413082m) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(13, this.f413082m);
        }
        if (!this.f413083n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f413083n);
        }
        if (!this.f413084o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f413084o);
        }
        m mVar = this.f413085p;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, mVar);
        }
        h hVar = this.f413086q;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, hVar);
        }
        return !this.f413087r.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(18, this.f413087r) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f413070a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f413071b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f413071b);
        }
        int i16 = this.f413072c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        if (!this.f413073d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f413073d);
        }
        int i17 = this.f413074e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.f413075f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.f413076g;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.f413077h;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        long j3 = this.f413078i;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        int i27 = this.f413079j;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i27);
        }
        boolean z16 = this.f413080k;
        if (z16) {
            codedOutputByteBufferNano.writeBool(11, z16);
        }
        int i28 = this.f413081l;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i28);
        }
        if (Float.floatToIntBits(this.f413082m) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(13, this.f413082m);
        }
        if (!this.f413083n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f413083n);
        }
        if (!this.f413084o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f413084o);
        }
        m mVar = this.f413085p;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(16, mVar);
        }
        h hVar = this.f413086q;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(17, hVar);
        }
        if (!this.f413087r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f413087r);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f413070a = 0;
        this.f413071b = "";
        this.f413072c = 0;
        this.f413073d = "";
        this.f413074e = 0;
        this.f413075f = 0;
        this.f413076g = 0;
        this.f413077h = 0;
        this.f413078i = 0L;
        this.f413079j = 0;
        this.f413080k = false;
        this.f413081l = 0;
        this.f413082m = 0.0f;
        this.f413083n = "";
        this.f413084o = "";
        this.f413085p = null;
        this.f413086q = null;
        this.f413087r = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
