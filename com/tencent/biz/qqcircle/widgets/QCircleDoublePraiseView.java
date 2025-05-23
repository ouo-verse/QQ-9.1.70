package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.events.QCirclePolyPraiseUpdateEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StLikeBusiData;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;

/* loaded from: classes5.dex */
public class QCircleDoublePraiseView extends FrameLayout implements SimpleEventReceiver, com.tencent.biz.qqcircle.richframework.part.a<QCircleReportBean> {

    /* renamed from: d, reason: collision with root package name */
    private FeedCloudMeta$StFeed f92966d;

    /* renamed from: e, reason: collision with root package name */
    private String f92967e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f92968f;

    /* renamed from: h, reason: collision with root package name */
    private int f92969h;

    /* renamed from: i, reason: collision with root package name */
    private QCircleReportBean f92970i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f92965m = ViewUtils.dpToPx(125.0f);
    private static final int C = ViewUtils.dpToPx(125.0f);

    public QCircleDoublePraiseView(Context context) {
        this(context, null);
    }

    private void b(List<QQCircleTianShu$MapEntry> list) {
        boolean z16;
        if (list != null) {
            for (QQCircleTianShu$MapEntry qQCircleTianShu$MapEntry : list) {
                if ("double_screen_like_icon".equals(qQCircleTianShu$MapEntry.key.get())) {
                    this.f92967e = qQCircleTianShu$MapEntry.value.get();
                    z16 = true;
                    QLog.d("QCircleDoublePraiseView", 1, "[parseDoubleLikeUrl] get url from server:" + this.f92967e);
                    break;
                }
            }
        }
        z16 = false;
        boolean g16 = com.tencent.biz.qqcircle.helpers.w.a().g();
        this.f92968f = g16;
        if (!z16 && g16) {
            this.f92967e = com.tencent.biz.qqcircle.k.k();
        }
    }

    private void d(int i3, int i16) {
        FeedCloudMeta$StLike feedCloudMeta$StLike;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f92966d;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLike = feedCloudMeta$StFeed.likeInfo) != null) {
            feedCloudMeta$StLike.count.set(i16);
            new QQCircleFeedBase$StLikeBusiData();
            try {
                QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData = new QQCircleFeedBase$StLikeBusiData();
                qQCircleFeedBase$StLikeBusiData.mergeFrom(this.f92966d.likeInfo.busiData.get().toByteArray());
                if (i3 == 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : qQCircleFeedBase$StLikeBusiData.likeIDs.get()) {
                        if (TextUtils.equals(str, "206008") || TextUtils.equals(str, "205993")) {
                            arrayList.add(str);
                        }
                    }
                    qQCircleFeedBase$StLikeBusiData.likeIDs.set(arrayList);
                } else if (qQCircleFeedBase$StLikeBusiData.likeIDs.get().contains("6")) {
                    return;
                } else {
                    qQCircleFeedBase$StLikeBusiData.likeIDs.add("6");
                }
                this.f92966d.likeInfo.busiData.set(ByteStringMicro.copyFrom(qQCircleFeedBase$StLikeBusiData.toByteArray()));
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.richframework.part.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean getReportBean() {
        return QCircleReportBean.getReportBean("QCircleDoublePraiseView", this.f92970i);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QCirclePolyPraiseUpdateEvent.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView.1
            @Override // java.lang.Runnable
            public void run() {
                QCircleDoublePraiseView.this.removeAllViews();
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QCirclePolyPraiseUpdateEvent) && ha0.b.g(this.f92966d)) {
            QCirclePolyPraiseUpdateEvent qCirclePolyPraiseUpdateEvent = (QCirclePolyPraiseUpdateEvent) simpleBaseEvent;
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f92966d;
            if (feedCloudMeta$StFeed != null && TextUtils.equals(feedCloudMeta$StFeed.f398449id.get(), qCirclePolyPraiseUpdateEvent.mTargetFeedId)) {
                d(qCirclePolyPraiseUpdateEvent.mPraisedStatus, qCirclePolyPraiseUpdateEvent.mPraisedNum);
            }
        }
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        setFeed(feedCloudMeta$StFeed, 0);
    }

    public void setPageType(int i3) {
        this.f92969h = i3;
    }

    public QCircleDoublePraiseView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        this.f92966d = feedCloudMeta$StFeed;
        this.f92967e = null;
        QQCircleTianShu$AdItem L = com.tencent.biz.qqcircle.immersive.utils.r.L(feedCloudMeta$StFeed, 1050);
        b(L != null ? L.argList.get() : null);
    }

    public void setReportBean(QCircleReportBean qCircleReportBean) {
        this.f92970i = QCircleReportBean.setReportBean("QCircleDoublePraiseView", qCircleReportBean);
    }

    public QCircleDoublePraiseView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public void c(float f16, float f17) {
    }
}
