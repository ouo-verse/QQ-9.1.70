package com.tencent.mobileqq.icgame.data.stage.nano;

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
public final class StageInfo extends ExtendableMessageNano<StageInfo> {
    private static volatile StageInfo[] _emptyArray;
    public int gameId;
    public int lianmaiSwitch;
    public long roomId;
    public String rtmp;
    public SeatInfo[] seatList;
    public long seq;
    public int stage;
    public long startSeq;

    public StageInfo() {
        clear();
    }

    public static StageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static StageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (StageInfo) MessageNano.mergeFrom(new StageInfo(), bArr);
    }

    public StageInfo clear() {
        this.roomId = 0L;
        this.seatList = SeatInfo.emptyArray();
        this.gameId = 0;
        this.stage = 0;
        this.startSeq = 0L;
        this.seq = 0L;
        this.rtmp = "";
        this.lianmaiSwitch = 0;
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
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, seatInfo);
                }
                i3++;
            }
        }
        int i16 = this.gameId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.stage;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        long j16 = this.startSeq;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        long j17 = this.seq;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        if (!this.rtmp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.rtmp);
        }
        int i18 = this.lianmaiSwitch;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
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
                    codedOutputByteBufferNano.writeMessage(2, seatInfo);
                }
                i3++;
            }
        }
        int i16 = this.gameId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.stage;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        long j16 = this.startSeq;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        long j17 = this.seq;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        if (!this.rtmp.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.rtmp);
        }
        int i18 = this.lianmaiSwitch;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static StageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new StageInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public StageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
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
            } else if (readTag == 24) {
                this.gameId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.stage = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.seq = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 58) {
                this.rtmp = codedInputByteBufferNano.readString();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.lianmaiSwitch = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
