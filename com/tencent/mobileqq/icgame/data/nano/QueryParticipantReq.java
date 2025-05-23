package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class QueryParticipantReq extends ExtendableMessageNano<QueryParticipantReq> {
    private static volatile QueryParticipantReq[] _emptyArray;
    public String actId;
    public long participantId;
    public String taskId;

    public QueryParticipantReq() {
        clear();
    }

    public static QueryParticipantReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryParticipantReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryParticipantReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryParticipantReq) MessageNano.mergeFrom(new QueryParticipantReq(), bArr);
    }

    public QueryParticipantReq clear() {
        this.actId = "";
        this.taskId = "";
        this.participantId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.actId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.actId);
        }
        if (!this.taskId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.taskId);
        }
        long j3 = this.participantId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        if (!this.taskId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.taskId);
        }
        long j3 = this.participantId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryParticipantReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryParticipantReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryParticipantReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.actId = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.taskId = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.participantId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
