package com.tencent.mobileqq.pb.financial;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class FinancialEntry$DrawerRsp extends MessageMicro<FinancialEntry$DrawerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"show_flag", "title", "url", "profit_rate_tip", "is_pull_avatar_tips"}, new Object[]{0, "", "", null, Boolean.FALSE}, FinancialEntry$DrawerRsp.class);
    public final PBInt32Field show_flag = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public FinancialEntry$TipItem profit_rate_tip = new MessageMicro<FinancialEntry$TipItem>() { // from class: com.tencent.mobileqq.pb.financial.FinancialEntry$TipItem
        public static final int ONLY_AVATAR = 1;
        public static final int ONLY_DRAWER = 2;
        public static final int PROFIT_RATE = 2;
        public static final int UNKNOWN = 0;
        public static final int UNLIMITED = 0;
        public static final int YDAY_PROFIT = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 56}, new String[]{"type", "loc", "content", "advanced_adv_ids", "animation_url", AppConstants.Key.SHARE_REQ_AUDIO_URL, "expire_ts"}, new Object[]{0, 0, "", 0L, "", "", 0L}, FinancialEntry$TipItem.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBEnumField loc = PBField.initEnum(0);
        public final PBStringField content = PBField.initString("");
        public final PBRepeatField<Long> advanced_adv_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBStringField animation_url = PBField.initString("");
        public final PBStringField audio_url = PBField.initString("");
        public final PBInt64Field expire_ts = PBField.initInt64(0);
    };
    public final PBBoolField is_pull_avatar_tips = PBField.initBool(false);
}
