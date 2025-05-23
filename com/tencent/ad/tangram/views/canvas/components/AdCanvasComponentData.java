package com.tencent.ad.tangram.views.canvas.components;

import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import java.io.Serializable;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public abstract class AdCanvasComponentData implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    public String f61339id;
    public int paddingTop = 0;
    public int paddingBottom = 0;
    public int paddingLeft = 0;
    public int paddingRight = 0;
    public boolean isAddToLoadStatistics = true;

    public int getToLoadIdSize() {
        return 1;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.f61339id) && this.paddingTop >= 0 && this.paddingBottom >= 0) {
            return true;
        }
        return false;
    }
}
