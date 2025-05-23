package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Like implements ISSOReqModel, ISSORspModel<Like> {
    public int count;
    public int status;

    public Like(int i3, int i16) {
        this.count = i3;
        this.status = i16;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Like decode(e eVar) {
        return new Like(eVar.k("count", 0), eVar.k("status", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("count", this.count);
        eVar.t("status", this.status);
        return eVar;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getStatus() {
        return this.status;
    }
}
