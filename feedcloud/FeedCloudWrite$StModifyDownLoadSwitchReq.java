package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudWrite$StModifyDownLoadSwitchReq extends MessageMicro<FeedCloudWrite$StModifyDownLoadSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"feedID", "posterID", WadlProxyConsts.CREATE_TIME, "downLoadOper"}, new Object[]{"", "", 0L, 0}, FeedCloudWrite$StModifyDownLoadSwitchReq.class);
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField posterID = PBField.initString("");
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBUInt32Field downLoadOper = PBField.initUInt32(0);
}
