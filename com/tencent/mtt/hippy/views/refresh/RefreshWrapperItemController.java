package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.b;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

/* compiled from: P */
@HippyController(name = "RefreshWrapperItemView")
/* loaded from: classes20.dex */
public class RefreshWrapperItemController extends HippyViewGroupController {
    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroupController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new RefreshWrapperItemView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void updateLayout(int i3, int i16, int i17, int i18, int i19, b bVar) {
        super.updateLayout(i3, i16, i17 - i19, i18, i19, bVar);
    }
}
