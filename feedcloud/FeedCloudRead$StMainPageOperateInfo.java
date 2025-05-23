package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudRead$StMainPageOperateInfo extends MessageMicro<FeedCloudRead$StMainPageOperateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"name", "icon", WadlProxyConsts.KEY_JUMP_URL, "desc", "type"}, new Object[]{"", null, "", "", 0}, FeedCloudRead$StMainPageOperateInfo.class);
    public final PBStringField name = PBField.initString("");
    public FeedCloudMeta$StImage icon = new FeedCloudMeta$StImage();
    public final PBStringField jumpUrl = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
}
