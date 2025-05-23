package com.tencent.mobileqq.icgame.data.mgr.nano;

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
public final class RoomStageInfo extends ExtendableMessageNano<RoomStageInfo> {
    private static volatile RoomStageInfo[] _emptyArray;
    public int controlMic;
    public int freeExtraType;
    public int inviteTimeout;
    public int lineQueueFlag;
    public int liveExtraMode;
    public int liveTime;
    public int nowTs;
    public int performExtraType;
    public String rtmp;
    public SeatInfo[] seatList;
    public int stageMode;
    public int waitingTime;

    public RoomStageInfo() {
        clear();
    }

    public static RoomStageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomStageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomStageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomStageInfo) MessageNano.mergeFrom(new RoomStageInfo(), bArr);
    }

    public RoomStageInfo clear() {
        this.seatList = SeatInfo.emptyArray();
        this.controlMic = 0;
        this.stageMode = 0;
        this.freeExtraType = 0;
        this.performExtraType = 0;
        this.waitingTime = 0;
        this.liveTime = 0;
        this.inviteTimeout = 0;
        this.nowTs = 0;
        this.lineQueueFlag = 0;
        this.liveExtraMode = 0;
        this.rtmp = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        SeatInfo[] seatInfoArr = this.seatList;
        if (seatInfoArr != null && seatInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SeatInfo[] seatInfoArr2 = this.seatList;
                if (i3 >= seatInfoArr2.length) {
                    break;
                }
                SeatInfo seatInfo = seatInfoArr2[i3];
                if (seatInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, seatInfo);
                }
                i3++;
            }
        }
        int i16 = this.controlMic;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.stageMode;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.freeExtraType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.performExtraType;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        int i26 = this.waitingTime;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i26);
        }
        int i27 = this.liveTime;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i27);
        }
        int i28 = this.inviteTimeout;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i28);
        }
        int i29 = this.nowTs;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i29);
        }
        int i36 = this.lineQueueFlag;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i36);
        }
        int i37 = this.liveExtraMode;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i37);
        }
        if (!this.rtmp.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.rtmp);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        SeatInfo[] seatInfoArr = this.seatList;
        if (seatInfoArr != null && seatInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SeatInfo[] seatInfoArr2 = this.seatList;
                if (i3 >= seatInfoArr2.length) {
                    break;
                }
                SeatInfo seatInfo = seatInfoArr2[i3];
                if (seatInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, seatInfo);
                }
                i3++;
            }
        }
        int i16 = this.controlMic;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.stageMode;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.freeExtraType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.performExtraType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        int i26 = this.waitingTime;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i26);
        }
        int i27 = this.liveTime;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i27);
        }
        int i28 = this.inviteTimeout;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i28);
        }
        int i29 = this.nowTs;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i29);
        }
        int i36 = this.lineQueueFlag;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i36);
        }
        int i37 = this.liveExtraMode;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i37);
        }
        if (!this.rtmp.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.rtmp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomStageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomStageInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomStageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    SeatInfo[] seatInfoArr = this.seatList;
                    int length = seatInfoArr == null ? 0 : seatInfoArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    SeatInfo[] seatInfoArr2 = new SeatInfo[i3];
                    if (length != 0) {
                        System.arraycopy(seatInfoArr, 0, seatInfoArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        SeatInfo seatInfo = new SeatInfo();
                        seatInfoArr2[length] = seatInfo;
                        codedInputByteBufferNano.readMessage(seatInfo);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    SeatInfo seatInfo2 = new SeatInfo();
                    seatInfoArr2[length] = seatInfo2;
                    codedInputByteBufferNano.readMessage(seatInfo2);
                    this.seatList = seatInfoArr2;
                    break;
                case 16:
                    this.controlMic = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.stageMode = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.freeExtraType = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.performExtraType = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.waitingTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.liveTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.inviteTimeout = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.nowTs = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.lineQueueFlag = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.liveExtraMode = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.rtmp = codedInputByteBufferNano.readString();
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
