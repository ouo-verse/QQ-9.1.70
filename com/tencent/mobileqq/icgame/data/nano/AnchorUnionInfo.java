package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnchorUnionInfo extends ExtendableMessageNano<AnchorUnionInfo> {
    private static volatile AnchorUnionInfo[] _emptyArray;
    public long uint64PresidentUin;
    public int unionId;
    public byte[] unionName;
    public long userId;

    public AnchorUnionInfo() {
        clear();
    }

    public static AnchorUnionInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorUnionInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorUnionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorUnionInfo) MessageNano.mergeFrom(new AnchorUnionInfo(), bArr);
    }

    public AnchorUnionInfo clear() {
        this.userId = 0L;
        this.unionId = 0;
        this.unionName = WireFormatNano.EMPTY_BYTES;
        this.uint64PresidentUin = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.userId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.unionId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.unionName, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.unionName);
        }
        long j16 = this.uint64PresidentUin;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.userId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.unionId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.unionName, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.unionName);
        }
        long j16 = this.uint64PresidentUin;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorUnionInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorUnionInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorUnionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.unionId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.unionName = codedInputByteBufferNano.readBytes();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uint64PresidentUin = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
