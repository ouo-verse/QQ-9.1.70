package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetPvtMsgReadReq extends ExtendableMessageNano<GetPvtMsgReadReq> {
    private static volatile GetPvtMsgReadReq[] _emptyArray;
    public int[] adminAccount;

    public GetPvtMsgReadReq() {
        clear();
    }

    public static GetPvtMsgReadReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPvtMsgReadReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPvtMsgReadReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPvtMsgReadReq) MessageNano.mergeFrom(new GetPvtMsgReadReq(), bArr);
    }

    public GetPvtMsgReadReq clear() {
        this.adminAccount = WireFormatNano.EMPTY_INT_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int[] iArr = this.adminAccount;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int[] iArr2 = this.adminAccount;
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
        int[] iArr = this.adminAccount;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.adminAccount;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(1, iArr2[i3]);
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetPvtMsgReadReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPvtMsgReadReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPvtMsgReadReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = new int[repeatedFieldArrayLength];
                int i3 = 0;
                for (int i16 = 0; i16 < repeatedFieldArrayLength; i16++) {
                    if (i16 != 0) {
                        codedInputByteBufferNano.readTag();
                    }
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
                        case 8:
                        case 9:
                        case 10:
                            iArr[i3] = readInt32;
                            i3++;
                            break;
                    }
                }
                if (i3 != 0) {
                    int[] iArr2 = this.adminAccount;
                    int length = iArr2 == null ? 0 : iArr2.length;
                    if (length == 0 && i3 == repeatedFieldArrayLength) {
                        this.adminAccount = iArr;
                    } else {
                        int[] iArr3 = new int[length + i3];
                        if (length != 0) {
                            System.arraycopy(iArr2, 0, iArr3, 0, length);
                        }
                        System.arraycopy(iArr, 0, iArr3, length, i3);
                        this.adminAccount = iArr3;
                    }
                }
            } else if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i17 = 0;
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
                        case 8:
                        case 9:
                        case 10:
                            i17++;
                            break;
                    }
                }
                if (i17 != 0) {
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr4 = this.adminAccount;
                    int length2 = iArr4 == null ? 0 : iArr4.length;
                    int[] iArr5 = new int[i17 + length2];
                    if (length2 != 0) {
                        System.arraycopy(iArr4, 0, iArr5, 0, length2);
                    }
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
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
                            case 8:
                            case 9:
                            case 10:
                                iArr5[length2] = readInt322;
                                length2++;
                                break;
                        }
                    }
                    this.adminAccount = iArr5;
                }
                codedInputByteBufferNano.popLimit(pushLimit);
            }
        }
    }
}
