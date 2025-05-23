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
public final class SetDrawAndGuessGameStageReq extends ExtendableMessageNano<SetDrawAndGuessGameStageReq> {
    private static volatile SetDrawAndGuessGameStageReq[] _emptyArray;
    public long roomId;
    public int stage;
    public String startSeq;

    public SetDrawAndGuessGameStageReq() {
        clear();
    }

    public static SetDrawAndGuessGameStageReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetDrawAndGuessGameStageReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetDrawAndGuessGameStageReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetDrawAndGuessGameStageReq) MessageNano.mergeFrom(new SetDrawAndGuessGameStageReq(), bArr);
    }

    public SetDrawAndGuessGameStageReq clear() {
        this.roomId = 0L;
        this.stage = 0;
        this.startSeq = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.stage;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.startSeq.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.startSeq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.stage;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.startSeq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetDrawAndGuessGameStageReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetDrawAndGuessGameStageReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetDrawAndGuessGameStageReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.stage = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startSeq = codedInputByteBufferNano.readString();
            }
        }
    }
}
