package com.tencent.pb.vipfontupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFontUpdate$TFontSsoRsp extends MessageMicro<VipFontUpdate$TFontSsoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 66, 82, 90, 98}, new String[]{"i32_ret", "str_msg", "u32_cmd", "u64_seq", "st_fresh_rsp", "st_md5_check_rsp", "st_poster_rsp", "st_check_rsp", "st_diyfont_rsp", "st_getposterfont_rsp", "st_setposterfont_rsp"}, new Object[]{0, "", 0, 0L, null, null, null, null, null, null, null}, VipFontUpdate$TFontSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt32Field u32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field u64_seq = PBField.initUInt64(0);
    public VipFontUpdate$TFontFreshRsp st_fresh_rsp = new MessageMicro<VipFontUpdate$TFontFreshRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TFontFreshRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"i32_font_type"}, new Object[]{0}, VipFontUpdate$TFontFreshRsp.class);
        public final PBInt32Field i32_font_type = PBField.initInt32(0);
    };
    public VipFontUpdate$TFontMd5CheckRsp st_md5_check_rsp = new MessageMicro<VipFontUpdate$TFontMd5CheckRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TFontMd5CheckRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_md5_ret"}, new Object[]{null}, VipFontUpdate$TFontMd5CheckRsp.class);
        public final PBRepeatMessageField<TMd5Ret> rpt_md5_ret = PBField.initRepeatMessage(TMd5Ret.class);

        /* compiled from: P */
        /* loaded from: classes22.dex */
        public static final class TMd5Ret extends MessageMicro<TMd5Ret> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"i32_check_font_id", "i32_check_ret"}, new Object[]{0, 0}, TMd5Ret.class);
            public final PBInt32Field i32_check_font_id = PBField.initInt32(0);
            public final PBInt32Field i32_check_ret = PBField.initInt32(0);
        }
    };
    public VipFontUpdate$TPosterRsp st_poster_rsp = new MessageMicro<VipFontUpdate$TPosterRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TPosterRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"i32_valid", "rpt_mine_list", "rpt_recommend_list"}, new Object[]{0, null, null}, VipFontUpdate$TPosterRsp.class);
        public final PBInt32Field i32_valid = PBField.initInt32(0);
        public final PBRepeatMessageField<VipFontUpdate$TPosterInfo> rpt_mine_list = PBField.initRepeatMessage(VipFontUpdate$TPosterInfo.class);
        public final PBRepeatMessageField<VipFontUpdate$TPosterInfo> rpt_recommend_list = PBField.initRepeatMessage(VipFontUpdate$TPosterInfo.class);
    };
    public VipFontUpdate$TCheckRsp st_check_rsp = new MessageMicro<VipFontUpdate$TCheckRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TCheckRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"i32_ret", "st_tips_info", "valid_time"}, new Object[]{0, null, 0L}, VipFontUpdate$TCheckRsp.class);
        public final PBInt32Field i32_ret = PBField.initInt32(0);
        public VipFontUpdate$TTipsInfo st_tips_info = new VipFontUpdate$TTipsInfo();
        public final PBInt64Field valid_time = PBField.initInt64(0);
    };
    public VipFontUpdate$TDiyFontRsp st_diyfont_rsp = new VipFontUpdate$TDiyFontRsp();
    public VipFontUpdate$TGetPosterFontRsp st_getposterfont_rsp = new MessageMicro<VipFontUpdate$TGetPosterFontRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TGetPosterFontRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"rpt_using_list", "st_redpoint", "i32_recommend_font_id"}, new Object[]{null, null, 0}, VipFontUpdate$TGetPosterFontRsp.class);
        public final PBRepeatMessageField<VipFontUpdate$TPosterFontInfo> rpt_using_list = PBField.initRepeatMessage(VipFontUpdate$TPosterFontInfo.class);
        public VipFontUpdate$TPosterFontRedPoint st_redpoint = new MessageMicro<VipFontUpdate$TPosterFontRedPoint>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TPosterFontRedPoint
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u64_ts", "u64_last"}, new Object[]{0L, 0L}, VipFontUpdate$TPosterFontRedPoint.class);
            public final PBUInt64Field u64_ts = PBField.initUInt64(0);
            public final PBUInt64Field u64_last = PBField.initUInt64(0);
        };
        public final PBRepeatField<Integer> i32_recommend_font_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    };
    public VipFontUpdate$TSetPosterFontRsp st_setposterfont_rsp = new MessageMicro<VipFontUpdate$TSetPosterFontRsp>() { // from class: com.tencent.pb.vipfontupdate.VipFontUpdate$TSetPosterFontRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"i32_ret", "st_tips_info"}, new Object[]{0, null}, VipFontUpdate$TSetPosterFontRsp.class);
        public final PBInt32Field i32_ret = PBField.initInt32(0);
        public VipFontUpdate$TTipsInfo st_tips_info = new VipFontUpdate$TTipsInfo();
    };
}
