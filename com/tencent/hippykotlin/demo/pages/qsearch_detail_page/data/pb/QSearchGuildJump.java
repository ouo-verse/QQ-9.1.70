package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchGuildJump implements ISSOReqModel, ISSORspModel<QSearchGuildJump> {
    public final long guildId;
    public final String joinGuildSig;
    public int joinStatus;

    public QSearchGuildJump(long j3, String str, int i3) {
        this.guildId = j3;
        this.joinGuildSig = str;
        this.joinStatus = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.u("guild_id", this.guildId);
        eVar.v("join_guild_sig", this.joinGuildSig);
        eVar.t("join_status", this.joinStatus);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchGuildJump decode(e eVar) {
        return new QSearchGuildJump(eVar.o("guild_id", 0L), eVar.q("join_guild_sig", ""), eVar.k("join_status", 0));
    }
}
