package com.tencent.mobileqq.vas.adv.negativefeedback.core.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.negativefeedback.bean.NFBSessionInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import jz2.NFBBusinessInfo;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mz2.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0010H\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/a;", "Llz2/a;", "", "event", "", "params", "", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "c", "a", "onActivityStop", "onActivityDestroy", "Landroid/view/MotionEvent;", "b", "Ljz2/a;", "Ljz2/a;", "businessInfo", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "mSessionInfo", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBActivityTouchListener;", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBActivityTouchListener;", "mActivityTouchListener", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBTimer;", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBTimer;", "mHeartBeatTimer", "<init>", "(Ljz2/a;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a implements lz2.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBBusinessInfo businessInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBSessionInfo mSessionInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBActivityTouchListener mActivityTouchListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBTimer mHeartBeatTimer;

    public a(@NotNull NFBBusinessInfo businessInfo) {
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        this.businessInfo = businessInfo;
        NFBSessionInfo nFBSessionInfo = new NFBSessionInfo(businessInfo, null, 0L, 0L, 0L, 30, null);
        this.mSessionInfo = nFBSessionInfo;
        this.mActivityTouchListener = new NFBActivityTouchListener(nFBSessionInfo);
        this.mHeartBeatTimer = new NFBTimer(nFBSessionInfo);
    }

    private final void d(String event, Map<String, String> params) {
        b.f417903a.e(this.businessInfo.getBusiId(), event, this.mSessionInfo.getSessionId(), params, this.mSessionInfo.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void e(a aVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        aVar.d(str, map);
    }

    @Override // lz2.a
    public void a(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        long currentTimeMillis = System.currentTimeMillis();
        this.mSessionInfo.j(currentTimeMillis);
        this.mSessionInfo.i(currentTimeMillis);
        e(this, "pg_in", null, 2, null);
    }

    @Override // lz2.a
    public void b(@NotNull Activity activity, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        this.mActivityTouchListener.b(activity, event);
    }

    public void c(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof QBaseActivity) {
            activity.runOnUiThread(this.mHeartBeatTimer);
        }
        e(this, "pg_cre", null, 2, null);
    }

    @Override // lz2.a
    public void onActivityDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        e(this, "pg_ext", null, 2, null);
    }

    @Override // lz2.a
    public void onActivityStop(@NotNull Activity activity) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mHeartBeatTimer.g(true);
        this.mSessionInfo.k(System.currentTimeMillis());
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, String.valueOf(this.mSessionInfo.getStopTime() - this.mSessionInfo.getStartTime())), TuplesKt.to("delta_time", String.valueOf(this.mSessionInfo.getStopTime() - this.mSessionInfo.getHeartBeatTime())));
        d("pg_out", mapOf);
    }
}
