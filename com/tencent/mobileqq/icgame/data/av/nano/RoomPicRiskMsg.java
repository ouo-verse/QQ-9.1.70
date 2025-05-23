package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class RoomPicRiskMsg extends ExtendableMessageNano<RoomPicRiskMsg> {
    private static volatile RoomPicRiskMsg[] _emptyArray;
    public AbductionRisk[] abductionRisk;
    public int confidence;
    public long groupid;
    public int hotScore;

    /* renamed from: id, reason: collision with root package name */
    public int f237256id;
    public String img;
    public int level;
    public int normalScore;
    public String ocrMsg;
    public int pornScore;
    public int roomId;
    public long screenshotTime;
    public long sendTime;
    public String sign;
    public int[] type;
    public long userid;

    public RoomPicRiskMsg() {
        clear();
    }

    public static RoomPicRiskMsg[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RoomPicRiskMsg[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RoomPicRiskMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RoomPicRiskMsg) MessageNano.mergeFrom(new RoomPicRiskMsg(), bArr);
    }

    public RoomPicRiskMsg clear() {
        this.f237256id = 0;
        this.roomId = 0;
        this.userid = 0L;
        this.img = "";
        this.type = WireFormatNano.EMPTY_INT_ARRAY;
        this.confidence = 0;
        this.normalScore = 0;
        this.pornScore = 0;
        this.hotScore = 0;
        this.level = 0;
        this.screenshotTime = 0L;
        this.ocrMsg = "";
        this.sign = "";
        this.sendTime = 0L;
        this.abductionRisk = AbductionRisk.emptyArray();
        this.groupid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f237256id;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        long j3 = this.userid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!this.img.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.img);
        }
        int[] iArr2 = this.type;
        int i17 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i18 = 0;
            int i19 = 0;
            while (true) {
                iArr = this.type;
                if (i18 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i18]);
                i18++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        int i26 = this.confidence;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i26);
        }
        int i27 = this.normalScore;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i27);
        }
        int i28 = this.pornScore;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i28);
        }
        int i29 = this.hotScore;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i29);
        }
        int i36 = this.level;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i36);
        }
        long j16 = this.screenshotTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(11, j16);
        }
        if (!this.ocrMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.ocrMsg);
        }
        if (!this.sign.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.sign);
        }
        long j17 = this.sendTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(14, j17);
        }
        AbductionRisk[] abductionRiskArr = this.abductionRisk;
        if (abductionRiskArr != null && abductionRiskArr.length > 0) {
            while (true) {
                AbductionRisk[] abductionRiskArr2 = this.abductionRisk;
                if (i17 >= abductionRiskArr2.length) {
                    break;
                }
                AbductionRisk abductionRisk = abductionRiskArr2[i17];
                if (abductionRisk != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, abductionRisk);
                }
                i17++;
            }
        }
        long j18 = this.groupid;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(16, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f237256id;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.roomId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        long j3 = this.userid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.img.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.img);
        }
        int[] iArr = this.type;
        int i17 = 0;
        if (iArr != null && iArr.length > 0) {
            int i18 = 0;
            while (true) {
                int[] iArr2 = this.type;
                if (i18 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(5, iArr2[i18]);
                i18++;
            }
        }
        int i19 = this.confidence;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i19);
        }
        int i26 = this.normalScore;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i26);
        }
        int i27 = this.pornScore;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i27);
        }
        int i28 = this.hotScore;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i28);
        }
        int i29 = this.level;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i29);
        }
        long j16 = this.screenshotTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(11, j16);
        }
        if (!this.ocrMsg.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.ocrMsg);
        }
        if (!this.sign.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.sign);
        }
        long j17 = this.sendTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeInt64(14, j17);
        }
        AbductionRisk[] abductionRiskArr = this.abductionRisk;
        if (abductionRiskArr != null && abductionRiskArr.length > 0) {
            while (true) {
                AbductionRisk[] abductionRiskArr2 = this.abductionRisk;
                if (i17 >= abductionRiskArr2.length) {
                    break;
                }
                AbductionRisk abductionRisk = abductionRiskArr2[i17];
                if (abductionRisk != null) {
                    codedOutputByteBufferNano.writeMessage(15, abductionRisk);
                }
                i17++;
            }
        }
        long j18 = this.groupid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RoomPicRiskMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RoomPicRiskMsg().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RoomPicRiskMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f237256id = codedInputByteBufferNano.readInt32();
                    break;
                case 16:
                    this.roomId = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.userid = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.img = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                    int[] iArr = this.type;
                    int length = iArr == null ? 0 : iArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    int[] iArr2 = new int[i3];
                    if (length != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readInt32();
                    this.type = iArr2;
                    break;
                case 42:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readInt32();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.type;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int i17 = i16 + length2;
                    int[] iArr4 = new int[i17];
                    if (length2 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        iArr4[length2] = codedInputByteBufferNano.readInt32();
                        length2++;
                    }
                    this.type = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 48:
                    this.confidence = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.normalScore = codedInputByteBufferNano.readInt32();
                    break;
                case 64:
                    this.pornScore = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.hotScore = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.level = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.screenshotTime = codedInputByteBufferNano.readInt64();
                    break;
                case 98:
                    this.ocrMsg = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.sign = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.sendTime = codedInputByteBufferNano.readInt64();
                    break;
                case 122:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    AbductionRisk[] abductionRiskArr = this.abductionRisk;
                    int length3 = abductionRiskArr == null ? 0 : abductionRiskArr.length;
                    int i18 = repeatedFieldArrayLength2 + length3;
                    AbductionRisk[] abductionRiskArr2 = new AbductionRisk[i18];
                    if (length3 != 0) {
                        System.arraycopy(abductionRiskArr, 0, abductionRiskArr2, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        AbductionRisk abductionRisk = new AbductionRisk();
                        abductionRiskArr2[length3] = abductionRisk;
                        codedInputByteBufferNano.readMessage(abductionRisk);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    AbductionRisk abductionRisk2 = new AbductionRisk();
                    abductionRiskArr2[length3] = abductionRisk2;
                    codedInputByteBufferNano.readMessage(abductionRisk2);
                    this.abductionRisk = abductionRiskArr2;
                    break;
                case 128:
                    this.groupid = codedInputByteBufferNano.readUInt64();
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
