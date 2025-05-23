package com.tencent.mobileqq.minigame.publicaccount.strategy;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes33.dex */
public class WebUiStrategy1 implements MiniGameUiStrategy {
    @Override // com.tencent.mobileqq.minigame.publicaccount.strategy.MiniGameUiStrategy
    public void setup(MiniGamePublicAccountWebFragment miniGamePublicAccountWebFragment) {
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            SystemBarActivityModule.setSystemBarComp(miniGamePublicAccountWebFragment.getBaseActivity(), null);
            SystemBarActivityModule.setImmersiveStatus(miniGamePublicAccountWebFragment.getBaseActivity(), 0);
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setStatusTextColor(true, miniGamePublicAccountWebFragment.getActivity().getWindow());
        }
        miniGamePublicAccountWebFragment.rootView.setBackgroundColor(-1);
        miniGamePublicAccountWebFragment.headerLayoutBg.setBackgroundResource(R.drawable.ip5);
        miniGamePublicAccountWebFragment.layoutTitleBar.setBackgroundResource(R.color.f88886);
        miniGamePublicAccountWebFragment.titleBar.setTitleBarTransparent();
        miniGamePublicAccountWebFragment.titleBar.getLeftBackIcon().setBackgroundResource(R.drawable.f162358dg3);
        miniGamePublicAccountWebFragment.titleBar.setRightImage(miniGamePublicAccountWebFragment.getResources().getDrawable(R.drawable.dfq), null);
        miniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, miniGamePublicAccountWebFragment.getResources().getDrawable(R.drawable.cii), (Drawable) null);
        miniGamePublicAccountWebFragment.moreMsgBtn.setCompoundDrawablePadding(x.c(miniGamePublicAccountWebFragment.getActivity(), 5.0f));
    }
}
