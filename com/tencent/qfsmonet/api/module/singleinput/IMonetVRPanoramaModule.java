package com.tencent.qfsmonet.api.module.singleinput;

import com.tencent.qfsmonet.api.module.IMonetSingleInputModule;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes22.dex */
public interface IMonetVRPanoramaModule extends IMonetSingleInputModule {
    public static final int BINOCULAR = 2;
    public static final int PANORAMA = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes22.dex */
    public @interface MonetVRType {
    }

    void doRotate(float f16, float f17, float f18);

    void setVRType(int i3);
}
