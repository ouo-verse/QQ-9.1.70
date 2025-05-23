package com.tencent.mobileqq.icgame.data.diff.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetDatingStageReq extends ExtendableMessageNano<SetDatingStageReq> {
    private static volatile SetDatingStageReq[] _emptyArray;
    public int datingStage;
    public int roomId;

    public SetDatingStageReq() {
        clear();
    }

    public static SetDatingStageReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetDatingStageReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetDatingStageReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetDatingStageReq) MessageNano.mergeFrom(new SetDatingStageReq(), bArr);
    }

    public SetDatingStageReq clear() {
        this.roomId = 0;
        this.datingStage = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeInt32Size(2, this.datingStage);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeInt32(2, this.datingStage);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetDatingStageReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetDatingStageReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetDatingStageReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.datingStage = readInt32;
                }
            }
        }
    }
}
