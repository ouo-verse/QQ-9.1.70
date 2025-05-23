package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayScore extends ExtendableMessageNano<FreePlayScore> {
    private static volatile FreePlayScore[] _emptyArray;
    public ScoreItem blueScore;
    public int mvpLevel;
    public int mvpScore;
    public long mvpUid;
    public ScoreItem redScore;

    /* loaded from: classes15.dex */
    public static final class ScoreItem extends ExtendableMessageNano<ScoreItem> {
        private static volatile ScoreItem[] _emptyArray;
        public long bestPlayer;
        public int lastLevelBase;
        public int level;
        public int levelBase;
        public int score;

        public ScoreItem() {
            clear();
        }

        public static ScoreItem[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScoreItem[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static ScoreItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (ScoreItem) MessageNano.mergeFrom(new ScoreItem(), bArr);
        }

        public ScoreItem clear() {
            this.score = 0;
            this.level = 0;
            this.levelBase = 0;
            this.lastLevelBase = 0;
            this.bestPlayer = 0L;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i3 = this.score;
            if (i3 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
            }
            int i16 = this.level;
            if (i16 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
            }
            int i17 = this.levelBase;
            if (i17 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
            }
            int i18 = this.lastLevelBase;
            if (i18 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
            }
            long j3 = this.bestPlayer;
            if (j3 != 0) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j3);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i3 = this.score;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i3);
            }
            int i16 = this.level;
            if (i16 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i16);
            }
            int i17 = this.levelBase;
            if (i17 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i17);
            }
            int i18 = this.lastLevelBase;
            if (i18 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i18);
            }
            long j3 = this.bestPlayer;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static ScoreItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new ScoreItem().mergeFrom(codedInputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public ScoreItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.score = codedInputByteBufferNano.readUInt32();
                } else if (readTag == 16) {
                    this.level = codedInputByteBufferNano.readUInt32();
                } else if (readTag == 24) {
                    this.levelBase = codedInputByteBufferNano.readUInt32();
                } else if (readTag == 32) {
                    this.lastLevelBase = codedInputByteBufferNano.readUInt32();
                } else if (readTag != 40) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.bestPlayer = codedInputByteBufferNano.readUInt64();
                }
            }
        }
    }

    public FreePlayScore() {
        clear();
    }

    public static FreePlayScore[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayScore[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayScore parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayScore) MessageNano.mergeFrom(new FreePlayScore(), bArr);
    }

    public FreePlayScore clear() {
        this.redScore = null;
        this.blueScore = null;
        this.mvpUid = 0L;
        this.mvpLevel = 0;
        this.mvpScore = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ScoreItem scoreItem = this.redScore;
        if (scoreItem != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, scoreItem);
        }
        ScoreItem scoreItem2 = this.blueScore;
        if (scoreItem2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, scoreItem2);
        }
        long j3 = this.mvpUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i3 = this.mvpLevel;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.mvpScore;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ScoreItem scoreItem = this.redScore;
        if (scoreItem != null) {
            codedOutputByteBufferNano.writeMessage(1, scoreItem);
        }
        ScoreItem scoreItem2 = this.blueScore;
        if (scoreItem2 != null) {
            codedOutputByteBufferNano.writeMessage(2, scoreItem2);
        }
        long j3 = this.mvpUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i3 = this.mvpLevel;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.mvpScore;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayScore parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayScore().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayScore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.redScore == null) {
                    this.redScore = new ScoreItem();
                }
                codedInputByteBufferNano.readMessage(this.redScore);
            } else if (readTag == 18) {
                if (this.blueScore == null) {
                    this.blueScore = new ScoreItem();
                }
                codedInputByteBufferNano.readMessage(this.blueScore);
            } else if (readTag == 24) {
                this.mvpUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.mvpLevel = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.mvpScore = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
