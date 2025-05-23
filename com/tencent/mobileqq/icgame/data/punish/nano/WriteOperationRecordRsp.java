package com.tencent.mobileqq.icgame.data.punish.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class WriteOperationRecordRsp extends ExtendableMessageNano<WriteOperationRecordRsp> {
    private static volatile WriteOperationRecordRsp[] _emptyArray;

    public WriteOperationRecordRsp() {
        clear();
    }

    public static WriteOperationRecordRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WriteOperationRecordRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static WriteOperationRecordRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (WriteOperationRecordRsp) MessageNano.mergeFrom(new WriteOperationRecordRsp(), bArr);
    }

    public WriteOperationRecordRsp clear() {
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    public static WriteOperationRecordRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new WriteOperationRecordRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public WriteOperationRecordRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int readTag;
        do {
            readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            }
        } while (storeUnknownField(codedInputByteBufferNano, readTag));
        return this;
    }
}
