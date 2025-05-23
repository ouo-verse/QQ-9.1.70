package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
class VideoRecommendManager$1 implements Runnable {
    final /* synthetic */ b this$0;

    @Override // java.lang.Runnable
    public void run() {
        QQAppInterface qQAppInterface = (QQAppInterface) com.tencent.mobileqq.kandian.biz.common.b.a();
        b.j(null, ReadInJoyHelper.H(qQAppInterface));
        b.h(null, ReadInJoyHelper.E(qQAppInterface));
        b.i(null, ReadInJoyHelper.F(qQAppInterface));
        b.g(null, ReadInJoyHelper.G(qQAppInterface));
        if (b.d(null) < 0.0f || b.d(null) > 1.0d) {
            b.i(null, 0.8f);
        }
        if (b.c(null) < 1000) {
            b.h(null, 40000);
        }
        if (b.e(null) == 1) {
            b.f(null, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() \u5f00\u5173\u914d\u7f6e\uff0cmIsOpened = " + b.a(null) + ", mStrategyID = " + b.e(null) + ", mStrategyDurationLimit = " + b.c(null) + ", mStrategyDurationPercent = " + b.d(null) + ", mOperator = " + b.b(null));
        }
    }
}
