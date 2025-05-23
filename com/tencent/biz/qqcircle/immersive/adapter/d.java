package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.views.QFSFollowDialogUserEndHintItemView;
import com.tencent.biz.qqcircle.immersive.views.QFSFollowDialogUserItemView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> implements SimpleEventReceiver {
    private FeedCloudMeta$StFeed C;
    private QCircleReportBean D;
    private ViewGroup E;
    private b F;

    /* renamed from: m, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f84720m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
            View view = this.itemView;
            if (!(view instanceof QFSFollowDialogUserItemView)) {
                return;
            }
            ((QFSFollowDialogUserItemView) view).setFeed(d.this.C);
            ((QFSFollowDialogUserItemView) this.itemView).setReportBean(d.this.D);
            ((QFSFollowDialogUserItemView) this.itemView).setParentView(d.this.E);
            ((QFSFollowDialogUserItemView) this.itemView).bindData(qQCircleDitto$StItemInfo, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a();
    }

    public d(b bVar) {
        this.F = bVar;
    }

    private void m0(QCircleFollowUpdateEvent qCircleFollowUpdateEvent) {
        if (!QCirclePluginUtil.isFollow(qCircleFollowUpdateEvent.mFollowStatus)) {
            QLog.d("QFSFollowDialogUserAdapter", 1, "[handleRemoveFollowedUserItemEvent] uin:" + qCircleFollowUpdateEvent.mUserId + " is not follow.");
        }
        String str = qCircleFollowUpdateEvent.mUserId;
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = new QQCircleDitto$StItemInfo();
        qQCircleDitto$StItemInfo.f429300id.set(str);
        l0(qQCircleDitto$StItemInfo);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCircleFollowUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f84720m.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == this.f84720m.size()) {
            return 1;
        }
        return -1;
    }

    public void l0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        String str = qQCircleDitto$StItemInfo.f429300id.get();
        int i3 = 0;
        while (true) {
            if (i3 < this.f84720m.size()) {
                QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo2 = this.f84720m.get(i3);
                if ((qQCircleDitto$StItemInfo2 instanceof QQCircleDitto$StItemInfo) && qQCircleDitto$StItemInfo2.f429300id.get().equals(str)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            n0(i3);
        }
    }

    public void n0(int i3) {
        this.f84720m.remove(i3);
        QLog.d("QFSFollowDialogUserAdapter", 1, "remove data index:" + i3 + ".remove after : mUserList.size() = " + this.f84720m.size());
        if (this.f84720m.size() == 0) {
            clearData();
            b bVar = this.F;
            if (bVar != null) {
                bVar.a();
            }
        }
        notifyItemRemoved(i3);
        notifyItemRangeChanged(i3, getNUM_BACKGOURND_ICON() - i3);
    }

    public void o0(ViewGroup viewGroup) {
        this.E = viewGroup;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if ((viewHolder instanceof a) && i3 < this.f84720m.size()) {
            ((a) viewHolder).m(this.f84720m.get(i3), i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        if (i3 == 1) {
            return new a(new QFSFollowDialogUserEndHintItemView(viewGroup.getContext()));
        }
        QFSFollowDialogUserItemView qFSFollowDialogUserItemView = new QFSFollowDialogUserItemView(viewGroup.getContext());
        qFSFollowDialogUserItemView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return new a(qFSFollowDialogUserItemView);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QCircleFollowUpdateEvent) {
            m0((QCircleFollowUpdateEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a, com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void p0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.C = feedCloudMeta$StFeed;
    }

    public void setData(List<QQCircleDitto$StItemInfo> list) {
        this.f84720m.clear();
        this.f84720m.addAll(list);
        notifyDataSetChanged();
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.D = qCircleReportBean;
    }
}
