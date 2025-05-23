package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalCollectBoxAddFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes4.dex */
public class QFSPersonalCollectBoxAddFeedAdapter extends QFSPersonalFeedBaseAdapter {
    private b D;

    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f88358d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.qqcircle.immersive.personal.bean.e f88359e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QFSPersonalCollectBoxAddFeedItemView f88360f;

        a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QFSPersonalCollectBoxAddFeedItemView qFSPersonalCollectBoxAddFeedItemView) {
            this.f88358d = i3;
            this.f88359e = eVar;
            this.f88360f = qFSPersonalCollectBoxAddFeedItemView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSPersonalCollectBoxAddFeedAdapter.this.D != null) {
                QFSPersonalCollectBoxAddFeedAdapter.this.D.a(this.f88358d, this.f88359e, this.f88360f.D);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, View view);
    }

    public QFSPersonalCollectBoxAddFeedAdapter(Bundle bundle) {
        super(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, QFSPersonalCollectBoxAddFeedItemView qFSPersonalCollectBoxAddFeedItemView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
        qCircleLayerBean.setFeed(eVar.b());
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = ErrorCode.ERROR_CHECKLEGALAPP_UNKNOWN_RET;
        qCircleLayerBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        qCircleLayerBean.setSingleFeed(true);
        ImageView imageView = qFSPersonalCollectBoxAddFeedItemView.f89200d;
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i3 = iArr[0];
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], imageView.getWidth() + i3, iArr[1] + imageView.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(eVar.a()));
        qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(imageView.getDrawable());
        com.tencent.biz.qqcircle.launcher.c.u(view.getContext(), qCircleLayerBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(final int i3, final Runnable runnable) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.mRecyclerView) != null) {
            if (recyclerView.isComputingLayout()) {
                this.mRecyclerView.postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        QFSPersonalCollectBoxAddFeedAdapter.this.w0(i3 - 1, runnable);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        RFWLog.i("QFSPersonalCollectBoxAddFeedAdapter", RFWLog.USR, "safeNotify return count = " + i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        super.onBindViewHolder(viewHolder, i3);
        final QFSPersonalCollectBoxAddFeedItemView qFSPersonalCollectBoxAddFeedItemView = (QFSPersonalCollectBoxAddFeedItemView) viewHolder.itemView;
        final com.tencent.biz.qqcircle.immersive.personal.bean.e eVar = (com.tencent.biz.qqcircle.immersive.personal.bean.e) this.mDataList.get(i3);
        qFSPersonalCollectBoxAddFeedItemView.D.setOnClickListener(new a(i3, eVar, qFSPersonalCollectBoxAddFeedItemView));
        if (this.f88370m == null) {
            qFSPersonalCollectBoxAddFeedItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSPersonalCollectBoxAddFeedAdapter.u0(com.tencent.biz.qqcircle.immersive.personal.bean.e.this, qFSPersonalCollectBoxAddFeedItemView, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalFeedBaseAdapter, com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return new QFSPersonalFeedBaseAdapter.c(new QFSPersonalCollectBoxAddFeedItemView(viewGroup.getContext()));
    }

    public void v0(final int i3) {
        w0(5, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.QFSPersonalCollectBoxAddFeedAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                QFSPersonalCollectBoxAddFeedAdapter.this.notifyItemChanged(i3);
            }
        });
    }

    public void x0(b bVar) {
        this.D = bVar;
    }
}
