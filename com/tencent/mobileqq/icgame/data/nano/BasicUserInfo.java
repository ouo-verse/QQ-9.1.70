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
public final class BasicUserInfo extends ExtendableMessageNano<BasicUserInfo> {
    private static volatile BasicUserInfo[] _emptyArray;
    public int age;
    public String avatar;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public String city;
    public String country;
    public int gender;
    public int hasSecondIdentity;
    public int infoType;
    public String name;
    public String province;
    public String signature;
    public long uid;
    public long uin;

    public BasicUserInfo() {
        clear();
    }

    public static BasicUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BasicUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BasicUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BasicUserInfo) MessageNano.mergeFrom(new BasicUserInfo(), bArr);
    }

    public BasicUserInfo clear() {
        this.uid = 0L;
        this.uin = 0L;
        this.name = "";
        this.gender = 0;
        this.avatar = "";
        this.birthdayYear = 0;
        this.birthdayMonth = 0;
        this.birthdayDay = 0;
        this.age = 999;
        this.country = "";
        this.province = "";
        this.city = "";
        this.signature = "";
        this.infoType = 0;
        this.hasSecondIdentity = 0;
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
        long j16 = this.uin;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.avatar);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.age;
        if (i19 != 999) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        if (!this.country.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.country);
        }
        if (!this.province.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.province);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.city);
        }
        if (!this.signature.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.signature);
        }
        int i26 = this.infoType;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i26);
        }
        int i27 = this.hasSecondIdentity;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(15, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.uin;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.avatar);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.age;
        if (i19 != 999) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        if (!this.country.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.country);
        }
        if (!this.province.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.province);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.city);
        }
        if (!this.signature.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.signature);
        }
        int i26 = this.infoType;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i26);
        }
        int i27 = this.hasSecondIdentity;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BasicUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BasicUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BasicUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uid = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2) {
                        break;
                    } else {
                        this.gender = readInt32;
                        break;
                    }
                case 42:
                    this.avatar = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.birthdayYear = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.birthdayMonth = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.birthdayDay = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.age = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.country = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.province = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.city = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.signature = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.infoType = codedInputByteBufferNano.readUInt32();
                    break;
                case 120:
                    this.hasSecondIdentity = codedInputByteBufferNano.readUInt32();
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
