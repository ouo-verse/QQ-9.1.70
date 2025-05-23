package com.qzone.reborn.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneBaseBlockContainer extends BlockContainer {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<QZonePullToRefreshListView.a> f53554d;

    public QZoneBaseBlockContainer(Context context) {
        super(context);
        this.f53554d = new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b createBlockMerger() {
        return new b(this);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b getBlockMerger() {
        BlockMerger blockMerger = this.mBlockMerger;
        if (blockMerger instanceof b) {
            return (b) blockMerger;
        }
        return null;
    }

    public void c() {
        ArrayList<QZonePullToRefreshListView.a> arrayList = this.f53554d;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return this.mRecyclerView.canScrollVertically(i3);
    }

    @Override // com.tencent.biz.richframework.part.block.BlockContainer, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ArrayList<QZonePullToRefreshListView.a> arrayList = this.f53554d;
        if (arrayList != null) {
            Iterator<QZonePullToRefreshListView.a> it = arrayList.iterator();
            while (it.hasNext()) {
                QZonePullToRefreshListView.a next = it.next();
                if (next != null) {
                    next.dispatchTouchEvent(motionEvent);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setDispatchTouchEventListener(QZonePullToRefreshListView.a aVar) {
        ArrayList<QZonePullToRefreshListView.a> arrayList = this.f53554d;
        if (arrayList != null) {
            arrayList.add(aVar);
        }
    }

    public QZoneBaseBlockContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f53554d = new ArrayList<>();
    }

    public QZoneBaseBlockContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f53554d = new ArrayList<>();
    }
}
