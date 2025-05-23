package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StModuleInfo extends MessageMicro<INTERFACE$StModuleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 66, 74, 80, 90, 98, 106, 112, 122, 128, 138, 146, 154, 162}, new String[]{"title", "userAppList", "moduleType", "useOld", "jumpMoreApp", "isFinished", "appTotalNum", "desc", "ranks", "freshInternal", "titleIcon", "backgroundPic", "dittoDsl", "subTypes", "jumpLink", "PopupType", "extInfo", "expressService", "usageGuide", TtmlNode.TAG_LAYOUT}, new Object[]{"", null, 0, 0, null, 0, 0, "", null, 0, "", "", "", 0, "", 0, null, null, null, null}, INTERFACE$StModuleInfo.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
    public final PBInt32Field moduleType = PBField.initInt32(0);
    public final PBInt32Field useOld = PBField.initInt32(0);
    public INTERFACE$StUserAppInfo jumpMoreApp = new INTERFACE$StUserAppInfo();
    public final PBInt32Field isFinished = PBField.initInt32(0);
    public final PBInt32Field appTotalNum = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StFriendRanking> ranks = PBField.initRepeatMessage(INTERFACE$StFriendRanking.class);
    public final PBInt32Field freshInternal = PBField.initInt32(0);
    public final PBStringField titleIcon = PBField.initString("");
    public final PBStringField backgroundPic = PBField.initString("");
    public final PBStringField dittoDsl = PBField.initString("");
    public final PBInt32Field subTypes = PBField.initInt32(0);
    public final PBStringField jumpLink = PBField.initString("");
    public final PBEnumField PopupType = PBField.initEnum(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StExpressService expressService = new MessageMicro<INTERFACE$StExpressService>() { // from class: NS_MINI_INTERFACE.INTERFACE$StExpressService
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"topApps", "normalApps", "more", "normalAppRows"}, new Object[]{null, null, null, 0}, INTERFACE$StExpressService.class);
        public final PBRepeatMessageField<INTERFACE$StUserAppInfo> topApps = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
        public final PBRepeatMessageField<INTERFACE$StUserAppInfo> normalApps = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
        public INTERFACE$StUserAppInfo more = new INTERFACE$StUserAppInfo();
        public final PBInt32Field normalAppRows = PBField.initInt32(0);
    };
    public INTERFACE$StUsageGuideStyle usageGuide = new INTERFACE$StUsageGuideStyle();
    public INTERFACE$StModuleLayout layout = new INTERFACE$StModuleLayout();
}
