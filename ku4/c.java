package ku4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f413088a;

    /* renamed from: b, reason: collision with root package name */
    public a f413089b;

    /* renamed from: c, reason: collision with root package name */
    public int f413090c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f413091d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f413092e;

    public c() {
        a();
    }

    public c a() {
        this.f413088a = "";
        this.f413089b = null;
        this.f413090c = 0;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.f413091d = iArr;
        this.f413092e = iArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f413088a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f413089b == null) {
                    this.f413089b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f413089b);
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f413090c = readInt32;
                }
            } else if (readTag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                int[] iArr = this.f413091d;
                int length = iArr == null ? 0 : iArr.length;
                int i3 = repeatedFieldArrayLength + length;
                int[] iArr2 = new int[i3];
                if (length != 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                }
                while (length < i3 - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.f413091d = iArr2;
            } else if (readTag == 34) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.f413091d;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int i17 = i16 + length2;
                int[] iArr4 = new int[i17];
                if (length2 != 0) {
                    System.arraycopy(iArr3, 0, iArr4, 0, length2);
                }
                while (length2 < i17) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.f413091d = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 40) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                int[] iArr5 = this.f413092e;
                int length3 = iArr5 == null ? 0 : iArr5.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                int[] iArr6 = new int[i18];
                if (length3 != 0) {
                    System.arraycopy(iArr5, 0, iArr6, 0, length3);
                }
                while (length3 < i18 - 1) {
                    iArr6[length3] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                iArr6[length3] = codedInputByteBufferNano.readUInt32();
                this.f413092e = iArr6;
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position2 = codedInputByteBufferNano.getPosition();
                int i19 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i19++;
                }
                codedInputByteBufferNano.rewindToPosition(position2);
                int[] iArr7 = this.f413092e;
                int length4 = iArr7 == null ? 0 : iArr7.length;
                int i26 = i19 + length4;
                int[] iArr8 = new int[i26];
                if (length4 != 0) {
                    System.arraycopy(iArr7, 0, iArr8, 0, length4);
                }
                while (length4 < i26) {
                    iArr8[length4] = codedInputByteBufferNano.readUInt32();
                    length4++;
                }
                this.f413092e = iArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f413088a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f413088a);
        }
        a aVar = this.f413089b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        int i3 = this.f413090c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        int[] iArr2 = this.f413091d;
        int i16 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                iArr = this.f413091d;
                if (i17 >= iArr.length) {
                    break;
                }
                i18 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i17]);
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (iArr.length * 1);
        }
        int[] iArr3 = this.f413092e;
        if (iArr3 == null || iArr3.length <= 0) {
            return computeSerializedSize;
        }
        int i19 = 0;
        while (true) {
            int[] iArr4 = this.f413092e;
            if (i16 < iArr4.length) {
                i19 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr4[i16]);
                i16++;
            } else {
                return computeSerializedSize + i19 + (iArr4.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f413088a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f413088a);
        }
        a aVar = this.f413089b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        int i3 = this.f413090c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int[] iArr = this.f413091d;
        int i16 = 0;
        if (iArr != null && iArr.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr2 = this.f413091d;
                if (i17 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(4, iArr2[i17]);
                i17++;
            }
        }
        int[] iArr3 = this.f413092e;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.f413092e;
                if (i16 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(5, iArr4[i16]);
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
