package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAdDescItemView extends QCircleBaseWidgetView<QFSCommentItemInfo> implements View.OnClickListener {
    private FeedCloudMeta$StFeed C;
    private final Size D;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f83157d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f83158e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f83159f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f83160h;

    /* renamed from: i, reason: collision with root package name */
    private QUIButton f83161i;

    /* renamed from: m, reason: collision with root package name */
    private QFSCommentItemInfo f83162m;

    public QFSCommentAdDescItemView(@NonNull Context context) {
        super(context);
        this.D = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159390d01);
        initView();
    }

    private void initView() {
        this.f83157d = (QCircleAvatarView) findViewById(R.id.a2o);
        this.f83158e = (TextView) findViewById(R.id.fxo);
        this.f83159f = (TextView) findViewById(R.id.fxm);
        this.f83160h = (TextView) findViewById(R.id.b3y);
        this.f83161i = (QUIButton) findViewById(R.id.f164650af4);
        this.f83157d.setOnClickListener(this);
        this.f83158e.setOnClickListener(this);
        this.f83159f.setOnClickListener(this);
        this.f83161i.setOnClickListener(this);
        findViewById(R.id.b3r).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        int i3;
        try {
            GdtAd gdtAd = new GdtAd(new qq_ad_get.QQAdGetRsp.AdInfo().mergeFrom(com.tencent.biz.qqcircle.immersive.feed.ad.u.d(this.C).busiData.get().toByteArray()));
            QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
            qCircleExtraTypeInfo.mFeed = this.C;
            if (view.getId() == R.id.a2o) {
                i3 = 10086;
            } else if (view.getId() == R.id.fxo) {
                i3 = 10087;
            } else if (view.getId() == R.id.fxm) {
                i3 = 10088;
            } else if (view.getId() == R.id.f164650af4) {
                i3 = 10089;
            } else {
                i3 = 10090;
            }
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(gdtAd, view, 0, qCircleExtraTypeInfo, i3);
        } catch (Exception e16) {
            QLog.e("QFSCommentFeedDescItemView", 1, "merge error. " + e16);
        }
    }

    private void n0(final View view) {
        if (this.C == null) {
            QLog.e("QFSCommentFeedDescItemView", 1, "feed is null. ");
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.d
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentAdDescItemView.this.m0(view);
                }
            });
        }
    }

    private void o0() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.C;
        if (feedCloudMeta$StFeed != null && this.f83161i != null) {
            FeedCloudMeta$StFeed d16 = com.tencent.biz.qqcircle.immersive.feed.ad.u.d(feedCloudMeta$StFeed);
            if (d16 == null) {
                QLog.e("QFSCommentFeedDescItemView", 1, "[updateActionText] adFeed is null. ");
            } else {
                this.f83161i.setText(d16.subtitle.get());
            }
        }
    }

    private void p0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QCircleAvatarView qCircleAvatarView;
        if (feedCloudMeta$StUser != null && (qCircleAvatarView = this.f83157d) != null) {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.D);
        }
    }

    private void q0() {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        QFSCommentItemInfo qFSCommentItemInfo = this.f83162m;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && this.f83159f != null) {
            String str = feedCloudMeta$StComment.content.get();
            if (TextUtils.isEmpty(str)) {
                this.f83159f.setVisibility(8);
            } else {
                this.f83159f.setText(str);
                this.f83159f.setVisibility(0);
            }
        }
    }

    private void r0() {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        TextView textView;
        QFSCommentItemInfo qFSCommentItemInfo = this.f83162m;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && (textView = this.f83160h) != null) {
            textView.setText(com.tencent.biz.qqcircle.widgets.comment.b.d(feedCloudMeta$StComment.createTime.get() * 1000));
        }
    }

    private void s0() {
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        QFSCommentItemInfo qFSCommentItemInfo = this.f83162m;
        if (qFSCommentItemInfo != null && (feedCloudMeta$StComment = qFSCommentItemInfo.comment) != null && this.f83158e != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = feedCloudMeta$StComment.postUser.get();
            p0(feedCloudMeta$StUser);
            this.f83158e.setText(feedCloudMeta$StUser.nick.get());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g9o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSCommentFeedDescItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSCommentItemInfo qFSCommentItemInfo, int i3) {
        this.f83162m = qFSCommentItemInfo;
        s0();
        q0();
        r0();
        o0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fxm || id5 == R.id.a2o || id5 == R.id.b3r || id5 == R.id.fxo || id5 == R.id.f164650af4) {
            n0(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.C = feedCloudMeta$StFeed;
    }
}
