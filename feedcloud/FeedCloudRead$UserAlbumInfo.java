package feedcloud;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$UserAlbumInfo extends MessageMicro<FeedCloudRead$UserAlbumInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<FeedCloudMeta$FeedAlbum> albums = PBField.initRepeatMessage(FeedCloudMeta$FeedAlbum.class);
    public final PBBoolField has_more = PBField.initBool(false);
    public final PBStringField load_more_attach_info = PBField.initString("");
    public final PBBoolField allow_create_album = PBField.initBool(false);

    static {
        String[] strArr = {"albums", PictureConst.KEY_HAS_MORE, "load_more_attach_info", "allow_create_album"};
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, strArr, new Object[]{null, bool, "", bool}, FeedCloudRead$UserAlbumInfo.class);
    }
}
