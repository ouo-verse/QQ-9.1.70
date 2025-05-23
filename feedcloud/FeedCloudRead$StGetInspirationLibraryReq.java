package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetInspirationLibraryReq extends MessageMicro<FeedCloudRead$StGetInspirationLibraryReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"from", "isFirstPage"}, new Object[]{0, Boolean.FALSE}, FeedCloudRead$StGetInspirationLibraryReq.class);
    public final PBInt32Field from = PBField.initInt32(0);
    public final PBBoolField isFirstPage = PBField.initBool(false);
}
