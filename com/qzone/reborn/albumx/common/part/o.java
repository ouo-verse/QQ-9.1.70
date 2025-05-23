package com.qzone.reborn.albumx.common.part;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class o extends com.qzone.reborn.base.k implements View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f52519d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneBlankStateView f52520e;

    /* renamed from: f, reason: collision with root package name */
    private i9.g f52521f;

    /* renamed from: h, reason: collision with root package name */
    private RFWConcatAdapter f52522h;

    private void C9() {
        this.f52521f = new i9.g();
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f52521f});
        this.f52522h = rFWConcatAdapter;
        this.f52519d.setAdapter(rFWConcatAdapter);
    }

    private void D9() {
        QZoneBlankStateView qZoneBlankStateView = this.f52520e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        RecyclerView recyclerView = this.f52519d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private void E9() {
        RecyclerView recyclerView = this.f52519d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        QZoneBlankStateView qZoneBlankStateView = this.f52520e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
    }

    public void F9(List<IQueueTask> list) {
        this.f52521f.setItems(list);
        if (RFSafeListUtils.isEmpty(list)) {
            E9();
        } else {
            D9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.n59);
        this.f52519d = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        QZoneBlankStateView qZoneBlankStateView = (QZoneBlankStateView) view.findViewById(R.id.mqu);
        this.f52520e = qZoneBlankStateView;
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.i(getContext()));
        C9();
    }
}
