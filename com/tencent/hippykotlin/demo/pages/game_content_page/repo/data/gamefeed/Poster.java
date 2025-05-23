package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class Poster implements ISSOReqModel, ISSORspModel<Poster> {
    public final String nick;

    public Poster(String str) {
        this.nick = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Poster decode(e eVar) {
        return new Poster(eVar.q("nick", ""));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("nick", this.nick);
        return eVar;
    }
}
