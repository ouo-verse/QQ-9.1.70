package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PvtMsgUserInfoGetRsp extends ExtendableMessageNano<PvtMsgUserInfoGetRsp> {
    private static volatile PvtMsgUserInfoGetRsp[] _emptyArray;
    public String planeTicketDesc;
    public int retCode;
    public String retMsg;
    public int showPlaneTicket;
    public UserInfo userInfo;

    public PvtMsgUserInfoGetRsp() {
        clear();
    }

    public static PvtMsgUserInfoGetRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PvtMsgUserInfoGetRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PvtMsgUserInfoGetRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PvtMsgUserInfoGetRsp) MessageNano.mergeFrom(new PvtMsgUserInfoGetRsp(), bArr);
    }

    public PvtMsgUserInfoGetRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.userInfo = null;
        this.showPlaneTicket = 0;
        this.planeTicketDesc = "";
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
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        int i16 = this.showPlaneTicket;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.planeTicketDesc.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.planeTicketDesc);
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
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        int i16 = this.showPlaneTicket;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.planeTicketDesc.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.planeTicketDesc);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PvtMsgUserInfoGetRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PvtMsgUserInfoGetRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PvtMsgUserInfoGetRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (readTag == 32) {
                this.showPlaneTicket = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.planeTicketDesc = codedInputByteBufferNano.readString();
            }
        }
    }
}
