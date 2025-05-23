package com.tencent.mobileqq.pymk;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/pymk/PYMKCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", "getClearSize", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PYMKCleanUpThoroughCacheTool implements y {
    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public ArrayList<String> getWhiteList() {
        return y.a.c(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        QLog.i("PYMKCleanUpThoroughCacheTool", 1, "start clearCache");
        ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeAllPymkData();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Manager manager = peekAppRuntime.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
            if (manager instanceof MayknowRecommendManager) {
                ((MayknowRecommendManager) manager).e();
            }
        }
    }
}
