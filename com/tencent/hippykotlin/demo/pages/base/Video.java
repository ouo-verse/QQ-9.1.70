package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Video implements ISSOReqModel, ISSORspModel<Video> {
    public final int duration;
    public final int fileSize;
    public final int height;
    public final int width;

    public /* synthetic */ Video(int i3, int i16, int i17) {
        this(0, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? 0 : i16, 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.t("file_size", this.fileSize);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.t("duration", this.duration);
        return eVar;
    }

    public Video(int i3, int i16, int i17, int i18) {
        this.fileSize = i3;
        this.width = i16;
        this.height = i17;
        this.duration = i18;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final Video decode(e eVar) {
        return new Video(eVar.k("file_size", 0), eVar.k("width", 0), eVar.k("height", 0), eVar.k("duration", 0));
    }
}
