package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface SystemObserver {
    boolean onNoticeResult(int i3);

    boolean onSolutionResult(Intent intent, String str);

    boolean onUpdateResult(int i3);
}
