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
public final class iLiveRequest extends ExtendableMessageNano<iLiveRequest> {
    private static volatile iLiveRequest[] _emptyArray;
    public long authAppid;
    public int authIp;
    public byte[] authKey;
    public int authType;
    public byte[] binaryBody;
    public String business;
    public long bussId;
    public int clientIp;
    public int clientPort;
    public int clientType;
    public int cmd;
    public int codec;

    /* renamed from: ex, reason: collision with root package name */
    public byte[] f237296ex;
    public int flag;
    public long originalAuthAppid;
    public String originalId;
    public int originalIdType;
    public String originalKey;
    public int originalKeyType;
    public long seq;
    public int serviceIp;
    public int subcmd;
    public long tinyid;
    public long uid;
    public int version;

    public iLiveRequest() {
        clear();
    }

    public static iLiveRequest[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new iLiveRequest[0];
                }
            }
        }
        return _emptyArray;
    }

    public static iLiveRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (iLiveRequest) MessageNano.mergeFrom(new iLiveRequest(), bArr);
    }

    public iLiveRequest clear() {
        this.version = 0;
        this.cmd = 0;
        this.subcmd = 0;
        this.seq = 0L;
        this.uid = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.binaryBody = bArr;
        this.f237296ex = bArr;
        this.clientType = 0;
        this.clientIp = 0;
        this.serviceIp = 0;
        this.business = "";
        this.authKey = bArr;
        this.authType = 0;
        this.authIp = 0;
        this.authAppid = 0L;
        this.tinyid = 0L;
        this.clientPort = 0;
        this.flag = 0;
        this.originalId = "";
        this.originalKey = "";
        this.originalKeyType = 0;
        this.originalIdType = 0;
        this.originalAuthAppid = 0L;
        this.bussId = 0L;
        this.codec = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.version;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.cmd;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.subcmd;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        long j3 = this.seq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        byte[] bArr = this.binaryBody;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.binaryBody);
        }
        if (!Arrays.equals(this.f237296ex, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.f237296ex);
        }
        int i18 = this.clientType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.clientIp;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        int i26 = this.serviceIp;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i26);
        }
        if (!this.business.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.business);
        }
        if (!Arrays.equals(this.authKey, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(12, this.authKey);
        }
        int i27 = this.authType;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i27);
        }
        int i28 = this.authIp;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i28);
        }
        long j17 = this.authAppid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j17);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j18);
        }
        int i29 = this.clientPort;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i29);
        }
        int i36 = this.flag;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i36);
        }
        if (!this.originalId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.originalId);
        }
        if (!this.originalKey.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.originalKey);
        }
        int i37 = this.originalKeyType;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(21, i37);
        }
        int i38 = this.originalIdType;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i38);
        }
        long j19 = this.originalAuthAppid;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(23, j19);
        }
        long j26 = this.bussId;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(24, j26);
        }
        int i39 = this.codec;
        if (i39 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(25, i39);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.version;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.cmd;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.subcmd;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        long j3 = this.seq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        byte[] bArr = this.binaryBody;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.binaryBody);
        }
        if (!Arrays.equals(this.f237296ex, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.f237296ex);
        }
        int i18 = this.clientType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.clientIp;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        int i26 = this.serviceIp;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i26);
        }
        if (!this.business.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.business);
        }
        if (!Arrays.equals(this.authKey, bArr2)) {
            codedOutputByteBufferNano.writeBytes(12, this.authKey);
        }
        int i27 = this.authType;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i27);
        }
        int i28 = this.authIp;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i28);
        }
        long j17 = this.authAppid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j17);
        }
        long j18 = this.tinyid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j18);
        }
        int i29 = this.clientPort;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i29);
        }
        int i36 = this.flag;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i36);
        }
        if (!this.originalId.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.originalId);
        }
        if (!this.originalKey.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.originalKey);
        }
        int i37 = this.originalKeyType;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(21, i37);
        }
        int i38 = this.originalIdType;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i38);
        }
        long j19 = this.originalAuthAppid;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(23, j19);
        }
        long j26 = this.bussId;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(24, j26);
        }
        int i39 = this.codec;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i39);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static iLiveRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new iLiveRequest().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public iLiveRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.version = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.cmd = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.subcmd = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.seq = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.binaryBody = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.f237296ex = codedInputByteBufferNano.readBytes();
                    break;
                case 64:
                    this.clientType = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.clientIp = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.serviceIp = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    this.business = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.authKey = codedInputByteBufferNano.readBytes();
                    break;
                case 104:
                    this.authType = codedInputByteBufferNano.readUInt32();
                    break;
                case 112:
                    this.authIp = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.authAppid = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.tinyid = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.clientPort = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.flag = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.originalId = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.originalKey = codedInputByteBufferNano.readString();
                    break;
                case 168:
                    this.originalKeyType = codedInputByteBufferNano.readUInt32();
                    break;
                case 176:
                    this.originalIdType = codedInputByteBufferNano.readUInt32();
                    break;
                case 184:
                    this.originalAuthAppid = codedInputByteBufferNano.readUInt64();
                    break;
                case 192:
                    this.bussId = codedInputByteBufferNano.readUInt64();
                    break;
                case 200:
                    this.codec = codedInputByteBufferNano.readUInt32();
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
