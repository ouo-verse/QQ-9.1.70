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
public final class BatchGetExperienceInfoRsp extends ExtendableMessageNano<BatchGetExperienceInfoRsp> {
    private static volatile BatchGetExperienceInfoRsp[] _emptyArray;
    public GetExperienceInfoRsp[] exps;

    public BatchGetExperienceInfoRsp() {
        clear();
    }

    public static BatchGetExperienceInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BatchGetExperienceInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BatchGetExperienceInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BatchGetExperienceInfoRsp) MessageNano.mergeFrom(new BatchGetExperienceInfoRsp(), bArr);
    }

    public BatchGetExperienceInfoRsp clear() {
        this.exps = GetExperienceInfoRsp.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GetExperienceInfoRsp[] getExperienceInfoRspArr = this.exps;
        if (getExperienceInfoRspArr != null && getExperienceInfoRspArr.length > 0) {
            int i3 = 0;
            while (true) {
                GetExperienceInfoRsp[] getExperienceInfoRspArr2 = this.exps;
                if (i3 >= getExperienceInfoRspArr2.length) {
                    break;
                }
                GetExperienceInfoRsp getExperienceInfoRsp = getExperienceInfoRspArr2[i3];
                if (getExperienceInfoRsp != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, getExperienceInfoRsp);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GetExperienceInfoRsp[] getExperienceInfoRspArr = this.exps;
        if (getExperienceInfoRspArr != null && getExperienceInfoRspArr.length > 0) {
            int i3 = 0;
            while (true) {
                GetExperienceInfoRsp[] getExperienceInfoRspArr2 = this.exps;
                if (i3 >= getExperienceInfoRspArr2.length) {
                    break;
                }
                GetExperienceInfoRsp getExperienceInfoRsp = getExperienceInfoRspArr2[i3];
                if (getExperienceInfoRsp != null) {
                    codedOutputByteBufferNano.writeMessage(1, getExperienceInfoRsp);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BatchGetExperienceInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BatchGetExperienceInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BatchGetExperienceInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                GetExperienceInfoRsp[] getExperienceInfoRspArr = this.exps;
                int length = getExperienceInfoRspArr == null ? 0 : getExperienceInfoRspArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GetExperienceInfoRsp[] getExperienceInfoRspArr2 = new GetExperienceInfoRsp[i3];
                if (length != 0) {
                    System.arraycopy(getExperienceInfoRspArr, 0, getExperienceInfoRspArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GetExperienceInfoRsp getExperienceInfoRsp = new GetExperienceInfoRsp();
                    getExperienceInfoRspArr2[length] = getExperienceInfoRsp;
                    codedInputByteBufferNano.readMessage(getExperienceInfoRsp);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GetExperienceInfoRsp getExperienceInfoRsp2 = new GetExperienceInfoRsp();
                getExperienceInfoRspArr2[length] = getExperienceInfoRsp2;
                codedInputByteBufferNano.readMessage(getExperienceInfoRsp2);
                this.exps = getExperienceInfoRspArr2;
            }
        }
    }
}
