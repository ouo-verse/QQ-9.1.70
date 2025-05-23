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
public final class BatchGetAnchorUnionInfoRsp extends ExtendableMessageNano<BatchGetAnchorUnionInfoRsp> {
    private static volatile BatchGetAnchorUnionInfoRsp[] _emptyArray;
    public AnchorUnionInfo[] anchorUnionInfo;

    public BatchGetAnchorUnionInfoRsp() {
        clear();
    }

    public static BatchGetAnchorUnionInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetAnchorUnionInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetAnchorUnionInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetAnchorUnionInfoRsp) MessageNano.mergeFrom(new BatchGetAnchorUnionInfoRsp(), bArr);
    }

    public BatchGetAnchorUnionInfoRsp clear() {
        this.anchorUnionInfo = AnchorUnionInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnchorUnionInfo[] anchorUnionInfoArr = this.anchorUnionInfo;
        if (anchorUnionInfoArr != null && anchorUnionInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnchorUnionInfo[] anchorUnionInfoArr2 = this.anchorUnionInfo;
                if (i3 >= anchorUnionInfoArr2.length) {
                    break;
                }
                AnchorUnionInfo anchorUnionInfo = anchorUnionInfoArr2[i3];
                if (anchorUnionInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, anchorUnionInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnchorUnionInfo[] anchorUnionInfoArr = this.anchorUnionInfo;
        if (anchorUnionInfoArr != null && anchorUnionInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AnchorUnionInfo[] anchorUnionInfoArr2 = this.anchorUnionInfo;
                if (i3 >= anchorUnionInfoArr2.length) {
                    break;
                }
                AnchorUnionInfo anchorUnionInfo = anchorUnionInfoArr2[i3];
                if (anchorUnionInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, anchorUnionInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetAnchorUnionInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetAnchorUnionInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetAnchorUnionInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                AnchorUnionInfo[] anchorUnionInfoArr = this.anchorUnionInfo;
                int length = anchorUnionInfoArr == null ? 0 : anchorUnionInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                AnchorUnionInfo[] anchorUnionInfoArr2 = new AnchorUnionInfo[i3];
                if (length != 0) {
                    System.arraycopy(anchorUnionInfoArr, 0, anchorUnionInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    AnchorUnionInfo anchorUnionInfo = new AnchorUnionInfo();
                    anchorUnionInfoArr2[length] = anchorUnionInfo;
                    codedInputByteBufferNano.readMessage(anchorUnionInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                AnchorUnionInfo anchorUnionInfo2 = new AnchorUnionInfo();
                anchorUnionInfoArr2[length] = anchorUnionInfo2;
                codedInputByteBufferNano.readMessage(anchorUnionInfo2);
                this.anchorUnionInfo = anchorUnionInfoArr2;
            }
        }
    }
}
