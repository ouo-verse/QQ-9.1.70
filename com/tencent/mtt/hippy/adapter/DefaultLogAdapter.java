package com.tencent.mtt.hippy.adapter;

import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultLogAdapter implements HippyLogAdapter {
    @Override // com.tencent.mtt.hippy.adapter.HippyLogAdapter
    public void onReceiveLogMessage(int i3, @NonNull String str, @NonNull String str2) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    LogUtils.d(str, str2);
                    return;
                } else {
                    LogUtils.e(str, str2);
                    return;
                }
            }
            LogUtils.w(str, str2);
            return;
        }
        LogUtils.i(str, str2);
    }
}
