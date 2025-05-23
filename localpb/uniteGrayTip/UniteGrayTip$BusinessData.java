package localpb.uniteGrayTip;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc010001;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class UniteGrayTip$BusinessData extends MessageMicro<UniteGrayTip$BusinessData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66, 74, 82}, new String[]{"haveRead", QCircleLpReportDc010001.KEY_SUBTYPE, "masterUin", "extUin", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "editState", "editTime", "editMsgData", "caidanAnimUrl", "caidanAnimUrlMd5"}, new Object[]{0, 0, "", "", "", 0, 0L, "", "", ""}, UniteGrayTip$BusinessData.class);
    public final PBUInt32Field haveRead = PBField.initUInt32(0);
    public final PBUInt32Field subType = PBField.initUInt32(0);
    public final PBStringField masterUin = PBField.initString("");
    public final PBStringField extUin = PBField.initString("");
    public final PBStringField taskId = PBField.initString("");
    public final PBUInt32Field editState = PBField.initUInt32(0);
    public final PBUInt64Field editTime = PBField.initUInt64(0);
    public final PBStringField editMsgData = PBField.initString("");
    public final PBStringField caidanAnimUrl = PBField.initString("");
    public final PBStringField caidanAnimUrlMd5 = PBField.initString("");
}
