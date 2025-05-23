package com.tencent.mobileqq.icgame.data.stage.nano;

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
public final class BatchGetStageInfoRsp extends ExtendableMessageNano<BatchGetStageInfoRsp> {
    private static volatile BatchGetStageInfoRsp[] _emptyArray;
    public StageInfo[] stageInfos;

    public BatchGetStageInfoRsp() {
        clear();
    }

    public static BatchGetStageInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetStageInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetStageInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetStageInfoRsp) MessageNano.mergeFrom(new BatchGetStageInfoRsp(), bArr);
    }

    public BatchGetStageInfoRsp clear() {
        this.stageInfos = StageInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        StageInfo[] stageInfoArr = this.stageInfos;
        if (stageInfoArr != null && stageInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                StageInfo[] stageInfoArr2 = this.stageInfos;
                if (i3 >= stageInfoArr2.length) {
                    break;
                }
                StageInfo stageInfo = stageInfoArr2[i3];
                if (stageInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, stageInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        StageInfo[] stageInfoArr = this.stageInfos;
        if (stageInfoArr != null && stageInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                StageInfo[] stageInfoArr2 = this.stageInfos;
                if (i3 >= stageInfoArr2.length) {
                    break;
                }
                StageInfo stageInfo = stageInfoArr2[i3];
                if (stageInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, stageInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetStageInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetStageInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetStageInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                StageInfo[] stageInfoArr = this.stageInfos;
                int length = stageInfoArr == null ? 0 : stageInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                StageInfo[] stageInfoArr2 = new StageInfo[i3];
                if (length != 0) {
                    System.arraycopy(stageInfoArr, 0, stageInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    StageInfo stageInfo = new StageInfo();
                    stageInfoArr2[length] = stageInfo;
                    codedInputByteBufferNano.readMessage(stageInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                StageInfo stageInfo2 = new StageInfo();
                stageInfoArr2[length] = stageInfo2;
                codedInputByteBufferNano.readMessage(stageInfo2);
                this.stageInfos = stageInfoArr2;
            }
        }
    }
}
