package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StApiAppInfo extends MessageMicro<INTERFACE$StApiAppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 154, 162, 170, 176, 186, 192, 202, 210, 216, 226, 234, 242, 250, 258, 266, 272, FilterEnum.MIC_PTU_TRANS_XINXIAN, 290, 298, 306, 314, 322, MapItemKt.ITEM_AVATAR_MIN_WIDTH, 336, a.CTRL_INDEX, g.CTRL_INDEX, 362, 368, NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN, 386}, new String[]{"appId", "appName", "icon", "donwLoadUrl", "version", "desc", "pubAccts", "type", "baselibMiniVersion", "subPkgs", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "domain", "appType", "mDebug", "versionId", "apiRight", "dataCache", "mainExt", "devInfo", "extData", "extGameCenter", "isRecommend", "serviceCategory", "supportOffline", "appMode", "operInfo", "skipDomainCheck", "extInfo", "extendData", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "extConfig", "appNoCacheExt", "basicInfo", "tabIndex", "miniAppType", "pkgInfo", QCircleScheme.AttrDetail.VIDEO_INFO, "coverInfo", QZoneDTLoginReporter.SCHEMA, "loopIcons", "appJson", "isContainer", "auditState", "releaseState", "registrationInfo", "right_age", "right_age_notice_url", "binding_appid"}, new Object[]{"", "", "", "", "", "", null, 0, "", null, null, null, 0, null, "", null, null, null, null, "", null, 0, "", 0, null, null, 0, null, "", "", null, null, null, 0, 0, null, null, null, "", "", "", 0, 1, 0, null, 0, "", ""}, INTERFACE$StApiAppInfo.class);
    public final PBStringField appJson;
    public INTERFACE$StAppMode appMode;
    public INTERFACE$StAppFixInfoExt appNoCacheExt;
    public final PBEnumField auditState;
    public INTERFACE$StAppBasicInfo basicInfo;
    public final PBStringField binding_appid;
    public final PBRepeatMessageField<INTERFACE$StAppMediaInfo> coverInfo;
    public final PBRepeatMessageField<INTERFACE$StExtConfigInfo> extConfig;
    public COMM.StCommonExt extInfo;
    public final PBStringField extendData;
    public final PBInt32Field isContainer;
    public final PBRepeatField<String> loopIcons;
    public final PBEnumField miniAppType;
    public INTERFACE$StOperationInfo operInfo;
    public INTERFACE$StAppPkgInfo pkgInfo;
    public INTERFACE$StRegistrationInfo registrationInfo;
    public final PBUInt32Field releaseState;
    public final PBUInt32Field right_age;
    public final PBStringField right_age_notice_url;
    public final PBStringField schema;
    public final PBRepeatField<String> serviceCategory;
    public final PBInt32Field skipDomainCheck;
    public final PBInt32Field supportOffline;
    public final PBInt32Field tabIndex;
    public final PBStringField tags;
    public final PBRepeatMessageField<INTERFACE$StAppVideoInfo> videoInfo;
    public final PBStringField appId = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField donwLoadUrl = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StPublicAccount> pubAccts = PBField.initRepeatMessage(INTERFACE$StPublicAccount.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField baselibMiniVersion = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$StSubPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE$StSubPkgInfo.class);
    public INTERFACE$StFirstPage first = new INTERFACE$StFirstPage();
    public INTERFACE$StDomainConfig domain = new INTERFACE$StDomainConfig();
    public final PBUInt32Field appType = PBField.initUInt32(0);
    public INTERFACE$StMDebugInfo mDebug = new INTERFACE$StMDebugInfo();
    public final PBStringField versionId = PBField.initString("");
    public INTERFACE$StApiRightController apiRight = new INTERFACE$StApiRightController();
    public final PBRepeatMessageField<INTERFACE$StAppDataCache> dataCache = PBField.initRepeatMessage(INTERFACE$StAppDataCache.class);
    public INTERFACE$StMainPageExtInfo mainExt = new INTERFACE$StMainPageExtInfo();
    public INTERFACE$StDeveloperInfo devInfo = new INTERFACE$StDeveloperInfo();
    public final PBStringField extData = PBField.initString("");
    public INTERFACE$StGameCenterInfo extGameCenter = new MessageMicro<INTERFACE$StGameCenterInfo>() { // from class: NS_MINI_INTERFACE.INTERFACE$StGameCenterInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{VasProfileTemplatePreloadHelper.BACKGROUND}, new Object[]{""}, INTERFACE$StGameCenterInfo.class);

        /* renamed from: bg, reason: collision with root package name */
        public final PBStringField f24959bg = PBField.initString("");
    };
    public final PBInt32Field isRecommend = PBField.initInt32(0);

    /* JADX WARN: Type inference failed for: r2v15, types: [NS_MINI_INTERFACE.INTERFACE$StGameCenterInfo] */
    public INTERFACE$StApiAppInfo() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.serviceCategory = PBField.initRepeat(pBStringField);
        this.supportOffline = PBField.initInt32(0);
        this.appMode = new INTERFACE$StAppMode();
        this.operInfo = new INTERFACE$StOperationInfo();
        this.skipDomainCheck = PBField.initInt32(0);
        this.extInfo = new COMM.StCommonExt();
        this.extendData = PBField.initString("");
        this.tags = PBField.initString("");
        this.extConfig = PBField.initRepeatMessage(INTERFACE$StExtConfigInfo.class);
        this.appNoCacheExt = new INTERFACE$StAppFixInfoExt();
        this.basicInfo = new INTERFACE$StAppBasicInfo();
        this.tabIndex = PBField.initInt32(0);
        this.miniAppType = PBField.initEnum(0);
        this.pkgInfo = new INTERFACE$StAppPkgInfo();
        this.videoInfo = PBField.initRepeatMessage(INTERFACE$StAppVideoInfo.class);
        this.coverInfo = PBField.initRepeatMessage(INTERFACE$StAppMediaInfo.class);
        this.schema = PBField.initString("");
        this.loopIcons = PBField.initRepeat(pBStringField);
        this.appJson = PBField.initString("");
        this.isContainer = PBField.initInt32(0);
        this.auditState = PBField.initEnum(1);
        this.releaseState = PBField.initUInt32(0);
        this.registrationInfo = new INTERFACE$StRegistrationInfo();
        this.right_age = PBField.initUInt32(0);
        this.right_age_notice_url = PBField.initString("");
        this.binding_appid = PBField.initString("");
    }
}
