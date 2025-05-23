package com.tencent.thumbplayer.core.hdr.capability;

import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.thumbplayer.core.utils.TPApplicationContext;

/* loaded from: classes26.dex */
public class TPDisplayHdrCapability {
    private static Display.HdrCapabilities sHdrCapabilities;

    public static synchronized boolean isHdrSupported(int i3) {
        int[] supportedHdrTypes;
        Display.HdrCapabilities hdrCapabilities;
        synchronized (TPDisplayHdrCapability.class) {
            if (sHdrCapabilities == null) {
                if (Build.VERSION.SDK_INT < 24) {
                    return false;
                }
                if (TPApplicationContext.getContext() == null) {
                    return false;
                }
                WindowManager windowManager = (WindowManager) TPApplicationContext.getContext().getSystemService("window");
                if (windowManager != null) {
                    hdrCapabilities = windowManager.getDefaultDisplay().getHdrCapabilities();
                    sHdrCapabilities = hdrCapabilities;
                    if (hdrCapabilities == null) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            supportedHdrTypes = sHdrCapabilities.getSupportedHdrTypes();
            for (int i16 : supportedHdrTypes) {
                if (i16 == i3) {
                    return true;
                }
            }
            return false;
        }
    }
}
