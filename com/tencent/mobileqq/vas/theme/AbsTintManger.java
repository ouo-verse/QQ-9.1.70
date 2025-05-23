package com.tencent.mobileqq.vas.theme;

import com.tencent.theme.ISkinTint;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class AbsTintManger implements ISkinTint {
    public abstract Map<String, String> getCurrentTintColorMap();

    public abstract Integer getPlateColor(String str);
}
