package com.tencent.qqmini.minigame.floatview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.HippyPageProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TaskNavigationManager extends a {

    /* renamed from: m, reason: collision with root package name */
    private TaskNavigationView f346389m;

    private void m() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.floatview.TaskNavigationManager.1
            @Override // java.lang.Runnable
            public void run() {
                TaskNavigationManager.this.c();
            }
        }, 4000L);
    }

    private boolean n() {
        LaunchParam launchParam;
        MiniAppInfo miniAppInfo = this.f346400i;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            QMLog.i("floatBox.TaskNavigationManager", "[isAllow2Show], taskType:" + launchParam.taskType + ",taskId:" + launchParam.taskId + ",taskAppId:" + launchParam.taskAppId);
            if (this.f346400i.launchParam.taskType == 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void b(String str) {
        int i3;
        ViewGroup viewGroup = this.f346396d;
        if (viewGroup == null) {
            return;
        }
        if (this.f346389m != null) {
            QMLog.w("floatBox.TaskNavigationManager", "already attached.");
            return;
        }
        Context context = viewGroup.getContext();
        if (!n()) {
            return;
        }
        TaskNavigationView taskNavigationView = new TaskNavigationView(context);
        this.f346389m = taskNavigationView;
        taskNavigationView.setAppInfo(this.f346400i);
        this.f346389m.setActivity(this.f346398f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DisplayUtil.dip2px(context, 343.0f), DisplayUtil.dip2px(context, 60.0f));
        layoutParams.gravity = 1;
        if (this.f346397e.isOrientationLandscape()) {
            QMLog.i("floatBox.TaskNavigationManager", "landscape mode.");
            layoutParams.topMargin = DisplayUtil.dip2px(context, 10.0f);
        } else {
            QMLog.i("floatBox.TaskNavigationManager", "portrait mode.");
            int dip2px = DisplayUtil.dip2px(context, 88.0f);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                i3 = DisplayUtil.getStatusBarHeight(context);
            } else {
                i3 = 0;
            }
            layoutParams.topMargin = dip2px + i3;
        }
        this.f346396d.addView(this.f346389m, layoutParams);
        m();
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void c() {
        ViewGroup viewGroup;
        TaskNavigationView taskNavigationView = this.f346389m;
        if (taskNavigationView != null && (viewGroup = this.f346396d) != null) {
            viewGroup.removeView(taskNavigationView);
            this.f346389m = null;
        }
    }

    @Override // com.tencent.qqmini.minigame.floatview.a
    public void l(MiniAppInfo miniAppInfo) {
        HippyPageProxy hippyPageProxy;
        super.l(miniAppInfo);
        b("");
        MiniAppInfo miniAppInfo2 = this.f346400i;
        if (miniAppInfo2 != null && miniAppInfo2.launchParam != null) {
            QMLog.i("floatBox.TaskNavigationManager", "[updateMiniAppInfo],isClosePage:" + this.f346400i.launchParam.isCloseGameBox);
            if (this.f346400i.launchParam.isCloseGameBox && (hippyPageProxy = (HippyPageProxy) ProxyManager.get(HippyPageProxy.class)) != null) {
                hippyPageProxy.closeHippyPage();
            }
        }
    }
}
