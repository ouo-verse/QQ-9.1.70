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
public final class StageInviteRsp extends ExtendableMessageNano<StageInviteRsp> {
    private static volatile StageInviteRsp[] _emptyArray;
    public StageInfo stageInfo;

    public StageInviteRsp() {
        clear();
    }

    public static StageInviteRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StageInviteRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static StageInviteRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (StageInviteRsp) MessageNano.mergeFrom(new StageInviteRsp(), bArr);
    }

    public StageInviteRsp clear() {
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

    public static StageInviteRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new StageInviteRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public StageInviteRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
