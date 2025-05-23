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
public final class GetGiftStoreReq extends ExtendableMessageNano<GetGiftStoreReq> {
    private static volatile GetGiftStoreReq[] _emptyArray;
    public long uid;

    public GetGiftStoreReq() {
        clear();
    }

    public static GetGiftStoreReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGiftStoreReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGiftStoreReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGiftStoreReq) MessageNano.mergeFrom(new GetGiftStoreReq(), bArr);
    }

    public GetGiftStoreReq clear() {
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGiftStoreReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGiftStoreReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGiftStoreReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
