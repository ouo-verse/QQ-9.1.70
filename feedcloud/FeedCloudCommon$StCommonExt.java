package feedcloud;

import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudCommon$StCommonExt extends MessageMicro<FeedCloudCommon$StCommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{ThirdPartyMiniApiImpl.KEY_MAP_INFO, "attachInfo", "mapBytesInfo", "recomNeedInfo"}, new Object[]{null, "", null, null}, FeedCloudCommon$StCommonExt.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> mapInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> mapBytesInfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public FeedCloudCommon$RecomNeedInfo recomNeedInfo = new FeedCloudCommon$RecomNeedInfo();
}
