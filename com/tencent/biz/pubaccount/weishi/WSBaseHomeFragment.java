package com.tencent.biz.pubaccount.weishi;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.a;
import com.tencent.biz.pubaccount.weishi.d;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class WSBaseHomeFragment<V extends com.tencent.biz.pubaccount.weishi.a, P extends d<V>, M> extends WSBaseFragment<V, P> implements v00.b<M> {
    protected Context M;
    protected View N;
    protected XRecyclerView P;
    private View Q;
    protected boolean R = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements XRecyclerView.RefreshCallback {
        a() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
            WSBaseHomeFragment.this.endOfRefresh();
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView xRecyclerView, int i3) {
            WSBaseHomeFragment.this.Hh(xRecyclerView, i3);
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView xRecyclerView, boolean z16) {
            WSBaseHomeFragment.this.Ih(xRecyclerView, z16);
        }
    }

    private void initView(View view) {
        if (this.L) {
            view.setBackgroundColor(this.M.getResources().getColor(R.color.black));
        }
        this.Q = view.findViewById(R.id.xal);
        XRecyclerView xRecyclerView = (XRecyclerView) view.findViewById(R.id.f125537mb);
        this.P = xRecyclerView;
        if (xRecyclerView != null) {
            LoadingMoreHelper loadMoreLayoutHelper = xRecyclerView.getLoadMoreLayoutHelper();
            if (loadMoreLayoutHelper != null) {
                loadMoreLayoutHelper.setPreLoaderCount(12);
            }
            this.P.setRefreshCallback(new a());
            RecyclerViewWithHeaderFooter recyclerView = this.P.getRecyclerView();
            if (Eh() != null) {
                recyclerView.setAdapter(Eh());
            }
            if (Fh() != null) {
                recyclerView.setLayoutManager(Fh());
            }
        }
    }

    protected abstract void Dh(Bundle bundle);

    protected abstract BaseAdapter Eh();

    protected abstract RecyclerView.LayoutManager Fh();

    protected abstract void Gh(View view);

    protected abstract void Hh(XRecyclerView xRecyclerView, int i3);

    protected abstract void Ih(XRecyclerView xRecyclerView, boolean z16);

    protected abstract void endOfRefresh();

    protected int getLayoutResId() {
        return -1;
    }

    @Override // v00.b
    public void hideLoading() {
        View view = this.Q;
        if (view == null || !view.isShown()) {
            return;
        }
        this.Q.setVisibility(8);
    }

    public abstract void loadData();

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.M = getBaseActivity();
        if (getArguments() != null) {
            Dh(getArguments());
        }
        if (getLayoutResId() != -1) {
            this.N = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        } else {
            this.N = layoutInflater.inflate(R.layout.fwa, viewGroup, false);
        }
        return this.N;
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(this.N);
        Gh(this.N);
        loadData();
    }

    @Override // v00.b
    public void showLoading() {
        View view = this.Q;
        if (view == null || view.isShown()) {
            return;
        }
        this.Q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment
    public boolean xh() {
        if (uy.a.f440578a.f()) {
            return false;
        }
        return super.xh();
    }
}
