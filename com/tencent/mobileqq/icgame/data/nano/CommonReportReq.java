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
public final class CommonReportReq extends ExtendableMessageNano<CommonReportReq> {
    private static volatile CommonReportReq[] _emptyArray;
    public long channelId;
    public String fromId;
    public ReportItem[] listReportItem;
    public String macVersion;
    public String macpara;
    public int network;
    public long odid;
    public String openid;
    public int platform;
    public long qqUin;
    public String qqVersion;
    public String screen;
    public String sdkVersion;
    public String shellVersion;
    public String str1;
    public String str2;
    public String sysVersion;
    public int type;
    public String uuid;

    public CommonReportReq() {
        clear();
    }

    public static CommonReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonReportReq) MessageNano.mergeFrom(new CommonReportReq(), bArr);
    }

    public CommonReportReq clear() {
        this.odid = 0L;
        this.qqUin = 0L;
        this.openid = "";
        this.shellVersion = "";
        this.type = 999;
        this.platform = 0;
        this.sdkVersion = "";
        this.qqVersion = "";
        this.channelId = 0L;
        this.sysVersion = "";
        this.macVersion = "";
        this.macpara = "";
        this.uuid = "";
        this.screen = "";
        this.network = 0;
        this.fromId = "";
        this.listReportItem = ReportItem.emptyArray();
        this.str1 = "";
        this.str2 = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.odid);
        long j3 = this.qqUin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.openid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.openid);
        }
        if (!this.shellVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.shellVersion);
        }
        int i3 = this.type;
        if (i3 != 999) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.platform;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        if (!this.sdkVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.sdkVersion);
        }
        if (!this.qqVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.qqVersion);
        }
        long j16 = this.channelId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j16);
        }
        if (!this.sysVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.sysVersion);
        }
        if (!this.macVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.macVersion);
        }
        if (!this.macpara.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.macpara);
        }
        if (!this.uuid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.uuid);
        }
        if (!this.screen.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.screen);
        }
        int i17 = this.network;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i17);
        }
        if (!this.fromId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.fromId);
        }
        ReportItem[] reportItemArr = this.listReportItem;
        if (reportItemArr != null && reportItemArr.length > 0) {
            int i18 = 0;
            while (true) {
                ReportItem[] reportItemArr2 = this.listReportItem;
                if (i18 >= reportItemArr2.length) {
                    break;
                }
                ReportItem reportItem = reportItemArr2[i18];
                if (reportItem != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, reportItem);
                }
                i18++;
            }
        }
        if (!this.str1.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.str1);
        }
        if (!this.str2.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(19, this.str2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.odid);
        long j3 = this.qqUin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.openid.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.openid);
        }
        if (!this.shellVersion.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.shellVersion);
        }
        int i3 = this.type;
        if (i3 != 999) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.platform;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        if (!this.sdkVersion.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.sdkVersion);
        }
        if (!this.qqVersion.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.qqVersion);
        }
        long j16 = this.channelId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j16);
        }
        if (!this.sysVersion.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.sysVersion);
        }
        if (!this.macVersion.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.macVersion);
        }
        if (!this.macpara.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.macpara);
        }
        if (!this.uuid.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.uuid);
        }
        if (!this.screen.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.screen);
        }
        int i17 = this.network;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i17);
        }
        if (!this.fromId.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.fromId);
        }
        ReportItem[] reportItemArr = this.listReportItem;
        if (reportItemArr != null && reportItemArr.length > 0) {
            int i18 = 0;
            while (true) {
                ReportItem[] reportItemArr2 = this.listReportItem;
                if (i18 >= reportItemArr2.length) {
                    break;
                }
                ReportItem reportItem = reportItemArr2[i18];
                if (reportItem != null) {
                    codedOutputByteBufferNano.writeMessage(17, reportItem);
                }
                i18++;
            }
        }
        if (!this.str1.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.str1);
        }
        if (!this.str2.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.str2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.odid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.qqUin = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.openid = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.shellVersion = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.platform = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.sdkVersion = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.qqVersion = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.channelId = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    this.sysVersion = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.macVersion = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.macpara = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.uuid = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.screen = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.network = codedInputByteBufferNano.readUInt32();
                    break;
                case 130:
                    this.fromId = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    ReportItem[] reportItemArr = this.listReportItem;
                    int length = reportItemArr == null ? 0 : reportItemArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    ReportItem[] reportItemArr2 = new ReportItem[i3];
                    if (length != 0) {
                        System.arraycopy(reportItemArr, 0, reportItemArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        ReportItem reportItem = new ReportItem();
                        reportItemArr2[length] = reportItem;
                        codedInputByteBufferNano.readMessage(reportItem);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    ReportItem reportItem2 = new ReportItem();
                    reportItemArr2[length] = reportItem2;
                    codedInputByteBufferNano.readMessage(reportItem2);
                    this.listReportItem = reportItemArr2;
                    break;
                case 146:
                    this.str1 = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.str2 = codedInputByteBufferNano.readString();
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
