package com.tencent.mobileqq.icgame.data.nano;

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
public final class AuctionBasicInfo extends ExtendableMessageNano<AuctionBasicInfo> {
    private static volatile AuctionBasicInfo[] _emptyArray;
    public int auctionBasicInfoSeq;
    public int auctionSeq;
    public String auctionTheme;
    public AuctionVip[] auctionVips;
    public AuctionVip currentAuctionVip;
    public int currentPrice;
    public int currentPriceTime;
    public int endTime;
    public int rateOfInctrease;
    public int startTime;
    public int startingPrice;
    public int status;
    public int waitingTime;

    public AuctionBasicInfo() {
        clear();
    }

    public static AuctionBasicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuctionBasicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AuctionBasicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AuctionBasicInfo) MessageNano.mergeFrom(new AuctionBasicInfo(), bArr);
    }

    public AuctionBasicInfo clear() {
        this.auctionSeq = 0;
        this.status = 0;
        this.auctionTheme = "";
        this.currentPrice = 0;
        this.currentPriceTime = 0;
        this.currentAuctionVip = null;
        this.waitingTime = 0;
        this.startingPrice = 0;
        this.rateOfInctrease = 0;
        this.auctionVips = AuctionVip.emptyArray();
        this.startTime = 0;
        this.endTime = 0;
        this.auctionBasicInfoSeq = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.auctionSeq;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.status;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.auctionTheme.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.auctionTheme);
        }
        int i17 = this.currentPrice;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.currentPriceTime;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        AuctionVip auctionVip = this.currentAuctionVip;
        if (auctionVip != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, auctionVip);
        }
        int i19 = this.waitingTime;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.startingPrice;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.rateOfInctrease;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        AuctionVip[] auctionVipArr = this.auctionVips;
        if (auctionVipArr != null && auctionVipArr.length > 0) {
            int i28 = 0;
            while (true) {
                AuctionVip[] auctionVipArr2 = this.auctionVips;
                if (i28 >= auctionVipArr2.length) {
                    break;
                }
                AuctionVip auctionVip2 = auctionVipArr2[i28];
                if (auctionVip2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, auctionVip2);
                }
                i28++;
            }
        }
        int i29 = this.startTime;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i29);
        }
        int i36 = this.endTime;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i36);
        }
        int i37 = this.auctionBasicInfoSeq;
        if (i37 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(13, i37);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.auctionSeq;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.status;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.auctionTheme.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.auctionTheme);
        }
        int i17 = this.currentPrice;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.currentPriceTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        AuctionVip auctionVip = this.currentAuctionVip;
        if (auctionVip != null) {
            codedOutputByteBufferNano.writeMessage(6, auctionVip);
        }
        int i19 = this.waitingTime;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.startingPrice;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.rateOfInctrease;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        AuctionVip[] auctionVipArr = this.auctionVips;
        if (auctionVipArr != null && auctionVipArr.length > 0) {
            int i28 = 0;
            while (true) {
                AuctionVip[] auctionVipArr2 = this.auctionVips;
                if (i28 >= auctionVipArr2.length) {
                    break;
                }
                AuctionVip auctionVip2 = auctionVipArr2[i28];
                if (auctionVip2 != null) {
                    codedOutputByteBufferNano.writeMessage(10, auctionVip2);
                }
                i28++;
            }
        }
        int i29 = this.startTime;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i29);
        }
        int i36 = this.endTime;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i36);
        }
        int i37 = this.auctionBasicInfoSeq;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i37);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AuctionBasicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AuctionBasicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AuctionBasicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.auctionSeq = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.status = codedInputByteBufferNano.readUInt32();
                    break;
                case 26:
                    this.auctionTheme = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.currentPrice = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.currentPriceTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    if (this.currentAuctionVip == null) {
                        this.currentAuctionVip = new AuctionVip();
                    }
                    codedInputByteBufferNano.readMessage(this.currentAuctionVip);
                    break;
                case 56:
                    this.waitingTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.startingPrice = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.rateOfInctrease = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    AuctionVip[] auctionVipArr = this.auctionVips;
                    int length = auctionVipArr == null ? 0 : auctionVipArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    AuctionVip[] auctionVipArr2 = new AuctionVip[i3];
                    if (length != 0) {
                        System.arraycopy(auctionVipArr, 0, auctionVipArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        AuctionVip auctionVip = new AuctionVip();
                        auctionVipArr2[length] = auctionVip;
                        codedInputByteBufferNano.readMessage(auctionVip);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    AuctionVip auctionVip2 = new AuctionVip();
                    auctionVipArr2[length] = auctionVip2;
                    codedInputByteBufferNano.readMessage(auctionVip2);
                    this.auctionVips = auctionVipArr2;
                    break;
                case 88:
                    this.startTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.endTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.auctionBasicInfoSeq = codedInputByteBufferNano.readInt32();
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
