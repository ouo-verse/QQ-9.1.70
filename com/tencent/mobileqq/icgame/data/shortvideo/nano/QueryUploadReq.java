package com.tencent.mobileqq.icgame.data.shortvideo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class QueryUploadReq extends ExtendableMessageNano<QueryUploadReq> {
    private static volatile QueryUploadReq[] _emptyArray;
    public String fileMd5;

    public QueryUploadReq() {
        clear();
    }

    public static QueryUploadReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryUploadReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryUploadReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryUploadReq) MessageNano.mergeFrom(new QueryUploadReq(), bArr);
    }

    public QueryUploadReq clear() {
        this.fileMd5 = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.fileMd5.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.fileMd5);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.fileMd5.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.fileMd5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryUploadReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryUploadReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryUploadReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.fileMd5 = codedInputByteBufferNano.readString();
            }
        }
    }
}
