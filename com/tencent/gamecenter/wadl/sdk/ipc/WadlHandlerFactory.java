package com.tencent.gamecenter.wadl.sdk.ipc;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlHandlerFactory {
    private static HashMap<Integer, WadlHandlerInterface> BUSINESS_HANDLER_MAP = new HashMap<>();
    public static final String TAG = "WadlHandlerFactory";

    public static void destroy() {
        try {
            Iterator<Map.Entry<Integer, WadlHandlerInterface>> it = BUSINESS_HANDLER_MAP.entrySet().iterator();
            while (it.hasNext()) {
                WadlHandlerInterface value = it.next().getValue();
                if (value != null) {
                    value.onDestroy();
                }
            }
            BUSINESS_HANDLER_MAP.clear();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "destroy exception", th5);
        }
    }

    public static WadlHandlerInterface getBusinessHandler(int i3) {
        WadlHandlerInterface wadlHandlerInterface = BUSINESS_HANDLER_MAP.get(Integer.valueOf(i3));
        if (wadlHandlerInterface == null) {
            synchronized (BUSINESS_HANDLER_MAP) {
                wadlHandlerInterface = BUSINESS_HANDLER_MAP.get(Integer.valueOf(i3));
                if (wadlHandlerInterface == null) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                wadlHandlerInterface = new WadlVMHandler(i3);
                            }
                        } else {
                            wadlHandlerInterface = new WadlTgpaHandler(i3);
                        }
                    } else {
                        wadlHandlerInterface = new WadlGameCenterHandler(i3);
                    }
                    if (wadlHandlerInterface != null) {
                        BUSINESS_HANDLER_MAP.put(Integer.valueOf(i3), wadlHandlerInterface);
                    }
                }
            }
        }
        return wadlHandlerInterface;
    }
}
