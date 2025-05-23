package com.tencent.mobileqq.qqexpand.fragment;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.bean.feed.MiniAppRecommInfo;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFooterView;
import com.tencent.mobileqq.qqexpand.widget.TabLayout;
import cooperation.vip.widget.VipGeneralGdtShowView;
import java.util.ArrayList;
import java.util.List;
import yg2.g;
import yg2.h;
import yg2.i;
import yg2.j;
import yg2.k;
import yg2.l;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean C;
    private c D;
    private final RecyclerView E;
    private final Activity F;
    private int G;
    private int H;
    private MiniAppRecommInfo I;
    private g K;

    /* renamed from: d, reason: collision with root package name */
    ExtendFriendCampusVerifyTipsView.a f263799d;

    /* renamed from: e, reason: collision with root package name */
    private final yg2.d f263800e;

    /* renamed from: f, reason: collision with root package name */
    private final f f263801f;

    /* renamed from: h, reason: collision with root package name */
    private final g.c f263802h;

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.mobileqq.qqexpand.bean.feed.b f263804m;
    private int J = 0;

    /* renamed from: i, reason: collision with root package name */
    private final List<com.tencent.mobileqq.qqexpand.bean.feed.b> f263803i = new ArrayList();

    public d(yg2.d dVar, f fVar, g.c cVar, ExtendFriendCampusVerifyTipsView.a aVar, RecyclerView recyclerView, Activity activity, int i3) {
        this.f263800e = dVar;
        this.E = recyclerView;
        this.F = activity;
        this.H = i3;
        com.tencent.mobileqq.qqexpand.bean.feed.b bVar = new com.tencent.mobileqq.qqexpand.bean.feed.b();
        this.f263804m = bVar;
        bVar.mType = 1;
        this.f263801f = fVar;
        this.f263802h = cVar;
        this.f263799d = aVar;
        this.G = 0;
    }

    public void A(int i3) {
        this.G = i3;
    }

    public void B(int i3, boolean z16) {
        this.f263804m.mFooterType = i3;
        if (!z16 || this.f263803i.isEmpty()) {
            return;
        }
        notifyItemChanged(getItemCount() - 1);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size;
        if (this.C) {
            size = this.f263803i.size();
        } else {
            if (this.f263803i.isEmpty()) {
                return 0;
            }
            size = this.f263803i.size();
        }
        return size + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.f263803i.size() == 0) {
            return 2;
        }
        if (i3 >= this.f263803i.size()) {
            return 1;
        }
        if (this.f263803i.get(i3) instanceof MiniAppRecommInfo) {
            return 5;
        }
        if (this.f263803i.get(i3) instanceof yg2.e) {
            return 6;
        }
        if (this.f263803i.get(i3) instanceof i) {
            return 7;
        }
        return this.f263803i.get(i3).mAlumbasicdata != null ? 4 : 0;
    }

    public List<com.tencent.mobileqq.qqexpand.bean.feed.b> getList() {
        return this.f263803i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType == 0) {
            j jVar = (j) viewHolder;
            com.tencent.mobileqq.qqexpand.bean.feed.b bVar = this.f263803i.get(i3);
            jVar.b(jVar, bVar, i3 == 0 ? this.G : 0);
            f fVar = this.f263801f;
            if (fVar != null && fVar.M4() == i3 && !jVar.G.i()) {
                jVar.G.n();
            } else {
                jVar.G.o();
            }
            c cVar = this.D;
            if (cVar != null) {
                cVar.a(bVar.mUin);
                return;
            }
            return;
        }
        if (itemViewType == 1) {
            k kVar = (k) viewHolder;
            kVar.b(kVar, this.f263804m);
            return;
        }
        if (itemViewType == 2) {
            yg2.a aVar = (yg2.a) viewHolder;
            aVar.b(aVar, null, this.J);
            return;
        }
        if (itemViewType == 4) {
            yg2.b bVar2 = (yg2.b) viewHolder;
            bVar2.b(bVar2, this.f263803i.get(i3), i3 == 0 ? this.G : 0);
        } else if (itemViewType == 5) {
            ((l) viewHolder).c((MiniAppRecommInfo) this.f263803i.get(i3), i3 == 0 ? this.G : 0);
        } else if (itemViewType == 6) {
            ((g) viewHolder).h(this.f263803i.get(i3), i3 == 0 ? this.G : 0);
        } else {
            if (itemViewType != 7) {
                return;
            }
            ((h) viewHolder).b(this.f263803i.get(i3), i3 == 0 ? this.G : 0);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i3 == 0) {
            ExtendFriendFeedView extendFriendFeedView = new ExtendFriendFeedView(this.F);
            extendFriendFeedView.setLayoutParams(layoutParams);
            return new j(extendFriendFeedView, this.f263801f, this.f263800e, this.F);
        }
        if (i3 == 1) {
            ExtendFriendFooterView extendFriendFooterView = new ExtendFriendFooterView(this.F);
            extendFriendFooterView.setLayoutParams(layoutParams);
            return new k(extendFriendFooterView, this.f263801f);
        }
        if (i3 == 2) {
            return new yg2.a(from.inflate(R.layout.au7, viewGroup, false), this.E, this.G, this.f263801f, this.H);
        }
        if (i3 == 4) {
            ExtendFriendFeedView extendFriendFeedView2 = new ExtendFriendFeedView(this.F);
            extendFriendFeedView2.removeAllViews();
            VipGeneralGdtShowView vipGeneralGdtShowView = new VipGeneralGdtShowView(this.F, R.layout.c3e, 3, 1);
            if (vipGeneralGdtShowView.g() != null) {
                extendFriendFeedView2.addView(vipGeneralGdtShowView.g(), layoutParams);
                return new yg2.b(extendFriendFeedView2, this.F, this.f263801f, vipGeneralGdtShowView);
            }
        } else {
            if (i3 == 5) {
                return new l(from.inflate(R.layout.f168276c92, viewGroup, false), this.F);
            }
            if (i3 == 6) {
                TabLayout tabLayout = new TabLayout(this.F);
                tabLayout.setLayoutParams(layoutParams);
                g gVar = new g(tabLayout, this.f263802h);
                g gVar2 = this.K;
                if (gVar2 != null) {
                    gVar2.destroy();
                }
                this.K = gVar;
                return gVar;
            }
            if (i3 == 7) {
                ExtendFriendCampusVerifyTipsView extendFriendCampusVerifyTipsView = new ExtendFriendCampusVerifyTipsView(this.F);
                extendFriendCampusVerifyTipsView.setLayoutParams(layoutParams);
                return new h(extendFriendCampusVerifyTipsView, this.f263799d);
            }
        }
        return null;
    }

    public void onDestroy() {
        g gVar = this.K;
        if (gVar != null) {
            gVar.destroy();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        if (viewHolder instanceof g) {
            ((g) viewHolder).destroy();
        } else if (viewHolder instanceof j) {
            ((j) viewHolder).g();
        }
    }

    public void p(int i3, com.tencent.mobileqq.qqexpand.bean.feed.b bVar) {
        this.f263803i.add(i3, bVar);
    }

    public void q(List<com.tencent.mobileqq.qqexpand.bean.feed.b> list) {
        this.f263803i.addAll(list);
        MiniAppRecommInfo miniAppRecommInfo = this.I;
        if (miniAppRecommInfo != null) {
            x(miniAppRecommInfo);
        }
    }

    public void r() {
        this.f263803i.clear();
    }

    public void remove(int i3) {
        this.f263803i.remove(i3);
    }

    public void s(boolean z16) {
        this.C = z16;
        notifyDataSetChanged();
    }

    public int t(String str) {
        List<com.tencent.mobileqq.qqexpand.bean.feed.b> list = this.f263803i;
        int i3 = -1;
        if (list != null && list.size() > 0) {
            for (int i16 = 0; i16 < this.f263803i.size(); i16++) {
                if (str.equals(this.f263803i.get(i16).mUin)) {
                    i3 = i16;
                }
            }
        }
        return i3;
    }

    public com.tencent.mobileqq.qqexpand.bean.feed.b u(int i3) {
        List<com.tencent.mobileqq.qqexpand.bean.feed.b> list = this.f263803i;
        if (list != null) {
            int size = list.size();
            if (i3 >= 0 && i3 < size) {
                return this.f263803i.get(i3);
            }
        }
        return null;
    }

    public int v() {
        return this.f263803i.size();
    }

    public void w(yg2.f fVar) {
        g gVar = this.K;
        if (gVar == null || gVar.itemView == null) {
            return;
        }
        gVar.k(fVar);
    }

    public void x(MiniAppRecommInfo miniAppRecommInfo) {
        boolean z16;
        boolean z17;
        if (this.f263803i == null || miniAppRecommInfo == null) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            z16 = true;
            if (i16 >= this.f263803i.size()) {
                z17 = false;
                break;
            } else {
                if (this.f263803i.get(i16) instanceof MiniAppRecommInfo) {
                    this.f263803i.remove(i16);
                    z17 = true;
                    break;
                }
                i16++;
            }
        }
        if (miniAppRecommInfo.appInfoList.size() > 0) {
            this.I = miniAppRecommInfo;
            while (true) {
                if (i3 >= getItemCount()) {
                    z16 = z17;
                    break;
                } else {
                    if (getItemViewType(i3) == 0) {
                        this.f263803i.add(i3, miniAppRecommInfo);
                        break;
                    }
                    i3++;
                }
            }
            z17 = z16;
        } else {
            this.I = null;
        }
        if (z17) {
            notifyDataSetChanged();
        }
    }

    public void y(c cVar) {
        this.D = cVar;
    }

    public void z(int i3) {
        this.J = i3;
    }
}
