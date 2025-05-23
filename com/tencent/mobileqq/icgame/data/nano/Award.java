package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class Award extends ExtendableMessageNano<Award> {
    private static volatile Award[] _emptyArray;
    public String awardConfigId;
    public int awardType;
    public String desc;
    public long endTs;
    public long extraBuff;
    public long extraBuffScore;
    public long extraScore;
    public long startTs;

    public Award() {
        clear();
    }

    public static Award[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Award[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Award parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Award) MessageNano.mergeFrom(new Award(), bArr);
    }

    public Award clear() {
        this.startTs = 0L;
        this.endTs = 0L;
        this.awardType = 0;
        this.desc = "";
        this.extraScore = 0L;
        this.extraBuff = 0L;
        this.extraBuffScore = 0L;
        this.awardConfigId = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.startTs;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        long j16 = this.endTs;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j16);
        }
        int i3 = this.awardType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!this.desc.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
        }
        long j17 = this.extraScore;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        long j18 = this.extraBuff;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j18);
        }
        long j19 = this.extraBuffScore;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j19);
        }
        if (!this.awardConfigId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.awardConfigId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.startTs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        long j16 = this.endTs;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j16);
        }
        int i3 = this.awardType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.desc);
        }
        long j17 = this.extraScore;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        long j18 = this.extraBuff;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j18);
        }
        long j19 = this.extraBuffScore;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j19);
        }
        if (!this.awardConfigId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.awardConfigId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Award parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Award().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Award mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.startTs = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.endTs = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.awardType = readInt32;
                }
            } else if (readTag == 34) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.extraScore = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 48) {
                this.extraBuff = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 56) {
                this.extraBuffScore = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.awardConfigId = codedInputByteBufferNano.readString();
            }
        }
    }
}
