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
public final class PkStageInfo extends ExtendableMessageNano<PkStageInfo> {
    private static volatile PkStageInfo[] _emptyArray;
    public String gameRoomid;
    public PlayerInfo[] players;
    public int status;
    public int updateFlag;
    public PlayerInfo[] waitingPlayers;

    public PkStageInfo() {
        clear();
    }

    public static PkStageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkStageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PkStageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PkStageInfo) MessageNano.mergeFrom(new PkStageInfo(), bArr);
    }

    public PkStageInfo clear() {
        this.players = PlayerInfo.emptyArray();
        this.status = 0;
        this.waitingPlayers = PlayerInfo.emptyArray();
        this.gameRoomid = "";
        this.updateFlag = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        PlayerInfo[] playerInfoArr = this.players;
        int i3 = 0;
        if (playerInfoArr != null && playerInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PlayerInfo[] playerInfoArr2 = this.players;
                if (i16 >= playerInfoArr2.length) {
                    break;
                }
                PlayerInfo playerInfo = playerInfoArr2[i16];
                if (playerInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, playerInfo);
                }
                i16++;
            }
        }
        int i17 = this.status;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i17);
        }
        PlayerInfo[] playerInfoArr3 = this.waitingPlayers;
        if (playerInfoArr3 != null && playerInfoArr3.length > 0) {
            while (true) {
                PlayerInfo[] playerInfoArr4 = this.waitingPlayers;
                if (i3 >= playerInfoArr4.length) {
                    break;
                }
                PlayerInfo playerInfo2 = playerInfoArr4[i3];
                if (playerInfo2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, playerInfo2);
                }
                i3++;
            }
        }
        if (!this.gameRoomid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.gameRoomid);
        }
        int i18 = this.updateFlag;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        PlayerInfo[] playerInfoArr = this.players;
        int i3 = 0;
        if (playerInfoArr != null && playerInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                PlayerInfo[] playerInfoArr2 = this.players;
                if (i16 >= playerInfoArr2.length) {
                    break;
                }
                PlayerInfo playerInfo = playerInfoArr2[i16];
                if (playerInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, playerInfo);
                }
                i16++;
            }
        }
        int i17 = this.status;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i17);
        }
        PlayerInfo[] playerInfoArr3 = this.waitingPlayers;
        if (playerInfoArr3 != null && playerInfoArr3.length > 0) {
            while (true) {
                PlayerInfo[] playerInfoArr4 = this.waitingPlayers;
                if (i3 >= playerInfoArr4.length) {
                    break;
                }
                PlayerInfo playerInfo2 = playerInfoArr4[i3];
                if (playerInfo2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, playerInfo2);
                }
                i3++;
            }
        }
        if (!this.gameRoomid.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.gameRoomid);
        }
        int i18 = this.updateFlag;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PkStageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PkStageInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PkStageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                PlayerInfo[] playerInfoArr = this.players;
                int length = playerInfoArr == null ? 0 : playerInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                PlayerInfo[] playerInfoArr2 = new PlayerInfo[i3];
                if (length != 0) {
                    System.arraycopy(playerInfoArr, 0, playerInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    PlayerInfo playerInfo = new PlayerInfo();
                    playerInfoArr2[length] = playerInfo;
                    codedInputByteBufferNano.readMessage(playerInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                PlayerInfo playerInfo2 = new PlayerInfo();
                playerInfoArr2[length] = playerInfo2;
                codedInputByteBufferNano.readMessage(playerInfo2);
                this.players = playerInfoArr2;
            } else if (readTag == 16) {
                this.status = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                PlayerInfo[] playerInfoArr3 = this.waitingPlayers;
                int length2 = playerInfoArr3 == null ? 0 : playerInfoArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                PlayerInfo[] playerInfoArr4 = new PlayerInfo[i16];
                if (length2 != 0) {
                    System.arraycopy(playerInfoArr3, 0, playerInfoArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    PlayerInfo playerInfo3 = new PlayerInfo();
                    playerInfoArr4[length2] = playerInfo3;
                    codedInputByteBufferNano.readMessage(playerInfo3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                PlayerInfo playerInfo4 = new PlayerInfo();
                playerInfoArr4[length2] = playerInfo4;
                codedInputByteBufferNano.readMessage(playerInfo4);
                this.waitingPlayers = playerInfoArr4;
            } else if (readTag == 34) {
                this.gameRoomid = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.updateFlag = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
