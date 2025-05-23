package com.tencent.hippy.qq.view.recycleview;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;

/* compiled from: P */
@HippyController(name = "RecyclerView", names = {"RecyclerView"})
/* loaded from: classes7.dex */
public class HippyQQRecycleViewController extends HippyRecyclerViewController {
    public static final String CLASS_NAME = "RecyclerView";

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new HippyRecyclerViewWrapper(context, HippyRecyclerViewController.initDefault(context, hippyMap, new HippyQQRecyclerView(context)));
    }
}
