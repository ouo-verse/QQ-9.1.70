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
public final class GetAuctionInfoRsp extends ExtendableMessageNano<GetAuctionInfoRsp> {
    private static volatile GetAuctionInfoRsp[] _emptyArray;
    public AuctionBasicInfo auctionInfo;

    public GetAuctionInfoRsp() {
        clear();
    }

    public static GetAuctionInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAuctionInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAuctionInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAuctionInfoRsp) MessageNano.mergeFrom(new GetAuctionInfoRsp(), bArr);
    }

    public GetAuctionInfoRsp clear() {
        this.auctionInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, auctionBasicInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AuctionBasicInfo auctionBasicInfo = this.auctionInfo;
        if (auctionBasicInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, auctionBasicInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAuctionInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAuctionInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAuctionInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.auctionInfo == null) {
                    this.auctionInfo = new AuctionBasicInfo();
                }
                codedInputByteBufferNano.readMessage(this.auctionInfo);
            }
        }
    }
}
