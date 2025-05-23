package com.tencent.qfsmonet.api.outputstream;

import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IMonetSurfaceOutputStream extends IMonetOutputStream {
    void updateSurface(@Nullable Surface surface) throws IllegalStateException;
}
