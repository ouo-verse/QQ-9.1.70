package oq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f423389a;

    /* renamed from: b, reason: collision with root package name */
    public int f423390b;

    /* renamed from: c, reason: collision with root package name */
    public String f423391c;

    /* renamed from: d, reason: collision with root package name */
    public String f423392d;

    /* renamed from: e, reason: collision with root package name */
    public String f423393e;

    /* renamed from: f, reason: collision with root package name */
    public String f423394f;

    /* renamed from: g, reason: collision with root package name */
    public String f423395g;

    /* renamed from: h, reason: collision with root package name */
    public int f423396h;

    /* renamed from: i, reason: collision with root package name */
    public String f423397i;

    /* renamed from: j, reason: collision with root package name */
    public int f423398j;

    /* renamed from: k, reason: collision with root package name */
    public int f423399k;

    /* renamed from: l, reason: collision with root package name */
    public String f423400l;

    public c() {
        a();
    }

    public c a() {
        this.f423389a = "";
        this.f423390b = 0;
        this.f423391c = "";
        this.f423392d = "";
        this.f423393e = "";
        this.f423394f = "";
        this.f423395g = "";
        this.f423396h = 0;
        this.f423397i = "";
        this.f423398j = 0;
        this.f423399k = 0;
        this.f423400l = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f423389a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f423390b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f423391c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f423392d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f423393e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f423394f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f423395g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f423396h = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.f423397i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f423398j = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.f423399k = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.f423400l = codedInputByteBufferNano.readString();
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
        if (!this.f423389a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f423389a);
        }
        int i3 = this.f423390b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f423391c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f423391c);
        }
        if (!this.f423392d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f423392d);
        }
        if (!this.f423393e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f423393e);
        }
        if (!this.f423394f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f423394f);
        }
        if (!this.f423395g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f423395g);
        }
        int i16 = this.f423396h;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        if (!this.f423397i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f423397i);
        }
        int i17 = this.f423398j;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        int i18 = this.f423399k;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i18);
        }
        if (!this.f423400l.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.f423400l);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f423389a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f423389a);
        }
        int i3 = this.f423390b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f423391c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f423391c);
        }
        if (!this.f423392d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f423392d);
        }
        if (!this.f423393e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f423393e);
        }
        if (!this.f423394f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f423394f);
        }
        if (!this.f423395g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f423395g);
        }
        int i16 = this.f423396h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        if (!this.f423397i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f423397i);
        }
        int i17 = this.f423398j;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        int i18 = this.f423399k;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i18);
        }
        if (!this.f423400l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f423400l);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
