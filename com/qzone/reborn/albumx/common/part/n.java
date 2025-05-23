package com.qzone.reborn.albumx.common.part;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class n extends com.qzone.reborn.base.k implements View.OnClickListener, l9.h {
    private com.qzone.reborn.albumx.common.viewmodel.k C;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f52513d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneBlankStateView f52514e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f52515f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f52516h;

    /* renamed from: i, reason: collision with root package name */
    private i9.f f52517i;

    /* renamed from: m, reason: collision with root package name */
    private RFWConcatAdapter f52518m;

    private void E9() {
        this.f52517i = new i9.f();
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f52517i});
        this.f52518m = rFWConcatAdapter;
        this.f52513d.setAdapter(rFWConcatAdapter);
    }

    private void I9(View view) {
        List<IQueueTask> value = this.C.O1().getValue();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handlePublishAllBtnClick]  | failedTaskList.size=");
        sb5.append(value != null ? value.size() : 0);
        QLog.d("CommonPublishQueuePart", 1, sb5.toString());
        if (RFSafeListUtils.isEmpty(value)) {
            return;
        }
        Iterator<IQueueTask> it = value.iterator();
        while (it.hasNext()) {
            this.C.W1(it.next());
        }
    }

    private void J9() {
        QZoneBlankStateView qZoneBlankStateView = this.f52514e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        RecyclerView recyclerView = this.f52513d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private void K9() {
        RecyclerView recyclerView = this.f52513d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        ViewGroup viewGroup = this.f52515f;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        QZoneBlankStateView qZoneBlankStateView = this.f52514e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(List<IQueueTask> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            this.f52515f.setVisibility(8);
        } else {
            this.f52515f.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M9(List<IQueueTask> list) {
        this.f52517i.setItems(list);
        if (RFSafeListUtils.isEmpty(list)) {
            K9();
        } else {
            J9();
        }
    }

    private void initViewModel() {
        com.qzone.reborn.albumx.common.viewmodel.k G9 = G9();
        this.C = G9;
        G9.S1(H9(), F9());
        M9(this.C.Q1().getValue());
        this.C.Q1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.M9((List) obj);
            }
        });
        this.C.O1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.albumx.common.part.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                n.this.L9((List) obj);
            }
        });
    }

    protected abstract String F9();

    protected abstract com.qzone.reborn.albumx.common.viewmodel.k G9();

    protected abstract String H9();

    @Override // l9.h
    public com.qzone.reborn.albumx.common.viewmodel.k g5() {
        return this.C;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.n5a) {
            I9(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.n59);
        this.f52513d = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        QZoneBlankStateView qZoneBlankStateView = (QZoneBlankStateView) view.findViewById(R.id.mqu);
        this.f52514e = qZoneBlankStateView;
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.i(getContext()));
        this.f52515f = (ViewGroup) view.findViewById(R.id.n5_);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.n5a);
        this.f52516h = viewGroup;
        viewGroup.setOnClickListener(this);
        E9();
        initViewModel();
        registerIoc(this, l9.h.class);
        fo.c.n(this.f52516h, "em_qz_upload_all");
    }
}
