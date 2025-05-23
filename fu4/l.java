package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class l extends ExtendableMessageNano<l> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f400788a;

    /* renamed from: b, reason: collision with root package name */
    public int f400789b;

    public l() {
        a();
    }

    public l a() {
        this.f400788a = WireFormatNano.EMPTY_INT_ARRAY;
        this.f400789b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:86:0x007c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:87:0x007f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:88:0x0082. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:89:0x0085. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:90:0x0088. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:91:0x008b. Please report as an issue. */
    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 10) {
                        if (readTag != 16) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1) {
                                this.f400789b = readInt32;
                            }
                        }
                    } else {
                        int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i3 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int readInt322 = codedInputByteBufferNano.readInt32();
                            if (readInt322 != 0 && readInt322 != 100) {
                                switch (readInt322) {
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                        break;
                                    default:
                                        switch (readInt322) {
                                            case 20:
                                            case 21:
                                            case 22:
                                            case 23:
                                                break;
                                            default:
                                                switch (readInt322) {
                                                    case 30:
                                                    case 31:
                                                    case 32:
                                                    case 33:
                                                        break;
                                                    default:
                                                        switch (readInt322) {
                                                            case 40:
                                                            case 41:
                                                            case 42:
                                                            case 43:
                                                                break;
                                                            default:
                                                                switch (readInt322) {
                                                                    case 50:
                                                                    case 51:
                                                                    case 52:
                                                                    case 53:
                                                                    case 54:
                                                                    case 55:
                                                                    case 56:
                                                                    case 57:
                                                                        break;
                                                                    default:
                                                                        switch (readInt322) {
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            }
                            i3++;
                        }
                        if (i3 != 0) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            int[] iArr = this.f400788a;
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
                                int readInt323 = codedInputByteBufferNano.readInt32();
                                if (readInt323 != 0 && readInt323 != 100) {
                                    switch (readInt323) {
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                            break;
                                        default:
                                            switch (readInt323) {
                                                case 20:
                                                case 21:
                                                case 22:
                                                case 23:
                                                    break;
                                                default:
                                                    switch (readInt323) {
                                                        case 30:
                                                        case 31:
                                                        case 32:
                                                        case 33:
                                                            break;
                                                        default:
                                                            switch (readInt323) {
                                                                case 40:
                                                                case 41:
                                                                case 42:
                                                                case 43:
                                                                    break;
                                                                default:
                                                                    switch (readInt323) {
                                                                        case 50:
                                                                        case 51:
                                                                        case 52:
                                                                        case 53:
                                                                        case 54:
                                                                        case 55:
                                                                        case 56:
                                                                        case 57:
                                                                            break;
                                                                        default:
                                                                            switch (readInt323) {
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                }
                                iArr2[length] = readInt323;
                                length++;
                            }
                            this.f400788a = iArr2;
                        }
                        codedInputByteBufferNano.popLimit(pushLimit);
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr3 = new int[repeatedFieldArrayLength];
                    int i16 = 0;
                    for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                        if (i17 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int readInt324 = codedInputByteBufferNano.readInt32();
                        if (readInt324 != 0 && readInt324 != 100) {
                            switch (readInt324) {
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    break;
                                default:
                                    switch (readInt324) {
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 23:
                                            break;
                                        default:
                                            switch (readInt324) {
                                                case 30:
                                                case 31:
                                                case 32:
                                                case 33:
                                                    break;
                                                default:
                                                    switch (readInt324) {
                                                        case 40:
                                                        case 41:
                                                        case 42:
                                                        case 43:
                                                            break;
                                                        default:
                                                            switch (readInt324) {
                                                                case 50:
                                                                case 51:
                                                                case 52:
                                                                case 53:
                                                                case 54:
                                                                case 55:
                                                                case 56:
                                                                case 57:
                                                                    break;
                                                                default:
                                                                    switch (readInt324) {
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        }
                        iArr3[i16] = readInt324;
                        i16++;
                    }
                    if (i16 != 0) {
                        int[] iArr4 = this.f400788a;
                        if (iArr4 == null) {
                            length2 = 0;
                        } else {
                            length2 = iArr4.length;
                        }
                        if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                            this.f400788a = iArr3;
                        } else {
                            int[] iArr5 = new int[length2 + i16];
                            if (length2 != 0) {
                                System.arraycopy(iArr4, 0, iArr5, 0, length2);
                            }
                            System.arraycopy(iArr3, 0, iArr5, length2, i16);
                            this.f400788a = iArr5;
                        }
                    }
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
        int[] iArr2 = this.f400788a;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f400788a;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        int i17 = this.f400789b;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.f400788a;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f400788a;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(1, iArr2[i3]);
                i3++;
            }
        }
        int i16 = this.f400789b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
