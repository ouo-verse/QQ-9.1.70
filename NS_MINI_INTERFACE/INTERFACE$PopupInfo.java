package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes.dex */
public final class INTERFACE$PopupInfo extends MessageMicro<INTERFACE$PopupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 50, 58}, new String[]{"appid", "popupType", "title", "popupContent", "enableGame", "extInfo", AppDownloadCallback.BUTTON_TXT}, new Object[]{"", 0L, "", "", Boolean.FALSE, null, ""}, INTERFACE$PopupInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt64Field popupType = PBField.initInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField popupContent = PBField.initString("");
    public final PBBoolField enableGame = PBField.initBool(false);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField button_txt = PBField.initString("");
}
