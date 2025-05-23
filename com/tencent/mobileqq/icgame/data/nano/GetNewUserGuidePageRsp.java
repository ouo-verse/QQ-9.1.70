package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetNewUserGuidePageRsp extends ExtendableMessageNano<GetNewUserGuidePageRsp> {
    private static volatile GetNewUserGuidePageRsp[] _emptyArray;
    public int jumpType;
    public String pageUrl;
    public int retCode;
    public String retMsg;
    public String strategyGroup;
    public String strategyId;

    public GetNewUserGuidePageRsp() {
        clear();
    }

    public static GetNewUserGuidePageRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetNewUserGuidePageRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetNewUserGuidePageRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetNewUserGuidePageRsp) MessageNano.mergeFrom(new GetNewUserGuidePageRsp(), bArr);
    }

    public GetNewUserGuidePageRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.pageUrl = "";
        this.jumpType = 0;
        this.strategyId = "";
        this.strategyGroup = "";
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
        if (!this.pageUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pageUrl);
        }
        int i16 = this.jumpType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.strategyId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.strategyId);
        }
        if (!this.strategyGroup.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.strategyGroup);
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
        if (!this.pageUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pageUrl);
        }
        int i16 = this.jumpType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.strategyId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.strategyId);
        }
        if (!this.strategyGroup.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.strategyGroup);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetNewUserGuidePageRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetNewUserGuidePageRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetNewUserGuidePageRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.pageUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.jumpType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.strategyId = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.strategyGroup = codedInputByteBufferNano.readString();
            }
        }
    }
}
