package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends ExtendableMessageNano<o> {

    /* renamed from: n, reason: collision with root package name */
    private static volatile o[] f427192n;

    /* renamed from: a, reason: collision with root package name */
    public int f427193a;

    /* renamed from: b, reason: collision with root package name */
    public int f427194b;

    /* renamed from: c, reason: collision with root package name */
    public String f427195c;

    /* renamed from: d, reason: collision with root package name */
    public String f427196d;

    /* renamed from: e, reason: collision with root package name */
    public long f427197e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f427198f;

    /* renamed from: g, reason: collision with root package name */
    public String f427199g;

    /* renamed from: h, reason: collision with root package name */
    public long f427200h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f427201i;

    /* renamed from: j, reason: collision with root package name */
    public String f427202j;

    /* renamed from: k, reason: collision with root package name */
    public String f427203k;

    /* renamed from: l, reason: collision with root package name */
    public long f427204l;

    /* renamed from: m, reason: collision with root package name */
    public long f427205m;

    public o() {
        a();
    }

    public static o[] b() {
        if (f427192n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f427192n == null) {
                    f427192n = new o[0];
                }
            }
        }
        return f427192n;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public o mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f427193a = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.f427194b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f427195c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f427196d = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.f427197e = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.f427198f = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.f427199g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f427200h = codedInputByteBufferNano.readInt64();
                    break;
                case 72:
                    this.f427201i = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    this.f427202j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f427203k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f427204l = codedInputByteBufferNano.readInt64();
                    break;
                case 104:
                    this.f427205m = codedInputByteBufferNano.readInt64();
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
        int i3 = this.f427193a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f427194b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f427195c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427195c);
        }
        if (!this.f427196d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427196d);
        }
        long j3 = this.f427197e;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!Arrays.equals(this.f427198f, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.f427198f);
        }
        if (!this.f427199g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f427199g);
        }
        long j16 = this.f427200h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j16);
        }
        boolean z16 = this.f427201i;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z16);
        }
        if (!this.f427202j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f427202j);
        }
        if (!this.f427203k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f427203k);
        }
        long j17 = this.f427204l;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(12, j17);
        }
        long j18 = this.f427205m;
        return j18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(13, j18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f427193a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f427194b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f427195c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427195c);
        }
        if (!this.f427196d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427196d);
        }
        long j3 = this.f427197e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!Arrays.equals(this.f427198f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f427198f);
        }
        if (!this.f427199g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f427199g);
        }
        long j16 = this.f427200h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j16);
        }
        boolean z16 = this.f427201i;
        if (z16) {
            codedOutputByteBufferNano.writeBool(9, z16);
        }
        if (!this.f427202j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f427202j);
        }
        if (!this.f427203k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f427203k);
        }
        long j17 = this.f427204l;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j17);
        }
        long j18 = this.f427205m;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeInt64(13, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public o a() {
        this.f427193a = 0;
        this.f427194b = 0;
        this.f427195c = "";
        this.f427196d = "";
        this.f427197e = 0L;
        this.f427198f = WireFormatNano.EMPTY_BYTES;
        this.f427199g = "";
        this.f427200h = 0L;
        this.f427201i = false;
        this.f427202j = "";
        this.f427203k = "";
        this.f427204l = 0L;
        this.f427205m = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
