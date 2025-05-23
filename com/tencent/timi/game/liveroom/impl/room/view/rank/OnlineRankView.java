package com.tencent.timi.game.liveroom.impl.room.view.rank;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import d55.j;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class OnlineRankView extends FrameLayout implements com.tencent.timi.game.liveroom.impl.room.view.rank.base.d {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f378825d;

    /* renamed from: e, reason: collision with root package name */
    private d f378826e;

    /* renamed from: f, reason: collision with root package name */
    private SelfRankInfoView f378827f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f378828h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f378829i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f378830m;

    public OnlineRankView(Activity activity, Context context, long j3, long j16) {
        super(context);
        a(activity, j3, j16);
    }

    private void a(Activity activity, long j3, long j16) {
        int i3;
        LayoutInflater.from(getContext()).inflate(R.layout.hxx, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.f70363l9);
        this.f378825d = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        d dVar = new d(activity, getContext(), j3, j16);
        this.f378826e = dVar;
        this.f378825d.setAdapter(dVar);
        SelfRankInfoView selfRankInfoView = (SelfRankInfoView) findViewById(R.id.f82964ia);
        this.f378827f = selfRankInfoView;
        selfRankInfoView.setRoomId(j3);
        this.f378828h = (FrameLayout) findViewById(R.id.f70263kz);
        this.f378829i = (TextView) findViewById(R.id.ycj);
        this.f378830m = (TextView) findViewById(R.id.ycd);
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.J(j3, 1)) {
            String d16 = ht3.a.d("anchor_rank_list_header_text_on_left", "\u6392\u5e8f");
            String d17 = ht3.a.d("anchor_rank_list_header_text_on_right", "\u9001\u793c\u91d1\u5e01 | \u89c2\u770b\u65f6\u957f");
            this.f378829i.setText(d16);
            this.f378830m.setText(d17);
        } else {
            String d18 = ht3.a.d("guest_rank_list_header_text_on_left", "\u6392\u5e8f");
            String d19 = ht3.a.d("guest_rank_list_header_text_on_right", "\u52a9\u529b\u503c");
            this.f378829i.setText(d18);
            this.f378830m.setText(d19);
        }
        String string = getContext().getString(R.string.f22040691);
        if (!NetworkUtil.isNetworkAvailable()) {
            string = ht3.a.d("native_rank_list_header_text_empty_wording", "\u6570\u636e\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            i3 = 5;
        } else {
            i3 = 8;
        }
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(getContext()).setImageType(i3).setBackgroundColorType(0).setDesc(string).setHalfScreenState(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f378828h.addView(halfScreenState.build(), layoutParams);
    }

    public void b(boolean z16) {
        this.f378827f.i(z16);
    }

    public void c(List<d55.a> list, boolean z16, long j3) {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("DetailRankView", 1, "updateRankListView");
        if (list.size() == 0) {
            this.f378825d.setVisibility(8);
            this.f378828h.setVisibility(0);
        } else {
            this.f378825d.setVisibility(0);
            this.f378828h.setVisibility(8);
            this.f378826e.v0(list, j3);
            this.f378826e.notifyDataSetChanged();
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("DetailRankView", 1, "updateSelfRankInfoView, isAnchor:" + z16);
    }

    public void d(j jVar, boolean z16) {
        if (jVar == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("DetailRankView", "updateUI RankListForNativeRsp is Error!! rsp == null");
            return;
        }
        d55.a[] aVarArr = jVar.f393088a;
        if (aVarArr == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("DetailRankView", "updateUI RankListForNativeRsp is Error!! rsp.rankList == null");
        } else if (jVar.f393090c == null) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i("DetailRankView", "updateUI RankListForNativeRsp is Error!! rsp.myRankInfo == null");
            c(Arrays.asList((d55.a[]) jVar.f393088a.clone()), z16, jVar.f393093f);
        } else {
            c(Arrays.asList((d55.a[]) aVarArr.clone()), z16, jVar.f393093f);
            this.f378827f.j(jVar.f393090c, z16);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.base.d
    public void onDismiss() {
        this.f378825d.setVisibility(8);
        this.f378827f.setVisibility(4);
    }

    public void setOnLineRankListItemListener(b bVar) {
        d dVar = this.f378826e;
        if (dVar != null) {
            dVar.w0(bVar);
        }
    }

    public void setOpenGiftPanelListener(SelfRankInfoView.b bVar) {
        SelfRankInfoView selfRankInfoView = this.f378827f;
        if (selfRankInfoView != null) {
            selfRankInfoView.setOpenGiftPanelListener(bVar);
        }
    }

    public void setSelfRankViewClickListener(SelfRankInfoView.c cVar) {
        SelfRankInfoView selfRankInfoView = this.f378827f;
        if (selfRankInfoView != null) {
            selfRankInfoView.h(cVar);
        }
    }
}
