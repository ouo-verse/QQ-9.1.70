package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StButtomBanner;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends c implements View.OnClickListener {
    private LinearLayout D;
    private FrameLayout E;
    private QCircleAvatarListView F;
    private TextView G;
    private ImageView H;
    private TextView I;
    private List<FeedCloudMeta$StUser> J;
    private String K;
    private String L;
    private String M;
    private int N;
    private int P;

    public r(a aVar) {
        super(aVar);
        this.J = new ArrayList();
        this.N = 106;
        this.P = 0;
    }

    private void t(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(view, str);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_item_name", this.L);
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }
    }

    private void u(com.tencent.biz.qqcircle.immersive.feed.event.ad adVar) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90602e;
        if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), adVar.a())) {
            this.P = adVar.b();
        }
    }

    private void v(@NonNull View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f48051yy);
        this.D = (LinearLayout) view.findViewById(R.id.f34340yw);
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        this.E = (FrameLayout) inflate.findViewById(R.id.f40871fj);
        this.F = (QCircleAvatarListView) inflate.findViewById(R.id.f40821fe);
        this.G = (TextView) inflate.findViewById(R.id.f40831ff);
        this.H = (ImageView) inflate.findViewById(R.id.f40841fg);
        this.I = (TextView) inflate.findViewById(R.id.f40861fi);
        this.E.setOnClickListener(this);
    }

    private void w() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (o() != null && (feedCloudMeta$StFeed = this.f90602e) != null) {
            QCircleShareInfo c16 = au.c(feedCloudMeta$StFeed);
            c16.shareStyleType = 7;
            c16.source = 5;
            c16.feedBlockData = this.f90601d;
            QCircleExtraTypeInfo k3 = k();
            c16.extraTypeInfo = k3;
            k3.mDataPosition = this.f90603f;
            if (this.f90602e.type.get() == 2) {
                c16.picDownPos = this.P;
            }
            c16.feed = this.f90602e;
            c16.mReportBean = p();
            o().onHandlerMessage("event_open_share", c16);
            w20.a.j().m();
            return;
        }
        QLog.d("QFSFeedOneByOneView", 1, "[openSharePanel] feed ioc should not be null.");
    }

    private void x(boolean z16) {
        int i3;
        FrameLayout frameLayout = this.E;
        int i16 = 0;
        if (frameLayout != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            frameLayout.setVisibility(i3);
        }
        LinearLayout linearLayout = this.D;
        if (linearLayout != null) {
            if (!z16) {
                i16 = 8;
            }
            linearLayout.setVisibility(i16);
        }
    }

    private void y(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.buttomBanner != null) {
            if (this.F != null && this.G != null) {
                this.J.clear();
                PBRepeatMessageField<FeedCloudMeta$StUser> pBRepeatMessageField = feedCloudMeta$StFeed.buttomBanner.vecUser;
                if (pBRepeatMessageField != null && pBRepeatMessageField.size() != 0) {
                    this.J.addAll(feedCloudMeta$StFeed.buttomBanner.vecUser.get());
                }
                if (RFSafeListUtils.isEmpty(this.J)) {
                    this.F.setVisibility(8);
                } else {
                    this.F.setData(com.tencent.biz.qqcircle.utils.o.c(this.J, 3));
                    this.F.setVisibility(0);
                }
                String str = feedCloudMeta$StFeed.buttomBanner.title.get();
                this.K = str;
                if (TextUtils.isEmpty(str)) {
                    this.G.setVisibility(8);
                    return;
                } else {
                    this.G.setText(this.K);
                    this.G.setVisibility(0);
                    return;
                }
            }
            QLog.e("QFSFeedOneByOneView", 1, "[updateLeft] view should not be null");
            return;
        }
        QLog.e("QFSFeedOneByOneView", 1, "[updateLeft] feed should not be null");
    }

    private void z(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        Drawable drawable;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSFeedOneByOneView", 1, "[updateRight] feed should not be null");
            return;
        }
        ImageView imageView = this.H;
        if (imageView != null && this.I != null) {
            if (QCirclePluginUtil.isFeedOwner(feedCloudMeta$StFeed)) {
                drawable = j().getResources().getDrawable(R.drawable.oqn);
            } else {
                drawable = j().getResources().getDrawable(R.drawable.f162058oq4);
            }
            imageView.setImageDrawable(drawable);
            FeedCloudMeta$StButtomBanner feedCloudMeta$StButtomBanner = feedCloudMeta$StFeed.buttomBanner;
            if (feedCloudMeta$StButtomBanner != null || feedCloudMeta$StButtomBanner.button != null) {
                String str = feedCloudMeta$StButtomBanner.button.text.get();
                this.L = str;
                this.I.setText(str);
                this.M = feedCloudMeta$StFeed.buttomBanner.button.jump_url.get();
                return;
            }
            return;
        }
        QLog.e("QFSFeedOneByOneView", 1, "[updateRight] view should not be null");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c, com.tencent.biz.qqcircle.immersive.views.banner.bottom.b
    public void f(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        super.f(hVar);
        if (hVar instanceof com.tencent.biz.qqcircle.immersive.feed.event.ad) {
            u((com.tencent.biz.qqcircle.immersive.feed.event.ad) hVar);
        }
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return this.N;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return com.tencent.biz.qqcircle.immersive.utils.r.r0(this.f90601d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f40871fj) {
            if (QCirclePluginUtil.isFeedOwner(this.f90602e)) {
                w();
            } else {
                com.tencent.biz.qqcircle.launcher.c.g(j(), this.M);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        QLog.d("QFSFeedOneByOneView", 1, "[onElementActivated]");
        v(this.f90604h);
        y(this.f90602e);
        z(this.f90602e);
        if (TextUtils.isEmpty(this.K)) {
            x(false);
            return;
        }
        x(true);
        t(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_JIELONG_GUIDE_PANEL);
        QCirclePluginInitHelper.PreloadWink(j());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        x(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void q() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    protected void r() {
    }
}
