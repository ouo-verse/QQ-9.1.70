package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.PerfTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/feedpro/part/m;", "Lcom/qzone/reborn/feedpro/part/b;", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "", "hasFocus", "onWindowFocusChanged", "onPartResume", "onPartDestroy", "c9", "d", "Ljava/lang/String;", "mStreamName", "", "e", "J", "mLaunchTime", "f", "mClickTime", "<init>", "(Ljava/lang/String;)V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends b {

    /* renamed from: i, reason: collision with root package name */
    private static long f54078i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String mStreamName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLaunchTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mClickTime;

    public m(String mStreamName) {
        Intrinsics.checkNotNullParameter(mStreamName, "mStreamName");
        this.mStreamName = mStreamName;
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.qzone.reborn.feedpro.part.a
    public void c9() {
        super.c9();
        QLog.d("QZoneFeedProLaunchTimeCostPart", 1, "onFeedShow  mStreamName = " + this.mStreamName);
        QLog.d("friend_feed_launch", 1, "\u65b0\u7248Feeds\u6570\u636e\u5c55\u793a,onFeedShow: \u8017\u65f6 " + (System.currentTimeMillis() - this.mClickTime) + "ms");
        jo.h.f410717a.h(this.mStreamName).t("FEED_SHOW");
        if (this.mLaunchTime > 0) {
            this.mLaunchTime = 0L;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProLaunchTimeCostPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        QLog.d("QZoneFeedProLaunchTimeCostPart", 1, "onPartCreate   mStreamName = " + this.mStreamName);
        Intent intent = activity.getIntent();
        PerfTracer.traceClick2Activity(intent);
        if (intent != null) {
            long longExtra = intent.getLongExtra(QZoneHelper.Constants.KEY_LAUNCH_TIME, 0L);
            this.mLaunchTime = longExtra;
            if (longExtra <= f54078i) {
                this.mLaunchTime = 0L;
            } else {
                f54078i = longExtra;
            }
            this.mClickTime = intent.getLongExtra(PerfTracer.PARAM_CLICK_TIME, 0L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QLog.d("QZoneFeedProLaunchTimeCostPart", 1, "onPartDestroy   mStreamName = " + this.mStreamName);
        jo.h.f410717a.h(this.mStreamName).l();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        QLog.d("QZoneFeedProLaunchTimeCostPart", 1, "onPartResume   mStreamName = " + this.mStreamName);
        if (this.mLaunchTime > 0) {
            this.mLaunchTime = System.currentTimeMillis() - this.mLaunchTime;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        QLog.d("QZoneFeedProLaunchTimeCostPart", 1, "onWindowFocusChanged   mStreamName = " + this.mStreamName + ", hasFocus" + hasFocus);
        if (hasFocus) {
            QLog.d("friend_feed_launch", 1, "\u65b0\u7248Feeds\u5e03\u5c40\u663e\u793a, onWindowFocusChanged: \u8017\u65f6 " + (System.currentTimeMillis() - this.mClickTime) + "ms");
            jo.h.f410717a.h(this.mStreamName).t("WINDOW_FOCUS");
        }
    }
}
