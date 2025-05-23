package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.container.core.NativeContainer;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class CoverViewAction implements Action<Object> {
    private static final int ADD_COVER_VIEW = 2;
    private static final int DEL_COVER_VIEW = 3;
    private static final int GET_COVER_VIEW = 1;
    private static final String TAG = "CoverViewAction";
    private static final int UNKNOWN_ACTION = 0;
    private int action = 0;
    private CoverView coverView;
    private int coverViewId;
    private boolean fixed;
    private IMiniAppContext miniAppContext;
    private int parentViewId;
    private int webViewId;

    CoverViewAction() {
    }

    private NativeContainer getNativeContainer() {
        return ((ax) this.miniAppContext).u(this.webViewId);
    }

    public static CoverViewAction obtain(IMiniAppContext iMiniAppContext) {
        CoverViewAction coverViewAction = new CoverViewAction();
        coverViewAction.miniAppContext = iMiniAppContext;
        return coverViewAction;
    }

    public boolean add(int i3, int i16, CoverView coverView) {
        return add(i3, i16, coverView, false);
    }

    public boolean del(int i3) {
        this.action = 3;
        this.coverViewId = i3;
        return Boolean.parseBoolean(this.miniAppContext.performAction(this).toString());
    }

    public CoverView get(int i3) {
        this.action = 1;
        this.coverViewId = i3;
        return (CoverView) this.miniAppContext.performAction(this);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Object perform(BaseRuntime baseRuntime) {
        boolean z16 = true;
        if (this.miniAppContext.isContainer()) {
            NativeContainer nativeContainer = getNativeContainer();
            int i3 = this.action;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        QMLog.e(TAG, "Unknown action");
                    } else {
                        if (nativeContainer == null || !nativeContainer.g0(this.coverViewId)) {
                            z16 = false;
                        }
                        return Boolean.valueOf(z16);
                    }
                } else {
                    if (nativeContainer == null || !nativeContainer.o(this.parentViewId, this.coverViewId, this.coverView, this.fixed)) {
                        z16 = false;
                    }
                    return Boolean.valueOf(z16);
                }
            } else {
                if (nativeContainer == null) {
                    return null;
                }
                return nativeContainer.t(this.coverViewId);
            }
        } else {
            IPage page = baseRuntime.getPage();
            if (!(page instanceof AppBrandPageContainer)) {
                QMLog.d(TAG, "Page is invalid");
                if (this.action == 1) {
                    return null;
                }
                return Boolean.FALSE;
            }
            AppBrandPageContainer appBrandPageContainer = (AppBrandPageContainer) page;
            int i16 = this.action;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        QMLog.e(TAG, "Unknown action");
                    } else {
                        return Boolean.valueOf(appBrandPageContainer.removeCoverView(this.coverViewId));
                    }
                } else {
                    return Boolean.valueOf(appBrandPageContainer.addCoverView(this.parentViewId, this.coverViewId, this.coverView, this.fixed));
                }
            } else {
                return appBrandPageContainer.getCoverView(this.coverViewId);
            }
        }
        return Boolean.FALSE;
    }

    public boolean add(int i3, int i16, CoverView coverView, boolean z16) {
        this.action = 2;
        this.parentViewId = i3;
        this.coverViewId = i16;
        this.coverView = coverView;
        this.fixed = z16;
        return Boolean.parseBoolean(this.miniAppContext.performAction(this).toString());
    }

    public static CoverViewAction obtain(IMiniAppContext iMiniAppContext, int i3) {
        CoverViewAction coverViewAction = new CoverViewAction();
        coverViewAction.miniAppContext = iMiniAppContext;
        coverViewAction.webViewId = i3;
        return coverViewAction;
    }
}
