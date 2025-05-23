package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.content.Context;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallItemView extends HippyViewGroup {

    /* renamed from: d, reason: collision with root package name */
    private int f309517d;

    public HippyWaterfallItemView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
    }

    public void setType(int i3) {
        this.f309517d = i3;
    }
}
