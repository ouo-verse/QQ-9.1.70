package com.tenpay.api;

import android.os.ResultReceiver;
import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IApiBankimg extends IApiBase {
    public static final String LOGIC = "com.tenpay.impl.ApiBankimgImpl";

    int getBankCardBackgroundId(String str);

    int getBankCardBackgroundId(String str, int i3);

    int getBankCardBackgroundIdForQQ(String str);

    int getBankCardBackgroundIdForQQ(String str, int i3);

    void getBankCardLogoForQQ(String str, ResultReceiver resultReceiver);

    void getBankCardWhiteMark(String str, ResultReceiver resultReceiver);

    void setBankCardDisableLogo(String str, View view);

    void setBankCardWhiteLogoForQQ(String str, View view);

    void setBankImage(String str, View view);
}
