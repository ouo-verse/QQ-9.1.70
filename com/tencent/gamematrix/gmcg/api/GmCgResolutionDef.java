package com.tencent.gamematrix.gmcg.api;

import com.tencent.tavcut.core.render.exporter.ExportOutput;

/* compiled from: P */
/* loaded from: classes6.dex */
public enum GmCgResolutionDef {
    RES_1080P(ExportOutput.KEY_LEVEL_1080P),
    RES_720P(ExportOutput.KEY_LEVEL_720P),
    RES_480P(ExportOutput.KEY_LEVEL_480P),
    RES_360P("360P"),
    RES_240P("240P");

    private final String mValue;

    GmCgResolutionDef(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
