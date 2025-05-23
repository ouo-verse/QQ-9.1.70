package com.tencent.biz.qqcircle.immersive.views.pymk;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.adapter.QFSListPYMKChildAdapter;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPYMKDeleteEvent;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.viewmodel.pymk.QFSListPYMKProductViewModel;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import e30.d;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StUser;
import qqcircle.QQCircleDitto$StButton;
import qqcircle.QQCircleDitto$StItemInfo;

/* loaded from: classes4.dex */
public class QFSListPYMKContainerItemView extends QCircleBaseWidgetView<QQCircleDitto$StItemInfo> implements View.OnClickListener {
    private ImageView C;
    private RelativeLayout D;
    private QQCircleDitto$StItemInfo E;
    private int F;
    private QFSListPYMKProductViewModel G;
    private Size H;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f91020d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f91021e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f91022f;

    /* renamed from: h, reason: collision with root package name */
    private QFSFollowView f91023h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f91024i;

    /* renamed from: m, reason: collision with root package name */
    private QFSListPYMKChildAdapter f91025m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends LinearLayoutManager {
        a(Context context, int i3, boolean z16) {
            super(context, i3, z16);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public QFSListPYMKContainerItemView(Context context) {
        super(context);
        p0(this);
    }

    private void l0() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.E;
        if (qQCircleDitto$StItemInfo == null) {
            return;
        }
        s0(qQCircleDitto$StItemInfo.buttonInfo, qQCircleDitto$StItemInfo.f429300id.get());
        this.f91020d.setAvatarByUin(this.E.f429300id.get(), this.H);
        this.f91022f.setText(this.E.des.get().get(0));
        this.f91021e.setText(this.E.name.get());
    }

    private void m0() {
        if (this.E == null) {
            return;
        }
        this.f91025m.j0(this.G.P1());
        this.f91025m.setData(this.E.feeds.get());
    }

    private void n0() {
        if (this.G == null) {
            this.G = new QFSListPYMKProductViewModel();
            w20.a.j().registerDisplaySurface(this.G.P1(), this.G);
        }
        this.G.N1(d.b(this.E.feeds.get()), this.E.f429300id.get(), o0());
    }

    private String o0() {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.E;
        if (qQCircleDitto$StItemInfo != null) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleDitto$StItemInfo.busiInfo.get()) {
                if (feedCloudCommon$Entry.key.get().equals("GetFeedListAttachInfo")) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
            return "";
        }
        return "";
    }

    private void p0(View view) {
        this.D = (RelativeLayout) view.findViewById(R.id.f512827o);
        this.f91020d = (QCircleAvatarView) view.findViewById(R.id.f512127h);
        this.f91021e = (TextView) view.findViewById(R.id.f513027q);
        this.f91022f = (TextView) view.findViewById(R.id.f512927p);
        this.f91023h = (QFSFollowView) view.findViewById(R.id.f512727n);
        this.C = (ImageView) view.findViewById(R.id.f513127r);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f512327j);
        this.f91024i = recyclerView;
        recyclerView.setLayoutManager(new a(getContext(), 0, false));
        QFSListPYMKChildAdapter qFSListPYMKChildAdapter = new QFSListPYMKChildAdapter();
        this.f91025m = qFSListPYMKChildAdapter;
        this.f91024i.setAdapter(qFSListPYMKChildAdapter);
        this.D.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.H = n.a(getContext(), R.dimen.d4n);
    }

    private void q0() {
        if (this.E == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(this.E.f429300id.get());
        c.d0(getContext(), qCircleInitBean);
    }

    private void r0() {
        if (this.E == null) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSPYMKDeleteEvent(this.F, this.E));
    }

    private void s0(QQCircleDitto$StButton qQCircleDitto$StButton, String str) {
        if (qQCircleDitto$StButton == null) {
            QLog.d("QFSListPYMKItemView", 1, "[setFollowImgStatus] button should not be null, id: ", str);
            return;
        }
        FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
        this.f91023h.setFollowedDismiss(false);
        feedCloudMeta$StUser.f398463id.set(str);
        feedCloudMeta$StUser.followState.set(QCirclePluginUtil.getBottonFollowStatus(qQCircleDitto$StButton.buttonValue.get()));
        this.f91023h.setUserData(feedCloudMeta$StUser);
        this.f91023h.setText(qQCircleDitto$StButton.name.get());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSListPYMKItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        this.E = qQCircleDitto$StItemInfo;
        this.F = i3;
        n0();
        l0();
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f512827o) {
            q0();
        } else if (id5 == R.id.f513127r) {
            r0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
