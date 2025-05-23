package com.tencent.mobileqq.vas.profilecard.colorscreen.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenSp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/profilecard/colorscreen/impl/VasColorScreenSpImpl;", "Lcom/tencent/mobileqq/vas/profilecard/colorscreen/IVasColorScreenSp;", "()V", "getColorScreenId", "", "uin", "", "setColorScreenId", "", "id", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasColorScreenSpImpl implements IVasColorScreenSp {
    @Override // com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenSp
    public int getColorScreenId(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SharedPreferences sharedPreferences = BaseApplication.context.getSharedPreferences(uin, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere\u2026in, Context.MODE_PRIVATE)");
        try {
            return sharedPreferences.getInt(AppConstants.Preferences.SVIP_COLOR_SCREEN_ID, 0);
        } catch (IllegalArgumentException e16) {
            QLog.e("VasColorScreenSpImpl", 1, e16, new Object[0]);
            return 0;
        }
    }

    @Override // com.tencent.mobileqq.vas.profilecard.colorscreen.IVasColorScreenSp
    public void setColorScreenId(@NotNull String uin, int id5) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        SharedPreferences sharedPreferences = BaseApplication.context.getSharedPreferences(uin, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere\u2026in, Context.MODE_PRIVATE)");
        sharedPreferences.edit().putInt(AppConstants.Preferences.SVIP_COLOR_SCREEN_ID, id5).apply();
    }
}
