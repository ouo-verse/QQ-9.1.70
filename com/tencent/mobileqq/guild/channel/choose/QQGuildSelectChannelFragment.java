package com.tencent.mobileqq.guild.channel.choose;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mf1.b;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildSelectChannelFragment extends QQGuildTitleBarFragment implements View.OnClickListener {
    private OverScrollRecyclerView T;
    private kf1.a U;
    private b V;
    private String W;
    private String X;
    private Activity Y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements Observer<List<lf1.a>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(List<lf1.a> list) {
            QQGuildSelectChannelFragment.this.Fh(list);
        }
    }

    private void Eh() {
        this.V.P1().observe(getViewLifecycleOwner(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(List<lf1.a> list) {
        if (list != null && list.size() > 0) {
            this.U.setData(list);
        }
    }

    private void initData() {
        if (this.Y == null) {
            return;
        }
        this.V = (b) h.b(this, b.D).get(b.class);
        this.W = this.Y.getIntent().getStringExtra("extra_guild_id");
        this.X = this.Y.getIntent().getStringExtra("extra_select_channel_origin_param");
        if (!TextUtils.isEmpty(this.W)) {
            this.V.Q1(this.W);
        }
        kf1.a aVar = new kf1.a();
        this.U = aVar;
        aVar.m0(this);
        this.T.setAdapter(this.U);
        this.T.setLayoutManager(new LinearLayoutManager(this.Y));
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setSupportsChangeAnimations(false);
        this.T.setItemAnimator(defaultItemAnimator);
        this.U.setData(this.V.O1(this.W));
    }

    private void initView() {
        if (getActivity() != null) {
            this.Y = getActivity();
        }
        this.T = (OverScrollRecyclerView) this.P.findViewById(R.id.xfj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getResources().getString(R.string.f155631i1));
        initView();
        initData();
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168181f83;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        lf1.a aVar = (lf1.a) view.getTag();
        if (aVar != null && aVar.f414445c != null) {
            Intent intent = new Intent();
            intent.putExtra("extra_key_return_selected_channel_id", aVar.f414445c.getChannelUin());
            intent.putExtra("extra_key_return_selected_channel_old_param", this.X);
            this.Y.setResult(-1, intent);
            this.Y.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
