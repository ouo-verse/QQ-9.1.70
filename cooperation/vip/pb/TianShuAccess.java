package cooperation.vip.pb;

import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TianShuAccess {
    public static final int AdTypeComm = 105;
    public static final int AdTypePush = 103;
    public static final int AdTypeQboss = 101;
    public static final int AdTypeRed = 102;
    public static final int AdTypeUnknown = 0;
    public static final int AdTypeWx = 104;
    public static final int MTCare = 4;
    public static final int MTNormal = 1;
    public static final int MTS_FRESH = 3;
    public static final int MTS_FRONT = 4;
    public static final int MTS_LOGIN = 1;
    public static final int MTS_PUSH = 99;
    public static final int MTS_RECONN = 2;
    public static final int MTS_UNKNOWN = 0;
    public static final int MTTeenager = 3;
    public static final int MTTiyan = 2;
    public static final int MTUnknown = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AdItem extends MessageMicro<AdItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42, 82, 90, 98, 106, 114, 122, 162}, new String[]{"iAdId", MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, "title", "desc", "jumpurl", TangramAppConstants.ICON_URL, "lstPic", "argList", "ext_info"}, new Object[]{0, "", "", "", "", "", "", null, ""}, AdItem.class);
        public final PBUInt32Field iAdId = PBField.initUInt32(0);
        public final PBStringField traceinfo = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBStringField desc = PBField.initString("");
        public final PBStringField jumpurl = PBField.initString("");
        public final PBStringField iconurl = PBField.initString("");
        public final PBRepeatField<String> lstPic = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBRepeatMessageField<MapEntry> argList = PBField.initRepeatMessage(MapEntry.class);
        public final PBStringField ext_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AdPlacementInfo extends MessageMicro<AdPlacementInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"type", "lst", "next_query_ts", "extInfo", "ctlInfo"}, new Object[]{0, null, 0, "", ""}, AdPlacementInfo.class);
        public final PBInt32Field type = PBField.initInt32(0);
        public final PBRepeatMessageField<AdItem> lst = PBField.initRepeatMessage(AdItem.class);
        public final PBUInt32Field next_query_ts = PBField.initUInt32(0);
        public final PBStringField extInfo = PBField.initString("");
        public final PBStringField ctlInfo = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class AdPosItem extends MessageMicro<AdPosItem> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 114}, new String[]{"posId", "nNeedCnt", "extra_info"}, new Object[]{0, 0, null}, AdPosItem.class);
        public final PBUInt32Field posId = PBField.initUInt32(0);
        public final PBUInt32Field nNeedCnt = PBField.initUInt32(0);
        public final PBRepeatMessageField<MapEntry> extra_info = PBField.initRepeatMessage(MapEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ClientStatus extends MessageMicro<ClientStatus> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"stMsgTabStatus"}, new Object[]{null}, ClientStatus.class);
        public MsgTabStatus stMsgTabStatus = new MsgTabStatus();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class CommInfo extends MessageMicro<CommInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 26, 34, 40, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 128, 162, 170, 192, 216}, new String[]{"lUin", "strDeviceInfo", "stGps", "iBid", "strUserIp", "strApp", "strOs", "strVersion", "strOpenId", "strCityCode", "iNetWorkEnv", "strQua", "strQimei", "strUid", "bLocationAuthorization", "strExpSeq", "traceId", "mode", "a11yMode"}, new Object[]{0L, "", null, 0, "", "", "", "", "", "", 0, "", "", "", Boolean.FALSE, "", "", 0, 0}, CommInfo.class);
        public final PBUInt64Field lUin = PBField.initUInt64(0);
        public final PBStringField strDeviceInfo = PBField.initString("");
        public Gps stGps = new Gps();
        public final PBUInt32Field iBid = PBField.initUInt32(0);
        public final PBStringField strUserIp = PBField.initString("");
        public final PBStringField strApp = PBField.initString("");
        public final PBStringField strOs = PBField.initString("");
        public final PBStringField strVersion = PBField.initString("");
        public final PBStringField strOpenId = PBField.initString("");
        public final PBStringField strCityCode = PBField.initString("");
        public final PBInt32Field iNetWorkEnv = PBField.initInt32(0);
        public final PBStringField strQua = PBField.initString("");
        public final PBStringField strQimei = PBField.initString("");
        public final PBStringField strUid = PBField.initString("");
        public final PBBoolField bLocationAuthorization = PBField.initBool(false);
        public final PBStringField strExpSeq = PBField.initString("");
        public final PBStringField traceId = PBField.initString("");
        public final PBInt32Field mode = PBField.initInt32(0);
        public final PBUInt32Field a11yMode = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class GetAdsEntry extends MessageMicro<GetAdsEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0L, ByteStringMicro.EMPTY}, GetAdsEntry.class);
        public final PBUInt64Field key = PBField.initUInt64(0);
        public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class GetAdsReq extends MessageMicro<GetAdsReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"stComminfo", "lstPos", "mapPosTran", "stClientStatus"}, new Object[]{null, null, null, null}, GetAdsReq.class);
        public CommInfo stComminfo = new CommInfo();
        public final PBRepeatMessageField<AdPosItem> lstPos = PBField.initRepeatMessage(AdPosItem.class);
        public final PBRepeatMessageField<GetAdsEntry> mapPosTran = PBField.initRepeatMessage(GetAdsEntry.class);
        public ClientStatus stClientStatus = new ClientStatus();
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class GetAdsRsp extends MessageMicro<GetAdsRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"code", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "mapAds", "rspExtInfo", "ctrlInfo", "mapPosTran"}, new Object[]{0, "", null, "", null, null}, GetAdsRsp.class);
        public final PBInt32Field code = PBField.initInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBRepeatMessageField<RspEntry> mapAds = PBField.initRepeatMessage(RspEntry.class);
        public final PBStringField rspExtInfo = PBField.initString("");
        public final PBRepeatMessageField<MapEntry> ctrlInfo = PBField.initRepeatMessage(MapEntry.class);
        public final PBRepeatMessageField<GetAdsEntry> mapPosTran = PBField.initRepeatMessage(GetAdsEntry.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class Gps extends MessageMicro<Gps> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lon", "accuracy"}, new Object[]{0, 0, 0}, Gps.class);
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lon = PBField.initInt32(0);
        public final PBInt32Field accuracy = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class MapEntry extends MessageMicro<MapEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, MapEntry.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class MsgTabShowingAd extends MessageMicro<MsgTabShowingAd> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ad_id", "first_show_ts"}, new Object[]{0L, 0L}, MsgTabShowingAd.class);
        public final PBUInt64Field ad_id = PBField.initUInt64(0);
        public final PBInt64Field first_show_ts = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class MsgTabStatus extends MessageMicro<MsgTabStatus> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scene", "IsContainerShowing", "showing_ads"}, new Object[]{0, Boolean.FALSE, null}, MsgTabStatus.class);
        public final PBEnumField scene = PBField.initEnum(0);
        public final PBBoolField IsContainerShowing = PBField.initBool(false);
        public final PBRepeatMessageField<MsgTabShowingAd> showing_ads = PBField.initRepeatMessage(MsgTabShowingAd.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class RspEntry extends MessageMicro<RspEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0, null}, RspEntry.class);
        public final PBUInt32Field key = PBField.initUInt32(0);
        public AdPlacementInfo value = new AdPlacementInfo();
    }

    TianShuAccess() {
    }
}
