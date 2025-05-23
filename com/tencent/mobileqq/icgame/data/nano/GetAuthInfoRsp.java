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
public final class GetAuthInfoRsp extends ExtendableMessageNano<GetAuthInfoRsp> {
    private static volatile GetAuthInfoRsp[] _emptyArray;
    public String idcard;
    public int idcardAuthStatus;
    public long idcardAuthTime;
    public String name;
    public String phone;
    public int phoneAuthStatus;
    public long phoneAuthTime;
    public String tenpayAccount;
    public int tenpayStatus;
    public long tenpayTime;
    public long uid;

    public GetAuthInfoRsp() {
        clear();
    }

    public static GetAuthInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetAuthInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetAuthInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetAuthInfoRsp) MessageNano.mergeFrom(new GetAuthInfoRsp(), bArr);
    }

    public GetAuthInfoRsp clear() {
        this.uid = 0L;
        this.name = "";
        this.idcard = "";
        this.idcardAuthStatus = 0;
        this.idcardAuthTime = 0L;
        this.phone = "";
        this.phoneAuthStatus = 0;
        this.phoneAuthTime = 0L;
        this.tenpayAccount = "";
        this.tenpayStatus = 0;
        this.tenpayTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        if (!this.idcard.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.idcard);
        }
        int i3 = this.idcardAuthStatus;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        long j16 = this.idcardAuthTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        if (!this.phone.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.phone);
        }
        int i16 = this.phoneAuthStatus;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        long j17 = this.phoneAuthTime;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j17);
        }
        if (!this.tenpayAccount.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.tenpayAccount);
        }
        int i17 = this.tenpayStatus;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        long j18 = this.tenpayTime;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        if (!this.idcard.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.idcard);
        }
        int i3 = this.idcardAuthStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        long j16 = this.idcardAuthTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        if (!this.phone.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.phone);
        }
        int i16 = this.phoneAuthStatus;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        long j17 = this.phoneAuthTime;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j17);
        }
        if (!this.tenpayAccount.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.tenpayAccount);
        }
        int i17 = this.tenpayStatus;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        long j18 = this.tenpayTime;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetAuthInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetAuthInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetAuthInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.idcard = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.idcardAuthStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.idcardAuthTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.phone = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.phoneAuthStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.phoneAuthTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    this.tenpayAccount = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.tenpayStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.tenpayTime = codedInputByteBufferNano.readUInt64();
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
