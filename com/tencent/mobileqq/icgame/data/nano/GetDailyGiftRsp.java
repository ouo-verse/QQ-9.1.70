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
public final class GetDailyGiftRsp extends ExtendableMessageNano<GetDailyGiftRsp> {
    private static volatile GetDailyGiftRsp[] _emptyArray;
    public long anchorUid;
    public long giftPrice;

    public GetDailyGiftRsp() {
        clear();
    }

    public static GetDailyGiftRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetDailyGiftRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetDailyGiftRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetDailyGiftRsp) MessageNano.mergeFrom(new GetDailyGiftRsp(), bArr);
    }

    public GetDailyGiftRsp clear() {
        this.anchorUid = 0L;
        this.giftPrice = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        return super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.anchorUid) + CodedOutputByteBufferNano.computeUInt64Size(2, this.giftPrice);
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.anchorUid);
        codedOutputByteBufferNano.writeUInt64(2, this.giftPrice);
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetDailyGiftRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetDailyGiftRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetDailyGiftRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.giftPrice = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
