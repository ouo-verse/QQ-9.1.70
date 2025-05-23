package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.data.nano.SeqInfo;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GameHeartbeatPush extends ExtendableMessageNano<GameHeartbeatPush> {
    private static volatile GameHeartbeatPush[] _emptyArray;
    public int gameId;
    public int heartbeatTime;
    public int roomId;
    public SeqInfo seqInfos;

    public GameHeartbeatPush() {
        clear();
    }

    public static GameHeartbeatPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GameHeartbeatPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GameHeartbeatPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GameHeartbeatPush) MessageNano.mergeFrom(new GameHeartbeatPush(), bArr);
    }

    public GameHeartbeatPush clear() {
        this.heartbeatTime = 0;
        this.roomId = 0;
        this.gameId = 0;
        this.seqInfos = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.heartbeatTime) + CodedOutputByteBufferNano.computeUInt32Size(2, this.roomId) + CodedOutputByteBufferNano.computeUInt32Size(3, this.gameId);
        SeqInfo seqInfo = this.seqInfos;
        if (seqInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, seqInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.heartbeatTime);
        codedOutputByteBufferNano.writeUInt32(2, this.roomId);
        codedOutputByteBufferNano.writeUInt32(3, this.gameId);
        SeqInfo seqInfo = this.seqInfos;
        if (seqInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, seqInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GameHeartbeatPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GameHeartbeatPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GameHeartbeatPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.heartbeatTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.gameId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.seqInfos == null) {
                    this.seqInfos = new SeqInfo();
                }
                codedInputByteBufferNano.readMessage(this.seqInfos);
            }
        }
    }
}
