package com.tencent.sqshow.zootopia.recommend.characterV2.data;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qv4.bh;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/data/a;", "", "", "action", "", "b", "d", "c", "Lqv4/bh;", "a", "Lqv4/bh;", "()Lqv4/bh;", "banner", "I", "getTianshuAdId", "()I", "tianshuAdId", "", "Ljava/lang/String;", "getTianshuTraceinfo", "()Ljava/lang/String;", "tianshuTraceinfo", "getTianshuGroupId", "tianshuGroupId", "", "e", "Z", "isExported", "<init>", "(Lqv4/bh;ILjava/lang/String;I)V", "f", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final bh banner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int tianshuAdId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String tianshuTraceinfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int tianshuGroupId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isExported;

    public a(bh banner, int i3, String tianshuTraceinfo, int i16) {
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(tianshuTraceinfo, "tianshuTraceinfo");
        this.banner = banner;
        this.tianshuAdId = i3;
        this.tianshuTraceinfo = tianshuTraceinfo;
        this.tianshuGroupId = i16;
    }

    private final void b(int action) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        if (account == null) {
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mTraceId = account + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = String.valueOf(this.tianshuGroupId);
        tianShuReportData.mPageId = String.valueOf(this.tianshuGroupId);
        tianShuReportData.mItemId = String.valueOf(this.tianshuAdId);
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mActionId = action;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mTriggerInfo = this.tianshuTraceinfo;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
        QLog.i("PortalBannerData", 1, "report(). action: " + action + ", bannerAdId: " + this.tianshuAdId + ", bannerData:" + this);
    }

    /* renamed from: a, reason: from getter */
    public final bh getBanner() {
        return this.banner;
    }

    public final void d() {
        if (this.isExported) {
            return;
        }
        this.isExported = true;
        b(101);
    }

    public final void c() {
        b(102);
    }
}
