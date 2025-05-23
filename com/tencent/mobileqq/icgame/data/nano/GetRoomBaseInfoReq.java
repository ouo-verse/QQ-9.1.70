package com.tencent.mobileqq.icgame.data.nano;

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
public final class GetRoomBaseInfoReq extends ExtendableMessageNano<GetRoomBaseInfoReq> {
    private static volatile GetRoomBaseInfoReq[] _emptyArray;
    public int getWay;
    public long[] groupCodes;
    public int[] roomIds;
    public int[] roomNos;

    public GetRoomBaseInfoReq() {
        clear();
    }

    public static GetRoomBaseInfoReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomBaseInfoReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomBaseInfoReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomBaseInfoReq) MessageNano.mergeFrom(new GetRoomBaseInfoReq(), bArr);
    }

    public GetRoomBaseInfoReq clear() {
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.roomIds = iArr;
        this.roomNos = iArr;
        this.groupCodes = WireFormatNano.EMPTY_LONG_ARRAY;
        this.getWay = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        long[] jArr;
        int[] iArr;
        int[] iArr2;
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr3 = this.roomIds;
        int i3 = 0;
        if (iArr3 != null && iArr3.length > 0) {
            int i16 = 0;
            int i17 = 0;
            while (true) {
                iArr2 = this.roomIds;
                if (i16 >= iArr2.length) {
                    break;
                }
                i17 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i16]);
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (iArr2.length * 1);
        }
        int[] iArr4 = this.roomNos;
        if (iArr4 != null && iArr4.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.roomNos;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        long[] jArr2 = this.groupCodes;
        if (jArr2 != null && jArr2.length > 0) {
            int i26 = 0;
            while (true) {
                jArr = this.groupCodes;
                if (i3 >= jArr.length) {
                    break;
                }
                i26 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i26 + (jArr.length * 1);
        }
        int i27 = this.getWay;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(99, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int[] iArr = this.roomIds;
        int i3 = 0;
        if (iArr != null && iArr.length > 0) {
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.roomIds;
                if (i16 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i16]);
                i16++;
            }
        }
        int[] iArr3 = this.roomNos;
        if (iArr3 != null && iArr3.length > 0) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.roomNos;
                if (i17 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr4[i17]);
                i17++;
            }
        }
        long[] jArr = this.groupCodes;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.groupCodes;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i3]);
                i3++;
            }
        }
        int i18 = this.getWay;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(99, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomBaseInfoReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomBaseInfoReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomBaseInfoReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = this.roomIds;
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
                this.roomIds = iArr2;
            } else if (readTag == 10) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.roomIds;
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
                this.roomIds = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 16) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                int[] iArr5 = this.roomNos;
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
                this.roomNos = iArr6;
            } else if (readTag == 18) {
                int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position2 = codedInputByteBufferNano.getPosition();
                int i19 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i19++;
                }
                codedInputByteBufferNano.rewindToPosition(position2);
                int[] iArr7 = this.roomNos;
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
                this.roomNos = iArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            } else if (readTag == 24) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.groupCodes;
                int length5 = jArr == null ? 0 : jArr.length;
                int i27 = repeatedFieldArrayLength3 + length5;
                long[] jArr2 = new long[i27];
                if (length5 != 0) {
                    System.arraycopy(jArr, 0, jArr2, 0, length5);
                }
                while (length5 < i27 - 1) {
                    jArr2[length5] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length5++;
                }
                jArr2[length5] = codedInputByteBufferNano.readUInt64();
                this.groupCodes = jArr2;
            } else if (readTag == 26) {
                int pushLimit3 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position3 = codedInputByteBufferNano.getPosition();
                int i28 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i28++;
                }
                codedInputByteBufferNano.rewindToPosition(position3);
                long[] jArr3 = this.groupCodes;
                int length6 = jArr3 == null ? 0 : jArr3.length;
                int i29 = i28 + length6;
                long[] jArr4 = new long[i29];
                if (length6 != 0) {
                    System.arraycopy(jArr3, 0, jArr4, 0, length6);
                }
                while (length6 < i29) {
                    jArr4[length6] = codedInputByteBufferNano.readUInt64();
                    length6++;
                }
                this.groupCodes = jArr4;
                codedInputByteBufferNano.popLimit(pushLimit3);
            } else if (readTag != 792) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.getWay = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
