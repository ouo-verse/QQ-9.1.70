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
public final class GetGiftInfoRsp extends ExtendableMessageNano<GetGiftInfoRsp> {
    private static volatile GetGiftInfoRsp[] _emptyArray;
    public GiftInfoRsp[] answercardGifts;
    public GiftInfoRsp[] doublecardGifts;
    public String errmsg;
    public int result;

    public GetGiftInfoRsp() {
        clear();
    }

    public static GetGiftInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGiftInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGiftInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGiftInfoRsp) MessageNano.mergeFrom(new GetGiftInfoRsp(), bArr);
    }

    public GetGiftInfoRsp clear() {
        this.result = 0;
        this.errmsg = "";
        this.doublecardGifts = GiftInfoRsp.emptyArray();
        this.answercardGifts = GiftInfoRsp.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        GiftInfoRsp[] giftInfoRspArr = this.doublecardGifts;
        int i16 = 0;
        if (giftInfoRspArr != null && giftInfoRspArr.length > 0) {
            int i17 = 0;
            while (true) {
                GiftInfoRsp[] giftInfoRspArr2 = this.doublecardGifts;
                if (i17 >= giftInfoRspArr2.length) {
                    break;
                }
                GiftInfoRsp giftInfoRsp = giftInfoRspArr2[i17];
                if (giftInfoRsp != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, giftInfoRsp);
                }
                i17++;
            }
        }
        GiftInfoRsp[] giftInfoRspArr3 = this.answercardGifts;
        if (giftInfoRspArr3 != null && giftInfoRspArr3.length > 0) {
            while (true) {
                GiftInfoRsp[] giftInfoRspArr4 = this.answercardGifts;
                if (i16 >= giftInfoRspArr4.length) {
                    break;
                }
                GiftInfoRsp giftInfoRsp2 = giftInfoRspArr4[i16];
                if (giftInfoRsp2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, giftInfoRsp2);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.errmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errmsg);
        }
        GiftInfoRsp[] giftInfoRspArr = this.doublecardGifts;
        int i16 = 0;
        if (giftInfoRspArr != null && giftInfoRspArr.length > 0) {
            int i17 = 0;
            while (true) {
                GiftInfoRsp[] giftInfoRspArr2 = this.doublecardGifts;
                if (i17 >= giftInfoRspArr2.length) {
                    break;
                }
                GiftInfoRsp giftInfoRsp = giftInfoRspArr2[i17];
                if (giftInfoRsp != null) {
                    codedOutputByteBufferNano.writeMessage(3, giftInfoRsp);
                }
                i17++;
            }
        }
        GiftInfoRsp[] giftInfoRspArr3 = this.answercardGifts;
        if (giftInfoRspArr3 != null && giftInfoRspArr3.length > 0) {
            while (true) {
                GiftInfoRsp[] giftInfoRspArr4 = this.answercardGifts;
                if (i16 >= giftInfoRspArr4.length) {
                    break;
                }
                GiftInfoRsp giftInfoRsp2 = giftInfoRspArr4[i16];
                if (giftInfoRsp2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, giftInfoRsp2);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGiftInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGiftInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGiftInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.errmsg = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                GiftInfoRsp[] giftInfoRspArr = this.doublecardGifts;
                int length = giftInfoRspArr == null ? 0 : giftInfoRspArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GiftInfoRsp[] giftInfoRspArr2 = new GiftInfoRsp[i3];
                if (length != 0) {
                    System.arraycopy(giftInfoRspArr, 0, giftInfoRspArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GiftInfoRsp giftInfoRsp = new GiftInfoRsp();
                    giftInfoRspArr2[length] = giftInfoRsp;
                    codedInputByteBufferNano.readMessage(giftInfoRsp);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GiftInfoRsp giftInfoRsp2 = new GiftInfoRsp();
                giftInfoRspArr2[length] = giftInfoRsp2;
                codedInputByteBufferNano.readMessage(giftInfoRsp2);
                this.doublecardGifts = giftInfoRspArr2;
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                GiftInfoRsp[] giftInfoRspArr3 = this.answercardGifts;
                int length2 = giftInfoRspArr3 == null ? 0 : giftInfoRspArr3.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                GiftInfoRsp[] giftInfoRspArr4 = new GiftInfoRsp[i16];
                if (length2 != 0) {
                    System.arraycopy(giftInfoRspArr3, 0, giftInfoRspArr4, 0, length2);
                }
                while (length2 < i16 - 1) {
                    GiftInfoRsp giftInfoRsp3 = new GiftInfoRsp();
                    giftInfoRspArr4[length2] = giftInfoRsp3;
                    codedInputByteBufferNano.readMessage(giftInfoRsp3);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                GiftInfoRsp giftInfoRsp4 = new GiftInfoRsp();
                giftInfoRspArr4[length2] = giftInfoRsp4;
                codedInputByteBufferNano.readMessage(giftInfoRsp4);
                this.answercardGifts = giftInfoRspArr4;
            }
        }
    }
}
