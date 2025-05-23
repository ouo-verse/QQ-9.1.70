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
public final class ReportInfoGetRsp extends ExtendableMessageNano<ReportInfoGetRsp> {
    private static volatile ReportInfoGetRsp[] _emptyArray;
    public int endFlag;
    public ReportUserInfo[] reportInfo;
    public int retCode;
    public String retMsg;

    public ReportInfoGetRsp() {
        clear();
    }

    public static ReportInfoGetRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportInfoGetRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportInfoGetRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportInfoGetRsp) MessageNano.mergeFrom(new ReportInfoGetRsp(), bArr);
    }

    public ReportInfoGetRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.reportInfo = ReportUserInfo.emptyArray();
        this.endFlag = 0;
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
        ReportUserInfo[] reportUserInfoArr = this.reportInfo;
        if (reportUserInfoArr != null && reportUserInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ReportUserInfo[] reportUserInfoArr2 = this.reportInfo;
                if (i16 >= reportUserInfoArr2.length) {
                    break;
                }
                ReportUserInfo reportUserInfo = reportUserInfoArr2[i16];
                if (reportUserInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, reportUserInfo);
                }
                i16++;
            }
        }
        int i17 = this.endFlag;
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
        ReportUserInfo[] reportUserInfoArr = this.reportInfo;
        if (reportUserInfoArr != null && reportUserInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ReportUserInfo[] reportUserInfoArr2 = this.reportInfo;
                if (i16 >= reportUserInfoArr2.length) {
                    break;
                }
                ReportUserInfo reportUserInfo = reportUserInfoArr2[i16];
                if (reportUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, reportUserInfo);
                }
                i16++;
            }
        }
        int i17 = this.endFlag;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportInfoGetRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportInfoGetRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportInfoGetRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                ReportUserInfo[] reportUserInfoArr = this.reportInfo;
                int length = reportUserInfoArr == null ? 0 : reportUserInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ReportUserInfo[] reportUserInfoArr2 = new ReportUserInfo[i3];
                if (length != 0) {
                    System.arraycopy(reportUserInfoArr, 0, reportUserInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ReportUserInfo reportUserInfo = new ReportUserInfo();
                    reportUserInfoArr2[length] = reportUserInfo;
                    codedInputByteBufferNano.readMessage(reportUserInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ReportUserInfo reportUserInfo2 = new ReportUserInfo();
                reportUserInfoArr2[length] = reportUserInfo2;
                codedInputByteBufferNano.readMessage(reportUserInfo2);
                this.reportInfo = reportUserInfoArr2;
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.endFlag = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
