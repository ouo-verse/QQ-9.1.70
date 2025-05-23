package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.view.Window;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildBaseTransFragment extends QPublicBaseFragment {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.fragment.GuildBaseTransFragment$1, reason: invalid class name */
    /* loaded from: classes13.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ GuildBaseTransFragment this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.getActivity() != null && !this.this$0.getActivity().isFinishing()) {
                this.this$0.getActivity().finish();
                this.this$0.getActivity().overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (QQTheme.isNowThemeIsNight()) {
            ph(activity, ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(activity, R.color.bnj));
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            ph(activity, -1);
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
