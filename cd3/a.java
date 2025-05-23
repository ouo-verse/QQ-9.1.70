package cd3;

import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vas.data.SmallHomeInfo;
import com.tencent.mobileqq.zootopia.service.ZootopiaMapDetailService;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import z23.e;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001c\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcd3/a;", "Lcom/tencent/mobileqq/mvvm/a;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/m;", "callback", "", "k", "", "uin", "Lcom/tencent/mobileqq/vas/data/d;", "j", "Lz23/e;", "a", "Lz23/e;", "getService", "()Lz23/e;", "service", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "b", "Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "getDetailService", "()Lcom/tencent/mobileqq/zootopia/service/ZootopiaMapDetailService;", "detailService", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final e service = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaMapDetailService detailService = new ZootopiaMapDetailService(0);

    public final void j(long uin, com.tencent.mobileqq.zootopia.api.e<SmallHomeInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        e.c(this.service, appInterface, uin, false, 0, callback, 8, null);
    }

    public final void k(com.tencent.mobileqq.zootopia.api.e<ZootopiaMapDetail> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.detailService.j(AdMetricID.Click.SUCCESS, callback);
    }
}
