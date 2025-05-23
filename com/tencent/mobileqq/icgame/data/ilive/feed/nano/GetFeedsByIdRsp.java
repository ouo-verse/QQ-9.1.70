package com.tencent.mobileqq.icgame.data.ilive.feed.nano;

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
public final class GetFeedsByIdRsp extends ExtendableMessageNano<GetFeedsByIdRsp> {
    private static volatile GetFeedsByIdRsp[] _emptyArray;
    public FeedsInfo[] infos;

    public GetFeedsByIdRsp() {
        clear();
    }

    public static GetFeedsByIdRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetFeedsByIdRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetFeedsByIdRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetFeedsByIdRsp) MessageNano.mergeFrom(new GetFeedsByIdRsp(), bArr);
    }

    public GetFeedsByIdRsp clear() {
        this.infos = FeedsInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        FeedsInfo[] feedsInfoArr = this.infos;
        if (feedsInfoArr != null && feedsInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                FeedsInfo[] feedsInfoArr2 = this.infos;
                if (i3 >= feedsInfoArr2.length) {
                    break;
                }
                FeedsInfo feedsInfo = feedsInfoArr2[i3];
                if (feedsInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, feedsInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        FeedsInfo[] feedsInfoArr = this.infos;
        if (feedsInfoArr != null && feedsInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                FeedsInfo[] feedsInfoArr2 = this.infos;
                if (i3 >= feedsInfoArr2.length) {
                    break;
                }
                FeedsInfo feedsInfo = feedsInfoArr2[i3];
                if (feedsInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, feedsInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetFeedsByIdRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetFeedsByIdRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetFeedsByIdRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                FeedsInfo[] feedsInfoArr = this.infos;
                int length = feedsInfoArr == null ? 0 : feedsInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                FeedsInfo[] feedsInfoArr2 = new FeedsInfo[i3];
                if (length != 0) {
                    System.arraycopy(feedsInfoArr, 0, feedsInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    FeedsInfo feedsInfo = new FeedsInfo();
                    feedsInfoArr2[length] = feedsInfo;
                    codedInputByteBufferNano.readMessage(feedsInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                FeedsInfo feedsInfo2 = new FeedsInfo();
                feedsInfoArr2[length] = feedsInfo2;
                codedInputByteBufferNano.readMessage(feedsInfo2);
                this.infos = feedsInfoArr2;
            }
        }
    }
}
