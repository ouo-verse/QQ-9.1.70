package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetStoryFeedListReq extends MessageMicro<CLIENT$StGetStoryFeedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"extInfo", "listType", "listNum", "uinTime"}, new Object[]{null, 0, 0, null}, CLIENT$StGetStoryFeedListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField listType = PBField.initEnum(0);
    public final PBUInt32Field listNum = PBField.initUInt32(0);
    public CLIENT$StUinTime uinTime = new CLIENT$StUinTime();
}
