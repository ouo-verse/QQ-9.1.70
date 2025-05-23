package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetUserNewestStoryReq extends MessageMicro<CLIENT$StGetUserNewestStoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "vecUinTime", "fromScene"}, new Object[]{null, null, 0}, CLIENT$StGetUserNewestStoryReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CLIENT$StUinTime> vecUinTime = PBField.initRepeatMessage(CLIENT$StUinTime.class);
    public final PBUInt32Field fromScene = PBField.initUInt32(0);
}
