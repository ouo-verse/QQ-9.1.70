package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class O3PostData {
    public String appId;
    public final String chatType;
    public String chatUin;
    public final String customScene;
    public String evilUin;
    public String grayId;
    public final long grayIdTime;
    public final String grayTipToken;
    public String groupCode;
    public String identifier;
    public boolean isFriend;
    public final String msgs;
    public final e postData;
    public String src;
    public final String token;
    public String uid;

    public O3PostData(e eVar) {
        this.postData = eVar;
        this.appId = eVar.p("appid");
        this.chatUin = eVar.p("chatuin");
        this.chatType = eVar.p("chattype");
        this.groupCode = eVar.p("groupcode");
        this.evilUin = eVar.p("eviluin");
        this.msgs = eVar.p("msgs");
        this.isFriend = eVar.j("buddyflag") == 1;
        this.token = eVar.q("qrt_token", "");
        this.identifier = eVar.p(IECDtReport.ACTION_IDENTIFIER);
        this.grayId = eVar.p("gray_tip_id");
        this.grayIdTime = eVar.o("gray_tip_time", 0L);
        this.uid = eVar.p("uid");
        this.src = eVar.q("src", "0");
        this.grayTipToken = eVar.p("gray_tip_token");
        this.customScene = eVar.q("customScene", "");
    }

    public final String toString() {
        return this.postData.toString();
    }
}
