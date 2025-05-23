package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchVideo implements ISSOReqModel, ISSORspModel<QSearchVideo> {
    public final StFeed feed;
    public final QSearchJump jumpLink;
    public final String rawData;

    public QSearchVideo(StFeed stFeed, String str, QSearchJump qSearchJump) {
        this.feed = stFeed;
        this.rawData = str;
        this.jumpLink = qSearchJump;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        StFeed stFeed = this.feed;
        if (stFeed != null) {
            eVar.v("feed", stFeed.encode());
        }
        eVar.v("raw_data", this.rawData);
        QSearchJump qSearchJump = this.jumpLink;
        if (qSearchJump != null) {
            eVar.v("jump_link", qSearchJump.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QSearchVideo decode(e eVar) {
        e m3 = eVar.m("feed");
        QSearchJump qSearchJump = null;
        StFeed decode = m3 != null ? new StFeed().decode(m3) : null;
        String q16 = eVar.q("raw_data", "");
        e m16 = eVar.m("jump_link");
        if (m16 != null) {
            String q17 = m16.q("jump_link", "");
            int k3 = m16.k("type", 0);
            int k16 = m16.k("tab_mask", 0);
            e m17 = m16.m("guild_jump");
            qSearchJump = new QSearchJump(q17, k3, k16, m17 != null ? new QSearchGuildJump(m17.o("guild_id", 0L), m17.q("join_guild_sig", ""), m17.k("join_status", 0)) : null, m16.q(MimeTypeParser.ATTR_EXTENSION, ""));
        }
        return new QSearchVideo(decode, q16, qSearchJump);
    }
}
