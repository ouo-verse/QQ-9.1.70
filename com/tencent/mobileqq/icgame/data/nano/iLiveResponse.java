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
public final class iLiveResponse extends ExtendableMessageNano<iLiveResponse> {
    private static volatile iLiveResponse[] _emptyArray;
    public byte[] binaryBody;
    public int clientType;
    public int cmd;
    public int errCode;
    public String errMsg;

    /* renamed from: ex, reason: collision with root package name */
    public byte[] f237297ex;
    public int flag;
    public long seq;
    public int subcmd;
    public long uid;
    public int version;

    public iLiveResponse() {
        clear();
    }

    public static iLiveResponse[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new iLiveResponse[0];
                }
            }
        }
        return _emptyArray;
    }

    public static iLiveResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (iLiveResponse) MessageNano.mergeFrom(new iLiveResponse(), bArr);
    }

    public iLiveResponse clear() {
        this.version = 0;
        this.cmd = 0;
        this.subcmd = 0;
        this.seq = 0L;
        this.uid = 0L;
        this.errCode = 0;
        this.errMsg = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.binaryBody = bArr;
        this.f237297ex = bArr;
        this.clientType = 0;
        this.flag = 0;
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
        int i18 = this.errCode;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        if (!this.errMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.errMsg);
        }
        byte[] bArr = this.binaryBody;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(8, this.binaryBody);
        }
        if (!Arrays.equals(this.f237297ex, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.f237297ex);
        }
        int i19 = this.clientType;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        int i26 = this.flag;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i26);
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
        int i18 = this.errCode;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.errMsg);
        }
        byte[] bArr = this.binaryBody;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(8, this.binaryBody);
        }
        if (!Arrays.equals(this.f237297ex, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.f237297ex);
        }
        int i19 = this.clientType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        int i26 = this.flag;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static iLiveResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new iLiveResponse().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public iLiveResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                case 48:
                    this.errCode = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.errMsg = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.binaryBody = codedInputByteBufferNano.readBytes();
                    break;
                case 74:
                    this.f237297ex = codedInputByteBufferNano.readBytes();
                    break;
                case 80:
                    this.clientType = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.flag = codedInputByteBufferNano.readUInt32();
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
