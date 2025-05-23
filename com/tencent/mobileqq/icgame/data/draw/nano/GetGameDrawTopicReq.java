package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetGameDrawTopicReq extends ExtendableMessageNano<GetGameDrawTopicReq> {
    private static volatile GetGameDrawTopicReq[] _emptyArray;
    public long roomId;
    public String startSeq;

    public GetGameDrawTopicReq() {
        clear();
    }

    public static GetGameDrawTopicReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGameDrawTopicReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGameDrawTopicReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGameDrawTopicReq) MessageNano.mergeFrom(new GetGameDrawTopicReq(), bArr);
    }

    public GetGameDrawTopicReq clear() {
        this.roomId = 0L;
        this.startSeq = "";
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
        if (!this.startSeq.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.startSeq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.startSeq.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.startSeq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGameDrawTopicReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGameDrawTopicReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGameDrawTopicReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.startSeq = codedInputByteBufferNano.readString();
            }
        }
    }
}
