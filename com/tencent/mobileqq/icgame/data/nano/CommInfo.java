package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CommInfo extends ExtendableMessageNano<CommInfo> {
    private static volatile CommInfo[] _emptyArray;
    public int iBid;
    public int iNetWorkEnv;
    public Gps stGps;
    public String strApp;
    public String strCityCode;
    public String strDeviceInfo;
    public String strExpSeq;
    public String strOs;
    public String strQimei;
    public String strQua;
    public String strUserIp;
    public String strVersion;

    public CommInfo() {
        clear();
    }

    public static CommInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommInfo) MessageNano.mergeFrom(new CommInfo(), bArr);
    }

    public CommInfo clear() {
        this.strDeviceInfo = "";
        this.stGps = null;
        this.iBid = 0;
        this.strUserIp = "";
        this.strApp = "";
        this.strOs = "";
        this.strVersion = "";
        this.strCityCode = "";
        this.iNetWorkEnv = 0;
        this.strQua = "";
        this.strQimei = "";
        this.strExpSeq = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.strDeviceInfo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.strDeviceInfo);
        }
        Gps gps = this.stGps;
        if (gps != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, gps);
        }
        int i3 = this.iBid;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        if (!this.strUserIp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.strUserIp);
        }
        if (!this.strApp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.strApp);
        }
        if (!this.strOs.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.strOs);
        }
        if (!this.strVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.strVersion);
        }
        if (!this.strCityCode.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.strCityCode);
        }
        int i16 = this.iNetWorkEnv;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i16);
        }
        if (!this.strQua.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.strQua);
        }
        if (!this.strQimei.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.strQimei);
        }
        if (!this.strExpSeq.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(20, this.strExpSeq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.strDeviceInfo.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.strDeviceInfo);
        }
        Gps gps = this.stGps;
        if (gps != null) {
            codedOutputByteBufferNano.writeMessage(4, gps);
        }
        int i3 = this.iBid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        if (!this.strUserIp.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.strUserIp);
        }
        if (!this.strApp.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.strApp);
        }
        if (!this.strOs.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.strOs);
        }
        if (!this.strVersion.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.strVersion);
        }
        if (!this.strCityCode.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.strCityCode);
        }
        int i16 = this.iNetWorkEnv;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i16);
        }
        if (!this.strQua.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.strQua);
        }
        if (!this.strQimei.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.strQimei);
        }
        if (!this.strExpSeq.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.strExpSeq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 26:
                    this.strDeviceInfo = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.stGps == null) {
                        this.stGps = new Gps();
                    }
                    codedInputByteBufferNano.readMessage(this.stGps);
                    break;
                case 40:
                    this.iBid = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.strUserIp = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.strApp = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.strOs = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.strVersion = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.strCityCode = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.iNetWorkEnv = codedInputByteBufferNano.readInt32();
                    break;
                case 106:
                    this.strQua = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.strQimei = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.strExpSeq = codedInputByteBufferNano.readString();
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
