package com.tencent.mobileqq.icgame.data.lucky.nano;

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
public final class GiftRecord extends ExtendableMessageNano<GiftRecord> {
    private static volatile GiftRecord[] _emptyArray;
    public int cardType;
    public int giftCoin;
    public Gift[] gifts;
    public int luckyNum;

    /* renamed from: ts, reason: collision with root package name */
    public int f237267ts;

    public GiftRecord() {
        clear();
    }

    public static GiftRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftRecord) MessageNano.mergeFrom(new GiftRecord(), bArr);
    }

    public GiftRecord clear() {
        this.gifts = Gift.emptyArray();
        this.f237267ts = 0;
        this.cardType = 0;
        this.luckyNum = 0;
        this.giftCoin = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i3 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i3 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i3];
                if (gift != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gift);
                }
                i3++;
            }
        }
        int i16 = this.f237267ts;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.cardType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.luckyNum;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.giftCoin;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i3 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i3 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i3];
                if (gift != null) {
                    codedOutputByteBufferNano.writeMessage(1, gift);
                }
                i3++;
            }
        }
        int i16 = this.f237267ts;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.cardType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.luckyNum;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.giftCoin;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Gift[] giftArr = this.gifts;
                int length = giftArr == null ? 0 : giftArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Gift[] giftArr2 = new Gift[i3];
                if (length != 0) {
                    System.arraycopy(giftArr, 0, giftArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Gift gift = new Gift();
                    giftArr2[length] = gift;
                    codedInputByteBufferNano.readMessage(gift);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Gift gift2 = new Gift();
                giftArr2[length] = gift2;
                codedInputByteBufferNano.readMessage(gift2);
                this.gifts = giftArr2;
            } else if (readTag == 16) {
                this.f237267ts = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.cardType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.luckyNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.giftCoin = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
