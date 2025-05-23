package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSMixFeedSelectFeedEvent;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qcircle.application.QCircleApplication;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMixFeedRecommendCardItemView extends QFSMixFeedBaseWidgetView<QQCircleDitto$StItemInfo> implements com.tencent.biz.qqcircle.immersive.scrollers.a, SimpleEventReceiver {

    /* renamed from: e, reason: collision with root package name */
    private y70.c f90864e;

    /* renamed from: f, reason: collision with root package name */
    private RoundCorneredFrameLayout f90865f;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StFeed f90866h;

    /* renamed from: i, reason: collision with root package name */
    private int f90867i;

    /* renamed from: m, reason: collision with root package name */
    private static final int f90863m = QCircleApplication.APP.getResources().getDimensionPixelSize(R.dimen.d4t);
    private static final int C = QCircleApplication.APP.getResources().getDimensionPixelSize(R.dimen.d4v);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements RoundCorneredFrameLayout.a {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout.a
        public boolean a(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || !cx.i(QFSMixFeedRecommendCardItemView.this.f90865f, true, false)) {
                return false;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSMixFeedSelectFeedEvent(QFSMixFeedRecommendCardItemView.this.f90867i));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends QFSAsyncUtils.Callback<Void, Void> {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        public Void doBackgroundAction(Void... voidArr) {
            if (QFSMixFeedRecommendCardItemView.this.f90866h == null) {
                return null;
            }
            QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
            try {
                qQCircleFeedBase$StFeedBusiReqData.mergeFrom(QFSMixFeedRecommendCardItemView.this.f90866h.busiData.get().toByteArray());
                QCirclePushInfoManager.e().n(QFSMixFeedRecommendCardItemView.this.f90866h.f398449id.get(), qQCircleFeedBase$StFeedBusiReqData.pushList);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            return null;
        }
    }

    public QFSMixFeedRecommendCardItemView(@NonNull Context context) {
        super(context);
        s0(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void n0() {
        DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(this.f90865f).setLayoutParams(this.f90865f.getLayoutParams()).setDefaultWidth(C).setDefaultHeight(f90863m).setTargetWidth(bz.j()).setMaxCardWidthScale(1.5f));
    }

    private void q0(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        n0();
    }

    private void s0(View view) {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) view.findViewById(R.id.f516528o);
        this.f90865f = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(cx.a(8.0f));
        y70.c cVar = new y70.c();
        this.f90864e = cVar;
        cVar.c(new y70.b());
        this.f90864e.c(new y70.e());
        this.f90864e.c(new y70.d());
        this.f90864e.j(this.mParentView);
        this.f90864e.h(view);
        this.f90865f.setTouchIntercept(new a());
    }

    private void u0(QFSVideoOnPlayEvent qFSVideoOnPlayEvent) {
        String feedId = qFSVideoOnPlayEvent.getFeedId();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.f90866h;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (feedCloudMeta$StFeed.f398449id.get().equals(feedId) && qFSVideoOnPlayEvent.getPlayHashCode() == hashCode()) {
            return;
        }
        this.f90864e.a();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        this.f90864e.a();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSVideoOnPlayEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gbk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMixFeedRecommendCard";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        this.f90866h = p0(qQCircleDitto$StItemInfo);
        this.f90867i = i3;
        this.f90864e.i(getQCircleExtraTypeInfo());
        this.f90864e.f(qQCircleDitto$StItemInfo, i3);
        n0();
        r0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f90864e.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f90864e.g();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSVideoOnPlayEvent) {
            u0((QFSVideoOnPlayEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            q0((QCircleConfigChangeEvent) simpleBaseEvent);
        }
    }

    public FeedCloudMeta$StFeed p0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        if (qQCircleDitto$StItemInfo != null && qQCircleDitto$StItemInfo.feeds.size() != 0) {
            return qQCircleDitto$StItemInfo.feeds.get(0);
        }
        return null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        this.f90864e.pause();
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.f90864e.play();
    }

    public void r0() {
        QFSAsyncUtils.executeSub(new b(), new Void[0]);
    }
}
