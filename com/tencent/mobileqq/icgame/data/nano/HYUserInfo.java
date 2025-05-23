package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import cooperation.qzone.api.QZoneContant;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class HYUserInfo extends ExtendableMessageNano<HYUserInfo> {
    private static volatile HYUserInfo[] _emptyArray;
    public int adoreCount;
    public int adoreTotalScore;
    public String avatar;
    public int beAdoredCount;
    public int beAttentionCount;
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
    public int fansCount;
    public int flag;
    public int gender;
    public int giftAmount;
    public int height;
    public String hyLogoUrl;

    /* renamed from: id, reason: collision with root package name */
    public long f237281id;
    public boolean isLiked;
    public int logoTimestamp;
    public String name;
    public int nobility;
    public int popularity;
    public String province;
    public long qiqiUid;
    public long shortId;
    public int showQq;
    public String signature;
    public int specialType;
    public String trend;
    public long uint64Uin;
    public UserInfoExtra userInfoExtra;
    public int userLogTimeStamp;
    public byte[] userLogoUrl;
    public User_Privilege_Data userPrivilege;
    public String userTag;
    public int weight;

    public HYUserInfo() {
        clear();
    }

    public static HYUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HYUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static HYUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (HYUserInfo) MessageNano.mergeFrom(new HYUserInfo(), bArr);
    }

    public HYUserInfo clear() {
        this.f237281id = 0L;
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
        this.specialType = 0;
        this.uint64Uin = 0L;
        this.showQq = 0;
        this.signature = "";
        this.fansCount = 0;
        this.logoTimestamp = 0;
        this.carInfo = null;
        this.isLiked = false;
        this.charm = 0;
        this.popularity = 0;
        this.beLovedCount = 0;
        this.beLikedCount = 0;
        this.giftAmount = 0;
        this.beAttentionCount = 0;
        this.adoreCount = 0;
        this.beAdoredCount = 0;
        this.adoreTotalScore = 0;
        this.userInfoExtra = null;
        this.behaviourToUserInfo = null;
        this.userPrivilege = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.f237281id);
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
        long j3 = this.qiqiUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(28, j3);
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
        long j16 = this.shortId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(39, j16);
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
        int i38 = this.specialType;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(43, i38);
        }
        long j17 = this.uint64Uin;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(101, j17);
        }
        int i39 = this.showQq;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(102, i39);
        }
        if (!this.signature.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(103, this.signature);
        }
        int i46 = this.fansCount;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(104, i46);
        }
        int i47 = this.logoTimestamp;
        if (i47 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(105, i47);
        }
        CarInfo carInfo = this.carInfo;
        if (carInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(106, carInfo);
        }
        boolean z16 = this.isLiked;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(201, z16);
        }
        int i48 = this.charm;
        if (i48 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(202, i48);
        }
        int i49 = this.popularity;
        if (i49 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(203, i49);
        }
        int i56 = this.beLovedCount;
        if (i56 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(204, i56);
        }
        int i57 = this.beLikedCount;
        if (i57 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(205, i57);
        }
        int i58 = this.giftAmount;
        if (i58 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(206, i58);
        }
        int i59 = this.beAttentionCount;
        if (i59 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(207, i59);
        }
        int i65 = this.adoreCount;
        if (i65 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(208, i65);
        }
        int i66 = this.beAdoredCount;
        if (i66 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(209, i66);
        }
        int i67 = this.adoreTotalScore;
        if (i67 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(210, i67);
        }
        UserInfoExtra userInfoExtra = this.userInfoExtra;
        if (userInfoExtra != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(301, userInfoExtra);
        }
        BehaviourToUserInfo behaviourToUserInfo = this.behaviourToUserInfo;
        if (behaviourToUserInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(401, behaviourToUserInfo);
        }
        User_Privilege_Data user_Privilege_Data = this.userPrivilege;
        if (user_Privilege_Data != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(500, user_Privilege_Data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f237281id);
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
        long j3 = this.qiqiUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(28, j3);
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
        long j16 = this.shortId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(39, j16);
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
        int i38 = this.specialType;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(43, i38);
        }
        long j17 = this.uint64Uin;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(101, j17);
        }
        int i39 = this.showQq;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(102, i39);
        }
        if (!this.signature.equals("")) {
            codedOutputByteBufferNano.writeString(103, this.signature);
        }
        int i46 = this.fansCount;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(104, i46);
        }
        int i47 = this.logoTimestamp;
        if (i47 != 0) {
            codedOutputByteBufferNano.writeUInt32(105, i47);
        }
        CarInfo carInfo = this.carInfo;
        if (carInfo != null) {
            codedOutputByteBufferNano.writeMessage(106, carInfo);
        }
        boolean z16 = this.isLiked;
        if (z16) {
            codedOutputByteBufferNano.writeBool(201, z16);
        }
        int i48 = this.charm;
        if (i48 != 0) {
            codedOutputByteBufferNano.writeUInt32(202, i48);
        }
        int i49 = this.popularity;
        if (i49 != 0) {
            codedOutputByteBufferNano.writeUInt32(203, i49);
        }
        int i56 = this.beLovedCount;
        if (i56 != 0) {
            codedOutputByteBufferNano.writeUInt32(204, i56);
        }
        int i57 = this.beLikedCount;
        if (i57 != 0) {
            codedOutputByteBufferNano.writeUInt32(205, i57);
        }
        int i58 = this.giftAmount;
        if (i58 != 0) {
            codedOutputByteBufferNano.writeUInt32(206, i58);
        }
        int i59 = this.beAttentionCount;
        if (i59 != 0) {
            codedOutputByteBufferNano.writeUInt32(207, i59);
        }
        int i65 = this.adoreCount;
        if (i65 != 0) {
            codedOutputByteBufferNano.writeUInt32(208, i65);
        }
        int i66 = this.beAdoredCount;
        if (i66 != 0) {
            codedOutputByteBufferNano.writeUInt32(209, i66);
        }
        int i67 = this.adoreTotalScore;
        if (i67 != 0) {
            codedOutputByteBufferNano.writeUInt32(210, i67);
        }
        UserInfoExtra userInfoExtra = this.userInfoExtra;
        if (userInfoExtra != null) {
            codedOutputByteBufferNano.writeMessage(301, userInfoExtra);
        }
        BehaviourToUserInfo behaviourToUserInfo = this.behaviourToUserInfo;
        if (behaviourToUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(401, behaviourToUserInfo);
        }
        User_Privilege_Data user_Privilege_Data = this.userPrivilege;
        if (user_Privilege_Data != null) {
            codedOutputByteBufferNano.writeMessage(500, user_Privilege_Data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static HYUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new HYUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public HYUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f237281id = codedInputByteBufferNano.readUInt64();
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
                case a.CTRL_INDEX /* 344 */:
                    this.specialType = codedInputByteBufferNano.readUInt32();
                    break;
                case 808:
                    this.uint64Uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 816:
                    this.showQq = codedInputByteBufferNano.readUInt32();
                    break;
                case BusinessInfoCheckUpdateItem.UIAPPID_XINGQU_BULUO /* 826 */:
                    this.signature = codedInputByteBufferNano.readString();
                    break;
                case 832:
                    this.fansCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 840:
                    this.logoTimestamp = codedInputByteBufferNano.readUInt32();
                    break;
                case 850:
                    if (this.carInfo == null) {
                        this.carInfo = new CarInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.carInfo);
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
                    this.beAttentionCount = codedInputByteBufferNano.readUInt32();
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
                case 2410:
                    if (this.userInfoExtra == null) {
                        this.userInfoExtra = new UserInfoExtra();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfoExtra);
                    break;
                case 3210:
                    if (this.behaviourToUserInfo == null) {
                        this.behaviourToUserInfo = new BehaviourToUserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.behaviourToUserInfo);
                    break;
                case 4002:
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
