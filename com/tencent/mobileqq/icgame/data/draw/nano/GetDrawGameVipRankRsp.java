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
public final class GetDrawGameVipRankRsp extends ExtendableMessageNano<GetDrawGameVipRankRsp> {
    private static volatile GetDrawGameVipRankRsp[] _emptyArray;
    public String errMsg;
    public RankItem[] rankList;
    public int result;

    public GetDrawGameVipRankRsp() {
        clear();
    }

    public static GetDrawGameVipRankRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDrawGameVipRankRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDrawGameVipRankRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDrawGameVipRankRsp) MessageNano.mergeFrom(new GetDrawGameVipRankRsp(), bArr);
    }

    public GetDrawGameVipRankRsp clear() {
        this.result = 0;
        this.rankList = RankItem.emptyArray();
        this.errMsg = "";
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
        RankItem[] rankItemArr = this.rankList;
        if (rankItemArr != null && rankItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                RankItem[] rankItemArr2 = this.rankList;
                if (i16 >= rankItemArr2.length) {
                    break;
                }
                RankItem rankItem = rankItemArr2[i16];
                if (rankItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, rankItem);
                }
                i16++;
            }
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        RankItem[] rankItemArr = this.rankList;
        if (rankItemArr != null && rankItemArr.length > 0) {
            int i16 = 0;
            while (true) {
                RankItem[] rankItemArr2 = this.rankList;
                if (i16 >= rankItemArr2.length) {
                    break;
                }
                RankItem rankItem = rankItemArr2[i16];
                if (rankItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, rankItem);
                }
                i16++;
            }
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDrawGameVipRankRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDrawGameVipRankRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDrawGameVipRankRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
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
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
