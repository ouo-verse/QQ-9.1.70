package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StGetUserInteractiveStorageRsp extends MessageMicro<CloudStorage$StGetUserInteractiveStorageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"ext", MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, "iv"}, new Object[]{null, "", ""}, CloudStorage$StGetUserInteractiveStorageRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField encryptedData = PBField.initString("");

    /* renamed from: iv, reason: collision with root package name */
    public final PBStringField f24953iv = PBField.initString("");
}
