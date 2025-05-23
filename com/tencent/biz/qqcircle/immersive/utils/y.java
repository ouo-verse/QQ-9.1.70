package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, String> f90244a = new LruCache<>(500);

    public static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_post_at_front_queue", true);
    }

    public static Collection<e30.b> b(List<e30.b> list, List<e30.b> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        for (int i3 = 0; i3 < list2.size(); i3++) {
            e30.b bVar = list2.get(i3);
            if (bVar != null && !h(bVar)) {
                QLog.d("FeedLine_QFSFeedLineUtils", 1, "get a not need filter feed, index= " + i3 + ",id= " + bVar.g().f398449id.get());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e30.b bVar2 = (e30.b) it.next();
                    if (bVar2 != null && TextUtils.equals(bVar2.g().f398449id.get(), bVar.g().f398449id.get())) {
                        it.remove();
                        QLog.d("FeedLine_QFSFeedLineUtils", 1, "remove origin feed from preFeedList");
                    }
                }
            }
        }
        return w20.a.j().getUniqueData(e30.b.class, arrayList, list2);
    }

    public static boolean c(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null) {
            return false;
        }
        return d(qCircleInitBean.getFeedId());
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str) || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_no_use_simple_feed_when_fetch_error", true)) {
            return false;
        }
        return !TextUtils.isEmpty(f90244a.get(str));
    }

    public static boolean e(e30.b bVar) {
        if (bVar == null) {
            return false;
        }
        return f(bVar.g());
    }

    public static boolean f(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.feedType.get() != 4) {
            return false;
        }
        return true;
    }

    public static boolean g() {
        if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_enable_ad_feed_filter_repeat_item", 0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean h(@NonNull e30.b bVar) {
        if (bVar.g().feedType.get() == 4) {
            return g();
        }
        return true;
    }

    public static boolean i(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        int i3 = feedCloudMeta$StFeed.feedType.get();
        int i16 = feedCloudMeta$StFeed.type.get();
        if (i3 != 1 || i16 != 3) {
            return false;
        }
        return true;
    }

    public static boolean j(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.type.get() != 2) {
            return false;
        }
        return true;
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.d("FeedLine_QFSFeedLineUtils", 1, "onFeedFetchError :" + str);
        f90244a.put(str, str);
    }

    public static void l(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (a()) {
            RFWThreadManager.getUIHandler().postAtFrontOfQueue(runnable);
        } else {
            QLog.d("FeedLine_QFSFeedLineUtils", 1, "[runOn0vvUiThread] use post");
            RFWThreadManager.getUIHandler().post(runnable);
        }
    }

    public static void m(Runnable runnable, Runnable runnable2) {
        if (runnable != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(runnable);
        }
        l(runnable2);
    }
}
