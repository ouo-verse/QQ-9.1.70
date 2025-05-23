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
public final class GetCardRsp extends ExtendableMessageNano<GetCardRsp> {
    private static volatile GetCardRsp[] _emptyArray;
    public Card[] cards;

    public GetCardRsp() {
        clear();
    }

    public static GetCardRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetCardRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetCardRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetCardRsp) MessageNano.mergeFrom(new GetCardRsp(), bArr);
    }

    public GetCardRsp clear() {
        this.cards = Card.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Card[] cardArr = this.cards;
        if (cardArr != null && cardArr.length > 0) {
            int i3 = 0;
            while (true) {
                Card[] cardArr2 = this.cards;
                if (i3 >= cardArr2.length) {
                    break;
                }
                Card card = cardArr2[i3];
                if (card != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, card);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Card[] cardArr = this.cards;
        if (cardArr != null && cardArr.length > 0) {
            int i3 = 0;
            while (true) {
                Card[] cardArr2 = this.cards;
                if (i3 >= cardArr2.length) {
                    break;
                }
                Card card = cardArr2[i3];
                if (card != null) {
                    codedOutputByteBufferNano.writeMessage(1, card);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetCardRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetCardRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetCardRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Card[] cardArr = this.cards;
                int length = cardArr == null ? 0 : cardArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Card[] cardArr2 = new Card[i3];
                if (length != 0) {
                    System.arraycopy(cardArr, 0, cardArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Card card = new Card();
                    cardArr2[length] = card;
                    codedInputByteBufferNano.readMessage(card);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Card card2 = new Card();
                cardArr2[length] = card2;
                codedInputByteBufferNano.readMessage(card2);
                this.cards = cardArr2;
            }
        }
    }
}
