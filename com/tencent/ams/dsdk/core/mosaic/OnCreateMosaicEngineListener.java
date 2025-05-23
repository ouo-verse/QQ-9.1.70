package com.tencent.ams.dsdk.core.mosaic;

import com.tencent.ams.dsdk.core.DKEngine;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface OnCreateMosaicEngineListener extends DKEngine.OnCreateEngineListener {
    void onSoLoadFailed(int i3);

    void onSoLoadStart();

    void onSoLoadSuccess(int i3);
}
