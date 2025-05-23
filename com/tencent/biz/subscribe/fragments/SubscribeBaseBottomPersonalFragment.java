package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_COMM.COMM;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class SubscribeBaseBottomPersonalFragment extends BaseFragment {
    protected View C;
    protected BlockContainer D;
    protected a E;
    protected StatusView F;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f96054a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f96055b;

        /* renamed from: c, reason: collision with root package name */
        public COMM.StCommonExt f96056c;

        /* renamed from: d, reason: collision with root package name */
        public List<CertifiedAccountMeta$StFeed> f96057d;

        /* renamed from: e, reason: collision with root package name */
        public CertifiedAccountMeta$StFeed f96058e;

        /* renamed from: f, reason: collision with root package name */
        public CertifiedAccountMeta$StUser f96059f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f96060g;

        /* renamed from: h, reason: collision with root package name */
        public CertifiedAccountRead$StGetMainPageRsp f96061h;

        /* renamed from: i, reason: collision with root package name */
        public String f96062i;
    }

    protected abstract void initView();

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f167700lm, viewGroup, false);
        this.C = inflate;
        this.D = (BlockContainer) inflate.findViewById(R.id.byw);
        this.F = (StatusView) this.C.findViewById(R.id.f166909dx1);
        this.D.g().setNestedScrollingEnabled(true);
        this.D.c().p0(2);
        this.D.setEnableRefresh(false);
        this.D.setEnableLoadMore(true);
        this.D.setExtraTypeInfo(ph());
        this.D.setParentFragment(this);
        this.D.setLayoutManagerType(3, 2);
        initView();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    abstract ExtraTypeInfo ph();

    public abstract void qh(int i3);

    public abstract void rh(String str, a aVar);
}
