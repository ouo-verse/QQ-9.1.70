package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ObserverManager extends Observable {
    private static final String TAG = "MsgObserverManager";

    public void notifyChange(Object obj) {
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "notifyChange...msg=" + obj);
        }
        setChanged();
        if (obj != null) {
            notifyObservers(obj);
        } else {
            notifyObservers();
        }
    }
}
