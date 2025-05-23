package com.tencent.ad.tangram.views.canvas.components.appicon;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdCanvasAppBtnComponentData;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCanvasAppIconComponentData extends AdCanvasComponentData {
    public AdCanvasAppBtnComponentData adCanvasAppBtnComponentData;
    public int logoHeight;
    public int logoWidth;

    @Nullable
    public String logoUrl = null;

    @Nullable
    public String name = null;
    public long downloadCount = 0;
    public long fileSize = 0;
    public int starCount = 0;
    public int marginLeft = 0;
    public int marginTop = 0;
    public int marginRight = 0;
    public int marginBottom = 0;

    @Override // com.tencent.ad.tangram.views.canvas.components.AdCanvasComponentData
    public boolean isValid() {
        if (!TextUtils.isEmpty(this.logoUrl) && !TextUtils.isEmpty(this.name)) {
            return true;
        }
        return false;
    }
}
