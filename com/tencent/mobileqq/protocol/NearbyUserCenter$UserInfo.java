package com.tencent.mobileqq.protocol;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.weiyun.poi.PoiDbManager;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$UserInfo extends MessageMicro<NearbyUserCenter$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<String> album;
    public final PBRepeatMessageField<NearbyUserCenter$TagTreeNode> all_tags;
    public final PBBytesField birthday;
    public final PBBytesField city_id;
    public final PBUInt32Field city_zone_id;
    public final PBStringField company;
    public final PBUInt32Field constellation;
    public final PBRepeatMessageField<NearbyUserCenter$NearbyTag> interests;
    public final PBUInt32Field job;
    public NearbyUserCenter$Location location;
    public final PBUInt32Field marriage;
    public final PBStringField school;
    public final PBStringField signature;
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt32Field age = PBField.initUInt32(0);

    /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mobileqq.protocol.NearbyUserCenter$Location] */
    public NearbyUserCenter$UserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.birthday = PBField.initBytes(byteStringMicro);
        this.signature = PBField.initString("");
        this.marriage = PBField.initUInt32(0);
        this.job = PBField.initUInt32(0);
        this.company = PBField.initString("");
        this.school = PBField.initString("");
        this.city_id = PBField.initBytes(byteStringMicro);
        this.city_zone_id = PBField.initUInt32(0);
        this.interests = PBField.initRepeatMessage(NearbyUserCenter$NearbyTag.class);
        this.location = new MessageMicro<NearbyUserCenter$Location>() { // from class: com.tencent.mobileqq.protocol.NearbyUserCenter$Location
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"longitude", "latitude"}, new Object[]{0, 0}, NearbyUserCenter$Location.class);
            public final PBInt32Field longitude = PBField.initInt32(0);
            public final PBInt32Field latitude = PBField.initInt32(0);
        };
        this.album = PBField.initRepeat(PBStringField.__repeatHelper__);
        this.constellation = PBField.initUInt32(0);
        this.all_tags = PBField.initRepeatMessage(NearbyUserCenter$TagTreeNode.class);
    }

    static {
        String[] strArr = {"nick", "logo", INetChannelCallback.KEY_TINY_ID, "gender", "age", "birthday", "signature", "marriage", "job", IProfileProtocolConst.KEY_COMPANY, "school", PoiDbManager.COL_POI_CITY_ID, "city_zone_id", IProfileProtocolConst.KET_INTERESTS, "location", "album", LpReport_UserInfo_dc02148.CONSTELLATION, "all_tags"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 50, 58, 64, 72, 82, 90, 98, 104, 114, 122, 138, 144, 154}, strArr, new Object[]{"", "", 0L, 0, 0, byteStringMicro, "", 0, 0, "", "", byteStringMicro, 0, null, null, "", 0, null}, NearbyUserCenter$UserInfo.class);
    }
}
