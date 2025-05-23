package NS_STORE_APP_CLIENT;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MiniAppStore$StGetFirstPageByTypeReq extends MessageMicro<MiniAppStore$StGetFirstPageByTypeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "uiPageType"}, new Object[]{null, 0}, MiniAppStore$StGetFirstPageByTypeReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field uiPageType = PBField.initUInt32(0);
}
