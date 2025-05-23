package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;

/* loaded from: classes.dex */
public final class MiniAppAd$StAdPageFlipTemplate extends MessageMicro<MiniAppAd$StAdPageFlipTemplate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ad_type", QzoneCameraConst.Tag.ARG_PARAM_EFFECT_ID}, new Object[]{0, 0}, MiniAppAd$StAdPageFlipTemplate.class);
    public final PBInt32Field ad_type = PBField.initInt32(0);
    public final PBInt32Field effect_id = PBField.initInt32(0);
}
