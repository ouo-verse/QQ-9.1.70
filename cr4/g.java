package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: v, reason: collision with root package name */
    private static volatile g[] f391734v;

    /* renamed from: a, reason: collision with root package name */
    public long f391735a;

    /* renamed from: b, reason: collision with root package name */
    public long f391736b;

    /* renamed from: c, reason: collision with root package name */
    public String f391737c;

    /* renamed from: d, reason: collision with root package name */
    public String f391738d;

    /* renamed from: e, reason: collision with root package name */
    public String f391739e;

    /* renamed from: f, reason: collision with root package name */
    public int f391740f;

    /* renamed from: g, reason: collision with root package name */
    public long f391741g;

    /* renamed from: h, reason: collision with root package name */
    public long f391742h;

    /* renamed from: i, reason: collision with root package name */
    public long f391743i;

    /* renamed from: j, reason: collision with root package name */
    public int f391744j;

    /* renamed from: k, reason: collision with root package name */
    public int f391745k;

    /* renamed from: l, reason: collision with root package name */
    public a f391746l;

    /* renamed from: m, reason: collision with root package name */
    public k f391747m;

    /* renamed from: n, reason: collision with root package name */
    public f f391748n;

    /* renamed from: o, reason: collision with root package name */
    public int f391749o;

    /* renamed from: p, reason: collision with root package name */
    public int f391750p;

    /* renamed from: q, reason: collision with root package name */
    public long f391751q;

    /* renamed from: r, reason: collision with root package name */
    public int f391752r;

    /* renamed from: s, reason: collision with root package name */
    public long f391753s;

    /* renamed from: t, reason: collision with root package name */
    public long f391754t;

    /* renamed from: u, reason: collision with root package name */
    public long f391755u;

    public g() {
        a();
    }

    public static g[] b() {
        if (f391734v == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f391734v == null) {
                    f391734v = new g[0];
                }
            }
        }
        return f391734v;
    }

    public g a() {
        this.f391735a = 0L;
        this.f391736b = 0L;
        this.f391737c = "";
        this.f391738d = "";
        this.f391739e = "";
        this.f391740f = 0;
        this.f391741g = 0L;
        this.f391742h = 0L;
        this.f391743i = 0L;
        this.f391744j = 0;
        this.f391745k = 0;
        this.f391746l = null;
        this.f391747m = null;
        this.f391748n = null;
        this.f391749o = 0;
        this.f391750p = 0;
        this.f391751q = 0L;
        this.f391752r = 0;
        this.f391753s = 0L;
        this.f391754t = 0L;
        this.f391755u = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f391735a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f391736b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f391737c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f391738d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f391739e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f391740f = readInt32;
                        break;
                    }
                case 56:
                    this.f391741g = codedInputByteBufferNano.readInt64();
                    break;
                case 64:
                    this.f391742h = codedInputByteBufferNano.readInt64();
                    break;
                case 72:
                    this.f391743i = codedInputByteBufferNano.readInt64();
                    break;
                case 80:
                    this.f391744j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f391745k = readInt322;
                        break;
                    }
                case 98:
                    if (this.f391746l == null) {
                        this.f391746l = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f391746l);
                    break;
                case 106:
                    if (this.f391747m == null) {
                        this.f391747m = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f391747m);
                    break;
                case 114:
                    if (this.f391748n == null) {
                        this.f391748n = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f391748n);
                    break;
                case 120:
                    this.f391749o = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.f391750p = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.f391751q = codedInputByteBufferNano.readInt64();
                    break;
                case 144:
                    this.f391752r = codedInputByteBufferNano.readInt32();
                    break;
                case 152:
                    this.f391753s = codedInputByteBufferNano.readInt64();
                    break;
                case 160:
                    this.f391754t = codedInputByteBufferNano.readInt64();
                    break;
                case 168:
                    this.f391755u = codedInputByteBufferNano.readInt64();
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
        long j3 = this.f391735a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f391736b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f391737c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391737c);
        }
        if (!this.f391738d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391738d);
        }
        if (!this.f391739e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f391739e);
        }
        int i3 = this.f391740f;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        long j17 = this.f391741g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j17);
        }
        long j18 = this.f391742h;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j18);
        }
        long j19 = this.f391743i;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(9, j19);
        }
        int i16 = this.f391744j;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        int i17 = this.f391745k;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i17);
        }
        a aVar = this.f391746l;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, aVar);
        }
        k kVar = this.f391747m;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, kVar);
        }
        f fVar = this.f391748n;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, fVar);
        }
        int i18 = this.f391749o;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i18);
        }
        int i19 = this.f391750p;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i19);
        }
        long j26 = this.f391751q;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(17, j26);
        }
        int i26 = this.f391752r;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, i26);
        }
        long j27 = this.f391753s;
        if (j27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(19, j27);
        }
        long j28 = this.f391754t;
        if (j28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(20, j28);
        }
        long j29 = this.f391755u;
        if (j29 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(21, j29);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f391735a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f391736b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f391737c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391737c);
        }
        if (!this.f391738d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391738d);
        }
        if (!this.f391739e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391739e);
        }
        int i3 = this.f391740f;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        long j17 = this.f391741g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j17);
        }
        long j18 = this.f391742h;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j18);
        }
        long j19 = this.f391743i;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeInt64(9, j19);
        }
        int i16 = this.f391744j;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        int i17 = this.f391745k;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i17);
        }
        a aVar = this.f391746l;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(12, aVar);
        }
        k kVar = this.f391747m;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(13, kVar);
        }
        f fVar = this.f391748n;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(14, fVar);
        }
        int i18 = this.f391749o;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i18);
        }
        int i19 = this.f391750p;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i19);
        }
        long j26 = this.f391751q;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeInt64(17, j26);
        }
        int i26 = this.f391752r;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(18, i26);
        }
        long j27 = this.f391753s;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeInt64(19, j27);
        }
        long j28 = this.f391754t;
        if (j28 != 0) {
            codedOutputByteBufferNano.writeInt64(20, j28);
        }
        long j29 = this.f391755u;
        if (j29 != 0) {
            codedOutputByteBufferNano.writeInt64(21, j29);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
