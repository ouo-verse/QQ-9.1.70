package com.qzone.reborn.albumx.common.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class k extends com.qzone.reborn.base.k implements View.OnClickListener, RFWDownloadQueueResultListener {
    private TextView C;
    private ImageView D;

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f52498d;

    /* renamed from: e, reason: collision with root package name */
    private QZoneBlankStateView f52499e;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f52500f;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f52501h;

    /* renamed from: i, reason: collision with root package name */
    private i9.c f52502i;

    /* renamed from: m, reason: collision with root package name */
    private RFWConcatAdapter f52503m;

    private void C9() {
        this.f52502i = new i9.c();
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f52502i});
        this.f52503m = rFWConcatAdapter;
        this.f52498d.setAdapter(rFWConcatAdapter);
    }

    private void D9() {
        this.f52500f.setVisibility(8);
        List<com.qzone.reborn.albumx.common.bean.e> items = this.f52502i.getItems();
        if (RFSafeListUtils.isEmpty(items)) {
            return;
        }
        boolean z16 = false;
        for (com.qzone.reborn.albumx.common.bean.e eVar : items) {
            if (eVar.getStateData().getState() == DownloadState.STATE_PAUSE || eVar.getStateData().getState() == DownloadState.STATE_ERROR || eVar.getStateData().getState() == DownloadState.STATE_CANCEL) {
                z16 = true;
            }
        }
        if (z16) {
            this.f52500f.setVisibility(0);
            VideoReport.traversePage(this.f52500f);
        }
    }

    private void H9() {
        QZoneBlankStateView qZoneBlankStateView = this.f52499e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.o0();
        }
        RecyclerView recyclerView = this.f52498d;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private void I9() {
        RecyclerView recyclerView = this.f52498d;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        ViewGroup viewGroup = this.f52500f;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        QZoneBlankStateView qZoneBlankStateView = this.f52499e;
        if (qZoneBlankStateView != null) {
            qZoneBlankStateView.s0();
        }
    }

    private void J9(List<com.qzone.reborn.albumx.common.bean.e> list) {
        this.f52502i.setItems(list);
        if (RFSafeListUtils.isEmpty(list)) {
            I9();
            D9();
        } else {
            H9();
        }
    }

    public abstract List<RFWDownloadTaskStateData> E9(String str);

    protected abstract String F9();

    /* JADX INFO: Access modifiers changed from: protected */
    public void G9(List<RFWDownloadTaskStateData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<RFWDownloadTaskStateData> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.qzone.reborn.albumx.common.bean.e(it.next()));
            }
        }
        J9(arrayList);
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.n59);
        this.f52498d = recyclerView;
        recyclerView.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        this.f52498d.setItemAnimator(null);
        QZoneBlankStateView qZoneBlankStateView = (QZoneBlankStateView) view.findViewById(R.id.mqu);
        this.f52499e = qZoneBlankStateView;
        qZoneBlankStateView.setData(com.qzone.reborn.feedx.util.k.g(getContext()));
        this.f52500f = (ViewGroup) view.findViewById(R.id.n5_);
        this.f52501h = (ViewGroup) view.findViewById(R.id.n5a);
        this.f52500f.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.n58);
        this.C = textView;
        textView.setText(com.qzone.util.l.a(R.string.v8x));
        ImageView imageView = (ImageView) view.findViewById(R.id.n57);
        this.D = imageView;
        imageView.setImageResource(R.drawable.qui_download);
        C9();
        fo.c.o(this.f52500f, "em_qz_download_all", new fo.b());
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData.getState() == DownloadState.STATE_WAITING || rFWDownloadTaskStateData.getState() == DownloadState.STATE_START_RUN || rFWDownloadTaskStateData.getState() == DownloadState.STATE_RUNNING) {
            return;
        }
        if (rFWDownloadTaskStateData.getState() != DownloadState.STATE_SUCCESS && rFWDownloadTaskStateData.getState() != DownloadState.STATE_CANCEL) {
            D9();
            return;
        }
        List<RFWDownloadTaskStateData> E9 = E9(F9());
        QLog.i(getTAG(), 1, "onStateChange  success, after filter, listSize = " + E9.size());
        G9(E9);
    }
}
