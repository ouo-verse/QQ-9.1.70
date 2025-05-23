package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import UserGrowth.stFriendFeed;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.n;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.h;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import com.tencent.biz.pubaccount.weishi.w;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends BaseViewHolder<stFeed> implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f80786d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f80787e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayoutManager f80788f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.f f80789h;

    /* renamed from: i, reason: collision with root package name */
    private h10.a f80790i;

    /* renamed from: m, reason: collision with root package name */
    private stFeed f80791m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.holder.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0825a implements BaseAdapter.OnItemClickListener {
        C0825a() {
        }

        @Override // com.tencent.widget.pull2refresh.BaseAdapter.OnItemClickListener
        public void onItemClick(View view, int i3) {
            a00.b bVar;
            if (a.this.f80790i == null || a.this.f80790i.getDataList() == null || i3 >= a.this.f80790i.getDataList().size() || (bVar = a.this.f80790i.getDataList().get(i3)) == null) {
                return;
            }
            a.b.c(new k(a.this.getContext(), "friend_feed", GuildMsgItem.NICK_FRIEND).M(bVar.e() + 1));
            WSFollowBeaconReport.p(i3 + 1, 1000001, bVar.a().get(0), bVar.g(), bVar.d());
        }
    }

    public static a e(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        return new a(viewGroup, fVar);
    }

    public RecyclerView f() {
        return this.f80786d;
    }

    public void h() {
        LinearLayoutManager linearLayoutManager = this.f80788f;
        if (linearLayoutManager == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f80788f.findLastVisibleItemPosition();
        for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition - findFirstVisibleItemPosition; i3++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f80786d.findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof BaseViewHolder) {
                this.f80790i.onViewAttachedToWindow((BaseViewHolder) findViewHolderForAdapterPosition);
            }
        }
    }

    public void i() {
        LinearLayoutManager linearLayoutManager = this.f80788f;
        if (linearLayoutManager == null || this.f80789h == null) {
            return;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f80788f.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition >= this.f80789h.getDataList().size()) {
            return;
        }
        while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f80786d.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
            if (findViewHolderForAdapterPosition instanceof h10.b) {
                ((h10.b) findViewHolderForAdapterPosition).t();
            }
            findFirstVisibleItemPosition++;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        stFriendFeed stfriendfeed;
        int id5 = view.getId();
        if (id5 != R.id.f125187ld) {
            if (id5 != R.id.f125407lz) {
                return;
            }
            a.b.c(new k(getContext(), "friend_feed", GuildMsgItem.NICK_FRIEND));
            WSFollowBeaconReport.o();
            return;
        }
        w wVar = new w(getContext());
        stFeed stfeed = this.f80791m;
        if (stfeed != null && (stfriendfeed = stfeed.friendFeed) != null && !TextUtils.isEmpty(stfriendfeed.dialogTips)) {
            wVar.Q(this.f80791m.friendFeed.dialogTips);
        }
        wVar.show();
        WSFollowBeaconReport.v();
        WSFollowBeaconReport.u();
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void bindData(stFeed stfeed) {
        if (stfeed == null) {
            this.f80787e.setVisibility(8);
            return;
        }
        this.f80791m = stfeed;
        this.f80787e.setVisibility(0);
        stFriendFeed stfriendfeed = stfeed.friendFeed;
        this.f80790i.fillList(zz.b.b(stfriendfeed));
        if (stfriendfeed != null) {
            h.c().f(stfriendfeed.attachInfo);
        }
    }

    a(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        super(viewGroup, R.layout.fx7);
        this.f80789h = fVar;
        g();
    }

    private void g() {
        this.f80787e = (LinearLayout) getView(R.id.f165391lk1);
        this.f80786d = (RecyclerView) getView(R.id.f71243nm);
        TextView textView = (TextView) getView(R.id.f125407lz);
        TextView textView2 = (TextView) getView(R.id.f125417m0);
        ImageView imageView = (ImageView) getView(R.id.f125187ld);
        textView2.setText(R.string.f241907t5);
        textView.setVisibility(0);
        imageView.setVisibility(0);
        textView.setOnClickListener(this);
        imageView.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.f80788f = linearLayoutManager;
        this.f80786d.setLayoutManager(linearLayoutManager);
        this.f80786d.setHasFixedSize(true);
        h10.a aVar = new h10.a(getContext(), this.f80789h);
        this.f80790i = aVar;
        this.f80786d.setAdapter(aVar);
        this.f80786d.addItemDecoration(new n());
        this.f80790i.setOnItemClickListener(new C0825a());
    }
}
