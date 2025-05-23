package com.tencent.aelight.camera.download.api.impl;

import com.tencent.aelight.camera.ae.download.AEResManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.a;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEResDownloadImpl implements IAEResDownload {
    @Override // com.tencent.aelight.camera.download.api.IAEResDownload
    public int getResPackageStatus(AEResInfo aEResInfo) {
        return AEResManager.J().S(aEResInfo);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResDownload
    public void preDownloadAEResOnAppStartUp() {
        AEResManager.J().k0();
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResDownload
    public void removeCallBack(a aVar) {
        AEResManager.J().p0(aVar);
    }

    @Override // com.tencent.aelight.camera.download.api.IAEResDownload
    public void requestDownload(AEResInfo aEResInfo, a aVar, boolean z16) {
        AEResManager.J().r0(aEResInfo, aVar, z16);
    }
}
