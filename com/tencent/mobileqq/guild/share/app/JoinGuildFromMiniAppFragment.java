package com.tencent.mobileqq.guild.share.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment;
import com.tencent.mobileqq.guild.share.app.JoinGuildFromMiniAppFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes14.dex */
public class JoinGuildFromMiniAppFragment extends BaseCreateSubChannelFragment {
    public static final int N = QQGuildUIUtil.f(57.0f);
    private LinearLayout F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private View J;
    private String K;
    private String L;
    private IQQGuildRouterApi.MiniAppJoinGuildDialogCallback M;

    private void initView() {
        this.F = (LinearLayout) this.C.findViewById(R.id.w1b);
        this.G = (ImageView) this.C.findViewById(R.id.f165438w03);
        this.H = (TextView) this.C.findViewById(R.id.f165583ws3);
        this.I = (TextView) this.C.findViewById(R.id.yab);
        final Context context = getContext();
        if (context == null) {
            return;
        }
        this.G.setImageDrawable(th(getContext(), this.L));
        this.H.setText(this.K);
        this.F.setOnClickListener(new View.OnClickListener() { // from class: k02.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGuildFromMiniAppFragment.this.lambda$initView$0(view);
            }
        });
        this.I.setOnClickListener(new View.OnClickListener() { // from class: k02.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGuildFromMiniAppFragment.this.uh(context, view);
            }
        });
        View findViewById = this.C.findViewById(R.id.f164814ty2);
        this.J = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: k02.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                JoinGuildFromMiniAppFragment.this.vh(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.M.onGuildCardClick();
        EventCollector.getInstance().onViewClicked(view);
    }

    private Drawable th(Context context, String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mKeyAddWHSuffix = false;
        int i3 = N;
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i3;
        obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.coo);
        obtain.mLoadingDrawable = context.getResources().getDrawable(R.drawable.coo);
        return URLDrawable.getDrawable(str, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void uh(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intent intent = new Intent();
        intent.setAction("action_join_guild_from_mini_app_channel");
        intent.putExtra("data", "Notice me senpai!");
        context.sendBroadcast(intent);
        getActivity().finishAndRemoveTask();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        BaseDialogFragment baseDialogFragment = this.E;
        if (baseDialogFragment != null) {
            baseDialogFragment.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static JoinGuildFromMiniAppFragment wh(CreateSubChannelInfo createSubChannelInfo, String str, String str2, IQQGuildRouterApi.MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback) {
        JoinGuildFromMiniAppFragment joinGuildFromMiniAppFragment = new JoinGuildFromMiniAppFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        bundle.putString("extra_key_guild_name", str);
        bundle.putString("extra_key_guild_avatar_url", str2);
        joinGuildFromMiniAppFragment.setArguments(bundle);
        joinGuildFromMiniAppFragment.xh(miniAppJoinGuildDialogCallback);
        return joinGuildFromMiniAppFragment;
    }

    private void xh(IQQGuildRouterApi.MiniAppJoinGuildDialogCallback miniAppJoinGuildDialogCallback) {
        this.M = miniAppJoinGuildDialogCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.evg;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    protected void init() {
        initView();
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.K = arguments.getString("extra_key_guild_name", "");
        this.L = arguments.getString("extra_key_guild_avatar_url", "");
    }
}
