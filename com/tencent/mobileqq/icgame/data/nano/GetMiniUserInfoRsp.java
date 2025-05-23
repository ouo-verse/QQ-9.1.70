package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetMiniUserInfoRsp extends ExtendableMessageNano<GetMiniUserInfoRsp> {
    private static volatile GetMiniUserInfoRsp[] _emptyArray;
    public BasicUserInfo basicUserinfo;
    public String groupCard;
    public int subscribeState;
    public UserExpLev userExpLev;
    public NobilityAllInfo userNobility;

    public GetMiniUserInfoRsp() {
        clear();
    }

    public static GetMiniUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMiniUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMiniUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMiniUserInfoRsp) MessageNano.mergeFrom(new GetMiniUserInfoRsp(), bArr);
    }

    public GetMiniUserInfoRsp clear() {
        this.basicUserinfo = null;
        this.groupCard = "";
        this.subscribeState = 0;
        this.userExpLev = null;
        this.userNobility = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        BasicUserInfo basicUserInfo = this.basicUserinfo;
        if (basicUserInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, basicUserInfo);
        }
        if (!this.groupCard.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.groupCard);
        }
        int i3 = this.subscribeState;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        UserExpLev userExpLev = this.userExpLev;
        if (userExpLev != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userExpLev);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, nobilityAllInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        BasicUserInfo basicUserInfo = this.basicUserinfo;
        if (basicUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, basicUserInfo);
        }
        if (!this.groupCard.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.groupCard);
        }
        int i3 = this.subscribeState;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        UserExpLev userExpLev = this.userExpLev;
        if (userExpLev != null) {
            codedOutputByteBufferNano.writeMessage(5, userExpLev);
        }
        NobilityAllInfo nobilityAllInfo = this.userNobility;
        if (nobilityAllInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, nobilityAllInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMiniUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMiniUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMiniUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.basicUserinfo == null) {
                    this.basicUserinfo = new BasicUserInfo();
                }
                codedInputByteBufferNano.readMessage(this.basicUserinfo);
            } else if (readTag == 18) {
                this.groupCard = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.subscribeState = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                if (this.userExpLev == null) {
                    this.userExpLev = new UserExpLev();
                }
                codedInputByteBufferNano.readMessage(this.userExpLev);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.userNobility == null) {
                    this.userNobility = new NobilityAllInfo();
                }
                codedInputByteBufferNano.readMessage(this.userNobility);
            }
        }
    }
}
