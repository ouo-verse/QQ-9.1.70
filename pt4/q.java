package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: r, reason: collision with root package name */
    private static volatile q[] f427213r;

    /* renamed from: a, reason: collision with root package name */
    public long f427214a;

    /* renamed from: b, reason: collision with root package name */
    public int f427215b;

    /* renamed from: c, reason: collision with root package name */
    public int f427216c;

    /* renamed from: d, reason: collision with root package name */
    public int f427217d;

    /* renamed from: e, reason: collision with root package name */
    public int f427218e;

    /* renamed from: f, reason: collision with root package name */
    public String f427219f;

    /* renamed from: g, reason: collision with root package name */
    public String f427220g;

    /* renamed from: h, reason: collision with root package name */
    public String f427221h;

    /* renamed from: i, reason: collision with root package name */
    public String f427222i;

    /* renamed from: j, reason: collision with root package name */
    public String f427223j;

    /* renamed from: k, reason: collision with root package name */
    public String f427224k;

    /* renamed from: l, reason: collision with root package name */
    public String f427225l;

    /* renamed from: m, reason: collision with root package name */
    public String f427226m;

    /* renamed from: n, reason: collision with root package name */
    public String f427227n;

    /* renamed from: o, reason: collision with root package name */
    public String f427228o;

    /* renamed from: p, reason: collision with root package name */
    public String f427229p;

    /* renamed from: q, reason: collision with root package name */
    public String f427230q;

    public q() {
        a();
    }

    public static q[] b() {
        if (f427213r == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427213r == null) {
                    f427213r = new q[0];
                }
            }
        }
        return f427213r;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427214a = codedInputByteBufferNano.readInt64();
                    break;
                case 16:
                    this.f427215b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f427216c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f427217d = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.f427218e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f427219f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f427220g = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f427221h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f427222i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.f427223j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f427224k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.f427225l = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.f427226m = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.f427227n = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.f427228o = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.f427229p = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.f427230q = codedInputByteBufferNano.readString();
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
        long j3 = this.f427214a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.f427215b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f427216c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f427217d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        int i18 = this.f427218e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        if (!this.f427219f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f427219f);
        }
        if (!this.f427220g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427220g);
        }
        if (!this.f427221h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f427221h);
        }
        if (!this.f427222i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f427222i);
        }
        if (!this.f427223j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f427223j);
        }
        if (!this.f427224k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427224k);
        }
        if (!this.f427225l.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.f427225l);
        }
        if (!this.f427226m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f427226m);
        }
        if (!this.f427227n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f427227n);
        }
        if (!this.f427228o.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.f427228o);
        }
        if (!this.f427229p.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.f427229p);
        }
        return !this.f427230q.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.f427230q) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f427214a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.f427215b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f427216c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f427217d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        int i18 = this.f427218e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        if (!this.f427219f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427219f);
        }
        if (!this.f427220g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427220g);
        }
        if (!this.f427221h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f427221h);
        }
        if (!this.f427222i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f427222i);
        }
        if (!this.f427223j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427223j);
        }
        if (!this.f427224k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427224k);
        }
        if (!this.f427225l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.f427225l);
        }
        if (!this.f427226m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f427226m);
        }
        if (!this.f427227n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f427227n);
        }
        if (!this.f427228o.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.f427228o);
        }
        if (!this.f427229p.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.f427229p);
        }
        if (!this.f427230q.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.f427230q);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public q a() {
        this.f427214a = 0L;
        this.f427215b = 0;
        this.f427216c = 0;
        this.f427217d = 0;
        this.f427218e = 0;
        this.f427219f = "";
        this.f427220g = "";
        this.f427221h = "";
        this.f427222i = "";
        this.f427223j = "";
        this.f427224k = "";
        this.f427225l = "";
        this.f427226m = "";
        this.f427227n = "";
        this.f427228o = "";
        this.f427229p = "";
        this.f427230q = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
