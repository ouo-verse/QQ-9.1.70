package com.tencent.mobileqq.vas.group;

import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapDetailService;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001c\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0002J\u001c\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/group/t;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/m;", "callback", "", "k", "", "uin", "Lcom/tencent/mobileqq/vas/data/d;", "j", "Lcom/tencent/mobileqq/vas/data/e;", "l", "Lz23/e;", "a", "Lz23/e;", "getService", "()Lz23/e;", "service", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "b", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "getDetailService", "()Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "detailService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class t extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z23.e service = new z23.e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapDetailService detailService = new ZootopiaMapDetailService(0);

    public final void j(long uin, com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        z23.e.c(this.service, appInterface, uin, false, 0, callback, 8, null);
    }

    public final void k(com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.detailService.j(AdMetricID.Click.SUCCESS, callback);
    }

    public final void l(long uin, com.tencent.mobileqq.zootopia.api.e<com.tencent.mobileqq.vas.data.e> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        this.service.d(appInterface, uin, callback);
    }
}
