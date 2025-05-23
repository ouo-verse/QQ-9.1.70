package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$GetUserAlbumListRsp extends MessageMicro<FeedCloudRead$GetUserAlbumListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "albums", PictureConst.KEY_HAS_MORE, "attach_info"}, new Object[]{null, null, Boolean.FALSE, ""}, FeedCloudRead$GetUserAlbumListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<FeedCloudMeta$FeedAlbum> albums = PBField.initRepeatMessage(FeedCloudMeta$FeedAlbum.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField attach_info = PBField.initString("");
}
