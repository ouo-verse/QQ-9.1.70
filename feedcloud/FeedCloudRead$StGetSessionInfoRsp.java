package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudRead$StGetSessionInfoRsp extends MessageMicro<FeedCloudRead$StGetSessionInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field expireTime;
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field sessionType;
    public final PBBytesField sessonID;
    public final PBBytesField subSessonID;
    public final PBBytesField transInfo;

    static {
        String[] strArr = {"extInfo", "sessonID", "subSessonID", "transInfo", "expireTime", ShortVideoConstants.PARAM_KEY_SESSION_TYPE};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, strArr, new Object[]{null, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, FeedCloudRead$StGetSessionInfoRsp.class);
    }

    public FeedCloudRead$StGetSessionInfoRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.sessonID = PBField.initBytes(byteStringMicro);
        this.subSessonID = PBField.initBytes(byteStringMicro);
        this.transInfo = PBField.initBytes(byteStringMicro);
        this.expireTime = PBField.initUInt32(0);
        this.sessionType = PBField.initUInt32(0);
    }
}
