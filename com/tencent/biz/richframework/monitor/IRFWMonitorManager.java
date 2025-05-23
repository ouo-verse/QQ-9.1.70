package com.tencent.biz.richframework.monitor;

import android.content.Context;
import com.tencent.biz.richframework.monitor.local.IRFWMonitorProxy;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IRFWMonitorManager {
    void endPageScroll(int i3);

    void injectProxyImpl(IRFWMonitorProxy iRFWMonitorProxy);

    void release();

    void start(Context context);

    void startPageScroll(int i3);

    void stop();
}
