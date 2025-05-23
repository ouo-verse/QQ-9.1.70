package fz;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.junit.Ignore;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lfz/b;", "", "", "positionId", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "kotlin.jvm.PlatformType", "a", "builder", AdMetricTag.EVENT_NAME, "", "b", "d", "", "isAgree", "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
@Ignore("\u6682\u672afix\uff0c\u5148\u5ffd\u7565")
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f400960a = new b();

    b() {
    }

    private final WSStatisticsReporter.Builder a(String positionId) {
        return new WSStatisticsReporter.Builder().setSopName("feeds").setFlush(true).addParams("feed_id", "").addParams("owner_id", "").addParams("position", positionId);
    }

    private final void b(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    public final void d() {
        WSStatisticsReporter.Builder a16 = a("friends_auth");
        Intrinsics.checkNotNullExpressionValue(a16, "createReportBuilder(POS_AUTH_FRIENDS)");
        b(a16, "gzh_exposure");
    }

    public final void c(boolean isAgree) {
        String str;
        if (isAgree) {
            str = "agree_auth";
        } else {
            str = "cancel_auth";
        }
        WSStatisticsReporter.Builder builder = a(str).addParams("action_id", "1000001");
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        b(builder, "gzh_click");
    }
}
