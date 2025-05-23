package com.tencent.ad.tangram.views.xijing;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdButtonData implements Serializable {

    @NonNull
    public AdTextData text = new AdTextData();
    public int borderCornerRadius = 5;
    public int backgroundColor = 0;
    public int borderWidth = 2;

    public boolean isValid() {
        if (this.text.isValid() && !TextUtils.isEmpty(this.text.text) && this.borderCornerRadius >= 0) {
            return true;
        }
        return false;
    }
}
