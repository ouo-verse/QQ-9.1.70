package ew4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.heytap.databaseengine.type.SportMode;
import com.tencent.luggage.wxa.uf.h;
import com.tencent.luggage.wxa.yf.x;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class d extends ExtendableMessageNano<d> {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;

    /* renamed from: a, reason: collision with root package name */
    public String f397313a;

    /* renamed from: b, reason: collision with root package name */
    public int f397314b;

    /* renamed from: c, reason: collision with root package name */
    public int f397315c;

    /* renamed from: d, reason: collision with root package name */
    public c f397316d;

    /* renamed from: e, reason: collision with root package name */
    public b f397317e;

    /* renamed from: f, reason: collision with root package name */
    public int f397318f;

    /* renamed from: g, reason: collision with root package name */
    public int f397319g;

    /* renamed from: h, reason: collision with root package name */
    public String f397320h;

    /* renamed from: i, reason: collision with root package name */
    public String f397321i;

    /* renamed from: j, reason: collision with root package name */
    public String f397322j;

    /* renamed from: k, reason: collision with root package name */
    public qu4.a f397323k;

    /* renamed from: l, reason: collision with root package name */
    public String f397324l;

    /* renamed from: m, reason: collision with root package name */
    public long f397325m;

    /* renamed from: n, reason: collision with root package name */
    public int f397326n;

    /* renamed from: o, reason: collision with root package name */
    public int f397327o;

    /* renamed from: p, reason: collision with root package name */
    public int f397328p;

    /* renamed from: q, reason: collision with root package name */
    public String f397329q;

    /* renamed from: r, reason: collision with root package name */
    public String f397330r;

    /* renamed from: s, reason: collision with root package name */
    public a f397331s;

    /* renamed from: t, reason: collision with root package name */
    public long f397332t;

    /* renamed from: u, reason: collision with root package name */
    public int f397333u;

    /* renamed from: v, reason: collision with root package name */
    public long f397334v;

    /* renamed from: w, reason: collision with root package name */
    public int f397335w;

    /* renamed from: z, reason: collision with root package name */
    public boolean f397336z;

    public d() {
        a();
    }

    public d a() {
        this.f397313a = "";
        this.f397314b = 0;
        this.f397315c = 0;
        this.f397316d = null;
        this.f397317e = null;
        this.f397318f = 0;
        this.f397319g = 0;
        this.f397320h = "";
        this.f397321i = "";
        this.f397322j = "";
        this.f397323k = null;
        this.f397324l = "";
        this.f397325m = 0L;
        this.f397326n = 0;
        this.f397327o = 0;
        this.f397328p = 0;
        this.f397329q = "";
        this.f397330r = "";
        this.f397331s = null;
        this.f397332t = 0L;
        this.f397333u = 0;
        this.f397334v = 0L;
        this.f397335w = 0;
        this.f397336z = false;
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
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f397313a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f397314b = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.f397315c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    if (this.f397316d == null) {
                        this.f397316d = new c();
                    }
                    codedInputByteBufferNano.readMessage(this.f397316d);
                    break;
                case 42:
                    if (this.f397317e == null) {
                        this.f397317e = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f397317e);
                    break;
                case 48:
                    this.f397318f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.f397319g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f397320h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f397322j = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f397321i = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.f397323k == null) {
                        this.f397323k = new qu4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f397323k);
                    break;
                case 802:
                    this.f397324l = codedInputByteBufferNano.readString();
                    break;
                case 808:
                    this.f397325m = codedInputByteBufferNano.readInt64();
                    break;
                case 816:
                    this.f397326n = codedInputByteBufferNano.readInt32();
                    break;
                case 824:
                    this.f397327o = codedInputByteBufferNano.readInt32();
                    break;
                case 832:
                    this.f397328p = codedInputByteBufferNano.readInt32();
                    break;
                case h.CTRL_INDEX /* 842 */:
                    this.f397329q = codedInputByteBufferNano.readString();
                    break;
                case 850:
                    this.f397330r = codedInputByteBufferNano.readString();
                    break;
                case 858:
                    if (this.f397331s == null) {
                        this.f397331s = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f397331s);
                    break;
                case 864:
                    this.f397332t = codedInputByteBufferNano.readInt64();
                    break;
                case 872:
                    this.f397333u = codedInputByteBufferNano.readInt32();
                    break;
                case x.CTRL_INDEX /* 880 */:
                    this.f397334v = codedInputByteBufferNano.readUInt64();
                    break;
                case 888:
                    this.f397335w = codedInputByteBufferNano.readInt32();
                    break;
                case 896:
                    this.f397336z = codedInputByteBufferNano.readBool();
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
        if (!this.f397313a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f397313a);
        }
        int i3 = this.f397314b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f397315c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        c cVar = this.f397316d;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        b bVar = this.f397317e;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bVar);
        }
        int i17 = this.f397318f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        int i18 = this.f397319g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i18);
        }
        if (!this.f397320h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f397320h);
        }
        if (!this.f397322j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f397322j);
        }
        if (!this.f397321i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f397321i);
        }
        qu4.a aVar = this.f397323k;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, aVar);
        }
        if (!this.f397324l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(100, this.f397324l);
        }
        long j3 = this.f397325m;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(101, j3);
        }
        int i19 = this.f397326n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(102, i19);
        }
        int i26 = this.f397327o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(103, i26);
        }
        int i27 = this.f397328p;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(104, i27);
        }
        if (!this.f397329q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(105, this.f397329q);
        }
        if (!this.f397330r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(106, this.f397330r);
        }
        a aVar2 = this.f397331s;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(107, aVar2);
        }
        long j16 = this.f397332t;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(108, j16);
        }
        int i28 = this.f397333u;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(109, i28);
        }
        long j17 = this.f397334v;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(110, j17);
        }
        int i29 = this.f397335w;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(111, i29);
        }
        boolean z16 = this.f397336z;
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
        return !this.F.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(118, this.F) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f397313a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f397313a);
        }
        int i3 = this.f397314b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f397315c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        c cVar = this.f397316d;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        b bVar = this.f397317e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bVar);
        }
        int i17 = this.f397318f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        int i18 = this.f397319g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        if (!this.f397320h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f397320h);
        }
        if (!this.f397322j.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f397322j);
        }
        if (!this.f397321i.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f397321i);
        }
        qu4.a aVar = this.f397323k;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(11, aVar);
        }
        if (!this.f397324l.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f397324l);
        }
        long j3 = this.f397325m;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(101, j3);
        }
        int i19 = this.f397326n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(102, i19);
        }
        int i26 = this.f397327o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(103, i26);
        }
        int i27 = this.f397328p;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(104, i27);
        }
        if (!this.f397329q.equals("")) {
            codedOutputByteBufferNano.writeString(105, this.f397329q);
        }
        if (!this.f397330r.equals("")) {
            codedOutputByteBufferNano.writeString(106, this.f397330r);
        }
        a aVar2 = this.f397331s;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(107, aVar2);
        }
        long j16 = this.f397332t;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(108, j16);
        }
        int i28 = this.f397333u;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(109, i28);
        }
        long j17 = this.f397334v;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(110, j17);
        }
        int i29 = this.f397335w;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(111, i29);
        }
        boolean z16 = this.f397336z;
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
