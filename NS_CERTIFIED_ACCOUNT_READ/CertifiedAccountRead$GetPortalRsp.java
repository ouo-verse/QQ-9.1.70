package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$GetPortalRsp extends MessageMicro<CertifiedAccountRead$GetPortalRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 82}, new String[]{"tab_lst", "room_lst", "trace_info"}, new Object[]{null, null, ""}, CertifiedAccountRead$GetPortalRsp.class);
    public final PBRepeatMessageField<TabItem> tab_lst = PBField.initRepeatMessage(TabItem.class);
    public final PBRepeatMessageField<RoomLstItem> room_lst = PBField.initRepeatMessage(RoomLstItem.class);
    public final PBStringField trace_info = PBField.initString("");

    /* loaded from: classes.dex */
    public static final class BannerItem extends MessageMicro<BannerItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"pic_url", "jump_url"}, new Object[]{"", ""}, BannerItem.class);
        public final PBStringField pic_url = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }

    /* loaded from: classes.dex */
    public static final class KV extends MessageMicro<KV> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, KV.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* loaded from: classes.dex */
    public static final class RoomGoodInfo extends MessageMicro<RoomGoodInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64}, new String[]{"has_good", "pic_url", "name", "price", "jump_url", "recomm_url", "recom_pic", "goods_num"}, new Object[]{0, "", "", "", "", "", "", 0L}, RoomGoodInfo.class);
        public final PBInt32Field has_good = PBField.initInt32(0);
        public final PBStringField pic_url = PBField.initString("");
        public final PBStringField name = PBField.initString("");
        public final PBStringField price = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
        public final PBStringField recomm_url = PBField.initString("");
        public final PBStringField recom_pic = PBField.initString("");
        public final PBUInt64Field goods_num = PBField.initUInt64(0);
    }

    /* loaded from: classes.dex */
    public static final class RoomIconInfo extends MessageMicro<RoomIconInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"icon_url", "icon_title", "audience_num"}, new Object[]{"", "", 0L}, RoomIconInfo.class);
        public final PBStringField icon_url = PBField.initString("");
        public final PBStringField icon_title = PBField.initString("");
        public final PBUInt64Field audience_num = PBField.initUInt64(0);
    }

    /* loaded from: classes.dex */
    public static final class RoomItem extends MessageMicro<RoomItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112, 120, 128, 136}, new String[]{AudienceReportConst.ROOM_ID, "pgc_openid", "pgc_uid", "nick", "title", "portrait", "pic_url", "program_id", "report_trace_info", "good_info", "icon_info", "ext_info", "recom_info", "room_type", "video_source", "game_id", "game_tag_id"}, new Object[]{"", "", 0L, "", "", "", "", "", "", null, null, null, "", 0, 0L, 0, 0}, RoomItem.class);
        public final PBStringField room_id = PBField.initString("");
        public final PBStringField pgc_openid = PBField.initString("");
        public final PBUInt64Field pgc_uid = PBField.initUInt64(0);
        public final PBStringField nick = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField portrait = PBField.initString("");
        public final PBStringField pic_url = PBField.initString("");
        public final PBStringField program_id = PBField.initString("");
        public final PBStringField report_trace_info = PBField.initString("");
        public RoomGoodInfo good_info = new RoomGoodInfo();
        public RoomIconInfo icon_info = new RoomIconInfo();
        public final PBRepeatMessageField<KV> ext_info = PBField.initRepeatMessage(KV.class);
        public final PBStringField recom_info = PBField.initString("");
        public final PBUInt32Field room_type = PBField.initUInt32(0);
        public final PBUInt64Field video_source = PBField.initUInt64(0);
        public final PBUInt32Field game_id = PBField.initUInt32(0);
        public final PBUInt32Field game_tag_id = PBField.initUInt32(0);
    }

    /* loaded from: classes.dex */
    public static final class RoomLstItem extends MessageMicro<RoomLstItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"tab_info", "sub_tab_lst", "banner_lst", "room_lst"}, new Object[]{null, null, null, null}, RoomLstItem.class);
        public TabItem tab_info = new TabItem();
        public final PBRepeatMessageField<SubTabItem> sub_tab_lst = PBField.initRepeatMessage(SubTabItem.class);
        public final PBRepeatMessageField<BannerItem> banner_lst = PBField.initRepeatMessage(BannerItem.class);
        public final PBRepeatMessageField<RoomItem> room_lst = PBField.initRepeatMessage(RoomItem.class);
    }

    /* loaded from: classes.dex */
    public static final class SubTabItem extends MessageMicro<SubTabItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, SubTabItem.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBInt32Field f24933id = PBField.initInt32(0);
        public final PBStringField name = PBField.initString("");
    }

    /* loaded from: classes.dex */
    public static final class TabItem extends MessageMicro<TabItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "name"}, new Object[]{0, ""}, TabItem.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBInt32Field f24934id = PBField.initInt32(0);
        public final PBStringField name = PBField.initString("");
    }
}
