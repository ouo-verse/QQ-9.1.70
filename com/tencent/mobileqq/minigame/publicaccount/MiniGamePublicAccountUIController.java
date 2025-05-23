package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountViewPagerIndicator;
import com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy1HeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.adapter.WebUiStrategy2HeaderAdapter;
import com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy1GameCenter;
import com.tencent.mobileqq.minigame.publicaccount.gamecenter.WebUiStrategy2GameCenter;
import com.tencent.mobileqq.minigame.publicaccount.strategy.MiniGameUiStrategy;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy1;
import com.tencent.mobileqq.minigame.publicaccount.strategy.WebUiStrategy2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

@Deprecated
/* loaded from: classes33.dex */
public class MiniGamePublicAccountUIController {
    private static final String TAG = "MiniGamePublicAccountUIController";
    public static final int UI_STRATEGY_WEB_1 = 1;
    public static final int UI_STRATEGY_WEB_2 = 2;
    private MiniGamePublicAccountWebFragment mFragment;
    private int mUiStrategy;

    public MiniGamePublicAccountUIController(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        this.mFragment = miniGamePublicAccountWebFragment;
        this.mUiStrategy = MiniGamePublicAccountHelper.shouldUseWebStrategy2() ? 2 : 1;
        QLog.d(TAG, 1, "init, uiStrategy = " + this.mUiStrategy);
    }

    public BaseHeaderAdapter createAdapter(Activity activity) {
        if (this.mUiStrategy != 1) {
            return new WebUiStrategy2HeaderAdapter(activity);
        }
        return new WebUiStrategy1HeaderAdapter(activity);
    }

    public MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig getIndicatorViewConfig() {
        MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig indicatorViewConfig = new MiniGamePublicAccountViewPagerIndicator.IndicatorViewConfig();
        if (this.mUiStrategy != 1) {
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                indicatorViewConfig.normalColor = Color.parseColor("#303030");
                indicatorViewConfig.selectedColor = Color.parseColor("#0983FF");
            } else {
                indicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
                indicatorViewConfig.selectedColor = Color.parseColor("#3EAFFF");
            }
            indicatorViewConfig.normalWidth = ViewUtils.dpToPx(14.0f);
            indicatorViewConfig.selectedWidth = ViewUtils.dpToPx(14.0f);
        } else {
            indicatorViewConfig.normalColor = Color.parseColor("#D0D8F2");
            indicatorViewConfig.selectedColor = Color.parseColor("#3857FF");
            indicatorViewConfig.normalWidth = ViewUtils.dpToPx(14.0f);
            indicatorViewConfig.selectedWidth = ViewUtils.dpToPx(32.0f);
        }
        return indicatorViewConfig;
    }

    public void initGameCenter(Activity activity, View view, MiniGamePublicAccountWebView miniGamePublicAccountWebView) {
        if (this.mUiStrategy != 1) {
            new WebUiStrategy2GameCenter().initView(activity, view, miniGamePublicAccountWebView);
        } else {
            new WebUiStrategy1GameCenter().initView(activity, view);
        }
    }

    public void setupStrategy() {
        MiniGameUiStrategy webUiStrategy1;
        if (this.mUiStrategy != 1) {
            webUiStrategy1 = new WebUiStrategy2();
        } else {
            webUiStrategy1 = new WebUiStrategy1();
        }
        webUiStrategy1.setup(this.mFragment);
    }
}
