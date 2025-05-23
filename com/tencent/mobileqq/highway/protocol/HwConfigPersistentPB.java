package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public final class HwConfigPersistentPB {
    static IPatchRedirector $redirector_;

    /* loaded from: classes9.dex */
    public static final class HwConfigItemPB extends MessageMicro<HwConfigItemPB> {
        public static final int RPT_END_POINT_LIST_FIELD_NUMBER = 2;
        public static final int STRING_KEY_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_key", "rpt_end_point_list"}, new Object[]{"", null}, HwConfigItemPB.class);
        public final PBStringField string_key = PBField.initString("");
        public final PBRepeatMessageField<HwEndPointPB> rpt_end_point_list = PBField.initRepeatMessage(HwEndPointPB.class);
    }

    /* loaded from: classes9.dex */
    public static final class HwConfigPB extends MessageMicro<HwConfigPB> {
        public static final int RPT_CONFIG_ITEM_LIST_FIELD_NUMBER = 1;
        public static final int RPT_CONFIG_ITEM_LIST_IP6_FIELD_NUMBER = 4;
        public static final int RPT_NET_SEG_CONF_LIST_FIELD_NUMBER = 2;
        public static final int RPT_SHORT_VIDEO_NET_CONF_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"rpt_config_item_list", "rpt_net_seg_conf_list", "rpt_short_video_net_conf", "rpt_config_item_list_ip6"}, new Object[]{null, null, null, null}, HwConfigPB.class);
        public final PBRepeatMessageField<HwConfigItemPB> rpt_config_item_list = PBField.initRepeatMessage(HwConfigItemPB.class);
        public final PBRepeatMessageField<HwNetSegConfPB> rpt_net_seg_conf_list = PBField.initRepeatMessage(HwNetSegConfPB.class);
        public final PBRepeatMessageField<HwNetSegConfPB> rpt_short_video_net_conf = PBField.initRepeatMessage(HwNetSegConfPB.class);
        public final PBRepeatMessageField<HwConfigItemPB> rpt_config_item_list_ip6 = PBField.initRepeatMessage(HwConfigItemPB.class);
    }

    /* loaded from: classes9.dex */
    public static final class HwEndPointPB extends MessageMicro<HwEndPointPB> {
        public static final int INT32_PORT_FIELD_NUMBER = 2;
        public static final int INT64_TIMESTAMPE_FIELD_NUMBER = 3;
        public static final int STRING_HOST_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"string_host", "int32_port", "int64_timestampe"}, new Object[]{"", 0, 0L}, HwEndPointPB.class);
        public final PBStringField string_host = PBField.initString("");
        public final PBInt32Field int32_port = PBField.initInt32(0);
        public final PBInt64Field int64_timestampe = PBField.initInt64(0);
    }

    /* loaded from: classes9.dex */
    public static final class HwNetSegConfPB extends MessageMicro<HwNetSegConfPB> {
        public static final int INT64_CUR_CONN_NUM_FIELD_NUMBER = 4;
        public static final int INT64_NET_TYPE_FIELD_NUMBER = 1;
        public static final int INT64_SEG_NUM_FIELD_NUMBER = 3;
        public static final int INT64_SEG_SIZE_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"int64_net_type", "int64_seg_size", "int64_seg_num", "int64_cur_conn_num"}, new Object[]{0L, 0L, 0L, 0L}, HwNetSegConfPB.class);
        public final PBInt64Field int64_net_type = PBField.initInt64(0);
        public final PBInt64Field int64_seg_size = PBField.initInt64(0);
        public final PBInt64Field int64_seg_num = PBField.initInt64(0);
        public final PBInt64Field int64_cur_conn_num = PBField.initInt64(0);
    }

    HwConfigPersistentPB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
