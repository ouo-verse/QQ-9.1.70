package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ChooseTopicRsp extends ExtendableMessageNano<ChooseTopicRsp> {
    private static volatile ChooseTopicRsp[] _emptyArray;
    public String errMsg;
    public DrawAndGuessBasicInfo info;
    public int result;

    public ChooseTopicRsp() {
        clear();
    }

    public static ChooseTopicRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ChooseTopicRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ChooseTopicRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ChooseTopicRsp) MessageNano.mergeFrom(new ChooseTopicRsp(), bArr);
    }

    public ChooseTopicRsp clear() {
        this.result = 0;
        this.info = null;
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        DrawAndGuessBasicInfo drawAndGuessBasicInfo = this.info;
        if (drawAndGuessBasicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, drawAndGuessBasicInfo);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        DrawAndGuessBasicInfo drawAndGuessBasicInfo = this.info;
        if (drawAndGuessBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, drawAndGuessBasicInfo);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ChooseTopicRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ChooseTopicRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ChooseTopicRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.info == null) {
                    this.info = new DrawAndGuessBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.info);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
