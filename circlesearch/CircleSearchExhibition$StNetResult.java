package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CircleSearchExhibition$StNetResult extends MessageMicro<CircleSearchExhibition$StNetResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feed", "raw_data", "report_data"}, new Object[]{null, "", ""}, CircleSearchExhibition$StNetResult.class);
    public CircleSearchExhibition$StFeedAbstractForNetResult feed = new MessageMicro<CircleSearchExhibition$StFeedAbstractForNetResult>() { // from class: circlesearch.CircleSearchExhibition$StFeedAbstractForNetResult
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 66}, new String[]{"id", QAdVrReport.ElementID.AD_POSTER, "cover", "video", "content", "type", "visitor_info", "images"}, new Object[]{"", null, null, null, "", 0, null, null}, CircleSearchExhibition$StFeedAbstractForNetResult.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f30977id = PBField.initString("");
        public CircleSearchExhibition$StUser poster = new MessageMicro<CircleSearchExhibition$StUser>() { // from class: circlesearch.CircleSearchExhibition$StUser
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"id", "nick"}, new Object[]{"", ""}, CircleSearchExhibition$StUser.class);

            /* renamed from: id, reason: collision with root package name */
            public final PBStringField f30978id = PBField.initString("");
            public final PBStringField nick = PBField.initString("");
        };
        public CircleSearchExhibition$StImage cover = new MessageMicro<CircleSearchExhibition$StImage>() { // from class: circlesearch.CircleSearchExhibition$StImage
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"width", "height", "pic_url", "layer_pic_url"}, new Object[]{0, 0, "", ""}, CircleSearchExhibition$StImage.class);
            public final PBUInt32Field width = PBField.initUInt32(0);
            public final PBUInt32Field height = PBField.initUInt32(0);
            public final PBStringField pic_url = PBField.initString("");
            public final PBStringField layer_pic_url = PBField.initString("");
        };
        public CircleSearchExhibition$StVideo video = new MessageMicro<CircleSearchExhibition$StVideo>() { // from class: circlesearch.CircleSearchExhibition$StVideo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"fileSize", "duration", "width", "height"}, new Object[]{0, 0, 0, 0}, CircleSearchExhibition$StVideo.class);
            public final PBUInt32Field fileSize = PBField.initUInt32(0);
            public final PBUInt32Field duration = PBField.initUInt32(0);
            public final PBUInt32Field width = PBField.initUInt32(0);
            public final PBUInt32Field height = PBField.initUInt32(0);
        };
        public final PBStringField content = PBField.initString("");
        public final PBUInt32Field type = PBField.initUInt32(0);
        public CircleSearchExhibition$StVisitor visitor_info = new MessageMicro<CircleSearchExhibition$StVisitor>() { // from class: circlesearch.CircleSearchExhibition$StVisitor
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"view_count"}, new Object[]{0}, CircleSearchExhibition$StVisitor.class);
            public final PBUInt32Field view_count = PBField.initUInt32(0);
        };
        public final PBRepeatMessageField<CircleSearchExhibition$StImage> images = PBField.initRepeatMessage(CircleSearchExhibition$StImage.class);
    };
    public final PBStringField raw_data = PBField.initString("");
    public final PBStringField report_data = PBField.initString("");
}
