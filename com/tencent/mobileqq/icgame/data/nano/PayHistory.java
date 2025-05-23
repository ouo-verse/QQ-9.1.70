package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PayHistory extends ExtendableMessageNano<PayHistory> {
    private static volatile PayHistory[] _emptyArray;
    public long anchorUid;
    public int giftId;
    public int giftNum;
    public int giftPrice;
    public long paytime;
    public String portalSerialno;
    public int roomid;
    public int stageMode;
    public long toUid;
    public long unionUid;

    public PayHistory() {
        clear();
    }

    public static PayHistory[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PayHistory[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PayHistory parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PayHistory) MessageNano.mergeFrom(new PayHistory(), bArr);
    }

    public PayHistory clear() {
        this.anchorUid = 0L;
        this.toUid = 0L;
        this.unionUid = 0L;
        this.roomid = 0;
        this.giftId = 0;
        this.giftNum = 0;
        this.giftPrice = 0;
        this.paytime = 0L;
        this.stageMode = 0;
        this.portalSerialno = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.toUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.unionUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        int i3 = this.roomid;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.giftId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.giftNum;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        int i18 = this.giftPrice;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        long j18 = this.paytime;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j18);
        }
        int i19 = this.stageMode;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        if (!this.portalSerialno.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.portalSerialno);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.toUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.unionUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        int i3 = this.roomid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.giftId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.giftNum;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        int i18 = this.giftPrice;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        long j18 = this.paytime;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j18);
        }
        int i19 = this.stageMode;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        if (!this.portalSerialno.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.portalSerialno);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PayHistory parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PayHistory().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PayHistory mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.anchorUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.toUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.unionUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.roomid = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.giftNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.giftPrice = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.paytime = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.stageMode = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.portalSerialno = codedInputByteBufferNano.readString();
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
