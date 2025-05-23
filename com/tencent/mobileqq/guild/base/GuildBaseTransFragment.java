package com.tencent.mobileqq.guild.base;

import android.app.Activity;
import android.view.Window;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildBaseTransFragment extends QPublicBaseFragment {
    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (QQTheme.isNowThemeIsNight()) {
            ph(activity, 0);
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            ph(activity, 0);
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    public void ph(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }
}
