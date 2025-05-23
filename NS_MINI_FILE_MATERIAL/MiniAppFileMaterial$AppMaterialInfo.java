package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MiniAppFileMaterial$AppMaterialInfo extends MessageMicro<MiniAppFileMaterial$AppMaterialInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"appid", "name", "icon", "desc", "path", TPReportKeys.PlayerStep.PLAYER_CDN_TYPE}, new Object[]{"", "", "", "", "", ""}, MiniAppFileMaterial$AppMaterialInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField path = PBField.initString("");

    /* renamed from: vt, reason: collision with root package name */
    public final PBStringField f24954vt = PBField.initString("");
}
