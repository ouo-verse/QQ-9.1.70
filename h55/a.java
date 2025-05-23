package h55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f404387a;

    /* renamed from: b, reason: collision with root package name */
    public int f404388b;

    /* renamed from: c, reason: collision with root package name */
    public String f404389c;

    /* renamed from: d, reason: collision with root package name */
    public String f404390d;

    /* renamed from: e, reason: collision with root package name */
    public String f404391e;

    /* renamed from: f, reason: collision with root package name */
    public int f404392f;

    /* renamed from: g, reason: collision with root package name */
    public d f404393g;

    /* renamed from: h, reason: collision with root package name */
    public long f404394h;

    /* renamed from: i, reason: collision with root package name */
    public int f404395i;

    /* renamed from: j, reason: collision with root package name */
    public long f404396j;

    /* renamed from: k, reason: collision with root package name */
    public long f404397k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f404398l;

    /* renamed from: m, reason: collision with root package name */
    public String f404399m;

    /* renamed from: n, reason: collision with root package name */
    public int f404400n;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f404387a = 0L;
        this.f404388b = 0;
        this.f404389c = "";
        this.f404390d = "";
        this.f404391e = "";
        this.f404392f = 0;
        this.f404393g = null;
        this.f404394h = 0L;
        this.f404395i = 0;
        this.f404396j = 0L;
        this.f404397k = 0L;
        this.f404398l = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f404399m = "";
        this.f404400n = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f404387a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.f404388b = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.f404389c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.f404390d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.f404391e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f404392f = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    if (this.f404393g == null) {
                        this.f404393g = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f404393g);
                    break;
                case 64:
                    this.f404394h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f404395i = readInt32;
                        break;
                    }
                case 80:
                    this.f404396j = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.f404397k = codedInputByteBufferNano.readUInt64();
                    break;
                case 98:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    String[] strArr = this.f404398l;
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
                    this.f404398l = strArr2;
                    break;
                case 106:
                    this.f404399m = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.f404400n = codedInputByteBufferNano.readUInt32();
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
        long j3 = this.f404387a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f404388b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.f404389c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f404389c);
        }
        if (!this.f404390d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f404390d);
        }
        if (!this.f404391e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f404391e);
        }
        int i16 = this.f404392f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        d dVar = this.f404393g;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, dVar);
        }
        long j16 = this.f404394h;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        int i17 = this.f404395i;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i17);
        }
        long j17 = this.f404396j;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j17);
        }
        long j18 = this.f404397k;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j18);
        }
        String[] strArr = this.f404398l;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr2 = this.f404398l;
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
        if (!this.f404399m.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.f404399m);
        }
        int i27 = this.f404400n;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(14, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f404387a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f404388b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.f404389c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f404389c);
        }
        if (!this.f404390d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f404390d);
        }
        if (!this.f404391e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f404391e);
        }
        int i16 = this.f404392f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        d dVar = this.f404393g;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(7, dVar);
        }
        long j16 = this.f404394h;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        int i17 = this.f404395i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        long j17 = this.f404396j;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j17);
        }
        long j18 = this.f404397k;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j18);
        }
        String[] strArr = this.f404398l;
        if (strArr != null && strArr.length > 0) {
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f404398l;
                if (i18 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i18];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(12, str);
                }
                i18++;
            }
        }
        if (!this.f404399m.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.f404399m);
        }
        int i19 = this.f404400n;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
