package com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private e30.b f86657a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f86658b = true;

    private static boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_cache_feed_insert", true);
    }

    private boolean b(String str, List<e30.b> list) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<e30.b> it = list.iterator();
        while (it.hasNext()) {
            FeedCloudMeta$StFeed g16 = it.next().g();
            if (g16 != null && TextUtils.equals(g16.f398449id.get(), str)) {
                z16 = true;
            }
        }
        return z16;
    }

    private void c(UIStateData<List<e30.b>> uIStateData) {
        e30.b bVar = this.f86657a;
        List<e30.b> data = uIStateData.getData();
        if (bVar != null && data != null) {
            this.f86657a = null;
            boolean b16 = b(bVar.g().f398449id.get(), data);
            RFWLog.d("FeedLine_QFSInsertFeedUtils", RFWLog.USR, "setFeedValue real do insert, feedId:" + bVar.g().f398449id.get() + ",findInOnlineList:" + b16);
            if (!b16) {
                data.add(0, bVar);
                uIStateData.setPos(0);
            }
        }
    }

    public void d(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            RFWLog.d("FeedLine_QFSInsertFeedUtils", RFWLog.USR, "onPublishFeed feedBlockData:" + bVar.g().f398449id.get());
        }
        this.f86657a = bVar;
    }

    public void e(UIStateData<List<e30.b>> uIStateData) {
        if (a() && uIStateData != null && uIStateData.getData() != null && uIStateData.getState() == 3 && this.f86658b) {
            this.f86658b = false;
            c(uIStateData);
        }
    }
}
