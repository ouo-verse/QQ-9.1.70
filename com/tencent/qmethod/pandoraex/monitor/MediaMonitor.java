package com.tencent.qmethod.pandoraex.monitor;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import com.tencent.qmethod.pandoraex.core.ext.file.ContentObserverHelper;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MediaMonitor {
    private static final String TAG = "MediaMonitor";

    MediaMonitor() {
    }

    public static void registerContentObserver(ContentResolver contentResolver, Uri uri, boolean z16, ContentObserver contentObserver) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "registerContentObserver invoke");
        ContentObserverHelper.g(contentResolver, uri, z16, contentObserver);
    }

    public static void unregisterContentObserver(ContentResolver contentResolver, ContentObserver contentObserver) {
        com.tencent.qmethod.pandoraex.core.o.a(TAG, "unregisterContentObserver invoke");
        ContentObserverHelper.i(contentResolver, contentObserver);
    }
}
