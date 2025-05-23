package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.adapter.ao;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.search.QFSSearchResultMoreTagView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.HashMap;
import org.apache.httpcore.message.TokenParser;
import ua0.i;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSearchResultMoreTagView extends QCircleBaseWidgetView {
    private ao C;
    private View.OnClickListener D;
    private String E;

    /* renamed from: d, reason: collision with root package name */
    private TextView f93854d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93855e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93856f;

    /* renamed from: h, reason: collision with root package name */
    private RecyclerView f93857h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StTagInfo f93858i;

    /* renamed from: m, reason: collision with root package name */
    private int f93859m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends LinearLayoutManager {
        a(Context context) {
            super(context);
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

    public QFSSearchResultMoreTagView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f93854d = (TextView) findViewById(R.id.f54262eq);
        this.f93855e = (TextView) findViewById(R.id.f54272er);
        setOnClickListener(l0());
        this.f93854d.setOnClickListener(l0());
        this.f93855e.setOnClickListener(l0());
        o0(this);
        n0(this);
    }

    private View.OnClickListener l0() {
        View.OnClickListener onClickListener = this.D;
        if (onClickListener != null) {
            return onClickListener;
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: rc0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSSearchResultMoreTagView.this.p0(view);
            }
        };
        this.D = onClickListener2;
        return onClickListener2;
    }

    private String m0() {
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = this.f93858i;
        if (feedCloudMeta$StTagInfo == null) {
            return "";
        }
        return r.f(feedCloudMeta$StTagInfo.userViewHistory.get()) + TokenParser.SP + h.a(R.string.f19191463) + " / " + r.f(this.f93858i.tagTotalFeed.get()) + TokenParser.SP + h.a(R.string.f184183l7);
    }

    private void n0(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f54252ep);
        this.f93857h = recyclerView;
        recyclerView.setOnClickListener(l0());
        a aVar = new a(this.f93857h.getContext());
        aVar.setOrientation(0);
        this.f93857h.setLayoutManager(aVar);
        ao aoVar = new ao();
        this.C = aoVar;
        this.f93857h.setAdapter(aoVar);
        this.f93857h.addItemDecoration(new ao.c());
    }

    private void o0(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f54282es);
        this.f93856f = imageView;
        imageView.setOnClickListener(l0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        qCirclePolymerizationBean.setTagInfo(this.f93858i);
        qCirclePolymerizationBean.setPolymerizationType(7);
        c.j0(getContext(), qCirclePolymerizationBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void q0() {
        if (this.f93858i == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(this.f93859m));
        hashMap.put("xsj_topic_name", this.f93858i.tagName.get());
        hashMap.put("xsj_topic_id", this.f93858i.tagId.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.E);
        i.k(this, "em_xsj_topic_item", hashMap, this.f93858i.hashCode());
    }

    private void r0() {
        if (TextUtils.isEmpty(this.f93858i.tagName.get())) {
            this.f93854d.setVisibility(8);
        } else {
            this.f93854d.setText(this.f93858i.tagName.get());
        }
        String m06 = m0();
        if (TextUtils.isEmpty(m06)) {
            this.f93855e.setVisibility(8);
        } else {
            this.f93855e.setText(m06);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (!(obj instanceof FeedCloudMeta$StTagInfo)) {
            return;
        }
        this.f93858i = (FeedCloudMeta$StTagInfo) obj;
        this.f93859m = i3;
        r0();
        this.C.t0(this.f93858i.get());
        this.C.u0(this.f93857h);
        this.C.v0(this.E);
        q0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gs9;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchResultMoreTagWidget";
    }

    public void setTransferInfo(String str) {
        this.E = str;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
