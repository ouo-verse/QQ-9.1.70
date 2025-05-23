package com.tencent.hippy.qq.view.viola.list;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.list.HippyListItemViewController;

/* compiled from: P */
@HippyController(isLazyLoad = true, name = TkdListItemViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class TkdListItemViewController extends HippyListItemViewController {
    public static final String CLASS_NAME = "tkdCell";

    @Override // com.tencent.mtt.hippy.views.list.HippyListItemViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new TkdListItemView(context);
    }
}
