package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppFileMaterial$GetMaterialRelevantAppRsp extends MessageMicro<MiniAppFileMaterial$GetMaterialRelevantAppRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"title", "relevant_list", "hasMore", "extra"}, new Object[]{"", null, Boolean.FALSE, ""}, MiniAppFileMaterial$GetMaterialRelevantAppRsp.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<MiniAppFileMaterial$AppMaterialInfo> relevant_list = PBField.initRepeatMessage(MiniAppFileMaterial$AppMaterialInfo.class);
    public final PBBoolField hasMore = PBField.initBool(false);
    public final PBStringField extra = PBField.initString("");
}
