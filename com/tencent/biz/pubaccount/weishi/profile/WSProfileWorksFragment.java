package com.tencent.biz.pubaccount.weishi.profile;

import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi.event.WSChangeItemViewVisibilityEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.profile.e;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.biz.pubaccount.weishi.view.recyclerview.RecyclerViewWithHeaderFooter;
import com.tencent.biz.pubaccount.weishi.view.recyclerview.XRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import java.util.ArrayList;
import java.util.List;
import z10.a;

/* loaded from: classes32.dex */
public class WSProfileWorksFragment extends WSBaseFragment<g, h> implements g, wz.c, com.tencent.biz.pubaccount.weishi.ui.a {
    private XRecyclerView M;
    private View N;
    private TextView P;
    private View Q;
    private View R;
    private GridLayoutManager S;
    private e T;
    private j U;
    private int V;
    private String W;
    private boolean X;
    private boolean Y = true;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f81271a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f81272b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f81273c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements e.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.profile.e.a
        public void a(z10.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar) {
            WSProfileWorksFragment.this.Xh(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements a.InterfaceC11644a {
        c() {
        }

        @Override // z10.a.InterfaceC11644a
        public void onItemClick(View view, int i3) {
            String str;
            String str2;
            if (WSProfileWorksFragment.this.Vh()) {
                str = "personal_main";
            } else {
                str = "personal_guest";
            }
            if (WSProfileWorksFragment.this.Vh()) {
                str2 = "homepage_main";
            } else {
                str2 = "homepage_guest";
            }
            a.b.c(new k(WSProfileWorksFragment.this.getContext(), str, str2).M(i3).Q(WSProfileWorksFragment.this.V).T(WSProfileWorksFragment.this.getPresenter().D0()).R(WSProfileWorksFragment.this.W).C(view).J(WSProfileWorksFragment.this.Th(i3)));
            WSProfileWorksFragment.this.Yh(i3, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (WSProfileWorksFragment.this.T != null) {
                WSProfileWorksFragment.this.T.s0();
            }
            WSProfileWorksFragment.this.Rh(true, true);
            WSProfileWorksFragment.this.R.setVisibility(8);
            WSProfileWorksFragment.this.showLoading();
        }
    }

    private void Mh() {
        View inflate = View.inflate(getBaseActivity(), R.layout.fx5, null);
        TextView textView = (TextView) inflate.findViewById(R.id.xux);
        int size = this.Z - this.T.getDataList().size();
        if (size > 0) {
            textView.setText(getResources().getString(R.string.x9k, Integer.valueOf(size)));
        } else {
            textView.setText(R.string.f161501xw);
        }
        this.T.i0(inflate);
    }

    private void Nh(WSChangeItemViewVisibilityEvent wSChangeItemViewVisibilityEvent) {
        XRecyclerView xRecyclerView;
        RecyclerViewWithHeaderFooter h16;
        stSimpleMetaFeed o16;
        if (!this.X) {
            x.j("WSProfileWorksFragmentLog", "changeItemViewVisibility() page is not selected.");
            return;
        }
        if (this.T == null || (xRecyclerView = this.M) == null || (h16 = xRecyclerView.h()) == null) {
            return;
        }
        for (int i3 = 0; i3 < h16.getChildCount(); i3++) {
            RecyclerView.ViewHolder childViewHolder = h16.getChildViewHolder(h16.getChildAt(i3));
            if ((childViewHolder instanceof f) && (o16 = ((f) childViewHolder).o()) != null && !TextUtils.isEmpty(wSChangeItemViewVisibilityEvent.getFeedId()) && wSChangeItemViewVisibilityEvent.getFeedId().equals(o16.f25129id)) {
                childViewHolder.itemView.setVisibility(wSChangeItemViewVisibilityEvent.getIsShow() ? 0 : 4);
                return;
            }
        }
    }

    private void Oh() {
        View view = this.N;
        if (view != null && view.isShown()) {
            this.N.setVisibility(8);
        }
        View view2 = this.R;
        if (view2 == null || !view2.isShown()) {
            return;
        }
        this.R.setVisibility(8);
    }

    public static WSProfileWorksFragment Ph(int i3, String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("key_page_type", i3);
        bundle.putString("key_page_from", str);
        intent.putExtras(bundle);
        WSProfileWorksFragment wSProfileWorksFragment = new WSProfileWorksFragment();
        wSProfileWorksFragment.setArguments(intent.getExtras());
        return wSProfileWorksFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<stSimpleMetaFeed> Th(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = this.T.getItem(Math.max(i3, 0));
        if (item == null) {
            return null;
        }
        stSimpleMetaFeed e16 = item.e();
        ArrayList arrayList = new ArrayList();
        arrayList.add(e16);
        return arrayList;
    }

    private void Uh() {
        LoadingMoreHelper loadMoreLayoutHelper = this.M.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(18);
        }
        this.S = new GridLayoutManager(this.C, 3);
        this.T = new e(this.C);
        this.M.setRefreshEnable(false);
        RecyclerViewWithHeaderFooter h16 = this.M.h();
        this.T.z0(this.f81272b0);
        h16.setAdapter(this.T);
        this.T.A0(new a());
        h16.setLayoutManager(this.S);
        h16.setItemAnimator(null);
        h16.addItemDecoration(new z10.e(ba.f81728c));
        this.M.setRefreshCallback(new b());
        this.T.q0(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vh() {
        return TextUtils.equals(bb.q(), this.W);
    }

    private boolean Wh(int i3, boolean z16, boolean z17) {
        int size = this.T.getDataList().size();
        return size - ((z16 || z17) ? size : Sh(this.M.h())) <= i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh(final z10.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar) {
        bVar.itemView.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.profile.WSProfileWorksFragment.4
            @Override // java.lang.Runnable
            public void run() {
                int adapterPosition = bVar.getAdapterPosition();
                if (adapterPosition <= WSProfileWorksFragment.this.S.findLastVisibleItemPosition()) {
                    WSProfileWorksFragment.this.Yh(adapterPosition, 1);
                }
            }
        });
    }

    private void bi() {
        String string;
        if (getPageType() == 1) {
            this.P.setText(Vh() ? R.string.x9j : R.string.x9o);
            return;
        }
        if (!this.Y) {
            if (Vh()) {
                string = getResources().getString(R.string.x9h);
            } else {
                string = getResources().getString(R.string.x9i);
            }
        } else if (Vh()) {
            string = getResources().getString(R.string.x9h);
        } else {
            string = getResources().getString(R.string.x9n);
        }
        this.P.setText(string);
    }

    private void gi() {
        int i3 = this.V;
        if (i3 == 1) {
            Rh(true, true);
            return;
        }
        if (i3 != 2) {
            return;
        }
        if (!Vh() && !this.Y) {
            this.N.setVisibility(0);
            bi();
        } else {
            Rh(true, true);
        }
    }

    private boolean hi(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        Oh();
        if ((z17 || z16) && list.size() == 0) {
            this.N.setVisibility(0);
            bi();
            return true;
        }
        this.N.setVisibility(8);
        return false;
    }

    private void showErrorView() {
        Oh();
        this.R.setVisibility(0);
        this.R.setOnClickListener(new d());
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Cb() {
        if (!this.X) {
            gi();
        }
        this.X = true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.b
    /* renamed from: Qh, reason: merged with bridge method [inline-methods] */
    public h V() {
        h hVar = new h();
        hVar.F0(this.W);
        return hVar;
    }

    public void Rh(boolean z16, boolean z17) {
        e eVar;
        if (this.f81271a0) {
            return;
        }
        this.f81271a0 = true;
        getPresenter().B0(this.W, this.V, z16, z17);
        if (!z16 || (eVar = this.T) == null) {
            return;
        }
        eVar.p0();
    }

    public void ai(String str, boolean z16) {
        this.f81272b0 = str;
        e eVar = this.T;
        if (eVar == null) {
            return;
        }
        eVar.z0(str);
        if (z16) {
            this.T.notifyDataSetChanged();
        }
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        e eVar;
        j jVar = this.U;
        if (jVar == null || (eVar = this.T) == null) {
            return;
        }
        if (wSSimpleBaseEvent instanceof FollowEvent) {
            jVar.m((FollowEvent) wSSimpleBaseEvent, eVar.getDataList());
            return;
        }
        if (wSSimpleBaseEvent instanceof LikeRspEvent) {
            jVar.o((LikeRspEvent) wSSimpleBaseEvent, eVar.getDataList());
        } else if (wSSimpleBaseEvent instanceof WSAddCommentEvent) {
            jVar.k((WSAddCommentEvent) wSSimpleBaseEvent, eVar.getDataList());
        } else if (wSSimpleBaseEvent instanceof WSChangeItemViewVisibilityEvent) {
            Nh((WSChangeItemViewVisibilityEvent) wSSimpleBaseEvent);
        }
    }

    public void ci(String str) {
        this.f81273c0 = str;
    }

    public void di(String str) {
        this.W = str;
    }

    public void ei(boolean z16) {
        this.Y = z16;
    }

    public void fi(int i3) {
        this.Z = i3;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(FollowEvent.class);
        arrayList.add(LikeRspEvent.class);
        arrayList.add(WSAddCommentEvent.class);
        arrayList.add(WSChangeItemViewVisibilityEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.g
    public int getPageType() {
        return this.V;
    }

    @Override // v00.b
    public void hideLoading() {
        View view = this.Q;
        if (view == null || !view.isShown()) {
            return;
        }
        this.Q.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ba.B(configuration, "WSProfileWorksFragment");
        this.T.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.V = getArguments().getInt("key_page_type");
            this.f81273c0 = getArguments().getString("key_page_from");
        }
        wz.b.b().d(this);
        this.U = new j();
    }

    @Override // com.tencent.biz.pubaccount.weishi.WSBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        wz.b.b().f(this);
    }

    @Override // v00.b
    public void showLoading() {
        View view = this.Q;
        if (view == null || view.isShown()) {
            return;
        }
        this.Q.setVisibility(0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.g
    public void Q0(int i3, String str, boolean z16) {
        e eVar;
        this.f81271a0 = false;
        if (z16 && (eVar = this.T) != null && eVar.getDataList().size() == 0) {
            showErrorView();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.profile.g
    public void Q1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, boolean z18) {
        this.f81271a0 = false;
        if (this.R.isShown()) {
            this.R.setVisibility(8);
        }
        this.M.loadMoreComplete(true, z18);
        if (hi(z16, z17, list)) {
            return;
        }
        if (!z16 && !z17) {
            this.T.r0(list);
        } else {
            this.T.t0(list);
            this.M.backToTopAtOnce();
        }
        if (!z18) {
            Mh();
        } else if (Wh(18, z16, z17)) {
            Rh(false, false);
        }
    }

    public void Zh() {
        this.f81271a0 = false;
        if (this.X) {
            Rh(false, true);
        }
    }

    public void resetData() {
        this.W = null;
        this.X = false;
        this.Y = true;
        this.f81271a0 = false;
        this.Z = 0;
        View view = this.N;
        if (view != null && view.isShown()) {
            this.N.setVisibility(8);
        }
        View view2 = this.R;
        if (view2 != null && view2.isShown()) {
            this.R.setVisibility(8);
        }
        e eVar = this.T;
        if (eVar != null) {
            eVar.p0();
            this.M.loadMoreComplete(true, false);
            this.T.s0();
        }
        if (getPresenter() != null) {
            getPresenter().E0();
        }
    }

    private int Sh(RecyclerView recyclerView) {
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh(int i3, int i16) {
        stSimpleMetaFeed e16;
        String str;
        int i17 = i3 + 1;
        e eVar = this.T;
        if (i3 < 0) {
            i3 = 0;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = eVar.getItem(i3);
        if (item == null || (e16 = item.e()) == null) {
            return;
        }
        boolean equals = TextUtils.equals(e16.f25129id, this.f81272b0);
        if (this.V == 1) {
            str = "works";
        } else {
            str = "like";
        }
        String str2 = str;
        String str3 = "homepage_video" + i17;
        if (i16 == 1) {
            com.tencent.biz.pubaccount.weishi.profile.b.y(this.f81273c0, str3, e16.f25129id, this.W, str2, equals ? 1 : 0);
        } else {
            if (i16 != 2) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.profile.b.x(this.f81273c0, str3, e16.f25129id, this.W, str2, equals ? 1 : 0);
        }
    }

    private void initView(View view) {
        XRecyclerView xRecyclerView = (XRecyclerView) view.findViewById(R.id.p65);
        this.M = xRecyclerView;
        xRecyclerView.setIsAutoScrolling(true);
        this.N = view.findViewById(R.id.f163260p54);
        this.P = (TextView) view.findViewById(R.id.p8b);
        this.Q = view.findViewById(R.id.p5f);
        this.R = view.findViewById(R.id.f163259p53);
        Uh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.d0w, viewGroup, false);
        initView(inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements XRecyclerView.c {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.recyclerview.XRecyclerView.c
        public void b(XRecyclerView xRecyclerView, int i3) {
            WSProfileWorksFragment.this.Rh(false, false);
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.recyclerview.XRecyclerView.c
        public void endOfRefresh() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.recyclerview.XRecyclerView.c
        public void a(XRecyclerView xRecyclerView, boolean z16) {
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.ui.a
    public void Y0() {
    }
}
