package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.j;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

/* loaded from: classes32.dex */
public class AEPathImpl implements IAEPath {
    private static final String TAG = "AEPathImpl";

    @Override // com.tencent.aelight.camera.api.IAEPath
    public void clearAECache() {
        FileUtils.deleteFilesInDirectory(g.a.c.f65266a);
        FileUtils.deleteFilesInDirectory(j.a.f65591b);
        FileUtils.deleteFilesInDirectory(j.a.f65592c);
        ms.a.c(TAG, "clearAECache success.");
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getCameraMaterialConfig() {
        return g.a.b.f65264m;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getCameraMaterialUnZipDownload() {
        return g.a.b.f65262k;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getCameraPathMaterialFinalUsable() {
        return g.a.b.f65262k;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getCameraResPath() {
        return g.a.b.f65253b;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getGifPreviewCache() {
        return g.b.a.f65273b;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getLoadPagPath() {
        return PagViewMonitor.b.f65754a.b();
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getMoodPathFinalUsable() {
        return g.a.b.f65261j;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getPendantBasePath() {
        return g.a.c.f65266a;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getQZoneCameraPathMaterialFinalUsable() {
        return g.a.b.f65265n;
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getQZoneCameraZipPathMaterialFinalUsable() {
        return g.a.b.f65265n + File.separator + "zip";
    }

    @Override // com.tencent.aelight.camera.api.IAEPath
    public String getTmpCache() {
        return j.b.f65593a;
    }
}
