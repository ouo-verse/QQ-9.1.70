package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public String f394986a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f394987b;

    /* renamed from: c, reason: collision with root package name */
    public String f394988c;

    public h() {
        a();
    }

    public h a() {
        this.f394986a = "";
        this.f394987b = WireFormatNano.EMPTY_INT_ARRAY;
        this.f394988c = "";
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
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 18) {
                            if (readTag != 26) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f394988c = codedInputByteBufferNano.readString();
                            }
                        } else {
                            int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i3 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                switch (codedInputByteBufferNano.readInt32()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                        i3++;
                                        break;
                                }
                            }
                            if (i3 != 0) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                int[] iArr = this.f394987b;
                                if (iArr == null) {
                                    length = 0;
                                } else {
                                    length = iArr.length;
                                }
                                int[] iArr2 = new int[i3 + length];
                                if (length != 0) {
                                    System.arraycopy(iArr, 0, iArr2, 0, length);
                                }
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    switch (readInt32) {
                                        case 0:
                                        case 1:
                                        case 2:
                                        case 3:
                                        case 4:
                                        case 5:
                                        case 6:
                                        case 7:
                                            iArr2[length] = readInt32;
                                            length++;
                                            break;
                                    }
                                }
                                this.f394987b = iArr2;
                            }
                            codedInputByteBufferNano.popLimit(pushLimit);
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                        int[] iArr3 = new int[repeatedFieldArrayLength];
                        int i16 = 0;
                        for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                            if (i17 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            switch (readInt322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    iArr3[i16] = readInt322;
                                    i16++;
                                    break;
                            }
                        }
                        if (i16 != 0) {
                            int[] iArr4 = this.f394987b;
                            if (iArr4 == null) {
                                length2 = 0;
                            } else {
                                length2 = iArr4.length;
                            }
                            if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                this.f394987b = iArr3;
                            } else {
                                int[] iArr5 = new int[length2 + i16];
                                if (length2 != 0) {
                                    System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                }
                                System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                this.f394987b = iArr5;
                            }
                        }
                    }
                } else {
                    this.f394986a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f394986a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f394986a);
        }
        int[] iArr2 = this.f394987b;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f394987b;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        if (!this.f394988c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f394988c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f394986a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f394986a);
        }
        int[] iArr = this.f394987b;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f394987b;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i3]);
                i3++;
            }
        }
        if (!this.f394988c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f394988c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
