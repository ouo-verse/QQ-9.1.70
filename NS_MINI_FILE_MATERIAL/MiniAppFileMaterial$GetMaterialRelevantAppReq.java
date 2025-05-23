package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppFileMaterial$GetMaterialRelevantAppReq extends MessageMicro<MiniAppFileMaterial$GetMaterialRelevantAppReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{JobDbManager.COL_UP_MIME_TYPE, "extra"}, new Object[]{"", ""}, MiniAppFileMaterial$GetMaterialRelevantAppReq.class);
    public final PBStringField mime_type = PBField.initString("");
    public final PBStringField extra = PBField.initString("");
}
