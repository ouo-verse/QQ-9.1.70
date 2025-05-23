package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetAuctionInfoListRsp extends ExtendableMessageNano<GetAuctionInfoListRsp> {
    private static volatile GetAuctionInfoListRsp[] _emptyArray;
    public AuctionBasicInfo[] auctionInfo;

    public GetAuctionInfoListRsp() {
        clear();
    }

    public static GetAuctionInfoListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAuctionInfoListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAuctionInfoListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAuctionInfoListRsp) MessageNano.mergeFrom(new GetAuctionInfoListRsp(), bArr);
    }

    public GetAuctionInfoListRsp clear() {
        this.auctionInfo = AuctionBasicInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AuctionBasicInfo[] auctionBasicInfoArr = this.auctionInfo;
        if (auctionBasicInfoArr != null && auctionBasicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AuctionBasicInfo[] auctionBasicInfoArr2 = this.auctionInfo;
                if (i3 >= auctionBasicInfoArr2.length) {
                    break;
                }
                AuctionBasicInfo auctionBasicInfo = auctionBasicInfoArr2[i3];
                if (auctionBasicInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, auctionBasicInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AuctionBasicInfo[] auctionBasicInfoArr = this.auctionInfo;
        if (auctionBasicInfoArr != null && auctionBasicInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AuctionBasicInfo[] auctionBasicInfoArr2 = this.auctionInfo;
                if (i3 >= auctionBasicInfoArr2.length) {
                    break;
                }
                AuctionBasicInfo auctionBasicInfo = auctionBasicInfoArr2[i3];
                if (auctionBasicInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, auctionBasicInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAuctionInfoListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAuctionInfoListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAuctionInfoListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                AuctionBasicInfo[] auctionBasicInfoArr = this.auctionInfo;
                int length = auctionBasicInfoArr == null ? 0 : auctionBasicInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AuctionBasicInfo[] auctionBasicInfoArr2 = new AuctionBasicInfo[i3];
                if (length != 0) {
                    System.arraycopy(auctionBasicInfoArr, 0, auctionBasicInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AuctionBasicInfo auctionBasicInfo = new AuctionBasicInfo();
                    auctionBasicInfoArr2[length] = auctionBasicInfo;
                    codedInputByteBufferNano.readMessage(auctionBasicInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AuctionBasicInfo auctionBasicInfo2 = new AuctionBasicInfo();
                auctionBasicInfoArr2[length] = auctionBasicInfo2;
                codedInputByteBufferNano.readMessage(auctionBasicInfo2);
                this.auctionInfo = auctionBasicInfoArr2;
            }
        }
    }
}
