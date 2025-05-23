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
public final class IsLoveAnchorReq extends ExtendableMessageNano<IsLoveAnchorReq> {
    private static volatile IsLoveAnchorReq[] _emptyArray;
    public long roomId;
    public long uid;

    public IsLoveAnchorReq() {
        clear();
    }

    public static IsLoveAnchorReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new IsLoveAnchorReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static IsLoveAnchorReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (IsLoveAnchorReq) MessageNano.mergeFrom(new IsLoveAnchorReq(), bArr);
    }

    public IsLoveAnchorReq clear() {
        this.roomId = 0L;
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
        long j16 = this.uid;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static IsLoveAnchorReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new IsLoveAnchorReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public IsLoveAnchorReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
