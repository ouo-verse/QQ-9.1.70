package com.tencent.icgame.trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiSmobaOuterClass$WujiSmobaGradeLevelConvertConf extends MessageMicro<WujiSmobaOuterClass$WujiSmobaGradeLevelConvertConf> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"src_disp_grade_level", "dest_disp_grade_level", "lower_star", "upper_star"}, new Object[]{0, 0, 0, 0}, WujiSmobaOuterClass$WujiSmobaGradeLevelConvertConf.class);
    public final PBInt32Field src_disp_grade_level = PBField.initInt32(0);
    public final PBInt32Field dest_disp_grade_level = PBField.initInt32(0);
    public final PBInt32Field lower_star = PBField.initInt32(0);
    public final PBInt32Field upper_star = PBField.initInt32(0);
}
