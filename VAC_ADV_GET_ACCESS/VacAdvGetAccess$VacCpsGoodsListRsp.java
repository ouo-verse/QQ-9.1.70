package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class VacAdvGetAccess$VacCpsGoodsListRsp extends MessageMicro<VacAdvGetAccess$VacCpsGoodsListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "total_num", "good_infos"}, new Object[]{0, "", 0, null}, VacAdvGetAccess$VacCpsGoodsListRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBInt32Field total_num = PBField.initInt32(0);
    public final PBRepeatMessageField<VacAdvGetAccess$GoodsInfo> good_infos = PBField.initRepeatMessage(VacAdvGetAccess$GoodsInfo.class);
}
