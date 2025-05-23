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
public final class GetOfManagerInfoListRsp extends ExtendableMessageNano<GetOfManagerInfoListRsp> {
    private static volatile GetOfManagerInfoListRsp[] _emptyArray;
    public ManagerInfo[] managerInfo;

    public GetOfManagerInfoListRsp() {
        clear();
    }

    public static GetOfManagerInfoListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetOfManagerInfoListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetOfManagerInfoListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetOfManagerInfoListRsp) MessageNano.mergeFrom(new GetOfManagerInfoListRsp(), bArr);
    }

    public GetOfManagerInfoListRsp clear() {
        this.managerInfo = ManagerInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        ManagerInfo[] managerInfoArr = this.managerInfo;
        if (managerInfoArr != null && managerInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ManagerInfo[] managerInfoArr2 = this.managerInfo;
                if (i3 >= managerInfoArr2.length) {
                    break;
                }
                ManagerInfo managerInfo = managerInfoArr2[i3];
                if (managerInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, managerInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        ManagerInfo[] managerInfoArr = this.managerInfo;
        if (managerInfoArr != null && managerInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                ManagerInfo[] managerInfoArr2 = this.managerInfo;
                if (i3 >= managerInfoArr2.length) {
                    break;
                }
                ManagerInfo managerInfo = managerInfoArr2[i3];
                if (managerInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, managerInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetOfManagerInfoListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetOfManagerInfoListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetOfManagerInfoListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                ManagerInfo[] managerInfoArr = this.managerInfo;
                int length = managerInfoArr == null ? 0 : managerInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ManagerInfo[] managerInfoArr2 = new ManagerInfo[i3];
                if (length != 0) {
                    System.arraycopy(managerInfoArr, 0, managerInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ManagerInfo managerInfo = new ManagerInfo();
                    managerInfoArr2[length] = managerInfo;
                    codedInputByteBufferNano.readMessage(managerInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ManagerInfo managerInfo2 = new ManagerInfo();
                managerInfoArr2[length] = managerInfo2;
                codedInputByteBufferNano.readMessage(managerInfo2);
                this.managerInfo = managerInfoArr2;
            }
        }
    }
}
