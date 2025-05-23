package com.tencent.mobileqq.icgame.data.mgr.nano;

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
public final class OpenDrawReq extends ExtendableMessageNano<OpenDrawReq> {
    private static volatile OpenDrawReq[] _emptyArray;
    public byte[] openDrawExt;
    public int roomId;
    public long uid;

    public OpenDrawReq() {
        clear();
    }

    public static OpenDrawReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new OpenDrawReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static OpenDrawReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (OpenDrawReq) MessageNano.mergeFrom(new OpenDrawReq(), bArr);
    }

    public OpenDrawReq clear() {
        this.uid = 0L;
        this.roomId = 0;
        this.openDrawExt = WireFormatNano.EMPTY_BYTES;
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
        int i3 = this.roomId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!Arrays.equals(this.openDrawExt, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(3, this.openDrawExt);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.roomId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!Arrays.equals(this.openDrawExt, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.openDrawExt);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static OpenDrawReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new OpenDrawReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public OpenDrawReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.openDrawExt = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
