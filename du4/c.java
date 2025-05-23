package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: w, reason: collision with root package name */
    private static volatile c[] f394933w;

    /* renamed from: a, reason: collision with root package name */
    public j f394934a;

    /* renamed from: b, reason: collision with root package name */
    public b f394935b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f394936c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f394937d;

    /* renamed from: e, reason: collision with root package name */
    public int f394938e;

    /* renamed from: f, reason: collision with root package name */
    public int f394939f;

    /* renamed from: g, reason: collision with root package name */
    public String f394940g;

    /* renamed from: h, reason: collision with root package name */
    public int f394941h;

    /* renamed from: i, reason: collision with root package name */
    public int f394942i;

    /* renamed from: j, reason: collision with root package name */
    public String f394943j;

    /* renamed from: k, reason: collision with root package name */
    public String f394944k;

    /* renamed from: l, reason: collision with root package name */
    public int f394945l;

    /* renamed from: m, reason: collision with root package name */
    public String f394946m;

    /* renamed from: n, reason: collision with root package name */
    public String f394947n;

    /* renamed from: o, reason: collision with root package name */
    public g f394948o;

    /* renamed from: p, reason: collision with root package name */
    public String f394949p;

    /* renamed from: q, reason: collision with root package name */
    public String f394950q;

    /* renamed from: r, reason: collision with root package name */
    public String f394951r;

    /* renamed from: s, reason: collision with root package name */
    public String f394952s;

    /* renamed from: t, reason: collision with root package name */
    public String f394953t;

    /* renamed from: u, reason: collision with root package name */
    public String f394954u;

    /* renamed from: v, reason: collision with root package name */
    public e f394955v;

    public c() {
        a();
    }

    public static c[] b() {
        if (f394933w == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f394933w == null) {
                    f394933w = new c[0];
                }
            }
        }
        return f394933w;
    }

    public c a() {
        this.f394934a = null;
        this.f394935b = null;
        this.f394936c = false;
        this.f394937d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f394938e = 0;
        this.f394939f = 0;
        this.f394940g = "";
        this.f394941h = 0;
        this.f394942i = 0;
        this.f394943j = "";
        this.f394944k = "";
        this.f394945l = 0;
        this.f394946m = "";
        this.f394947n = "";
        this.f394948o = null;
        this.f394949p = "";
        this.f394950q = "";
        this.f394951r = "";
        this.f394952s = "";
        this.f394953t = "";
        this.f394954u = "";
        this.f394955v = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    if (this.f394934a == null) {
                        this.f394934a = new j();
                    }
                    codedInputByteBufferNano.readMessage(this.f394934a);
                    break;
                case 18:
                    if (this.f394935b == null) {
                        this.f394935b = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f394935b);
                    break;
                case 24:
                    this.f394936c = codedInputByteBufferNano.readBool();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.f394937d;
                    if (strArr == null) {
                        length = 0;
                    } else {
                        length = strArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i3];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.f394937d = strArr2;
                    break;
                case 40:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 5) {
                        break;
                    } else {
                        this.f394938e = readInt32;
                        break;
                    }
                case 48:
                    this.f394939f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    this.f394940g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f394941h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f394942i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f394943j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f394944k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f394945l = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    this.f394946m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f394947n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    if (this.f394948o == null) {
                        this.f394948o = new g();
                    }
                    codedInputByteBufferNano.readMessage(this.f394948o);
                    break;
                case 130:
                    this.f394949p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f394950q = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.f394951r = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.f394952s = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.f394953t = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f394954u = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    if (this.f394955v == null) {
                        this.f394955v = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f394955v);
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
        j jVar = this.f394934a;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, jVar);
        }
        b bVar = this.f394935b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        boolean z16 = this.f394936c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        String[] strArr = this.f394937d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f394937d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        int i18 = this.f394938e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        int i19 = this.f394939f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i19);
        }
        if (!this.f394940g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f394940g);
        }
        int i26 = this.f394941h;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i26);
        }
        int i27 = this.f394942i;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i27);
        }
        if (!this.f394943j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f394943j);
        }
        if (!this.f394944k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f394944k);
        }
        int i28 = this.f394945l;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i28);
        }
        if (!this.f394946m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f394946m);
        }
        if (!this.f394947n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f394947n);
        }
        g gVar = this.f394948o;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, gVar);
        }
        if (!this.f394949p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f394949p);
        }
        if (!this.f394950q.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.f394950q);
        }
        if (!this.f394951r.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.f394951r);
        }
        if (!this.f394952s.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.f394952s);
        }
        if (!this.f394953t.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.f394953t);
        }
        if (!this.f394954u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f394954u);
        }
        e eVar = this.f394955v;
        if (eVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(22, eVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        j jVar = this.f394934a;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(1, jVar);
        }
        b bVar = this.f394935b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        boolean z16 = this.f394936c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        String[] strArr = this.f394937d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f394937d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i3++;
            }
        }
        int i16 = this.f394938e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f394939f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        if (!this.f394940g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f394940g);
        }
        int i18 = this.f394941h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        int i19 = this.f394942i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i19);
        }
        if (!this.f394943j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f394943j);
        }
        if (!this.f394944k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f394944k);
        }
        int i26 = this.f394945l;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i26);
        }
        if (!this.f394946m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f394946m);
        }
        if (!this.f394947n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f394947n);
        }
        g gVar = this.f394948o;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(15, gVar);
        }
        if (!this.f394949p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f394949p);
        }
        if (!this.f394950q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f394950q);
        }
        if (!this.f394951r.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.f394951r);
        }
        if (!this.f394952s.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.f394952s);
        }
        if (!this.f394953t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f394953t);
        }
        if (!this.f394954u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f394954u);
        }
        e eVar = this.f394955v;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(22, eVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
