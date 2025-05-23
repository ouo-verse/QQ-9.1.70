package com.tencent.online.push.pb;

import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$BackgroundReq extends MessageMicro<OnlinePushField$BackgroundReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1361608, 1361616, 1361624, 1361632, 1361640, 1361650, 1361658, 1361664, 1361672, 1361680, 1361688, 1361698, 1361704, 1361712, 1361720, 1361730, 1361736, 1361744, 1361752, 1361760, 1361768, 1361776, 1361784}, new String[]{"uin", "c2c_unread_msg_count", "grp_unread", "dis_unread", "dis_session_list", "bind_uin_unread_item_list", "special_message_unread_list", PhotoCacheData.VIDEO_FLAG, "verify_unread", "recommend_unread", "contacts_unread", "public_account_folder_info_list", "document_unread", "public_account_switch", "notify_switch", "custom_unread_list", "bind_uin_notify_switch", "bind_uin_unread_status", "group_pro_unread", "group_pro_switch", "group_pro_notify_box_unread", "group_pro_subscribed_unread", "group_guild_unread"}, new Object[]{0L, 0L, 0L, 0L, 0, null, null, 0, 0, 0, 0, null, 0, 0, 0, null, 0, 0, 0, 0, 0L, 0L, 0L}, OnlinePushField$BackgroundReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt64Field c2c_unread_msg_count = PBField.initInt64(0);
    public final PBInt64Field grp_unread = PBField.initInt64(0);
    public final PBInt64Field dis_unread = PBField.initInt64(0);
    public final PBRepeatField<Integer> dis_session_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<OnlinePushField$BindUinUnreadItem> bind_uin_unread_item_list = PBField.initRepeatMessage(OnlinePushField$BindUinUnreadItem.class);
    public final PBRepeatMessageField<OnlinePushField$SpecialMessageUnRead> special_message_unread_list = PBField.initRepeatMessage(OnlinePushField$SpecialMessageUnRead.class);
    public final PBUInt32Field video_flag = PBField.initUInt32(0);
    public final PBUInt32Field verify_unread = PBField.initUInt32(0);
    public final PBUInt32Field recommend_unread = PBField.initUInt32(0);
    public final PBUInt32Field contacts_unread = PBField.initUInt32(0);
    public final PBRepeatMessageField<OnlinePushField$PublicAccountFolderInfo> public_account_folder_info_list = PBField.initRepeatMessage(OnlinePushField$PublicAccountFolderInfo.class);
    public final PBUInt32Field document_unread = PBField.initUInt32(0);
    public final PBUInt32Field public_account_switch = PBField.initUInt32(0);
    public final PBUInt32Field notify_switch = PBField.initUInt32(0);
    public final PBRepeatMessageField<OnlinePushField$CustomUnreadInfo> custom_unread_list = PBField.initRepeatMessage(OnlinePushField$CustomUnreadInfo.class);
    public final PBUInt32Field bind_uin_notify_switch = PBField.initUInt32(0);
    public final PBUInt32Field bind_uin_unread_status = PBField.initUInt32(0);
    public final PBUInt32Field group_pro_unread = PBField.initUInt32(0);
    public final PBUInt32Field group_pro_switch = PBField.initUInt32(0);
    public final PBInt64Field group_pro_notify_box_unread = PBField.initInt64(0);
    public final PBInt64Field group_pro_subscribed_unread = PBField.initInt64(0);
    public final PBInt64Field group_guild_unread = PBField.initInt64(0);
}
