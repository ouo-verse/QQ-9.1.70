package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name = "ViewPagerItem")
/* loaded from: classes20.dex */
public class HippyViewPagerItemController extends HippyViewController<HippyViewPagerItem> {
    public static final String CLASS_NAME = "ViewPagerItem";
    private static final String TAG = "ViewPagerItem";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyViewPagerItem(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected boolean shouldInterceptLayout(View view, int i3, int i16, int i17, int i18) {
        return true;
    }
}
