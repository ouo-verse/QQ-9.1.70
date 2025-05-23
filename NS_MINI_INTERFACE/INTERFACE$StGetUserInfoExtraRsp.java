package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserInfoExtraRsp extends MessageMicro<INTERFACE$StGetUserInfoExtraRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv"}, new Object[]{null, "", ""}, INTERFACE$StGetUserInfoExtraRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24963iv = PBField.initString("");
}
