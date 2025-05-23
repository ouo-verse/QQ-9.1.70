package com.tencent.mobileqq.icgame.data.punish.nano;

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
public final class PermitReq extends ExtendableMessageNano<PermitReq> {
    private static volatile PermitReq[] _emptyArray;
    public byte[] reason;
    public int roomId;
    public int type;
    public long uid;

    public PermitReq() {
        clear();
    }

    public static PermitReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PermitReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PermitReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PermitReq) MessageNano.mergeFrom(new PermitReq(), bArr);
    }

    public PermitReq clear() {
        this.type = 0;
        this.uid = 0L;
        this.roomId = 0;
        this.reason = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.type) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid);
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!Arrays.equals(this.reason, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.reason);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.type);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!Arrays.equals(this.reason, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.reason);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PermitReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PermitReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PermitReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.reason = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
