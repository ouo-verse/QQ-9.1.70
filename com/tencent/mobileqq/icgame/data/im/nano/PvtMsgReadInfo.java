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
public final class PvtMsgReadInfo extends ExtendableMessageNano<PvtMsgReadInfo> {
    private static volatile PvtMsgReadInfo[] _emptyArray;
    public int adminAccount;
    public long readLastTime;
    public SubGroupReadInfo[] subReadInfo;

    public PvtMsgReadInfo() {
        clear();
    }

    public static PvtMsgReadInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PvtMsgReadInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PvtMsgReadInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PvtMsgReadInfo) MessageNano.mergeFrom(new PvtMsgReadInfo(), bArr);
    }

    public PvtMsgReadInfo clear() {
        this.readLastTime = 0L;
        this.subReadInfo = SubGroupReadInfo.emptyArray();
        this.adminAccount = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.readLastTime;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        SubGroupReadInfo[] subGroupReadInfoArr = this.subReadInfo;
        if (subGroupReadInfoArr != null && subGroupReadInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SubGroupReadInfo[] subGroupReadInfoArr2 = this.subReadInfo;
                if (i3 >= subGroupReadInfoArr2.length) {
                    break;
                }
                SubGroupReadInfo subGroupReadInfo = subGroupReadInfoArr2[i3];
                if (subGroupReadInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, subGroupReadInfo);
                }
                i3++;
            }
        }
        int i16 = this.adminAccount;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.readLastTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        SubGroupReadInfo[] subGroupReadInfoArr = this.subReadInfo;
        if (subGroupReadInfoArr != null && subGroupReadInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SubGroupReadInfo[] subGroupReadInfoArr2 = this.subReadInfo;
                if (i3 >= subGroupReadInfoArr2.length) {
                    break;
                }
                SubGroupReadInfo subGroupReadInfo = subGroupReadInfoArr2[i3];
                if (subGroupReadInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, subGroupReadInfo);
                }
                i3++;
            }
        }
        int i16 = this.adminAccount;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PvtMsgReadInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PvtMsgReadInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PvtMsgReadInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.readLastTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SubGroupReadInfo[] subGroupReadInfoArr = this.subReadInfo;
                int length = subGroupReadInfoArr == null ? 0 : subGroupReadInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                SubGroupReadInfo[] subGroupReadInfoArr2 = new SubGroupReadInfo[i3];
                if (length != 0) {
                    System.arraycopy(subGroupReadInfoArr, 0, subGroupReadInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    SubGroupReadInfo subGroupReadInfo = new SubGroupReadInfo();
                    subGroupReadInfoArr2[length] = subGroupReadInfo;
                    codedInputByteBufferNano.readMessage(subGroupReadInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                SubGroupReadInfo subGroupReadInfo2 = new SubGroupReadInfo();
                subGroupReadInfoArr2[length] = subGroupReadInfo2;
                codedInputByteBufferNano.readMessage(subGroupReadInfo2);
                this.subReadInfo = subGroupReadInfoArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
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
                        this.adminAccount = readInt32;
                        break;
                }
            }
        }
    }
}
