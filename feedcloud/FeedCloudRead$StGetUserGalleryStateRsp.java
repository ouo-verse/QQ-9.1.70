package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetUserGalleryStateRsp extends MessageMicro<FeedCloudRead$StGetUserGalleryStateRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"enableGallery"}, new Object[]{Boolean.FALSE}, FeedCloudRead$StGetUserGalleryStateRsp.class);
    public final PBBoolField enableGallery = PBField.initBool(false);
}
