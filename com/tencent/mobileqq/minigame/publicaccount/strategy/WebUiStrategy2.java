package com.tencent.mobileqq.minigame.publicaccount.strategy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes33.dex */
public class WebUiStrategy2 implements MiniGameUiStrategy {
    private static final boolean ENABLE_DARK_THEME = false;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Strategy2Config {
        public static final float ITEM_HEIGHT_WIDTH_RATE = 0.911f;
        public static final int ITEM_MARGIN_LEFT = 15;
        private static final String TAG = "Strategy2Config";
        public static final int VIEWPAGER_PADDING_RIGHT = 30;
        public static int arkViewWidth;
        public static int viewPagerItemHeight;
        public static int viewPagerItemMarginLeft;
        public static float viewPagerWidth;

        public static void init(Context context) {
            int i3 = x.f(context).f185860a;
            int c16 = x.c(context, 30.0f);
            int c17 = x.c(context, 15.0f);
            viewPagerItemMarginLeft = c17;
            int i16 = (i3 - (c17 * 2)) - c16;
            arkViewWidth = i16;
            viewPagerItemHeight = (int) (i16 * 0.911f);
            viewPagerWidth = ((i3 - c17) * 1.0f) / i3;
        }
    }

    private Resources getResources(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        return miniGamePublicAccountWebFragment.getResources();
    }

    @Override // com.tencent.mobileqq.minigame.publicaccount.strategy.MiniGameUiStrategy
    public void setup(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        Strategy2Config.init(miniGamePublicAccountWebFragment.getActivity());
        ThemeUtil.isNowThemeIsNight(null, false, null);
        setupLightTheme(miniGamePublicAccountWebFragment);
        miniGamePublicAccountWebFragment.viewPager.setClipToPadding(false);
        miniGamePublicAccountWebFragment.viewPager.setPadding(0, 0, x.c(miniGamePublicAccountWebFragment.getActivity(), 30.0f), 0);
        miniGamePublicAccountWebFragment.viewPager.getLayoutParams().height = Strategy2Config.viewPagerItemHeight;
    }

    private void setupDarkTheme(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        setupStatusBar(miniGamePublicAccountWebFragment, true);
        miniGamePublicAccountWebFragment.rootView.setBackgroundColor(-16777216);
        miniGamePublicAccountWebFragment.titleBar.changeBg(false);
        miniGamePublicAccountWebFragment.navTitle.setTextColor(-1);
        miniGamePublicAccountWebFragment.titleBar.setRightImage(getResources(miniGamePublicAccountWebFragment).getDrawable(R.drawable.b4o), null);
        miniGamePublicAccountWebFragment.moreMsgText.setTextColor(-1);
        miniGamePublicAccountWebFragment.moreMsgBtn.setTextColor(Color.parseColor("#7C7B82"));
        miniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources(miniGamePublicAccountWebFragment).getDrawable(R.drawable.iqe), (Drawable) null);
        miniGamePublicAccountWebFragment.headLayout.setBackgroundColor(-16777216);
        miniGamePublicAccountWebFragment.webView.setBackgroundColor(-16777216);
    }

    private void setupLightTheme(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        setupStatusBar(miniGamePublicAccountWebFragment, false);
        miniGamePublicAccountWebFragment.rootView.setBackgroundColor(-1);
        miniGamePublicAccountWebFragment.titleBar.changeBg(true);
        miniGamePublicAccountWebFragment.navTitle.setTextColor(-16777216);
        miniGamePublicAccountWebFragment.titleBar.setRightImage(getResources(miniGamePublicAccountWebFragment).getDrawable(R.drawable.hxy), null);
        miniGamePublicAccountWebFragment.moreMsgText.setTextColor(-16777216);
        miniGamePublicAccountWebFragment.moreMsgBtn.setTextColor(Color.parseColor("#878B99"));
        miniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getResources(miniGamePublicAccountWebFragment).getDrawable(R.drawable.iqd), (Drawable) null);
        miniGamePublicAccountWebFragment.headLayout.setBackgroundColor(-1);
        miniGamePublicAccountWebFragment.webView.setBackgroundColor(-1);
    }

    private void setupStatusBar(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment, boolean z16) {
        int i3 = z16 ? -16777216 : -1;
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            SystemBarActivityModule.setSystemBarComp(miniGamePublicAccountWebFragment.getBaseActivity(), null);
            SystemBarActivityModule.setImmersiveStatus(miniGamePublicAccountWebFragment.getBaseActivity(), i3);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setStatusTextColor(!z16, miniGamePublicAccountWebFragment.getActivity().getWindow());
        }
    }
}
