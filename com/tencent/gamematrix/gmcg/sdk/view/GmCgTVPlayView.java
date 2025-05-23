package com.tencent.gamematrix.gmcg.sdk.view;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes6.dex */
public class GmCgTVPlayView extends GmCgPlayView {
    public GmCgTVPlayView(Context context) {
        super(context);
    }

    @Override // com.tencent.gamematrix.gmcg.sdk.view.GmCgPlayView
    public void configGameScreenOrientation(int i3) {
        configGameScreenOrientation(i3, false);
    }

    public GmCgTVPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
