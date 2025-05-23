package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SetStageReq extends ExtendableMessageNano<SetStageReq> {
    private static volatile SetStageReq[] _emptyArray;
    public String punishTopic;
    public int roomId;
    public int stage;
    public int timeLimit;

    public SetStageReq() {
        clear();
    }

    public static SetStageReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetStageReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetStageReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetStageReq) MessageNano.mergeFrom(new SetStageReq(), bArr);
    }

    public SetStageReq clear() {
        this.roomId = 0;
        this.stage = 0;
        this.timeLimit = 0;
        this.punishTopic = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.stage);
        int i3 = this.timeLimit;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.punishTopic.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.punishTopic);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt32(2, this.stage);
        int i3 = this.timeLimit;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.punishTopic.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.punishTopic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetStageReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetStageReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetStageReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.stage = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.timeLimit = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.punishTopic = codedInputByteBufferNano.readString();
            }
        }
    }
}
