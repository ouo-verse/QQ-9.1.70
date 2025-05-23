package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.api.IQIMManager;
import fr.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMManagerImpl implements IQIMManager {
    private static final String TAG = "QIMManagerImpl";

    @Override // com.tencent.aelight.camera.api.IQIMManager
    public void destory() {
        try {
            com.tencent.aelight.camera.ae.control.a.c().a();
            f.d().b();
        } catch (Throwable th5) {
            ms.a.c(TAG, th5.getMessage());
        }
    }
}
