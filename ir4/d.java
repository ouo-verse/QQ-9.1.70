package ir4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public long f408449a;

    /* renamed from: b, reason: collision with root package name */
    public String f408450b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f408451c;

    public d() {
        a();
    }

    public d a() {
        this.f408449a = 0L;
        this.f408450b = "";
        this.f408451c = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 26) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                                int position = codedInputByteBufferNano.getPosition();
                                int i3 = 0;
                                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                                        i3++;
                                    }
                                }
                                if (i3 != 0) {
                                    codedInputByteBufferNano.rewindToPosition(position);
                                    int[] iArr = this.f408451c;
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
                                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3 || readInt322 == 4) {
                                            iArr2[length] = readInt322;
                                            length++;
                                        }
                                    }
                                    this.f408451c = iArr2;
                                }
                                codedInputByteBufferNano.popLimit(pushLimit);
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                            int[] iArr3 = new int[repeatedFieldArrayLength];
                            int i16 = 0;
                            for (int i17 = 0; i17 < repeatedFieldArrayLength; i17++) {
                                if (i17 != 0) {
                                    codedInputByteBufferNano.readTag();
                                }
                                int readInt323 = codedInputByteBufferNano.readInt32();
                                if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3 || readInt323 == 4) {
                                    iArr3[i16] = readInt323;
                                    i16++;
                                }
                            }
                            if (i16 != 0) {
                                int[] iArr4 = this.f408451c;
                                if (iArr4 == null) {
                                    length2 = 0;
                                } else {
                                    length2 = iArr4.length;
                                }
                                if (length2 == 0 && i16 == repeatedFieldArrayLength) {
                                    this.f408451c = iArr3;
                                } else {
                                    int[] iArr5 = new int[length2 + i16];
                                    if (length2 != 0) {
                                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                                    }
                                    System.arraycopy(iArr3, 0, iArr5, length2, i16);
                                    this.f408451c = iArr5;
                                }
                            }
                        }
                    } else {
                        this.f408450b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f408449a = codedInputByteBufferNano.readUInt64();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f408449a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f408450b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408450b);
        }
        int[] iArr = this.f408451c;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.f408451c;
                if (i3 < iArr2.length) {
                    i16 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (iArr2.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f408449a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f408450b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408450b);
        }
        int[] iArr = this.f408451c;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.f408451c;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(3, iArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
