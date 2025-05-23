package com.tencent.mobileqq.vas.api.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasThemeFontApi;
import com.tencent.mobileqq.vas.theme.api.IThemeFontAdapter;

/* compiled from: P */
/* loaded from: classes20.dex */
public class as implements IVasThemeFontApi {
    @Override // com.tencent.mobileqq.vas.api.IVasManager
    @NonNull
    public String getManagerName() {
        return "VasThemeFontApiImpl";
    }

    @Override // com.tencent.mobileqq.vas.api.IVasThemeFontApi
    public void switchFont(int i3) {
        try {
            ((IThemeFontAdapter) QRoute.api(IThemeFontAdapter.class)).switchFont(i3);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
        }
    }
}
