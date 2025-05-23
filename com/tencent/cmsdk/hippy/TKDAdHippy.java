package com.tencent.cmsdk.hippy;

import com.tencent.cmsdk.hippy.api.ITKDAdModule;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TKDAdHippy {
    ITKDAdModule itkdAdModule;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class Holder {
        private static final TKDAdHippy instance = new TKDAdHippy();

        Holder() {
        }
    }

    public static TKDAdHippy getInstance() {
        return Holder.instance;
    }

    public ITKDAdModule getTKDAdModule() {
        return this.itkdAdModule;
    }

    public void setITkdAdModule(ITKDAdModule iTKDAdModule) {
        if (iTKDAdModule != null) {
            this.itkdAdModule = iTKDAdModule;
        }
    }
}
