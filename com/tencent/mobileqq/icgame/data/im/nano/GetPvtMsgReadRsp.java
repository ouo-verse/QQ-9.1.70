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
public final class GetPvtMsgReadRsp extends ExtendableMessageNano<GetPvtMsgReadRsp> {
    private static volatile GetPvtMsgReadRsp[] _emptyArray;
    public PvtMsgReadInfo[] readInfo;
    public int retCode;
    public String retMsg;

    public GetPvtMsgReadRsp() {
        clear();
    }

    public static GetPvtMsgReadRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetPvtMsgReadRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetPvtMsgReadRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetPvtMsgReadRsp) MessageNano.mergeFrom(new GetPvtMsgReadRsp(), bArr);
    }

    public GetPvtMsgReadRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.readInfo = PvtMsgReadInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        PvtMsgReadInfo[] pvtMsgReadInfoArr = this.readInfo;
        if (pvtMsgReadInfoArr != null && pvtMsgReadInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PvtMsgReadInfo[] pvtMsgReadInfoArr2 = this.readInfo;
                if (i16 >= pvtMsgReadInfoArr2.length) {
                    break;
                }
                PvtMsgReadInfo pvtMsgReadInfo = pvtMsgReadInfoArr2[i16];
                if (pvtMsgReadInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pvtMsgReadInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        PvtMsgReadInfo[] pvtMsgReadInfoArr = this.readInfo;
        if (pvtMsgReadInfoArr != null && pvtMsgReadInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PvtMsgReadInfo[] pvtMsgReadInfoArr2 = this.readInfo;
                if (i16 >= pvtMsgReadInfoArr2.length) {
                    break;
                }
                PvtMsgReadInfo pvtMsgReadInfo = pvtMsgReadInfoArr2[i16];
                if (pvtMsgReadInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, pvtMsgReadInfo);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetPvtMsgReadRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetPvtMsgReadRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetPvtMsgReadRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                PvtMsgReadInfo[] pvtMsgReadInfoArr = this.readInfo;
                int length = pvtMsgReadInfoArr == null ? 0 : pvtMsgReadInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PvtMsgReadInfo[] pvtMsgReadInfoArr2 = new PvtMsgReadInfo[i3];
                if (length != 0) {
                    System.arraycopy(pvtMsgReadInfoArr, 0, pvtMsgReadInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PvtMsgReadInfo pvtMsgReadInfo = new PvtMsgReadInfo();
                    pvtMsgReadInfoArr2[length] = pvtMsgReadInfo;
                    codedInputByteBufferNano.readMessage(pvtMsgReadInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PvtMsgReadInfo pvtMsgReadInfo2 = new PvtMsgReadInfo();
                pvtMsgReadInfoArr2[length] = pvtMsgReadInfo2;
                codedInputByteBufferNano.readMessage(pvtMsgReadInfo2);
                this.readInfo = pvtMsgReadInfoArr2;
            }
        }
    }
}
