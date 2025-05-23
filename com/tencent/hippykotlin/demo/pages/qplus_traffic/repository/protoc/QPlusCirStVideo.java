package com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* loaded from: classes31.dex */
public final class QPlusCirStVideo implements ISSOReqModel, ISSORspModel<QPlusCirStVideo> {
    public final int duration;
    public final String fileId;
    public final int fileSize;
    public final int height;
    public final String playUrl;
    public final int width;

    public QPlusCirStVideo(String str, int i3, int i16, int i17, int i18, String str2) {
        this.fileId = str;
        this.fileSize = i3;
        this.duration = i16;
        this.width = i17;
        this.height = i18;
        this.playUrl = str2;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("fileId", this.fileId);
        eVar.t("fileSize", this.fileSize);
        eVar.t("duration", this.duration);
        eVar.t("width", this.width);
        eVar.t("height", this.height);
        eVar.v("playUrl", this.playUrl);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final QPlusCirStVideo decode(e eVar) {
        return new QPlusCirStVideo(eVar.q("fileId", ""), eVar.k("fileSize", 0), eVar.k("duration", 0), eVar.k("width", 0), eVar.k("height", 0), eVar.q("playUrl", ""));
    }
}
