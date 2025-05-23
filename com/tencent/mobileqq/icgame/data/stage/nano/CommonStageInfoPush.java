package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class CommonStageInfoPush extends ExtendableMessageNano<CommonStageInfoPush> {
    private static volatile CommonStageInfoPush[] _emptyArray;
    public int roomId;
    public StageInfo roomStage;
    public WaitingListInfo waitingList;

    public CommonStageInfoPush() {
        clear();
    }

    public static CommonStageInfoPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonStageInfoPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonStageInfoPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonStageInfoPush) MessageNano.mergeFrom(new CommonStageInfoPush(), bArr);
    }

    public CommonStageInfoPush clear() {
        this.roomId = 0;
        this.roomStage = null;
        this.waitingList = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        StageInfo stageInfo = this.roomStage;
        if (stageInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, stageInfo);
        }
        WaitingListInfo waitingListInfo = this.waitingList;
        if (waitingListInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, waitingListInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        StageInfo stageInfo = this.roomStage;
        if (stageInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, stageInfo);
        }
        WaitingListInfo waitingListInfo = this.waitingList;
        if (waitingListInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, waitingListInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonStageInfoPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonStageInfoPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonStageInfoPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.roomStage == null) {
                    this.roomStage = new StageInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomStage);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.waitingList == null) {
                    this.waitingList = new WaitingListInfo();
                }
                codedInputByteBufferNano.readMessage(this.waitingList);
            }
        }
    }
}
