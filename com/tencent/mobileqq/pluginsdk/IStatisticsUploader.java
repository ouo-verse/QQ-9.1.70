package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes16.dex */
public interface IStatisticsUploader {
    void uploadStartupFailure(Context context, String str, String str2, String str3, String str4, String str5);

    void uploadStartupSpeedInfo(Context context, Intent intent);
}
