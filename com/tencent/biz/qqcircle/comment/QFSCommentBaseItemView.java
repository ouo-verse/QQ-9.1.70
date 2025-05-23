package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QCircleCommentAvatarDecorateView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class QFSCommentBaseItemView extends QCircleBaseWidgetView<QFSCommentItemInfo> implements View.OnClickListener {
    private boolean C;
    protected com.tencent.biz.qqcircle.widgets.comment.c D;
    private FeedCloudMeta$StUser E;
    private final Size F;

    /* renamed from: d, reason: collision with root package name */
    protected QCircleAvatarView f83163d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleCommentAvatarDecorateView f83164e;

    /* renamed from: f, reason: collision with root package name */
    protected LottieAnimationView f83165f;

    /* renamed from: h, reason: collision with root package name */
    protected View f83166h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f83167i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f83168m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QFSAsyncUtils.Callback<Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f83169a;

        a(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f83169a = feedCloudMeta$StUser;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void doMainAction(Void r16) {
            if (QFSCommentBaseItemView.this.C) {
                QFSCommentBaseItemView.this.u0();
            }
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            PBBoolField pBBoolField;
            QQCircleBase$StUserBusiData userExtraData = QCircleHostUtil.getUserExtraData(this.f83169a);
            if (userExtraData == null || (pBBoolField = userExtraData.has_unread_feed) == null) {
                return null;
            }
            QFSCommentBaseItemView.this.C = pBBoolField.get();
            return null;
        }
    }

    public QFSCommentBaseItemView(@NonNull Context context) {
        super(context);
        this.F = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159390d01);
        initView();
    }

    private void initView() {
        this.f83163d = (QCircleAvatarView) findViewById(R.id.a2o);
        this.f83164e = (QCircleCommentAvatarDecorateView) findViewById(R.id.t1h);
        this.f83165f = (LottieAnimationView) findViewById(R.id.f164547t15);
        this.f83166h = findViewById(R.id.t1z);
        this.f83167i = (TextView) findViewById(R.id.b3y);
        this.f83168m = (TextView) findViewById(R.id.xrx);
        QCircleAvatarView qCircleAvatarView = this.f83163d;
        if (qCircleAvatarView == null) {
            return;
        }
        qCircleAvatarView.setOnClickListener(this);
        this.f83163d.setContentDescription(com.tencent.biz.qqcircle.utils.h.a(R.string.f187843v3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0() {
        p0();
        o0(null);
        this.f83166h = null;
        this.f83165f = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentBaseItemView";
    }

    public void o0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        View view = this.f83166h;
        if (view != null && this.f83163d != null && view.getVisibility() == 0) {
            com.tencent.biz.qqcircle.helpers.e eVar = com.tencent.biz.qqcircle.helpers.e.f84616a;
            eVar.a(this.f83166h);
            this.f83163d.setTag(-3, Boolean.FALSE);
            this.f83163d.setTag(-4, feedCloudMeta$StFeed);
            eVar.b(this.E);
        }
        this.C = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.a2o) {
            p0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p0() {
        QCircleAvatarView qCircleAvatarView = this.f83163d;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.g(this.f83165f);
        }
        this.C = false;
    }

    public QCircleAvatarView q0() {
        return this.f83163d;
    }

    public boolean r0() {
        return this.C;
    }

    public void setOnCommentElementClickListener(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.D = cVar;
    }

    public void u0() {
        View view = this.f83166h;
        if (view != null && this.f83163d != null) {
            com.tencent.biz.qqcircle.helpers.e eVar = com.tencent.biz.qqcircle.helpers.e.f84616a;
            if (!eVar.d(view)) {
                QLog.d("QFSCommentBaseItemView", 4, "showApertureStaticAnimation");
                this.f83163d.setTag(-3, Boolean.TRUE);
                eVar.f(this.f83166h, 1.5f);
            }
        }
    }

    public void v0() {
        if (this.f83166h != null && this.f83163d != null) {
            QLog.d("QFSCommentBaseItemView", 4, "showApertureUpdateAnimation");
            this.f83163d.setTag(-3, Boolean.TRUE);
            com.tencent.biz.qqcircle.helpers.e.f84616a.g(this.f83166h, 1.5f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QCircleAvatarView qCircleAvatarView;
        if (feedCloudMeta$StUser != null && (qCircleAvatarView = this.f83163d) != null) {
            this.E = feedCloudMeta$StUser;
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.F);
            this.f83163d.setClickable(false);
            QCircleCommentAvatarDecorateView qCircleCommentAvatarDecorateView = this.f83164e;
            if (qCircleCommentAvatarDecorateView != null) {
                qCircleCommentAvatarDecorateView.setCommentDecorate(feedCloudMeta$StUser.iconDecorate, new QCircleCommentAvatarDecorateView.a() { // from class: com.tencent.biz.qqcircle.comment.f
                    @Override // com.tencent.biz.qqcircle.widgets.QCircleCommentAvatarDecorateView.a
                    public final void a() {
                        QFSCommentBaseItemView.this.s0();
                    }
                });
            }
            QFSAsyncUtils.executeSub(new a(feedCloudMeta$StUser), new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0(long j3) {
        TextView textView = this.f83167i;
        if (textView == null) {
            return;
        }
        textView.setText(com.tencent.biz.qqcircle.widgets.comment.b.d(j3 * 1000));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
    }
}
