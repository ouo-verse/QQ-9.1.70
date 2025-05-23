package com.tencent.hippy.qq.view.tkd.listview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

/* compiled from: P */
@HippyController(name = HippyTKDListViewWrapperController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyTKDListViewWrapperController extends HippyViewGroupController {
    public static final String CLASS_NAME = "QBListViewWrapper";
    private static final int LISTVIEW_INDEX = 1;
    View mCustomHippyRefreshView;
    int mCustomHippyRefreshViewHeight;
    View.OnLayoutChangeListener mLayoutChangeListener;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void addView(ViewGroup viewGroup, View view, int i3) {
        super.addView(viewGroup, view, i3);
        if (i3 == 0) {
            this.mCustomHippyRefreshView = view;
            view.setVisibility(8);
            if (viewGroup.getChildCount() > 1 && viewGroup.getChildAt(1) != null) {
                ((HippyTKDListView) viewGroup.getChildAt(1)).setCustomHippyRefreshView(this.mCustomHippyRefreshView);
                return;
            }
            return;
        }
        if (view instanceof HippyTKDListView) {
            ((HippyTKDListView) view).setCustomHippyRefreshView(this.mCustomHippyRefreshView);
        }
    }
}
