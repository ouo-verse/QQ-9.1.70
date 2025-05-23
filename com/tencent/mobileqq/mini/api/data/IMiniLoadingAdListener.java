package com.tencent.mobileqq.mini.api.data;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface IMiniLoadingAdListener {
    void getLoadingAdLayoutReady();

    void onAdClick(int i3);

    void onAdDismiss(boolean z16);

    void onAdShow(View view);

    void onDownloadAdEnd(String str, long j3, String str2);

    void onPreloadAdReceive(int i3);

    void onSelectAdProcessDone(String str, ArrayList<Long> arrayList, HashMap<String, String> hashMap);
}
