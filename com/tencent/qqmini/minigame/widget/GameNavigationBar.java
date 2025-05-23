package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.screenrecord.GuideBubbleViewCtrl;
import com.tencent.qqmini.minigame.ui.GuideBubbleView;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.widget.CapsuleButton;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameNavigationBar extends BaseGameNavigationBar {
    private static final String TAG = "GameNavigationBar";
    protected boolean hasInit;
    protected int mBackGroundColor;
    protected String mBarStyle;
    protected int mBarTextStyle;
    protected CapsuleButton mCapsuleButton;
    protected RelativeLayout mContainer;
    protected GuideBubbleViewCtrl mGuideViewCtrl;
    protected IMiniAppContext mMiniAppContext;

    public GameNavigationBar(Context context) {
        this(context, null);
    }

    private void changeNavIcon() {
        CapsuleButton capsuleButton = this.mCapsuleButton;
        if (capsuleButton != null) {
            capsuleButton.changeNavIcon(this.mBarTextStyle);
        }
    }

    public static WindowInfo fakeWindowInfo() {
        NavigationBarInfo navigationBarInfo = new NavigationBarInfo();
        navigationBarInfo.backgoundColor = 0;
        navigationBarInfo.textStyle = "gray";
        navigationBarInfo.style = "default";
        WindowInfo windowInfo = new WindowInfo();
        windowInfo.navigationBarInfo = navigationBarInfo;
        windowInfo.backgroundColor = DisplayUtil.parseColor(TipsElementData.DEFAULT_COLOR);
        windowInfo.backgroundTextStyle = MiniAppConst.MENU_STYLE_DARK;
        windowInfo.enablePullDownRefresh = Boolean.FALSE;
        windowInfo.onReachBottomDistance = 50;
        return windowInfo;
    }

    private void init() {
        if (getContext() != null && !this.hasInit) {
            this.mContainer = new RelativeLayout(getContext());
            this.mContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int i3 = 0;
            this.mContainer.setClipChildren(false);
            CapsuleButton capsuleButton = new CapsuleButton(getContext());
            this.mCapsuleButton = capsuleButton;
            capsuleButton.setId(R.id.container_top_btns);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 80.0f), DisplayUtil.dip2px(getContext(), 30.0f));
            layoutParams.addRule(11, -1);
            int dip2px = DisplayUtil.dip2px(getContext(), 9.0f);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                i3 = DisplayUtil.getStatusBarHeight(getContext());
            }
            layoutParams.topMargin = dip2px + i3;
            layoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 12.5f);
            this.mContainer.addView(this.mCapsuleButton, layoutParams);
            addView(this.mContainer);
            this.mContainer.setBackgroundColor(this.mBackGroundColor);
            changeNavIcon();
            this.hasInit = true;
            return;
        }
        if (QMLog.isColorLevel()) {
            QMLog.d(TAG, "[init] context null");
        }
    }

    private void showScreenRecordEntryGuide() {
        try {
            QMLog.i(TAG, "showScreenRecordEntryGuide");
            if (this.mMiniAppContext == null) {
                return;
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.minigame.widget.GameNavigationBar.1
                @Override // java.lang.Runnable
                public void run() {
                    GameNavigationBar gameNavigationBar = GameNavigationBar.this;
                    if (gameNavigationBar.mContainer == null) {
                        return;
                    }
                    boolean z16 = gameNavigationBar.mMiniAppContext.getMiniAppInfo().launchParam.isScreenRecordEnabled;
                    QMLog.i(GameNavigationBar.TAG, "switch:" + z16);
                    if (!z16) {
                        return;
                    }
                    GameNavigationBar gameNavigationBar2 = GameNavigationBar.this;
                    GuideBubbleView b16 = gameNavigationBar2.mGuideViewCtrl.b(0, gameNavigationBar2.getContext());
                    if (b16 != null) {
                        b16.setId(R.id.screen_record_entry_guide_bubble);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(3, R.id.container_top_btns);
                        layoutParams.topMargin = DisplayUtil.dip2px(GameNavigationBar.this.getContext(), 1.0f);
                        layoutParams.rightMargin = DisplayUtil.dip2px(GameNavigationBar.this.getContext(), 12.5f);
                        layoutParams.addRule(11, -1);
                        GameNavigationBar.this.mContainer.addView(b16, layoutParams);
                    }
                }
            }, 6000L);
        } catch (Throwable th5) {
            QMLog.e(TAG, "showScreenRecordEntryGuide errors:" + th5);
        }
    }

    private void updateBarStyle() {
        if ("custom".equals(this.mBarStyle)) {
            setNavBackgroundColor(0);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public void attachMiniAppContext(IMiniAppContext iMiniAppContext) {
        this.mCapsuleButton.setListener(new GameCapsuleButtonClickListener(iMiniAppContext));
        this.mMiniAppContext = iMiniAppContext;
        showScreenRecordEntryGuide();
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public void requestLandscapeLayout() {
        ((RelativeLayout.LayoutParams) this.mCapsuleButton.getLayoutParams()).topMargin = DisplayUtil.dip2px(getContext(), 9.0f);
    }

    public void requestPortraitLayout() {
        int i3;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCapsuleButton.getLayoutParams();
        int dip2px = DisplayUtil.dip2px(getContext(), 9.0f);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            i3 = DisplayUtil.getStatusBarHeight(getContext());
        } else {
            i3 = 0;
        }
        layoutParams.topMargin = dip2px + i3;
    }

    public GameNavigationBar setBarStyle(String str) {
        this.mBarStyle = str;
        updateBarStyle();
        return this;
    }

    public GameNavigationBar setNavBackgroundColor(int i3) {
        this.mBackGroundColor = i3;
        RelativeLayout relativeLayout = this.mContainer;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i3);
        }
        return this;
    }

    public GameNavigationBar setTextStyle(String str) {
        if ("black".equals(str)) {
            this.mBarTextStyle = -16777216;
        } else if ("white".equals(str)) {
            this.mBarTextStyle = -1;
        }
        changeNavIcon();
        return this;
    }

    public GameNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public CapsuleButton getCapsuleButton() {
        return this.mCapsuleButton;
    }

    @Override // com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public GameNavigationBar setWindowInfo(WindowInfo windowInfo) {
        NavigationBarInfo navigationBarInfo;
        if (windowInfo != null && (navigationBarInfo = windowInfo.navigationBarInfo) != null) {
            if (!TextUtils.isEmpty(navigationBarInfo.textStyle)) {
                setTextStyle(navigationBarInfo.textStyle);
            }
            setNavBackgroundColor(navigationBarInfo.backgoundColor);
            if (!TextUtils.isEmpty(navigationBarInfo.style)) {
                setBarStyle(navigationBarInfo.style);
            }
        }
        return this;
    }

    public GameNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mGuideViewCtrl = new GuideBubbleViewCtrl();
        this.mBackGroundColor = -16777216;
        this.mBarTextStyle = -1;
        this.hasInit = false;
        init();
    }
}
