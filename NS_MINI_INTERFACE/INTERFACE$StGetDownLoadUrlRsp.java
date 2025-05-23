package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetDownLoadUrlRsp extends MessageMicro<INTERFACE$StGetDownLoadUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", CoverDBCacheData.URLS}, new Object[]{null, null}, INTERFACE$StGetDownLoadUrlRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StDownLoadUrl> urls = PBField.initRepeatMessage(INTERFACE$StDownLoadUrl.class);
}
