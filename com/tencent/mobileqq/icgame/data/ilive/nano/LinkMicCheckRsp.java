package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicCheckRsp extends ExtendableMessageNano<LinkMicCheckRsp> {
    private static volatile LinkMicCheckRsp[] _emptyArray;
    public CheckResult[] result;

    public LinkMicCheckRsp() {
        clear();
    }

    public static LinkMicCheckRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicCheckRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicCheckRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicCheckRsp) MessageNano.mergeFrom(new LinkMicCheckRsp(), bArr);
    }

    public LinkMicCheckRsp clear() {
        this.result = CheckResult.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        CheckResult[] checkResultArr = this.result;
        if (checkResultArr != null && checkResultArr.length > 0) {
            int i3 = 0;
            while (true) {
                CheckResult[] checkResultArr2 = this.result;
                if (i3 >= checkResultArr2.length) {
                    break;
                }
                CheckResult checkResult = checkResultArr2[i3];
                if (checkResult != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, checkResult);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        CheckResult[] checkResultArr = this.result;
        if (checkResultArr != null && checkResultArr.length > 0) {
            int i3 = 0;
            while (true) {
                CheckResult[] checkResultArr2 = this.result;
                if (i3 >= checkResultArr2.length) {
                    break;
                }
                CheckResult checkResult = checkResultArr2[i3];
                if (checkResult != null) {
                    codedOutputByteBufferNano.writeMessage(3, checkResult);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicCheckRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicCheckRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicCheckRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                CheckResult[] checkResultArr = this.result;
                int length = checkResultArr == null ? 0 : checkResultArr.length;
                int i3 = repeatedFieldArrayLength + length;
                CheckResult[] checkResultArr2 = new CheckResult[i3];
                if (length != 0) {
                    System.arraycopy(checkResultArr, 0, checkResultArr2, 0, length);
                }
                while (length < i3 - 1) {
                    CheckResult checkResult = new CheckResult();
                    checkResultArr2[length] = checkResult;
                    codedInputByteBufferNano.readMessage(checkResult);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                CheckResult checkResult2 = new CheckResult();
                checkResultArr2[length] = checkResult2;
                codedInputByteBufferNano.readMessage(checkResult2);
                this.result = checkResultArr2;
            }
        }
    }
}
