package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PkGameList extends ExtendableMessageNano<PkGameList> {
    private static volatile PkGameList[] _emptyArray;
    public GameInfo[] gameList;

    /* loaded from: classes15.dex */
    public static final class GameInfo extends ExtendableMessageNano<GameInfo> {
        private static volatile GameInfo[] _emptyArray;
        public String gameId;
        public String icon;
        public String name;
        public int partnerId;

        public GameInfo() {
            clear();
        }

        public static GameInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GameInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public static GameInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
            return (GameInfo) MessageNano.mergeFrom(new GameInfo(), bArr);
        }

        public GameInfo clear() {
            this.partnerId = 0;
            this.gameId = "";
            this.name = "";
            this.icon = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public int computeSerializedSize() {
            int computeSerializedSize = super.computeSerializedSize();
            int i3 = this.partnerId;
            if (i3 != 0) {
                computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
            }
            if (!this.gameId.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.gameId);
            }
            if (!this.name.equals("")) {
                computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
            }
            if (!this.icon.equals("")) {
                return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.icon);
            }
            return computeSerializedSize;
        }

        @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
        public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i3 = this.partnerId;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(1, i3);
            }
            if (!this.gameId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.gameId);
            }
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.name);
            }
            if (!this.icon.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.icon);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        public static GameInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            return new GameInfo().mergeFrom(codedInputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public GameInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
            while (true) {
                int readTag = codedInputByteBufferNano.readTag();
                if (readTag == 0) {
                    return this;
                }
                if (readTag == 8) {
                    this.partnerId = codedInputByteBufferNano.readInt32();
                } else if (readTag == 18) {
                    this.gameId = codedInputByteBufferNano.readString();
                } else if (readTag == 26) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (readTag != 34) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    this.icon = codedInputByteBufferNano.readString();
                }
            }
        }
    }

    public PkGameList() {
        clear();
    }

    public static PkGameList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkGameList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PkGameList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PkGameList) MessageNano.mergeFrom(new PkGameList(), bArr);
    }

    public PkGameList clear() {
        this.gameList = GameInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GameInfo[] gameInfoArr = this.gameList;
        if (gameInfoArr != null && gameInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                GameInfo[] gameInfoArr2 = this.gameList;
                if (i3 >= gameInfoArr2.length) {
                    break;
                }
                GameInfo gameInfo = gameInfoArr2[i3];
                if (gameInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gameInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GameInfo[] gameInfoArr = this.gameList;
        if (gameInfoArr != null && gameInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                GameInfo[] gameInfoArr2 = this.gameList;
                if (i3 >= gameInfoArr2.length) {
                    break;
                }
                GameInfo gameInfo = gameInfoArr2[i3];
                if (gameInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, gameInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PkGameList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PkGameList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PkGameList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                GameInfo[] gameInfoArr = this.gameList;
                int length = gameInfoArr == null ? 0 : gameInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GameInfo[] gameInfoArr2 = new GameInfo[i3];
                if (length != 0) {
                    System.arraycopy(gameInfoArr, 0, gameInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GameInfo gameInfo = new GameInfo();
                    gameInfoArr2[length] = gameInfo;
                    codedInputByteBufferNano.readMessage(gameInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GameInfo gameInfo2 = new GameInfo();
                gameInfoArr2[length] = gameInfo2;
                codedInputByteBufferNano.readMessage(gameInfo2);
                this.gameList = gameInfoArr2;
            }
        }
    }
}
