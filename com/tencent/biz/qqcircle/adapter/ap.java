package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchAdFeedbackEvent;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchSuggestAdItemView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchSuggestItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class ap extends com.tencent.biz.qqcircle.bizparts.a<g30.b> implements SimpleEventReceiver {
    private final Collection<WeakReference<BaseListViewAdapter<g30.b>.BaseVH>> C;

    /* renamed from: m, reason: collision with root package name */
    private p70.j f82638m;

    public ap(Bundle bundle) {
        super(bundle);
        this.C = new ArrayList();
    }

    private boolean i0(int i3) {
        if (i3 == 4) {
            return true;
        }
        return false;
    }

    private void j0(QFSSearchAdFeedbackEvent qFSSearchAdFeedbackEvent) {
        if (this.f82638m != null && getDataList() != null && !ab0.a.a(qFSSearchAdFeedbackEvent.getPos(), getDataList())) {
            this.f82638m.O1(getDataList().get(qFSSearchAdFeedbackEvent.getPos()));
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSSearchAdFeedbackEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (getDataList() != null && getDataList().get(i3) != null && getDataList().get(i3).a() != null) {
            return getDataList().get(i3).a().suggest_type.get();
        }
        return super.getItemViewType(i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSSearchSuggestBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (!ab0.a.a(i3, getDataList())) {
            if (i0(getItemViewType(i3))) {
                ((QFSSearchSuggestAdItemView) viewHolder.itemView).setData(getDataList().get(i3), i3);
            } else {
                ((QFSSearchSuggestItemView) viewHolder.itemView).setData(getDataList().get(i3), i3);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QCircleBaseWidgetView qFSSearchSuggestItemView;
        if (i0(i3)) {
            qFSSearchSuggestItemView = new QFSSearchSuggestAdItemView(viewGroup.getContext());
        } else {
            qFSSearchSuggestItemView = new QFSSearchSuggestItemView(viewGroup.getContext());
        }
        qFSSearchSuggestItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchSuggestItemView.setReportBean(getReportBean());
        BaseListViewAdapter.BaseVH baseVH = new BaseListViewAdapter.BaseVH(qFSSearchSuggestItemView);
        if (i0(i3)) {
            this.C.add(new WeakReference<>(baseVH));
        }
        return baseVH;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        this.f82638m = (p70.j) getViewModel(p70.j.class);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        Iterator<WeakReference<BaseListViewAdapter<g30.b>.BaseVH>> it = this.C.iterator();
        while (it.hasNext()) {
            BaseListViewAdapter<g30.b>.BaseVH baseVH = it.next().get();
            if (baseVH != null) {
                View view = baseVH.itemView;
                if (view instanceof QFSSearchSuggestAdItemView) {
                    ((QFSSearchSuggestAdItemView) view).r0();
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSearchAdFeedbackEvent) {
            j0((QFSSearchAdFeedbackEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}
