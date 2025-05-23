package com.etrump.mixlayout.api;

import com.etrump.mixlayout.ETEngine;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ETFontUtil {
    public static boolean enableAnimation = true;

    public static void clearMap(ETEngine eTEngine) {
        HashMap<Long, WeakReference<IETDecoration>> hashMap;
        IETDecoration iETDecoration;
        if (eTEngine != null && (hashMap = eTEngine.mDescriptorMap) != null) {
            for (Map.Entry<Long, WeakReference<IETDecoration>> entry : hashMap.entrySet()) {
                eTEngine.native_decorationDeleteDescriptor(entry.getKey().longValue());
                if (entry.getValue().get() != null && (iETDecoration = entry.getValue().get()) != null) {
                    iETDecoration.setNativeDescriptorHandle(0L);
                }
            }
            eTEngine.mDescriptorMap.clear();
        }
    }
}
