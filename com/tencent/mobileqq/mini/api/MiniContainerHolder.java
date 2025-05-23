package com.tencent.mobileqq.mini.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniContainerHolder {
    public static final int LIFECYCLE_DESTROY = 2;
    public static final int LIFECYCLE_PAUSE = 1;
    public static final int LIFECYCLE_RESUME = 0;
    public static final int STATE_LOADING = 0;
    public static final int STATE_LOAD_FAILED = 2;
    public static final int STATE_LOAD_SUCCEED = 1;
    private final View miniView;

    public MiniContainerHolder(View view) {
        this.miniView = view;
    }

    public void dispatchNativeEvent(String str, Map<String, ?> map) {
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent(str, map);
    }

    public View getView() {
        return this.miniView;
    }

    public void retry() {
        if (this.miniView == null) {
            return;
        }
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).retry(this.miniView);
    }

    public void setDrawEnabled(boolean z16) {
        if (this.miniView == null) {
            return;
        }
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setDrawEnabled(this.miniView, z16);
    }

    public void setLoadingView(IMiniLoadingView iMiniLoadingView) {
        if (this.miniView == null) {
            return;
        }
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).setLoadingView(this.miniView, iMiniLoadingView);
    }
}
