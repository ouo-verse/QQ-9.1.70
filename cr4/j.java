package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f391761a;

    /* renamed from: b, reason: collision with root package name */
    public int f391762b;

    /* renamed from: c, reason: collision with root package name */
    public int f391763c;

    /* renamed from: d, reason: collision with root package name */
    public String f391764d;

    /* renamed from: e, reason: collision with root package name */
    public String f391765e;

    /* renamed from: f, reason: collision with root package name */
    public int f391766f;

    /* renamed from: g, reason: collision with root package name */
    public a f391767g;

    /* renamed from: h, reason: collision with root package name */
    public k f391768h;

    /* renamed from: i, reason: collision with root package name */
    public b f391769i;

    /* renamed from: j, reason: collision with root package name */
    public String f391770j;

    /* renamed from: k, reason: collision with root package name */
    public int f391771k;

    /* renamed from: l, reason: collision with root package name */
    public String f391772l;

    /* renamed from: m, reason: collision with root package name */
    public int f391773m;

    /* renamed from: n, reason: collision with root package name */
    public String f391774n;

    /* renamed from: o, reason: collision with root package name */
    public int f391775o;

    /* renamed from: p, reason: collision with root package name */
    public int f391776p;

    /* renamed from: q, reason: collision with root package name */
    public int f391777q;

    /* renamed from: r, reason: collision with root package name */
    public int f391778r;

    /* renamed from: s, reason: collision with root package name */
    public int f391779s;

    public j() {
        a();
    }

    public j a() {
        this.f391761a = 0;
        this.f391762b = 0;
        this.f391763c = 0;
        this.f391764d = "";
        this.f391765e = "";
        this.f391766f = 0;
        this.f391767g = null;
        this.f391768h = null;
        this.f391769i = null;
        this.f391770j = "";
        this.f391771k = 0;
        this.f391772l = "";
        this.f391773m = 0;
        this.f391774n = "";
        this.f391775o = 0;
        this.f391776p = 0;
        this.f391777q = 0;
        this.f391778r = 0;
        this.f391779s = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.f391761a = readInt32;
                        break;
                    }
                case 16:
                    this.f391762b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f391763c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.f391764d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f391765e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2) {
                        break;
                    } else {
                        this.f391766f = readInt322;
                        break;
                    }
                case 58:
                    if (this.f391767g == null) {
                        this.f391767g = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f391767g);
                    break;
                case 66:
                    if (this.f391768h == null) {
                        this.f391768h = new k();
                    }
                    codedInputByteBufferNano.readMessage(this.f391768h);
                    break;
                case 74:
                    if (this.f391769i == null) {
                        this.f391769i = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f391769i);
                    break;
                case 82:
                    this.f391770j = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.f391771k = codedInputByteBufferNano.readInt32();
                    break;
                case 98:
                    this.f391772l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.f391773m = codedInputByteBufferNano.readInt32();
                    break;
                case 114:
                    this.f391774n = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                        break;
                    } else {
                        this.f391775o = readInt323;
                        break;
                    }
                case 128:
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 != 0 && readInt324 != 1 && readInt324 != 2) {
                        break;
                    } else {
                        this.f391776p = readInt324;
                        break;
                    }
                case 136:
                    int readInt325 = codedInputByteBufferNano.readInt32();
                    if (readInt325 != 0 && readInt325 != 1 && readInt325 != 2 && readInt325 != 3) {
                        break;
                    } else {
                        this.f391777q = readInt325;
                        break;
                    }
                case 144:
                    this.f391778r = codedInputByteBufferNano.readInt32();
                    break;
                case 152:
                    int readInt326 = codedInputByteBufferNano.readInt32();
                    if (readInt326 != 0 && readInt326 != 1) {
                        break;
                    } else {
                        this.f391779s = readInt326;
                        break;
                    }
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
        int i3 = this.f391761a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.f391762b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f391763c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!this.f391764d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391764d);
        }
        if (!this.f391765e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f391765e);
        }
        int i18 = this.f391766f;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i18);
        }
        a aVar = this.f391767g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, aVar);
        }
        k kVar = this.f391768h;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, kVar);
        }
        b bVar = this.f391769i;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, bVar);
        }
        if (!this.f391770j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f391770j);
        }
        int i19 = this.f391771k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i19);
        }
        if (!this.f391772l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f391772l);
        }
        int i26 = this.f391773m;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i26);
        }
        if (!this.f391774n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f391774n);
        }
        int i27 = this.f391775o;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i27);
        }
        int i28 = this.f391776p;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i28);
        }
        int i29 = this.f391777q;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i29);
        }
        int i36 = this.f391778r;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, i36);
        }
        int i37 = this.f391779s;
        if (i37 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(19, i37);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f391761a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.f391762b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f391763c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!this.f391764d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391764d);
        }
        if (!this.f391765e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391765e);
        }
        int i18 = this.f391766f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        a aVar = this.f391767g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(7, aVar);
        }
        k kVar = this.f391768h;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(8, kVar);
        }
        b bVar = this.f391769i;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(9, bVar);
        }
        if (!this.f391770j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f391770j);
        }
        int i19 = this.f391771k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i19);
        }
        if (!this.f391772l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f391772l);
        }
        int i26 = this.f391773m;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i26);
        }
        if (!this.f391774n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f391774n);
        }
        int i27 = this.f391775o;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i27);
        }
        int i28 = this.f391776p;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(16, i28);
        }
        int i29 = this.f391777q;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i29);
        }
        int i36 = this.f391778r;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeInt32(18, i36);
        }
        int i37 = this.f391779s;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeInt32(19, i37);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
