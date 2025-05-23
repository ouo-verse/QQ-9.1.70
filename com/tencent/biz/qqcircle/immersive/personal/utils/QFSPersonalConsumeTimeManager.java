package com.tencent.biz.qqcircle.immersive.personal.utils;

import android.text.TextUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class QFSPersonalConsumeTimeManager {

    /* renamed from: b, reason: collision with root package name */
    private static volatile QFSPersonalConsumeTimeManager f89047b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f89048a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f89052a;

        /* renamed from: b, reason: collision with root package name */
        long f89053b;

        a() {
        }
    }

    QFSPersonalConsumeTimeManager() {
    }

    public static QFSPersonalConsumeTimeManager e() {
        if (f89047b == null) {
            synchronized (QFSPersonalConsumeTimeManager.class) {
                if (f89047b == null) {
                    f89047b = new QFSPersonalConsumeTimeManager();
                }
            }
        }
        return f89047b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        a aVar;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(str) && (aVar = this.f89048a.get(str)) != null && aVar.f89052a != 0) {
            QCircleLpReportDc05504.DataBuilder ext2 = new QCircleLpReportDc05504.DataBuilder().setToUin(str).setActionType(11).setSubActionType(57).setThrActionType(1).setExt9(feedCloudMeta$StFeed.f398449id.get()).setExt2(String.valueOf(aVar.f89052a));
            if (feedCloudMeta$StFeed.busiReport.has()) {
                ext2.setFeedReportInfo(feedCloudMeta$StFeed.busiReport.get().toByteArray());
            }
            QCircleLpReportDc05504.report(ext2);
            aVar.f89052a = 0L;
            aVar.f89053b = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(str)) {
            a aVar = this.f89048a.get(str);
            if (aVar == null) {
                aVar = new a();
            }
            aVar.f89053b = System.currentTimeMillis();
            this.f89048a.put(str, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        a aVar;
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(str) && (aVar = this.f89048a.get(str)) != null && aVar.f89053b != 0) {
            aVar.f89052a += System.currentTimeMillis() - aVar.f89053b;
            aVar.f89053b = System.currentTimeMillis();
            this.f89048a.put(str, aVar);
        }
    }

    public void d(final FeedCloudMeta$StFeed feedCloudMeta$StFeed, final String str, final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str) && !str.equals(QCircleCommonUtil.getCurrentAccount())) {
                    int i16 = i3;
                    if (i16 == 0) {
                        QFSPersonalConsumeTimeManager.this.g(feedCloudMeta$StFeed, str);
                    } else if (i16 == 1) {
                        QFSPersonalConsumeTimeManager.this.h(feedCloudMeta$StFeed, str);
                    } else if (i16 == 2) {
                        QFSPersonalConsumeTimeManager.this.f(feedCloudMeta$StFeed, str);
                    }
                }
            }
        });
    }
}
