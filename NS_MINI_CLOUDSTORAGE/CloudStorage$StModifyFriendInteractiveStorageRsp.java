package NS_MINI_CLOUDSTORAGE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CloudStorage$StModifyFriendInteractiveStorageRsp extends MessageMicro<CloudStorage$StModifyFriendInteractiveStorageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext", "details"}, new Object[]{null, ""}, CloudStorage$StModifyFriendInteractiveStorageRsp.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField details = PBField.initString("");
}
