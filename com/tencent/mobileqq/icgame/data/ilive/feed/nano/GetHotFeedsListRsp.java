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
public final class GetHotFeedsListRsp extends ExtendableMessageNano<GetHotFeedsListRsp> {
    private static volatile GetHotFeedsListRsp[] _emptyArray;
    public FeedsInfo[] infos;
    public int retCode;
    public String retMsg;
    public int total;

    public GetHotFeedsListRsp() {
        clear();
    }

    public static GetHotFeedsListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetHotFeedsListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetHotFeedsListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetHotFeedsListRsp) MessageNano.mergeFrom(new GetHotFeedsListRsp(), bArr);
    }

    public GetHotFeedsListRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.infos = FeedsInfo.emptyArray();
        this.total = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        FeedsInfo[] feedsInfoArr = this.infos;
        if (feedsInfoArr != null && feedsInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                FeedsInfo[] feedsInfoArr2 = this.infos;
                if (i16 >= feedsInfoArr2.length) {
                    break;
                }
                FeedsInfo feedsInfo = feedsInfoArr2[i16];
                if (feedsInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, feedsInfo);
                }
                i16++;
            }
        }
        int i17 = this.total;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        FeedsInfo[] feedsInfoArr = this.infos;
        if (feedsInfoArr != null && feedsInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                FeedsInfo[] feedsInfoArr2 = this.infos;
                if (i16 >= feedsInfoArr2.length) {
                    break;
                }
                FeedsInfo feedsInfo = feedsInfoArr2[i16];
                if (feedsInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, feedsInfo);
                }
                i16++;
            }
        }
        int i17 = this.total;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetHotFeedsListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetHotFeedsListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetHotFeedsListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
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
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.total = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
