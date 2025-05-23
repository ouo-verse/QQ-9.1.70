package feedcloud;

import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.fe.a;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.view.FilterEnum;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FeedCloudMeta$StUser extends MessageMicro<FeedCloudMeta$StUser> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field blackState;
    public final PBBytesField busiData;
    public final PBBytesField busiReport;
    public final PBStringField certificationDesc;
    public final PBStringField company;
    public final PBInt32Field constellation;
    public final PBUInt32Field descType;
    public final PBStringField euid;
    public final PBUInt64Field fansCount;
    public final PBUInt64Field followCount;
    public final PBUInt32Field frdState;
    public final PBUInt32Field friendType;
    public final PBUInt64Field fuelCount;
    public FeedCloudMeta$StGuildStateInfo guild_state;
    public FeedCloudMeta$StIconDecorate iconDecorate;
    public final PBBoolField isUserInLivingStatus;
    public final PBBoolField is_e_da_xia;
    public final PBStringField jumpUrl;
    public final PBUInt32Field label;
    public final PBUInt64Field level_benefit;
    public final PBStringField level_benefit_icon;
    public final PBStringField locationCode;
    public final PBStringField login_ip_location;
    public final PBStringField mcn_name;
    public FeedCloudMeta$StTagMedalInfo medal;
    public final PBUInt32Field newAddedFansCount;
    public final PBBytesField qq_vip;
    public final PBStringField rawNick;
    public final PBUInt32Field relationState;
    public final PBUInt64Field rocketCount;
    public final PBStringField thirdId;
    public final PBUInt64Field visitorCount;

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f398463id = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public FeedCloudMeta$StIconInfo icon = new FeedCloudMeta$StIconInfo();
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field followState = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBUInt64Field birthday = PBField.initUInt64(0);
    public final PBStringField school = PBField.initString("");
    public final PBStringField location = PBField.initString("");

    static {
        int[] iArr = {10, 18, 26, 34, 40, 48, 56, 64, 74, 90, 98, 104, 112, 120, 130, 136, 146, 154, 162, 170, 178, 184, 192, 202, 210, 218, 224, 232, 240, 248, 256, 264, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298, 306, 312, 322, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 336, a.CTRL_INDEX};
        String[] strArr = {"id", "nick", "icon", "desc", "followState", "type", "sex", "birthday", "school", "location", MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, "frdState", "relationState", "blackState", "medal", LpReport_UserInfo_dc02148.CONSTELLATION, WadlProxyConsts.KEY_JUMP_URL, "locationCode", "thirdId", IProfileProtocolConst.KEY_COMPANY, "certificationDesc", "descType", "isUserInLivingStatus", "rawNick", "iconDecorate", "busiReport", "label", "followCount", "fansCount", "fuelCount", "visitorCount", "newAddedFansCount", QCircleSchemeAttr.MainPage.EUID, "guild_state", "login_ip_location", QQPermissionConstants.Business.SCENE.QQ_VIP, "mcn_name", "level_benefit", "level_benefit_icon", "friendType", "is_e_da_xia", "rocketCount"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", "", null, "", 0, 0, 0, 0L, "", "", byteStringMicro, 0, 0, 0, null, 0, "", "", "", "", "", 0, bool, "", null, byteStringMicro, 0, 0L, 0L, 0L, 0L, 0, "", null, "", byteStringMicro, "", 0L, "", 0, bool, 0L}, FeedCloudMeta$StUser.class);
    }

    public FeedCloudMeta$StUser() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.busiData = PBField.initBytes(byteStringMicro);
        this.frdState = PBField.initUInt32(0);
        this.relationState = PBField.initUInt32(0);
        this.blackState = PBField.initUInt32(0);
        this.medal = new FeedCloudMeta$StTagMedalInfo();
        this.constellation = PBField.initInt32(0);
        this.jumpUrl = PBField.initString("");
        this.locationCode = PBField.initString("");
        this.thirdId = PBField.initString("");
        this.company = PBField.initString("");
        this.certificationDesc = PBField.initString("");
        this.descType = PBField.initUInt32(0);
        this.isUserInLivingStatus = PBField.initBool(false);
        this.rawNick = PBField.initString("");
        this.iconDecorate = new FeedCloudMeta$StIconDecorate();
        this.busiReport = PBField.initBytes(byteStringMicro);
        this.label = PBField.initUInt32(0);
        this.followCount = PBField.initUInt64(0L);
        this.fansCount = PBField.initUInt64(0L);
        this.fuelCount = PBField.initUInt64(0L);
        this.visitorCount = PBField.initUInt64(0L);
        this.newAddedFansCount = PBField.initUInt32(0);
        this.euid = PBField.initString("");
        this.guild_state = new FeedCloudMeta$StGuildStateInfo();
        this.login_ip_location = PBField.initString("");
        this.qq_vip = PBField.initBytes(byteStringMicro);
        this.mcn_name = PBField.initString("");
        this.level_benefit = PBField.initUInt64(0L);
        this.level_benefit_icon = PBField.initString("");
        this.friendType = PBField.initUInt32(0);
        this.is_e_da_xia = PBField.initBool(false);
        this.rocketCount = PBField.initUInt64(0L);
    }
}
