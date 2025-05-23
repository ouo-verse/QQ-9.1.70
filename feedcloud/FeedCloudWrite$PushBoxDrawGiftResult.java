package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudWrite$PushBoxDrawGiftResult extends MessageMicro<FeedCloudWrite$PushBoxDrawGiftResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 37, 42, 50, 58, 66, 74}, new String[]{"gift_type", "total_rocket", "congratulation_words", "rate", "sub_title", "gift_id", "setting_btn_text", "setting_btn_url", "img_url"}, new Object[]{0, 0, "", Float.valueOf(0.0f), "", "", "", "", ""}, FeedCloudWrite$PushBoxDrawGiftResult.class);
    public final PBUInt32Field gift_type = PBField.initUInt32(0);
    public final PBUInt32Field total_rocket = PBField.initUInt32(0);
    public final PBStringField congratulation_words = PBField.initString("");
    public final PBFloatField rate = PBField.initFloat(0.0f);
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField gift_id = PBField.initString("");
    public final PBStringField setting_btn_text = PBField.initString("");
    public final PBStringField setting_btn_url = PBField.initString("");
    public final PBStringField img_url = PBField.initString("");
}
