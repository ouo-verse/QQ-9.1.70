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
public final class GetGiftListRsp extends ExtendableMessageNano<GetGiftListRsp> {
    private static volatile GetGiftListRsp[] _emptyArray;
    public int defaultGiftId;
    public Gift[] gifts;

    public GetGiftListRsp() {
        clear();
    }

    public static GetGiftListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGiftListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGiftListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGiftListRsp) MessageNano.mergeFrom(new GetGiftListRsp(), bArr);
    }

    public GetGiftListRsp clear() {
        this.gifts = Gift.emptyArray();
        this.defaultGiftId = 0;
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
        int i16 = this.defaultGiftId;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i16);
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
        int i16 = this.defaultGiftId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGiftListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGiftListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGiftListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.defaultGiftId = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
