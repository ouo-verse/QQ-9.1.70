package com.tencent.aelight.camera.download.old.api.impl;

import com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion;
import fq.d;

/* loaded from: classes32.dex */
public class AEOldResPendentVersionImpl implements IAEOldResPendentVersion {
    @Override // com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion
    public boolean checkConfigFileListIsOK(String str, String str2) {
        return d.a(str, str2);
    }

    @Override // com.tencent.aelight.camera.download.old.api.IAEOldResPendentVersion
    public boolean checkSignatureVersionIsOK(String str, int i3) {
        return d.b(str, i3);
    }
}
