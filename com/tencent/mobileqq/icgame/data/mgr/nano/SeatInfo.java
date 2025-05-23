package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SeatInfo extends ExtendableMessageNano<SeatInfo> {
    private static volatile SeatInfo[] _emptyArray;
    public int assistRight;
    public int audioPlay;
    public int audioRight;
    public int clientType;
    public int gender;
    public long inviteUid;
    public int landscapeType;
    public int listId;
    public int openCamera;
    public byte[] openDrawExt;
    public int openMedia;
    public int openMic;
    public int openPpt;
    public int openScreen;
    public int seatNo;
    public int seatType;
    public int showPre;
    public int sourceType;
    public long timestamp;
    public long tinyid;
    public long uid;
    public int videoPlay;
    public int videoRight;

    public SeatInfo() {
        clear();
    }

    public static SeatInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeatInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeatInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeatInfo) MessageNano.mergeFrom(new SeatInfo(), bArr);
    }

    public SeatInfo clear() {
        this.seatType = 0;
        this.seatNo = 0;
        this.uid = 0L;
        this.audioRight = 0;
        this.videoRight = 0;
        this.timestamp = 0L;
        this.openMic = 0;
        this.audioPlay = 0;
        this.videoPlay = 0;
        this.openCamera = 0;
        this.inviteUid = 0L;
        this.showPre = 0;
        this.landscapeType = 0;
        this.listId = 0;
        this.tinyid = 0L;
        this.openScreen = 0;
        this.clientType = 0;
        this.openPpt = 0;
        this.openMedia = 0;
        this.openDrawExt = WireFormatNano.EMPTY_BYTES;
        this.assistRight = 0;
        this.sourceType = 0;
        this.gender = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i17 = this.audioRight;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        int i18 = this.videoRight;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i18);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i19 = this.openMic;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.audioPlay;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.videoPlay;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        int i28 = this.openCamera;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i28);
        }
        long j17 = this.inviteUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j17);
        }
        int i29 = this.showPre;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i29);
        }
        int i36 = this.landscapeType;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i36);
        }
        int i37 = this.listId;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i37);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j18);
        }
        int i38 = this.openScreen;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i38);
        }
        int i39 = this.clientType;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i39);
        }
        int i46 = this.openPpt;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i46);
        }
        int i47 = this.openMedia;
        if (i47 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(19, i47);
        }
        if (!Arrays.equals(this.openDrawExt, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(20, this.openDrawExt);
        }
        int i48 = this.assistRight;
        if (i48 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(21, i48);
        }
        int i49 = this.sourceType;
        if (i49 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i49);
        }
        int i56 = this.gender;
        if (i56 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(23, i56);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.seatNo;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i17 = this.audioRight;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        int i18 = this.videoRight;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i18);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i19 = this.openMic;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.audioPlay;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.videoPlay;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        int i28 = this.openCamera;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i28);
        }
        long j17 = this.inviteUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j17);
        }
        int i29 = this.showPre;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i29);
        }
        int i36 = this.landscapeType;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i36);
        }
        int i37 = this.listId;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i37);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j18);
        }
        int i38 = this.openScreen;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i38);
        }
        int i39 = this.clientType;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i39);
        }
        int i46 = this.openPpt;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i46);
        }
        int i47 = this.openMedia;
        if (i47 != 0) {
            codedOutputByteBufferNano.writeUInt32(19, i47);
        }
        if (!Arrays.equals(this.openDrawExt, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(20, this.openDrawExt);
        }
        int i48 = this.assistRight;
        if (i48 != 0) {
            codedOutputByteBufferNano.writeUInt32(21, i48);
        }
        int i49 = this.sourceType;
        if (i49 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i49);
        }
        int i56 = this.gender;
        if (i56 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i56);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeatInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeatInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeatInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.seatType = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.seatNo = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.audioRight = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.videoRight = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.openMic = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.audioPlay = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.videoPlay = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.openCamera = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.inviteUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.showPre = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.landscapeType = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.listId = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.tinyid = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.openScreen = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.clientType = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.openPpt = codedInputByteBufferNano.readUInt32();
                    break;
                case 152:
                    this.openMedia = codedInputByteBufferNano.readUInt32();
                    break;
                case 162:
                    this.openDrawExt = codedInputByteBufferNano.readBytes();
                    break;
                case 168:
                    this.assistRight = codedInputByteBufferNano.readUInt32();
                    break;
                case 176:
                    this.sourceType = codedInputByteBufferNano.readUInt32();
                    break;
                case 184:
                    this.gender = codedInputByteBufferNano.readUInt32();
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
