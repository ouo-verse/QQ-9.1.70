package feedcloud;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StEShopPlatformInfo extends MessageMicro<FeedCloudMeta$StEShopPlatformInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"isBindedWithPlatform", "adID", WadlProxyConsts.CHANNEL, "contentExt"}, new Object[]{Boolean.FALSE, "", 0, ByteStringMicro.EMPTY}, FeedCloudMeta$StEShopPlatformInfo.class);
    public final PBBoolField isBindedWithPlatform = PBField.initBool(false);
    public final PBStringField adID = PBField.initString("");
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBBytesField contentExt = PBField.initBytes(ByteStringMicro.EMPTY);
}
