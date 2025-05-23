package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends MultiViewBlock<SubscribeDraftBean> implements SimpleEventReceiver {
    public static String M = "SubscribeDraftAdapter";
    public static int N = ImmersiveUtils.dpToPx(4.0f);
    private int J;
    private int K;
    private String L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements SubscribeDraftManager.c {
        a() {
        }

        @Override // com.tencent.biz.subscribe.utils.SubscribeDraftManager.c
        public void a(int i3, boolean z16, String str, Object... objArr) {
            if (z16) {
                if (objArr != null && objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof ArrayList) {
                        d.this.t((ArrayList) obj);
                        return;
                    }
                    return;
                }
                return;
            }
            QLog.d(d.M, 4, "get drafts failed");
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class b extends RecyclerView.ViewHolder {
        public b(View view) {
            super(view);
        }

        public void b(SubscribeDraftBean subscribeDraftBean) {
            View view = this.itemView;
            if (view instanceof SubScribeDraftItemView) {
                ((SubScribeDraftItemView) view).setData(subscribeDraftBean);
            }
        }
    }

    public d(Bundle bundle) {
        super(bundle);
        this.J = ImmersiveUtils.dpToPx(19.0f);
        this.K = ImmersiveUtils.dpToPx(3.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void G(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex() % 2 == 0) {
            rect.left = N;
            rect.right = this.K / 2;
        } else {
            rect.left = this.K / 2;
            rect.right = N;
        }
        rect.bottom = this.J;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int N(int i3) {
        return 2;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 1;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public boolean R() {
        return true;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void U(com.tencent.biz.subscribe.part.block.base.b bVar) {
        if (bVar.i() || bVar.f()) {
            i0();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(SubDraftChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f96195d.size();
    }

    public void i0() {
        if (A() != null && C() != null && ((PublicFragmentActivity) C()).app != null) {
            this.L = ((PublicFragmentActivity) C()).app.getAccount();
            if (SubscribeDraftManager.f().i(this.L)) {
                SubscribeDraftManager.f().j(this.L, new a());
            } else {
                q();
                notifyDataSetChanged();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof b) {
            ((b) viewHolder).b(r().get(i3));
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new b(new SubScribeDraftItemView(viewGroup.getContext(), this));
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof SubDraftChangeEvent) {
            i0();
        }
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public void a0(Bundle bundle) {
    }
}
