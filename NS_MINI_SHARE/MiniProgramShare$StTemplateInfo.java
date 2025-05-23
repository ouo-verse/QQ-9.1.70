package NS_MINI_SHARE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class MiniProgramShare$StTemplateInfo extends MessageMicro<MiniProgramShare$StTemplateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"templateId", "templateData"}, new Object[]{"", ""}, MiniProgramShare$StTemplateInfo.class);
    public final PBStringField templateId = PBField.initString("");
    public final PBStringField templateData = PBField.initString("");
}
