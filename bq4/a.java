package bq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f28985a;

    /* renamed from: b, reason: collision with root package name */
    public long f28986b;

    /* renamed from: c, reason: collision with root package name */
    public int f28987c;

    /* renamed from: d, reason: collision with root package name */
    public int f28988d;

    /* renamed from: e, reason: collision with root package name */
    public long f28989e;

    /* renamed from: f, reason: collision with root package name */
    public long f28990f;

    /* renamed from: g, reason: collision with root package name */
    public long[] f28991g;

    /* renamed from: h, reason: collision with root package name */
    public long f28992h;

    /* renamed from: i, reason: collision with root package name */
    public long f28993i;

    /* renamed from: j, reason: collision with root package name */
    public int f28994j;

    public a() {
        a();
    }

    public a a() {
        this.f28985a = "";
        this.f28986b = 0L;
        this.f28987c = 0;
        this.f28988d = 0;
        this.f28989e = 0L;
        this.f28990f = 0L;
        this.f28991g = WireFormatNano.EMPTY_LONG_ARRAY;
        this.f28992h = 0L;
        this.f28993i = 0L;
        this.f28994j = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f28985a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.f28986b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                        switch (readInt32) {
                        }
                    }
                    this.f28987c = readInt32;
                    break;
                case 32:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3) {
                        break;
                    } else {
                        this.f28988d = readInt322;
                        break;
                    }
                case 40:
                    this.f28989e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.f28990f = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                    long[] jArr = this.f28991g;
                    if (jArr == null) {
                        length = 0;
                    } else {
                        length = jArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    long[] jArr2 = new long[i3];
                    if (length != 0) {
                        System.arraycopy(jArr, 0, jArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.f28991g = jArr2;
                    break;
                case 58:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.f28991g;
                    if (jArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = jArr3.length;
                    }
                    int i17 = i16 + length2;
                    long[] jArr4 = new long[i17];
                    if (length2 != 0) {
                        System.arraycopy(jArr3, 0, jArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.f28991g = jArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 64:
                    this.f28992h = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.f28993i = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.f28994j = codedInputByteBufferNano.readInt32();
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
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f28985a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f28985a);
        }
        long j3 = this.f28986b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f28987c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int i16 = this.f28988d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        long j16 = this.f28989e;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.f28990f;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        long[] jArr2 = this.f28991g;
        if (jArr2 != null && jArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                jArr = this.f28991g;
                if (i17 >= jArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (jArr.length * 1);
        }
        long j18 = this.f28992h;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j18);
        }
        long j19 = this.f28993i;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j19);
        }
        int i19 = this.f28994j;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(10, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f28985a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f28985a);
        }
        long j3 = this.f28986b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f28987c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i16 = this.f28988d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        long j16 = this.f28989e;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.f28990f;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        long[] jArr = this.f28991g;
        if (jArr != null && jArr.length > 0) {
            int i17 = 0;
            while (true) {
                long[] jArr2 = this.f28991g;
                if (i17 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(7, jArr2[i17]);
                i17++;
            }
        }
        long j18 = this.f28992h;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j18);
        }
        long j19 = this.f28993i;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j19);
        }
        int i18 = this.f28994j;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
