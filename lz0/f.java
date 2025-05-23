package lz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public long f415816a;

    /* renamed from: b, reason: collision with root package name */
    public String f415817b;

    /* renamed from: c, reason: collision with root package name */
    public String f415818c;

    /* renamed from: d, reason: collision with root package name */
    public long f415819d;

    /* renamed from: e, reason: collision with root package name */
    public e[] f415820e;

    /* renamed from: f, reason: collision with root package name */
    public int f415821f;

    /* renamed from: g, reason: collision with root package name */
    public long f415822g;

    /* renamed from: h, reason: collision with root package name */
    public int f415823h;

    /* renamed from: i, reason: collision with root package name */
    public int f415824i;

    /* renamed from: j, reason: collision with root package name */
    public String f415825j;

    /* renamed from: k, reason: collision with root package name */
    public String f415826k;

    /* renamed from: l, reason: collision with root package name */
    public long f415827l;

    /* renamed from: m, reason: collision with root package name */
    public long f415828m;

    /* renamed from: n, reason: collision with root package name */
    public int f415829n;

    public f() {
        a();
    }

    public f a() {
        this.f415816a = 0L;
        this.f415817b = "";
        this.f415818c = "";
        this.f415819d = 0L;
        this.f415820e = e.b();
        this.f415821f = 0;
        this.f415822g = 0L;
        this.f415823h = 0;
        this.f415824i = 0;
        this.f415825j = "";
        this.f415826k = "";
        this.f415827l = 0L;
        this.f415828m = 0L;
        this.f415829n = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f415816a = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.f415817b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f415818c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f415819d = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    e[] eVarArr = this.f415820e;
                    if (eVarArr == null) {
                        length = 0;
                    } else {
                        length = eVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    e[] eVarArr2 = new e[i3];
                    if (length != 0) {
                        System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        e eVar = new e();
                        eVarArr2[length] = eVar;
                        codedInputByteBufferNano.readMessage(eVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    e eVar2 = new e();
                    eVarArr2[length] = eVar2;
                    codedInputByteBufferNano.readMessage(eVar2);
                    this.f415820e = eVarArr2;
                    break;
                case 48:
                    this.f415821f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f415822g = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.f415823h = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.f415824i = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.f415825j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.f415826k = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.f415827l = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.f415828m = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.f415829n = codedInputByteBufferNano.readUInt32();
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
        long j3 = this.f415816a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f415817b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415817b);
        }
        if (!this.f415818c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f415818c);
        }
        long j16 = this.f415819d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        e[] eVarArr = this.f415820e;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f415820e;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f415821f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        long j17 = this.f415822g;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        int i17 = this.f415823h;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        int i18 = this.f415824i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i18);
        }
        if (!this.f415825j.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.f415825j);
        }
        if (!this.f415826k.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.f415826k);
        }
        long j18 = this.f415827l;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j18);
        }
        long j19 = this.f415828m;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j19);
        }
        int i19 = this.f415829n;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(14, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f415816a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f415817b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415817b);
        }
        if (!this.f415818c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f415818c);
        }
        long j16 = this.f415819d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        e[] eVarArr = this.f415820e;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f415820e;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, eVar);
                }
                i3++;
            }
        }
        int i16 = this.f415821f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        long j17 = this.f415822g;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        int i17 = this.f415823h;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        int i18 = this.f415824i;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i18);
        }
        if (!this.f415825j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f415825j);
        }
        if (!this.f415826k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f415826k);
        }
        long j18 = this.f415827l;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j18);
        }
        long j19 = this.f415828m;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j19);
        }
        int i19 = this.f415829n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
