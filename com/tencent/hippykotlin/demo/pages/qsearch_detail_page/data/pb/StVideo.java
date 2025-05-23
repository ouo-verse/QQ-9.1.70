package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StVideo implements ISSOReqModel, ISSORspModel<StVideo> {
    public final int duration;
    public final int fileSize;
    public int height;
    public final String playUrl;
    public int width;

    public StVideo(int i3, int i16, int i17, int i18, String str) {
        this.fileSize = i3;
        this.duration = i16;
        this.width = i17;
        this.height = i18;
        this.playUrl = str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("fileSize", this.fileSize);
        eVar.t("duration", this.duration);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("play_url", this.playUrl);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StVideo decode(e eVar) {
        return new StVideo(eVar.k("fileSize", 0), eVar.k("duration", 0), eVar.k("width", 0), eVar.k("height", 0), eVar.q("play_url", ""));
    }
}
