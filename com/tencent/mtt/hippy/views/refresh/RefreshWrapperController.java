package com.tencent.mtt.hippy.views.refresh;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;

/* compiled from: P */
@HippyController(name = "RefreshWrapper")
/* loaded from: classes20.dex */
public class RefreshWrapperController extends HippyGroupController<RefreshWrapper> {
    final String RefreshComplected = "refreshComplected";
    final String StartRefresh = "startRefresh";

    @HippyControllerProps(defaultNumber = 300.0d, defaultType = "number", name = "bounceTime")
    public void bounceTime(RefreshWrapper refreshWrapper, int i3) {
        refreshWrapper.setTime(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new RefreshWrapper(context);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onScrollEnable")
    public void setOnScrollEventEnable(RefreshWrapper refreshWrapper, boolean z16) {
        refreshWrapper.setOnScrollEventEnable(z16);
    }

    @HippyControllerProps(defaultNumber = PreDownloadConstants.SYS_BUSY_VALUE_FPS, defaultType = "number", name = "scrollEventThrottle")
    public void setscrollEventThrottle(RefreshWrapper refreshWrapper, int i3) {
        refreshWrapper.setScrollEventThrottle(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(RefreshWrapper refreshWrapper, String str, HippyArray hippyArray) {
        super.dispatchFunction((RefreshWrapperController) refreshWrapper, str, hippyArray);
        if ("refreshComplected".equals(str)) {
            refreshWrapper.refreshComplected();
        } else if ("startRefresh".equals(str)) {
            refreshWrapper.startRefresh();
        }
    }
}
