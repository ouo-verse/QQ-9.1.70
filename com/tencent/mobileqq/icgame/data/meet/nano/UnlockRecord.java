package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UnlockRecord extends ExtendableMessageNano<UnlockRecord> {
    private static volatile UnlockRecord[] _emptyArray;
    public long[] payUnlockTime;
    public long[] seeUnlockTime;

    public UnlockRecord() {
        clear();
    }

    public static UnlockRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UnlockRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UnlockRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UnlockRecord) MessageNano.mergeFrom(new UnlockRecord(), bArr);
    }

    public UnlockRecord clear() {
        long[] jArr = WireFormatNano.EMPTY_LONG_ARRAY;
        this.payUnlockTime = jArr;
        this.seeUnlockTime = jArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int computeSerializedSize = super.computeSerializedSize();
        long[] jArr2 = this.payUnlockTime;
        int i3 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                jArr = this.payUnlockTime;
                if (i16 >= jArr.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (jArr.length * 1);
        }
        long[] jArr3 = this.seeUnlockTime;
        if (jArr3 != null && jArr3.length > 0) {
            int i18 = 0;
            while (true) {
                long[] jArr4 = this.seeUnlockTime;
                if (i3 < jArr4.length) {
                    i18 += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr4[i3]);
                    i3++;
                } else {
                    return computeSerializedSize + i18 + (jArr4.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long[] jArr = this.payUnlockTime;
        int i3 = 0;
        if (jArr != null && jArr.length > 0) {
            int i16 = 0;
            while (true) {
                long[] jArr2 = this.payUnlockTime;
                if (i16 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt64(1, jArr2[i16]);
                i16++;
            }
        }
        long[] jArr3 = this.seeUnlockTime;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.seeUnlockTime;
                if (i3 >= jArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt64(2, jArr4[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UnlockRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UnlockRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UnlockRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                long[] jArr = this.payUnlockTime;
                int length = jArr == null ? 0 : jArr.length;
                int i3 = repeatedFieldArrayLength + length;
                long[] jArr2 = new long[i3];
                if (length != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length);
                }
                while (length < i3 - 1) {
                    jArr2[length] = codedInputByteBufferNano.readInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readInt64();
                this.payUnlockTime = jArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt64();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.payUnlockTime;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                int i17 = i16 + length2;
                long[] jArr4 = new long[i17];
                if (length2 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length2);
                }
                while (length2 < i17) {
                    jArr4[length2] = codedInputByteBufferNano.readInt64();
                    length2++;
                }
                this.payUnlockTime = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 16) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                long[] jArr5 = this.seeUnlockTime;
                int length3 = jArr5 == null ? 0 : jArr5.length;
                int i18 = repeatedFieldArrayLength2 + length3;
                long[] jArr6 = new long[i18];
                if (length3 != 0) {
                    System.arraycopy(jArr5, 0, jArr6, 0, length3);
                }
                while (length3 < i18 - 1) {
                    jArr6[length3] = codedInputByteBufferNano.readInt64();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                jArr6[length3] = codedInputByteBufferNano.readInt64();
                this.seeUnlockTime = jArr6;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position2 = codedInputByteBufferNano.getPosition();
                int i19 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt64();
                    i19++;
                }
                codedInputByteBufferNano.rewindToPosition(position2);
                long[] jArr7 = this.seeUnlockTime;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                int i26 = i19 + length4;
                long[] jArr8 = new long[i26];
                if (length4 != 0) {
                    System.arraycopy(jArr7, 0, jArr8, 0, length4);
                }
                while (length4 < i26) {
                    jArr8[length4] = codedInputByteBufferNano.readInt64();
                    length4++;
                }
                this.seeUnlockTime = jArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            }
        }
    }
}
