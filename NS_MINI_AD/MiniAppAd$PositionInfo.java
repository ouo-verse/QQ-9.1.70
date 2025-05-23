package NS_MINI_AD;

import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MiniAppAd$PositionInfo extends MessageMicro<MiniAppAd$PositionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{SsoReporter.POS_ID_KEY, "ad_count", "pos_ext"}, new Object[]{"", 0, null}, MiniAppAd$PositionInfo.class);
    public final PBStringField pos_id = PBField.initString("");
    public final PBUInt32Field ad_count = PBField.initUInt32(0);
    public MiniAppAd$PositionExt pos_ext = new MiniAppAd$PositionExt();
}
