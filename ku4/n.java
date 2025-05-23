package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: o, reason: collision with root package name */
    private static volatile n[] f413119o;

    /* renamed from: a, reason: collision with root package name */
    public int f413120a;

    /* renamed from: b, reason: collision with root package name */
    public String f413121b;

    /* renamed from: c, reason: collision with root package name */
    public String f413122c;

    /* renamed from: d, reason: collision with root package name */
    public String f413123d;

    /* renamed from: e, reason: collision with root package name */
    public String f413124e;

    /* renamed from: f, reason: collision with root package name */
    public String f413125f;

    /* renamed from: g, reason: collision with root package name */
    public int f413126g;

    /* renamed from: h, reason: collision with root package name */
    public int f413127h;

    /* renamed from: i, reason: collision with root package name */
    public String f413128i;

    /* renamed from: j, reason: collision with root package name */
    public String f413129j;

    /* renamed from: k, reason: collision with root package name */
    public String f413130k;

    /* renamed from: l, reason: collision with root package name */
    public String f413131l;

    /* renamed from: m, reason: collision with root package name */
    public int f413132m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f413133n;

    public n() {
        a();
    }

    public static n[] b() {
        if (f413119o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f413119o == null) {
                    f413119o = new n[0];
                }
            }
        }
        return f413119o;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f413120a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f413121b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f413122c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f413123d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f413124e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f413125f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f413126g = readInt32;
                        break;
                    }
                case 64:
                    this.f413127h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f413128i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f413129j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f413130k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f413131l = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f413132m = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.f413133n = codedInputByteBufferNano.readBool();
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
        int i3 = this.f413120a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f413121b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f413121b);
        }
        if (!this.f413122c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f413122c);
        }
        if (!this.f413123d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f413123d);
        }
        if (!this.f413124e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f413124e);
        }
        if (!this.f413125f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f413125f);
        }
        int i16 = this.f413126g;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i16);
        }
        int i17 = this.f413127h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.f413128i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f413128i);
        }
        if (!this.f413129j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f413129j);
        }
        if (!this.f413130k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f413130k);
        }
        if (!this.f413131l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f413131l);
        }
        int i18 = this.f413132m;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i18);
        }
        boolean z16 = this.f413133n;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(15, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f413120a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f413121b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f413121b);
        }
        if (!this.f413122c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f413122c);
        }
        if (!this.f413123d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f413123d);
        }
        if (!this.f413124e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f413124e);
        }
        if (!this.f413125f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f413125f);
        }
        int i16 = this.f413126g;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i16);
        }
        int i17 = this.f413127h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.f413128i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f413128i);
        }
        if (!this.f413129j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f413129j);
        }
        if (!this.f413130k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f413130k);
        }
        if (!this.f413131l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f413131l);
        }
        int i18 = this.f413132m;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i18);
        }
        boolean z16 = this.f413133n;
        if (z16) {
            codedOutputByteBufferNano.writeBool(15, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f413120a = 0;
        this.f413121b = "";
        this.f413122c = "";
        this.f413123d = "";
        this.f413124e = "";
        this.f413125f = "";
        this.f413126g = 0;
        this.f413127h = 0;
        this.f413128i = "";
        this.f413129j = "";
        this.f413130k = "";
        this.f413131l = "";
        this.f413132m = 0;
        this.f413133n = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
