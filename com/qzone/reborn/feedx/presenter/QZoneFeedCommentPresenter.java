package com.qzone.reborn.feedx.presenter;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Space;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

/* loaded from: classes37.dex */
public class QZoneFeedCommentPresenter extends vg.a implements Observer<af.b> {
    private oh.a F;
    private TextView G;
    private View H;
    private RecyclerView I;

    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            xg.d.a(((vg.a) QZoneFeedCommentPresenter.this).f441565h, ((vg.a) QZoneFeedCommentPresenter.this).C, view);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes37.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || com.qzone.reborn.feedx.util.x.f55790a.c(QZoneFeedCommentPresenter.this.o())) {
                return false;
            }
            xg.d.a(((vg.a) QZoneFeedCommentPresenter.this).f441565h, ((vg.a) QZoneFeedCommentPresenter.this).C, QZoneFeedCommentPresenter.this.I);
            return false;
        }
    }

    /* loaded from: classes37.dex */
    class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            if (QZoneFeedCommentPresenter.this.F != null && QZoneFeedCommentPresenter.this.F.getNUM_BACKGOURND_ICON() > 1) {
                if (recyclerView.getChildAdapterPosition(view) < QZoneFeedCommentPresenter.this.F.getNUM_BACKGOURND_ICON() - 1) {
                    rect.bottom = ImmersiveUtils.dpToPx(2.0f);
                    return;
                }
                return;
            }
            super.getItemOffsets(rect, view, recyclerView, state);
        }
    }

    private boolean O(BusinessFeedData businessFeedData) {
        return (businessFeedData.getCommentInfoV2() == null || businessFeedData.getCommentInfoV2().commments == null || businessFeedData.getFeedCommInfoV2() == null || businessFeedData.getFeedCommInfoV2().bizId != 3) ? false : true;
    }

    private void Q() {
        Space space;
        if (com.qzone.reborn.feedx.util.x.f55790a.c(o()) || (space = (Space) this.f441563e.findViewById(R.id.mcj)) == null) {
            return;
        }
        space.setVisibility(8);
        if (this.H.getVisibility() != 8 || this.f441565h.getLikeInfoV2().likeNum <= 0 || com.tencent.mobileqq.utils.bl.b(this.f441565h.getLikeInfoV2().likeMans)) {
            return;
        }
        space.setVisibility(0);
    }

    private void R(BusinessFeedData businessFeedData) {
        this.F.q0(businessFeedData, O(businessFeedData));
        if (this.F.getNUM_BACKGOURND_ICON() == 0 && !this.F.s0()) {
            this.H.setVisibility(8);
            return;
        }
        this.H.setVisibility(0);
        com.qzone.reborn.feedx.util.ag.f55738a.b(5, new Runnable() { // from class: com.qzone.reborn.feedx.presenter.QZoneFeedCommentPresenter.4
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedCommentPresenter.this.F.notifyDataSetChanged();
            }
        }, this.I);
        if (O(businessFeedData)) {
            S(businessFeedData);
        } else {
            T();
        }
        Q();
    }

    private void S(BusinessFeedData businessFeedData) {
        CellCommentInfo commentInfoV2 = businessFeedData.getCommentInfoV2();
        int size = commentInfoV2.serverRspTotalCommentNum - commentInfoV2.commments.size();
        int i3 = commentInfoV2.serverRspTotalCommentNum;
        if (i3 != 0 && (size > 0 || i3 > this.F.m0(businessFeedData))) {
            this.G.setVisibility(0);
            this.G.setText(MobileQQ.sMobileQQ.getString(R.string.f169537rf4, Integer.valueOf(this.F.l0())));
        } else {
            this.G.setVisibility(8);
        }
    }

    private void T() {
        if (this.F.s0()) {
            this.G.setVisibility(0);
            this.G.setText(MobileQQ.sMobileQQ.getString(R.string.f169537rf4, Integer.valueOf(this.F.l0())));
        } else {
            this.G.setVisibility(8);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        R(businessFeedData);
        if (TextUtils.isEmpty(ef.b.a(businessFeedData)) || o() == 5) {
            return;
        }
        RFWLog.d("QZoneFeedCommentPresenter", RFWLog.DEV, "observe comment, feedsKey: " + ef.b.a(businessFeedData) + ", comment: " + businessFeedData.getCommentInfo() + ", presenter: " + this);
        ze.a.a().observerGlobalState(new af.b(ef.b.a(businessFeedData), businessFeedData.getCommentInfo()), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedCommentPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nnd;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void onChanged(af.b bVar) {
        if (bVar == null || !TextUtils.equals(bVar.b(), ef.b.a(this.f441565h))) {
            return;
        }
        RFWLog.d("QZoneFeedCommentPresenter", RFWLog.DEV, "comment onChanged, feedsKey: " + bVar.b() + ", comment: " + bVar.a() + ", isFromDetail: " + bVar.c() + ", presenter: " + this);
        if (bVar.c()) {
            RFWLog.i("QZoneFeedCommentPresenter", RFWLog.USR, "is from detail, not need to update");
        } else {
            this.f441565h.setCommentInfo(bVar.a());
            R(this.f441565h);
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.H = view.findViewById(R.id.mvv);
        this.I = (RecyclerView) view.findViewById(R.id.mru);
        this.G = (TextView) view.findViewById(R.id.n6x);
        this.I.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.I.setNestedScrollingEnabled(false);
        oh.a aVar = new oh.a(o());
        this.F = aVar;
        aVar.r0(this.f441567m);
        this.I.setAdapter(this.F);
        this.G.setOnClickListener(new a());
        this.I.setOnTouchListener(new b());
        this.I.addItemDecoration(new c());
    }
}
