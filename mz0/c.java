package mz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public long f417847a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f417848b;

    /* renamed from: c, reason: collision with root package name */
    public long f417849c;

    /* renamed from: d, reason: collision with root package name */
    public long f417850d;

    public c() {
        a();
    }

    public c a() {
        this.f417847a = 0L;
        this.f417848b = WireFormatNano.EMPTY_INT_ARRAY;
        this.f417849c = 0L;
        this.f417850d = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 18) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f417850d = codedInputByteBufferNano.readUInt64();
                                }
                            } else {
                                this.f417849c = codedInputByteBufferNano.readUInt64();
                            }
                        } else {
                            int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                            int position = codedInputByteBufferNano.getPosition();
                            int i3 = 0;
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                int readInt32 = codedInputByteBufferNano.readInt32();
                                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                                    i3++;
                                }
                            }
                            if (i3 != 0) {
                                codedInputByteBufferNano.rewindToPosition(position);
                                int[] iArr = this.f417848b;
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
                                    int readInt322 = codedInputByteBufferNano.readInt32();
                                    if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4 || readInt322 == 5) {
                                        iArr2[length] = readInt322;
                                        length++;
                                    }
                                }
                                this.f417848b = iArr2;
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
                            int readInt323 = codedInputByteBufferNano.readInt32();
                            if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3 || readInt323 == 4 || readInt323 == 5) {
                                iArr3[i16] = readInt323;
                                i16++;
                            }
                        }
                        if (i16 != 0) {
                            int[] iArr4 = this.f417848b;
                            if (iArr4 == null) {
                                length2 = 0;
                            } else {
                                length2 = iArr4.length;
                            }
                            if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                this.f417848b = iArr3;
                            } else {
                                int[] iArr5 = new int[length2 + i16];
                                if (length2 != 0) {
                                    System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                }
                                System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                this.f417848b = iArr5;
                            }
                        }
                    }
                } else {
                    this.f417847a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f417847a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int[] iArr2 = this.f417848b;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.f417848b;
                if (i3 >= iArr.length) {
                    break;
                }
                i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (iArr.length * 1);
        }
        long j16 = this.f417849c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        long j17 = this.f417850d;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f417847a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int[] iArr = this.f417848b;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f417848b;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i3]);
                i3++;
            }
        }
        long j16 = this.f417849c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        long j17 = this.f417850d;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
