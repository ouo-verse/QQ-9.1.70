package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import UserGrowth.stFeed;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.follow.joingroup.e;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends RecyclerView.Adapter<c> {

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f80729d;

    /* renamed from: e, reason: collision with root package name */
    private Context f80730e;

    /* renamed from: f, reason: collision with root package name */
    private WSFollowFeedHolder f80731f;

    /* renamed from: h, reason: collision with root package name */
    private List<com.tencent.biz.pubaccount.weishi.follow.joingroup.b> f80732h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.view.c f80733i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.follow.joingroup.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class ViewOnClickListenerC0824a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.pubaccount.weishi.follow.joingroup.b f80734d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f80735e;

        ViewOnClickListenerC0824a(com.tencent.biz.pubaccount.weishi.follow.joingroup.b bVar, int i3) {
            this.f80734d = bVar;
            this.f80735e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bb.E()) {
                return;
            }
            a.this.z(this.f80734d);
            a.this.y(this.f80734d, this.f80735e);
        }
    }

    public a(Context context, List<com.tencent.biz.pubaccount.weishi.follow.joingroup.b> list, WSFollowFeedHolder wSFollowFeedHolder) {
        this.f80729d = LayoutInflater.from(context);
        this.f80730e = context;
        this.f80732h = list;
        this.f80731f = wSFollowFeedHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.f80733i == null) {
            if (this.f80730e == null) {
                return;
            }
            Context context = this.f80730e;
            this.f80733i = new com.tencent.biz.pubaccount.weishi.view.c(context, context.getResources().getString(R.string.ddr));
        }
        this.f80733i.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        com.tencent.biz.pubaccount.weishi.view.c cVar = this.f80733i;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.f80733i.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(com.tencent.biz.pubaccount.weishi.follow.joingroup.b bVar, int i3) {
        WSFollowFeedHolder wSFollowFeedHolder = this.f80731f;
        if (wSFollowFeedHolder != null) {
            stFeed L = wSFollowFeedHolder.L();
            HashMap hashMap = new HashMap();
            hashMap.put("qq_group_num", bVar.f80740c);
            WSFollowBeaconReport.j("qqgroup_add", i3 + 1, com.tencent.biz.pubaccount.weishi.report.d.f81489a, hashMap, L != null ? L.feed : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.tencent.biz.pubaccount.weishi.follow.joingroup.b bVar) {
        String str;
        WSFollowFeedHolder wSFollowFeedHolder = this.f80731f;
        if (wSFollowFeedHolder != null && wSFollowFeedHolder.L() != null && this.f80731f.L().feed == null) {
            str = this.f80731f.L().feed.poster_id;
        } else {
            str = "";
        }
        e.b().d(bVar.f80740c, str, new b());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tencent.biz.pubaccount.weishi.follow.joingroup.b> list = this.f80732h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i3) {
        com.tencent.biz.pubaccount.weishi.follow.joingroup.b bVar = this.f80732h.get(i3);
        WSPicLoader.g().j(this.f80730e, cVar.f80742d, bVar.a());
        cVar.f80743e.setText(bVar.b());
        cVar.f80744f.setOnClickListener(new ViewOnClickListenerC0824a(bVar, i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate = this.f80729d.inflate(R.layout.fwg, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        layoutParams.height = (int) viewGroup.getContext().getResources().getDimension(R.dimen.c36);
        inflate.setLayoutParams(layoutParams);
        return new c(inflate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements e.b {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.follow.joingroup.e.b
        public void a() {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f242007te, 0).show();
        }

        @Override // com.tencent.biz.pubaccount.weishi.follow.joingroup.e.b
        public boolean c() {
            return a.this.f80733i != null && a.this.f80733i.isShowing();
        }

        @Override // com.tencent.biz.pubaccount.weishi.follow.joingroup.e.b
        public void dismissLoading() {
            a.this.v();
        }

        @Override // com.tencent.biz.pubaccount.weishi.follow.joingroup.e.b
        public void showLoading() {
            a.this.A();
        }

        @Override // com.tencent.biz.pubaccount.weishi.follow.joingroup.e.b
        public void b(String str, String str2) {
            TroopUtils.I(a.this.f80730e, aq.d(str, str2, 60006), 2);
        }
    }
}
