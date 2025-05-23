package lo2;

import android.app.Activity;
import androidx.annotation.Nullable;
import circlesearch.CircleSearchExhibition$UnifyFeedsResult;
import circlesearch.CircleSearchExhibition$UnifySearchData;
import circlesearch.CircleSearchExhibition$UnifyUserCardResult;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac extends z {

    /* renamed from: b0, reason: collision with root package name */
    private CircleSearchExhibition$UnifySearchData f415102b0;

    /* renamed from: c0, reason: collision with root package name */
    private a f415103c0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        List<FeedCloudMeta$StFeed> getFeedList();

        String getTitle();

        boolean isDataValid();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final CircleSearchExhibition$UnifyFeedsResult f415104a;

        b(CircleSearchExhibition$UnifySearchData circleSearchExhibition$UnifySearchData) {
            CircleSearchExhibition$UnifyFeedsResult circleSearchExhibition$UnifyFeedsResult = circleSearchExhibition$UnifySearchData.feed_result.get();
            this.f415104a = circleSearchExhibition$UnifyFeedsResult;
            ac.b0("qDouble", circleSearchExhibition$UnifyFeedsResult.feeds.get());
        }

        public int a() {
            return this.f415104a.rank.get();
        }

        public boolean b() {
            if (a() >= 0) {
                return true;
            }
            return false;
        }

        @Override // lo2.ac.a
        public List<FeedCloudMeta$StFeed> getFeedList() {
            return this.f415104a.feeds.get();
        }

        @Override // lo2.ac.a
        public String getTitle() {
            return this.f415104a.title.get();
        }

        @Override // lo2.ac.a
        public boolean isDataValid() {
            return !this.f415104a.feeds.isEmpty();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        private final CircleSearchExhibition$UnifyUserCardResult f415105a;

        /* renamed from: b, reason: collision with root package name */
        private QQCircleBase$StUserBusiData f415106b;

        c(CircleSearchExhibition$UnifySearchData circleSearchExhibition$UnifySearchData) {
            CircleSearchExhibition$UnifyUserCardResult circleSearchExhibition$UnifyUserCardResult = circleSearchExhibition$UnifySearchData.user_result.get();
            this.f415105a = circleSearchExhibition$UnifyUserCardResult;
            c();
            ac.b0("qArt", circleSearchExhibition$UnifyUserCardResult.feeds.get());
        }

        private void c() {
            QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
            this.f415106b = qQCircleBase$StUserBusiData;
            try {
                qQCircleBase$StUserBusiData.mergeFrom(this.f415105a.user.busiData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w(m.f415228a0, 1, "#parseBusiInfo", e16);
                this.f415106b = null;
            }
        }

        public FeedCloudMeta$StUser a() {
            return this.f415105a.user.get();
        }

        @Nullable
        public QQCircleBase$StUserBusiData b() {
            return this.f415106b;
        }

        @Override // lo2.ac.a
        public List<FeedCloudMeta$StFeed> getFeedList() {
            return this.f415105a.feeds.get();
        }

        @Override // lo2.ac.a
        public String getTitle() {
            return "";
        }

        @Override // lo2.ac.a
        public boolean isDataValid() {
            if (this.f415105a != null) {
                return true;
            }
            return false;
        }
    }

    public ac(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        g0(ufsResultItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b0(final String str, final List<FeedCloudMeta$StFeed> list) {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        qBaseActivity.runOnUiThread(new Runnable() { // from class: lo2.ab
            @Override // java.lang.Runnable
            public final void run() {
                ac.e0(qBaseActivity, str, list);
            }
        });
    }

    private static void c0() {
        final QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        qBaseActivity.runOnUiThread(new Runnable() { // from class: lo2.aa
            @Override // java.lang.Runnable
            public final void run() {
                ac.f0(qBaseActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e0(Activity activity, String str, List list) {
        QFSSearchPrerenderManager.E(activity).b(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0(Activity activity) {
        QFSSearchPrerenderManager.E(activity).u();
    }

    private void g0(UfsResultItem ufsResultItem) {
        byte[] bArr = ufsResultItem.layoutContent;
        if (bArr.length > 0) {
            CircleSearchExhibition$UnifySearchData circleSearchExhibition$UnifySearchData = new CircleSearchExhibition$UnifySearchData();
            this.f415102b0 = circleSearchExhibition$UnifySearchData;
            try {
                circleSearchExhibition$UnifySearchData.mergeFrom(bArr);
                i0();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w(m.f415228a0, 1, "#parseHotEventInfo", e16);
            }
        }
    }

    private void i0() {
        c0();
        int i3 = this.f415102b0.type.get();
        if (i3 != 1) {
            if (i3 == 2) {
                this.f415103c0 = new c(this.f415102b0);
                return;
            }
            return;
        }
        this.f415103c0 = new b(this.f415102b0);
    }

    @Override // lo2.m
    public boolean N() {
        a aVar = this.f415103c0;
        if (aVar != null && aVar.isDataValid()) {
            return true;
        }
        return false;
    }

    @Override // lo2.z
    public List<FeedCloudMeta$StFeed> W() {
        return this.f415103c0.getFeedList();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public String getTitleSpans() {
        return this.f415103c0.getTitle();
    }

    public a d0() {
        return this.f415103c0;
    }
}
