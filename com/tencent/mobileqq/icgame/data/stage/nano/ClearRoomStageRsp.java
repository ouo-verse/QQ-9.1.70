package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ClearRoomStageRsp extends ExtendableMessageNano<ClearRoomStageRsp> {
    private static volatile ClearRoomStageRsp[] _emptyArray;
    public StageInfo stageInfo;

    public ClearRoomStageRsp() {
        clear();
    }

    public static ClearRoomStageRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ClearRoomStageRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ClearRoomStageRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ClearRoomStageRsp) MessageNano.mergeFrom(new ClearRoomStageRsp(), bArr);
    }

    public ClearRoomStageRsp clear() {
        this.stageInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        StageInfo stageInfo = this.stageInfo;
        if (stageInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, stageInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        StageInfo stageInfo = this.stageInfo;
        if (stageInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, stageInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ClearRoomStageRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ClearRoomStageRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ClearRoomStageRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.stageInfo == null) {
                    this.stageInfo = new StageInfo();
                }
                codedInputByteBufferNano.readMessage(this.stageInfo);
            }
        }
    }
}
