package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f423330a;

    /* renamed from: b, reason: collision with root package name */
    public String f423331b;

    /* renamed from: c, reason: collision with root package name */
    public int f423332c;

    /* renamed from: d, reason: collision with root package name */
    public String f423333d;

    /* renamed from: e, reason: collision with root package name */
    public String f423334e;

    /* renamed from: f, reason: collision with root package name */
    public int f423335f;

    /* renamed from: g, reason: collision with root package name */
    public f f423336g;

    /* renamed from: h, reason: collision with root package name */
    public int f423337h;

    /* renamed from: i, reason: collision with root package name */
    public int f423338i;

    /* renamed from: j, reason: collision with root package name */
    public String f423339j;

    /* renamed from: k, reason: collision with root package name */
    public String f423340k;

    /* renamed from: l, reason: collision with root package name */
    public String f423341l;

    /* renamed from: m, reason: collision with root package name */
    public String f423342m;

    /* renamed from: n, reason: collision with root package name */
    public int f423343n;

    /* renamed from: o, reason: collision with root package name */
    public int f423344o;

    /* renamed from: p, reason: collision with root package name */
    public String f423345p;

    /* renamed from: q, reason: collision with root package name */
    public String f423346q;

    /* renamed from: r, reason: collision with root package name */
    public String f423347r;

    /* renamed from: s, reason: collision with root package name */
    public String f423348s;

    /* renamed from: t, reason: collision with root package name */
    public String f423349t;

    public h() {
        a();
    }

    public h a() {
        this.f423330a = "";
        this.f423331b = "";
        this.f423332c = 0;
        this.f423333d = "";
        this.f423334e = "";
        this.f423335f = 0;
        this.f423336g = null;
        this.f423337h = 0;
        this.f423338i = 0;
        this.f423339j = "";
        this.f423340k = "";
        this.f423341l = "";
        this.f423342m = "";
        this.f423343n = 0;
        this.f423344o = 0;
        this.f423345p = "";
        this.f423346q = "";
        this.f423347r = "";
        this.f423348s = "";
        this.f423349t = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f423330a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f423331b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f423332c = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.f423333d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f423334e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f423335f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    if (this.f423336g == null) {
                        this.f423336g = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f423336g);
                    break;
                case 64:
                    this.f423337h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f423338i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f423339j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f423340k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f423341l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f423342m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f423343n = codedInputByteBufferNano.readInt32();
                    break;
                case 120:
                    this.f423344o = codedInputByteBufferNano.readInt32();
                    break;
                case 130:
                    this.f423345p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f423346q = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.f423347r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.f423348s = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.f423349t = codedInputByteBufferNano.readString();
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
        if (!this.f423330a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423330a);
        }
        if (!this.f423331b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f423331b);
        }
        int i3 = this.f423332c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.f423333d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f423333d);
        }
        if (!this.f423334e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f423334e);
        }
        int i16 = this.f423335f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        f fVar = this.f423336g;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, fVar);
        }
        int i17 = this.f423337h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        int i18 = this.f423338i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        if (!this.f423339j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f423339j);
        }
        if (!this.f423340k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f423340k);
        }
        if (!this.f423341l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f423341l);
        }
        if (!this.f423342m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f423342m);
        }
        int i19 = this.f423343n;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i19);
        }
        int i26 = this.f423344o;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i26);
        }
        if (!this.f423345p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f423345p);
        }
        if (!this.f423346q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f423346q);
        }
        if (!this.f423347r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f423347r);
        }
        if (!this.f423348s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f423348s);
        }
        if (!this.f423349t.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.f423349t);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423330a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423330a);
        }
        if (!this.f423331b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f423331b);
        }
        int i3 = this.f423332c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.f423333d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f423333d);
        }
        if (!this.f423334e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f423334e);
        }
        int i16 = this.f423335f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        f fVar = this.f423336g;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(7, fVar);
        }
        int i17 = this.f423337h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        int i18 = this.f423338i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i18);
        }
        if (!this.f423339j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f423339j);
        }
        if (!this.f423340k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f423340k);
        }
        if (!this.f423341l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f423341l);
        }
        if (!this.f423342m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f423342m);
        }
        int i19 = this.f423343n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i19);
        }
        int i26 = this.f423344o;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(15, i26);
        }
        if (!this.f423345p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f423345p);
        }
        if (!this.f423346q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f423346q);
        }
        if (!this.f423347r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f423347r);
        }
        if (!this.f423348s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f423348s);
        }
        if (!this.f423349t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f423349t);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
