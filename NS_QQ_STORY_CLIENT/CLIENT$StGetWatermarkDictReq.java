package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CLIENT$StGetWatermarkDictReq extends MessageMicro<CLIENT$StGetWatermarkDictReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBDoubleField fLat = PBField.initDouble(0.0d);
    public final PBDoubleField fLon = PBField.initDouble(0.0d);
    public final PBStringField clientIP = PBField.initString("");

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17, 25, 34}, new String[]{"extInfo", "fLat", "fLon", "clientIP"}, new Object[]{null, valueOf, valueOf, ""}, CLIENT$StGetWatermarkDictReq.class);
    }
}
