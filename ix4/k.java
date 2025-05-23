package ix4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.heytap.databaseengine.type.SportMode;
import com.tencent.luggage.wxa.yf.x;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {
    private static volatile k[] G;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;

    /* renamed from: a, reason: collision with root package name */
    public String f408950a;

    /* renamed from: b, reason: collision with root package name */
    public int f408951b;

    /* renamed from: c, reason: collision with root package name */
    public int f408952c;

    /* renamed from: d, reason: collision with root package name */
    public e f408953d;

    /* renamed from: e, reason: collision with root package name */
    public d f408954e;

    /* renamed from: f, reason: collision with root package name */
    public int f408955f;

    /* renamed from: g, reason: collision with root package name */
    public int f408956g;

    /* renamed from: h, reason: collision with root package name */
    public String f408957h;

    /* renamed from: i, reason: collision with root package name */
    public String f408958i;

    /* renamed from: j, reason: collision with root package name */
    public String f408959j;

    /* renamed from: k, reason: collision with root package name */
    public gx4.a f408960k;

    /* renamed from: l, reason: collision with root package name */
    public String f408961l;

    /* renamed from: m, reason: collision with root package name */
    public long f408962m;

    /* renamed from: n, reason: collision with root package name */
    public int f408963n;

    /* renamed from: o, reason: collision with root package name */
    public int f408964o;

    /* renamed from: p, reason: collision with root package name */
    public int f408965p;

    /* renamed from: q, reason: collision with root package name */
    public String f408966q;

    /* renamed from: r, reason: collision with root package name */
    public String f408967r;

    /* renamed from: s, reason: collision with root package name */
    public a f408968s;

    /* renamed from: t, reason: collision with root package name */
    public long f408969t;

    /* renamed from: u, reason: collision with root package name */
    public int f408970u;

    /* renamed from: v, reason: collision with root package name */
    public long f408971v;

    /* renamed from: w, reason: collision with root package name */
    public int f408972w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f408973z;

    public k() {
        a();
    }

    public static k[] b() {
        if (G == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (G == null) {
                    G = new k[0];
                }
            }
        }
        return G;
    }

    public k a() {
        this.f408950a = "";
        this.f408951b = 0;
        this.f408952c = 0;
        this.f408953d = null;
        this.f408954e = null;
        this.f408955f = 0;
        this.f408956g = 0;
        this.f408957h = "";
        this.f408958i = "";
        this.f408959j = "";
        this.f408960k = null;
        this.f408961l = "";
        this.f408962m = 0L;
        this.f408963n = 0;
        this.f408964o = 0;
        this.f408965p = 0;
        this.f408966q = "";
        this.f408967r = "";
        this.f408968s = null;
        this.f408969t = 0L;
        this.f408970u = 0;
        this.f408971v = 0L;
        this.f408972w = 0;
        this.f408973z = false;
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f408950a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f408951b = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.f408952c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    if (this.f408953d == null) {
                        this.f408953d = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f408953d);
                    break;
                case 42:
                    if (this.f408954e == null) {
                        this.f408954e = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f408954e);
                    break;
                case 48:
                    this.f408955f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.f408956g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f408957h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f408959j = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f408958i = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.f408960k == null) {
                        this.f408960k = new gx4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f408960k);
                    break;
                case 802:
                    this.f408961l = codedInputByteBufferNano.readString();
                    break;
                case 808:
                    this.f408962m = codedInputByteBufferNano.readInt64();
                    break;
                case 816:
                    this.f408963n = codedInputByteBufferNano.readInt32();
                    break;
                case 824:
                    this.f408964o = codedInputByteBufferNano.readInt32();
                    break;
                case 832:
                    this.f408965p = codedInputByteBufferNano.readInt32();
                    break;
                case com.tencent.luggage.wxa.uf.h.CTRL_INDEX /* 842 */:
                    this.f408966q = codedInputByteBufferNano.readString();
                    break;
                case 850:
                    this.f408967r = codedInputByteBufferNano.readString();
                    break;
                case 858:
                    if (this.f408968s == null) {
                        this.f408968s = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f408968s);
                    break;
                case 864:
                    this.f408969t = codedInputByteBufferNano.readInt64();
                    break;
                case 872:
                    this.f408970u = codedInputByteBufferNano.readInt32();
                    break;
                case x.CTRL_INDEX /* 880 */:
                    this.f408971v = codedInputByteBufferNano.readUInt64();
                    break;
                case 888:
                    this.f408972w = codedInputByteBufferNano.readInt32();
                    break;
                case 896:
                    this.f408973z = codedInputByteBufferNano.readBool();
                    break;
                case SportMode.HORSE_RIDING /* 906 */:
                    this.A = codedInputByteBufferNano.readString();
                    break;
                case 914:
                    this.B = codedInputByteBufferNano.readString();
                    break;
                case 922:
                    this.C = codedInputByteBufferNano.readString();
                    break;
                case 930:
                    this.D = codedInputByteBufferNano.readString();
                    break;
                case com.tencent.luggage.wxa.i2.b.CTRL_INDEX /* 938 */:
                    this.E = codedInputByteBufferNano.readString();
                    break;
                case 946:
                    this.F = codedInputByteBufferNano.readString();
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
        if (!this.f408950a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408950a);
        }
        int i3 = this.f408951b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f408952c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        e eVar = this.f408953d;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, eVar);
        }
        d dVar = this.f408954e;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, dVar);
        }
        int i17 = this.f408955f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        int i18 = this.f408956g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i18);
        }
        if (!this.f408957h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f408957h);
        }
        if (!this.f408959j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f408959j);
        }
        if (!this.f408958i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f408958i);
        }
        gx4.a aVar = this.f408960k;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, aVar);
        }
        if (!this.f408961l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(100, this.f408961l);
        }
        long j3 = this.f408962m;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(101, j3);
        }
        int i19 = this.f408963n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(102, i19);
        }
        int i26 = this.f408964o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(103, i26);
        }
        int i27 = this.f408965p;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(104, i27);
        }
        if (!this.f408966q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(105, this.f408966q);
        }
        if (!this.f408967r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(106, this.f408967r);
        }
        a aVar2 = this.f408968s;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(107, aVar2);
        }
        long j16 = this.f408969t;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(108, j16);
        }
        int i28 = this.f408970u;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(109, i28);
        }
        long j17 = this.f408971v;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(110, j17);
        }
        int i29 = this.f408972w;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(111, i29);
        }
        boolean z16 = this.f408973z;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(112, z16);
        }
        if (!this.A.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(113, this.A);
        }
        if (!this.B.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(114, this.B);
        }
        if (!this.C.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(115, this.C);
        }
        if (!this.D.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(116, this.D);
        }
        if (!this.E.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(117, this.E);
        }
        if (!this.F.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(118, this.F);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408950a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408950a);
        }
        int i3 = this.f408951b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f408952c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        e eVar = this.f408953d;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(4, eVar);
        }
        d dVar = this.f408954e;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(5, dVar);
        }
        int i17 = this.f408955f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        int i18 = this.f408956g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        if (!this.f408957h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f408957h);
        }
        if (!this.f408959j.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f408959j);
        }
        if (!this.f408958i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f408958i);
        }
        gx4.a aVar = this.f408960k;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(11, aVar);
        }
        if (!this.f408961l.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f408961l);
        }
        long j3 = this.f408962m;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(101, j3);
        }
        int i19 = this.f408963n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(102, i19);
        }
        int i26 = this.f408964o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(103, i26);
        }
        int i27 = this.f408965p;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(104, i27);
        }
        if (!this.f408966q.equals("")) {
            codedOutputByteBufferNano.writeString(105, this.f408966q);
        }
        if (!this.f408967r.equals("")) {
            codedOutputByteBufferNano.writeString(106, this.f408967r);
        }
        a aVar2 = this.f408968s;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(107, aVar2);
        }
        long j16 = this.f408969t;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(108, j16);
        }
        int i28 = this.f408970u;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(109, i28);
        }
        long j17 = this.f408971v;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(110, j17);
        }
        int i29 = this.f408972w;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(111, i29);
        }
        boolean z16 = this.f408973z;
        if (z16) {
            codedOutputByteBufferNano.writeBool(112, z16);
        }
        if (!this.A.equals("")) {
            codedOutputByteBufferNano.writeString(113, this.A);
        }
        if (!this.B.equals("")) {
            codedOutputByteBufferNano.writeString(114, this.B);
        }
        if (!this.C.equals("")) {
            codedOutputByteBufferNano.writeString(115, this.C);
        }
        if (!this.D.equals("")) {
            codedOutputByteBufferNano.writeString(116, this.D);
        }
        if (!this.E.equals("")) {
            codedOutputByteBufferNano.writeString(117, this.E);
        }
        if (!this.F.equals("")) {
            codedOutputByteBufferNano.writeString(118, this.F);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
