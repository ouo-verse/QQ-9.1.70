package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class STORE_APP_CLIENT$StGetGuessYouLikeReq extends MessageMicro<STORE_APP_CLIENT$StGetGuessYouLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "count"}, new Object[]{null, 0}, STORE_APP_CLIENT$StGetGuessYouLikeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field count = PBField.initInt32(0);
}
