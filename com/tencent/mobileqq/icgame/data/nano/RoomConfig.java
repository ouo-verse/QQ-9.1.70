package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.luggage.wxa.uf.l;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class RoomConfig extends ExtendableMessageNano<RoomConfig> {
    private static volatile RoomConfig[] _emptyArray;
    public int allowWordJoinRoomTime;
    public long flag;
    public int forbidAllWord;
    public int forbidLink;
    public int lineWaitingTime;
    public RoomGamePlayState roomGamePlayState;
    public int roomId;
    public int visitLimit;
    public int wordIntervalTime;
    public int wordLengthLimit;

    public RoomConfig() {
        clear();
    }

    public static RoomConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomConfig) MessageNano.mergeFrom(new RoomConfig(), bArr);
    }

    public RoomConfig clear() {
        this.flag = 0L;
        this.lineWaitingTime = 0;
        this.forbidAllWord = 0;
        this.allowWordJoinRoomTime = 0;
        this.wordIntervalTime = 0;
        this.wordLengthLimit = 0;
        this.forbidLink = 0;
        this.visitLimit = 0;
        this.roomId = 0;
        this.roomGamePlayState = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.flag;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.lineWaitingTime;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.forbidAllWord;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.allowWordJoinRoomTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.wordIntervalTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.wordLengthLimit;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.forbidLink;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.visitLimit;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        int i28 = this.roomId;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(99, i28);
        }
        RoomGamePlayState roomGamePlayState = this.roomGamePlayState;
        if (roomGamePlayState != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(100, roomGamePlayState);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.flag;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.lineWaitingTime;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.forbidAllWord;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.allowWordJoinRoomTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.wordIntervalTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.wordLengthLimit;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.forbidLink;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.visitLimit;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        int i28 = this.roomId;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(99, i28);
        }
        RoomGamePlayState roomGamePlayState = this.roomGamePlayState;
        if (roomGamePlayState != null) {
            codedOutputByteBufferNano.writeMessage(100, roomGamePlayState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.flag = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.lineWaitingTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.forbidAllWord = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.allowWordJoinRoomTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.wordIntervalTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.wordLengthLimit = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.forbidLink = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.visitLimit = codedInputByteBufferNano.readUInt32();
                    break;
                case l.CTRL_INDEX /* 792 */:
                    this.roomId = codedInputByteBufferNano.readUInt32();
                    break;
                case 802:
                    if (this.roomGamePlayState == null) {
                        this.roomGamePlayState = new RoomGamePlayState();
                    }
                    codedInputByteBufferNano.readMessage(this.roomGamePlayState);
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
