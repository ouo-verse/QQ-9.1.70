package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchJump implements ISSOReqModel, ISSORspModel<QSearchJump> {
    public final String extension;
    public final QSearchGuildJump guildJump;
    public final String jumpLink;
    public final int tabMask;
    public final int type;

    public QSearchJump(String str, int i3, int i16, QSearchGuildJump qSearchGuildJump, String str2) {
        this.jumpLink = str;
        this.type = i3;
        this.tabMask = i16;
        this.guildJump = qSearchGuildJump;
        this.extension = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("jump_link", this.jumpLink);
        eVar.t("type", this.type);
        eVar.t("tab_mask", this.tabMask);
        QSearchGuildJump qSearchGuildJump = this.guildJump;
        if (qSearchGuildJump != null) {
            eVar.v("guild_jump", qSearchGuildJump.encode());
        }
        eVar.v(MimeTypeParser.ATTR_EXTENSION, this.extension);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchJump decode(e eVar) {
        String q16 = eVar.q("jump_link", "");
        int k3 = eVar.k("type", 0);
        int k16 = eVar.k("tab_mask", 0);
        e m3 = eVar.m("guild_jump");
        return new QSearchJump(q16, k3, k16, m3 != null ? new QSearchGuildJump(m3.o("guild_id", 0L), m3.q("join_guild_sig", ""), m3.k("join_status", 0)) : null, eVar.q(MimeTypeParser.ATTR_EXTENSION, ""));
    }
}
