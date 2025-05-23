package com.tencent.qqmini.sdk.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class NavigationBar extends FrameLayout {
    public static final String STYLE_CUSTOM = "custom";
    public static final String STYLE_DEFAULT = "default";
    public static final String STYLE_RESET = "reset";
    private static final String TAG = "minisdk-startNavigationBar";
    public static final String TEXT_STYLE_BLACK = "black";
    public static final String TEXT_STYLE_WHITE = "white";
    protected NavigationBarInfo barInfo;
    protected int mBackGroundColor;
    protected String mBarStyle;
    protected String mBarText;
    protected int mBarTextStyle;
    protected IMiniAppContext mMiniAppContext;
    protected a mNavigationBarCallback;
    protected int mPageCount;
    protected boolean mWebViewCanGoBack;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface a {
        IMiniAppContext getMiniAppContext();

        RelativeLayout getPageRootView();

        boolean isTabPage();

        void onClickBack(NavigationBar navigationBar);

        void onClickHome(NavigationBar navigationBar);
    }

    public NavigationBar(Context context) {
        super(context);
        this.mBackGroundColor = -16777216;
        this.mBarTextStyle = -1;
        this.mBarText = "";
        this.mPageCount = 0;
        this.mWebViewCanGoBack = false;
        init();
    }

    public static int getDefaultNaviBarHeight(Context context) {
        return DisplayUtil.dip2px(context, 44.0f) + DisplayUtil.getStatusBarHeight(context);
    }

    public static int getHalfNaviBarHeight(Context context) {
        return DisplayUtil.dip2px(context, 104.0f) + DisplayUtil.getStatusBarHeight(context);
    }

    private void init() {
        if (getContext() == null) {
            QMLog.d(TAG, "init with null context. return");
        }
        onInitView();
    }

    public CapsuleButton getCapsuleButton() {
        QMLog.d(TAG, "getCapsuleButton");
        return null;
    }

    public int getHomeIconVisibility() {
        return 8;
    }

    public String getNavbarStyle() {
        return this.mBarStyle;
    }

    public int getStatusNavigationBarTextStyle() {
        return this.mBarTextStyle;
    }

    public abstract void hideLoading();

    public boolean isEntryModelValid() {
        boolean z16;
        if (this.mMiniAppContext != null && MiniAppUtils.getMiniAppInfo() != null && MiniAppUtils.getMiniAppInfo().launchParam != null && MiniAppUtils.getMiniAppInfo().launchParam.entryModel != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QMLog.d(TAG, "isEntryModelValid valid  ===== " + z16);
        return z16;
    }

    protected abstract void onInitView();

    public final NavigationBar setBarStyle(String str) {
        this.mBarStyle = str;
        updateBarStyle();
        return this;
    }

    public abstract void setCapsuleVisible(int i3);

    public NavigationBar setClickBackListener(a aVar) {
        this.mNavigationBarCallback = aVar;
        return this;
    }

    public void setInnerWebViewCanGoBack(boolean z16) {
        this.mWebViewCanGoBack = z16;
    }

    public abstract void setMaskVisible(int i3);

    public NavigationBar setNavBackgroundColor(int i3) {
        this.mBackGroundColor = i3;
        return this;
    }

    public void setPageCount(int i3) {
        this.mPageCount = i3;
    }

    public void setTitleTextFromMiniApp(String str) {
        this.mBarText = str;
    }

    public boolean shouldContentBelow(String str) {
        return false;
    }

    public abstract void showLoading();

    protected abstract void updateBarStyle();

    public void updateByWindowInfo(WindowInfo windowInfo, Activity activity) {
        boolean z16;
        QMLog.d(TAG, "updateByWindowInfo");
        if (windowInfo != null) {
            NavigationBarInfo navigationBarInfo = windowInfo.navigationBarInfo;
            this.barInfo = navigationBarInfo;
            boolean z17 = false;
            if (navigationBarInfo != null) {
                setTitleTextFromMiniApp(navigationBarInfo.titleText);
                if (!TextUtils.isEmpty(this.barInfo.textStyle)) {
                    setTextStyle(this.barInfo.textStyle);
                }
                int i3 = this.barInfo.backgoundColor;
                this.mBackGroundColor = i3;
                setNavBackgroundColor(i3);
                hideLoading();
                if (!TextUtils.isEmpty(this.barInfo.style)) {
                    setBarStyle(this.barInfo.style);
                }
                z16 = "black".equals(this.barInfo.textStyle);
            } else {
                z16 = false;
            }
            if (activity != null) {
                z17 = DisplayUtil.setStatusTextColor(z16, activity.getWindow());
            }
            setUseCustomStatusBarStyle(z17);
        }
    }

    public abstract void updateProgress(byte b16);

    public NavigationBar setNavBackgroundColor(int i3, long j3, String str) {
        this.mBackGroundColor = i3;
        return this;
    }

    public NavigationBar(Context context, IMiniAppContext iMiniAppContext) {
        super(context);
        this.mBackGroundColor = -16777216;
        this.mBarTextStyle = -1;
        this.mBarText = "";
        this.mPageCount = 0;
        this.mWebViewCanGoBack = false;
        this.mMiniAppContext = iMiniAppContext;
        init();
    }

    public void checkCapsuleButton() {
    }

    public void setHomeIconVisibility(int i3) {
    }

    public void setNeedCloseTopRightCapsule(boolean z16) {
    }

    public NavigationBar setTextStyle(String str) {
        return this;
    }

    public void setUseCustomStatusBarStyle(boolean z16) {
    }

    public void updateByMiniAppContext(IMiniAppContext iMiniAppContext) {
    }
}
