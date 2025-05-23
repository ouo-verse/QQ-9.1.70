package com.tencent.mobileqq.icgame.data.login.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UserInfo extends ExtendableMessageNano<UserInfo> {
    private static volatile UserInfo[] _emptyArray;
    public int adolescentMode;
    public long alreadyLoginNearby;
    public long explicitUid;
    public long fanQun;
    public int idVerifyTs;
    public long imsdkTinyid;
    public long isVerifyPhone;
    public String logoFullUrl;
    public String nick;
    public long payId;
    public String residentCity;
    public int sex;
    public String signature;
    public int sysBeatReason;
    public long tenpayVerifyTs;
    public long uid;
    public int userType;
    public String wechatPub;

    public UserInfo() {
        clear();
    }

    public static UserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserInfo) MessageNano.mergeFrom(new UserInfo(), bArr);
    }

    public UserInfo clear() {
        this.uid = 0L;
        this.explicitUid = 0L;
        this.nick = "";
        this.sex = 0;
        this.signature = "";
        this.logoFullUrl = "";
        this.fanQun = 0L;
        this.residentCity = "";
        this.userType = 0;
        this.payId = 0L;
        this.imsdkTinyid = 0L;
        this.sysBeatReason = 0;
        this.isVerifyPhone = 0L;
        this.alreadyLoginNearby = 0L;
        this.wechatPub = "";
        this.tenpayVerifyTs = 0L;
        this.idVerifyTs = 0;
        this.adolescentMode = 0;
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
        long j16 = this.explicitUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.nick);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.signature.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.signature);
        }
        if (!this.logoFullUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.logoFullUrl);
        }
        long j17 = this.fanQun;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j17);
        }
        if (!this.residentCity.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.residentCity);
        }
        int i16 = this.userType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i16);
        }
        long j18 = this.payId;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j18);
        }
        long j19 = this.imsdkTinyid;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j19);
        }
        int i17 = this.sysBeatReason;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i17);
        }
        long j26 = this.isVerifyPhone;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j26);
        }
        long j27 = this.alreadyLoginNearby;
        if (j27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j27);
        }
        if (!this.wechatPub.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.wechatPub);
        }
        long j28 = this.tenpayVerifyTs;
        if (j28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j28);
        }
        int i18 = this.idVerifyTs;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i18);
        }
        int i19 = this.adolescentMode;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(18, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.explicitUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.nick);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.signature.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.signature);
        }
        if (!this.logoFullUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.logoFullUrl);
        }
        long j17 = this.fanQun;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j17);
        }
        if (!this.residentCity.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.residentCity);
        }
        int i16 = this.userType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i16);
        }
        long j18 = this.payId;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j18);
        }
        long j19 = this.imsdkTinyid;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j19);
        }
        int i17 = this.sysBeatReason;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i17);
        }
        long j26 = this.isVerifyPhone;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j26);
        }
        long j27 = this.alreadyLoginNearby;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j27);
        }
        if (!this.wechatPub.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.wechatPub);
        }
        long j28 = this.tenpayVerifyTs;
        if (j28 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j28);
        }
        int i18 = this.idVerifyTs;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i18);
        }
        int i19 = this.adolescentMode;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.explicitUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.nick = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.sex = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.signature = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.logoFullUrl = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.fanQun = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.residentCity = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1) {
                        break;
                    } else {
                        this.userType = readInt32;
                        break;
                    }
                case 80:
                    this.payId = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.imsdkTinyid = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.sysBeatReason = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.isVerifyPhone = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.alreadyLoginNearby = codedInputByteBufferNano.readUInt64();
                    break;
                case 122:
                    this.wechatPub = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.tenpayVerifyTs = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.idVerifyTs = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.adolescentMode = codedInputByteBufferNano.readUInt32();
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
