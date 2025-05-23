package com.tencent.biz.pubaccount.weishi.teenmode;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0003\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/WSTeenModeDialogReportHelper;", "", "Lcom/tencent/biz/pubaccount/weishi/teenmode/WSTeenModeDialogReportHelper$BtnType;", "btnType", "", "sopName", "", "b", "c", "Lcom/tencent/biz/pubaccount/weishi/report/WSStatisticsReporter$Builder;", "builder", AdMetricTag.EVENT_NAME, "a", "<init>", "()V", "BtnType", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSTeenModeDialogReportHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final WSTeenModeDialogReportHelper f81597a = new WSTeenModeDialogReportHelper();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/teenmode/WSTeenModeDialogReportHelper$BtnType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "ENTER", "KNOW", "CLOSE", "OTHER", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public enum BtnType {
        ENTER(1),
        KNOW(2),
        CLOSE(3),
        OTHER(4);

        private final int value;

        BtnType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    WSTeenModeDialogReportHelper() {
    }

    @JvmStatic
    private static final void a(WSStatisticsReporter.Builder builder, String eventName) {
        builder.build(eventName).report();
    }

    @JvmStatic
    public static final void b(BtnType btnType, String sopName) {
        Intrinsics.checkNotNullParameter(btnType, "btnType");
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Map<String, String> feedsBaseParamsWithoutFeed = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("teenmode_window_clk", 1000001);
        HashMap hashMap = new HashMap();
        hashMap.put("btn_type", String.valueOf(btnType.getValue()));
        WSStatisticsReporter.Builder builder = new WSStatisticsReporter.Builder().setSopName(sopName).setTestId(bb.x(1)).setPushId(WSPublicAccReport.getInstance().getPushId()).setOperationId("").setFlush(true).addParams(feedsBaseParamsWithoutFeed).addExtParams(hashMap).addObjectParams("feed_pass_key", "").addObjectParams("global_key", "");
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        a(builder, "gzh_click");
    }

    @JvmStatic
    public static final void c(String sopName) {
        Intrinsics.checkNotNullParameter(sopName, "sopName");
        Map<String, String> feedsBaseParamsWithoutFeed = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("teenmode_window_exp", 0);
        WSStatisticsReporter.Builder builder = new WSStatisticsReporter.Builder().setSopName(sopName).setTestId(bb.x(1)).setPushId(WSPublicAccReport.getInstance().getPushId()).setOperationId("").setFlush(true).addParams(feedsBaseParamsWithoutFeed).addExtParams(new HashMap()).addObjectParams("feed_pass_key", "").addObjectParams("global_key", "");
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        a(builder, "gzh_exposure");
    }
}
