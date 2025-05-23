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
public final class ReportItem extends ExtendableMessageNano<ReportItem> {
    private static volatile ReportItem[] _emptyArray;
    public String action;
    public long actionOrder;
    public long actionTime;
    public long cycle;
    public long dayCycle;
    public ReportValue[] listReportValue;
    public String module;
    public String opername;
    public String roomid;
    public String tid;

    public ReportItem() {
        clear();
    }

    public static ReportItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportItem) MessageNano.mergeFrom(new ReportItem(), bArr);
    }

    public ReportItem clear() {
        this.tid = "";
        this.opername = "";
        this.module = "";
        this.action = "";
        this.actionTime = 0L;
        this.actionOrder = 0L;
        this.cycle = 0L;
        this.dayCycle = 0L;
        this.roomid = "";
        this.listReportValue = ReportValue.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeStringSize(1, this.tid);
        if (!this.opername.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.opername);
        }
        if (!this.module.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.module);
        }
        int computeStringSize = computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.action);
        long j3 = this.actionTime;
        if (j3 != 0) {
            computeStringSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        long j16 = this.actionOrder;
        if (j16 != 0) {
            computeStringSize += CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        long j17 = this.cycle;
        if (j17 != 0) {
            computeStringSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        long j18 = this.dayCycle;
        if (j18 != 0) {
            computeStringSize += CodedOutputByteBufferNano.computeUInt64Size(8, j18);
        }
        if (!this.roomid.equals("")) {
            computeStringSize += CodedOutputByteBufferNano.computeStringSize(9, this.roomid);
        }
        ReportValue[] reportValueArr = this.listReportValue;
        if (reportValueArr != null && reportValueArr.length > 0) {
            int i3 = 0;
            while (true) {
                ReportValue[] reportValueArr2 = this.listReportValue;
                if (i3 >= reportValueArr2.length) {
                    break;
                }
                ReportValue reportValue = reportValueArr2[i3];
                if (reportValue != null) {
                    computeStringSize += CodedOutputByteBufferNano.computeMessageSize(10, reportValue);
                }
                i3++;
            }
        }
        return computeStringSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.tid);
        if (!this.opername.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.opername);
        }
        if (!this.module.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.module);
        }
        codedOutputByteBufferNano.writeString(4, this.action);
        long j3 = this.actionTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        long j16 = this.actionOrder;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        long j17 = this.cycle;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        long j18 = this.dayCycle;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j18);
        }
        if (!this.roomid.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.roomid);
        }
        ReportValue[] reportValueArr = this.listReportValue;
        if (reportValueArr != null && reportValueArr.length > 0) {
            int i3 = 0;
            while (true) {
                ReportValue[] reportValueArr2 = this.listReportValue;
                if (i3 >= reportValueArr2.length) {
                    break;
                }
                ReportValue reportValue = reportValueArr2[i3];
                if (reportValue != null) {
                    codedOutputByteBufferNano.writeMessage(10, reportValue);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.tid = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.opername = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.module = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.action = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.actionTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.actionOrder = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    this.cycle = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.dayCycle = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    this.roomid = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    ReportValue[] reportValueArr = this.listReportValue;
                    int length = reportValueArr == null ? 0 : reportValueArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ReportValue[] reportValueArr2 = new ReportValue[i3];
                    if (length != 0) {
                        System.arraycopy(reportValueArr, 0, reportValueArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ReportValue reportValue = new ReportValue();
                        reportValueArr2[length] = reportValue;
                        codedInputByteBufferNano.readMessage(reportValue);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ReportValue reportValue2 = new ReportValue();
                    reportValueArr2[length] = reportValue2;
                    codedInputByteBufferNano.readMessage(reportValue2);
                    this.listReportValue = reportValueArr2;
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
