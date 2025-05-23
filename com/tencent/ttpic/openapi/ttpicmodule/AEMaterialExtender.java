package com.tencent.ttpic.openapi.ttpicmodule;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEMaterialExtender {
    private static HashMap<String, Object> renderExtension = new HashMap<>();

    public static void extendRenderAttr(Class cls) {
        renderExtension.put(cls.getName(), cls);
    }

    public static HashMap<String, Object> getRenderExtension() {
        return renderExtension;
    }
}
