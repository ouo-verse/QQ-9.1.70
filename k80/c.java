package k80;

import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.events.QFSSearchLiveStatusChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.utils.ah;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends g {
    private int T;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class a implements IRequestRoomStatus.IRoomResult {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<c> f411873a;

        /* renamed from: b, reason: collision with root package name */
        private final FeedCloudMeta$StFeed f411874b;

        a(c cVar, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            this.f411873a = new WeakReference<>(cVar);
            this.f411874b = feedCloudMeta$StFeed;
        }

        private void a() {
            this.f411874b.live.room.roomState.set(2);
            p.H(this.f411874b, 3);
            c cVar = this.f411873a.get();
            if (cVar != null && cVar.Q && ((QFSBaseFeedChildPresenter) cVar).f85017h == this.f411874b) {
                cVar.N1();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus.IRoomResult
        public void onResult(long j3, boolean z16, int i3, @Nullable String str) {
            if (i3 != 0) {
                QLog.w("QFSSearchBaseCardLivePresenter", 1, "#onResult: roomId=" + j3 + ", errorCode=" + i3 + ", errorMsg=" + str);
                return;
            }
            if (z16) {
                QCircleToast.j(QCircleToast.f91645e, h.a(R.string.f171205d51), 0);
            } else {
                a();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long O1() {
        T t16 = this.f85017h;
        if (t16 != 0) {
            return ((FeedCloudMeta$StFeed) t16).live.room.roomId.get();
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean P1() {
        T t16 = this.f85017h;
        if (t16 != 0 && p.j((FeedCloudMeta$StFeed) t16) == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void N1() {
        a();
        T0(new j80.a());
        QFSSearchLiveStatusChangeEvent qFSSearchLiveStatusChangeEvent = new QFSSearchLiveStatusChangeEvent((FeedCloudMeta$StFeed) this.f85017h);
        boolean z16 = true;
        if (this.T != 1) {
            z16 = false;
        }
        qFSSearchLiveStatusChangeEvent.setOnlyLiveEvent(z16);
        SimpleEventBus.getInstance().dispatchEvent(qFSSearchLiveStatusChangeEvent);
    }

    public void Q1(int i3) {
        this.T = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public int b0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // k80.d
    public String i1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.g, k80.d
    public void o1() {
        if (!P1()) {
            return;
        }
        x1();
        ah.g(m0(), false, (FeedCloudMeta$StFeed) this.f85017h, 17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.g, com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public boolean onPlayError(int i3) {
        super.onPlayError(i3);
        long O1 = O1();
        if (O1 > 0) {
            ((IRequestRoomStatus) QRoute.api(IRequestRoomStatus.class)).request(O1, new a(this, (FeedCloudMeta$StFeed) this.f85017h));
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k80.g, k80.d, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        this.P.R1(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), 0);
        if (P1()) {
            super.play();
        }
    }

    @Override // k80.g, k80.d, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: q1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.L.b();
        SimpleEventBus.getInstance().dispatchEvent(new QFSSearchLiveStatusChangeEvent(feedCloudMeta$StFeed));
    }

    @Override // k80.g, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchBaseCardLivePresenter";
    }
}
