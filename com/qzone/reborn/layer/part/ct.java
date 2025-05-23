package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLaunchKey;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ct extends Part {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView f58038d;

    /* renamed from: e, reason: collision with root package name */
    private List<RFWLayerItemMediaInfo> f58039e;

    /* renamed from: f, reason: collision with root package name */
    private RFWLayerInitBean f58040f;

    /* renamed from: h, reason: collision with root package name */
    private RFWLayerViewModel f58041h;

    /* renamed from: i, reason: collision with root package name */
    private RFWConcatAdapter f58042i;

    /* renamed from: m, reason: collision with root package name */
    private f9.b f58043m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements Observer<UIStateData<RFWLayerState>> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<RFWLayerState> uIStateData) {
            ct.this.A9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A9(UIStateData<RFWLayerState> uIStateData) {
        f9.b bVar;
        if (uIStateData.getData() != null && (bVar = this.f58043m) != null) {
            bVar.setItems(uIStateData.getData().getRichMediaDataList());
            this.f58043m.notifyDataSetChanged();
        } else {
            RFWLog.e(getTAG(), RFWLog.USR, "error data");
        }
    }

    private void initPageBean() {
        if (getActivity() == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "getActivity is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "intent is null");
            return;
        }
        if (intent.hasExtra(RFWLaunchKey.KEY_INIT_BEAN)) {
            Parcelable parcelableExtra = intent.getParcelableExtra(RFWLaunchKey.KEY_INIT_BEAN);
            if (!(parcelableExtra instanceof RFWLayerInitBean)) {
                return;
            } else {
                this.f58040f = (RFWLayerInitBean) parcelableExtra;
            }
        }
        this.f58039e = this.f58040f.getRichMediaDataList();
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setRichMediaDataList(this.f58039e);
        rFWLayerState.setSelectedPosition(0);
        this.f58041h.mRichMediaInfo.setValue(UIStateData.obtainSuccess(true).setDataList(rFWLayerState));
    }

    private void z9() {
        RecyclerView recyclerView = this.f58038d;
        if (recyclerView == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "recycler view is null");
            return;
        }
        recyclerView.setItemAnimator(null);
        this.f58038d.setLayoutManager(new SafeLinearLayoutManager(getContext()));
        f9.b bVar = new f9.b(new AdapterDelegatesManager(new qk.a()));
        this.f58043m = bVar;
        bVar.setHasStableIds(true);
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.f58043m});
        this.f58042i = rFWConcatAdapter;
        this.f58038d.setAdapter(rFWConcatAdapter);
        this.f58041h.mRichMediaInfo.observe(getPartHost().getLifecycleOwner(), new a());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        view.setBackground(new ColorDrawable(-16777216));
        this.f58038d = (RecyclerView) view.findViewById(R.id.neg);
        z9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.f58041h = (RFWLayerViewModel) getViewModel(RFWLayerViewModel.class);
        initPageBean();
    }
}
