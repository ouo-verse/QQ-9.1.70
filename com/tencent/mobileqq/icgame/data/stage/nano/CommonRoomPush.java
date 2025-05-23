package com.tencent.mobileqq.icgame.data.stage.nano;

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
public final class CommonRoomPush extends ExtendableMessageNano<CommonRoomPush> {
    private static volatile CommonRoomPush[] _emptyArray;
    public int clientCmd;
    public byte[] data;
    public long roomid;

    public CommonRoomPush() {
        clear();
    }

    public static CommonRoomPush[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonRoomPush[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonRoomPush parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonRoomPush) MessageNano.mergeFrom(new CommonRoomPush(), bArr);
    }

    public CommonRoomPush clear() {
        this.clientCmd = 0;
        this.roomid = 0L;
        this.data = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.clientCmd;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.roomid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.clientCmd;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.roomid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonRoomPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonRoomPush().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonRoomPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.clientCmd = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.roomid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.data = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
