package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.ReportInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdData implements ISSOReqModel, ISSORspModel<AdData> {
    public final AdCard adCard;
    public final ReportInfo report;
    public final int uiType;

    public AdData(int i3, AdCard adCard, ReportInfo reportInfo) {
        this.uiType = i3;
        this.adCard = adCard;
        this.report = reportInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("ui_type", this.uiType);
        AdCard adCard = this.adCard;
        if (adCard != null) {
            eVar.v("ad_card", adCard.encode());
        }
        ReportInfo reportInfo = this.report;
        if (reportInfo != null) {
            eVar.v("report", reportInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final AdData decode(e eVar) {
        int k3 = eVar.k("ui_type", 0);
        e m3 = eVar.m("ad_card");
        AdCard decode = m3 != null ? new AdCard("", "", "", null, null, null, "").decode(m3) : null;
        e m16 = eVar.m("report");
        return new AdData(k3, decode, m16 != null ? new ReportInfo(m16.q("id", ""), m16.o("distribute_time", 0L), m16.q("user_id", ""), m16.q("content_id", ""), m16.q("business_scene", ""), m16.k("app_source", 0), m16.k("app_scene", 0), m16.q("ad_id", ""), m16.k("ad_type", 0), m16.k("ad_source", 0), m16.k("ad_channel", 0), m16.m("busi_ext"), m16.q("checksum", ""), m16.m("passing_backs"), m16.k("event", 0), m16.k("ui_type", 0)) : null);
    }
}
