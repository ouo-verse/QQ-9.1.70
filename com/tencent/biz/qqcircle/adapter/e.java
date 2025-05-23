package com.tencent.biz.qqcircle.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPicPreloadScroller;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class e extends com.tencent.biz.qqcircle.bizparts.a<e30.b> {
    protected com.tencent.biz.qqcircle.scrollers.b C;
    protected com.tencent.biz.qqcircle.scrollers.a D;
    protected int E;
    protected boolean F;

    /* renamed from: m, reason: collision with root package name */
    protected QCircleExtraTypeInfo f82646m;

    public e(Bundle bundle) {
        super(bundle);
        this.E = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m0(Runnable runnable) {
        RFWThreadManager.getUIHandler().post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(List list) {
        setDatasDefault(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<com.tencent.biz.qqcircle.scrollers.a> k0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new QCircleFeedPicPreloadScroller());
        return arrayList;
    }

    @NonNull
    protected com.tencent.biz.qqcircle.scrollers.a l0() {
        return new QCircleFeedReportScroller(getPageId(), getReportBean());
    }

    protected void o0(RecyclerView recyclerView) {
        this.C = new com.tencent.biz.qqcircle.scrollers.b(getContext(), recyclerView, this);
        List<com.tencent.biz.qqcircle.scrollers.a> k06 = k0();
        if (k06 != null && k06.size() > 0) {
            Iterator<com.tencent.biz.qqcircle.scrollers.a> it = k06.iterator();
            while (it.hasNext()) {
                this.C.d(it.next());
            }
        }
        com.tencent.biz.qqcircle.scrollers.a l06 = l0();
        this.D = l06;
        this.C.d(l06);
        this.C.l(this.f82646m);
        this.C.m(this.E);
        addOnScrollListener(this.C);
        this.C.h(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        o0(recyclerView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            removeOnScrollListener(bVar);
            this.C.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.onDestroy();
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.onPause();
        }
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.onStop();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.j(viewHolder);
        }
        QLog.d("QCircleBaseFeedBlock", 4, "onViewAttachedToWindow:" + viewHolder.getAdapterPosition() + "  " + viewHolder + "  " + this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.k(viewHolder);
        }
        QLog.d("QCircleBaseFeedBlock", 4, "onViewDetachedFromWindow:" + viewHolder.getAdapterPosition() + "  " + viewHolder + "  " + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0() {
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void q0(final List<e30.b> list, boolean z16, final Runnable runnable) {
        if (list == null) {
            QLog.e("QCircleBaseFeedBlock", 1, "[setDataList] list == null");
            return;
        }
        this.F = z16;
        if (this.mDiffer != null) {
            submitList(list, new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.m0(runnable);
                }
            });
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            setDatasDefault(list);
            p0();
        } else {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.adapter.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.n0(list);
                }
            });
        }
    }

    public void r0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.f82646m = qCircleExtraTypeInfo;
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.l(qCircleExtraTypeInfo);
        }
    }

    public void s0(int i3) {
        this.E = i3;
        com.tencent.biz.qqcircle.scrollers.b bVar = this.C;
        if (bVar != null) {
            bVar.m(i3);
        }
    }
}
