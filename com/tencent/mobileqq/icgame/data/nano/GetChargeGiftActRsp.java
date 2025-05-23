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
public final class GetChargeGiftActRsp extends ExtendableMessageNano<GetChargeGiftActRsp> {
    private static volatile GetChargeGiftActRsp[] _emptyArray;
    public GiftAct[] giftActList;

    public GetChargeGiftActRsp() {
        clear();
    }

    public static GetChargeGiftActRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetChargeGiftActRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetChargeGiftActRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetChargeGiftActRsp) MessageNano.mergeFrom(new GetChargeGiftActRsp(), bArr);
    }

    public GetChargeGiftActRsp clear() {
        this.giftActList = GiftAct.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GiftAct[] giftActArr = this.giftActList;
        if (giftActArr != null && giftActArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftAct[] giftActArr2 = this.giftActList;
                if (i3 >= giftActArr2.length) {
                    break;
                }
                GiftAct giftAct = giftActArr2[i3];
                if (giftAct != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, giftAct);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GiftAct[] giftActArr = this.giftActList;
        if (giftActArr != null && giftActArr.length > 0) {
            int i3 = 0;
            while (true) {
                GiftAct[] giftActArr2 = this.giftActList;
                if (i3 >= giftActArr2.length) {
                    break;
                }
                GiftAct giftAct = giftActArr2[i3];
                if (giftAct != null) {
                    codedOutputByteBufferNano.writeMessage(1, giftAct);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetChargeGiftActRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetChargeGiftActRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetChargeGiftActRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                GiftAct[] giftActArr = this.giftActList;
                int length = giftActArr == null ? 0 : giftActArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GiftAct[] giftActArr2 = new GiftAct[i3];
                if (length != 0) {
                    System.arraycopy(giftActArr, 0, giftActArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GiftAct giftAct = new GiftAct();
                    giftActArr2[length] = giftAct;
                    codedInputByteBufferNano.readMessage(giftAct);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GiftAct giftAct2 = new GiftAct();
                giftActArr2[length] = giftAct2;
                codedInputByteBufferNano.readMessage(giftAct2);
                this.giftActList = giftActArr2;
            }
        }
    }
}
