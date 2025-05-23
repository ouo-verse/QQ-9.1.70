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
public final class QueryTaskRsp extends ExtendableMessageNano<QueryTaskRsp> {
    private static volatile QueryTaskRsp[] _emptyArray;
    public Task task;

    public QueryTaskRsp() {
        clear();
    }

    public static QueryTaskRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryTaskRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryTaskRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryTaskRsp) MessageNano.mergeFrom(new QueryTaskRsp(), bArr);
    }

    public QueryTaskRsp clear() {
        this.task = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Task task = this.task;
        if (task != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, task);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Task task = this.task;
        if (task != null) {
            codedOutputByteBufferNano.writeMessage(1, task);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryTaskRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryTaskRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryTaskRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.task == null) {
                    this.task = new Task();
                }
                codedInputByteBufferNano.readMessage(this.task);
            }
        }
    }
}
