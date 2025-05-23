package com.tencent.ad.tangram.views.canvas.components.appinfobutton;

import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppInfoButtonComponentData extends AdCanvasAppBtnComponentData {
    public String appName;
    public int appNameFontSize;
    public int backgroundColor;
    public String desc;
    public int descFontSize;
    public float descLineSpacing;
    public long downloadCount;
    public long fileSize;
    public int fileSizeAndDownFontSize;
    public String logoUrl;

    @Override // com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData, com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (super.isValid() && this.paddingLeft >= 0 && this.paddingRight >= 0 && this.height > 0 && this.button.isValid()) {
            return true;
        }
        return false;
    }
}
