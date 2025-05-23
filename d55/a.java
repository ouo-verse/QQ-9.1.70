package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: l, reason: collision with root package name */
    private static volatile a[] f393048l;

    /* renamed from: a, reason: collision with root package name */
    public long f393049a;

    /* renamed from: b, reason: collision with root package name */
    public long f393050b;

    /* renamed from: c, reason: collision with root package name */
    public int f393051c;

    /* renamed from: d, reason: collision with root package name */
    public String f393052d;

    /* renamed from: e, reason: collision with root package name */
    public String f393053e;

    /* renamed from: f, reason: collision with root package name */
    public int f393054f;

    /* renamed from: g, reason: collision with root package name */
    public int f393055g;

    /* renamed from: h, reason: collision with root package name */
    public String f393056h;

    /* renamed from: i, reason: collision with root package name */
    public int f393057i;

    /* renamed from: j, reason: collision with root package name */
    public sr4.g[] f393058j;

    /* renamed from: k, reason: collision with root package name */
    public f f393059k;

    public a() {
        a();
    }

    public static a[] b() {
        if (f393048l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f393048l == null) {
                    f393048l = new a[0];
                }
            }
        }
        return f393048l;
    }

    public a a() {
        this.f393049a = 0L;
        this.f393050b = 0L;
        this.f393051c = 0;
        this.f393052d = "";
        this.f393053e = "";
        this.f393054f = 0;
        this.f393055g = 0;
        this.f393056h = "";
        this.f393057i = 0;
        this.f393058j = sr4.g.b();
        this.f393059k = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f393049a = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f393050b = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f393051c = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f393052d = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.f393053e = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.f393054f = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.f393055g = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.f393056h = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f393057i = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    sr4.g[] gVarArr = this.f393058j;
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
                    this.f393058j = gVarArr2;
                    break;
                case 122:
                    if (this.f393059k == null) {
                        this.f393059k = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f393059k);
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
        long j3 = this.f393049a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f393050b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        int i3 = this.f393051c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        if (!this.f393052d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f393052d);
        }
        if (!this.f393053e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f393053e);
        }
        int i16 = this.f393054f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i16);
        }
        int i17 = this.f393055g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        if (!this.f393056h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f393056h);
        }
        int i18 = this.f393057i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i18);
        }
        sr4.g[] gVarArr = this.f393058j;
        if (gVarArr != null && gVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f393058j;
                if (i19 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i19];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, gVar);
                }
                i19++;
            }
        }
        f fVar = this.f393059k;
        if (fVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(15, fVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f393049a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f393050b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        int i3 = this.f393051c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.f393052d.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f393052d);
        }
        if (!this.f393053e.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f393053e);
        }
        int i16 = this.f393054f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i16);
        }
        int i17 = this.f393055g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        if (!this.f393056h.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f393056h);
        }
        int i18 = this.f393057i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i18);
        }
        sr4.g[] gVarArr = this.f393058j;
        if (gVarArr != null && gVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                sr4.g[] gVarArr2 = this.f393058j;
                if (i19 >= gVarArr2.length) {
                    break;
                }
                sr4.g gVar = gVarArr2[i19];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(13, gVar);
                }
                i19++;
            }
        }
        f fVar = this.f393059k;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(15, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
