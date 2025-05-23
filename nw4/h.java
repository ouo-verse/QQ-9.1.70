package nw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: s, reason: collision with root package name */
    private static volatile h[] f421481s;

    /* renamed from: a, reason: collision with root package name */
    public long f421482a;

    /* renamed from: b, reason: collision with root package name */
    public String f421483b;

    /* renamed from: c, reason: collision with root package name */
    public int f421484c;

    /* renamed from: d, reason: collision with root package name */
    public String f421485d;

    /* renamed from: e, reason: collision with root package name */
    public String f421486e;

    /* renamed from: f, reason: collision with root package name */
    public int f421487f;

    /* renamed from: g, reason: collision with root package name */
    public String f421488g;

    /* renamed from: h, reason: collision with root package name */
    public int f421489h;

    /* renamed from: i, reason: collision with root package name */
    public String f421490i;

    /* renamed from: j, reason: collision with root package name */
    public int f421491j;

    /* renamed from: k, reason: collision with root package name */
    public long f421492k;

    /* renamed from: l, reason: collision with root package name */
    public String f421493l;

    /* renamed from: m, reason: collision with root package name */
    public String f421494m;

    /* renamed from: n, reason: collision with root package name */
    public String f421495n;

    /* renamed from: o, reason: collision with root package name */
    public String f421496o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f421497p;

    /* renamed from: q, reason: collision with root package name */
    public int f421498q;

    /* renamed from: r, reason: collision with root package name */
    public int f421499r;

    public h() {
        a();
    }

    public static h[] b() {
        if (f421481s == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f421481s == null) {
                    f421481s = new h[0];
                }
            }
        }
        return f421481s;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f421482a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f421483b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f421484c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.f421485d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f421486e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 5) {
                        break;
                    } else {
                        this.f421487f = readInt32;
                        break;
                    }
                case 58:
                    this.f421488g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f421489h = readInt322;
                        break;
                    }
                case 74:
                    this.f421490i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f421491j = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.f421492k = codedInputByteBufferNano.readUInt64();
                    break;
                case 98:
                    this.f421493l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f421494m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f421495n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f421496o = codedInputByteBufferNano.readString();
                    break;
                case 272:
                    this.f421497p = codedInputByteBufferNano.readBool();
                    break;
                case 800:
                    this.f421498q = codedInputByteBufferNano.readInt32();
                    break;
                case 808:
                    this.f421499r = codedInputByteBufferNano.readInt32();
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
        long j3 = this.f421482a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f421483b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421483b);
        }
        int i3 = this.f421484c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f421485d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f421485d);
        }
        if (!this.f421486e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f421486e);
        }
        int i16 = this.f421487f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        if (!this.f421488g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f421488g);
        }
        int i17 = this.f421489h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        if (!this.f421490i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f421490i);
        }
        int i18 = this.f421491j;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i18);
        }
        long j16 = this.f421492k;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        if (!this.f421493l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f421493l);
        }
        if (!this.f421494m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f421494m);
        }
        if (!this.f421495n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f421495n);
        }
        if (!this.f421496o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f421496o);
        }
        boolean z16 = this.f421497p;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(34, z16);
        }
        int i19 = this.f421498q;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(100, i19);
        }
        int i26 = this.f421499r;
        return i26 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(101, i26) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f421482a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f421483b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421483b);
        }
        int i3 = this.f421484c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f421485d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f421485d);
        }
        if (!this.f421486e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f421486e);
        }
        int i16 = this.f421487f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        if (!this.f421488g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f421488g);
        }
        int i17 = this.f421489h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        if (!this.f421490i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f421490i);
        }
        int i18 = this.f421491j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        long j16 = this.f421492k;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        if (!this.f421493l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f421493l);
        }
        if (!this.f421494m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f421494m);
        }
        if (!this.f421495n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f421495n);
        }
        if (!this.f421496o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f421496o);
        }
        boolean z16 = this.f421497p;
        if (z16) {
            codedOutputByteBufferNano.writeBool(34, z16);
        }
        int i19 = this.f421498q;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(100, i19);
        }
        int i26 = this.f421499r;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(101, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f421482a = 0L;
        this.f421483b = "";
        this.f421484c = 0;
        this.f421485d = "";
        this.f421486e = "";
        this.f421487f = 0;
        this.f421488g = "";
        this.f421489h = 0;
        this.f421490i = "";
        this.f421491j = 0;
        this.f421492k = 0L;
        this.f421493l = "";
        this.f421494m = "";
        this.f421495n = "";
        this.f421496o = "";
        this.f421497p = false;
        this.f421498q = 0;
        this.f421499r = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
