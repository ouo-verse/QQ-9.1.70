package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.feedcloud;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class StUser implements ISSOReqModel, ISSORspModel<StUser> {
    public final long birthday;
    public final int blackState;
    public final String busiData;
    public final String busiReport;
    public final String certificationDesc;
    public final String company;
    public final int constellation;
    public final String desc;
    public final int descType;
    public final String euid;
    public final long fansCount;
    public final long followCount;
    public final int followState;
    public final int frdState;
    public final long fuelCount;

    /* renamed from: id, reason: collision with root package name */
    public final String f114190id;
    public final boolean isUserInLivingStatus;
    public final String jumpUrl;
    public final int label;
    public final String location;
    public final String locationCode;
    public final String loginIpLocation;
    public final int newAddedFansCount;
    public final String nick;
    public final String rawNick;
    public final int relationState;
    public final String school;
    public final int sex;
    public final String thirdId;
    public final int type;
    public final long visitorCount;

    public StUser(String str, String str2, String str3, int i3, int i16, int i17, long j3, String str4, String str5, String str6, int i18, int i19, int i26, int i27, String str7, String str8, String str9, String str10, String str11, int i28, boolean z16, String str12, String str13, int i29, long j16, long j17, long j18, long j19, int i36, String str14, String str15) {
        this.f114190id = str;
        this.nick = str2;
        this.desc = str3;
        this.followState = i3;
        this.type = i16;
        this.sex = i17;
        this.birthday = j3;
        this.school = str4;
        this.location = str5;
        this.busiData = str6;
        this.frdState = i18;
        this.relationState = i19;
        this.blackState = i26;
        this.constellation = i27;
        this.jumpUrl = str7;
        this.locationCode = str8;
        this.thirdId = str9;
        this.company = str10;
        this.certificationDesc = str11;
        this.descType = i28;
        this.isUserInLivingStatus = z16;
        this.rawNick = str12;
        this.busiReport = str13;
        this.label = i29;
        this.followCount = j16;
        this.fansCount = j17;
        this.fuelCount = j18;
        this.visitorCount = j19;
        this.newAddedFansCount = i36;
        this.euid = str14;
        this.loginIpLocation = str15;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114190id);
        eVar.v("nick", this.nick);
        eVar.v("desc", this.desc);
        eVar.t("followState", this.followState);
        eVar.t("type", this.type);
        eVar.t("sex", this.sex);
        eVar.u("birthday", this.birthday);
        eVar.v("school", this.school);
        eVar.v("location", this.location);
        eVar.v(MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, this.busiData);
        eVar.t("frdState", this.frdState);
        eVar.t("relationState", this.relationState);
        eVar.t("blackState", this.blackState);
        eVar.t(LpReport_UserInfo_dc02148.CONSTELLATION, this.constellation);
        eVar.v(WadlProxyConsts.KEY_JUMP_URL, this.jumpUrl);
        eVar.v("locationCode", this.locationCode);
        eVar.v("thirdId", this.thirdId);
        eVar.v(IProfileProtocolConst.KEY_COMPANY, this.company);
        eVar.v("certificationDesc", this.certificationDesc);
        eVar.t("descType", this.descType);
        eVar.w("isUserInLivingStatus", this.isUserInLivingStatus);
        eVar.v("rawNick", this.rawNick);
        eVar.v("busiReport", this.busiReport);
        eVar.t("label", this.label);
        eVar.u("followCount", this.followCount);
        eVar.u("fansCount", this.fansCount);
        eVar.u("fuelCount", this.fuelCount);
        eVar.u("visitorCount", this.visitorCount);
        eVar.t("newAddedFansCount", this.newAddedFansCount);
        eVar.v(QCircleSchemeAttr.MainPage.EUID, this.euid);
        eVar.v("login_ip_location", this.loginIpLocation);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StUser decode(e eVar) {
        return new StUser(eVar.q("id", ""), eVar.q("nick", ""), eVar.q("desc", ""), eVar.k("followState", 0), eVar.k("type", 0), eVar.k("sex", 0), eVar.o("birthday", 0L), eVar.q("school", ""), eVar.q("location", ""), eVar.q(MessageForQCircleFeed.MSG_QCIRCLE_FEED_LEY_BUSI_DATA, ""), eVar.k("frdState", 0), eVar.k("relationState", 0), eVar.k("blackState", 0), eVar.k(LpReport_UserInfo_dc02148.CONSTELLATION, 0), eVar.q(WadlProxyConsts.KEY_JUMP_URL, ""), eVar.q("locationCode", ""), eVar.q("thirdId", ""), eVar.q(IProfileProtocolConst.KEY_COMPANY, ""), eVar.q("certificationDesc", ""), eVar.k("descType", 0), eVar.g("isUserInLivingStatus", false), eVar.q("rawNick", ""), eVar.q("busiReport", ""), eVar.k("label", 0), eVar.o("followCount", 0L), eVar.o("fansCount", 0L), eVar.o("fuelCount", 0L), eVar.o("visitorCount", 0L), eVar.k("newAddedFansCount", 0), eVar.q(QCircleSchemeAttr.MainPage.EUID, ""), eVar.q("login_ip_location", ""));
    }
}
