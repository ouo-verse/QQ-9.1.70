package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudConvertidClient$ConvertToXWorldRsp extends MessageMicro<FeedCloudConvertidClient$ConvertToXWorldRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82}, new String[]{"id_items", "poll_conf"}, new Object[]{null, null}, FeedCloudConvertidClient$ConvertToXWorldRsp.class);
    public final PBRepeatMessageField<FeedCloudConvertidClient$IDItem> id_items = PBField.initRepeatMessage(FeedCloudConvertidClient$IDItem.class);
    public FeedCloudConvertidClient$PollConf poll_conf = new MessageMicro<FeedCloudConvertidClient$PollConf>() { // from class: feedcloud.FeedCloudConvertidClient$PollConf
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"duration", "max_count"}, new Object[]{0, 0}, FeedCloudConvertidClient$PollConf.class);
        public final PBUInt32Field duration = PBField.initUInt32(0);
        public final PBUInt32Field max_count = PBField.initUInt32(0);
    };
}
