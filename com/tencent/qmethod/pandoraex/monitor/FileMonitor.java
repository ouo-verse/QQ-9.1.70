package com.tencent.qmethod.pandoraex.monitor;

import android.os.FileObserver;
import com.tencent.qmethod.pandoraex.core.ext.file.FileObserverHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class FileMonitor {
    private static final String TAG = "FileMonitor";

    FileMonitor() {
    }

    public static void startWatching(Object obj) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "startWatching invoker");
        if (obj instanceof FileObserver) {
            FileObserverHelper.j((FileObserver) obj);
        } else {
            com.tencent.qmethod.pandoraex.core.t.b(obj, "startWatching", new Class[0], new Object[0]);
        }
    }

    public static void stopWatching(Object obj) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "stopWatching invoker");
        if (obj instanceof FileObserver) {
            FileObserverHelper.k((FileObserver) obj);
        } else {
            com.tencent.qmethod.pandoraex.core.t.b(obj, "stopWatching", new Class[0], new Object[0]);
        }
    }
}
