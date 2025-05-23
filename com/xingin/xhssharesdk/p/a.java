package com.xingin.xhssharesdk.p;

import androidx.annotation.NonNull;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.xingin.xhssharesdk.XhsShareSdkTools;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a extends BaseThread {

    @NonNull
    public final File C;

    public a(@NonNull File file) {
        this.C = file;
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        XhsShareSdkTools.deleteFile(this.C, false);
    }
}
