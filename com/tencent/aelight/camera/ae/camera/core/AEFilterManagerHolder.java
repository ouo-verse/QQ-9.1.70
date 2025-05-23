package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFilterManagerHolder {
    private static AEFilterProcessTex instance;

    public static AEFilterProcessTex getAEFilterManager() {
        return instance;
    }

    public static void setFilterProcess(AEFilterProcessTex aEFilterProcessTex) {
        instance = aEFilterProcessTex;
    }
}
