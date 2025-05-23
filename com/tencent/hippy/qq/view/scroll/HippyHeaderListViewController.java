package com.tencent.hippy.qq.view.scroll;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;

/* compiled from: P */
@HippyController(name = HippyHeaderListViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class HippyHeaderListViewController extends HippyListViewController {
    public static final String CLASS_NAME = "HeaderListView";
    public static final String VIEW_TAG = "viewTag";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.list.HippyListViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createViewImpl(Context context, HippyMap hippyMap) {
        return super.createViewImpl(context, hippyMap);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = VIEW_TAG)
    public void setViewTag(HippyListView hippyListView, String str) {
        hippyListView.setTag(R.id.x_z, str);
    }
}
