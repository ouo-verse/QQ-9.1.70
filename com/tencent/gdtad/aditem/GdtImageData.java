package com.tencent.gdtad.aditem;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtImageData {
    public int height;
    public String url;
    public int width;

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.url) && this.width >= 0 && this.height >= 0) {
            return true;
        }
        return false;
    }
}
