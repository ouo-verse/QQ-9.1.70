package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class Gift extends ExtendableMessageNano<Gift> {
    private static volatile Gift[] _emptyArray;
    public String activityStr;
    public int giftId;
    public int giftType;
    public String name;
    public int onlineTime;
    public int permitBuy;
    public String pic;
    public String previewPic;
    public int price;
    public int showFlag;
    public int stock;

    public Gift() {
        clear();
    }

    public static Gift[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Gift[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Gift parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Gift) MessageNano.mergeFrom(new Gift(), bArr);
    }

    public Gift clear() {
        this.giftId = 0;
        this.name = "";
        this.pic = "";
        this.price = 0;
        this.stock = 0;
        this.onlineTime = 0;
        this.previewPic = "";
        this.permitBuy = 0;
        this.activityStr = "";
        this.giftType = 1;
        this.showFlag = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId) + CodedOutputByteBufferNano.computeStringSize(2, this.name) + CodedOutputByteBufferNano.computeStringSize(3, this.pic) + CodedOutputByteBufferNano.computeInt32Size(4, this.price);
        int i3 = this.stock;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.onlineTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        if (!this.previewPic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.previewPic);
        }
        int i17 = this.permitBuy;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        if (!this.activityStr.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.activityStr);
        }
        int i18 = this.giftType;
        if (i18 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i18);
        }
        int i19 = this.showFlag;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.giftId);
        codedOutputByteBufferNano.writeString(2, this.name);
        codedOutputByteBufferNano.writeString(3, this.pic);
        codedOutputByteBufferNano.writeInt32(4, this.price);
        int i3 = this.stock;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.onlineTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        if (!this.previewPic.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.previewPic);
        }
        int i17 = this.permitBuy;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        if (!this.activityStr.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.activityStr);
        }
        int i18 = this.giftType;
        if (i18 != 1) {
            codedOutputByteBufferNano.writeInt32(10, i18);
        }
        int i19 = this.showFlag;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Gift parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Gift().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Gift mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.pic = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.price = codedInputByteBufferNano.readInt32();
                    break;
                case 40:
                    this.stock = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.onlineTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.previewPic = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.permitBuy = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.activityStr = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 10) {
                        switch (readInt32) {
                        }
                    }
                    this.giftType = readInt32;
                    break;
                case 88:
                    this.showFlag = codedInputByteBufferNano.readUInt32();
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
