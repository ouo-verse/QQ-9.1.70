package com.tencent.biz.qqcircle.immersive.views.search.mixuser;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView;
import com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.viewmodel.b;
import com.tencent.biz.qqcircle.immersive.views.search.mixuser.QFSSearchMixUserResultView;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StSearchMixPageUserInfo;
import i60.a;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchMixUserResultView extends QFSSearchMixResultBaseView<FeedCloudRead$StSearchMixPageUserInfo> implements View.OnClickListener {
    private QFSSearchVUserResultItemView F;
    private LinearLayout G;
    private a H;

    public QFSSearchMixUserResultView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void A0(FeedCloudRead$StSearchMixPageUserInfo feedCloudRead$StSearchMixPageUserInfo) {
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StSearchMixPageUserInfo.feeds.get();
        if (list != null && list.size() == 1) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(0);
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("is_single_user_feed");
            feedCloudMeta$StFeed.clientInfo.setHasFlag(true);
            feedCloudMeta$StFeed.clientInfo.clientMap.set(Collections.singletonList(feedCloudCommon$Entry));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (getData() != null && getData().user.f398463id.has()) {
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setUin(getData().user.f398463id.get());
            c.d0(getContext(), qCircleInitBean);
        }
    }

    private void initView() {
        this.F = (QFSSearchVUserResultItemView) findViewById(R.id.f56942lz);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f53702d8);
        this.G = linearLayout;
        linearLayout.setVisibility(8);
        this.G.setOnClickListener(this);
    }

    protected void C0() {
        a aVar = this.H;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public void w0(FeedCloudRead$StSearchMixPageUserInfo feedCloudRead$StSearchMixPageUserInfo) {
        this.F.setData(feedCloudRead$StSearchMixPageUserInfo.user);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gs7;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public Runnable m0() {
        return new Runnable() { // from class: j90.a
            @Override // java.lang.Runnable
            public final void run() {
                QFSSearchMixUserResultView.this.B0();
            }
        };
    }

    @Override // e80.d
    public String o() {
        return "art";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.G) {
            C0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public b p0() {
        return (b) getViewModel(n90.a.class);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    public i80.a q0() {
        return new k90.a();
    }

    public void setOnClickMoreListener(a aVar) {
        if (aVar != null) {
            this.H = aVar;
            this.G.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    public boolean l0(FeedCloudRead$StSearchMixPageUserInfo feedCloudRead$StSearchMixPageUserInfo) {
        if (feedCloudRead$StSearchMixPageUserInfo != null && feedCloudRead$StSearchMixPageUserInfo.feeds.has() && !feedCloudRead$StSearchMixPageUserInfo.feeds.isEmpty() && feedCloudRead$StSearchMixPageUserInfo.user.has()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.component.cardcontainer.QFSSearchMixResultBaseView
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public List<FeedCloudMeta$StFeed> n0(FeedCloudRead$StSearchMixPageUserInfo feedCloudRead$StSearchMixPageUserInfo) {
        A0(feedCloudRead$StSearchMixPageUserInfo);
        return feedCloudRead$StSearchMixPageUserInfo.feeds.get();
    }
}
