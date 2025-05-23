package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name = GamePubAccountMsgViewController.CLASS_NAME)
/* loaded from: classes16.dex */
public class GamePubAccountMsgViewController extends HippyViewController<GamePubAccountHeadView> {
    public static final String CLASS_NAME = "gpHeaderView";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new GamePubAccountHeadView(context);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new GamePubAccountHeadView(context);
    }
}
