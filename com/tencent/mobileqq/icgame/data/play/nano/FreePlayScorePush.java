package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class FreePlayScorePush extends ExtendableMessageNano<FreePlayScorePush> {
    private static volatile FreePlayScorePush[] _emptyArray;
    public int roomId;
    public FreePlayScore score;

    public FreePlayScorePush() {
        clear();
    }

    public static FreePlayScorePush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FreePlayScorePush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FreePlayScorePush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FreePlayScorePush) MessageNano.mergeFrom(new FreePlayScorePush(), bArr);
    }

    public FreePlayScorePush clear() {
        this.roomId = 0;
        this.score = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        FreePlayScore freePlayScore = this.score;
        if (freePlayScore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, freePlayScore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        FreePlayScore freePlayScore = this.score;
        if (freePlayScore != null) {
            codedOutputByteBufferNano.writeMessage(2, freePlayScore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FreePlayScorePush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FreePlayScorePush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FreePlayScorePush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.score == null) {
                    this.score = new FreePlayScore();
                }
                codedInputByteBufferNano.readMessage(this.score);
            }
        }
    }
}
