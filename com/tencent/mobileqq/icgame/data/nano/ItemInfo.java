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
public final class ItemInfo extends ExtendableMessageNano<ItemInfo> {
    private static volatile ItemInfo[] _emptyArray;
    public String activityStr;
    public String androidVersion;
    public int giftOffline;
    public int giftOfflineTime;
    public int giftPermitbuy;
    public int giftTransformId;
    public int itemId;
    public String name;
    public String pcVersion;
    public String pic;
    public String previewPic;
    public int price;
    public float sharingRatio;
    public int type;

    public ItemInfo() {
        clear();
    }

    public static ItemInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ItemInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ItemInfo) MessageNano.mergeFrom(new ItemInfo(), bArr);
    }

    public ItemInfo clear() {
        this.itemId = 0;
        this.name = "";
        this.price = 0;
        this.pic = "";
        this.type = 1;
        this.sharingRatio = 0.0f;
        this.previewPic = "";
        this.pcVersion = "";
        this.androidVersion = "";
        this.giftOffline = 0;
        this.giftPermitbuy = 0;
        this.giftOfflineTime = 0;
        this.giftTransformId = 0;
        this.activityStr = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.itemId) + CodedOutputByteBufferNano.computeStringSize(2, this.name) + CodedOutputByteBufferNano.computeInt32Size(3, this.price) + CodedOutputByteBufferNano.computeStringSize(4, this.pic) + CodedOutputByteBufferNano.computeInt32Size(5, this.type) + CodedOutputByteBufferNano.computeFloatSize(6, this.sharingRatio);
        if (!this.previewPic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.previewPic);
        }
        if (!this.pcVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.pcVersion);
        }
        if (!this.androidVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.androidVersion);
        }
        int i3 = this.giftOffline;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i3);
        }
        int i16 = this.giftPermitbuy;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i16);
        }
        int i17 = this.giftOfflineTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i17);
        }
        int i18 = this.giftTransformId;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i18);
        }
        if (!this.activityStr.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.activityStr);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.itemId);
        codedOutputByteBufferNano.writeString(2, this.name);
        codedOutputByteBufferNano.writeInt32(3, this.price);
        codedOutputByteBufferNano.writeString(4, this.pic);
        codedOutputByteBufferNano.writeInt32(5, this.type);
        codedOutputByteBufferNano.writeFloat(6, this.sharingRatio);
        if (!this.previewPic.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.previewPic);
        }
        if (!this.pcVersion.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.pcVersion);
        }
        if (!this.androidVersion.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.androidVersion);
        }
        int i3 = this.giftOffline;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i3);
        }
        int i16 = this.giftPermitbuy;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i16);
        }
        int i17 = this.giftOfflineTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i17);
        }
        int i18 = this.giftTransformId;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i18);
        }
        if (!this.activityStr.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.activityStr);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ItemInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.itemId = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.price = codedInputByteBufferNano.readInt32();
                    break;
                case 34:
                    this.pic = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 10) {
                        switch (readInt32) {
                        }
                    }
                    this.type = readInt32;
                    break;
                case 53:
                    this.sharingRatio = codedInputByteBufferNano.readFloat();
                    break;
                case 58:
                    this.previewPic = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.pcVersion = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.androidVersion = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.giftOffline = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.giftPermitbuy = codedInputByteBufferNano.readInt32();
                    break;
                case 96:
                    this.giftOfflineTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.giftTransformId = codedInputByteBufferNano.readInt32();
                    break;
                case 114:
                    this.activityStr = codedInputByteBufferNano.readString();
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
