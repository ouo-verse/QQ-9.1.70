package NS_MINI_INTERFACE;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StIdeConfig extends MessageMicro<INTERFACE$StIdeConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"scene", "extraAppid", WadlProxyConsts.EXTRA_DATA, "startExtInfo"}, new Object[]{"", "", "", null}, INTERFACE$StIdeConfig.class);
    public final PBStringField scene = PBField.initString("");
    public final PBStringField extraAppid = PBField.initString("");
    public final PBStringField extraData = PBField.initString("");
    public INTERFACE$StStartExtInfo startExtInfo = new INTERFACE$StStartExtInfo();
}
