package com.tencent.biz.pubaccount.weishi;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0003\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/u;", "", "", "sopName", "refreshType", "", "isRemind", "", "d", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "a", "b", "builder", AdMetricTag.EVENT_NAME, "c", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f81611a = new u();

    u() {
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder a(String sopName) {
        WSStatisticsReporter.Builder addParams = b(sopName).addParams("position", "refresh_remind").addParams("feed_id", "").addParams("owner_id", "");
        Intrinsics.checkNotNullExpressionValue(addParams, "createReportBuilder(sopN\u2026nstants.KEY_OWNER_ID, \"\")");
        return addParams;
    }

    @JvmStatic
    private static final WSStatisticsReporter.Builder b(String sopName) {
        WSStatisticsReporter.Builder flush = new WSStatisticsReporter.Builder().setSopName(sopName).setTestId(bb.x(1)).setPushId(com.tencent.biz.pubaccount.weishi.util.v.b().c()).setFlush(true);
        Intrinsics.checkNotNullExpressionValue(flush, "Builder()\n              \u2026          .setFlush(true)");
        return flush;
    }

    @JvmStatic
    private static final void c(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    @JvmStatic
    public static final void d(String sopName, String refreshType, boolean isRemind) {
        String str;
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Intrinsics.checkNotNullParameter(refreshType, "refreshType");
        HashMap hashMap = new HashMap();
        hashMap.put("click_type", refreshType);
        if (isRemind) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_remind", str);
        WSStatisticsReporter.Builder builder = a(sopName).addExtParams(hashMap).addParams("action_id", "1000001");
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        c(builder, "gzh_click");
    }
}
