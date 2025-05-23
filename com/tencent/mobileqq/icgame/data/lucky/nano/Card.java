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
public final class Card extends ExtendableMessageNano<Card> {
    private static volatile Card[] _emptyArray;
    public Piece[] pieces;
    public int type;

    public Card() {
        clear();
    }

    public static Card[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Card[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Card parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Card) MessageNano.mergeFrom(new Card(), bArr);
    }

    public Card clear() {
        this.type = 0;
        this.pieces = Piece.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        Piece[] pieceArr = this.pieces;
        if (pieceArr != null && pieceArr.length > 0) {
            int i16 = 0;
            while (true) {
                Piece[] pieceArr2 = this.pieces;
                if (i16 >= pieceArr2.length) {
                    break;
                }
                Piece piece = pieceArr2[i16];
                if (piece != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, piece);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        Piece[] pieceArr = this.pieces;
        if (pieceArr != null && pieceArr.length > 0) {
            int i16 = 0;
            while (true) {
                Piece[] pieceArr2 = this.pieces;
                if (i16 >= pieceArr2.length) {
                    break;
                }
                Piece piece = pieceArr2[i16];
                if (piece != null) {
                    codedOutputByteBufferNano.writeMessage(2, piece);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Card parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Card().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Card mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Piece[] pieceArr = this.pieces;
                int length = pieceArr == null ? 0 : pieceArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Piece[] pieceArr2 = new Piece[i3];
                if (length != 0) {
                    System.arraycopy(pieceArr, 0, pieceArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Piece piece = new Piece();
                    pieceArr2[length] = piece;
                    codedInputByteBufferNano.readMessage(piece);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Piece piece2 = new Piece();
                pieceArr2[length] = piece2;
                codedInputByteBufferNano.readMessage(piece2);
                this.pieces = pieceArr2;
            }
        }
    }
}
