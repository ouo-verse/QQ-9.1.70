package com.tencent.mobileqq.guild.channel.frame;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.pad.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import uf1.a;

/* loaded from: classes12.dex */
public class GuildPostsLoadFragment extends QPublicBaseFragment implements f {
    private a C;
    private View D;

    private void ph() {
        tf1.a aVar = (tf1.a) ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getGuildPostLoadHandler();
        if (aVar == null) {
            QLog.e("Guild.jump.GuildPostsLoadFragment", 1, "launchPostsFragment: get loadHandler error.");
            return;
        }
        Fragment a16 = aVar.a(getArguments());
        int i3 = getArguments().getInt("guild_posts_type", 0);
        if (a16 != null && getHost() != null && a16.getArguments() != null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.trw, a16, aVar.b(i3));
            beginTransaction.commitAllowingStateLoss();
        } else {
            if (getActivity() != null) {
                getActivity().finish();
            }
            QLog.e("Guild.jump.GuildPostsLoadFragment", 1, "launchPostsFragment: get fragment error.");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (QQTheme.isNowThemeIsNight()) {
            qh(activity, QQGuildUIUtil.i(activity, R.color.bnj));
            ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
        } else {
            qh(activity, -1);
            ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        }
        if (activity.getIntent().getBooleanExtra("jumpGuildFromLoadingPage", false)) {
            activity.overridePendingTransition(R.anim.l_, R.anim.l_);
        } else if (!this.C.f()) {
            activity.overridePendingTransition(R.anim.f154606oe, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        a aVar = this.C;
        if (aVar != null) {
            aVar.b();
        }
        ph();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view = this.D;
        if (view == null) {
            this.D = layoutInflater.inflate(R.layout.f3r, (ViewGroup) null);
        } else if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.D.getParent()).removeView(this.D);
        }
        View view2 = this.D;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view2);
        return view2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.C;
        if (aVar != null) {
            aVar.c(true);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        a aVar = this.C;
        if (aVar != null && !aVar.g() && getActivity() != null) {
            getActivity().overridePendingTransition(0, R.anim.f154607of);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z16) {
        super.onHiddenChanged(z16);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        ph();
    }

    public void qh(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    @Override // androidx.fragment.app.Fragment, com.tencent.mobileqq.auto.engine.main.IASFragment
    public void setArguments(@Nullable Bundle bundle) {
        super.setArguments(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && !arguments.isEmpty()) {
            a aVar = this.C;
            if (aVar == null) {
                this.C = new a(arguments);
                return;
            } else {
                aVar.m(arguments);
                return;
            }
        }
        QLog.e("Guild.jump.GuildPostsLoadFragment", 1, "setArguments: get paramsBundle error.");
    }
}
