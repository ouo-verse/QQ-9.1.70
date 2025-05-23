package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f391710a;

    /* renamed from: b, reason: collision with root package name */
    public String f391711b;

    /* renamed from: c, reason: collision with root package name */
    public String f391712c;

    /* renamed from: d, reason: collision with root package name */
    public String f391713d;

    /* renamed from: e, reason: collision with root package name */
    public String f391714e;

    /* renamed from: f, reason: collision with root package name */
    public String f391715f;

    /* renamed from: g, reason: collision with root package name */
    public String f391716g;

    /* renamed from: h, reason: collision with root package name */
    public String f391717h;

    /* renamed from: i, reason: collision with root package name */
    public String f391718i;

    /* renamed from: j, reason: collision with root package name */
    public String f391719j;

    /* renamed from: k, reason: collision with root package name */
    public String f391720k;

    /* renamed from: l, reason: collision with root package name */
    public String f391721l;

    /* renamed from: m, reason: collision with root package name */
    public String f391722m;

    /* renamed from: n, reason: collision with root package name */
    public c[] f391723n;

    /* renamed from: o, reason: collision with root package name */
    public String f391724o;

    /* renamed from: p, reason: collision with root package name */
    public String f391725p;

    /* renamed from: q, reason: collision with root package name */
    public String f391726q;

    public b() {
        a();
    }

    public b a() {
        this.f391710a = "";
        this.f391711b = "";
        this.f391712c = "";
        this.f391713d = "";
        this.f391714e = "";
        this.f391715f = "";
        this.f391716g = "";
        this.f391717h = "";
        this.f391718i = "";
        this.f391719j = "";
        this.f391720k = "";
        this.f391721l = "";
        this.f391722m = "";
        this.f391723n = c.b();
        this.f391724o = "";
        this.f391725p = "";
        this.f391726q = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f391710a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f391711b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f391712c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f391713d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f391714e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f391715f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f391716g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f391717h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f391718i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f391719j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f391720k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f391721l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f391722m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    c[] cVarArr = this.f391723n;
                    if (cVarArr == null) {
                        length = 0;
                    } else {
                        length = cVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    c[] cVarArr2 = new c[i3];
                    if (length != 0) {
                        System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        c cVar = new c();
                        cVarArr2[length] = cVar;
                        codedInputByteBufferNano.readMessage(cVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    c cVar2 = new c();
                    cVarArr2[length] = cVar2;
                    codedInputByteBufferNano.readMessage(cVar2);
                    this.f391723n = cVarArr2;
                    break;
                case 122:
                    this.f391724o = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.f391725p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f391726q = codedInputByteBufferNano.readString();
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
        if (!this.f391710a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f391710a);
        }
        if (!this.f391711b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391711b);
        }
        if (!this.f391712c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f391712c);
        }
        if (!this.f391713d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f391713d);
        }
        if (!this.f391714e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f391714e);
        }
        if (!this.f391715f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f391715f);
        }
        if (!this.f391716g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f391716g);
        }
        if (!this.f391717h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f391717h);
        }
        if (!this.f391718i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f391718i);
        }
        if (!this.f391719j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f391719j);
        }
        if (!this.f391720k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f391720k);
        }
        if (!this.f391721l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f391721l);
        }
        if (!this.f391722m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f391722m);
        }
        c[] cVarArr = this.f391723n;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f391723n;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, cVar);
                }
                i3++;
            }
        }
        if (!this.f391724o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f391724o);
        }
        if (!this.f391725p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f391725p);
        }
        if (!this.f391726q.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.f391726q);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f391710a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f391710a);
        }
        if (!this.f391711b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391711b);
        }
        if (!this.f391712c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f391712c);
        }
        if (!this.f391713d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f391713d);
        }
        if (!this.f391714e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f391714e);
        }
        if (!this.f391715f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f391715f);
        }
        if (!this.f391716g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f391716g);
        }
        if (!this.f391717h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f391717h);
        }
        if (!this.f391718i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f391718i);
        }
        if (!this.f391719j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f391719j);
        }
        if (!this.f391720k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f391720k);
        }
        if (!this.f391721l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f391721l);
        }
        if (!this.f391722m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f391722m);
        }
        c[] cVarArr = this.f391723n;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f391723n;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(14, cVar);
                }
                i3++;
            }
        }
        if (!this.f391724o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f391724o);
        }
        if (!this.f391725p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f391725p);
        }
        if (!this.f391726q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f391726q);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
