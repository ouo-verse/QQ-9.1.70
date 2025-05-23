package com.tencent.mobileqq.qwallet.pb;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes16.dex */
public final class RedPackSkin$Promotion extends MessageMicro<RedPackSkin$Promotion> {
    public static final int RAINBOW = 0;
    public static final int TIANSHU = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 64, 74, 82}, new String[]{"id", "title", NotificationCompat.CATEGORY_RECOMMENDATION, "v_img", "h_img", "url", "tip", "source", WinkDaTongReportConstant.ElementParamKey.ADID, "trace_info"}, new Object[]{0, "", "", "", "", "", "", 0, "", ""}, RedPackSkin$Promotion.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f278703id = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField recommendation = PBField.initString("");
    public final PBStringField v_img = PBField.initString("");
    public final PBStringField h_img = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField tip = PBField.initString("");
    public final PBEnumField source = PBField.initEnum(0);
    public final PBStringField adid = PBField.initString("");
    public final PBStringField trace_info = PBField.initString("");
}
