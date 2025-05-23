package com.tencent.biz.qqcircle.immersive.feed.ad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes4.dex */
public final class ch extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private GdtAd I;
    private int J = Integer.MIN_VALUE;
    private int K = Integer.MIN_VALUE;
    private View L;
    private URLImageView M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f85561d;

        a(URLImageView uRLImageView) {
            this.f85561d = uRLImageView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.qqcircle.immersive.utils.j.f90213a.I(ch.this.I, this.f85561d, ((QFSBaseFeedChildPresenter) ch.this).f85018i, null, 10);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void i1(QFSFeedAdCardAnimEvent qFSFeedAdCardAnimEvent) {
        String str;
        if (qFSFeedAdCardAnimEvent == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[handleCardAnimEvent] error, event is null");
            return;
        }
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.equals(str, qFSFeedAdCardAnimEvent.getTraceId())) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[handleCardAnimEvent] error, not the same ad");
            return;
        }
        QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[handleCardAnimEvent] state:" + qFSFeedAdCardAnimEvent.getState() + " status:" + qFSFeedAdCardAnimEvent.getStatus());
        if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "1")) {
            j1(2);
            o1(1);
        } else if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "2") && qFSFeedAdCardAnimEvent.getStatus() == 1) {
            j1(1);
        } else if (TextUtils.equals(qFSFeedAdCardAnimEvent.getState(), "2") && qFSFeedAdCardAnimEvent.getStatus() == 2) {
            o1(2);
        }
    }

    private void j1(int i3) {
        if (this.K != i3) {
            QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[hideMarketingPendantImageView] error, not enabled style:" + i3 + " mMarketingPendantStyle:" + this.K);
            return;
        }
        URLImageView uRLImageView = this.M;
        if (uRLImageView == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[hideMarketingPendantImageView] error, mMarketingPendantImageView is null, style:" + i3);
            return;
        }
        QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[hideMarketingPendantImageView] style:" + i3);
        uRLImageView.setVisibility(8);
    }

    private void k1() {
        if (this.L != null) {
            return;
        }
        View view = this.C;
        if (view == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[initCardView] error, mRootView is null");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.v9u);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[initView]", th5);
            }
        }
        this.L = this.C.findViewById(R.id.v9q);
    }

    private void l1() {
        int i3;
        int i16;
        if (this.M != null) {
            return;
        }
        int i17 = this.K;
        if (i17 == 1) {
            i3 = R.id.f380518x;
            i16 = R.id.f380718z;
        } else if (i17 == 2) {
            i3 = R.id.f380618y;
            i16 = R.id.f3808190;
        } else {
            QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[initMarketingPendantImageView] error, not enabled, mMarketingPendantStyle:" + this.K);
            return;
        }
        View view = this.L;
        if (view == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[initMarketingPendantImageView] error, mCardView is null");
            return;
        }
        ViewStub viewStub = (ViewStub) view.findViewById(i3);
        if (viewStub != null) {
            try {
                viewStub.inflate();
            } catch (Throwable th5) {
                QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, th5, new Object[0]);
            }
        }
        this.M = (URLImageView) this.L.findViewById(i16);
    }

    private void n1() {
        this.I = null;
        this.J = Integer.MIN_VALUE;
        this.K = Integer.MIN_VALUE;
        URLImageView uRLImageView = this.M;
        if (uRLImageView != null) {
            uRLImageView.setImageDrawable(null);
            uRLImageView.setVisibility(8);
            this.M = null;
        }
    }

    private void o1(int i3) {
        if (this.K != i3) {
            QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[showMarketingPendantImageView] error, not enabled style:" + i3 + " mMarketingPendantStyle:" + this.K);
            return;
        }
        URLImageView uRLImageView = this.M;
        if (uRLImageView == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[showMarketingPendantImageView] error, view is null, style:" + i3);
            return;
        }
        QLog.i("QFSFeedChildAdMarketingPendantPresenter", 2, "[showMarketingPendantImageView] style:" + i3);
        uRLImageView.setVisibility(0);
    }

    private void p1() {
        String str;
        GdtAd gdtAd = this.I;
        if (gdtAd != null) {
            str = gdtAd.getMarketPendantImageUrl();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[updateMarketingPendantImageView] error, url is empty");
            return;
        }
        URLImageView uRLImageView = this.M;
        if (uRLImageView == null) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 1, "[updateMarketingPendantImageView] error, mMarketingPendantImageView is null");
        } else {
            uRLImageView.setImageURL(str);
            uRLImageView.setOnClickListener(new a(uRLImageView));
        }
    }

    private void updateView() {
        if (this.K == Integer.MIN_VALUE) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 2, "[updateView] error, not enabled");
            return;
        }
        k1();
        l1();
        p1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QFSFeedAdCardAnimEvent.class);
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        int i16;
        super.L0(feedCloudMeta$StFeed, i3);
        GdtAd gdtAd = new GdtAd(u.e(this.E));
        String traceId = gdtAd.getTraceId();
        GdtAd gdtAd2 = this.I;
        if (gdtAd2 != null) {
            str = gdtAd2.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, str)) {
            QLog.e("QFSFeedChildAdMarketingPendantPresenter", 2, "[onBindData] ignore, is the same ad");
            return;
        }
        n1();
        this.I = gdtAd;
        FeedCloudMeta$StFeed c16 = u.c(this.E);
        if (c16 != null) {
            i16 = c16.status.get();
        } else {
            i16 = Integer.MIN_VALUE;
        }
        this.J = i16;
        int C = af.C(gdtAd);
        if (af.i(gdtAd, this.J, C)) {
            this.K = C;
        }
        updateView();
        U0(ae.b(feedCloudMeta$StFeed, i3));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSFeedAdCardAnimEvent) {
            i1((QFSFeedAdCardAnimEvent) QFSFeedAdCardAnimEvent.class.cast(simpleBaseEvent));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildAdMarketingPendantPresenter";
    }
}
