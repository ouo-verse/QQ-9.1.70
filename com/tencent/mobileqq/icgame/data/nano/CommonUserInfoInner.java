package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.uf.h;
import cooperation.qzone.api.QZoneContant;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CommonUserInfoInner extends ExtendableMessageNano<CommonUserInfoInner> {
    private static volatile CommonUserInfoInner[] _emptyArray;
    public int adoreCount;
    public int adoreTotalScore;
    public String avatar;
    public int beAdoredCount;
    public long beAttentionCount;
    public int beLikedCount;
    public int beLovedCount;
    public BehaviourToUserInfo behaviourToUserInfo;
    public String birthCity;
    public String birthCountry;
    public String birthProvince;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public int bloodType;
    public CarInfo carInfo;
    public int charm;
    public String city;
    public int cityZone;
    public String country;
    public String dosomething;
    public int flag;
    public int gender;
    public int giftAmount;
    public int hasCertification;
    public int height;
    public String hyLogoUrl;

    /* renamed from: id, reason: collision with root package name */
    public long f237275id;
    public boolean isLiked;
    public String name;
    public long newCharm;
    public long newPopularity;
    public int nobility;
    public int popularity;
    public String province;
    public long qiqiUid;
    public int qunCharm;
    public int qunPopularity;
    public long shortId;
    public String signature;
    public SpecialConfig specialConfig;
    public int specialType;
    public String trend;
    public long uin;
    public UserInfoExtra userInfoExtra;
    public int userLogTimeStamp;
    public byte[] userLogoUrl;
    public User_Privilege_Data userPrivilege;
    public String userTag;
    public UserVoiceCover userVoiceCover;
    public int weight;

    public CommonUserInfoInner() {
        clear();
    }

    public static CommonUserInfoInner[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommonUserInfoInner[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommonUserInfoInner parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommonUserInfoInner) MessageNano.mergeFrom(new CommonUserInfoInner(), bArr);
    }

    public CommonUserInfoInner clear() {
        this.f237275id = 0L;
        this.name = "";
        this.gender = 0;
        this.hyLogoUrl = "";
        this.userLogoUrl = WireFormatNano.EMPTY_BYTES;
        this.avatar = "";
        this.userTag = "";
        this.trend = "";
        this.dosomething = "";
        this.birthdayYear = 0;
        this.birthdayMonth = 0;
        this.birthdayDay = 0;
        this.country = "";
        this.province = "";
        this.city = "";
        this.cityZone = 0;
        this.height = 0;
        this.weight = 0;
        this.qiqiUid = 0L;
        this.bloodType = 0;
        this.birthCountry = "";
        this.birthProvince = "";
        this.birthCity = "";
        this.shortId = 0L;
        this.flag = 0;
        this.userLogTimeStamp = 0;
        this.nobility = 0;
        this.signature = "";
        this.uin = 0L;
        this.qunCharm = 0;
        this.qunPopularity = 0;
        this.hasCertification = 0;
        this.userVoiceCover = null;
        this.isLiked = false;
        this.charm = 0;
        this.popularity = 0;
        this.beLovedCount = 0;
        this.beLikedCount = 0;
        this.giftAmount = 0;
        this.beAttentionCount = 0L;
        this.adoreCount = 0;
        this.beAdoredCount = 0;
        this.adoreTotalScore = 0;
        this.newPopularity = 0L;
        this.newCharm = 0L;
        this.userInfoExtra = null;
        this.behaviourToUserInfo = null;
        this.specialType = 0;
        this.specialConfig = null;
        this.carInfo = null;
        this.userPrivilege = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f237275id;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.hyLogoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.hyLogoUrl);
        }
        if (!Arrays.equals(this.userLogoUrl, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(11, this.userLogoUrl);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.avatar);
        }
        if (!this.userTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.userTag);
        }
        if (!this.trend.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.trend);
        }
        if (!this.dosomething.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.dosomething);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i18);
        }
        if (!this.country.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.country);
        }
        if (!this.province.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.province);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.city);
        }
        int i19 = this.cityZone;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i19);
        }
        int i26 = this.height;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(23, i26);
        }
        int i27 = this.weight;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i27);
        }
        long j16 = this.qiqiUid;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(28, j16);
        }
        int i28 = this.bloodType;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(31, i28);
        }
        if (!this.birthCountry.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(32, this.birthCountry);
        }
        if (!this.birthProvince.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(33, this.birthProvince);
        }
        if (!this.birthCity.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(34, this.birthCity);
        }
        long j17 = this.shortId;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(39, j17);
        }
        int i29 = this.flag;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(40, i29);
        }
        int i36 = this.userLogTimeStamp;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(41, i36);
        }
        int i37 = this.nobility;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(42, i37);
        }
        if (!this.signature.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(43, this.signature);
        }
        long j18 = this.uin;
        if (j18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(101, j18);
        }
        int i38 = this.qunCharm;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(102, i38);
        }
        int i39 = this.qunPopularity;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(103, i39);
        }
        int i46 = this.hasCertification;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(104, i46);
        }
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(105, userVoiceCover);
        }
        boolean z16 = this.isLiked;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(201, z16);
        }
        int i47 = this.charm;
        if (i47 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(202, i47);
        }
        int i48 = this.popularity;
        if (i48 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(203, i48);
        }
        int i49 = this.beLovedCount;
        if (i49 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(204, i49);
        }
        int i56 = this.beLikedCount;
        if (i56 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(205, i56);
        }
        int i57 = this.giftAmount;
        if (i57 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(206, i57);
        }
        long j19 = this.beAttentionCount;
        if (j19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(207, j19);
        }
        int i58 = this.adoreCount;
        if (i58 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(208, i58);
        }
        int i59 = this.beAdoredCount;
        if (i59 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(209, i59);
        }
        int i65 = this.adoreTotalScore;
        if (i65 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(210, i65);
        }
        long j26 = this.newPopularity;
        if (j26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(211, j26);
        }
        long j27 = this.newCharm;
        if (j27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(212, j27);
        }
        UserInfoExtra userInfoExtra = this.userInfoExtra;
        if (userInfoExtra != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(301, userInfoExtra);
        }
        BehaviourToUserInfo behaviourToUserInfo = this.behaviourToUserInfo;
        if (behaviourToUserInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(302, behaviourToUserInfo);
        }
        int i66 = this.specialType;
        if (i66 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(401, i66);
        }
        SpecialConfig specialConfig = this.specialConfig;
        if (specialConfig != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(402, specialConfig);
        }
        CarInfo carInfo = this.carInfo;
        if (carInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(403, carInfo);
        }
        User_Privilege_Data user_Privilege_Data = this.userPrivilege;
        if (user_Privilege_Data != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(404, user_Privilege_Data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f237275id;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.hyLogoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.hyLogoUrl);
        }
        if (!Arrays.equals(this.userLogoUrl, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(11, this.userLogoUrl);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.avatar);
        }
        if (!this.userTag.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.userTag);
        }
        if (!this.trend.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.trend);
        }
        if (!this.dosomething.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.dosomething);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(18, i18);
        }
        if (!this.country.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.country);
        }
        if (!this.province.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.province);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.city);
        }
        int i19 = this.cityZone;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i19);
        }
        int i26 = this.height;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i26);
        }
        int i27 = this.weight;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i27);
        }
        long j16 = this.qiqiUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(28, j16);
        }
        int i28 = this.bloodType;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(31, i28);
        }
        if (!this.birthCountry.equals("")) {
            codedOutputByteBufferNano.writeString(32, this.birthCountry);
        }
        if (!this.birthProvince.equals("")) {
            codedOutputByteBufferNano.writeString(33, this.birthProvince);
        }
        if (!this.birthCity.equals("")) {
            codedOutputByteBufferNano.writeString(34, this.birthCity);
        }
        long j17 = this.shortId;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(39, j17);
        }
        int i29 = this.flag;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(40, i29);
        }
        int i36 = this.userLogTimeStamp;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(41, i36);
        }
        int i37 = this.nobility;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(42, i37);
        }
        if (!this.signature.equals("")) {
            codedOutputByteBufferNano.writeString(43, this.signature);
        }
        long j18 = this.uin;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(101, j18);
        }
        int i38 = this.qunCharm;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(102, i38);
        }
        int i39 = this.qunPopularity;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(103, i39);
        }
        int i46 = this.hasCertification;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(104, i46);
        }
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            codedOutputByteBufferNano.writeMessage(105, userVoiceCover);
        }
        boolean z16 = this.isLiked;
        if (z16) {
            codedOutputByteBufferNano.writeBool(201, z16);
        }
        int i47 = this.charm;
        if (i47 != 0) {
            codedOutputByteBufferNano.writeUInt32(202, i47);
        }
        int i48 = this.popularity;
        if (i48 != 0) {
            codedOutputByteBufferNano.writeUInt32(203, i48);
        }
        int i49 = this.beLovedCount;
        if (i49 != 0) {
            codedOutputByteBufferNano.writeUInt32(204, i49);
        }
        int i56 = this.beLikedCount;
        if (i56 != 0) {
            codedOutputByteBufferNano.writeUInt32(205, i56);
        }
        int i57 = this.giftAmount;
        if (i57 != 0) {
            codedOutputByteBufferNano.writeUInt32(206, i57);
        }
        long j19 = this.beAttentionCount;
        if (j19 != 0) {
            codedOutputByteBufferNano.writeUInt64(207, j19);
        }
        int i58 = this.adoreCount;
        if (i58 != 0) {
            codedOutputByteBufferNano.writeUInt32(208, i58);
        }
        int i59 = this.beAdoredCount;
        if (i59 != 0) {
            codedOutputByteBufferNano.writeUInt32(209, i59);
        }
        int i65 = this.adoreTotalScore;
        if (i65 != 0) {
            codedOutputByteBufferNano.writeUInt32(210, i65);
        }
        long j26 = this.newPopularity;
        if (j26 != 0) {
            codedOutputByteBufferNano.writeUInt64(211, j26);
        }
        long j27 = this.newCharm;
        if (j27 != 0) {
            codedOutputByteBufferNano.writeUInt64(212, j27);
        }
        UserInfoExtra userInfoExtra = this.userInfoExtra;
        if (userInfoExtra != null) {
            codedOutputByteBufferNano.writeMessage(301, userInfoExtra);
        }
        BehaviourToUserInfo behaviourToUserInfo = this.behaviourToUserInfo;
        if (behaviourToUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(302, behaviourToUserInfo);
        }
        int i66 = this.specialType;
        if (i66 != 0) {
            codedOutputByteBufferNano.writeUInt32(401, i66);
        }
        SpecialConfig specialConfig = this.specialConfig;
        if (specialConfig != null) {
            codedOutputByteBufferNano.writeMessage(402, specialConfig);
        }
        CarInfo carInfo = this.carInfo;
        if (carInfo != null) {
            codedOutputByteBufferNano.writeMessage(403, carInfo);
        }
        User_Privilege_Data user_Privilege_Data = this.userPrivilege;
        if (user_Privilege_Data != null) {
            codedOutputByteBufferNano.writeMessage(404, user_Privilege_Data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommonUserInfoInner parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommonUserInfoInner().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommonUserInfoInner mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f237275id = codedInputByteBufferNano.readUInt64();
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
                case 82:
                    this.hyLogoUrl = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.userLogoUrl = codedInputByteBufferNano.readBytes();
                    break;
                case 98:
                    this.avatar = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.userTag = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.trend = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.dosomething = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.birthdayYear = codedInputByteBufferNano.readUInt32();
                    break;
                case 136:
                    this.birthdayMonth = codedInputByteBufferNano.readUInt32();
                    break;
                case 144:
                    this.birthdayDay = codedInputByteBufferNano.readUInt32();
                    break;
                case 154:
                    this.country = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.province = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.city = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.cityZone = codedInputByteBufferNano.readUInt32();
                    break;
                case 184:
                    this.height = codedInputByteBufferNano.readUInt32();
                    break;
                case 192:
                    this.weight = codedInputByteBufferNano.readUInt32();
                    break;
                case 224:
                    this.qiqiUid = codedInputByteBufferNano.readInt64();
                    break;
                case 248:
                    this.bloodType = codedInputByteBufferNano.readUInt32();
                    break;
                case 258:
                    this.birthCountry = codedInputByteBufferNano.readString();
                    break;
                case 266:
                    this.birthProvince = codedInputByteBufferNano.readString();
                    break;
                case 274:
                    this.birthCity = codedInputByteBufferNano.readString();
                    break;
                case 312:
                    this.shortId = codedInputByteBufferNano.readUInt64();
                    break;
                case 320:
                    this.flag = codedInputByteBufferNano.readUInt32();
                    break;
                case AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE /* 328 */:
                    this.userLogTimeStamp = codedInputByteBufferNano.readUInt32();
                    break;
                case 336:
                    this.nobility = codedInputByteBufferNano.readUInt32();
                    break;
                case 346:
                    this.signature = codedInputByteBufferNano.readString();
                    break;
                case 808:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 816:
                    this.qunCharm = codedInputByteBufferNano.readUInt32();
                    break;
                case 824:
                    this.qunPopularity = codedInputByteBufferNano.readUInt32();
                    break;
                case 832:
                    this.hasCertification = codedInputByteBufferNano.readUInt32();
                    break;
                case h.CTRL_INDEX /* 842 */:
                    if (this.userVoiceCover == null) {
                        this.userVoiceCover = new UserVoiceCover();
                    }
                    codedInputByteBufferNano.readMessage(this.userVoiceCover);
                    break;
                case 1608:
                    this.isLiked = codedInputByteBufferNano.readBool();
                    break;
                case QZoneContant.QZ_START_FEED_DETAIL_REQ /* 1616 */:
                    this.charm = codedInputByteBufferNano.readUInt32();
                    break;
                case 1624:
                    this.popularity = codedInputByteBufferNano.readUInt32();
                    break;
                case 1632:
                    this.beLovedCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 1640:
                    this.beLikedCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 1648:
                    this.giftAmount = codedInputByteBufferNano.readUInt32();
                    break;
                case 1656:
                    this.beAttentionCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 1664:
                    this.adoreCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 1672:
                    this.beAdoredCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 1680:
                    this.adoreTotalScore = codedInputByteBufferNano.readUInt32();
                    break;
                case 1688:
                    this.newPopularity = codedInputByteBufferNano.readUInt64();
                    break;
                case 1696:
                    this.newCharm = codedInputByteBufferNano.readUInt64();
                    break;
                case 2410:
                    if (this.userInfoExtra == null) {
                        this.userInfoExtra = new UserInfoExtra();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfoExtra);
                    break;
                case 2418:
                    if (this.behaviourToUserInfo == null) {
                        this.behaviourToUserInfo = new BehaviourToUserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.behaviourToUserInfo);
                    break;
                case 3208:
                    this.specialType = codedInputByteBufferNano.readUInt32();
                    break;
                case 3218:
                    if (this.specialConfig == null) {
                        this.specialConfig = new SpecialConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.specialConfig);
                    break;
                case 3226:
                    if (this.carInfo == null) {
                        this.carInfo = new CarInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.carInfo);
                    break;
                case 3234:
                    if (this.userPrivilege == null) {
                        this.userPrivilege = new User_Privilege_Data();
                    }
                    codedInputByteBufferNano.readMessage(this.userPrivilege);
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
