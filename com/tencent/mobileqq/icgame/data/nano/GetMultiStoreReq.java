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
public final class GetMultiStoreReq extends ExtendableMessageNano<GetMultiStoreReq> {
    private static volatile GetMultiStoreReq[] _emptyArray;
    public boolean getAdoreStore;
    public boolean getGiftStore;
    public long uid;

    public GetMultiStoreReq() {
        clear();
    }

    public static GetMultiStoreReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMultiStoreReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMultiStoreReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMultiStoreReq) MessageNano.mergeFrom(new GetMultiStoreReq(), bArr);
    }

    public GetMultiStoreReq clear() {
        this.uid = 0L;
        this.getGiftStore = false;
        this.getAdoreStore = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        boolean z16 = this.getGiftStore;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        boolean z17 = this.getAdoreStore;
        if (z17) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        boolean z16 = this.getGiftStore;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        boolean z17 = this.getAdoreStore;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMultiStoreReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMultiStoreReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMultiStoreReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.getGiftStore = codedInputByteBufferNano.readBool();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.getAdoreStore = codedInputByteBufferNano.readBool();
            }
        }
    }
}
