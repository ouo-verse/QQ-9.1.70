package mt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f417550a;

    /* renamed from: b, reason: collision with root package name */
    public int f417551b;

    /* renamed from: c, reason: collision with root package name */
    public String f417552c;

    /* renamed from: d, reason: collision with root package name */
    public int f417553d;

    /* renamed from: e, reason: collision with root package name */
    public long f417554e;

    /* renamed from: f, reason: collision with root package name */
    public String f417555f;

    /* renamed from: g, reason: collision with root package name */
    public int f417556g;

    /* renamed from: h, reason: collision with root package name */
    public int f417557h;

    /* renamed from: i, reason: collision with root package name */
    public String f417558i;

    /* renamed from: j, reason: collision with root package name */
    public String f417559j;

    /* renamed from: k, reason: collision with root package name */
    public String f417560k;

    /* renamed from: l, reason: collision with root package name */
    public long f417561l;

    /* renamed from: m, reason: collision with root package name */
    public int f417562m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f417563n;

    /* renamed from: o, reason: collision with root package name */
    public String f417564o;

    /* renamed from: p, reason: collision with root package name */
    public long f417565p;

    /* renamed from: q, reason: collision with root package name */
    public long f417566q;

    /* renamed from: r, reason: collision with root package name */
    public long f417567r;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f417550a = 0;
        this.f417551b = 0;
        this.f417552c = "";
        this.f417553d = 0;
        this.f417554e = 0L;
        this.f417555f = "";
        this.f417556g = 0;
        this.f417557h = 0;
        this.f417558i = "";
        this.f417559j = "";
        this.f417560k = "";
        this.f417561l = 0L;
        this.f417562m = 0;
        this.f417563n = false;
        this.f417564o = "";
        this.f417565p = 0L;
        this.f417566q = 0L;
        this.f417567r = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f417550a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f417551b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f417552c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f417553d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f417554e = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.f417555f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f417556g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f417557h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f417558i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f417559j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f417560k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f417561l = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.f417562m = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.f417563n = codedInputByteBufferNano.readBool();
                    break;
                case 122:
                    this.f417564o = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.f417565p = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.f417566q = codedInputByteBufferNano.readUInt64();
                    break;
                case 144:
                    this.f417567r = codedInputByteBufferNano.readUInt64();
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
        int i3 = this.f417550a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f417551b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f417552c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f417552c);
        }
        int i17 = this.f417553d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        long j3 = this.f417554e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.f417555f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f417555f);
        }
        int i18 = this.f417556g;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.f417557h;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        if (!this.f417558i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f417558i);
        }
        if (!this.f417559j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f417559j);
        }
        if (!this.f417560k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f417560k);
        }
        long j16 = this.f417561l;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j16);
        }
        int i26 = this.f417562m;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i26);
        }
        boolean z16 = this.f417563n;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z16);
        }
        if (!this.f417564o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f417564o);
        }
        long j17 = this.f417565p;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j17);
        }
        long j18 = this.f417566q;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j18);
        }
        long j19 = this.f417567r;
        if (j19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(18, j19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417550a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f417551b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f417552c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f417552c);
        }
        int i17 = this.f417553d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        long j3 = this.f417554e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.f417555f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f417555f);
        }
        int i18 = this.f417556g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.f417557h;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        if (!this.f417558i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f417558i);
        }
        if (!this.f417559j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f417559j);
        }
        if (!this.f417560k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f417560k);
        }
        long j16 = this.f417561l;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j16);
        }
        int i26 = this.f417562m;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i26);
        }
        boolean z16 = this.f417563n;
        if (z16) {
            codedOutputByteBufferNano.writeBool(14, z16);
        }
        if (!this.f417564o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f417564o);
        }
        long j17 = this.f417565p;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j17);
        }
        long j18 = this.f417566q;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(17, j18);
        }
        long j19 = this.f417567r;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
