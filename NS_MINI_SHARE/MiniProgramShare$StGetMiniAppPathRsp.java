package NS_MINI_SHARE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniProgramShare$StGetMiniAppPathRsp extends MessageMicro<MiniProgramShare$StGetMiniAppPathRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "content"}, new Object[]{null, ""}, MiniProgramShare$StGetMiniAppPathRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField content = PBField.initString("");
}
