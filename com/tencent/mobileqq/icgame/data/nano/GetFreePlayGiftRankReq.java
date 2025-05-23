package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class GetFreePlayGiftRankReq extends ExtendableMessageNano<GetFreePlayGiftRankReq> {
    private static volatile GetFreePlayGiftRankReq[] _emptyArray;
    public int roomId;
    public long startSeq;
    public int tab;

    public GetFreePlayGiftRankReq() {
        clear();
    }

    public static GetFreePlayGiftRankReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFreePlayGiftRankReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFreePlayGiftRankReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFreePlayGiftRankReq) MessageNano.mergeFrom(new GetFreePlayGiftRankReq(), bArr);
    }

    public GetFreePlayGiftRankReq clear() {
        this.roomId = 0;
        this.startSeq = 0L;
        this.tab = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.startSeq) + CodedOutputByteBufferNano.computeUInt32Size(3, this.tab);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.startSeq);
        codedOutputByteBufferNano.writeUInt32(3, this.tab);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFreePlayGiftRankReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFreePlayGiftRankReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFreePlayGiftRankReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.startSeq = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.tab = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
