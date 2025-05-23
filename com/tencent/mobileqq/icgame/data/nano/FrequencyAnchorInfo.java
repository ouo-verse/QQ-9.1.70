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
public final class FrequencyAnchorInfo extends ExtendableMessageNano<FrequencyAnchorInfo> {
    private static volatile FrequencyAnchorInfo[] _emptyArray;
    public long anchorUid;
    public long last;
    public int times;

    public FrequencyAnchorInfo() {
        clear();
    }

    public static FrequencyAnchorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FrequencyAnchorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FrequencyAnchorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FrequencyAnchorInfo) MessageNano.mergeFrom(new FrequencyAnchorInfo(), bArr);
    }

    public FrequencyAnchorInfo clear() {
        this.last = 0L;
        this.times = 0;
        this.anchorUid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.last;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.times;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.last;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.times;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FrequencyAnchorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FrequencyAnchorInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FrequencyAnchorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.last = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                this.times = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
