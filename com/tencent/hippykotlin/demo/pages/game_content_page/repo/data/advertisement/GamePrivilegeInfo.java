package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class GamePrivilegeInfo implements ISSOReqModel, ISSORspModel<GamePrivilegeInfo> {
    public final String appName;
    public final String appPrivilegesText;
    public final String appPrivilegesUrl;
    public final String developer;
    public final String privatePoliciesText;
    public final String privatePoliciesUrl;
    public final String version;

    public GamePrivilegeInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.developer = str;
        this.version = str2;
        this.privatePoliciesText = str3;
        this.privatePoliciesUrl = str4;
        this.appPrivilegesText = str5;
        this.appPrivilegesUrl = str6;
        this.appName = str7;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("developer", this.developer);
        eVar.v("version", this.version);
        eVar.v("private_policies_text", this.privatePoliciesText);
        eVar.v("private_policies_url", this.privatePoliciesUrl);
        eVar.v("app_privileges_text", this.appPrivilegesText);
        eVar.v("app_privileges_url", this.appPrivilegesUrl);
        eVar.v("app_name", this.appName);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GamePrivilegeInfo decode(e eVar) {
        return new GamePrivilegeInfo(eVar.q("developer", ""), eVar.q("version", ""), eVar.q("private_policies_text", ""), eVar.q("private_policies_url", ""), eVar.q("app_privileges_text", ""), eVar.q("app_privileges_url", ""), eVar.q("app_name", ""));
    }
}
