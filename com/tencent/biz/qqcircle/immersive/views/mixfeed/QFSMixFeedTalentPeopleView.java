package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.adapter.u;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedReportScroller;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemContainer;

/* loaded from: classes4.dex */
public class QFSMixFeedTalentPeopleView extends QFSMixFeedBaseWidgetView<e30.b> implements View.OnClickListener {
    private int C;
    private String D;
    protected RecyclerView E;
    protected RecyclerView.LayoutManager F;
    protected Dialog G;
    protected u H;
    protected QQCircleDitto$StItemContainer I;
    protected QCircleFeedReportScroller J;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f90888e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f90889f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f90890h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f90891i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f90892m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                QFSMixFeedTalentPeopleView.this.s0();
            }
        }
    }

    public QFSMixFeedTalentPeopleView(@NotNull Context context) {
        super(context);
        this.C = 0;
        o0(this);
    }

    private void l0(int i3) {
        if (i3 == 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = cx.a(-4.0f);
            layoutParams.topMargin = cx.a(4.0f);
            layoutParams.rightMargin = cx.a(-4.0f);
            this.f90888e.setLayoutParams(layoutParams);
        }
    }

    private void n0() {
        PBStringField pBStringField;
        TextView textView;
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.I;
        if (qQCircleDitto$StItemContainer != null && (pBStringField = qQCircleDitto$StItemContainer.title) != null && qQCircleDitto$StItemContainer.busiInfo != null && (textView = this.f90892m) != null && this.f90889f != null) {
            textView.setText(pBStringField.get());
            List<FeedCloudCommon$Entry> list = this.I.busiInfo.get();
            if (list != null && list.size() >= 2) {
                this.f90889f.setText(list.get(0).value.get());
                this.D = list.get(1).value.get();
            }
        }
    }

    private void o0(View view) {
        this.f90888e = (FrameLayout) view.findViewById(R.id.f9252584);
        this.f90892m = (TextView) view.findViewById(R.id.f32880uy);
        TextView textView = (TextView) view.findViewById(R.id.f32830ut);
        this.f90889f = textView;
        textView.setOnClickListener(this);
        this.E = (RecyclerView) view.findViewById(R.id.f32860uw);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext(), 0, false);
        this.F = safeLinearLayoutManager;
        this.E.setLayoutManager(safeLinearLayoutManager);
        this.E.setItemAnimator(new DefaultItemAnimator());
        this.E.addOnScrollListener(new a());
        u uVar = new u();
        this.H = uVar;
        uVar.q0(this);
        this.H.p0(this.E);
        this.H.setReportBean(this.mReportBean);
        this.H.v0(this.J);
        this.E.setAdapter(this.H);
    }

    private void p0(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (this.H == null) {
            QLog.d("QFSMixFeedTalentPeopleView", 1, "talent people adapter should not be null.");
            return;
        }
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer = this.I;
        if (qQCircleDitto$StItemContainer == null) {
            QLog.d("QFSMixFeedTalentPeopleView", 1, "container should not be null.");
            return;
        }
        int size = qQCircleDitto$StItemContainer.items.size();
        int i16 = this.I.styleType.get();
        QLog.d("QFSMixFeedTalentPeopleView", 1, "dittoFeed pos: ", Integer.valueOf(i3), " | itemSize: ", Integer.valueOf(size), " | styleType: ", Integer.valueOf(i16));
        this.H.o0(this.I);
        this.H.u0(feedCloudMeta$StFeed, i3, this.I.items.get(), i16);
    }

    private void q0() {
        TextView textView;
        if (!TextUtils.isEmpty(this.D) && !this.D.equals("") && (textView = this.f90890h) != null) {
            textView.setText(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedTalentPeopleView.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QFSMixFeedTalentPeopleView", 1, " |triggerDTTraversePage after data change!");
                VideoReport.traversePage(QFSMixFeedTalentPeopleView.this.E);
            }
        });
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168641g64;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedTalentPeopleView";
    }

    public RecyclerView m0() {
        return this.E;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f32830ut) {
                r0();
            } else if (id5 == R.id.f32530u0 && (dialog = this.G) != null) {
                dialog.dismiss();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void r0() {
        if (this.G == null) {
            ReportDialog reportDialog = new ReportDialog(getContext());
            this.G = reportDialog;
            reportDialog.setCanceledOnTouchOutside(false);
            this.G.getWindow().requestFeature(1);
            this.G.getWindow().setFlags(1024, 1024);
            this.G.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.g65, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.f32530u0);
            this.f90891i = textView;
            textView.setOnClickListener(this);
            this.f90890h = (TextView) inflate.findViewById(R.id.f786447m);
            q0();
            this.G.setContentView(inflate);
        }
        if (!this.G.isShowing()) {
            this.G.show();
        }
    }

    public void setPageId(int i3) {
        this.C = i3;
        this.H.w0(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(e30.b bVar, int i3) {
        if (this.H != null && bVar != null) {
            l0(i3);
            this.I = d.i(bVar, String.valueOf(bVar.g().dittoFeed.dittoId.get()));
            p0(i3, bVar.g());
            n0();
            s0();
            return;
        }
        QLog.d("QFSMixFeedTalentPeopleView", 1, "adapter should not be null.");
    }
}
