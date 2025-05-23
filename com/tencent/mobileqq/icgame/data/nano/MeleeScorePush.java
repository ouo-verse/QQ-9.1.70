package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class MeleeScorePush extends ExtendableMessageNano<MeleeScorePush> {
    private static volatile MeleeScorePush[] _emptyArray;
    public MeleeScore meleeScore;
    public int roomId;

    public MeleeScorePush() {
        clear();
    }

    public static MeleeScorePush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeleeScorePush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeleeScorePush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeleeScorePush) MessageNano.mergeFrom(new MeleeScorePush(), bArr);
    }

    public MeleeScorePush clear() {
        this.roomId = 0;
        this.meleeScore = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        MeleeScore meleeScore = this.meleeScore;
        if (meleeScore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, meleeScore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        MeleeScore meleeScore = this.meleeScore;
        if (meleeScore != null) {
            codedOutputByteBufferNano.writeMessage(2, meleeScore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeleeScorePush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeleeScorePush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeleeScorePush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.meleeScore == null) {
                    this.meleeScore = new MeleeScore();
                }
                codedInputByteBufferNano.readMessage(this.meleeScore);
            }
        }
    }
}
