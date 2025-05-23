package com.tencent.mobileqq.icgame.data.nano;

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
public final class GiftAct extends ExtendableMessageNano<GiftAct> {
    private static volatile GiftAct[] _emptyArray;
    public byte[] bigIcon;
    public int discountPrice;
    public int giftId;
    public byte[] giftName;
    public int isBuy;
    public int num;
    public int price;
    public byte[] smallIcon;

    public GiftAct() {
        clear();
    }

    public static GiftAct[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftAct[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftAct parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftAct) MessageNano.mergeFrom(new GiftAct(), bArr);
    }

    public GiftAct clear() {
        this.giftId = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.giftName = bArr;
        this.price = 0;
        this.discountPrice = 0;
        this.smallIcon = bArr;
        this.bigIcon = bArr;
        this.num = 0;
        this.isBuy = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.giftId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        byte[] bArr = this.giftName;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.giftName);
        }
        int i16 = this.price;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.discountPrice;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        if (!Arrays.equals(this.smallIcon, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.smallIcon);
        }
        if (!Arrays.equals(this.bigIcon, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.bigIcon);
        }
        int i18 = this.num;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        int i19 = this.isBuy;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.giftId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        byte[] bArr = this.giftName;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.giftName);
        }
        int i16 = this.price;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.discountPrice;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        if (!Arrays.equals(this.smallIcon, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.smallIcon);
        }
        if (!Arrays.equals(this.bigIcon, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.bigIcon);
        }
        int i18 = this.num;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        int i19 = this.isBuy;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftAct parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftAct().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftAct mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.giftName = codedInputByteBufferNano.readBytes();
            } else if (readTag == 24) {
                this.price = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.discountPrice = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.smallIcon = codedInputByteBufferNano.readBytes();
            } else if (readTag == 50) {
                this.bigIcon = codedInputByteBufferNano.readBytes();
            } else if (readTag == 56) {
                this.num = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isBuy = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
