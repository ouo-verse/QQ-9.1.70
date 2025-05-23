package com.epicgames.ue4;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface StoreHelper {
    boolean BeginPurchase(String str, String str2);

    void ConsumePurchase(String str);

    boolean IsAllowedToMakePurchases();

    boolean QueryExistingPurchases();

    boolean QueryInAppPurchases(String[] strArr);

    boolean RestorePurchases(String[] strArr, boolean[] zArr);

    boolean onActivityResult(int i3, int i16, Intent intent);

    void onDestroy();
}
