package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StExposeStoryReq extends MessageMicro<CLIENT$StExposeStoryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", "feedPosterUin", "feedId"}, new Object[]{null, "", ""}, CLIENT$StExposeStoryReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField feedPosterUin = PBField.initString("");
    public final PBStringField feedId = PBField.initString("");
}
