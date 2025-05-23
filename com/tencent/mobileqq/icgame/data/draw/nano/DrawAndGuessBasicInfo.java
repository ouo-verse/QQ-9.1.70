package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class DrawAndGuessBasicInfo extends ExtendableMessageNano<DrawAndGuessBasicInfo> {
    private static volatile DrawAndGuessBasicInfo[] _emptyArray;
    public int basicSeq;
    public ChallengerInfo challengerInfo;
    public GuessInfo[] guessList;
    public String lastStartSeq;
    public long roomId;
    public int stage;
    public GameStageInfo stageInfo;
    public String startSeq;
    public long startTime;
    public TopicInfo topicInfo;

    public DrawAndGuessBasicInfo() {
        clear();
    }

    public static DrawAndGuessBasicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawAndGuessBasicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawAndGuessBasicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawAndGuessBasicInfo) MessageNano.mergeFrom(new DrawAndGuessBasicInfo(), bArr);
    }

    public DrawAndGuessBasicInfo clear() {
        this.roomId = 0L;
        this.startSeq = "";
        this.startTime = 0L;
        this.stage = 0;
        this.stageInfo = null;
        this.guessList = GuessInfo.emptyArray();
        this.topicInfo = null;
        this.basicSeq = 0;
        this.lastStartSeq = "";
        this.challengerInfo = null;
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
        if (!this.startSeq.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.startSeq);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        int i3 = this.stage;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        GameStageInfo gameStageInfo = this.stageInfo;
        if (gameStageInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gameStageInfo);
        }
        GuessInfo[] guessInfoArr = this.guessList;
        if (guessInfoArr != null && guessInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                GuessInfo[] guessInfoArr2 = this.guessList;
                if (i16 >= guessInfoArr2.length) {
                    break;
                }
                GuessInfo guessInfo = guessInfoArr2[i16];
                if (guessInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, guessInfo);
                }
                i16++;
            }
        }
        TopicInfo topicInfo = this.topicInfo;
        if (topicInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, topicInfo);
        }
        int i17 = this.basicSeq;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i17);
        }
        if (!this.lastStartSeq.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.lastStartSeq);
        }
        ChallengerInfo challengerInfo = this.challengerInfo;
        if (challengerInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, challengerInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.startSeq);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        int i3 = this.stage;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        GameStageInfo gameStageInfo = this.stageInfo;
        if (gameStageInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, gameStageInfo);
        }
        GuessInfo[] guessInfoArr = this.guessList;
        if (guessInfoArr != null && guessInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                GuessInfo[] guessInfoArr2 = this.guessList;
                if (i16 >= guessInfoArr2.length) {
                    break;
                }
                GuessInfo guessInfo = guessInfoArr2[i16];
                if (guessInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, guessInfo);
                }
                i16++;
            }
        }
        TopicInfo topicInfo = this.topicInfo;
        if (topicInfo != null) {
            codedOutputByteBufferNano.writeMessage(7, topicInfo);
        }
        int i17 = this.basicSeq;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i17);
        }
        if (!this.lastStartSeq.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.lastStartSeq);
        }
        ChallengerInfo challengerInfo = this.challengerInfo;
        if (challengerInfo != null) {
            codedOutputByteBufferNano.writeMessage(10, challengerInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawAndGuessBasicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawAndGuessBasicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawAndGuessBasicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.roomId = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.startSeq = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.startTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.stage = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    if (this.stageInfo == null) {
                        this.stageInfo = new GameStageInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.stageInfo);
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    GuessInfo[] guessInfoArr = this.guessList;
                    int length = guessInfoArr == null ? 0 : guessInfoArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    GuessInfo[] guessInfoArr2 = new GuessInfo[i3];
                    if (length != 0) {
                        System.arraycopy(guessInfoArr, 0, guessInfoArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        GuessInfo guessInfo = new GuessInfo();
                        guessInfoArr2[length] = guessInfo;
                        codedInputByteBufferNano.readMessage(guessInfo);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    GuessInfo guessInfo2 = new GuessInfo();
                    guessInfoArr2[length] = guessInfo2;
                    codedInputByteBufferNano.readMessage(guessInfo2);
                    this.guessList = guessInfoArr2;
                    break;
                case 58:
                    if (this.topicInfo == null) {
                        this.topicInfo = new TopicInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.topicInfo);
                    break;
                case 64:
                    this.basicSeq = codedInputByteBufferNano.readInt32();
                    break;
                case 74:
                    this.lastStartSeq = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.challengerInfo == null) {
                        this.challengerInfo = new ChallengerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.challengerInfo);
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
