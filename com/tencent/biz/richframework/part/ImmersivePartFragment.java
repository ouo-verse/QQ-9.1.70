package com.tencent.biz.richframework.part;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.compat.RFWThemeUtil;

/* loaded from: classes5.dex */
public abstract class ImmersivePartFragment extends BasePartFragment {
    public ImmersivePartFragment() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean enableRootViewSetFitsSystemWindows() {
        return true;
    }

    protected boolean enableSetStatusBarColor() {
        return true;
    }

    protected abstract int getStatusBarColor();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isUseDarkTextStatusBar() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needSupportFullScreen() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (needAdjustImmersive()) {
            if (needSupportFullScreen()) {
                setFullScreen();
            } else {
                setImmersive(view);
            }
            setStatusBarTextColor();
        }
    }

    protected void setFullScreen() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
        }
    }

    protected void setImmersive(View view) {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (enableSetStatusBarColor()) {
                RFWThemeUtil.setStatusBarColor(getActivity(), getStatusBarColor());
            }
            if (enableRootViewSetFitsSystemWindows() && view != null) {
                view.setFitsSystemWindows(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStatusBarTextColor() {
        if (ImmersiveUtils.isSupporImmersive() == 1 && getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(isUseDarkTextStatusBar(), getActivity().getWindow());
        }
    }

    public ImmersivePartFragment(int i3) {
        super(i3);
    }
}
