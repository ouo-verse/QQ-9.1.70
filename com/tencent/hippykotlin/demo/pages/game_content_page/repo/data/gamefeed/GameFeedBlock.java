package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameFeedBlock implements ISSOReqModel, ISSORspModel<GameFeedBlock> {
    public final StGetFeedListRsp baseFeedRsp;
    public final int source;
    public final int subSource;

    public GameFeedBlock(int i3, int i16, StGetFeedListRsp stGetFeedListRsp) {
        this.source = i3;
        this.subSource = i16;
        this.baseFeedRsp = stGetFeedListRsp;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("source", this.source);
        eVar.t("sub_source", this.subSource);
        StGetFeedListRsp stGetFeedListRsp = this.baseFeedRsp;
        if (stGetFeedListRsp != null) {
            eVar.v("base_feed_rsp", stGetFeedListRsp.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameFeedBlock decode(e eVar) {
        int k3 = eVar.k("source", 0);
        int k16 = eVar.k("sub_source", 0);
        e m3 = eVar.m("base_feed_rsp");
        return new GameFeedBlock(k3, k16, m3 != null ? new StGetFeedListRsp(null, 0, null, "", "", "", false, null).decode(m3) : null);
    }
}
