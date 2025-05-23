package com.tencent.mobileqq.vas.theme;

import android.content.SharedPreferences;
import com.tencent.mobileqq.utils.em;
import com.tencent.theme.j;

/* loaded from: classes20.dex */
public class ThemeMMKVPreference implements j {
    @Override // com.tencent.theme.j
    public SharedPreferences getPreference() {
        return em.b().a();
    }
}
