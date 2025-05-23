package nq3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f420717a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f420718b;

    /* renamed from: c, reason: collision with root package name */
    public long f420719c;

    /* renamed from: d, reason: collision with root package name */
    public long f420720d;

    /* renamed from: e, reason: collision with root package name */
    public int f420721e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f420722f;

    /* renamed from: g, reason: collision with root package name */
    public String f420723g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f420724h;

    /* renamed from: i, reason: collision with root package name */
    public int f420725i;

    /* renamed from: j, reason: collision with root package name */
    public long f420726j;

    public h() {
        a();
    }

    public h a() {
        this.f420717a = false;
        this.f420718b = false;
        this.f420719c = 0L;
        this.f420720d = 0L;
        this.f420721e = 0;
        this.f420722f = false;
        this.f420723g = "";
        this.f420724h = WireFormatNano.EMPTY_INT_ARRAY;
        this.f420725i = 0;
        this.f420726j = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f420717a = codedInputByteBufferNano.readBool();
                    break;
                case 16:
                    this.f420718b = codedInputByteBufferNano.readBool();
                    break;
                case 24:
                    this.f420719c = codedInputByteBufferNano.readInt64();
                    break;
                case 32:
                    this.f420720d = codedInputByteBufferNano.readInt64();
                    break;
                case 40:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.f420721e = readInt32;
                        break;
                    }
                case 48:
                    this.f420722f = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    this.f420723g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 64);
                    int[] iArr = this.f420724h;
                    if (iArr == null) {
                        length = 0;
                    } else {
                        length = iArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    int[] iArr2 = new int[i3];
                    if (length != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readInt32();
                    this.f420724h = iArr2;
                    break;
                case 66:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readInt32();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.f420724h;
                    if (iArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = iArr3.length;
                    }
                    int i17 = i16 + length2;
                    int[] iArr4 = new int[i17];
                    if (length2 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        iArr4[length2] = codedInputByteBufferNano.readInt32();
                        length2++;
                    }
                    this.f420724h = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 72:
                    this.f420725i = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.f420726j = codedInputByteBufferNano.readInt64();
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
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f420717a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f420718b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        long j3 = this.f420719c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        long j16 = this.f420720d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j16);
        }
        int i3 = this.f420721e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        boolean z18 = this.f420722f;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z18);
        }
        if (!this.f420723g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f420723g);
        }
        int[] iArr2 = this.f420724h;
        if (iArr2 != null && iArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr = this.f420724h;
                if (i16 >= iArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr.length * 1);
        }
        int i18 = this.f420725i;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i18);
        }
        long j17 = this.f420726j;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(10, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f420717a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f420718b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        long j3 = this.f420719c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        long j16 = this.f420720d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j16);
        }
        int i3 = this.f420721e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        boolean z18 = this.f420722f;
        if (z18) {
            codedOutputByteBufferNano.writeBool(6, z18);
        }
        if (!this.f420723g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f420723g);
        }
        int[] iArr = this.f420724h;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f420724h;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(8, iArr2[i16]);
                i16++;
            }
        }
        int i17 = this.f420725i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        long j17 = this.f420726j;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(10, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
