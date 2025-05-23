package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface SystemNotifier {
    void notifyNoticeObservers(int i3);

    void notifyObservers(int i3);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}
