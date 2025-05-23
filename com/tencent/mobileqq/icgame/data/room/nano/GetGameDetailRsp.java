package com.tencent.mobileqq.icgame.data.room.nano;

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
public final class GetGameDetailRsp extends ExtendableMessageNano<GetGameDetailRsp> {
    private static volatile GetGameDetailRsp[] _emptyArray;
    public GameInfo[] gameInfo;

    public GetGameDetailRsp() {
        clear();
    }

    public static GetGameDetailRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGameDetailRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGameDetailRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGameDetailRsp) MessageNano.mergeFrom(new GetGameDetailRsp(), bArr);
    }

    public GetGameDetailRsp clear() {
        this.gameInfo = GameInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GameInfo[] gameInfoArr = this.gameInfo;
        if (gameInfoArr != null && gameInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                GameInfo[] gameInfoArr2 = this.gameInfo;
                if (i3 >= gameInfoArr2.length) {
                    break;
                }
                GameInfo gameInfo = gameInfoArr2[i3];
                if (gameInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gameInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GameInfo[] gameInfoArr = this.gameInfo;
        if (gameInfoArr != null && gameInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                GameInfo[] gameInfoArr2 = this.gameInfo;
                if (i3 >= gameInfoArr2.length) {
                    break;
                }
                GameInfo gameInfo = gameInfoArr2[i3];
                if (gameInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, gameInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGameDetailRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGameDetailRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGameDetailRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                GameInfo[] gameInfoArr = this.gameInfo;
                int length = gameInfoArr == null ? 0 : gameInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GameInfo[] gameInfoArr2 = new GameInfo[i3];
                if (length != 0) {
                    System.arraycopy(gameInfoArr, 0, gameInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GameInfo gameInfo = new GameInfo();
                    gameInfoArr2[length] = gameInfo;
                    codedInputByteBufferNano.readMessage(gameInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GameInfo gameInfo2 = new GameInfo();
                gameInfoArr2[length] = gameInfo2;
                codedInputByteBufferNano.readMessage(gameInfo2);
                this.gameInfo = gameInfoArr2;
            }
        }
    }
}
