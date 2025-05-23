package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StCheckFollowRsp extends MessageMicro<Follow$StCheckFollowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"star"}, new Object[]{null}, Follow$StCheckFollowRsp.class);
    public Follow$StStar star = new MessageMicro<Follow$StStar>() { // from class: NS_FOLLOW.Follow$StStar
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17}, new String[]{"star", "weight"}, new Object[]{"", Double.valueOf(0.0d)}, Follow$StStar.class);
        public final PBStringField star = PBField.initString("");
        public final PBDoubleField weight = PBField.initDouble(0.0d);
    };
}
