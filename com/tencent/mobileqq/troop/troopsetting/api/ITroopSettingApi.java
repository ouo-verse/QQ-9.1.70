package com.tencent.mobileqq.troop.troopsetting.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopSettingApi extends QRouteApi {
    String getSimpleNameForTroopSettingActivity();

    Class<? extends Fragment> getTroopSettingFragmentClass();

    boolean handleShowSearchWayInAIO(@NonNull Context context, @Nullable String str);

    boolean isInstanceOfTroopSettingActivity(Activity activity);
}
