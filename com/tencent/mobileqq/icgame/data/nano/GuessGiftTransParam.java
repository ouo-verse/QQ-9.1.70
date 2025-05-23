package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GuessGiftTransParam extends ExtendableMessageNano<GuessGiftTransParam> {
    private static volatile GuessGiftTransParam[] _emptyArray;
    public String guessSeq;
    public int seatType;
    public long startSeq;

    public GuessGiftTransParam() {
        clear();
    }

    public static GuessGiftTransParam[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GuessGiftTransParam[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GuessGiftTransParam parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GuessGiftTransParam) MessageNano.mergeFrom(new GuessGiftTransParam(), bArr);
    }

    public GuessGiftTransParam clear() {
        this.seatType = 0;
        this.startSeq = 0L;
        this.guessSeq = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.seatType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.guessSeq.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.guessSeq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.seatType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.startSeq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.guessSeq.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.guessSeq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GuessGiftTransParam parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GuessGiftTransParam().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GuessGiftTransParam mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.seatType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.guessSeq = codedInputByteBufferNano.readString();
            }
        }
    }
}
