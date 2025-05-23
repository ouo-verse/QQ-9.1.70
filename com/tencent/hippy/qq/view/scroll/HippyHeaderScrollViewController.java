package com.tencent.hippy.qq.view.scroll;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

/* compiled from: P */
@HippyController(name = HippyHeaderScrollViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyHeaderScrollViewController extends HippyViewController<HippyHeaderScrollView> {
    public static final String CLASS_NAME = "HeaderScrollView";
    public static final String CURRENT_LIST_VIEW_TAG = "currentListViewTag";
    public static final String HEADER_HEIGHT = "headerHeight";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyHeaderScrollView(context);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = CURRENT_LIST_VIEW_TAG)
    public void setCurrentListViewTag(HippyHeaderScrollView hippyHeaderScrollView, String str) {
        hippyHeaderScrollView.setCurrentListViewTag(str);
    }

    @HippyControllerProps(defaultType = "number", name = HEADER_HEIGHT)
    public void setHeaderHeight(HippyHeaderScrollView hippyHeaderScrollView, int i3) {
        hippyHeaderScrollView.setHeaderHeight(i3);
    }
}
