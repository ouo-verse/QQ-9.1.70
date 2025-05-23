package com.tencent.mobileqq.guild.setting.channeldetails;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes14.dex */
public abstract class QQGuildPaddingImmerseTitleBarFragment extends QPublicBaseFragment implements GuildChannelBaseNavBar.a {
    protected GuildChannelBaseNavBar C;
    public RelativeLayout D;
    protected View E;

    private View ph(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.eis, viewGroup, false);
        try {
            this.E = layoutInflater.inflate(getContentLayoutId(), (ViewGroup) inflate, false);
            this.D = (RelativeLayout) inflate.findViewById(R.id.f98265mm);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.D.setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.w27);
            this.D.addView(this.E, layoutParams);
        } catch (InflateException e16) {
            QLog.e("Guild.MF.End.QQGuildPaddingImmerseTitleBarFragment", 1, e16, new Object[0]);
        }
        return inflate;
    }

    @Override // com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBar.a
    public void S9(View view) {
        onBackEvent();
    }

    public AppInterface getAppInterface() {
        if (getActivity() == null || !(getQBaseActivity().getAppRuntime() instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) getQBaseActivity().getAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public abstract int getContentLayoutId();

    protected void initNavBar() {
        if (getActivity() == null) {
            return;
        }
        ((FrameLayout) getActivity().findViewById(android.R.id.content)).setForeground(ResourcesCompat.getDrawable(getResources(), R.drawable.guild_header_bar_shadow, null));
        if (isTransparent() && needImmersive() && needStatusTrans()) {
            ViewParent parent = getActivity().findViewById(android.R.id.title).getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).setVisibility(8);
            }
        }
        GuildChannelBaseNavBar guildChannelBaseNavBar = (GuildChannelBaseNavBar) this.D.findViewById(R.id.w27);
        this.C = guildChannelBaseNavBar;
        guildChannelBaseNavBar.setNavBarClickListener(this);
    }

    protected boolean isTransparent() {
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

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getActivity() == null) {
            return false;
        }
        if (AppSetting.t(getActivity()) && ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).isSplashActivityTop()) {
            getActivity().onKeyDown(4, new KeyEvent(4, 4));
        } else {
            getActivity().finish();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    @TargetApi(14)
    public final View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View ph5 = ph(layoutInflater, viewGroup);
        initNavBar();
        qh();
        doOnCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, ph5);
        return ph5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rh(CharSequence charSequence, boolean z16) {
        int i3;
        GuildChannelBaseNavBar guildChannelBaseNavBar = this.C;
        if (guildChannelBaseNavBar != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = R.drawable.guild_detail_notice_off_title_icon;
            }
            guildChannelBaseNavBar.setTitle(charSequence, i3);
        }
    }

    protected void qh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }
}
