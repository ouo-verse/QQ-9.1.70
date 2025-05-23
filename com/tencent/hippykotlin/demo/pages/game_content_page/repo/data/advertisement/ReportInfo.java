package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ReportInfo implements ISSOReqModel, ISSORspModel<ReportInfo> {
    public final int adChannel;
    public final String adId;
    public final int adSource;
    public final int adType;
    public final int appScene;
    public final int appSource;
    public final e busiExt;
    public final String businessScene;
    public final String checksum;
    public final String contentId;
    public final long distributeTime;
    public final int event;

    /* renamed from: id, reason: collision with root package name */
    public final String f114189id;
    public final e passingBacks;
    public final int uiType;
    public final String userId;

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114189id);
        eVar.u("distribute_time", this.distributeTime);
        eVar.v("user_id", this.userId);
        eVar.v("content_id", this.contentId);
        eVar.v("business_scene", this.businessScene);
        eVar.t("app_source", this.appSource);
        eVar.t("app_scene", this.appScene);
        eVar.v("ad_id", this.adId);
        eVar.t("ad_type", this.adType);
        eVar.t("ad_source", this.adSource);
        eVar.t("ad_channel", this.adChannel);
        eVar.v("busi_ext", String.valueOf(this.busiExt));
        eVar.v("checksum", this.checksum);
        eVar.v("passing_backs", String.valueOf(this.passingBacks));
        eVar.t("event", this.event);
        eVar.t("ui_type", this.uiType);
        return eVar;
    }

    public ReportInfo(String str, long j3, String str2, String str3, String str4, int i3, int i16, String str5, int i17, int i18, int i19, e eVar, String str6, e eVar2, int i26, int i27) {
        this.f114189id = str;
        this.distributeTime = j3;
        this.userId = str2;
        this.contentId = str3;
        this.businessScene = str4;
        this.appSource = i3;
        this.appScene = i16;
        this.adId = str5;
        this.adType = i17;
        this.adSource = i18;
        this.adChannel = i19;
        this.busiExt = eVar;
        this.checksum = str6;
        this.passingBacks = eVar2;
        this.event = i26;
        this.uiType = i27;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final ReportInfo decode(e eVar) {
        return new ReportInfo(eVar.q("id", ""), eVar.o("distribute_time", 0L), eVar.q("user_id", ""), eVar.q("content_id", ""), eVar.q("business_scene", ""), eVar.k("app_source", 0), eVar.k("app_scene", 0), eVar.q("ad_id", ""), eVar.k("ad_type", 0), eVar.k("ad_source", 0), eVar.k("ad_channel", 0), eVar.m("busi_ext"), eVar.q("checksum", ""), eVar.m("passing_backs"), eVar.k("event", 0), eVar.k("ui_type", 0));
    }
}
