package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusContentDetail implements ISSOReqModel, ISSORspModel<QPlusContentDetail> {
    public final String contentId;
    public final int contentType;
    public final String creatorId;
    public final String creatorNick;
    public final String date;
    public final String icon;
    public final String title;

    public QPlusContentDetail(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.contentType = i3;
        this.contentId = str;
        this.title = str2;
        this.icon = str3;
        this.creatorId = str4;
        this.creatorNick = str5;
        this.date = str6;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("content_type", this.contentType);
        eVar.v("content_id", this.contentId);
        eVar.v("title", this.title);
        eVar.v("icon", this.icon);
        eVar.v("creator_id", this.creatorId);
        eVar.v("creator_nick", this.creatorNick);
        eVar.v("date", this.date);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusContentDetail decode(e eVar) {
        return new QPlusContentDetail(eVar.k("content_type", 0), eVar.q("content_id", ""), eVar.q("title", ""), eVar.q("icon", ""), eVar.q("creator_id", ""), eVar.q("creator_nick", ""), eVar.q("date", ""));
    }
}
