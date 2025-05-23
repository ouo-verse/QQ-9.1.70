package com.tencent.ams.mosaic.jsengine.component.image.drawable;

import android.graphics.drawable.Drawable;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface MosaicDrawable {
    Drawable getDrawable();

    @JSMethod
    boolean isAnimatable();
}
