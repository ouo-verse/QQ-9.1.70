package com.tencent.filament.zplan.app.impl;

import android.os.HandlerThread;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.UUID;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"", "priority", "Landroid/os/HandlerThread;", "b", "zplan-android_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final HandlerThread b(int i3) {
        String str = "FilamentNativeApp_" + UUID.randomUUID();
        FLog.INSTANCE.i("FilamentThreadHandler", "createFilamentThread(). name:" + str + ", priority:" + i3);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str, i3);
        baseHandlerThread.start();
        return baseHandlerThread;
    }
}
