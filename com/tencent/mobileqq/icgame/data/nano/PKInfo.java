package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PKInfo extends ExtendableMessageNano<PKInfo> {
    private static volatile PKInfo[] _emptyArray;
    public long negativeScore;
    public long negativeUid;
    public long pkEndTs;
    public long pkId;
    public long pkStartTs;
    public long positiveScore;
    public long positiveUid;

    public PKInfo() {
        clear();
    }

    public static PKInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PKInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PKInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PKInfo) MessageNano.mergeFrom(new PKInfo(), bArr);
    }

    public PKInfo clear() {
        this.pkId = 0L;
        this.positiveUid = 0L;
        this.negativeUid = 0L;
        this.positiveScore = 0L;
        this.negativeScore = 0L;
        this.pkStartTs = 0L;
        this.pkEndTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.pkId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.positiveUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        long j17 = this.negativeUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j17);
        }
        long j18 = this.positiveScore;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j18);
        }
        long j19 = this.negativeScore;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j19);
        }
        long j26 = this.pkStartTs;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j26);
        }
        long j27 = this.pkEndTs;
        if (j27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, j27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.pkId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.positiveUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        long j17 = this.negativeUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j17);
        }
        long j18 = this.positiveScore;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j18);
        }
        long j19 = this.negativeScore;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j19);
        }
        long j26 = this.pkStartTs;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j26);
        }
        long j27 = this.pkEndTs;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PKInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PKInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PKInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.pkId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.positiveUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.negativeUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 32) {
                this.positiveScore = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 40) {
                this.negativeScore = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.pkStartTs = codedInputByteBufferNano.readInt64();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.pkEndTs = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
