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
public final class DrawTimerInfo extends ExtendableMessageNano<DrawTimerInfo> {
    private static volatile DrawTimerInfo[] _emptyArray;
    public int drawStatus;
    public long roomId;
    public String startSeq;
    public long startTime;
    public int timeLimit;
    public long uid;

    public DrawTimerInfo() {
        clear();
    }

    public static DrawTimerInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawTimerInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawTimerInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawTimerInfo) MessageNano.mergeFrom(new DrawTimerInfo(), bArr);
    }

    public DrawTimerInfo clear() {
        this.roomId = 0L;
        this.startTime = 0L;
        this.timeLimit = 0;
        this.startSeq = "";
        this.drawStatus = 0;
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        int i3 = this.timeLimit;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!this.startSeq.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.startSeq);
        }
        int i16 = this.drawStatus;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.startTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        int i3 = this.timeLimit;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.startSeq);
        }
        int i16 = this.drawStatus;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawTimerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawTimerInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawTimerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.timeLimit = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.startSeq = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.drawStatus = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
