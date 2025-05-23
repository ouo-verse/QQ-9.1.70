package com.tencent.mobileqq.channel.report;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ReportReq extends ExtendableMessageNano<ReportReq> {
    private static volatile ReportReq[] _emptyArray;
    public String attaId;
    public SingleData[] singleDatas;

    public ReportReq() {
        clear();
    }

    public static ReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportReq) MessageNano.mergeFrom(new ReportReq(), bArr);
    }

    public ReportReq clear() {
        this.attaId = "";
        this.singleDatas = SingleData.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.attaId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.attaId);
        }
        SingleData[] singleDataArr = this.singleDatas;
        if (singleDataArr != null && singleDataArr.length > 0) {
            int i3 = 0;
            while (true) {
                SingleData[] singleDataArr2 = this.singleDatas;
                if (i3 >= singleDataArr2.length) {
                    break;
                }
                SingleData singleData = singleDataArr2[i3];
                if (singleData != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, singleData);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.attaId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.attaId);
        }
        SingleData[] singleDataArr = this.singleDatas;
        if (singleDataArr != null && singleDataArr.length > 0) {
            int i3 = 0;
            while (true) {
                SingleData[] singleDataArr2 = this.singleDatas;
                if (i3 >= singleDataArr2.length) {
                    break;
                }
                SingleData singleData = singleDataArr2[i3];
                if (singleData != null) {
                    codedOutputByteBufferNano.writeMessage(2, singleData);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.attaId = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SingleData[] singleDataArr = this.singleDatas;
                int length = singleDataArr == null ? 0 : singleDataArr.length;
                int i3 = repeatedFieldArrayLength + length;
                SingleData[] singleDataArr2 = new SingleData[i3];
                if (length != 0) {
                    System.arraycopy(singleDataArr, 0, singleDataArr2, 0, length);
                }
                while (length < i3 - 1) {
                    SingleData singleData = new SingleData();
                    singleDataArr2[length] = singleData;
                    codedInputByteBufferNano.readMessage(singleData);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                SingleData singleData2 = new SingleData();
                singleDataArr2[length] = singleData2;
                codedInputByteBufferNano.readMessage(singleData2);
                this.singleDatas = singleDataArr2;
            }
        }
    }
}
