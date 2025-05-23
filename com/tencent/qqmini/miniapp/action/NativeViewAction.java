package com.tencent.qqmini.miniapp.action;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeViewAction implements Action<Boolean> {
    private static final int ADD_NATIVE_VIEW = 1;
    private static final int DEL_NATIVE_VIEW = 2;
    private static final String TAG = "NativeViewAction";
    private static final int UNKNOWN_ACTION = 0;
    private int action = 0;
    private ViewGroup.LayoutParams layoutParams;
    private IMiniAppContext miniAppContext;
    private View nativeView;

    NativeViewAction() {
    }

    public static NativeViewAction obtain(IMiniAppContext iMiniAppContext) {
        NativeViewAction nativeViewAction = new NativeViewAction();
        nativeViewAction.miniAppContext = iMiniAppContext;
        return nativeViewAction;
    }

    public boolean add(View view, ViewGroup.LayoutParams layoutParams) {
        this.action = 1;
        this.nativeView = view;
        this.layoutParams = layoutParams;
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    public boolean del(View view) {
        this.action = 2;
        this.nativeView = view;
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        boolean addNativeView;
        IPage page = baseRuntime.getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            QMLog.d(TAG, "Page is invalid");
            return null;
        }
        AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
        int i3 = this.action;
        if (i3 == 1) {
            addNativeView = appBrandPageContainer.addNativeView(this.nativeView, this.layoutParams);
        } else if (i3 != 2) {
            QMLog.e(TAG, "Unknown action");
            addNativeView = false;
        } else {
            addNativeView = appBrandPageContainer.removeNativeView(this.nativeView);
        }
        return Boolean.valueOf(addNativeView);
    }
}
