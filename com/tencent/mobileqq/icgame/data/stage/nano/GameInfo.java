package com.tencent.mobileqq.icgame.data.stage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GameInfo extends ExtendableMessageNano<GameInfo> {
    private static volatile GameInfo[] _emptyArray;
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
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.gameId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.gameName.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.gameName);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.gameId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.gameName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.gameName);
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
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.gameName = codedInputByteBufferNano.readString();
            }
        }
    }
}
