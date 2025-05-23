package com.tencent.biz.pb;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$FollowListRsp extends MessageMicro<clientbusilogic$FollowListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"oidb_0x4c9", "oidb_0xf2a"}, new Object[]{null, null}, clientbusilogic$FollowListRsp.class);
    public ListOld oidb_0x4c9 = new ListOld();
    public ListNew oidb_0xf2a = new ListNew();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class FollowInfoNew extends MessageMicro<FollowInfoNew> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField openid = PBField.initString("");
        public final PBBoolField is_followed = PBField.initBool(false);
        public final PBUInt32Field follow_time = PBField.initUInt32(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt64Field appid = PBField.initUInt64(0);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBBoolField is_recv_msg = PBField.initBool(false);
        public final PBBoolField is_recv_push = PBField.initBool(false);
        public final PBUInt32Field follow_type = PBField.initUInt32(0);
        public final PBStringField account_uid = PBField.initString("");

        static {
            String[] strArr = {"openid", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_IS_FOLLOWED, "follow_time", "uin", "appid", IPublicAccountBrowser.KEY_PUB_UIN, "is_recv_msg", "is_recv_push", "follow_type", "account_uid"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 64, 72, 274}, strArr, new Object[]{"", bool, 0, 0L, 0L, 0L, bool, bool, 0, ""}, FollowInfoNew.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class FollowInfoOld extends MessageMicro<FollowInfoOld> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBBoolField is_recv_msg = PBField.initBool(false);
        public final PBBoolField is_recv_push = PBField.initBool(false);
        public final PBUInt32Field follow_type = PBField.initUInt32(0);
        public final PBStringField account_uid = PBField.initString("");

        static {
            String[] strArr = {IPublicAccountBrowser.KEY_PUB_UIN, "is_recv_msg", "is_recv_push", "follow_type", "account_uid"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 274}, strArr, new Object[]{0L, bool, bool, 0, ""}, FollowInfoOld.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ListNew extends MessageMicro<ListNew> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"follow_info", "is_end", "next_seq", "total_follow_count"}, new Object[]{null, Boolean.FALSE, 0L, 0}, ListNew.class);
        public final PBRepeatMessageField<FollowInfoNew> follow_info = PBField.initRepeatMessage(FollowInfoNew.class);
        public final PBBoolField is_end = PBField.initBool(false);
        public final PBInt64Field next_seq = PBField.initInt64(0);
        public final PBUInt32Field total_follow_count = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class ListOld extends MessageMicro<ListOld> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"ret_info", "list_seqno", "total_follow_count", "rpt_msg_pubacc_list"}, new Object[]{null, 0, 0, null}, ListOld.class);
        public clientbusilogic$RetInfo ret_info = new clientbusilogic$RetInfo();
        public final PBUInt32Field list_seqno = PBField.initUInt32(0);
        public final PBUInt32Field total_follow_count = PBField.initUInt32(0);
        public final PBRepeatMessageField<FollowInfoOld> rpt_msg_pubacc_list = PBField.initRepeatMessage(FollowInfoOld.class);
    }
}
