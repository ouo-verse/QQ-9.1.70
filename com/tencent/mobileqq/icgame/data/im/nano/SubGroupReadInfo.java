package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SubGroupReadInfo extends ExtendableMessageNano<SubGroupReadInfo> {
    private static volatile SubGroupReadInfo[] _emptyArray;
    public int accountSubGroup;
    public long readLastTime;

    public SubGroupReadInfo() {
        clear();
    }

    public static SubGroupReadInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SubGroupReadInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SubGroupReadInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SubGroupReadInfo) MessageNano.mergeFrom(new SubGroupReadInfo(), bArr);
    }

    public SubGroupReadInfo clear() {
        this.accountSubGroup = 0;
        this.readLastTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.accountSubGroup;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.readLastTime;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.accountSubGroup;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.readLastTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SubGroupReadInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SubGroupReadInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SubGroupReadInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.accountSubGroup = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.readLastTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
