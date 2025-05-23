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
public final class GetDrawAndGuessGameInfoRsp extends ExtendableMessageNano<GetDrawAndGuessGameInfoRsp> {
    private static volatile GetDrawAndGuessGameInfoRsp[] _emptyArray;
    public String errMsg;
    public GameScoreInfo gameScoreInfo;
    public DrawAndGuessBasicInfo info;
    public int interval;
    public int result;
    public long timestamp;

    public GetDrawAndGuessGameInfoRsp() {
        clear();
    }

    public static GetDrawAndGuessGameInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawAndGuessGameInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawAndGuessGameInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawAndGuessGameInfoRsp) MessageNano.mergeFrom(new GetDrawAndGuessGameInfoRsp(), bArr);
    }

    public GetDrawAndGuessGameInfoRsp clear() {
        this.result = 0;
        this.info = null;
        this.interval = 0;
        this.timestamp = 0L;
        this.errMsg = "";
        this.gameScoreInfo = null;
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
        int i16 = this.interval;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.errMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.errMsg);
        }
        GameScoreInfo gameScoreInfo = this.gameScoreInfo;
        if (gameScoreInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, gameScoreInfo);
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
        int i16 = this.interval;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.errMsg);
        }
        GameScoreInfo gameScoreInfo = this.gameScoreInfo;
        if (gameScoreInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, gameScoreInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawAndGuessGameInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawAndGuessGameInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawAndGuessGameInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
            } else if (readTag == 24) {
                this.interval = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 42) {
                this.errMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.gameScoreInfo == null) {
                    this.gameScoreInfo = new GameScoreInfo();
                }
                codedInputByteBufferNano.readMessage(this.gameScoreInfo);
            }
        }
    }
}
