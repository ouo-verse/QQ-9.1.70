package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqmini.sdk.widget.ToastView;

/* loaded from: classes28.dex */
public final class FeedCloudRead$PushBoxDetail extends MessageMicro<FeedCloudRead$PushBoxDetail> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field box_type = PBField.initUInt32(0);
    public final PBFloatField loading = PBField.initFloat(0.0f);
    public final PBFloatField rate = PBField.initFloat(0.0f);
    public final PBUInt32Field draw_rocket_count = PBField.initUInt32(0);
    public final PBUInt32Field box_status = PBField.initUInt32(0);
    public final PBStringField show_off_label = PBField.initString("");

    static {
        String[] strArr = {"box_type", ToastView.ICON_LOADING, "rate", "draw_rocket_count", "box_status", "show_off_label"};
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 21, 29, 32, 40, 50}, strArr, new Object[]{0, valueOf, valueOf, 0, 0, ""}, FeedCloudRead$PushBoxDetail.class);
    }
}
