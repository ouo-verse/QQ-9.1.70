package com.tencent.qqnt.doutu.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IDoutuSPUtil extends QRouteApi {
    long getComboDuration(Context context, String str);

    long getComboKeep(Context context, String str);

    boolean getDoutuComboSwitch(Context context, String str, boolean z16);

    int getDoutuConfigAppId(Context context, String str);

    long getDoutuDuration(Context context, String str);

    boolean getDoutuResDamaged(Context context);

    String getDoutuResMd5(Context context, String str);

    String getDoutuResUrl(Context context, String str);

    boolean getDoutuSettingSwitch(Context context, String str);

    boolean getDoutuSmartSwitchNew(Context context, String str);

    boolean getDoutuSwitch(Context context, String str, boolean z16);

    int getDuiTimes(Context context, String str);

    int getSmartPicCount(Context context, String str);

    void removeComboDuration(Context context, String str);

    void removeComboKeep(Context context, String str);

    void removeDoutuComboSwitch(Context context, String str);

    void removeDoutuDuration(Context context, String str);

    void removeDoutuResMd5(Context context, String str);

    void removeDoutuResUrl(Context context, String str);

    void removeDoutuSmartSwitchNew(Context context, String str);

    void removeDoutuSwitch(Context context, String str);

    void removeDuiTimes(Context context, String str);

    void removeSmartPicCount(Context context, String str);

    void updateComboDuration(Context context, String str, long j3);

    void updateComboKeep(Context context, String str, long j3);

    void updateDoutuComboSwitch(Context context, String str, boolean z16);

    void updateDoutuConfigAppId(Context context, String str, int i3);

    void updateDoutuConfigVersion(Context context, String str, int i3);

    void updateDoutuDuration(Context context, String str, long j3);

    void updateDoutuResDamaged(Context context, boolean z16);

    void updateDoutuResMd5(Context context, String str, String str2);

    void updateDoutuResUrl(Context context, String str, String str2);

    void updateDoutuSettingSwitch(Context context, String str, boolean z16);

    void updateDoutuSmartSwitchNew(Context context, String str, boolean z16);

    void updateDoutuSwitch(Context context, String str, boolean z16);

    void updateDuiTimes(Context context, String str, int i3);

    void updateSmartPicCount(Context context, String str, int i3);
}
