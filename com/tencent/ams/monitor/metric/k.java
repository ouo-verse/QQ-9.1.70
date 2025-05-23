package com.tencent.ams.monitor.metric;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface k {
    void a(WeakReference<Context> weakReference);

    void flush(WeakReference<Context> weakReference);

    void handle(WeakReference<Context> weakReference, CopyOnWriteArrayList<i> copyOnWriteArrayList);

    void setReportEnabled(WeakReference<Context> weakReference, boolean z16);
}
