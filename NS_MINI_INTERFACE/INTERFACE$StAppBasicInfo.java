package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StAppBasicInfo extends MessageMicro<INTERFACE$StAppBasicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 58, 64, 74, 82, 90, 98, 106, 114, 120, 130, 136, 146, 154}, new String[]{"operationTags", "feiqiziduan", "usrFileSizeLimit", "preCacheList", "versionUpdateTime", "noNeedRealRecommend", "pluginInfo", "pkgType", "renderInfo", "qualificationInfo", "shareId", "via", "ideConfig", "resourcePreCacheList", "splashScreenAd", "splashScreenAdId", "template", "gamePublicationInfo", "gameCopyrightInfo"}, new Object[]{"", 0, 0L, null, 0, 0, null, 0, null, "", "", "", null, null, 0, "", 0, null, ""}, INTERFACE$StAppBasicInfo.class);
    public final PBStringField operationTags = PBField.initString("");
    public final PBInt32Field feiqiziduan = PBField.initInt32(0);
    public final PBInt64Field usrFileSizeLimit = PBField.initInt64(0);
    public final PBRepeatMessageField<INTERFACE$StAppPreCacheInfo> preCacheList = PBField.initRepeatMessage(INTERFACE$StAppPreCacheInfo.class);
    public final PBUInt32Field versionUpdateTime = PBField.initUInt32(0);
    public final PBInt32Field noNeedRealRecommend = PBField.initInt32(0);
    public INTERFACE$StPluginInfo pluginInfo = new INTERFACE$StPluginInfo();
    public final PBUInt32Field pkgType = PBField.initUInt32(0);
    public INTERFACE$StRenderInfo renderInfo = new INTERFACE$StRenderInfo();
    public final PBRepeatField<String> qualificationInfo = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField shareId = PBField.initString("");
    public final PBStringField via = PBField.initString("");
    public INTERFACE$StIdeConfig ideConfig = new INTERFACE$StIdeConfig();
    public final PBRepeatMessageField<INTERFACE$StResourcePreCacheInfo> resourcePreCacheList = PBField.initRepeatMessage(INTERFACE$StResourcePreCacheInfo.class);
    public final PBUInt32Field splashScreenAd = PBField.initUInt32(0);
    public final PBStringField splashScreenAdId = PBField.initString("");
    public final PBUInt32Field template = PBField.initUInt32(0);
    public INTERFACE$StGamePublicationInfo gamePublicationInfo = new INTERFACE$StGamePublicationInfo();
    public final PBStringField gameCopyrightInfo = PBField.initString("");
}
