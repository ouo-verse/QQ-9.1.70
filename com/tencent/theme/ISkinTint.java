package com.tencent.theme;

import android.content.res.Resources;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ISkinTint {
    void clear();

    boolean isTint(String str);

    void loadConfig(Resources resources, String str);

    boolean needTintRes(String str);

    void tint(Paint paint, String str);

    void tintColorState(int[] iArr, int[][] iArr2, String str);
}
