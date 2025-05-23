package com.tencent.mobileqq.filemanager.data.search.troop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.e;
import com.tencent.mobileqq.filemanager.widget.QFileListPullMoreLayout;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import java.util.List;
import qn2.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TroopFileSearchFragment extends BaseSearchFragment<y> implements e, AbsListView.OnScrollListener {
    public int C;
    public long D;
    private TroopFileSearchEngine E;
    private b F;
    private QFileListPullMoreLayout I;
    private int G = 0;
    private int H = 0;
    protected com.tencent.mobileqq.app.c J = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends com.tencent.mobileqq.app.c {
        a() {
        }

        @Override // com.tencent.mobileqq.app.c
        protected void g(Object obj) {
            TroopFileSearchFragment.this.F.notifyDataSetChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    private class b extends mn2.a<y, sn2.c> {
        public b() {
        }

        @Override // mn2.a
        protected d<y, sn2.c> e(int i3) {
            boolean z16;
            com.tencent.mobileqq.filemanager.data.search.troop.b bVar = new com.tencent.mobileqq.filemanager.data.search.troop.b();
            if (TroopFileSearchFragment.this.C == 13) {
                z16 = true;
            } else {
                z16 = false;
            }
            bVar.f207960d = z16;
            return bVar;
        }

        @Override // mn2.a
        protected sn2.d f(int i3, ViewGroup viewGroup) {
            return new c(viewGroup);
        }
    }

    private void qh(boolean z16) {
        if (z16) {
            this.I.setVisibility(0);
            this.I.setTextLeftDrawable(R.drawable.f160545jt);
        } else {
            this.I.setVisibility(8);
            this.I.a();
        }
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return HardCodeUtil.qqStr(R.string.jzn);
    }

    @Override // com.tencent.mobileqq.filemanager.data.search.e
    public String getSearchKeyword() {
        return this.keyword;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        b bVar = new b();
        this.F = bVar;
        return bVar;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        TroopFileSearchEngine troopFileSearchEngine = new TroopFileSearchEngine((QQAppInterface) this.appInterface, getQBaseActivity(), this.D, this.C, this);
        this.E = troopFileSearchEngine;
        troopFileSearchEngine.G(1);
        return this.E;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fragmentView.findViewById(R.id.d3z).setVisibility(8);
        this.listView.setOnScrollListener(this);
        QFileListPullMoreLayout qFileListPullMoreLayout = new QFileListPullMoreLayout(getQBaseActivity());
        this.I = qFileListPullMoreLayout;
        qFileListPullMoreLayout.setBackgroundResource(R.drawable.bg_texture);
        this.I.setTextColor(getResources().getColor(R.color.skin_black));
        this.listView.addFooterView(this.I);
        this.I.setVisibility(8);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        TroopFileSearchEngine troopFileSearchEngine = this.E;
        if (troopFileSearchEngine != null) {
            troopFileSearchEngine.destroy();
        }
        com.tencent.mobileqq.app.c cVar = this.J;
        if (cVar != null) {
            this.appInterface.removeObserver(cVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        TroopFileSearchEngine troopFileSearchEngine = this.E;
        if (troopFileSearchEngine != null) {
            troopFileSearchEngine.pause();
        }
        com.tencent.mobileqq.app.c cVar = this.J;
        if (cVar != null) {
            this.appInterface.removeObserver(cVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TroopFileSearchEngine troopFileSearchEngine = this.E;
        if (troopFileSearchEngine != null) {
            troopFileSearchEngine.resume();
        }
        com.tencent.mobileqq.app.c cVar = this.J;
        if (cVar != null) {
            this.appInterface.addObserver(cVar);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        this.H = i17;
        this.G = ((i3 + i16) - 1) - 1;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        List<M> list;
        if (i3 == 0 && (list = this.mResultList) != 0 && !list.isEmpty() && this.G == this.H - 2 && !this.E.z(this.keyword)) {
            this.E.E(this.keyword);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoMoreResult(boolean z16) {
        if (!this.E.z(this.keyword) && z16) {
            qh(true);
        } else {
            qh(false);
            super.showNoMoreResult(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoResultLayout(boolean z16) {
        qh(false);
        super.showNoResultLayout(z16);
    }
}
