package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Follow$StStarList extends MessageMicro<Follow$StStarList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"stars"}, new Object[]{null}, Follow$StStarList.class);
    public final PBRepeatMessageField<Follow$StStar> stars = PBField.initRepeatMessage(Follow$StStar.class);
}
