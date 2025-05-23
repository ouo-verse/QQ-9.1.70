package NS_MINI_AD;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppAd$ContextInfo extends MessageMicro<MiniAppAd$ContextInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56}, new String[]{"public_id", AppConstants.Key.SHARE_REQ_ARTICLE_ID, "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids"}, new Object[]{0L, 0L, 0, 0, 0, ByteStringMicro.EMPTY, 0L}, MiniAppAd$ContextInfo.class);
    public final PBUInt64Field public_id = PBField.initUInt64(0);
    public final PBUInt64Field article_id = PBField.initUInt64(0);
    public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
    public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
    public final PBUInt32Field source_from = PBField.initUInt32(0);
    public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
