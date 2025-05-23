package com.tencent.ad.tangram.views.canvas.components.text;

import android.text.TextUtils;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasTextComponentData extends AdCanvasComponentData {
    public String content;
    public int fontSize;
    public int marginLeft = 0;
    public int marginTop = 0;
    public int marginRight = 0;
    public int marginBottom = 0;

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (super.isValid() && !TextUtils.isEmpty(this.content)) {
            return true;
        }
        return false;
    }
}
