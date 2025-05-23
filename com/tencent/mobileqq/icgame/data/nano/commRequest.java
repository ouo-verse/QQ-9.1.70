package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class commRequest extends ExtendableMessageNano<commRequest> {
    private static volatile commRequest[] _emptyArray;
    public String appName;
    public long authAppid;
    public String authIp;
    public byte[] authKey;
    public int authType;
    public byte[] body;
    public String business;
    public String clientIp;
    public String clientRelease;
    public int clientType;
    public int cmd;
    public String fromId;
    public long microtime;
    public int network;
    public String openid;
    public long seq;
    public String serviceIp;
    public long uid;
    public long uin;
    public String userSig;
    public int version;

    public commRequest() {
        clear();
    }

    public static commRequest[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new commRequest[0];
                }
            }
        }
        return _emptyArray;
    }

    public static commRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (commRequest) MessageNano.mergeFrom(new commRequest(), bArr);
    }

    public commRequest clear() {
        this.version = 1;
        this.appName = "";
        this.cmd = 0;
        this.seq = 0L;
        this.clientIp = "";
        this.serviceIp = "";
        this.business = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.authKey = bArr;
        this.authType = 0;
        this.authIp = "";
        this.authAppid = 0L;
        this.uid = 0L;
        this.uin = 0L;
        this.openid = "";
        this.body = bArr;
        this.microtime = 0L;
        this.clientType = 0;
        this.clientRelease = "";
        this.userSig = "";
        this.network = 0;
        this.fromId = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.version;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.appName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.appName);
        }
        int i16 = this.cmd;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        long j3 = this.seq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.clientIp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.clientIp);
        }
        if (!this.serviceIp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.serviceIp);
        }
        if (!this.business.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.business);
        }
        byte[] bArr = this.authKey;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.authKey);
        }
        int i17 = this.authType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i17);
        }
        if (!this.authIp.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.authIp);
        }
        long j16 = this.authAppid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j17);
        }
        long j18 = this.uin;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j18);
        }
        if (!this.openid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.openid);
        }
        if (!Arrays.equals(this.body, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(15, this.body);
        }
        long j19 = this.microtime;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j19);
        }
        int i18 = this.clientType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i18);
        }
        if (!this.clientRelease.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.clientRelease);
        }
        if (!this.userSig.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.userSig);
        }
        int i19 = this.network;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(20, i19);
        }
        if (!this.fromId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(21, this.fromId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.version;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.appName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.appName);
        }
        int i16 = this.cmd;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        long j3 = this.seq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.clientIp.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.clientIp);
        }
        if (!this.serviceIp.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.serviceIp);
        }
        if (!this.business.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.business);
        }
        byte[] bArr = this.authKey;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.authKey);
        }
        int i17 = this.authType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i17);
        }
        if (!this.authIp.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.authIp);
        }
        long j16 = this.authAppid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j17);
        }
        long j18 = this.uin;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j18);
        }
        if (!this.openid.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.openid);
        }
        if (!Arrays.equals(this.body, bArr2)) {
            codedOutputByteBufferNano.writeBytes(15, this.body);
        }
        long j19 = this.microtime;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j19);
        }
        int i18 = this.clientType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i18);
        }
        if (!this.clientRelease.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.clientRelease);
        }
        if (!this.userSig.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.userSig);
        }
        int i19 = this.network;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(20, i19);
        }
        if (!this.fromId.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.fromId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static commRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new commRequest().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public commRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.version = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.appName = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.cmd = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.seq = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.clientIp = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.serviceIp = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.business = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.authKey = codedInputByteBufferNano.readBytes();
                    break;
                case 72:
                    this.authType = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.authIp = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.authAppid = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 114:
                    this.openid = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.body = codedInputByteBufferNano.readBytes();
                    break;
                case 128:
                    this.microtime = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.clientType = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    this.clientRelease = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.userSig = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.network = codedInputByteBufferNano.readUInt32();
                    break;
                case 170:
                    this.fromId = codedInputByteBufferNano.readString();
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
