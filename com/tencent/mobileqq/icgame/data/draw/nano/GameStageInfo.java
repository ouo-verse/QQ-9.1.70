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
public final class GameStageInfo extends ExtendableMessageNano<GameStageInfo> {
    private static volatile GameStageInfo[] _emptyArray;
    public int answeredNum;
    public long answeredStartTime;
    public int answeredTimeLimit;
    public int brushGiftId;
    public int doubleTimeLimit;
    public long drawStartTime;
    public int drawStatus;
    public int drawTimeLimit;
    public PadExtInfo padEtxInfo;
    public int padGiftId;
    public int seatNo;
    public long selectStartTime;
    public int selectTime;
    public long uid;
    public int wordcountInterval;

    public GameStageInfo() {
        clear();
    }

    public static GameStageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GameStageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GameStageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GameStageInfo) MessageNano.mergeFrom(new GameStageInfo(), bArr);
    }

    public GameStageInfo clear() {
        this.uid = 0L;
        this.seatNo = 0;
        this.drawStatus = 0;
        this.answeredNum = 0;
        this.selectTime = 0;
        this.selectStartTime = 0L;
        this.drawTimeLimit = 0;
        this.drawStartTime = 0L;
        this.answeredTimeLimit = 0;
        this.brushGiftId = 0;
        this.padGiftId = 0;
        this.padEtxInfo = null;
        this.doubleTimeLimit = 0;
        this.wordcountInterval = 0;
        this.answeredStartTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.seatNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.drawStatus;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.answeredNum;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.selectTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        long j16 = this.selectStartTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j16);
        }
        int i19 = this.drawTimeLimit;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        long j17 = this.drawStartTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j17);
        }
        int i26 = this.answeredTimeLimit;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        int i27 = this.brushGiftId;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i27);
        }
        int i28 = this.padGiftId;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        PadExtInfo padExtInfo = this.padEtxInfo;
        if (padExtInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, padExtInfo);
        }
        int i29 = this.doubleTimeLimit;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i29);
        }
        int i36 = this.wordcountInterval;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i36);
        }
        long j18 = this.answeredStartTime;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(16, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.seatNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.drawStatus;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.answeredNum;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.selectTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        long j16 = this.selectStartTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        int i19 = this.drawTimeLimit;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        long j17 = this.drawStartTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j17);
        }
        int i26 = this.answeredTimeLimit;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        int i27 = this.brushGiftId;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i27);
        }
        int i28 = this.padGiftId;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i28);
        }
        PadExtInfo padExtInfo = this.padEtxInfo;
        if (padExtInfo != null) {
            codedOutputByteBufferNano.writeMessage(13, padExtInfo);
        }
        int i29 = this.doubleTimeLimit;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i29);
        }
        int i36 = this.wordcountInterval;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i36);
        }
        long j18 = this.answeredStartTime;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GameStageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GameStageInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GameStageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.seatNo = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.drawStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.answeredNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.selectTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.selectStartTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.drawTimeLimit = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.drawStartTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.answeredTimeLimit = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.brushGiftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.padGiftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 106:
                    if (this.padEtxInfo == null) {
                        this.padEtxInfo = new PadExtInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.padEtxInfo);
                    break;
                case 112:
                    this.doubleTimeLimit = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.wordcountInterval = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.answeredStartTime = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
