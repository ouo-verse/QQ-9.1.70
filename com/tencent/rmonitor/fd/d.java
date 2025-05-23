package com.tencent.rmonitor.fd;

import android.os.MessageQueue;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.FileDescriptor;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements MessageQueue.OnFileDescriptorEventListener {
    @Override // android.os.MessageQueue.OnFileDescriptorEventListener
    public int onFileDescriptorEvents(@NonNull FileDescriptor fileDescriptor, int i3) {
        if (i3 == 1) {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                byte[] bArr = new byte[1024];
                if (fileInputStream.read(bArr) > 0 && bArr[0] == 101) {
                    FdLeakMonitor.getInstance().i(true);
                }
            } catch (Throwable th5) {
                FdLeakMonitor.nEnableLeakDetectThisTime(false);
                Logger.f365497g.c("RMonitor_FdLeak_Monitor", th5);
                return 0;
            }
        }
        return 1;
    }
}
