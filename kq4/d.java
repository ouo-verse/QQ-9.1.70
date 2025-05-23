package kq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.MapFactories;
import java.io.IOException;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: w, reason: collision with root package name */
    private static volatile d[] f412877w;

    /* renamed from: a, reason: collision with root package name */
    public int f412878a;

    /* renamed from: b, reason: collision with root package name */
    public String f412879b;

    /* renamed from: c, reason: collision with root package name */
    public String f412880c;

    /* renamed from: d, reason: collision with root package name */
    public String f412881d;

    /* renamed from: e, reason: collision with root package name */
    public int f412882e;

    /* renamed from: f, reason: collision with root package name */
    public int f412883f;

    /* renamed from: g, reason: collision with root package name */
    public String f412884g;

    /* renamed from: h, reason: collision with root package name */
    public String f412885h;

    /* renamed from: i, reason: collision with root package name */
    public String f412886i;

    /* renamed from: j, reason: collision with root package name */
    public String f412887j;

    /* renamed from: k, reason: collision with root package name */
    public String f412888k;

    /* renamed from: l, reason: collision with root package name */
    public String f412889l;

    /* renamed from: m, reason: collision with root package name */
    public String f412890m;

    /* renamed from: n, reason: collision with root package name */
    public String f412891n;

    /* renamed from: o, reason: collision with root package name */
    public String f412892o;

    /* renamed from: p, reason: collision with root package name */
    public String f412893p;

    /* renamed from: q, reason: collision with root package name */
    public Map<String, String> f412894q;

    /* renamed from: r, reason: collision with root package name */
    public int f412895r;

    /* renamed from: s, reason: collision with root package name */
    public int f412896s;

    /* renamed from: t, reason: collision with root package name */
    public String f412897t;

    /* renamed from: u, reason: collision with root package name */
    public String f412898u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f412899v;

    public d() {
        a();
    }

    public static d[] b() {
        if (f412877w == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f412877w == null) {
                    f412877w = new d[0];
                }
            }
        }
        return f412877w;
    }

    public d a() {
        this.f412878a = 0;
        this.f412879b = "";
        this.f412880c = "";
        this.f412881d = "";
        this.f412882e = 0;
        this.f412883f = 0;
        this.f412884g = "";
        this.f412885h = "";
        this.f412886i = "";
        this.f412887j = "";
        this.f412888k = "";
        this.f412889l = "";
        this.f412890m = "";
        this.f412891n = "";
        this.f412892o = "";
        this.f412893p = "";
        this.f412894q = null;
        this.f412895r = 0;
        this.f412896s = 0;
        this.f412897t = "";
        this.f412898u = "";
        this.f412899v = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f412878a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.f412879b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f412880c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f412881d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f412882e = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.f412883f = codedInputByteBufferNano.readInt32();
                    break;
                case 58:
                    this.f412884g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f412885h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f412886i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f412887j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f412888k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f412889l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f412890m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f412891n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f412892o = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.f412893p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f412894q = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.f412894q, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 144:
                    this.f412895r = codedInputByteBufferNano.readInt32();
                    break;
                case 152:
                    this.f412896s = codedInputByteBufferNano.readInt32();
                    break;
                case 162:
                    this.f412897t = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.f412898u = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.f412899v = codedInputByteBufferNano.readBool();
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
        int i3 = this.f412878a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f412879b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f412879b);
        }
        if (!this.f412880c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f412880c);
        }
        if (!this.f412881d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f412881d);
        }
        int i16 = this.f412882e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f412883f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        if (!this.f412884g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f412884g);
        }
        if (!this.f412885h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f412885h);
        }
        if (!this.f412886i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f412886i);
        }
        if (!this.f412887j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f412887j);
        }
        if (!this.f412888k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f412888k);
        }
        if (!this.f412889l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f412889l);
        }
        if (!this.f412890m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f412890m);
        }
        if (!this.f412891n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f412891n);
        }
        if (!this.f412892o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f412892o);
        }
        if (!this.f412893p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f412893p);
        }
        Map<String, String> map = this.f412894q;
        if (map != null) {
            computeSerializedSize += InternalNano.computeMapFieldSize(map, 17, 9, 9);
        }
        int i18 = this.f412895r;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(18, i18);
        }
        int i19 = this.f412896s;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(19, i19);
        }
        if (!this.f412897t.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.f412897t);
        }
        if (!this.f412898u.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.f412898u);
        }
        boolean z16 = this.f412899v;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(22, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f412878a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f412879b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f412879b);
        }
        if (!this.f412880c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f412880c);
        }
        if (!this.f412881d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f412881d);
        }
        int i16 = this.f412882e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f412883f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        if (!this.f412884g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f412884g);
        }
        if (!this.f412885h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f412885h);
        }
        if (!this.f412886i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f412886i);
        }
        if (!this.f412887j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f412887j);
        }
        if (!this.f412888k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f412888k);
        }
        if (!this.f412889l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f412889l);
        }
        if (!this.f412890m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f412890m);
        }
        if (!this.f412891n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f412891n);
        }
        if (!this.f412892o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f412892o);
        }
        if (!this.f412893p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f412893p);
        }
        Map<String, String> map = this.f412894q;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 17, 9, 9);
        }
        int i18 = this.f412895r;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(18, i18);
        }
        int i19 = this.f412896s;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(19, i19);
        }
        if (!this.f412897t.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.f412897t);
        }
        if (!this.f412898u.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.f412898u);
        }
        boolean z16 = this.f412899v;
        if (z16) {
            codedOutputByteBufferNano.writeBool(22, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
