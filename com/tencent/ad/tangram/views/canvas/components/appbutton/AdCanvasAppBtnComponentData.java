package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.support.annotation.NonNull;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.xijing.AdButtonData;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AdCanvasAppBtnComponentData extends AdCanvasComponentData {
    public int width = 0;
    public int height = 0;

    @NonNull
    public AdButtonData button = new AdButtonData();
    public int fontColor = 0;
    public int gravity = 0;
    public boolean isFixed = false;
    public int toBottom = 0;
    public int whiteSpace = 0;
    public boolean canShowProgress = false;

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (super.isValid() && this.width > 0 && this.height > 0 && this.button.isValid()) {
            return true;
        }
        return false;
    }
}
