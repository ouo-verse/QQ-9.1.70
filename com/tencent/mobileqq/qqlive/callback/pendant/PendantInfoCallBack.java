package com.tencent.mobileqq.qqlive.callback.pendant;

import com.tencent.mobileqq.qqlive.callback.BaseCallback;
import com.tencent.mobileqq.qqlive.data.pendant.PendantViewData;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface PendantInfoCallBack extends BaseCallback {
    void onFailed(boolean z16, int i3, String str);

    void onRecv(ArrayList<PendantViewData> arrayList);
}
