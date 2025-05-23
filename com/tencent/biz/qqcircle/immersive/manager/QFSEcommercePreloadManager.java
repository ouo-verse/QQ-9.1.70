package com.tencent.biz.qqcircle.immersive.manager;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.adapter.n;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class QFSEcommercePreloadManager {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QFSEcommercePreloadManager f87189a;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f87190b = new AtomicBoolean(false);

    QFSEcommercePreloadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        Object obj;
        if (n.k(feedCloudMeta$StFeed)) {
            return feedCloudMeta$StFeed.hashCode() + ":" + i3;
        }
        StringBuilder sb5 = new StringBuilder();
        Object obj2 = "";
        if (context == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(context.hashCode());
        }
        sb5.append(obj);
        sb5.append(":");
        if (feedCloudMeta$StFeed != null) {
            obj2 = Integer.valueOf(feedCloudMeta$StFeed.hashCode());
        }
        sb5.append(obj2);
        sb5.append(":");
        sb5.append(i3);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudCommon$Entry> list;
        if (feedCloudMeta$StFeed == null || (list = feedCloudMeta$StFeed.extInfo.get()) == null || list.isEmpty()) {
            return "-1";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && "source_from".equals(feedCloudCommon$Entry.key.get())) {
                String str = feedCloudCommon$Entry.value.get();
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return "-1";
    }

    public static QFSEcommercePreloadManager j() {
        if (f87189a == null) {
            synchronized (QFSEcommercePreloadManager.class) {
                if (f87189a == null) {
                    f87189a = new QFSEcommercePreloadManager();
                }
            }
        }
        return f87189a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Context context, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.commentExtraInfo.displayShopEntrance.get()) {
            String e16 = e(context, feedCloudMeta$StFeed, 4);
            QLog.d("QFSEcommercePreloadManager", 1, "preloadCommentEcommerceCard uniqueId = " + e16);
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).preloadGoodsViewModel(e16, 2, null, feedCloudMeta$StFeed.f398449id.get(), 4, 0, feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.recomInfo.recomTrace.get(), ba.d(feedCloudMeta$StFeed), i3, h(feedCloudMeta$StFeed), false, n.k(feedCloudMeta$StFeed));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Context context, int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner) != null && feedCloudMeta$StLiteBanner.style_type.get() == 4 && feedCloudMeta$StFeed.liteBanner.business_type.get() == 4) {
            String e16 = e(context, feedCloudMeta$StFeed, f(feedCloudMeta$StFeed));
            QLog.d("QFSEcommercePreloadManager", 1, "preloadFeedEcommerceCard uniqueId = " + e16);
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).preloadGoodsViewModel(e16, 2, null, feedCloudMeta$StFeed.f398449id.get(), f(feedCloudMeta$StFeed), 0, feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.recomInfo.recomTrace.get(), ba.d(feedCloudMeta$StFeed), i3, h(feedCloudMeta$StFeed), g(feedCloudMeta$StFeed).booleanValue(), false);
        }
    }

    public int f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return 2;
        }
        if (feedCloudMeta$StFeed.type.get() == 2) {
            return 3;
        }
        if (feedCloudMeta$StFeed.type.get() != 1) {
            return 2;
        }
        return 1;
    }

    public Boolean g(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (f.f().c(feedCloudMeta$StFeed) > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    public IQQGoodsViewModel i(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        String e16 = e(context, feedCloudMeta$StFeed, i3);
        QLog.d("QFSEcommercePreloadManager", 1, "getViewModel uniqueId = " + e16);
        return ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).createGoodsViewModel(e16, 2, null, feedCloudMeta$StFeed.f398449id.get(), i3, 0, feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.recomInfo.recomTrace.get(), ba.d(feedCloudMeta$StFeed), i16, h(feedCloudMeta$StFeed), g(feedCloudMeta$StFeed).booleanValue(), n.k(feedCloudMeta$StFeed));
    }

    public boolean k(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).isPreloadGoodsDataSuccess(feedCloudMeta$StFeed.f398449id.get(), 8, n.k(feedCloudMeta$StFeed));
    }

    public void l(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        if (!u.b()) {
            QLog.d("QFSEcommercePreloadManager", 1, "preProcessAdFeed return from config");
            return;
        }
        List<FeedCloudMeta$StFeed> list = feedCloudRead$StGetFeedListRsp.vecFeed.get();
        if (list.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = list.get(i3);
            FeedCloudMeta$StFeed d16 = u.d(feedCloudMeta$StFeed);
            if (d16 != null) {
                QLog.d("QFSEcommercePreloadManager", 1, "preProcessAdFeed feedId:" + feedCloudMeta$StFeed.f398449id.get() + ",finalVideoId:" + feedCloudMeta$StFeed.video.fileId);
                feedCloudMeta$StFeed.video.set(d16.video);
            }
        }
    }

    public void n(final Context context, final int i3, List<e30.b> list) {
        if (list != null && list.size() != 0) {
            final ArrayList arrayList = new ArrayList(list);
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager.2
                @Override // java.lang.Runnable
                public void run() {
                    List list2 = arrayList;
                    if (list2 != null && list2.size() != 0) {
                        Iterator it = arrayList.iterator();
                        synchronized (it) {
                            while (it.hasNext()) {
                                e30.b bVar = (e30.b) it.next();
                                if (bVar != null) {
                                    QFSEcommercePreloadManager.this.o(context, i3, bVar.g());
                                    QFSEcommercePreloadManager.this.m(context, i3, bVar.g());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public void p(final FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && n.k(feedCloudMeta$StFeed)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager.1
                @Override // java.lang.Runnable
                public void run() {
                    String e16 = QFSEcommercePreloadManager.this.e(null, feedCloudMeta$StFeed, 8);
                    QLog.d("QFSEcommercePreloadManager", 1, "preloadTopViewEcommerceCard uniqueId = " + e16);
                    ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).preloadGoodsViewModel(e16, 2, null, feedCloudMeta$StFeed.f398449id.get(), 8, 0, feedCloudMeta$StFeed.poster.f398463id.get(), feedCloudMeta$StFeed.recomInfo.recomTrace.get(), ba.d(feedCloudMeta$StFeed), 0, QFSEcommercePreloadManager.this.h(feedCloudMeta$StFeed), QFSEcommercePreloadManager.this.g(feedCloudMeta$StFeed).booleanValue(), n.k(feedCloudMeta$StFeed));
                }
            });
        }
    }

    public void q(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSEcommercePreloadManager", 1, "releaseTopViewModel_2 feed == null");
            return;
        }
        QLog.d("QFSEcommercePreloadManager", 1, "releaseTopViewModel_2 uniqueId = " + feedCloudMeta$StFeed.hashCode());
        if (n.k(feedCloudMeta$StFeed)) {
            ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).releaseGoodsViewModel(String.valueOf(feedCloudMeta$StFeed.hashCode()));
        }
    }

    public void r(Context context) {
        if (context == null) {
            QLog.e("QFSEcommercePreloadManager", 1, "releaseViewModels_1 context = null");
            return;
        }
        QLog.d("QFSEcommercePreloadManager", 1, "releaseViewModels_1 uniqueId = " + context.hashCode());
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).releaseGoodsViewModel(String.valueOf(context.hashCode()));
    }
}
