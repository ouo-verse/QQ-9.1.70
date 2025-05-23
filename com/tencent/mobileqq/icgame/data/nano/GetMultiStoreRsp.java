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
public final class GetMultiStoreRsp extends ExtendableMessageNano<GetMultiStoreRsp> {
    private static volatile GetMultiStoreRsp[] _emptyArray;
    public int adoreStore;
    public int defaultGiftId;
    public Gift[] gifts;

    public GetMultiStoreRsp() {
        clear();
    }

    public static GetMultiStoreRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMultiStoreRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMultiStoreRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMultiStoreRsp) MessageNano.mergeFrom(new GetMultiStoreRsp(), bArr);
    }

    public GetMultiStoreRsp clear() {
        this.defaultGiftId = 0;
        this.gifts = Gift.emptyArray();
        this.adoreStore = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.defaultGiftId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i16 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i16 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i16];
                if (gift != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gift);
                }
                i16++;
            }
        }
        int i17 = this.adoreStore;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.defaultGiftId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        Gift[] giftArr = this.gifts;
        if (giftArr != null && giftArr.length > 0) {
            int i16 = 0;
            while (true) {
                Gift[] giftArr2 = this.gifts;
                if (i16 >= giftArr2.length) {
                    break;
                }
                Gift gift = giftArr2[i16];
                if (gift != null) {
                    codedOutputByteBufferNano.writeMessage(2, gift);
                }
                i16++;
            }
        }
        int i17 = this.adoreStore;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMultiStoreRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMultiStoreRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMultiStoreRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.defaultGiftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
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
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.adoreStore = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
