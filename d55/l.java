package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: q, reason: collision with root package name */
    private static volatile l[] f393097q;

    /* renamed from: a, reason: collision with root package name */
    public int f393098a;

    /* renamed from: b, reason: collision with root package name */
    public String f393099b;

    /* renamed from: c, reason: collision with root package name */
    public int f393100c;

    /* renamed from: d, reason: collision with root package name */
    public int f393101d;

    /* renamed from: e, reason: collision with root package name */
    public int f393102e;

    /* renamed from: f, reason: collision with root package name */
    public String f393103f;

    /* renamed from: g, reason: collision with root package name */
    public long f393104g;

    /* renamed from: h, reason: collision with root package name */
    public String f393105h;

    /* renamed from: i, reason: collision with root package name */
    public String f393106i;

    /* renamed from: j, reason: collision with root package name */
    public long f393107j;

    /* renamed from: k, reason: collision with root package name */
    public int f393108k;

    /* renamed from: l, reason: collision with root package name */
    public sr4.g[] f393109l;

    /* renamed from: m, reason: collision with root package name */
    public int f393110m;

    /* renamed from: n, reason: collision with root package name */
    public long f393111n;

    /* renamed from: o, reason: collision with root package name */
    public pq4.c f393112o;

    /* renamed from: p, reason: collision with root package name */
    public long f393113p;

    public l() {
        a();
    }

    public static l[] b() {
        if (f393097q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f393097q == null) {
                    f393097q = new l[0];
                }
            }
        }
        return f393097q;
    }

    public l a() {
        this.f393098a = 0;
        this.f393099b = "";
        this.f393100c = 0;
        this.f393101d = 0;
        this.f393102e = 0;
        this.f393103f = "";
        this.f393104g = 0L;
        this.f393105h = "";
        this.f393106i = "";
        this.f393107j = 0L;
        this.f393108k = 0;
        this.f393109l = sr4.g.b();
        this.f393110m = 0;
        this.f393111n = 0L;
        this.f393112o = null;
        this.f393113p = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f393098a = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.f393099b = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.f393100c = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.f393101d = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.f393102e = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.f393103f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f393104g = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.f393105h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f393106i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.f393107j = codedInputByteBufferNano.readInt64();
                    break;
                case 88:
                    this.f393108k = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    sr4.g[] gVarArr = this.f393109l;
                    if (gVarArr == null) {
                        length = 0;
                    } else {
                        length = gVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    sr4.g[] gVarArr2 = new sr4.g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        sr4.g gVar = new sr4.g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sr4.g gVar2 = new sr4.g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f393109l = gVarArr2;
                    break;
                case 104:
                    this.f393110m = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.f393111n = codedInputByteBufferNano.readInt64();
                    break;
                case 122:
                    if (this.f393112o == null) {
                        this.f393112o = new pq4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f393112o);
                    break;
                case 128:
                    this.f393113p = codedInputByteBufferNano.readUInt64();
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
        int i3 = this.f393098a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f393099b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f393099b);
        }
        int i16 = this.f393100c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f393101d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.f393102e;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        if (!this.f393103f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f393103f);
        }
        long j3 = this.f393104g;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        if (!this.f393105h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f393105h);
        }
        if (!this.f393106i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f393106i);
        }
        long j16 = this.f393107j;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, j16);
        }
        int i19 = this.f393108k;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        sr4.g[] gVarArr = this.f393109l;
        if (gVarArr != null && gVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f393109l;
                if (i26 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i26];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, gVar);
                }
                i26++;
            }
        }
        int i27 = this.f393110m;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i27);
        }
        long j17 = this.f393111n;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(14, j17);
        }
        pq4.c cVar = this.f393112o;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, cVar);
        }
        long j18 = this.f393113p;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(16, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f393098a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f393099b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f393099b);
        }
        int i16 = this.f393100c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f393101d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.f393102e;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        if (!this.f393103f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f393103f);
        }
        long j3 = this.f393104g;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        if (!this.f393105h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f393105h);
        }
        if (!this.f393106i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f393106i);
        }
        long j16 = this.f393107j;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(10, j16);
        }
        int i19 = this.f393108k;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        sr4.g[] gVarArr = this.f393109l;
        if (gVarArr != null && gVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f393109l;
                if (i26 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i26];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(12, gVar);
                }
                i26++;
            }
        }
        int i27 = this.f393110m;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i27);
        }
        long j17 = this.f393111n;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(14, j17);
        }
        pq4.c cVar = this.f393112o;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(15, cVar);
        }
        long j18 = this.f393113p;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
