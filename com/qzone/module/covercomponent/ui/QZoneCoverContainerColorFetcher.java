package com.qzone.module.covercomponent.ui;

import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCoverContainerColorFetcher extends com.tencent.mobileqq.qui.immersive.color.a {
    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(Drawable drawable) {
        return false;
    }

    @Override // com.tencent.mobileqq.qui.immersive.color.IColorFetcher
    public boolean canHandle(View view) {
        return view instanceof QZoneCoverContainer;
    }
}
