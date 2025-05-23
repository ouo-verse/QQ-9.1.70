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
public final class ReportConfigRsp extends ExtendableMessageNano<ReportConfigRsp> {
    private static volatile ReportConfigRsp[] _emptyArray;
    public ReportConfigItem[] configItems;
    public RetInfo retinfo;

    public ReportConfigRsp() {
        clear();
    }

    public static ReportConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportConfigRsp) MessageNano.mergeFrom(new ReportConfigRsp(), bArr);
    }

    public ReportConfigRsp clear() {
        this.retinfo = null;
        this.configItems = ReportConfigItem.emptyArray();
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
        ReportConfigItem[] reportConfigItemArr = this.configItems;
        if (reportConfigItemArr != null && reportConfigItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                ReportConfigItem[] reportConfigItemArr2 = this.configItems;
                if (i3 >= reportConfigItemArr2.length) {
                    break;
                }
                ReportConfigItem reportConfigItem = reportConfigItemArr2[i3];
                if (reportConfigItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, reportConfigItem);
                }
                i3++;
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
        ReportConfigItem[] reportConfigItemArr = this.configItems;
        if (reportConfigItemArr != null && reportConfigItemArr.length > 0) {
            int i3 = 0;
            while (true) {
                ReportConfigItem[] reportConfigItemArr2 = this.configItems;
                if (i3 >= reportConfigItemArr2.length) {
                    break;
                }
                ReportConfigItem reportConfigItem = reportConfigItemArr2[i3];
                if (reportConfigItem != null) {
                    codedOutputByteBufferNano.writeMessage(2, reportConfigItem);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ReportConfigItem[] reportConfigItemArr = this.configItems;
                int length = reportConfigItemArr == null ? 0 : reportConfigItemArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ReportConfigItem[] reportConfigItemArr2 = new ReportConfigItem[i3];
                if (length != 0) {
                    System.arraycopy(reportConfigItemArr, 0, reportConfigItemArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ReportConfigItem reportConfigItem = new ReportConfigItem();
                    reportConfigItemArr2[length] = reportConfigItem;
                    codedInputByteBufferNano.readMessage(reportConfigItem);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ReportConfigItem reportConfigItem2 = new ReportConfigItem();
                reportConfigItemArr2[length] = reportConfigItem2;
                codedInputByteBufferNano.readMessage(reportConfigItem2);
                this.configItems = reportConfigItemArr2;
            }
        }
    }
}
