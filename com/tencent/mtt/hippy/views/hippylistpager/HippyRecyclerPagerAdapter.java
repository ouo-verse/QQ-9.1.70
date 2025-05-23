package com.tencent.mtt.hippy.views.hippylistpager;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;

/* loaded from: classes20.dex */
public class HippyRecyclerPagerAdapter<HRCV extends HippyRecyclerView> extends HippyRecyclerListAdapter {
    private static final String TAG = "HippyRecyclerPager";

    public HippyRecyclerPagerAdapter(HRCV hrcv, HippyEngineContext hippyEngineContext) {
        super(hrcv, hippyEngineContext);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter
    protected View createRenderView(ListItemRenderNode listItemRenderNode) {
        View e16 = listItemRenderNode.e();
        listItemRenderNode.setLazy(false);
        if (e16 == null) {
            e16 = listItemRenderNode.createViewRecursive();
            if (e16 == null) {
                LogUtils.e("TAG", "createRenderView: view == null error!!!");
            }
        } else {
            listItemRenderNode.createViewRecursive();
        }
        listItemRenderNode.updateViewRecursive();
        return e16;
    }
}
