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

/* loaded from: classes15.dex */
public final class MediaCommPush extends ExtendableMessageNano<MediaCommPush> {
    private static volatile MediaCommPush[] _emptyArray;
    public byte[] pushData;
    public int pushType;
    public long uid;

    public MediaCommPush() {
        clear();
    }

    public static MediaCommPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MediaCommPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MediaCommPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MediaCommPush) MessageNano.mergeFrom(new MediaCommPush(), bArr);
    }

    public MediaCommPush clear() {
        this.pushType = 0;
        this.uid = 0L;
        this.pushData = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.pushType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!Arrays.equals(this.pushData, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.pushData);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.pushType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!Arrays.equals(this.pushData, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.pushData);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MediaCommPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MediaCommPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MediaCommPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.pushType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.pushData = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
