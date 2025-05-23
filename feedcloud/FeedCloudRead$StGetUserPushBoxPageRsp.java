package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqnt.chats.api.impl.ChatsRevealApiImpl;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserPushBoxPageRsp extends MessageMicro<FeedCloudRead$StGetUserPushBoxPageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 58, 66, 74, 82, 90}, new String[]{"box_list", "extInfo", "rocket_count", "normal_box_count", "super_box_count", PictureConst.KEY_HAS_MORE, "attach_info", "rules_jump_url", ChatsRevealApiImpl.KEY_JUMP_SCHEME, "push_statistic_data", "push_page_res"}, new Object[]{null, null, 0, 0, 0, 0, "", "", "", null, null}, FeedCloudRead$StGetUserPushBoxPageRsp.class);
    public final PBRepeatMessageField<FeedCloudRead$PushBoxInfo> box_list = PBField.initRepeatMessage(FeedCloudRead$PushBoxInfo.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field rocket_count = PBField.initUInt32(0);
    public final PBUInt32Field normal_box_count = PBField.initUInt32(0);
    public final PBUInt32Field super_box_count = PBField.initUInt32(0);
    public final PBInt32Field has_more = PBField.initInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBStringField rules_jump_url = PBField.initString("");
    public final PBStringField jump_schema = PBField.initString("");
    public FeedCloudRead$PushStatisticData push_statistic_data = new MessageMicro<FeedCloudRead$PushStatisticData>() { // from class: feedcloud.FeedCloudRead$PushStatisticData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"today_push_cnt", "today_recv_box", "today_recv_rocket", "history_push_cnt", "history_recv_box", "history_recv_rocket", "tips"}, new Object[]{0, 0, 0, 0, 0, 0, ""}, FeedCloudRead$PushStatisticData.class);
        public final PBUInt32Field today_push_cnt = PBField.initUInt32(0);
        public final PBUInt32Field today_recv_box = PBField.initUInt32(0);
        public final PBUInt32Field today_recv_rocket = PBField.initUInt32(0);
        public final PBUInt32Field history_push_cnt = PBField.initUInt32(0);
        public final PBUInt32Field history_recv_box = PBField.initUInt32(0);
        public final PBUInt32Field history_recv_rocket = PBField.initUInt32(0);
        public final PBStringField tips = PBField.initString("");
    };
    public FeedCloudRead$PushPageRes push_page_res = new MessageMicro<FeedCloudRead$PushPageRes>() { // from class: feedcloud.FeedCloudRead$PushPageRes
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"res_type", "res_cover_url", "res_title", "res_desc", "res_jump_url"}, new Object[]{0, "", "", "", ""}, FeedCloudRead$PushPageRes.class);
        public final PBUInt32Field res_type = PBField.initUInt32(0);
        public final PBStringField res_cover_url = PBField.initString("");
        public final PBStringField res_title = PBField.initString("");
        public final PBStringField res_desc = PBField.initString("");
        public final PBStringField res_jump_url = PBField.initString("");
    };
}
