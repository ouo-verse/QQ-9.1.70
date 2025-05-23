package com.tencent.biz.richframework.order;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWOrderElementFactory {
    private static final ConcurrentHashMap<String, RFWOrderElementManager> sInstanceMap = new ConcurrentHashMap<>();

    public static RFWOrderElementManager getOrderElementManager(String str) {
        ConcurrentHashMap<String, RFWOrderElementManager> concurrentHashMap = sInstanceMap;
        RFWOrderElementManager rFWOrderElementManager = concurrentHashMap.get(str);
        if (rFWOrderElementManager == null) {
            synchronized (RFWOrderElementFactory.class) {
                rFWOrderElementManager = concurrentHashMap.get(str);
                if (rFWOrderElementManager == null) {
                    rFWOrderElementManager = new RFWOrderElementManager();
                    concurrentHashMap.put(str, rFWOrderElementManager);
                }
            }
        }
        return rFWOrderElementManager;
    }
}
