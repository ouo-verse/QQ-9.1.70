package com.tencent.qcircle.weseevideo.composition.interfaces;

import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ICompositionUpdateInterface {
    void durationUpdate(CMTime cMTime);

    void renderSizeUpdate(CGSize cGSize);
}
