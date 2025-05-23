package or4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: p, reason: collision with root package name */
    private static volatile k[] f423503p;

    /* renamed from: a, reason: collision with root package name */
    public long f423504a;

    /* renamed from: b, reason: collision with root package name */
    public int f423505b;

    /* renamed from: c, reason: collision with root package name */
    public long f423506c;

    /* renamed from: d, reason: collision with root package name */
    public String f423507d;

    /* renamed from: e, reason: collision with root package name */
    public String f423508e;

    /* renamed from: f, reason: collision with root package name */
    public int f423509f;

    /* renamed from: g, reason: collision with root package name */
    public String f423510g;

    /* renamed from: h, reason: collision with root package name */
    public long f423511h;

    /* renamed from: i, reason: collision with root package name */
    public long f423512i;

    /* renamed from: j, reason: collision with root package name */
    public long f423513j;

    /* renamed from: k, reason: collision with root package name */
    public m f423514k;

    /* renamed from: l, reason: collision with root package name */
    public int f423515l;

    /* renamed from: m, reason: collision with root package name */
    public String[] f423516m;

    /* renamed from: n, reason: collision with root package name */
    public String f423517n;

    /* renamed from: o, reason: collision with root package name */
    public int f423518o;

    public k() {
        a();
    }

    public static k[] b() {
        if (f423503p == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423503p == null) {
                    f423503p = new k[0];
                }
            }
        }
        return f423503p;
    }

    public k a() {
        this.f423504a = 0L;
        this.f423505b = 0;
        this.f423506c = 0L;
        this.f423507d = "";
        this.f423508e = "";
        this.f423509f = 0;
        this.f423510g = "";
        this.f423511h = 0L;
        this.f423512i = 0L;
        this.f423513j = 0L;
        this.f423514k = null;
        this.f423515l = 0;
        this.f423516m = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f423517n = "";
        this.f423518o = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f423504a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f423505b = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.f423506c = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.f423507d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f423508e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f423509f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.f423510g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f423511h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f423512i = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.f423513j = codedInputByteBufferNano.readUInt64();
                    break;
                case 90:
                    if (this.f423514k == null) {
                        this.f423514k = new m();
                    }
                    codedInputByteBufferNano.readMessage(this.f423514k);
                    break;
                case 96:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f423515l = readInt32;
                        break;
                    }
                case 106:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    String[] strArr = this.f423516m;
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
                    this.f423516m = strArr2;
                    break;
                case 114:
                    this.f423517n = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.f423518o = codedInputByteBufferNano.readUInt32();
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
        long j3 = this.f423504a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f423505b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.f423506c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        if (!this.f423507d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f423507d);
        }
        if (!this.f423508e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f423508e);
        }
        int i16 = this.f423509f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        if (!this.f423510g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f423510g);
        }
        long j17 = this.f423511h;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        long j18 = this.f423512i;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j18);
        }
        long j19 = this.f423513j;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j19);
        }
        m mVar = this.f423514k;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, mVar);
        }
        int i17 = this.f423515l;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i17);
        }
        String[] strArr = this.f423516m;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr2 = this.f423516m;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    i26++;
                    i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (i26 * 1);
        }
        if (!this.f423517n.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.f423517n);
        }
        int i27 = this.f423518o;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(15, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f423504a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f423505b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.f423506c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        if (!this.f423507d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f423507d);
        }
        if (!this.f423508e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f423508e);
        }
        int i16 = this.f423509f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        if (!this.f423510g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f423510g);
        }
        long j17 = this.f423511h;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        long j18 = this.f423512i;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j18);
        }
        long j19 = this.f423513j;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j19);
        }
        m mVar = this.f423514k;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(11, mVar);
        }
        int i17 = this.f423515l;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i17);
        }
        String[] strArr = this.f423516m;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f423516m;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(13, str);
                }
                i18++;
            }
        }
        if (!this.f423517n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.f423517n);
        }
        int i19 = this.f423518o;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
