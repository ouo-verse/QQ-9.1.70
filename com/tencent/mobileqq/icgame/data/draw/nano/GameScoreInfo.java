package com.tencent.mobileqq.icgame.data.draw.nano;

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
public final class GameScoreInfo extends ExtendableMessageNano<GameScoreInfo> {
    private static volatile GameScoreInfo[] _emptyArray;
    public RankItem[] rankList;

    public GameScoreInfo() {
        clear();
    }

    public static GameScoreInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GameScoreInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GameScoreInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GameScoreInfo) MessageNano.mergeFrom(new GameScoreInfo(), bArr);
    }

    public GameScoreInfo clear() {
        this.rankList = RankItem.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RankItem[] rankItemArr = this.rankList;
        if (rankItemArr != null && rankItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                RankItem[] rankItemArr2 = this.rankList;
                if (i3 >= rankItemArr2.length) {
                    break;
                }
                RankItem rankItem = rankItemArr2[i3];
                if (rankItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, rankItem);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RankItem[] rankItemArr = this.rankList;
        if (rankItemArr != null && rankItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                RankItem[] rankItemArr2 = this.rankList;
                if (i3 >= rankItemArr2.length) {
                    break;
                }
                RankItem rankItem = rankItemArr2[i3];
                if (rankItem != null) {
                    codedOutputByteBufferNano.writeMessage(1, rankItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GameScoreInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GameScoreInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GameScoreInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                RankItem[] rankItemArr = this.rankList;
                int length = rankItemArr == null ? 0 : rankItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RankItem[] rankItemArr2 = new RankItem[i3];
                if (length != 0) {
                    System.arraycopy(rankItemArr, 0, rankItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RankItem rankItem = new RankItem();
                    rankItemArr2[length] = rankItem;
                    codedInputByteBufferNano.readMessage(rankItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RankItem rankItem2 = new RankItem();
                rankItemArr2[length] = rankItem2;
                codedInputByteBufferNano.readMessage(rankItem2);
                this.rankList = rankItemArr2;
            }
        }
    }
}
