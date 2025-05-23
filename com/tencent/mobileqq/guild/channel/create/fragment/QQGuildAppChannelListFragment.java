package com.tencent.mobileqq.guild.channel.create.fragment;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.fragment.QQGuildAppChannelListFragment;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import nf1.b;
import qf1.a;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildAppChannelListFragment extends BaseCreateSubChannelFragment {
    private RecyclerView F;
    private b G;
    private a H;

    private void initData() {
        if (getAppInterface() == null) {
            return;
        }
        ((rf1.b) h.a(getActivity()).get(rf1.b.class)).M1().observe(this, new Observer() { // from class: pf1.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildAppChannelListFragment.this.lambda$initData$0((List) obj);
            }
        });
    }

    private void initView() {
        this.F = (RecyclerView) this.C.findViewById(R.id.std);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setOrientation(1);
        this.F.setLayoutManager(gridLayoutManager);
        b bVar = new b(getContext());
        this.G = bVar;
        bVar.k0(this.H);
        this.F.setAdapter(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$0(List list) {
        this.G.setData(list);
    }

    public static QQGuildAppChannelListFragment rh(CreateSubChannelInfo createSubChannelInfo) {
        QQGuildAppChannelListFragment qQGuildAppChannelListFragment = new QQGuildAppChannelListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_key_subchannel_info", createSubChannelInfo);
        qQGuildAppChannelListFragment.setArguments(bundle);
        return qQGuildAppChannelListFragment;
    }

    private void sh() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.F, "pg_create_sub_appchannel");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.F, this.D.f214821d, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.efm;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    protected void init() {
        initView();
        initData();
        sh();
    }

    public void th(a aVar) {
        this.H = aVar;
    }
}
