package com.tencent.qqmini.sdk.runtime;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AppRuntimeEventCenter extends Observable {
    public static final String TAG = "minisdk-start_AppStateManager";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MiniAppStateMessage {
        public BaseRuntimeLoader appRuntimeLoader;
        public Object obj;
        public int what;

        MiniAppStateMessage(int i3, BaseRuntimeLoader baseRuntimeLoader) {
            this.what = i3;
            this.appRuntimeLoader = baseRuntimeLoader;
        }

        public static MiniAppStateMessage obtainMessage(int i3, BaseRuntimeLoader baseRuntimeLoader) {
            return new MiniAppStateMessage(i3, baseRuntimeLoader);
        }

        public String toString() {
            String str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("{RuntimeLoader(");
            BaseRuntimeLoader baseRuntimeLoader = this.appRuntimeLoader;
            Object obj = "nil";
            if (baseRuntimeLoader == null) {
                str = "nil";
            } else {
                str = baseRuntimeLoader.getClass().getSimpleName();
            }
            sb5.append(str);
            sb5.append(")@");
            BaseRuntimeLoader baseRuntimeLoader2 = this.appRuntimeLoader;
            if (baseRuntimeLoader2 != null) {
                obj = Integer.valueOf(baseRuntimeLoader2.hashCode());
            }
            sb5.append(obj);
            sb5.append(this.appRuntimeLoader);
            sb5.append(" what=");
            sb5.append(this.what);
            sb5.append("}");
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static abstract class RuntimeStateObserver implements Observer {
        public abstract void onStateChange(MiniAppStateMessage miniAppStateMessage);

        @Override // java.util.Observer
        public void update(Observable observable, Object obj) {
            if (obj instanceof MiniAppStateMessage) {
                onStateChange((MiniAppStateMessage) obj);
            }
        }
    }

    public void notifyChange(Object obj) {
        if (obj == null) {
            return;
        }
        if (QMLog.isDebugEnabled()) {
            QMLog.d(TAG, "notifyChange msg=" + obj);
        }
        setChanged();
        notifyObservers(obj);
    }
}
