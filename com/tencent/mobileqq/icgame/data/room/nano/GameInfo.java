package com.tencent.mobileqq.icgame.data.room.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GameInfo extends ExtendableMessageNano<GameInfo> {
    private static volatile GameInfo[] _emptyArray;
    public byte[] gameDetail;
    public int gameId;
    public String gameName;

    public GameInfo() {
        clear();
    }

    public static GameInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GameInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GameInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GameInfo) MessageNano.mergeFrom(new GameInfo(), bArr);
    }

    public GameInfo clear() {
        this.gameId = 0;
        this.gameName = "";
        this.gameDetail = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.gameId);
        if (!this.gameName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.gameName);
        }
        if (!Arrays.equals(this.gameDetail, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.gameDetail);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.gameId);
        if (!this.gameName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.gameName);
        }
        if (!Arrays.equals(this.gameDetail, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.gameDetail);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GameInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GameInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GameInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.gameId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.gameName = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.gameDetail = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
