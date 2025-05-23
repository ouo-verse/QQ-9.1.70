package com.tencent.aelight.camera.download.old.api.impl;

import com.tencent.aelight.camera.download.old.api.IAEOldPath;
import fq.a;
import fq.b;
import fq.c;

/* loaded from: classes32.dex */
public class AEOldPathImpl implements IAEOldPath {
    @Override // com.tencent.aelight.camera.download.old.api.IAEOldPath
    public String getCameraResPath() {
        return a.f400293b;
    }

    @Override // com.tencent.aelight.camera.download.old.api.IAEOldPath
    public String getPendantBasePath() {
        return b.f400301a;
    }

    @Override // com.tencent.aelight.camera.download.old.api.IAEOldPath
    public String getTmpCache() {
        return c.b.f400308a;
    }
}
