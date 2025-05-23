package NS_MINI_INTERFACE;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StDownLoadUrl extends MessageMicro<INTERFACE$StDownLoadUrl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{QCircleSchemeAttr.Detail.FEED_VIDEO_ID, "url"}, new Object[]{"", ""}, INTERFACE$StDownLoadUrl.class);
    public final PBStringField fileid = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
