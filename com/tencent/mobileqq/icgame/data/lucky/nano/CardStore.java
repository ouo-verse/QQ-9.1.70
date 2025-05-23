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
public final class CardStore extends ExtendableMessageNano<CardStore> {
    private static volatile CardStore[] _emptyArray;
    public Card[] cards;
    public String sign;

    public CardStore() {
        clear();
    }

    public static CardStore[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CardStore[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CardStore parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CardStore) MessageNano.mergeFrom(new CardStore(), bArr);
    }

    public CardStore clear() {
        this.cards = Card.emptyArray();
        this.sign = "";
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
        if (!this.sign.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.sign);
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
        if (!this.sign.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.sign);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CardStore parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CardStore().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CardStore mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
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
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.sign = codedInputByteBufferNano.readString();
            }
        }
    }
}
