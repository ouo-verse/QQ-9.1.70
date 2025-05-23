package pb.unify.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnifySearchBusiHotWord$RspBody extends MessageMicro<UnifySearchBusiHotWord$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"result_code", "error_msg", "rpt_item_groups", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{0, "", null, 0}, UnifySearchBusiHotWord$RspBody.class);
    public final PBUInt32Field result_code = PBField.initUInt32(0);
    public final PBStringField error_msg = PBField.initString("");
    public final PBRepeatMessageField<UnifySearchBusiHotWord$GroupWord> rpt_item_groups = PBField.initRepeatMessage(UnifySearchBusiHotWord$GroupWord.class);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
}
