package com.tencent.hippy.qq.view.gridview;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.HippyLinearLayoutManager;
import com.tencent.mapsdk.internal.by;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;

/* compiled from: P */
@HippyController(name = HippyQQDragGridViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyQQDragGridViewController extends HippyRecyclerViewController {
    public static final String CLASS_NAME = "QQDragGridView";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private interface PropertyName {
        public static final String COLUMN = "column";
        public static final String ENABLE_DRAG = "enableDrag";
        public static final String FIXED_COUNT = "fixedCount";
    }

    private HippyQQDragGridView getGridViewFromWrapper(HippyRecyclerViewWrapper hippyRecyclerViewWrapper) {
        HippyRecyclerView recyclerView;
        if (hippyRecyclerViewWrapper != null && (recyclerView = hippyRecyclerViewWrapper.getRecyclerView()) != null && (recyclerView instanceof HippyQQDragGridView)) {
            return (HippyQQDragGridView) recyclerView;
        }
        return null;
    }

    public static HippyQQDragGridView initGridView(Context context, HippyMap hippyMap, HippyQQDragGridView hippyQQDragGridView) {
        HippyLinearLayoutManager hippyLinearLayoutManager = new HippyLinearLayoutManager(context);
        boolean z16 = false;
        if (hippyMap != null) {
            if (hippyMap.containsKey("horizontal")) {
                hippyLinearLayoutManager.setOrientation(0);
            }
            z16 = hippyMap.getBoolean(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
        }
        hippyQQDragGridView.setLayoutManager(hippyLinearLayoutManager);
        hippyQQDragGridView.setHippyEngineContext(((HippyInstanceContext) context).getEngineContext());
        hippyQQDragGridView.initRecyclerView();
        hippyQQDragGridView.getRecyclerViewEventHelper().setOnScrollEventEnable(z16);
        return hippyQQDragGridView;
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new HippyRecyclerViewWrapper(context, initGridView(context, hippyMap, new HippyQQDragGridView(context)));
    }

    @HippyControllerProps(defaultNumber = by.f147964a, defaultType = "number", name = "column")
    public void setColumn(HippyRecyclerViewWrapper hippyRecyclerViewWrapper, int i3) {
        HippyQQDragGridView gridViewFromWrapper = getGridViewFromWrapper(hippyRecyclerViewWrapper);
        if (gridViewFromWrapper != null) {
            gridViewFromWrapper.setColumn(i3);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = PropertyName.ENABLE_DRAG)
    public void setDragEnable(HippyRecyclerViewWrapper hippyRecyclerViewWrapper, boolean z16) {
        HippyQQDragGridView gridViewFromWrapper = getGridViewFromWrapper(hippyRecyclerViewWrapper);
        if (gridViewFromWrapper != null) {
            gridViewFromWrapper.setDragEnable(z16);
        }
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = PropertyName.FIXED_COUNT)
    public void setFixedCount(HippyRecyclerViewWrapper hippyRecyclerViewWrapper, int i3) {
        HippyQQDragGridView gridViewFromWrapper = getGridViewFromWrapper(hippyRecyclerViewWrapper);
        if (gridViewFromWrapper != null) {
            gridViewFromWrapper.setFixedCount(i3);
        }
    }
}
