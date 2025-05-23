package com.tencent.gdtad.adapter;

import com.tencent.ad.tangram.views.AdUISettingsAdapter;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class t implements AdUISettingsAdapter {
    @Override // com.tencent.ad.tangram.views.AdUISettingsAdapter
    public boolean isNightMode() {
        return QQTheme.isNowThemeIsNight();
    }
}
