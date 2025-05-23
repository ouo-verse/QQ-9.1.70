package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetGameInfoRsp extends ExtendableMessageNano<GetGameInfoRsp> {
    private static volatile GetGameInfoRsp[] _emptyArray;
    public byte[] gameDetail;
    public GameInfo gameInfo;
    public int result;
    public int[] supportItem;
    public int switchFlag;
    public int[] switchSupportGameid;

    public GetGameInfoRsp() {
        clear();
    }

    public static GetGameInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGameInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGameInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGameInfoRsp) MessageNano.mergeFrom(new GetGameInfoRsp(), bArr);
    }

    public GetGameInfoRsp clear() {
        this.result = 0;
        this.gameInfo = null;
        this.gameDetail = WireFormatNano.EMPTY_BYTES;
        this.switchFlag = 0;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.switchSupportGameid = iArr;
        this.supportItem = iArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        GameInfo gameInfo = this.gameInfo;
        if (gameInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gameInfo);
        }
        if (!Arrays.equals(this.gameDetail, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.gameDetail);
        }
        int i16 = this.switchFlag;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int[] iArr2 = this.switchSupportGameid;
        int i17 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.switchSupportGameid;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        int[] iArr3 = this.supportItem;
        if (iArr3 != null && iArr3.length > 0) {
            int i26 = 0;
            while (true) {
                int[] iArr4 = this.supportItem;
                if (i17 < iArr4.length) {
                    i26 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr4[i17]);
                    i17++;
                } else {
                    return computeSerializedSize + i26 + (iArr4.length * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        GameInfo gameInfo = this.gameInfo;
        if (gameInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, gameInfo);
        }
        if (!Arrays.equals(this.gameDetail, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.gameDetail);
        }
        int i16 = this.switchFlag;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int[] iArr = this.switchSupportGameid;
        int i17 = 0;
        if (iArr != null && iArr.length > 0) {
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.switchSupportGameid;
                if (i18 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(5, iArr2[i18]);
                i18++;
            }
        }
        int[] iArr3 = this.supportItem;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.supportItem;
                if (i17 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(10, iArr4[i17]);
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGameInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGameInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGameInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readInt32();
            } else if (readTag == 18) {
                if (this.gameInfo == null) {
                    this.gameInfo = new GameInfo();
                }
                codedInputByteBufferNano.readMessage(this.gameInfo);
            } else if (readTag == 26) {
                this.gameDetail = codedInputByteBufferNano.readBytes();
            } else if (readTag == 32) {
                this.switchFlag = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                int[] iArr = this.switchSupportGameid;
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
                this.switchSupportGameid = iArr2;
            } else if (readTag == 42) {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i16 = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i16++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.switchSupportGameid;
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
                this.switchSupportGameid = iArr4;
                codedInputByteBufferNano.popLimit(pushLimit);
            } else if (readTag == 80) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                int[] iArr5 = this.supportItem;
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
                this.supportItem = iArr6;
            } else if (readTag != 82) {
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
                int[] iArr7 = this.supportItem;
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
                this.supportItem = iArr8;
                codedInputByteBufferNano.popLimit(pushLimit2);
            }
        }
    }
}
