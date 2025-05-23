package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameBasicInfo implements ISSOReqModel, ISSORspModel<GameBasicInfo> {
    public final int appId;
    public final String appName;
    public final String channelId;
    public final String cover;
    public final String detailUrl;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114188msg;
    public final String tickets;

    public GameBasicInfo(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.appId = i3;
        this.appName = str;
        this.tickets = str2;
        this.f114188msg = str3;
        this.cover = str4;
        this.detailUrl = str5;
        this.channelId = str6;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("app_id", this.appId);
        eVar.v("app_name", this.appName);
        eVar.v("tickets", this.tickets);
        eVar.v("msg", this.f114188msg);
        eVar.v("cover", this.cover);
        eVar.v("detail_url", this.detailUrl);
        eVar.v("channel_id", this.channelId);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameBasicInfo decode(e eVar) {
        return new GameBasicInfo(eVar.k("app_id", 0), eVar.q("app_name", ""), eVar.q("tickets", ""), eVar.q("msg", ""), eVar.q("cover", ""), eVar.q("detail_url", ""), eVar.q("channel_id", ""));
    }
}
