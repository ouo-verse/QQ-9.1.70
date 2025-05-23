package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.gamefeed;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Share implements ISSOReqModel, ISSORspModel<Share> {
    public int count;

    public Share(int i3) {
        this.count = i3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Share decode(e eVar) {
        return new Share(eVar.k("count", 0));
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("count", this.count);
        return eVar;
    }

    public final int getCount() {
        return this.count;
    }
}
