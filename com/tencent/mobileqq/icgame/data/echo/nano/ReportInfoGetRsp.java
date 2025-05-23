package com.tencent.mobileqq.icgame.data.echo.nano;

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
    public ReportInfo[] reportInfoList;
    public RetInfo retinfo;
    public int totalCount;

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
        this.retinfo = null;
        this.totalCount = 0;
        this.reportInfoList = ReportInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RetInfo retInfo = this.retinfo;
        if (retInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, retInfo);
        }
        int i3 = this.totalCount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        ReportInfo[] reportInfoArr = this.reportInfoList;
        if (reportInfoArr != null && reportInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ReportInfo[] reportInfoArr2 = this.reportInfoList;
                if (i16 >= reportInfoArr2.length) {
                    break;
                }
                ReportInfo reportInfo = reportInfoArr2[i16];
                if (reportInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, reportInfo);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RetInfo retInfo = this.retinfo;
        if (retInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, retInfo);
        }
        int i3 = this.totalCount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        ReportInfo[] reportInfoArr = this.reportInfoList;
        if (reportInfoArr != null && reportInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                ReportInfo[] reportInfoArr2 = this.reportInfoList;
                if (i16 >= reportInfoArr2.length) {
                    break;
                }
                ReportInfo reportInfo = reportInfoArr2[i16];
                if (reportInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, reportInfo);
                }
                i16++;
            }
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
            if (readTag == 10) {
                if (this.retinfo == null) {
                    this.retinfo = new RetInfo();
                }
                codedInputByteBufferNano.readMessage(this.retinfo);
            } else if (readTag == 16) {
                this.totalCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                ReportInfo[] reportInfoArr = this.reportInfoList;
                int length = reportInfoArr == null ? 0 : reportInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ReportInfo[] reportInfoArr2 = new ReportInfo[i3];
                if (length != 0) {
                    System.arraycopy(reportInfoArr, 0, reportInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ReportInfo reportInfo = new ReportInfo();
                    reportInfoArr2[length] = reportInfo;
                    codedInputByteBufferNano.readMessage(reportInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ReportInfo reportInfo2 = new ReportInfo();
                reportInfoArr2[length] = reportInfo2;
                codedInputByteBufferNano.readMessage(reportInfo2);
                this.reportInfoList = reportInfoArr2;
            }
        }
    }
}
