package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GuessInfo extends ExtendableMessageNano<GuessInfo> {
    private static volatile GuessInfo[] _emptyArray;
    public int guessStatus;
    public int multiple;
    public int score;
    public int seatNo;
    public long timestamp;
    public String topic;
    public long uid;

    public GuessInfo() {
        clear();
    }

    public static GuessInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GuessInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GuessInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GuessInfo) MessageNano.mergeFrom(new GuessInfo(), bArr);
    }

    public GuessInfo clear() {
        this.uid = 0L;
        this.seatNo = 0;
        this.topic = "";
        this.multiple = 0;
        this.guessStatus = 0;
        this.timestamp = 0L;
        this.score = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.seatNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.topic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.topic);
        }
        int i16 = this.multiple;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.guessStatus;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        int i18 = this.score;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.seatNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.topic.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.topic);
        }
        int i16 = this.multiple;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.guessStatus;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        long j16 = this.timestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        int i18 = this.score;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GuessInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GuessInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GuessInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.seatNo = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.topic = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.multiple = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.guessStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.score = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
