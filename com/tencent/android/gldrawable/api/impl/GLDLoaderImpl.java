package com.tencent.android.gldrawable.api.impl;

import androidx.annotation.Keep;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.ILoadUtils;
import com.tencent.android.gldrawable.api.base.AbsGLDLoader;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
/* loaded from: classes3.dex */
public class GLDLoaderImpl extends AbsGLDLoader {
    private ILoadUtils loadUtils = new LoaderUtilsImpl();

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    @NotNull
    public ILoadUtils getLoaderUtils() {
        return this.loadUtils;
    }

    @Override // com.tencent.android.gldrawable.api.base.AbsGLDLoader
    public void onLoadSucess() {
        super.onLoadSucess();
        if (DeviceInfoUtils.isLowPerfDevice()) {
            GLDrawableApi.config().setFpsLimit(20);
        }
    }
}
