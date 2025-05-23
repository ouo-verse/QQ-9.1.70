package com.tencent.mobileqq.guild.feed.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* loaded from: classes13.dex */
public abstract class GuildQBasePartFragment extends QPublicBaseFragment {
    protected static final String TAG = "BasePartFragment";
    protected View mContentView;
    protected TopGestureLayout mGestureLayout;

    public void enableFlingRight(boolean z16) {
        if (this.mGestureLayout == null && getActivity() != null) {
            ViewGroup viewGroup = (ViewGroup) getActivity().getWindow().getDecorView();
            int i3 = 0;
            while (true) {
                if (i3 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof TopGestureLayout) {
                    this.mGestureLayout = (TopGestureLayout) childAt;
                    break;
                }
                i3++;
            }
        }
        TopGestureLayout topGestureLayout = this.mGestureLayout;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    protected boolean enableRootViewSetFitsSystemWindows() {
        return true;
    }

    protected boolean enableSetStatusBarColor() {
        return true;
    }

    protected abstract int getStatusBarColor();

    protected boolean isUseDarkTextStatusBar() {
        return false;
    }

    protected boolean needAdjustImmersive() {
        return true;
    }

    protected boolean needSupportFullScreen() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mContentView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (needAdjustImmersive()) {
            if (needSupportFullScreen()) {
                setFullScreen();
            } else {
                setImmersive();
            }
            setStatusBarTextColor();
        }
        View view = this.mContentView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    protected void setFullScreen() {
        if (getActivity() != null && getActivity().getWindow() != null) {
            setImmersive();
            ImmersiveUtils.trySetImmersiveStatusBar(getActivity().getWindow());
        }
    }

    public void setImmersive() {
        if (!(getActivity() instanceof QBaseActivity) || SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()) == null) {
            return;
        }
        SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()).init();
        SystemBarActivityModule.getSystemBarComp((QBaseActivity) getActivity()).setStatusBarVisible(2, 0);
    }

    protected void setStatusBarTextColor() {
        if (ImmersiveUtils.isSupporImmersive() == 1 && getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(isUseDarkTextStatusBar(), getActivity().getWindow());
        }
    }
}
