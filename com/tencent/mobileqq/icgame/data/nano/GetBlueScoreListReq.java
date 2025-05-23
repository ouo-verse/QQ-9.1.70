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
public final class GetBlueScoreListReq extends ExtendableMessageNano<GetBlueScoreListReq> {
    private static volatile GetBlueScoreListReq[] _emptyArray;
    public int roomId;

    public GetBlueScoreListReq() {
        clear();
    }

    public static GetBlueScoreListReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetBlueScoreListReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetBlueScoreListReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetBlueScoreListReq) MessageNano.mergeFrom(new GetBlueScoreListReq(), bArr);
    }

    public GetBlueScoreListReq clear() {
        this.roomId = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetBlueScoreListReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetBlueScoreListReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetBlueScoreListReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.roomId = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
