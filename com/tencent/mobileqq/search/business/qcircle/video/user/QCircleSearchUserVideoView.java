package com.tencent.mobileqq.search.business.qcircle.video.user;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import java.util.HashMap;
import lo2.ac;
import qqcircle.QQCircleBase$StUserBusiData;
import ua0.i;
import vo2.e;
import wo2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QCircleSearchUserVideoView extends QCircleSearchDoubleVideoView<ac> implements View.OnClickListener {
    private static final int J = ViewUtils.dip2px(40.0f);
    private ac.c C;
    private View D;
    private QCircleAvatarView E;
    private TextView F;
    private TextView G;
    private TextView H;
    private QFSFollowView I;

    public QCircleSearchUserVideoView(Context context) {
        super(context);
    }

    private void o() {
        FeedCloudMeta$StUser a16 = this.C.a();
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(a16);
        c.d0(getContext(), qCircleInitBean);
    }

    private void p(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.I.setItemReportListener(new a(feedCloudMeta$StUser));
    }

    private void q(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        VideoReport.setElementId(this.D, "em_xsj_author_avatar");
        VideoReport.setElementParam(this.D, QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
        VideoReport.setElementParam(this.D, QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, feedCloudMeta$StUser.nick.get());
        VideoReport.setElementReuseIdentifier(this.D, String.valueOf(((ac) this.f283063e).hashCode()));
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    @NonNull
    protected Class<? extends com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a> g() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    protected String i() {
        return "qArt";
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    public void j() {
        super.j();
        this.D = findViewById(R.id.f115306vo);
        this.E = (QCircleAvatarView) findViewById(R.id.f56892lu);
        this.F = (TextView) findViewById(R.id.f56962m1);
        this.G = (TextView) findViewById(R.id.f372016m);
        this.H = (TextView) findViewById(R.id.f41611hj);
        this.I = (QFSFollowView) findViewById(R.id.f42091iu);
        this.D.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    protected no2.a k(HorizontalListView horizontalListView, mo2.a aVar, com.tencent.mobileqq.search.business.qcircle.video.base.viewmodel.a aVar2, com.tencent.mobileqq.search.business.qcircle.video.base.a aVar3) {
        return new uo2.a(horizontalListView, aVar, aVar2, aVar3);
    }

    @Override // com.tencent.mobileqq.search.business.qcircle.video.base.QCircleSearchDoubleVideoView
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(ac acVar) {
        super.d(acVar);
        ac.c cVar = (ac.c) acVar.d0();
        this.C = cVar;
        FeedCloudMeta$StUser a16 = cVar.a();
        QCircleAvatarView qCircleAvatarView = this.E;
        int i3 = J;
        qCircleAvatarView.setAvatar(a16, new Size(i3, i3));
        this.F.setText(b.a(this.F, (int) ah.Z(), a16.nick.get(), acVar.L));
        QQCircleBase$StUserBusiData b16 = this.C.b();
        if (b16 != null && b16.has()) {
            this.G.setVisibility(0);
            this.G.setText(getContext().getString(R.string.f19011418, r.f(b16.fansNum.get())));
            this.H.setVisibility(0);
            this.H.setText(getContext().getString(R.string.f19230475, r.f(b16.feedNum.get())));
        } else {
            this.G.setVisibility(8);
            this.H.setVisibility(8);
        }
        this.I.setUserData(a16);
        q(a16);
        p(a16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.D) {
            o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QCircleSearchUserVideoView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QCircleSearchUserVideoView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements QFSFollowView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f283086a;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f283086a = feedCloudMeta$StUser;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, this.f283086a.nick.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f283086a.f398463id.get());
            i.k(QCircleSearchUserVideoView.this.I, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, hashMap, ((ac) ((QCircleSearchDoubleVideoView) QCircleSearchUserVideoView.this).f283063e).hashCode());
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
        }
    }
}
