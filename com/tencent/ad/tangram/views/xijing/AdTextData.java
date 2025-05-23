package com.tencent.ad.tangram.views.xijing;

import com.tencent.ad.tangram.annotation.AdKeep;
import java.io.Serializable;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdTextData implements Serializable {
    public static final String FONT_WEIGHT_BOLD = "bold";
    public static final String FONT_WEIGHT_NORMAL = "normal";
    public int size;
    public String text;
    public int color = 0;
    public int lengthMax = Integer.MIN_VALUE;
    public String weight = "normal";

    public boolean isValid() {
        if (this.size > 0) {
            return true;
        }
        return false;
    }
}
