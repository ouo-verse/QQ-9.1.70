package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.PerfTracer;

/* compiled from: P */
/* loaded from: classes37.dex */
public class cc extends g {

    /* renamed from: h, reason: collision with root package name */
    private static long f55081h;

    /* renamed from: d, reason: collision with root package name */
    private long f55082d;

    /* renamed from: e, reason: collision with root package name */
    private long f55083e;

    /* renamed from: f, reason: collision with root package name */
    private String f55084f;

    public cc(String str) {
        this.f55084f = str;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneLaunchTimeCostPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        QLog.d("QZoneLaunchTimeCostPart", 1, "onDelayShowAfterFeedShow   mStreamName = " + this.f55084f);
        QLog.d("friend_feed_launch", 1, "\u65b0\u7248Feeds\u6570\u636e\u5c55\u793a,onDelayShowAfterFeedShow: \u8017\u65f6 " + (System.currentTimeMillis() - this.f55083e) + "ms");
        jo.h.f410717a.h(this.f55084f).t("FEED_SHOW");
        if (this.f55082d > 0) {
            this.f55082d = 0L;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        QLog.d("QZoneLaunchTimeCostPart", 1, "onPartCreate   mStreamName = " + this.f55084f);
        Intent intent = activity.getIntent();
        PerfTracer.traceClick2Activity(intent);
        if (intent != null) {
            long longExtra = intent.getLongExtra(QZoneHelper.Constants.KEY_LAUNCH_TIME, 0L);
            this.f55082d = longExtra;
            if (longExtra <= f55081h) {
                this.f55082d = 0L;
            } else {
                f55081h = longExtra;
            }
            this.f55083e = intent.getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QLog.d("QZoneLaunchTimeCostPart", 1, "onPartDestroy   mStreamName = " + this.f55084f);
        jo.h.f410717a.h(this.f55084f).l();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.d("QZoneLaunchTimeCostPart", 1, "onPartResume   mStreamName = " + this.f55084f);
        if (this.f55082d > 0) {
            this.f55082d = System.currentTimeMillis() - this.f55082d;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        QLog.d("QZoneLaunchTimeCostPart", 1, "onWindowFocusChanged   mStreamName = " + this.f55084f);
        if (z16) {
            QLog.d("friend_feed_launch", 1, "\u65b0\u7248Feeds\u5e03\u5c40\u663e\u793a, onWindowFocusChanged: \u8017\u65f6 " + (System.currentTimeMillis() - this.f55083e) + "ms");
            jo.h.f410717a.h(this.f55084f).t("WINDOW_FOCUS");
        }
    }
}
