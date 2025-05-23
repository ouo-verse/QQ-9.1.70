package com.tencent.biz.qqcircle.immersive.views.search.mixtag;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b;
import com.tencent.biz.qqcircle.immersive.views.search.mixtag.QFSSearchMixTagResultView;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$StSearchMixPageTagInfo;
import h90.a;
import java.util.HashMap;
import java.util.List;
import ua0.i;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchMixTagResultView extends QFSSearchMixResultBaseView<FeedCloudRead$StSearchMixPageTagInfo> implements View.OnClickListener {
    private ImageView F;
    private TextView G;
    private TextView H;
    private View I;
    private String J;
    private String K;

    public QFSSearchMixTagResultView(@NonNull Context context) {
        super(context);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (TextUtils.isEmpty(this.J)) {
            return;
        }
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(this.J);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setPolymerizationType(7);
        c.j0(getContext(), qCirclePolymerizationBean);
    }

    private void C0() {
        if (!TextUtils.isEmpty(this.K) && getContext() != null) {
            c.g(getContext(), cy.c(cy.a(this.K, QCirclePublishQualityReporter.getTraceId()), 1005));
        }
    }

    private void D0(int i3) {
        VideoReport.setElementParam(this, QCircleDaTongConstant.ElementParamKey.XSJ_TOPIC_CARD_CLCK, Integer.valueOf(i3));
        EventCollector.getInstance().onViewClicked(this);
    }

    private void E0(FeedCloudRead$StSearchMixPageTagInfo feedCloudRead$StSearchMixPageTagInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(o0()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TOPIC_CARD_NAME, feedCloudRead$StSearchMixPageTagInfo.tagInfo.tagName.get());
        i.k(this, "em_xsj_topic_card", hashMap, feedCloudRead$StSearchMixPageTagInfo.hashCode());
    }

    private void F0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        if (feedCloudMeta$StTagInfo.optInfo.publishSchema.has() && !TextUtils.isEmpty(feedCloudMeta$StTagInfo.optInfo.publishSchema.get())) {
            this.K = feedCloudMeta$StTagInfo.optInfo.publishSchema.get();
            if (feedCloudMeta$StTagInfo.tagId.has()) {
                this.K += String.format("&%s=%s", "tagid", feedCloudMeta$StTagInfo.tagId.get());
                return;
            }
            return;
        }
        this.K = "";
    }

    private void G0(FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo, boolean z16) {
        int i3;
        String str = feedCloudMeta$StTagInfo.tagName.get();
        this.J = str;
        this.G.setText(str);
        this.H.setText(z0(feedCloudMeta$StTagInfo.userViewHistory.get(), feedCloudMeta$StTagInfo.tagTotalFeed.get()));
        ImageView imageView = this.F;
        QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
        if (z16) {
            i3 = R.drawable.ook;
        } else {
            i3 = R.drawable.qui_hashtag;
        }
        imageView.setImageDrawable(qCircleSkinHelper.getDrawable(i3));
        F0(feedCloudMeta$StTagInfo);
    }

    private void initView() {
        this.F = (ImageView) findViewById(R.id.f46751vf);
        this.G = (TextView) findViewById(R.id.f55042gu);
        this.H = (TextView) findViewById(R.id.f48071z0);
        this.I = findViewById(R.id.f501424l);
        this.F.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
    }

    private String z0(long j3, int i3) {
        return String.format(QCircleApplication.getAPP().getString(R.string.f195214e0), r.f(j3), r.f(i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public List<FeedCloudMeta$StFeed> n0(FeedCloudRead$StSearchMixPageTagInfo feedCloudRead$StSearchMixPageTagInfo) {
        return feedCloudRead$StSearchMixPageTagInfo.feeds.get();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void w0(FeedCloudRead$StSearchMixPageTagInfo feedCloudRead$StSearchMixPageTagInfo) {
        G0(feedCloudRead$StSearchMixPageTagInfo.tagInfo.get(), feedCloudRead$StSearchMixPageTagInfo.need_medal.get());
        E0(feedCloudRead$StSearchMixPageTagInfo);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gs6;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public Runnable m0() {
        return new Runnable() { // from class: d90.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchMixTagResultView.this.B0();
            }
        };
    }

    @Override // e80.d
    public String o() {
        return "mixTag";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != this.F && view != this.G && view != this.H) {
            if (view == this.I) {
                C0();
                D0(1);
            }
        } else {
            B0();
            D0(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public b p0() {
        return (b) getViewModel(a.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public i80.a q0() {
        return new e90.a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public boolean l0(FeedCloudRead$StSearchMixPageTagInfo feedCloudRead$StSearchMixPageTagInfo) {
        if (feedCloudRead$StSearchMixPageTagInfo != null && feedCloudRead$StSearchMixPageTagInfo.feeds.has() && !feedCloudRead$StSearchMixPageTagInfo.feeds.isEmpty() && feedCloudRead$StSearchMixPageTagInfo.tagInfo.has()) {
            return true;
        }
        return false;
    }
}
