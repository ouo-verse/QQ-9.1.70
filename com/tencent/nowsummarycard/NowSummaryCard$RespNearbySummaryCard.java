package com.tencent.nowsummarycard;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$RespNearbySummaryCard extends MessageMicro<NowSummaryCard$RespNearbySummaryCard> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt64Field birthday;
    public final PBUInt64Field chat_id;
    public final PBBytesField common_label;
    public NowSummaryCard$CommonTag common_tag;
    public final PBBytesField date_face;
    public final PBUInt64Field gender;
    public NowSummaryCard$GiftInfo gift_info;
    public NowSummaryCard$GroupInfo group_info;
    public NowSummaryCard$InterestTagInfo interest_tag;
    public final PBUInt32Field is_friend;
    public final PBUInt32Field is_verified;
    public final PBBytesField nearby_info;
    public NowSummaryCard$NearbyTag nearby_tag;
    public final PBBytesField nearby_task_info;
    public final PBBytesField now_info;
    public final PBBytesField rich_sign;
    public final PBBytesField temp_chat_sig;
    public NowSummaryCard$VoteInfo vote_info;
    public final PBInt32Field iFace = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field age = PBField.initInt32(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBInt32Field constellation = PBField.initInt32(0);
    public final PBUInt32Field profession = PBField.initUInt32(0);
    public final PBStringField company = PBField.initString("");
    public final PBStringField school = PBField.initString("");
    public final PBUInt32Field home_country = PBField.initUInt32(0);
    public final PBUInt32Field home_province = PBField.initUInt32(0);
    public final PBUInt32Field home_city = PBField.initUInt32(0);
    public final PBStringField distance = PBField.initString("");
    public final PBStringField elapse = PBField.initString("");
    public final PBInt32Field marriage = PBField.initInt32(0);
    public final PBUInt32Field home_zone = PBField.initUInt32(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBUInt64Field school_id = PBField.initUInt64(0);

    static {
        int[] iArr = {8, 16, 24, 34, 42, 50, 58, 66, 72, 80, 90, 98, 104, 112, 120, 130, 138, 144, 152, 160, 168, 178, 186, 194, 202, 210, 216, 226, 234, 240, 250, 258, 266, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 288, 298, 306, 314};
        String[] strArr = {"iFace", "uin", "age", "nick", "remark", "province", "city", "sign", LpReport_UserInfo_dc02148.CONSTELLATION, IProfileProtocolConst.KEY_PROFESSION, IProfileProtocolConst.KEY_COMPANY, "school", "home_country", "home_province", "home_city", Element.ELEMENT_NAME_DISTANCE, "elapse", "marriage", "home_zone", INetChannelCallback.KEY_TINY_ID, "school_id", "nearby_task_info", "now_info", "common_label", "nearby_info", "date_face", "birthday", "rich_sign", "temp_chat_sig", "gender", "interest_tag", "gift_info", "vote_info", "is_friend", "chat_id", "is_verified", "common_tag", "nearby_tag", "group_info"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{0, 0L, 0, "", "", "", "", "", 0, 0, "", "", 0, 0, 0, "", "", 0, 0, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, byteStringMicro, byteStringMicro, 0L, null, null, null, 0, 0L, 0, null, null, null}, NowSummaryCard$RespNearbySummaryCard.class);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.nowsummarycard.NowSummaryCard$CommonTag] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.nowsummarycard.NowSummaryCard$NearbyTag] */
    public NowSummaryCard$RespNearbySummaryCard() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.nearby_task_info = PBField.initBytes(byteStringMicro);
        this.now_info = PBField.initBytes(byteStringMicro);
        this.common_label = PBField.initBytes(byteStringMicro);
        this.nearby_info = PBField.initBytes(byteStringMicro);
        this.date_face = PBField.initBytes(byteStringMicro);
        this.birthday = PBField.initInt64(0L);
        this.rich_sign = PBField.initBytes(byteStringMicro);
        this.temp_chat_sig = PBField.initBytes(byteStringMicro);
        this.gender = PBField.initUInt64(0L);
        this.interest_tag = new NowSummaryCard$InterestTagInfo();
        this.gift_info = new NowSummaryCard$GiftInfo();
        this.vote_info = new NowSummaryCard$VoteInfo();
        this.is_friend = PBField.initUInt32(0);
        this.chat_id = PBField.initUInt64(0L);
        this.is_verified = PBField.initUInt32(0);
        this.common_tag = new MessageMicro<NowSummaryCard$CommonTag>() { // from class: com.tencent.nowsummarycard.NowSummaryCard$CommonTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tag"}, new Object[]{null}, NowSummaryCard$CommonTag.class);
            public final PBRepeatMessageField<Tag> tag = PBField.initRepeatMessage(Tag.class);

            /* compiled from: P */
            /* loaded from: classes22.dex */
            public static final class Tag extends MessageMicro<Tag> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"topic", "name"}, new Object[]{"", ""}, Tag.class);
                public final PBStringField topic = PBField.initString("");
                public final PBRepeatField<String> name = PBField.initRepeat(PBStringField.__repeatHelper__);
            }
        };
        this.nearby_tag = new MessageMicro<NowSummaryCard$NearbyTag>() { // from class: com.tencent.nowsummarycard.NowSummaryCard$NearbyTag
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, NowSummaryCard$NearbyTag.class);
            public final PBRepeatMessageField<Data> data = PBField.initRepeatMessage(Data.class);

            /* compiled from: P */
            /* loaded from: classes22.dex */
            public static final class ChildDetail extends MessageMicro<ChildDetail> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"id", "name", "checked", "sort_id"}, new Object[]{"", "", Boolean.FALSE, 0}, ChildDetail.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBStringField f339117id = PBField.initString("");
                public final PBStringField name = PBField.initString("");
                public final PBBoolField checked = PBField.initBool(false);
                public final PBUInt32Field sort_id = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes22.dex */
            public static final class Data extends MessageMicro<Data> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"id", "name", "type", "detail", "sort_id"}, new Object[]{"", "", 0, null, 0}, Data.class);

                /* renamed from: id, reason: collision with root package name */
                public final PBStringField f339118id = PBField.initString("");
                public final PBStringField name = PBField.initString("");
                public final PBUInt32Field type = PBField.initUInt32(0);
                public final PBRepeatMessageField<Detail> detail = PBField.initRepeatMessage(Detail.class);
                public final PBUInt32Field sort_id = PBField.initUInt32(0);
            }

            /* compiled from: P */
            /* loaded from: classes22.dex */
            public static final class Detail extends MessageMicro<Detail> {
                static final MessageMicro.FieldMap __fieldMap__;

                /* renamed from: id, reason: collision with root package name */
                public final PBStringField f339119id = PBField.initString("");
                public final PBStringField name = PBField.initString("");
                public final PBBoolField checked = PBField.initBool(false);
                public final PBRepeatMessageField<ChildDetail> child_detail = PBField.initRepeatMessage(ChildDetail.class);
                public final PBUInt32Field sort_id = PBField.initUInt32(0);
                public final PBBoolField hide = PBField.initBool(false);

                static {
                    Boolean bool = Boolean.FALSE;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 48}, new String[]{"id", "name", "checked", "child_detail", "sort_id", "hide"}, new Object[]{"", "", bool, null, 0, bool}, Detail.class);
                }
            }
        };
        this.group_info = new NowSummaryCard$GroupInfo();
    }
}
