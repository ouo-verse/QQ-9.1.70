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
public final class GetDailyGiftReq extends ExtendableMessageNano<GetDailyGiftReq> {
    private static volatile GetDailyGiftReq[] _emptyArray;
    public long anchorUid;
    public int roomId;

    public GetDailyGiftReq() {
        clear();
    }

    public static GetDailyGiftReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDailyGiftReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDailyGiftReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDailyGiftReq) MessageNano.mergeFrom(new GetDailyGiftReq(), bArr);
    }

    public GetDailyGiftReq clear() {
        this.roomId = 0;
        this.anchorUid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.anchorUid);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.anchorUid);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDailyGiftReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDailyGiftReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDailyGiftReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
