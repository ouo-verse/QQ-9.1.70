package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class QueryParticipantRsp extends ExtendableMessageNano<QueryParticipantRsp> {
    private static volatile QueryParticipantRsp[] _emptyArray;
    public Participant participant;

    public QueryParticipantRsp() {
        clear();
    }

    public static QueryParticipantRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryParticipantRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryParticipantRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryParticipantRsp) MessageNano.mergeFrom(new QueryParticipantRsp(), bArr);
    }

    public QueryParticipantRsp clear() {
        this.participant = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Participant participant = this.participant;
        if (participant != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, participant);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Participant participant = this.participant;
        if (participant != null) {
            codedOutputByteBufferNano.writeMessage(1, participant);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryParticipantRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryParticipantRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryParticipantRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.participant == null) {
                    this.participant = new Participant();
                }
                codedInputByteBufferNano.readMessage(this.participant);
            }
        }
    }
}
